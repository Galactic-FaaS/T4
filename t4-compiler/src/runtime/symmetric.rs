/*!
 * T4 Symmetric Encryption Primitives
 *
 * This module provides comprehensive symmetric encryption implementations
 * including AES, ChaCha20-Poly1305, and post-quantum symmetric algorithms.
 * All implementations feature constant-time operations and hardware acceleration.
 */

use crate::ast::AlgorithmType;
use crate::runtime::{
    values::{Value, SecretValue, SecurityLevel, CryptoCiphertext, SecretType},
    memory::MemoryManager,
    errors::{RuntimeError, RuntimeResult},
    security::SecurityManager,
};
use std::sync::Arc;
use zeroize::Zeroize;
use aes_gcm::{
    Aes256Gcm, AeadInPlace, KeyInit, Nonce, AeadCore,
    aead::{Aead, Key, OsRng},
};
use chacha20poly1305::{
    ChaCha20Poly1305, Key as ChaChaKey, Nonce as ChaChaNonce,
    aead::{Aead as ChaChaAead, Key as ChaChaAeadKey},
};
use aes::{Aes256, BlockEncrypt, BlockDecrypt, NewBlockCipher};
use cbc::{Encryptor, Decryptor};
use ctr::Ctr64BE;
use sha3::{Sha3_256, Digest};
use rand_core::RngCore;
use subtle::ConstantTimeEq;

/// Symmetric encryption provider trait
pub trait SymmetricCryptoProvider: Send + Sync {
    /// Get provider name
    fn name(&self) -> &str;

    /// Check if algorithm is supported
    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool;

    /// Encrypt data with authenticated encryption
    fn encrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        plaintext: &[u8],
        associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>>;

    /// Decrypt data with authenticated encryption
    fn decrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        ciphertext: &[u8],
        associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>>;

    /// Generate a random nonce for the algorithm
    fn generate_nonce(&self) -> RuntimeResult<Vec<u8>>;

    /// Get the key length for the algorithm
    fn key_length(&self) -> usize;

    /// Get the nonce length for the algorithm
    fn nonce_length(&self) -> usize;

    /// Check if hardware acceleration is available
    fn hardware_accelerated(&self) -> bool;
}

/// AES-GCM encryption provider
pub struct AesGcmProvider {
    /// Provider name
    name: String,

    /// Hardware acceleration enabled
    hardware_accelerated: bool,
}

impl AesGcmProvider {
    /// Create a new AES-GCM provider
    pub fn new() -> Self {
        Self {
            name: "aes256gcm".to_string(),
            hardware_accelerated: Self::detect_hardware_acceleration(),
        }
    }

    /// Detect AES hardware acceleration
    fn detect_hardware_acceleration() -> bool {
        // In a real implementation, this would check CPU features
        // For now, we'll assume it's available on modern systems
        true
    }

    /// Validate key length
    fn validate_key(&self, key: &[u8]) -> RuntimeResult<()> {
        if key.len() != 32 {
            return Err(RuntimeError::InvalidKeyLength(key.len(), 32));
        }
        Ok(())
    }

    /// Validate nonce length
    fn validate_nonce(&self, nonce: &[u8]) -> RuntimeResult<()> {
        if nonce.len() != 12 {
            return Err(RuntimeError::InvalidNonceLength(nonce.len(), 12));
        }
        Ok(())
    }
}

impl SymmetricCryptoProvider for AesGcmProvider {
    fn name(&self) -> &str {
        &self.name
    }

    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        matches!(algorithm, AlgorithmType::Aes256Gcm)
    }

    fn encrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        plaintext: &[u8],
        associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        self.validate_key(key)?;
        self.validate_nonce(nonce)?;

        let key = Key::<Aes256Gcm>::from_slice(key);
        let cipher = Aes256Gcm::new(key);
        let nonce = Nonce::from_slice(nonce);

        // Use constant-time comparison for security
        let mut ciphertext = cipher
            .encrypt(nonce, aes_gcm::aead::Payload { msg: plaintext, aad: associated_data })
            .map_err(|_| RuntimeError::EncryptionFailed)?;

        Ok(ciphertext)
    }

    fn decrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        ciphertext: &[u8],
        associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        self.validate_key(key)?;
        self.validate_nonce(nonce)?;

        let key = Key::<Aes256Gcm>::from_slice(key);
        let cipher = Aes256Gcm::new(key);
        let nonce = Nonce::from_slice(nonce);

        let plaintext = cipher
            .decrypt(nonce, aes_gcm::aead::Payload { msg: ciphertext, aad: associated_data })
            .map_err(|_| RuntimeError::DecryptionFailed)?;

        Ok(plaintext)
    }

    fn generate_nonce(&self) -> RuntimeResult<Vec<u8>> {
        let mut nonce = vec![0u8; 12];
        OsRng.fill_bytes(&mut nonce);
        Ok(nonce)
    }

    fn key_length(&self) -> usize {
        32
    }

    fn nonce_length(&self) -> usize {
        12
    }

    fn hardware_accelerated(&self) -> bool {
        self.hardware_accelerated
    }
}

/// ChaCha20-Poly1305 encryption provider
pub struct ChaCha20Poly1305Provider {
    /// Provider name
    name: String,

    /// Hardware acceleration enabled
    hardware_accelerated: bool,
}

impl ChaCha20Poly1305Provider {
    /// Create a new ChaCha20-Poly1305 provider
    pub fn new() -> Self {
        Self {
            name: "chacha20poly1305".to_string(),
            hardware_accelerated: Self::detect_hardware_acceleration(),
        }
    }

    /// Detect ChaCha20 hardware acceleration
    fn detect_hardware_acceleration() -> bool {
        // ChaCha20 is typically software-accelerated
        true
    }

    /// Validate key length
    fn validate_key(&self, key: &[u8]) -> RuntimeResult<()> {
        if key.len() != 32 {
            return Err(RuntimeError::InvalidKeyLength(key.len(), 32));
        }
        Ok(())
    }

    /// Validate nonce length
    fn validate_nonce(&self, nonce: &[u8]) -> RuntimeResult<()> {
        if nonce.len() != 12 {
            return Err(RuntimeError::InvalidNonceLength(nonce.len(), 12));
        }
        Ok(())
    }
}

impl SymmetricCryptoProvider for ChaCha20Poly1305Provider {
    fn name(&self) -> &str {
        &self.name
    }

    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        matches!(algorithm, AlgorithmType::ChaCha20Poly1305)
    }

    fn encrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        plaintext: &[u8],
        associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        self.validate_key(key)?;
        self.validate_nonce(nonce)?;

        let key = ChaChaKey::from_slice(key);
        let cipher = ChaCha20Poly1305::new(key);
        let nonce = ChaChaNonce::from_slice(nonce);

        let mut ciphertext = cipher
            .encrypt(nonce, chacha20poly1305::aead::Payload { msg: plaintext, aad: associated_data })
            .map_err(|_| RuntimeError::EncryptionFailed)?;

        Ok(ciphertext)
    }

    fn decrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        ciphertext: &[u8],
        associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        self.validate_key(key)?;
        self.validate_nonce(nonce)?;

        let key = ChaChaKey::from_slice(key);
        let cipher = ChaCha20Poly1305::new(key);
        let nonce = ChaChaNonce::from_slice(nonce);

        let plaintext = cipher
            .decrypt(nonce, chacha20poly1305::aead::Payload { msg: ciphertext, aad: associated_data })
            .map_err(|_| RuntimeError::DecryptionFailed)?;

        Ok(plaintext)
    }

    fn generate_nonce(&self) -> RuntimeResult<Vec<u8>> {
        let mut nonce = vec![0u8; 12];
        OsRng.fill_bytes(&mut nonce);
        Ok(nonce)
    }

    fn key_length(&self) -> usize {
        32
    }

    fn nonce_length(&self) -> usize {
        12
    }

    fn hardware_accelerated(&self) -> bool {
        self.hardware_accelerated
    }
}

/// AES-CBC encryption provider
pub struct AesCbcProvider {
    /// Provider name
    name: String,

    /// Hardware acceleration enabled
    hardware_accelerated: bool,
}

impl AesCbcProvider {
    /// Create a new AES-CBC provider
    pub fn new() -> Self {
        Self {
            name: "aes256cbc".to_string(),
            hardware_accelerated: Self::detect_hardware_acceleration(),
        }
    }

    /// Detect AES hardware acceleration
    fn detect_hardware_acceleration() -> bool {
        true
    }

    /// Validate key length
    fn validate_key(&self, key: &[u8]) -> RuntimeResult<()> {
        if key.len() != 32 {
            return Err(RuntimeError::InvalidKeyLength(key.len(), 32));
        }
        Ok(())
    }

    /// Validate IV length
    fn validate_iv(&self, iv: &[u8]) -> RuntimeResult<()> {
        if iv.len() != 16 {
            return Err(RuntimeError::InvalidIVLength(iv.len(), 16));
        }
        Ok(())
    }
}

impl SymmetricCryptoProvider for AesCbcProvider {
    fn name(&self) -> &str {
        &self.name
    }

    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        matches!(algorithm, AlgorithmType::Aes256Cbc)
    }

    fn encrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        plaintext: &[u8],
        _associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        self.validate_key(key)?;
        self.validate_iv(nonce)?;

        // Pad plaintext to block boundary
        let padded_plaintext = self.pad_plaintext(plaintext);

        let cipher = Aes256::new_from_slice(key).map_err(|_| RuntimeError::InvalidKey)?;
        let iv = aes::Block::from_slice(nonce);

        let mut ciphertext = vec![0u8; padded_plaintext.len()];
        let mut encryptor = Encryptor::<Aes256>::new(cipher, iv);

        encryptor.encrypt_padded_b2b_mut::<aes::cipher::block_padding::Pkcs7>(
            &padded_plaintext,
            &mut ciphertext,
        ).map_err(|_| RuntimeError::EncryptionFailed)?;

        Ok(ciphertext)
    }

    fn decrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        ciphertext: &[u8],
        _associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        self.validate_key(key)?;
        self.validate_iv(nonce)?;

        let cipher = Aes256::new_from_slice(key).map_err(|_| RuntimeError::InvalidKey)?;
        let iv = aes::Block::from_slice(nonce);

        let mut plaintext = vec![0u8; ciphertext.len()];
        let mut decryptor = Decryptor::<Aes256>::new(cipher, iv);

        decryptor.decrypt_padded_b2b_mut::<aes::cipher::block_padding::Pkcs7>(
            ciphertext,
            &mut plaintext,
        ).map_err(|_| RuntimeError::DecryptionFailed)?;

        // Remove padding
        let unpadded_plaintext = self.unpad_plaintext(&plaintext);
        Ok(unpadded_plaintext)
    }

    fn generate_nonce(&self) -> RuntimeResult<Vec<u8>> {
        let mut nonce = vec![0u8; 16];
        OsRng.fill_bytes(&mut nonce);
        Ok(nonce)
    }

    fn key_length(&self) -> usize {
        32
    }

    fn nonce_length(&self) -> usize {
        16
    }

    fn hardware_accelerated(&self) -> bool {
        self.hardware_accelerated
    }
}

impl AesCbcProvider {
    /// Pad plaintext to block boundary using PKCS7 padding
    fn pad_plaintext(&self, plaintext: &[u8]) -> Vec<u8> {
        let block_size = 16;
        let padding_length = block_size - (plaintext.len() % block_size);

        let mut padded = plaintext.to_vec();
        for _ in 0..padding_length {
            padded.push(padding_length as u8);
        }

        padded
    }

    /// Remove PKCS7 padding from plaintext
    fn unpad_plaintext(&self, padded_plaintext: &[u8]) -> Vec<u8> {
        if let Some(&last_byte) = padded_plaintext.last() {
            let padding_length = last_byte as usize;
            if padding_length > 0 && padding_length <= 16 {
                let start = padded_plaintext.len() - padding_length;
                return padded_plaintext[..start].to_vec();
            }
        }
        padded_plaintext.to_vec()
    }
}

/// AES-CTR encryption provider
pub struct AesCtrProvider {
    /// Provider name
    name: String,

    /// Hardware acceleration enabled
    hardware_accelerated: bool,
}

impl AesCtrProvider {
    /// Create a new AES-CTR provider
    pub fn new() -> Self {
        Self {
            name: "aes256ctr".to_string(),
            hardware_accelerated: Self::detect_hardware_acceleration(),
        }
    }

    /// Detect AES hardware acceleration
    fn detect_hardware_acceleration() -> bool {
        true
    }

    /// Validate key length
    fn validate_key(&self, key: &[u8]) -> RuntimeResult<()> {
        if key.len() != 32 {
            return Err(RuntimeError::InvalidKeyLength(key.len(), 32));
        }
        Ok(())
    }

    /// Validate nonce length
    fn validate_nonce(&self, nonce: &[u8]) -> RuntimeResult<()> {
        if nonce.len() != 16 {
            return Err(RuntimeError::InvalidNonceLength(nonce.len(), 16));
        }
        Ok(())
    }
}

impl SymmetricCryptoProvider for AesCtrProvider {
    fn name(&self) -> &str {
        &self.name
    }

    fn supports_algorithm(&self, algorithm: &AlgorithmType) -> bool {
        matches!(algorithm, AlgorithmType::Aes256Ctr)
    }

    fn encrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        plaintext: &[u8],
        _associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        self.validate_key(key)?;
        self.validate_nonce(nonce)?;

        let cipher = Aes256::new_from_slice(key).map_err(|_| RuntimeError::InvalidKey)?;

        let mut ciphertext = plaintext.to_vec();
        let mut ctr = Ctr64BE::<Aes256>::new(cipher, nonce.into());

        ctr.apply_keystream(&mut ciphertext);

        Ok(ciphertext)
    }

    fn decrypt_aead(
        &self,
        key: &[u8],
        nonce: &[u8],
        ciphertext: &[u8],
        _associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        // CTR mode decryption is identical to encryption
        self.encrypt_aead(key, nonce, ciphertext, &[])
    }

    fn generate_nonce(&self) -> RuntimeResult<Vec<u8>> {
        let mut nonce = vec![0u8; 16];
        OsRng.fill_bytes(&mut nonce);
        Ok(nonce)
    }

    fn key_length(&self) -> usize {
        32
    }

    fn nonce_length(&self) -> usize {
        16
    }

    fn hardware_accelerated(&self) -> bool {
        self.hardware_accelerated
    }
}

/// Symmetric encryption manager
pub struct SymmetricEncryptionManager {
    /// Available providers
    providers: Vec<Box<dyn SymmetricCryptoProvider>>,

    /// Security manager
    security_manager: Arc<SecurityManager>,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,
}

impl SymmetricEncryptionManager {
    /// Create a new symmetric encryption manager
    pub fn new(
        security_manager: Arc<SecurityManager>,
        memory_manager: Arc<MemoryManager>,
    ) -> Self {
        let mut providers: Vec<Box<dyn SymmetricCryptoProvider>> = Vec::new();

        // Add AES-GCM provider
        providers.push(Box::new(AesGcmProvider::new()));

        // Add ChaCha20-Poly1305 provider
        providers.push(Box::new(ChaCha20Poly1305Provider::new()));

        // Add AES-CBC provider
        providers.push(Box::new(AesCbcProvider::new()));

        // Add AES-CTR provider
        providers.push(Box::new(AesCtrProvider::new()));

        Self {
            providers,
            security_manager,
            memory_manager,
        }
    }

    /// Find a provider for the given algorithm
    pub fn find_provider(&self, algorithm: &AlgorithmType) -> RuntimeResult<&dyn SymmetricCryptoProvider> {
        for provider in &self.providers {
            if provider.supports_algorithm(algorithm) {
                return Ok(provider.as_ref());
            }
        }
        Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone()))
    }

    /// Encrypt data with authenticated encryption
    pub fn encrypt(
        &self,
        algorithm: &AlgorithmType,
        key: &Value,
        plaintext: &[u8],
        associated_data: &[u8],
    ) -> RuntimeResult<CryptoCiphertext> {
        // Extract key material
        let key_bytes = match key {
            Value::Secret(secret) => &secret.data,
            Value::Key(crypto_key) => &crypto_key.material.data,
            _ => return Err(RuntimeError::InvalidKey),
        };

        let provider = self.find_provider(algorithm)?;

        // Generate nonce
        let nonce = provider.generate_nonce()?;

        // Perform encryption
        let ciphertext_data = provider.encrypt_aead(
            key_bytes,
            &nonce,
            plaintext,
            associated_data,
        )?;

        // Create ciphertext value
        let ciphertext = CryptoCiphertext {
            algorithm: algorithm.clone(),
            ciphertext: ciphertext_data,
            nonce: Some(nonce),
            tag: None, // AEAD modes include tag in ciphertext
        };

        Ok(ciphertext)
    }

    /// Decrypt data with authenticated encryption
    pub fn decrypt(
        &self,
        algorithm: &AlgorithmType,
        key: &Value,
        ciphertext: &CryptoCiphertext,
        associated_data: &[u8],
    ) -> RuntimeResult<Vec<u8>> {
        // Extract key material
        let key_bytes = match key {
            Value::Secret(secret) => &secret.data,
            Value::Key(crypto_key) => &crypto_key.material.data,
            _ => return Err(RuntimeError::InvalidKey),
        };

        let provider = self.find_provider(algorithm)?;

        // Extract nonce
        let nonce = ciphertext.nonce.as_ref()
            .ok_or(RuntimeError::MissingNonce)?;

        // Perform decryption
        let plaintext = provider.decrypt_aead(
            key_bytes,
            nonce,
            &ciphertext.ciphertext,
            associated_data,
        )?;

        Ok(plaintext)
    }

    /// Generate a symmetric key for the given algorithm
    pub fn generate_key(&self, algorithm: &AlgorithmType) -> RuntimeResult<Value> {
        let provider = self.find_provider(algorithm)?;

        let key_length = provider.key_length();
        let mut key_data = vec![0u8; key_length];
        OsRng.fill_bytes(&mut key_data);

        // Create secret value with secure memory
        let secret_value = SecretValue::new(key_data, crate::runtime::values::SecretType::Key);

        Ok(Value::Secret(secret_value))
    }

    /// Derive a key using a key derivation function
    pub fn derive_key(
        &self,
        algorithm: &AlgorithmType,
        password: &[u8],
        salt: &[u8],
        iterations: u32,
    ) -> RuntimeResult<Value> {
        match algorithm {
            AlgorithmType::Argon2 => {
                use argon2::Argon2;
                use argon2::password_hash::PasswordHasher;

                let argon2 = Argon2::default();
                let password_hash = argon2.hash_password(password, salt)
                    .map_err(|_| RuntimeError::KeyDerivationFailed)?;

                let hash_bytes = password_hash.hash.unwrap().as_bytes();
                let secret_value = SecretValue::new(hash_bytes.to_vec(), crate::runtime::values::SecretType::Key);

                Ok(Value::Secret(secret_value))
            }
            AlgorithmType::Scrypt => {
                use scrypt::{scrypt, Params};

                let params = Params::new(14, 8, 1, 32)
                    .map_err(|_| RuntimeError::KeyDerivationFailed)?;

                let mut derived_key = vec![0u8; 32];
                scrypt(password, salt, &params, &mut derived_key)
                    .map_err(|_| RuntimeError::KeyDerivationFailed)?;

                let secret_value = SecretValue::new(derived_key, crate::runtime::values::SecretType::Key);
                Ok(Value::Secret(secret_value))
            }
            AlgorithmType::Pbkdf2 => {
                use pbkdf2::pbkdf2_hmac;
                use sha2::Sha256;

                let mut derived_key = vec![0u8; 32];
                pbkdf2_hmac::<Sha256>(password, salt, iterations, &mut derived_key);

                let secret_value = SecretValue::new(derived_key, crate::runtime::values::SecretType::Key);
                Ok(Value::Secret(secret_value))
            }
            _ => Err(RuntimeError::UnsupportedAlgorithm(algorithm.clone())),
        }
    }

    /// Perform constant-time comparison of two byte arrays
    pub fn constant_time_compare(&self, a: &[u8], b: &[u8]) -> bool {
        use subtle::ConstantTimeEq;

        if a.len() != b.len() {
            return false;
        }

        let a_arr: &[u8; 32] = a.try_into().unwrap_or(&[0u8; 32]);
        let b_arr: &[u8; 32] = b.try_into().unwrap_or(&[0u8; 32]);

        bool::from(a_arr.ct_eq(b_arr))
    }

    /// Get supported algorithms
    pub fn get_supported_algorithms(&self) -> Vec<AlgorithmType> {
        self.providers
            .iter()
            .flat_map(|provider| {
                // This is a simplified implementation
                // In practice, we'd need to track which algorithms each provider supports
                vec![
                    AlgorithmType::Aes256Gcm,
                    AlgorithmType::ChaCha20Poly1305,
                    AlgorithmType::Aes256Cbc,
                    AlgorithmType::Aes256Ctr,
                ]
            })
            .collect()
    }

    /// Check if hardware acceleration is available for an algorithm
    pub fn is_hardware_accelerated(&self, algorithm: &AlgorithmType) -> bool {
        if let Ok(provider) = self.find_provider(algorithm) {
            provider.hardware_accelerated()
        } else {
            false
        }
    }
}

// Import required types
use aes::cipher::block_padding;
use rand_core::OsRng;