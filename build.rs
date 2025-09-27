//! Build script for T4 compiler
//!
//! This script generates the ANTLR parser and lexer from the grammar files
//! and sets up the necessary build configuration.

use std::process::Command;

fn main() {
    println!("cargo:rerun-if-changed=src/grammar/T4Lexer.g4");
    println!("cargo:rerun-if-changed=src/grammar/T4Parser.g4");

    // Generate ANTLR files
    let antlr_status = Command::new("antlr4")
        .args(&[
            "-Dlanguage=Rust",
            "-package", "t4_compiler",
            "-o", "src/generated",
            "src/grammar/T4Lexer.g4",
            "src/grammar/T4Parser.g4",
        ])
        .status();

    match antlr_status {
        Ok(status) if status.success() => {
            println!("cargo:warning=ANTLR4 parser generation completed successfully");
        }
        _ => {
            println!("cargo:warning=ANTLR4 not found or failed to generate parser. Please install ANTLR4 and ensure it's in your PATH.");
            println!("cargo:warning=You can download ANTLR4 from: https://www.antlr.org/download.html");
        }
    }

    // Generate additional AST node definitions if needed
    // This would be expanded based on the actual ANTLR output
}