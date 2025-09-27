//! Cryptographic debugging for T4 Debugger

use std::collections::HashMap;

pub struct CryptoDebugger {
    operations: Vec<CryptoOperation>,
    key_operations: HashMap<String, KeyOperation>,
    algorithm_usage: HashMap<String, usize>,
}

#[derive(Debug, Clone)]
pub struct CryptoOperation {
    pub id: usize,
    pub algorithm: String,
    pub operation_type: CryptoOperationType,
    pub timestamp: std::time::SystemTime,
    pub duration: std::time::Duration,
    pub success: bool,
    pub error_message: Option<String>,
}

#[derive(Debug, Clone)]
pub enum CryptoOperationType {
    Encrypt,
    Decrypt,
    Sign,
    Verify,
    Hash,
    KeyGen,
    KemEncapsulate,
    KemDecapsulate,
}

#[derive(Debug, Clone)]
pub struct KeyOperation {
    pub key_id: String,
    pub algorithm: String,
    pub operation: String,
    pub timestamp: std::time::SystemTime,
}

impl CryptoDebugger {
    pub fn new() -> Self {
        Self {
            operations: Vec::new(),
            key_operations: HashMap::new(),
            algorithm_usage: HashMap::new(),
        }
    }

    pub fn record_operation(&mut self, operation: CryptoOperation) {
        // Update algorithm usage statistics
        *self.algorithm_usage.entry(operation.algorithm.clone()).or_insert(0) += 1;

        self.operations.push(operation);
    }

    pub fn get_operations(&self) -> &[CryptoOperation] {
        &self.operations
    }

    pub fn get_algorithm_usage(&self) -> &HashMap<String, usize> {
        &self.algorithm_usage
    }

    pub fn get_timing_analysis(&self) -> CryptoTimingAnalysis {
        // TODO: Implement timing analysis
        CryptoTimingAnalysis {
            average_encryption_time: std::time::Duration::from_millis(1),
            average_decryption_time: std::time::Duration::from_millis(1),
            timing_variations: Vec::new(),
        }
    }
}

#[derive(Debug)]
pub struct CryptoTimingAnalysis {
    pub average_encryption_time: std::time::Duration,
    pub average_decryption_time: std::time::Duration,
    pub timing_variations: Vec<std::time::Duration>,
}