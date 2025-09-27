//! Diagnostics management for T4 Language Server
//!
//! Handles error reporting, syntax highlighting, and semantic analysis.

use lsp_types::*;
use std::collections::HashMap;
use t4_compiler::ast::{Program, Expression, Statement, Type};
use super::server::T4LanguageServer;

pub struct DiagnosticsManager {
    documents: HashMap<Url, DocumentDiagnostics>,
}

#[derive(Debug, Clone)]
struct DocumentDiagnostics {
    uri: Url,
    version: i32,
    diagnostics: Vec<Diagnostic>,
    last_modified: std::time::SystemTime,
}

impl DiagnosticsManager {
    pub fn new() -> Self {
        Self {
            documents: HashMap::new(),
        }
    }

    pub fn get_diagnostics(&self, uri: &Url) -> anyhow::Result<Vec<Diagnostic>> {
        Ok(self.documents.get(uri)
            .map(|doc| doc.diagnostics.clone())
            .unwrap_or_default())
    }

    pub fn update_document(&mut self, uri: Url, content: String, version: i32) -> anyhow::Result<()> {
        let mut diagnostics = Vec::new();

        // Parse the document
        match self.parse_document(&content) {
            Ok(program) => {
                // Perform semantic analysis
                self.analyze_program(&program, &mut diagnostics);
            }
            Err(errors) => {
                // Convert parse errors to diagnostics
                for error in errors {
                    diagnostics.push(self.create_parse_error_diagnostic(&error));
                }
            }
        }

        // Add security-related diagnostics
        self.analyze_security(&content, &mut diagnostics);

        // Add cryptographic best practice diagnostics
        self.analyze_crypto_practices(&content, &mut diagnostics);

        let doc_diagnostics = DocumentDiagnostics {
            uri: uri.clone(),
            version,
            diagnostics,
            last_modified: std::time::SystemTime::now(),
        };

        self.documents.insert(uri, doc_diagnostics);
        Ok(())
    }

    fn parse_document(&self, content: &str) -> Result<Program, Vec<ParseError>> {
        // TODO: Implement actual parsing using ANTLR
        // For now, return a placeholder
        Ok(Program {
            declarations: Vec::new(),
            config: Default::default(),
        })
    }

    fn analyze_program(&self, _program: &Program, _diagnostics: &mut Vec<Diagnostic>) {
        // TODO: Implement semantic analysis
        // - Type checking
        // - Variable usage analysis
        // - Control flow analysis
        // - Security annotation validation
    }

    fn analyze_security(&self, content: &str, diagnostics: &mut Vec<Diagnostic>) {
        let lines: Vec<&str> = content.lines().collect();

        for (line_num, line) in lines.iter().enumerate() {
            let line_num = line_num + 1; // LSP uses 1-based line numbers

            // Check for insecure patterns
            if line.contains("unsafe") {
                diagnostics.push(Diagnostic {
                    range: Range {
                        start: Position { line: line_num - 1, character: 0 },
                        end: Position { line: line_num - 1, character: line.len() as u32 },
                    },
                    severity: Some(DiagnosticSeverity::WARNING),
                    code: Some(NumberOrString::String("security".to_string())),
                    message: "Use of unsafe code detected. Consider using safe alternatives.".to_string(),
                    source: Some("t4-lsp".to_string()),
                    ..Default::default()
                });
            }

            // Check for hardcoded secrets
            if line.contains("password") || line.contains("secret") || line.contains("key") {
                if line.contains("\"") || line.contains("'") {
                    diagnostics.push(Diagnostic {
                        range: Range {
                            start: Position { line: line_num - 1, character: 0 },
                            end: Position { line: line_num - 1, character: line.len() as u32 },
                        },
                        severity: Some(DiagnosticSeverity::WARNING),
                        code: Some(NumberOrString::String("security".to_string())),
                        message: "Potential hardcoded secret detected. Use secure key management.".to_string(),
                        source: Some("t4-lsp".to_string()),
                        ..Default::default()
                    });
                }
            }

            // Check for missing security annotations
            if line.contains("fn ") && !line.contains("#[security") {
                diagnostics.push(Diagnostic {
                    range: Range {
                        start: Position { line: line_num - 1, character: 0 },
                        end: Position { line: line_num - 1, character: line.len() as u32 },
                    },
                    severity: Some(DiagnosticSeverity::INFORMATION),
                    code: Some(NumberOrString::String("security".to_string())),
                    message: "Consider adding security annotations to this function.".to_string(),
                    source: Some("t4-lsp".to_string()),
                    ..Default::default()
                });
            }
        }
    }

    fn analyze_crypto_practices(&self, content: &str, diagnostics: &mut Vec<Diagnostic>) {
        let lines: Vec<&str> = content.lines().collect();

        for (line_num, line) in lines.iter().enumerate() {
            let line_num = line_num + 1;

            // Check for deprecated algorithms
            if line.contains("MD5") || line.contains("SHA1") {
                diagnostics.push(Diagnostic {
                    range: Range {
                        start: Position { line: line_num - 1, character: 0 },
                        end: Position { line: line_num - 1, character: line.len() as u32 },
                    },
                    severity: Some(DiagnosticSeverity::WARNING),
                    code: Some(NumberOrString::String("crypto".to_string())),
                    message: "Deprecated cryptographic algorithm detected. Use SHA3 or BLAKE2.".to_string(),
                    source: Some("t4-lsp".to_string()),
                    ..Default::default()
                });
            }

            // Check for weak key sizes
            if line.contains("RSA") {
                if let Some(key_size) = self.extract_key_size(line) {
                    if key_size < 2048 {
                        diagnostics.push(Diagnostic {
                            range: Range {
                                start: Position { line: line_num - 1, character: 0 },
                                end: Position { line: line_num - 1, character: line.len() as u32 },
                            },
                            severity: Some(DiagnosticSeverity::ERROR),
                            code: Some(NumberOrString::String("crypto".to_string())),
                            message: "RSA key size too small. Use at least 2048 bits.".to_string(),
                            source: Some("t4-lsp".to_string()),
                            ..Default::default()
                        });
                    }
                }
            }

            // Check for constant-time violations
            if line.contains("==") && (line.contains("secret") || line.contains("key")) {
                diagnostics.push(Diagnostic {
                    range: Range {
                        start: Position { line: line_num - 1, character: 0 },
                        end: Position { line: line_num - 1, character: line.len() as u32 },
                    },
                    severity: Some(DiagnosticSeverity::WARNING),
                    code: Some(NumberOrString::String("crypto".to_string())),
                    message: "Potential timing attack. Use constant-time comparison.".to_string(),
                    source: Some("t4-lsp".to_string()),
                    ..Default::default()
                });
            }
        }
    }

    fn create_parse_error_diagnostic(&self, error: &ParseError) -> Diagnostic {
        Diagnostic {
            range: Range {
                start: Position {
                    line: error.line - 1,
                    character: error.column,
                },
                end: Position {
                    line: error.line - 1,
                    character: error.column + error.length,
                },
            },
            severity: Some(DiagnosticSeverity::ERROR),
            code: Some(NumberOrString::String("parse".to_string())),
            message: error.message.clone(),
            source: Some("t4-lsp".to_string()),
            ..Default::default()
        }
    }

    fn extract_key_size(&self, line: &str) -> Option<usize> {
        // Simple regex-like extraction for key sizes
        if let Some(start) = line.find("RSA") {
            let after_rsa = &line[start + 3..];
            if let Some(dash_pos) = after_rsa.find('-') {
                let size_part = &after_rsa[dash_pos + 1..];
                if let Some(space_pos) = size_part.find(' ') {
                    let size_str = &size_part[..space_pos];
                    size_str.parse().ok()
                } else {
                    size_part.parse().ok()
                }
            } else {
                None
            }
        } else {
            None
        }
    }
}

#[derive(Debug, Clone)]
struct ParseError {
    line: u32,
    column: u32,
    length: u32,
    message: String,
}

impl ParseError {
    fn new(line: u32, column: u32, length: u32, message: String) -> Self {
        Self {
            line,
            column,
            length,
            message,
        }
    }
}