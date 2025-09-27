//! T4 Runtime Value System
//!
//! This module implements runtime value representation for all T4 types,
//! including primitives, cryptographic types, arrays, and structs.
//! It also handles secret value management with memory wiping.

use crate::ast::{Type, AlgorithmType, Literal};
use crate::runtime::{
    memory::{MemoryManager, SecureMemoryGuard, SecretGuard},
    crypto::{CryptoValue, KeyMaterial},
    errors::{RuntimeError, RuntimeResult},
};
use serde::{Deserialize, Serialize};
use std::collections::HashMap;
use std::sync::Arc;
use zeroize::Zeroize;

/// Runtime value representation
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub enum Value {
    // Primitive types
    Unit,
    Bool(bool),
    Integer(i64),
    Float(f64),
    String(String),
    Bytes(Vec<u8>),

    // Cryptographic types
    Key(CryptoKey),
    Secret(SecretValue),
    PublicKey(CryptoPublicKey),
    PrivateKey(CryptoPrivateKey),
    Signature(CryptoSignature),
    Ciphertext(CryptoCiphertext),
    Plaintext(CryptoPlaintext),
    Hash(CryptoHash),
    Nonce(CryptoNonce),
    Salt(CryptoSalt),

    // Complex types
    Array(RuntimeArray),
    Tuple(RuntimeTuple),
    Struct(RuntimeStruct),
    Enum(RuntimeEnum),

    // Function values
    Function(Box<RuntimeFunction>),
    BuiltinFunction(BuiltinFunction),

    // Reference types
    Reference(Box<Value>),
    MutableReference(Box<Value>),
}

/// Cryptographic key value
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoKey {
    /// Key algorithm
    pub algorithm: AlgorithmType,

    /// Key material (stored securely)
    pub material: KeyMaterial,

    /// Key metadata
    pub metadata: KeyMetadata,
}

/// Secret value with automatic memory management
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct SecretValue {
    /// The secret data
    pub data: Vec<u8>,

    /// Secret type information
    pub secret_type: SecretType,

    /// Security requirements
    pub security_requirements: SecurityRequirements,
}

/// Runtime array
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct RuntimeArray {
    /// Element type
    pub element_type: Type,

    /// Array elements
    pub elements: Vec<Value>,

    /// Array length
    pub length: usize,
}

/// Runtime tuple
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct RuntimeTuple {
    /// Tuple elements
    pub elements: Vec<Value>,
}

/// Runtime struct
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct RuntimeStruct {
    /// Struct name
    pub name: String,

    /// Struct fields
    pub fields: HashMap<String, Value>,
}

/// Runtime enum
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct RuntimeEnum {
    /// Enum name
    pub name: String,

    /// Variant name
    pub variant: String,

    /// Variant data
    pub data: Option<Box<Value>>,
}

/// Runtime function
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct RuntimeFunction {
    /// Function name
    pub name: String,

    /// Function parameters
    pub parameters: Vec<ParameterInfo>,

    /// Return type
    pub return_type: Option<Type>,

    /// Function body (for interpreted functions)
    pub body: Option<Vec<crate::ast::Statement>>,

    /// Security annotations
    pub security_annotations: Vec<crate::ast::SecurityAnnotation>,
}

/// Built-in function
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct BuiltinFunction {
    /// Function name
    pub name: String,

    /// Function pointer
    pub function_ptr: usize,

    /// Parameter types
    pub param_types: Vec<Type>,

    /// Return type
    pub return_type: Option<Type>,
}

/// Parameter information
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct ParameterInfo {
    pub name: String,
    pub typ: Type,
    pub mutable: bool,
    pub reference: bool,
}

/// Secret type enumeration
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub enum SecretType {
    Key,
    Password,
    Token,
    KeyMaterial,
    Generic,
}

/// Security requirements for values
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct SecurityRequirements {
    pub constant_time: bool,
    pub secure_memory: bool,
    pub hardware_protection: bool,
    pub auto_wipe: bool,
}

/// Key metadata
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct KeyMetadata {
    pub key_id: String,
    pub created_at: chrono::DateTime<chrono::Utc>,
    pub algorithm_version: String,
    pub security_level: SecurityLevel,
}

/// Security level
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub enum SecurityLevel {
    Low,
    Medium,
    High,
    Critical,
}

/// Cryptographic value trait
pub trait CryptoValue {
    fn algorithm(&self) -> AlgorithmType;
    fn size(&self) -> usize;
    fn is_secret(&self) -> bool;
    fn security_level(&self) -> SecurityLevel;
}

/// Cryptographic public key
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoPublicKey {
    pub algorithm: AlgorithmType,
    pub key_data: Vec<u8>,
    pub metadata: KeyMetadata,
}

/// Cryptographic private key
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoPrivateKey {
    pub algorithm: AlgorithmType,
    pub key_data: SecretValue,
    pub metadata: KeyMetadata,
}

/// Cryptographic signature
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoSignature {
    pub algorithm: AlgorithmType,
    pub signature_data: Vec<u8>,
    pub metadata: SignatureMetadata,
}

/// Cryptographic ciphertext
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoCiphertext {
    pub algorithm: AlgorithmType,
    pub ciphertext: Vec<u8>,
    pub nonce: Option<Vec<u8>>,
    pub tag: Option<Vec<u8>>,
}

/// Cryptographic plaintext
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoPlaintext {
    pub data: Vec<u8>,
    pub encoding: String,
}

/// Cryptographic hash
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoHash {
    pub algorithm: AlgorithmType,
    pub hash_value: Vec<u8>,
    pub metadata: HashMetadata,
}

/// Cryptographic nonce
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoNonce {
    pub nonce_data: Vec<u8>,
    pub used: bool,
}

/// Cryptographic salt
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct CryptoSalt {
    pub salt_data: Vec<u8>,
}

/// Signature metadata
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct SignatureMetadata {
    pub signature_id: String,
    pub signed_at: chrono::DateTime<chrono::Utc>,
    pub algorithm_version: String,
}

/// Hash metadata
#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct HashMetadata {
    pub hash_id: String,
    pub computed_at: chrono::DateTime<chrono::Utc>,
    pub algorithm_version: String,
}

impl Value {
    /// Create a value from a literal
    pub fn from_literal(literal: &Literal) -> Self {
        match literal {
            Literal::Integer(s) => {
                if let Ok(i) = s.parse::<i64>() {
                    Value::Integer(i)
                } else {
                    Value::Integer(0)
                }
            }
            Literal::Float(s) => {
                if let Ok(f) = s.parse::<f64>() {
                    Value::Float(f)
                } else {
                    Value::Float(0.0)
                }
            }
            Literal::String(s) => Value::String(s.clone()),
            Literal::Bool(b) => Value::Bool(*b),
            Literal::ByteString(bytes) => Value::Bytes(bytes.clone()),
            Literal::Char(c) => Value::Integer(*c as i64),
        }
    }

    /// Get the type of this value
    pub fn get_type(&self) -> Type {
        match self {
            Value::Unit => Type::Unit,
            Value::Bool(_) => Type::Bool,
            Value::Integer(_) => Type::Int64,
            Value::Float(_) => Type::Float64,
            Value::String(_) => Type::String,
            Value::Bytes(_) => Type::Bytes,
            Value::Key(key) => Type::Key(key.algorithm.clone()),
            Value::Secret(secret) => Type::Secret(Box::new(Type::Bytes)), // Simplified
            Value::PublicKey(key) => Type::PublicKey(key.algorithm.clone()),
            Value::PrivateKey(key) => Type::PrivateKey(key.algorithm.clone()),
            Value::Signature(sig) => Type::Signature(sig.algorithm.clone()),
            Value::Ciphertext(ct) => Type::Ciphertext(ct.algorithm.clone()),
            Value::Plaintext(_) => Type::Plaintext(AlgorithmType::Aes256), // Simplified
            Value::Hash(hash) => Type::Hash(hash.algorithm.clone()),
            Value::Nonce(_) => Type::Nonce,
            Value::Salt(_) => Type::Salt,
            Value::Array(arr) => Type::Array(Box::new(arr.element_type.clone()), arr.length),
            Value::Tuple(tup) => Type::Tuple(tup.elements.iter().map(|v| v.get_type()).collect()),
            Value::Struct(s) => Type::Path {
                module: None,
                name: crate::ast::Identifier {
                    name: 0, // Simplified
                    span: crate::ast::SourceSpan {
                        location: crate::ast::SourceLocation {
                            start_line: 0,
                            start_column: 0,
                            end_line: 0,
                            end_column: 0,
                            file: 0,
                        }
                    },
                },
                args: Vec::new(),
            },
            Value::Enum(e) => Type::Path {
                module: None,
                name: crate::ast::Identifier {
                    name: 0, // Simplified
                    span: crate::ast::SourceSpan {
                        location: crate::ast::SourceLocation {
                            start_line: 0,
                            start_column: 0,
                            end_line: 0,
                            end_column: 0,
                            file: 0,
                        }
                    },
                },
                args: Vec::new(),
            },
            Value::Function(_) => Type::Function {
                params: Vec::new(),
                return_type: Box::new(Type::Unit),
            },
            Value::BuiltinFunction(_) => Type::Function {
                params: Vec::new(),
                return_type: Box::new(Type::Unit),
            },
            Value::Reference(_) => Type::Reference(Box::new(Type::Unit)), // Simplified
            Value::MutableReference(_) => Type::MutableReference(Box::new(Type::Unit)), // Simplified
        }
    }

    /// Check if this value is secret
    pub fn is_secret(&self) -> bool {
        matches!(
            self,
            Value::Secret(_) | Value::PrivateKey(_) | Value::Key(_)
        )
    }

    /// Get the size of this value in bytes
    pub fn size(&self) -> usize {
        match self {
            Value::Unit => 0,
            Value::Bool(_) => 1,
            Value::Integer(_) => 8,
            Value::Float(_) => 8,
            Value::String(s) => s.len(),
            Value::Bytes(b) => b.len(),
            Value::Key(key) => key.material.size(),
            Value::Secret(secret) => secret.data.len(),
            Value::PublicKey(key) => key.key_data.len(),
            Value::PrivateKey(key) => key.key_data.data.len(),
            Value::Signature(sig) => sig.signature_data.len(),
            Value::Ciphertext(ct) => ct.ciphertext.len(),
            Value::Plaintext(pt) => pt.data.len(),
            Value::Hash(hash) => hash.hash_value.len(),
            Value::Nonce(nonce) => nonce.nonce_data.len(),
            Value::Salt(salt) => salt.salt_data.len(),
            Value::Array(arr) => arr.elements.iter().map(|e| e.size()).sum(),
            Value::Tuple(tup) => tup.elements.iter().map(|e| e.size()).sum(),
            Value::Struct(s) => s.fields.values().map(|v| v.size()).sum(),
            Value::Enum(e) => e.data.as_ref().map_or(0, |d| d.size()),
            Value::Function(_) => 8, // Function pointer size
            Value::BuiltinFunction(_) => 8, // Function pointer size
            Value::Reference(_) => 8, // Pointer size
            Value::MutableReference(_) => 8, // Pointer size
        }
    }

    /// Create a new secret value
    pub fn new_secret(data: Vec<u8>, secret_type: SecretType) -> Self {
        Value::Secret(SecretValue {
            data,
            secret_type,
            security_requirements: SecurityRequirements {
                constant_time: true,
                secure_memory: true,
                hardware_protection: false,
                auto_wipe: true,
            },
        })
    }

    /// Create a new cryptographic key
    pub fn new_crypto_key(algorithm: AlgorithmType, material: KeyMaterial) -> Self {
        Value::Key(CryptoKey {
            algorithm,
            material,
            metadata: KeyMetadata {
                key_id: uuid::Uuid::new_v4().to_string(),
                created_at: chrono::Utc::now(),
                algorithm_version: "1.0".to_string(),
                security_level: SecurityLevel::High,
            },
        })
    }

    /// Create a new array value
    pub fn new_array(element_type: Type, elements: Vec<Value>) -> Self {
        Value::Array(RuntimeArray {
            element_type,
            elements,
            length: elements.len(),
        })
    }

    /// Create a new struct value
    pub fn new_struct(name: String, fields: HashMap<String, Value>) -> Self {
        Value::Struct(RuntimeStruct { name, fields })
    }

    /// Get a field from a struct value
    pub fn get_field(&self, field_name: &str) -> RuntimeResult<&Value> {
        match self {
            Value::Struct(s) => {
                s.fields.get(field_name).ok_or(RuntimeError::FieldNotFound(field_name.to_string()))
            }
            _ => Err(RuntimeError::NotAStruct),
        }
    }

    /// Set a field in a struct value
    pub fn set_field(&mut self, field_name: &str, value: Value) -> RuntimeResult<()> {
        match self {
            Value::Struct(s) => {
                s.fields.insert(field_name.to_string(), value);
                Ok(())
            }
            _ => Err(RuntimeError::NotAStruct),
        }
    }

    /// Get an element from an array value
    pub fn get_array_element(&self, index: usize) -> RuntimeResult<&Value> {
        match self {
            Value::Array(arr) => {
                arr.elements.get(index).ok_or(RuntimeError::IndexOutOfBounds)
            }
            _ => Err(RuntimeError::NotAnArray),
        }
    }

    /// Set an element in an array value
    pub fn set_array_element(&mut self, index: usize, value: Value) -> RuntimeResult<()> {
        match self {
            Value::Array(arr) => {
                if index < arr.elements.len() {
                    arr.elements[index] = value;
                    Ok(())
                } else {
                    Err(RuntimeError::IndexOutOfBounds)
                }
            }
            _ => Err(RuntimeError::NotAnArray),
        }
    }

    /// Clone this value with secure handling for secrets
    pub fn secure_clone(&self, memory_manager: &MemoryManager) -> RuntimeResult<Self> {
        match self {
            Value::Secret(secret) => {
                // For secrets, we need to handle memory carefully
                let mut new_data = secret.data.clone();
                Ok(Value::Secret(SecretValue {
                    data: new_data,
                    secret_type: secret.secret_type.clone(),
                    security_requirements: secret.security_requirements.clone(),
                }))
            }
            Value::PrivateKey(key) => {
                // Private keys need special handling
                let mut new_data = key.key_data.data.clone();
                Ok(Value::PrivateKey(CryptoPrivateKey {
                    algorithm: key.algorithm.clone(),
                    key_data: SecretValue {
                        data: new_data,
                        secret_type: SecretType::PrivateKey,
                        security_requirements: SecurityRequirements {
                            constant_time: true,
                            secure_memory: true,
                            hardware_protection: true,
                            auto_wipe: true,
                        },
                    },
                    metadata: key.metadata.clone(),
                }))
            }
            _ => {
                // For non-secret values, regular clone is fine
                Ok(self.clone())
            }
        }
    }

    /// Wipe this value if it contains secrets
    pub fn wipe(&mut self) -> RuntimeResult<()> {
        match self {
            Value::Secret(secret) => {
                secret.data.zeroize();
                Ok(())
            }
            Value::PrivateKey(key) => {
                key.key_data.data.zeroize();
                Ok(())
            }
            Value::Key(key) => {
                key.material.wipe();
                Ok(())
            }
            _ => {
                // Non-secret values don't need wiping
                Ok(())
            }
        }
    }

    /// Check if this value requires constant-time operations
    pub fn requires_constant_time(&self) -> bool {
        match self {
            Value::Secret(secret) => secret.security_requirements.constant_time,
            Value::PrivateKey(key) => key.key_data.security_requirements.constant_time,
            Value::Key(key) => key.material.requires_constant_time(),
            _ => false,
        }
    }

    /// Check if this value requires secure memory
    pub fn requires_secure_memory(&self) -> bool {
        match self {
            Value::Secret(secret) => secret.security_requirements.secure_memory,
            Value::PrivateKey(key) => key.key_data.security_requirements.secure_memory,
            Value::Key(key) => key.material.requires_secure_memory(),
            _ => false,
        }
    }
}

impl SecretValue {
    /// Create a new secret value
    pub fn new(data: Vec<u8>, secret_type: SecretType) -> Self {
        Self {
            data,
            secret_type,
            security_requirements: SecurityRequirements {
                constant_time: true,
                secure_memory: true,
                hardware_protection: false,
                auto_wipe: true,
            },
        }
    }

    /// Get the size of the secret data
    pub fn size(&self) -> usize {
        self.data.len()
    }

    /// Check if this secret requires constant-time operations
    pub fn requires_constant_time(&self) -> bool {
        self.security_requirements.constant_time
    }

    /// Check if this secret requires secure memory
    pub fn requires_secure_memory(&self) -> bool {
        self.security_requirements.secure_memory
    }

    /// Create a secret guard for this value
    pub fn create_guard(self, memory_manager: Arc<MemoryManager>) -> SecretGuard<Self> {
        SecretGuard::new(self, memory_manager)
    }
}

impl CryptoValue for CryptoKey {
    fn algorithm(&self) -> AlgorithmType {
        self.algorithm.clone()
    }

    fn size(&self) -> usize {
        self.material.size()
    }

    fn is_secret(&self) -> bool {
        true
    }

    fn security_level(&self) -> SecurityLevel {
        self.metadata.security_level.clone()
    }
}

impl CryptoValue for CryptoPublicKey {
    fn algorithm(&self) -> AlgorithmType {
        self.algorithm.clone()
    }

    fn size(&self) -> usize {
        self.key_data.len()
    }

    fn is_secret(&self) -> bool {
        false
    }

    fn security_level(&self) -> SecurityLevel {
        SecurityLevel::Medium
    }
}

impl CryptoValue for CryptoPrivateKey {
    fn algorithm(&self) -> AlgorithmType {
        self.algorithm.clone()
    }

    fn size(&self) -> usize {
        self.key_data.data.len()
    }

    fn is_secret(&self) -> bool {
        true
    }

    fn security_level(&self) -> SecurityLevel {
        SecurityLevel::Critical
    }
}

impl CryptoValue for CryptoSignature {
    fn algorithm(&self) -> AlgorithmType {
        self.algorithm.clone()
    }

    fn size(&self) -> usize {
        self.signature_data.len()
    }

    fn is_secret(&self) -> bool {
        false
    }

    fn security_level(&self) -> SecurityLevel {
        SecurityLevel::Medium
    }
}

impl CryptoValue for CryptoCiphertext {
    fn algorithm(&self) -> AlgorithmType {
        self.algorithm.clone()
    }

    fn size(&self) -> usize {
        self.ciphertext.len()
    }

    fn is_secret(&self) -> bool {
        true
    }

    fn security_level(&self) -> SecurityLevel {
        SecurityLevel::High
    }
}

impl CryptoValue for CryptoHash {
    fn algorithm(&self) -> AlgorithmType {
        self.algorithm.clone()
    }

    fn size(&self) -> usize {
        self.hash_value.len()
    }

    fn is_secret(&self) -> bool {
        false
    }

    fn security_level(&self) -> SecurityLevel {
        SecurityLevel::Low
    }
}

/// Display implementation for values (with security considerations)
impl std::fmt::Display for Value {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            Value::Unit => write!(f, "()"),
            Value::Bool(b) => write!(f, "{}", b),
            Value::Integer(i) => write!(f, "{}", i),
            Value::Float(fl) => write!(f, "{}", fl),
            Value::String(s) => write!(f, "\"{}\"", s),
            Value::Bytes(b) => write!(f, "Bytes[{}]", b.len()),
            Value::Key(key) => write!(f, "Key<{}>[{}]", key.algorithm, key.size()),
            Value::Secret(secret) => write!(f, "Secret<{}>[{}]", secret.secret_type, secret.size()),
            Value::PublicKey(key) => write!(f, "PublicKey<{}>[{}]", key.algorithm, key.size()),
            Value::PrivateKey(key) => write!(f, "PrivateKey<{}>[***]", key.algorithm),
            Value::Signature(sig) => write!(f, "Signature<{}>[{}]", sig.algorithm, sig.size()),
            Value::Ciphertext(ct) => write!(f, "Ciphertext<{}>[{}]", ct.algorithm, ct.size()),
            Value::Plaintext(pt) => write!(f, "Plaintext[{}]", pt.data.len()),
            Value::Hash(hash) => write!(f, "Hash<{}>[{}]", hash.algorithm, hash.size()),
            Value::Nonce(nonce) => write!(f, "Nonce[{}]", nonce.nonce_data.len()),
            Value::Salt(salt) => write!(f, "Salt[{}]", salt.salt_data.len()),
            Value::Array(arr) => write!(f, "Array[{}]", arr.length),
            Value::Tuple(tup) => write!(f, "Tuple({})", tup.elements.len()),
            Value::Struct(s) => write!(f, "Struct({})", s.name),
            Value::Enum(e) => write!(f, "Enum({}::{})", e.name, e.variant),
            Value::Function(func) => write!(f, "Function({})", func.name),
            Value::BuiltinFunction(builtin) => write!(f, "BuiltinFunction({})", builtin.name),
            Value::Reference(_) => write!(f, "&_"),
            Value::MutableReference(_) => write!(f, "&mut _"),
        }
    }
}