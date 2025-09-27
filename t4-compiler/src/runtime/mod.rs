//! T4 Runtime and Interpreter System
//!
//! This module implements the complete runtime and interpreter system for T4,
//! including execution engine, memory management, cryptographic operations,
//! and runtime support for all T4 language features.

pub mod engine;
pub mod memory;
pub mod values;
pub mod crypto;
pub mod symmetric;
pub mod asymmetric;
pub mod builtins;
pub mod execution;
pub mod security;
pub mod errors;
pub mod stdlib;

pub use engine::{Runtime, ExecutionContext, CallFrame};
pub use memory::{MemoryManager, SecureAllocator, MemoryRegion};
pub use values::{Value, RuntimeValue, SecretValue, CryptoValue};
pub use crypto::{CryptoProvider, CryptoRuntime, KeyManager, SymmetricEncryptionManager, AsymmetricEncryptionManager};
pub use builtins::{BuiltinFunctions, StandardLibrary};
pub use execution::{ExpressionEvaluator, StatementExecutor, ControlFlow};
pub use security::{SecurityManager, ConstantTimeOps, SideChannelProtection};
pub use errors::{RuntimeError, RuntimeResult};

use crate::ast::{Program, Type};
use std::collections::HashMap;

/// Main T4 runtime system
pub struct T4Runtime {
    /// Core execution engine
    engine: Runtime,

    /// Memory management system
    memory_manager: MemoryManager,

    /// Cryptographic runtime support
    crypto_runtime: CryptoRuntime,

    /// Built-in functions and standard library
    builtins: BuiltinFunctions,

    /// Comprehensive standard library
    stdlib: stdlib::StandardLibrary,

    /// Security management
    security_manager: SecurityManager,

    /// Global symbol table
    globals: HashMap<String, Value>,

    /// Configuration
    config: RuntimeConfig,
}

/// Runtime configuration
#[derive(Debug, Clone)]
pub struct RuntimeConfig {
    /// Enable cryptographic operations
    pub crypto_enabled: bool,

    /// Enable post-quantum cryptography
    pub post_quantum_enabled: bool,

    /// Hardware acceleration enabled
    pub hardware_acceleration: bool,

    /// Memory safety level
    pub memory_safety: MemorySafetyLevel,

    /// Security hardening level
    pub security_level: SecurityLevel,

    /// Performance optimization level
    pub optimization_level: OptimizationLevel,
}

#[derive(Debug, Clone)]
pub enum MemorySafetyLevel {
    /// Standard memory safety
    Standard,
    /// Enhanced memory safety with cryptographic protections
    Enhanced,
    /// Maximum security with full memory wiping
    Maximum,
}

#[derive(Debug, Clone)]
pub enum SecurityLevel {
    /// Standard security
    Standard,
    /// High security with side-channel protection
    High,
    /// Maximum security with formal verification
    Maximum,
}

#[derive(Debug, Clone)]
pub enum OptimizationLevel {
    /// No optimizations
    None,
    /// Basic optimizations
    Basic,
    /// Aggressive optimizations
    Aggressive,
}

impl Default for RuntimeConfig {
    fn default() -> Self {
        Self {
            crypto_enabled: true,
            post_quantum_enabled: true,
            hardware_acceleration: true,
            memory_safety: MemorySafetyLevel::Enhanced,
            security_level: SecurityLevel::High,
            optimization_level: OptimizationLevel::Basic,
        }
    }
}

impl T4Runtime {
    /// Create a new T4 runtime with default configuration
    pub fn new() -> RuntimeResult<Self> {
        Self::with_config(RuntimeConfig::default())
    }

    /// Create a new T4 runtime with custom configuration
    pub fn with_config(config: RuntimeConfig) -> RuntimeResult<Self> {
        let memory_manager = MemoryManager::new(config.memory_safety.clone())?;
        let crypto_runtime = CryptoRuntime::new(config.crypto_enabled, config.post_quantum_enabled)?;
        let security_manager = SecurityManager::new(config.security_level.clone())?;
        let builtins = BuiltinFunctions::new()?;

        // Initialize comprehensive standard library
        let stdlib_config = stdlib::StandardLibraryConfig {
            crypto_enabled: config.crypto_enabled,
            network_enabled: true,
            filesystem_enabled: true,
            concurrency_enabled: true,
            memory_safety: config.memory_safety.clone(),
            security_level: config.security_level.clone(),
        };
        let stdlib = stdlib::StandardLibrary::new(stdlib_config)?;

        Ok(Self {
            engine: Runtime::new()?,
            memory_manager,
            crypto_runtime,
            builtins,
            stdlib,
            security_manager,
            globals: HashMap::new(),
            config,
        })
    }

    /// Execute a T4 program
    pub async fn execute_program(&mut self, program: &Program) -> RuntimeResult<Value> {
        // Initialize execution context
        let mut context = ExecutionContext::new(program)?;

        // Execute program declarations
        for declaration in &program.declarations {
            self.execute_declaration(&mut context, declaration).await?;
        }

        // Return the result of the main function if it exists
        if let Some(main_result) = self.globals.get("main") {
            Ok(main_result.clone())
        } else {
            Ok(Value::Unit)
        }
    }

    /// Execute a single declaration
    async fn execute_declaration(
        &mut self,
        context: &mut ExecutionContext,
        declaration: &crate::ast::Declaration,
    ) -> RuntimeResult<()> {
        match declaration {
            crate::ast::Declaration::Function(func) => {
                self.register_function(context, func).await
            }
            crate::ast::Declaration::Static(var) => {
                self.execute_static_declaration(context, var).await
            }
            _ => {
                // Other declarations are handled during compilation
                Ok(())
            }
        }
    }

    /// Register a function in the runtime
    async fn register_function(
        &mut self,
        context: &mut ExecutionContext,
        function: &crate::ast::Function,
    ) -> RuntimeResult<()> {
        let func_name = context.interner.get(function.name.name).unwrap_or("unknown");
        let runtime_function = RuntimeFunction::from_ast(function, context)?;

        self.globals.insert(
            func_name.to_string(),
            Value::Function(Box::new(runtime_function)),
        );

        Ok(())
    }

    /// Execute a static variable declaration
    async fn execute_static_declaration(
        &mut self,
        context: &mut ExecutionContext,
        static_var: &crate::ast::StaticVariable,
    ) -> RuntimeResult<()> {
        let var_name = context.interner.get(static_var.name.name).unwrap_or("unknown");

        if let Some(ref value_expr) = static_var.value {
            let value = self.evaluate_expression(context, value_expr).await?;
            self.globals.insert(var_name.to_string(), value);
        }

        Ok(())
    }

    /// Evaluate an expression
    async fn evaluate_expression(
        &mut self,
        context: &mut ExecutionContext,
        expression: &crate::ast::Expression,
    ) -> RuntimeResult<Value> {
        let mut evaluator = ExpressionEvaluator::new(
            &self.memory_manager,
            &self.crypto_runtime,
            &self.builtins,
            &self.security_manager,
        );

        evaluator.evaluate_expression(context, expression).await
    }

    /// Get runtime statistics
    pub fn get_statistics(&self) -> RuntimeStatistics {
        RuntimeStatistics {
            memory_usage: self.memory_manager.get_usage_stats(),
            crypto_operations: self.crypto_runtime.get_operation_count(),
            security_violations: self.security_manager.get_violation_count(),
            execution_time: std::time::Duration::from_secs(0), // TODO: Track execution time
        }
    }
}

/// Runtime statistics
#[derive(Debug, Clone)]
pub struct RuntimeStatistics {
    pub memory_usage: MemoryUsageStats,
    pub crypto_operations: u64,
    pub security_violations: u64,
    pub execution_time: std::time::Duration,
}

/// Memory usage statistics
#[derive(Debug, Clone)]
pub struct MemoryUsageStats {
    pub total_allocated: usize,
    pub peak_usage: usize,
    pub secure_regions: usize,
    pub wiped_bytes: usize,
}

/// Runtime function representation
#[derive(Debug, Clone)]
pub struct RuntimeFunction {
    pub name: String,
    pub parameters: Vec<ParameterInfo>,
    pub return_type: Option<Type>,
    pub body: Option<Vec<crate::ast::Statement>>,
    pub security_annotations: Vec<crate::ast::SecurityAnnotation>,
}

#[derive(Debug, Clone)]
pub struct ParameterInfo {
    pub name: String,
    pub typ: Type,
    pub mutable: bool,
    pub reference: bool,
}

impl RuntimeFunction {
    pub fn from_ast(
        function: &crate::ast::Function,
        context: &ExecutionContext,
    ) -> RuntimeResult<Self> {
        let name = context.interner.get(function.name.name).unwrap_or("unknown").to_string();

        let parameters = function
            .parameters
            .iter()
            .map(|param| ParameterInfo {
                name: context.interner.get(param.name.name).unwrap_or("unknown").to_string(),
                typ: param.typ.clone(),
                mutable: param.mutable,
                reference: param.reference,
            })
            .collect();

        Ok(Self {
            name,
            parameters,
            return_type: function.return_type.clone(),
            body: function.body.clone(),
            security_annotations: function.security_annotations.clone(),
        })
    }
}