//! Security violation monitoring for T4 Debugger

use std::collections::HashMap;

pub struct SecurityMonitor {
    violations: Vec<SecurityViolation>,
    violation_counts: HashMap<SecurityViolationType, usize>,
}

#[derive(Debug, Clone)]
pub struct SecurityViolation {
    pub violation_type: SecurityViolationType,
    pub description: String,
    pub file: String,
    pub line: usize,
    pub timestamp: std::time::SystemTime,
    pub severity: SecuritySeverity,
}

#[derive(Debug, Clone, PartialEq, Eq, Hash)]
pub enum SecurityViolationType {
    TimingAttack,
    MemoryLeak,
    InsecureRandom,
    WeakKey,
    InsecureAlgorithm,
    ConstantTimeViolation,
    CacheAttack,
    SideChannelLeak,
    InsecureConfiguration,
    PrivilegeEscalation,
}

#[derive(Debug, Clone)]
pub enum SecuritySeverity {
    Low,
    Medium,
    High,
    Critical,
}

impl SecurityMonitor {
    pub fn new() -> Self {
        Self {
            violations: Vec::new(),
            violation_counts: HashMap::new(),
        }
    }

    pub fn record_violation(&mut self, violation: SecurityViolation) {
        // Update violation counts
        *self.violation_counts.entry(violation.violation_type.clone()).or_insert(0) += 1;

        self.violations.push(violation);
    }

    pub fn get_violations(&self) -> &[SecurityViolation] {
        &self.violations
    }

    pub fn get_violation_counts(&self) -> &HashMap<SecurityViolationType, usize> {
        &self.violation_counts
    }

    pub fn get_violations_by_type(&self, violation_type: &SecurityViolationType) -> Vec<&SecurityViolation> {
        self.violations.iter().filter(|v| v.violation_type == *violation_type).collect()
    }

    pub fn get_high_severity_violations(&self) -> Vec<&SecurityViolation> {
        self.violations.iter().filter(|v| matches!(v.severity, SecuritySeverity::High | SecuritySeverity::Critical)).collect()
    }

    pub fn generate_security_report(&self) -> SecurityReport {
        let mut type_summary = HashMap::new();
        let mut severity_summary = HashMap::new();

        for violation in &self.violations {
            *type_summary.entry(violation.violation_type.clone()).or_insert(0) += 1;
            *severity_summary.entry(violation.severity.clone()).or_insert(0) += 1;
        }

        SecurityReport {
            total_violations: self.violations.len(),
            type_summary,
            severity_summary,
            high_severity_count: self.get_high_severity_violations().len(),
        }
    }
}

#[derive(Debug)]
pub struct SecurityReport {
    pub total_violations: usize,
    pub type_summary: HashMap<SecurityViolationType, usize>,
    pub severity_summary: HashMap<SecuritySeverity, usize>,
    pub high_severity_count: usize,
}