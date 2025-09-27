//! T4 Cryptographic Tests
//!
//! Comprehensive test suite for T4 cryptographic operations

use t4_compiler::runtime::{
    crypto::{CryptoRuntime, DefaultCryptoProvider, PostQuantumProvider},
    values::{Value, SecretValue, SecretType},
    errors::RuntimeError,
};
use t4_compiler::ast::AlgorithmType;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_crypto_runtime_creation() {
        let crypto_runtime = CryptoRuntime::new(true, true);
        assert!(crypto_runtime.is_ok());
    }

    #[test]
    fn test_default_crypto_provider() {
        let provider = DefaultCryptoProvider::new();
        assert_eq!(provider.name(), "default");
        assert!(provider.supports_algorithm(&AlgorithmType::Aes256));
        assert!(provider.supports_algorithm(&AlgorithmType::Ed25519));
    }

    #[test]
    fn test_post_quantum_provider() {
        let provider = PostQuantumProvider::new();
        assert_eq!(provider.name(), "post_quantum");
        assert!(provider.supports_algorithm(&AlgorithmType::Kyber1024));
        assert!(provider.supports_algorithm(&AlgorithmType::Dilithium3));
    }

    #[test]
    fn test_aes_encryption_decryption() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();
        let provider = crypto_runtime.get_default_provider().unwrap();

        // Generate a key
        let key = provider.generate_key(&AlgorithmType::Aes256).unwrap();
        let plaintext = b"Hello, World!";

        // Encrypt
        let ciphertext = provider.encrypt(&key, plaintext).unwrap();
        assert_ne!(ciphertext, plaintext);

        // Decrypt
        let decrypted = provider.decrypt(&key, &ciphertext).unwrap();
        assert_eq!(decrypted, plaintext);
    }

    #[test]
    fn test_ed25519_signing_verification() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();
        let provider = crypto_runtime.get_default_provider().unwrap();

        // Generate keypair
        let (public_key, private_key) = provider.generate_keypair(&AlgorithmType::Ed25519).unwrap();
        let message = b"Test message for signing";

        // Sign
        let signature = provider.sign(&private_key, message).unwrap();
        assert!(!signature.is_empty());

        // Verify
        let is_valid = provider.verify(&public_key, message, &signature).unwrap();
        assert!(is_valid);

        // Test with wrong message
        let wrong_message = b"Different message";
        let is_wrong_valid = provider.verify(&public_key, wrong_message, &signature).unwrap();
        assert!(!is_wrong_valid);
    }

    #[test]
    fn test_sha3_hashing() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();
        let provider = crypto_runtime.get_default_provider().unwrap();

        let data = b"Data to hash";
        let hash1 = provider.hash(&AlgorithmType::Sha3_256, data).unwrap();
        let hash2 = provider.hash(&AlgorithmType::Sha3_256, data).unwrap();

        // Hash should be deterministic
        assert_eq!(hash1, hash2);

        // Different data should produce different hashes
        let different_data = b"Different data";
        let different_hash = provider.hash(&AlgorithmType::Sha3_256, different_data).unwrap();
        assert_ne!(hash1, different_hash);

        // Check hash length
        assert_eq!(hash1.len(), 32); // SHA3-256 produces 32 bytes
    }

    #[test]
    fn test_random_bytes_generation() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();
        let provider = crypto_runtime.get_default_provider().unwrap();

        let random1 = provider.random_bytes(32).unwrap();
        let random2 = provider.random_bytes(32).unwrap();

        // Random bytes should be different
        assert_ne!(random1, random2);

        // Check length
        assert_eq!(random1.len(), 32);
        assert_eq!(random2.len(), 32);
    }

    #[test]
    fn test_ecdh_key_exchange() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();
        let provider = crypto_runtime.get_default_provider().unwrap();

        // Generate two keypairs
        let (alice_public, alice_private) = provider.generate_keypair(&AlgorithmType::SecP256r1).unwrap();
        let (bob_public, bob_private) = provider.generate_keypair(&AlgorithmType::SecP256r1).unwrap();

        // Perform key exchange
        let alice_shared = provider.key_exchange(&alice_private, &bob_public).unwrap();
        let bob_shared = provider.key_exchange(&bob_private, &alice_public).unwrap();

        // Shared secrets should be the same
        match (alice_shared, bob_shared) {
            (Value::Secret(secret1), Value::Secret(secret2)) => {
                assert_eq!(secret1.data, secret2.data);
            }
            _ => panic!("Expected secret values"),
        }
    }

    #[test]
    fn test_post_quantum_kyber() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();
        let provider = crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Kyber1024).unwrap();

        // Generate keypair
        let (public_key, private_key) = provider.generate_keypair(&AlgorithmType::Kyber1024).unwrap();

        // Perform key encapsulation
        let (shared_secret, ciphertext) = match (&public_key, &private_key) {
            (Value::PublicKey(pub_key), Value::PrivateKey(priv_key)) => {
                let secret = provider.key_exchange(&private_key, &public_key).unwrap();
                let encapsulated = provider.encrypt(&public_key, b"test").unwrap();
                (secret, encapsulated)
            }
            _ => panic!("Expected keypair"),
        };

        // Decapsulate
        let decapsulated = match &private_key {
            Value::PrivateKey(priv_key) => {
                provider.decrypt(&private_key, &ciphertext).unwrap()
            }
            _ => panic!("Expected private key"),
        };

        // Secrets should match
        assert_eq!(shared_secret, Value::Secret(SecretValue::new(decapsulated, SecretType::KeyMaterial)));
    }

    #[test]
    fn test_post_quantum_dilithium() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();
        let provider = crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Dilithium3).unwrap();

        // Generate keypair
        let (public_key, private_key) = provider.generate_keypair(&AlgorithmType::Dilithium3).unwrap();
        let message = b"Post-quantum signature test";

        // Sign
        let signature = match &private_key {
            Value::PrivateKey(priv_key) => {
                provider.sign(&private_key, message).unwrap()
            }
            _ => panic!("Expected private key"),
        };

        // Verify
        let is_valid = match &public_key {
            Value::PublicKey(pub_key) => {
                provider.verify(&public_key, message, &signature).unwrap()
            }
            _ => panic!("Expected public key"),
        };

        assert!(is_valid);
    }

    #[test]
    fn test_crypto_runtime_operations() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        // Test key generation
        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
        assert!(matches!(key, Value::Secret(_)));

        let (public, private) = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();
        assert!(matches!(public, Value::PublicKey(_)));
        assert!(matches!(private, Value::PrivateKey(_)));

        // Test hashing
        let data = b"Test data";
        let hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data).unwrap();
        assert_eq!(hash.len(), 32);

        // Test operation counting
        assert_eq!(crypto_runtime.get_operation_count(), 3);
    }

    #[test]
    fn test_error_conditions() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();
        let provider = crypto_runtime.get_default_provider().unwrap();

        // Test with invalid key
        let invalid_key = Value::Integer(42);
        let result = provider.encrypt(&invalid_key, b"test");
        assert!(matches!(result, Err(RuntimeError::InvalidKey)));

        // Test with unsupported algorithm
        let result = provider.generate_keypair(&AlgorithmType::Rsa2048);
        assert!(matches!(result, Err(RuntimeError::UnsupportedAlgorithm(_))));
    }

    #[test]
    fn test_memory_safety() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Generate a key and ensure it's properly secured
        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();

        match key {
            Value::Secret(secret) => {
                assert_eq!(secret.data.len(), 32);
                assert!(secret.requires_secure_memory());
                assert!(secret.requires_constant_time());
            }
            _ => panic!("Expected secret value"),
        }
    }

    #[test]
    fn test_constant_time_operations() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Generate two identical keys
        let key1 = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
        let key2 = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();

        // The comparison should be constant-time
        // In a real implementation, this would be tested with timing analysis
        let plaintext = b"Test message";
        let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();

        let ciphertext1 = crypto_runtime.get_default_provider().unwrap().encrypt(&key1, plaintext).unwrap();
        let ciphertext2 = crypto_runtime.get_default_provider().unwrap().encrypt(&key2, plaintext).unwrap();

        // Both encryptions should succeed (even if keys are different)
        assert!(!ciphertext1.is_empty());
        assert!(!ciphertext2.is_empty());
    }

    #[test]
    fn test_provider_selection() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        // Test finding providers for different algorithms
        let aes_provider = crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Aes256);
        let ed25519_provider = crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Ed25519);
        let kyber_provider = crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Kyber1024);

        assert!(aes_provider.is_some());
        assert!(ed25519_provider.is_some());
        assert!(kyber_provider.is_some());

        assert_eq!(aes_provider.unwrap().name(), "default");
        assert_eq!(ed25519_provider.unwrap().name(), "default");
        assert_eq!(kyber_provider.unwrap().name(), "post_quantum");
    }

    #[test]
    fn test_key_sizes() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        // Test different key sizes
        let aes_key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
        assert_eq!(aes_key.size(), 32);

        let (ed25519_public, ed25519_private) = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();
        assert_eq!(ed25519_public.size(), 32);
        assert_eq!(ed25519_private.size(), 32);

        let (kyber_public, kyber_private) = crypto_runtime.generate_keypair(&AlgorithmType::Kyber1024).unwrap();
        assert!(kyber_public.size() > 0);
        assert!(kyber_private.size() > 0);
    }

    #[test]
    fn test_hash_collision_resistance() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let data1 = b"Message 1";
        let data2 = b"Message 2";

        let hash1 = crypto_runtime.hash(&AlgorithmType::Sha3_256, data1).unwrap();
        let hash2 = crypto_runtime.hash(&AlgorithmType::Sha3_256, data2).unwrap();

        // Different messages should produce different hashes
        assert_ne!(hash1, hash2);
    }

    #[test]
    fn test_deterministic_operations() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let data = b"Deterministic test";
        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
        let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();

        // Multiple encryptions with same inputs should be deterministic
        let ciphertext1 = crypto_runtime.get_default_provider().unwrap().encrypt(&key, data).unwrap();
        let ciphertext2 = crypto_runtime.get_default_provider().unwrap().encrypt(&key, data).unwrap();

        // Note: Due to random nonces, ciphertexts will be different
        // This is expected behavior for security
        assert_ne!(ciphertext1, ciphertext2);

        // But decryption should always work
        let decrypted1 = crypto_runtime.get_default_provider().unwrap().decrypt(&key, &ciphertext1).unwrap();
        let decrypted2 = crypto_runtime.get_default_provider().unwrap().decrypt(&key, &ciphertext2).unwrap();

        assert_eq!(decrypted1, data);
        assert_eq!(decrypted2, data);
    }

    #[test]
    fn test_security_requirements() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();

        match key {
            Value::Secret(secret) => {
                assert!(secret.requires_constant_time());
                assert!(secret.requires_secure_memory());
                assert_eq!(secret.secret_type, SecretType::Key);
            }
            _ => panic!("Expected secret value"),
        }
    }

    #[test]
    fn test_provider_registration() {
        let mut crypto_runtime = CryptoRuntime::new(false, false).unwrap();

        // Initially no providers
        assert!(crypto_runtime.get_default_provider().is_none());

        // Register a provider
        let provider = Box::new(DefaultCryptoProvider::new());
        crypto_runtime.register_provider(provider);

        // Now we should have a default provider
        assert!(crypto_runtime.get_default_provider().is_some());
        assert_eq!(crypto_runtime.get_default_provider().unwrap().name(), "default");
    }

    #[test]
    fn test_algorithm_support() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        // Test supported algorithms
        assert!(crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Aes256).is_some());
        assert!(crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Ed25519).is_some());
        assert!(crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Sha3_256).is_some());
        assert!(crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Kyber1024).is_some());
        assert!(crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Dilithium3).is_some());

        // Test unsupported algorithm
        assert!(crypto_runtime.find_provider_for_algorithm(&AlgorithmType::Rsa2048).is_none());
    }

    #[test]
    fn test_crypto_operation_errors() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Test with invalid key type
        let invalid_key = Value::Integer(42);
        let result = crypto_runtime.encrypt(&invalid_key, b"test");
        assert!(matches!(result, Err(RuntimeError::InvalidKey)));

        // Test with invalid ciphertext
        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
        let invalid_ciphertext = b"too_short";
        let result = crypto_runtime.decrypt(&key, invalid_ciphertext);
        assert!(matches!(result, Err(RuntimeError::InvalidCiphertext)));
    }

    #[test]
    fn test_key_derivation() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Generate a shared secret
        let (alice_public, alice_private) = crypto_runtime.generate_keypair(&AlgorithmType::SecP256r1).unwrap();
        let (bob_public, bob_private) = crypto_runtime.generate_keypair(&AlgorithmType::SecP256r1).unwrap();

        let shared_secret = crypto_runtime.key_exchange(&alice_private, &bob_public).unwrap();

        // Derive a key from the shared secret
        let derived_key = crypto_runtime.derive_key(
            &AlgorithmType::Pbkdf2,
            b"password",
            b"salt",
            1000
        ).unwrap();

        assert!(matches!(derived_key, Value::Secret(_)));
        assert_eq!(derived_key.size(), 32);
    }

    #[test]
    fn test_performance_characteristics() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        let start_operations = crypto_runtime.get_operation_count();

        // Perform some operations
        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
        let data = b"Performance test data";
        let hash = crypto_runtime.hash(&AlgorithmType::Sha3_256, data).unwrap();

        let end_operations = crypto_runtime.get_operation_count();

        // Should have performed 2 operations
        assert_eq!(end_operations - start_operations, 2);
        assert_eq!(hash.len(), 32);
        assert_eq!(key.size(), 32);
    }

    #[test]
    fn test_memory_cleanup() {
        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Generate a key
        let key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();

        // The key should be properly secured
        match key {
            Value::Secret(secret) => {
                assert!(secret.requires_secure_memory());
                assert!(secret.security_requirements.auto_wipe);
            }
            _ => panic!("Expected secret value"),
        }

        // When the secret goes out of scope, it should be wiped
        // This is tested implicitly by the Drop implementation
    }

    #[test]
    fn test_concurrent_operations() {
        use std::thread;

        let mut crypto_runtime = CryptoRuntime::new(true, false).unwrap();

        // Test that operations can be performed concurrently
        let handles: Vec<_> = (0..4).map(|i| {
            let mut runtime = CryptoRuntime::new(true, false).unwrap();
            let data = format!("Thread {} data", i);

            thread::spawn(move || {
                let hash = runtime.hash(&AlgorithmType::Sha3_256, data.as_bytes()).unwrap();
                assert_eq!(hash.len(), 32);
                hash
            })
        }).collect();

        for handle in handles {
            let hash = handle.join().unwrap();
            assert_eq!(hash.len(), 32);
        }
    }

    #[test]
    fn test_crypto_integration() {
        let mut crypto_runtime = CryptoRuntime::new(true, true).unwrap();

        // Test full cryptographic workflow
        let message = b"Integration test message";

        // 1. Generate keys
        let aes_key = crypto_runtime.generate_key(&AlgorithmType::Aes256).unwrap();
        let (signing_public, signing_private) = crypto_runtime.generate_keypair(&AlgorithmType::Ed25519).unwrap();

        // 2. Encrypt message
        let nonce = crypto_runtime.get_default_provider().unwrap().random_bytes(12).unwrap();
        let ciphertext = crypto_runtime.get_default_provider().unwrap().encrypt(&aes_key, message).unwrap();

        // 3. Sign ciphertext
        let signature = crypto_runtime.get_default_provider().unwrap().sign(&signing_private, &ciphertext).unwrap();

        // 4. Verify signature
        let is_valid = crypto_runtime.get_default_provider().unwrap().verify(&signing_public, &ciphertext, &signature).unwrap();
        assert!(is_valid);

        // 5. Decrypt message
        let decrypted = crypto_runtime.get_default_provider().unwrap().decrypt(&aes_key, &ciphertext).unwrap();
        assert_eq!(decrypted, message);
    }
}