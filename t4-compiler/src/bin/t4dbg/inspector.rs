//! Variable inspection for T4 Debugger

use std::collections::HashMap;

pub struct VariableInspector {
    watch_expressions: Vec<String>,
    variables: HashMap<String, VariableValue>,
}

#[derive(Debug, Clone)]
pub enum VariableValue {
    Int(i64),
    Float(f64),
    String(String),
    Bool(bool),
    Bytes(Vec<u8>),
    Key(String), // Key identifier
    Ciphertext(String),
    Hash(String),
    Array(Vec<VariableValue>),
    Struct(HashMap<String, VariableValue>),
}

impl VariableInspector {
    pub fn new() -> Self {
        Self {
            watch_expressions: Vec::new(),
            variables: HashMap::new(),
        }
    }

    pub fn add_watch_expression(&mut self, expression: String) {
        self.watch_expressions.push(expression);
    }

    pub fn inspect_variable(&self, _name: &str) -> Option<&VariableValue> {
        // TODO: Implement variable inspection
        None
    }

    pub fn evaluate_expression(&self, _expression: &str) -> Option<VariableValue> {
        // TODO: Implement expression evaluation
        None
    }

    pub fn list_watch_expressions(&self) -> &[String] {
        &self.watch_expressions
    }

    pub fn get_variable_value(&self, name: &str) -> Option<&VariableValue> {
        self.variables.get(name)
    }

    pub fn set_variable(&mut self, name: String, value: VariableValue) {
        self.variables.insert(name, value);
    }
}