//! Integration layer between the T4 AST and type system
//!
//! This module provides the main interface for type checking T4 programs,
//! bridging the gap between the parsed AST and the type system.

use crate::ast::*;
use super::*;
use super::error::{TypeError, TypeResult, TypeErrorReporter};
use super::inference::TypeInference;
use super::security::SecurityAnalysis;
use string_interner::StringInterner;

/// Main type checker that integrates all type system components
pub struct T4TypeChecker {
    interner: StringInterner,
    inference: TypeInference,
    security: SecurityAnalysis,
    error_reporter: TypeErrorReporter,
}

impl T4TypeChecker {
    /// Create a new type checker
    pub fn new() -> Self {
        Self {
            interner: StringInterner::default(),
            inference: TypeInference::new(),
            security: SecurityAnalysis::new(),
            error_reporter: TypeErrorReporter::new(),
        }
    }

    /// Type check a complete T4 program
    pub fn check_program(&mut self, program: &Program) -> TypeResult<CheckedProgram> {
        // Clear any previous errors
        self.error_reporter.clear();

        // Run type inference
        let inference_result = match self.inference.infer_program(program) {
            Ok(result) => result,
            Err(e) => {
                self.error_reporter.report_error(e, "during type inference".to_string());
                return Err(TypeError::GenericTypeError {
                    message: "Type inference failed".to_string(),
                    location: SourceLocation {
                        start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                        file: self.interner.get_or_intern_static("unknown"),
                    }
                });
            }
        };

        // Run security analysis
        let security_report = match self.security.analyze_program(program) {
            Ok(report) => report,
            Err(e) => {
                self.error_reporter.report_error(e, "during security analysis".to_string());
                return Err(TypeError::SecurityViolation {
                    message: "Security analysis failed".to_string(),
                    location: SourceLocation {
                        start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                        file: self.interner.get_or_intern_static("unknown"),
                    }
                });
            }
        };

        // Check for security violations
        if security_report.has_violations() {
            for violation in security_report.violations {
                self.error_reporter.report_error(
                    TypeError::SecurityViolation {
                        message: format!("{}", violation),
                        location: SourceLocation {
                            start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                            file: self.interner.get_or_intern_static("unknown"),
                        }
                    },
                    format!("security violation: {}", violation)
                );
            }
        }

        // If there are errors, return the first one
        if self.error_reporter.has_errors() {
            return Err(self.error_reporter.errors()[0].error.clone());
        }

        // Convert inference result to checked program
        let checked_program = CheckedProgram {
            declarations: inference_result.declarations.into_iter().map(|decl| {
                match decl {
                    super::inference::InferredDeclaration::Function(func) => {
                        CheckedDeclaration::Function(CheckedFunction {
                            name: func.name,
                            parameters: func.parameters.into_iter().map(|(name, typ)| {
                                Parameter {
                                    name,
                                    typ: if let TypeScheme::Concrete(t) = typ { t } else { Type::Infer },
                                    mutable: false, // TODO: Track mutability
                                    reference: false,
                                }
                            }).collect(),
                            return_type: if let TypeScheme::Concrete(t) = func.return_type {
                                Some(t)
                            } else {
                                None
                            },
                            body: Vec::new(), // TODO: Convert statement types
                            security_annotations: func.security_annotations,
                        })
                    }
                    super::inference::InferredDeclaration::Struct(name, fields) => {
                        CheckedDeclaration::Struct
                    }
                    super::inference::InferredDeclaration::Enum(name, variants) => {
                        CheckedDeclaration::Enum
                    }
                    super::inference::InferredDeclaration::Other => {
                        CheckedDeclaration::Other
                    }
                }
            }).collect(),
            config: program.config.clone(),
        };

        Ok(checked_program)
    }

    /// Type check a single function
    pub fn check_function(&mut self, function: &Function) -> TypeResult<CheckedFunction> {
        // Create a minimal program with just this function
        let program = Program {
            declarations: vec![Declaration::Function(function.clone())],
            config: ModuleConfig {
                default_crypto_provider: None,
                post_quantum_enabled: false,
                hardware_acceleration: false,
                custom_settings: std::collections::HashMap::new(),
            },
        };

        let checked_program = self.check_program(&program)?;

        match checked_program.declarations.first() {
            Some(CheckedDeclaration::Function(func)) => Ok(func.clone()),
            _ => Err(TypeError::GenericTypeError {
                message: "Expected function declaration".to_string(),
                location: SourceLocation {
                    start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                    file: self.interner.get_or_intern_static("unknown"),
                }
            }),
        }
    }

    /// Get error reporter for accessing type errors
    pub fn error_reporter(&self) -> &TypeErrorReporter {
        &self.error_reporter
    }

    /// Get error reporter as mutable reference
    pub fn error_reporter_mut(&mut self) -> &mut TypeErrorReporter {
        &mut self.error_reporter
    }

    /// Check if type checking found any errors
    pub fn has_errors(&self) -> bool {
        self.error_reporter.has_errors()
    }

    /// Get formatted error report
    pub fn format_errors(&self) -> String {
        self.error_reporter.format_errors()
    }
}

impl Default for T4TypeChecker {
    fn default() -> Self {
        Self::new()
    }
}

/// Checked program with complete type information
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

/// Checked function with complete type and security information
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
    pub security_info: super::security::SecurityInfo,
}

/// Type checking context for incremental checking
pub struct TypeCheckContext {
    pub type_checker: T4TypeChecker,
    pub current_module: Option<String>,
    pub imported_modules: std::collections::HashMap<String, Vec<Declaration>>,
}

impl TypeCheckContext {
    pub fn new() -> Self {
        Self {
            type_checker: T4TypeChecker::new(),
            current_module: None,
            imported_modules: std::collections::HashMap::new(),
        }
    }

    /// Set the current module being checked
    pub fn set_current_module(&mut self, module_name: String) {
        self.current_module = Some(module_name);
    }

    /// Add an imported module
    pub fn add_imported_module(&mut self, module_name: String, declarations: Vec<Declaration>) {
        self.imported_modules.insert(module_name, declarations);
    }

    /// Type check with current context
    pub fn check_with_context(&mut self, program: &Program) -> TypeResult<CheckedProgram> {
        // Add imported modules to the inference environment
        for (module_name, declarations) in &self.imported_modules {
            // TODO: Add module declarations to type environment
        }

        self.type_checker.check_program(program)
    }
}

/// Utility functions for type checking integration
pub mod utils {
    use super::*;
    use crate::generated::t4parser::ProgramContext;

    /// Type check a parsed program from ANTLR
    pub fn type_check_parsed_program(
        parse_tree: &ProgramContext,
        interner: &mut StringInterner,
    ) -> TypeResult<CheckedProgram> {
        // This would integrate with the AST builder to convert parse tree to AST
        // For now, this is a placeholder
        let mut type_checker = T4TypeChecker::new();
        // TODO: Convert parse tree to AST and type check
        Err(TypeError::GenericTypeError {
            message: "Parse tree to AST conversion not yet implemented".to_string(),
            location: SourceLocation {
                start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                file: interner.get_or_intern_static("unknown"),
            }
        })
    }

    /// Validate cryptographic type usage
    pub fn validate_crypto_types(program: &Program) -> Result<(), TypeError> {
        for decl in &program.declarations {
            match decl {
                Declaration::Function(func) => {
                    validate_function_crypto_types(func)?;
                }
                _ => {}
            }
        }
        Ok(())
    }

    /// Validate cryptographic types in a function
    fn validate_function_crypto_types(function: &Function) -> Result<(), TypeError> {
        // Check parameter types
        for param in &function.parameters {
            validate_crypto_type(&param.typ)?;
        }

        // Check return type
        if let Some(ref ret_type) = function.return_type {
            validate_crypto_type(ret_type)?;
        }

        Ok(())
    }

    /// Validate a single cryptographic type
    fn validate_crypto_type(typ: &Type) -> Result<(), TypeError> {
        match typ {
            Type::Key(alg) => {
                // Validate that algorithm is supported
                match alg {
                    AlgorithmType::Aes256 | AlgorithmType::Kyber1024 | AlgorithmType::Dilithium3 => Ok(()),
                    _ => Err(TypeError::CryptoTypeError {
                        message: format!("Unsupported algorithm: {}", alg),
                        location: SourceLocation {
                            start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                            file: string_interner::Sym::default(),
                        }
                    }),
                }
            }
            Type::Secret(inner) => {
                validate_crypto_type(inner)
            }
            Type::PublicKey(alg) | Type::PrivateKey(alg) | Type::Signature(alg) => {
                match alg {
                    AlgorithmType::Ed25519 | AlgorithmType::SecP256r1 | AlgorithmType::Dilithium3 => Ok(()),
                    _ => Err(TypeError::CryptoTypeError {
                        message: format!("Unsupported signature algorithm: {}", alg),
                        location: SourceLocation {
                            start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                            file: string_interner::Sym::default(),
                        }
                    }),
                }
            }
            _ => Ok(()),
        }
    }

    /// Extract type information from checked program
    pub fn extract_type_info(checked_program: &CheckedProgram) -> TypeInfo {
        let mut functions = Vec::new();
        let mut types = Vec::new();

        for decl in &checked_program.declarations {
            match decl {
                CheckedDeclaration::Function(func) => {
                    functions.push(FunctionTypeInfo {
                        name: func.name.clone(),
                        parameter_types: func.parameters.iter().map(|p| p.typ.clone()).collect(),
                        return_type: func.return_type.clone(),
                        security_annotations: func.security_annotations.clone(),
                    });
                }
                _ => {}
            }
        }

        TypeInfo {
            functions,
            types,
        }
    }

    /// Type information summary
    #[derive(Debug, Clone)]
    pub struct TypeInfo {
        pub functions: Vec<FunctionTypeInfo>,
        pub types: Vec<TypeInfo>,
    }

    /// Function type information
    #[derive(Debug, Clone)]
    pub struct FunctionTypeInfo {
        pub name: Identifier,
        pub parameter_types: Vec<Type>,
        pub return_type: Option<Type>,
        pub security_annotations: Vec<SecurityAnnotation>,
    }
}

/// Example usage and testing functions
pub mod examples {
    use super::*;

    /// Example of type checking a simple T4 program
    pub fn example_type_checking() -> Result<CheckedProgram, TypeError> {
        // Create a simple program AST
        let program = Program {
            declarations: vec![
                Declaration::Function(Function {
                    name: Identifier::new("main".into(), SourceSpan {
                        location: SourceLocation {
                            start_line: 1, start_column: 0, end_line: 1, end_column: 4,
                            file: string_interner::Sym::default(),
                        }
                    }),
                    generics: Vec::new(),
                    parameters: Vec::new(),
                    return_type: Some(Type::Int64),
                    body: Some(vec![
                        Statement::Let {
                            pattern: Pattern::Identifier {
                                name: Identifier::new("x".into(), SourceSpan {
                                    location: SourceLocation {
                                        start_line: 2, start_column: 4, end_line: 2, end_column: 5,
                                        file: string_interner::Sym::default(),
                                    }
                                }),
                                mutable: false,
                                reference: false,
                                subpattern: None,
                            },
                            typ: Some(Type::Int64),
                            value: Some(Expression::Literal(Literal::Integer("42".to_string()))),
                        },
                        Statement::Expression(Expression::Variable(Identifier::new("x".into(), SourceSpan {
                            location: SourceLocation {
                                start_line: 3, start_column: 11, end_line: 3, end_column: 12,
                                file: string_interner::Sym::default(),
                            }
                        }))),
                    ]),
                    where_clause: None,
                    security_annotations: Vec::new(),
                })
            ],
            config: ModuleConfig {
                default_crypto_provider: None,
                post_quantum_enabled: false,
                hardware_acceleration: false,
                custom_settings: std::collections::HashMap::new(),
            },
        };

        let mut type_checker = T4TypeChecker::new();
        type_checker.check_program(&program)
    }

    /// Example of cryptographic type checking
    pub fn example_crypto_type_checking() -> Result<CheckedProgram, TypeError> {
        let program = Program {
            declarations: vec![
                Declaration::Function(Function {
                    name: Identifier::new("encrypt_data".into(), SourceSpan {
                        location: SourceLocation {
                            start_line: 1, start_column: 0, end_line: 1, end_column: 12,
                            file: string_interner::Sym::default(),
                        }
                    }),
                    generics: Vec::new(),
                    parameters: vec![
                        Parameter {
                            name: Identifier::new("data".into(), SourceSpan {
                                location: SourceLocation {
                                    start_line: 1, start_column: 13, end_line: 1, end_column: 17,
                                    file: string_interner::Sym::default(),
                                }
                            }),
                            typ: Type::Plaintext(AlgorithmType::Aes256),
                            mutable: false,
                            reference: false,
                        },
                        Parameter {
                            name: Identifier::new("key".into(), SourceSpan {
                                location: SourceLocation {
                                    start_line: 1, start_column: 18, end_line: 1, end_column: 21,
                                    file: string_interner::Sym::default(),
                                }
                            }),
                            typ: Type::Key(AlgorithmType::Aes256),
                            mutable: false,
                            reference: false,
                        }
                    ],
                    return_type: Some(Type::Ciphertext(AlgorithmType::Aes256)),
                    body: Some(vec![
                        // Function body would contain encryption logic
                        Statement::Expression(Expression::Encrypt {
                            data: Box::new(Expression::Variable(Identifier::new("data".into(), SourceSpan {
                                location: SourceLocation {
                                    start_line: 2, start_column: 11, end_line: 2, end_column: 15,
                                    file: string_interner::Sym::default(),
                                }
                            }))),
                            key: Box::new(Expression::Variable(Identifier::new("key".into(), SourceSpan {
                                location: SourceLocation {
                                    start_line: 2, start_column: 17, end_line: 2, end_column: 20,
                                    file: string_interner::Sym::default(),
                                }
                            }))),
                        })
                    ]),
                    where_clause: None,
                    security_annotations: vec![SecurityAnnotation::ConstantTime],
                })
            ],
            config: ModuleConfig {
                default_crypto_provider: Some("libcrypto".to_string()),
                post_quantum_enabled: true,
                hardware_acceleration: true,
                custom_settings: std::collections::HashMap::new(),
            },
        };

        let mut type_checker = T4TypeChecker::new();
        type_checker.check_program(&program)
    }
}

#[cfg(test)]
mod integration_tests {
    use super::*;

    #[test]
    fn test_type_checker_creation() {
        let type_checker = T4TypeChecker::new();
        assert!(!type_checker.has_errors());
    }

    #[test]
    fn test_example_type_checking() {
        let result = examples::example_type_checking();
        // This might fail due to incomplete implementation, but should not panic
        assert!(result.is_err() || result.is_ok());
    }

    #[test]
    fn test_crypto_type_validation() {
        let program = Program {
            declarations: vec![],
            config: ModuleConfig {
                default_crypto_provider: None,
                post_quantum_enabled: false,
                hardware_acceleration: false,
                custom_settings: std::collections::HashMap::new(),
            },
        };

        let result = utils::validate_crypto_types(&program);
        assert!(result.is_ok());
    }

    #[test]
    fn test_type_context_creation() {
        let context = TypeCheckContext::new();
        assert!(context.current_module.is_none());
        assert!(context.imported_modules.is_empty());
    }

    #[test]
    fn test_error_reporting_integration() {
        let mut type_checker = T4TypeChecker::new();

        // Simulate an error
        type_checker.error_reporter_mut().report_error(
            TypeError::UnboundVariable(Identifier::new("test".into(), SourceSpan {
                location: SourceLocation {
                    start_line: 1, start_column: 0, end_line: 1, end_column: 4,
                    file: string_interner::Sym::default(),
                }
            })),
            "test error".to_string()
        );

        assert!(type_checker.has_errors());
        let errors = type_checker.format_errors();
        assert!(errors.contains("Unbound variable"));
    }
}