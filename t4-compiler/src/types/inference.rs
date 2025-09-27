//! Type inference engine for the T4 programming language

use crate::ast::*;
use super::{TypeScheme, TypeVar, TypeVarId, TypeSubstitution, TypeContext, TypeError, TypeResult};
use super::environment::TypeEnvironment;
use std::collections::HashSet;

/// Type inference engine
#[derive(Debug)]
pub struct TypeInference {
    context: TypeContext,
    constraints: Vec<TypeConstraint>,
    next_var_id: u32,
}

impl TypeInference {
    pub fn new() -> Self {
        Self {
            context: TypeContext::new(),
            constraints: Vec::new(),
            next_var_id: 0,
        }
    }

    /// Infer types for a complete program
    pub fn infer_program(&mut self, program: &Program) -> TypeResult<InferenceResult> {
        let mut declarations = Vec::new();

        for decl in &program.declarations {
            let inferred_decl = self.infer_declaration(decl)?;
            declarations.push(inferred_decl);
        }

        let substitution = self.solve_constraints()?;

        Ok(InferenceResult {
            declarations,
            substitution,
            environment: self.context.environment.clone(),
        })
    }

    /// Infer types for a declaration
    fn infer_declaration(&mut self, decl: &Declaration) -> TypeResult<InferredDeclaration> {
        match decl {
            Declaration::Function(func) => {
                let inferred_func = self.infer_function(func)?;
                Ok(InferredDeclaration::Function(inferred_func))
            }
            Declaration::Struct { name, fields, .. } => {
                // For now, just store the struct declaration
                Ok(InferredDeclaration::Struct(name.clone(), fields.clone()))
            }
            Declaration::Enum { name, variants, .. } => {
                // For now, just store the enum declaration
                Ok(InferredDeclaration::Enum(name.clone(), variants.clone()))
            }
            _ => {
                // For other declarations, just pass them through
                Ok(InferredDeclaration::Other)
            }
        }
    }

    /// Infer types for a function
    fn infer_function(&mut self, func: &Function) -> TypeResult<InferredFunction> {
        // Enter function scope
        self.context.environment.enter_scope();

        // Infer parameter types
        let mut param_types = Vec::new();
        for param in &func.parameters {
            let param_type = self.infer_type(&param.typ)?;
            self.context.environment.add_variable(
                param.name.name,
                param_type.clone(),
                param.mutable
            );
            param_types.push((param.name.clone(), param_type));
        }

        // Infer return type
        let return_type = if let Some(ret_type) = &func.return_type {
            self.infer_type(ret_type)?
        } else {
            TypeScheme::concrete(Type::Unit)
        };

        // Infer function body
        let mut body_types = Vec::new();
        for stmt in &func.body {
            let stmt_type = self.infer_statement(stmt)?;
            body_types.push(stmt_type);
        }

        // Exit function scope
        self.context.environment.exit_scope();

        Ok(InferredFunction {
            name: func.name.clone(),
            parameters: param_types,
            return_type,
            body: body_types,
            security_annotations: func.security_annotations.clone(),
        })
    }

    /// Infer types for a statement
    fn infer_statement(&mut self, stmt: &Statement) -> TypeResult<TypeScheme> {
        match stmt {
            Statement::Let { pattern, typ, value } => {
                let value_type = if let Some(expr) = value {
                    self.infer_expression(expr)?
                } else {
                    self.fresh_type_var()
                };

                if let Some(declared_type) = typ {
                    let declared_scheme = self.infer_type(declared_type)?;
                    self.add_constraint(TypeConstraint::Equal(value_type, declared_scheme));
                }

                // TODO: Handle pattern typing
                Ok(TypeScheme::concrete(Type::Unit))
            }
            Statement::Expression(expr) => {
                self.infer_expression(expr)
            }
            Statement::Return(expr) => {
                let expr_type = if let Some(e) = expr {
                    self.infer_expression(e)?
                } else {
                    TypeScheme::concrete(Type::Unit)
                };

                // TODO: Check against function return type
                Ok(expr_type)
            }
            _ => {
                // For other statements, return unit type
                Ok(TypeScheme::concrete(Type::Unit))
            }
        }
    }

    /// Infer types for an expression
    fn infer_expression(&mut self, expr: &Expression) -> TypeResult<TypeScheme> {
        match expr {
            Expression::Literal(lit) => {
                let typ = match lit {
                    Literal::Integer(_) => TypeScheme::concrete(Type::Int64),
                    Literal::Float(_) => TypeScheme::concrete(Type::Float64),
                    Literal::String(_) => TypeScheme::concrete(Type::String),
                    Literal::Bool(_) => TypeScheme::concrete(Type::Bool),
                    Literal::ByteString(_) => TypeScheme::concrete(Type::Bytes),
                    Literal::Char(_) => TypeScheme::concrete(Type::Int8),
                };
                Ok(typ)
            }
            Expression::Variable(ident) => {
                if let Some((typ, _)) = self.context.environment.resolve_variable(ident.name) {
                    Ok(typ)
                } else {
                    Err(TypeError::UnboundVariable(ident.clone()))
                }
            }
            Expression::Binary { left, op, right } => {
                let left_type = self.infer_expression(left)?;
                let right_type = self.infer_expression(right)?;

                // Add constraint that operand types must be equal
                self.add_constraint(TypeConstraint::Equal(left_type.clone(), right_type));

                // Determine result type based on operation
                self.infer_binary_op_type(op, &left_type)
            }
            Expression::Call { function, args } => {
                let func_type = self.infer_expression(function)?;
                let mut arg_types = Vec::new();

                for arg in args {
                    arg_types.push(self.infer_expression(arg)?);
                }

                // Create fresh type variable for result
                let result_type = self.fresh_type_var();

                // Add constraint for function call
                let expected_func_type = TypeScheme::concrete(Type::Function {
                    params: arg_types,
                    return_type: Box::new(result_type.clone()),
                });

                self.add_constraint(TypeConstraint::Equal(func_type, expected_func_type));

                Ok(result_type)
            }
            Expression::Unary { op, expression } => {
                let expr_type = self.infer_expression(expression)?;
                self.infer_unary_op_type(op, &expr_type)
            }
            Expression::Tuple(exprs) => {
                let mut element_types = Vec::new();
                for expr in exprs {
                    element_types.push(self.infer_expression(expr)?);
                }
                Ok(TypeScheme::concrete(Type::Tuple(element_types)))
            }
            Expression::Array(exprs) => {
                if exprs.is_empty() {
                    // Empty array - need type annotation
                    let element_type = self.fresh_type_var();
                    Ok(TypeScheme::concrete(Type::Array(Box::new(Type::Infer), 0)))
                } else {
                    let first_type = self.infer_expression(&exprs[0])?;
                    for expr in &exprs[1..] {
                        let expr_type = self.infer_expression(expr)?;
                        self.add_constraint(TypeConstraint::Equal(first_type.clone(), expr_type));
                    }
                    Ok(TypeScheme::concrete(Type::Array(Box::new(Type::Infer), exprs.len())))
                }
            }
            Expression::Index { array, index } => {
                let array_type = self.infer_expression(array)?;
                let index_type = self.infer_expression(index)?;

                // Index should be integer type
                self.add_constraint(TypeConstraint::Equal(
                    index_type,
                    TypeScheme::concrete(Type::Int64)
                ));

                // Result is element type
                let element_type = self.fresh_type_var();
                self.add_constraint(TypeConstraint::Equal(
                    array_type,
                    TypeScheme::concrete(Type::Array(Box::new(Type::Infer), 0))
                ));

                Ok(element_type)
            }
            Expression::Field { object, field } => {
                let object_type = self.infer_expression(object)?;
                // TODO: Look up field type in struct definition
                Ok(self.fresh_type_var())
            }
            Expression::Block { statements, expression } => {
                self.context.environment.enter_scope();

                let mut stmt_types = Vec::new();
                for stmt in statements {
                    stmt_types.push(self.infer_statement(stmt)?);
                }

                let expr_type = if let Some(expr) = expression {
                    self.infer_expression(expr)?
                } else {
                    TypeScheme::concrete(Type::Unit)
                };

                self.context.environment.exit_scope();
                Ok(expr_type)
            }
            Expression::If { condition, then_block, else_ifs, else_block } => {
                let cond_type = self.infer_expression(condition)?;
                self.add_constraint(TypeConstraint::Equal(
                    cond_type,
                    TypeScheme::concrete(Type::Bool)
                ));

                let then_type = self.infer_expression(then_block)?;

                for (else_if_cond, else_if_block) in else_ifs {
                    let else_if_cond_type = self.infer_expression(else_if_cond)?;
                    self.add_constraint(TypeConstraint::Equal(
                        else_if_cond_type,
                        TypeScheme::concrete(Type::Bool)
                    ));

                    let else_if_type = self.infer_expression(else_if_block)?;
                    self.add_constraint(TypeConstraint::Equal(then_type.clone(), else_if_type));
                }

                if let Some(else_expr) = else_block {
                    let else_type = self.infer_expression(else_expr)?;
                    self.add_constraint(TypeConstraint::Equal(then_type.clone(), else_type));
                }

                Ok(then_type)
            }
            _ => {
                // For unhandled expressions, return a fresh type variable
                Ok(self.fresh_type_var())
            }
        }
    }

    /// Infer type for a type annotation
    fn infer_type(&mut self, typ: &Type) -> TypeResult<TypeScheme> {
        Ok(TypeScheme::concrete(typ.clone()))
    }

    /// Infer result type of a binary operation
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
                self.add_constraint(TypeConstraint::Equal(
                    operand_type.clone(),
                    TypeScheme::concrete(Type::Bool)
                ));
                Ok(TypeScheme::concrete(Type::Bool))
            }
            _ => {
                // For other operations, return the operand type
                Ok(operand_type.clone())
            }
        }
    }

    /// Infer result type of a unary operation
    fn infer_unary_op_type(&mut self, op: &UnaryOp, operand_type: &TypeScheme) -> TypeResult<TypeScheme> {
        match op {
            UnaryOp::Neg => {
                // Negation preserves numeric types
                Ok(operand_type.clone())
            }
            UnaryOp::Not => {
                // Logical not requires bool operand and returns bool
                self.add_constraint(TypeConstraint::Equal(
                    operand_type.clone(),
                    TypeScheme::concrete(Type::Bool)
                ));
                Ok(TypeScheme::concrete(Type::Bool))
            }
            UnaryOp::Deref => {
                // Dereference returns the inner type
                Ok(self.fresh_type_var())
            }
            UnaryOp::Borrow | UnaryOp::BorrowMut => {
                // Borrow returns a reference type
                let inner_type = operand_type.clone();
                Ok(TypeScheme::concrete(Type::Reference(Box::new(Type::Infer))))
            }
        }
    }

    /// Create a fresh type variable
    fn fresh_type_var(&mut self) -> TypeScheme {
        let var = TypeVar::new(TypeVarId(self.next_var_id));
        self.next_var_id += 1;
        TypeScheme::Variable(var)
    }

    /// Add a type constraint
    fn add_constraint(&mut self, constraint: TypeConstraint) {
        self.constraints.push(constraint);
    }

    /// Solve all type constraints using unification
    fn solve_constraints(&mut self) -> TypeResult<TypeSubstitution> {
        let mut substitution = TypeSubstitution::new();

        for constraint in &self.constraints {
            match constraint {
                TypeConstraint::Equal(t1, t2) => {
                    let t1_subst = substitution.apply(t1);
                    let t2_subst = substitution.apply(t2);

                    match (&t1_subst, &t2_subst) {
                        (TypeScheme::Variable(v1), TypeScheme::Variable(v2)) if v1 == v2 => {
                            // Already unified
                        }
                        (TypeScheme::Variable(v), other) | (other, TypeScheme::Variable(v)) => {
                            if occurs_check(v, other) {
                                return Err(TypeError::InfiniteType(v.clone()));
                            }
                            substitution.insert(v.clone(), other.clone());
                        }
                        (TypeScheme::Concrete(c1), TypeScheme::Concrete(c2)) => {
                            if c1 != c2 {
                                return Err(TypeError::UnificationFailed(t1_subst, t2_subst));
                            }
                        }
                        _ => {
                            return Err(TypeError::UnificationFailed(t1_subst, t2_subst));
                        }
                    }
                }
            }
        }

        Ok(substitution)
    }
}

/// Type constraint for the inference algorithm
#[derive(Debug, Clone)]
pub enum TypeConstraint {
    /// Two types must be equal
    Equal(TypeScheme, TypeScheme),
    /// Type must implement a trait
    Implements(TypeScheme, String),
    /// Type must be a subtype of another
    Subtype(TypeScheme, TypeScheme),
}

/// Result of type inference
#[derive(Debug)]
pub struct InferenceResult {
    pub declarations: Vec<InferredDeclaration>,
    pub substitution: TypeSubstitution,
    pub environment: TypeEnvironment,
}

/// Inferred declaration with type information
#[derive(Debug, Clone)]
pub enum InferredDeclaration {
    Function(InferredFunction),
    Struct(Identifier, Option<Vec<StructField>>),
    Enum(Identifier, Vec<EnumVariant>),
    Other,
}

/// Inferred function with complete type information
#[derive(Debug, Clone)]
pub struct InferredFunction {
    pub name: Identifier,
    pub parameters: Vec<(Identifier, TypeScheme)>,
    pub return_type: TypeScheme,
    pub body: Vec<TypeScheme>,
    pub security_annotations: Vec<SecurityAnnotation>,
}

/// Check if a type variable occurs in a type (for infinite type detection)
fn occurs_check(var: &TypeVar, typ: &TypeScheme) -> bool {
    match typ {
        TypeScheme::Variable(v) => v == var,
        TypeScheme::Concrete(_) => false,
        TypeScheme::Polymorphic { vars, typ } => {
            if vars.contains(var) {
                false
            } else {
                occurs_check(var, typ)
            }
        }
    }
}

/// Unification error
#[derive(Debug, Clone)]
pub enum UnificationError {
    InfiniteType(TypeVar),
    TypeMismatch(TypeScheme, TypeScheme),
    ConstraintNotSatisfied(String),
}

impl From<UnificationError> for TypeError {
    fn from(err: UnificationError) -> Self {
        match err {
            UnificationError::InfiniteType(var) => TypeError::InfiniteType(var),
            UnificationError::TypeMismatch(t1, t2) => TypeError::UnificationFailed(t1, t2),
            UnificationError::ConstraintNotSatisfied(msg) => {
                TypeError::GenericTypeError {
                    message: msg,
                    location: SourceLocation {
                        start_line: 0,
                        start_column: 0,
                        end_line: 0,
                        end_column: 0,
                        file: 0, // TODO: Fix when proper symbol interning is implemented
                    }
                }
            }
        }
    }
}

/// Constraint solver for complex type relationships
pub struct ConstraintSolver {
    constraints: Vec<TypeConstraint>,
    substitution: TypeSubstitution,
}

impl ConstraintSolver {
    pub fn new(constraints: Vec<TypeConstraint>) -> Self {
        Self {
            constraints,
            substitution: TypeSubstitution::new(),
        }
    }

    pub fn solve(mut self) -> Result<TypeSubstitution, UnificationError> {
        while let Some(constraint) = self.constraints.pop() {
            match constraint {
                TypeConstraint::Equal(t1, t2) => {
                    self.unify_types(&t1, &t2)?;
                }
                TypeConstraint::Implements(typ, trait_name) => {
                    self.check_trait_implementation(&typ, &trait_name)?;
                }
                TypeConstraint::Subtype(sub, sup) => {
                    self.check_subtype(&sub, &sup)?;
                }
            }
        }

        Ok(self.substitution)
    }

    fn unify_types(&mut self, t1: &TypeScheme, t2: &TypeScheme) -> Result<(), UnificationError> {
        let t1_subst = self.substitution.apply(t1);
        let t2_subst = self.substitution.apply(t2);

        match (&t1_subst, &t2_subst) {
            (TypeScheme::Variable(v1), TypeScheme::Variable(v2)) if v1 == v2 => {}
            (TypeScheme::Variable(v), other) | (other, TypeScheme::Variable(v)) => {
                if occurs_check(v, other) {
                    return Err(UnificationError::InfiniteType(v.clone()));
                }
                self.substitution.insert(v.clone(), other.clone());
            }
            (TypeScheme::Concrete(c1), TypeScheme::Concrete(c2)) => {
                if c1 != c2 {
                    return Err(UnificationError::TypeMismatch(t1_subst, t2_subst));
                }
            }
            _ => {
                return Err(UnificationError::TypeMismatch(t1_subst, t2_subst));
            }
        }

        Ok(())
    }

    fn check_trait_implementation(&self, _typ: &TypeScheme, _trait_name: &str) -> Result<(), UnificationError> {
        // TODO: Implement trait checking
        Ok(())
    }

    fn check_subtype(&self, _sub: &TypeScheme, _sup: &TypeScheme) -> Result<(), UnificationError> {
        // TODO: Implement subtype checking
        Ok(())
    }
}