//! T4 Type System Integration
//!
//! This module provides integration between the type system and the rest of the compiler

use crate::ast::{Program, Declaration, Statement, Expression, Type, Identifier};
use super::{TypeScheme, TypeChecker, TypeResult, CheckedProgram, CheckedDeclaration, CheckedStatement, CheckedExpression, SecurityInfo};
use string_interner::StringInterner;

/// Main type checker for T4 programs
pub struct T4TypeChecker {
    /// Internal type checker
    checker: TypeChecker,

    /// String interner
    interner: StringInterner,
}

impl T4TypeChecker {
    /// Create a new T4 type checker
    pub fn new() -> Self {
        Self {
            checker: TypeChecker::new(),
            interner: StringInterner::default(),
        }
    }

    /// Type check a complete program
    pub fn check_program(&mut self, program: &Program) -> TypeResult<CheckedProgram> {
        self.checker.check_program(program)
    }

    /// Type check a single declaration
    pub fn check_declaration(&mut self, declaration: &Declaration) -> TypeResult<CheckedDeclaration> {
        self.checker.check_declaration(declaration)
    }

    /// Type check a single statement
    pub fn check_statement(&mut self, statement: &Statement) -> TypeResult<CheckedStatement> {
        self.checker.check_statement(statement)
    }

    /// Type check a single expression
    pub fn check_expression(&mut self, expression: &Expression) -> TypeResult<CheckedExpression> {
        self.checker.check_expression(expression)
    }

    /// Get the string interner
    pub fn interner(&self) -> &StringInterner {
        &self.interner
    }

    /// Get the string interner mutably
    pub fn interner_mut(&mut self) -> &mut StringInterner {
        &mut self.interner
    }
}

/// Type checking context
#[derive(Debug, Clone)]
pub struct TypeCheckContext {
    /// String interner
    pub interner: StringInterner,

    /// Current module being checked
    pub current_module: Option<String>,

    /// Security context
    pub security_context: SecurityContext,
}

/// Security context for type checking
#[derive(Debug, Clone)]
pub struct SecurityContext {
    /// Whether we're in a constant-time context
    pub constant_time: bool,

    /// Whether we're in a secure memory context
    pub secure_memory: bool,

    /// Current security level
    pub security_level: SecurityLevel,
}

/// Security level enumeration
#[derive(Debug, Clone, PartialEq)]
pub enum SecurityLevel {
    /// Standard security
    Standard,
    /// High security
    High,
    /// Maximum security
    Maximum,
}

impl Default for SecurityContext {
    fn default() -> Self {
        Self {
            constant_time: false,
            secure_memory: false,
            security_level: SecurityLevel::Standard,
        }
    }
}

impl Default for TypeCheckContext {
    fn default() -> Self {
        Self {
            interner: StringInterner::default(),
            current_module: None,
            security_context: SecurityContext::default(),
        }
    }
}