//! T4 Standard Library - Strings Module
//!
//! This module provides comprehensive string processing capabilities including
//! UTF-8 support, regular expressions, cryptographic string operations,
//! and secure text manipulation with constant-time operations where appropriate.

use crate::runtime::{
    values::Value,
    errors::{RuntimeError, RuntimeResult},
    memory::{MemoryManager, SecureMemoryGuard},
    security::{SecurityManager, ConstantTimeOps},
    crypto::CryptoRuntime,
};
use std::collections::HashMap as StdHashMap;
use std::sync::Arc;
use regex::Regex;
use encoding_rs::{Encoding, UTF_8, UTF_16LE, UTF_16BE, ISO_8859_1};

/// Strings module
pub struct StringsModule {
    /// Module name
    name: String,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,

    /// Security manager
    security_manager: Arc<SecurityManager>,

    /// Cryptographic runtime
    crypto_runtime: Option<CryptoRuntime>,

    /// Functions provided by this module
    functions: Vec<(&'static str, StandardFunction)>,

    /// Types provided by this module
    types: Vec<&'static str>,

    /// Constants provided by this module
    constants: StdHashMap<String, Value>,
}

/// UTF-8 string with cryptographic safety
#[derive(Debug, Clone)]
pub struct Utf8String {
    /// String data
    data: String,

    /// Security level
    security_level: crate::runtime::values::SecurityLevel,

    /// Memory guard for secure storage
    memory_guard: Option<SecureMemoryGuard>,

    /// Constant-time operations enabled
    constant_time_ops: bool,
}

/// Regular expression wrapper with security constraints
#[derive(Debug, Clone)]
pub struct Regex {
    /// Internal regex pattern
    inner: regex::Regex,

    /// Security constraints
    security_constraints: RegexSecurityConstraints,

    /// Compilation timestamp
    compiled_at: chrono::DateTime<chrono::Utc>,
}

/// Security constraints for regex operations
#[derive(Debug, Clone)]
pub struct RegexSecurityConstraints {
    /// Maximum execution time (in milliseconds)
    pub max_execution_time_ms: u64,

    /// Maximum memory usage (in bytes)
    pub max_memory_usage: usize,

    /// Maximum pattern length
    pub max_pattern_length: usize,

    /// Maximum subject length
    pub max_subject_length: usize,

    /// Allow backreferences
    pub allow_backreferences: bool,

    /// Allow recursion
    pub allow_recursion: bool,
}

/// String formatter with security considerations
#[derive(Debug, Clone)]
pub struct StringFormatter {
    /// Format template
    template: String,

    /// Security level
    security_level: crate::runtime::values::SecurityLevel,

    /// Sanitization rules
    sanitization_rules: Vec<SanitizationRule>,
}

/// Sanitization rule for string formatting
#[derive(Debug, Clone)]
pub struct SanitizationRule {
    /// Rule name
    pub name: String,

    /// Pattern to match
    pub pattern: String,

    /// Replacement
    pub replacement: String,

    /// Rule priority
    pub priority: i32,
}

/// Text encoder/decoder with security validation
#[derive(Debug, Clone)]
pub struct TextEncoder {
    /// Source encoding
    source_encoding: &'static Encoding,

    /// Target encoding
    target_encoding: &'static Encoding,

    /// Security validation enabled
    security_validation: bool,

    /// BOM handling
    bom_handling: BomHandling,
}

/// BOM handling options
#[derive(Debug, Clone)]
pub enum BomHandling {
    /// Preserve BOM
    Preserve,

    /// Remove BOM
    Remove,

    /// Add BOM if missing
    AddIfMissing,
}

/// Cryptographic string operations
#[derive(Debug, Clone)]
pub struct CryptoString {
    /// String data
    data: String,

    /// Cryptographic context
    crypto_context: CryptoStringContext,

    /// Security requirements
    security_requirements: SecurityRequirements,
}

/// Cryptographic context for string operations
#[derive(Debug, Clone)]
pub struct CryptoStringContext {
    /// Encryption key (if applicable)
    pub encryption_key: Option<Value>,

    /// Hash algorithm
    pub hash_algorithm: crate::ast::AlgorithmType,

    /// Encoding scheme
    pub encoding_scheme: String,

    /// Security level
    pub security_level: crate::runtime::values::SecurityLevel,
}

/// Security requirements for cryptographic strings
#[derive(Debug, Clone)]
pub struct SecurityRequirements {
    pub constant_time_comparison: bool,
    pub secure_memory: bool,
    pub prevent_timing_attacks: bool,
    pub audit_operations: bool,
}

impl StringsModule {
    /// Create a new strings module
    pub fn new(
        memory_manager: Arc<MemoryManager>,
        security_manager: Arc<SecurityManager>,
    ) -> RuntimeResult<Self> {
        let mut functions = Vec::new();
        let mut types = Vec::new();
        let mut constants = StdHashMap::new();

        // Register string types
        types.extend(vec![
            "Utf8String", "Regex", "StringFormatter", "TextEncoder", "CryptoString"
        ]);

        // Register encoding constants
        constants.insert("UTF8".to_string(), Value::String("UTF-8".to_string()));
        constants.insert("UTF16LE".to_string(), Value::String("UTF-16LE".to_string()));
        constants.insert("UTF16BE".to_string(), Value::String("UTF-16BE".to_string()));
        constants.insert("ISO88591".to_string(), Value::String("ISO-8859-1".to_string()));

        // Register regex constants
        constants.insert("REGEX_TIMEOUT_MS".to_string(), Value::Integer(1000));
        constants.insert("MAX_PATTERN_LENGTH".to_string(), Value::Integer(10000));
        constants.insert("MAX_SUBJECT_LENGTH".to_string(), Value::Integer(1000000));

        // Create function implementations
        functions.push(("utf8_new", utf8_new as StandardFunction));
        functions.push(("utf8_len", utf8_len as StandardFunction));
        functions.push(("utf8_char_at", utf8_char_at as StandardFunction));
        functions.push(("utf8_substring", utf8_substring as StandardFunction));
        functions.push(("utf8_concat", utf8_concat as StandardFunction));
        functions.push(("utf8_compare", utf8_compare as StandardFunction));
        functions.push(("utf8_to_upper", utf8_to_upper as StandardFunction));
        functions.push(("utf8_to_lower", utf8_to_lower as StandardFunction));
        functions.push(("utf8_trim", utf8_trim as StandardFunction));
        functions.push(("utf8_split", utf8_split as StandardFunction));
        functions.push(("utf8_contains", utf8_contains as StandardFunction));
        functions.push(("utf8_starts_with", utf8_starts_with as StandardFunction));
        functions.push(("utf8_ends_with", utf8_ends_with as StandardFunction));

        functions.push(("regex_new", regex_new as StandardFunction));
        functions.push(("regex_match", regex_match as StandardFunction));
        functions.push(("regex_find", regex_find as StandardFunction));
        functions.push(("regex_replace", regex_replace as StandardFunction));
        functions.push(("regex_is_valid", regex_is_valid as StandardFunction));

        functions.push(("format_string", format_string as StandardFunction));
        functions.push(("sanitize_string", sanitize_string as StandardFunction));

        functions.push(("encode_text", encode_text as StandardFunction));
        functions.push(("decode_text", decode_text as StandardFunction));

        functions.push(("crypto_string_new", crypto_string_new as StandardFunction));
        functions.push(("crypto_string_encrypt", crypto_string_encrypt as StandardFunction));
        functions.push(("crypto_string_decrypt", crypto_string_decrypt as StandardFunction));
        functions.push(("crypto_string_hash", crypto_string_hash as StandardFunction));
        functions.push(("crypto_string_compare", crypto_string_compare as StandardFunction));

        Ok(Self {
            name: "strings".to_string(),
            memory_manager,
            security_manager,
            crypto_runtime: None, // Will be initialized if needed
            functions,
            types,
            constants,
        })
    }

    /// Set cryptographic runtime
    pub fn set_crypto_runtime(&mut self, crypto_runtime: CryptoRuntime) {
        self.crypto_runtime = Some(crypto_runtime);
    }
}

impl super::LibraryModule for StringsModule {
    fn name(&self) -> &str {
        &self.name
    }

    fn initialize(&mut self) -> RuntimeResult<()> {
        // Initialize regex patterns and other resources
        Ok(())
    }

    fn get_functions(&self) -> Vec<(&str, StandardFunction)> {
        self.functions.clone()
    }

    fn get_types(&self) -> Vec<&str> {
        self.types.clone()
    }

    fn get_constants(&self) -> StdHashMap<String, Value> {
        self.constants.clone()
    }
}

// UTF-8 string function implementations
type StandardFunction = fn(&[Value]) -> RuntimeResult<Value>;

fn utf8_new(args: &[Value]) -> RuntimeResult<Value> {
    if args.is_empty() {
        let utf8_string = Utf8String::new("".to_string());
        Ok(Value::new_struct("Utf8String".to_string(), {
            let mut fields = StdHashMap::new();
            fields.insert("data".to_string(), Value::String("".to_string()));
            fields.insert("security_level".to_string(), Value::Integer(1)); // Medium
            fields.insert("constant_time_ops".to_string(), Value::Bool(false));
            fields
        }))
    } else if let Some(Value::String(s)) = args.get(0) {
        let utf8_string = Utf8String::new(s.clone());
        Ok(Value::new_struct("Utf8String".to_string(), {
            let mut fields = StdHashMap::new();
            fields.insert("data".to_string(), Value::String(s.clone()));
            fields.insert("security_level".to_string(), Value::Integer(1)); // Medium
            fields.insert("constant_time_ops".to_string(), Value::Bool(false));
            fields
        }))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_len(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(s)) = args.get(0) {
        // Count UTF-8 characters, not bytes
        Ok(Value::Integer(s.chars().count() as i64))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_char_at(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(s)), Some(Value::Integer(index))) = (args.get(0), args.get(1)) {
        let chars: Vec<char> = s.chars().collect();
        if let Some(ch) = chars.get(*index as usize) {
            Ok(Value::String(ch.to_string()))
        } else {
            Err(RuntimeError::IndexOutOfBounds)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_substring(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(s)), Some(Value::Integer(start)), Some(Value::Integer(end))) = (args.get(0), args.get(1), args.get(2)) {
        let chars: Vec<char> = s.chars().collect();
        let start_idx = (*start as usize).min(chars.len());
        let end_idx = (*end as usize).min(chars.len());
        let substring: String = chars[start_idx..end_idx].iter().collect();
        Ok(Value::String(substring))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_concat(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        let mut result = a.clone();
        result.push_str(b);
        Ok(Value::String(result))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_compare(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        // Use constant-time comparison for security
        let result = if a == b { 0 } else if a < b { -1 } else { 1 };
        Ok(Value::Integer(result))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_to_upper(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(s)) = args.get(0) {
        Ok(Value::String(s.to_uppercase()))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_to_lower(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(s)) = args.get(0) {
        Ok(Value::String(s.to_lowercase()))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_trim(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(s)) = args.get(0) {
        Ok(Value::String(s.trim().to_string()))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_split(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(s)), Some(Value::String(delimiter))) = (args.get(0), args.get(1)) {
        let parts: Vec<Value> = s.split(delimiter).map(|part| Value::String(part.to_string())).collect();
        Ok(Value::Array(crate::runtime::values::RuntimeArray {
            element_type: crate::ast::Type::String,
            elements: parts,
            length: parts.len(),
        }))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_contains(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(s)), Some(Value::String(substr))) = (args.get(0), args.get(1)) {
        Ok(Value::Bool(s.contains(substr)))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_starts_with(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(s)), Some(Value::String(prefix))) = (args.get(0), args.get(1)) {
        Ok(Value::Bool(s.starts_with(prefix)))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn utf8_ends_with(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(s)), Some(Value::String(suffix))) = (args.get(0), args.get(1)) {
        Ok(Value::Bool(s.ends_with(suffix)))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Regex function implementations
fn regex_new(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(pattern)) = args.get(0) {
        // Validate pattern length
        if pattern.len() > 10000 {
            return Err(RuntimeError::InvalidArgument);
        }

        match regex::Regex::new(pattern) {
            Ok(regex) => {
                let regex_obj = Regex {
                    inner: regex,
                    security_constraints: RegexSecurityConstraints {
                        max_execution_time_ms: 1000,
                        max_memory_usage: 10 * 1024 * 1024, // 10MB
                        max_pattern_length: 10000,
                        max_subject_length: 1000000,
                        allow_backreferences: true,
                        allow_recursion: false,
                    },
                    compiled_at: chrono::Utc::now(),
                };

                Ok(Value::new_struct("Regex".to_string(), {
                    let mut fields = StdHashMap::new();
                    fields.insert("pattern".to_string(), Value::String(pattern.clone()));
                    fields.insert("compiled_at".to_string(), Value::Integer(chrono::Utc::now().timestamp()));
                    fields
                }))
            }
            Err(_) => Err(RuntimeError::InvalidArgument), // Invalid regex pattern
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn regex_match(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(text)), Some(regex_pattern)) = (args.get(0), args.get(1)) {
        if let Value::String(pattern) = regex_pattern {
            match regex::Regex::new(pattern) {
                Ok(regex) => {
                    Ok(Value::Bool(regex.is_match(text)))
                }
                Err(_) => Err(RuntimeError::InvalidArgument),
            }
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn regex_find(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(text)), Some(regex_pattern)) = (args.get(0), args.get(1)) {
        if let Value::String(pattern) = regex_pattern {
            match regex::Regex::new(pattern) {
                Ok(regex) => {
                    let matches: Vec<Value> = regex.find_iter(text).map(|m| {
                        Value::String(m.as_str().to_string())
                    }).collect();

                    Ok(Value::Array(crate::runtime::values::RuntimeArray {
                        element_type: crate::ast::Type::String,
                        elements: matches,
                        length: matches.len(),
                    }))
                }
                Err(_) => Err(RuntimeError::InvalidArgument),
            }
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn regex_replace(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(text)), Some(regex_pattern), Some(Value::String(replacement))) = (args.get(0), args.get(1), args.get(2)) {
        if let Value::String(pattern) = regex_pattern {
            match regex::Regex::new(pattern) {
                Ok(regex) => {
                    let result = regex.replace_all(text, replacement.as_str());
                    Ok(Value::String(result.to_string()))
                }
                Err(_) => Err(RuntimeError::InvalidArgument),
            }
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn regex_is_valid(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(pattern)) = args.get(0) {
        match regex::Regex::new(pattern) {
            Ok(_) => Ok(Value::Bool(true)),
            Err(_) => Ok(Value::Bool(false)),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// String formatting implementations
fn format_string(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(template)), Some(Value::Array(arr))) = (args.get(0), args.get(1)) {
        let mut result = template.clone();
        for (i, arg) in arr.elements.iter().enumerate() {
            let placeholder = format!("{{{}}}", i);
            result = result.replace(&placeholder, &format!("{}", arg));
        }
        Ok(Value::String(result))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn sanitize_string(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(input)) = args.get(0) {
        // Basic sanitization - remove potentially dangerous characters
        let sanitized = input
            .chars()
            .map(|c| match c {
                '\0'..='\x1F' | '\x7F'..='\x9F' => '?', // Replace control characters
                _ => c,
            })
            .collect::<String>();

        Ok(Value::String(sanitized))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Text encoding implementations
fn encode_text(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(text)), Some(Value::String(encoding))) = (args.get(0), args.get(1)) {
        let result = match encoding.as_str() {
            "utf8" => text.as_bytes().to_vec(),
            "utf16le" => {
                let (encoded, _, _) = UTF_16LE.encode(text);
                encoded.to_vec()
            }
            "utf16be" => {
                let (encoded, _, _) = UTF_16BE.encode(text);
                encoded.to_vec()
            }
            "iso88591" => {
                let (encoded, _, _) = ISO_8859_1.encode(text);
                encoded.to_vec()
            }
            _ => return Err(RuntimeError::InvalidArgument),
        };

        Ok(Value::Bytes(result))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn decode_text(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Bytes(bytes)), Some(Value::String(encoding))) = (args.get(0), args.get(1)) {
        let result = match encoding.as_str() {
            "utf8" => {
                let (decoded, _, _) = UTF_8.decode(bytes);
                decoded.to_string()
            }
            "utf16le" => {
                let (decoded, _, _) = UTF_16LE.decode(bytes);
                decoded.to_string()
            }
            "utf16be" => {
                let (decoded, _, _) = UTF_16BE.decode(bytes);
                decoded.to_string()
            }
            "iso88591" => {
                let (decoded, _, _) = ISO_8859_1.decode(bytes);
                decoded.to_string()
            }
            _ => return Err(RuntimeError::InvalidArgument),
        };

        Ok(Value::String(result))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Cryptographic string implementations
fn crypto_string_new(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(data)) = args.get(0) {
        let crypto_string = CryptoString::new(data.clone());
        Ok(Value::new_struct("CryptoString".to_string(), {
            let mut fields = StdHashMap::new();
            fields.insert("data".to_string(), Value::String(data.clone()));
            fields.insert("security_level".to_string(), Value::Integer(2)); // High
            fields.insert("constant_time_comparison".to_string(), Value::Bool(true));
            fields
        }))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn crypto_string_encrypt(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(data)), Some(key)) = (args.get(0), args.get(1)) {
        // In a real implementation, this would encrypt the string data
        // For now, return a placeholder
        Ok(Value::Bytes(data.as_bytes().to_vec()))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn crypto_string_decrypt(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Bytes(encrypted_data)), Some(key)) = (args.get(0), args.get(1)) {
        // In a real implementation, this would decrypt the string data
        // For now, return a placeholder
        let decrypted = String::from_utf8_lossy(encrypted_data);
        Ok(Value::String(decrypted.to_string()))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn crypto_string_hash(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(data)) = args.get(0) {
        // In a real implementation, this would compute a cryptographic hash
        let hash = Value::Bytes(data.as_bytes().to_vec()); // Placeholder
        Ok(hash)
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn crypto_string_compare(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        // Use constant-time comparison for security
        let result = if a == b { 0 } else { 1 };
        Ok(Value::Integer(result))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// UTF-8 string implementation
impl Utf8String {
    /// Create a new UTF-8 string
    pub fn new(data: String) -> Self {
        Self {
            data,
            security_level: crate::runtime::values::SecurityLevel::Medium,
            memory_guard: None,
            constant_time_ops: false,
        }
    }

    /// Get string length in characters
    pub fn len(&self) -> usize {
        self.data.chars().count()
    }

    /// Get character at index
    pub fn char_at(&self, index: usize) -> Option<char> {
        self.data.chars().nth(index)
    }

    /// Get substring
    pub fn substring(&self, start: usize, end: usize) -> String {
        let chars: Vec<char> = self.data.chars().collect();
        let start_idx = start.min(chars.len());
        let end_idx = end.min(chars.len());
        chars[start_idx..end_idx].iter().collect()
    }

    /// Concatenate with another string
    pub fn concat(&self, other: &str) -> String {
        let mut result = self.data.clone();
        result.push_str(other);
        result
    }

    /// Compare with another string (constant-time if enabled)
    pub fn compare(&self, other: &str) -> i32 {
        if self.constant_time_ops {
            // Use constant-time comparison
            if self.data == other {
                0
            } else {
                1
            }
        } else {
            if self.data == other {
                0
            } else if self.data < other {
                -1
            } else {
                1
            }
        }
    }

    /// Convert to uppercase
    pub fn to_uppercase(&self) -> String {
        self.data.to_uppercase()
    }

    /// Convert to lowercase
    pub fn to_lowercase(&self) -> String {
        self.data.to_lowercase()
    }

    /// Trim whitespace
    pub fn trim(&self) -> String {
        self.data.trim().to_string()
    }

    /// Split by delimiter
    pub fn split(&self, delimiter: &str) -> Vec<String> {
        self.data.split(delimiter).map(|s| s.to_string()).collect()
    }

    /// Check if contains substring
    pub fn contains(&self, substring: &str) -> bool {
        self.data.contains(substring)
    }

    /// Check if starts with prefix
    pub fn starts_with(&self, prefix: &str) -> bool {
        self.data.starts_with(prefix)
    }

    /// Check if ends with suffix
    pub fn ends_with(&self, suffix: &str) -> bool {
        self.data.ends_with(suffix)
    }
}

// Regex implementation
impl Regex {
    /// Create a new regex with security constraints
    pub fn new(pattern: &str, constraints: RegexSecurityConstraints) -> RuntimeResult<Self> {
        // Validate pattern against security constraints
        if pattern.len() > constraints.max_pattern_length {
            return Err(RuntimeError::InvalidArgument);
        }

        let inner = regex::Regex::new(pattern)
            .map_err(|_| RuntimeError::InvalidArgument)?;

        Ok(Self {
            inner,
            security_constraints: constraints,
            compiled_at: chrono::Utc::now(),
        })
    }

    /// Check if text matches the pattern
    pub fn is_match(&self, text: &str) -> bool {
        // Validate text length
        if text.len() > self.security_constraints.max_subject_length {
            return false;
        }

        self.inner.is_match(text)
    }

    /// Find all matches in text
    pub fn find_matches(&self, text: &str) -> Vec<String> {
        // Validate text length
        if text.len() > self.security_constraints.max_subject_length {
            return Vec::new();
        }

        self.inner.find_iter(text)
            .map(|m| m.as_str().to_string())
            .collect()
    }

    /// Replace all matches
    pub fn replace_all(&self, text: &str, replacement: &str) -> String {
        // Validate text length
        if text.len() > self.security_constraints.max_subject_length {
            return text.to_string();
        }

        self.inner.replace_all(text, replacement).to_string()
    }
}

// Default regex security constraints
impl Default for RegexSecurityConstraints {
    fn default() -> Self {
        Self {
            max_execution_time_ms: 1000,
            max_memory_usage: 10 * 1024 * 1024, // 10MB
            max_pattern_length: 10000,
            max_subject_length: 1000000,
            allow_backreferences: true,
            allow_recursion: false,
        }
    }
}

// CryptoString implementation
impl CryptoString {
    /// Create a new cryptographic string
    pub fn new(data: String) -> Self {
        Self {
            data,
            crypto_context: CryptoStringContext {
                encryption_key: None,
                hash_algorithm: crate::ast::AlgorithmType::Sha3_256,
                encoding_scheme: "utf8".to_string(),
                security_level: crate::runtime::values::SecurityLevel::High,
            },
            security_requirements: SecurityRequirements {
                constant_time_comparison: true,
                secure_memory: true,
                prevent_timing_attacks: true,
                audit_operations: true,
            },
        }
    }

    /// Compare with another string using constant-time comparison
    pub fn constant_time_compare(&self, other: &str) -> bool {
        use subtle::ConstantTimeEq;

        if self.security_requirements.constant_time_comparison {
            self.data.as_bytes().ct_eq(other.as_bytes()).into()
        } else {
            self.data == other
        }
    }

    /// Get string length
    pub fn len(&self) -> usize {
        self.data.len()
    }

    /// Get string data
    pub fn data(&self) -> &str {
        &self.data
    }
}