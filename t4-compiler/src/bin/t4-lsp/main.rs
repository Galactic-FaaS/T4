//! T4 Language Server (t4-lsp)
//!
//! Language Server Protocol implementation for T4 programming language.
//! Provides IDE integration with syntax highlighting, error diagnostics,
//! auto-completion, and other development features.

use clap::Parser;
use lsp_server::{Connection, ExtractError, Message, Notification, Request, RequestId, Response};
use lsp_types::*;
use serde_json::Value;
use std::collections::HashMap;
use std::path::PathBuf;
use t4_compiler::*;

mod server;
mod diagnostics;
mod completion;
mod hover;
mod goto;
mod formatting;
mod workspace;

use server::T4LanguageServer;
use diagnostics::DiagnosticsManager;
use completion::CompletionProvider;
use hover::HoverProvider;
use goto::GotoProvider;
use formatting::FormattingProvider;
use workspace::WorkspaceManager;

#[derive(Parser)]
#[command(name = "t4-lsp")]
#[command(about = "T4 Language Server Protocol implementation")]
#[command(version)]
struct Cli {
    /// TCP port to listen on (for TCP transport)
    #[arg(long)]
    port: Option<u16>,

    /// Use TCP transport instead of stdio
    #[arg(long)]
    tcp: bool,

    /// Log file path
    #[arg(short, long, value_name = "FILE")]
    log: Option<PathBuf>,

    /// Enable verbose logging
    #[arg(short, long)]
    verbose: bool,

    /// Configuration file
    #[arg(short, long, value_name = "FILE")]
    config: Option<PathBuf>,
}

fn main() -> anyhow::Result<()> {
    let cli = Cli::parse();

    // Initialize logging
    init_logging(cli.verbose, cli.log)?;

    log::info!("Starting T4 Language Server");

    // Create language server
    let mut server = T4LanguageServer::new()?;

    // Start the server loop
    if let Some(port) = cli.port {
        server.run_tcp(port)
    } else {
        server.run_stdio()
    }
}

fn init_logging(verbose: bool, log_file: Option<PathBuf>) -> anyhow::Result<()> {
    use env_logger::{Builder, Target};
    use log::LevelFilter;
    use std::fs::OpenOptions;

    let mut builder = Builder::from_default_env();

    let level = if verbose { LevelFilter::Debug } else { LevelFilter::Info };

    if let Some(log_file) = log_file {
        let log_file = OpenOptions::new()
            .create(true)
            .append(true)
            .open(log_file)?;

        builder
            .target(Target::Writer(Box::new(log_file)))
            .filter_level(level)
            .init();
    } else {
        builder
            .filter_level(level)
            .init();
    }

    Ok(())
}

mod server {
    use super::*;
    use std::io::{self, Read, Write};
    use std::net::{TcpListener, TcpStream};
    use std::sync::{Arc, Mutex};
    use std::thread;

    pub struct T4LanguageServer {
        connection: Option<Connection>,
        workspace: WorkspaceManager,
        diagnostics: DiagnosticsManager,
        completion: CompletionProvider,
        hover: HoverProvider,
        goto: GotoProvider,
        formatting: FormattingProvider,
        documents: HashMap<Url, String>,
        config: Option<PathBuf>,
    }

    impl T4LanguageServer {
        pub fn new() -> anyhow::Result<Self> {
            Ok(Self {
                connection: None,
                workspace: WorkspaceManager::new(),
                diagnostics: DiagnosticsManager::new(),
                completion: CompletionProvider::new(),
                hover: HoverProvider::new(),
                goto: GotoProvider::new(),
                formatting: FormattingProvider::new(),
                documents: HashMap::new(),
                config: None,
            })
        }

        pub fn run_stdio(mut self) -> anyhow::Result<()> {
            let (connection, io_threads) = Connection::stdio();

            self.connection = Some(connection);
            let connection = self.connection.as_ref().unwrap();

            // Run the main server loop
            self.main_loop(connection)?;

            // Wait for IO threads to finish
            io_threads.join()?;

            Ok(())
        }

        pub fn run_tcp(mut self, port: u16) -> anyhow::Result<()> {
            let listener = TcpListener::bind(format!("127.0.0.1:{}", port))?;
            log::info!("Listening for TCP connections on port {}", port);

            for stream in listener.incoming() {
                match stream {
                    Ok(stream) => {
                        log::info!("New TCP connection established");
                        if let Err(e) = self.handle_tcp_connection(stream) {
                            log::error!("TCP connection error: {}", e);
                        }
                    }
                    Err(e) => log::error!("Connection failed: {}", e),
                }
            }

            Ok(())
        }

        fn handle_tcp_connection(&mut self, mut stream: TcpStream) -> anyhow::Result<()> {
            // For simplicity, we'll use a basic JSON-RPC implementation over TCP
            // In a production system, you'd want to use proper async handling
            let mut buffer = String::new();
            stream.read_to_string(&mut buffer)?;

            if let Ok(message) = serde_json::from_str::<Message>(&buffer) {
                self.handle_message(message)?;
            }

            Ok(())
        }

        fn main_loop(&mut self, connection: &Connection) -> anyhow::Result<()> {
            loop {
                match connection.receiver.recv()? {
                    Message::Request(request) => {
                        self.handle_request(connection, request)?;
                    }
                    Message::Notification(notification) => {
                        self.handle_notification(connection, notification)?;
                    }
                    Message::Response(_) => {
                        // We don't expect responses as we don't send requests
                    }
                }
            }
        }

        fn handle_request(&mut self, connection: &Connection, request: Request) -> anyhow::Result<()> {
            let response = match request.method.as_str() {
                "initialize" => self.handle_initialize(request.id, request.params)?,
                "shutdown" => self.handle_shutdown(request.id)?,
                "textDocument/completion" => self.handle_completion(request.id, request.params)?,
                "textDocument/hover" => self.handle_hover(request.id, request.params)?,
                "textDocument/definition" => self.handle_goto_definition(request.id, request.params)?,
                "textDocument/references" => self.handle_find_references(request.id, request.params)?,
                "textDocument/documentSymbol" => self.handle_document_symbols(request.id, request.params)?,
                "textDocument/formatting" => self.handle_format_document(request.id, request.params)?,
                "textDocument/rangeFormatting" => self.handle_format_range(request.id, request.params)?,
                "workspace/symbol" => self.handle_workspace_symbols(request.id, request.params)?,
                _ => {
                    log::warn!("Unknown request method: {}", request.method);
                    self.create_error_response(request.id, ErrorCode::MethodNotFound, "Method not found".to_string())
                }
            };

            connection.sender.send(Message::Response(response))?;
            Ok(())
        }

        fn handle_notification(&mut self, _connection: &Connection, notification: Notification) -> anyhow::Result<()> {
            match notification.method.as_str() {
                "textDocument/didOpen" => {
                    self.handle_did_open_text_document(notification.params)?;
                }
                "textDocument/didChange" => {
                    self.handle_did_change_text_document(notification.params)?;
                }
                "textDocument/didClose" => {
                    self.handle_did_close_text_document(notification.params)?;
                }
                "textDocument/didSave" => {
                    self.handle_did_save_text_document(notification.params)?;
                }
                "workspace/didChangeConfiguration" => {
                    self.handle_did_change_configuration(notification.params)?;
                }
                _ => {
                    log::debug!("Unhandled notification: {}", notification.method);
                }
            }

            Ok(())
        }

        fn handle_initialize(&mut self, id: RequestId, _params: Value) -> Response {
            let capabilities = ServerCapabilities {
                text_document_sync: Some(TextDocumentSyncCapability::Kind(TextDocumentSyncKind::FULL)),
                completion_provider: Some(CompletionOptions {
                    resolve_provider: Some(true),
                    trigger_characters: Some(vec![".".to_string(), "::".to_string()]),
                    ..Default::default()
                }),
                hover_provider: Some(HoverProviderCapability::Simple(true)),
                definition_provider: Some(OneOf::Left(true)),
                references_provider: Some(OneOf::Left(true)),
                document_symbol_provider: Some(OneOf::Left(true)),
                document_formatting_provider: Some(OneOf::Left(true)),
                document_range_formatting_provider: Some(OneOf::Left(true)),
                workspace_symbol_provider: Some(OneOf::Left(true)),
                ..Default::default()
            };

            let result = InitializeResult {
                capabilities,
                server_info: Some(ServerInfo {
                    name: "T4 Language Server".to_string(),
                    version: Some(env!("CARGO_PKG_VERSION").to_string()),
                }),
            };

            Response {
                id,
                result: Some(serde_json::to_value(result).unwrap()),
                error: None,
            }
        }

        fn handle_shutdown(&mut self, id: RequestId) -> Response {
            Response {
                id,
                result: Some(Value::Null),
                error: None,
            }
        }

        fn handle_completion(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement completion logic
            let result = CompletionList {
                is_incomplete: false,
                items: vec![],
            };

            Response {
                id,
                result: Some(serde_json::to_value(result).unwrap()),
                error: None,
            }
        }

        fn handle_hover(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement hover logic
            let result = None::<Hover>;

            Response {
                id,
                result: result.map(|r| serde_json::to_value(r).unwrap()),
                error: None,
            }
        }

        fn handle_goto_definition(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement goto definition logic
            let result = None::<Location>;

            Response {
                id,
                result: result.map(|r| serde_json::to_value(r).unwrap()),
                error: None,
            }
        }

        fn handle_find_references(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement find references logic
            let result = Vec::<Location>::new();

            Response {
                id,
                result: Some(serde_json::to_value(result).unwrap()),
                error: None,
            }
        }

        fn handle_document_symbols(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement document symbols logic
            let result = Vec::<SymbolInformation>::new();

            Response {
                id,
                result: Some(serde_json::to_value(result).unwrap()),
                error: None,
            }
        }

        fn handle_format_document(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement document formatting logic
            let result = Vec::<TextEdit>::new();

            Response {
                id,
                result: Some(serde_json::to_value(result).unwrap()),
                error: None,
            }
        }

        fn handle_format_range(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement range formatting logic
            let result = Vec::<TextEdit>::new();

            Response {
                id,
                result: Some(serde_json::to_value(result).unwrap()),
                error: None,
            }
        }

        fn handle_workspace_symbols(&mut self, id: RequestId, params: Value) -> Response {
            // TODO: Implement workspace symbols logic
            let result = Vec::<SymbolInformation>::new();

            Response {
                id,
                result: Some(serde_json::to_value(result).unwrap()),
                error: None,
            }
        }

        fn handle_did_open_text_document(&mut self, params: Value) -> anyhow::Result<()> {
            let params: DidOpenTextDocumentParams = serde_json::from_value(params)?;
            let uri = params.text_document.uri;
            let content = params.text_document.text;

            self.documents.insert(uri.clone(), content);

            // Publish diagnostics
            self.publish_diagnostics(&uri)?;

            Ok(())
        }

        fn handle_did_change_text_document(&mut self, params: Value) -> anyhow::Result<()> {
            let params: DidChangeTextDocumentParams = serde_json::from_value(params)?;
            let uri = params.text_document.uri;

            if let Some(changes) = params.content_changes.first() {
                if let Some(text) = changes.range.as_ref().and_then(|_| changes.text.as_ref()) {
                    // Full content update
                    self.documents.insert(uri.clone(), text.clone());
                }
            }

            // Publish diagnostics
            self.publish_diagnostics(&uri)?;

            Ok(())
        }

        fn handle_did_close_text_document(&mut self, params: Value) -> anyhow::Result<()> {
            let params: DidCloseTextDocumentParams = serde_json::from_value(params)?;
            let uri = params.text_document.uri;

            self.documents.remove(&uri);
            Ok(())
        }

        fn handle_did_save_text_document(&mut self, params: Value) -> anyhow::Result<()> {
            let params: DidSaveTextDocumentParams = serde_json::from_value(params)?;
            let uri = params.text_document.uri;

            // Publish diagnostics after save
            self.publish_diagnostics(&uri)?;
            Ok(())
        }

        fn handle_did_change_configuration(&mut self, params: Value) -> anyhow::Result<()> {
            // TODO: Handle configuration changes
            log::debug!("Configuration changed: {:?}", params);
            Ok(())
        }

        fn publish_diagnostics(&mut self, uri: &Url) -> anyhow::Result<()> {
            if let Some(connection) = &self.connection {
                let diagnostics = self.diagnostics.get_diagnostics(uri)?;
                let params = PublishDiagnosticsParams {
                    uri: uri.clone(),
                    diagnostics,
                    version: None,
                };

                let notification = Notification {
                    jsonrpc: "2.0".to_string(),
                    method: "textDocument/publishDiagnostics".to_string(),
                    params: serde_json::to_value(params)?,
                };

                connection.sender.send(Message::Notification(notification))?;
            }

            Ok(())
        }

        fn create_error_response(&self, id: RequestId, code: ErrorCode, message: String) -> Response {
            let error = ResponseError {
                code: code as i32,
                message,
                data: None,
            };

            Response {
                id,
                result: None,
                error: Some(error),
            }
        }
    }
}