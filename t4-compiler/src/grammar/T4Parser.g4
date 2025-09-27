/**
 * T4 Parser Grammar
 *
 * This file defines the parser grammar rules for the T4 programming language,
 * a security-first language designed for cryptographic workloads and
 * post-quantum security with built-in support for modern cryptographic
 * primitives while maintaining memory safety.
 *
 * The grammar is organized into the following main sections:
 * - Program Structure and Declarations
 * - Type System (Basic and Advanced)
 * - Function Declarations and Calls
 * - Control Flow Statements
 * - Expression Parsing
 * - Pattern Matching
 * - Cryptographic-Specific Syntax
 * - Security Annotations
 * - Metaprogramming Features
 * - Advanced Language Features
 *
 * Author: T4 Compiler Team
 * Version: 2.0 - Advanced Grammar Extension
 */

parser grammar T4Parser;

options {
    tokenVocab = T4Lexer;
}

// ====================
// PROGRAM STRUCTURE
// ====================
// Top-level program structure and declarations

program
    : declaration* EOF
    ;

// ====================
// DECLARATIONS
// ====================
// Top-level declarations that can appear in a T4 program

declaration
    : module_declaration
    | import_declaration
    | function_declaration
    | struct_declaration
    | enum_declaration
    | trait_declaration
    | impl_block
    | type_alias
    | const_declaration
    | static_declaration
    | config_block
    | extern_block
    ;

// Module system
module_declaration
    : MODULE IDENTIFIER LBRACE declaration* RBRACE
    ;

import_declaration
    : IMPORT (STRING | MODULE_PATH) (AS_ IDENTIFIER)? SEMICOLON
    ;

config_block
    : CONFIG_ LBRACE config_item* RBRACE
    ;

config_item
    : DEFAULT_CRYPTO_PROVIDER ASSIGN STRING SEMICOLON
    | POST_QUANTUM_ENABLED ASSIGN (TRUE | FALSE) SEMICOLON
    | HARDWARE_ACCELERATION ASSIGN (TRUE | FALSE) SEMICOLON
    | IDENTIFIER ASSIGN expression SEMICOLON
    ;

extern_block
    : EXTERN_ STRING (AS_ IDENTIFIER)? LBRACE extern_function* RBRACE
    ;

extern_function
    : FN IDENTIFIER LPAREN parameters? RPAREN (ARROW return_type)? SEMICOLON
    ;

// Function declarations
function_declaration
    : FN IDENTIFIER generic_params? LPAREN parameters? RPAREN
      (ARROW return_type)? (where_clause)?
      (LBRACE statement* RBRACE | SEMICOLON)
    ;

// ====================
// TYPE SYSTEM
// ====================
// Type definitions and type expressions

type_
    : basic_type
    | cryptographic_type
    | type_path
    | tuple_type
    | array_type
    | slice_type
    | reference_type
    | mutable_reference_type
    | function_type
    | generic_type
    | advanced_type
    ;

basic_type
    : INT8 | INT16 | INT32 | INT64
    | UINT8 | UINT16 | UINT32 | UINT64
    | FLOAT32 | FLOAT64
    | BOOL
    | STRING
    | BYTES
    ;

cryptographic_type
    : KEY_ LT algorithm_type GT
    | SECRET_ LT type_ GT
    | PUBLICKEY_ LT algorithm_type GT
    | PRIVATEKEY_ LT algorithm_type GT
    | SIGNATURE_ LT algorithm_type GT
    | CIPHERTEXT_ LT algorithm_type GT
    | PLAINTEXT_ LT algorithm_type GT
    | HASH_ LT algorithm_type GT
    | NONCE_
    | SALT_
    ;

algorithm_type
    : AES256 | KYBER1024 | DILITHIUM3 | ED25519 | P256
    | FALCON512 | CKKS | GROTH16 | BULLETPROOFS | STARK | PLONK
    | type_path
    ;

type_path
    : (MODULE_PATH COLONCOLON)? IDENTIFIER generic_args?
    ;

tuple_type
    : LPAREN (type_ (COMMA type_)*)? RPAREN
    ;

array_type
    : LBRACKET type_ SEMICOLON expression RBRACKET
    ;

slice_type
    : LBRACKET type_ RBRACKET
    ;

reference_type
    : AND type_
    ;

mutable_reference_type
    : AND MUT type_
    ;

function_type
    : FN LPAREN parameters? RPAREN (ARROW return_type)?
    ;

generic_type
    : type_path LT type_args GT
    ;

type_args
    : type_ (COMMA type_)*
    ;

generic_params
    : LT generic_param (COMMA generic_param)* GT
    ;

generic_param
    : IDENTIFIER (COLON bound (PLUS bound)*)?
    ;

bound
    : type_path
    | LIFETIME
    | QUESTION? LPAREN bound (PLUS bound)* RPAREN
    ;

where_clause
    : WHERE_ where_item (COMMA where_item)*
    ;

where_item
    : generic_param COLON bound (PLUS bound)*
    ;

// Parameters and return types
parameters
    : parameter (COMMA parameter)*
    ;

parameter
    : (MUT | REF | MUT REF)? IDENTIFIER COLON type_
    ;

return_type
    : type_
    | LPAREN (type_ (COMMA type_)*)? RPAREN
    ;

// Struct declarations
struct_declaration
    : STRUCT IDENTIFIER generic_params? (LPAREN struct_fields? RPAREN)? where_clause?
      (LBRACE struct_field* RBRACE | SEMICOLON)
    ;

struct_fields
    : struct_field (COMMA struct_field)*
    ;

struct_field
    : (PUB_)? IDENTIFIER COLON type_
    ;

// Enum declarations
enum_declaration
    : ENUM IDENTIFIER generic_params? where_clause?
      LBRACE enum_variant* RBRACE
    ;

enum_variant
    : IDENTIFIER (LPAREN (type_ (COMMA type_)*)? RPAREN)?
    ;

// Trait declarations
trait_declaration
    : TRAIT IDENTIFIER generic_params? where_clause?
      LBRACE trait_item* RBRACE
    ;

trait_item
    : function_declaration
    | const_declaration
    | type_alias
    ;

// Implementation blocks
impl_block
    : IMPL generic_params? type_path where_clause?
      FOR type_path LBRACE impl_item* RBRACE
    ;

impl_item
    : function_declaration
    | const_declaration
    | type_alias
    ;

// Type aliases
type_alias
    : TYPE IDENTIFIER generic_params? where_clause? ASSIGN type_ SEMICOLON
    ;

// Constants and statics
const_declaration
    : CONST IDENTIFIER COLON type_ ASSIGN expression SEMICOLON
    ;

static_declaration
    : STATIC (MUT)? IDENTIFIER COLON type_ ASSIGN expression SEMICOLON
    ;

// ====================
// STATEMENTS
// ====================
// Statement-level language constructs

statement
    : let_statement
    | expression_statement
    | assignment_statement
    | return_statement
    | break_statement
    | continue_statement
    | if_statement
    | match_statement
    | while_statement
    | for_statement
    | loop_statement
    | async_statement
    | early_return
    | yield_statement
    ;

let_statement
    : LET (MUT)? IDENTIFIER (COLON type_)? (ASSIGN expression)? SEMICOLON
    ;

expression_statement
    : expression SEMICOLON
    ;

assignment_statement
    : expression ASSIGN expression SEMICOLON
    ;

return_statement
    : RETURN expression? SEMICOLON
    ;

break_statement
    : BREAK expression? SEMICOLON
    ;

continue_statement
    : CONTINUE SEMICOLON
    ;

if_statement
    : IF expression LBRACE statement* RBRACE
      (ELSE IF expression LBRACE statement* RBRACE)*
      (ELSE LBRACE statement* RBRACE)?
    ;

match_statement
    : MATCH expression LBRACE match_arm* RBRACE
    ;

match_arm
    : pattern FAT_ARROW statement
    ;

while_statement
    : WHILE expression LBRACE statement* RBRACE
    ;

for_statement
    : FOR IDENTIFIER IN expression LBRACE statement* RBRACE
    ;

loop_statement
    : LOOP LBRACE statement* RBRACE
    ;

// ====================
// EXPRESSIONS
// ====================
// Expression-level language constructs and operations

// Base expressions that don't contain other expressions
atom_expression
    : literal_expression
    | path_expression
    | tuple_expression
    | array_expression
    | struct_expression
    | enum_expression
    | grouped_expression
    | block_expression
    | if_expression
    | match_expression
    | closure_expression
    | async_expression
    | cryptographic_expression
    | security_annotation
    ;

// Expressions that can contain other expressions
expression
    : atom_expression
    | unary_expression
    | binary_expression
    | call_expression
    | index_expression
    | field_expression
    | method_expression
    | range_expression
    | reference_expression
    | dereference_expression
    | type_cast_expression
    | await_expression
    ;

literal_expression
    : INTEGER
    | HEX_INTEGER
    | OCT_INTEGER
    | BIN_INTEGER
    | FLOAT
    | STRING
    | BYTE_STRING
    | CHAR
    | TRUE
    | FALSE
    ;

path_expression
    : type_path
    | MODULE_PATH COLONCOLON IDENTIFIER
    ;

binary_expression
    : atom_expression operator atom_expression
    | binary_expression operator atom_expression
    ;

operator
    : PLUS | MINUS | STAR | SLASH | PERCENT
    | EQ | NE | LT | GT | LE | GE
    | AND | OR | CARET
    | ANDAND | OROR
    | SHL | SHR
    ;

unary_expression
    : (NOT | MINUS | STAR | AND | AND MUT) expression
    ;

call_expression
    : atom_expression LPAREN arguments? RPAREN
    ;

arguments
    : atom_expression (COMMA atom_expression)*
    ;

index_expression
    : atom_expression LBRACKET atom_expression RBRACKET
    ;

field_expression
    : atom_expression DOT IDENTIFIER
    ;

method_expression
    : atom_expression DOT IDENTIFIER LPAREN arguments? RPAREN
    ;

tuple_expression
    : LPAREN (atom_expression (COMMA atom_expression)*)? RPAREN
    ;

array_expression
    : LBRACKET (atom_expression (COMMA atom_expression)*)? RBRACKET
    ;

struct_expression
    : type_path LBRACE (field_init (COMMA field_init)*)? RBRACE
    ;

field_init
    : IDENTIFIER COLON atom_expression
    ;

enum_expression
    : type_path COLONCOLON IDENTIFIER (LPAREN arguments? RPAREN)?
    ;

range_expression
    : atom_expression DOT DOT atom_expression?
    ;

reference_expression
    : AND (MUT)? atom_expression
    ;

dereference_expression
    : STAR atom_expression
    ;

type_cast_expression
    : atom_expression AS_ type_
    ;

grouped_expression
    : LPAREN atom_expression RPAREN
    ;

block_expression
    : LBRACE statement* atom_expression? RBRACE
    ;

if_expression
    : IF atom_expression LBRACE statement* RBRACE
      (ELSE IF atom_expression LBRACE statement* RBRACE)*
      (ELSE LBRACE statement* RBRACE)?
    ;

match_expression
    : MATCH atom_expression LBRACE match_arm* RBRACE
    ;

closure_expression
    : (MOVE | STATIC)? (OR OR parameters? OR) (ARROW return_type)? atom_expression
    ;

async_expression
    : ASYNC LBRACE statement* RBRACE
    ;

await_expression
    : atom_expression DOT AWAIT
    ;

// Cryptographic expressions
cryptographic_expression
    : encrypt_expression
    | decrypt_expression
    | sign_expression
    | verify_expression
    | keygen_expression
    | kem_expression
    | proof_expression
    | verify_proof_expression
    ;

encrypt_expression
    : ENCRYPT_ LPAREN expression COMMA expression RPAREN
    ;

decrypt_expression
    : DECRYPT_ LPAREN expression COMMA expression RPAREN
    ;

sign_expression
    : SIGN_ LPAREN expression COMMA expression RPAREN
    ;

verify_expression
    : VERIFY_ LPAREN expression COMMA expression COMMA expression RPAREN
    ;

keygen_expression
    : KEY_ LT algorithm_type GT COLONCOLON NEW LPAREN RPAREN
    ;

kem_expression
    : KEM_ LPAREN expression RPAREN
    ;

proof_expression
    : PROOF_ LT type_ GT LPAREN expression COMMA expression RPAREN
    ;

verify_proof_expression
    : VERIFY_PROOF_ LPAREN expression COMMA expression RPAREN
    ;

// Security annotations
security_annotation
    : HASH_LBRACKET security_attribute (COMMA security_attribute)* RBRACKET
    ;

security_attribute
    : CONSTANT_TIME_
    | CACHE_RESISTANT_
    | SECURE_MEMORY_
    | VERIFY_PROTOCOL_
    | WIPE_ON_DROP_
    | DISTRIBUTED_
    | THRESHOLD_SIGN_
    | VERIFY_SOUNDNESS_
    | VERIFY_ZERO_KNOWLEDGE_
    | POWER_RESISTANT_
    ;

// Patterns
pattern
    : literal_pattern
    | identifier_pattern
    | wildcard_pattern
    | reference_pattern
    | struct_pattern
    | enum_pattern
    | tuple_pattern
    | array_pattern
    | range_pattern
    ;

literal_pattern
    : literal_expression
    ;

identifier_pattern
    : (MUT | REF | MUT REF)? IDENTIFIER
    ;

wildcard_pattern
    : UNDERSCORE
    ;

reference_pattern
    : (MUT | REF | MUT REF)? (literal_pattern | identifier_pattern | wildcard_pattern | struct_pattern | enum_pattern | tuple_pattern | array_pattern | range_pattern)
    ;

struct_pattern
    : type_path LBRACE (field_pattern (COMMA field_pattern)*)? RBRACE
    ;

field_pattern
    : (IDENTIFIER COLON)? pattern
    ;

enum_pattern
    : type_path COLONCOLON IDENTIFIER (LPAREN patterns? RPAREN)?
    ;

tuple_pattern
    : LPAREN (pattern (COMMA pattern)*)? RPAREN
    ;

array_pattern
    : LBRACKET (pattern (COMMA pattern)*)? RBRACKET
    ;

range_pattern
    : literal_expression DOT DOT literal_expression?
    ;

patterns
    : pattern (COMMA pattern)*
    ;

// Generic arguments
generic_args
    : LT type_args GT
    ;

// Error handling
error_type
    : CRYPTO_ERROR
    | INVALID_KEY
    | DECRYPTION_FAILED
    | AUTHENTICATION_FAILED
    | WEAK_PARAMETER
    | HARDWARE_FAILURE
    | TIMING_ATTACK_DETECTED
    ;

result_type
    : RESULT_ LT type_ COMMA error_type GT
    ;

// Advanced Type System Grammar Rules
advanced_type
    : HIGHER_KINDED_ type_constructor
    | EXISTENTIAL_ type_
    | CRYPTO_PARAM_ LT crypto_type_params GT
    | ASSOCIATED_ type_path
    | PHANTOM_ type_
    | ZERO_SIZED_ type_
    ;

higher_kinded_type
    : HKT_ LT type_constructor (KIND_ARROW_ type_constructor)* GT
    ;

type_constructor
    : TYPE_CONSTRUCTOR_ LT type_args GT
    | IDENTIFIER
    ;

crypto_type_params
    : CRYPTO_ALG_ (COMMA SECURITY_PARAM_)? (COMMA type_)*
    ;

trait_bounds
    : TRAIT_BOUND_ (PLUS TRAIT_BOUND_)*
    ;

associated_type
    : ASSOCIATED_TYPE_ IDENTIFIER (COLON type_)? (ASSIGN type_)?
    ;

associated_const
    : ASSOCIATED_CONST_ IDENTIFIER COLON type_ ASSIGN expression
    ;

generic_constraints
    : CONSTRAINT_ LT type_ COLON trait_bounds GT
    ;

type_family
    : TYPE_FAMILY_ IDENTIFIER ASSIGN type_
    ;

kind
    : KIND_ KIND_STAR_
    | KIND_ (KIND_ARROW_ kind)*
    ;

phantom_type
    : PHANTOM_ LT type_ GT
    ;

existential_type
    : EXISTS_ IDENTIFIER COLON type_
    ;

universal_type
    : FORALL_ IDENTIFIER COLON type_ DOT type_
    ;

// Security Annotation Grammar Rules
security_annotations
    : HASH_LBRACKET security_attribute (COMMA security_attribute)* RBRACKET
    ;

advanced_security_attribute
    : TIMING_RESISTANT_
    | FAULT_RESISTANT_
    | LEAKAGE_RESISTANT_
    | SECURE_EXECUTION_
    | TRUSTED_EXECUTION_
    | ENCLAVE_
    | SECURE_CHANNEL_
    | AUTHENTICATED_
    | CONFIDENTIAL_
    | INTEGRITY_CHECK_
    | FRESHNESS_CHECK_
    | NON_REPLAYABLE_
    | FORWARD_SECURE_
    | POST_COMPROMISE_
    | COMPUTATIONAL_SECURITY_
    | INFORMATION_THEORETIC_
    ;

protocol_annotation
    : PROTOCOL_ LPAREN protocol_spec RPAREN
    ;

protocol_spec
    : IDENTIFIER LBRACE protocol_property* RBRACE
    ;

protocol_property
    : CONFIDENTIALITY_ COLON expression
    | AUTHENTICATION_ COLON expression
    | NON_REPUDIATION_ COLON expression
    | INTEGRITY_ COLON expression
    | AVAILABILITY_ COLON expression
    | FRESHNESS_ COLON expression
    | FORWARD_SECRECY_ COLON expression
    | BACKWARD_SECRECY_ COLON expression
    | PERFECT_SECRECY_ COLON expression
    ;

zero_knowledge_annotation
    : ZERO_KNOWLEDGE_ LPAREN zk_params RPAREN
    ;

zk_params
    : PROOF_SYSTEM_ ASSIGN IDENTIFIER (COMMA SECURITY_PARAMETER_ ASSIGN expression)?
    ;

homomorphic_annotation
    : HOMOMORPHIC_ LPAREN ENCRYPTION_SCHEME_ ASSIGN IDENTIFIER RPAREN
    ;

distributed_annotation
    : DISTRIBUTED_ LPAREN THRESHOLD_ ASSIGN expression RPAREN
    ;

secure_computation_annotation
    : SECURE_COMPUTATION_ LPAREN computation_type RPAREN
    ;

computation_type
    : MULTIPARTY_ | OBLIVIOUS_ | PRIVATE_SET_ | SECURE_SEARCH_
    ;

// Advanced Function Grammar Rules
advanced_function
    : CLOSURE_ parameters? (ARROW return_type)? ASSIGN expression
    | LAMBDA_ parameters? ARROW expression
    | OPERATOR_ operator_name LPAREN parameters RPAREN ASSIGN expression
    | FUNCTION_PTR_ LT function_type GT
    | CALLABLE_ trait_bounds
    ;

operator_overload
    : OVERLOAD_ operator_name FOR type_ LBRACE
      function_body
      RBRACE
    ;

function_body
    : statement* return_statement?
    ;

operator_name
    : PLUS | MINUS | STAR | SLASH | PERCENT
    | EQ | NE | LT | GT | LE | GE
    | AND | OR | NOT | CARET
    | ANDAND | OROR | SHL | SHR
    ;

async_function
    : ASYNC FN IDENTIFIER generic_params? LPAREN parameters? RPAREN
      (ARROW return_type)? where_clause?
      (LBRACE async_statement* RBRACE | SEMICOLON)
    ;

async_statement
    : AWAIT atom_expression SEMICOLON
    | YIELD atom_expression SEMICOLON
    | let_statement
    | expression_statement
    | assignment_statement
    | return_statement
    | break_statement
    | continue_statement
    | if_statement
    | match_statement
    | while_statement
    | for_statement
    | loop_statement
    | early_return
    | yield_statement
    ;

stream_expression
    : STREAM_ LT type_ GT LPAREN expression RPAREN
    ;

iterator_expression
    : ITERATOR_ LPAREN expression RPAREN
    ;

generator_expression
    : GENERATOR_ LBRACE yield_statement* RBRACE
    ;

yield_statement
    : YIELD expression SEMICOLON
    ;

coroutine_expression
    : COROUTINE_ LPAREN parameters? RPAREN ARROW return_type ASSIGN expression
    ;

partial_application
    : PARTIAL_ expression LPAREN partial_args RPAREN
    ;

partial_args
    : (expression COMMA)* UNDERSCORE (COMMA expression)*
    ;

function_composition
    : COMPOSE_ LPAREN expression COMMA expression RPAREN
    ;

pipeline_expression
    : expression PIPE_ expression (PIPE_ expression)*
    ;

method_chain
    : CHAIN_ LPAREN expression (DOT IDENTIFIER LPAREN arguments? RPAREN)* RPAREN
    ;

// Module System Extension Grammar Rules
module_hierarchy
    : NAMESPACE_ IDENTIFIER (COLONCOLON IDENTIFIER)* LBRACE module_item* RBRACE
    ;

module_item
    : declaration
    | visibility_modifier declaration
    | secure_module
    | isolated_module
    ;

visibility_modifier
    : SECURE_ | ISOLATED_ | TRUSTED_ | UNTRUSTED_ | SENSITIVE_ | CLASSIFIED_
    ;

secure_module
    : SECURE_ MODULE IDENTIFIER LBRACE secure_item* RBRACE
    ;

secure_item
    : COMPARTMENT_ IDENTIFIER LBRACE declaration* RBRACE
    | declaration
    ;

isolated_module
    : ISOLATED_ MODULE IDENTIFIER LBRACE isolated_item* RBRACE
    ;

isolated_item
    : TRUSTED_ LBRACE declaration* RBRACE
    | UNTRUSTED_ LBRACE declaration* RBRACE
    | declaration
    ;

component_declaration
    : COMPONENT_ IDENTIFIER (IMPLEMENTS_ interface_list)? LBRACE component_item* RBRACE
    ;

interface_list
    : IDENTIFIER (COMMA IDENTIFIER)*
    ;

component_item
    : SERVICE_ IDENTIFIER LPAREN parameters RPAREN (ARROW return_type)? SEMICOLON
    | declaration
    ;

microservice_declaration
    : MICROSERVICE_ IDENTIFIER LBRACE microservice_config* RBRACE
    ;

microservice_config
    : API_ ENDPOINT_ ASSIGN STRING SEMICOLON
    | AUTHENTICATION_ REQUIRED_ SEMICOLON
    | ENCRYPTION_ REQUIRED_ SEMICOLON
    ;

api_declaration
    : API_ IDENTIFIER LBRACE api_method* RBRACE
    ;

api_method
    : FN IDENTIFIER LPAREN parameters RPAREN (ARROW return_type)? SEMICOLON
    ;

interface_declaration
    : INTERFACE_ IDENTIFIER LBRACE interface_method* RBRACE
    ;

interface_method
    : FN IDENTIFIER LPAREN parameters RPAREN (ARROW return_type)? SEMICOLON
    ;

// Advanced Control Flow Grammar Rules
pattern_matching
    : PATTERN_ IDENTIFIER LBRACE pattern_arm* RBRACE
    ;

pattern_arm
    : pattern GUARD_? FAT_ARROW expression
    ;

guard_expression
    : GUARD_ LPAREN expression RPAREN
    ;

destructuring
    : DESTRUCTURE_ LPAREN binding (COMMA binding)* RPAREN ASSIGN expression
    ;

binding
    : BINDING_ IDENTIFIER COLON type_
    | IDENTIFIER
    ;

comprehension
    : COMPREHENSION_ LT type_ GT LPAREN expression PIPE_ iterators RPAREN
    ;

iterators
    : iterator_chain (COMMA iterator_chain)*
    ;

iterator_chain
    : ITERATOR_CHAIN_ DOT chain_operation LPAREN arguments? RPAREN
    ;

chain_operation
    : FILTER_ | MAP_TRANSFORM_ | REDUCE_ | FOLD_ | FLATTEN_ | ZIP_
    | ENUMERATE_ | TAKE_ | SKIP_ | CYCLE_ | REPEAT_
    ;

list_comprehension
    : LIST_ LBRACE expression PIPE_ generators RBRACE
    ;

generators
    : generator (COMMA generator)*
    ;

generator
    : IDENTIFIER IN expression (IF expression)?
    ;

range_literal
    : RANGE_ LPAREN start=expression COMMA end=expression
      (COMMA step=expression)? (COMMA inclusive=INCLUSIVE_)? RPAREN
    ;

early_return
    : EARLY_RETURN_ expression? SEMICOLON
    ;

vector_literal
    : VECTOR_ LBRACKET (expression (COMMA expression)*)? RBRACKET
    ;

set_literal
    : SET_ LBRACE (expression (COMMA expression)*)? RBRACE
    ;

// Cryptographic-Specific Syntax Grammar Rules
crypto_literal
    : KEY_LITERAL_ LT algorithm_type GT LPAREN key_data RPAREN
    | SECRET_LITERAL_ LT type_ GT LPAREN secret_data RPAREN
    ;

key_data
    : HEX_INTEGER | STRING | BYTES
    ;

secret_data
    : expression
    ;

crypto_operation
    : CRYPTO_OP_ LT operation_type GT LPAREN operands RPAREN
    ;

operation_type
    : ENCRYPTION_ | DECRYPTION_ | SIGNATURE_ | VERIFICATION_
    | KEY_EXCHANGE_ | HASH_ | MAC_ | PROOF_
    ;

operands
    : expression (COMMA expression)*
    ;

protocol_definition
    : PROTOCOL_ IDENTIFIER LBRACE protocol_stage* RBRACE
    ;

protocol_stage
    : IDENTIFIER ARROW LBRACE protocol_action* RBRACE
    ;

protocol_action
    : SEND_ LPAREN message RPAREN
    | RECEIVE_ LPAREN message RPAREN
    | COMPUTE_ LPAREN computation RPAREN
    | VERIFY_ LPAREN verification RPAREN
    ;

message
    : expression
    ;

computation
    : expression
    ;

verification
    : expression
    ;

zero_knowledge_proof
    : ZERO_KNOWLEDGE_ LPAREN prover COMMA verifier COMMA zk_statement COMMA witness RPAREN
    ;

prover
    : expression
    ;

verifier
    : expression
    ;

zk_statement
    : expression
    ;

witness
    : expression
    ;

homomorphic_operation
    : HOMOMORPHIC_ DOT operation LPAREN encrypted_data COMMA plaintext RPAREN
    ;

operation
    : ADD_ | SUB_ | MUL_ | DIV_
    ;

encrypted_data
    : expression
    ;

plaintext
    : expression
    ;

distributed_crypto
    : DISTRIBUTED_ LPAREN threshold=expression COMMA participants RPAREN
    ;

participants
    : expression (COMMA expression)*
    ;

secure_computation
    : SECURE_COMPUTATION_ LPAREN computation_type COMMA inputs RPAREN
    ;

inputs
    : expression (COMMA expression)*
    ;

anonymous_communication
    : ANONYMOUS_ LPAREN message COMMA routing RPAREN
    ;

routing
    : ONION_ | MIXNET_ | DCNET_
    ;

untraceable_operation
    : UNTRACEABLE_ LPAREN operation RPAREN
    ;

confidentiality_property
    : CONFIDENTIALITY_ LPAREN data COMMA policy RPAREN
    ;

data
    : expression
    ;

policy
    : expression
    ;

authentication_property
    : AUTHENTICATION_ LPAREN entity COMMA credential RPAREN
    ;

entity
    : expression
    ;

credential
    : expression
    ;

non_repudiation_property
    : NON_REPUDIATION_ LPAREN action COMMA evidence RPAREN
    ;

action
    : expression
    ;

evidence
    : expression
    ;

integrity_property
    : INTEGRITY_ LPAREN data COMMA checksum RPAREN
    ;

checksum
    : expression
    ;

availability_property
    : AVAILABILITY_ LPAREN resource COMMA redundancy RPAREN
    ;

resource
    : expression
    ;

redundancy
    : expression
    ;

freshness_property
    : FRESHNESS_ LPAREN timestamp COMMA nonce RPAREN
    ;

timestamp
    : expression
    ;

nonce
    : expression
    ;

forward_secrecy_property
    : FORWARD_SECRECY_ LPAREN session_key COMMA compromise_time RPAREN
    ;

session_key
    : expression
    ;

compromise_time
    : expression
    ;

backward_secrecy_property
    : BACKWARD_SECRECY_ LPAREN session_key COMMA compromise_time RPAREN
    ;

perfect_secrecy_property
    : PERFECT_SECRECY_ LPAREN key_expr COMMA message RPAREN
    ;

key_expr
    : expression
    ;

computational_security_property
    : COMPUTATIONAL_SECURITY_ LPAREN algorithm COMMA security_parameter RPAREN
    ;

algorithm
    : expression
    ;

security_parameter
    : expression
    ;

information_theoretic_property
    : INFORMATION_THEORETIC_ LPAREN entropy COMMA min_entropy RPAREN
    ;

entropy
    : expression
    ;

min_entropy
    : expression
    ;

// Metaprogramming Grammar Rules
compile_time_function
    : COMPILE_TIME_ FN IDENTIFIER LPAREN parameters? RPAREN
      (ARROW return_type)? ASSIGN expression
    ;

macro_definition
    : MACRO_ IDENTIFIER LPAREN macro_params? RPAREN ASSIGN macro_body
    ;

macro_params
    : IDENTIFIER (COMMA IDENTIFIER)*
    ;

macro_body
    : expression
    | LBRACE statement* RBRACE
    ;

macro_invocation
    : IDENTIFIER NOT LPAREN arguments? RPAREN
    ;

macro_rules_definition
    : MACRO_RULES_ IDENTIFIER LBRACE macro_rule* RBRACE
    ;

macro_rule
    : LPAREN pattern RPAREN ARROW LPAREN template RPAREN
    ;

template
    : expression
    ;

syntax_extension
    : SYNTAX_ IDENTIFIER ASSIGN syntax_rule
    ;

syntax_rule
    : expression
    ;

proc_macro
    : PROC_ MACRO_ FN IDENTIFIER LPAREN parameters RPAREN ARROW return_type
    ;

derive_macro
    : DERIVE_ LPAREN trait_list RPAREN
    ;

trait_list
    : IDENTIFIER (COMMA IDENTIFIER)*
    ;

attribute_macro
    : ATTRIBUTE_ LPAREN attribute_name RPAREN
    ;

attribute_name
    : IDENTIFIER
    ;

annotation
    : ANNOTATION_ LPAREN annotation_name RPAREN
    ;

annotation_name
    : IDENTIFIER
    ;

decorator
    : DECORATOR_ LPAREN decorator_name RPAREN
    ;

decorator_name
    : IDENTIFIER
    ;

meta_programming
    : META_ LPAREN meta_operation RPAREN
    ;

meta_operation
    : REFLECTION_ | INTROSPECTION_ | CODEGEN_
    ;

template_metaprogramming
    : TEMPLATE_ LT type_ GT LPAREN template_args RPAREN
    ;

template_args
    : expression (COMMA expression)*
    ;

generic_specialization
    : SPECIALIZATION_ LT type_args GT FOR type_
    ;

monomorphization
    : MONOMORPHIZATION_ LT type_ GT
    ;

const_evaluation
    : CONST_EVAL_ LPAREN expression RPAREN
    ;

static_analysis
    : STATIC LBRACE analysis_directive* RBRACE
    ;

analysis_directive
    : DEBUG_ | RELEASE_ | TEST_ | BENCH_ | DOC_ | EXAMPLE_
    ;

conditional_compilation
    : CFG_ LPAREN condition RPAREN LBRACE declaration* RBRACE
    ;

condition
    : expression
    ;

feature_gate
    : FEATURE_ LPAREN feature_name RPAREN
    ;

feature_name
    : IDENTIFIER
    ;

// Advanced Expression Grammar Rules
property_access
    : PROPERTY_ LPAREN expression COMMA property_name RPAREN
    ;

property_name
    : IDENTIFIER
    ;

computed_property
    : COMPUTED_ LPAREN expression COMMA computed_index_expr RPAREN
    ;

computed_index_expr
    : expression
    ;

chained_expression
    : CHAINED_ LPAREN expression (DOT method_call)* RPAREN
    ;

method_call
    : IDENTIFIER LPAREN arguments? RPAREN
    ;

pipeline_expr
    : PIPELINE_ LPAREN expression (PIPE_ pipeline_op)* RPAREN
    ;

pipeline_op
    : expression
    ;

composition_expression
    : COMPOSITION_ LPAREN expression COMMA expression RPAREN
    ;

partial_app_expr
    : PARTIAL_APP_ LPAREN expression COMMA partial_app_args RPAREN
    ;

partial_app_args
    : expression (COMMA expression)*
    ;

currying_expression
    : CURRYING_ LPAREN multi_arg_function RPAREN
    ;

multi_arg_function
    : expression
    ;

lazy_evaluation
    : LAZY_EVAL_ LPAREN expression RPAREN
    ;

strict_evaluation
    : STRICT_EVAL_ LPAREN expression RPAREN
    ;

memoization
    : MEMOIZATION_ LPAREN expression RPAREN
    ;

caching_expression
    : CACHING_ LPAREN expression RPAREN
    ;

parallel_computation
    : PARALLEL_ LPAREN expression RPAREN
    ;

concurrent_expression
    : CONCURRENT_ LPAREN expression RPAREN
    ;

atomic_operation
    : ATOMIC_ LPAREN expression RPAREN
    ;

synchronized_block
    : SYNCHRONIZED_ LPAREN lock RPAREN LBRACE statement* RBRACE
    ;

lock
    : expression
    ;

volatile_access
    : VOLATILE_ LPAREN expression RPAREN
    ;

immutable_value
    : IMMUTABLE_ LPAREN expression RPAREN
    ;

mutable_reference
    : MUTABLE_ LPAREN expression RPAREN
    ;

shared_reference
    : SHARED_ LPAREN expression RPAREN
    ;

owned_value
    : OWNED_ LPAREN expression RPAREN
    ;

borrowed_reference
    : BORROWED_ LPAREN expression RPAREN
    ;

lifetime_annotation
    : LIFETIME_ LPAREN expression RPAREN
    ;

scope_expression
    : SCOPE_ LPAREN expression RPAREN
    ;

region_expression
    : REGION_ LPAREN expression RPAREN
    ;

arena_allocation
    : ARENA_ LPAREN expression RPAREN
    ;

bump_allocation
    : BUMP_ LPAREN expression RPAREN
    ;

trace_expression
    : TRACE_ LPAREN expression RPAREN
    ;

garbage_collection
    : GC_ LPAREN collection_strategy RPAREN
    ;

collection_strategy
    : RC_ | ARC_
    ;

pinned_memory
    : PINNED_ LPAREN expression RPAREN
    ;

unpinned_memory
    : UNPINNED_ LPAREN expression RPAREN
    ;