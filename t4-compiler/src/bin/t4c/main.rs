//! T4 Compiler (t4c)
//!
//! The main compiler binary for the T4 programming language with comprehensive
//! command-line interface and multiple output formats.

use clap::{Parser, Subcommand, ValueEnum};
use std::path::PathBuf;
use t4_compiler::*;

mod compiler;
mod config;
mod error;
mod output;

use compiler::Compiler;
use config::Config;
use error::T4cError;
use output::{OutputFormat, OutputManager};

/// T4 Programming Language Compiler
#[derive(Parser)]
#[command(name = "t4c")]
#[command(about = "The T4 Programming Language Compiler")]
#[command(version, long_about = None)]
struct Cli {
    #[command(subcommand)]
    command: Commands,

    /// Increase verbosity (can be used multiple times: -v, -vv, -vvv)
    #[arg(short, long, action = clap::ArgAction::Count)]
    verbose: u8,

    /// Suppress all output except errors
    #[arg(short, long)]
    quiet: bool,

    /// Configuration file to use
    #[arg(short, long, value_name = "FILE")]
    config: Option<PathBuf>,

    /// Target triple for cross-compilation
    #[arg(long, value_name = "TRIPLE")]
    target: Option<String>,

    /// Number of parallel jobs to run
    #[arg(short = 'j', long, default_value = "1")]
    jobs: usize,
}

#[derive(Subcommand)]
enum Commands {
    /// Build the project
    Build {
        /// Input source files
        #[arg(value_name = "FILES")]
        files: Vec<PathBuf>,

        /// Output file or directory
        #[arg(short, long, value_name = "PATH")]
        output: Option<PathBuf>,

        /// Output format
        #[arg(short = 'f', long, default_value = "binary")]
        format: OutputFormat,

        /// Optimization level (0-3)
        #[arg(short = 'O', default_value = "2")]
        opt_level: u8,

        /// Enable debug information
        #[arg(short = 'g')]
        debug: bool,

        /// Enable Link-Time Optimization
        #[arg(long)]
        lto: bool,

        /// Additional include paths
        #[arg(short = 'I', value_name = "DIR")]
        include: Vec<PathBuf>,

        /// Library search paths
        #[arg(short = 'L', value_name = "DIR")]
        library_paths: Vec<PathBuf>,

        /// Libraries to link against
        #[arg(short = 'l', value_name = "LIB")]
        libraries: Vec<String>,

        /// Define a preprocessor symbol
        #[arg(short = 'D', value_name = "SYMBOL")]
        defines: Vec<String>,

        /// Enable security hardening
        #[arg(long)]
        security_hardening: bool,

        /// Enable cryptographic verification
        #[arg(long)]
        crypto_verify: bool,

        /// Enable post-quantum cryptography
        #[arg(long)]
        post_quantum: bool,

        /// Custom crypto provider
        #[arg(long, value_name = "PROVIDER")]
        crypto_provider: Option<String>,
    },

    /// Check the project for errors without building
    Check {
        /// Input source files
        #[arg(value_name = "FILES")]
        files: Vec<PathBuf>,

        /// Additional include paths
        #[arg(short = 'I', value_name = "DIR")]
        include: Vec<PathBuf>,

        /// Define a preprocessor symbol
        #[arg(short = 'D', value_name = "SYMBOL")]
        defines: Vec<String>,

        /// Enable security analysis
        #[arg(long)]
        security_analysis: bool,

        /// Enable cryptographic analysis
        #[arg(long)]
        crypto_analysis: bool,
    },

    /// Run the compiled program
    Run {
        /// Input source file
        #[arg(value_name = "FILE")]
        file: PathBuf,

        /// Arguments to pass to the program
        #[arg(last = true)]
        args: Vec<String>,

        /// Optimization level (0-3)
        #[arg(short = 'O', default_value = "2")]
        opt_level: u8,

        /// Enable debug information
        #[arg(short = 'g')]
        debug: bool,

        /// Additional include paths
        #[arg(short = 'I', value_name = "DIR")]
        include: Vec<PathBuf>,

        /// Define a preprocessor symbol
        #[arg(short = 'D', value_name = "SYMBOL")]
        defines: Vec<String>,
    },

    /// Generate documentation
    Doc {
        /// Input source files
        #[arg(value_name = "FILES")]
        files: Vec<PathBuf>,

        /// Output directory
        #[arg(short, long, value_name = "DIR")]
        output: Option<PathBuf>,

        /// Documentation format
        #[arg(short = 'f', long, default_value = "html")]
        format: DocFormat,

        /// Include private items
        #[arg(long)]
        private: bool,

        /// Include security annotations
        #[arg(long)]
        security_docs: bool,

        /// Include cryptographic details
        #[arg(long)]
        crypto_docs: bool,
    },

    /// Initialize a new T4 project
    Init {
        /// Project name
        #[arg(value_name = "NAME")]
        name: String,

        /// Project type
        #[arg(short, long, default_value = "binary")]
        project_type: ProjectType,

        /// Directory to create project in
        #[arg(short, long, value_name = "DIR")]
        directory: Option<PathBuf>,

        /// Initialize git repository
        #[arg(long)]
        git: bool,

        /// Include security template
        #[arg(long)]
        security_template: bool,

        /// Include cryptographic examples
        #[arg(long)]
        crypto_examples: bool,
    },

    /// Clean build artifacts
    Clean {
        /// Also clean documentation
        #[arg(long)]
        doc: bool,

        /// Also clean dependencies
        #[arg(long)]
        deps: bool,

        /// Target directory to clean
        #[arg(short, long, value_name = "DIR")]
        target: Option<PathBuf>,
    },

    /// Show compiler version and information
    Version {
        /// Show detailed version information
        #[arg(long)]
        detailed: bool,

        /// Show supported targets
        #[arg(long)]
        targets: bool,

        /// Show supported cryptographic algorithms
        #[arg(long)]
        crypto: bool,
    },

    /// Update compiler and tools
    Update {
        /// Update to specific version
        #[arg(long, value_name = "VERSION")]
        version: Option<String>,

        /// Force update even if already up to date
        #[arg(long)]
        force: bool,

        /// Check for updates without installing
        #[arg(long)]
        check: bool,
    },
}

#[derive(Clone, ValueEnum)]
enum DocFormat {
    Html,
    Markdown,
    Json,
    Pdf,
}

#[derive(Clone, ValueEnum)]
enum ProjectType {
    Binary,
    Library,
    Staticlib,
    Cdylib,
}

#[tokio::main]
async fn main() -> Result<(), T4cError> {
    let cli = Cli::parse();

    // Initialize logging based on verbosity
    init_logging(cli.verbose, cli.quiet);

    // Load configuration
    let config = Config::load(cli.config.as_deref())?;

    match cli.command {
        Commands::Build {
            files,
            output,
            format,
            opt_level,
            debug,
            lto,
            include,
            library_paths,
            libraries,
            defines,
            security_hardening,
            crypto_verify,
            post_quantum,
            crypto_provider,
        } => {
            let mut compiler = Compiler::new(config);

            // Set compilation options
            compiler.set_optimization_level(opt_level);
            compiler.set_debug_info(debug);
            compiler.set_lto(lto);
            compiler.set_security_hardening(security_hardening);
            compiler.set_crypto_verify(crypto_verify);
            compiler.set_post_quantum(post_quantum);
            if let Some(provider) = crypto_provider {
                compiler.set_crypto_provider(provider);
            }

            // Add include paths and defines
            for path in include {
                compiler.add_include_path(path);
            }
            for define in defines {
                compiler.add_define(define);
            }

            // Add library search paths and libraries
            for path in library_paths {
                compiler.add_library_path(path);
            }
            for library in libraries {
                compiler.add_library(library);
            }

            // Compile files
            let output_manager = OutputManager::new(format, output, cli.target);
            compiler.compile_files(files, output_manager).await?;
        }

        Commands::Check {
            files,
            include,
            defines,
            security_analysis,
            crypto_analysis,
        } => {
            let mut compiler = Compiler::new(config);

            // Add include paths and defines
            for path in include {
                compiler.add_include_path(path);
            }
            for define in defines {
                compiler.add_define(define);
            }

            compiler.set_security_analysis(security_analysis);
            compiler.set_crypto_analysis(crypto_analysis);

            compiler.check_files(files).await?;
        }

        Commands::Run {
            file,
            args,
            opt_level,
            debug,
            include,
            defines,
        } => {
            let mut compiler = Compiler::new(config);

            compiler.set_optimization_level(opt_level);
            compiler.set_debug_info(debug);

            for path in include {
                compiler.add_include_path(path);
            }
            for define in defines {
                compiler.add_define(define);
            }

            compiler.run_file(file, args).await?;
        }

        Commands::Doc {
            files,
            output,
            format,
            private,
            security_docs,
            crypto_docs,
        } => {
            let mut compiler = Compiler::new(config);

            compiler.set_include_private(private);
            compiler.set_security_docs(security_docs);
            compiler.set_crypto_docs(crypto_docs);

            compiler.generate_docs(files, output, format).await?;
        }

        Commands::Init {
            name,
            project_type,
            directory,
            git,
            security_template,
            crypto_examples,
        } => {
            let project_dir = directory.unwrap_or_else(|| PathBuf::from(&name));
            Compiler::init_project(name, project_type, project_dir, git, security_template, crypto_examples)?;
        }

        Commands::Clean { doc, deps, target } => {
            Compiler::clean_build(target, doc, deps)?;
        }

        Commands::Version { detailed, targets, crypto } => {
            Compiler::show_version(detailed, targets, crypto);
        }

        Commands::Update { version, force, check } => {
            Compiler::update_compiler(version, force, check).await?;
        }
    }

    Ok(())
}

fn init_logging(verbosity: u8, quiet: bool) {
    use env_logger::{Builder, Target};
    use log::LevelFilter;

    let mut builder = Builder::from_default_env();

    let level = match (quiet, verbosity) {
        (true, _) => LevelFilter::Error,
        (false, 0) => LevelFilter::Warn,
        (false, 1) => LevelFilter::Info,
        (false, 2) => LevelFilter::Debug,
        (false, _) => LevelFilter::Trace,
    };

    builder
        .filter_level(level)
        .target(Target::Stderr)
        .init();
}