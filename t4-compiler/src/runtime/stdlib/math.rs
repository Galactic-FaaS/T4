//! T4 Standard Library - Math Module
//!
//! This module provides comprehensive mathematical functions including
//! basic arithmetic, advanced math functions (trigonometry, logarithms),
//! random number generation (secure and non-secure), statistical functions,
//! and big integer support with cryptographic safety.

use crate::runtime::{
    values::Value,
    errors::{RuntimeError, RuntimeResult},
    memory::{MemoryManager, SecureMemoryGuard},
    security::SecurityManager,
    crypto::CryptoRuntime,
};
use std::collections::HashMap as StdHashMap;
use std::sync::Arc;
use num_bigint::{BigInt, BigUint};
use num_traits::{Zero, One, Signed, Pow};
use rand::{Rng, SeedableRng};
use rand::rngs::StdRng;
use rand::distributions::{Distribution, Uniform, Normal, Exponential};

/// Math module
pub struct MathModule {
    /// Module name
    name: String,

    /// Memory manager
    memory_manager: Arc<MemoryManager>,

    /// Security manager
    security_manager: Arc<SecurityManager>,

    /// Cryptographic runtime for secure random
    crypto_runtime: Option<CryptoRuntime>,

    /// Random number generators
    rng: StdRng,

    /// Secure RNG for cryptographic operations
    secure_rng: Option<StdRng>,

    /// Functions provided by this module
    functions: Vec<(&'static str, StandardFunction)>,

    /// Types provided by this module
    types: Vec<&'static str>,

    /// Constants provided by this module
    constants: StdHashMap<String, Value>,
}

/// Mathematical constants
#[derive(Debug, Clone)]
pub struct MathConstants;

impl MathConstants {
    pub const E: f64 = std::f64::consts::E;
    pub const PI: f64 = std::f64::consts::PI;
    pub const TAU: f64 = std::f64::consts::TAU;
    pub const SQRT_2: f64 = std::f64::consts::SQRT_2;
    pub const LN_2: f64 = std::f64::consts::LN_2;
    pub const LN_10: f64 = std::f64::consts::LN_10;
    pub const LOG2_E: f64 = std::f64::consts::LOG2_E;
    pub const LOG10_E: f64 = std::f64::consts::LOG10_E;
}

/// Big integer wrapper with security
#[derive(Debug, Clone)]
pub struct BigIntWrapper {
    /// Big integer value
    value: BigInt,

    /// Security level
    security_level: crate::runtime::values::SecurityLevel,

    /// Memory guard
    memory_guard: Option<SecureMemoryGuard>,
}

/// Random number generator with security
#[derive(Debug, Clone)]
pub struct RandomGenerator {
    /// RNG type
    rng_type: RandomType,

    /// Security level
    security_level: crate::runtime::values::SecurityLevel,

    /// Seed value
    seed: Option<u64>,
}

/// Random number generator type
#[derive(Debug, Clone)]
pub enum RandomType {
    PseudoRandom,
    CryptographicallySecure,
    Deterministic,
}

/// Statistical functions collection
#[derive(Debug, Clone)]
pub struct Statistics {
    /// Security level for operations
    security_level: crate::runtime::values::SecurityLevel,

    /// Precision for calculations
    precision: f64,
}

/// Probability distributions
#[derive(Debug, Clone)]
pub enum Distribution {
    Uniform { min: f64, max: f64 },
    Normal { mean: f64, std_dev: f64 },
    Exponential { rate: f64 },
    Poisson { lambda: f64 },
}

impl MathModule {
    /// Create a new math module
    pub fn new(
        memory_manager: Arc<MemoryManager>,
        security_manager: Arc<SecurityManager>,
    ) -> RuntimeResult<Self> {
        let mut functions = Vec::new();
        let mut types = Vec::new();
        let mut constants = StdHashMap::new();

        // Register math types
        types.extend(vec![
            "BigInt", "RandomGenerator", "Statistics"
        ]);

        // Register mathematical constants
        constants.insert("E".to_string(), Value::Float(MathConstants::E));
        constants.insert("PI".to_string(), Value::Float(MathConstants::PI));
        constants.insert("TAU".to_string(), Value::Float(MathConstants::TAU));
        constants.insert("SQRT_2".to_string(), Value::Float(MathConstants::SQRT_2));
        constants.insert("LN_2".to_string(), Value::Float(MathConstants::LN_2));
        constants.insert("LN_10".to_string(), Value::Float(MathConstants::LN_10));
        constants.insert("LOG2_E".to_string(), Value::Float(MathConstants::LOG2_E));
        constants.insert("LOG10_E".to_string(), Value::Float(MathConstants::LOG10_E));

        // Basic arithmetic functions
        functions.push(("abs", abs as StandardFunction));
        functions.push(("sign", sign as StandardFunction));
        functions.push(("min", min as StandardFunction));
        functions.push(("max", max as StandardFunction));
        functions.push(("clamp", clamp as StandardFunction));

        // Power and root functions
        functions.push(("pow", pow as StandardFunction));
        functions.push(("sqrt", sqrt as StandardFunction));
        functions.push(("cbrt", cbrt as StandardFunction));
        functions.push(("hypot", hypot as StandardFunction));

        // Trigonometric functions
        functions.push(("sin", sin as StandardFunction));
        functions.push(("cos", cos as StandardFunction));
        functions.push(("tan", tan as StandardFunction));
        functions.push(("asin", asin as StandardFunction));
        functions.push(("acos", acos as StandardFunction));
        functions.push(("atan", atan as StandardFunction));
        functions.push(("atan2", atan2 as StandardFunction));

        // Hyperbolic functions
        functions.push(("sinh", sinh as StandardFunction));
        functions.push(("cosh", cosh as StandardFunction));
        functions.push(("tanh", tanh as StandardFunction));

        // Logarithmic functions
        functions.push(("ln", ln as StandardFunction));
        functions.push(("log2", log2 as StandardFunction));
        functions.push(("log10", log10 as StandardFunction));
        functions.push(("log", log as StandardFunction));

        // Rounding functions
        functions.push(("floor", floor as StandardFunction));
        functions.push(("ceil", ceil as StandardFunction));
        functions.push(("round", round as StandardFunction));
        functions.push(("trunc", trunc as StandardFunction));

        // Special functions
        functions.push(("gamma", gamma as StandardFunction));
        functions.push(("lgamma", lgamma as StandardFunction));
        functions.push(("erf", erf as StandardFunction));
        functions.push(("erfc", erfc as StandardFunction));

        // Random number generation
        functions.push(("random_int", random_int as StandardFunction));
        functions.push(("random_float", random_float as StandardFunction));
        functions.push(("random_bytes", random_bytes as StandardFunction));
        functions.push(("random_choice", random_choice as StandardFunction));
        functions.push(("random_shuffle", random_shuffle as StandardFunction));

        // Big integer functions
        functions.push(("bigint_new", bigint_new as StandardFunction));
        functions.push(("bigint_from_string", bigint_from_string as StandardFunction));
        functions.push(("bigint_to_string", bigint_to_string as StandardFunction));
        functions.push(("bigint_add", bigint_add as StandardFunction));
        functions.push(("bigint_sub", bigint_sub as StandardFunction));
        functions.push(("bigint_mul", bigint_mul as StandardFunction));
        functions.push(("bigint_div", bigint_div as StandardFunction));
        functions.push(("bigint_mod", bigint_mod as StandardFunction));
        functions.push(("bigint_pow", bigint_pow as StandardFunction));
        functions.push(("bigint_gcd", bigint_gcd as StandardFunction));
        functions.push(("bigint_lcm", bigint_lcm as StandardFunction));
        functions.push(("bigint_compare", bigint_compare as StandardFunction));

        // Statistical functions
        functions.push(("mean", mean as StandardFunction));
        functions.push(("median", median as StandardFunction));
        functions.push(("mode", mode as StandardFunction));
        functions.push(("std_dev", std_dev as StandardFunction));
        functions.push(("variance", variance as StandardFunction));
        functions.push(("correlation", correlation as StandardFunction));
        functions.push(("linear_regression", linear_regression as StandardFunction));

        // Probability distributions
        functions.push(("pdf_uniform", pdf_uniform as StandardFunction));
        functions.push(("pdf_normal", pdf_normal as StandardFunction));
        functions.push(("pdf_exponential", pdf_exponential as StandardFunction));
        functions.push(("cdf_uniform", cdf_uniform as StandardFunction));
        functions.push(("cdf_normal", cdf_normal as StandardFunction));
        functions.push(("cdf_exponential", cdf_exponential as StandardFunction));

        // Initialize RNG with current time as seed
        let rng = StdRng::from_entropy();
        let secure_rng = Some(StdRng::from_entropy());

        Ok(Self {
            name: "math".to_string(),
            memory_manager,
            security_manager,
            crypto_runtime: None,
            rng,
            secure_rng,
            functions,
            types,
            constants,
        })
    }

    /// Set cryptographic runtime for secure random
    pub fn set_crypto_runtime(&mut self, crypto_runtime: CryptoRuntime) {
        self.crypto_runtime = Some(crypto_runtime);
    }

    /// Get cryptographically secure random bytes
    pub fn secure_random_bytes(&mut self, size: usize) -> RuntimeResult<Vec<u8>> {
        if let Some(ref mut crypto_runtime) = self.crypto_runtime {
            // Use crypto runtime for secure random
            let random_bytes = crypto_runtime.get_default_provider()
                .ok_or(RuntimeError::NoCryptoProvider)?
                .random_bytes(size)?;
            Ok(random_bytes)
        } else {
            // Fallback to standard RNG
            let mut bytes = vec![0u8; size];
            self.rng.fill_bytes(&mut bytes);
            Ok(bytes)
        }
    }
}

impl super::LibraryModule for MathModule {
    fn name(&self) -> &str {
        &self.name
    }

    fn initialize(&mut self) -> RuntimeResult<()> {
        // Initialize mathematical lookup tables and constants
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

// Basic arithmetic functions
fn abs(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Integer(i.abs())),
            Value::Float(f) => Ok(Value::Float(f.abs())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn sign(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Integer(i.signum())),
            Value::Float(f) => Ok(Value::Integer(if *f >= 0.0 { 1 } else { -1 })),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn min(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(a), Some(b)) = (args.get(0), args.get(1)) {
        match (a, b) {
            (Value::Integer(x), Value::Integer(y)) => Ok(Value::Integer(*x.min(y))),
            (Value::Float(x), Value::Float(y)) => Ok(Value::Float(x.min(*y))),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn max(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(a), Some(b)) = (args.get(0), args.get(1)) {
        match (a, b) {
            (Value::Integer(x), Value::Integer(y)) => Ok(Value::Integer(*x.max(y))),
            (Value::Float(x), Value::Float(y)) => Ok(Value::Float(x.max(*y))),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn clamp(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(value), Some(min_val), Some(max_val)) = (args.get(0), args.get(1), args.get(2)) {
        match (value, min_val, max_val) {
            (Value::Integer(v), Value::Integer(min), Value::Integer(max)) => {
                Ok(Value::Integer(v.max(*min).min(*max)))
            }
            (Value::Float(v), Value::Float(min), Value::Float(max)) => {
                Ok(Value::Float(v.max(*min).min(*max)))
            }
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

// Power and root functions
fn pow(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(base), Some(exp)) = (args.get(0), args.get(1)) {
        match (base, exp) {
            (Value::Integer(b), Value::Integer(e)) => {
                if let Ok(result) = BigInt::from(*b).pow(*e as u32).to_i64() {
                    Ok(Value::Integer(result))
                } else {
                    Err(RuntimeError::Overflow)
                }
            }
            (Value::Float(b), Value::Float(e)) => Ok(Value::Float(b.powf(*e))),
            (Value::Integer(b), Value::Float(e)) => Ok(Value::Float((*b as f64).powf(*e))),
            (Value::Float(b), Value::Integer(e)) => Ok(Value::Float(b.powi(*e as i32))),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn sqrt(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).sqrt())),
            Value::Float(f) => Ok(Value::Float(f.sqrt())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn cbrt(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).cbrt())),
            Value::Float(f) => Ok(Value::Float(f.cbrt())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn hypot(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(a), Some(b)) = (args.get(0), args.get(1)) {
        match (a, b) {
            (Value::Integer(x), Value::Integer(y)) => {
                let result = ((*x as f64).hypot(*y as f64));
                Ok(Value::Float(result))
            }
            (Value::Float(x), Value::Float(y)) => Ok(Value::Float(x.hypot(*y))),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

// Trigonometric functions
fn sin(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).sin())),
            Value::Float(f) => Ok(Value::Float(f.sin())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn cos(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).cos())),
            Value::Float(f) => Ok(Value::Float(f.cos())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn tan(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).tan())),
            Value::Float(f) => Ok(Value::Float(f.tan())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn asin(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).asin())),
            Value::Float(f) => Ok(Value::Float(f.asin())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn acos(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).acos())),
            Value::Float(f) => Ok(Value::Float(f.acos())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn atan(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).atan())),
            Value::Float(f) => Ok(Value::Float(f.atan())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn atan2(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(y), Some(x)) = (args.get(0), args.get(1)) {
        match (y, x) {
            (Value::Integer(y), Value::Integer(x)) => {
                Ok(Value::Float((*y as f64).atan2(*x as f64)))
            }
            (Value::Float(y), Value::Float(x)) => Ok(Value::Float(y.atan2(*x))),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

// Hyperbolic functions
fn sinh(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).sinh())),
            Value::Float(f) => Ok(Value::Float(f.sinh())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn cosh(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).cosh())),
            Value::Float(f) => Ok(Value::Float(f.cosh())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn tanh(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).tanh())),
            Value::Float(f) => Ok(Value::Float(f.tanh())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

// Logarithmic functions
fn ln(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).ln())),
            Value::Float(f) => Ok(Value::Float(f.ln())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn log2(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).log2())),
            Value::Float(f) => Ok(Value::Float(f.log2())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn log10(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).log10())),
            Value::Float(f) => Ok(Value::Float(f.log10())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn log(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(value), Some(base)) = (args.get(0), args.get(1)) {
        match (value, base) {
            (Value::Integer(v), Value::Integer(b)) => {
                Ok(Value::Float((*v as f64).log(*b as f64)))
            }
            (Value::Float(v), Value::Float(b)) => Ok(Value::Float(v.log(*b))),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

// Rounding functions
fn floor(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(_) => Ok(value.clone()),
            Value::Float(f) => Ok(Value::Float(f.floor())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn ceil(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(_) => Ok(value.clone()),
            Value::Float(f) => Ok(Value::Float(f.ceil())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn round(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(_) => Ok(value.clone()),
            Value::Float(f) => Ok(Value::Float(f.round())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn trunc(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(_) => Ok(value.clone()),
            Value::Float(f) => Ok(Value::Float(f.trunc())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

// Special functions
fn gamma(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).gamma())),
            Value::Float(f) => Ok(Value::Float(f.gamma())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn lgamma(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => {
                let result = (*i as f64).ln_gamma();
                Ok(Value::Float(result))
            }
            Value::Float(f) => {
                let result = f.ln_gamma();
                Ok(Value::Float(result))
            }
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn erf(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).erf())),
            Value::Float(f) => Ok(Value::Float(f.erf())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn erfc(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(value) = args.get(0) {
        match value {
            Value::Integer(i) => Ok(Value::Float((*i as f64).erfc())),
            Value::Float(f) => Ok(Value::Float(f.erfc())),
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

// Random number generation
fn random_int(args: &[Value]) -> RuntimeResult<Value> {
    if args.is_empty() {
        // Random integer from 0 to i64::MAX
        let mut rng = rand::thread_rng();
        Ok(Value::Integer(rng.gen()))
    } else if let (Some(Value::Integer(min)), Some(Value::Integer(max))) = (args.get(0), args.get(1)) {
        let range = Uniform::from(*min..=*max);
        let mut rng = rand::thread_rng();
        Ok(Value::Integer(range.sample(&mut rng)))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn random_float(args: &[Value]) -> RuntimeResult<Value> {
    if args.is_empty() {
        let mut rng = rand::thread_rng();
        Ok(Value::Float(rng.gen()))
    } else {
        Err(RuntimeError::InvalidArgumentCount)
    }
}

fn random_bytes(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Integer(size)) = args.get(0) {
        let size = *size as usize;
        let mut bytes = vec![0u8; size];
        let mut rng = rand::thread_rng();
        rng.fill_bytes(&mut bytes);
        Ok(Value::Bytes(bytes))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn random_choice(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Array(arr)) = args.get(0) {
        if arr.length > 0 {
            let index = rand::random::<usize>() % arr.length;
            Ok(arr.elements.get(index).cloned().unwrap_or(Value::Unit))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn random_shuffle(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Array(mut arr)) = args.get(0) {
        use rand::seq::SliceRandom;
        let mut rng = rand::thread_rng();
        arr.elements.shuffle(&mut rng);
        Ok(Value::Array(arr))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Big integer functions
fn bigint_new(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Integer(i)) = args.get(0) {
        let bigint = BigIntWrapper::from_i64(*i);
        Ok(Value::new_struct("BigInt".to_string(), {
            let mut fields = StdHashMap::new();
            fields.insert("value".to_string(), Value::String(bigint.to_string()));
            fields.insert("security_level".to_string(), Value::Integer(1));
            fields
        }))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_from_string(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(s)) = args.get(0) {
        match s.parse::<BigInt>() {
            Ok(bigint) => {
                let wrapper = BigIntWrapper::from_bigint(bigint);
                Ok(Value::new_struct("BigInt".to_string(), {
                    let mut fields = StdHashMap::new();
                    fields.insert("value".to_string(), Value::String(wrapper.to_string()));
                    fields.insert("security_level".to_string(), Value::Integer(1));
                    fields
                }))
            }
            Err(_) => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_to_string(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::String(s)) = args.get(0) {
        Ok(Value::String(s.clone()))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_add(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            let result = a_big + b_big;
            Ok(Value::String(result.to_string()))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_sub(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            let result = a_big - b_big;
            Ok(Value::String(result.to_string()))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_mul(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            let result = a_big * b_big;
            Ok(Value::String(result.to_string()))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_div(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            if !b_big.is_zero() {
                let result = a_big / b_big;
                Ok(Value::String(result.to_string()))
            } else {
                Err(RuntimeError::DivisionByZero)
            }
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_mod(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            if !b_big.is_zero() {
                let result = a_big % b_big;
                Ok(Value::String(result.to_string()))
            } else {
                Err(RuntimeError::DivisionByZero)
            }
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_pow(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(base)), Some(Value::Integer(exp))) = (args.get(0), args.get(1)) {
        if let Ok(base_big) = base.parse::<BigInt>() {
            let result = base_big.pow(*exp as u32);
            Ok(Value::String(result.to_string()))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_gcd(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            let result = a_big.gcd(&b_big);
            Ok(Value::String(result.to_string()))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_lcm(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            let gcd = a_big.gcd(&b_big);
            let result = (a_big * b_big) / gcd;
            Ok(Value::String(result.to_string()))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn bigint_compare(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::String(a)), Some(Value::String(b))) = (args.get(0), args.get(1)) {
        if let (Ok(a_big), Ok(b_big)) = (a.parse::<BigInt>(), b.parse::<BigInt>()) {
            Ok(Value::Integer(a_big.cmp(&b_big) as i64))
        } else {
            Err(RuntimeError::InvalidArgument)
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Statistical functions
fn mean(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Array(arr)) = args.get(0) {
        let values: Result<Vec<f64>, _> = arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        match values {
            Ok(vals) => {
                if vals.is_empty() {
                    Err(RuntimeError::InvalidArgument)
                } else {
                    let sum: f64 = vals.iter().sum();
                    Ok(Value::Float(sum / vals.len() as f64))
                }
            }
            Err(e) => Err(e),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn median(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Array(arr)) = args.get(0) {
        let mut values: Result<Vec<f64>, _> = arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        if let Ok(ref mut vals) = values {
            if vals.is_empty() {
                return Err(RuntimeError::InvalidArgument);
            }

            vals.sort_by(|a, b| a.partial_cmp(b).unwrap());
            let mid = vals.len() / 2;

            if vals.len() % 2 == 0 {
                Ok(Value::Float((vals[mid - 1] + vals[mid]) / 2.0))
            } else {
                Ok(Value::Float(vals[mid]))
            }
        } else {
            values.unwrap_err()
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn mode(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Array(arr)) = args.get(0) {
        let values: Result<Vec<f64>, _> = arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        match values {
            Ok(vals) => {
                if vals.is_empty() {
                    Err(RuntimeError::InvalidArgument)
                } else {
                    use std::collections::HashMap;
                    let mut counts = HashMap::new();

                    for val in vals {
                        *counts.entry(val).or_insert(0) += 1;
                    }

                    let mode = counts.iter().max_by_key(|(_, count)| *count).unwrap().0;
                    Ok(Value::Float(*mode))
                }
            }
            Err(e) => Err(e),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn std_dev(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Array(arr)) = args.get(0) {
        let values: Result<Vec<f64>, _> = arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        match values {
            Ok(vals) => {
                if vals.is_empty() {
                    Err(RuntimeError::InvalidArgument)
                } else {
                    let mean_val = vals.iter().sum::<f64>() / vals.len() as f64;
                    let variance = vals.iter()
                        .map(|x| (x - mean_val).powi(2))
                        .sum::<f64>() / vals.len() as f64;
                    Ok(Value::Float(variance.sqrt()))
                }
            }
            Err(e) => Err(e),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn variance(args: &[Value]) -> RuntimeResult<Value> {
    if let Some(Value::Array(arr)) = args.get(0) {
        let values: Result<Vec<f64>, _> = arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        match values {
            Ok(vals) => {
                if vals.is_empty() {
                    Err(RuntimeError::InvalidArgument)
                } else {
                    let mean_val = vals.iter().sum::<f64>() / vals.len() as f64;
                    let variance = vals.iter()
                        .map(|x| (x - mean_val).powi(2))
                        .sum::<f64>() / vals.len() as f64;
                    Ok(Value::Float(variance))
                }
            }
            Err(e) => Err(e),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn correlation(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Array(x_arr)), Some(Value::Array(y_arr))) = (args.get(0), args.get(1)) {
        if x_arr.length != y_arr.length || x_arr.length == 0 {
            return Err(RuntimeError::InvalidArgument);
        }

        let x_vals: Result<Vec<f64>, _> = x_arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        let y_vals: Result<Vec<f64>, _> = y_arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        match (x_vals, y_vals) {
            (Ok(x), Ok(y)) => {
                let n = x.len() as f64;
                let sum_x: f64 = x.iter().sum();
                let sum_y: f64 = y.iter().sum();
                let sum_xy: f64 = x.iter().zip(y.iter()).map(|(a, b)| a * b).sum();
                let sum_x2: f64 = x.iter().map(|a| a * a).sum();
                let sum_y2: f64 = y.iter().map(|b| b * b).sum();

                let numerator = n * sum_xy - sum_x * sum_y;
                let denominator = ((n * sum_x2 - sum_x * sum_x) * (n * sum_y2 - sum_y * sum_y)).sqrt();

                if denominator == 0.0 {
                    Ok(Value::Float(0.0))
                } else {
                    Ok(Value::Float(numerator / denominator))
                }
            }
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn linear_regression(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Array(x_arr)), Some(Value::Array(y_arr))) = (args.get(0), args.get(1)) {
        if x_arr.length != y_arr.length || x_arr.length < 2 {
            return Err(RuntimeError::InvalidArgument);
        }

        let x_vals: Result<Vec<f64>, _> = x_arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        let y_vals: Result<Vec<f64>, _> = y_arr.elements.iter().map(|v| match v {
            Value::Integer(i) => Ok(*i as f64),
            Value::Float(f) => Ok(*f),
            _ => Err(RuntimeError::InvalidArgument),
        }).collect();

        match (x_vals, y_vals) {
            (Ok(x), Ok(y)) => {
                let n = x.len() as f64;
                let sum_x: f64 = x.iter().sum();
                let sum_y: f64 = y.iter().sum();
                let sum_xy: f64 = x.iter().zip(y.iter()).map(|(a, b)| a * b).sum();
                let sum_x2: f64 = x.iter().map(|a| a * a).sum();

                let slope = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x);
                let intercept = (sum_y - slope * sum_x) / n;

                Ok(Value::new_struct("LinearRegression".to_string(), {
                    let mut fields = StdHashMap::new();
                    fields.insert("slope".to_string(), Value::Float(slope));
                    fields.insert("intercept".to_string(), Value::Float(intercept));
                    fields
                }))
            }
            _ => Err(RuntimeError::InvalidArgument),
        }
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// Probability distribution functions
fn pdf_uniform(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Float(x)), Some(Value::Float(min)), Some(Value::Float(max))) = (args.get(0), args.get(1), args.get(2)) {
        if *min >= *max {
            return Err(RuntimeError::InvalidArgument);
        }

        let pdf = if *x >= *min && *x <= *max {
            1.0 / (*max - *min)
        } else {
            0.0
        };

        Ok(Value::Float(pdf))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn pdf_normal(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Float(x)), Some(Value::Float(mean)), Some(Value::Float(std_dev))) = (args.get(0), args.get(1), args.get(2)) {
        if *std_dev <= 0.0 {
            return Err(RuntimeError::InvalidArgument);
        }

        let variance = std_dev * std_dev;
        let pdf = (1.0 / (std_dev * (2.0 * std::f64::consts::PI).sqrt())) *
                  (-0.5 * ((x - mean) / std_dev).powi(2)).exp();

        Ok(Value::Float(pdf))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn pdf_exponential(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Float(x)), Some(Value::Float(rate))) = (args.get(0), args.get(1)) {
        if *rate <= 0.0 || *x < 0.0 {
            return Err(RuntimeError::InvalidArgument);
        }

        let pdf = rate * (-rate * x).exp();
        Ok(Value::Float(pdf))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn cdf_uniform(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Float(x)), Some(Value::Float(min)), Some(Value::Float(max))) = (args.get(0), args.get(1), args.get(2)) {
        if *min >= *max {
            return Err(RuntimeError::InvalidArgument);
        }

        let cdf = if *x < *min {
            0.0
        } else if *x > *max {
            1.0
        } else {
            (*x - *min) / (*max - *min)
        };

        Ok(Value::Float(cdf))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn cdf_normal(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Float(x)), Some(Value::Float(mean)), Some(Value::Float(std_dev))) = (args.get(0), args.get(1), args.get(2)) {
        if *std_dev <= 0.0 {
            return Err(RuntimeError::InvalidArgument);
        }

        let z = (x - mean) / std_dev;
        let cdf = 0.5 * (1.0 + erf(z / 2.0_f64.sqrt()));
        Ok(Value::Float(cdf))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

fn cdf_exponential(args: &[Value]) -> RuntimeResult<Value> {
    if let (Some(Value::Float(x)), Some(Value::Float(rate))) = (args.get(0), args.get(1)) {
        if *rate <= 0.0 || *x < 0.0 {
            return Err(RuntimeError::InvalidArgument);
        }

        let cdf = 1.0 - (-rate * x).exp();
        Ok(Value::Float(cdf))
    } else {
        Err(RuntimeError::InvalidArgument)
    }
}

// BigIntWrapper implementation
impl BigIntWrapper {
    pub fn from_i64(value: i64) -> Self {
        Self {
            value: BigInt::from(value),
            security_level: crate::runtime::values::SecurityLevel::Medium,
            memory_guard: None,
        }
    }

    pub fn from_bigint(value: BigInt) -> Self {
        Self {
            value,
            security_level: crate::runtime::values::SecurityLevel::Medium,
            memory_guard: None,
        }
    }

    pub fn to_string(&self) -> String {
        self.value.to_string()
    }

    pub fn add(&self, other: &BigIntWrapper) -> BigIntWrapper {
        Self::from_bigint(&self.value + &other.value)
    }

    pub fn sub(&self, other: &BigIntWrapper) -> BigIntWrapper {
        Self::from_bigint(&self.value - &other.value)
    }

    pub fn mul(&self, other: &BigIntWrapper) -> BigIntWrapper {
        Self::from_bigint(&self.value * &other.value)
    }

    pub fn div(&self, other: &BigIntWrapper) -> RuntimeResult<BigIntWrapper> {
        if other.value.is_zero() {
            Err(RuntimeError::DivisionByZero)
        } else {
            Ok(Self::from_bigint(&self.value / &other.value))
        }
    }

    pub fn compare(&self, other: &BigIntWrapper) -> i32 {
        self.value.cmp(&other.value) as i32
    }
}

// Statistics implementation
impl Statistics {
    pub fn new(security_level: crate::runtime::values::SecurityLevel) -> Self {
        Self {
            security_level,
            precision: 1e-10,
        }
    }

    pub fn mean(&self, values: &[f64]) -> f64 {
        if values.is_empty() {
            0.0
        } else {
            values.iter().sum::<f64>() / values.len() as f64
        }
    }

    pub fn variance(&self, values: &[f64]) -> f64 {
        if values.len() <= 1 {
            return 0.0;
        }

        let mean_val = self.mean(values);
        let sum_squared_diff: f64 = values.iter()
            .map(|x| (x - mean_val).powi(2))
            .sum();
        sum_squared_diff / (values.len() - 1) as f64
    }

    pub fn std_dev(&self, values: &[f64]) -> f64 {
        self.variance(values).sqrt()
    }
}