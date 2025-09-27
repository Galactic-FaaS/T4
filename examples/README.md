# T4 Programming Language Examples and Test Cases

This directory contains comprehensive examples and test cases demonstrating all major features of the T4 programming language, with a focus on its security-first approach and cryptographic capabilities.

## Directory Structure

```
examples/
├── basics/                 # Basic language features
│   ├── hello_world.t4     # Hello World and basic I/O
│   ├── data_types.t4      # Data types and type system
│   ├── control_flow.t4    # Control flow structures
│   ├── functions_modules.t4 # Functions and module system
│   └── error_handling.t4  # Error handling patterns
├── crypto/                # Cryptographic examples
│   ├── symmetric_asymmetric.t4 # Symmetric and asymmetric encryption
│   ├── signatures_key_exchange.t4 # Digital signatures and key exchange
│   └── hash_post_quantum.t4 # Hash functions and post-quantum crypto
├── applications/          # Real-world applications (to be added)
├── advanced/             # Advanced features (to be added)
├── performance/          # Performance examples (to be added)
└── tests/                # Test suites
    ├── unit_tests.t4     # Comprehensive unit tests
    └── security_tests.t4 # Security-focused tests
```

## Examples Overview

### Basic Language Examples (`basics/`)

#### 1. Hello World (`hello_world.t4`)
- Basic T4 syntax and structure
- Secure console I/O operations
- UTF-8 string handling
- Basic data types (integers, floats, booleans, strings)
- Secure memory management
- Cryptographic string operations with constant-time comparison

**Key Features Demonstrated:**
- Module system with cryptographic library imports
- Configuration management
- Secure memory handling
- Constant-time operations
- Automatic memory wiping

#### 2. Data Types (`data_types.t4`)
- All T4 primitive types (Int8, Int16, Int32, Int64, UInt8, UInt16, UInt32, UInt64)
- Floating-point types (Float32, Float64)
- Boolean and character types
- String operations with UTF-8 support
- Array operations (fixed-size and dynamic)
- Vector operations
- HashMap operations
- Cryptographic data types (Key, Secret, PublicKey, PrivateKey, etc.)

**Key Features Demonstrated:**
- Type safety and bounds checking
- Unicode/UTF-8 support
- Cryptographic type system
- Memory-safe collections
- Type conversion operations

#### 3. Control Flow (`control_flow.t4`)
- Conditional statements (if-else, if-else if-else)
- Loop constructs (for, while, loop with break/continue)
- Match expressions for pattern matching
- Error handling with Result and Option types
- Advanced control flow with labeled breaks
- Iteration patterns and early returns

**Key Features Demonstrated:**
- Pattern matching
- Error propagation with `?` operator
- Labeled loops and control flow
- Comprehensive error handling
- Control flow security considerations

#### 4. Functions and Modules (`functions_modules.t4`)
- Function definitions and calls
- Parameter passing and return values
- Generic functions with type constraints
- Higher-order functions
- Module system with nested modules
- Module exports and imports
- Function composition and closures

**Key Features Demonstrated:**
- Generic programming
- Higher-order functions
- Module organization
- Information hiding
- Function composition patterns

#### 5. Error Handling (`error_handling.t4`)
- Result type for error handling
- Option type for nullable values
- Custom error types with enums
- Error propagation patterns
- Recovery strategies
- Security-focused error handling
- Memory-safe error handling

**Key Features Demonstrated:**
- Comprehensive error handling
- Custom error types
- Error context and debugging
- Security considerations in error handling

### Cryptographic Examples (`crypto/`)

#### 1. Symmetric and Asymmetric Encryption (`symmetric_asymmetric.t4`)
- AES-256 encryption/decryption
- ChaCha20 stream cipher
- Authenticated encryption (AES-GCM)
- RSA encryption/decryption
- Elliptic curve cryptography (ECC)
- Key derivation and management
- Hybrid encryption schemes

**Key Features Demonstrated:**
- Multiple encryption algorithms
- Authenticated encryption
- Key management security
- Memory-safe cryptographic operations
- Error handling in cryptographic contexts

#### 2. Digital Signatures and Key Exchange (`signatures_key_exchange.t4`)
- Ed25519 digital signatures
- ECDSA signatures
- RSA signatures with PSS padding
- Diffie-Hellman key exchange
- ECDH key exchange
- Threshold signatures
- Blind signatures
- Certificate creation and verification

**Key Features Demonstrated:**
- Multiple signature schemes
- Key exchange protocols
- Threshold cryptography
- Certificate-based authentication
- Real-world signing scenarios

#### 3. Hash Functions and Post-Quantum Cryptography (`hash_post_quantum.t4`)
- SHA-3 hash function family
- SHAKE extendable output functions
- BLAKE2 hash functions
- Hash-based applications (passwords, integrity)
- CRYSTALS-Kyber key encapsulation
- CRYSTALS-Dilithium signatures
- Falcon signatures
- Post-quantum hybrid schemes
- Security level comparisons

**Key Features Demonstrated:**
- Cryptographic hash functions
- Post-quantum cryptography
- Hybrid classical/PQ schemes
- Performance characteristics
- Security level mappings

### Test Suites (`tests/`)

#### 1. Unit Tests (`unit_tests.t4`)
- Comprehensive test framework
- Basic data type tests
- Collection operation tests
- Cryptographic operation tests
- String and math operation tests
- Control flow tests
- Error handling tests
- Performance tests

**Key Features Demonstrated:**
- Custom test framework
- Assertion functions
- Test organization and reporting
- Performance measurement
- Error collection and reporting

#### 2. Security Tests (`security_tests.t4`)
- Secret memory handling tests
- Constant-time operation tests
- Key security tests
- Authentication security tests
- Side-channel resistance tests
- Protocol security tests
- Post-quantum security tests
- Security violation detection

**Key Features Demonstrated:**
- Security-focused testing
- Violation detection
- Performance security testing
- Cryptographic security verification

## Key T4 Features Demonstrated

### Security-First Design
- **Memory Safety**: Automatic memory wiping, bounds checking, secure allocation
- **Constant-Time Operations**: Timing attack prevention, secure comparisons
- **Side-Channel Resistance**: Cache timing protection, power analysis resistance
- **Cryptographic Safety**: Secure key management, safe cryptographic operations

### Type System
- **Cryptographic Types**: Key<T>, Secret<T>, PublicKey<T>, PrivateKey<T>, etc.
- **Security Annotations**: constant_time, cache_resistant, secure_memory
- **Generic Types**: Algorithm-specific type parameters
- **Error Types**: Result<T, E>, Option<T> with security considerations

### Cryptographic Capabilities
- **Modern Algorithms**: AES, ChaCha20, RSA, ECC, Ed25519, ECDSA
- **Post-Quantum Cryptography**: Kyber, Dilithium, Falcon, SPHINCS+
- **Advanced Protocols**: Threshold signatures, zero-knowledge proofs, homomorphic encryption
- **Secure Protocols**: TLS-like constructions, authenticated key exchange

### Module System
- **Organized Code**: Hierarchical module structure
- **Secure Imports**: Cryptographic library integration
- **Configuration Management**: Compile-time algorithm selection
- **Information Hiding**: Public/private module interfaces

## Running the Examples

### Prerequisites
- T4 compiler (`t4c`)
- T4 runtime environment
- Required cryptographic libraries (libcrypto, libssl)

### Compilation and Execution
```bash
# Compile an example
t4c examples/basics/hello_world.t4

# Run the compiled program
./hello_world

# Compile and run cryptographic examples
t4c examples/crypto/symmetric_asymmetric.t4
./symmetric_asymmetric

# Run test suites
t4c examples/tests/unit_tests.t4
./unit_tests

t4c examples/tests/security_tests.t4
./security_tests
```

### Expected Output
Each example includes detailed console output showing:
- Operation results
- Performance metrics
- Security verification results
- Error handling demonstrations

## Security Considerations

All examples follow T4's security-first approach:

1. **Memory Safety**: All sensitive data is automatically wiped when it goes out of scope
2. **Constant-Time Operations**: Cryptographic operations use constant-time algorithms
3. **Input Validation**: All inputs are validated for security
4. **Error Handling**: Comprehensive error handling with security considerations
5. **Side-Channel Protection**: Operations are designed to resist timing and cache attacks

## Performance Characteristics

The examples demonstrate T4's performance capabilities:

- **Cryptographic Performance**: High-speed encryption/decryption operations
- **Memory Efficiency**: Secure memory management with minimal overhead
- **Scalability**: Examples show performance under load
- **Optimization**: Demonstrates both security and performance optimization

## Testing Coverage

The test suites provide comprehensive coverage:

- **Unit Tests**: 16 test categories covering all language features
- **Security Tests**: 12 security-focused test categories
- **Performance Tests**: Load testing and performance verification
- **Integration Tests**: Real-world usage scenario testing

## Future Examples

Additional examples to be developed:

1. **Real-World Applications**:
   - Secure messaging application
   - Blockchain/cryptocurrency implementation
   - TLS-like protocol implementation
   - Secure web server

2. **Advanced Features**:
   - Zero-knowledge proof implementations
   - Homomorphic encryption usage
   - Secure multi-party computation
   - Advanced protocol compositions

3. **Performance Examples**:
   - Memory-efficient large data processing
   - Concurrent and parallel processing
   - Cryptographic operation optimization
   - Benchmarking and profiling

## Contributing

When adding new examples:

1. Follow T4's security-first design principles
2. Include comprehensive documentation
3. Add appropriate test cases
4. Demonstrate both functionality and security features
5. Include performance considerations
6. Document any external dependencies

## License

These examples are part of the T4 programming language project and follow the same licensing terms as the T4 compiler and runtime system.