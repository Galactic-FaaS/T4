//! T4 Cryptographic Runtime Support
//!
//! This module provides comprehensive cryptographic runtime support for T4,
//! including secure memory management, cryptographic provider abstraction,
//! and support for post-quantum cryptography.

use crate::ast::AlgorithmType;
use crate::runtime::{
    values::{Value, CryptoValue, SecretValue, SecurityLevel},
    memory::{MemoryManager, SecureMemoryGuard},
    errors::{RuntimeError, RuntimeResult},
    symmetric::SymmetricEncryptionManager,
    asymmetric::AsymmetricEncryptionManager,
};
use std::collections::HashMap;
use std::sync::{Arc, Mutex};
use zeroize::Zeroize;

/// Cryptographic provider trait for algorithm abstraction
pub trait CryptoProvider: Send + Sync {
    /// Get provider name
    fn name(&self) -> &str;

    /// Check if algorithm is supported
    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool;

    /// Generate a key pair
    fn generate_keypair(&self, algorithm: &AlgorithmType) -> RuntimeResult<(Value, Value)>;

    /// Generate symmetric key
    fn generate_key(&self, algorithm: &AlgorithmType) -> RuntimeResult<Value>;

    /// Encrypt data
    fn encrypt(&self, key: &Value, plaintext: &[u8]) -> RuntimeResult<Vec<u8>>;

    /// Decrypt data
    fn decrypt(&self, key: &Value, ciphertext: &[u8]) -> RuntimeResult<Vec<u8>>;

    /// Sign data
    fn sign(&self, key: &Value, data: &[u8]) -> RuntimeResult<Vec<u8>>;

    /// Verify signature
    fn verify(&self, key: &Value, data: &[u8], signature: &[u8]) -> RuntimeResult<bool>;

    /// Hash data
    fn hash(&self, algorithm: &AlgorithmType, data: &[u8]) -> RuntimeResult<Vec<u8>>;

    /// Generate random bytes
    fn random_bytes(&self, size: usize) -> RuntimeResult<Vec<u8>>;

    /// Perform key exchange
    fn key_exchange(&self, private_key: &Value, public_key: &Value) -> RuntimeResult<Value>;
}

/// Main cryptographic runtime system
pub struct CryptoRuntime {
    /// Available crypto providers
    providers: HashMap<String, Box<dyn CryptoProvider>>,

    /// Default provider name
    default_provider: String,

    /// Operation counter for statistics
    operation_count: u64,

    /// Memory manager for secure operations
    memory_manager: Arc<MemoryManager>,

    /// Configuration
    config: CryptoConfig,

    /// Symmetric encryption manager
    symmetric_manager: Option<SymmetricEncryptionManager>,

    /// Asymmetric encryption manager
    asymmetric_manager: Option<AsymmetricEncryptionManager>,
}

/// Cryptographic configuration
#[derive(Debug, Clone)]
pub struct CryptoConfig {
    /// Enable post-quantum cryptography
    pub post_quantum_enabled: bool,

    /// Hardware acceleration enabled
    pub hardware_acceleration: bool,

    /// Default security level
    pub default_security_level: SecurityLevel,

    /// Provider preferences
    pub provider_preferences: Vec<String>,
}

/// Key material with secure storage
#[derive(Debug, Clone)]
pub struct KeyMaterial {
    /// The key data
    pub data: Vec<u8>,

    /// Key algorithm
    pub algorithm: AlgorithmType,

    /// Security requirements
    pub security_requirements: SecurityRequirements,

    /// Memory guard for automatic wiping
    memory_guard: Option<SecureMemoryGuard>,
}

impl KeyMaterial {
    /// Create new key material
    pub fn new(
        data: Vec<u8>,
        algorithm: AlgorithmType,
        memory_manager: Arc<MemoryManager>,
    ) -> RuntimeResult<Self> {
        let security_requirements = SecurityRequirements {
            constant_time: true,
            secure_memory: true,
            hardware_protection: false,
            auto_wipe: true,
        };

        // Allocate secure memory for the key
        let ptr = memory_manager.allocate_value(data.len(), crate::runtime::memory::RegionType::CryptoKey)?;
        let memory_guard = SecureMemoryGuard::new(ptr, data.len(), true, memory_manager.clone());

        Ok(Self {
            data,
            algorithm,
            security_requirements,
            memory_guard: Some(memory_guard),
        })
    }

    /// Get key size
    pub fn size(&self) -> usize {
        self.data.len()
    }

    /// Check if constant-time operations are required
    pub fn requires_constant_time(&self) -> bool {
        self.security_requirements.constant_time
    }

    /// Check if secure memory is required
    pub fn requires_secure_memory(&self) -> bool {
        self.security_requirements.secure_memory
    }

    /// Wipe the key material
    pub fn wipe(&mut self) {
        self.data.zeroize();
        if let Some(ref mut guard) = self.memory_guard {
            let _ = guard.wipe();
        }
    }
}

impl Drop for KeyMaterial {
    fn drop(&mut self) {
        self.wipe();
    }
}

/// Security requirements for cryptographic operations
#[derive(Debug, Clone)]
pub struct SecurityRequirements {
    pub constant_time: bool,
    pub secure_memory: bool,
    pub hardware_protection: bool,
    pub auto_wipe: bool,
}

/// Key manager for key lifecycle management
pub struct KeyManager {
    /// Stored keys
    keys: HashMap<String, StoredKey>,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,
}

/// Stored key information
#[derive(Debug, Clone)]
pub struct StoredKey {
    pub key_id: String,
    pub algorithm: AlgorithmType,
    pub key_type: KeyType,
    pub created_at: chrono::DateTime<chrono::Utc>,
    pub expires_at: Option<chrono::DateTime<chrono::Utc>>,
    pub metadata: HashMap<String, String>,
}

/// Key type enumeration
#[derive(Debug, Clone, PartialEq)]
pub enum KeyType {
    Symmetric,
    AsymmetricPrivate,
    AsymmetricPublic,
    Master,
    Session,
}

/// Default cryptographic provider implementation
pub struct DefaultCryptoProvider {
    /// Provider name
    name: String,

    /// Supported algorithms
    supported_algorithms: Vec<AlgorithmType>,
}

impl DefaultCryptoProvider {
    /// Create a new default crypto provider
    pub fn new() -> Self {
        Self {
            name: "default".to_string(),
            supported_algorithms: vec![
                AlgorithmType::Aes256,
                AlgorithmType::ChaCha20,
                AlgorithmType::Sha3_256,
                AlgorithmType::Sha3_512,
                AlgorithmType::Ed25519,
                AlgorithmType::SecP256r1,
            ],
        }
    }
}

impl CryptoProvider for DefaultCryptoProvider {
    fn name(&self) -> &str {
        &self.name
    }

    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        self.supported_algorithms.contains(algorithm)
    }

    fn generate_keypair(&self, algorithm: &AlgorithmType) -> RuntimeResult<(Value, Value)> {
        match algorithm {
            AlgorithmType::Ed25519 => {
                // Generate Ed25519 keypair
                let private_key = ed25519_dalek::SecretKey::generate(&mut OsRng);
                let public_key = ed25519_dalek::PublicKey::from(&private_key);

                let private_value = Value::PrivateKey(CryptoPrivateKey {
                    algorithm: algorithm.clone(),
                    key_data: SecretValue::new(private_key.to_bytes().to_vec(), SecretType::PrivateKey),
                    metadata: KeyMetadata {
                        key_id: uuid::Uuid::new_v4().to_string(),
                        created_at: chrono::Utc::now(),
                        algorithm_version: "1.0".to_string(),
                        security_level: SecurityLevel::Critical,
                    },
                });

                let public_value = Value::PublicKey(CryptoPublicKey {
                    algorithm: algorithm.clone(),
                    key_data: public_key.to_bytes().to_vec(),
                    metadata: KeyMetadata {
                        key_id: uuid::Uuid::new_v4().to_string(),
                        created_at: chrono::Utc::now(),
                        algorithm_version: "1.0".to_string(),
                        security_level: SecurityLevel::Medium,
                    },
                });

                Ok((private_value, public_value))
            }
            _ => Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone())),
        }
    }

    fn generate_key(&self, algorithm: &AlgorithmType) -> RuntimeResult<Value> {
        match algorithm {
            AlgorithmType::Aes256 => {
                let key_data = self.random_bytes(32)?;
                Ok(Value::new_secret(key_data, SecretType::Key))
            }
            AlgorithmType::ChaCha20 => {
                let key_data = self.random_bytes(32)?;
                Ok(Value::new_secret(key_data, SecretType::Key))
            }
            _ => Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone())),
        }
    }

    fn encrypt(&self, key: &Value, plaintext: &[u8]) -> RuntimeResult<Vec<u8>> {
        match key {
            Value::Secret(secret) => {
                // Simple AES-256 encryption (placeholder)
                // In a real implementation, this would use a proper crypto library
                let mut ciphertext = Vec::new();
                ciphertext.extend_from_slice(plaintext);
                Ok(ciphertext)
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn decrypt(&self, key: &Value, ciphertext: &[u8]) -> RuntimeResult<Vec<u8>> {
        match key {
            Value::Secret(secret) => {
                // Simple AES-256 decryption (placeholder)
                let mut plaintext = Vec::new();
                plaintext.extend_from_slice(ciphertext);
                Ok(plaintext)
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn sign(&self, key: &Value, data: &[u8]) -> RuntimeResult<Vec<u8>> {
        match key {
            Value::PrivateKey(private_key) => {
                match private_key.algorithm {
                    AlgorithmType::Ed25519 => {
                        // Ed25519 signing (placeholder)
                        let signature = Vec::new(); // Placeholder
                        Ok(signature)
                    }
                    _ => Err(RuntimeError::UnsupportedAlgorithm(private_key.algorithm.clone())),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn verify(&self, key: &Value, data: &[u8], signature: &[u8]) -> RuntimeResult<bool> {
        match key {
            Value::PublicKey(public_key) => {
                match public_key.algorithm {
                    AlgorithmType::Ed25519 => {
                        // Ed25519 verification (placeholder)
                        Ok(true) // Placeholder
                    }
                    _ => Err(RuntimeError::UnsupportedAlgorithm(public_key.algorithm.clone())),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn hash(&self, algorithm: &AlgorithmType, data: &[u8]) -> RuntimeResult<Vec<u8>> {
        match algorithm {
            AlgorithmType::Sha3_256 => {
                use sha3::{Sha3_256, Digest};
                let mut hasher = Sha3_256::new();
                hasher.update(data);
                Ok(hasher.finalize().to_vec())
            }
            AlgorithmType::Sha3_512 => {
                use sha3::{Sha3_512, Digest};
                let mut hasher = Sha3_512::new();
                hasher.update(data);
                Ok(hasher.finalize().to_vec())
            }
            _ => Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone())),
        }
    }

    fn random_bytes(&self, size: usize) -> RuntimeResult<Vec<u8>> {
        use rand::RngCore;
        let mut rng = rand::rngs::OsRng;
        let mut bytes = vec![0u8; size];
        rng.fill_bytes(&mut bytes);
        Ok(bytes)
    }

    fn key_exchange(&self, private_key: &Value, public_key: &Value) -> RuntimeResult<Value> {
        match (private_key, public_key) {
            (Value::PrivateKey(priv_key), Value::PublicKey(pub_key)) => {
                match (&priv_key.algorithm, &pub_key.algorithm) {
                    (AlgorithmType::SecP256r1, AlgorithmType::SecP256r1) => {
                        // ECDH key exchange (placeholder)
                        let shared_secret = Value::new_secret(vec![0u8; 32], SecretType::KeyMaterial);
                        Ok(shared_secret)
                    }
                    _ => Err(RuntimeError::IncompatibleAlgorithms),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }
}

/// Post-quantum cryptographic provider
pub struct PostQuantumProvider {
    /// Provider name
    name: String,

    /// Supported post-quantum algorithms
    supported_algorithms: Vec<AlgorithmType>,
}

impl PostQuantumProvider {
    /// Create a new post-quantum crypto provider
    pub fn new() -> Self {
        Self {
            name: "post_quantum".to_string(),
            supported_algorithms: vec![
                AlgorithmType::Kyber1024,
                AlgorithmType::Kyber768,
                AlgorithmType::Kyber512,
                AlgorithmType::Dilithium3,
                AlgorithmType::Dilithium2,
                AlgorithmType::Dilithium5,
            ],
        }
    }
}

impl CryptoProvider for PostQuantumProvider {
    fn name(&self) -> &str {
        &self.name
    }

    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        self.supported_algorithms.contains(algorithm)
    }

    fn generate_keypair(&self, algorithm: &AlgorithmType) -> RuntimeResult<(Value, Value)> {
        match algorithm {
            AlgorithmType::Kyber1024 => {
                // Generate Kyber-1024 keypair (placeholder)
                let (public_key, private_key) = (vec![0u8; 1568], vec![0u8; 3168]);

                let private_value = Value::PrivateKey(CryptoPrivateKey {
                    algorithm: algorithm.clone(),
                    key_data: SecretValue::new(private_key, SecretType::PrivateKey),
                    metadata: KeyMetadata {
                        key_id: uuid::Uuid::new_v4().to_string(),
                        created_at: chrono::Utc::now(),
                        algorithm_version: "1.0".to_string(),
                        security_level: SecurityLevel::Critical,
                    },
                });

                let public_value = Value::PublicKey(CryptoPublicKey {
                    algorithm: algorithm.clone(),
                    key_data: public_key,
                    metadata: KeyMetadata {
                        key_id: uuid::Uuid::new_v4().to_string(),
                        created_at: chrono::Utc::now(),
                        algorithm_version: "1.0".to_string(),
                        security_level: SecurityLevel::Medium,
                    },
                });

                Ok((private_value, public_value))
            }
            _ => Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone())),
        }
    }

    fn generate_key(&self, algorithm: &AlgorithmType) -> RuntimeResult<Value> {
        // Post-quantum algorithms typically use keypairs, not symmetric keys
        Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone()))
    }

    fn encrypt(&self, key: &Value, plaintext: &[u8]) -> RuntimeResult<Vec<u8>> {
        match key {
            Value::PublicKey(pub_key) => {
                match pub_key.algorithm {
                    AlgorithmType::Kyber1024 => {
                        // Kyber encapsulation (placeholder)
                        Ok(vec![0u8; 1568])
                    }
                    _ => Err(RuntimeError::UnsupportedAlgorithm(pub_key.algorithm.clone())),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn decrypt(&self, key: &Value, ciphertext: &[u8]) -> RuntimeResult<Vec<u8>> {
        match key {
            Value::PrivateKey(priv_key) => {
                match priv_key.algorithm {
                    AlgorithmType::Kyber1024 => {
                        // Kyber decapsulation (placeholder)
                        Ok(vec![0u8; 32])
                    }
                    _ => Err(RuntimeError::UnsupportedAlgorithm(priv_key.algorithm.clone())),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn sign(&self, key: &Value, data: &[u8]) -> RuntimeResult<Vec<u8>> {
        match key {
            Value::PrivateKey(priv_key) => {
                match priv_key.algorithm {
                    AlgorithmType::Dilithium3 => {
                        // Dilithium signature (placeholder)
                        Ok(vec![0u8; 3293])
                    }
                    _ => Err(RuntimeError::UnsupportedAlgorithm(priv_key.algorithm.clone())),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn verify(&self, key: &Value, data: &[u8], signature: &[u8]) -> RuntimeResult<bool> {
        match key {
            Value::PublicKey(pub_key) => {
                match pub_key.algorithm {
                    AlgorithmType::Dilithium3 => {
                        // Dilithium verification (placeholder)
                        Ok(true)
                    }
                    _ => Err(RuntimeError::UnsupportedAlgorithm(pub_key.algorithm.clone())),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }

    fn hash(&self, algorithm: &AlgorithmType, data: &[u8]) -> RuntimeResult<Vec<u8>> {
        // Post-quantum algorithms typically use SHAKE for hashing
        match algorithm {
            AlgorithmType::Shake256 => {
                use sha3::{Shake256, digest::ExtendableOutput, digest::Update};
                let mut hasher = Shake256::default();
                hasher.update(data);
                let mut output = [0u8; 32];
                hasher.finalize_xof_into(&mut output);
                Ok(output.to_vec())
            }
            _ => Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone())),
        }
    }

    fn random_bytes(&self, size: usize) -> RuntimeResult<Vec<u8>> {
        use rand::RngCore;
        let mut rng = rand::rngs::OsRng;
        let mut bytes = vec![0u8; size];
        rng.fill_bytes(&mut bytes);
        Ok(bytes)
    }

    fn key_exchange(&self, private_key: &Value, public_key: &Value) -> RuntimeResult<Value> {
        match (private_key, public_key) {
            (Value::PrivateKey(priv_key), Value::PublicKey(pub_key)) => {
                match (&priv_key.algorithm, &pub_key.algorithm) {
                    (AlgorithmType::Kyber1024, AlgorithmType::Kyber1024) => {
                        // Kyber key exchange (placeholder)
                        let shared_secret = Value::new_secret(vec![0u8; 32], SecretType::KeyMaterial);
                        Ok(shared_secret)
                    }
                    _ => Err(RuntimeError::IncompatibleAlgorithms),
                }
            }
            _ => Err(RuntimeError::InvalidKey),
        }
    }
}

impl CryptoRuntime {
    /// Create a new cryptographic runtime
    pub fn new(crypto_enabled: bool, post_quantum_enabled: bool) -> RuntimeResult<Self> {
        if !crypto_enabled {
            return Ok(Self {
                providers: HashMap::new(),
                default_provider: "none".to_string(),
                operation_count: 0,
                memory_manager: Arc::new(MemoryManager::new(crate::runtime::MemorySafetyLevel::Standard)?),
                config: CryptoConfig {
                    post_quantum_enabled,
                    hardware_acceleration: false,
                    default_security_level: SecurityLevel::Medium,
                    provider_preferences: vec!["default".to_string()],
                },
                symmetric_manager: None,
                asymmetric_manager: None,
            });
        }

        let mut providers: HashMap<String, Box<dyn CryptoProvider>> = HashMap::new();

        // Add default provider
        let default_provider = Box::new(DefaultCryptoProvider::new());
        providers.insert("default".to_string(), default_provider);

        // Add post-quantum provider if enabled
        if post_quantum_enabled {
            let pq_provider = Box::new(PostQuantumProvider::new());
            providers.insert("post_quantum".to_string(), pq_provider);
        }

        // Create security manager for encryption operations
        let security_manager = Arc::new(SecurityManager::new(SecurityLevel::High)?);

        Ok(Self {
            providers,
            default_provider: "default".to_string(),
            operation_count: 0,
            memory_manager: Arc::new(MemoryManager::new(crate::runtime::MemorySafetyLevel::Enhanced)?),
            config: CryptoConfig {
                post_quantum_enabled,
                hardware_acceleration: false,
                default_security_level: SecurityLevel::High,
                provider_preferences: vec!["default".to_string(), "post_quantum".to_string()],
            },
            symmetric_manager: Some(SymmetricEncryptionManager::new(
                security_manager.clone(),
                Arc::new(MemoryManager::new(crate::runtime::MemorySafetyLevel::Enhanced)?),
            )),
            asymmetric_manager: Some(AsymmetricEncryptionManager::new(
                security_manager,
                Arc::new(MemoryManager::new(crate::runtime::MemorySafetyLevel::Enhanced)?),
            )),
        })
    }

    /// Get a crypto provider by name
    pub fn get_provider(&self, name: &str) -> Option<&dyn CryptoProvider> {
        self.providers.get(name).map(|p| p.as_ref())
    }

    /// Get the default crypto provider
    pub fn get_default_provider(&self) -> Option<&dyn CryptoProvider> {
        self.get_provider(&self.default_provider)
    }

    /// Find a provider that supports the given algorithm
    pub fn find_provider_for_algorithm(&self, algorithm: &AlgorithmType) -> Option<&dyn CryptoProvider> {
        for provider_name in &self.config.provider_preferences {
            if let Some(provider) = self.get_provider(provider_name) {
                if provider.supports_algorithm(algorithm) {
                    return Some(provider);
                }
            }
        }
        None
    }

    /// Generate a key pair
    pub fn generate_keypair(&mut self, algorithm: &AlgorithmType) -> RuntimeResult<(Value, Value)> {
        // Check if this is an asymmetric algorithm that should use the asymmetric manager
        if self.is_asymmetric_algorithm(algorithm) {
            if let Some(ref mut asymmetric_manager) = self.asymmetric_manager {
                let result = asymmetric_manager.generate_keypair(algorithm)?;
                self.operation_count += 1;
                return Ok(result);
            }
        }

        // Fall back to legacy provider-based keypair generation
        let provider = self.find_provider_for_algorithm(algorithm)
            .ok_or(RuntimeError::NoProviderForAlgorithm(algorithm.clone()))?;

        let result = provider.generate_keypair(algorithm)?;
        self.operation_count += 1;
        Ok(result)
    }

    /// Generate a symmetric key
    pub fn generate_key(&mut self, algorithm: &AlgorithmType) -> RuntimeResult<Value> {
        let provider = self.find_provider_for_algorithm(algorithm)
            .ok_or(RuntimeError::NoProviderForAlgorithm(algorithm.clone()))?;

        let result = provider.generate_key(algorithm)?;
        self.operation_count += 1;
        Ok(result)
    }

    /// Encrypt data
    pub fn encrypt(&mut self, key: &Value, plaintext: &[u8]) -> RuntimeResult<Vec<u8>> {
        // Extract algorithm from key
        let algorithm = match key {
            Value::Secret(_) => AlgorithmType::Aes256Gcm, // Default to AES-GCM for symmetric keys
            Value::PublicKey(pub_key) => pub_key.algorithm.clone(),
            Value::Key(crypto_key) => crypto_key.algorithm.clone(),
            _ => return Err(RuntimeError::InvalidKey),
        };

        // Check if this is a symmetric encryption algorithm
        if self.is_symmetric_algorithm(&algorithm) {
            if let Some(ref mut symmetric_manager) = self.symmetric_manager {
                let ciphertext = symmetric_manager.encrypt(&algorithm, key, plaintext, &[])?;
                self.operation_count += 1;
                return Ok(ciphertext.ciphertext);
            }
        }

        // Fall back to legacy provider-based encryption for asymmetric algorithms
        let provider = self.find_provider_for_algorithm(&algorithm)
            .ok_or(RuntimeError::NoProviderForAlgorithm(algorithm.clone()))?;

        let result = provider.encrypt(key, plaintext)?;
        self.operation_count += 1;
        Ok(result)
    }

    /// Decrypt data
    pub fn decrypt(&mut self, key: &Value, ciphertext: &[u8]) -> RuntimeResult<Vec<u8>> {
        // Extract algorithm from key
        let algorithm = match key {
            Value::Secret(_) => AlgorithmType::Aes256Gcm, // Default to AES-GCM for symmetric keys
            Value::PrivateKey(priv_key) => priv_key.algorithm.clone(),
            Value::Key(crypto_key) => crypto_key.algorithm.clone(),
            _ => return Err(RuntimeError::InvalidKey),
        };

        // Check if this is a symmetric encryption algorithm
        if self.is_symmetric_algorithm(&algorithm) {
            if let Some(ref mut symmetric_manager) = self.symmetric_manager {
                // For symmetric decryption, we need to reconstruct the ciphertext structure
                // This is a simplified approach - in practice, we'd need more metadata
                let crypto_ciphertext = crate::runtime::values::CryptoCiphertext {
                    algorithm: algorithm.clone(),
                    ciphertext: ciphertext.to_vec(),
                    nonce: Some(vec![0u8; 12]), // Default nonce - in practice this should be stored
                    tag: None,
                };

                let plaintext = symmetric_manager.decrypt(&algorithm, key, &crypto_ciphertext, &[])?;
                self.operation_count += 1;
                return Ok(plaintext);
            }
        }

        // Fall back to legacy provider-based decryption for asymmetric algorithms
        let provider = self.find_provider_for_algorithm(&algorithm)
            .ok_or(RuntimeError::NoProviderForAlgorithm(algorithm.clone()))?;

        let result = provider.decrypt(key, ciphertext)?;
        self.operation_count += 1;
        Ok(result)
    }

    /// Hash data
    pub fn hash(&mut self, algorithm: &AlgorithmType, data: &[u8]) -> RuntimeResult<Vec<u8>> {
        let provider = self.find_provider_for_algorithm(algorithm)
            .ok_or(RuntimeError::NoProviderForAlgorithm(algorithm.clone()))?;

        let result = provider.hash(algorithm, data)?;
        self.operation_count += 1;
        Ok(result)
    }

    /// Perform key exchange
    pub fn key_exchange(&mut self, private_key: &Value, public_key: &Value) -> RuntimeResult<Value> {
        let algorithm = match (private_key, public_key) {
            (Value::PrivateKey(priv_key), Value::PublicKey(pub_key)) => {
                if priv_key.algorithm != pub_key.algorithm {
                    return Err(RuntimeError::IncompatibleAlgorithms);
                }
                priv_key.algorithm.clone()
            }
            _ => return Err(RuntimeError::InvalidKey),
        };

        let provider = self.find_provider_for_algorithm(&algorithm)
            .ok_or(RuntimeError::NoProviderForAlgorithm(algorithm.clone()))?;

        let result = provider.key_exchange(private_key, public_key)?;
        self.operation_count += 1;
        Ok(result)
    }

    /// Get operation count
    pub fn get_operation_count(&self) -> u64 {
        self.operation_count
    }

    /// Register a new crypto provider
    pub fn register_provider(&mut self, provider: Box<dyn CryptoProvider>) {
        self.providers.insert(provider.name().to_string(), provider);
    }

    /// Set the default provider
    pub fn set_default_provider(&mut self, provider_name: &str) -> RuntimeResult<()> {
        if self.providers.contains_key(provider_name) {
            self.default_provider = provider_name.to_string();
            Ok(())
        } else {
            Err(RuntimeError::ProviderNotFound(provider_name.to_string()))
        }
    }

    /// Check if an algorithm is symmetric encryption
    fn is_symmetric_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        matches!(
            algorithm,
            AlgorithmType::Aes256Gcm
                | AlgorithmType::Aes256Cbc
                | AlgorithmType::Aes256Ctr
                | AlgorithmType::ChaCha20Poly1305
                | AlgorithmType::Aes128Gcm
                | AlgorithmType::Aes128Cbc
                | AlgorithmType::ChaCha20
        )
    }

    /// Check if an algorithm is asymmetric encryption
    fn is_asymmetric_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        matches!(
            algorithm,
            AlgorithmType::Rsa2048
                | AlgorithmType::Rsa4096
                | AlgorithmType::Ed25519
                | AlgorithmType::X25519
                | AlgorithmType::SecP256r1
                | AlgorithmType::Kyber1024
                | AlgorithmType::Kyber768
                | AlgorithmType::Kyber512
                | AlgorithmType::Dilithium3
                | AlgorithmType::Dilithium2
                | AlgorithmType::Dilithium5
        )
    }

    /// Get the symmetric encryption manager
    pub fn get_symmetric_manager(&mut self) -> Option<&mut SymmetricEncryptionManager> {
        self.symmetric_manager.as_mut()
    }

    /// Get the asymmetric encryption manager
    pub fn get_asymmetric_manager(&mut self) -> Option<&mut AsymmetricEncryptionManager> {
        self.asymmetric_manager.as_mut()
    }

    /// Generate a symmetric key using the symmetric encryption manager
    pub fn generate_symmetric_key(&mut self, algorithm: &AlgorithmType) -> RuntimeResult<Value> {
        if let Some(ref mut symmetric_manager) = self.symmetric_manager {
            let key = symmetric_manager.generate_key(algorithm)?;
            self.operation_count += 1;
            Ok(key)
        } else {
            Err(RuntimeError::CryptoDisabled)
        }
    }

    /// Derive a key using key derivation functions
    pub fn derive_key(
        &mut self,
        algorithm: &AlgorithmType,
        password: &[u8],
        salt: &[u8],
        iterations: u32,
    ) -> RuntimeResult<Value> {
        if let Some(ref mut symmetric_manager) = self.symmetric_manager {
            let key = symmetric_manager.derive_key(algorithm, password, salt, iterations)?;
            self.operation_count += 1;
            Ok(key)
        } else {
            Err(RuntimeError::CryptoDisabled)
        }
    }
}

impl KeyManager {
    /// Create a new key manager
    pub fn new(memory_manager: Arc<MemoryManager>) -> Self {
        Self {
            keys: HashMap::new(),
            memory_manager,
        }
    }

    /// Store a key
    pub fn store_key(&mut self, key_id: String, key: Value, key_type: KeyType) -> RuntimeResult<()> {
        let algorithm = key.get_type().try_into()?; // Convert Type to AlgorithmType

        let stored_key = StoredKey {
            key_id: key_id.clone(),
            algorithm,
            key_type,
            created_at: chrono::Utc::now(),
            expires_at: None,
            metadata: HashMap::new(),
        };

        // TODO: Actually store the key securely
        self.keys.insert(key_id, stored_key);
        Ok(())
    }

    /// Retrieve a key
    pub fn retrieve_key(&self, key_id: &str) -> RuntimeResult<Option<Value>> {
        // TODO: Implement secure key retrieval
        Ok(None)
    }

    /// Delete a key
    pub fn delete_key(&mut self, key_id: &str) -> RuntimeResult<()> {
        if let Some(mut stored_key) = self.keys.remove(key_id) {
            // Key data should be wiped when dropped
            stored_key.metadata.clear();
        }
        Ok(())
    }

    /// List stored keys
    pub fn list_keys(&self) -> Vec<&str> {
        self.keys.keys().map(|s| s.as_str()).collect()
    }
}

// Import required types
use chrono::Utc;
use ed25519_dalek::{self, SecretKey, PublicKey};
use rand::{self, RngCore};
use uuid;

// Re-export commonly used types
pub use self::{
    KeyMaterial,
    KeyManager,
    CryptoProvider,
    DefaultCryptoProvider,
    PostQuantumProvider,
};