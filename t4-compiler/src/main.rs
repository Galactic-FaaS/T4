use clap::{Arg, Command};
use std::fs;
use std::process;

mod compiler;
mod codegen;

use compiler::T4Compiler;
use codegen::CodeGenerator;

fn main() {
   let matches = Command::new("T4 Compiler")
       .version("0.1.0")
       .author("T4 Compiler Team")
       .about("Compiles T4 programming language to secure binaries")
       .arg(Arg::new("input")
           .help("Input T4 source file")
           .required(true)
           .index(1))
       .arg(Arg::new("output")
           .short('o')
           .long("output")
           .help("Output file")
           .required(false))
       .arg(Arg::new("verbose")
           .short('v')
           .long("verbose")
           .help("Enable verbose output")
           .action(clap::ArgAction::SetTrue))
       .get_matches();

   let input_file = matches.get_one::<String>("input").unwrap();
   let output_file = matches.get_one::<String>("output").map(|s| s.as_str());
   let verbose = matches.get_flag("verbose");

   if verbose {
       println!("T4 Compiler v0.1.0");
       println!("Input file: {}", input_file);
       if let Some(output) = output_file {
           println!("Output file: {}", output);
       }
   }

   // Compile the T4 program
   match compile_t4_program(input_file, output_file, verbose) {
       Ok(()) => {
           if verbose {
               println!("Compilation successful!");
           }
           process::exit(0);
       }
       Err(e) => {
           eprintln!("Compilation failed: {}", e);
           if verbose {
               eprintln!("Error details: {}", e);
           }
           process::exit(1);
       }
   }
}

fn compile_t4_program(input_file: &str, output_file: Option<&str>, verbose: bool) -> Result<(), String> {
   // Read the source file
   let source = fs::read_to_string(input_file)
       .map_err(|e| format!("Failed to read input file '{}': {}", input_file, e))?;

   if verbose {
       println!("Read {} bytes from {}", source.len(), input_file);
   }

   // Create compiler instance
   let mut compiler = T4Compiler::new();

   // Parse the source code
   if verbose {
       println!("Parsing T4 source code...");
   }

   let program = compiler.parse(&source)
       .map_err(|e| format!("Parse error: {}", e))?;

   if verbose {
       println!("Successfully parsed {} declarations", program.declarations.len());
   }

   // Type check the program
   if verbose {
       println!("Type checking...");
   }

   compiler.type_check(&program)
       .map_err(|e| format!("Type check error: {}", e))?;

   if verbose {
       println!("Type checking passed");
   }

   // Generate code
   if verbose {
       println!("Generating code...");
   }

   let mut codegen = CodeGenerator::new();
   let output = codegen.generate(&program, output_file.unwrap_or("output"))
       .map_err(|e| format!("Code generation error: {}", e))?;

   if verbose {
       println!("Generated {} bytes of output", output.len());
   }

   // Write output file if specified
   if let Some(output_path) = output_file {
       fs::write(output_path, &output)
           .map_err(|e| format!("Failed to write output file '{}': {}", output_path, e))?;

       if verbose {
           println!("Output written to {}", output_path);
       }
   } else {
       // Print to stdout
       println!("{}", String::from_utf8_lossy(&output));
   }

   Ok(())
}
