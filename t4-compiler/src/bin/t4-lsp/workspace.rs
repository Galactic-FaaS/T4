//! Workspace management for T4 Language Server

use lsp_types::*;
use std::collections::HashMap;
use std::path::PathBuf;

pub struct WorkspaceManager {
    root_uri: Option<Url>,
    documents: HashMap<Url, String>,
    config: WorkspaceConfig,
}

#[derive(Debug, Clone)]
pub struct WorkspaceConfig {
    pub max_diagnostics: usize,
    pub enable_security_analysis: bool,
    pub enable_crypto_analysis: bool,
    pub format_on_save: bool,
    pub organize_imports: bool,
}

impl Default for WorkspaceConfig {
    fn default() -> Self {
        Self {
            max_diagnostics: 100,
            enable_security_analysis: true,
            enable_crypto_analysis: true,
            format_on_save: true,
            organize_imports: true,
        }
    }
}

impl WorkspaceManager {
    pub fn new() -> Self {
        Self {
            root_uri: None,
            documents: HashMap::new(),
            config: WorkspaceConfig::default(),
        }
    }

    pub fn set_root_uri(&mut self, uri: Url) {
        self.root_uri = Some(uri);
    }

    pub fn get_config(&self) -> &WorkspaceConfig {
        &self.config
    }

    pub fn update_config(&mut self, config: WorkspaceConfig) {
        self.config = config;
    }

    pub fn add_document(&mut self, uri: Url, content: String) {
        self.documents.insert(uri, content);
    }

    pub fn remove_document(&mut self, uri: &Url) {
        self.documents.remove(uri);
    }

    pub fn get_document(&self, uri: &Url) -> Option<&String> {
        self.documents.get(uri)
    }

    pub fn list_documents(&self) -> Vec<&Url> {
        self.documents.keys().collect()
    }

    pub fn find_files(&self, pattern: &str) -> Vec<Url> {
        // TODO: Implement file discovery
        Vec::new()
    }

    pub fn get_workspace_root(&self) -> Option<&Url> {
        self.root_uri.as_ref()
    }

    pub fn resolve_path(&self, path: &str) -> Option<PathBuf> {
        if let Some(root) = &self.root_uri {
            if let Ok(root_path) = root.to_file_path() {
                Some(root_path.join(path))
            } else {
                None
            }
        } else {
            None
        }
    }
}