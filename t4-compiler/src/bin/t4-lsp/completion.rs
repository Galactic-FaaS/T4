//! Auto-completion provider for T4 Language Server

use lsp_types::*;
use std::collections::HashMap;

pub struct CompletionProvider {
    keywords: Vec<CompletionItem>,
    builtin_types: Vec<CompletionItem>,
    builtin_functions: Vec<CompletionItem>,
    crypto_algorithms: Vec<CompletionItem>,
    security_annotations: Vec<CompletionItem>,
}

impl CompletionProvider {
    pub fn new() -> Self {
        Self {
            keywords: Self::create_keyword_completions(),
            builtin_types: Self::create_type_completions(),
            builtin_functions: Self::create_function_completions(),
            crypto_algorithms: Self::create_crypto_completions(),
            security_annotations: Self::create_security_completions(),
        }
    }

    pub fn get_completions(&self, context: &str, position: Position) -> CompletionList {
        let mut completions = Vec::new();

        // Add context-specific completions
        if self.is_in_type_context(context, position) {
            completions.extend(self.builtin_types.iter().cloned());
            completions.extend(self.crypto_algorithms.iter().cloned());
        }

        if self.is_in_function_context(context, position) {
            completions.extend(self.builtin_functions.iter().cloned());
        }

        if self.is_in_security_context(context, position) {
            completions.extend(self.security_annotations.iter().cloned());
        }

        // Always add keywords
        completions.extend(self.keywords.iter().cloned());

        CompletionList {
            is_incomplete: false,
            items: completions,
        }
    }

    fn create_keyword_completions() -> Vec<CompletionItem> {
        let keywords = vec![
            "fn", "let", "mut", "if", "else", "match", "while", "for", "loop",
            "break", "continue", "return", "struct", "enum", "trait", "impl",
            "mod", "use", "pub", "const", "static", "extern", "unsafe",
            "async", "await", "move", "ref", "self", "super", "crate",
        ];

        keywords.into_iter().map(|keyword| {
            CompletionItem {
                label: keyword.to_string(),
                kind: Some(CompletionItemKind::KEYWORD),
                detail: Some(format!("T4 keyword: {}", keyword)),
                documentation: Some(Documentation::MarkupContent(MarkupContent {
                    kind: MarkupKind::Markdown,
                    value: format!("**{}** - T4 language keyword", keyword),
                })),
                ..Default::default()
            }
        }).collect()
    }

    fn create_type_completions() -> Vec<CompletionItem> {
        let types = vec![
            "i8", "i16", "i32", "i64", "u8", "u16", "u32", "u64",
            "f32", "f64", "bool", "String", "Bytes", "Key", "Secret",
            "PublicKey", "PrivateKey", "Signature", "Ciphertext", "Plaintext",
            "Hash", "Nonce", "Salt", "Result", "Option", "Vec", "HashMap",
        ];

        types.into_iter().map(|typ| {
            CompletionItem {
                label: typ.to_string(),
                kind: Some(CompletionItemKind::TYPE_PARAMETER),
                detail: Some(format!("Type: {}", typ)),
                documentation: Some(Documentation::MarkupContent(MarkupContent {
                    kind: MarkupKind::Markdown,
                    value: format!("**{}** - Built-in T4 type", typ),
                })),
                ..Default::default()
            }
        }).collect()
    }

    fn create_function_completions() -> Vec<CompletionItem> {
        let functions = vec![
            ("print", "Print values to stdout"),
            ("println", "Print values with newline to stdout"),
            ("encrypt", "Encrypt data with specified algorithm"),
            ("decrypt", "Decrypt data with specified algorithm"),
            ("hash", "Compute cryptographic hash"),
            ("sign", "Create digital signature"),
            ("verify", "Verify digital signature"),
            ("generate_key", "Generate cryptographic key"),
            ("kem_encapsulate", "KEM encapsulation"),
            ("kem_decapsulate", "KEM decapsulation"),
        ];

        functions.into_iter().map(|(name, desc)| {
            CompletionItem {
                label: name.to_string(),
                kind: Some(CompletionItemKind::FUNCTION),
                detail: Some(desc.to_string()),
                documentation: Some(Documentation::MarkupContent(MarkupContent {
                    kind: MarkupKind::Markdown,
                    value: format!("**{}** - {}", name, desc),
                })),
                ..Default::default()
            }
        }).collect()
    }

    fn create_crypto_completions() -> Vec<CompletionItem> {
        let algorithms = vec![
            "AES256", "ChaCha20", "Ed25519", "SecP256r1", "RSA2048", "RSA3072", "RSA4096",
            "Kyber1024", "Kyber768", "Kyber512", "Dilithium3", "Dilithium2", "Dilithium5",
            "SHA3_256", "SHA3_512", "BLAKE2b", "SHAKE256",
        ];

        algorithms.into_iter().map(|alg| {
            CompletionItem {
                label: alg.to_string(),
                kind: Some(CompletionItemKind::ENUM_MEMBER),
                detail: Some(format!("Cryptographic algorithm: {}", alg)),
                documentation: Some(Documentation::MarkupContent(MarkupContent {
                    kind: MarkupKind::Markdown,
                    value: format!("**{}** - Cryptographic algorithm", alg),
                })),
                ..Default::default()
            }
        }).collect()
    }

    fn create_security_completions() -> Vec<CompletionItem> {
        let annotations = vec![
            "constant_time", "cache_resistant", "secure_memory", "verify_protocol",
            "wipe_on_drop", "distributed", "threshold_sign", "verify_soundness",
            "verify_zero_knowledge", "power_resistant",
        ];

        annotations.into_iter().map(|ann| {
            CompletionItem {
                label: format!("#[security({})]", ann),
                kind: Some(CompletionItemKind::SNIPPET),
                detail: Some(format!("Security annotation: {}", ann)),
                documentation: Some(Documentation::MarkupContent(MarkupContent {
                    kind: MarkupKind::Markdown,
                    value: format!("**#[security({})]** - Security annotation", ann),
                })),
                insert_text: Some(format!("#[security({})]\n$0", ann)),
                insert_text_format: Some(InsertTextFormat::SNIPPET),
                ..Default::default()
            }
        }).collect()
    }

    fn is_in_type_context(&self, _context: &str, _position: Position) -> bool {
        // TODO: Implement context analysis
        true
    }

    fn is_in_function_context(&self, _context: &str, _position: Position) -> bool {
        // TODO: Implement context analysis
        true
    }

    fn is_in_security_context(&self, _context: &str, _position: Position) -> bool {
        // TODO: Implement context analysis
        false
    }
}