//! Generated T4 Lexer
//!
//! This module contains the lexer implementation for T4.
//! Generated from T4Lexer.g4

use crate::generated::parser::TokenType;

/// Basic lexer implementation for T4
pub struct T4Lexer {
    /// Source code being lexed
    source: String,

    /// Current position in source
    position: usize,

    /// Current line number
    line: usize,

    /// Current column number
    column: usize,
}

impl T4Lexer {
    /// Create a new lexer
    pub fn new(source: String) -> Self {
        Self {
            source,
            position: 0,
            line: 1,
            column: 1,
        }
    }

    /// Get the next token
    pub fn next_token(&mut self) -> TokenType {
        if self.is_at_end() {
            return TokenType::Eof;
        }

        self.skip_whitespace();

        if self.is_at_end() {
            return TokenType::Eof;
        }

        let ch = self.peek_char();
        let token = match ch {
            Some(ch) if ch.is_alphabetic() || ch == '_' => self.lex_identifier(),
            Some(ch) if ch.is_ascii_digit() => self.lex_number(),
            Some('"') => self.lex_string(),
            Some('\'') => self.lex_char(),
            Some('+') => {
                self.advance();
                TokenType::Plus
            },
            Some('-') => {
                self.advance();
                if self.peek_char() == Some('>') {
                    self.advance();
                    TokenType::Arrow
                } else {
                    TokenType::Minus
                }
            },
            Some('*') => {
                self.advance();
                TokenType::Star
            },
            Some('/') => {
                self.advance();
                TokenType::Slash
            },
            Some('%') => {
                self.advance();
                TokenType::Percent
            },
            Some('=') => {
                self.advance();
                if self.peek_char() == Some('=') {
                    self.advance();
                    TokenType::Eq
                } else {
                    TokenType::Eq // Assignment operator
                }
            },
            Some('!') => {
                self.advance();
                if self.peek_char() == Some('=') {
                    self.advance();
                    TokenType::Ne
                } else {
                    TokenType::Not
                }
            },
            Some('<') => {
                self.advance();
                if self.peek_char() == Some('=') {
                    self.advance();
                    TokenType::Le
                } else {
                    TokenType::Lt
                }
            },
            Some('>') => {
                self.advance();
                if self.peek_char() == Some('=') {
                    self.advance();
                    TokenType::Ge
                } else {
                    TokenType::Gt
                }
            },
            Some('&') => {
                self.advance();
                if self.peek_char() == Some('&') {
                    self.advance();
                    TokenType::AndAnd
                } else {
                    TokenType::And
                }
            },
            Some('|') => {
                self.advance();
                if self.peek_char() == Some('|') {
                    self.advance();
                    TokenType::OrOr
                } else {
                    TokenType::Or
                }
            },
            Some('^') => {
                self.advance();
                TokenType::Caret
            },
            Some('(') => {
                self.advance();
                TokenType::LParen
            },
            Some(')') => {
                self.advance();
                TokenType::RParen
            },
            Some('{') => {
                self.advance();
                TokenType::LBrace
            },
            Some('}') => {
                self.advance();
                TokenType::RBrace
            },
            Some('[') => {
                self.advance();
                TokenType::LBracket
            },
            Some(']') => {
                self.advance();
                TokenType::RBracket
            },
            Some(';') => {
                self.advance();
                TokenType::Semicolon
            },
            Some(':') => {
                self.advance();
                if self.peek_char() == Some(':') {
                    self.advance();
                    TokenType::ColonColon
                } else {
                    TokenType::Colon
                }
            },
            Some(',') => {
                self.advance();
                TokenType::Comma
            },
            Some('.') => {
                self.advance();
                if self.peek_char() == Some('.') {
                    self.advance();
                    TokenType::Dot // For ranges
                } else {
                    TokenType::Dot
                }
            },
            Some(_) => {
                self.advance();
                TokenType::Eof // Unknown characters
            },
            None => TokenType::Eof,
        };

        token
    }

    /// Lex an identifier or keyword
    fn lex_identifier(&mut self) -> TokenType {
        let start = self.position;
        while let Some(ch) = self.peek_char() {
            if ch.is_alphanumeric() || ch == '_' {
                self.advance();
            } else {
                break;
            }
        }

        let text: String = self.source.chars().skip(start).take(self.position - start).collect();

        match text.as_str() {
            "module" => TokenType::Module,
            "import" => TokenType::Import,
            "config" => TokenType::Config,
            "fn" => TokenType::Function,
            "struct" => TokenType::Struct,
            "enum" => TokenType::Enum,
            "trait" => TokenType::Trait,
            "impl" => TokenType::Impl,
            "let" => TokenType::Let,
            "mut" => TokenType::Mut,
            "if" => TokenType::If,
            "else" => TokenType::Else,
            "match" => TokenType::Match,
            "while" => TokenType::While,
            "for" => TokenType::For,
            "loop" => TokenType::Loop,
            "return" => TokenType::Return,
            "break" => TokenType::Break,
            "continue" => TokenType::Continue,
            "true" => TokenType::True,
            "false" => TokenType::False,
            "type" => TokenType::Type,
            "const" => TokenType::Const,
            "static" => TokenType::Static,
            "extern" => TokenType::Extern,
            "pub" => TokenType::Pub,
            "Int32" => TokenType::Int32,
            "Int64" => TokenType::Int64,
            "Bool" => TokenType::Bool,
            "String" => TokenType::String,
            "as" => TokenType::Identifier("as".to_string()),
            _ => TokenType::Identifier(text),
        }
    }

    /// Lex a number literal
    fn lex_number(&mut self) -> TokenType {
        let start = self.position;
        let mut is_float = false;

        while let Some(ch) = self.peek_char() {
            if ch.is_ascii_digit() {
                self.advance();
            } else if ch == '.' && !is_float {
                is_float = true;
                self.advance();
            } else {
                break;
            }
        }

        let text: String = self.source.chars().skip(start).take(self.position - start).collect();

        if is_float {
            TokenType::Float(text)
        } else {
            TokenType::Integer(text)
        }
    }

    /// Lex a string literal
    fn lex_string(&mut self) -> TokenType {
        self.advance(); // consume opening quote
        let start = self.position;

        while let Some(ch) = self.peek_char() {
            if ch == '"' {
                let text: String = self.source.chars().skip(start).take(self.position - start).collect();
                self.advance(); // consume closing quote
                return TokenType::StringLit(text);
            }
            self.advance();
        }

        TokenType::StringLit("".to_string()) // Unterminated string
    }

    /// Lex a character literal
    fn lex_char(&mut self) -> TokenType {
        self.advance(); // consume opening quote
        let ch = self.peek_char();
        self.advance(); // consume character
        if self.peek_char() == Some('\'') {
            self.advance(); // consume closing quote
            TokenType::Char(ch.unwrap_or('\0'))
        } else {
            TokenType::Char('\0') // Invalid char literal
        }
    }

    /// Skip whitespace and comments
    fn skip_whitespace(&mut self) {
        while let Some(ch) = self.source.chars().nth(self.position) {
            if ch.is_whitespace() {
                if ch == '\n' {
                    self.line += 1;
                    self.column = 1;
                } else {
                    self.column += 1;
                }
                self.position += 1;
            } else if ch == '/' && self.source.chars().nth(self.position + 1) == Some('/') {
                // Skip line comment
                self.position += 2;
                while let Some(comment_ch) = self.source.chars().nth(self.position) {
                    if comment_ch == '\n' {
                        self.line += 1;
                        self.column = 1;
                        self.position += 1;
                        break;
                    }
                    self.position += 1;
                    self.column += 1;
                }
            } else {
                break;
            }
        }
    }

    /// Peek at the current character
    fn peek_char(&self) -> Option<char> {
        self.source.chars().nth(self.position)
    }

    /// Advance to the next character
    fn advance(&mut self) {
        if let Some(ch) = self.source.chars().nth(self.position) {
            if ch == '\n' {
                self.line += 1;
                self.column = 1;
            } else {
                self.column += 1;
            }
            self.position += 1;
        }
    }

    /// Check if at end of input
    fn is_at_end(&self) -> bool {
        self.position >= self.source.len()
    }
}