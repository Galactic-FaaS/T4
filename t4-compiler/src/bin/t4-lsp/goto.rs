//! Go-to-definition and find-references provider for T4 Language Server

use lsp_types::*;

pub struct GotoProvider;

impl GotoProvider {
    pub fn new() -> Self {
        Self
    }

    pub fn find_definition(&self, _position: Position, _context: &str) -> Option<Location> {
        // TODO: Implement go-to-definition
        None
    }

    pub fn find_references(&self, _position: Position, _context: &str) -> Vec<Location> {
        // TODO: Implement find-references
        Vec::new()
    }
}