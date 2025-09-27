//! Security type system for the T4 programming language
//!
//! This module implements security-focused type checking including:
//! - Affine usage analysis for secret types
//! - Constant-time operation verification
//! - Memory safety analysis for cryptographic data
//! - Side-channel resistance validation

use crate::ast::*;
use super::{TypeScheme, TypeVar, TypeError, TypeResult, Sym};
use std::collections::{HashMap, HashSet};
use std::fmt;

/// Security analysis result
#[derive(Debug, Clone)]
pub struct SecurityAnalysis {
    violations: Vec<SecurityViolation>,
    usage_tracking: AffineUsage,
    constant_time_info: ConstantTimeInfo,
}

impl SecurityAnalysis {
    pub fn new() -> Self {
        Self {
            violations: Vec::new(),
            usage_tracking: AffineUsage::new(),
            constant_time_info: ConstantTimeInfo::new(),
        }
    }

    /// Analyze security properties of a program
    pub fn analyze_program(&mut self, program: &Program) -> Result<SecurityReport, TypeError> {
        for decl in &program.declarations {
            self.analyze_declaration(decl)?;
        }

        Ok(SecurityReport {
            violations: self.violations.clone(),
            usage_tracking: self.usage_tracking.clone(),
            constant_time_info: self.constant_time_info.clone(),
        })
    }

    /// Analyze security properties of a declaration
    fn analyze_declaration(&mut self, decl: &Declaration) -> Result<(), TypeError> {
        match decl {
            Declaration::Function(func) => {
                self.analyze_function(func)
            }
            _ => Ok(())
        }
    }

    /// Analyze security properties of a function
    fn analyze_function(&mut self, func: &Function) -> Result<(), TypeError> {
        // Check security annotations
        for annotation in &func.security_annotations {
            match annotation {
                SecurityAnnotation::ConstantTime => {
                    self.constant_time_info.mark_function_constant_time(&func.name);
                }
                SecurityAnnotation::SecureMemory => {
                    // Mark function as using secure memory
                }
                _ => {}
            }
        }

        // Analyze function body for security violations
        for stmt in &func.body {
            self.analyze_statement(stmt)?;
        }

        Ok(())
    }

    /// Analyze security properties of a statement
    fn analyze_statement(&mut self, stmt: &Statement) -> Result<(), TypeError> {
        match stmt {
            Statement::Let { pattern, value, .. } => {
                if let Some(expr) = value {
                    self.analyze_expression(expr)?;
                }
                // TODO: Analyze pattern for security
                Ok(())
            }
            Statement::Expression(expr) => {
                self.analyze_expression(expr)
            }
            _ => Ok(())
        }
    }

    /// Analyze security properties of an expression
    fn analyze_expression(&mut self, expr: &Expression) -> Result<(), TypeError> {
        match expr {
            Expression::Variable(ident) => {
                // Check if variable is used correctly
                self.usage_tracking.track_variable_use(&ident.name);
                Ok(())
            }
            Expression::Binary { left, op, right } => {
                self.analyze_expression(left)?;
                self.analyze_expression(right)?;

                // Check if binary operation is constant-time when required
                self.check_constant_time_operation(op, left, right)?;
                Ok(())
            }
            Expression::Call { function, args } => {
                self.analyze_expression(function)?;

                for arg in args {
                    self.analyze_expression(arg)?;
                }

                // Check function call for security properties
                if let Expression::Variable(ident) = function.as_ref() {
                    self.check_function_call_security(ident, args)?;
                }

                Ok(())
            }
            Expression::Encrypt { data, key } => {
                self.analyze_expression(data)?;
                self.analyze_expression(key)?;

                // Verify encryption operation security
                self.check_encryption_security(data, key)
            }
            Expression::Decrypt { data, key } => {
                self.analyze_expression(data)?;
                self.analyze_expression(key)?;

                // Verify decryption operation security
                self.check_decryption_security(data, key)
            }
            _ => {
                // For other expressions, recursively analyze subexpressions
                // This is a simplified implementation
                Ok(())
            }
        }
    }

    /// Check if a binary operation is constant-time
    fn check_constant_time_operation(&mut self, op: &BinaryOp, left: &Expression, right: &Expression) -> Result<(), TypeError> {
        // Check if either operand involves secret data
        let left_secret = self.is_secret_expression(left);
        let right_secret = self.is_secret_expression(right);

        if left_secret || right_secret {
            match op {
                BinaryOp::Eq | BinaryOp::Ne | BinaryOp::Lt | BinaryOp::Gt | BinaryOp::Le | BinaryOp::Ge => {
                    // Comparison operations on secrets must be constant-time
                    if !self.constant_time_info.is_constant_time_context() {
                        return Err(TypeError::SecurityViolation {
                            message: format!("Comparison operation '{}' on secret data must be in constant-time context", op),
                            location: SourceLocation {
                                start_line: 0, start_column: 0, end_line: 0, end_column: 0, file: 0
                            }
                        });
                    }
                }
                _ => {}
            }
        }

        Ok(())
    }

    /// Check if an expression involves secret data
    fn is_secret_expression(&self, expr: &Expression) -> bool {
        match expr {
            Expression::Variable(ident) => {
                // Check if variable has secret type
                // This is a simplified check - in practice we'd look up the type
                matches!(format!("{}", ident.name).as_str(), "secret" | "key" | "private")
            }
            Expression::Field { object, .. } => {
                // Check if accessing secret field
                self.is_secret_expression(object)
            }
            _ => false
        }
    }

    /// Check security properties of function call
    fn check_function_call_security(&mut self, func_name: &Identifier, args: &[Expression]) -> Result<(), TypeError> {
        // Check for cryptographic function calls
        match format!("{}", func_name.name).as_str() {
            "encrypt" | "decrypt" | "sign" | "verify" => {
                self.check_crypto_function_security(func_name, args)
            }
            _ => Ok(())
        }
    }

    /// Check security of cryptographic function calls
    fn check_crypto_function_security(&mut self, func_name: &Identifier, args: &[Expression]) -> Result<(), TypeError> {
        match format!("{}", func_name.name).as_str() {
            "encrypt" => {
                if args.len() >= 2 {
                    // Check that key is not used after encryption
                    if let Expression::Variable(key_var) = &args[1] {
                        self.usage_tracking.track_secret_use(&key_var.name);
                    }
                }
            }
            "decrypt" => {
                if args.len() >= 2 {
                    // Check that key is not used after decryption
                    if let Expression::Variable(key_var) = &args[1] {
                        self.usage_tracking.track_secret_use(&key_var.name);
                    }
                }
            }
            _ => {}
        }

        Ok(())
    }

    /// Check encryption operation security
    fn check_encryption_security(&mut self, data: &Expression, key: &Expression) -> Result<(), TypeError> {
        // Verify that encryption uses appropriate key type
        if let Expression::Variable(key_var) = key {
            // Check if key variable has appropriate type
            // This would involve looking up the variable's type
        }

        Ok(())
    }

    /// Check decryption operation security
    fn check_decryption_security(&mut self, data: &Expression, key: &Expression) -> Result<(), TypeError> {
        // Verify that decryption uses appropriate key type
        if let Expression::Variable(key_var) = key {
            // Check if key variable has appropriate type
        }

        Ok(())
    }

    /// Report a security violation
    fn report_violation(&mut self, violation: SecurityViolation) {
        self.violations.push(violation);
    }
}

/// Affine usage tracking for secret types
#[derive(Debug, Clone)]
pub struct AffineUsage {
    usage_count: HashMap<Sym, usize>,
    secret_variables: HashSet<Sym>,
}

impl AffineUsage {
    pub fn new() -> Self {
        Self {
            usage_count: HashMap::new(),
            secret_variables: HashSet::new(),
        }
    }

    /// Track a variable use
    pub fn track_variable_use(&mut self, var_name: &Sym) {
        *self.usage_count.entry(*var_name).or_insert(0) += 1;
    }

    /// Track a secret variable use (affine analysis)
    pub fn track_secret_use(&mut self, var_name: &Sym) {
        self.secret_variables.insert(*var_name);
        self.track_variable_use(var_name);
    }

    /// Check if a secret variable has been used affinely (at most once)
    pub fn check_affine_usage(&self, var_name: &Sym) -> Result<(), SecurityViolation> {
        if self.secret_variables.contains(var_name) {
            let usage_count = self.usage_count.get(var_name).unwrap_or(&0);
            if *usage_count > 1 {
                return Err(SecurityViolation::MultipleSecretUsage {
                    var_name: var_name.to_string(),
                    usage_count: *usage_count,
                });
            }
        }
        Ok(())
    }

    /// Get usage count for a variable
    pub fn get_usage_count(&self, var_name: &Sym) -> usize {
        self.usage_count.get(var_name).copied().unwrap_or(0)
    }

    /// Check all affine constraints
    pub fn check_all_affine_constraints(&self) -> Vec<SecurityViolation> {
        let mut violations = Vec::new();

        for var_name in &self.secret_variables {
            if let Err(violation) = self.check_affine_usage(var_name) {
                violations.push(violation);
            }
        }

        violations
    }
}

/// Constant-time operation information
#[derive(Debug, Clone)]
pub struct ConstantTimeInfo {
    constant_time_functions: HashSet<Sym>,
    constant_time_context: bool,
}

impl ConstantTimeInfo {
    pub fn new() -> Self {
        Self {
            constant_time_functions: HashSet::new(),
            constant_time_context: false,
        }
    }

    /// Mark a function as constant-time
    pub fn mark_function_constant_time(&mut self, func_name: &Identifier) {
        self.constant_time_functions.insert(func_name.name);
    }

    /// Check if currently in a constant-time context
    pub fn is_constant_time_context(&self) -> bool {
        self.constant_time_context
    }

    /// Enter a constant-time context
    pub fn enter_constant_time_context(&mut self) {
        self.constant_time_context = true;
    }

    /// Exit constant-time context
    pub fn exit_constant_time_context(&mut self) {
        self.constant_time_context = false;
    }

    /// Check if a function is marked as constant-time
    pub fn is_function_constant_time(&self, func_name: &Sym) -> bool {
        self.constant_time_functions.contains(func_name)
    }
}

/// Security violation types
#[derive(Debug, Clone)]
pub enum SecurityViolation {
    /// Secret used more than once (affine violation)
    MultipleSecretUsage {
        var_name: String,
        usage_count: usize,
    },
    /// Non-constant-time operation on secrets
    NonConstantTimeOperation {
        operation: String,
        location: SourceLocation,
    },
    /// Secret data leaked through public channel
    SecretLeakage {
        var_name: String,
        location: SourceLocation,
    },
    /// Insecure memory handling
    InsecureMemoryAccess {
        message: String,
        location: SourceLocation,
    },
    /// Timing attack vulnerability
    TimingAttackRisk {
        message: String,
        location: SourceLocation,
    },
    /// Cryptographic protocol violation
    CryptoProtocolViolation {
        message: String,
        location: SourceLocation,
    },
}

impl fmt::Display for SecurityViolation {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            SecurityViolation::MultipleSecretUsage { var_name, usage_count } => {
                write!(f, "Secret variable '{}' used {} times (should be used at most once)", var_name, usage_count)
            }
            SecurityViolation::NonConstantTimeOperation { operation, location } => {
                write!(f, "Non-constant-time operation '{}' on secret data at {}:{}", operation, location.start_line, location.start_column)
            }
            SecurityViolation::SecretLeakage { var_name, location } => {
                write!(f, "Secret variable '{}' leaked at {}:{}", var_name, location.start_line, location.start_column)
            }
            SecurityViolation::InsecureMemoryAccess { message, location } => {
                write!(f, "Insecure memory access at {}:{} - {}", location.start_line, location.start_column, message)
            }
            SecurityViolation::TimingAttackRisk { message, location } => {
                write!(f, "Timing attack risk at {}:{} - {}", location.start_line, location.start_column, message)
            }
            SecurityViolation::CryptoProtocolViolation { message, location } => {
                write!(f, "Cryptographic protocol violation at {}:{} - {}", location.start_line, location.start_column, message)
            }
        }
    }
}

/// Security report containing all analysis results
#[derive(Debug, Clone)]
pub struct SecurityReport {
    pub violations: Vec<SecurityViolation>,
    pub usage_tracking: AffineUsage,
    pub constant_time_info: ConstantTimeInfo,
}

impl SecurityReport {
    /// Check if the program has any security violations
    pub fn has_violations(&self) -> bool {
        !self.violations.is_empty()
    }

    /// Get the number of security violations
    pub fn violation_count(&self) -> usize {
        self.violations.len()
    }

    /// Get violations by type
    pub fn violations_by_type(&self) -> HashMap<String, Vec<&SecurityViolation>> {
        let mut by_type = HashMap::new();

        for violation in &self.violations {
            let type_name = match violation {
                SecurityViolation::MultipleSecretUsage { .. } => "MultipleSecretUsage",
                SecurityViolation::NonConstantTimeOperation { .. } => "NonConstantTimeOperation",
                SecurityViolation::SecretLeakage { .. } => "SecretLeakage",
                SecurityViolation::InsecureMemoryAccess { .. } => "InsecureMemoryAccess",
                SecurityViolation::TimingAttackRisk { .. } => "TimingAttackRisk",
                SecurityViolation::CryptoProtocolViolation { .. } => "CryptoProtocolViolation",
            };

            by_type.entry(type_name.to_string()).or_insert_with(Vec::new).push(violation);
        }

        by_type
    }

    /// Format security report for display
    pub fn format_report(&self) -> String {
        let mut report = String::new();

        report.push_str(&format!("Security Analysis Report\n"));
        report.push_str(&format!("========================\n\n"));

        if self.has_violations() {
            report.push_str(&format!("Found {} security violation(s):\n\n", self.violation_count()));

            for (i, violation) in self.violations.iter().enumerate() {
                report.push_str(&format!("{}. {}\n", i + 1, violation));
            }
        } else {
            report.push_str("No security violations found.\n");
        }

        report.push_str("\nAffine Usage Summary:\n");
        report.push_str("--------------------\n");
        for (var_name, count) in &self.usage_tracking.usage_count {
            if self.usage_tracking.secret_variables.contains(var_name) {
                report.push_str(&format!("{}: {} uses\n", var_name, count));
            }
        }

        report
    }
}

/// Security context for tracking security properties during type checking
#[derive(Debug, Clone)]
pub struct SecurityContext {
    current_security_level: SecurityLevel,
    in_constant_time_context: bool,
    active_secrets: HashSet<Sym>,
}

impl SecurityContext {
    pub fn new() -> Self {
        Self {
            current_security_level: SecurityLevel::Public,
            in_constant_time_context: false,
            active_secrets: HashSet::new(),
        }
    }

    /// Enter a secret context
    pub fn enter_secret_context(&mut self, secret_vars: Vec<Sym>) {
        self.current_security_level = SecurityLevel::Secret;
        self.active_secrets.extend(secret_vars);
    }

    /// Exit secret context
    pub fn exit_secret_context(&mut self) {
        self.current_security_level = SecurityLevel::Public;
        self.active_secrets.clear();
    }

    /// Enter constant-time context
    pub fn enter_constant_time_context(&mut self) {
        self.in_constant_time_context = true;
    }

    /// Exit constant-time context
    pub fn exit_constant_time_context(&mut self) {
        self.in_constant_time_context = false;
    }

    /// Check if currently in secret context
    pub fn in_secret_context(&self) -> bool {
        self.current_security_level == SecurityLevel::Secret
    }

    /// Check if currently in constant-time context
    pub fn in_constant_time_context(&self) -> bool {
        self.in_constant_time_context
    }

    /// Get active secrets
    pub fn active_secrets(&self) -> &HashSet<Sym> {
        &self.active_secrets
    }
}

/// Security levels for information flow analysis
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum SecurityLevel {
    Public,
    Secret,
    Encrypted,
}

impl SecurityLevel {
    /// Check if this level can flow to another level
    pub fn can_flow_to(&self, other: &SecurityLevel) -> bool {
        match (self, other) {
            (SecurityLevel::Public, _) => true,
            (SecurityLevel::Secret, SecurityLevel::Secret) => true,
            (SecurityLevel::Secret, SecurityLevel::Encrypted) => true,
            (SecurityLevel::Encrypted, SecurityLevel::Encrypted) => true,
            _ => false,
        }
    }
}

/// Memory safety analysis for cryptographic data
pub struct MemorySafetyAnalysis {
    memory_violations: Vec<MemoryViolation>,
}

impl MemorySafetyAnalysis {
    pub fn new() -> Self {
        Self {
            memory_violations: Vec::new(),
        }
    }

    /// Analyze memory safety of cryptographic operations
    pub fn analyze_memory_safety(&mut self, expr: &Expression) -> Result<(), MemoryViolation> {
        match expr {
            Expression::Encrypt { key, .. } | Expression::Decrypt { key, .. } => {
                // Check that cryptographic keys are properly handled
                if let Expression::Variable(key_var) = key {
                    // Verify key is not copied or leaked
                    self.check_key_handling(key_var)?;
                }
                Ok(())
            }
            _ => Ok(())
        }
    }

    fn check_key_handling(&mut self, key_var: &Identifier) -> Result<(), MemoryViolation> {
        // This would involve more sophisticated analysis in practice
        // For now, just check that the variable name suggests proper handling
        let name_str = format!("{}", key_var.name);
        if name_str.contains("temp") || name_str.contains("tmp") {
            return Err(MemoryViolation::TemporaryKeyExposure {
                var_name: name_str,
                location: SourceLocation {
                    start_line: 0, start_column: 0, end_line: 0, end_column: 0,
                    file: 0
                }
            });
        }
        Ok(())
    }
}

/// Memory safety violation
#[derive(Debug, Clone)]
pub enum MemoryViolation {
    TemporaryKeyExposure {
        var_name: String,
        location: SourceLocation,
    },
    KeyCopied {
        var_name: String,
        location: SourceLocation,
    },
    InsecureMemoryWipe {
        message: String,
        location: SourceLocation,
    },
}

impl fmt::Display for MemoryViolation {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            MemoryViolation::TemporaryKeyExposure { var_name, location } => {
                write!(f, "Temporary key '{}' exposed at {}:{}", var_name, location.start_line, location.start_column)
            }
            MemoryViolation::KeyCopied { var_name, location } => {
                write!(f, "Cryptographic key '{}' copied at {}:{}", var_name, location.start_line, location.start_column)
            }
            MemoryViolation::InsecureMemoryWipe { message, location } => {
                write!(f, "Insecure memory wipe at {}:{} - {}", location.start_line, location.start_column, message)
            }
        }
    }
}