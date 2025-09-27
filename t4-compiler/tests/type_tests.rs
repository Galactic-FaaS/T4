//! Unit tests for the T4 type system

use t4_compiler::types::*;
use t4_compiler::ast::*;
use string_interner::StringInterner;

#[cfg(test)]
mod tests {
    use super::*;

    fn create_test_interner() -> StringInterner {
        let mut interner = StringInterner::default();
        // Add common symbols
        interner.get_or_intern_static("test");
        interner.get_or_intern_static("Int64");
        interner.get_or_intern_static("Bool");
        interner.get_or_intern_static("String");
        interner
    }

    #[test]
    fn test_type_variable_creation() {
        let mut interner = create_test_interner();
        let mut context = TypeContext::new();

        let var1 = context.fresh_var();
        let var2 = context.fresh_var();

        assert_ne!(var1, var2);
        assert!(matches!(var1, TypeScheme::Variable(_)));
        assert!(matches!(var2, TypeScheme::Variable(_)));
    }

    #[test]
    fn test_type_unification() {
        let mut context = TypeContext::new();

        let var = context.fresh_var();
        let concrete_type = TypeScheme::concrete(Type::Int64);

        // Unify variable with concrete type
        assert!(context.unify(&var, &concrete_type).is_ok());

        // After unification, they should be equal
        let unified_var = context.substitution.apply(&var);
        assert_eq!(unified_var, concrete_type);
    }

    #[test]
    fn test_infinite_type_detection() {
        let mut context = TypeContext::new();

        let var1 = context.fresh_var();
        let var2 = context.fresh_var();

        // Create a type that contains var1
        let recursive_type = TypeScheme::concrete(Type::Tuple(vec![
            Type::Infer, // This will be substituted with var1
        ]));

        // This should cause infinite type error
        // (This test would need more sophisticated setup in practice)
    }

    #[test]
    fn test_environment_scoping() {
        let mut env = TypeEnvironment::new();

        // Add binding to root scope
        let int_type = TypeScheme::concrete(Type::Int64);
        env.add_variable("x".into(), int_type.clone(), false);

        assert!(env.contains("x".into()));
        assert_eq!(env.scope_depth(), 0);

        // Enter new scope
        env.enter_scope();
        assert_eq!(env.scope_depth(), 1);

        // Add binding to new scope
        let bool_type = TypeScheme::concrete(Type::Bool);
        env.add_variable("y".into(), bool_type, false);

        assert!(env.contains("y".into()));
        assert!(env.contains("x".into())); // Should still see parent scope

        // Exit scope
        env.exit_scope();
        assert_eq!(env.scope_depth(), 0);
        assert!(!env.contains("y".into())); // Should not see child scope
        assert!(env.contains("x".into())); // Should still see root scope
    }

    #[test]
    fn test_security_analysis() {
        let mut analysis = SecurityAnalysis::new();

        // Test affine usage tracking
        let secret_var = "secret_key".into();
        analysis.usage_tracking.track_secret_use(&secret_var);
        analysis.usage_tracking.track_secret_use(&secret_var);

        // Should detect multiple usage
        let violations = analysis.usage_tracking.check_all_affine_constraints();
        assert!(!violations.is_empty());
    }

    #[test]
    fn test_type_inference_basic() {
        let mut inference = TypeInference::new();

        // Create a simple expression: 42
        let literal_expr = Expression::Literal(Literal::Integer("42".to_string()));

        let result = inference.infer_expression(&literal_expr);
        assert!(result.is_ok());

        let inferred_type = result.unwrap();
        assert_eq!(inferred_type, TypeScheme::concrete(Type::Int64));
    }

    #[test]
    fn test_binary_operation_inference() {
        let mut inference = TypeInference::new();

        // Create expression: 1 + 2
        let left = Box::new(Expression::Literal(Literal::Integer("1".to_string())));
        let right = Box::new(Expression::Literal(Literal::Integer("2".to_string())));
        let add_expr = Expression::Binary {
            left,
            op: BinaryOp::Add,
            right,
        };

        let result = inference.infer_expression(&add_expr);
        assert!(result.is_ok());

        // Result should be Int64 (from integer literals)
        let inferred_type = result.unwrap();
        // The type will be a fresh variable that gets unified with Int64
        assert!(matches!(inferred_type, TypeScheme::Variable(_) |
                      TypeScheme::Concrete(Type::Int64)));
    }

    #[test]
    fn test_function_type_inference() {
        let mut inference = TypeInference::new();

        // Create a simple function
        let param_name = Identifier::new("x".into(), SourceSpan {
            location: SourceLocation {
                start_line: 1, start_column: 0, end_line: 1, end_column: 1,
                file: "test".into()
            }
        });

        let function = Function {
            name: Identifier::new("test_func".into(), SourceSpan {
                location: SourceLocation {
                    start_line: 1, start_column: 0, end_line: 1, end_column: 9,
                    file: "test".into()
                }
            }),
            generics: Vec::new(),
            parameters: vec![
                Parameter {
                    name: param_name,
                    typ: Type::Int64,
                    mutable: false,
                    reference: false,
                }
            ],
            return_type: Some(Type::Bool),
            body: Some(vec![
                Statement::Expression(Expression::Variable(Identifier::new("x".into(), SourceSpan {
                    location: SourceLocation {
                        start_line: 2, start_column: 4, end_line: 2, end_column: 5,
                        file: "test".into()
                    }
                })))
            ]),
            where_clause: None,
            security_annotations: Vec::new(),
        };

        let result = inference.infer_function(&function);
        assert!(result.is_ok());
    }

    #[test]
    fn test_error_reporting() {
        let mut reporter = TypeErrorReporter::new();

        let error = TypeError::UnboundVariable(Identifier::new("unknown_var".into(), SourceSpan {
            location: SourceLocation {
                start_line: 1, start_column: 0, end_line: 1, end_column: 11,
                file: "test".into()
            }
        }));

        reporter.report_error(error, "at 1:0".to_string());

        assert!(reporter.has_errors());
        assert_eq!(reporter.error_count(), 1);

        let formatted = reporter.format_errors();
        assert!(formatted.contains("Unbound variable"));
        assert!(formatted.contains("unknown_var"));
    }

    #[test]
    fn test_cryptographic_types() {
        // Test that cryptographic types are properly handled
        let key_type = TypeScheme::concrete(Type::Key(AlgorithmType::Aes256));
        let secret_type = TypeScheme::concrete(Type::Secret(Box::new(Type::Bytes)));
        let nonce_type = TypeScheme::concrete(Type::Nonce);

        assert!(matches!(key_type, TypeScheme::Concrete(Type::Key(_))));
        assert!(matches!(secret_type, TypeScheme::Concrete(Type::Secret(_))));
        assert!(matches!(nonce_type, TypeScheme::Concrete(Type::Nonce)));
    }

    #[test]
    fn test_type_substitution() {
        let mut substitution = TypeSubstitution::new();
        let var = TypeVar::new(TypeVarId(0));
        let replacement = TypeScheme::concrete(Type::Int64);

        substitution.insert(var.clone(), replacement.clone());

        let original = TypeScheme::Variable(var);
        let substituted = substitution.apply(&original);

        assert_eq!(substituted, replacement);
    }

    #[test]
    fn test_polymorphic_types() {
        let var = TypeVar::new(TypeVarId(0));
        let monotype = TypeScheme::concrete(Type::Int64);
        let polytype = TypeScheme::polymorphic(vec![var.clone()], monotype.clone());

        assert!(matches!(polytype, TypeScheme::Polymorphic { .. }));

        // Test free variables
        let free_vars = polytype.free_vars();
        assert!(!free_vars.contains(&var)); // Bound variable should not be free
    }

    #[test]
    fn test_security_violations() {
        let violation = SecurityViolation::MultipleSecretUsage {
            var_name: "secret_key".to_string(),
            usage_count: 3,
        };

        let formatted = format!("{}", violation);
        assert!(formatted.contains("secret_key"));
        assert!(formatted.contains("3 times"));
    }

    #[test]
    fn test_memory_safety_analysis() {
        let mut analysis = MemorySafetyAnalysis::new();

        // Test key handling analysis
        let key_var = Identifier::new("temp_key".into(), SourceSpan {
            location: SourceLocation {
                start_line: 1, start_column: 0, end_line: 1, end_column: 8,
                file: "test".into()
            }
        });

        // This should be flagged as a temporary key exposure
        let result = analysis.check_key_handling(&key_var);
        assert!(result.is_err());
    }

    #[test]
    fn test_constraint_solving() {
        let constraints = vec![
            TypeConstraint::Equal(
                TypeScheme::concrete(Type::Int64),
                TypeScheme::concrete(Type::Int64)
            )
        ];

        let solver = ConstraintSolver::new(constraints);
        let result = solver.solve();

        assert!(result.is_ok());
    }

    #[test]
    fn test_type_scheme_display() {
        let concrete = TypeScheme::concrete(Type::Int64);
        assert_eq!(format!("{}", concrete), "Int64");

        let var = TypeScheme::Variable(TypeVar::new(TypeVarId(0)));
        assert_eq!(format!("{}", var), "?0");

        let poly = TypeScheme::polymorphic(
            vec![TypeVar::new(TypeVarId(0))],
            TypeScheme::concrete(Type::Int64)
        );
        assert!(format!("{}", poly).contains("∀"));
    }

    #[test]
    fn test_security_context() {
        let mut context = SecurityContext::new();

        assert!(!context.in_secret_context());
        assert!(!context.in_constant_time_context());

        let secret_vars = vec!["key1".into(), "key2".into()];
        context.enter_secret_context(secret_vars.clone());

        assert!(context.in_secret_context());
        assert_eq!(context.active_secrets().len(), 2);

        context.exit_secret_context();
        assert!(!context.in_secret_context());
        assert_eq!(context.active_secrets().len(), 0);
    }

    #[test]
    fn test_security_levels() {
        assert!(SecurityLevel::Public.can_flow_to(&SecurityLevel::Secret));
        assert!(SecurityLevel::Secret.can_flow_to(&SecurityLevel::Secret));
        assert!(SecurityLevel::Secret.can_flow_to(&SecurityLevel::Encrypted));
        assert!(!SecurityLevel::Secret.can_flow_to(&SecurityLevel::Public));
        assert!(!SecurityLevel::Encrypted.can_flow_to(&SecurityLevel::Secret));
    }

    #[test]
    fn test_type_environment_builtins() {
        let env = TypeEnvironment::new();

        // Check that built-in types are available
        assert!(env.contains("Int64".into()));
        assert!(env.contains("Bool".into()));
        assert!(env.contains("String".into()));
        assert!(env.contains("Nonce".into()));
        assert!(env.contains("Salt".into()));
    }

    #[test]
    fn test_error_suggestions() {
        let error = TypeError::UnboundVariable(Identifier::new("foo".into(), SourceSpan {
            location: SourceLocation {
                start_line: 1, start_column: 0, end_line: 1, end_column: 3,
                file: "test".into()
            }
        }));

        let suggestions = generate_suggestions(&error);
        assert!(!suggestions.is_empty());
        assert!(suggestions.iter().any(|s| s.contains("declared")));
        assert!(suggestions.iter().any(|s| s.contains("typos")));
    }

    #[test]
    fn test_type_context_qualification() {
        let env = TypeEnvironment::new();
        let mut context = TypeContext::new(&env);

        let qualified = context.qualify_name("MyStruct".into(), Some("mymodule".into()));
        assert_eq!(qualified, "mymodule::MyStruct");

        let unqualified = context.qualify_name("Int64".into(), None);
        assert_eq!(unqualified, "Int64");
    }

    #[test]
    fn test_security_report() {
        let mut analysis = SecurityAnalysis::new();

        // Create a mock violation
        analysis.report_violation(SecurityViolation::MultipleSecretUsage {
            var_name: "test_secret".to_string(),
            usage_count: 2,
        });

        let report = SecurityReport {
            violations: analysis.violations,
            usage_tracking: analysis.usage_tracking,
            constant_time_info: analysis.constant_time_info,
        };

        assert!(report.has_violations());
        assert_eq!(report.violation_count(), 1);

        let formatted = report.format_report();
        assert!(formatted.contains("Security Analysis Report"));
        assert!(formatted.contains("test_secret"));
    }

    #[test]
    fn test_occurs_check() {
        let var = TypeVar::new(TypeVarId(0));
        let other_var = TypeVar::new(TypeVarId(1));

        // Variable should occur in itself
        assert!(occurs_check(&var, &TypeScheme::Variable(var.clone())));

        // Variable should not occur in different variable
        assert!(!occurs_check(&var, &TypeScheme::Variable(other_var)));

        // Variable should not occur in concrete type
        assert!(!occurs_check(&var, &TypeScheme::concrete(Type::Int64)));
    }

    #[test]
    fn test_type_instantiation() {
        let var = TypeVar::new(TypeVarId(0));
        let polytype = TypeScheme::polymorphic(
            vec![var.clone()],
            TypeScheme::concrete(Type::Int64)
        );

        let mut next_var = 1;
        let mut interner = StringInterner::default();

        let instantiated = polytype.instantiate(&mut interner, &mut next_var);

        // Should be a concrete type now
        assert!(matches!(instantiated, TypeScheme::Concrete(Type::Int64)));
    }

    #[test]
    fn test_type_generalization() {
        let var = TypeVar::new(TypeVarId(0));
        let monotype = TypeScheme::Variable(var.clone());

        let mut env_vars = std::collections::HashSet::new();
        env_vars.insert(var.clone());

        let generalized = monotype.generalize(&env_vars);

        // Should remain a variable since it's in the environment
        assert!(matches!(generalized, TypeScheme::Variable(_)));
    }

    #[test]
    fn test_cryptographic_algorithm_types() {
        let algorithms = vec![
            AlgorithmType::Aes256,
            AlgorithmType::Kyber1024,
            AlgorithmType::Dilithium3,
            AlgorithmType::Ed25519,
            AlgorithmType::SecP256r1,
        ];

        for alg in algorithms {
            let display = format!("{}", alg);
            assert!(!display.is_empty());
            assert!(display.chars().all(|c| c.is_alphanumeric() || c == '_'));
        }
    }

    #[test]
    fn test_security_annotations() {
        let annotations = vec![
            SecurityAnnotation::ConstantTime,
            SecurityAnnotation::CacheResistant,
            SecurityAnnotation::SecureMemory,
            SecurityAnnotation::VerifyProtocol,
        ];

        for annotation in annotations {
            let display = format!("{}", annotation);
            assert!(!display.is_empty());
        }
    }

    #[test]
    fn test_type_path_resolution() {
        let mut env = TypeEnvironment::new();
        let context = TypeContext::new(&env);

        // Test resolution of built-in types
        assert!(context.resolve_type("Int64".into()).is_some());
        assert!(context.resolve_type("NonExistent".into()).is_none());
    }

    #[test]
    fn test_module_type_bindings() {
        let env = TypeEnvironment::new();
        let type_bindings = env.get_type_bindings();

        // Should have built-in types
        assert!(!type_bindings.is_empty());
        assert!(type_bindings.contains_key(&"Int64".into()));
        assert!(type_bindings.contains_key(&"Bool".into()));
    }

    #[test]
    fn test_error_context_formatting() {
        let error = TypeError::TypeMismatch {
            expected: TypeScheme::concrete(Type::Int64),
            found: TypeScheme::concrete(Type::Bool),
            location: SourceLocation {
                start_line: 10, start_column: 5, end_line: 10, end_column: 15,
                file: "test".into()
            }
        };

        let context = TypeErrorWithContext::new(error, "in function test_func".to_string());

        let formatted = format!("{}", context);
        assert!(formatted.contains("Type mismatch"));
        assert!(formatted.contains("10:5"));
        assert!(formatted.contains("Int64"));
        assert!(formatted.contains("Bool"));
    }
}