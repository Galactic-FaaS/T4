//! T4 Runtime Error System
//!
//! This module defines all runtime errors that can occur during T4 program execution,
//! including cryptographic errors, memory errors, and security violations.

use crate::ast::{AlgorithmType, SourceLocation};
use std::fmt;

/// Runtime error types
#[derive(Debug, Clone, PartialEq)]
pub enum RuntimeError {
    // General errors
    /// Undefined variable
    UndefinedVariable(String),

    /// Type error at runtime
    TypeError(String),

    /// Division by zero
    DivisionByZero,

    /// Index out of bounds
    IndexOutOfBounds,

    /// Invalid argument
    InvalidArgument,

    /// Invalid argument count
    InvalidArgumentCount,

    /// Not callable
    NotCallable,

    /// Not a struct
    NotAStruct,

    /// Not an array
    NotAnArray,

    /// Field not found
    FieldNotFound(String),

    /// Invalid binary operation
    InvalidBinaryOperation,

    /// Function not found
    FunctionNotFound(String),

    /// Invalid function call
    InvalidFunctionCall,

    // Memory errors
    /// Out of memory
    OutOfMemory,

    /// Memory access violation
    MemoryAccessViolation,

    /// Invalid memory layout
    InvalidLayout,

    /// Memory lock error
    LockError,

    /// Double free
    DoubleFree,

    /// Use after free
    UseAfterFree,

    // Cryptographic errors
    /// Invalid key
    InvalidKey,

    /// Invalid signature
    InvalidSignature,

    /// Invalid ciphertext
    InvalidCiphertext,

    /// Decryption failed
    DecryptionFailed,

    /// Key generation failed
    KeyGenerationFailed,

    /// Unsupported algorithm
    UnsupportedAlgorithm(AlgorithmType),

    /// Incompatible algorithms
    IncompatibleAlgorithms,

    /// Weak key detected
    WeakKey,

    /// Cryptographic operation failed
    CryptoOperationFailed(String),

    /// No crypto provider available
    NoCryptoProvider,

    /// No provider for algorithm
    NoProviderForAlgorithm(AlgorithmType),

    /// Provider not found
    ProviderNotFound(String),

    // Security errors
    /// Security violation
    SecurityViolation(String),

    /// Timing attack detected
    TimingAttackDetected,

    /// Side-channel leak detected
    SideChannelLeak,

    /// Authentication failed
    AuthenticationFailed,

    /// Authorization failed
    AuthorizationFailed,

    /// Constant-time violation
    ConstantTimeViolation,

    /// Memory safety violation
    MemorySafetyViolation,

    // I/O errors
    /// I/O error
    IOError,

    /// File not found
    FileNotFound(String),

    /// Permission denied
    PermissionDenied,

    /// Invalid file operation
    InvalidFileOperation,

    // System errors
    /// System call failed
    SystemCallFailed(String),

    /// Not implemented
    NotImplemented,

    /// Internal error
    InternalError(String),

    /// Stack overflow
    StackOverflow,

    /// Stack underflow
    StackUnderflow,

    /// Call stack corrupted
    CallStackCorrupted,
}

/// Runtime result type
pub type RuntimeResult<T> = Result<T, RuntimeError>;

impl fmt::Display for RuntimeError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            RuntimeError::UndefinedVariable(name) => {
                write!(f, "Undefined variable: {}", name)
            }
            RuntimeError::TypeError(msg) => {
                write!(f, "Type error: {}", msg)
            }
            RuntimeError::DivisionByZero => {
                write!(f, "Division by zero")
            }
            RuntimeError::IndexOutOfBounds => {
                write!(f, "Index out of bounds")
            }
            RuntimeError::InvalidArgument => {
                write!(f, "Invalid argument")
            }
            RuntimeError::InvalidArgumentCount => {
                write!(f, "Invalid argument count")
            }
            RuntimeError::NotCallable => {
                write!(f, "Value is not callable")
            }
            RuntimeError::NotAStruct => {
                write!(f, "Value is not a struct")
            }
            RuntimeError::NotAnArray => {
                write!(f, "Value is not an array")
            }
            RuntimeError::FieldNotFound(name) => {
                write!(f, "Field not found: {}", name)
            }
            RuntimeError::InvalidBinaryOperation => {
                write!(f, "Invalid binary operation")
            }
            RuntimeError::FunctionNotFound(name) => {
                write!(f, "Function not found: {}", name)
            }
            RuntimeError::InvalidFunctionCall => {
                write!(f, "Invalid function call")
            }
            RuntimeError::OutOfMemory => {
                write!(f, "Out of memory")
            }
            RuntimeError::MemoryAccessViolation => {
                write!(f, "Memory access violation")
            }
            RuntimeError::InvalidLayout => {
                write!(f, "Invalid memory layout")
            }
            RuntimeError::LockError => {
                write!(f, "Memory lock error")
            }
            RuntimeError::DoubleFree => {
                write!(f, "Double free detected")
            }
            RuntimeError::UseAfterFree => {
                write!(f, "Use after free detected")
            }
            RuntimeError::InvalidKey => {
                write!(f, "Invalid cryptographic key")
            }
            RuntimeError::InvalidSignature => {
                write!(f, "Invalid signature")
            }
            RuntimeError::InvalidCiphertext => {
                write!(f, "Invalid ciphertext")
            }
            RuntimeError::DecryptionFailed => {
                write!(f, "Decryption failed")
            }
            RuntimeError::KeyGenerationFailed => {
                write!(f, "Key generation failed")
            }
            RuntimeError::UnsupportedAlgorithm(alg) => {
                write!(f, "Unsupported algorithm: {}", alg)
            }
            RuntimeError::IncompatibleAlgorithms => {
                write!(f, "Incompatible algorithms")
            }
            RuntimeError::WeakKey => {
                write!(f, "Weak cryptographic key detected")
            }
            RuntimeError::CryptoOperationFailed(msg) => {
                write!(f, "Cryptographic operation failed: {}", msg)
            }
            RuntimeError::NoCryptoProvider => {
                write!(f, "No cryptographic provider available")
            }
            RuntimeError::NoProviderForAlgorithm(alg) => {
                write!(f, "No provider available for algorithm: {}", alg)
            }
            RuntimeError::ProviderNotFound(name) => {
                write!(f, "Cryptographic provider not found: {}", name)
            }
            RuntimeError::SecurityViolation(msg) => {
                write!(f, "Security violation: {}", msg)
            }
            RuntimeError::TimingAttackDetected => {
                write!(f, "Timing attack detected")
            }
            RuntimeError::SideChannelLeak => {
                write!(f, "Side-channel leak detected")
            }
            RuntimeError::AuthenticationFailed => {
                write!(f, "Authentication failed")
            }
            RuntimeError::AuthorizationFailed => {
                write!(f, "Authorization failed")
            }
            RuntimeError::ConstantTimeViolation => {
                write!(f, "Constant-time operation violation")
            }
            RuntimeError::MemorySafetyViolation => {
                write!(f, "Memory safety violation")
            }
            RuntimeError::IOError => {
                write!(f, "I/O error")
            }
            RuntimeError::FileNotFound(name) => {
                write!(f, "File not found: {}", name)
            }
            RuntimeError::PermissionDenied => {
                write!(f, "Permission denied")
            }
            RuntimeError::InvalidFileOperation => {
                write!(f, "Invalid file operation")
            }
            RuntimeError::SystemCallFailed(msg) => {
                write!(f, "System call failed: {}", msg)
            }
            RuntimeError::NotImplemented => {
                write!(f, "Not implemented")
            }
            RuntimeError::InternalError(msg) => {
                write!(f, "Internal error: {}", msg)
            }
            RuntimeError::StackOverflow => {
                write!(f, "Stack overflow")
            }
            RuntimeError::StackUnderflow => {
                write!(f, "Stack underflow")
            }
            RuntimeError::CallStackCorrupted => {
                write!(f, "Call stack corrupted")
            }
        }
    }
}

impl std::error::Error for RuntimeError {}

/// Runtime error with source location
#[derive(Debug, Clone)]
pub struct LocatedRuntimeError {
    /// The runtime error
    pub error: RuntimeError,

    /// Source location where error occurred
    pub location: Option<SourceLocation>,

    /// Call stack trace
    pub call_stack: Vec<String>,
}

impl LocatedRuntimeError {
    /// Create a new located runtime error
    pub fn new(error: RuntimeError, location: Option<SourceLocation>) -> Self {
        Self {
            error,
            location,
            call_stack: Vec::new(),
        }
    }

    /// Add a function to the call stack
    pub fn add_to_call_stack(&mut self, function_name: String) {
        self.call_stack.push(function_name);
    }
}

impl fmt::Display for LocatedRuntimeError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "Runtime error: {}", self.error)?;

        if let Some(ref location) = self.location {
            write!(f, " at {}:{}:{}",
                location.file,
                location.start_line,
                location.start_column)?;
        }

        if !self.call_stack.is_empty() {
            write!(f, "\nCall stack:")?;
            for (i, frame) in self.call_stack.iter().rev().enumerate() {
                write!(f, "\n  {}: {}", i, frame)?;
            }
        }

        Ok(())
    }
}

/// Error context for detailed error reporting
#[derive(Debug, Clone)]
pub struct ErrorContext {
    /// Error location
    pub location: Option<SourceLocation>,

    /// Function context
    pub function_context: Option<String>,

    /// Variable context
    pub variable_context: Option<String>,

    /// Operation context
    pub operation_context: Option<String>,

    /// Additional context information
    pub additional_info: HashMap<String, String>,
}

impl ErrorContext {
    /// Create a new error context
    pub fn new() -> Self {
        Self {
            location: None,
            function_context: None,
            variable_context: None,
            operation_context: None,
            additional_info: HashMap::new(),
        }
    }

    /// Set source location
    pub fn with_location(mut self, location: SourceLocation) -> Self {
        self.location = Some(location);
        self
    }

    /// Set function context
    pub fn with_function(mut self, function: String) -> Self {
        self.function_context = Some(function);
        self
    }

    /// Set variable context
    pub fn with_variable(mut self, variable: String) -> Self {
        self.variable_context = Some(variable);
        self
    }

    /// Set operation context
    pub fn with_operation(mut self, operation: String) -> Self {
        self.operation_context = Some(operation);
        self
    }

    /// Add additional information
    pub fn with_info(mut self, key: String, value: String) -> Self {
        self.additional_info.insert(key, value);
        self
    }
}

impl Default for ErrorContext {
    fn default() -> Self {
        Self::new()
    }
}

/// Enhanced runtime error with context
#[derive(Debug, Clone)]
pub struct ContextualRuntimeError {
    /// The base runtime error
    pub error: RuntimeError,

    /// Error context
    pub context: ErrorContext,

    /// Timestamp when error occurred
    pub timestamp: chrono::DateTime<chrono::Utc>,

    /// Error ID for tracking
    pub error_id: String,
}

impl ContextualRuntimeError {
    /// Create a new contextual runtime error
    pub fn new(error: RuntimeError, context: ErrorContext) -> Self {
        Self {
            error,
            context,
            timestamp: chrono::Utc::now(),
            error_id: uuid::Uuid::new_v4().to_string(),
        }
    }

    /// Create a new error with location
    pub fn with_location(error: RuntimeError, location: SourceLocation) -> Self {
        Self::new(error, ErrorContext::new().with_location(location))
    }

    /// Create a new error with function context
    pub fn with_function(error: RuntimeError, function: String) -> Self {
        Self::new(error, ErrorContext::new().with_function(function))
    }
}

impl fmt::Display for ContextualRuntimeError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "Runtime error [{}]: {}", self.error_id, self.error)?;

        if let Some(ref location) = self.context.location {
            write!(f, " at {}:{}:{}", location.file, location.start_line, location.start_column)?;
        }

        if let Some(ref function) = self.context.function_context {
            write!(f, " in function '{}'", function)?;
        }

        if let Some(ref variable) = self.context.variable_context {
            write!(f, " involving variable '{}'", variable)?;
        }

        if let Some(ref operation) = self.context.operation_context {
            write!(f, " during operation '{}'", operation)?;
        }

        if !self.context.additional_info.is_empty() {
            write!(f, "\nAdditional information:")?;
            for (key, value) in &self.context.additional_info {
                write!(f, "\n  {}: {}", key, value)?;
            }
        }

        Ok(())
    }
}

/// Error severity levels
#[derive(Debug, Clone, PartialEq)]
pub enum ErrorSeverity {
    /// Warning - execution can continue
    Warning,
    /// Error - execution should stop
    Error,
    /// Critical - security or system integrity issue
    Critical,
    /// Fatal - program cannot continue
    Fatal,
}

/// Error classification for different types of runtime errors
#[derive(Debug, Clone)]
pub struct ErrorClassification {
    /// Error category
    pub category: ErrorCategory,

    /// Error severity
    pub severity: ErrorSeverity,

    /// Whether error is recoverable
    pub recoverable: bool,

    /// Suggested actions
    pub suggested_actions: Vec<String>,
}

/// Error categories
#[derive(Debug, Clone, PartialEq)]
pub enum ErrorCategory {
    /// Type-related errors
    Type,

    /// Memory-related errors
    Memory,

    /// Cryptographic errors
    Cryptographic,

    /// Security-related errors
    Security,

    /// I/O errors
    IO,

    /// System errors
    System,

    /// Logic errors
    Logic,

    /// Implementation errors
    Implementation,
}

impl RuntimeError {
    /// Classify this error
    pub fn classify(&self) -> ErrorClassification {
        match self {
            RuntimeError::TypeError(_) => ErrorClassification {
                category: ErrorCategory::Type,
                severity: ErrorSeverity::Error,
                recoverable: false,
                suggested_actions: vec!["Check type annotations".to_string()],
            },
            RuntimeError::DivisionByZero => ErrorClassification {
                category: ErrorCategory::Logic,
                severity: ErrorSeverity::Error,
                recoverable: false,
                suggested_actions: vec!["Check for division by zero".to_string()],
            },
            RuntimeError::IndexOutOfBounds => ErrorClassification {
                category: ErrorCategory::Logic,
                severity: ErrorSeverity::Error,
                recoverable: false,
                suggested_actions: vec!["Check array bounds".to_string()],
            },
            RuntimeError::OutOfMemory => ErrorClassification {
                category: ErrorCategory::Memory,
                severity: ErrorSeverity::Fatal,
                recoverable: false,
                suggested_actions: vec!["Free memory".to_string(), "Increase available memory".to_string()],
            },
            RuntimeError::InvalidKey | RuntimeError::InvalidSignature | RuntimeError::InvalidCiphertext => {
                ErrorClassification {
                    category: ErrorCategory::Cryptographic,
                    severity: ErrorSeverity::Error,
                    recoverable: true,
                    suggested_actions: vec!["Verify key/ciphertext validity".to_string()],
                }
            },
            RuntimeError::SecurityViolation(_) | RuntimeError::TimingAttackDetected | RuntimeError::SideChannelLeak => {
                ErrorClassification {
                    category: ErrorCategory::Security,
                    severity: ErrorSeverity::Critical,
                    recoverable: false,
                    suggested_actions: vec!["Review security requirements".to_string(), "Audit code for vulnerabilities".to_string()],
                }
            },
            RuntimeError::IOError | RuntimeError::FileNotFound(_) | RuntimeError::PermissionDenied => {
                ErrorClassification {
                    category: ErrorCategory::IO,
                    severity: ErrorSeverity::Error,
                    recoverable: true,
                    suggested_actions: vec!["Check file permissions".to_string(), "Verify file paths".to_string()],
                }
            },
            RuntimeError::NotImplemented => ErrorClassification {
                category: ErrorCategory::Implementation,
                severity: ErrorSeverity::Error,
                recoverable: false,
                suggested_actions: vec!["Implement missing functionality".to_string()],
            },
            _ => ErrorClassification {
                category: ErrorCategory::Logic,
                severity: ErrorSeverity::Error,
                recoverable: false,
                suggested_actions: vec!["Review code logic".to_string()],
            },
        }
    }

    /// Check if error is security-related
    pub fn is_security_related(&self) -> bool {
        matches!(
            self,
            RuntimeError::SecurityViolation(_)
                | RuntimeError::TimingAttackDetected
                | RuntimeError::SideChannelLeak
                | RuntimeError::AuthenticationFailed
                | RuntimeError::AuthorizationFailed
                | RuntimeError::ConstantTimeViolation
                | RuntimeError::MemorySafetyViolation
        )
    }

    /// Check if error is cryptographic
    pub fn is_cryptographic(&self) -> bool {
        matches!(
            self,
            RuntimeError::InvalidKey
                | RuntimeError::InvalidSignature
                | RuntimeError::InvalidCiphertext
                | RuntimeError::DecryptionFailed
                | RuntimeError::KeyGenerationFailed
                | RuntimeError::UnsupportedAlgorithm(_)
                | RuntimeError::IncompatibleAlgorithms
                | RuntimeError::WeakKey
                | RuntimeError::CryptoOperationFailed(_)
                | RuntimeError::NoCryptoProvider
                | RuntimeError::NoProviderForAlgorithm(_)
                | RuntimeError::ProviderNotFound(_)
        )
    }

    /// Check if error is memory-related
    pub fn is_memory_related(&self) -> bool {
        matches!(
            self,
            RuntimeError::OutOfMemory
                | RuntimeError::MemoryAccessViolation
                | RuntimeError::InvalidLayout
                | RuntimeError::LockError
                | RuntimeError::DoubleFree
                | RuntimeError::UseAfterFree
                | RuntimeError::MemorySafetyViolation
        )
    }
}

// Import required types
use std::collections::HashMap;
use uuid;