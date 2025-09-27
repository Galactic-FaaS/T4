//! T4 Compiler Library
//!
//! This library provides the core functionality for the T4 programming language compiler,
//! including parsing, AST construction, and type checking.

pub mod ast;
pub mod generated;
pub mod types;

// Re-export main types for convenience
pub use ast::*;
pub use string_interner::StringInterner;