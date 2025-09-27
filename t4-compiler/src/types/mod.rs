//! Type System for the T4 Programming Language
//!
//! This module implements a comprehensive type system including:
//! - Type representation with type variables for inference
//! - Type environment management
//! - Unification algorithm for type inference
//! - Security type system with affine usage analysis
//! - Error reporting and type checking

use crate::ast::*;
use serde::{Deserialize, Serialize};
use std::collections::{HashMap, HashSet};
use std::fmt;
use string_interner::StringInterner;
// Simple symbol type to replace string_interner::Sym for now
pub type Sym = u32;

pub mod error;
pub mod inference;
pub mod security;
pub mod environment;
pub mod integration;

pub use error::{TypeError, TypeResult};
pub use inference::{TypeInference, UnificationError};
pub use security::{SecurityAnalysis, AffineUsage, SecurityViolation};
pub use environment::{TypeEnvironment, Scope, Binding};
pub use self::integration::{T4TypeChecker, TypeCheckContext};

/// Unique identifier for type variables
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash, Serialize, Deserialize)]
pub struct TypeVarId(pub u32);

impl fmt::Display for TypeVarId {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "?{}", self.0)
    }
}

/// Type variable for type inference
#[derive(Debug, Clone, PartialEq, Eq, Hash, Serialize, Deserialize)]
pub struct TypeVar {
    pub id: TypeVarId,
    pub rank: u32, // For rank-based unification
}

impl TypeVar {
    pub fn new(id: TypeVarId) -> Self {
        Self { id, rank: 0 }
    }

    pub fn with_rank(id: TypeVarId, rank: u32) -> Self {
        Self { id, rank }
    }
}

impl fmt::Display for TypeVar {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "?{}", self.id.0)
    }
}

/// Extended type representation with type variables for inference
#[derive(Debug, Clone, PartialEq, Eq, Hash, Serialize, Deserialize)]
pub enum TypeScheme {
    /// Concrete type
    Concrete(Type),
    /// Polymorphic type with quantified type variables
    Polymorphic {
        vars: Vec<TypeVar>,
        typ: Box<TypeScheme>,
    },
    /// Type variable for inference
    Variable(TypeVar),
}

impl TypeScheme {
    pub fn concrete(typ: Type) -> Self {
        Self::Concrete(typ)
    }

    pub fn variable(var: TypeVar) -> Self {
        Self::Variable(var)
    }

    pub fn polymorphic(vars: Vec<TypeVar>, typ: TypeScheme) -> Self {
        Self::Polymorphic {
            vars,
            typ: Box::new(typ),
        }
    }

    /// Instantiate a polymorphic type with fresh type variables
    pub fn instantiate(&self, interner: &mut StringInterner, next_var: &mut u32) -> TypeScheme {
        match self {
            Self::Concrete(_) => self.clone(),
            Self::Variable(var) => Self::Variable(var.clone()),
            Self::Polymorphic { vars, typ } => {
                let mut subst = HashMap::new();
                for var in vars {
                    let fresh_var = TypeVar::new(TypeVarId(*next_var));
                    *next_var += 1;
                    subst.insert(var.clone(), fresh_var);
                }

                let mut instantiated = typ.clone();
                for (old_var, new_var) in subst {
                    instantiated = instantiated.substitute(&old_var, &TypeScheme::Variable(new_var));
                }

                instantiated
            }
        }
    }

    /// Substitute a type variable with another type
    pub fn substitute(&self, var: &TypeVar, replacement: &TypeScheme) -> TypeScheme {
        match self {
            Self::Concrete(_) => self.clone(),
            Self::Variable(v) if v == var => replacement.clone(),
            Self::Variable(_) => self.clone(),
            Self::Polymorphic { vars, typ } => {
                // Don't substitute bound variables
                if vars.contains(var) {
                    self.clone()
                } else {
                    let substituted = typ.substitute(var, replacement);
                    Self::Polymorphic {
                        vars: vars.clone(),
                        typ: Box::new(substituted),
                    }
                }
            }
        }
    }

    /// Get the free type variables in this type scheme
    pub fn free_vars(&self) -> HashSet<TypeVar> {
        match self {
            Self::Concrete(_) => HashSet::new(),
            Self::Variable(var) => [var.clone()].into(),
            Self::Polymorphic { vars, typ } => {
                let mut free = typ.free_vars();
                for var in vars {
                    free.remove(var);
                }
                free
            }
        }
    }

    /// Generalize a type by quantifying over free type variables
    pub fn generalize(&self, env_vars: &HashSet<TypeVar>) -> TypeScheme {
        let free = self.free_vars();
        let to_quantify: Vec<TypeVar> = free.difference(env_vars).cloned().collect();

        if to_quantify.is_empty() {
            self.clone()
        } else {
            Self::Polymorphic {
                vars: to_quantify,
                typ: Box::new(self.clone()),
            }
        }
    }
}

impl fmt::Display for TypeScheme {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            Self::Concrete(typ) => write!(f, "{}", typ),
            Self::Variable(var) => write!(f, "{}", var),
            Self::Polymorphic { vars, typ } => {
                write!(f, "∀")?;
                for (i, var) in vars.iter().enumerate() {
                    if i > 0 {
                        write!(f, " ")?;
                    }
                    write!(f, "{}", var)?;
                }
                write!(f, ". {}", typ)
            }
        }
    }
}

/// Type substitution mapping
#[derive(Debug, Clone, Default)]
pub struct TypeSubstitution {
    pub mapping: HashMap<TypeVar, TypeScheme>,
}

impl TypeSubstitution {
    pub fn new() -> Self {
        Self::default()
    }

    pub fn insert(&mut self, var: TypeVar, scheme: TypeScheme) {
        self.mapping.insert(var, scheme);
    }

    pub fn get(&self, var: &TypeVar) -> Option<&TypeScheme> {
        self.mapping.get(var)
    }

    pub fn compose(mut self, other: TypeSubstitution) -> Self {
        for (var, scheme) in other.mapping {
            let substituted = scheme.substitute_all(&self);
            self.mapping.insert(var, substituted);
        }
        self
    }

    pub fn apply(&self, scheme: &TypeScheme) -> TypeScheme {
        scheme.substitute_all(self)
    }
}

impl TypeScheme {
    /// Apply a substitution to this type scheme
    pub fn substitute_all(&self, subst: &TypeSubstitution) -> TypeScheme {
        match self {
            Self::Concrete(_) => self.clone(),
            Self::Variable(var) => {
                subst.get(var).cloned().unwrap_or_else(|| self.clone())
            }
            Self::Polymorphic { vars, typ } => {
                // Remove mappings for bound variables
                let mut filtered_subst = subst.clone();
                for var in vars {
                    filtered_subst.mapping.remove(var);
                }

                let new_typ = typ.substitute_all(&filtered_subst);
                Self::Polymorphic {
                    vars: vars.clone(),
                    typ: Box::new(new_typ),
                }
            }
        }
    }
}

/// Type context for type checking
#[derive(Debug, Clone)]
pub struct TypeContext {
    pub interner: StringInterner,
    pub next_var_id: u32,
    pub substitution: TypeSubstitution,
    pub environment: TypeEnvironment,
}

impl TypeContext {
    pub fn new() -> Self {
        Self {
            interner: StringInterner::default(),
            next_var_id: 0,
            substitution: TypeSubstitution::new(),
            environment: TypeEnvironment::new(),
        }
    }

    pub fn fresh_var(&mut self) -> TypeVar {
        let var = TypeVar::new(TypeVarId(self.next_var_id));
        self.next_var_id += 1;
        var
    }

    pub fn fresh_type_var(&mut self) -> TypeScheme {
        TypeScheme::Variable(self.fresh_var())
    }

    pub fn unify(&mut self, t1: &TypeScheme, t2: &TypeScheme) -> TypeResult<()> {
        let a = self.substitution.apply(t1);
        let b = self.substitution.apply(t2);

        match (&a, &b) {
            (TypeScheme::Concrete(_), TypeScheme::Concrete(_)) => {
                // TODO: Implement concrete type unification
                Ok(())
            }
            (TypeScheme::Variable(v1), TypeScheme::Variable(v2)) if v1 == v2 => Ok(()),
            (TypeScheme::Variable(v), other) | (other, TypeScheme::Variable(v)) => {
                if other.free_vars().contains(v) {
                    Err(TypeError::InfiniteType(v.clone()))
                } else {
                    self.substitution.insert(v.clone(), other.clone());
                    Ok(())
                }
            }
            _ => Err(TypeError::UnificationFailed(a, b)),
        }
    }
}

/// Main type checker
pub struct TypeChecker {
    context: TypeContext,
    security_analysis: SecurityAnalysis,
}

impl TypeChecker {
    pub fn new() -> Self {
        Self {
            context: TypeContext::new(),
            security_analysis: SecurityAnalysis::new(),
        }
    }

    /// Type check a complete program
    pub fn check_program(&mut self, program: &Program) -> TypeResult<CheckedProgram> {
        let mut checked_declarations = Vec::new();

        for decl in &program.declarations {
            let checked_decl = self.check_declaration(decl)?;
            checked_declarations.push(checked_decl);
        }

        Ok(CheckedProgram {
            declarations: checked_declarations,
            config: program.config.clone(),
        })
    }

    /// Type check a declaration
    fn check_declaration(&mut self, decl: &Declaration) -> TypeResult<CheckedDeclaration> {
        match decl {
            Declaration::Function(func) => self.check_function(func),
            Declaration::Struct { .. } => {
                // TODO: Implement struct checking
                Ok(CheckedDeclaration::Struct)
            }
            Declaration::Enum { .. } => {
                // TODO: Implement enum checking
                Ok(CheckedDeclaration::Enum)
            }
            Declaration::Trait { .. } => {
                // TODO: Implement trait checking
                Ok(CheckedDeclaration::Trait)
            }
            Declaration::Impl { .. } => {
                // TODO: Implement impl checking
                Ok(CheckedDeclaration::Impl)
            }
            _ => {
                // For now, just accept other declarations
                Ok(CheckedDeclaration::Other)
            }
        }
    }

    /// Type check a function
    fn check_function(&mut self, func: &Function) -> TypeResult<CheckedDeclaration> {
        // Enter function scope
        self.context.environment.enter_scope();

        // Add parameters to environment
        for param in &func.parameters {
            let param_type = self.infer_type(&param.typ)?;
            self.context.environment.add_binding(
                param.name.name,
                Binding::Variable {
                    typ: param_type,
                    mutable: param.mutable,
                }
            );
        }

        // Type check function body
        let mut checked_body = Vec::new();
        for stmt in &func.body {
            let checked_stmt = self.check_statement(stmt)?;
            checked_body.push(checked_stmt);
        }

        // Exit function scope
        self.context.environment.exit_scope();

        Ok(CheckedDeclaration::Function(CheckedFunction {
            name: func.name.clone(),
            parameters: func.parameters.clone(),
            return_type: func.return_type.clone(),
            body: checked_body,
            security_annotations: func.security_annotations.clone(),
        }))
    }

    /// Type check a statement
    fn check_statement(&mut self, stmt: &Statement) -> TypeResult<CheckedStatement> {
        match stmt {
            Statement::Let { pattern, typ, value } => {
                let inferred_type = if let Some(expr) = value {
                    let checked_expr = self.check_expression(expr)?;
                    checked_expr.typ
                } else {
                    TypeScheme::concrete(Type::Unit)
                };

                // TODO: Check pattern matching
                Ok(CheckedStatement::Let {
                    pattern: pattern.clone(),
                    typ: inferred_type,
                })
            }
            Statement::Expression(expr) => {
                let checked_expr = self.check_expression(expr)?;
                Ok(CheckedStatement::Expression(checked_expr))
            }
            Statement::Return(expr) => {
                let checked_expr = if let Some(e) = expr {
                    Some(self.check_expression(e)?)
                } else {
                    None
                };
                Ok(CheckedStatement::Return(checked_expr))
            }
            _ => {
                // For now, accept other statements
                Ok(CheckedStatement::Other)
            }
        }
    }

    /// Type check an expression
    fn check_expression(&mut self, expr: &Expression) -> TypeResult<CheckedExpression> {
        let (inferred_type, security_info) = match expr {
            Expression::Literal(lit) => {
                let typ = match lit {
                    Literal::Integer(_) => TypeScheme::concrete(Type::Int64),
                    Literal::Float(_) => TypeScheme::concrete(Type::Float64),
                    Literal::String(_) => TypeScheme::concrete(Type::String),
                    Literal::Bool(_) => TypeScheme::concrete(Type::Bool),
                    Literal::ByteString(_) => TypeScheme::concrete(Type::Bytes),
                    Literal::Char(_) => TypeScheme::concrete(Type::Int8),
                };
                (typ, SecurityInfo::Public)
            }
            Expression::Variable(ident) => {
                if let Some(binding) = self.context.environment.get_binding(ident.name) {
                    match binding {
                        Binding::Variable { typ, .. } => (typ, SecurityInfo::Public),
                        Binding::Function { typ, .. } => (typ, SecurityInfo::Public),
                    }
                } else {
                    return Err(TypeError::UnboundVariable(ident.clone()));
                }
            }
            Expression::Binary { left, op, right } => {
                let checked_left = self.check_expression(left)?;
                let checked_right = self.check_expression(right)?;

                // Unify operand types
                self.context.unify(&checked_left.typ, &checked_right.typ)?;

                // Determine result type based on operation
                let result_type = self.infer_binary_op_type(op, &checked_left.typ)?;

                (result_type, SecurityInfo::Public) // TODO: Proper security analysis
            }
            Expression::Call { function, args } => {
                let checked_function = self.check_expression(function)?;
                let mut checked_args = Vec::new();

                for arg in args {
                    checked_args.push(self.check_expression(arg)?);
                }

                // TODO: Check function call compatibility
                let result_type = self.fresh_type_var();

                (result_type, SecurityInfo::Public) // TODO: Proper security analysis
            }
            _ => {
                // For now, return a fresh type variable for unhandled expressions
                (self.context.fresh_type_var(), SecurityInfo::Public)
            }
        };

        Ok(CheckedExpression {
            expr: expr.clone(),
            typ: inferred_type,
            security_info,
        })
    }

    /// Infer the type of a binary operation
    fn infer_binary_op_type(&mut self, op: &BinaryOp, operand_type: &TypeScheme) -> TypeResult<TypeScheme> {
        match op {
            BinaryOp::Add | BinaryOp::Sub | BinaryOp::Mul | BinaryOp::Div | BinaryOp::Mod => {
                // Arithmetic operations preserve numeric types
                Ok(operand_type.clone())
            }
            BinaryOp::Eq | BinaryOp::Ne | BinaryOp::Lt | BinaryOp::Gt | BinaryOp::Le | BinaryOp::Ge => {
                // Comparison operations return bool
                Ok(TypeScheme::concrete(Type::Bool))
            }
            BinaryOp::And | BinaryOp::Or => {
                // Logical operations require bool operands and return bool
                self.context.unify(operand_type, &TypeScheme::concrete(Type::Bool))?;
                Ok(TypeScheme::concrete(Type::Bool))
            }
            _ => {
                // For other operations, return the operand type
                Ok(operand_type.clone())
            }
        }
    }

    /// Convert AST Type to TypeScheme
    fn infer_type(&mut self, typ: &Type) -> TypeResult<TypeScheme> {
        Ok(TypeScheme::concrete(typ.clone()))
    }

    /// Create a fresh type variable
    fn fresh_type_var(&mut self) -> TypeScheme {
        self.context.fresh_type_var()
    }
}

/// Checked program with type information
#[derive(Debug, Clone)]
pub struct CheckedProgram {
    pub declarations: Vec<CheckedDeclaration>,
    pub config: ModuleConfig,
}

/// Checked declaration with type information
#[derive(Debug, Clone)]
pub enum CheckedDeclaration {
    Function(CheckedFunction),
    Struct,
    Enum,
    Trait,
    Impl,
    Other,
}

/// Checked function with type information
#[derive(Debug, Clone)]
pub struct CheckedFunction {
    pub name: Identifier,
    pub parameters: Vec<Parameter>,
    pub return_type: Option<Type>,
    pub body: Vec<CheckedStatement>,
    pub security_annotations: Vec<SecurityAnnotation>,
}

/// Checked statement with type information
#[derive(Debug, Clone)]
pub enum CheckedStatement {
    Let {
        pattern: Pattern,
        typ: TypeScheme,
    },
    Expression(CheckedExpression),
    Return(Option<CheckedExpression>),
    Other,
}

/// Checked expression with type and security information
#[derive(Debug, Clone)]
pub struct CheckedExpression {
    pub expr: Expression,
    pub typ: TypeScheme,
    pub security_info: SecurityInfo,
}

/// Security information for expressions
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum SecurityInfo {
    Public,
    Secret,
    Encrypted,
    Unknown,
}

impl fmt::Display for SecurityInfo {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            SecurityInfo::Public => write!(f, "public"),
            SecurityInfo::Secret => write!(f, "secret"),
            SecurityInfo::Encrypted => write!(f, "encrypted"),
            SecurityInfo::Unknown => write!(f, "unknown"),
        }
    }
}