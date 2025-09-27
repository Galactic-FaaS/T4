//! Error types and handling for T4 Compiler
//!
//! Comprehensive error reporting with source locations and suggestions.

use std::fmt;
use std::path::PathBuf;
use thiserror::Error;

#[derive(Error, Debug)]
pub enum T4cError {
    #[error("IO error: {0}")]
    Io(#[from] std::io::Error),

    #[error("TOML parsing error: {0}")]
    Toml(#[from] toml::de::Error),

    #[error("JSON parsing error: {0}")]
    Json(#[from] serde_json::Error),

    #[error("File error for {0}: {1}")]
    FileError(PathBuf, std::io::Error),

    #[error("Parse error at {file}:{line}:{column}: {message}")]
    ParseError {
        file: PathBuf,
        line: usize,
        column: usize,
        message: String,
    },

    #[error("Type error: {0}")]
    TypeError(String),

    #[error("Security error: {0}")]
    SecurityError(String),

    #[error("Cryptographic error: {0}")]
    CryptoError(String),

    #[error("Linker error: {0}")]
    LinkerError(String),

    #[error("Configuration error: {0}")]
    ConfigError(String),

    #[error("Build error: {0}")]
    BuildError(String),

    #[error("Runtime error: {0}")]
    RuntimeError(String),

    #[error("Internal compiler error: {0}")]
    InternalError(String),

    #[error("Unsupported feature: {0}")]
    UnsupportedFeature(String),

    #[error("Invalid argument: {0}")]
    InvalidArgument(String),

    #[error("Missing dependency: {0}")]
    MissingDependency(String),

    #[error("Version mismatch: {0}")]
    VersionMismatch(String),

    #[error("Network error: {0}")]
    NetworkError(String),

    #[error("Permission denied: {0}")]
    PermissionDenied(String),

    #[error("Out of memory")]
    OutOfMemory,

    #[error("Timeout: {0}")]
    Timeout(String),

    #[error("Cancelled")]
    Cancelled,
}

pub type Result<T> = std::result::Result<T, T4cError>;

/// Error severity levels
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum Severity {
    Error,
    Warning,
    Info,
    Hint,
}

/// Diagnostic information with source location
#[derive(Debug, Clone)]
pub struct Diagnostic {
    pub severity: Severity,
    pub message: String,
    pub file: PathBuf,
    pub line: usize,
    pub column: usize,
    pub end_line: Option<usize>,
    pub end_column: Option<usize>,
    pub source: Option<String>,
    pub suggestions: Vec<String>,
    pub error_code: Option<String>,
}

impl Diagnostic {
    pub fn new(
        severity: Severity,
        message: String,
        file: PathBuf,
        line: usize,
        column: usize,
    ) -> Self {
        Self {
            severity,
            message,
            file,
            line,
            column,
            end_line: None,
            end_column: None,
            source: None,
            suggestions: Vec::new(),
            error_code: None,
        }
    }

    pub fn with_span(mut self, end_line: usize, end_column: usize) -> Self {
        self.end_line = Some(end_line);
        self.end_column = Some(end_column);
        self
    }

    pub fn with_source(mut self, source: String) -> Self {
        self.source = Some(source);
        self
    }

    pub fn with_suggestions(mut self, suggestions: Vec<String>) -> Self {
        self.suggestions = suggestions;
        self
    }

    pub fn with_error_code(mut self, code: String) -> Self {
        self.error_code = Some(code);
        self
    }

    pub fn format_message(&self) -> String {
        let location = if let (Some(end_line), Some(end_column)) = (self.end_line, self.end_column) {
            if end_line == self.line {
                format!("{}:{}: ", self.file.display(), self.line)
            } else {
                format!("{}:{}:{} - {}:{}", self.file.display(), self.line, self.column, end_line, end_column)
            }
        } else {
            format!("{}:{}:{}: ", self.file.display(), self.line, self.column)
        };

        let severity_str = match self.severity {
            Severity::Error => "error",
            Severity::Warning => "warning",
            Severity::Info => "info",
            Severity::Hint => "hint",
        };

        let mut message = format!("{}{}[{}]: {}", location, severity_str, self.error_code.as_deref().unwrap_or("0000"), self.message);

        if !self.suggestions.is_empty() {
            message.push_str("\n\nSuggestions:");
            for (i, suggestion) in self.suggestions.iter().enumerate() {
                message.push_str(&format!("\n  {}. {}", i + 1, suggestion));
            }
        }

        if let Some(source) = &self.source {
            message.push_str(&format!("\n\nSource:\n{}", source));
        }

        message
    }
}

/// Error reporter for collecting and displaying diagnostics
pub struct ErrorReporter {
    diagnostics: Vec<Diagnostic>,
    max_errors: usize,
    show_warnings: bool,
}

impl ErrorReporter {
    pub fn new() -> Self {
        Self {
            diagnostics: Vec::new(),
            max_errors: 100,
            show_warnings: true,
        }
    }

    pub fn with_max_errors(mut self, max: usize) -> Self {
        self.max_errors = max;
        self
    }

    pub fn show_warnings(mut self, show: bool) -> Self {
        self.show_warnings = show;
        self
    }

    pub fn report(&mut self, diagnostic: Diagnostic) {
        if matches!(diagnostic.severity, Severity::Warning) && !self.show_warnings {
            return;
        }

        self.diagnostics.push(diagnostic);

        if self.diagnostics.len() >= self.max_errors
            && self.diagnostics.iter().any(|d| d.severity == Severity::Error) {
            eprintln!("Too many errors, stopping compilation");
            std::process::exit(1);
        }
    }

    pub fn has_errors(&self) -> bool {
        self.diagnostics.iter().any(|d| d.severity == Severity::Error)
    }

    pub fn error_count(&self) -> usize {
        self.diagnostics.iter().filter(|d| d.severity == Severity::Error).count()
    }

    pub fn warning_count(&self) -> usize {
        self.diagnostics.iter().filter(|d| d.severity == Severity::Warning).count()
    }

    pub fn print_all(&self) {
        for diagnostic in &self.diagnostics {
            eprintln!("{}", diagnostic.format_message());
        }

        if self.has_errors() {
            eprintln!("\nCompilation failed with {} errors and {} warnings",
                     self.error_count(), self.warning_count());
        } else if self.warning_count() > 0 {
            eprintln!("\nCompilation succeeded with {} warnings", self.warning_count());
        }
    }

    pub fn clear(&mut self) {
        self.diagnostics.clear();
    }
}

impl Default for ErrorReporter {
    fn default() -> Self {
        Self::new()
    }
}

/// Helper macros for creating common diagnostics
#[macro_export]
macro_rules! error {
    ($reporter:expr, $file:expr, $line:expr, $column:expr, $message:expr) => {
        $reporter.report(Diagnostic::new(
            Severity::Error,
            $message.to_string(),
            $file,
            $line,
            $column,
        ));
    };
}

#[macro_export]
macro_rules! warning {
    ($reporter:expr, $file:expr, $line:expr, $column:expr, $message:expr) => {
        $reporter.report(Diagnostic::new(
            Severity::Warning,
            $message.to_string(),
            $file,
            $line,
            $column,
        ));
    };
}

#[macro_export]
macro_rules! info {
    ($reporter:expr, $file:expr, $line:expr, $column:expr, $message:expr) => {
        $reporter.report(Diagnostic::new(
            Severity::Info,
            $message.to_string(),
            $file,
            $line,
            $column,
        ));
    };
}

pub fn format_error_chain(error: &dyn std::error::Error) -> String {
    let mut chain = Vec::new();
    let mut current = error;

    while let Some(source) = current.source() {
        chain.push(current.to_string());
        current = source;
    }
    chain.push(current.to_string());

    chain.join("\nCaused by: ")
}