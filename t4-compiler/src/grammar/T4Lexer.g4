/**
 * T4 Lexer Grammar
 *
 * This file defines the lexical tokens for the T4 programming language,
 * a security-first language designed for cryptographic workloads and
 * post-quantum security with built-in support for modern cryptographic
 * primitives while maintaining memory safety.
 *
 * Author: T4 Compiler Team
 * Version: 2.0 - Advanced Grammar Extension
 */

lexer grammar T4Lexer;

// ====================
// WHITESPACE AND COMMENTS
// ====================
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

// ====================
// CORE LANGUAGE KEYWORDS
// ====================
MODULE: 'module';
IMPORT: 'import';
EXPORT: 'export';
FN: 'fn';
LET: 'let';
MUT: 'mut';
CONST: 'const';
STATIC: 'static';
STRUCT: 'struct';
ENUM: 'enum';
TRAIT: 'trait';
IMPL: 'impl';
FOR: 'for';
IN: 'in';
IF: 'if';
ELSE: 'else';
MATCH: 'match';
WHILE: 'while';
LOOP: 'loop';
BREAK: 'break';
CONTINUE: 'continue';
RETURN: 'return';
YIELD: 'yield';
ASYNC: 'async';
AWAIT: 'await';
TYPE: 'type';
ALIAS: 'alias';
WHERE_: 'where';
SELF_: 'self';
SUPER_: 'super';
CRATE_: 'crate';
USE_: 'use';
PUB_: 'pub';
PRIVATE_: 'private';
PROTECTED_: 'protected';

// ====================
// CRYPTOGRAPHIC KEYWORDS
// ====================
// Cryptographic type keywords for built-in security types
KEY_: 'Key';
SECRET_: 'Secret';
PUBLICKEY_: 'PublicKey';
PRIVATEKEY_: 'PrivateKey';
SIGNATURE_: 'Signature';
CIPHERTEXT_: 'Ciphertext';
PLAINTEXT_: 'Plaintext';
HASH_: 'Hash';
NONCE_: 'Nonce';
SALT_: 'Salt';

// Cryptographic operation keywords
CRYPTO_: 'crypto';
ENCRYPT_: 'encrypt';
DECRYPT_: 'decrypt';
SIGN_: 'sign';
VERIFY_: 'verify';
PROOF_: 'proof';
WITNESS_: 'witness';
COMMIT_: 'commit';
REVEAL_: 'reveal';

// ====================
// SECURITY ANNOTATIONS
// ====================
// Security and cryptographic verification annotations
CONSTANT_TIME_: 'constant_time';
CACHE_RESISTANT_: 'cache_resistant';
SECURE_MEMORY_: 'secure_memory';
VERIFY_PROTOCOL_: 'verify_protocol';
WIPE_ON_DROP_: 'wipe_on_drop';
DISTRIBUTED_: 'distributed';
THRESHOLD_SIGN_: 'threshold_sign';
VERIFY_SOUNDNESS_: 'verify_soundness';
VERIFY_ZERO_KNOWLEDGE_: 'verify_zero_knowledge';
POWER_RESISTANT_: 'power_resistant';

// Module system
CONFIG_: 'config';
EXTERN_: 'extern';
AS_: 'as';

// Error handling
RESULT_: 'Result';
OK_: 'Ok';
ERR_: 'Err';

// Basic literals
INTEGER: [0-9]+;
HEX_INTEGER: '0x' [0-9a-fA-F]+;
OCT_INTEGER: '0o' [0-7]+;
BIN_INTEGER: '0b' [01]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: '"' (~["\\] | '\\' .)* '"';
BYTE_STRING: 'b"' (~["\\] | '\\' .)* '"';
CHAR: '\'' (~['\\] | '\\' .) '\'';

// Boolean literals
TRUE: 'true';
FALSE: 'false';

// Cryptographic algorithm names (simplified - would be extended)
AES256: 'AES256';
KYBER1024: 'Kyber1024';
DILITHIUM3: 'Dilithium3';
ED25519: 'Ed25519';
P256: 'P256';
FALCON512: 'Falcon512';
CKKS: 'CKKS';
GROTH16: 'Groth16';
BULLETPROOFS: 'Bulletproofs';
STARK: 'STARK';
PLONK: 'PLONK';

// Operators
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
PERCENT: '%';
CARET: '^';
NOT: '!';
AND: '&';
OR: '|';
ANDAND: '&&';
OROR: '||';
SHL: '<<';
SHR: '>>';

// Comparison operators
EQ: '==';
NE: '!=';
LT: '<';
GT: '>';
LE: '<=';
GE: '>=';

// Assignment operators
ASSIGN: '=';
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
STAR_ASSIGN: '*=';
SLASH_ASSIGN: '/=';
PERCENT_ASSIGN: '%=';
AND_ASSIGN: '&=';
OR_ASSIGN: '|=';
XOR_ASSIGN: '^=';
SHL_ASSIGN: '<<=';
SHR_ASSIGN: '>>=';

// Delimiters
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';
RBRACKET: ']';
COMMA: ',';
COLON: ':';
COLONCOLON: '::';
SEMICOLON: ';';
DOT: '.';
ARROW: '->';
FAT_ARROW: '=>';
QUESTION: '?';
AT: '@';
DOLLAR: '$';
UNDERSCORE: '_';

// Security attribute prefix
HASH_LBRACKET: '#[';

// Identifiers
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

// Lifetime annotations
LIFETIME: '\'' [a-zA-Z_][a-zA-Z0-9_]*;

// Raw identifiers
RAW_IDENTIFIER: 'r#' [a-zA-Z_][a-zA-Z0-9_]*;

// Module paths
MODULE_PATH: IDENTIFIER (COLONCOLON IDENTIFIER)*;

// Type paths
TYPE_PATH: (MODULE_PATH COLONCOLON)? IDENTIFIER;

// Algorithm constraints
ALGORITHM: 'Algorithm';
KEY_EXCHANGE: 'KeyExchange';
SIGNATURE_SCHEME: 'SignatureScheme';
ENCRYPTION_SCHEME: 'EncryptionScheme';
ZKP_SYSTEM: 'ZKPSystem';
HOMOMORPHIC_SCHEME: 'HomomorphicScheme';
THRESHOLD_SCHEME: 'ThresholdScheme';
THRESHOLD_SIGNATURE_SCHEME: 'ThresholdSignatureScheme';

// Security levels
SECURITY_LEVEL: 'SecurityLevel';
LEVEL1: 'Level1';
LEVEL2: 'Level2';
LEVEL3: 'Level3';
LEVEL4: 'Level4';
LEVEL5: 'Level5';

// Cryptographic constants
NIST_LEVEL: 'NISTLevel';
KEY_SIZE: 'KeySize';
BLOCK_SIZE: 'BlockSize';
SECURITY_PARAMETER: 'SecurityParameter';

// Module configuration
DEFAULT_CRYPTO_PROVIDER: 'default_crypto_provider';
POST_QUANTUM_ENABLED: 'post_quantum_enabled';
HARDWARE_ACCELERATION: 'hardware_acceleration';

// Error types
CRYPTO_ERROR: 'CryptoError';
INVALID_KEY: 'InvalidKey';
DECRYPTION_FAILED: 'DecryptionFailed';
AUTHENTICATION_FAILED: 'AuthenticationFailed';
WEAK_PARAMETER: 'WeakParameter';
HARDWARE_FAILURE: 'HardwareFailure';
TIMING_ATTACK_DETECTED: 'TimingAttackDetected';

// External library declarations
LIBCRYPTO: 'libcrypto';
LIBSSL: 'libssl';

// Additional basic types
INT8: 'Int8';
INT16: 'Int16';
INT32: 'Int32';
INT64: 'Int64';
UINT8: 'UInt8';
UINT16: 'UInt16';
UINT32: 'UInt32';
UINT64: 'UInt64';
FLOAT32: 'Float32';
FLOAT64: 'Float64';
BOOL: 'Bool';
STRING_: 'String';
BYTES: 'Bytes';

// ====================
// ADDITIONAL CORE KEYWORDS
// ====================
NEW: 'new';
REF: 'ref';
KEM_: 'kem';
VERIFY_PROOF_: 'verify_proof';

// ====================
// ADVANCED TYPE SYSTEM KEYWORDS
// ====================
// Keywords for generic types, higher-kinded types, and advanced type constructs
GENERIC_: 'Generic';
CONSTRAINT_: 'Constraint';
ASSOCIATED_: 'Associated';
TRAIT_BOUND_: 'TraitBound';
HIGHER_KINDED_: 'HigherKinded';
EXISTENTIAL_: 'Existential';
CRYPTO_PARAM_: 'CryptoParam';
TYPE_FAMILY_: 'TypeFamily';
KIND_: 'Kind';
TYPE_LEVEL_: 'TypeLevel';
PHANTOM_: 'Phantom';
ZERO_SIZED_: 'ZeroSized';

// Generic type parameter keywords
FORALL_: 'forall';
EXISTS_: 'exists';
IMPLIES_: 'implies';

// Associated types and traits
TRAIT_ASSOC_: 'trait_assoc';
IMPL_ASSOC_: 'impl_assoc';
ASSOCIATED_TYPE_: 'associated_type';
ASSOCIATED_CONST_: 'associated_const';

// Higher-kinded type keywords
HKT_: 'HKT';
TYPE_CONSTRUCTOR_: 'TypeConstructor';
TYPE_APPLICATION_: 'TypeApplication';
KIND_ARROW_: '->>';
KIND_STAR_: '★';

// Existential type keywords
DYNT_: 'dyn';
ANY_: 'any';
SOME_: 'some';

// Cryptographic type parameters
CRYPTO_ALG_: 'CryptoAlg';
SECURITY_PARAM_: 'SecurityParam';
KEY_TYPE_: 'KeyType';
CIPHER_TYPE_: 'CipherType';
SIGNATURE_TYPE_: 'SignatureType';
HASH_TYPE_: 'HashType';
PROTOCOL_TYPE_: 'ProtocolType';


// Additional Security Annotations and Attributes
TIMING_RESISTANT_: 'timing_resistant';
FAULT_RESISTANT_: 'fault_resistant';
LEAKAGE_RESISTANT_: 'leakage_resistant';
SECURE_EXECUTION_: 'secure_execution';
TRUSTED_EXECUTION_: 'trusted_execution';
ENCLAVE_: 'enclave';
SECURE_CHANNEL_: 'secure_channel';
AUTHENTICATED_: 'authenticated';
CONFIDENTIAL_: 'confidential';
INTEGRITY_CHECK_: 'integrity_check';
FRESHNESS_CHECK_: 'freshness_check';
NON_REPLAYABLE_: 'non_replayable';
FORWARD_SECURE_: 'forward_secure';
POST_COMPROMISE_: 'post_compromise';

// Advanced Function Features
CLOSURE_: 'closure';
LAMBDA_: 'lambda';
OPERATOR_: 'operator';
OVERLOAD_: 'overload';
FUNCTION_PTR_: 'function_ptr';
CALLABLE_: 'callable';
STREAM_: 'stream';
ITERATOR_: 'iterator';
GENERATOR_: 'generator';
COROUTINE_: 'coroutine';
CONTINUATION_: 'continuation';
PARTIAL_: 'partial';
CURRY_: 'curry';
COMPOSE_: 'compose';
PIPE_: 'pipe';
CHAIN_: 'chain';

// Module System Extensions
SECURE_: 'secure';
ISOLATED_: 'isolated';
TRUSTED_: 'trusted';
UNTRUSTED_: 'untrusted';
SENSITIVE_: 'sensitive';
CLASSIFIED_: 'classified';
COMPARTMENT_: 'compartment';
NAMESPACE_: 'namespace';
PACKAGE_: 'package';
LIBRARY_: 'library';
FRAMEWORK_: 'framework';
COMPONENT_: 'component';
SERVICE_: 'service';
MICROSERVICE_: 'microservice';
API_: 'api';
INTERFACE_: 'interface';

// Advanced Control Flow
PATTERN_: 'pattern';
GUARD_: 'guard';
BINDING_: 'binding';
DESTRUCTURE_: 'destructure';
COMPREHENSION_: 'comprehension';
ITERATOR_CHAIN_: 'iterator_chain';
EARLY_RETURN_: 'early_return';
LIST_: 'list';
VECTOR_: 'vector';
SET_: 'set';
RANGE_: 'range';
INCLUSIVE_: 'inclusive';
EXCLUSIVE_: 'exclusive';
STEP_: 'step';
FILTER_: 'filter';
REDUCE_: 'reduce';
FOLD_: 'fold';
FLATTEN_: 'flatten';
ZIP_: 'zip';
ENUMERATE_: 'enumerate';
TAKE_: 'take';
SKIP_: 'skip';
CYCLE_: 'cycle';
REPEAT_: 'repeat';

// Cryptographic-Specific Syntax
KEY_LITERAL_: 'key_literal';
SECRET_LITERAL_: 'secret_literal';
CRYPTO_OP_: 'crypto_op';
PROTOCOL_: 'protocol';
ZERO_KNOWLEDGE_: 'zero_knowledge';
HOMOMORPHIC_: 'homomorphic';
MULTIPARTY_: 'multiparty';
THRESHOLD_: 'threshold';
DISTRIBUTED_KEY_: 'distributed_key';
SECURE_COMPUTATION_: 'secure_computation';
OBLIVIOUS_: 'oblivious';
PRIVATE_SET_: 'private_set';
PRIVATE_INFO_: 'private_info';
SECURE_SEARCH_: 'secure_search';
ANONYMOUS_: 'anonymous';
UNTRACEABLE_: 'untraceable';
CONFIDENTIALITY_: 'confidentiality';
AUTHENTICATION_: 'authentication';
NON_REPUDIATION_: 'non_repudiation';
INTEGRITY_: 'integrity';
AVAILABILITY_: 'availability';
FRESHNESS_: 'freshness';
FORWARD_SECRECY_: 'forward_secrecy';
BACKWARD_SECRECY_: 'backward_secrecy';
PERFECT_SECRECY_: 'perfect_secrecy';
COMPUTATIONAL_SECURITY_: 'computational_security';
INFORMATION_THEORETIC_: 'information_theoretic';

// Metaprogramming Features
COMPILE_TIME_: 'compile_time';
RUNTIME_: 'runtime';
MACRO_: 'macro';
MACRO_RULES_: 'macro_rules';
SYNTAX_: 'syntax';
PROC_: 'proc';
DERIVE_: 'derive';
ATTRIBUTE_: 'attribute';
ANNOTATION_: 'annotation';
DECORATOR_: 'decorator';
META_: 'meta';
REFLECTION_: 'reflection';
INTROSPECTION_: 'introspection';
CODEGEN_: 'codegen';
TEMPLATE_: 'template';
GENERICS_: 'generics';
SPECIALIZATION_: 'specialization';
MONOMORPHIZATION_: 'monomorphization';
CONST_EVAL_: 'const_eval';
DYNAMIC_: 'dynamic';
LAZY_: 'lazy';
EAGER_: 'eager';
STRICT_: 'strict';
LENIENT_: 'lenient';
DEBUG_: 'debug';
RELEASE_: 'release';
TEST_: 'test';
BENCH_: 'bench';
DOC_: 'doc';
EXAMPLE_: 'example';
CFG_: 'cfg';
FEATURE_: 'feature';

// Advanced Expression Features
PROPERTY_: 'property';
COMPUTED_: 'computed';
INDEXED_: 'indexed';
CHAINED_: 'chained';
PIPELINE_: 'pipeline';
COMPOSITION_: 'composition';
PARTIAL_APP_: 'partial_app';
CURRYING_: 'currying';
LAZY_EVAL_: 'lazy_eval';
STRICT_EVAL_: 'strict_eval';
MEMOIZATION_: 'memoization';
CACHING_: 'caching';
PARALLEL_: 'parallel';
CONCURRENT_: 'concurrent';
ATOMIC_: 'atomic';
SYNCHRONIZED_: 'synchronized';
VOLATILE_: 'volatile';
IMMUTABLE_: 'immutable';
MUTABLE_: 'mutable';
SHARED_: 'shared';
OWNED_: 'owned';
BORROWED_: 'borrowed';
LIFETIME_: 'lifetime';
SCOPE_: 'scope';
REGION_: 'region';
ARENA_: 'arena';
BUMP_: 'bump';
TRACE_: 'trace';
GC_: 'gc';
RC_: 'rc';
ARC_: 'arc';
PINNED_: 'pinned';
UNPINNED_: 'unpinned';

// ====================
// ADDITIONAL TOKENS FOR PARSER GRAMMAR
// ====================
// Additional tokens needed by parser grammar rules
PROOF_SYSTEM_: 'proof_system';
SECURITY_PARAMETER_: 'security_parameter';
ENCRYPTION_SCHEME_: 'encryption_scheme';
IMPLEMENTS_: 'implements';
ENDPOINT_: 'endpoint';
REQUIRED_: 'required';
ENCRYPTION_: 'encryption';
DECRYPTION_: 'decryption';
VERIFICATION_: 'verification';
KEY_EXCHANGE_: 'key_exchange';
MAC_: 'mac';
SEND_: 'send';
RECEIVE_: 'receive';
COMPUTE_: 'compute';
ADD_: 'add';
SUB_: 'sub';
MUL_: 'mul';
DIV_: 'div';
ONION_: 'onion';
MIXNET_: 'mixnet';
DCNET_: 'dcnet';

// Additional missing tokens
MOVE: 'move';
MAP_TRANSFORM_: 'map_transform';