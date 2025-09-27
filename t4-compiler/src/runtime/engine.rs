//! T4 Runtime Execution Engine
//!
//! This module implements the core execution engine for T4 programs,
//! including call stack management, frame handling, and program execution.

use crate::ast::{Program, Statement, Expression, Declaration, Identifier};
use crate::runtime::{
    values::Value,
    memory::MemoryManager,
    crypto::CryptoRuntime,
    builtins::BuiltinFunctions,
    security::SecurityManager,
    errors::{RuntimeError, RuntimeResult},
};
use std::collections::HashMap;
use string_interner::StringInterner;

/// Main runtime execution engine
pub struct Runtime {
    /// String interner for efficient string handling
    interner: StringInterner,

    /// Call stack for function calls
    call_stack: Vec<CallFrame>,

    /// Global variables and functions
    globals: HashMap<String, Value>,

    /// Memory manager
    memory_manager: MemoryManager,

    /// Cryptographic runtime
    crypto_runtime: CryptoRuntime,

    /// Built-in functions
    builtins: BuiltinFunctions,

    /// Security manager
    security_manager: SecurityManager,

    /// Execution statistics
    stats: ExecutionStats,
}

/// Execution context for a single program execution
pub struct ExecutionContext {
    /// Reference to the runtime
    pub runtime: Runtime,

    /// String interner
    pub interner: StringInterner,

    /// Local variables in current scope
    pub locals: HashMap<String, Value>,

    /// Current program being executed
    pub program: Program,

    /// Current execution state
    pub state: ExecutionState,
}

/// Execution state
#[derive(Debug, Clone, PartialEq)]
pub enum ExecutionState {
    /// Normal execution
    Running,
    /// Break statement encountered
    Breaking,
    /// Continue statement encountered
    Continuing,
    /// Return statement encountered
    Returning(Value),
    /// Error occurred
    Error(RuntimeError),
    /// Execution completed
    Completed,
}

/// Call frame for function execution
#[derive(Debug, Clone)]
pub struct CallFrame {
    /// Function name
    pub function_name: String,

    /// Program counter (statement index)
    pub pc: usize,

    /// Local variables
    pub locals: HashMap<String, Value>,

    /// Return address (caller frame index)
    pub return_address: usize,

    /// Function parameters
    pub parameters: Vec<String>,

    /// Security context
    pub security_context: SecurityContext,
}

/// Security context for execution
#[derive(Debug, Clone)]
pub struct SecurityContext {
    /// Constant-time execution required
    pub constant_time: bool,

    /// Memory wiping required
    pub secure_memory: bool,

    /// Side-channel protection level
    pub protection_level: ProtectionLevel,

    /// Cryptographic operation context
    pub crypto_context: Option<CryptoContext>,
}

/// Protection level for side-channel resistance
#[derive(Debug, Clone, PartialEq)]
pub enum ProtectionLevel {
    /// No special protection
    None,
    /// Basic timing attack protection
    Basic,
    /// Full side-channel resistance
    Full,
}

/// Cryptographic operation context
#[derive(Debug, Clone)]
pub struct CryptoContext {
    /// Algorithm being used
    pub algorithm: String,

    /// Operation type
    pub operation: CryptoOperation,

    /// Security requirements
    pub requirements: SecurityRequirements,
}

/// Cryptographic operation type
#[derive(Debug, Clone, PartialEq)]
pub enum CryptoOperation {
    /// Key generation
    KeyGen,
    /// Encryption
    Encrypt,
    /// Decryption
    Decrypt,
    /// Digital signature
    Sign,
    /// Signature verification
    Verify,
    /// Key exchange
    KeyExchange,
    /// Hash computation
    Hash,
    /// Zero-knowledge proof
    ZeroKnowledgeProof,
}

/// Security requirements for cryptographic operations
#[derive(Debug, Clone)]
pub struct SecurityRequirements {
    /// Constant-time execution required
    pub constant_time: bool,

    /// Secure memory required
    pub secure_memory: bool,

    /// Hardware acceleration preferred
    pub hardware_acceleration: bool,

    /// Post-quantum security required
    pub post_quantum: bool,
}

/// Execution statistics
#[derive(Debug, Clone, Default)]
pub struct ExecutionStats {
    /// Number of instructions executed
    pub instructions_executed: u64,

    /// Number of function calls
    pub function_calls: u64,

    /// Number of cryptographic operations
    pub crypto_operations: u64,

    /// Memory allocations
    pub memory_allocations: u64,

    /// Security violations detected
    pub security_violations: u64,

    /// Execution time
    pub execution_time_ns: u64,
}

impl Runtime {
    /// Create a new runtime engine
    pub fn new() -> RuntimeResult<Self> {
        Ok(Self {
            interner: StringInterner::default(),
            call_stack: Vec::new(),
            globals: HashMap::new(),
            memory_manager: MemoryManager::new(crate::runtime::RuntimeConfig::default().memory_safety)?,
            crypto_runtime: CryptoRuntime::new(true, true)?,
            builtins: BuiltinFunctions::new()?,
            security_manager: SecurityManager::new(crate::runtime::RuntimeConfig::default().security_level)?,
            stats: ExecutionStats::default(),
        })
    }

    /// Execute a program
    pub async fn execute(&mut self, program: Program) -> RuntimeResult<Value> {
        let mut context = ExecutionContext::new(self, program)?;

        // Execute the program
        let result = self.execute_program(&mut context).await?;

        // Update statistics
        self.stats.instructions_executed += 1;

        Ok(result)
    }

    /// Execute a complete program
    async fn execute_program(&mut self, context: &mut ExecutionContext) -> RuntimeResult<Value> {
        // Initialize global environment
        self.initialize_globals(context).await?;

        // Execute main function if it exists
        if let Some(main_value) = self.globals.get("main") {
            match main_value {
                Value::Function(func) => {
                    let result = self.call_function(context, func, Vec::new()).await?;
                    context.state = ExecutionState::Completed;
                    Ok(result)
                }
                _ => {
                    // Main is not a function, return it directly
                    context.state = ExecutionState::Completed;
                    Ok(main_value.clone())
                }
            }
        } else {
            // No main function, return unit
            context.state = ExecutionState::Completed;
            Ok(Value::Unit)
        }
    }

    /// Initialize global variables and functions
    async fn initialize_globals(&mut self, context: &mut ExecutionContext) -> RuntimeResult<()> {
        for declaration in &context.program.declarations {
            match declaration {
                Declaration::Function(func) => {
                    let func_name = context.interner.get(func.name.name)
                        .unwrap_or("unknown").to_string();
                    let runtime_func = RuntimeFunction::from_ast(func, context)?;
                    self.globals.insert(func_name, Value::Function(Box::new(runtime_func)));
                }
                Declaration::Static(static_var) => {
                    let var_name = context.interner.get(static_var.name.name)
                        .unwrap_or("unknown").to_string();

                    if let Some(ref value_expr) = static_var.value {
                        let value = self.evaluate_expression(context, value_expr).await?;
                        self.globals.insert(var_name, value);
                    } else {
                        self.globals.insert(var_name, Value::Unit);
                    }
                }
                _ => {
                    // Other declarations handled at compile time
                }
            }
        }
        Ok(())
    }

    /// Call a function with arguments
    async fn call_function(
        &mut self,
        context: &mut ExecutionContext,
        function: &RuntimeFunction,
        arguments: Vec<Value>,
    ) -> RuntimeResult<Value> {
        // Create new call frame
        let frame_index = self.call_stack.len();
        let mut frame = CallFrame::new(
            function.name.clone(),
            frame_index,
            function.security_annotations.clone(),
        );

        // Set up parameters
        for (i, param) in function.parameters.iter().enumerate() {
            if let Some(arg_value) = arguments.get(i) {
                frame.locals.insert(param.name.clone(), arg_value.clone());
            }
        }

        // Push frame onto call stack
        self.call_stack.push(frame);

        // Execute function body
        let result = if let Some(ref body) = function.body {
            self.execute_block(context, body).await?
        } else {
            Value::Unit
        };

        // Pop frame from call stack
        self.call_stack.pop();

        // Update statistics
        self.stats.function_calls += 1;

        Ok(result)
    }

    /// Execute a block of statements
    async fn execute_block(&mut self, context: &mut ExecutionContext, statements: &[Statement]) -> RuntimeResult<Value> {
        let mut last_result = Value::Unit;

        for statement in statements {
            last_result = self.execute_statement(context, statement).await?;

            // Handle control flow
            match context.state {
                ExecutionState::Breaking | ExecutionState::Continuing => {
                    // These are handled by loop constructs
                    break;
                }
                ExecutionState::Returning(ref value) => {
                    // Return statement encountered
                    return Ok(value.clone());
                }
                ExecutionState::Error(ref err) => {
                    return Err(err.clone());
                }
                ExecutionState::Completed => {
                    break;
                }
                ExecutionState::Running => {
                    // Continue execution
                }
            }
        }

        Ok(last_result)
    }

    /// Execute a single statement
    async fn execute_statement(&mut self, context: &mut ExecutionContext, statement: &Statement) -> RuntimeResult<Value> {
        match statement {
            Statement::Let { pattern, typ: _, value } => {
                let value = if let Some(ref expr) = value {
                    self.evaluate_expression(context, expr).await?
                } else {
                    Value::Unit
                };

                // TODO: Handle pattern matching
                // For now, just store the value
                Value::Unit
            }
            Statement::Expression(expr) => {
                self.evaluate_expression(context, expr).await
            }
            Statement::Return(expr) => {
                let value = if let Some(ref e) = expr {
                    self.evaluate_expression(context, e).await?
                } else {
                    Value::Unit
                };

                context.state = ExecutionState::Returning(value.clone());
                Ok(value)
            }
            Statement::If { condition, then_block, else_ifs, else_block } => {
                let cond_value = self.evaluate_expression(context, condition).await?;

                let result = if self.is_truthy(&cond_value) {
                    self.execute_block(context, then_block).await?
                } else {
                    // Check else-if conditions
                    let mut executed = false;
                    for (else_if_cond, else_if_block) in else_ifs {
                        let else_if_value = self.evaluate_expression(context, else_if_cond).await?;
                        if self.is_truthy(&else_if_value) {
                            let result = self.execute_block(context, else_if_block).await?;
                            executed = true;
                            break;
                        }
                    }

                    if !executed {
                        if let Some(ref else_b) = else_block {
                            self.execute_block(context, else_b).await?
                        } else {
                            Value::Unit
                        }
                    } else {
                        Value::Unit
                    }
                };

                Ok(result)
            }
            Statement::While { condition, body } => {
                let mut last_result = Value::Unit;

                while self.is_truthy(&self.evaluate_expression(context, condition).await?) {
                    match context.state {
                        ExecutionState::Breaking => {
                            context.state = ExecutionState::Running;
                            break;
                        }
                        ExecutionState::Continuing => {
                            context.state = ExecutionState::Running;
                            continue;
                        }
                        ExecutionState::Returning(_) | ExecutionState::Error(_) => {
                            break;
                        }
                        _ => {}
                    }

                    last_result = self.execute_block(context, body).await?;
                }

                Ok(last_result)
            }
            Statement::Break(_) => {
                context.state = ExecutionState::Breaking;
                Ok(Value::Unit)
            }
            Statement::Continue => {
                context.state = ExecutionState::Continuing;
                Ok(Value::Unit)
            }
            _ => {
                // Other statements not yet implemented
                Ok(Value::Unit)
            }
        }
    }

    /// Evaluate an expression
    async fn evaluate_expression(&mut self, context: &mut ExecutionContext, expression: &Expression) -> RuntimeResult<Value> {
        match expression {
            Expression::Literal(lit) => {
                Ok(Value::from_literal(lit))
            }
            Expression::Variable(ident) => {
                let name = context.interner.get(ident.name).unwrap_or("unknown");

                // Look up in locals first, then globals
                if let Some(value) = context.locals.get(name) {
                    Ok(value.clone())
                } else if let Some(value) = self.globals.get(name) {
                    Ok(value.clone())
                } else {
                    Err(RuntimeError::UndefinedVariable(name.to_string()))
                }
            }
            Expression::Binary { left, op, right } => {
                let left_val = self.evaluate_expression(context, left).await?;
                let right_val = self.evaluate_expression(context, right).await?;

                self.evaluate_binary_operation(&left_val, *op, &right_val)
            }
            Expression::Call { function, args } => {
                let func_val = self.evaluate_expression(context, function).await?;
                let mut arg_vals = Vec::new();

                for arg in args {
                    arg_vals.push(self.evaluate_expression(context, arg).await?);
                }

                self.evaluate_function_call(context, &func_val, arg_vals).await
            }
            _ => {
                // Other expressions not yet implemented
                Ok(Value::Unit)
            }
        }
    }

    /// Evaluate a binary operation
    fn evaluate_binary_operation(&self, left: &Value, op: crate::ast::BinaryOp, right: &Value) -> RuntimeResult<Value> {
        match (left, op, right) {
            (Value::Integer(l), crate::ast::BinaryOp::Add, Value::Integer(r)) => {
                Ok(Value::Integer(l + r))
            }
            (Value::Integer(l), crate::ast::BinaryOp::Sub, Value::Integer(r)) => {
                Ok(Value::Integer(l - r))
            }
            (Value::Integer(l), crate::ast::BinaryOp::Mul, Value::Integer(r)) => {
                Ok(Value::Integer(l * r))
            }
            (Value::Integer(l), crate::ast::BinaryOp::Div, Value::Integer(r)) => {
                if *r == 0 {
                    Err(RuntimeError::DivisionByZero)
                } else {
                    Ok(Value::Integer(l / r))
                }
            }
            (Value::Integer(l), crate::ast::BinaryOp::Eq, Value::Integer(r)) => {
                Ok(Value::Bool(l == r))
            }
            (Value::Integer(l), crate::ast::BinaryOp::Lt, Value::Integer(r)) => {
                Ok(Value::Bool(l < r))
            }
            _ => {
                Err(RuntimeError::InvalidBinaryOperation)
            }
        }
    }

    /// Evaluate a function call
    async fn evaluate_function_call(
        &mut self,
        context: &mut ExecutionContext,
        function: &Value,
        arguments: Vec<Value>,
    ) -> RuntimeResult<Value> {
        match function {
            Value::Function(func) => {
                self.call_function(context, func, arguments).await
            }
            Value::BuiltinFunction(builtin) => {
                self.builtins.call_builtin(builtin, arguments).await
            }
            _ => {
                Err(RuntimeError::NotCallable)
            }
        }
    }

    /// Check if a value is truthy
    fn is_truthy(&self, value: &Value) -> bool {
        match value {
            Value::Bool(b) => *b,
            Value::Integer(i) => *i != 0,
            Value::Unit => false,
            _ => true,
        }
    }

    /// Get execution statistics
    pub fn get_stats(&self) -> &ExecutionStats {
        &self.stats
    }
}

impl ExecutionContext {
    /// Create a new execution context
    pub fn new(runtime: &mut Runtime, program: Program) -> RuntimeResult<Self> {
        Ok(Self {
            runtime: Runtime {
                interner: runtime.interner.clone(),
                call_stack: runtime.call_stack.clone(),
                globals: runtime.globals.clone(),
                memory_manager: runtime.memory_manager.clone(),
                crypto_runtime: runtime.crypto_runtime.clone(),
                builtins: runtime.builtins.clone(),
                security_manager: runtime.security_manager.clone(),
                stats: runtime.stats.clone(),
            },
            interner: StringInterner::default(),
            locals: HashMap::new(),
            program,
            state: ExecutionState::Running,
        })
    }
}

impl CallFrame {
    /// Create a new call frame
    pub fn new(
        function_name: String,
        return_address: usize,
        security_annotations: Vec<crate::ast::SecurityAnnotation>,
    ) -> Self {
        Self {
            function_name,
            pc: 0,
            locals: HashMap::new(),
            return_address,
            parameters: Vec::new(),
            security_context: SecurityContext::from_annotations(security_annotations),
        }
    }
}

impl SecurityContext {
    /// Create security context from annotations
    pub fn from_annotations(annotations: Vec<crate::ast::SecurityAnnotation>) -> Self {
        let mut constant_time = false;
        let mut secure_memory = false;
        let mut protection_level = ProtectionLevel::None;

        for annotation in annotations {
            match annotation {
                crate::ast::SecurityAnnotation::ConstantTime => {
                    constant_time = true;
                    protection_level = ProtectionLevel::Full;
                }
                crate::ast::SecurityAnnotation::SecureMemory => {
                    secure_memory = true;
                }
                crate::ast::SecurityAnnotation::CacheResistant => {
                    protection_level = ProtectionLevel::Basic;
                }
                crate::ast::SecurityAnnotation::PowerResistant => {
                    protection_level = ProtectionLevel::Full;
                }
                _ => {}
            }
        }

        Self {
            constant_time,
            secure_memory,
            protection_level,
            crypto_context: None,
        }
    }
}

/// Runtime function representation
#[derive(Debug, Clone)]
pub struct RuntimeFunction {
    pub name: String,
    pub parameters: Vec<ParameterInfo>,
    pub return_type: Option<crate::ast::Type>,
    pub body: Option<Vec<Statement>>,
    pub security_annotations: Vec<crate::ast::SecurityAnnotation>,
}

#[derive(Debug, Clone)]
pub struct ParameterInfo {
    pub name: String,
    pub typ: crate::ast::Type,
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