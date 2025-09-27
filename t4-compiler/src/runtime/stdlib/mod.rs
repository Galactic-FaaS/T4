//! T4 Standard Library
//!
//! This module implements the comprehensive standard library for T4,
//! building on the runtime system and cryptographic primitives.
//! The standard library provides essential functionality for T4 programs
//! including data structures, I/O operations, string processing,
//! mathematical functions, utilities, error handling, concurrency,
//! and system integration.

pub mod collections;
pub mod io;
pub mod strings;
pub mod math;
pub mod utils;
pub mod error;
pub mod testing;
pub mod concurrency;
pub mod system;

pub use collections::{HashMap, HashSet, LinkedList, Queue, Stack, Deque, SecureVector};
pub use io::{FileSystem, Network, Console, Stream, Path, Directory};
pub use strings::{Utf8String, Regex, StringFormatter, TextEncoder, CryptoString};
pub use math::{MathFunctions, Random, Statistics, BigInt};
pub use utils::{Time, Environment, Config, Logger};
pub use error::{Result, Option, ErrorFormatter};
pub use testing::{TestFramework, Benchmark};
pub use concurrency::{ThreadSafeMap, AtomicOperations, AsyncRuntime, SyncPrimitives};
pub use system::{OSInterface, ProcessManager, MemoryInfo, HardwareDetector};

use crate::runtime::{
    values::Value,
    errors::{RuntimeError, RuntimeResult},
    memory::MemoryManager,
    security::SecurityManager,
};
use std::collections::HashMap as StdHashMap;
use std::sync::Arc;

/// Standard library registry
pub struct StandardLibrary {
    /// Library modules
    modules: StdHashMap<String, Box<dyn LibraryModule>>,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,

    /// Security manager
    security_manager: Arc<SecurityManager>,

    /// Global constants
    constants: StdHashMap<String, Value>,

    /// Function registry
    functions: StdHashMap<String, StandardFunction>,
}

/// Library module trait
pub trait LibraryModule: Send + Sync {
    /// Get module name
    fn name(&self) -> &str;

    /// Initialize the module
    fn initialize(&mut self) -> RuntimeResult<()>;

    /// Get module functions
    fn get_functions(&self) -> Vec<(&str, StandardFunction)>;

    /// Get module types
    fn get_types(&self) -> Vec<&str>;

    /// Get module constants
    fn get_constants(&self) -> StdHashMap<String, Value>;
}

/// Standard function definition
#[derive(Debug, Clone)]
pub struct StandardFunction {
    /// Function name
    pub name: String,

    /// Function implementation
    pub implementation: fn(&[Value]) -> RuntimeResult<Value>,

    /// Parameter types
    pub param_types: Vec<crate::ast::Type>,

    /// Return type
    pub return_type: Option<crate::ast::Type>,

    /// Security annotations
    pub security_annotations: Vec<crate::ast::SecurityAnnotation>,

    /// Module name
    pub module: String,
}

/// Standard library configuration
#[derive(Debug, Clone)]
pub struct StandardLibraryConfig {
    /// Enable cryptographic features
    pub crypto_enabled: bool,

    /// Enable network features
    pub network_enabled: bool,

    /// Enable file system features
    pub filesystem_enabled: bool,

    /// Enable concurrency features
    pub concurrency_enabled: bool,

    /// Memory safety level
    pub memory_safety: crate::runtime::MemorySafetyLevel,

    /// Security level
    pub security_level: crate::runtime::SecurityLevel,
}

impl Default for StandardLibraryConfig {
    fn default() -> Self {
        Self {
            crypto_enabled: true,
            network_enabled: true,
            filesystem_enabled: true,
            concurrency_enabled: true,
            memory_safety: crate::runtime::MemorySafetyLevel::Enhanced,
            security_level: crate::runtime::SecurityLevel::High,
        }
    }
}

impl StandardLibrary {
    /// Create a new standard library
    pub fn new(config: StandardLibraryConfig) -> RuntimeResult<Self> {
        let memory_manager = Arc::new(MemoryManager::new(config.memory_safety.clone())?);
        let security_manager = Arc::new(SecurityManager::new(config.security_level.clone())?);

        let mut stdlib = Self {
            modules: StdHashMap::new(),
            memory_manager: memory_manager.clone(),
            security_manager: security_manager.clone(),
            constants: StdHashMap::new(),
            functions: StdHashMap::new(),
        };

        // Initialize core modules
        stdlib.initialize_core_modules(config)?;

        Ok(stdlib)
    }

    /// Initialize core modules
    fn initialize_core_modules(&mut self, config: StandardLibraryConfig) -> RuntimeResult<()> {
        // Initialize collections module
        let mut collections_module = collections::CollectionsModule::new(
            self.memory_manager.clone(),
            self.security_manager.clone(),
        )?;
        collections_module.initialize()?;
        self.register_module(Box::new(collections_module));

        // Initialize I/O module if enabled
        if config.filesystem_enabled || config.network_enabled {
            let mut io_module = io::IOModule::new(
                self.memory_manager.clone(),
                self.security_manager.clone(),
                config.filesystem_enabled,
                config.network_enabled,
            )?;
            io_module.initialize()?;
            self.register_module(Box::new(io_module));
        }

        // Initialize strings module
        let mut strings_module = strings::StringsModule::new(
            self.memory_manager.clone(),
            self.security_manager.clone(),
        )?;
        strings_module.initialize()?;
        self.register_module(Box::new(strings_module));

        // Initialize math module
        let mut math_module = math::MathModule::new(
            self.memory_manager.clone(),
            self.security_manager.clone(),
        )?;
        math_module.initialize()?;
        self.register_module(Box::new(math_module));

        // Initialize utils module
        let mut utils_module = utils::UtilsModule::new(
            self.memory_manager.clone(),
            self.security_manager.clone(),
        )?;
        utils_module.initialize()?;
        self.register_module(Box::new(utils_module));

        // Initialize error handling module
        let mut error_module = error::ErrorModule::new(
            self.memory_manager.clone(),
            self.security_manager.clone(),
        )?;
        error_module.initialize()?;
        self.register_module(Box::new(error_module));

        // Initialize testing module
        let mut testing_module = testing::TestingModule::new(
            self.memory_manager.clone(),
            self.security_manager.clone(),
        )?;
        testing_module.initialize()?;
        self.register_module(Box::new(testing_module));

        // Initialize concurrency module if enabled
        if config.concurrency_enabled {
            let mut concurrency_module = concurrency::ConcurrencyModule::new(
                self.memory_manager.clone(),
                self.security_manager.clone(),
            )?;
            concurrency_module.initialize()?;
            self.register_module(Box::new(concurrency_module));
        }

        // Initialize system module
        let mut system_module = system::SystemModule::new(
            self.memory_manager.clone(),
            self.security_manager.clone(),
        )?;
        system_module.initialize()?;
        self.register_module(Box::new(system_module));

        Ok(())
    }

    /// Register a library module
    fn register_module(&mut self, module: Box<dyn LibraryModule>) {
        let module_name = module.name().to_string();

        // Register module functions
        for (func_name, function) in module.get_functions() {
            let full_name = if module_name == "core" {
                func_name.to_string()
            } else {
                format!("{}::{}", module_name, func_name)
            };

            self.functions.insert(full_name.clone(), function);
        }

        // Register module constants
        for (const_name, value) in module.get_constants() {
            let full_name = if module_name == "core" {
                const_name
            } else {
                format!("{}::{}", module_name, const_name)
            };

            self.constants.insert(full_name, value);
        }

        self.modules.insert(module_name, module);
    }

    /// Get a function by name
    pub fn get_function(&self, name: &str) -> Option<&StandardFunction> {
        self.functions.get(name)
    }

    /// Call a standard library function
    pub fn call_function(&self, name: &str, arguments: &[Value]) -> RuntimeResult<Value> {
        if let Some(function) = self.get_function(name) {
            // Security check
            self.security_manager.check_call(name, arguments)?;

            // Call the function
            (function.implementation)(arguments)
        } else {
            Err(RuntimeError::FunctionNotFound(name.to_string()))
        }
    }

    /// Get a constant by name
    pub fn get_constant(&self, name: &str) -> Option<&Value> {
        self.constants.get(name)
    }

    /// List all available functions
    pub fn list_functions(&self) -> Vec<&str> {
        self.functions.keys().map(|s| s.as_str()).collect()
    }

    /// List all available constants
    pub fn list_constants(&self) -> Vec<&str> {
        self.constants.keys().map(|s| s.as_str()).collect()
    }

    /// Get memory manager
    pub fn memory_manager(&self) -> &Arc<MemoryManager> {
        &self.memory_manager
    }

    /// Get security manager
    pub fn security_manager(&self) -> &Arc<SecurityManager> {
        &self.security_manager
    }

    /// Get library statistics
    pub fn get_statistics(&self) -> LibraryStatistics {
        LibraryStatistics {
            modules_loaded: self.modules.len(),
            functions_available: self.functions.len(),
            constants_available: self.constants.len(),
            memory_usage: self.memory_manager.get_usage_stats(),
        }
    }
}

/// Library statistics
#[derive(Debug, Clone)]
pub struct LibraryStatistics {
    pub modules_loaded: usize,
    pub functions_available: usize,
    pub constants_available: usize,
    pub memory_usage: crate::runtime::memory::MemoryUsageStats,
}

/// Standard library prelude - commonly used functions and types
pub mod prelude {
    // Re-export commonly used types and functions
    pub use super::collections::*;
    pub use super::io::*;
    pub use super::strings::*;
    pub use super::math::*;
    pub use super::utils::*;
    pub use super::error::*;

    // Common utility functions
    pub use crate::runtime::values::Value;

    // Standard library functions
    pub fn print(value: &Value) {
        println!("{}", value);
    }

    pub fn println(value: &Value) {
        println!("{}", value);
    }

    pub fn format(template: &str, args: &[Value]) -> String {
        // Simple string formatting implementation
        let mut result = template.to_string();
        for (i, arg) in args.iter().enumerate() {
            let placeholder = format!("{{{}}}", i);
            result = result.replace(&placeholder, &format!("{}", arg));
        }
        result
    }
}