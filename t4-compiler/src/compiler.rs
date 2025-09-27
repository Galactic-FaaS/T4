//! T4 Compiler Implementation
//!
//! This module contains the main compiler logic for T4,
//! including parsing, type checking, and compilation phases.

use crate::ast::{Program, Declaration, Type, Expression, Statement};
use crate::generated::parser::T4Parser;
use std::collections::HashMap;

/// Main T4 compiler
pub struct T4Compiler {
    /// Symbol table for type checking
    symbol_table: HashMap<String, Type>,

    /// Current scope depth
    scope_depth: usize,
}

/// Compilation error
#[derive(Debug, Clone)]
pub struct CompileError {
    pub message: String,
    pub line: usize,
    pub column: usize,
}

impl T4Compiler {
    /// Create a new T4 compiler
    pub fn new() -> Self {
        Self {
            symbol_table: HashMap::new(),
            scope_depth: 0,
        }
    }

    /// Parse T4 source code into an AST
    pub fn parse(&mut self, source: &str) -> Result<Program, CompileError> {
        let mut parser = T4Parser::new(source.to_string());
        parser.parse_program()
            .map_err(|msg| CompileError {
                message: msg,
                line: 1,    // TODO: Get actual line number from parser
                column: 1,  // TODO: Get actual column number from parser
            })
    }

    /// Type check a T4 program
    pub fn type_check(&mut self, program: &Program) -> Result<(), CompileError> {
        // Enter global scope
        self.enter_scope();

        // Check all declarations
        for declaration in &program.declarations {
            self.check_declaration(declaration)?;
        }

        // Exit global scope
        self.exit_scope();

        Ok(())
    }

    /// Check a declaration for type correctness
    fn check_declaration(&mut self, declaration: &Declaration) -> Result<(), CompileError> {
        match declaration {
            Declaration::Function(func) => self.check_function_declaration(func),
            Declaration::Struct { .. } => {
                // TODO: Implement struct checking
                Ok(())
            },
            Declaration::Enum { .. } => {
                // TODO: Implement enum checking
                Ok(())
            },
            Declaration::Constant(constant) => self.check_constant_declaration(constant),
            Declaration::Static(_) => {
                // TODO: Implement static checking
                Ok(())
            },
            _ => Ok(()),
        }
    }

    /// Check a function declaration
    fn check_function_declaration(&mut self, function: &crate::ast::Function) -> Result<(), CompileError> {
        // Add function name to symbol table
        let func_name = self.get_identifier_name(&function.name);
        let return_type = function.return_type.clone().unwrap_or(Type::Unit);

        // Add parameters to symbol table
        self.enter_scope();
        for param in &function.parameters {
            let param_name = self.get_identifier_name(&param.name);
            self.symbol_table.insert(param_name, param.typ.clone());
        }

        // Check function body if present
        if let Some(body) = &function.body {
            self.check_statements(body)?;
        }

        self.exit_scope();

        Ok(())
    }

    /// Check a constant declaration
    fn check_constant_declaration(&mut self, constant: &crate::ast::Constant) -> Result<(), CompileError> {
        // Check that the constant value matches its declared type
        let const_name = self.get_identifier_name(&constant.name);
        let value_type = self.infer_expression_type(&constant.value)?;

        if !self.types_compatible(&constant.typ, &value_type) {
            return Err(CompileError {
                message: format!(
                    "Constant '{}' has type {:?} but value has type {:?}",
                    const_name, constant.typ, value_type
                ),
                line: 1, // TODO: Get actual location
                column: 1,
            });
        }

        self.symbol_table.insert(const_name, constant.typ.clone());
        Ok(())
    }

    /// Check a list of statements
    fn check_statements(&mut self, statements: &[Statement]) -> Result<(), CompileError> {
        for statement in statements {
            self.check_statement(statement)?;
        }
        Ok(())
    }

    /// Check a statement for type correctness
    fn check_statement(&mut self, statement: &Statement) -> Result<(), CompileError> {
        match statement {
            Statement::Let { pattern, typ, value } => {
                if let Some(ref expr) = value {
                    let value_type = self.infer_expression_type(expr)?;
                    if let Some(ref expected_type) = typ {
                        if !self.types_compatible(expected_type, &value_type) {
                            return Err(CompileError {
                                message: format!(
                                    "Let binding has type {:?} but value has type {:?}",
                                    expected_type, value_type
                                ),
                                line: 1,
                                column: 1,
                            });
                        }
                    }
                }
                Ok(())
            },
            Statement::Expression(expr) => {
                self.infer_expression_type(expr)?;
                Ok(())
            },
            Statement::Assignment { target: _, value } => {
                self.infer_expression_type(value)?;
                Ok(())
            },
            Statement::Return(expr) => {
                if let Some(ref e) = expr {
                    self.infer_expression_type(e)?;
                }
                Ok(())
            },
            Statement::If { condition, then_block, else_ifs, else_block } => {
                let cond_type = self.infer_expression_type(condition)?;
                if cond_type != Type::Bool {
                    return Err(CompileError {
                        message: format!("If condition must be Bool, got {:?}", cond_type),
                        line: 1,
                        column: 1,
                    });
                }

                self.check_statements(then_block)?;
                for (_, elif_block) in else_ifs {
                    self.check_statements(elif_block)?;
                }
                if let Some(ref eb) = else_block {
                    self.check_statements(eb)?;
                }
                Ok(())
            },
            Statement::While { condition, body } => {
                let cond_type = self.infer_expression_type(condition)?;
                if cond_type != Type::Bool {
                    return Err(CompileError {
                        message: format!("While condition must be Bool, got {:?}", cond_type),
                        line: 1,
                        column: 1,
                    });
                }
                self.check_statements(body)?;
                Ok(())
            },
            Statement::Match { expression: _, arms: _ } => {
                // TODO: Implement match checking
                Ok(())
            },
            Statement::For { pattern: _, iterator: _, body } => {
                self.check_statements(body)?;
                Ok(())
            },
            Statement::Loop { body } => {
                self.check_statements(body)?;
                Ok(())
            },
            Statement::Break(_) | Statement::Continue => Ok(()),
        }
    }

    /// Infer the type of an expression
    fn infer_expression_type(&mut self, expression: &Expression) -> Result<Type, CompileError> {
        match expression {
            Expression::Literal(lit) => self.infer_literal_type(lit),
            Expression::Variable(ident) => {
                let name = self.get_identifier_name(ident);
                self.symbol_table.get(&name)
                    .cloned()
                    .ok_or_else(|| CompileError {
                        message: format!("Undefined variable: {}", name),
                        line: 1,
                        column: 1,
                    })
            },
            Expression::Binary { left, op: _, right } => {
                let left_type = self.infer_expression_type(left)?;
                let right_type = self.infer_expression_type(right)?;

                if !self.types_compatible(&left_type, &right_type) {
                    return Err(CompileError {
                        message: format!(
                            "Binary operation between incompatible types: {:?} and {:?}",
                            left_type, right_type
                        ),
                        line: 1,
                        column: 1,
                    });
                }

                // Result type is the same as operand types for most operations
                Ok(left_type)
            },
            Expression::Unary { op: _, expression } => {
                self.infer_expression_type(expression)
            },
            Expression::Call { function, args: _ } => {
                if let Expression::Variable(ident) = &**function {
                    let name = self.get_identifier_name(ident);
                    // TODO: Look up function return type
                    Ok(Type::Unit) // Placeholder
                } else {
                    Ok(Type::Unit) // Placeholder
                }
            },
            Expression::Grouped(expr) => self.infer_expression_type(expr),
            Expression::Block { statements, expression } => {
                self.enter_scope();
                self.check_statements(statements)?;
                let result = if let Some(ref e) = expression {
                    self.infer_expression_type(e)?
                } else {
                    Type::Unit
                };
                self.exit_scope();
                Ok(result)
            },
            _ => Ok(Type::Unit), // Placeholder for unimplemented expressions
        }
    }

    /// Infer the type of a literal
    fn infer_literal_type(&self, literal: &crate::ast::Literal) -> Result<Type, CompileError> {
        match literal {
            crate::ast::Literal::Integer(_) => Ok(Type::Int32), // Default to Int32
            crate::ast::Literal::Float(_) => Ok(Type::Float64),  // Default to Float64
            crate::ast::Literal::String(_) => Ok(Type::String),
            crate::ast::Literal::Bool(_) => Ok(Type::Bool),
            crate::ast::Literal::Char(_) => Ok(Type::Int32), // Char as Int32
            crate::ast::Literal::ByteString(_) => Ok(Type::Bytes),
        }
    }

    /// Check if two types are compatible
    fn types_compatible(&self, a: &Type, b: &Type) -> bool {
        match (a, b) {
            (Type::Int32, Type::Int32) => true,
            (Type::Int64, Type::Int64) => true,
            (Type::Float32, Type::Float32) => true,
            (Type::Float64, Type::Float64) => true,
            (Type::Bool, Type::Bool) => true,
            (Type::String, Type::String) => true,
            (Type::Bytes, Type::Bytes) => true,
            (Type::Unit, Type::Unit) => true,
            _ => false, // TODO: More sophisticated compatibility checking
        }
    }

    /// Enter a new scope
    fn enter_scope(&mut self) {
        self.scope_depth += 1;
    }

    /// Exit the current scope
    fn exit_scope(&mut self) {
        if self.scope_depth > 0 {
            self.scope_depth -= 1;
        }
    }

    /// Get the name of an identifier (placeholder implementation)
    fn get_identifier_name(&self, ident: &crate::ast::Identifier) -> String {
        // In a real implementation, this would resolve the interned string
        format!("id_{}", ident.name)
    }
}

impl Default for T4Compiler {
    fn default() -> Self {
        Self::new()
    }
}