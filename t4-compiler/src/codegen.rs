//! T4 Code Generator
//!
//! This module generates output code from T4 AST.
//! Currently generates human-readable representations for debugging.

use crate::ast::{Program, Declaration, Expression, Statement, Type};
use std::collections::HashMap;

/// Code generator for T4
pub struct CodeGenerator {
    /// Generated output
    output: Vec<u8>,

    /// Indentation level
    indent: usize,

    /// Label counter for generated code
    label_counter: usize,
}

impl CodeGenerator {
    /// Create a new code generator
    pub fn new() -> Self {
        Self {
            output: Vec::new(),
            indent: 0,
            label_counter: 0,
        }
    }

    /// Generate code for a T4 program
    pub fn generate(&mut self, program: &Program, output_name: &str) -> Result<Vec<u8>, String> {
        self.emit_header(output_name);
        self.emit_program(program);
        self.emit_footer();

        Ok(self.output.clone())
    }

    /// Emit file header
    fn emit_header(&mut self, output_name: &str) {
        self.emit_line(&format!("// Generated T4 output: {}", output_name));
        self.emit_line("// T4 Compiler v0.1.0");
        self.emit_line("");
    }

    /// Emit program structure
    fn emit_program(&mut self, program: &Program) {
        self.emit_line("=== T4 Program ===");
        self.emit_line(&format!("Declarations: {}", program.declarations.len()));
        self.emit_line("");

        for declaration in &program.declarations {
            self.emit_declaration(declaration);
            self.emit_line("");
        }
    }

    /// Emit a declaration
    fn emit_declaration(&mut self, declaration: &Declaration) {
        match declaration {
            Declaration::Module(module) => self.emit_module(module),
            Declaration::Import { path, alias } => {
                self.emit_line("Import:");
                self.indent();
                self.emit_line(&format!("Path: {}", path));
                if let Some(ref a) = alias {
                    self.emit_line(&format!("Alias: {}", self.get_identifier_name(a)));
                }
                self.dedent();
            },
            Declaration::Function(function) => self.emit_function(function),
            Declaration::Struct { name, fields, .. } => {
                self.emit_line("Struct:");
                self.indent();
                self.emit_line(&format!("Name: {}", self.get_identifier_name(name)));
                if let Some(ref f) = fields {
                    self.emit_line("Fields:");
                    self.indent();
                    for field in f {
                        self.emit_line(&format!(
                            "{}: {}",
                            self.get_identifier_name(&field.name),
                            self.format_type(&field.typ)
                        ));
                    }
                    self.dedent();
                }
                self.dedent();
            },
            Declaration::Enum { name, variants, .. } => {
                self.emit_line("Enum:");
                self.indent();
                self.emit_line(&format!("Name: {}", self.get_identifier_name(name)));
                self.emit_line("Variants:");
                self.indent();
                for variant in variants {
                    self.emit_line(&format!("{} ({:?})",
                        self.get_identifier_name(&variant.name),
                        variant.fields
                    ));
                }
                self.dedent();
                self.dedent();
            },
            Declaration::Constant(constant) => {
                self.emit_line("Constant:");
                self.indent();
                self.emit_line(&format!("Name: {}", self.get_identifier_name(&constant.name)));
                self.emit_line(&format!("Type: {}", self.format_type(&constant.typ)));
                self.emit_line("Value: <expression>");
                self.dedent();
            },
            Declaration::Static(_) => {
                self.emit_line("Static variable");
            },
            Declaration::Config(_) => {
                self.emit_line("Configuration block");
            },
            Declaration::Extern(_) => {
                self.emit_line("External block");
            },
            Declaration::Trait { .. } => {
                self.emit_line("Trait declaration");
            },
            Declaration::Impl { .. } => {
                self.emit_line("Implementation block");
            },
            Declaration::TypeAlias(_) => {
                self.emit_line("Type alias");
            },
        }
    }

    /// Emit a module
    fn emit_module(&mut self, module: &crate::ast::Module) {
        self.emit_line("Module:");
        self.indent();
        self.emit_line(&format!("Name: {}", self.get_identifier_name(&module.name)));
        self.emit_line(&format!("Declarations: {}", module.declarations.len()));

        for declaration in &module.declarations {
            self.emit_declaration(declaration);
        }

        self.dedent();
    }

    /// Emit a function
    fn emit_function(&mut self, function: &crate::ast::Function) {
        self.emit_line("Function:");
        self.indent();
        self.emit_line(&format!("Name: {}", self.get_identifier_name(&function.name)));

        if !function.parameters.is_empty() {
            self.emit_line("Parameters:");
            self.indent();
            for param in &function.parameters {
                self.emit_line(&format!(
                    "{}: {} ({})",
                    self.get_identifier_name(&param.name),
                    self.format_type(&param.typ),
                    if param.mutable { "mut" } else { "immut" }
                ));
            }
            self.dedent();
        }

        if let Some(ref return_type) = function.return_type {
            self.emit_line(&format!("Return type: {}", self.format_type(return_type)));
        }

        if let Some(ref body) = function.body {
            self.emit_line("Body:");
            self.indent();
            for statement in body {
                self.emit_statement(statement);
            }
            self.dedent();
        } else {
            self.emit_line("External function");
        }

        self.dedent();
    }

    /// Emit a statement
    fn emit_statement(&mut self, statement: &Statement) {
        match statement {
            Statement::Let { pattern, typ, value } => {
                self.emit_line("Let:");
                self.indent();
                self.emit_line(&format!("Pattern: {:?}", pattern));
                if let Some(ref t) = typ {
                    self.emit_line(&format!("Type: {}", self.format_type(t)));
                }
                if let Some(ref v) = value {
                    self.emit_line("Value: <expression>");
                }
                self.dedent();
            },
            Statement::Expression(expr) => {
                self.emit_line("Expression: <expression>");
            },
            Statement::Assignment { target, value } => {
                self.emit_line("Assignment:");
                self.indent();
                self.emit_line("Target: <expression>");
                self.emit_line("Value: <expression>");
                self.dedent();
            },
            Statement::Return(expr) => {
                self.emit_line("Return:");
                if let Some(ref e) = expr {
                    self.emit_line("Value: <expression>");
                } else {
                    self.emit_line("Void return");
                }
            },
            Statement::Break(expr) => {
                self.emit_line("Break:");
                if let Some(ref e) = expr {
                    self.emit_line("Value: <expression>");
                }
            },
            Statement::Continue => {
                self.emit_line("Continue");
            },
            Statement::If { condition, then_block, else_ifs, else_block } => {
                self.emit_line("If:");
                self.indent();
                self.emit_line("Condition: <expression>");
                self.emit_line("Then:");
                self.indent();
                for stmt in then_block {
                    self.emit_statement(stmt);
                }
                self.dedent();

                for (elif_condition, elif_block) in else_ifs {
                    self.emit_line("Else if:");
                    self.indent();
                    self.emit_line("Condition: <expression>");
                    for stmt in elif_block {
                        self.emit_statement(stmt);
                    }
                    self.dedent();
                }

                if let Some(ref eb) = else_block {
                    self.emit_line("Else:");
                    self.indent();
                    for stmt in eb {
                        self.emit_statement(stmt);
                    }
                    self.dedent();
                }

                self.dedent();
            },
            Statement::Match { expression, arms } => {
                self.emit_line("Match:");
                self.indent();
                self.emit_line("Expression: <expression>");
                self.emit_line(&format!("Arms: {}", arms.len()));
                self.dedent();
            },
            Statement::While { condition, body } => {
                self.emit_line("While:");
                self.indent();
                self.emit_line("Condition: <expression>");
                for stmt in body {
                    self.emit_statement(stmt);
                }
                self.dedent();
            },
            Statement::For { pattern, iterator, body } => {
                self.emit_line("For:");
                self.indent();
                self.emit_line(&format!("Pattern: {:?}", pattern));
                self.emit_line("Iterator: <expression>");
                for stmt in body {
                    self.emit_statement(stmt);
                }
                self.dedent();
            },
            Statement::Loop { body } => {
                self.emit_line("Loop:");
                self.indent();
                for stmt in body {
                    self.emit_statement(stmt);
                }
                self.dedent();
            },
        }
    }

    /// Format a type for display
    fn format_type(&self, typ: &Type) -> String {
        match typ {
            Type::Int8 => "Int8".to_string(),
            Type::Int16 => "Int16".to_string(),
            Type::Int32 => "Int32".to_string(),
            Type::Int64 => "Int64".to_string(),
            Type::UInt8 => "UInt8".to_string(),
            Type::UInt16 => "UInt16".to_string(),
            Type::UInt32 => "UInt32".to_string(),
            Type::UInt64 => "UInt64".to_string(),
            Type::Float32 => "Float32".to_string(),
            Type::Float64 => "Float64".to_string(),
            Type::Bool => "Bool".to_string(),
            Type::String => "String".to_string(),
            Type::Bytes => "Bytes".to_string(),
            Type::Key(alg) => format!("Key<{}>", alg),
            Type::Secret(t) => format!("Secret<{}>", self.format_type(t)),
            Type::PublicKey(alg) => format!("PublicKey<{}>", alg),
            Type::PrivateKey(alg) => format!("PrivateKey<{}>", alg),
            Type::Signature(alg) => format!("Signature<{}>", alg),
            Type::Ciphertext(alg) => format!("Ciphertext<{}>", alg),
            Type::Plaintext(alg) => format!("Plaintext<{}>", alg),
            Type::Hash(alg) => format!("Hash<{}>", alg),
            Type::Nonce => "Nonce".to_string(),
            Type::Salt => "Salt".to_string(),
            Type::Tuple(types) => {
                let type_strs: Vec<String> = types.iter().map(|t| self.format_type(t)).collect();
                format!("({})", type_strs.join(", "))
            },
            Type::Array(t, size) => format!("[{}; {}]", self.format_type(t), size),
            Type::Slice(t) => format!("[{}]", self.format_type(t)),
            Type::Reference(t) => format!("&{}", self.format_type(t)),
            Type::MutableReference(t) => format!("&mut {}", self.format_type(t)),
            Type::Function { params, return_type } => {
                let param_strs: Vec<String> = params.iter().map(|t| self.format_type(t)).collect();
                format!("fn({}) -> {}", param_strs.join(", "), self.format_type(return_type))
            },
            Type::Generic { base, args } => {
                let arg_strs: Vec<String> = args.iter().map(|t| self.format_type(t)).collect();
                format!("{}<{}>", self.format_type(base), arg_strs.join(", "))
            },
            Type::Path { module, name, args } => {
                let mut path = String::new();
                if let Some(ref m) = module {
                    for part in m {
                        path.push_str(&self.get_identifier_name(part));
                        path.push_str("::");
                    }
                }
                path.push_str(&self.get_identifier_name(name));
                if !args.is_empty() {
                    let arg_strs: Vec<String> = args.iter().map(|t| self.format_type(t)).collect();
                    path.push_str(&format!("<{}>", arg_strs.join(", ")));
                }
                path
            },
            Type::Unit => "()".to_string(),
            Type::Never => "!".to_string(),
            Type::Infer => "_".to_string(),
        }
    }

    /// Get identifier name (placeholder)
    fn get_identifier_name(&self, ident: &crate::ast::Identifier) -> String {
        format!("id_{}", ident.name)
    }

    /// Emit a line of output
    fn emit_line(&mut self, line: &str) {
        let indent_str = "    ".repeat(self.indent);
        let formatted_line = format!("{}{}\n", indent_str, line);
        self.output.extend(formatted_line.as_bytes());
    }

    /// Increase indentation
    fn indent(&mut self) {
        self.indent += 1;
    }

    /// Decrease indentation
    fn dedent(&mut self) {
        if self.indent > 0 {
            self.indent -= 1;
        }
    }

    /// Emit footer
    fn emit_footer(&mut self) {
        self.emit_line("");
        self.emit_line("// End of generated T4 output");
    }

    /// Generate a unique label
    fn generate_label(&mut self, prefix: &str) -> String {
        let label = format!("{}_{}", prefix, self.label_counter);
        self.label_counter += 1;
        label
    }
}

impl Default for CodeGenerator {
    fn default() -> Self {
        Self::new()
    }
}