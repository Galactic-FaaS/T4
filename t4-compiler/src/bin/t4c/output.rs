//! Output generation and management for T4 Compiler
//!
//! Handles various output formats including binary, library, AST, LLVM IR, and assembly.

use crate::ast::Program;
use super::error::{T4cError, Result};
use std::path::{Path, PathBuf};
use std::fs;
use tokio::io::AsyncWriteExt;

#[derive(Debug, Clone, PartialEq)]
pub enum OutputFormat {
    Binary,
    Library,
    StaticLibrary,
    SharedLibrary,
    Ast,
    LlvmIr,
    Assembly,
    Object,
    Json,
    Debug,
}

impl std::str::FromStr for OutputFormat {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s.to_lowercase().as_str() {
            "binary" | "bin" | "exe" => Ok(OutputFormat::Binary),
            "library" | "lib" | "rlib" => Ok(OutputFormat::Library),
            "staticlib" | "static" | "a" => Ok(OutputFormat::StaticLibrary),
            "sharedlib" | "shared" | "so" | "dll" | "dylib" => Ok(OutputFormat::SharedLibrary),
            "ast" => Ok(OutputFormat::Ast),
            "llvm" | "llvm-ir" | "ll" => Ok(OutputFormat::LlvmIr),
            "asm" | "assembly" | "s" => Ok(OutputFormat::Assembly),
            "object" | "obj" | "o" => Ok(OutputFormat::Object),
            "json" => Ok(OutputFormat::Json),
            "debug" | "dbg" => Ok(OutputFormat::Debug),
            _ => Err(format!("Unknown output format: {}", s)),
        }
    }
}

impl std::fmt::Display for OutputFormat {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            OutputFormat::Binary => write!(f, "binary"),
            OutputFormat::Library => write!(f, "library"),
            OutputFormat::StaticLibrary => write!(f, "static-library"),
            OutputFormat::SharedLibrary => write!(f, "shared-library"),
            OutputFormat::Ast => write!(f, "ast"),
            OutputFormat::LlvmIr => write!(f, "llvm-ir"),
            OutputFormat::Assembly => write!(f, "assembly"),
            OutputFormat::Object => write!(f, "object"),
            OutputFormat::Json => write!(f, "json"),
            OutputFormat::Debug => write!(f, "debug"),
        }
    }
}

pub struct OutputManager {
    format: OutputFormat,
    output_path: Option<PathBuf>,
    target: Option<String>,
    compression: bool,
    debug_info: bool,
    strip_debug: bool,
    generate_map: bool,
}

impl OutputManager {
    pub fn new(format: OutputFormat, output_path: Option<PathBuf>, target: Option<String>) -> Self {
        Self {
            format,
            output_path,
            target,
            compression: false,
            debug_info: false,
            strip_debug: false,
            generate_map: false,
        }
    }

    pub fn with_compression(mut self, compression: bool) -> Self {
        self.compression = compression;
        self
    }

    pub fn with_debug_info(mut self, debug_info: bool) -> Self {
        self.debug_info = debug_info;
        self
    }

    pub fn with_strip_debug(mut self, strip_debug: bool) -> Self {
        self.strip_debug = strip_debug;
        self
    }

    pub fn with_map_generation(mut self, generate_map: bool) -> Self {
        self.generate_map = generate_map;
        self
    }

    pub async fn write_output(&self, program: &Program) -> Result<()> {
        let output_path = self.get_output_path();

        match self.format {
            OutputFormat::Binary => self.write_binary(program, &output_path).await?,
            OutputFormat::Library => self.write_library(program, &output_path).await?,
            OutputFormat::StaticLibrary => self.write_static_library(program, &output_path).await?,
            OutputFormat::SharedLibrary => self.write_shared_library(program, &output_path).await?,
            OutputFormat::Ast => self.write_ast(program, &output_path).await?,
            OutputFormat::LlvmIr => self.write_llvm_ir(program, &output_path).await?,
            OutputFormat::Assembly => self.write_assembly(program, &output_path).await?,
            OutputFormat::Object => self.write_object(program, &output_path).await?,
            OutputFormat::Json => self.write_json(program, &output_path).await?,
            OutputFormat::Debug => self.write_debug(program, &output_path).await?,
        }

        log::info!("Output written to: {}", output_path.display());
        Ok(())
    }

    fn get_output_path(&self) -> PathBuf {
        if let Some(path) = &self.output_path {
            path.clone()
        } else {
            match self.format {
                OutputFormat::Binary => PathBuf::from("target/t4c"),
                OutputFormat::Library => PathBuf::from("target/libt4c.rlib"),
                OutputFormat::StaticLibrary => PathBuf::from("target/libt4c.a"),
                OutputFormat::SharedLibrary => {
                    if cfg!(target_os = "windows") {
                        PathBuf::from("target/t4c.dll")
                    } else if cfg!(target_os = "macos") {
                        PathBuf::from("target/libt4c.dylib")
                    } else {
                        PathBuf::from("target/libt4c.so")
                    }
                }
                OutputFormat::Ast => PathBuf::from("target/program.ast"),
                OutputFormat::LlvmIr => PathBuf::from("target/program.ll"),
                OutputFormat::Assembly => PathBuf::from("target/program.s"),
                OutputFormat::Object => PathBuf::from("target/program.o"),
                OutputFormat::Json => PathBuf::from("target/program.json"),
                OutputFormat::Debug => PathBuf::from("target/program.dbg"),
            }
        }
    }

    async fn write_binary(&self, _program: &Program, path: &Path) -> Result<()> {
        // Create target directory
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement actual binary generation
        // For now, create a placeholder binary
        let binary_content = self.generate_placeholder_binary();

        let mut file = tokio::fs::File::create(path).await?;
        file.write_all(&binary_content).await?;

        if self.strip_debug {
            self.strip_binary_debug(path).await?;
        }

        Ok(())
    }

    async fn write_library(&self, _program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement library generation
        let library_content = self.generate_placeholder_library();

        let mut file = tokio::fs::File::create(path).await?;
        file.write_all(&library_content).await?;

        Ok(())
    }

    async fn write_static_library(&self, _program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement static library generation
        let archive_content = self.generate_placeholder_archive();

        let mut file = tokio::fs::File::create(path).await?;
        file.write_all(&archive_content).await?;

        Ok(())
    }

    async fn write_shared_library(&self, _program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement shared library generation
        let shared_lib_content = self.generate_placeholder_shared_library();

        let mut file = tokio::fs::File::create(path).await?;
        file.write_all(&shared_lib_content).await?;

        Ok(())
    }

    async fn write_ast(&self, program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        let ast_content = format!("{:#?}", program);
        tokio::fs::write(path, ast_content).await?;
        Ok(())
    }

    async fn write_llvm_ir(&self, _program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement LLVM IR generation
        let llvm_ir = self.generate_placeholder_llvm_ir();
        tokio::fs::write(path, llvm_ir).await?;
        Ok(())
    }

    async fn write_assembly(&self, _program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement assembly generation
        let assembly = self.generate_placeholder_assembly();
        tokio::fs::write(path, assembly).await?;
        Ok(())
    }

    async fn write_object(&self, _program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement object file generation
        let object_content = self.generate_placeholder_object();
        let mut file = tokio::fs::File::create(path).await?;
        file.write_all(&object_content).await?;
        Ok(())
    }

    async fn write_json(&self, program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        let json_content = serde_json::to_string_pretty(program)?;
        tokio::fs::write(path, json_content).await?;
        Ok(())
    }

    async fn write_debug(&self, _program: &Program, path: &Path) -> Result<()> {
        if let Some(parent) = path.parent() {
            fs::create_dir_all(parent)?;
        }

        // TODO: Implement debug info generation
        let debug_content = self.generate_placeholder_debug_info();
        tokio::fs::write(path, debug_content).await?;
        Ok(())
    }

    async fn strip_binary_debug(&self, _path: &Path) -> Result<()> {
        // TODO: Implement debug stripping
        Ok(())
    }

    fn generate_placeholder_binary(&self) -> Vec<u8> {
        // Placeholder ELF/PE/COFF header + T4 bytecode
        let mut binary = Vec::new();

        // Magic number for T4 binary
        binary.extend_from_slice(b"T4BIN");

        // Version
        binary.extend_from_slice(&[0u8, 1, 0, 0]);

        // Placeholder content
        binary.extend_from_slice(b"T4 compiled binary placeholder");

        binary
    }

    fn generate_placeholder_library(&self) -> Vec<u8> {
        let mut library = Vec::new();
        library.extend_from_slice(b"T4LIB");
        library.extend_from_slice(&[0u8, 1, 0, 0]);
        library.extend_from_slice(b"T4 library placeholder");
        library
    }

    fn generate_placeholder_archive(&self) -> Vec<u8> {
        let mut archive = Vec::new();
        archive.extend_from_slice(b"T4ARCH");
        archive.extend_from_slice(&[0u8, 1, 0, 0]);
        archive.extend_from_slice(b"T4 static archive placeholder");
        archive
    }

    fn generate_placeholder_shared_library(&self) -> Vec<u8> {
        let mut shared_lib = Vec::new();
        shared_lib.extend_from_slice(b"T4SHLIB");
        shared_lib.extend_from_slice(&[0u8, 1, 0, 0]);
        shared_lib.extend_from_slice(b"T4 shared library placeholder");
        shared_lib
    }

    fn generate_placeholder_llvm_ir(&self) -> String {
        r#"; T4 Compiled LLVM IR
; Target: t4-unknown-unknown
; Optimization level: 2

define i32 @main() {
entry:
  ret i32 0
}

; Placeholder LLVM IR
"#.to_string()
    }

    fn generate_placeholder_assembly(&self) -> String {
        r#"; T4 Compiled Assembly
; Target: t4-unknown-unknown
; Optimization level: 2

.global main
.text
main:
    mov $0, %eax
    ret

; Placeholder assembly
"#.to_string()
    }

    fn generate_placeholder_object(&self) -> Vec<u8> {
        let mut object = Vec::new();
        object.extend_from_slice(b"T4OBJ");
        object.extend_from_slice(&[0u8, 1, 0, 0]);
        object.extend_from_slice(b"T4 object file placeholder");
        object
    }

    fn generate_placeholder_debug_info(&self) -> String {
        r#"T4 Debug Information
====================

Source files: 0
Functions: 0
Variables: 0
Types: 0

Debug info placeholder
"#.to_string()
    }
}