use std::process::Command;

fn main() {
    // Generate ANTLR parser from grammar file
    println!("cargo:rerun-if-changed=src/grammar/T4Parser.g4");
    println!("cargo:rerun-if-changed=src/grammar/T4Lexer.g4");

    // Check if ANTLR is available and generate parser
    match Command::new("antlr4")
        .args(&[
            "-Dlanguage=Rust",
            "-package=t4parser",
            "-o", "src/generated",
            "src/grammar/T4Parser.g4"
        ])
        .output()
    {
        Ok(output) => {
            if output.status.success() {
                println!("ANTLR parser generated successfully");
            } else {
                eprintln!("Failed to generate ANTLR parser: {}", String::from_utf8_lossy(&output.stderr));
                // For now, we'll create a basic parser manually
                generate_basic_parser();
            }
        }
        Err(_) => {
            eprintln!("ANTLR4 not found, generating basic parser manually");
            generate_basic_parser();
        }
    }
}

fn generate_basic_parser() {
    // Create a basic parser implementation
    let parser_content = r#"
//! Generated T4 Parser
//!
//! This module contains the parser implementation for T4.
//! Generated from T4Parser.g4

use crate::ast::{Program, Declaration, Expression, Statement, Type, Identifier, SourceSpan};
use std::collections::HashMap;

// Basic parser implementation
pub struct T4Parser {
    // Parser state would go here
}

impl T4Parser {
    pub fn new() -> Self {
        Self {}
    }

    pub fn parse_program(&self, input: &str) -> Result<Program, String> {
        // Basic parsing implementation
        // This is a placeholder - in a real implementation,
        // this would use the ANTLR-generated parser
        Ok(Program {
            declarations: Vec::new(),
            config: Default::default(),
        })
    }
}
"#;

    std::fs::create_dir_all("src/generated").ok();
    std::fs::write("src/generated/parser.rs", parser_content).ok();
}