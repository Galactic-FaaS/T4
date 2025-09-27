//! T4 Built-in Functions and Standard Library
//!
//! This module implements built-in functions and the standard library for T4,
//! including cryptographic primitives, I/O operations, collections, and math functions.

use crate::ast::{Type, AlgorithmType};
use crate::runtime::{
    values::Value,
    memory::MemoryManager,
    crypto::CryptoRuntime,
    security::SecurityManager,
    errors::{RuntimeError, RuntimeResult},
};
use std::collections::HashMap;
use std::sync::Arc;

/// Built-in functions registry
pub struct BuiltinFunctions {
    /// Function registry
    functions: HashMap<String, BuiltinFunction>,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,

    /// Cryptographic runtime
    crypto_runtime: CryptoRuntime,

    /// Security manager
    security_manager: SecurityManager,
}

/// Built-in function definition
#[derive(Debug, Clone)]
pub struct BuiltinFunction {
    /// Function name
    pub name: String,

    /// Function implementation
    pub implementation: BuiltinImplementation,

    /// Parameter types
    pub param_types: Vec<Type>,

    /// Return type
    pub return_type: Option<Type>,

    /// Security annotations
    pub security_annotations: Vec<crate::ast::SecurityAnnotation>,
}

/// Built-in function implementation
#[derive(Debug, Clone)]
pub enum BuiltinImplementation {
    /// Cryptographic function
    Crypto(CryptoFunction),

    /// I/O function
    IO(IOFunction),

    /// Collection function
    Collection(CollectionFunction),

    /// Math function
    Math(MathFunction),

    /// String function
    String(StringFunction),

    /// Memory function
    Memory(MemoryFunction),

    /// System function
    System(SystemFunction),
}

/// Cryptographic built-in functions
#[derive(Debug, Clone)]
pub enum CryptoFunction {
    /// Generate key pair
    GenerateKeypair(AlgorithmType),

    /// Generate symmetric key
    GenerateKey(AlgorithmType),

    /// Encrypt data
    Encrypt,

    /// Decrypt data
    Decrypt,

    /// Sign data
    Sign,

    /// Verify signature
    Verify,

    /// Hash data
    Hash(AlgorithmType),

    /// Generate random bytes
    RandomBytes,

    /// Key exchange
    KeyExchange,
}

/// I/O built-in functions
#[derive(Debug, Clone)]
pub enum IOFunction {
    /// Print to stdout
    Print,

    /// Read from stdin
    ReadLine,

    /// Write to file
    WriteFile,

    /// Read from file
    ReadFile,

    /// Open file
    OpenFile,

    /// Close file
    CloseFile,
}

/// Collection built-in functions
#[derive(Debug, Clone)]
pub enum CollectionFunction {
    /// Create vector
    VecNew,

    /// Vector push
    VecPush,

    /// Vector pop
    VecPop,

    /// Vector length
    VecLen,

    /// Vector get
    VecGet,

    /// Vector set
    VecSet,

    /// Create map
    MapNew,

    /// Map insert
    MapInsert,

    /// Map get
    MapGet,

    /// Map remove
    MapRemove,

    /// Map contains key
    MapContains,

    /// Map length
    MapLen,
}

/// Math built-in functions
#[derive(Debug, Clone)]
pub enum MathFunction {
    /// Absolute value
    Abs,

    /// Square root
    Sqrt,

    /// Power
    Pow,

    /// Sine
    Sin,

    /// Cosine
    Cos,

    /// Tangent
    Tan,

    /// Natural logarithm
    Ln,

    /// Base-10 logarithm
    Log10,

    /// Minimum
    Min,

    /// Maximum
    Max,

    /// Clamp
    Clamp,
}

/// String built-in functions
#[derive(Debug, Clone)]
pub enum StringFunction {
    /// String length
    Len,

    /// String concatenation
    Concat,

    /// Substring
    Substring,

    /// String contains
    Contains,

    /// String starts with
    StartsWith,

    /// String ends with
    EndsWith,

    /// String to uppercase
    ToUpper,

    /// String to lowercase
    ToLower,

    /// String trim
    Trim,

    /// String split
    Split,
}

/// Memory built-in functions
#[derive(Debug, Clone)]
pub enum MemoryFunction {
    /// Allocate memory
    Alloc,

    /// Deallocate memory
    Dealloc,

    /// Copy memory
    Copy,

    /// Compare memory
    Compare,

    /// Zero memory
    Zero,

    /// Get memory usage
    Usage,
}

/// System built-in functions
#[derive(Debug, Clone)]
pub enum SystemFunction {
    /// Get current time
    Now,

    /// Get environment variable
    GetEnv,

    /// Set environment variable
    SetEnv,

    /// Exit program
    Exit,

    /// Get command line arguments
    Args,

    /// Sleep
    Sleep,
}

impl BuiltinFunctions {
    /// Create a new built-in functions registry
    pub fn new() -> RuntimeResult<Self> {
        let mut functions = HashMap::new();
        let memory_manager = Arc::new(MemoryManager::new(crate::runtime::MemorySafetyLevel::Standard)?);
        let crypto_runtime = CryptoRuntime::new(true, true)?;
        let security_manager = SecurityManager::new(crate::runtime::SecurityLevel::Standard)?;

        // Register cryptographic functions
        functions.insert("generate_keypair".to_string(), BuiltinFunction {
            name: "generate_keypair".to_string(),
            implementation: BuiltinImplementation::Crypto(CryptoFunction::GenerateKeypair(AlgorithmType::Ed25519)),
            param_types: vec![Type::Path {
                module: None,
                name: crate::ast::Identifier {
                    name: 0,
                    span: crate::ast::SourceSpan {
                        location: crate::ast::SourceLocation {
                            start_line: 0,
                            start_column: 0,
                            end_line: 0,
                            end_column: 0,
                            file: 0,
                        }
                    },
                },
                args: Vec::new(),
            }],
            return_type: Some(Type::Tuple(vec![
                Type::PublicKey(AlgorithmType::Ed25519),
                Type::PrivateKey(AlgorithmType::Ed25519),
            ])),
            security_annotations: vec![crate::ast::SecurityAnnotation::ConstantTime],
        });

        functions.insert("generate_key".to_string(), BuiltinFunction {
            name: "generate_key".to_string(),
            implementation: BuiltinImplementation::Crypto(CryptoFunction::GenerateKey(AlgorithmType::Aes256)),
            param_types: vec![Type::Path {
                module: None,
                name: crate::ast::Identifier {
                    name: 0,
                    span: crate::ast::SourceSpan {
                        location: crate::ast::SourceLocation {
                            start_line: 0,
                            start_column: 0,
                            end_line: 0,
                            end_column: 0,
                            file: 0,
                        }
                    },
                },
                args: Vec::new(),
            }],
            return_type: Some(Type::Key(AlgorithmType::Aes256)),
            security_annotations: vec![crate::ast::SecurityAnnotation::ConstantTime],
        });

        functions.insert("encrypt".to_string(), BuiltinFunction {
            name: "encrypt".to_string(),
            implementation: BuiltinImplementation::Crypto(CryptoFunction::Encrypt),
            param_types: vec![
                Type::Key(AlgorithmType::Aes256),
                Type::Bytes,
            ],
            return_type: Some(Type::Bytes),
            security_annotations: vec![
                crate::ast::SecurityAnnotation::ConstantTime,
                crate::ast::SecurityAnnotation::SecureMemory,
            ],
        });

        functions.insert("decrypt".to_string(), BuiltinFunction {
            name: "decrypt".to_string(),
            implementation: BuiltinImplementation::Crypto(CryptoFunction::Decrypt),
            param_types: vec![
                Type::Key(AlgorithmType::Aes256),
                Type::Bytes,
            ],
            return_type: Some(Type::Bytes),
            security_annotations: vec![
                crate::ast::SecurityAnnotation::ConstantTime,
                crate::ast::SecurityAnnotation::SecureMemory,
            ],
        });

        functions.insert("hash".to_string(), BuiltinFunction {
            name: "hash".to_string(),
            implementation: BuiltinImplementation::Crypto(CryptoFunction::Hash(AlgorithmType::Sha3_256)),
            param_types: vec![
                Type::Path {
                    module: None,
                    name: crate::ast::Identifier {
                        name: 0,
                        span: crate::ast::SourceSpan {
                            location: crate::ast::SourceLocation {
                                start_line: 0,
                                start_column: 0,
                                end_line: 0,
                                end_column: 0,
                                file: 0,
                            }
                        },
                    },
                    args: Vec::new(),
                },
                Type::Bytes,
            ],
            return_type: Some(Type::Hash(AlgorithmType::Sha3_256)),
            security_annotations: vec![crate::ast::SecurityAnnotation::ConstantTime],
        });

        // Register I/O functions
        functions.insert("print".to_string(), BuiltinFunction {
            name: "print".to_string(),
            implementation: BuiltinImplementation::IO(IOFunction::Print),
            param_types: vec![Type::String],
            return_type: Some(Type::Unit),
            security_annotations: vec![],
        });

        functions.insert("read_line".to_string(), BuiltinFunction {
            name: "read_line".to_string(),
            implementation: BuiltinImplementation::IO(IOFunction::ReadLine),
            param_types: vec![],
            return_type: Some(Type::String),
            security_annotations: vec![],
        });

        // Register collection functions
        functions.insert("vec_new".to_string(), BuiltinFunction {
            name: "vec_new".to_string(),
            implementation: BuiltinImplementation::Collection(CollectionFunction::VecNew),
            param_types: vec![],
            return_type: Some(Type::Array(Box::new(Type::Infer), 0)),
            security_annotations: vec![],
        });

        functions.insert("vec_push".to_string(), BuiltinFunction {
            name: "vec_push".to_string(),
            implementation: BuiltinImplementation::Collection(CollectionFunction::VecPush),
            param_types: vec![
                Type::Array(Box::new(Type::Infer), 0),
                Type::Infer,
            ],
            return_type: Some(Type::Unit),
            security_annotations: vec![],
        });

        functions.insert("vec_len".to_string(), BuiltinFunction {
            name: "vec_len".to_string(),
            implementation: BuiltinImplementation::Collection(CollectionFunction::VecLen),
            param_types: vec![Type::Array(Box::new(Type::Infer), 0)],
            return_type: Some(Type::Int64),
            security_annotations: vec![],
        });

        // Register math functions
        functions.insert("abs".to_string(), BuiltinFunction {
            name: "abs".to_string(),
            implementation: BuiltinImplementation::Math(MathFunction::Abs),
            param_types: vec![Type::Float64],
            return_type: Some(Type::Float64),
            security_annotations: vec![],
        });

        functions.insert("sqrt".to_string(), BuiltinFunction {
            name: "sqrt".to_string(),
            implementation: BuiltinImplementation::Math(MathFunction::Sqrt),
            param_types: vec![Type::Float64],
            return_type: Some(Type::Float64),
            security_annotations: vec![],
        });

        functions.insert("pow".to_string(), BuiltinFunction {
            name: "pow".to_string(),
            implementation: BuiltinImplementation::Math(MathFunction::Pow),
            param_types: vec![Type::Float64, Type::Float64],
            return_type: Some(Type::Float64),
            security_annotations: vec![],
        });

        // Register string functions
        functions.insert("len".to_string(), BuiltinFunction {
            name: "len".to_string(),
            implementation: BuiltinImplementation::String(StringFunction::Len),
            param_types: vec![Type::String],
            return_type: Some(Type::Int64),
            security_annotations: vec![],
        });

        functions.insert("concat".to_string(), BuiltinFunction {
            name: "concat".to_string(),
            implementation: BuiltinImplementation::String(StringFunction::Concat),
            param_types: vec![Type::String, Type::String],
            return_type: Some(Type::String),
            security_annotations: vec![],
        });

        Ok(Self {
            functions,
            memory_manager,
            crypto_runtime,
            security_manager,
        })
    }

    /// Call a built-in function
    pub async fn call_builtin(&mut self, function: &BuiltinFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        // Security check
        self.security_manager.check_call(&function.name, &arguments)?;

        let result = match &function.implementation {
            BuiltinImplementation::Crypto(crypto_func) => {
                self.call_crypto_function(crypto_func, arguments).await?
            }
            BuiltinImplementation::IO(io_func) => {
                self.call_io_function(io_func, arguments).await?
            }
            BuiltinImplementation::Collection(coll_func) => {
                self.call_collection_function(coll_func, arguments).await?
            }
            BuiltinImplementation::Math(math_func) => {
                self.call_math_function(math_func, arguments).await?
            }
            BuiltinImplementation::String(str_func) => {
                self.call_string_function(str_func, arguments).await?
            }
            BuiltinImplementation::Memory(mem_func) => {
                self.call_memory_function(mem_func, arguments).await?
            }
            BuiltinImplementation::System(sys_func) => {
                self.call_system_function(sys_func, arguments).await?
            }
        };

        Ok(result)
    }

    /// Call a cryptographic function
    async fn call_crypto_function(&mut self, function: &CryptoFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        match function {
            CryptoFunction::GenerateKeypair(algorithm) => {
                let (public_key, private_key) = self.crypto_runtime.generate_keypair(algorithm)?;
                Ok(Value::Tuple(vec![public_key, private_key]))
            }
            CryptoFunction::GenerateKey(algorithm) => {
                let key = self.crypto_runtime.generate_key(algorithm)?;
                Ok(key)
            }
            CryptoFunction::Encrypt => {
                if arguments.len() >= 2 {
                    let key = &arguments[0];
                    let plaintext = match &arguments[1] {
                        Value::Bytes(b) => b,
                        Value::String(s) => s.as_bytes(),
                        _ => return Err(RuntimeError::InvalidArgument),
                    };

                    let ciphertext = self.crypto_runtime.encrypt(key, plaintext)?;
                    Ok(Value::Bytes(ciphertext))
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            CryptoFunction::Decrypt => {
                if arguments.len() >= 2 {
                    let key = &arguments[0];
                    let ciphertext = match &arguments[1] {
                        Value::Bytes(b) => b,
                        _ => return Err(RuntimeError::InvalidArgument),
                    };

                    let plaintext = self.crypto_runtime.decrypt(key, ciphertext)?;
                    Ok(Value::Bytes(plaintext))
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            CryptoFunction::Hash(algorithm) => {
                if let Some(Value::Bytes(data)) = arguments.first() {
                    let hash = self.crypto_runtime.hash(algorithm, data)?;
                    Ok(Value::Hash(crate::runtime::values::CryptoHash {
                        algorithm: algorithm.clone(),
                        hash_value: hash,
                        metadata: crate::runtime::values::HashMetadata {
                            hash_id: uuid::Uuid::new_v4().to_string(),
                            computed_at: chrono::Utc::now(),
                            algorithm_version: "1.0".to_string(),
                        },
                    }))
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            CryptoFunction::RandomBytes => {
                if let Some(Value::Integer(size)) = arguments.first() {
                    if let Ok(size_usize) = (*size as usize).try_into() {
                        let random_bytes = self.crypto_runtime.get_default_provider()
                            .ok_or(RuntimeError::NoCryptoProvider)?
                            .random_bytes(size_usize)?;
                        Ok(Value::Bytes(random_bytes))
                    } else {
                        Err(RuntimeError::InvalidArgument)
                    }
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            _ => {
                // Other crypto functions not yet implemented
                Err(RuntimeError::NotImplemented)
            }
        }
    }

    /// Call an I/O function
    async fn call_io_function(&mut self, function: &IOFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        match function {
            IOFunction::Print => {
                if let Some(Value::String(s)) = arguments.first() {
                    println!("{}", s);
                    Ok(Value::Unit)
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            IOFunction::ReadLine => {
                use std::io::{self, BufRead};
                let stdin = io::stdin();
                let line = stdin.lines().next()
                    .ok_or(RuntimeError::IOError)??;
                Ok(Value::String(line))
            }
            _ => {
                // Other I/O functions not yet implemented
                Err(RuntimeError::NotImplemented)
            }
        }
    }

    /// Call a collection function
    async fn call_collection_function(&mut self, function: &CollectionFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        match function {
            CollectionFunction::VecNew => {
                Ok(Value::Array(crate::runtime::values::RuntimeArray {
                    element_type: Type::Infer,
                    elements: Vec::new(),
                    length: 0,
                }))
            }
            CollectionFunction::VecPush => {
                if arguments.len() >= 2 {
                    if let Value::Array(ref mut arr) = arguments[0] {
                        arr.elements.push(arguments[1].clone());
                        arr.length += 1;
                        Ok(Value::Unit)
                    } else {
                        Err(RuntimeError::InvalidArgument)
                    }
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            CollectionFunction::VecLen => {
                if let Some(Value::Array(arr)) = arguments.first() {
                    Ok(Value::Integer(arr.length as i64))
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            CollectionFunction::VecGet => {
                if arguments.len() >= 2 {
                    if let (Value::Array(arr), Value::Integer(index)) = (&arguments[0], &arguments[1]) {
                        if let Some(element) = arr.elements.get(*index as usize) {
                            Ok(element.clone())
                        } else {
                            Err(RuntimeError::IndexOutOfBounds)
                        }
                    } else {
                        Err(RuntimeError::InvalidArgument)
                    }
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            _ => {
                // Other collection functions not yet implemented
                Err(RuntimeError::NotImplemented)
            }
        }
    }

    /// Call a math function
    async fn call_math_function(&mut self, function: &MathFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        match function {
            MathFunction::Abs => {
                if let Some(Value::Float(x)) = arguments.first() {
                    Ok(Value::Float(x.abs()))
                } else if let Some(Value::Integer(x)) = arguments.first() {
                    Ok(Value::Integer(x.abs()))
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            MathFunction::Sqrt => {
                if let Some(Value::Float(x)) = arguments.first() {
                    Ok(Value::Float(x.sqrt()))
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            MathFunction::Pow => {
                if arguments.len() >= 2 {
                    if let (Value::Float(base), Value::Float(exp)) = (&arguments[0], &arguments[1]) {
                        Ok(Value::Float(base.powf(*exp)))
                    } else {
                        Err(RuntimeError::InvalidArgument)
                    }
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            MathFunction::Min => {
                if arguments.len() >= 2 {
                    if let (Value::Integer(a), Value::Integer(b)) = (&arguments[0], &arguments[1]) {
                        Ok(Value::Integer(*a.min(b)))
                    } else if let (Value::Float(a), Value::Float(b)) = (&arguments[0], &arguments[1]) {
                        Ok(Value::Float(a.min(*b)))
                    } else {
                        Err(RuntimeError::InvalidArgument)
                    }
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            MathFunction::Max => {
                if arguments.len() >= 2 {
                    if let (Value::Integer(a), Value::Integer(b)) = (&arguments[0], &arguments[1]) {
                        Ok(Value::Integer(*a.max(b)))
                    } else if let (Value::Float(a), Value::Float(b)) = (&arguments[0], &arguments[1]) {
                        Ok(Value::Float(a.max(*b)))
                    } else {
                        Err(RuntimeError::InvalidArgument)
                    }
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            _ => {
                // Other math functions not yet implemented
                Err(RuntimeError::NotImplemented)
            }
        }
    }

    /// Call a string function
    async fn call_string_function(&mut self, function: &StringFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        match function {
            StringFunction::Len => {
                if let Some(Value::String(s)) = arguments.first() {
                    Ok(Value::Integer(s.len() as i64))
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            StringFunction::Concat => {
                if arguments.len() >= 2 {
                    if let (Value::String(a), Value::String(b)) = (&arguments[0], &arguments[1]) {
                        let mut result = a.clone();
                        result.push_str(b);
                        Ok(Value::String(result))
                    } else {
                        Err(RuntimeError::InvalidArgument)
                    }
                } else {
                    Err(RuntimeError::InvalidArgumentCount)
                }
            }
            StringFunction::ToUpper => {
                if let Some(Value::String(s)) = arguments.first() {
                    Ok(Value::String(s.to_uppercase()))
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            StringFunction::ToLower => {
                if let Some(Value::String(s)) = arguments.first() {
                    Ok(Value::String(s.to_lowercase()))
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            _ => {
                // Other string functions not yet implemented
                Err(RuntimeError::NotImplemented)
            }
        }
    }

    /// Call a memory function
    async fn call_memory_function(&mut self, function: &MemoryFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        match function {
            MemoryFunction::Usage => {
                let stats = self.memory_manager.get_usage_stats();
                let usage_map = std::collections::HashMap::from([
                    ("total_allocated".to_string(), Value::Integer(stats.total_allocated as i64)),
                    ("peak_usage".to_string(), Value::Integer(stats.peak_usage as i64)),
                    ("secure_regions".to_string(), Value::Integer(stats.secure_regions as i64)),
                    ("wiped_bytes".to_string(), Value::Integer(stats.wiped_bytes as i64)),
                ]);
                Ok(Value::new_struct("MemoryUsage".to_string(), usage_map))
            }
            _ => {
                // Other memory functions not yet implemented
                Err(RuntimeError::NotImplemented)
            }
        }
    }

    /// Call a system function
    async fn call_system_function(&mut self, function: &SystemFunction, arguments: Vec<Value>) -> RuntimeResult<Value> {
        match function {
            SystemFunction::Now => {
                let now = chrono::Utc::now().timestamp();
                Ok(Value::Integer(now))
            }
            SystemFunction::GetEnv => {
                if let Some(Value::String(var_name)) = arguments.first() {
                    match std::env::var(var_name) {
                        Ok(value) => Ok(Value::String(value)),
                        Err(_) => Ok(Value::Unit), // Environment variable not found
                    }
                } else {
                    Err(RuntimeError::InvalidArgument)
                }
            }
            SystemFunction::Exit => {
                if let Some(Value::Integer(code)) = arguments.first() {
                    std::process::exit(*code as i32);
                } else {
                    std::process::exit(0);
                }
            }
            _ => {
                // Other system functions not yet implemented
                Err(RuntimeError::NotImplemented)
            }
        }
    }

    /// Get a built-in function by name
    pub fn get_function(&self, name: &str) -> Option<&BuiltinFunction> {
        self.functions.get(name)
    }

    /// List all available built-in functions
    pub fn list_functions(&self) -> Vec<&str> {
        self.functions.keys().map(|s| s.as_str()).collect()
    }

    /// Register a new built-in function
    pub fn register_function(&mut self, function: BuiltinFunction) {
        self.functions.insert(function.name.clone(), function);
    }
}

/// Standard library module
pub struct StandardLibrary {
    /// Built-in functions
    builtins: BuiltinFunctions,

    /// Standard modules
    modules: HashMap<String, StandardModule>,
}

/// Standard module
#[derive(Debug, Clone)]
pub struct StandardModule {
    pub name: String,
    pub functions: Vec<String>,
    pub types: Vec<String>,
    pub constants: HashMap<String, Value>,
}

/// Predefined constants
impl StandardLibrary {
    /// Create a new standard library
    pub fn new() -> RuntimeResult<Self> {
        let mut builtins = BuiltinFunctions::new()?;
        let mut modules = HashMap::new();

        // Create crypto module
        let crypto_module = StandardModule {
            name: "crypto".to_string(),
            functions: vec![
                "generate_keypair".to_string(),
                "generate_key".to_string(),
                "encrypt".to_string(),
                "decrypt".to_string(),
                "hash".to_string(),
                "random_bytes".to_string(),
            ],
            types: vec![
                "Key".to_string(),
                "Secret".to_string(),
                "PublicKey".to_string(),
                "PrivateKey".to_string(),
                "Signature".to_string(),
                "Ciphertext".to_string(),
                "Hash".to_string(),
            ],
            constants: HashMap::new(),
        };

        // Create io module
        let io_module = StandardModule {
            name: "io".to_string(),
            functions: vec![
                "print".to_string(),
                "read_line".to_string(),
                "read_file".to_string(),
                "write_file".to_string(),
            ],
            types: vec![
                "File".to_string(),
                "Reader".to_string(),
                "Writer".to_string(),
            ],
            constants: HashMap::new(),
        };

        // Create collections module
        let collections_module = StandardModule {
            name: "collections".to_string(),
            functions: vec![
                "vec_new".to_string(),
                "vec_push".to_string(),
                "vec_len".to_string(),
                "vec_get".to_string(),
                "map_new".to_string(),
                "map_insert".to_string(),
                "map_get".to_string(),
            ],
            types: vec![
                "Vec".to_string(),
                "Map".to_string(),
                "Set".to_string(),
            ],
            constants: HashMap::new(),
        };

        modules.insert("crypto".to_string(), crypto_module);
        modules.insert("io".to_string(), io_module);
        modules.insert("collections".to_string(), collections_module);

        Ok(Self {
            builtins,
            modules,
        })
    }

    /// Get built-in functions
    pub fn builtins(&self) -> &BuiltinFunctions {
        &self.builtins
    }

    /// Get built-in functions mutably
    pub fn builtins_mut(&mut self) -> &mut BuiltinFunctions {
        &mut self.builtins
    }

    /// Get a standard module
    pub fn get_module(&self, name: &str) -> Option<&StandardModule> {
        self.modules.get(name)
    }

    /// List all standard modules
    pub fn list_modules(&self) -> Vec<&str> {
        self.modules.keys().map(|s| s.as_str()).collect()
    }
}