//! Configuration management for T4 Compiler
//!
//! Handles loading and parsing of configuration files and command-line options.

use serde::{Deserialize, Serialize};
use std::collections::HashMap;
use std::path::Path;
use std::fs;

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Config {
    pub compiler: CompilerConfig,
    pub build: BuildConfig,
    pub security: SecurityConfig,
    pub crypto: CryptoConfig,
    pub output: OutputConfig,
    pub development: DevelopmentConfig,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct CompilerConfig {
    pub default_optimization_level: u8,
    pub default_target: Option<String>,
    pub include_paths: Vec<String>,
    pub library_paths: Vec<String>,
    pub defines: HashMap<String, String>,
    pub jobs: usize,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BuildConfig {
    pub output_dir: String,
    pub target_dir: String,
    pub cache_dir: String,
    pub clean_on_rebuild: bool,
    pub incremental: bool,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct SecurityConfig {
    pub hardening: bool,
    pub stack_protection: bool,
    pub fortify_source: bool,
    pub relro: bool,
    pub pie: bool,
    pub strip_binaries: bool,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct CryptoConfig {
    pub default_provider: String,
    pub post_quantum_enabled: bool,
    pub hardware_acceleration: bool,
    pub verify_operations: bool,
    pub allowed_algorithms: Vec<String>,
    pub deprecated_algorithms: Vec<String>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct OutputConfig {
    pub format: String,
    pub compression: bool,
    pub debug_info: bool,
    pub strip_debug: bool,
    pub generate_map: bool,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct DevelopmentConfig {
    pub verbose: bool,
    pub color_output: bool,
    pub progress_bar: bool,
    pub log_level: String,
    pub log_file: Option<String>,
}

impl Default for Config {
    fn default() -> Self {
        Self {
            compiler: CompilerConfig::default(),
            build: BuildConfig::default(),
            security: SecurityConfig::default(),
            crypto: CryptoConfig::default(),
            output: OutputConfig::default(),
            development: DevelopmentConfig::default(),
        }
    }
}

impl Default for CompilerConfig {
    fn default() -> Self {
        Self {
            default_optimization_level: 2,
            default_target: None,
            include_paths: Vec::new(),
            library_paths: Vec::new(),
            defines: HashMap::new(),
            jobs: num_cpus::get(),
        }
    }
}

impl Default for BuildConfig {
    fn default() -> Self {
        Self {
            output_dir: "target".to_string(),
            target_dir: "target".to_string(),
            cache_dir: "target/cache".to_string(),
            clean_on_rebuild: false,
            incremental: true,
        }
    }
}

impl Default for SecurityConfig {
    fn default() -> Self {
        Self {
            hardening: true,
            stack_protection: true,
            fortify_source: true,
            relro: true,
            pie: true,
            strip_binaries: false,
        }
    }
}

impl Default for CryptoConfig {
    fn default() -> Self {
        Self {
            default_provider: "rust-crypto".to_string(),
            post_quantum_enabled: false,
            hardware_acceleration: true,
            verify_operations: true,
            allowed_algorithms: vec![
                "AES256".to_string(),
                "ChaCha20".to_string(),
                "Ed25519".to_string(),
                "SecP256r1".to_string(),
                "SHA3_256".to_string(),
                "SHA3_512".to_string(),
            ],
            deprecated_algorithms: vec![
                "MD5".to_string(),
                "SHA1".to_string(),
                "DES".to_string(),
            ],
        }
    }
}

impl Default for OutputConfig {
    fn default() -> Self {
        Self {
            format: "binary".to_string(),
            compression: false,
            debug_info: false,
            strip_debug: false,
            generate_map: false,
        }
    }
}

impl Default for DevelopmentConfig {
    fn default() -> Self {
        Self {
            verbose: false,
            color_output: true,
            progress_bar: true,
            log_level: "info".to_string(),
            log_file: None,
        }
    }
}

impl Config {
    pub fn load(config_path: Option<&Path>) -> Result<Self, Box<dyn std::error::Error>> {
        // Try to load from specified path, or search for default locations
        let config_path = config_path.map(|p| p.to_path_buf()).or_else(|| {
            let candidates = [
                "t4c.toml",
                "t4c.json",
                ".t4c.toml",
                ".t4c.json",
            ];

            for candidate in &candidates {
                if Path::new(candidate).exists() {
                    return Some(PathBuf::from(candidate));
                }
            }
            None
        });

        if let Some(path) = config_path {
            let content = fs::read_to_string(&path)?;
            let extension = path.extension().and_then(|s| s.to_str()).unwrap_or("");

            let config: Config = match extension {
                "toml" => toml::from_str(&content)?,
                "json" => serde_json::from_str(&content)?,
                _ => return Err("Unsupported config file format. Use .toml or .json".into()),
            };

            Ok(config)
        } else {
            // Return default configuration
            Ok(Config::default())
        }
    }

    pub fn save(&self, path: &Path) -> Result<(), Box<dyn std::error::Error>> {
        let extension = path.extension().and_then(|s| s.to_str()).unwrap_or("");

        let content = match extension {
            "toml" => toml::to_string_pretty(self)?,
            "json" => serde_json::to_string_pretty(self)?,
            _ => return Err("Unsupported config file format. Use .toml or .json".into()),
        };

        fs::write(path, content)?;
        Ok(())
    }

    pub fn merge_cli_options(&mut self, cli_config: CliConfig) {
        if let Some(opt_level) = cli_config.optimization_level {
            self.compiler.default_optimization_level = opt_level;
        }

        if let Some(target) = cli_config.target {
            self.compiler.default_target = Some(target);
        }

        if let Some(jobs) = cli_config.jobs {
            self.compiler.jobs = jobs;
        }

        if let Some(verbose) = cli_config.verbose {
            self.development.verbose = verbose;
        }

        if let Some(format) = cli_config.output_format {
            self.output.format = format;
        }

        if let Some(debug) = cli_config.debug_info {
            self.output.debug_info = debug;
        }

        if let Some(hardening) = cli_config.security_hardening {
            self.security.hardening = hardening;
        }

        if let Some(verify) = cli_config.crypto_verify {
            self.crypto.verify_operations = verify;
        }

        if let Some(pq) = cli_config.post_quantum {
            self.crypto.post_quantum_enabled = pq;
        }

        if let Some(provider) = cli_config.crypto_provider {
            self.crypto.default_provider = provider;
        }
    }
}

#[derive(Debug, Default)]
pub struct CliConfig {
    pub optimization_level: Option<u8>,
    pub target: Option<String>,
    pub jobs: Option<usize>,
    pub verbose: Option<bool>,
    pub output_format: Option<String>,
    pub debug_info: Option<bool>,
    pub security_hardening: Option<bool>,
    pub crypto_verify: Option<bool>,
    pub post_quantum: Option<bool>,
    pub crypto_provider: Option<String>,
}