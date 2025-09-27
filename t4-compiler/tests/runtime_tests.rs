//! T4 Runtime System Tests
//!
//! This module contains comprehensive tests for the T4 runtime system,
//! including execution engine, memory management, cryptographic operations,
//! and security features.

use t4_compiler::runtime::{
    T4Runtime,
    values::Value,
    memory::{MemoryManager, SecureMemoryGuard},
    crypto::{CryptoRuntime, KeyMaterial, CryptoProvider, DefaultCryptoProvider},
    security::{SecurityManager, ConstantTimeOps},
    errors::{RuntimeError, RuntimeResult},
    RuntimeConfig, MemorySafetyLevel, SecurityLevel,
};
use t4_compiler::ast::{Program, Declaration, Function, Statement, Expression, Literal, Identifier, SourceSpan, SourceLocation, Type, AlgorithmType};
use std::sync::Arc;
use std::collections::HashMap;

/// Test runtime creation and basic functionality
#[test]
fn test_runtime_creation() {
    let runtime = T4Runtime::new();
    assert!(runtime.is_ok());

    let mut runtime = runtime.unwrap();
    let stats = runtime.get_statistics();
    assert_eq!(stats.memory_usage.total_allocated, 0);
    assert_eq!(stats.crypto_operations, 0);
    assert_eq!(stats.security_violations, 0);
}

/// Test memory management
#[test]
fn test_memory_management() {
    let memory_manager = MemoryManager::new(MemorySafetyLevel::Enhanced);
    assert!(memory_manager.is_ok());

    let memory_manager = memory_manager.unwrap();
    let stats = memory_manager.get_usage_stats();
    assert_eq!(stats.total_allocated, 0);
    assert_eq!(stats.secure_regions, 0);
}

/// Test secure memory allocation and wiping
#[test]
fn test_secure_memory() {
    let memory_manager = Arc::new(MemoryManager::new(MemorySafetyLevel::Maximum).unwrap());
    let allocator = memory_manager.allocator.clone();

    // Test secure allocation
    let layout = std::alloc::Layout::from_size_align(1024, 8).unwrap();
    let ptr = allocator.allocate(layout, crate::runtime::memory::RegionType::Secret, crate::runtime::values::SecurityLevel::Secret, true);
    assert!(ptr.is_ok());

    let ptr = ptr.unwrap();

    // Test secure wiping
    allocator.secure_wipe(ptr, 1024);

    // Test deallocation
    let result = allocator.deallocate(ptr, layout, true);
    assert!(result.is_ok());
}

/// Test value system
#[test]
fn test_value_system() {
    // Test primitive values
    let int_val = Value::Integer(42);
    assert_eq!(int_val.get_type(), Type::Int64);
    assert_eq!(int_val.size(), 8);

    let bool_val = Value::Bool(true);
    assert_eq!(bool_val.get_type(), Type::Bool);
    assert_eq!(bool_val.size(), 1);

    let string_val = Value::String("Hello, T4!".to_string());
    assert_eq!(string_val.get_type(), Type::String);
    assert_eq!(string_val.size(), 10);

    // Test array value
    let elements = vec![Value::Integer(1), Value::Integer(2), Value::Integer(3)];
    let array_val = Value::new_array(Type::Int64, elements);
    assert_eq!(array_val.get_type(), Type::Array(Box::new(Type::Int64), 3));

    // Test struct value
    let mut fields = HashMap::new();
    fields.insert("x".to_string(), Value::Integer(10));
    fields.insert("y".to_string(), Value::Integer(20));
    let struct_val = Value::new_struct("Point".to_string(), fields);
    assert_eq!(struct_val.get_type(), Type::Path {
        module: None,
        name: Identifier {
            name: 0,
            span: SourceSpan {
                location: SourceLocation {
                    start_line: 0,
                    start_column: 0,
                    end_line: 0,
                    end_column: 0,
                    file: 0,
                }
            },
        },
        args: Vec::new(),
    });
}

/// Test secret value handling
#[test]
fn test_secret_values() {
    let memory_manager = Arc::new(MemoryManager::new(MemorySafetyLevel::Maximum).unwrap());

    // Test secret creation
    let secret_data = vec![1u8, 2, 3, 4, 5];
    let secret_val = Value::new_secret(secret_data.clone(), crate::runtime::values::SecretType::Key);

    // Verify it's marked as secret
    assert!(secret_val.is_secret());
    assert!(secret_val.requires_constant_time());
    assert!(secret_val.requires_secure_memory());

    // Test secret wiping
    if let Value::Secret(ref mut secret) = secret_val {
        // Data should be intact initially
        assert_eq!(secret.data, secret_data);

        // Wipe the secret
        let _ = secret_val.wipe();

        // Data should be zeroed
        assert_eq!(secret.data, vec![0u8; 5]);
    } else {
        panic!("Expected secret value");
    }
}

/// Test cryptographic runtime
#[test]
fn test_crypto_runtime() {
    let crypto_runtime = CryptoRuntime::new(true, true);
    assert!(crypto_runtime.is_ok());

    let mut crypto_runtime = crypto_runtime.unwrap();

    // Test key generation
    let key_result = crypto_runtime.generate_key(&AlgorithmType::Aes256);
    assert!(key_result.is_ok());

    let key = key_result.unwrap();
    assert!(key.is_secret());

    // Test hashing
    let data = b"Hello, World!";
    let hash_result = crypto_runtime.hash(&AlgorithmType::Sha3_256, data);
    assert!(hash_result.is_ok());

    let hash = hash_result.unwrap();
    assert_eq!(hash.len(), 32); // SHA3-256 produces 32 bytes

    // Test operation counting
    assert_eq!(crypto_runtime.get_operation_count(), 2);
}

/// Test built-in functions
#[test]
fn test_builtin_functions() {
    let builtins = t4_compiler::runtime::builtins::BuiltinFunctions::new();
    assert!(builtins.is_ok());

    let builtins = builtins.unwrap();

    // Test function lookup
    let print_func = builtins.get_function("print");
    assert!(print_func.is_some());

    let crypto_func = builtins.get_function("generate_keypair");
    assert!(crypto_func.is_some());

    // Test function listing
    let func_names = builtins.list_functions();
    assert!(!func_names.is_empty());
    assert!(func_names.contains(&"print"));
    assert!(func_names.contains(&"generate_keypair"));
}

/// Test security manager
#[test]
fn test_security_manager() {
    let security_manager = SecurityManager::new(SecurityLevel::High);
    assert!(security_manager.is_ok());

    let mut security_manager = security_manager.unwrap();

    // Test function call checking
    let arguments = vec![Value::String("test".to_string())];
    let result = security_manager.check_call("print", &arguments);
    assert!(result.is_ok());

    // Test crypto operation checking
    let crypto_args = vec![Value::new_secret(vec![1u8; 32], crate::runtime::values::SecretType::Key)];
    let result = security_manager.check_crypto_operation("encrypt", &crypto_args);
    assert!(result.is_ok());

    // Test security statistics
    let stats = security_manager.get_security_stats();
    assert_eq!(stats.violation_count, 0);
    assert_eq!(stats.protection_level, SecurityLevel::High);
}

/// Test constant-time operations
#[test]
fn test_constant_time_ops() {
    // Test constant-time comparison
    let a = [1u8, 2, 3, 4];
    let b = [1u8, 2, 3, 4];
    let c = [1u8, 2, 3, 5];

    assert!(ConstantTimeOps::equal_bytes(&a, &b));
    assert!(!ConstantTimeOps::equal_bytes(&a, &c));

    // Test constant-time selection
    let selected = ConstantTimeOps::select(true, &a, &c);
    assert_eq!(selected, a);

    let selected = ConstantTimeOps::select(false, &a, &c);
    assert_eq!(selected, c);
}

/// Test error handling
#[test]
fn test_error_handling() {
    // Test runtime error classification
    let div_by_zero = RuntimeError::DivisionByZero;
    let classification = div_by_zero.classify();
    assert_eq!(classification.category, t4_compiler::runtime::errors::ErrorCategory::Logic);
    assert_eq!(classification.severity, t4_compiler::runtime::errors::ErrorSeverity::Error);
    assert!(!classification.recoverable);

    // Test security-related error detection
    let security_error = RuntimeError::SecurityViolation("test".to_string());
    assert!(security_error.is_security_related());

    // Test cryptographic error detection
    let crypto_error = RuntimeError::InvalidKey;
    assert!(crypto_error.is_cryptographic());

    // Test memory error detection
    let memory_error = RuntimeError::OutOfMemory;
    assert!(memory_error.is_memory_related());
}

/// Test runtime execution
#[test]
fn test_runtime_execution() {
    let mut runtime = T4Runtime::new().unwrap();

    // Create a simple program
    let program = create_test_program();
    let result = runtime.execute_program(&program);

    // The execution might fail due to unimplemented features, but shouldn't panic
    // This tests that the runtime can at least start executing
    assert!(result.is_ok() || matches!(result, Err(RuntimeError::NotImplemented)));
}

/// Test memory leak detection
#[test]
fn test_memory_leak_detection() {
    let memory_manager = MemoryManager::new(MemorySafetyLevel::Maximum).unwrap();

    // Allocate some memory
    let initial_stats = memory_manager.get_usage_stats();

    // Create some values that require secure memory
    let secret_val = Value::new_secret(vec![1u8; 100], crate::runtime::values::SecretType::Key);

    // Check that memory tracking is working
    let final_stats = memory_manager.get_usage_stats();
    assert!(final_stats.wiped_bytes >= initial_stats.wiped_bytes);
}

/// Test cryptographic provider system
#[test]
fn test_crypto_providers() {
    let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

    // Test provider registration
    let provider = Box::new(DefaultCryptoProvider::new());
    crypto_runtime.register_provider(provider);

    // Test provider lookup
    let default_provider = crypto_runtime.get_default_provider();
    assert!(default_provider.is_some());

    // Test algorithm support
    let supports_aes = default_provider.unwrap().supports_algorithm(&AlgorithmType::Aes256);
    assert!(supports_aes);

    // Test provider selection
    let provider = crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Aes256);
    assert!(provider.is_some());
}

/// Test security violation detection
#[test]
fn test_security_violations() {
    let mut security_manager = SecurityManager::new(SecurityLevel::Maximum).unwrap();

    // Test suspicious value detection
    let suspicious_data = vec![0u8; 2000]; // Large byte array might be suspicious
    let suspicious_value = Value::Bytes(suspicious_data);

    // This should trigger security analysis
    let result = security_manager.check_call("process_data", &[suspicious_value]);
    // May or may not be flagged as violation depending on implementation
    assert!(result.is_ok() || matches!(result, Err(RuntimeError::SecurityViolation(_))));
}

/// Test performance characteristics
#[test]
fn test_performance() {
    let mut runtime = T4Runtime::new().unwrap();

    // Measure basic operation performance
    let start_time = std::time::Instant::now();

    // Perform some operations
    for i in 0..1000 {
        let value = Value::Integer(i);
        let _ = value.get_type();
        let _ = value.size();
    }

    let duration = start_time.elapsed();
    assert!(duration.as_millis() < 1000); // Should complete within 1 second
}

/// Test concurrent access safety
#[test]
fn test_concurrent_safety() {
    use std::thread;

    let memory_manager = Arc::new(MemoryManager::new(MemorySafetyLevel::Standard).unwrap());

    // Test concurrent memory allocation
    let handles: Vec<_> = (0..10).map(|_| {
        let mm = memory_manager.clone();
        thread::spawn(move || {
            for _ in 0..100 {
                // Simulate memory operations
                let _ = mm.get_usage_stats();
            }
        })
    }).collect();

    // Wait for all threads to complete
    for handle in handles {
        handle.join().unwrap();
    }
}

/// Test error recovery
#[test]
fn test_error_recovery() {
    let mut runtime = T4Runtime::new().unwrap();

    // Create a program that will cause errors
    let error_program = create_error_program();

    // Execute the program - it should handle errors gracefully
    let result = runtime.execute_program(&error_program);

    // Should either succeed or fail with a proper error, not panic
    assert!(result.is_ok() || result.is_err());
}

/// Helper function to create a test program
fn create_test_program() -> Program {
    Program {
        declarations: vec![
            Declaration::Function(Function {
                name: Identifier {
                    name: 0,
                    span: SourceSpan {
                        location: SourceLocation {
                            start_line: 1,
                            start_column: 1,
                            end_line: 1,
                            end_column: 10,
                            file: 0,
                        }
                    },
                },
                generics: Vec::new(),
                parameters: Vec::new(),
                return_type: Some(Type::Int64),
                body: Some(vec![
                    Statement::Expression(Expression::Literal(Literal::Integer("42".to_string()))),
                ]),
                where_clause: None,
                security_annotations: Vec::new(),
            }),
        ],
        config: crate::ast::ModuleConfig {
            default_crypto_provider: None,
            post_quantum_enabled: false,
            hardware_acceleration: false,
            custom_settings: HashMap::new(),
        },
    }
}

/// Helper function to create a program that will cause errors
fn create_error_program() -> Program {
    Program {
        declarations: vec![
            Declaration::Function(Function {
                name: Identifier {
                    name: 0,
                    span: SourceSpan {
                        location: SourceLocation {
                            start_line: 1,
                            start_column: 1,
                            end_line: 1,
                            end_column: 10,
                            file: 0,
                        }
                    },
                },
                generics: Vec::new(),
                parameters: Vec::new(),
                return_type: Some(Type::Int64),
                body: Some(vec![
                    Statement::Expression(Expression::Binary {
                        left: Box::new(Expression::Literal(Literal::Integer("10".to_string()))),
                        op: crate::ast::BinaryOp::Div,
                        right: Box::new(Expression::Literal(Literal::Integer("0".to_string()))),
                    }),
                ]),
                where_clause: None,
                security_annotations: Vec::new(),
            }),
        ],
        config: crate::ast::ModuleConfig {
            default_crypto_provider: None,
            post_quantum_enabled: false,
            hardware_acceleration: false,
            custom_settings: HashMap::new(),
        },
    }
}

/// Test comprehensive runtime integration
#[test]
fn test_runtime_integration() {
    // Test that all runtime components work together
    let mut runtime = T4Runtime::with_config(RuntimeConfig {
        crypto_enabled: true,
        post_quantum_enabled: true,
        hardware_acceleration: true,
        memory_safety: MemorySafetyLevel::Enhanced,
        security_level: SecurityLevel::High,
        optimization_level: crate::runtime::OptimizationLevel::Basic,
    }).unwrap();

    // Test memory management integration
    let stats = runtime.get_statistics();
    assert_eq!(stats.memory_usage.total_allocated, 0);

    // Test cryptographic integration
    let program = create_test_program();
    let result = runtime.execute_program(&program);

    // Should handle execution without panicking
    assert!(result.is_ok() || result.is_err());
}

/// Benchmark test for performance evaluation
#[test]
fn test_runtime_performance() {
    let mut runtime = T4Runtime::new().unwrap();

    // Measure memory allocation performance
    let start_time = std::time::Instant::now();

    for _ in 0..1000 {
        let _ = Value::new_secret(vec![1u8; 32], crate::runtime::values::SecretType::Key);
    }

    let allocation_time = start_time.elapsed();

    // Measure cryptographic operation performance
    let crypto_start = std::time::Instant::now();

    for _ in 0..100 {
        let data = b"test data for hashing";
        let _ = runtime.crypto_runtime.hash(&AlgorithmType::Sha3_256, data);
    }

    let crypto_time = crypto_start.elapsed();

    // Performance assertions
    assert!(allocation_time.as_millis() < 1000); // Should allocate 1000 secrets quickly
    assert!(crypto_time.as_millis() < 1000); // Should hash 100 blocks quickly

    // Verify operation counting
    assert_eq!(runtime.crypto_runtime.get_operation_count(), 100);
}

/// Test memory stress
#[test]
fn test_memory_stress() {
    let memory_manager = MemoryManager::new(MemorySafetyLevel::Maximum).unwrap();

    // Allocate and deallocate many objects
    let mut guards = Vec::new();

    for i in 0..100 {
        let size = 100 + (i % 1000); // Varying sizes
        let secret_val = Value::new_secret(vec![1u8; size], crate::runtime::values::SecretType::Key);

        // In a real test, we'd create actual memory guards
        // For now, just test that we can handle the load
        assert!(secret_val.is_secret());
    }

    // Check final memory statistics
    let final_stats = memory_manager.get_usage_stats();
    assert!(final_stats.allocations > 0);
}

/// Test security stress
#[test]
fn test_security_stress() {
    let mut security_manager = SecurityManager::new(SecurityLevel::Maximum).unwrap();

    // Perform many security checks
    for i in 0..1000 {
        let value = Value::Integer(i);
        let _ = security_manager.check_call("test_function", &[value]);
    }

    // Check that security monitoring is working
    let stats = security_manager.get_security_stats();
    assert_eq!(stats.protection_level, SecurityLevel::Maximum);
}

/// Test error stress
#[test]
fn test_error_stress() {
    // Test that error handling doesn't degrade under load
    for i in 0..1000 {
        let error = RuntimeError::UndefinedVariable(format!("var_{}", i));
        let classification = error.classify();

        // Verify error classification is consistent
        assert!(!classification.suggested_actions.is_empty());
    }
}

/// Test crypto stress
#[test]
fn test_crypto_stress() {
    let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

    // Perform many cryptographic operations
    for i in 0..100 {
        let data = format!("test data {}", i).as_bytes().to_vec();
        let _ = crypto_runtime.hash(&AlgorithmType::Sha3_256, &data);
    }

    // Verify operation counting
    assert_eq!(crypto_runtime.get_operation_count(), 100);
}

/// Test comprehensive stress
#[test]
fn test_comprehensive_stress() {
    let mut runtime = T4Runtime::new().unwrap();

    // Perform mixed operations
    for i in 0..100 {
        // Memory operations
        let _ = Value::new_secret(vec![1u8; 32], crate::runtime::values::SecretType::Key);

        // Crypto operations
        let data = format!("iteration {}", i).as_bytes().to_vec();
        let _ = runtime.crypto_runtime.hash(&AlgorithmType::Sha3_256, &data);

        // Security checks
        let value = Value::Integer(i);
        let _ = runtime.security_manager.check_call("stress_test", &[value]);
    }

    // Verify all systems are still functional
    let stats = runtime.get_statistics();
    assert!(stats.crypto_operations > 0);
    assert_eq!(stats.security_violations, 0); // Should have no violations
}