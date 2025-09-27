//! Error types and reporting for the T4 type system

use crate::ast::*;
use super::{TypeScheme, TypeVar};
use std::fmt;

/// Result type for type checking operations
pub type TypeResult<T> = Result<T, TypeError>;

/// Type checking errors
#[derive(Debug, Clone)]
pub enum TypeError {
    /// Unbound variable
    UnboundVariable(Identifier),

    /// Unification failed between two types
    UnificationFailed(TypeScheme, TypeScheme),

    /// Infinite type detected during unification
    InfiniteType(TypeVar),

    /// Type mismatch
    TypeMismatch {
        expected: TypeScheme,
        found: TypeScheme,
        location: SourceLocation,
    },

    /// Missing type annotation
    MissingTypeAnnotation {
        location: SourceLocation,
    },

    /// Invalid type for operation
    InvalidOperation {
        op: String,
        typ: TypeScheme,
        location: SourceLocation,
    },

    /// Security violation
    SecurityViolation {
        message: String,
        location: SourceLocation,
    },

    /// Cryptographic type error
    CryptoTypeError {
        message: String,
        location: SourceLocation,
    },

    /// Generic type error
    GenericTypeError {
        message: String,
        location: SourceLocation,
    },

    /// Trait bound not satisfied
    TraitBoundNotSatisfied {
        trait_name: String,
        type_param: String,
        location: SourceLocation,
    },

    /// Duplicate definition
    DuplicateDefinition {
        name: String,
        location: SourceLocation,
    },

    /// Missing implementation
    MissingImplementation {
        trait_name: String,
        type_name: String,
        location: SourceLocation,
    },
}

impl fmt::Display for TypeError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            TypeError::UnboundVariable(ident) => {
                write!(f, "Unbound variable: {}", ident.name)
            }
            TypeError::UnificationFailed(t1, t2) => {
                write!(f, "Cannot unify types: {} and {}", t1, t2)
            }
            TypeError::InfiniteType(var) => {
                write!(f, "Infinite type detected involving {}", var)
            }
            TypeError::TypeMismatch { expected, found, location } => {
                write!(f, "Type mismatch at {}:{} - expected {}, found {}",
                       location.start_line, location.start_column, expected, found)
            }
            TypeError::MissingTypeAnnotation { location } => {
                write!(f, "Missing type annotation at {}:{}", location.start_line, location.start_column)
            }
            TypeError::InvalidOperation { op, typ, location } => {
                write!(f, "Invalid operation '{}' on type {} at {}:{}",
                       op, typ, location.start_line, location.start_column)
            }
            TypeError::SecurityViolation { message, location } => {
                write!(f, "Security violation at {}:{} - {}", location.start_line, location.start_column, message)
            }
            TypeError::CryptoTypeError { message, location } => {
                write!(f, "Cryptographic type error at {}:{} - {}", location.start_line, location.start_column, message)
            }
            TypeError::GenericTypeError { message, location } => {
                write!(f, "Generic type error at {}:{} - {}", location.start_line, location.start_column, message)
            }
            TypeError::TraitBoundNotSatisfied { trait_name, type_param, location } => {
                write!(f, "Trait bound not satisfied at {}:{} - trait '{}' not implemented for type parameter '{}'",
                       location.start_line, location.start_column, trait_name, type_param)
            }
            TypeError::DuplicateDefinition { name, location } => {
                write!(f, "Duplicate definition '{}' at {}:{}", name, location.start_line, location.start_column)
            }
            TypeError::MissingImplementation { trait_name, type_name, location } => {
                write!(f, "Missing implementation at {}:{} - trait '{}' not implemented for type '{}'",
                       location.start_line, location.start_column, trait_name, type_name)
            }
        }
    }
}

impl std::error::Error for TypeError {}

/// Type error with source context
#[derive(Debug, Clone)]
pub struct TypeErrorWithContext {
    pub error: TypeError,
    pub source_context: String,
    pub suggestions: Vec<String>,
}

impl TypeErrorWithContext {
    pub fn new(error: TypeError, source_context: String) -> Self {
        let suggestions = generate_suggestions(&error);
        Self {
            error,
            source_context,
            suggestions,
        }
    }

    pub fn with_suggestions(mut self, suggestions: Vec<String>) -> Self {
        self.suggestions = suggestions;
        self
    }
}

impl fmt::Display for TypeErrorWithContext {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        writeln!(f, "Type error: {}", self.error)?;
        writeln!(f, "Context: {}", self.source_context)?;

        if !self.suggestions.is_empty() {
            writeln!(f, "Suggestions:")?;
            for suggestion in &self.suggestions {
                writeln!(f, "  - {}", suggestion)?;
            }
        }

        Ok(())
    }
}

/// Generate helpful suggestions for type errors
fn generate_suggestions(error: &TypeError) -> Vec<String> {
    match error {
        TypeError::UnboundVariable(ident) => {
            vec![
                format!("Check if '{}' is declared in scope", ident.name),
                "Consider adding a type annotation if this is a function parameter".to_string(),
                "Check for typos in variable name".to_string(),
            ]
        }
        TypeError::TypeMismatch { expected, found, .. } => {
            vec![
                format!("Expected type: {}", expected),
                format!("Found type: {}", found),
                "Consider adding explicit type conversion".to_string(),
                "Check if types are compatible for this operation".to_string(),
            ]
        }
        TypeError::MissingTypeAnnotation { .. } => {
            vec![
                "Add explicit type annotation".to_string(),
                "Consider using type inference hints".to_string(),
            ]
        }
        TypeError::InvalidOperation { op, typ, .. } => {
            vec![
                format!("Operation '{}' is not supported for type {}", op, typ),
                "Check if this operation is valid for the given type".to_string(),
                "Consider using a different operation or type conversion".to_string(),
            ]
        }
        TypeError::SecurityViolation { message, .. } => {
            vec![
                format!("Security issue: {}", message),
                "Review security annotations and access patterns".to_string(),
                "Consider using secure memory operations".to_string(),
            ]
        }
        TypeError::CryptoTypeError { message, .. } => {
            vec![
                format!("Cryptographic error: {}", message),
                "Check cryptographic type usage and algorithm compatibility".to_string(),
                "Verify key types and encryption parameters".to_string(),
            ]
        }
        TypeError::TraitBoundNotSatisfied { trait_name, type_param, .. } => {
            vec![
                format!("Type parameter '{}' does not implement trait '{}'", type_param, trait_name),
                "Add trait bound to type parameter".to_string(),
                "Implement the required trait for the type".to_string(),
            ]
        }
        _ => vec![
            "Check the T4 language specification for correct syntax".to_string(),
            "Review type annotations and generic constraints".to_string(),
        ]
    }
}

/// Error reporter for collecting and formatting type errors
#[derive(Debug, Default)]
pub struct TypeErrorReporter {
    errors: Vec<TypeErrorWithContext>,
}

impl TypeErrorReporter {
    pub fn new() -> Self {
        Self::default()
    }

    pub fn report_error(&mut self, error: TypeError, source_context: String) {
        let error_with_context = TypeErrorWithContext::new(error, source_context);
        self.errors.push(error_with_context);
    }

    pub fn report_error_with_suggestions(&mut self, error: TypeError, source_context: String, suggestions: Vec<String>) {
        let error_with_context = TypeErrorWithContext::new(error, source_context)
            .with_suggestions(suggestions);
        self.errors.push(error_with_context);
    }

    pub fn has_errors(&self) -> bool {
        !self.errors.is_empty()
    }

    pub fn error_count(&self) -> usize {
        self.errors.len()
    }

    pub fn errors(&self) -> &[TypeErrorWithContext] {
        &self.errors
    }

    pub fn clear(&mut self) {
        self.errors.clear()
    }

    /// Format all errors for display
    pub fn format_errors(&self) -> String {
        let mut output = String::new();

        for (i, error) in self.errors.iter().enumerate() {
            if i > 0 {
                output.push_str("\n\n");
            }
            output.push_str(&format!("{}", error));
        }

        output
    }

    /// Get a summary of all errors
    pub fn error_summary(&self) -> String {
        format!("Found {} type error(s)", self.errors.len())
    }
}

/// Helper macro for creating type errors with location
#[macro_export]
macro_rules! type_error {
    ($error:expr, $location:expr) => {
        TypeErrorWithContext::new($error, format!("at {}:{}", $location.start_line, $location.start_column))
    };
}

/// Helper macro for reporting type errors
#[macro_export]
macro_rules! report_type_error {
    ($reporter:expr, $error:expr, $location:expr) => {
        $reporter.report_error($error, format!("at {}:{}", $location.start_line, $location.start_column))
    };
}