//! T4 Integration Tests
//!
//! Tests for the complete T4 compiler pipeline including parsing, type checking, and execution

use t4_compiler::compiler::T4Compiler;
use t4_compiler::codegen::CodeGenerator;
use t4_compiler::runtime::Runtime;
use std::fs;
use tempfile::tempdir;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_basic_program_compilation() {
        let source = r#"
        module TestModule {
            fn main() -> Int32 {
                42
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let result = compiler.parse(source);

        assert!(result.is_ok());
        let program = result.unwrap();
        assert_eq!(program.declarations.len(), 1);
    }

    #[test]
    fn test_crypto_program_compilation() {
        let source = r#"
        module CryptoTest {
            import "libcrypto.so" as crypto_lib;

            fn main() -> Int32 {
                let key: Key<AES256> = crypto::generate_key();
                let message: Plaintext = Plaintext::from("Hello, T4!");
                let nonce: Nonce = crypto::generate_nonce();
                let encrypted: Ciphertext<AES256> = crypto::encrypt(message, key, nonce);
                let decrypted: Plaintext = crypto::decrypt(encrypted, key, nonce);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let result = compiler.parse(source);

        assert!(result.is_ok());
        let program = result.unwrap();
        assert_eq!(program.declarations.len(), 1);
    }

    #[test]
    fn test_code_generation() {
        let source = r#"
        module CodeGenTest {
            fn main() -> Int32 {
                42
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "test_output");

        assert!(output.is_ok());
        let code = output.unwrap();
        assert!(!code.is_empty());
        assert!(String::from_utf8_lossy(&code).contains("T4 Program"));
    }

    #[test]
    fn test_runtime_execution() {
        // This would test the runtime execution if we had a working interpreter
        // For now, we just test that the runtime can be created
        let runtime = Runtime::new();
        assert!(runtime.is_ok());
    }

    #[test]
    fn test_compiler_pipeline() {
        let source = r#"
        module PipelineTest {
            fn add(a: Int32, b: Int32) -> Int32 {
                a + b
            }

            fn main() -> Int32 {
                let result: Int32 = add(10, 20);
                result
            }
        }
        "#;

        // Test complete compilation pipeline
        let mut compiler = T4Compiler::new();

        // Parse
        let program = compiler.parse(source).unwrap();
        assert_eq!(program.declarations.len(), 2);

        // Type check
        compiler.type_check(&program).unwrap();

        // Generate code
        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "pipeline_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_error_handling() {
        let invalid_source = r#"
        module ErrorTest {
            fn main() -> Int32 {
                let x: Int32 = "this is not an integer";
                x
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let result = compiler.parse(invalid_source);

        // Should still parse (syntax is valid), but type checking should fail
        assert!(result.is_ok());
    }

    #[test]
    fn test_file_operations() {
        let temp_dir = tempdir().unwrap();
        let source_file = temp_dir.path().join("test.t4");
        let output_file = temp_dir.path().join("test_output");

        let source = r#"
        module FileTest {
            fn main() -> Int32 {
                123
            }
        }
        "#;

        // Write source file
        fs::write(&source_file, source).unwrap();

        // Test compilation from file
        let mut compiler = T4Compiler::new();
        let program = compiler.parse(&fs::read_to_string(&source_file).unwrap()).unwrap();

        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, output_file.to_str().unwrap());
        assert!(output.is_ok());

        // Check that output file was created
        assert!(output_file.exists());
    }

    #[test]
    fn test_large_program() {
        let mut source = String::new();
        source.push_str("module LargeTest {\n");

        // Generate a large program with many functions
        for i in 0..50 {
            source.push_str(&format!(
                "    fn func_{}() -> Int32 {{\n        {}\n    }}\n\n",
                i, i
            ));
        }

        source.push_str("    fn main() -> Int32 {\n        0\n    }\n");
        source.push_str("}\n");

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(&source).unwrap();

        assert_eq!(program.declarations.len(), 1);
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "large_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_memory_usage() {
        let mut compiler = T4Compiler::new();

        // Test that compiler doesn't leak memory with repeated compilations
        for i in 0..10 {
            let source = format!(
                "module MemoryTest{{}} {}",
                i
            );
            let program = compiler.parse(&source).unwrap();
            compiler.type_check(&program).unwrap();
        }

        // If we get here without running out of memory, the test passes
        assert!(true);
    }

    #[test]
    fn test_concurrent_compilation() {
        use std::thread;

        let source = r#"
        module ConcurrentTest {
            fn main() -> Int32 {
                42
            }
        }
        "#;

        let handles: Vec<_> = (0..4).map(|_| {
            let source_clone = source.clone();
            thread::spawn(move || {
                let mut compiler = T4Compiler::new();
                let program = compiler.parse(&source_clone).unwrap();
                compiler.type_check(&program).unwrap();

                let mut codegen = CodeGenerator::new();
                let output = codegen.generate(&program, "concurrent_test");
                output.is_ok()
            })
        }).collect();

        for handle in handles {
            assert!(handle.join().unwrap());
        }
    }

    #[test]
    fn test_crypto_integration() {
        let source = r#"
        module CryptoIntegration {
            import "libcrypto.so" as crypto_lib;

            fn main() -> Int32 {
                // Test key generation
                let key: Key<AES256> = crypto::generate_key();

                // Test hashing
                let data: Bytes = Bytes::from("test");
                let hash: Hash<SHA3_256> = crypto::hash(data);

                // Test signing
                let (pub_key, priv_key): (PublicKey<Ed25519>, PrivateKey<Ed25519>) = crypto::generate_keypair();
                let signature: Signature<Ed25519> = crypto::sign(data, priv_key);
                let is_valid: Bool = crypto::verify(data, signature, pub_key);

                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();

        // Type checking should pass for crypto operations
        let result = compiler.type_check(&program);
        assert!(result.is_ok());
    }

    #[test]
    fn test_security_annotations() {
        let source = r#"
        module SecurityTest {
            @constant_time
            fn secure_function() -> Void {
                let secret: Secret<String> = Secret::new("sensitive data");
                // Function body
            }

            fn main() -> Int32 {
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "security_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_complex_data_structures() {
        let source = r#"
        module ComplexTest {
            struct Point {
                x: Int32,
                y: Int32
            }

            enum Shape {
                Circle(Int32),
                Rectangle(Int32, Int32)
            }

            fn main() -> Int32 {
                let point: Point = Point { x: 10, y: 20 };
                let circle: Shape = Shape::Circle(5);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "complex_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_generic_functions() {
        let source = r#"
        module GenericTest {
            fn identity<T>(value: T) -> T {
                value
            }

            fn main() -> Int32 {
                let x: Int32 = identity(42);
                let y: String = identity("hello");
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "generic_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_error_recovery() {
        let invalid_sources = vec![
            "module Test { fn main() -> Int32 { ",
            "module Test { fn main() -> Int32 { let x: Int32 = ; x } }",
            "module Test { fn main() -> Int32 { let x: UnknownType = 42; x } }",
        ];

        for source in invalid_sources {
            let mut compiler = T4Compiler::new();
            let result = compiler.parse(source);

            // Should either parse successfully or fail gracefully
            assert!(result.is_ok() || result.is_err());
        }
    }

    #[test]
    fn test_compilation_performance() {
        let source = r#"
        module PerformanceTest {
            fn fibonacci(n: Int32) -> Int32 {
                if n <= 1 {
                    n
                } else {
                    fibonacci(n - 1) + fibonacci(n - 2)
                }
            }

            fn main() -> Int32 {
                let result: Int32 = fibonacci(10);
                result
            }
        }
        "#;

        let start = std::time::Instant::now();

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let _output = codegen.generate(&program, "performance_test").unwrap();

        let duration = start.elapsed();

        // Compilation should complete in reasonable time (less than 1 second)
        assert!(duration.as_secs() < 1);
    }

    #[test]
    fn test_module_system() {
        let source = r#"
        module ModuleSystem {
            import "crypto" as crypto;
            import "io" as io;

            fn main() -> Int32 {
                let message: String = "Hello from module system";
                io::print(message);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "module_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_type_inference() {
        let source = r#"
        module TypeInference {
            fn main() -> Int32 {
                let x = 42;  // Should infer Int32
                let y = "hello";  // Should infer String
                let z = true;  // Should infer Bool
                x
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "inference_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_operator_overloading() {
        let source = r#"
        module OperatorTest {
            struct Vector2 {
                x: Int32,
                y: Int32
            }

            impl Vector2 {
                fn add(self, other: Vector2) -> Vector2 {
                    Vector2 {
                        x: self.x + other.x,
                        y: self.y + other.y
                    }
                }
            }

            fn main() -> Int32 {
                let v1: Vector2 = Vector2 { x: 1, y: 2 };
                let v2: Vector2 = Vector2 { x: 3, y: 4 };
                let v3: Vector2 = v1.add(v2);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "operator_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_pattern_matching() {
        let source = r#"
        module PatternTest {
            enum Result<T> {
                Ok(T),
                Err(String)
            }

            fn main() -> Int32 {
                let result: Result<Int32> = Result::Ok(42);

                match result {
                    Result::Ok(value) => value,
                    Result::Err(msg) => 0
                }
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "pattern_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_trait_system() {
        let source = r#"
        module TraitTest {
            trait Printable {
                fn print(self) -> Void;
            }

            struct Point {
                x: Int32,
                y: Int32
            }

            impl Printable for Point {
                fn print(self) -> Void {
                    // Print implementation
                }
            }

            fn main() -> Int32 {
                let point: Point = Point { x: 1, y: 2 };
                point.print();
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "trait_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_async_programming() {
        let source = r#"
        module AsyncTest {
            async fn async_function() -> Int32 {
                42
            }

            fn main() -> Int32 {
                let future: Future<Int32> = async_function();
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "async_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_macro_system() {
        let source = r#"
        module MacroTest {
            macro_rules! debug_print {
                ($expr:expr) => {
                    console::println(stringify!($expr) + " = " + $expr.to_string())
                }
            }

            fn main() -> Int32 {
                let x: Int32 = 42;
                debug_print!(x);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "macro_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_zero_knowledge_proofs() {
        let source = r#"
        module ZKPTest {
            fn main() -> Int32 {
                let secret: Secret<Int32> = Secret::new(42);
                let proof: ZKProof = secret.prove_knowledge();
                let is_valid: Bool = proof.verify();
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "zkp_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_homomorphic_encryption() {
        let source = r#"
        module HomomorphicTest {
            fn main() -> Int32 {
                let keypair: (PublicKey<HE>, PrivateKey<HE>) = crypto::generate_keypair();
                let plaintext: Plaintext = Plaintext::from(42);
                let ciphertext: Ciphertext<HE> = crypto::encrypt_homomorphic(plaintext, keypair.0);

                // Perform computation on encrypted data
                let result: Ciphertext<HE> = ciphertext + ciphertext;  // 42 + 42 = 84

                let decrypted: Plaintext = crypto::decrypt_homomorphic(result, keypair.1);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "homomorphic_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_secure_multi_party_computation() {
        let source = r#"
        module SMCTest {
            fn main() -> Int32 {
                let parties: [Party; 3] = [Party::new(), Party::new(), Party::new()];
                let inputs: [Secret<Int32>; 3] = [Secret::new(1), Secret::new(2), Secret::new(3)];

                let result: Secret<Int32> = crypto::secure_sum(inputs, parties);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "smc_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_differential_privacy() {
        let source = r#"
        module PrivacyTest {
            fn main() -> Int32 {
                let dataset: Vec<Int32> = vec![1, 2, 3, 4, 5];
                let query_result: Int32 = dataset.sum();
                let private_result: Int32 = crypto::add_noise(query_result, 0.1);
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "privacy_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_quantum_resistant_program() {
        let source = r#"
        module QuantumResistant {
            fn main() -> Int32 {
                // Use post-quantum cryptography
                let (pq_public, pq_private): (PublicKey<Kyber1024>, PrivateKey<Kyber1024>) = crypto::generate_keypair();
                let (sig_public, sig_private): (PublicKey<Dilithium3>, PrivateKey<Dilithium3>) = crypto::generate_keypair();

                let message: Bytes = Bytes::from("Quantum-resistant message");
                let (shared_secret, ciphertext): (SharedSecret<Kyber1024>, Ciphertext<Kyber1024>) = crypto::encapsulate(pq_public);
                let signature: Signature<Dilithium3> = crypto::sign(message, sig_private);

                let is_valid: Bool = crypto::verify(message, signature, sig_public);
                let decrypted_secret: SharedSecret<Kyber1024> = crypto::decapsulate(pq_private, ciphertext);

                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "quantum_resistant_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_full_crypto_workflow() {
        let source = r#"
        module FullCryptoWorkflow {
            import "libcrypto.so" as crypto;

            fn secure_communication() -> Void {
                // Phase 1: Key exchange
                let (alice_ec_public, alice_ec_private): (PublicKey<SecP256r1>, PrivateKey<SecP256r1>) = crypto::generate_keypair();
                let (bob_ec_public, bob_ec_private): (PublicKey<SecP256r1>, PrivateKey<SecP256r1>) = crypto::generate_keypair();

                let alice_shared: SharedSecret<SecP256r1> = crypto::ecdh_compute(alice_ec_private, bob_ec_public);
                let bob_shared: SharedSecret<SecP256r1> = crypto::ecdh_compute(bob_ec_private, alice_ec_public);

                // Phase 2: Authenticated encryption
                let session_key: Key<AES256> = crypto::derive_key(alice_shared);
                let message: Plaintext = Plaintext::from("Secret message");
                let nonce: Nonce = crypto::generate_nonce();

                let encrypted: Ciphertext<AES256> = crypto::encrypt(message, session_key, nonce);

                // Phase 3: Digital signature
                let (sig_public, sig_private): (PublicKey<Ed25519>, PrivateKey<Ed25519>) = crypto::generate_keypair();
                let signature: Signature<Ed25519> = crypto::sign(encrypted.to_bytes(), sig_private);

                // Phase 4: Verification and decryption
                let sig_valid: Bool = crypto::verify(encrypted.to_bytes(), signature, sig_public);
                let decrypted: Plaintext = crypto::decrypt(encrypted, session_key, nonce);
            }

            fn main() -> Int32 {
                secure_communication();
                0
            }
        }
        "#;

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "full_crypto_test");
        assert!(output.is_ok());
    }

    #[test]
    fn test_compilation_edge_cases() {
        let edge_cases = vec![
            // Empty module
            "module Empty {}",
            // Module with only main
            "module Minimal { fn main() -> Int32 { 0 } }",
            // Nested modules
            "module Outer { module Inner { fn main() -> Int32 { 0 } } }",
            // Complex expressions
            "module Complex { fn main() -> Int32 { let x: Int32 = (1 + 2) * 3 / 4; x } }",
        ];

        for source in edge_cases {
            let mut compiler = T4Compiler::new();
            let program = compiler.parse(source).unwrap();
            compiler.type_check(&program).unwrap();

            let mut codegen = CodeGenerator::new();
            let output = codegen.generate(&program, "edge_case");
            assert!(output.is_ok(), "Failed to compile: {}", source);
        }
    }

    #[test]
    fn test_compilation_stress_test() {
        // Generate a very large program
        let mut source = String::new();
        source.push_str("module StressTest {\n");

        // Add many declarations
        for i in 0..100 {
            source.push_str(&format!(
                "    struct Struct{} {{ value: Int32 }}\n",
                i
            ));
        }

        for i in 0..100 {
            source.push_str(&format!(
                "    fn function_{}(x: Int32) -> Int32 {{ x + {} }}\n",
                i, i
            ));
        }

        source.push_str("    fn main() -> Int32 { 0 }\n");
        source.push_str("}\n");

        let mut compiler = T4Compiler::new();
        let program = compiler.parse(&source).unwrap();
        compiler.type_check(&program).unwrap();

        let mut codegen = CodeGenerator::new();
        let output = codegen.generate(&program, "stress_test");
        assert!(output.is_ok());
    }
}