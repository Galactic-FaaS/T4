//! T4 Standard Library - Utils Module
//!
//! This module provides utility libraries including time and date handling,
//! environment variable access, configuration file parsing, and logging
//! with security considerations.

use crate::runtime::{
    values::Value,
    errors::{RuntimeError, RuntimeResult},
    memory::{MemoryManager, SecureMemoryGuard},
    security::SecurityManager,
};
use std::collections::HashMap as StdHashMap;
use std::sync::Arc;
use std::env;
use std::fs;
use std::path::Path;
use serde_json;
use chrono::{DateTime, Utc, TimeZone, Local, Duration};
use log::{Level, LevelFilter, Record, Metadata};

/// Utils module
pub struct UtilsModule {
    /// Module name
    name: String,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,

    /// Security manager
    security_manager: Arc<SecurityManager>,

    /// Functions provided by this module
    functions: Vec<(&'static str, StandardFunction)>,

    /// Types provided by this module
    types: Vec<&'static str>,

    /// Constants provided by this module
    constants: StdHashMap<String, Value>,
}

/// Time and date utilities
#[derive(Debug, Clone)]
pub struct Time {
    /// Security level for time operations
    security_level: crate::runtime::values::SecurityLevel,

    /// Timezone handling
    timezone: TimeZone,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,
}

/// Timezone enumeration
#[derive(Debug, Clone)]
pub enum TimeZone {
    Utc,
    Local,
    Custom(String),
}

/// Environment variable manager with security
#[derive(Debug, Clone)]
pub struct Environment {
    /// Security constraints
    security_constraints: EnvironmentSecurityConstraints,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,

    /// Security manager
    security_manager: Arc<SecurityManager>,
}

/// Security constraints for environment access
#[derive(Debug, Clone)]
pub struct EnvironmentSecurityConstraints {
    /// Allowed environment variables
    pub allowed_variables: Vec<String>,

    /// Block sensitive variables
    pub block_sensitive: bool,

    /// Audit access
    pub audit_access: bool,

    /// Encryption for sensitive values
    pub encrypt_sensitive: bool,
}

/// Configuration manager
#[derive(Debug, Clone)]
pub struct Config {
    /// Configuration data
    config_data: Value,

    /// Configuration file path
    config_path: Option<String>,

    /// Security level
    security_level: crate::runtime::values::SecurityLevel,

    /// Encryption enabled
    encryption_enabled: bool,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,
}

/// Secure logger with security considerations
#[derive(Debug, Clone)]
pub struct Logger {
    /// Logger name
    name: String,

    /// Security level
    security_level: crate::runtime::values::SecurityLevel,

    /// Log level
    level: Level,

    /// Output target
    output_target: LogTarget,

    /// Security constraints
    security_constraints: LoggerSecurityConstraints,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,
}

/// Log target
#[derive(Debug, Clone)]
pub enum LogTarget {
    Console,
    File(String),
    Memory,
    Syslog,
}

/// Security constraints for logging
#[derive(Debug, Clone)]
pub struct LoggerSecurityConstraints {
    /// Maximum log message length
    pub max_message_length: usize,

    /// Sanitize sensitive data
    pub sanitize_sensitive: bool,

    /// Encrypt log files
    pub encrypt_logs: bool,

    /// Audit logging operations
    pub audit_logging: bool,

    /// Rate limiting (messages per second)
    pub rate_limit_per_second: Option<u32>,
}

/// Command line argument processor
#[derive(Debug, Clone)]
pub struct Args {
    /// Program arguments
    args: Vec<String>,

    /// Security constraints
    security_constraints: ArgsSecurityConstraints,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,
}

/// Security constraints for command line arguments
#[derive(Debug, Clone)]
pub struct ArgsSecurityConstraints {
    /// Maximum argument length
    pub max_arg_length: usize,

    /// Maximum number of arguments
    pub max_arg_count: usize,

    /// Sanitize arguments
    pub sanitize_args: bool,

    /// Block dangerous arguments
    pub block_dangerous: bool,
}

impl UtilsModule {
    /// Create a new utils module
    pub fn new(
        memory_manager: Arc<MemoryManager>,
        security_manager: Arc<SecurityManager>,
    ) -> RuntimeResult<Self> {
        let mut functions = Vec::new();
        let mut types = Vec::new();
        let mut constants = StdHashMap::new();

        // Register utility types
        types.extend(vec![
            "Time", "Environment", "Config", "Logger", "Args"
        ]);

        // Register time constants
        constants.insert("SECONDS_PER_MINUTE".to_string(), Value::Integer(60));
        constants.insert("SECONDS_PER_HOUR".to_string(), Value::Integer(3600));
        constants.insert("SECONDS_PER_DAY".to_string(), Value::Integer(86400));
        constants.insert("DAYS_PER_WEEK".to_string(), Value::Integer(7));
        constants.insert("MONTHS_PER_YEAR".to_string(), Value::Integer(12));

        // Time and date functions
        functions.push(("time_now", time_now as StandardFunction));
        functions.push(("time_utc", time_utc as StandardFunction));
        functions.push(("time_local", time_local as StandardFunction));
        functions.push(("time_timestamp", time_timestamp as StandardFunction));
        functions.push(("time_format", time_format as StandardFunction));
        functions.push(("time_parse", time_parse as StandardFunction));
        functions.push(("time_add", time_add as StandardFunction));
        functions.push(("time_sub", time_sub as StandardFunction));
        functions.push(("time_diff", time_diff as StandardFunction));

        // Environment functions
        functions.push(("env_get", env_get as StandardFunction));
        functions.push(("env_set", env_set as StandardFunction));
        functions.push(("env_list", env_list as StandardFunction));
        functions.push(("env_exists", env_exists as StandardFunction));

        // Configuration functions
        functions.push(("config_load", config_load as StandardFunction));
        functions.push(("config_save", config_save as StandardFunction));
        functions.push(("config_get", config_get as StandardFunction));
        functions.push(("config_set", config_set as StandardFunction));
        functions.push(("config_keys", config_keys as StandardFunction));

        // Logging functions
        functions.push(("log_debug", log_debug as StandardFunction));
        functions.push(("log_info", log_info as StandardFunction));
        functions.push(("log_warn", log_warn as StandardFunction));
        functions.push(("log_error", log_error as StandardFunction));
        functions.push(("log_critical", log_critical as StandardFunction));

        // Command line arguments
        functions.push(("args_len", args_len as StandardFunction));
        functions.push(("args_get", args_get as StandardFunction));
        functions.push(("args_has", args_has as StandardFunction));

        Ok(Self {
            name: "utils".to_string(),
            memory_manager,
            security_manager,
            functions,
            types,
            constants,
        })
    }
}

impl super::LibraryModule for UtilsModule {
    fn name(&self) -> &str {
        &self.name
    }

    fn initialize(&mut self) -> RuntimeResult<()> {
        // Initialize logging system
        env::set_var("RUST_LOG", "info");
        Ok(())
    }

    fn get_functions(&self) -> Vec<(&str, StandardFunction)> {
        self.functions.clone()
    }

    fn get_types(&self) -> Vec<&str> {
        self.types.clone()
    }

    fn get_constants(&self) -> StdHashMap<String, Value> {
        self.constants.clone()
    }
}

// Function implementations
type StandardFunction = fn(&[Value]) -> RuntimeResult<Value>;

// Time and date functions
fn time_now(args: &[Value]) -> RuntimeResult<Value> {
    let now = Utc::now();
    Ok(Value::String(now.to_rfc3339()))
}

fn time_utc(args: &[Value]) -> RuntimeResult<Value> {
    let now = Utc::now();
    Ok(Value::String(now.to_rfc3339()))
}

fn time_local(args: &[Value]) -> RuntimeResult<Value> {
    let now = Local::now();
    Ok(Value::String(now.to_rfc3339()))
}

fn time_timestamp(args: &[Value]) -> RuntimeResult<Value> {
    let now = Utc::now();
    Ok(Value::Integer(now.timestamp()))
}

fn time_format(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(timestamp)), Some(Value::String(format))) = (args.get(0), args.get(1)) {
        // Parse timestamp and format it
        match DateTime::parse_from_rfc3339(timestamp) {
            Ok(dt) => {
                let formatted = dt.format(format).to_string();
                Ok(Value::String(formatted))
            }
            Err(_) => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn time_parse(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(time_str)), Some(Value::String(format))) = (args.get(0), args.get(1)) {
        // Parse time string with format
        match DateTime::parse_from_str(time_str, format) {
            Ok(dt) => Ok(Value::String(dt.to_rfc3339())),
            Err(_) => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn time_add(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(timestamp)), Some(Value::Integer(seconds))) = (args.get(0), args.get(1)) {
        match DateTime::parse_from_rfc3339(timestamp) {
            Ok(dt) => {
                let new_dt = dt + Duration::seconds(*seconds);
                Ok(Value::String(new_dt.to_rfc3339()))
            }
            Err(_) => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn time_sub(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(timestamp)), Some(Value::Integer(seconds))) = (args.get(0), args.get(1)) {
        match DateTime::parse_from_rfc3339(timestamp) {
            Ok(dt) => {
                let new_dt = dt - Duration::seconds(*seconds);
                Ok(Value::String(new_dt.to_rfc3339()))
            }
            Err(_) => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn time_diff(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(start)), Some(Value::String(end))) = (args.get(0), args.get(1)) {
        match (DateTime::parse_from_rfc3339(start), DateTime::parse_from_rfc3339(end)) {
            (Ok(start_dt), Ok(end_dt)) => {
                let diff = end_dt.signed_duration_since(start_dt);
                Ok(Value::Integer(diff.num_seconds()))
            }
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Environment functions
fn env_get(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(var_name)) = args.get(0) {
        // Security check - validate variable name
        if !is_env_var_allowed(var_name) {
            return Ok(Value::Unit); // Return unit for blocked variables
        }

        match env::var(var_name) {
            Ok(value) => Ok(Value::String(value)),
            Err(_) => Ok(Value::Unit), // Variable not found
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn env_set(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(var_name)), Some(Value::String(value))) = (args.get(0), args.get(1)) {
        // Security check - validate variable name
        if !is_env_var_allowed(var_name) {
            return Err(RuntimeError::SecurityViolation);
        }

        env::set_var(var_name, value);
        Ok(Value::Unit)
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn env_list(args: &[Value]) -> RuntimeResult<Value> {
    let vars: Vec<Value> = env::vars()
        .filter(|(name, _)| is_env_var_allowed(name))
        .map(|(name, _)| Value::String(name))
        .collect();

    Ok(Value::Array(crate::runtime::values::RuntimeArray {
        element_type: crate::ast::Type::String,
        elements: vars,
        length: vars.len(),
    }))
}

fn env_exists(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(var_name)) = args.get(0) {
        // Security check - validate variable name
        if !is_env_var_allowed(var_name) {
            return Ok(Value::Bool(false));
        }

        Ok(Value::Bool(env::var(var_name).is_ok()))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Configuration functions
fn config_load(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(path)) = args.get(0) {
        // Security check - validate config file path
        let config_path = Path::new(path);
        if !is_config_path_safe(config_path) {
            return Err(RuntimeError::SecurityViolation);
        }

        match fs::read_to_string(config_path) {
            Ok(contents) => {
                match serde_json::from_str::<serde_json::Value>(&contents) {
                    Ok(json_value) => {
                        // Convert JSON to T4 Value
                        Ok(json_to_value(json_value))
                    }
                    Err(_) => Err(RuntimeError::InvalidArgument), // Invalid JSON
                }
            }
            Err(_) => Err(RuntimeError::IOError),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn config_save(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(path)), Some(config_value)) = (args.get(0), args.get(1)) {
        // Security check - validate config file path
        let config_path = Path::new(path);
        if !is_config_path_safe(config_path) {
            return Err(RuntimeError::SecurityViolation);
        }

        // Convert T4 Value to JSON
        let json_value = value_to_json(config_value);
        match serde_json::to_string_pretty(&json_value) {
            Ok(json_string) => {
                match fs::write(config_path, json_string) {
                    Ok(_) => Ok(Value::Bool(true)),
                    Err(_) => Ok(Value::Bool(false)),
                }
            }
            Err(_) => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn config_get(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(config), Some(Value::String(key))) = (args.get(0), args.get(1)) {
        // In a real implementation, this would get a value from the config
        Ok(Value::Unit) // Placeholder
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn config_set(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(config), Some(Value::String(key)), Some(value)) = (args.get(0), args.get(1), args.get(2)) {
        // In a real implementation, this would set a value in the config
        Ok(Value::Unit) // Placeholder
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn config_keys(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(config) = args.get(0) {
        // In a real implementation, this would return all config keys
        Ok(Value::Array(crate::runtime::values::RuntimeArray {
            element_type: crate::ast::Type::String,
            elements: Vec::new(),
            length: 0,
        }))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Logging functions
fn log_debug(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(message)) = args.get(0) {
        // Security check - sanitize message
        let sanitized = sanitize_log_message(message);
        log::debug!("{}", sanitized);
        Ok(Value::Unit)
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn log_info(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(message)) = args.get(0) {
        let sanitized = sanitize_log_message(message);
        log::info!("{}", sanitized);
        Ok(Value::Unit)
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn log_warn(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(message)) = args.get(0) {
        let sanitized = sanitize_log_message(message);
        log::warn!("{}", sanitized);
        Ok(Value::Unit)
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn log_error(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(message)) = args.get(0) {
        let sanitized = sanitize_log_message(message);
        log::error!("{}", sanitized);
        Ok(Value::Unit)
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn log_critical(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(message)) = args.get(0) {
        let sanitized = sanitize_log_message(message);
        log::error!("CRITICAL: {}", sanitized);
        Ok(Value::Unit)
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Command line arguments functions
fn args_len(args: &[Value]) -> RuntimeResult<Value> {
    let args: Vec<String> = std::env::args().collect();
    Ok(Value::Integer(args.len() as i64))
}

fn args_get(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Integer(index)) = args.get(0) {
        let args: Vec<String> = std::env::args().collect();
        if let Some(arg) = args.get(*index as usize) {
            Ok(Value::String(arg.clone()))
        } else {
            Ok(Value::Unit)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn args_has(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(arg)) = args.get(0) {
        let args: Vec<String> = std::env::args().collect();
        Ok(Value::Bool(args.contains(arg)))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Utility functions
fn is_env_var_allowed(var_name: &str) -> bool {
    // Basic security check for environment variables
    let dangerous_vars = ["PATH", "LD_LIBRARY_PATH", "HOME", "USER", "SHELL"];
    !dangerous_vars.contains(&var_name) || var_name.starts_with("T4_")
}

fn is_config_path_safe(path: &Path) -> bool {
    // Basic security check for config file paths
    let path_str = path.to_string_lossy().to_string();
    !path_str.contains("..") &&
    (path_str.ends_with(".json") || path_str.ends_with(".yaml") || path_str.ends_with(".toml"))
}

fn sanitize_log_message(message: &str) -> String {
    // Basic sanitization - remove control characters and limit length
    let sanitized: String = message
        .chars()
        .filter(|c| !c.is_control() || *c == '\n' || *c == '\r' || *c == '\t')
        .take(1000) // Limit message length
        .collect();

    // Remove potentially sensitive patterns
    sanitized
        .replace("password", "[REDACTED]")
        .replace("secret", "[REDACTED]")
        .replace("key", "[REDACTED]")
        .replace("token", "[REDACTED]")
}

fn json_to_value(json_value: serde_json::Value) -> Value {
    match json_value {
        serde_json::Value::Null => Value::Unit,
        serde_json::Value::Bool(b) => Value::Bool(b),
        serde_json::Value::Number(n) => {
            if let Some(i) = n.as_i64() {
                Value::Integer(i)
            } else if let Some(f) = n.as_f64() {
                Value::Float(f)
            } else {
                Value::Integer(0)
            }
        }
        serde_json::Value::String(s) => Value::String(s),
        serde_json::Value::Array(arr) => {
            let elements: Vec<Value> = arr.into_iter().map(json_to_value).collect();
            Value::Array(crate::runtime::values::RuntimeArray {
                element_type: crate::ast::Type::Infer,
                elements,
                length: elements.len(),
            })
        }
        serde_json::Value::Object(obj) => {
            let mut fields = StdHashMap::new();
            for (key, value) in obj {
                fields.insert(key, json_to_value(value));
            }
            Value::new_struct("ConfigObject".to_string(), fields)
        }
    }
}

fn value_to_json(value: &Value) -> serde_json::Value {
    match value {
        Value::Unit => serde_json::Value::Null,
        Value::Bool(b) => serde_json::Value::Bool(*b),
        Value::Integer(i) => serde_json::Value::Number((*i).into()),
        Value::Float(f) => serde_json::Value::Number(serde_json::Number::from_f64(*f).unwrap_or(serde_json::Number::from(0))),
        Value::String(s) => serde_json::Value::String(s.clone()),
        Value::Bytes(b) => serde_json::Value::String(format!("{:?}", b)), // Convert bytes to string representation
        Value::Array(arr) => {
            let elements: Vec<serde_json::Value> = arr.elements.iter().map(value_to_json).collect();
            serde_json::Value::Array(elements)
        }
        Value::Struct(s) => {
            let mut obj = serde_json::Map::new();
            for (key, value) in &s.fields {
                obj.insert(key.clone(), value_to_json(value));
            }
            serde_json::Value::Object(obj)
        }
        _ => serde_json::Value::Null, // Other types not supported in JSON
    }
}

// Time implementation
impl Time {
    /// Create a new time utility
    pub fn new(
        security_level: crate::runtime::values::SecurityLevel,
        timezone: TimeZone,
        memory_manager: Arc<MemoryManager>,
    ) -> Self {
        Self {
            security_level,
            timezone,
            memory_manager,
        }
    }

    /// Get current time
    pub fn now(&self) -> DateTime<Utc> {
        Utc::now()
    }

    /// Get current time in local timezone
    pub fn now_local(&self) -> DateTime<Local> {
        Local::now()
    }

    /// Format timestamp
    pub fn format(&self, timestamp: DateTime<Utc>, format: &str) -> String {
        match self.timezone {
            TimeZone::Utc => timestamp.format(format).to_string(),
            TimeZone::Local => timestamp.with_timezone(&Local).format(format).to_string(),
            TimeZone::Custom(_) => timestamp.format(format).to_string(), // Simplified
        }
    }

    /// Parse time string
    pub fn parse(&self, time_str: &str, format: &str) -> RuntimeResult<DateTime<Utc>> {
        DateTime::parse_from_str(time_str, format)
            .map(|dt| dt.with_timezone(&Utc))
            .map_err(|_| RuntimeError::InvalidArgument)
    }

    /// Add duration to timestamp
    pub fn add_duration(&self, timestamp: DateTime<Utc>, duration: Duration) -> DateTime<Utc> {
        timestamp + duration
    }

    /// Subtract duration from timestamp
    pub fn sub_duration(&self, timestamp: DateTime<Utc>, duration: Duration) -> DateTime<Utc> {
        timestamp - duration
    }

    /// Calculate difference between timestamps
    pub fn difference(&self, start: DateTime<Utc>, end: DateTime<Utc>) -> Duration {
        end.signed_duration_since(start)
    }
}

// Environment implementation
impl Environment {
    /// Create a new environment manager
    pub fn new(
        security_constraints: EnvironmentSecurityConstraints,
        memory_manager: Arc<MemoryManager>,
        security_manager: Arc<SecurityManager>,
    ) -> Self {
        Self {
            security_constraints,
            memory_manager,
            security_manager,
        }
    }

    /// Get environment variable with security checks
    pub fn get(&self, name: &str) -> RuntimeResult<Option<String>> {
        // Security validation
        self.security_manager.check_env_access(name)?;

        if !self.is_variable_allowed(name) {
            return Ok(None);
        }

        match env::var(name) {
            Ok(value) => Ok(Some(value)),
            Err(_) => Ok(None),
        }
    }

    /// Set environment variable with security checks
    pub fn set(&self, name: &str, value: &str) -> RuntimeResult<()> {
        // Security validation
        self.security_manager.check_env_access(name)?;

        if !self.is_variable_allowed(name) {
            return Err(RuntimeError::SecurityViolation);
        }

        env::set_var(name, value);
        Ok(())
    }

    /// Check if variable is allowed
    fn is_variable_allowed(&self, name: &str) -> bool {
        if self.security_constraints.block_sensitive {
            let sensitive_vars = ["PATH", "LD_LIBRARY_PATH", "HOME", "USER", "SHELL"];
            if sensitive_vars.contains(&name) {
                return false;
            }
        }

        self.security_constraints.allowed_variables.is_empty() ||
        self.security_constraints.allowed_variables.contains(&name.to_string())
    }

    /// List allowed environment variables
    pub fn list(&self) -> RuntimeResult<Vec<String>> {
        Ok(env::vars()
            .filter(|(name, _)| self.is_variable_allowed(name))
            .map(|(name, _)| name)
            .collect())
    }
}

// Config implementation
impl Config {
    /// Create a new configuration manager
    pub fn new(
        config_data: Value,
        config_path: Option<String>,
        security_level: crate::runtime::values::SecurityLevel,
        encryption_enabled: bool,
        memory_manager: Arc<MemoryManager>,
    ) -> Self {
        Self {
            config_data,
            config_path,
            security_level,
            encryption_enabled,
            memory_manager,
        }
    }

    /// Load configuration from file
    pub fn load_from_file(path: &str) -> RuntimeResult<Self> {
        let config_path = Path::new(path);
        if !is_config_path_safe(config_path) {
            return Err(RuntimeError::SecurityViolation);
        }

        match fs::read_to_string(config_path) {
            Ok(contents) => {
                match serde_json::from_str::<serde_json::Value>(&contents) {
                    Ok(json_value) => {
                        Ok(Self::new(
                            json_to_value(json_value),
                            Some(path.to_string()),
                            crate::runtime::values::SecurityLevel::Medium,
                            false,
                            Arc::new(MemoryManager::new(crate::runtime::MemorySafetyLevel::Standard).unwrap()),
                        ))
                    }
                    Err(_) => Err(RuntimeError::InvalidArgument),
                }
            }
            Err(_) => Err(RuntimeError::IOError),
        }
    }

    /// Save configuration to file
    pub fn save_to_file(&self, path: &str) -> RuntimeResult<()> {
        let config_path = Path::new(path);
        if !is_config_path_safe(config_path) {
            return Err(RuntimeError::SecurityViolation);
        }

        let json_value = value_to_json(&self.config_data);
        match serde_json::to_string_pretty(&json_value) {
            Ok(json_string) => {
                match fs::write(config_path, json_string) {
                    Ok(_) => Ok(()),
                    Err(_) => Err(RuntimeError::IOError),
                }
            }
            Err(_) => Err(RuntimeError::InvalidArgument),
        }
    }

    /// Get configuration value
    pub fn get(&self, key: &str) -> Option<&Value> {
        match &self.config_data {
            Value::Struct(s) => s.fields.get(key),
            _ => None,
        }
    }

    /// Set configuration value
    pub fn set(&mut self, key: String, value: Value) {
        match &mut self.config_data {
            Value::Struct(s) => {
                s.fields.insert(key, value);
            }
            _ => {
                // Convert to struct if not already
                self.config_data = Value::new_struct("Config".to_string(), {
                    let mut fields = StdHashMap::new();
                    fields.insert(key, value);
                    fields
                });
            }
        }
    }

    /// Get all configuration keys
    pub fn keys(&self) -> Vec<String> {
        match &self.config_data {
            Value::Struct(s) => s.fields.keys().cloned().collect(),
            _ => Vec::new(),
        }
    }
}

// Logger implementation
impl Logger {
    /// Create a new logger
    pub fn new(
        name: String,
        security_level: crate::runtime::values::SecurityLevel,
        level: Level,
        output_target: LogTarget,
        security_constraints: LoggerSecurityConstraints,
        memory_manager: Arc<MemoryManager>,
    ) -> Self {
        Self {
            name,
            security_level,
            level,
            output_target,
            security_constraints,
            memory_manager,
        }
    }

    /// Log a message with security considerations
    pub fn log(&self, level: Level, message: &str) -> RuntimeResult<()> {
        if level < self.level {
            return Ok(()); // Filter out messages below the configured level
        }

        // Sanitize message
        let sanitized = self.sanitize_message(message);

        // Check rate limiting
        if !self.check_rate_limit() {
            return Ok(()); // Rate limited
        }

        // Log based on target
        match &self.output_target {
            LogTarget::Console => {
                println!("[{}] {}", self.name, sanitized);
            }
            LogTarget::File(path) => {
                if let Ok(mut file) = fs::OpenOptions::new().create(true).append(true).open(path) {
                    use std::io::Write;
                    let _ = writeln!(file, "[{}] {}", self.name, sanitized);
                }
            }
            LogTarget::Memory => {
                // Store in memory (simplified)
            }
            LogTarget::Syslog => {
                // Send to syslog (simplified)
            }
        }

        Ok(())
    }

    /// Sanitize log message
    fn sanitize_message(&self, message: &str) -> String {
        let mut sanitized = message.to_string();

        if self.security_constraints.sanitize_sensitive {
            sanitized = sanitize_log_message(&sanitized);
        }

        // Truncate if too long
        if sanitized.len() > self.security_constraints.max_message_length {
            sanitized.truncate(self.security_constraints.max_message_length);
        }

        sanitized
    }

    /// Check rate limiting
    fn check_rate_limit(&self) -> bool {
        if let Some(limit) = self.security_constraints.rate_limit_per_second {
            // Simplified rate limiting - in a real implementation, this would track timestamps
            true
        } else {
            true
        }
    }

    /// Log debug message
    pub fn debug(&self, message: &str) -> RuntimeResult<()> {
        self.log(Level::Debug, message)
    }

    /// Log info message
    pub fn info(&self, message: &str) -> RuntimeResult<()> {
        self.log(Level::Info, message)
    }

    /// Log warning message
    pub fn warn(&self, message: &str) -> RuntimeResult<()> {
        self.log(Level::Warn, message)
    }

    /// Log error message
    pub fn error(&self, message: &str) -> RuntimeResult<()> {
        self.log(Level::Error, message)
    }
}

// Args implementation
impl Args {
    /// Create a new arguments processor
    pub fn new(
        args: Vec<String>,
        security_constraints: ArgsSecurityConstraints,
        memory_manager: Arc<MemoryManager>,
    ) -> Self {
        Self {
            args,
            security_constraints,
            memory_manager,
        }
    }

    /// Get argument count
    pub fn len(&self) -> usize {
        self.args.len()
    }

    /// Get argument at index
    pub fn get(&self, index: usize) -> Option<&str> {
        if index >= self.args.len() {
            return None;
        }

        let arg = &self.args[index];

        // Security check - validate argument
        if !self.is_argument_safe(arg) {
            return None;
        }

        Some(arg)
    }

    /// Check if argument exists
    pub fn has(&self, arg: &str) -> bool {
        if !self.is_argument_safe(arg) {
            return false;
        }

        self.args.contains(&arg.to_string())
    }

    /// Check if argument is safe
    fn is_argument_safe(&self, arg: &str) -> bool {
        if self.security_constraints.block_dangerous {
            let dangerous_args = ["--exec", "--eval", "--dangerous"];
            if dangerous_args.iter().any(|&dangerous| arg.contains(dangerous)) {
                return false;
            }
        }

        arg.len() <= self.security_constraints.max_arg_length
    }

    /// Get all arguments
    pub fn all(&self) -> Vec<&str> {
        self.args.iter()
            .filter(|arg| self.is_argument_safe(arg))
            .map(|s| s.as_str())
            .collect()
    }
}

// Default implementations
impl Default for EnvironmentSecurityConstraints {
    fn default() -> Self {
        Self {
            allowed_variables: Vec::new(),
            block_sensitive: true,
            audit_access: true,
            encrypt_sensitive: false,
        }
    }
}

impl Default for LoggerSecurityConstraints {
    fn default() -> Self {
        Self {
            max_message_length: 1000,
            sanitize_sensitive: true,
            encrypt_logs: false,
            audit_logging: true,
            rate_limit_per_second: Some(100),
        }
    }
}

impl Default for ArgsSecurityConstraints {
    fn default() -> Self {
        Self {
            max_arg_length: 1000,
            max_arg_count: 100,
            sanitize_args: true,
            block_dangerous: true,
        }
    }
}