//! Code formatting provider for T4 Language Server

use lsp_types::*;

pub struct FormattingProvider;

impl FormattingProvider {
    pub fn new() -> Self {
        Self
    }

    pub fn format_document(&self, _content: &str) -> Vec<TextEdit> {
        // TODO: Implement document formatting
        Vec::new()
    }

    pub fn format_range(&self, _content: &str, _range: Range) -> Vec<TextEdit> {
        // TODO: Implement range formatting
        Vec::new()
    }
}