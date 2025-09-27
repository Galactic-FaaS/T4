//! AST Visitor implementation for converting ANTLR parse trees to T4 AST nodes
//!
//! This module provides a custom visitor that traverses the ANTLR-generated parse tree
//! and constructs our typed AST nodes with proper source location information.

use super::*;
use crate::generated::{t4lexer::*, t4parser::*};
use antlr_rust::parser_rule_context::ParserRuleContext;
use antlr_rust::token::Token;
use antlr_rust::tree::{ParseTree, ParseTreeVisitor, TerminalNode, Tree};
use std::rc::Rc;
use string_interner::StringInterner;

/// Context for AST construction with source location tracking
pub struct AstBuilder<'i> {
    interner: &'i mut StringInterner,
    errors: Vec<BuildError>,
}

/// Error during AST construction
#[derive(Debug, Clone)]
pub struct BuildError {
    pub message: String,
    pub location: SourceLocation,
}

/// Result type for AST construction
pub type BuildResult<T> = Result<T, BuildError>;

impl<'i> AstBuilder<'i> {
    pub fn new(interner: &'i mut StringInterner) -> Self {
        Self {
            interner,
            errors: Vec::new(),
        }
    }

    /// Get source location from ANTLR context
    fn get_location(&self, ctx: &dyn ParserRuleContext) -> SourceLocation {
        let start = ctx.start();
        let stop = ctx.stop().unwrap_or(start);

        SourceLocation {
            start_line: start.line() as usize,
            start_column: start.column() as usize,
            end_line: stop.line() as usize,
            end_column: stop.column() as usize,
            file: self.interner.get_or_intern_static("unknown"), // TODO: Track actual file
        }
    }

    /// Create spanned AST node
    fn spanned<T>(&self, ctx: &dyn ParserRuleContext, node: T) -> Spanned<T> {
        Spanned::new(
            node,
            SourceSpan {
                location: self.get_location(ctx),
            },
        )
    }

    /// Intern string and create identifier
    fn make_ident(&mut self, text: &str, ctx: &dyn ParserRuleContext) -> Identifier {
        let sym = self.interner.get_or_intern(text);
        Identifier::new(
            sym,
            SourceSpan {
                location: self.get_location(ctx),
            },
        )
    }

    /// Report error during AST construction
    fn report_error(&mut self, message: String, ctx: &dyn ParserRuleContext) {
        self.errors.push(BuildError {
            message,
            location: self.get_location(ctx),
        });
    }
}

/// Main visitor for converting parse trees to AST
pub struct T4AstVisitor<'i> {
    builder: AstBuilder<'i>,
}

impl<'i> T4AstVisitor<'i> {
    pub fn new(interner: &'i mut StringInterner) -> Self {
        Self {
            builder: AstBuilder::new(interner),
        }
    }

    /// Build complete program from parse tree
    pub fn build_program(&mut self, ctx: &ProgramContext) -> Program {
        let mut declarations = Vec::new();

        for decl_ctx in ctx.declaration_all() {
            if let Ok(decl) = self.visit_declaration(decl_ctx.as_ref()) {
                declarations.push(decl.node);
            }
        }

        Program {
            declarations,
            config: ModuleConfig {
                default_crypto_provider: None,
                post_quantum_enabled: false,
                hardware_acceleration: false,
                custom_settings: std::collections::HashMap::new(),
            },
        }
    }

    /// Convert declaration context to AST declaration
    fn visit_declaration(&mut self, ctx: &DeclarationContext) -> BuildResult<SpannedDecl> {
        let location = self.builder.get_location(ctx);

        let declaration = if ctx.module_declaration().is_some() {
            self.visit_module_declaration(ctx.module_declaration().as_ref().unwrap())?
        } else if ctx.function_declaration().is_some() {
            self.visit_function_declaration(ctx.function_declaration().as_ref().unwrap())?
        } else if ctx.struct_declaration().is_some() {
            self.visit_struct_declaration(ctx.struct_declaration().as_ref().unwrap())?
        } else if ctx.enum_declaration().is_some() {
            self.visit_enum_declaration(ctx.enum_declaration().as_ref().unwrap())?
        } else if ctx.trait_declaration().is_some() {
            self.visit_trait_declaration(ctx.trait_declaration().as_ref().unwrap())?
        } else if ctx.impl_block().is_some() {
            self.visit_impl_block(ctx.impl_block().as_ref().unwrap())?
        } else if ctx.type_alias().is_some() {
            self.visit_type_alias(ctx.type_alias().as_ref().unwrap())?
        } else if ctx.const_declaration().is_some() {
            self.visit_const_declaration(ctx.const_declaration().as_ref().unwrap())?
        } else if ctx.static_declaration().is_some() {
            self.visit_static_declaration(ctx.static_declaration().as_ref().unwrap())?
        } else if ctx.extern_block().is_some() {
            self.visit_extern_block(ctx.extern_block().as_ref().unwrap())?
        } else {
            return Err(BuildError {
                message: "Unknown declaration type".to_string(),
                location,
            });
        };

        Ok(Spanned::new(declaration, SourceSpan { location }))
    }

    /// Visit module declaration
    fn visit_module_declaration(&mut self, ctx: &ModuleDeclarationContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let mut declarations = Vec::new();
        for decl_ctx in ctx.declaration_all() {
            if let Ok(decl) = self.visit_declaration(decl_ctx.as_ref()) {
                declarations.push(decl.node);
            }
        }

        Ok(Declaration::Module(Module {
            name,
            declarations,
            config: ModuleConfig {
                default_crypto_provider: None,
                post_quantum_enabled: false,
                hardware_acceleration: false,
                custom_settings: std::collections::HashMap::new(),
            },
        }))
    }

    /// Visit function declaration
    fn visit_function_declaration(&mut self, ctx: &FunctionDeclarationContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        // Parse parameters
        let mut parameters = Vec::new();
        if let Some(params_ctx) = ctx.parameters() {
            for param_ctx in params_ctx.parameter_all() {
                let param = self.visit_parameter(param_ctx.as_ref())?;
                parameters.push(param);
            }
        }

        // Parse return type
        let return_type = if let Some(ret_ctx) = ctx.return_type() {
            Some(self.visit_type(ret_ctx.as_ref())?)
        } else {
            None
        };

        // Parse body
        let body = if let Some(body_ctx) = ctx.block() {
            Some(self.visit_block(body_ctx.as_ref())?)
        } else {
            None
        };

        Ok(Declaration::Function(Function {
            name,
            generics: Vec::new(), // TODO: Parse generic parameters
            parameters,
            return_type,
            body,
            where_clause: None, // TODO: Parse where clause
            security_annotations: Vec::new(), // TODO: Parse security annotations
        }))
    }

    /// Visit parameter
    fn visit_parameter(&mut self, ctx: &ParameterContext) -> BuildResult<Parameter> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let typ = self.visit_type(ctx.type_().as_ref().unwrap())?;

        Ok(Parameter {
            name,
            typ,
            mutable: ctx.MUT().is_some(),
            reference: ctx.AND().is_some(),
        })
    }

    /// Visit type
    fn visit_type(&mut self, ctx: &TypeContext) -> BuildResult<Type> {
        if let Some(basic_ctx) = ctx.basic_type() {
            self.visit_basic_type(basic_ctx.as_ref())
        } else if let Some(crypto_ctx) = ctx.cryptographic_type() {
            self.visit_cryptographic_type(crypto_ctx.as_ref())
        } else if let Some(path_ctx) = ctx.type_path() {
            self.visit_type_path(path_ctx.as_ref())
        } else if let Some(tuple_ctx) = ctx.tuple_type() {
            self.visit_tuple_type(tuple_ctx.as_ref())
        } else if let Some(array_ctx) = ctx.array_type() {
            self.visit_array_type(array_ctx.as_ref())
        } else if let Some(slice_ctx) = ctx.slice_type() {
            self.visit_slice_type(slice_ctx.as_ref())
        } else if let Some(ref_ctx) = ctx.reference_type() {
            self.visit_reference_type(ref_ctx.as_ref())
        } else if let Some(mut_ref_ctx) = ctx.mutable_reference_type() {
            self.visit_mutable_reference_type(mut_ref_ctx.as_ref())
        } else {
            Err(BuildError {
                message: "Unknown type".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit basic type
    fn visit_basic_type(&mut self, ctx: &BasicTypeContext) -> BuildResult<Type> {
        if ctx.INT8().is_some() { Ok(Type::Int8) }
        else if ctx.INT16().is_some() { Ok(Type::Int16) }
        else if ctx.INT32().is_some() { Ok(Type::Int32) }
        else if ctx.INT64().is_some() { Ok(Type::Int64) }
        else if ctx.UINT8().is_some() { Ok(Type::UInt8) }
        else if ctx.UINT16().is_some() { Ok(Type::UInt16) }
        else if ctx.UINT32().is_some() { Ok(Type::UInt32) }
        else if ctx.UINT64().is_some() { Ok(Type::UInt64) }
        else if ctx.FLOAT32().is_some() { Ok(Type::Float32) }
        else if ctx.FLOAT64().is_some() { Ok(Type::Float64) }
        else if ctx.BOOL().is_some() { Ok(Type::Bool) }
        else if ctx.STRING_().is_some() { Ok(Type::String) }
        else if ctx.BYTES().is_some() { Ok(Type::Bytes) }
        else {
            Err(BuildError {
                message: "Unknown basic type".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit cryptographic type
    fn visit_cryptographic_type(&mut self, ctx: &CryptographicTypeContext) -> BuildResult<Type> {
        if let Some(key_ctx) = ctx.KEY_() {
            let alg_ctx = ctx.algorithm_type().unwrap();
            let algorithm = self.visit_algorithm_type(alg_ctx.as_ref())?;
            Ok(Type::Key(algorithm))
        } else if let Some(secret_ctx) = ctx.SECRET_() {
            let inner_ctx = ctx.type_().unwrap();
            let inner_type = self.visit_type(inner_ctx.as_ref())?;
            Ok(Type::Secret(Box::new(inner_type)))
        } else if let Some(pubkey_ctx) = ctx.PUBLICKEY_() {
            let alg_ctx = ctx.algorithm_type().unwrap();
            let algorithm = self.visit_algorithm_type(alg_ctx.as_ref())?;
            Ok(Type::PublicKey(algorithm))
        } else if let Some(privkey_ctx) = ctx.PRIVATEKEY_() {
            let alg_ctx = ctx.algorithm_type().unwrap();
            let algorithm = self.visit_algorithm_type(alg_ctx.as_ref())?;
            Ok(Type::PrivateKey(algorithm))
        } else if let Some(sig_ctx) = ctx.SIGNATURE_() {
            let alg_ctx = ctx.algorithm_type().unwrap();
            let algorithm = self.visit_algorithm_type(alg_ctx.as_ref())?;
            Ok(Type::Signature(algorithm))
        } else if let Some(cipher_ctx) = ctx.CIPHERTEXT_() {
            let alg_ctx = ctx.algorithm_type().unwrap();
            let algorithm = self.visit_algorithm_type(alg_ctx.as_ref())?;
            Ok(Type::Ciphertext(algorithm))
        } else if let Some(plain_ctx) = ctx.PLAINTEXT_() {
            let alg_ctx = ctx.algorithm_type().unwrap();
            let algorithm = self.visit_algorithm_type(alg_ctx.as_ref())?;
            Ok(Type::Plaintext(algorithm))
        } else if let Some(hash_ctx) = ctx.HASH_() {
            let alg_ctx = ctx.algorithm_type().unwrap();
            let algorithm = self.visit_algorithm_type(alg_ctx.as_ref())?;
            Ok(Type::Hash(algorithm))
        } else if ctx.NONCE_().is_some() {
            Ok(Type::Nonce)
        } else if ctx.SALT_().is_some() {
            Ok(Type::Salt)
        } else {
            Err(BuildError {
                message: "Unknown cryptographic type".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit algorithm type
    fn visit_algorithm_type(&mut self, ctx: &AlgorithmTypeContext) -> BuildResult<AlgorithmType> {
        if ctx.AES256().is_some() { Ok(AlgorithmType::Aes256) }
        else if ctx.KYBER1024().is_some() { Ok(AlgorithmType::Kyber1024) }
        else if ctx.DILITHIUM3().is_some() { Ok(AlgorithmType::Dilithium3) }
        else if ctx.ED25519().is_some() { Ok(AlgorithmType::Ed25519) }
        else if ctx.P256().is_some() { Ok(AlgorithmType::SecP256r1) }
        else if ctx.FALCON512().is_some() { Ok(AlgorithmType::Falcon512) }
        else if ctx.CKKS().is_some() { Ok(AlgorithmType::Ckks) }
        else if ctx.GROTH16().is_some() { Ok(AlgorithmType::Groth16) }
        else if ctx.BULLETPROOFS().is_some() { Ok(AlgorithmType::Bulletproofs) }
        else if ctx.STARK().is_some() { Ok(AlgorithmType::Stark) }
        else if ctx.PLONK().is_some() { Ok(AlgorithmType::Plonk) }
        else if let Some(path_ctx) = ctx.type_path() {
            // Handle custom algorithm types
            let path = self.visit_type_path(path_ctx.as_ref())?;
            if let Type::Path { name, .. } = path {
                Ok(AlgorithmType::Custom(name.name.to_string()))
            } else {
                Err(BuildError {
                    message: "Expected algorithm type path".to_string(),
                    location: self.builder.get_location(ctx),
                })
            }
        } else {
            Err(BuildError {
                message: "Unknown algorithm type".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit type path
    fn visit_type_path(&mut self, ctx: &TypePathContext) -> BuildResult<Type> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        Ok(Type::Path {
            module: None, // TODO: Parse module path
            name,
            args: Vec::new(), // TODO: Parse generic arguments
        })
    }

    /// Visit tuple type
    fn visit_tuple_type(&mut self, ctx: &TupleTypeContext) -> BuildResult<Type> {
        let mut types = Vec::new();
        for type_ctx in ctx.type_all() {
            types.push(self.visit_type(type_ctx.as_ref())?);
        }

        if types.is_empty() {
            Ok(Type::Unit)
        } else {
            Ok(Type::Tuple(types))
        }
    }

    /// Visit array type
    fn visit_array_type(&mut self, ctx: &ArrayTypeContext) -> BuildResult<Type> {
        let element_type = self.visit_type(ctx.type_().as_ref().unwrap())?;
        let size_text = ctx.INTEGER().unwrap().get_text();
        let size: usize = size_text.parse().map_err(|_| BuildError {
            message: format!("Invalid array size: {}", size_text),
            location: self.builder.get_location(ctx),
        })?;

        Ok(Type::Array(Box::new(element_type), size))
    }

    /// Visit slice type
    fn visit_slice_type(&mut self, ctx: &SliceTypeContext) -> BuildResult<Type> {
        let element_type = self.visit_type(ctx.type_().as_ref().unwrap())?;
        Ok(Type::Slice(Box::new(element_type)))
    }

    /// Visit reference type
    fn visit_reference_type(&mut self, ctx: &ReferenceTypeContext) -> BuildResult<Type> {
        let target_type = self.visit_type(ctx.type_().as_ref().unwrap())?;
        Ok(Type::Reference(Box::new(target_type)))
    }

    /// Visit mutable reference type
    fn visit_mutable_reference_type(&mut self, ctx: &MutableReferenceTypeContext) -> BuildResult<Type> {
        let target_type = self.visit_type(ctx.type_().as_ref().unwrap())?;
        Ok(Type::MutableReference(Box::new(target_type)))
    }

    /// Visit struct declaration
    fn visit_struct_declaration(&mut self, ctx: &StructDeclarationContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let mut fields = Vec::new();
        if let Some(fields_ctx) = ctx.struct_fields() {
            for field_ctx in fields_ctx.struct_field_all() {
                let field = self.visit_struct_field(field_ctx.as_ref())?;
                fields.push(field);
            }
        }

        Ok(Declaration::Struct {
            name,
            generics: Vec::new(), // TODO: Parse generic parameters
            fields: Some(fields),
            where_clause: None, // TODO: Parse where clause
        })
    }

    /// Visit struct field
    fn visit_struct_field(&mut self, ctx: &StructFieldContext) -> BuildResult<StructField> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let typ = self.visit_type(ctx.type_().as_ref().unwrap())?;

        Ok(StructField {
            name,
            typ,
            public: ctx.PUB_().is_some(),
        })
    }

    /// Visit enum declaration
    fn visit_enum_declaration(&mut self, ctx: &EnumDeclarationContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let mut variants = Vec::new();
        for variant_ctx in ctx.enum_variant_all() {
            let variant = self.visit_enum_variant(variant_ctx.as_ref())?;
            variants.push(variant);
        }

        Ok(Declaration::Enum {
            name,
            generics: Vec::new(), // TODO: Parse generic parameters
            variants,
            where_clause: None, // TODO: Parse where clause
        })
    }

    /// Visit enum variant
    fn visit_enum_variant(&mut self, ctx: &EnumVariantContext) -> BuildResult<EnumVariant> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let fields = if let Some(tuple_ctx) = ctx.tuple_type() {
            let mut types = Vec::new();
            for type_ctx in tuple_ctx.type_all() {
                types.push(self.visit_type(type_ctx.as_ref())?);
            }
            Some(types)
        } else {
            None
        };

        Ok(EnumVariant { name, fields })
    }

    /// Visit trait declaration
    fn visit_trait_declaration(&mut self, ctx: &TraitDeclarationContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let mut items = Vec::new();
        for item_ctx in ctx.trait_item_all() {
            let item = self.visit_trait_item(item_ctx.as_ref())?;
            items.push(item);
        }

        Ok(Declaration::Trait {
            name,
            generics: Vec::new(), // TODO: Parse generic parameters
            items,
            where_clause: None, // TODO: Parse where clause
        })
    }

    /// Visit trait item
    fn visit_trait_item(&mut self, ctx: &TraitItemContext) -> BuildResult<TraitItem> {
        if let Some(fn_ctx) = ctx.function_declaration() {
            let decl = self.visit_function_declaration(fn_ctx.as_ref())?;
            if let Declaration::Function(function) = decl {
                Ok(TraitItem::Function(function))
            } else {
                Err(BuildError {
                    message: "Expected function in trait".to_string(),
                    location: self.builder.get_location(ctx),
                })
            }
        } else {
            Err(BuildError {
                message: "Unsupported trait item".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit impl block
    fn visit_impl_block(&mut self, ctx: &ImplBlockContext) -> BuildResult<Declaration> {
        let trait_type = if let Some(trait_ctx) = ctx.type_path() {
            Some(self.visit_type_path(trait_ctx.as_ref())?)
        } else {
            None
        };

        let impl_type = self.visit_type_path(ctx.type_path().get(1).unwrap().as_ref())?;

        let mut items = Vec::new();
        for item_ctx in ctx.impl_item_all() {
            let item = self.visit_impl_item(item_ctx.as_ref())?;
            items.push(item);
        }

        Ok(Declaration::Impl {
            generics: Vec::new(), // TODO: Parse generic parameters
            trait_type,
            impl_type,
            items,
            where_clause: None, // TODO: Parse where clause
        })
    }

    /// Visit impl item
    fn visit_impl_item(&mut self, ctx: &ImplItemContext) -> BuildResult<ImplItem> {
        if let Some(fn_ctx) = ctx.function_declaration() {
            let decl = self.visit_function_declaration(fn_ctx.as_ref())?;
            if let Declaration::Function(function) = decl {
                Ok(ImplItem::Function(function))
            } else {
                Err(BuildError {
                    message: "Expected function in impl".to_string(),
                    location: self.builder.get_location(ctx),
                })
            }
        } else {
            Err(BuildError {
                message: "Unsupported impl item".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit type alias
    fn visit_type_alias(&mut self, ctx: &TypeAliasContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let target = self.visit_type(ctx.type_().as_ref().unwrap())?;

        Ok(Declaration::TypeAlias(TypeAlias {
            name,
            generics: Vec::new(), // TODO: Parse generic parameters
            target,
            where_clause: None, // TODO: Parse where clause
        }))
    }

    /// Visit const declaration
    fn visit_const_declaration(&mut self, ctx: &ConstDeclarationContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let typ = self.visit_type(ctx.type_().as_ref().unwrap())?;
        let value = self.visit_expression(ctx.expression().as_ref().unwrap())?;

        Ok(Declaration::Constant(Constant {
            name,
            typ,
            value,
        }))
    }

    /// Visit static declaration
    fn visit_static_declaration(&mut self, ctx: &StaticDeclarationContext) -> BuildResult<Declaration> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let typ = self.visit_type(ctx.type_().as_ref().unwrap())?;
        let value = self.visit_expression(ctx.expression().as_ref().unwrap())?;

        Ok(Declaration::Static(StaticVariable {
            name,
            typ,
            mutable: ctx.MUT().is_some(),
            value,
        }))
    }

    /// Visit extern block
    fn visit_extern_block(&mut self, ctx: &ExternBlockContext) -> BuildResult<Declaration> {
        let library_path = ctx.STRING().unwrap().get_text();
        let alias = if let Some(alias_token) = ctx.IDENTIFIER() {
            Some(self.builder.make_ident(alias_token.get_text().as_str(), ctx))
        } else {
            None
        };

        let mut functions = Vec::new();
        for fn_ctx in ctx.extern_function_all() {
            let function = self.visit_extern_function(fn_ctx.as_ref())?;
            functions.push(function);
        }

        Ok(Declaration::Extern(ExternBlock {
            library_path,
            alias,
            functions,
        }))
    }

    /// Visit extern function
    fn visit_extern_function(&mut self, ctx: &ExternFunctionContext) -> BuildResult<ExternFunction> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let mut parameters = Vec::new();
        if let Some(params_ctx) = ctx.parameters() {
            for param_ctx in params_ctx.parameter_all() {
                let param = self.visit_parameter(param_ctx.as_ref())?;
                parameters.push(param);
            }
        }

        let return_type = if let Some(ret_ctx) = ctx.return_type() {
            Some(self.visit_type(ret_ctx.as_ref())?)
        } else {
            None
        };

        Ok(ExternFunction {
            name,
            parameters,
            return_type,
        })
    }

    /// Visit block
    fn visit_block(&mut self, ctx: &BlockContext) -> BuildResult<Vec<Statement>> {
        let mut statements = Vec::new();
        for stmt_ctx in ctx.statement_all() {
            let stmt = self.visit_statement(stmt_ctx.as_ref())?;
            statements.push(stmt);
        }
        Ok(statements)
    }

    /// Visit statement
    fn visit_statement(&mut self, ctx: &StatementContext) -> BuildResult<Statement> {
        if let Some(let_ctx) = ctx.let_statement() {
            self.visit_let_statement(let_ctx.as_ref())
        } else if let Some(expr_ctx) = ctx.expression_statement() {
            let expr = self.visit_expression(expr_ctx.expression().as_ref().unwrap())?;
            Ok(Statement::Expression(expr))
        } else if let Some(if_ctx) = ctx.if_statement() {
            self.visit_if_statement(if_ctx.as_ref())
        } else if let Some(match_ctx) = ctx.match_statement() {
            self.visit_match_statement(match_ctx.as_ref())
        } else if let Some(while_ctx) = ctx.while_statement() {
            self.visit_while_statement(while_ctx.as_ref())
        } else if let Some(for_ctx) = ctx.for_statement() {
            self.visit_for_statement(for_ctx.as_ref())
        } else if let Some(return_ctx) = ctx.return_statement() {
            self.visit_return_statement(return_ctx.as_ref())
        } else {
            Err(BuildError {
                message: "Unknown statement type".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit let statement
    fn visit_let_statement(&mut self, ctx: &LetStatementContext) -> BuildResult<Statement> {
        let pattern = self.visit_pattern(ctx.pattern().as_ref().unwrap())?;
        let typ = if let Some(type_ctx) = ctx.type_() {
            Some(self.visit_type(type_ctx.as_ref())?)
        } else {
            None
        };
        let value = if let Some(expr_ctx) = ctx.expression() {
            Some(self.visit_expression(expr_ctx.as_ref())?)
        } else {
            None
        };

        Ok(Statement::Let {
            pattern,
            typ,
            value,
        })
    }

    /// Visit if statement
    fn visit_if_statement(&mut self, ctx: &IfStatementContext) -> BuildResult<Statement> {
        let condition = self.visit_expression(ctx.expression().as_ref().unwrap())?;
        let then_block = self.visit_block(ctx.block().as_ref().unwrap())?;

        let mut else_ifs = Vec::new();
        for i in 0..ctx.ELSE().len() {
            if i < ctx.expression().len() - 1 && i < ctx.block().len() - 1 {
                let else_if_condition = self.visit_expression(ctx.expression().get(i + 1).unwrap().as_ref())?;
                let else_if_block = self.visit_block(ctx.block().get(i + 1).unwrap().as_ref())?;
                else_ifs.push((else_if_condition, else_if_block));
            }
        }

        let else_block = if ctx.ELSE().len() > 0 && ctx.block().len() > ctx.ELSE().len() {
            Some(self.visit_block(ctx.block().last().unwrap().as_ref())?)
        } else {
            None
        };

        Ok(Statement::If {
            condition,
            then_block,
            else_ifs,
            else_block,
        })
    }

    /// Visit match statement
    fn visit_match_statement(&mut self, ctx: &MatchStatementContext) -> BuildResult<Statement> {
        let expression = self.visit_expression(ctx.expression().as_ref().unwrap())?;

        let mut arms = Vec::new();
        for arm_ctx in ctx.match_arm_all() {
            let arm = self.visit_match_arm(arm_ctx.as_ref())?;
            arms.push(arm);
        }

        Ok(Statement::Match { expression, arms })
    }

    /// Visit match arm
    fn visit_match_arm(&mut self, ctx: &MatchArmContext) -> BuildResult<MatchArm> {
        let pattern = self.visit_pattern(ctx.pattern().as_ref().unwrap())?;
        let body = self.visit_expression(ctx.expression().as_ref().unwrap())?;

        Ok(MatchArm {
            pattern,
            guard: None, // TODO: Parse guard
            body,
        })
    }

    /// Visit while statement
    fn visit_while_statement(&mut self, ctx: &WhileStatementContext) -> BuildResult<Statement> {
        let condition = self.visit_expression(ctx.expression().as_ref().unwrap())?;
        let body = self.visit_block(ctx.block().as_ref().unwrap())?;

        Ok(Statement::While { condition, body })
    }

    /// Visit for statement
    fn visit_for_statement(&mut self, ctx: &ForStatementContext) -> BuildResult<Statement> {
        let pattern = self.visit_pattern(ctx.pattern().as_ref().unwrap())?;
        let iterator = self.visit_expression(ctx.expression().as_ref().unwrap())?;
        let body = self.visit_block(ctx.block().as_ref().unwrap())?;

        Ok(Statement::For {
            pattern,
            iterator,
            body,
        })
    }

    /// Visit return statement
    fn visit_return_statement(&mut self, ctx: &ReturnStatementContext) -> BuildResult<Statement> {
        let expression = if let Some(expr_ctx) = ctx.expression() {
            Some(self.visit_expression(expr_ctx.as_ref())?)
        } else {
            None
        };

        Ok(Statement::Return(expression))
    }

    /// Visit pattern
    fn visit_pattern(&mut self, ctx: &PatternContext) -> BuildResult<Pattern> {
        if let Some(literal_ctx) = ctx.literal_pattern() {
            self.visit_literal_pattern(literal_ctx.as_ref())
        } else if let Some(ident_ctx) = ctx.identifier_pattern() {
            self.visit_identifier_pattern(ident_ctx.as_ref())
        } else if ctx.wildcard_pattern().is_some() {
            Ok(Pattern::Wildcard)
        } else if let Some(struct_ctx) = ctx.struct_pattern() {
            self.visit_struct_pattern(struct_ctx.as_ref())
        } else if let Some(enum_ctx) = ctx.enum_pattern() {
            self.visit_enum_pattern(enum_ctx.as_ref())
        } else if let Some(tuple_ctx) = ctx.tuple_pattern() {
            self.visit_tuple_pattern(tuple_ctx.as_ref())
        } else {
            Err(BuildError {
                message: "Unknown pattern type".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit literal pattern
    fn visit_literal_pattern(&mut self, ctx: &LiteralPatternContext) -> BuildResult<Pattern> {
        let literal = self.visit_literal(ctx.literal().as_ref().unwrap())?;
        Ok(Pattern::Literal(literal))
    }

    /// Visit identifier pattern
    fn visit_identifier_pattern(&mut self, ctx: &IdentifierPatternContext) -> BuildResult<Pattern> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        Ok(Pattern::Identifier {
            name,
            mutable: ctx.MUT().is_some(),
            reference: ctx.REF().is_some(),
            subpattern: None, // TODO: Parse subpattern
        })
    }

    /// Visit struct pattern
    fn visit_struct_pattern(&mut self, ctx: &StructPatternContext) -> BuildResult<Pattern> {
        let typ = self.visit_type_path(ctx.type_path().as_ref().unwrap())?;

        let mut fields = Vec::new();
        for field_ctx in ctx.field_pattern_all() {
            let field = self.visit_field_pattern(field_ctx.as_ref())?;
            fields.push(field);
        }

        Ok(Pattern::Struct { typ, fields })
    }

    /// Visit field pattern
    fn visit_field_pattern(&mut self, ctx: &FieldPatternContext) -> BuildResult<FieldPattern> {
        let name = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let pattern = self.visit_pattern(ctx.pattern().as_ref().unwrap())?;

        Ok(FieldPattern { name, pattern })
    }

    /// Visit enum pattern
    fn visit_enum_pattern(&mut self, ctx: &EnumPatternContext) -> BuildResult<Pattern> {
        let typ = self.visit_type_path(ctx.type_path().as_ref().unwrap())?;
        let variant = self.builder.make_ident(
            ctx.IDENTIFIER().unwrap().get_text().as_str(),
            ctx
        );

        let fields = if let Some(patterns_ctx) = ctx.patterns() {
            let mut patterns = Vec::new();
            for pattern_ctx in patterns_ctx.pattern_all() {
                patterns.push(self.visit_pattern(pattern_ctx.as_ref())?);
            }
            Some(patterns)
        } else {
            None
        };

        Ok(Pattern::Enum { typ, variant, fields })
    }

    /// Visit tuple pattern
    fn visit_tuple_pattern(&mut self, ctx: &TuplePatternContext) -> BuildResult<Pattern> {
        let mut patterns = Vec::new();
        for pattern_ctx in ctx.pattern_all() {
            patterns.push(self.visit_pattern(pattern_ctx.as_ref())?);
        }

        Ok(Pattern::Tuple(patterns))
    }

    /// Visit literal
    fn visit_literal(&mut self, ctx: &LiteralContext) -> BuildResult<Literal> {
        if let Some(int_token) = ctx.INTEGER() {
            Ok(Literal::Integer(int_token.get_text()))
        } else if let Some(float_token) = ctx.FLOAT() {
            Ok(Literal::Float(float_token.get_text()))
        } else if let Some(string_token) = ctx.STRING() {
            Ok(Literal::String(string_token.get_text()))
        } else if let Some(char_token) = ctx.CHAR() {
            Ok(Literal::Char(char_token.get_text().chars().next().unwrap()))
        } else if ctx.TRUE().is_some() {
            Ok(Literal::Bool(true))
        } else if ctx.FALSE().is_some() {
            Ok(Literal::Bool(false))
        } else {
            Err(BuildError {
                message: "Unknown literal".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit expression
    fn visit_expression(&mut self, ctx: &ExpressionContext) -> BuildResult<Expression> {
        if let Some(literal_ctx) = ctx.literal_expression() {
            let literal = self.visit_literal(literal_ctx.literal().as_ref().unwrap())?;
            Ok(Expression::Literal(literal))
        } else if let Some(var_ctx) = ctx.path_expression() {
            if let Some(path_ctx) = var_ctx.type_path() {
                let typ = self.visit_type_path(path_ctx.as_ref())?;
                if let Type::Path { name, .. } = typ {
                    Ok(Expression::Variable(name))
                } else {
                    Err(BuildError {
                        message: "Expected variable path".to_string(),
                        location: self.builder.get_location(ctx),
                    })
                }
            } else {
                Err(BuildError {
                    message: "Expected variable".to_string(),
                    location: self.builder.get_location(ctx),
                })
            }
        } else if let Some(call_ctx) = ctx.call_expression() {
            self.visit_call_expression(call_ctx.as_ref())
        } else if let Some(binary_ctx) = ctx.binary_expression() {
            self.visit_binary_expression(binary_ctx.as_ref())
        } else if let Some(grouped_ctx) = ctx.grouped_expression() {
            self.visit_expression(grouped_ctx.expression().as_ref().unwrap())
        } else {
            Err(BuildError {
                message: "Unsupported expression type".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Visit call expression
    fn visit_call_expression(&mut self, ctx: &CallExpressionContext) -> BuildResult<Expression> {
        let function = Box::new(self.visit_expression(ctx.expression().as_ref().unwrap())?);

        let mut args = Vec::new();
        if let Some(args_ctx) = ctx.arguments() {
            for arg_ctx in args_ctx.expression_all() {
                args.push(self.visit_expression(arg_ctx.as_ref())?);
            }
        }

        Ok(Expression::Call { function, args })
    }

    /// Visit binary expression
    fn visit_binary_expression(&mut self, ctx: &BinaryExpressionContext) -> BuildResult<Expression> {
        let left = Box::new(self.visit_expression(ctx.expression().get(0).unwrap().as_ref())?);
        let right = Box::new(self.visit_expression(ctx.expression().get(1).unwrap().as_ref())?);

        let op = self.visit_operator(ctx.operator().as_ref().unwrap())?;

        Ok(Expression::Binary { left, op, right })
    }

    /// Visit operator
    fn visit_operator(&mut self, ctx: &OperatorContext) -> BuildResult<BinaryOp> {
        if ctx.PLUS().is_some() { Ok(BinaryOp::Add) }
        else if ctx.MINUS().is_some() { Ok(BinaryOp::Sub) }
        else if ctx.STAR().is_some() { Ok(BinaryOp::Mul) }
        else if ctx.SLASH().is_some() { Ok(BinaryOp::Div) }
        else if ctx.PERCENT().is_some() { Ok(BinaryOp::Mod) }
        else if ctx.EQ().is_some() { Ok(BinaryOp::Eq) }
        else if ctx.NE().is_some() { Ok(BinaryOp::Ne) }
        else if ctx.LT().is_some() { Ok(BinaryOp::Lt) }
        else if ctx.GT().is_some() { Ok(BinaryOp::Gt) }
        else if ctx.LE().is_some() { Ok(BinaryOp::Le) }
        else if ctx.GE().is_some() { Ok(BinaryOp::Ge) }
        else if ctx.ANDAND().is_some() { Ok(BinaryOp::And) }
        else if ctx.OROR().is_some() { Ok(BinaryOp::Or) }
        else {
            Err(BuildError {
                message: "Unknown operator".to_string(),
                location: self.builder.get_location(ctx),
            })
        }
    }

    /// Get build errors
    pub fn errors(&self) -> &[BuildError] {
        &self.builder.errors
    }

    /// Check if there were any build errors
    pub fn has_errors(&self) -> bool {
        !self.builder.errors.is_empty()
    }
}