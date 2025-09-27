//! Type environment management for the T4 type system

use crate::ast::*;
use super::{TypeScheme, TypeVar};
use std::collections::HashMap;
// use string_interner::Sym; // TODO: Fix when ANTLR integration is complete
use super::Sym;

/// Binding information in the type environment
#[derive(Debug, Clone)]
pub enum Binding {
    /// Variable binding with type and mutability
    Variable {
        typ: TypeScheme,
        mutable: bool,
    },
    /// Function binding with type signature
    Function {
        typ: TypeScheme,
        security_annotations: Vec<SecurityAnnotation>,
    },
    /// Type binding (struct, enum, trait)
    Type {
        typ: TypeScheme,
        kind: TypeKind,
    },
    /// Module binding
    Module {
        declarations: Vec<Declaration>,
    },
}

/// Kind of a type (for type-level programming)
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum TypeKind {
    /// Regular type
    Type,
    /// Trait (type class)
    Trait,
    /// Kind of higher-order types
    Kind(Box<TypeKind>),
}

/// Scope in the type environment
#[derive(Debug, Clone)]
pub struct Scope {
    pub bindings: HashMap<u32, Binding>,
    pub parent: Option<usize>,
}

impl Scope {
    pub fn new() -> Self {
        Self {
            bindings: HashMap::new(),
            parent: None,
        }
    }

    pub fn with_parent(parent: usize) -> Self {
        Self {
            bindings: HashMap::new(),
            parent: Some(parent),
        }
    }

    pub fn add_binding(&mut self, name: u32, binding: Binding) {
        self.bindings.insert(name, binding);
    }

    pub fn get_binding(&self, name: u32) -> Option<&Binding> {
        self.bindings.get(&name)
    }

    pub fn contains(&self, name: u32) -> bool {
        self.bindings.contains_key(&name)
    }
}

/// Type environment with scoped bindings
#[derive(Debug, Clone)]
pub struct TypeEnvironment {
    scopes: Vec<Scope>,
    current_scope: usize,
}

impl TypeEnvironment {
    pub fn new() -> Self {
        let mut env = Self {
            scopes: vec![Scope::new()],
            current_scope: 0,
        };

        // Add built-in types
        env.add_builtin_types();
        env
    }

    /// Add built-in types to the environment
    fn add_builtin_types(&mut self) {
        let builtin_scope = &mut self.scopes[0];

        // Basic types
        let basic_types = vec![
            (Type::Int8, TypeKind::Type),
            (Type::Int16, TypeKind::Type),
            (Type::Int32, TypeKind::Type),
            (Type::Int64, TypeKind::Type),
            (Type::UInt8, TypeKind::Type),
            (Type::UInt16, TypeKind::Type),
            (Type::UInt32, TypeKind::Type),
            (Type::UInt64, TypeKind::Type),
            (Type::Float32, TypeKind::Type),
            (Type::Float64, TypeKind::Type),
            (Type::Bool, TypeKind::Type),
            (Type::String, TypeKind::Type),
            (Type::Bytes, TypeKind::Type),
            (Type::Unit, TypeKind::Type),
            (Type::Never, TypeKind::Type),
        ];

        for (typ, kind) in basic_types {
            builtin_scope.add_binding(
                match &typ {
                    Type::Int8 => "Int8",
                    Type::Int16 => "Int16",
                    Type::Int32 => "Int32",
                    Type::Int64 => "Int64",
                    Type::UInt8 => "UInt8",
                    Type::UInt16 => "UInt16",
                    Type::UInt32 => "UInt32",
                    Type::UInt64 => "UInt64",
                    Type::Float32 => "Float32",
                    Type::Float64 => "Float64",
                    Type::Bool => "Bool",
                    Type::String => "String",
                    Type::Bytes => "Bytes",
                    Type::Unit => "Unit",
                    Type::Never => "Never",
                    _ => unreachable!(),
                },
                Binding::Type {
                    typ: TypeScheme::concrete(typ),
                    kind,
                }
            );
        }

        // Cryptographic types
        let crypto_types = vec![
            (Type::Nonce, TypeKind::Type),
            (Type::Salt, TypeKind::Type),
        ];

        for (typ, kind) in crypto_types {
            builtin_scope.add_binding(
                match &typ {
                    Type::Nonce => "Nonce",
                    Type::Salt => "Salt",
                    _ => unreachable!(),
                },
                Binding::Type {
                    typ: TypeScheme::concrete(typ),
                    kind,
                }
            );
        }
    }

    /// Enter a new scope
    pub fn enter_scope(&mut self) {
        let parent = self.current_scope;
        self.scopes.push(Scope::with_parent(parent));
        self.current_scope = self.scopes.len() - 1;
    }

    /// Exit the current scope
    pub fn exit_scope(&mut self) {
        if let Some(parent) = self.scopes[self.current_scope].parent {
            self.current_scope = parent;
        }
    }

    /// Add a binding to the current scope
    pub fn add_binding(&mut self, name: u32, binding: Binding) {
        self.scopes[self.current_scope].add_binding(name, binding);
    }

    /// Get a binding from the environment (searches all scopes)
    pub fn get_binding(&self, name: u32) -> Option<&Binding> {
        let mut current = self.current_scope;

        loop {
            if let Some(binding) = self.scopes[current].get_binding(name) {
                return Some(binding);
            }

            if let Some(parent) = self.scopes[current].parent {
                current = parent;
            } else {
                break;
            }
        }

        None
    }

    /// Check if a name is bound in the current scope
    pub fn contains_in_current_scope(&self, name: u32) -> bool {
        self.scopes[self.current_scope].contains(name)
    }

    /// Check if a name is bound anywhere in the environment
    pub fn contains(&self, name: u32) -> bool {
        self.get_binding(name).is_some()
    }

    /// Get all bindings in the current scope
    pub fn current_bindings(&self) -> &HashMap<u32, Binding> {
        &self.scopes[self.current_scope].bindings
    }

    /// Get the current scope index
    pub fn current_scope_index(&self) -> usize {
        self.current_scope
    }

    /// Get all type bindings (for name resolution)
    pub fn get_type_bindings(&self) -> HashMap<u32, (TypeScheme, TypeKind)> {
        let mut type_bindings = HashMap::new();
        let mut current = self.current_scope;

        loop {
            for (name, binding) in &self.scopes[current].bindings {
                if let Binding::Type { typ, kind } = binding {
                    type_bindings.insert(*name, (typ.clone(), kind.clone()));
                }
            }

            if let Some(parent) = self.scopes[current].parent {
                current = parent;
            } else {
                break;
            }
        }

        type_bindings
    }

    /// Add a generic type parameter to the current scope
    pub fn add_type_parameter(&mut self, name: u32, var: TypeVar) {
        self.add_binding(
            name,
            Binding::Type {
                typ: TypeScheme::Variable(var),
                kind: TypeKind::Type,
            }
        );
    }

    /// Add a function binding
    pub fn add_function(&mut self, name: u32, typ: TypeScheme, security_annotations: Vec<SecurityAnnotation>) {
        self.add_binding(
            name,
            Binding::Function {
                typ,
                security_annotations,
            }
        );
    }

    /// Add a variable binding
    pub fn add_variable(&mut self, name: u32, typ: TypeScheme, mutable: bool) {
        self.add_binding(
            name,
            Binding::Variable {
                typ,
                mutable,
            }
        );
    }

    /// Add a type binding
    pub fn add_type(&mut self, name: u32, typ: TypeScheme, kind: TypeKind) {
        self.add_binding(
            name,
            Binding::Type { typ, kind }
        );
    }

    /// Add a module binding
    pub fn add_module(&mut self, name: u32, declarations: Vec<Declaration>) {
        self.add_binding(
            name,
            Binding::Module { declarations }
        );
    }

    /// Get all free type variables in the current environment
    pub fn free_type_vars(&self) -> Vec<TypeVar> {
        let mut free_vars = Vec::new();

        for scope in &self.scopes {
            for binding in scope.bindings.values() {
                match binding {
                    Binding::Variable { typ, .. } => {
                        for var in typ.free_vars() {
                            if !free_vars.contains(&var) {
                                free_vars.push(var);
                            }
                        }
                    }
                    Binding::Function { typ, .. } => {
                        for var in typ.free_vars() {
                            if !free_vars.contains(&var) {
                                free_vars.push(var);
                            }
                        }
                    }
                    Binding::Type { typ, .. } => {
                        for var in typ.free_vars() {
                            if !free_vars.contains(&var) {
                                free_vars.push(var);
                            }
                        }
                    }
                    _ => {}
                }
            }
        }

        free_vars
    }

    /// Clone the environment for a new context
    pub fn clone_for_context(&self) -> Self {
        self.clone()
    }

    /// Merge another environment into this one
    pub fn merge(&mut self, other: TypeEnvironment) {
        for scope in other.scopes {
            for (name, binding) in scope.bindings {
                if !self.contains(name) {
                    self.add_binding(name, binding);
                }
            }
        }
    }

    /// Get the depth of the current scope (for debugging)
    pub fn scope_depth(&self) -> usize {
        let mut depth = 0;
        let mut current = self.current_scope;

        while let Some(parent) = self.scopes[current].parent {
            depth += 1;
            current = parent;
        }

        depth
    }

    /// Get all bindings in all scopes (for debugging)
    pub fn all_bindings(&self) -> Vec<(u32, &Binding)> {
        let mut bindings = Vec::new();

        for scope in &self.scopes {
            for (name, binding) in &scope.bindings {
                bindings.push((*name, binding));
            }
        }

        bindings
    }

    /// Check if we're in a function scope
    pub fn in_function_scope(&self) -> bool {
        // Simple heuristic: if we have more than one scope, we're likely in a function
        self.scopes.len() > 1
    }

    /// Get the current function's return type (if any)
    pub fn current_function_return_type(&self) -> Option<TypeScheme> {
        if !self.in_function_scope() {
            return None;
        }

        // Look for function bindings in outer scopes
        let mut current = self.current_scope;
        while let Some(parent) = self.scopes[current].parent {
            for binding in self.scopes[current].bindings.values() {
                if let Binding::Function { typ, .. } = binding {
                    return Some(typ.clone());
                }
            }
            current = parent;
        }

        None
    }
}

impl Default for TypeEnvironment {
    fn default() -> Self {
        Self::new()
    }
}

/// Type context for resolving names and types
#[derive(Debug)]
pub struct TypeContext<'a> {
    pub environment: &'a TypeEnvironment,
    pub current_module: Option<u32>,
    pub imported_modules: HashMap<u32, Vec<Declaration>>,
}

impl<'a> TypeContext<'a> {
    pub fn new(environment: &'a TypeEnvironment) -> Self {
        Self {
            environment,
            current_module: None,
            imported_modules: HashMap::new(),
        }
    }

    pub fn with_module(environment: &'a TypeEnvironment, module: u32) -> Self {
        Self {
            environment,
            current_module: Some(module),
            imported_modules: HashMap::new(),
        }
    }

    /// Resolve a type name to its definition
    pub fn resolve_type(&self, name: u32) -> Option<(TypeScheme, TypeKind)> {
        self.environment.get_type_bindings().get(&name).cloned()
    }

    /// Resolve a function name to its signature
    pub fn resolve_function(&self, name: u32) -> Option<&TypeScheme> {
        if let Some(Binding::Function { typ, .. }) = self.environment.get_binding(name) {
            Some(typ)
        } else {
            None
        }
    }

    /// Resolve a variable name to its type
    pub fn resolve_variable(&self, name: u32) -> Option<(TypeScheme, bool)> {
        if let Some(Binding::Variable { typ, mutable }) = self.environment.get_binding(name) {
            Some((typ.clone(), *mutable))
        } else {
            None
        }
    }

    /// Add an imported module
    pub fn add_import(&mut self, module_name: u32, declarations: Vec<Declaration>) {
        self.imported_modules.insert(module_name, declarations);
    }

    /// Get declarations from an imported module
    pub fn get_module_declarations(&self, module_name: u32) -> Option<&Vec<Declaration>> {
        self.imported_modules.get(&module_name)
    }

    /// Check if a name is accessible (considering module boundaries)
    pub fn is_accessible(&self, name: u32, defining_module: Option<u32>) -> bool {
        match defining_module {
            Some(defining) => {
                // If it's defined in the current module or a public export, it's accessible
                self.current_module == Some(defining) ||
                self.environment.get_binding(name).is_some()
            }
            None => {
                // Built-in or global definitions are always accessible
                self.environment.get_binding(name).is_some()
            }
        }
    }

    /// Get the fully qualified name for a definition
    pub fn qualify_name(&self, name: u32, defining_module: Option<u32>) -> String {
        match defining_module {
            Some(module) => format!("{}::{}", module, name),
            None => name.to_string(),
        }
    }
}