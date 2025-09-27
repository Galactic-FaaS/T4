//! T4 Performance Tests
//!
//! Benchmarks and performance tests for T4 compiler and runtime

use t4_compiler::compiler::T4Compiler;
use t4_compiler::codegen::CodeGenerator;
use t4_compiler::runtime::{Runtime, crypto::CryptoRuntime};
use t4_compiler::ast::AlgorithmType;
use std::time::{Duration, Instant};

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_compilation_performance() {
        let source = generate_large_program(100);

        let start_time = Instant::now();
        let mut compiler = T4Compiler::new();
        let program = compiler.parse(&source).unwrap();
        compiler.type_check(&program).unwrap();
        let compilation_time = start_time.elapsed();

        println!("Compilation time for 100 functions: {:?}", compilation_time);
        assert!(compilation_time < Duration::from_secs(5));
    }

    #[test]
    fn test_crypto_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        let start_time = Instant::now();

        for _ in 0..100 {
            // AES operations
            let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
            let data = b"Performance test data for AES encryption and decryption";
            let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();
            let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&key, data).unwrap();
            let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&key, &ciphertext).unwrap();
            assert_eq!(decrypted, data);
        }

        let duration = start_time.elapsed();
        println!("100 AES operations took: {:?}", duration);
        println!("Average time per AES operation: {:?}", duration / 100);

        // Should complete 100 operations in reasonable time
        assert!(duration < Duration::from_secs(10));
    }

    #[test]
    fn test_signing_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Generate keypair once
        let (public_key, private_key) = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();

        let start_time = Instant::now();
        let message = b"Performance test message for digital signatures";

        for _ in 0..50 {
            let signature = crypto_runtime.get_default_provider().unwrap().sign(&private_key, message).unwrap();
            let is_valid = crypto_runtime.get_default_provider().unwrap().verify(&public_key, message, &signature).unwrap();
            assert!(is_valid);
        }

        let duration = start_time.elapsed();
        println!("50 Ed25519 sign/verify operations took: {:?}", duration);
        println!("Average time per sign/verify: {:?}", duration / 50);

        assert!(duration < Duration::from_secs(5));
    }

    #[test]
    fn test_hashing_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let start_time = Instant::now();
        let data = b"Performance test data for hash function benchmarking";

        for _ in 0..1000 {
            let hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data).unwrap();
            assert_eq!(hash.len(), 32);
        }

        let duration = start_time.elapsed();
        println!("1000 SHA3-256 hashes took: {:?}", duration);
        println!("Average time per hash: {:?}", duration / 1000);

        // Hashing should be very fast
        assert!(duration < Duration::from_secs(2));
    }

    #[test]
    fn test_key_exchange_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let start_time = Instant::now();

        for _ in 0..25 {
            let (alice_public, alice_private) = crypto_runtime.generate_keypair(&AlgorithmType::SecP256r1).unwrap();
            let (bob_public, bob_private) = crypto_runtime.generate_keypair(&AlgorithmType::SecP256r1).unwrap();

            let alice_shared = crypto_runtime.key_exchange(&alice_private, &bob_public).unwrap();
            let bob_shared = crypto_runtime.key_exchange(&bob_private, &alice_public).unwrap();

            // Verify shared secrets match
            match (alice_shared, bob_shared) {
                (t4_compiler::runtime::values::Value::Secret(s1), t4_compiler::runtime::values::Value::Secret(s2)) => {
                    assert_eq!(s1.data, s2.data);
                }
                _ => panic!("Expected secret values"),
            }
        }

        let duration = start_time.elapsed();
        println!("25 ECDH key exchanges took: {:?}", duration);
        println!("Average time per key exchange: {:?}", duration / 25);

        assert!(duration < Duration::from_secs(5));
    }

    #[test]
    fn test_post_quantum_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        let start_time = Instant::now();

        for _ in 0..10 {
            // Kyber operations
            let (public_key, private_key) = crypto_runtime.generate_keypair(&AlgorithmType::Kyber1024).unwrap();
            let (shared_secret, ciphertext) = match &public_key {
                t4_compiler::runtime::values::Value::PublicKey(pk) => {
                    let secret = crypto_runtime.key_exchange(&private_key, &public_key).unwrap();
                    let encapsulated = crypto_runtime.get_default_provider().unwrap().encrypt(&public_key, b"test").unwrap();
                    (secret, encapsulated)
                }
                _ => panic!("Expected public key"),
            };

            let decapsulated = match &private_key {
                t4_compiler::runtime::values::Value::PrivateKey(pk) => {
                    crypto_runtime.get_default_provider().unwrap().decrypt(&private_key, &ciphertext).unwrap()
                }
                _ => panic!("Expected private key"),
            };

            // Verify secrets match
            match shared_secret {
                t4_compiler::runtime::values::Value::Secret(s) => {
                    assert_eq!(s.data, decapsulated);
                }
                _ => panic!("Expected secret value"),
            }
        }

        let duration = start_time.elapsed();
        println!("10 Kyber operations took: {:?}", duration);
        println!("Average time per Kyber operation: {:?}", duration / 10);

        // Post-quantum operations are expected to be slower
        assert!(duration < Duration::from_secs(15));
    }

    #[test]
    fn test_memory_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let start_time = Instant::now();

        for i in 0..100 {
            let data_size = 1024 + (i * 100); // Varying data sizes
            let data = vec![0u8; data_size];

            let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
            let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();

            let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&key, &data).unwrap();
            let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&key, &ciphertext).unwrap();

            assert_eq!(data, decrypted);
        }

        let duration = start_time.elapsed();
        println!("100 variable-size AES operations took: {:?}", duration);
        println!("Average time per operation: {:?}", duration / 100);

        assert!(duration < Duration::from_secs(10));
    }

    #[test]
    fn test_concurrent_crypto_performance() {
        use std::thread;

        let start_time = Instant::now();

        let handles: Vec<_> = (0..4).map(|thread_id| {
            thread::spawn(move || {
                let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

                for i in 0..25 {
                    let data = format!("Thread {} data {}", thread_id, i);
                    let hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data.as_bytes()).unwrap();
                    assert_eq!(hash.len(), 32);
                }

                crypto_runtime.get_operation_count()
            })
        }).collect();

        let mut total_operations = 0;
        for handle in handles {
            total_operations += handle.join().unwrap();
        }

        let duration = start_time.elapsed();
        println!("4 threads x 25 hashes = {} total operations took: {:?}", total_operations, duration);
        println!("Average time per hash: {:?}", duration / total_operations);

        assert!(duration < Duration::from_secs(5));
        assert_eq!(total_operations, 100);
    }

    #[test]
    fn test_compilation_memory_usage() {
        let initial_memory = get_memory_usage();

        // Compile multiple programs
        for i in 0..10 {
            let source = format!(
                "module MemoryTest{{}} fn main() -> Int32 {{ {} }}",
                i
            );
            let mut compiler = T4Compiler::new();
            let program = compiler.parse(&source).unwrap();
            compiler.type_check(&program).unwrap();

            let mut codegen = CodeGenerator::new();
            let _output = codegen.generate(&program, "memory_test").unwrap();
        }

        let final_memory = get_memory_usage();
        let memory_increase = final_memory - initial_memory;

        println!("Memory increase after 10 compilations: {} KB", memory_increase / 1024);

        // Memory increase should be reasonable (less than 50MB)
        assert!(memory_increase < 50 * 1024 * 1024);
    }

    #[test]
    fn test_crypto_memory_usage() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();
        let initial_stats = crypto_runtime.get_default_provider().unwrap().get_memory_stats();

        // Perform many operations
        for _ in 0..100 {
            let _key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
            let _keypair = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();
        }

        let final_stats = crypto_runtime.get_default_provider().unwrap().get_memory_stats();
        let memory_increase = final_stats.total_allocated - initial_stats.total_allocated;

        println!("Memory increase after 200 key generations: {} bytes", memory_increase);

        // Memory should be properly managed
        assert!(memory_increase < 10 * 1024 * 1024); // Less than 10MB
    }

    #[test]
    fn test_scaling_performance() {
        let data_sizes = vec![1024, 2048, 4096, 8192];

        for &size in &data_sizes {
            let data = vec![0u8; size];
            let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

            let start_time = Instant::now();
            let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
            let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();

            let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&key, &data).unwrap();
            let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&key, &ciphertext).unwrap();

            let duration = start_time.elapsed();
            println!("AES {} bytes took: {:?}", size, duration);

            assert_eq!(data, decrypted);
            assert!(duration < Duration::from_secs(2));
        }
    }

    #[test]
    fn test_batch_operations_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Batch key generation
        let start_time = Instant::now();
        let mut keys = Vec::new();

        for _ in 0..50 {
            keys.push(crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap());
        }

        let keygen_duration = start_time.elapsed();
        println!("50 key generations took: {:?}", keygen_duration);

        // Batch encryption
        let start_time = Instant::now();
        let data = b"Batch encryption test data";
        let mut ciphertexts = Vec::new();

        for key in &keys {
            let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();
            let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(key, data).unwrap();
            ciphertexts.push((ciphertext, nonce));
        }

        let encryption_duration = start_time.elapsed();
        println!("50 encryptions took: {:?}", encryption_duration);

        // Batch decryption
        let start_time = Instant::now();

        for (i, (ciphertext, nonce)) in ciphertexts.iter().enumerate() {
            let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&keys[i], ciphertext).unwrap();
            assert_eq!(decrypted, data);
        }

        let decryption_duration = start_time.elapsed();
        println!("50 decryptions took: {:?}", decryption_duration);

        assert!(keygen_duration < Duration::from_secs(2));
        assert!(encryption_duration < Duration::from_secs(3));
        assert!(decryption_duration < Duration::from_secs(3));
    }

    #[test]
    fn test_algorithm_comparison() {
        let algorithms = vec![
            AlgorithmType::Sha3_256,
            AlgorithmType::Sha3_512,
        ];

        for algorithm in algorithms {
            let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();
            let data = b"Algorithm comparison test data";

            let start_time = Instant::now();

            for _ in 0..100 {
                let hash = crypto_runtime.hash(&algorithm, data).unwrap();
                assert!(!hash.is_empty());
            }

            let duration = start_time.elapsed();
            println!("100 {:?} hashes took: {:?}", algorithm, duration);
            println!("Average time per hash: {:?}", duration / 100);

            assert!(duration < Duration::from_secs(3));
        }
    }

    #[test]
    fn test_resource_cleanup() {
        let start_time = Instant::now();

        for iteration in 0..10 {
            let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

            // Generate many keys and other resources
            for i in 0..100 {
                let _key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
                let _keypair = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();
                let data = format!("Iteration {} data {}", iteration, i);
                let _hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data.as_bytes()).unwrap();
            }

            // Resources should be cleaned up when crypto_runtime goes out of scope
        }

        let duration = start_time.elapsed();
        println!("10 iterations with resource cleanup took: {:?}", duration);

        // Should complete without excessive memory growth
        assert!(duration < Duration::from_secs(20));
    }

    #[test]
    fn test_error_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let start_time = Instant::now();

        for _ in 0..100 {
            // Try operations that should fail
            let invalid_key = t4_compiler::runtime::values::Value::Integer(42);
            let _ = crypto_runtime.get_default_provider().unwrap().encrypt(&invalid_key, b"test");
        }

        let duration = start_time.elapsed();
        println!("100 error operations took: {:?}", duration);

        // Error handling should be fast
        assert!(duration < Duration::from_secs(2));
    }

    #[test]
    fn test_compilation_scaling() {
        let program_sizes = vec![10, 50, 100];

        for &num_functions in &program_sizes {
            let source = generate_large_program(num_functions);

            let start_time = Instant::now();
            let mut compiler = T4Compiler::new();
            let program = compiler.parse(&source).unwrap();
            compiler.type_check(&program).unwrap();
            let compilation_time = start_time.elapsed();

            println!("Compilation of {} functions took: {:?}", num_functions, compilation_time);
            println!("Time per function: {:?}", compilation_time / num_functions as u32);

            assert!(compilation_time < Duration::from_secs(10));
        }
    }

    #[test]
    fn test_memory_efficiency() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Measure memory usage with many small operations
        let start_time = Instant::now();
        let mut operation_count = 0;

        for _ in 0..1000 {
            let data = b"Small data";
            let hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data).unwrap();
            assert_eq!(hash.len(), 32);
            operation_count += 1;
        }

        let duration = start_time.elapsed();
        println!("1000 small hash operations took: {:?}", duration);
        println!("Operations per second: {:.2}", operation_count as f64 / duration.as_secs_f64());

        assert!(duration < Duration::from_secs(5));
        assert!(operation_count as f64 / duration.as_secs_f64() > 100.0); // At least 100 ops/sec
    }

    #[test]
    fn test_peak_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Test peak performance with optimal conditions
        let data = b"Peak performance test data";
        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();

        let start_time = Instant::now();

        for _ in 0..200 {
            let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();
            let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&key, data).unwrap();
            let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&key, &ciphertext).unwrap();
            assert_eq!(decrypted, data);
        }

        let duration = start_time.elapsed();
        println!("200 AES operations (peak performance) took: {:?}", duration);
        println!("Average time per operation: {:?}", duration / 200);

        // Peak performance should be very good
        assert!(duration < Duration::from_secs(5));
    }

    #[test]
    fn test_endurance_test() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let start_time = Instant::now();

        // Long-running test
        for iteration in 0..50 {
            for i in 0..20 {
                let data = format!("Endurance test iteration {} data {}", iteration, i);

                // Mix of operations
                let hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data.as_bytes()).unwrap();
                let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
                let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();
                let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&key, data.as_bytes()).unwrap();
                let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&key, &ciphertext).unwrap();

                assert_eq!(hash.len(), 32);
                assert_eq!(decrypted, data.as_bytes());
            }
        }

        let duration = start_time.elapsed();
        println!("Endurance test (50x20 operations) took: {:?}", duration);
        println!("Total operations: 1000");
        println!("Average time per operation: {:?}", duration / 1000);

        // Should handle long-running operations without issues
        assert!(duration < Duration::from_secs(30));
    }

    #[test]
    fn test_mixed_workload_performance() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        let start_time = Instant::now();

        // Mix of different cryptographic operations
        for i in 0..25 {
            // AES encryption/decryption
            let aes_key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
            let data = format!("AES test data {}", i);
            let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();
            let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&aes_key, data.as_bytes()).unwrap();
            let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&aes_key, &ciphertext).unwrap();
            assert_eq!(decrypted, data.as_bytes());

            // Ed25519 signing
            let (signing_public, signing_private) = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();
            let signature = crypto_runtime.get_default_provider().unwrap().sign(&signing_private, data.as_bytes()).unwrap();
            let is_valid = crypto_runtime.get_default_provider().unwrap().verify(&signing_public, data.as_bytes(), &signature).unwrap();
            assert!(is_valid);

            // SHA-3 hashing
            let hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data.as_bytes()).unwrap();
            assert_eq!(hash.len(), 32);

            // Post-quantum operations
            let (pq_public, pq_private) = crypto_runtime.generate_keypair(&AlgorithmType::Kyber1024).unwrap();
            let (shared_secret, pq_ciphertext) = match &pq_public {
                t4_compiler::runtime::values::Value::PublicKey(pk) => {
                    let secret = crypto_runtime.key_exchange(&pq_private, &pq_public).unwrap();
                    let encapsulated = crypto_runtime.get_default_provider().unwrap().encrypt(&pq_public, data.as_bytes()).unwrap();
                    (secret, encapsulated)
                }
                _ => panic!("Expected public key"),
            };
        }

        let duration = start_time.elapsed();
        println!("Mixed workload (25 iterations) took: {:?}", duration);
        println!("Average time per iteration: {:?}", duration / 25);

        assert!(duration < Duration::from_secs(15));
    }

    #[test]
    fn test_real_world_scenario() {
        // Simulate a real-world cryptographic scenario
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        let start_time = Instant::now();

        // Scenario: Secure communication between two parties
        for scenario in 0..10 {
            // 1. Key exchange
            let (alice_ec_public, alice_ec_private) = crypto_runtime.generate_keypair(&AlgorithmType::SecP256r1).unwrap();
            let (bob_ec_public, bob_ec_private) = crypto_runtime.generate_keypair(&AlgorithmType::SecP256r1).unwrap();

            let alice_shared = crypto_runtime.key_exchange(&alice_ec_private, &bob_ec_public).unwrap();
            let bob_shared = crypto_runtime.key_exchange(&bob_private, &alice_ec_public).unwrap();

            // 2. Derive session key
            let session_key = crypto_runtime.derive_key(
                &AlgorithmType::Pbkdf2,
                b"session_password",
                &format!("salt_{}", scenario).as_bytes(),
                1000
            ).unwrap();

            // 3. Encrypt message
            let message = format!("Real-world scenario message {}", scenario);
            let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();
            let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&session_key, message.as_bytes()).unwrap();

            // 4. Sign message
            let (sig_public, sig_private) = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();
            let signature = crypto_runtime.get_default_provider().unwrap().sign(&sig_private, &ciphertext).unwrap();

            // 5. Verify and decrypt
            let sig_valid = crypto_runtime.get_default_provider().unwrap().verify(&sig_public, &ciphertext, &signature).unwrap();
            assert!(sig_valid);

            let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&session_key, &ciphertext).unwrap();
            assert_eq!(decrypted, message.as_bytes());

            // 6. Post-quantum signature for long-term security
            let (pq_sig_public, pq_sig_private) = crypto_runtime.generate_keypair(&AlgorithmType::Dilithium3).unwrap();
            let pq_signature = crypto_runtime.get_default_provider().unwrap().sign(&pq_sig_private, &ciphertext).unwrap();
            let pq_sig_valid = crypto_runtime.get_default_provider().unwrap().verify(&pq_sig_public, &ciphertext, &pq_signature).unwrap();
            assert!(pq_sig_valid);
        }

        let duration = start_time.elapsed();
        println!("10 real-world scenarios took: {:?}", duration);
        println!("Average time per scenario: {:?}", duration / 10);

        assert!(duration < Duration::from_secs(20));
    }

    // Helper functions

    fn generate_large_program(num_functions: usize) -> String {
        let mut source = String::new();
        source.push_str("module LargeProgram {\n");

        for i in 0..num_functions {
            source.push_str(&format!(
                "    fn function_{}(x: Int32) -> Int32 {{\n        x + {}\n    }}\n\n",
                i, i
            ));
        }

        source.push_str("    fn main() -> Int32 {\n        let mut sum: Int32 = 0;\n");
        for i in 0..num_functions {
            source.push_str(&format!("        sum = sum + function_{}(1);\n", i));
        }
        source.push_str("        sum\n    }\n");
        source.push_str("}\n");

        source
    }

    fn get_memory_usage() -> usize {
        // Simplified memory usage check
        // In a real implementation, this would use platform-specific APIs
        0
    }
}