// Generated from c:/Users/tirpi/OneDrive/Documents/GitHub/T4/t4-compiler/src/grammar/T4Parser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class T4Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, LINE_COMMENT=2, BLOCK_COMMENT=3, MODULE=4, IMPORT=5, EXPORT=6, FN=7, 
		LET=8, MUT=9, CONST=10, STATIC=11, STRUCT=12, ENUM=13, TRAIT=14, IMPL=15, 
		FOR=16, IN=17, IF=18, ELSE=19, MATCH=20, WHILE=21, LOOP=22, BREAK=23, 
		CONTINUE=24, RETURN=25, YIELD=26, ASYNC=27, AWAIT=28, TYPE=29, ALIAS=30, 
		WHERE_=31, SELF_=32, SUPER_=33, CRATE_=34, USE_=35, PUB_=36, PRIVATE_=37, 
		PROTECTED_=38, KEY_=39, SECRET_=40, PUBLICKEY_=41, PRIVATEKEY_=42, SIGNATURE_=43, 
		CIPHERTEXT_=44, PLAINTEXT_=45, HASH_=46, NONCE_=47, SALT_=48, CRYPTO_=49, 
		ENCRYPT_=50, DECRYPT_=51, SIGN_=52, VERIFY_=53, PROOF_=54, WITNESS_=55, 
		COMMIT_=56, REVEAL_=57, CONSTANT_TIME_=58, CACHE_RESISTANT_=59, SECURE_MEMORY_=60, 
		VERIFY_PROTOCOL_=61, WIPE_ON_DROP_=62, DISTRIBUTED_=63, THRESHOLD_SIGN_=64, 
		VERIFY_SOUNDNESS_=65, VERIFY_ZERO_KNOWLEDGE_=66, POWER_RESISTANT_=67, 
		CONFIG_=68, EXTERN_=69, AS_=70, RESULT_=71, OK_=72, ERR_=73, INTEGER=74, 
		HEX_INTEGER=75, OCT_INTEGER=76, BIN_INTEGER=77, FLOAT=78, STRING=79, BYTE_STRING=80, 
		CHAR=81, TRUE=82, FALSE=83, AES256=84, KYBER1024=85, DILITHIUM3=86, ED25519=87, 
		P256=88, FALCON512=89, CKKS=90, GROTH16=91, BULLETPROOFS=92, STARK=93, 
		PLONK=94, PLUS=95, MINUS=96, STAR=97, SLASH=98, PERCENT=99, CARET=100, 
		NOT=101, AND=102, OR=103, ANDAND=104, OROR=105, SHL=106, SHR=107, EQ=108, 
		NE=109, LT=110, GT=111, LE=112, GE=113, ASSIGN=114, PLUS_ASSIGN=115, MINUS_ASSIGN=116, 
		STAR_ASSIGN=117, SLASH_ASSIGN=118, PERCENT_ASSIGN=119, AND_ASSIGN=120, 
		OR_ASSIGN=121, XOR_ASSIGN=122, SHL_ASSIGN=123, SHR_ASSIGN=124, LPAREN=125, 
		RPAREN=126, LBRACE=127, RBRACE=128, LBRACKET=129, RBRACKET=130, COMMA=131, 
		COLON=132, COLONCOLON=133, SEMICOLON=134, DOT=135, ARROW=136, FAT_ARROW=137, 
		QUESTION=138, AT=139, DOLLAR=140, UNDERSCORE=141, HASH_LBRACKET=142, IDENTIFIER=143, 
		LIFETIME=144, RAW_IDENTIFIER=145, MODULE_PATH=146, TYPE_PATH=147, ALGORITHM=148, 
		KEY_EXCHANGE=149, SIGNATURE_SCHEME=150, ENCRYPTION_SCHEME=151, ZKP_SYSTEM=152, 
		HOMOMORPHIC_SCHEME=153, THRESHOLD_SCHEME=154, THRESHOLD_SIGNATURE_SCHEME=155, 
		SECURITY_LEVEL=156, LEVEL1=157, LEVEL2=158, LEVEL3=159, LEVEL4=160, LEVEL5=161, 
		NIST_LEVEL=162, KEY_SIZE=163, BLOCK_SIZE=164, SECURITY_PARAMETER=165, 
		DEFAULT_CRYPTO_PROVIDER=166, POST_QUANTUM_ENABLED=167, HARDWARE_ACCELERATION=168, 
		CRYPTO_ERROR=169, INVALID_KEY=170, DECRYPTION_FAILED=171, AUTHENTICATION_FAILED=172, 
		WEAK_PARAMETER=173, HARDWARE_FAILURE=174, TIMING_ATTACK_DETECTED=175, 
		LIBCRYPTO=176, LIBSSL=177, INT8=178, INT16=179, INT32=180, INT64=181, 
		UINT8=182, UINT16=183, UINT32=184, UINT64=185, FLOAT32=186, FLOAT64=187, 
		BOOL=188, STRING_=189, BYTES=190, NEW=191, REF=192, KEM_=193, VERIFY_PROOF_=194, 
		GENERIC_=195, CONSTRAINT_=196, ASSOCIATED_=197, TRAIT_BOUND_=198, HIGHER_KINDED_=199, 
		EXISTENTIAL_=200, CRYPTO_PARAM_=201, TYPE_FAMILY_=202, KIND_=203, TYPE_LEVEL_=204, 
		PHANTOM_=205, ZERO_SIZED_=206, FORALL_=207, EXISTS_=208, IMPLIES_=209, 
		TRAIT_ASSOC_=210, IMPL_ASSOC_=211, ASSOCIATED_TYPE_=212, ASSOCIATED_CONST_=213, 
		HKT_=214, TYPE_CONSTRUCTOR_=215, TYPE_APPLICATION_=216, KIND_ARROW_=217, 
		KIND_STAR_=218, DYNT_=219, ANY_=220, SOME_=221, CRYPTO_ALG_=222, SECURITY_PARAM_=223, 
		KEY_TYPE_=224, CIPHER_TYPE_=225, SIGNATURE_TYPE_=226, HASH_TYPE_=227, 
		PROTOCOL_TYPE_=228, TIMING_RESISTANT_=229, FAULT_RESISTANT_=230, LEAKAGE_RESISTANT_=231, 
		SECURE_EXECUTION_=232, TRUSTED_EXECUTION_=233, ENCLAVE_=234, SECURE_CHANNEL_=235, 
		AUTHENTICATED_=236, CONFIDENTIAL_=237, INTEGRITY_CHECK_=238, FRESHNESS_CHECK_=239, 
		NON_REPLAYABLE_=240, FORWARD_SECURE_=241, POST_COMPROMISE_=242, CLOSURE_=243, 
		LAMBDA_=244, OPERATOR_=245, OVERLOAD_=246, FUNCTION_PTR_=247, CALLABLE_=248, 
		STREAM_=249, ITERATOR_=250, GENERATOR_=251, COROUTINE_=252, CONTINUATION_=253, 
		PARTIAL_=254, CURRY_=255, COMPOSE_=256, PIPE_=257, CHAIN_=258, SECURE_=259, 
		ISOLATED_=260, TRUSTED_=261, UNTRUSTED_=262, SENSITIVE_=263, CLASSIFIED_=264, 
		COMPARTMENT_=265, NAMESPACE_=266, PACKAGE_=267, LIBRARY_=268, FRAMEWORK_=269, 
		COMPONENT_=270, SERVICE_=271, MICROSERVICE_=272, API_=273, INTERFACE_=274, 
		PATTERN_=275, GUARD_=276, BINDING_=277, DESTRUCTURE_=278, COMPREHENSION_=279, 
		ITERATOR_CHAIN_=280, EARLY_RETURN_=281, LIST_=282, VECTOR_=283, SET_=284, 
		RANGE_=285, INCLUSIVE_=286, EXCLUSIVE_=287, STEP_=288, FILTER_=289, REDUCE_=290, 
		FOLD_=291, FLATTEN_=292, ZIP_=293, ENUMERATE_=294, TAKE_=295, SKIP_=296, 
		CYCLE_=297, REPEAT_=298, KEY_LITERAL_=299, SECRET_LITERAL_=300, CRYPTO_OP_=301, 
		PROTOCOL_=302, ZERO_KNOWLEDGE_=303, HOMOMORPHIC_=304, MULTIPARTY_=305, 
		THRESHOLD_=306, DISTRIBUTED_KEY_=307, SECURE_COMPUTATION_=308, OBLIVIOUS_=309, 
		PRIVATE_SET_=310, PRIVATE_INFO_=311, SECURE_SEARCH_=312, ANONYMOUS_=313, 
		UNTRACEABLE_=314, CONFIDENTIALITY_=315, AUTHENTICATION_=316, NON_REPUDIATION_=317, 
		INTEGRITY_=318, AVAILABILITY_=319, FRESHNESS_=320, FORWARD_SECRECY_=321, 
		BACKWARD_SECRECY_=322, PERFECT_SECRECY_=323, COMPUTATIONAL_SECURITY_=324, 
		INFORMATION_THEORETIC_=325, COMPILE_TIME_=326, RUNTIME_=327, MACRO_=328, 
		MACRO_RULES_=329, SYNTAX_=330, PROC_=331, DERIVE_=332, ATTRIBUTE_=333, 
		ANNOTATION_=334, DECORATOR_=335, META_=336, REFLECTION_=337, INTROSPECTION_=338, 
		CODEGEN_=339, TEMPLATE_=340, GENERICS_=341, SPECIALIZATION_=342, MONOMORPHIZATION_=343, 
		CONST_EVAL_=344, DYNAMIC_=345, LAZY_=346, EAGER_=347, STRICT_=348, LENIENT_=349, 
		DEBUG_=350, RELEASE_=351, TEST_=352, BENCH_=353, DOC_=354, EXAMPLE_=355, 
		CFG_=356, FEATURE_=357, PROPERTY_=358, COMPUTED_=359, INDEXED_=360, CHAINED_=361, 
		PIPELINE_=362, COMPOSITION_=363, PARTIAL_APP_=364, CURRYING_=365, LAZY_EVAL_=366, 
		STRICT_EVAL_=367, MEMOIZATION_=368, CACHING_=369, PARALLEL_=370, CONCURRENT_=371, 
		ATOMIC_=372, SYNCHRONIZED_=373, VOLATILE_=374, IMMUTABLE_=375, MUTABLE_=376, 
		SHARED_=377, OWNED_=378, BORROWED_=379, LIFETIME_=380, SCOPE_=381, REGION_=382, 
		ARENA_=383, BUMP_=384, TRACE_=385, GC_=386, RC_=387, ARC_=388, PINNED_=389, 
		UNPINNED_=390, PROOF_SYSTEM_=391, SECURITY_PARAMETER_=392, ENCRYPTION_SCHEME_=393, 
		IMPLEMENTS_=394, ENDPOINT_=395, REQUIRED_=396, ENCRYPTION_=397, DECRYPTION_=398, 
		VERIFICATION_=399, KEY_EXCHANGE_=400, MAC_=401, SEND_=402, RECEIVE_=403, 
		COMPUTE_=404, ADD_=405, SUB_=406, MUL_=407, DIV_=408, ONION_=409, MIXNET_=410, 
		DCNET_=411, MOVE=412, MAP_TRANSFORM_=413;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_module_declaration = 2, RULE_import_declaration = 3, 
		RULE_config_block = 4, RULE_config_item = 5, RULE_extern_block = 6, RULE_extern_function = 7, 
		RULE_function_declaration = 8, RULE_type_ = 9, RULE_basic_type = 10, RULE_cryptographic_type = 11, 
		RULE_algorithm_type = 12, RULE_type_path = 13, RULE_tuple_type = 14, RULE_array_type = 15, 
		RULE_slice_type = 16, RULE_reference_type = 17, RULE_mutable_reference_type = 18, 
		RULE_function_type = 19, RULE_generic_type = 20, RULE_type_args = 21, 
		RULE_generic_params = 22, RULE_generic_param = 23, RULE_bound = 24, RULE_where_clause = 25, 
		RULE_where_item = 26, RULE_parameters = 27, RULE_parameter = 28, RULE_return_type = 29, 
		RULE_struct_declaration = 30, RULE_struct_fields = 31, RULE_struct_field = 32, 
		RULE_enum_declaration = 33, RULE_enum_variant = 34, RULE_trait_declaration = 35, 
		RULE_trait_item = 36, RULE_impl_block = 37, RULE_impl_item = 38, RULE_type_alias = 39, 
		RULE_const_declaration = 40, RULE_static_declaration = 41, RULE_statement = 42, 
		RULE_let_statement = 43, RULE_expression_statement = 44, RULE_assignment_statement = 45, 
		RULE_return_statement = 46, RULE_break_statement = 47, RULE_continue_statement = 48, 
		RULE_if_statement = 49, RULE_match_statement = 50, RULE_match_arm = 51, 
		RULE_while_statement = 52, RULE_for_statement = 53, RULE_loop_statement = 54, 
		RULE_atom_expression = 55, RULE_expression = 56, RULE_literal_expression = 57, 
		RULE_path_expression = 58, RULE_binary_expression = 59, RULE_operator = 60, 
		RULE_unary_expression = 61, RULE_call_expression = 62, RULE_arguments = 63, 
		RULE_index_expression = 64, RULE_field_expression = 65, RULE_method_expression = 66, 
		RULE_tuple_expression = 67, RULE_array_expression = 68, RULE_struct_expression = 69, 
		RULE_field_init = 70, RULE_enum_expression = 71, RULE_range_expression = 72, 
		RULE_reference_expression = 73, RULE_dereference_expression = 74, RULE_type_cast_expression = 75, 
		RULE_grouped_expression = 76, RULE_block_expression = 77, RULE_if_expression = 78, 
		RULE_match_expression = 79, RULE_closure_expression = 80, RULE_async_expression = 81, 
		RULE_await_expression = 82, RULE_cryptographic_expression = 83, RULE_encrypt_expression = 84, 
		RULE_decrypt_expression = 85, RULE_sign_expression = 86, RULE_verify_expression = 87, 
		RULE_keygen_expression = 88, RULE_kem_expression = 89, RULE_proof_expression = 90, 
		RULE_verify_proof_expression = 91, RULE_security_annotation = 92, RULE_security_attribute = 93, 
		RULE_pattern = 94, RULE_literal_pattern = 95, RULE_identifier_pattern = 96, 
		RULE_wildcard_pattern = 97, RULE_reference_pattern = 98, RULE_struct_pattern = 99, 
		RULE_field_pattern = 100, RULE_enum_pattern = 101, RULE_tuple_pattern = 102, 
		RULE_array_pattern = 103, RULE_range_pattern = 104, RULE_patterns = 105, 
		RULE_generic_args = 106, RULE_error_type = 107, RULE_result_type = 108, 
		RULE_advanced_type = 109, RULE_higher_kinded_type = 110, RULE_type_constructor = 111, 
		RULE_crypto_type_params = 112, RULE_trait_bounds = 113, RULE_associated_type = 114, 
		RULE_associated_const = 115, RULE_generic_constraints = 116, RULE_type_family = 117, 
		RULE_kind = 118, RULE_phantom_type = 119, RULE_existential_type = 120, 
		RULE_universal_type = 121, RULE_security_annotations = 122, RULE_advanced_security_attribute = 123, 
		RULE_protocol_annotation = 124, RULE_protocol_spec = 125, RULE_protocol_property = 126, 
		RULE_zero_knowledge_annotation = 127, RULE_zk_params = 128, RULE_homomorphic_annotation = 129, 
		RULE_distributed_annotation = 130, RULE_secure_computation_annotation = 131, 
		RULE_computation_type = 132, RULE_advanced_function = 133, RULE_operator_overload = 134, 
		RULE_function_body = 135, RULE_operator_name = 136, RULE_async_function = 137, 
		RULE_async_statement = 138, RULE_stream_expression = 139, RULE_iterator_expression = 140, 
		RULE_generator_expression = 141, RULE_yield_statement = 142, RULE_coroutine_expression = 143, 
		RULE_partial_application = 144, RULE_partial_args = 145, RULE_function_composition = 146, 
		RULE_pipeline_expression = 147, RULE_method_chain = 148, RULE_module_hierarchy = 149, 
		RULE_module_item = 150, RULE_visibility_modifier = 151, RULE_secure_module = 152, 
		RULE_secure_item = 153, RULE_isolated_module = 154, RULE_isolated_item = 155, 
		RULE_component_declaration = 156, RULE_interface_list = 157, RULE_component_item = 158, 
		RULE_microservice_declaration = 159, RULE_microservice_config = 160, RULE_api_declaration = 161, 
		RULE_api_method = 162, RULE_interface_declaration = 163, RULE_interface_method = 164, 
		RULE_pattern_matching = 165, RULE_pattern_arm = 166, RULE_guard_expression = 167, 
		RULE_destructuring = 168, RULE_binding = 169, RULE_comprehension = 170, 
		RULE_iterators = 171, RULE_iterator_chain = 172, RULE_chain_operation = 173, 
		RULE_list_comprehension = 174, RULE_generators = 175, RULE_generator = 176, 
		RULE_range_literal = 177, RULE_early_return = 178, RULE_vector_literal = 179, 
		RULE_set_literal = 180, RULE_crypto_literal = 181, RULE_key_data = 182, 
		RULE_secret_data = 183, RULE_crypto_operation = 184, RULE_operation_type = 185, 
		RULE_operands = 186, RULE_protocol_definition = 187, RULE_protocol_stage = 188, 
		RULE_protocol_action = 189, RULE_message = 190, RULE_computation = 191, 
		RULE_verification = 192, RULE_zero_knowledge_proof = 193, RULE_prover = 194, 
		RULE_verifier = 195, RULE_zk_statement = 196, RULE_witness = 197, RULE_homomorphic_operation = 198, 
		RULE_operation = 199, RULE_encrypted_data = 200, RULE_plaintext = 201, 
		RULE_distributed_crypto = 202, RULE_participants = 203, RULE_secure_computation = 204, 
		RULE_inputs = 205, RULE_anonymous_communication = 206, RULE_routing = 207, 
		RULE_untraceable_operation = 208, RULE_confidentiality_property = 209, 
		RULE_data = 210, RULE_policy = 211, RULE_authentication_property = 212, 
		RULE_entity = 213, RULE_credential = 214, RULE_non_repudiation_property = 215, 
		RULE_action = 216, RULE_evidence = 217, RULE_integrity_property = 218, 
		RULE_checksum = 219, RULE_availability_property = 220, RULE_resource = 221, 
		RULE_redundancy = 222, RULE_freshness_property = 223, RULE_timestamp = 224, 
		RULE_nonce = 225, RULE_forward_secrecy_property = 226, RULE_session_key = 227, 
		RULE_compromise_time = 228, RULE_backward_secrecy_property = 229, RULE_perfect_secrecy_property = 230, 
		RULE_key_expr = 231, RULE_computational_security_property = 232, RULE_algorithm = 233, 
		RULE_security_parameter = 234, RULE_information_theoretic_property = 235, 
		RULE_entropy = 236, RULE_min_entropy = 237, RULE_compile_time_function = 238, 
		RULE_macro_definition = 239, RULE_macro_params = 240, RULE_macro_body = 241, 
		RULE_macro_invocation = 242, RULE_macro_rules_definition = 243, RULE_macro_rule = 244, 
		RULE_template = 245, RULE_syntax_extension = 246, RULE_syntax_rule = 247, 
		RULE_proc_macro = 248, RULE_derive_macro = 249, RULE_trait_list = 250, 
		RULE_attribute_macro = 251, RULE_attribute_name = 252, RULE_annotation = 253, 
		RULE_annotation_name = 254, RULE_decorator = 255, RULE_decorator_name = 256, 
		RULE_meta_programming = 257, RULE_meta_operation = 258, RULE_template_metaprogramming = 259, 
		RULE_template_args = 260, RULE_generic_specialization = 261, RULE_monomorphization = 262, 
		RULE_const_evaluation = 263, RULE_static_analysis = 264, RULE_analysis_directive = 265, 
		RULE_conditional_compilation = 266, RULE_condition = 267, RULE_feature_gate = 268, 
		RULE_feature_name = 269, RULE_property_access = 270, RULE_property_name = 271, 
		RULE_computed_property = 272, RULE_computed_index_expr = 273, RULE_chained_expression = 274, 
		RULE_method_call = 275, RULE_pipeline_expr = 276, RULE_pipeline_op = 277, 
		RULE_composition_expression = 278, RULE_partial_app_expr = 279, RULE_partial_app_args = 280, 
		RULE_currying_expression = 281, RULE_multi_arg_function = 282, RULE_lazy_evaluation = 283, 
		RULE_strict_evaluation = 284, RULE_memoization = 285, RULE_caching_expression = 286, 
		RULE_parallel_computation = 287, RULE_concurrent_expression = 288, RULE_atomic_operation = 289, 
		RULE_synchronized_block = 290, RULE_lock = 291, RULE_volatile_access = 292, 
		RULE_immutable_value = 293, RULE_mutable_reference = 294, RULE_shared_reference = 295, 
		RULE_owned_value = 296, RULE_borrowed_reference = 297, RULE_lifetime_annotation = 298, 
		RULE_scope_expression = 299, RULE_region_expression = 300, RULE_arena_allocation = 301, 
		RULE_bump_allocation = 302, RULE_trace_expression = 303, RULE_garbage_collection = 304, 
		RULE_collection_strategy = 305, RULE_pinned_memory = 306, RULE_unpinned_memory = 307;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "module_declaration", "import_declaration", 
			"config_block", "config_item", "extern_block", "extern_function", "function_declaration", 
			"type_", "basic_type", "cryptographic_type", "algorithm_type", "type_path", 
			"tuple_type", "array_type", "slice_type", "reference_type", "mutable_reference_type", 
			"function_type", "generic_type", "type_args", "generic_params", "generic_param", 
			"bound", "where_clause", "where_item", "parameters", "parameter", "return_type", 
			"struct_declaration", "struct_fields", "struct_field", "enum_declaration", 
			"enum_variant", "trait_declaration", "trait_item", "impl_block", "impl_item", 
			"type_alias", "const_declaration", "static_declaration", "statement", 
			"let_statement", "expression_statement", "assignment_statement", "return_statement", 
			"break_statement", "continue_statement", "if_statement", "match_statement", 
			"match_arm", "while_statement", "for_statement", "loop_statement", "atom_expression", 
			"expression", "literal_expression", "path_expression", "binary_expression", 
			"operator", "unary_expression", "call_expression", "arguments", "index_expression", 
			"field_expression", "method_expression", "tuple_expression", "array_expression", 
			"struct_expression", "field_init", "enum_expression", "range_expression", 
			"reference_expression", "dereference_expression", "type_cast_expression", 
			"grouped_expression", "block_expression", "if_expression", "match_expression", 
			"closure_expression", "async_expression", "await_expression", "cryptographic_expression", 
			"encrypt_expression", "decrypt_expression", "sign_expression", "verify_expression", 
			"keygen_expression", "kem_expression", "proof_expression", "verify_proof_expression", 
			"security_annotation", "security_attribute", "pattern", "literal_pattern", 
			"identifier_pattern", "wildcard_pattern", "reference_pattern", "struct_pattern", 
			"field_pattern", "enum_pattern", "tuple_pattern", "array_pattern", "range_pattern", 
			"patterns", "generic_args", "error_type", "result_type", "advanced_type", 
			"higher_kinded_type", "type_constructor", "crypto_type_params", "trait_bounds", 
			"associated_type", "associated_const", "generic_constraints", "type_family", 
			"kind", "phantom_type", "existential_type", "universal_type", "security_annotations", 
			"advanced_security_attribute", "protocol_annotation", "protocol_spec", 
			"protocol_property", "zero_knowledge_annotation", "zk_params", "homomorphic_annotation", 
			"distributed_annotation", "secure_computation_annotation", "computation_type", 
			"advanced_function", "operator_overload", "function_body", "operator_name", 
			"async_function", "async_statement", "stream_expression", "iterator_expression", 
			"generator_expression", "yield_statement", "coroutine_expression", "partial_application", 
			"partial_args", "function_composition", "pipeline_expression", "method_chain", 
			"module_hierarchy", "module_item", "visibility_modifier", "secure_module", 
			"secure_item", "isolated_module", "isolated_item", "component_declaration", 
			"interface_list", "component_item", "microservice_declaration", "microservice_config", 
			"api_declaration", "api_method", "interface_declaration", "interface_method", 
			"pattern_matching", "pattern_arm", "guard_expression", "destructuring", 
			"binding", "comprehension", "iterators", "iterator_chain", "chain_operation", 
			"list_comprehension", "generators", "generator", "range_literal", "early_return", 
			"vector_literal", "set_literal", "crypto_literal", "key_data", "secret_data", 
			"crypto_operation", "operation_type", "operands", "protocol_definition", 
			"protocol_stage", "protocol_action", "message", "computation", "verification", 
			"zero_knowledge_proof", "prover", "verifier", "zk_statement", "witness", 
			"homomorphic_operation", "operation", "encrypted_data", "plaintext", 
			"distributed_crypto", "participants", "secure_computation", "inputs", 
			"anonymous_communication", "routing", "untraceable_operation", "confidentiality_property", 
			"data", "policy", "authentication_property", "entity", "credential", 
			"non_repudiation_property", "action", "evidence", "integrity_property", 
			"checksum", "availability_property", "resource", "redundancy", "freshness_property", 
			"timestamp", "nonce", "forward_secrecy_property", "session_key", "compromise_time", 
			"backward_secrecy_property", "perfect_secrecy_property", "key_expr", 
			"computational_security_property", "algorithm", "security_parameter", 
			"information_theoretic_property", "entropy", "min_entropy", "compile_time_function", 
			"macro_definition", "macro_params", "macro_body", "macro_invocation", 
			"macro_rules_definition", "macro_rule", "template", "syntax_extension", 
			"syntax_rule", "proc_macro", "derive_macro", "trait_list", "attribute_macro", 
			"attribute_name", "annotation", "annotation_name", "decorator", "decorator_name", 
			"meta_programming", "meta_operation", "template_metaprogramming", "template_args", 
			"generic_specialization", "monomorphization", "const_evaluation", "static_analysis", 
			"analysis_directive", "conditional_compilation", "condition", "feature_gate", 
			"feature_name", "property_access", "property_name", "computed_property", 
			"computed_index_expr", "chained_expression", "method_call", "pipeline_expr", 
			"pipeline_op", "composition_expression", "partial_app_expr", "partial_app_args", 
			"currying_expression", "multi_arg_function", "lazy_evaluation", "strict_evaluation", 
			"memoization", "caching_expression", "parallel_computation", "concurrent_expression", 
			"atomic_operation", "synchronized_block", "lock", "volatile_access", 
			"immutable_value", "mutable_reference", "shared_reference", "owned_value", 
			"borrowed_reference", "lifetime_annotation", "scope_expression", "region_expression", 
			"arena_allocation", "bump_allocation", "trace_expression", "garbage_collection", 
			"collection_strategy", "pinned_memory", "unpinned_memory"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'module'", "'import'", "'export'", "'fn'", "'let'", 
			"'mut'", "'const'", "'static'", "'struct'", "'enum'", "'trait'", "'impl'", 
			"'for'", "'in'", "'if'", "'else'", "'match'", "'while'", "'loop'", "'break'", 
			"'continue'", "'return'", "'yield'", "'async'", "'await'", "'type'", 
			"'alias'", "'where'", "'self'", "'super'", "'crate'", "'use'", "'pub'", 
			"'private'", "'protected'", "'Key'", "'Secret'", "'PublicKey'", "'PrivateKey'", 
			"'Signature'", "'Ciphertext'", "'Plaintext'", "'Hash'", "'Nonce'", "'Salt'", 
			"'crypto'", "'encrypt'", "'decrypt'", "'sign'", "'verify'", "'proof'", 
			"'witness'", "'commit'", "'reveal'", "'constant_time'", "'cache_resistant'", 
			"'secure_memory'", "'verify_protocol'", "'wipe_on_drop'", "'distributed'", 
			"'threshold_sign'", "'verify_soundness'", "'verify_zero_knowledge'", 
			"'power_resistant'", "'config'", "'extern'", "'as'", "'Result'", "'Ok'", 
			"'Err'", null, null, null, null, null, null, null, null, "'true'", "'false'", 
			"'AES256'", "'Kyber1024'", "'Dilithium3'", "'Ed25519'", "'P256'", "'Falcon512'", 
			"'CKKS'", "'Groth16'", "'Bulletproofs'", "'STARK'", "'PLONK'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "'&'", "'|'", "'&&'", "'||'", 
			"'<<'", "'>>'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'='", 
			"'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", 
			"'>>='", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "':'", "'::'", 
			"';'", "'.'", "'->'", "'=>'", "'?'", "'@'", "'$'", "'_'", "'#['", null, 
			null, null, null, null, "'Algorithm'", "'KeyExchange'", "'SignatureScheme'", 
			"'EncryptionScheme'", "'ZKPSystem'", "'HomomorphicScheme'", "'ThresholdScheme'", 
			"'ThresholdSignatureScheme'", "'SecurityLevel'", "'Level1'", "'Level2'", 
			"'Level3'", "'Level4'", "'Level5'", "'NISTLevel'", "'KeySize'", "'BlockSize'", 
			"'SecurityParameter'", "'default_crypto_provider'", "'post_quantum_enabled'", 
			"'hardware_acceleration'", "'CryptoError'", "'InvalidKey'", "'DecryptionFailed'", 
			"'AuthenticationFailed'", "'WeakParameter'", "'HardwareFailure'", "'TimingAttackDetected'", 
			"'libcrypto'", "'libssl'", "'Int8'", "'Int16'", "'Int32'", "'Int64'", 
			"'UInt8'", "'UInt16'", "'UInt32'", "'UInt64'", "'Float32'", "'Float64'", 
			"'Bool'", "'String'", "'Bytes'", "'new'", "'ref'", "'kem'", "'verify_proof'", 
			"'Generic'", "'Constraint'", "'Associated'", "'TraitBound'", "'HigherKinded'", 
			"'Existential'", "'CryptoParam'", "'TypeFamily'", "'Kind'", "'TypeLevel'", 
			"'Phantom'", "'ZeroSized'", "'forall'", "'exists'", "'implies'", "'trait_assoc'", 
			"'impl_assoc'", "'associated_type'", "'associated_const'", "'HKT'", "'TypeConstructor'", 
			"'TypeApplication'", "'->>'", "'\\u2605'", "'dyn'", "'any'", "'some'", 
			"'CryptoAlg'", "'SecurityParam'", "'KeyType'", "'CipherType'", "'SignatureType'", 
			"'HashType'", "'ProtocolType'", "'timing_resistant'", "'fault_resistant'", 
			"'leakage_resistant'", "'secure_execution'", "'trusted_execution'", "'enclave'", 
			"'secure_channel'", "'authenticated'", "'confidential'", "'integrity_check'", 
			"'freshness_check'", "'non_replayable'", "'forward_secure'", "'post_compromise'", 
			"'closure'", "'lambda'", "'operator'", "'overload'", "'function_ptr'", 
			"'callable'", "'stream'", "'iterator'", "'generator'", "'coroutine'", 
			"'continuation'", "'partial'", "'curry'", "'compose'", "'pipe'", "'chain'", 
			"'secure'", "'isolated'", "'trusted'", "'untrusted'", "'sensitive'", 
			"'classified'", "'compartment'", "'namespace'", "'package'", "'library'", 
			"'framework'", "'component'", "'service'", "'microservice'", "'api'", 
			"'interface'", "'pattern'", "'guard'", "'binding'", "'destructure'", 
			"'comprehension'", "'iterator_chain'", "'early_return'", "'list'", "'vector'", 
			"'set'", "'range'", "'inclusive'", "'exclusive'", "'step'", "'filter'", 
			"'reduce'", "'fold'", "'flatten'", "'zip'", "'enumerate'", "'take'", 
			"'skip'", "'cycle'", "'repeat'", "'key_literal'", "'secret_literal'", 
			"'crypto_op'", "'protocol'", "'zero_knowledge'", "'homomorphic'", "'multiparty'", 
			"'threshold'", "'distributed_key'", "'secure_computation'", "'oblivious'", 
			"'private_set'", "'private_info'", "'secure_search'", "'anonymous'", 
			"'untraceable'", "'confidentiality'", "'authentication'", "'non_repudiation'", 
			"'integrity'", "'availability'", "'freshness'", "'forward_secrecy'", 
			"'backward_secrecy'", "'perfect_secrecy'", "'computational_security'", 
			"'information_theoretic'", "'compile_time'", "'runtime'", "'macro'", 
			"'macro_rules'", "'syntax'", "'proc'", "'derive'", "'attribute'", "'annotation'", 
			"'decorator'", "'meta'", "'reflection'", "'introspection'", "'codegen'", 
			"'template'", "'generics'", "'specialization'", "'monomorphization'", 
			"'const_eval'", "'dynamic'", "'lazy'", "'eager'", "'strict'", "'lenient'", 
			"'debug'", "'release'", "'test'", "'bench'", "'doc'", "'example'", "'cfg'", 
			"'feature'", "'property'", "'computed'", "'indexed'", "'chained'", "'pipeline'", 
			"'composition'", "'partial_app'", "'currying'", "'lazy_eval'", "'strict_eval'", 
			"'memoization'", "'caching'", "'parallel'", "'concurrent'", "'atomic'", 
			"'synchronized'", "'volatile'", "'immutable'", "'mutable'", "'shared'", 
			"'owned'", "'borrowed'", "'lifetime'", "'scope'", "'region'", "'arena'", 
			"'bump'", "'trace'", "'gc'", "'rc'", "'arc'", "'pinned'", "'unpinned'", 
			"'proof_system'", "'security_parameter'", "'encryption_scheme'", "'implements'", 
			"'endpoint'", "'required'", "'encryption'", "'decryption'", "'verification'", 
			"'key_exchange'", "'mac'", "'send'", "'receive'", "'compute'", "'add'", 
			"'sub'", "'mul'", "'div'", "'onion'", "'mixnet'", "'dcnet'", "'move'", 
			"'map_transform'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "LINE_COMMENT", "BLOCK_COMMENT", "MODULE", "IMPORT", "EXPORT", 
			"FN", "LET", "MUT", "CONST", "STATIC", "STRUCT", "ENUM", "TRAIT", "IMPL", 
			"FOR", "IN", "IF", "ELSE", "MATCH", "WHILE", "LOOP", "BREAK", "CONTINUE", 
			"RETURN", "YIELD", "ASYNC", "AWAIT", "TYPE", "ALIAS", "WHERE_", "SELF_", 
			"SUPER_", "CRATE_", "USE_", "PUB_", "PRIVATE_", "PROTECTED_", "KEY_", 
			"SECRET_", "PUBLICKEY_", "PRIVATEKEY_", "SIGNATURE_", "CIPHERTEXT_", 
			"PLAINTEXT_", "HASH_", "NONCE_", "SALT_", "CRYPTO_", "ENCRYPT_", "DECRYPT_", 
			"SIGN_", "VERIFY_", "PROOF_", "WITNESS_", "COMMIT_", "REVEAL_", "CONSTANT_TIME_", 
			"CACHE_RESISTANT_", "SECURE_MEMORY_", "VERIFY_PROTOCOL_", "WIPE_ON_DROP_", 
			"DISTRIBUTED_", "THRESHOLD_SIGN_", "VERIFY_SOUNDNESS_", "VERIFY_ZERO_KNOWLEDGE_", 
			"POWER_RESISTANT_", "CONFIG_", "EXTERN_", "AS_", "RESULT_", "OK_", "ERR_", 
			"INTEGER", "HEX_INTEGER", "OCT_INTEGER", "BIN_INTEGER", "FLOAT", "STRING", 
			"BYTE_STRING", "CHAR", "TRUE", "FALSE", "AES256", "KYBER1024", "DILITHIUM3", 
			"ED25519", "P256", "FALCON512", "CKKS", "GROTH16", "BULLETPROOFS", "STARK", 
			"PLONK", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "CARET", "NOT", 
			"AND", "OR", "ANDAND", "OROR", "SHL", "SHR", "EQ", "NE", "LT", "GT", 
			"LE", "GE", "ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "STAR_ASSIGN", "SLASH_ASSIGN", 
			"PERCENT_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "SHL_ASSIGN", 
			"SHR_ASSIGN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", 
			"COMMA", "COLON", "COLONCOLON", "SEMICOLON", "DOT", "ARROW", "FAT_ARROW", 
			"QUESTION", "AT", "DOLLAR", "UNDERSCORE", "HASH_LBRACKET", "IDENTIFIER", 
			"LIFETIME", "RAW_IDENTIFIER", "MODULE_PATH", "TYPE_PATH", "ALGORITHM", 
			"KEY_EXCHANGE", "SIGNATURE_SCHEME", "ENCRYPTION_SCHEME", "ZKP_SYSTEM", 
			"HOMOMORPHIC_SCHEME", "THRESHOLD_SCHEME", "THRESHOLD_SIGNATURE_SCHEME", 
			"SECURITY_LEVEL", "LEVEL1", "LEVEL2", "LEVEL3", "LEVEL4", "LEVEL5", "NIST_LEVEL", 
			"KEY_SIZE", "BLOCK_SIZE", "SECURITY_PARAMETER", "DEFAULT_CRYPTO_PROVIDER", 
			"POST_QUANTUM_ENABLED", "HARDWARE_ACCELERATION", "CRYPTO_ERROR", "INVALID_KEY", 
			"DECRYPTION_FAILED", "AUTHENTICATION_FAILED", "WEAK_PARAMETER", "HARDWARE_FAILURE", 
			"TIMING_ATTACK_DETECTED", "LIBCRYPTO", "LIBSSL", "INT8", "INT16", "INT32", 
			"INT64", "UINT8", "UINT16", "UINT32", "UINT64", "FLOAT32", "FLOAT64", 
			"BOOL", "STRING_", "BYTES", "NEW", "REF", "KEM_", "VERIFY_PROOF_", "GENERIC_", 
			"CONSTRAINT_", "ASSOCIATED_", "TRAIT_BOUND_", "HIGHER_KINDED_", "EXISTENTIAL_", 
			"CRYPTO_PARAM_", "TYPE_FAMILY_", "KIND_", "TYPE_LEVEL_", "PHANTOM_", 
			"ZERO_SIZED_", "FORALL_", "EXISTS_", "IMPLIES_", "TRAIT_ASSOC_", "IMPL_ASSOC_", 
			"ASSOCIATED_TYPE_", "ASSOCIATED_CONST_", "HKT_", "TYPE_CONSTRUCTOR_", 
			"TYPE_APPLICATION_", "KIND_ARROW_", "KIND_STAR_", "DYNT_", "ANY_", "SOME_", 
			"CRYPTO_ALG_", "SECURITY_PARAM_", "KEY_TYPE_", "CIPHER_TYPE_", "SIGNATURE_TYPE_", 
			"HASH_TYPE_", "PROTOCOL_TYPE_", "TIMING_RESISTANT_", "FAULT_RESISTANT_", 
			"LEAKAGE_RESISTANT_", "SECURE_EXECUTION_", "TRUSTED_EXECUTION_", "ENCLAVE_", 
			"SECURE_CHANNEL_", "AUTHENTICATED_", "CONFIDENTIAL_", "INTEGRITY_CHECK_", 
			"FRESHNESS_CHECK_", "NON_REPLAYABLE_", "FORWARD_SECURE_", "POST_COMPROMISE_", 
			"CLOSURE_", "LAMBDA_", "OPERATOR_", "OVERLOAD_", "FUNCTION_PTR_", "CALLABLE_", 
			"STREAM_", "ITERATOR_", "GENERATOR_", "COROUTINE_", "CONTINUATION_", 
			"PARTIAL_", "CURRY_", "COMPOSE_", "PIPE_", "CHAIN_", "SECURE_", "ISOLATED_", 
			"TRUSTED_", "UNTRUSTED_", "SENSITIVE_", "CLASSIFIED_", "COMPARTMENT_", 
			"NAMESPACE_", "PACKAGE_", "LIBRARY_", "FRAMEWORK_", "COMPONENT_", "SERVICE_", 
			"MICROSERVICE_", "API_", "INTERFACE_", "PATTERN_", "GUARD_", "BINDING_", 
			"DESTRUCTURE_", "COMPREHENSION_", "ITERATOR_CHAIN_", "EARLY_RETURN_", 
			"LIST_", "VECTOR_", "SET_", "RANGE_", "INCLUSIVE_", "EXCLUSIVE_", "STEP_", 
			"FILTER_", "REDUCE_", "FOLD_", "FLATTEN_", "ZIP_", "ENUMERATE_", "TAKE_", 
			"SKIP_", "CYCLE_", "REPEAT_", "KEY_LITERAL_", "SECRET_LITERAL_", "CRYPTO_OP_", 
			"PROTOCOL_", "ZERO_KNOWLEDGE_", "HOMOMORPHIC_", "MULTIPARTY_", "THRESHOLD_", 
			"DISTRIBUTED_KEY_", "SECURE_COMPUTATION_", "OBLIVIOUS_", "PRIVATE_SET_", 
			"PRIVATE_INFO_", "SECURE_SEARCH_", "ANONYMOUS_", "UNTRACEABLE_", "CONFIDENTIALITY_", 
			"AUTHENTICATION_", "NON_REPUDIATION_", "INTEGRITY_", "AVAILABILITY_", 
			"FRESHNESS_", "FORWARD_SECRECY_", "BACKWARD_SECRECY_", "PERFECT_SECRECY_", 
			"COMPUTATIONAL_SECURITY_", "INFORMATION_THEORETIC_", "COMPILE_TIME_", 
			"RUNTIME_", "MACRO_", "MACRO_RULES_", "SYNTAX_", "PROC_", "DERIVE_", 
			"ATTRIBUTE_", "ANNOTATION_", "DECORATOR_", "META_", "REFLECTION_", "INTROSPECTION_", 
			"CODEGEN_", "TEMPLATE_", "GENERICS_", "SPECIALIZATION_", "MONOMORPHIZATION_", 
			"CONST_EVAL_", "DYNAMIC_", "LAZY_", "EAGER_", "STRICT_", "LENIENT_", 
			"DEBUG_", "RELEASE_", "TEST_", "BENCH_", "DOC_", "EXAMPLE_", "CFG_", 
			"FEATURE_", "PROPERTY_", "COMPUTED_", "INDEXED_", "CHAINED_", "PIPELINE_", 
			"COMPOSITION_", "PARTIAL_APP_", "CURRYING_", "LAZY_EVAL_", "STRICT_EVAL_", 
			"MEMOIZATION_", "CACHING_", "PARALLEL_", "CONCURRENT_", "ATOMIC_", "SYNCHRONIZED_", 
			"VOLATILE_", "IMMUTABLE_", "MUTABLE_", "SHARED_", "OWNED_", "BORROWED_", 
			"LIFETIME_", "SCOPE_", "REGION_", "ARENA_", "BUMP_", "TRACE_", "GC_", 
			"RC_", "ARC_", "PINNED_", "UNPINNED_", "PROOF_SYSTEM_", "SECURITY_PARAMETER_", 
			"ENCRYPTION_SCHEME_", "IMPLEMENTS_", "ENDPOINT_", "REQUIRED_", "ENCRYPTION_", 
			"DECRYPTION_", "VERIFICATION_", "KEY_EXCHANGE_", "MAC_", "SEND_", "RECEIVE_", 
			"COMPUTE_", "ADD_", "SUB_", "MUL_", "DIV_", "ONION_", "MIXNET_", "DCNET_", 
			"MOVE", "MAP_TRANSFORM_"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "T4Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public T4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(T4Parser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_) {
				{
				{
				setState(616);
				declaration();
				}
				}
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(622);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Module_declarationContext module_declaration() {
			return getRuleContext(Module_declarationContext.class,0);
		}
		public Import_declarationContext import_declaration() {
			return getRuleContext(Import_declarationContext.class,0);
		}
		public Function_declarationContext function_declaration() {
			return getRuleContext(Function_declarationContext.class,0);
		}
		public Struct_declarationContext struct_declaration() {
			return getRuleContext(Struct_declarationContext.class,0);
		}
		public Enum_declarationContext enum_declaration() {
			return getRuleContext(Enum_declarationContext.class,0);
		}
		public Trait_declarationContext trait_declaration() {
			return getRuleContext(Trait_declarationContext.class,0);
		}
		public Impl_blockContext impl_block() {
			return getRuleContext(Impl_blockContext.class,0);
		}
		public Type_aliasContext type_alias() {
			return getRuleContext(Type_aliasContext.class,0);
		}
		public Const_declarationContext const_declaration() {
			return getRuleContext(Const_declarationContext.class,0);
		}
		public Static_declarationContext static_declaration() {
			return getRuleContext(Static_declarationContext.class,0);
		}
		public Config_blockContext config_block() {
			return getRuleContext(Config_blockContext.class,0);
		}
		public Extern_blockContext extern_block() {
			return getRuleContext(Extern_blockContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(636);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(624);
				module_declaration();
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(625);
				import_declaration();
				}
				break;
			case FN:
				enterOuterAlt(_localctx, 3);
				{
				setState(626);
				function_declaration();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				setState(627);
				struct_declaration();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(628);
				enum_declaration();
				}
				break;
			case TRAIT:
				enterOuterAlt(_localctx, 6);
				{
				setState(629);
				trait_declaration();
				}
				break;
			case IMPL:
				enterOuterAlt(_localctx, 7);
				{
				setState(630);
				impl_block();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 8);
				{
				setState(631);
				type_alias();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 9);
				{
				setState(632);
				const_declaration();
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 10);
				{
				setState(633);
				static_declaration();
				}
				break;
			case CONFIG_:
				enterOuterAlt(_localctx, 11);
				{
				setState(634);
				config_block();
				}
				break;
			case EXTERN_:
				enterOuterAlt(_localctx, 12);
				{
				setState(635);
				extern_block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Module_declarationContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(T4Parser.MODULE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public Module_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_declaration; }
	}

	public final Module_declarationContext module_declaration() throws RecognitionException {
		Module_declarationContext _localctx = new Module_declarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			match(MODULE);
			setState(639);
			match(IDENTIFIER);
			setState(640);
			match(LBRACE);
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_) {
				{
				{
				setState(641);
				declaration();
				}
				}
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(647);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Import_declarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(T4Parser.IMPORT, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode STRING() { return getToken(T4Parser.STRING, 0); }
		public TerminalNode MODULE_PATH() { return getToken(T4Parser.MODULE_PATH, 0); }
		public TerminalNode AS_() { return getToken(T4Parser.AS_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Import_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_declaration; }
	}

	public final Import_declarationContext import_declaration() throws RecognitionException {
		Import_declarationContext _localctx = new Import_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_import_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(IMPORT);
			setState(650);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==MODULE_PATH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_) {
				{
				setState(651);
				match(AS_);
				setState(652);
				match(IDENTIFIER);
				}
			}

			setState(655);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Config_blockContext extends ParserRuleContext {
		public TerminalNode CONFIG_() { return getToken(T4Parser.CONFIG_, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Config_itemContext> config_item() {
			return getRuleContexts(Config_itemContext.class);
		}
		public Config_itemContext config_item(int i) {
			return getRuleContext(Config_itemContext.class,i);
		}
		public Config_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_config_block; }
	}

	public final Config_blockContext config_block() throws RecognitionException {
		Config_blockContext _localctx = new Config_blockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_config_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			match(CONFIG_);
			setState(658);
			match(LBRACE);
			setState(662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 58720257L) != 0)) {
				{
				{
				setState(659);
				config_item();
				}
				}
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(665);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Config_itemContext extends ParserRuleContext {
		public TerminalNode DEFAULT_CRYPTO_PROVIDER() { return getToken(T4Parser.DEFAULT_CRYPTO_PROVIDER, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public TerminalNode STRING() { return getToken(T4Parser.STRING, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode POST_QUANTUM_ENABLED() { return getToken(T4Parser.POST_QUANTUM_ENABLED, 0); }
		public TerminalNode TRUE() { return getToken(T4Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(T4Parser.FALSE, 0); }
		public TerminalNode HARDWARE_ACCELERATION() { return getToken(T4Parser.HARDWARE_ACCELERATION, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Config_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_config_item; }
	}

	public final Config_itemContext config_item() throws RecognitionException {
		Config_itemContext _localctx = new Config_itemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_config_item);
		int _la;
		try {
			setState(684);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEFAULT_CRYPTO_PROVIDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(667);
				match(DEFAULT_CRYPTO_PROVIDER);
				setState(668);
				match(ASSIGN);
				setState(669);
				match(STRING);
				setState(670);
				match(SEMICOLON);
				}
				break;
			case POST_QUANTUM_ENABLED:
				enterOuterAlt(_localctx, 2);
				{
				setState(671);
				match(POST_QUANTUM_ENABLED);
				setState(672);
				match(ASSIGN);
				setState(673);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(674);
				match(SEMICOLON);
				}
				break;
			case HARDWARE_ACCELERATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(675);
				match(HARDWARE_ACCELERATION);
				setState(676);
				match(ASSIGN);
				setState(677);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(678);
				match(SEMICOLON);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(679);
				match(IDENTIFIER);
				setState(680);
				match(ASSIGN);
				setState(681);
				expression();
				setState(682);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Extern_blockContext extends ParserRuleContext {
		public TerminalNode EXTERN_() { return getToken(T4Parser.EXTERN_, 0); }
		public TerminalNode STRING() { return getToken(T4Parser.STRING, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public TerminalNode AS_() { return getToken(T4Parser.AS_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public List<Extern_functionContext> extern_function() {
			return getRuleContexts(Extern_functionContext.class);
		}
		public Extern_functionContext extern_function(int i) {
			return getRuleContext(Extern_functionContext.class,i);
		}
		public Extern_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extern_block; }
	}

	public final Extern_blockContext extern_block() throws RecognitionException {
		Extern_blockContext _localctx = new Extern_blockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_extern_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			match(EXTERN_);
			setState(687);
			match(STRING);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_) {
				{
				setState(688);
				match(AS_);
				setState(689);
				match(IDENTIFIER);
				}
			}

			setState(692);
			match(LBRACE);
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FN) {
				{
				{
				setState(693);
				extern_function();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(699);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Extern_functionContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Extern_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extern_function; }
	}

	public final Extern_functionContext extern_function() throws RecognitionException {
		Extern_functionContext _localctx = new Extern_functionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_extern_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			match(FN);
			setState(702);
			match(IDENTIFIER);
			setState(703);
			match(LPAREN);
			setState(705);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || _la==IDENTIFIER || _la==REF) {
				{
				setState(704);
				parameters();
				}
			}

			setState(707);
			match(RPAREN);
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(708);
				match(ARROW);
				setState(709);
				return_type();
				}
			}

			setState(712);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_declarationContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Generic_paramsContext generic_params() {
			return getRuleContext(Generic_paramsContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(FN);
			setState(715);
			match(IDENTIFIER);
			setState(717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(716);
				generic_params();
				}
			}

			setState(719);
			match(LPAREN);
			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || _la==IDENTIFIER || _la==REF) {
				{
				setState(720);
				parameters();
				}
			}

			setState(723);
			match(RPAREN);
			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(724);
				match(ARROW);
				setState(725);
				return_type();
				}
			}

			setState(729);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(728);
				where_clause();
				}
			}

			setState(740);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(731);
				match(LBRACE);
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
					{
					{
					setState(732);
					statement();
					}
					}
					setState(737);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(738);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(739);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_Context extends ParserRuleContext {
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Cryptographic_typeContext cryptographic_type() {
			return getRuleContext(Cryptographic_typeContext.class,0);
		}
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public Tuple_typeContext tuple_type() {
			return getRuleContext(Tuple_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Slice_typeContext slice_type() {
			return getRuleContext(Slice_typeContext.class,0);
		}
		public Reference_typeContext reference_type() {
			return getRuleContext(Reference_typeContext.class,0);
		}
		public Mutable_reference_typeContext mutable_reference_type() {
			return getRuleContext(Mutable_reference_typeContext.class,0);
		}
		public Function_typeContext function_type() {
			return getRuleContext(Function_typeContext.class,0);
		}
		public Generic_typeContext generic_type() {
			return getRuleContext(Generic_typeContext.class,0);
		}
		public Advanced_typeContext advanced_type() {
			return getRuleContext(Advanced_typeContext.class,0);
		}
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_);
		try {
			setState(753);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(742);
				basic_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(743);
				cryptographic_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(744);
				type_path();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(745);
				tuple_type();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(746);
				array_type();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(747);
				slice_type();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(748);
				reference_type();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(749);
				mutable_reference_type();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(750);
				function_type();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(751);
				generic_type();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(752);
				advanced_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Basic_typeContext extends ParserRuleContext {
		public TerminalNode INT8() { return getToken(T4Parser.INT8, 0); }
		public TerminalNode INT16() { return getToken(T4Parser.INT16, 0); }
		public TerminalNode INT32() { return getToken(T4Parser.INT32, 0); }
		public TerminalNode INT64() { return getToken(T4Parser.INT64, 0); }
		public TerminalNode UINT8() { return getToken(T4Parser.UINT8, 0); }
		public TerminalNode UINT16() { return getToken(T4Parser.UINT16, 0); }
		public TerminalNode UINT32() { return getToken(T4Parser.UINT32, 0); }
		public TerminalNode UINT64() { return getToken(T4Parser.UINT64, 0); }
		public TerminalNode FLOAT32() { return getToken(T4Parser.FLOAT32, 0); }
		public TerminalNode FLOAT64() { return getToken(T4Parser.FLOAT64, 0); }
		public TerminalNode BOOL() { return getToken(T4Parser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(T4Parser.STRING, 0); }
		public TerminalNode BYTES() { return getToken(T4Parser.BYTES, 0); }
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_basic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			_la = _input.LA(1);
			if ( !(_la==STRING || ((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & 6143L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cryptographic_typeContext extends ParserRuleContext {
		public TerminalNode KEY_() { return getToken(T4Parser.KEY_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Algorithm_typeContext algorithm_type() {
			return getRuleContext(Algorithm_typeContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode SECRET_() { return getToken(T4Parser.SECRET_, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode PUBLICKEY_() { return getToken(T4Parser.PUBLICKEY_, 0); }
		public TerminalNode PRIVATEKEY_() { return getToken(T4Parser.PRIVATEKEY_, 0); }
		public TerminalNode SIGNATURE_() { return getToken(T4Parser.SIGNATURE_, 0); }
		public TerminalNode CIPHERTEXT_() { return getToken(T4Parser.CIPHERTEXT_, 0); }
		public TerminalNode PLAINTEXT_() { return getToken(T4Parser.PLAINTEXT_, 0); }
		public TerminalNode HASH_() { return getToken(T4Parser.HASH_, 0); }
		public TerminalNode NONCE_() { return getToken(T4Parser.NONCE_, 0); }
		public TerminalNode SALT_() { return getToken(T4Parser.SALT_, 0); }
		public Cryptographic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cryptographic_type; }
	}

	public final Cryptographic_typeContext cryptographic_type() throws RecognitionException {
		Cryptographic_typeContext _localctx = new Cryptographic_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cryptographic_type);
		try {
			setState(799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY_:
				enterOuterAlt(_localctx, 1);
				{
				setState(757);
				match(KEY_);
				setState(758);
				match(LT);
				setState(759);
				algorithm_type();
				setState(760);
				match(GT);
				}
				break;
			case SECRET_:
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
				match(SECRET_);
				setState(763);
				match(LT);
				setState(764);
				type_();
				setState(765);
				match(GT);
				}
				break;
			case PUBLICKEY_:
				enterOuterAlt(_localctx, 3);
				{
				setState(767);
				match(PUBLICKEY_);
				setState(768);
				match(LT);
				setState(769);
				algorithm_type();
				setState(770);
				match(GT);
				}
				break;
			case PRIVATEKEY_:
				enterOuterAlt(_localctx, 4);
				{
				setState(772);
				match(PRIVATEKEY_);
				setState(773);
				match(LT);
				setState(774);
				algorithm_type();
				setState(775);
				match(GT);
				}
				break;
			case SIGNATURE_:
				enterOuterAlt(_localctx, 5);
				{
				setState(777);
				match(SIGNATURE_);
				setState(778);
				match(LT);
				setState(779);
				algorithm_type();
				setState(780);
				match(GT);
				}
				break;
			case CIPHERTEXT_:
				enterOuterAlt(_localctx, 6);
				{
				setState(782);
				match(CIPHERTEXT_);
				setState(783);
				match(LT);
				setState(784);
				algorithm_type();
				setState(785);
				match(GT);
				}
				break;
			case PLAINTEXT_:
				enterOuterAlt(_localctx, 7);
				{
				setState(787);
				match(PLAINTEXT_);
				setState(788);
				match(LT);
				setState(789);
				algorithm_type();
				setState(790);
				match(GT);
				}
				break;
			case HASH_:
				enterOuterAlt(_localctx, 8);
				{
				setState(792);
				match(HASH_);
				setState(793);
				match(LT);
				setState(794);
				algorithm_type();
				setState(795);
				match(GT);
				}
				break;
			case NONCE_:
				enterOuterAlt(_localctx, 9);
				{
				setState(797);
				match(NONCE_);
				}
				break;
			case SALT_:
				enterOuterAlt(_localctx, 10);
				{
				setState(798);
				match(SALT_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Algorithm_typeContext extends ParserRuleContext {
		public TerminalNode AES256() { return getToken(T4Parser.AES256, 0); }
		public TerminalNode KYBER1024() { return getToken(T4Parser.KYBER1024, 0); }
		public TerminalNode DILITHIUM3() { return getToken(T4Parser.DILITHIUM3, 0); }
		public TerminalNode ED25519() { return getToken(T4Parser.ED25519, 0); }
		public TerminalNode P256() { return getToken(T4Parser.P256, 0); }
		public TerminalNode FALCON512() { return getToken(T4Parser.FALCON512, 0); }
		public TerminalNode CKKS() { return getToken(T4Parser.CKKS, 0); }
		public TerminalNode GROTH16() { return getToken(T4Parser.GROTH16, 0); }
		public TerminalNode BULLETPROOFS() { return getToken(T4Parser.BULLETPROOFS, 0); }
		public TerminalNode STARK() { return getToken(T4Parser.STARK, 0); }
		public TerminalNode PLONK() { return getToken(T4Parser.PLONK, 0); }
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public Algorithm_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_algorithm_type; }
	}

	public final Algorithm_typeContext algorithm_type() throws RecognitionException {
		Algorithm_typeContext _localctx = new Algorithm_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_algorithm_type);
		try {
			setState(813);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AES256:
				enterOuterAlt(_localctx, 1);
				{
				setState(801);
				match(AES256);
				}
				break;
			case KYBER1024:
				enterOuterAlt(_localctx, 2);
				{
				setState(802);
				match(KYBER1024);
				}
				break;
			case DILITHIUM3:
				enterOuterAlt(_localctx, 3);
				{
				setState(803);
				match(DILITHIUM3);
				}
				break;
			case ED25519:
				enterOuterAlt(_localctx, 4);
				{
				setState(804);
				match(ED25519);
				}
				break;
			case P256:
				enterOuterAlt(_localctx, 5);
				{
				setState(805);
				match(P256);
				}
				break;
			case FALCON512:
				enterOuterAlt(_localctx, 6);
				{
				setState(806);
				match(FALCON512);
				}
				break;
			case CKKS:
				enterOuterAlt(_localctx, 7);
				{
				setState(807);
				match(CKKS);
				}
				break;
			case GROTH16:
				enterOuterAlt(_localctx, 8);
				{
				setState(808);
				match(GROTH16);
				}
				break;
			case BULLETPROOFS:
				enterOuterAlt(_localctx, 9);
				{
				setState(809);
				match(BULLETPROOFS);
				}
				break;
			case STARK:
				enterOuterAlt(_localctx, 10);
				{
				setState(810);
				match(STARK);
				}
				break;
			case PLONK:
				enterOuterAlt(_localctx, 11);
				{
				setState(811);
				match(PLONK);
				}
				break;
			case IDENTIFIER:
			case MODULE_PATH:
				enterOuterAlt(_localctx, 12);
				{
				setState(812);
				type_path();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_pathContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode MODULE_PATH() { return getToken(T4Parser.MODULE_PATH, 0); }
		public TerminalNode COLONCOLON() { return getToken(T4Parser.COLONCOLON, 0); }
		public Generic_argsContext generic_args() {
			return getRuleContext(Generic_argsContext.class,0);
		}
		public Type_pathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_path; }
	}

	public final Type_pathContext type_path() throws RecognitionException {
		Type_pathContext _localctx = new Type_pathContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODULE_PATH) {
				{
				setState(815);
				match(MODULE_PATH);
				setState(816);
				match(COLONCOLON);
				}
			}

			setState(819);
			match(IDENTIFIER);
			setState(821);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(820);
				generic_args();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tuple_typeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Tuple_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple_type; }
	}

	public final Tuple_typeContext tuple_type() throws RecognitionException {
		Tuple_typeContext _localctx = new Tuple_typeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tuple_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			match(LPAREN);
			setState(832);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562400197607552L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 1196268659408897L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & -4089057389779615735L) != 0)) {
				{
				setState(824);
				type_();
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(825);
					match(COMMA);
					setState(826);
					type_();
					}
					}
					setState(831);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(834);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(T4Parser.LBRACKET, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			match(LBRACKET);
			setState(837);
			type_();
			setState(838);
			match(SEMICOLON);
			setState(839);
			expression();
			setState(840);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Slice_typeContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(T4Parser.LBRACKET, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public Slice_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice_type; }
	}

	public final Slice_typeContext slice_type() throws RecognitionException {
		Slice_typeContext _localctx = new Slice_typeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_slice_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			match(LBRACKET);
			setState(843);
			type_();
			setState(844);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Reference_typeContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(T4Parser.AND, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Reference_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_type; }
	}

	public final Reference_typeContext reference_type() throws RecognitionException {
		Reference_typeContext _localctx = new Reference_typeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_reference_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
			match(AND);
			setState(847);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mutable_reference_typeContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(T4Parser.AND, 0); }
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Mutable_reference_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutable_reference_type; }
	}

	public final Mutable_reference_typeContext mutable_reference_type() throws RecognitionException {
		Mutable_reference_typeContext _localctx = new Mutable_reference_typeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mutable_reference_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			match(AND);
			setState(850);
			match(MUT);
			setState(851);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_typeContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_type; }
	}

	public final Function_typeContext function_type() throws RecognitionException {
		Function_typeContext _localctx = new Function_typeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(853);
			match(FN);
			setState(854);
			match(LPAREN);
			setState(856);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || _la==IDENTIFIER || _la==REF) {
				{
				setState(855);
				parameters();
				}
			}

			setState(858);
			match(RPAREN);
			setState(861);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(859);
				match(ARROW);
				setState(860);
				return_type();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_typeContext extends ParserRuleContext {
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_argsContext type_args() {
			return getRuleContext(Type_argsContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public Generic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_type; }
	}

	public final Generic_typeContext generic_type() throws RecognitionException {
		Generic_typeContext _localctx = new Generic_typeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_generic_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			type_path();
			setState(864);
			match(LT);
			setState(865);
			type_args();
			setState(866);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_argsContext extends ParserRuleContext {
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Type_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_args; }
	}

	public final Type_argsContext type_args() throws RecognitionException {
		Type_argsContext _localctx = new Type_argsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868);
			type_();
			setState(873);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(869);
				match(COMMA);
				setState(870);
				type_();
				}
				}
				setState(875);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_paramsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public List<Generic_paramContext> generic_param() {
			return getRuleContexts(Generic_paramContext.class);
		}
		public Generic_paramContext generic_param(int i) {
			return getRuleContext(Generic_paramContext.class,i);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Generic_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_params; }
	}

	public final Generic_paramsContext generic_params() throws RecognitionException {
		Generic_paramsContext _localctx = new Generic_paramsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_generic_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
			match(LT);
			setState(877);
			generic_param();
			setState(882);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(878);
				match(COMMA);
				setState(879);
				generic_param();
				}
				}
				setState(884);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(885);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_paramContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public List<BoundContext> bound() {
			return getRuleContexts(BoundContext.class);
		}
		public BoundContext bound(int i) {
			return getRuleContext(BoundContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(T4Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(T4Parser.PLUS, i);
		}
		public Generic_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_param; }
	}

	public final Generic_paramContext generic_param() throws RecognitionException {
		Generic_paramContext _localctx = new Generic_paramContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_generic_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			match(IDENTIFIER);
			setState(897);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(888);
				match(COLON);
				setState(889);
				bound();
				setState(894);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PLUS) {
					{
					{
					setState(890);
					match(PLUS);
					setState(891);
					bound();
					}
					}
					setState(896);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoundContext extends ParserRuleContext {
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode LIFETIME() { return getToken(T4Parser.LIFETIME, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<BoundContext> bound() {
			return getRuleContexts(BoundContext.class);
		}
		public BoundContext bound(int i) {
			return getRuleContext(BoundContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode QUESTION() { return getToken(T4Parser.QUESTION, 0); }
		public List<TerminalNode> PLUS() { return getTokens(T4Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(T4Parser.PLUS, i);
		}
		public BoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bound; }
	}

	public final BoundContext bound() throws RecognitionException {
		BoundContext _localctx = new BoundContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bound);
		int _la;
		try {
			setState(915);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case MODULE_PATH:
				enterOuterAlt(_localctx, 1);
				{
				setState(899);
				type_path();
				}
				break;
			case LIFETIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(900);
				match(LIFETIME);
				}
				break;
			case LPAREN:
			case QUESTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(902);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(901);
					match(QUESTION);
					}
				}

				setState(904);
				match(LPAREN);
				setState(905);
				bound();
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PLUS) {
					{
					{
					setState(906);
					match(PLUS);
					setState(907);
					bound();
					}
					}
					setState(912);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(913);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE_() { return getToken(T4Parser.WHERE_, 0); }
		public List<Where_itemContext> where_item() {
			return getRuleContexts(Where_itemContext.class);
		}
		public Where_itemContext where_item(int i) {
			return getRuleContext(Where_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_where_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			match(WHERE_);
			setState(918);
			where_item();
			setState(923);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(919);
				match(COMMA);
				setState(920);
				where_item();
				}
				}
				setState(925);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Where_itemContext extends ParserRuleContext {
		public Generic_paramContext generic_param() {
			return getRuleContext(Generic_paramContext.class,0);
		}
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public List<BoundContext> bound() {
			return getRuleContexts(BoundContext.class);
		}
		public BoundContext bound(int i) {
			return getRuleContext(BoundContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(T4Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(T4Parser.PLUS, i);
		}
		public Where_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_item; }
	}

	public final Where_itemContext where_item() throws RecognitionException {
		Where_itemContext _localctx = new Where_itemContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_where_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
			generic_param();
			setState(927);
			match(COLON);
			setState(928);
			bound();
			setState(933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(929);
				match(PLUS);
				setState(930);
				bound();
				}
				}
				setState(935);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			parameter();
			setState(941);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(937);
				match(COMMA);
				setState(938);
				parameter();
				}
				}
				setState(943);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public TerminalNode REF() { return getToken(T4Parser.REF, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(948);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(944);
				match(MUT);
				}
				break;
			case 2:
				{
				setState(945);
				match(REF);
				}
				break;
			case 3:
				{
				setState(946);
				match(MUT);
				setState(947);
				match(REF);
				}
				break;
			}
			setState(950);
			match(IDENTIFIER);
			setState(951);
			match(COLON);
			setState(952);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_typeContext extends ParserRuleContext {
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_return_type);
		int _la;
		try {
			setState(967);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(954);
				type_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(955);
				match(LPAREN);
				setState(964);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562400197607552L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 1196268659408897L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & -4089057389779615735L) != 0)) {
					{
					setState(956);
					type_();
					setState(961);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(957);
						match(COMMA);
						setState(958);
						type_();
						}
						}
						setState(963);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(966);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declarationContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(T4Parser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Generic_paramsContext generic_params() {
			return getRuleContext(Generic_paramsContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public Struct_fieldsContext struct_fields() {
			return getRuleContext(Struct_fieldsContext.class,0);
		}
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_struct_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			match(STRUCT);
			setState(970);
			match(IDENTIFIER);
			setState(972);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(971);
				generic_params();
				}
			}

			setState(979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(974);
				match(LPAREN);
				setState(976);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUB_ || _la==IDENTIFIER) {
					{
					setState(975);
					struct_fields();
					}
				}

				setState(978);
				match(RPAREN);
				}
			}

			setState(982);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(981);
				where_clause();
				}
			}

			setState(993);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(984);
				match(LBRACE);
				setState(988);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PUB_ || _la==IDENTIFIER) {
					{
					{
					setState(985);
					struct_field();
					}
					}
					setState(990);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(991);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(992);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_fieldsContext extends ParserRuleContext {
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Struct_fieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_fields; }
	}

	public final Struct_fieldsContext struct_fields() throws RecognitionException {
		Struct_fieldsContext _localctx = new Struct_fieldsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_struct_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(995);
			struct_field();
			setState(1000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(996);
				match(COMMA);
				setState(997);
				struct_field();
				}
				}
				setState(1002);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_fieldContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode PUB_() { return getToken(T4Parser.PUB_, 0); }
		public Struct_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_field; }
	}

	public final Struct_fieldContext struct_field() throws RecognitionException {
		Struct_fieldContext _localctx = new Struct_fieldContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_struct_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUB_) {
				{
				setState(1003);
				match(PUB_);
				}
			}

			setState(1006);
			match(IDENTIFIER);
			setState(1007);
			match(COLON);
			setState(1008);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enum_declarationContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(T4Parser.ENUM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public Generic_paramsContext generic_params() {
			return getRuleContext(Generic_paramsContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public List<Enum_variantContext> enum_variant() {
			return getRuleContexts(Enum_variantContext.class);
		}
		public Enum_variantContext enum_variant(int i) {
			return getRuleContext(Enum_variantContext.class,i);
		}
		public Enum_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_declaration; }
	}

	public final Enum_declarationContext enum_declaration() throws RecognitionException {
		Enum_declarationContext _localctx = new Enum_declarationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_enum_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1010);
			match(ENUM);
			setState(1011);
			match(IDENTIFIER);
			setState(1013);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1012);
				generic_params();
				}
			}

			setState(1016);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(1015);
				where_clause();
				}
			}

			setState(1018);
			match(LBRACE);
			setState(1022);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(1019);
				enum_variant();
				}
				}
				setState(1024);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1025);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enum_variantContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Enum_variantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_variant; }
	}

	public final Enum_variantContext enum_variant() throws RecognitionException {
		Enum_variantContext _localctx = new Enum_variantContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_enum_variant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1027);
			match(IDENTIFIER);
			setState(1040);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(1028);
				match(LPAREN);
				setState(1037);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562400197607552L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 1196268659408897L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & -4089057389779615735L) != 0)) {
					{
					setState(1029);
					type_();
					setState(1034);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1030);
						match(COMMA);
						setState(1031);
						type_();
						}
						}
						setState(1036);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1039);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trait_declarationContext extends ParserRuleContext {
		public TerminalNode TRAIT() { return getToken(T4Parser.TRAIT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public Generic_paramsContext generic_params() {
			return getRuleContext(Generic_paramsContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public List<Trait_itemContext> trait_item() {
			return getRuleContexts(Trait_itemContext.class);
		}
		public Trait_itemContext trait_item(int i) {
			return getRuleContext(Trait_itemContext.class,i);
		}
		public Trait_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_declaration; }
	}

	public final Trait_declarationContext trait_declaration() throws RecognitionException {
		Trait_declarationContext _localctx = new Trait_declarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_trait_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			match(TRAIT);
			setState(1043);
			match(IDENTIFIER);
			setState(1045);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1044);
				generic_params();
				}
			}

			setState(1048);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(1047);
				where_clause();
				}
			}

			setState(1050);
			match(LBRACE);
			setState(1054);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536872064L) != 0)) {
				{
				{
				setState(1051);
				trait_item();
				}
				}
				setState(1056);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1057);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trait_itemContext extends ParserRuleContext {
		public Function_declarationContext function_declaration() {
			return getRuleContext(Function_declarationContext.class,0);
		}
		public Const_declarationContext const_declaration() {
			return getRuleContext(Const_declarationContext.class,0);
		}
		public Type_aliasContext type_alias() {
			return getRuleContext(Type_aliasContext.class,0);
		}
		public Trait_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_item; }
	}

	public final Trait_itemContext trait_item() throws RecognitionException {
		Trait_itemContext _localctx = new Trait_itemContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_trait_item);
		try {
			setState(1062);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1059);
				function_declaration();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(1060);
				const_declaration();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1061);
				type_alias();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Impl_blockContext extends ParserRuleContext {
		public TerminalNode IMPL() { return getToken(T4Parser.IMPL, 0); }
		public List<Type_pathContext> type_path() {
			return getRuleContexts(Type_pathContext.class);
		}
		public Type_pathContext type_path(int i) {
			return getRuleContext(Type_pathContext.class,i);
		}
		public TerminalNode FOR() { return getToken(T4Parser.FOR, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public Generic_paramsContext generic_params() {
			return getRuleContext(Generic_paramsContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public List<Impl_itemContext> impl_item() {
			return getRuleContexts(Impl_itemContext.class);
		}
		public Impl_itemContext impl_item(int i) {
			return getRuleContext(Impl_itemContext.class,i);
		}
		public Impl_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impl_block; }
	}

	public final Impl_blockContext impl_block() throws RecognitionException {
		Impl_blockContext _localctx = new Impl_blockContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_impl_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			match(IMPL);
			setState(1066);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1065);
				generic_params();
				}
			}

			setState(1068);
			type_path();
			setState(1070);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(1069);
				where_clause();
				}
			}

			setState(1072);
			match(FOR);
			setState(1073);
			type_path();
			setState(1074);
			match(LBRACE);
			setState(1078);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536872064L) != 0)) {
				{
				{
				setState(1075);
				impl_item();
				}
				}
				setState(1080);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1081);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Impl_itemContext extends ParserRuleContext {
		public Function_declarationContext function_declaration() {
			return getRuleContext(Function_declarationContext.class,0);
		}
		public Const_declarationContext const_declaration() {
			return getRuleContext(Const_declarationContext.class,0);
		}
		public Type_aliasContext type_alias() {
			return getRuleContext(Type_aliasContext.class,0);
		}
		public Impl_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impl_item; }
	}

	public final Impl_itemContext impl_item() throws RecognitionException {
		Impl_itemContext _localctx = new Impl_itemContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_impl_item);
		try {
			setState(1086);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1083);
				function_declaration();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(1084);
				const_declaration();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1085);
				type_alias();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_aliasContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(T4Parser.TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Generic_paramsContext generic_params() {
			return getRuleContext(Generic_paramsContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Type_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_alias; }
	}

	public final Type_aliasContext type_alias() throws RecognitionException {
		Type_aliasContext _localctx = new Type_aliasContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_type_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			match(TYPE);
			setState(1089);
			match(IDENTIFIER);
			setState(1091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1090);
				generic_params();
				}
			}

			setState(1094);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(1093);
				where_clause();
				}
			}

			setState(1096);
			match(ASSIGN);
			setState(1097);
			type_();
			setState(1098);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Const_declarationContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(T4Parser.CONST, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Const_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_declaration; }
	}

	public final Const_declarationContext const_declaration() throws RecognitionException {
		Const_declarationContext _localctx = new Const_declarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_const_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1100);
			match(CONST);
			setState(1101);
			match(IDENTIFIER);
			setState(1102);
			match(COLON);
			setState(1103);
			type_();
			setState(1104);
			match(ASSIGN);
			setState(1105);
			expression();
			setState(1106);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Static_declarationContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(T4Parser.STATIC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public Static_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_declaration; }
	}

	public final Static_declarationContext static_declaration() throws RecognitionException {
		Static_declarationContext _localctx = new Static_declarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_static_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108);
			match(STATIC);
			setState(1110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(1109);
				match(MUT);
				}
			}

			setState(1112);
			match(IDENTIFIER);
			setState(1113);
			match(COLON);
			setState(1114);
			type_();
			setState(1115);
			match(ASSIGN);
			setState(1116);
			expression();
			setState(1117);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Let_statementContext let_statement() {
			return getRuleContext(Let_statementContext.class,0);
		}
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Break_statementContext break_statement() {
			return getRuleContext(Break_statementContext.class,0);
		}
		public Continue_statementContext continue_statement() {
			return getRuleContext(Continue_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Match_statementContext match_statement() {
			return getRuleContext(Match_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public Async_statementContext async_statement() {
			return getRuleContext(Async_statementContext.class,0);
		}
		public Early_returnContext early_return() {
			return getRuleContext(Early_returnContext.class,0);
		}
		public Yield_statementContext yield_statement() {
			return getRuleContext(Yield_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_statement);
		try {
			setState(1133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1119);
				let_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1120);
				expression_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1121);
				assignment_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1122);
				return_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1123);
				break_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1124);
				continue_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1125);
				if_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1126);
				match_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1127);
				while_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1128);
				for_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1129);
				loop_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1130);
				async_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1131);
				early_return();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1132);
				yield_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_statementContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(T4Parser.LET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Let_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_statement; }
	}

	public final Let_statementContext let_statement() throws RecognitionException {
		Let_statementContext _localctx = new Let_statementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_let_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135);
			match(LET);
			setState(1137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(1136);
				match(MUT);
				}
			}

			setState(1139);
			match(IDENTIFIER);
			setState(1142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1140);
				match(COLON);
				setState(1141);
				type_();
				}
			}

			setState(1146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(1144);
				match(ASSIGN);
				setState(1145);
				expression();
				}
			}

			setState(1148);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_expression_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1150);
			expression();
			setState(1151);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assignment_statementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Assignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_statement; }
	}

	public final Assignment_statementContext assignment_statement() throws RecognitionException {
		Assignment_statementContext _localctx = new Assignment_statementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_assignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153);
			expression();
			setState(1154);
			match(ASSIGN);
			setState(1155);
			expression();
			setState(1156);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_statementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(T4Parser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158);
			match(RETURN);
			setState(1160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(1159);
				expression();
				}
			}

			setState(1162);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Break_statementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(T4Parser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Break_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_statement; }
	}

	public final Break_statementContext break_statement() throws RecognitionException {
		Break_statementContext _localctx = new Break_statementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_break_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1164);
			match(BREAK);
			setState(1166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(1165);
				expression();
				}
			}

			setState(1168);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Continue_statementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(T4Parser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Continue_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_statement; }
	}

	public final Continue_statementContext continue_statement() throws RecognitionException {
		Continue_statementContext _localctx = new Continue_statementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_continue_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1170);
			match(CONTINUE);
			setState(1171);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_statementContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(T4Parser.IF); }
		public TerminalNode IF(int i) {
			return getToken(T4Parser.IF, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(T4Parser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(T4Parser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(T4Parser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(T4Parser.RBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(T4Parser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(T4Parser.ELSE, i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_if_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1173);
			match(IF);
			setState(1174);
			expression();
			setState(1175);
			match(LBRACE);
			setState(1179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
				{
				{
				setState(1176);
				statement();
				}
				}
				setState(1181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1182);
			match(RBRACE);
			setState(1197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1183);
					match(ELSE);
					setState(1184);
					match(IF);
					setState(1185);
					expression();
					setState(1186);
					match(LBRACE);
					setState(1190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
						{
						{
						setState(1187);
						statement();
						}
						}
						setState(1192);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1193);
					match(RBRACE);
					}
					} 
				}
				setState(1199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			}
			setState(1209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1200);
				match(ELSE);
				setState(1201);
				match(LBRACE);
				setState(1205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
					{
					{
					setState(1202);
					statement();
					}
					}
					setState(1207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1208);
				match(RBRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Match_statementContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(T4Parser.MATCH, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Match_armContext> match_arm() {
			return getRuleContexts(Match_armContext.class);
		}
		public Match_armContext match_arm(int i) {
			return getRuleContext(Match_armContext.class,i);
		}
		public Match_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_statement; }
	}

	public final Match_statementContext match_statement() throws RecognitionException {
		Match_statementContext _localctx = new Match_statementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_match_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1211);
			match(MATCH);
			setState(1212);
			expression();
			setState(1213);
			match(LBRACE);
			setState(1217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 38280596832650239L) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & 2251799813685285L) != 0)) {
				{
				{
				setState(1214);
				match_arm();
				}
				}
				setState(1219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1220);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Match_armContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode FAT_ARROW() { return getToken(T4Parser.FAT_ARROW, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Match_armContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_arm; }
	}

	public final Match_armContext match_arm() throws RecognitionException {
		Match_armContext _localctx = new Match_armContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_match_arm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1222);
			pattern();
			setState(1223);
			match(FAT_ARROW);
			setState(1224);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(T4Parser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_while_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1226);
			match(WHILE);
			setState(1227);
			expression();
			setState(1228);
			match(LBRACE);
			setState(1232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
				{
				{
				setState(1229);
				statement();
				}
				}
				setState(1234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1235);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(T4Parser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(T4Parser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1237);
			match(FOR);
			setState(1238);
			match(IDENTIFIER);
			setState(1239);
			match(IN);
			setState(1240);
			expression();
			setState(1241);
			match(LBRACE);
			setState(1245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
				{
				{
				setState(1242);
				statement();
				}
				}
				setState(1247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1248);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_statementContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(T4Parser.LOOP, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Loop_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_statement; }
	}

	public final Loop_statementContext loop_statement() throws RecognitionException {
		Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_loop_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1250);
			match(LOOP);
			setState(1251);
			match(LBRACE);
			setState(1255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
				{
				{
				setState(1252);
				statement();
				}
				}
				setState(1257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1258);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Atom_expressionContext extends ParserRuleContext {
		public Literal_expressionContext literal_expression() {
			return getRuleContext(Literal_expressionContext.class,0);
		}
		public Path_expressionContext path_expression() {
			return getRuleContext(Path_expressionContext.class,0);
		}
		public Tuple_expressionContext tuple_expression() {
			return getRuleContext(Tuple_expressionContext.class,0);
		}
		public Array_expressionContext array_expression() {
			return getRuleContext(Array_expressionContext.class,0);
		}
		public Struct_expressionContext struct_expression() {
			return getRuleContext(Struct_expressionContext.class,0);
		}
		public Enum_expressionContext enum_expression() {
			return getRuleContext(Enum_expressionContext.class,0);
		}
		public Grouped_expressionContext grouped_expression() {
			return getRuleContext(Grouped_expressionContext.class,0);
		}
		public Block_expressionContext block_expression() {
			return getRuleContext(Block_expressionContext.class,0);
		}
		public If_expressionContext if_expression() {
			return getRuleContext(If_expressionContext.class,0);
		}
		public Match_expressionContext match_expression() {
			return getRuleContext(Match_expressionContext.class,0);
		}
		public Closure_expressionContext closure_expression() {
			return getRuleContext(Closure_expressionContext.class,0);
		}
		public Async_expressionContext async_expression() {
			return getRuleContext(Async_expressionContext.class,0);
		}
		public Cryptographic_expressionContext cryptographic_expression() {
			return getRuleContext(Cryptographic_expressionContext.class,0);
		}
		public Security_annotationContext security_annotation() {
			return getRuleContext(Security_annotationContext.class,0);
		}
		public Atom_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom_expression; }
	}

	public final Atom_expressionContext atom_expression() throws RecognitionException {
		Atom_expressionContext _localctx = new Atom_expressionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_atom_expression);
		try {
			setState(1274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1260);
				literal_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1261);
				path_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1262);
				tuple_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1263);
				array_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1264);
				struct_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1265);
				enum_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1266);
				grouped_expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1267);
				block_expression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1268);
				if_expression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1269);
				match_expression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1270);
				closure_expression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1271);
				async_expression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1272);
				cryptographic_expression();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1273);
				security_annotation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Binary_expressionContext binary_expression() {
			return getRuleContext(Binary_expressionContext.class,0);
		}
		public Call_expressionContext call_expression() {
			return getRuleContext(Call_expressionContext.class,0);
		}
		public Index_expressionContext index_expression() {
			return getRuleContext(Index_expressionContext.class,0);
		}
		public Field_expressionContext field_expression() {
			return getRuleContext(Field_expressionContext.class,0);
		}
		public Method_expressionContext method_expression() {
			return getRuleContext(Method_expressionContext.class,0);
		}
		public Range_expressionContext range_expression() {
			return getRuleContext(Range_expressionContext.class,0);
		}
		public Reference_expressionContext reference_expression() {
			return getRuleContext(Reference_expressionContext.class,0);
		}
		public Dereference_expressionContext dereference_expression() {
			return getRuleContext(Dereference_expressionContext.class,0);
		}
		public Type_cast_expressionContext type_cast_expression() {
			return getRuleContext(Type_cast_expressionContext.class,0);
		}
		public Await_expressionContext await_expression() {
			return getRuleContext(Await_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_expression);
		try {
			setState(1288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1276);
				atom_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1277);
				unary_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1278);
				binary_expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1279);
				call_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1280);
				index_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1281);
				field_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1282);
				method_expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1283);
				range_expression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1284);
				reference_expression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1285);
				dereference_expression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1286);
				type_cast_expression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1287);
				await_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Literal_expressionContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(T4Parser.INTEGER, 0); }
		public TerminalNode HEX_INTEGER() { return getToken(T4Parser.HEX_INTEGER, 0); }
		public TerminalNode OCT_INTEGER() { return getToken(T4Parser.OCT_INTEGER, 0); }
		public TerminalNode BIN_INTEGER() { return getToken(T4Parser.BIN_INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(T4Parser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(T4Parser.STRING, 0); }
		public TerminalNode BYTE_STRING() { return getToken(T4Parser.BYTE_STRING, 0); }
		public TerminalNode CHAR() { return getToken(T4Parser.CHAR, 0); }
		public TerminalNode TRUE() { return getToken(T4Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(T4Parser.FALSE, 0); }
		public Literal_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_expression; }
	}

	public final Literal_expressionContext literal_expression() throws RecognitionException {
		Literal_expressionContext _localctx = new Literal_expressionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_literal_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1290);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 1023L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Path_expressionContext extends ParserRuleContext {
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode MODULE_PATH() { return getToken(T4Parser.MODULE_PATH, 0); }
		public TerminalNode COLONCOLON() { return getToken(T4Parser.COLONCOLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_expression; }
	}

	public final Path_expressionContext path_expression() throws RecognitionException {
		Path_expressionContext _localctx = new Path_expressionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_path_expression);
		try {
			setState(1296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1292);
				type_path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1293);
				match(MODULE_PATH);
				setState(1294);
				match(COLONCOLON);
				setState(1295);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Binary_expressionContext extends ParserRuleContext {
		public List<Atom_expressionContext> atom_expression() {
			return getRuleContexts(Atom_expressionContext.class);
		}
		public Atom_expressionContext atom_expression(int i) {
			return getRuleContext(Atom_expressionContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Binary_expressionContext binary_expression() {
			return getRuleContext(Binary_expressionContext.class,0);
		}
		public Binary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_expression; }
	}

	public final Binary_expressionContext binary_expression() throws RecognitionException {
		return binary_expression(0);
	}

	private Binary_expressionContext binary_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Binary_expressionContext _localctx = new Binary_expressionContext(_ctx, _parentState);
		Binary_expressionContext _prevctx = _localctx;
		int _startState = 118;
		enterRecursionRule(_localctx, 118, RULE_binary_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1299);
			atom_expression();
			setState(1300);
			operator();
			setState(1301);
			atom_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(1309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Binary_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
					setState(1303);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1304);
					operator();
					setState(1305);
					atom_expression();
					}
					} 
				}
				setState(1311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(T4Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(T4Parser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(T4Parser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(T4Parser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(T4Parser.PERCENT, 0); }
		public TerminalNode EQ() { return getToken(T4Parser.EQ, 0); }
		public TerminalNode NE() { return getToken(T4Parser.NE, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LE() { return getToken(T4Parser.LE, 0); }
		public TerminalNode GE() { return getToken(T4Parser.GE, 0); }
		public TerminalNode AND() { return getToken(T4Parser.AND, 0); }
		public TerminalNode OR() { return getToken(T4Parser.OR, 0); }
		public TerminalNode CARET() { return getToken(T4Parser.CARET, 0); }
		public TerminalNode ANDAND() { return getToken(T4Parser.ANDAND, 0); }
		public TerminalNode OROR() { return getToken(T4Parser.OROR, 0); }
		public TerminalNode SHL() { return getToken(T4Parser.SHL, 0); }
		public TerminalNode SHR() { return getToken(T4Parser.SHR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1312);
			_la = _input.LA(1);
			if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & 524223L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(T4Parser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(T4Parser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(T4Parser.STAR, 0); }
		public TerminalNode AND() { return getToken(T4Parser.AND, 0); }
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_unary_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				{
				setState(1314);
				match(NOT);
				}
				break;
			case 2:
				{
				setState(1315);
				match(MINUS);
				}
				break;
			case 3:
				{
				setState(1316);
				match(STAR);
				}
				break;
			case 4:
				{
				setState(1317);
				match(AND);
				}
				break;
			case 5:
				{
				setState(1318);
				match(AND);
				setState(1319);
				match(MUT);
				}
				break;
			}
			setState(1322);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Call_expressionContext extends ParserRuleContext {
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Call_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expression; }
	}

	public final Call_expressionContext call_expression() throws RecognitionException {
		Call_expressionContext _localctx = new Call_expressionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_call_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1324);
			atom_expression();
			setState(1325);
			match(LPAREN);
			setState(1327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(1326);
				arguments();
				}
			}

			setState(1329);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<Atom_expressionContext> atom_expression() {
			return getRuleContexts(Atom_expressionContext.class);
		}
		public Atom_expressionContext atom_expression(int i) {
			return getRuleContext(Atom_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1331);
			atom_expression();
			setState(1336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1332);
				match(COMMA);
				setState(1333);
				atom_expression();
				}
				}
				setState(1338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Index_expressionContext extends ParserRuleContext {
		public List<Atom_expressionContext> atom_expression() {
			return getRuleContexts(Atom_expressionContext.class);
		}
		public Atom_expressionContext atom_expression(int i) {
			return getRuleContext(Atom_expressionContext.class,i);
		}
		public TerminalNode LBRACKET() { return getToken(T4Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public Index_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_expression; }
	}

	public final Index_expressionContext index_expression() throws RecognitionException {
		Index_expressionContext _localctx = new Index_expressionContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_index_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1339);
			atom_expression();
			setState(1340);
			match(LBRACKET);
			setState(1341);
			atom_expression();
			setState(1342);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_expressionContext extends ParserRuleContext {
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(T4Parser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Field_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_expression; }
	}

	public final Field_expressionContext field_expression() throws RecognitionException {
		Field_expressionContext _localctx = new Field_expressionContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_field_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1344);
			atom_expression();
			setState(1345);
			match(DOT);
			setState(1346);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_expressionContext extends ParserRuleContext {
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(T4Parser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Method_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_expression; }
	}

	public final Method_expressionContext method_expression() throws RecognitionException {
		Method_expressionContext _localctx = new Method_expressionContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_method_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1348);
			atom_expression();
			setState(1349);
			match(DOT);
			setState(1350);
			match(IDENTIFIER);
			setState(1351);
			match(LPAREN);
			setState(1353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(1352);
				arguments();
				}
			}

			setState(1355);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tuple_expressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<Atom_expressionContext> atom_expression() {
			return getRuleContexts(Atom_expressionContext.class);
		}
		public Atom_expressionContext atom_expression(int i) {
			return getRuleContext(Atom_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Tuple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple_expression; }
	}

	public final Tuple_expressionContext tuple_expression() throws RecognitionException {
		Tuple_expressionContext _localctx = new Tuple_expressionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_tuple_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1357);
			match(LPAREN);
			setState(1366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(1358);
				atom_expression();
				setState(1363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1359);
					match(COMMA);
					setState(1360);
					atom_expression();
					}
					}
					setState(1365);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1368);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_expressionContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(T4Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public List<Atom_expressionContext> atom_expression() {
			return getRuleContexts(Atom_expressionContext.class);
		}
		public Atom_expressionContext atom_expression(int i) {
			return getRuleContext(Atom_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Array_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expression; }
	}

	public final Array_expressionContext array_expression() throws RecognitionException {
		Array_expressionContext _localctx = new Array_expressionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_array_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1370);
			match(LBRACKET);
			setState(1379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(1371);
				atom_expression();
				setState(1376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1372);
					match(COMMA);
					setState(1373);
					atom_expression();
					}
					}
					setState(1378);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1381);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_expressionContext extends ParserRuleContext {
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Field_initContext> field_init() {
			return getRuleContexts(Field_initContext.class);
		}
		public Field_initContext field_init(int i) {
			return getRuleContext(Field_initContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Struct_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_expression; }
	}

	public final Struct_expressionContext struct_expression() throws RecognitionException {
		Struct_expressionContext _localctx = new Struct_expressionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_struct_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1383);
			type_path();
			setState(1384);
			match(LBRACE);
			setState(1393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1385);
				field_init();
				setState(1390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1386);
					match(COMMA);
					setState(1387);
					field_init();
					}
					}
					setState(1392);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1395);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_initContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public Field_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_init; }
	}

	public final Field_initContext field_init() throws RecognitionException {
		Field_initContext _localctx = new Field_initContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_field_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1397);
			match(IDENTIFIER);
			setState(1398);
			match(COLON);
			setState(1399);
			atom_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enum_expressionContext extends ParserRuleContext {
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(T4Parser.COLONCOLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Enum_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_expression; }
	}

	public final Enum_expressionContext enum_expression() throws RecognitionException {
		Enum_expressionContext _localctx = new Enum_expressionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_enum_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1401);
			type_path();
			setState(1402);
			match(COLONCOLON);
			setState(1403);
			match(IDENTIFIER);
			setState(1409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(1404);
				match(LPAREN);
				setState(1406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
					{
					setState(1405);
					arguments();
					}
				}

				setState(1408);
				match(RPAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Range_expressionContext extends ParserRuleContext {
		public List<Atom_expressionContext> atom_expression() {
			return getRuleContexts(Atom_expressionContext.class);
		}
		public Atom_expressionContext atom_expression(int i) {
			return getRuleContext(Atom_expressionContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(T4Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(T4Parser.DOT, i);
		}
		public Range_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_expression; }
	}

	public final Range_expressionContext range_expression() throws RecognitionException {
		Range_expressionContext _localctx = new Range_expressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_range_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1411);
			atom_expression();
			setState(1412);
			match(DOT);
			setState(1413);
			match(DOT);
			setState(1415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(1414);
				atom_expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Reference_expressionContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(T4Parser.AND, 0); }
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public Reference_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_expression; }
	}

	public final Reference_expressionContext reference_expression() throws RecognitionException {
		Reference_expressionContext _localctx = new Reference_expressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_reference_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1417);
			match(AND);
			setState(1419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(1418);
				match(MUT);
				}
			}

			setState(1421);
			atom_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dereference_expressionContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(T4Parser.STAR, 0); }
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public Dereference_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dereference_expression; }
	}

	public final Dereference_expressionContext dereference_expression() throws RecognitionException {
		Dereference_expressionContext _localctx = new Dereference_expressionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_dereference_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1423);
			match(STAR);
			setState(1424);
			atom_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_cast_expressionContext extends ParserRuleContext {
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode AS_() { return getToken(T4Parser.AS_, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Type_cast_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_cast_expression; }
	}

	public final Type_cast_expressionContext type_cast_expression() throws RecognitionException {
		Type_cast_expressionContext _localctx = new Type_cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_type_cast_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1426);
			atom_expression();
			setState(1427);
			match(AS_);
			setState(1428);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Grouped_expressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Grouped_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouped_expression; }
	}

	public final Grouped_expressionContext grouped_expression() throws RecognitionException {
		Grouped_expressionContext _localctx = new Grouped_expressionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_grouped_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1430);
			match(LPAREN);
			setState(1431);
			atom_expression();
			setState(1432);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_expressionContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public Block_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_expression; }
	}

	public final Block_expressionContext block_expression() throws RecognitionException {
		Block_expressionContext _localctx = new Block_expressionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_block_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1434);
			match(LBRACE);
			setState(1438);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1435);
					statement();
					}
					} 
				}
				setState(1440);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
			}
			setState(1442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(1441);
				atom_expression();
				}
			}

			setState(1444);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_expressionContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(T4Parser.IF); }
		public TerminalNode IF(int i) {
			return getToken(T4Parser.IF, i);
		}
		public List<Atom_expressionContext> atom_expression() {
			return getRuleContexts(Atom_expressionContext.class);
		}
		public Atom_expressionContext atom_expression(int i) {
			return getRuleContext(Atom_expressionContext.class,i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(T4Parser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(T4Parser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(T4Parser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(T4Parser.RBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(T4Parser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(T4Parser.ELSE, i);
		}
		public If_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expression; }
	}

	public final If_expressionContext if_expression() throws RecognitionException {
		If_expressionContext _localctx = new If_expressionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_if_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1446);
			match(IF);
			setState(1447);
			atom_expression();
			setState(1448);
			match(LBRACE);
			setState(1452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
				{
				{
				setState(1449);
				statement();
				}
				}
				setState(1454);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1455);
			match(RBRACE);
			setState(1470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1456);
					match(ELSE);
					setState(1457);
					match(IF);
					setState(1458);
					atom_expression();
					setState(1459);
					match(LBRACE);
					setState(1463);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
						{
						{
						setState(1460);
						statement();
						}
						}
						setState(1465);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1466);
					match(RBRACE);
					}
					} 
				}
				setState(1472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			}
			setState(1482);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(1473);
				match(ELSE);
				setState(1474);
				match(LBRACE);
				setState(1478);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
					{
					{
					setState(1475);
					statement();
					}
					}
					setState(1480);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1481);
				match(RBRACE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Match_expressionContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(T4Parser.MATCH, 0); }
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Match_armContext> match_arm() {
			return getRuleContexts(Match_armContext.class);
		}
		public Match_armContext match_arm(int i) {
			return getRuleContext(Match_armContext.class,i);
		}
		public Match_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_expression; }
	}

	public final Match_expressionContext match_expression() throws RecognitionException {
		Match_expressionContext _localctx = new Match_expressionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_match_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1484);
			match(MATCH);
			setState(1485);
			atom_expression();
			setState(1486);
			match(LBRACE);
			setState(1490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 38280596832650239L) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & 2251799813685285L) != 0)) {
				{
				{
				setState(1487);
				match_arm();
				}
				}
				setState(1492);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1493);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Closure_expressionContext extends ParserRuleContext {
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public List<TerminalNode> OR() { return getTokens(T4Parser.OR); }
		public TerminalNode OR(int i) {
			return getToken(T4Parser.OR, i);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode MOVE() { return getToken(T4Parser.MOVE, 0); }
		public TerminalNode STATIC() { return getToken(T4Parser.STATIC, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Closure_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closure_expression; }
	}

	public final Closure_expressionContext closure_expression() throws RecognitionException {
		Closure_expressionContext _localctx = new Closure_expressionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_closure_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC || _la==MOVE) {
				{
				setState(1495);
				_la = _input.LA(1);
				if ( !(_la==STATIC || _la==MOVE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			{
			setState(1498);
			match(OR);
			setState(1499);
			match(OR);
			setState(1501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || _la==IDENTIFIER || _la==REF) {
				{
				setState(1500);
				parameters();
				}
			}

			setState(1503);
			match(OR);
			}
			setState(1507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(1505);
				match(ARROW);
				setState(1506);
				return_type();
				}
			}

			setState(1509);
			atom_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Async_expressionContext extends ParserRuleContext {
		public TerminalNode ASYNC() { return getToken(T4Parser.ASYNC, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Async_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_async_expression; }
	}

	public final Async_expressionContext async_expression() throws RecognitionException {
		Async_expressionContext _localctx = new Async_expressionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_async_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1511);
			match(ASYNC);
			setState(1512);
			match(LBRACE);
			setState(1516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
				{
				{
				setState(1513);
				statement();
				}
				}
				setState(1518);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1519);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Await_expressionContext extends ParserRuleContext {
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(T4Parser.DOT, 0); }
		public TerminalNode AWAIT() { return getToken(T4Parser.AWAIT, 0); }
		public Await_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_await_expression; }
	}

	public final Await_expressionContext await_expression() throws RecognitionException {
		Await_expressionContext _localctx = new Await_expressionContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_await_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1521);
			atom_expression();
			setState(1522);
			match(DOT);
			setState(1523);
			match(AWAIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cryptographic_expressionContext extends ParserRuleContext {
		public Encrypt_expressionContext encrypt_expression() {
			return getRuleContext(Encrypt_expressionContext.class,0);
		}
		public Decrypt_expressionContext decrypt_expression() {
			return getRuleContext(Decrypt_expressionContext.class,0);
		}
		public Sign_expressionContext sign_expression() {
			return getRuleContext(Sign_expressionContext.class,0);
		}
		public Verify_expressionContext verify_expression() {
			return getRuleContext(Verify_expressionContext.class,0);
		}
		public Keygen_expressionContext keygen_expression() {
			return getRuleContext(Keygen_expressionContext.class,0);
		}
		public Kem_expressionContext kem_expression() {
			return getRuleContext(Kem_expressionContext.class,0);
		}
		public Proof_expressionContext proof_expression() {
			return getRuleContext(Proof_expressionContext.class,0);
		}
		public Verify_proof_expressionContext verify_proof_expression() {
			return getRuleContext(Verify_proof_expressionContext.class,0);
		}
		public Cryptographic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cryptographic_expression; }
	}

	public final Cryptographic_expressionContext cryptographic_expression() throws RecognitionException {
		Cryptographic_expressionContext _localctx = new Cryptographic_expressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_cryptographic_expression);
		try {
			setState(1533);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENCRYPT_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1525);
				encrypt_expression();
				}
				break;
			case DECRYPT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1526);
				decrypt_expression();
				}
				break;
			case SIGN_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1527);
				sign_expression();
				}
				break;
			case VERIFY_:
				enterOuterAlt(_localctx, 4);
				{
				setState(1528);
				verify_expression();
				}
				break;
			case KEY_:
				enterOuterAlt(_localctx, 5);
				{
				setState(1529);
				keygen_expression();
				}
				break;
			case KEM_:
				enterOuterAlt(_localctx, 6);
				{
				setState(1530);
				kem_expression();
				}
				break;
			case PROOF_:
				enterOuterAlt(_localctx, 7);
				{
				setState(1531);
				proof_expression();
				}
				break;
			case VERIFY_PROOF_:
				enterOuterAlt(_localctx, 8);
				{
				setState(1532);
				verify_proof_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Encrypt_expressionContext extends ParserRuleContext {
		public TerminalNode ENCRYPT_() { return getToken(T4Parser.ENCRYPT_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Encrypt_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_encrypt_expression; }
	}

	public final Encrypt_expressionContext encrypt_expression() throws RecognitionException {
		Encrypt_expressionContext _localctx = new Encrypt_expressionContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_encrypt_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1535);
			match(ENCRYPT_);
			setState(1536);
			match(LPAREN);
			setState(1537);
			expression();
			setState(1538);
			match(COMMA);
			setState(1539);
			expression();
			setState(1540);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Decrypt_expressionContext extends ParserRuleContext {
		public TerminalNode DECRYPT_() { return getToken(T4Parser.DECRYPT_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Decrypt_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decrypt_expression; }
	}

	public final Decrypt_expressionContext decrypt_expression() throws RecognitionException {
		Decrypt_expressionContext _localctx = new Decrypt_expressionContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_decrypt_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1542);
			match(DECRYPT_);
			setState(1543);
			match(LPAREN);
			setState(1544);
			expression();
			setState(1545);
			match(COMMA);
			setState(1546);
			expression();
			setState(1547);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sign_expressionContext extends ParserRuleContext {
		public TerminalNode SIGN_() { return getToken(T4Parser.SIGN_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Sign_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign_expression; }
	}

	public final Sign_expressionContext sign_expression() throws RecognitionException {
		Sign_expressionContext _localctx = new Sign_expressionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_sign_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1549);
			match(SIGN_);
			setState(1550);
			match(LPAREN);
			setState(1551);
			expression();
			setState(1552);
			match(COMMA);
			setState(1553);
			expression();
			setState(1554);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Verify_expressionContext extends ParserRuleContext {
		public TerminalNode VERIFY_() { return getToken(T4Parser.VERIFY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Verify_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verify_expression; }
	}

	public final Verify_expressionContext verify_expression() throws RecognitionException {
		Verify_expressionContext _localctx = new Verify_expressionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_verify_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1556);
			match(VERIFY_);
			setState(1557);
			match(LPAREN);
			setState(1558);
			expression();
			setState(1559);
			match(COMMA);
			setState(1560);
			expression();
			setState(1561);
			match(COMMA);
			setState(1562);
			expression();
			setState(1563);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Keygen_expressionContext extends ParserRuleContext {
		public TerminalNode KEY_() { return getToken(T4Parser.KEY_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Algorithm_typeContext algorithm_type() {
			return getRuleContext(Algorithm_typeContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode COLONCOLON() { return getToken(T4Parser.COLONCOLON, 0); }
		public TerminalNode NEW() { return getToken(T4Parser.NEW, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Keygen_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keygen_expression; }
	}

	public final Keygen_expressionContext keygen_expression() throws RecognitionException {
		Keygen_expressionContext _localctx = new Keygen_expressionContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_keygen_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1565);
			match(KEY_);
			setState(1566);
			match(LT);
			setState(1567);
			algorithm_type();
			setState(1568);
			match(GT);
			setState(1569);
			match(COLONCOLON);
			setState(1570);
			match(NEW);
			setState(1571);
			match(LPAREN);
			setState(1572);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Kem_expressionContext extends ParserRuleContext {
		public TerminalNode KEM_() { return getToken(T4Parser.KEM_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Kem_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kem_expression; }
	}

	public final Kem_expressionContext kem_expression() throws RecognitionException {
		Kem_expressionContext _localctx = new Kem_expressionContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_kem_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1574);
			match(KEM_);
			setState(1575);
			match(LPAREN);
			setState(1576);
			expression();
			setState(1577);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Proof_expressionContext extends ParserRuleContext {
		public TerminalNode PROOF_() { return getToken(T4Parser.PROOF_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Proof_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proof_expression; }
	}

	public final Proof_expressionContext proof_expression() throws RecognitionException {
		Proof_expressionContext _localctx = new Proof_expressionContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_proof_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1579);
			match(PROOF_);
			setState(1580);
			match(LT);
			setState(1581);
			type_();
			setState(1582);
			match(GT);
			setState(1583);
			match(LPAREN);
			setState(1584);
			expression();
			setState(1585);
			match(COMMA);
			setState(1586);
			expression();
			setState(1587);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Verify_proof_expressionContext extends ParserRuleContext {
		public TerminalNode VERIFY_PROOF_() { return getToken(T4Parser.VERIFY_PROOF_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Verify_proof_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verify_proof_expression; }
	}

	public final Verify_proof_expressionContext verify_proof_expression() throws RecognitionException {
		Verify_proof_expressionContext _localctx = new Verify_proof_expressionContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_verify_proof_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1589);
			match(VERIFY_PROOF_);
			setState(1590);
			match(LPAREN);
			setState(1591);
			expression();
			setState(1592);
			match(COMMA);
			setState(1593);
			expression();
			setState(1594);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Security_annotationContext extends ParserRuleContext {
		public TerminalNode HASH_LBRACKET() { return getToken(T4Parser.HASH_LBRACKET, 0); }
		public List<Security_attributeContext> security_attribute() {
			return getRuleContexts(Security_attributeContext.class);
		}
		public Security_attributeContext security_attribute(int i) {
			return getRuleContext(Security_attributeContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Security_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_security_annotation; }
	}

	public final Security_annotationContext security_annotation() throws RecognitionException {
		Security_annotationContext _localctx = new Security_annotationContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_security_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1596);
			match(HASH_LBRACKET);
			setState(1597);
			security_attribute();
			setState(1602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1598);
				match(COMMA);
				setState(1599);
				security_attribute();
				}
				}
				setState(1604);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1605);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Security_attributeContext extends ParserRuleContext {
		public TerminalNode CONSTANT_TIME_() { return getToken(T4Parser.CONSTANT_TIME_, 0); }
		public TerminalNode CACHE_RESISTANT_() { return getToken(T4Parser.CACHE_RESISTANT_, 0); }
		public TerminalNode SECURE_MEMORY_() { return getToken(T4Parser.SECURE_MEMORY_, 0); }
		public TerminalNode VERIFY_PROTOCOL_() { return getToken(T4Parser.VERIFY_PROTOCOL_, 0); }
		public TerminalNode WIPE_ON_DROP_() { return getToken(T4Parser.WIPE_ON_DROP_, 0); }
		public TerminalNode DISTRIBUTED_() { return getToken(T4Parser.DISTRIBUTED_, 0); }
		public TerminalNode THRESHOLD_SIGN_() { return getToken(T4Parser.THRESHOLD_SIGN_, 0); }
		public TerminalNode VERIFY_SOUNDNESS_() { return getToken(T4Parser.VERIFY_SOUNDNESS_, 0); }
		public TerminalNode VERIFY_ZERO_KNOWLEDGE_() { return getToken(T4Parser.VERIFY_ZERO_KNOWLEDGE_, 0); }
		public TerminalNode POWER_RESISTANT_() { return getToken(T4Parser.POWER_RESISTANT_, 0); }
		public Security_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_security_attribute; }
	}

	public final Security_attributeContext security_attribute() throws RecognitionException {
		Security_attributeContext _localctx = new Security_attributeContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_security_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1607);
			_la = _input.LA(1);
			if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & 1023L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public Literal_patternContext literal_pattern() {
			return getRuleContext(Literal_patternContext.class,0);
		}
		public Identifier_patternContext identifier_pattern() {
			return getRuleContext(Identifier_patternContext.class,0);
		}
		public Wildcard_patternContext wildcard_pattern() {
			return getRuleContext(Wildcard_patternContext.class,0);
		}
		public Reference_patternContext reference_pattern() {
			return getRuleContext(Reference_patternContext.class,0);
		}
		public Struct_patternContext struct_pattern() {
			return getRuleContext(Struct_patternContext.class,0);
		}
		public Enum_patternContext enum_pattern() {
			return getRuleContext(Enum_patternContext.class,0);
		}
		public Tuple_patternContext tuple_pattern() {
			return getRuleContext(Tuple_patternContext.class,0);
		}
		public Array_patternContext array_pattern() {
			return getRuleContext(Array_patternContext.class,0);
		}
		public Range_patternContext range_pattern() {
			return getRuleContext(Range_patternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_pattern);
		try {
			setState(1618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1609);
				literal_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1610);
				identifier_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1611);
				wildcard_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1612);
				reference_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1613);
				struct_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1614);
				enum_pattern();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1615);
				tuple_pattern();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1616);
				array_pattern();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1617);
				range_pattern();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Literal_patternContext extends ParserRuleContext {
		public Literal_expressionContext literal_expression() {
			return getRuleContext(Literal_expressionContext.class,0);
		}
		public Literal_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_pattern; }
	}

	public final Literal_patternContext literal_pattern() throws RecognitionException {
		Literal_patternContext _localctx = new Literal_patternContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_literal_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1620);
			literal_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Identifier_patternContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public TerminalNode REF() { return getToken(T4Parser.REF, 0); }
		public Identifier_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_pattern; }
	}

	public final Identifier_patternContext identifier_pattern() throws RecognitionException {
		Identifier_patternContext _localctx = new Identifier_patternContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_identifier_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1626);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				{
				setState(1622);
				match(MUT);
				}
				break;
			case 2:
				{
				setState(1623);
				match(REF);
				}
				break;
			case 3:
				{
				setState(1624);
				match(MUT);
				setState(1625);
				match(REF);
				}
				break;
			}
			setState(1628);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Wildcard_patternContext extends ParserRuleContext {
		public TerminalNode UNDERSCORE() { return getToken(T4Parser.UNDERSCORE, 0); }
		public Wildcard_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard_pattern; }
	}

	public final Wildcard_patternContext wildcard_pattern() throws RecognitionException {
		Wildcard_patternContext _localctx = new Wildcard_patternContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_wildcard_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1630);
			match(UNDERSCORE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Reference_patternContext extends ParserRuleContext {
		public Literal_patternContext literal_pattern() {
			return getRuleContext(Literal_patternContext.class,0);
		}
		public Identifier_patternContext identifier_pattern() {
			return getRuleContext(Identifier_patternContext.class,0);
		}
		public Wildcard_patternContext wildcard_pattern() {
			return getRuleContext(Wildcard_patternContext.class,0);
		}
		public Struct_patternContext struct_pattern() {
			return getRuleContext(Struct_patternContext.class,0);
		}
		public Enum_patternContext enum_pattern() {
			return getRuleContext(Enum_patternContext.class,0);
		}
		public Tuple_patternContext tuple_pattern() {
			return getRuleContext(Tuple_patternContext.class,0);
		}
		public Array_patternContext array_pattern() {
			return getRuleContext(Array_patternContext.class,0);
		}
		public Range_patternContext range_pattern() {
			return getRuleContext(Range_patternContext.class,0);
		}
		public TerminalNode MUT() { return getToken(T4Parser.MUT, 0); }
		public TerminalNode REF() { return getToken(T4Parser.REF, 0); }
		public Reference_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_pattern; }
	}

	public final Reference_patternContext reference_pattern() throws RecognitionException {
		Reference_patternContext _localctx = new Reference_patternContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_reference_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(1632);
				match(MUT);
				}
				break;
			case 2:
				{
				setState(1633);
				match(REF);
				}
				break;
			case 3:
				{
				setState(1634);
				match(MUT);
				setState(1635);
				match(REF);
				}
				break;
			}
			setState(1646);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(1638);
				literal_pattern();
				}
				break;
			case 2:
				{
				setState(1639);
				identifier_pattern();
				}
				break;
			case 3:
				{
				setState(1640);
				wildcard_pattern();
				}
				break;
			case 4:
				{
				setState(1641);
				struct_pattern();
				}
				break;
			case 5:
				{
				setState(1642);
				enum_pattern();
				}
				break;
			case 6:
				{
				setState(1643);
				tuple_pattern();
				}
				break;
			case 7:
				{
				setState(1644);
				array_pattern();
				}
				break;
			case 8:
				{
				setState(1645);
				range_pattern();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_patternContext extends ParserRuleContext {
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Field_patternContext> field_pattern() {
			return getRuleContexts(Field_patternContext.class);
		}
		public Field_patternContext field_pattern(int i) {
			return getRuleContext(Field_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Struct_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_pattern; }
	}

	public final Struct_patternContext struct_pattern() throws RecognitionException {
		Struct_patternContext _localctx = new Struct_patternContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_struct_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1648);
			type_path();
			setState(1649);
			match(LBRACE);
			setState(1658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 38280596832650239L) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & 2251799813685285L) != 0)) {
				{
				setState(1650);
				field_pattern();
				setState(1655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1651);
					match(COMMA);
					setState(1652);
					field_pattern();
					}
					}
					setState(1657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1660);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_patternContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Field_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_pattern; }
	}

	public final Field_patternContext field_pattern() throws RecognitionException {
		Field_patternContext _localctx = new Field_patternContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_field_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1664);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				{
				setState(1662);
				match(IDENTIFIER);
				setState(1663);
				match(COLON);
				}
				break;
			}
			setState(1666);
			pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enum_patternContext extends ParserRuleContext {
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(T4Parser.COLONCOLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public Enum_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_pattern; }
	}

	public final Enum_patternContext enum_pattern() throws RecognitionException {
		Enum_patternContext _localctx = new Enum_patternContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_enum_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1668);
			type_path();
			setState(1669);
			match(COLONCOLON);
			setState(1670);
			match(IDENTIFIER);
			setState(1676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(1671);
				match(LPAREN);
				setState(1673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MUT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 38280596832650239L) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & 2251799813685285L) != 0)) {
					{
					setState(1672);
					patterns();
					}
				}

				setState(1675);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tuple_patternContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Tuple_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple_pattern; }
	}

	public final Tuple_patternContext tuple_pattern() throws RecognitionException {
		Tuple_patternContext _localctx = new Tuple_patternContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_tuple_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1678);
			match(LPAREN);
			setState(1687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 38280596832650239L) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & 2251799813685285L) != 0)) {
				{
				setState(1679);
				pattern();
				setState(1684);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1680);
					match(COMMA);
					setState(1681);
					pattern();
					}
					}
					setState(1686);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1689);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_patternContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(T4Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Array_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_pattern; }
	}

	public final Array_patternContext array_pattern() throws RecognitionException {
		Array_patternContext _localctx = new Array_patternContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_array_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1691);
			match(LBRACKET);
			setState(1700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 38280596832650239L) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & 2251799813685285L) != 0)) {
				{
				setState(1692);
				pattern();
				setState(1697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1693);
					match(COMMA);
					setState(1694);
					pattern();
					}
					}
					setState(1699);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1702);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Range_patternContext extends ParserRuleContext {
		public List<Literal_expressionContext> literal_expression() {
			return getRuleContexts(Literal_expressionContext.class);
		}
		public Literal_expressionContext literal_expression(int i) {
			return getRuleContext(Literal_expressionContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(T4Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(T4Parser.DOT, i);
		}
		public Range_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_pattern; }
	}

	public final Range_patternContext range_pattern() throws RecognitionException {
		Range_patternContext _localctx = new Range_patternContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_range_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1704);
			literal_expression();
			setState(1705);
			match(DOT);
			setState(1706);
			match(DOT);
			setState(1708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 1023L) != 0)) {
				{
				setState(1707);
				literal_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternsContext extends ParserRuleContext {
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public PatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patterns; }
	}

	public final PatternsContext patterns() throws RecognitionException {
		PatternsContext _localctx = new PatternsContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_patterns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1710);
			pattern();
			setState(1715);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1711);
				match(COMMA);
				setState(1712);
				pattern();
				}
				}
				setState(1717);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_argsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_argsContext type_args() {
			return getRuleContext(Type_argsContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public Generic_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_args; }
	}

	public final Generic_argsContext generic_args() throws RecognitionException {
		Generic_argsContext _localctx = new Generic_argsContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_generic_args);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1718);
			match(LT);
			setState(1719);
			type_args();
			setState(1720);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Error_typeContext extends ParserRuleContext {
		public TerminalNode CRYPTO_ERROR() { return getToken(T4Parser.CRYPTO_ERROR, 0); }
		public TerminalNode INVALID_KEY() { return getToken(T4Parser.INVALID_KEY, 0); }
		public TerminalNode DECRYPTION_FAILED() { return getToken(T4Parser.DECRYPTION_FAILED, 0); }
		public TerminalNode AUTHENTICATION_FAILED() { return getToken(T4Parser.AUTHENTICATION_FAILED, 0); }
		public TerminalNode WEAK_PARAMETER() { return getToken(T4Parser.WEAK_PARAMETER, 0); }
		public TerminalNode HARDWARE_FAILURE() { return getToken(T4Parser.HARDWARE_FAILURE, 0); }
		public TerminalNode TIMING_ATTACK_DETECTED() { return getToken(T4Parser.TIMING_ATTACK_DETECTED, 0); }
		public Error_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_type; }
	}

	public final Error_typeContext error_type() throws RecognitionException {
		Error_typeContext _localctx = new Error_typeContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_error_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1722);
			_la = _input.LA(1);
			if ( !(((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & 127L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Result_typeContext extends ParserRuleContext {
		public TerminalNode RESULT_() { return getToken(T4Parser.RESULT_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Error_typeContext error_type() {
			return getRuleContext(Error_typeContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public Result_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_type; }
	}

	public final Result_typeContext result_type() throws RecognitionException {
		Result_typeContext _localctx = new Result_typeContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_result_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1724);
			match(RESULT_);
			setState(1725);
			match(LT);
			setState(1726);
			type_();
			setState(1727);
			match(COMMA);
			setState(1728);
			error_type();
			setState(1729);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Advanced_typeContext extends ParserRuleContext {
		public TerminalNode HIGHER_KINDED_() { return getToken(T4Parser.HIGHER_KINDED_, 0); }
		public Type_constructorContext type_constructor() {
			return getRuleContext(Type_constructorContext.class,0);
		}
		public TerminalNode EXISTENTIAL_() { return getToken(T4Parser.EXISTENTIAL_, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode CRYPTO_PARAM_() { return getToken(T4Parser.CRYPTO_PARAM_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Crypto_type_paramsContext crypto_type_params() {
			return getRuleContext(Crypto_type_paramsContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode ASSOCIATED_() { return getToken(T4Parser.ASSOCIATED_, 0); }
		public Type_pathContext type_path() {
			return getRuleContext(Type_pathContext.class,0);
		}
		public TerminalNode PHANTOM_() { return getToken(T4Parser.PHANTOM_, 0); }
		public TerminalNode ZERO_SIZED_() { return getToken(T4Parser.ZERO_SIZED_, 0); }
		public Advanced_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_advanced_type; }
	}

	public final Advanced_typeContext advanced_type() throws RecognitionException {
		Advanced_typeContext _localctx = new Advanced_typeContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_advanced_type);
		try {
			setState(1746);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HIGHER_KINDED_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1731);
				match(HIGHER_KINDED_);
				setState(1732);
				type_constructor();
				}
				break;
			case EXISTENTIAL_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1733);
				match(EXISTENTIAL_);
				setState(1734);
				type_();
				}
				break;
			case CRYPTO_PARAM_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1735);
				match(CRYPTO_PARAM_);
				setState(1736);
				match(LT);
				setState(1737);
				crypto_type_params();
				setState(1738);
				match(GT);
				}
				break;
			case ASSOCIATED_:
				enterOuterAlt(_localctx, 4);
				{
				setState(1740);
				match(ASSOCIATED_);
				setState(1741);
				type_path();
				}
				break;
			case PHANTOM_:
				enterOuterAlt(_localctx, 5);
				{
				setState(1742);
				match(PHANTOM_);
				setState(1743);
				type_();
				}
				break;
			case ZERO_SIZED_:
				enterOuterAlt(_localctx, 6);
				{
				setState(1744);
				match(ZERO_SIZED_);
				setState(1745);
				type_();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Higher_kinded_typeContext extends ParserRuleContext {
		public TerminalNode HKT_() { return getToken(T4Parser.HKT_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public List<Type_constructorContext> type_constructor() {
			return getRuleContexts(Type_constructorContext.class);
		}
		public Type_constructorContext type_constructor(int i) {
			return getRuleContext(Type_constructorContext.class,i);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public List<TerminalNode> KIND_ARROW_() { return getTokens(T4Parser.KIND_ARROW_); }
		public TerminalNode KIND_ARROW_(int i) {
			return getToken(T4Parser.KIND_ARROW_, i);
		}
		public Higher_kinded_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_higher_kinded_type; }
	}

	public final Higher_kinded_typeContext higher_kinded_type() throws RecognitionException {
		Higher_kinded_typeContext _localctx = new Higher_kinded_typeContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_higher_kinded_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1748);
			match(HKT_);
			setState(1749);
			match(LT);
			setState(1750);
			type_constructor();
			setState(1755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KIND_ARROW_) {
				{
				{
				setState(1751);
				match(KIND_ARROW_);
				setState(1752);
				type_constructor();
				}
				}
				setState(1757);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1758);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_constructorContext extends ParserRuleContext {
		public TerminalNode TYPE_CONSTRUCTOR_() { return getToken(T4Parser.TYPE_CONSTRUCTOR_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_argsContext type_args() {
			return getRuleContext(Type_argsContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Type_constructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_constructor; }
	}

	public final Type_constructorContext type_constructor() throws RecognitionException {
		Type_constructorContext _localctx = new Type_constructorContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_type_constructor);
		try {
			setState(1766);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_CONSTRUCTOR_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1760);
				match(TYPE_CONSTRUCTOR_);
				setState(1761);
				match(LT);
				setState(1762);
				type_args();
				setState(1763);
				match(GT);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1765);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Crypto_type_paramsContext extends ParserRuleContext {
		public TerminalNode CRYPTO_ALG_() { return getToken(T4Parser.CRYPTO_ALG_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public TerminalNode SECURITY_PARAM_() { return getToken(T4Parser.SECURITY_PARAM_, 0); }
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public Crypto_type_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crypto_type_params; }
	}

	public final Crypto_type_paramsContext crypto_type_params() throws RecognitionException {
		Crypto_type_paramsContext _localctx = new Crypto_type_paramsContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_crypto_type_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1768);
			match(CRYPTO_ALG_);
			setState(1771);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				{
				setState(1769);
				match(COMMA);
				setState(1770);
				match(SECURITY_PARAM_);
				}
				break;
			}
			setState(1777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1773);
				match(COMMA);
				setState(1774);
				type_();
				}
				}
				setState(1779);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trait_boundsContext extends ParserRuleContext {
		public List<TerminalNode> TRAIT_BOUND_() { return getTokens(T4Parser.TRAIT_BOUND_); }
		public TerminalNode TRAIT_BOUND_(int i) {
			return getToken(T4Parser.TRAIT_BOUND_, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(T4Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(T4Parser.PLUS, i);
		}
		public Trait_boundsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_bounds; }
	}

	public final Trait_boundsContext trait_bounds() throws RecognitionException {
		Trait_boundsContext _localctx = new Trait_boundsContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_trait_bounds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1780);
			match(TRAIT_BOUND_);
			setState(1785);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(1781);
				match(PLUS);
				setState(1782);
				match(TRAIT_BOUND_);
				}
				}
				setState(1787);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Associated_typeContext extends ParserRuleContext {
		public TerminalNode ASSOCIATED_TYPE_() { return getToken(T4Parser.ASSOCIATED_TYPE_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public Associated_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associated_type; }
	}

	public final Associated_typeContext associated_type() throws RecognitionException {
		Associated_typeContext _localctx = new Associated_typeContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_associated_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1788);
			match(ASSOCIATED_TYPE_);
			setState(1789);
			match(IDENTIFIER);
			setState(1792);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1790);
				match(COLON);
				setState(1791);
				type_();
				}
			}

			setState(1796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(1794);
				match(ASSIGN);
				setState(1795);
				type_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Associated_constContext extends ParserRuleContext {
		public TerminalNode ASSOCIATED_CONST_() { return getToken(T4Parser.ASSOCIATED_CONST_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Associated_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associated_const; }
	}

	public final Associated_constContext associated_const() throws RecognitionException {
		Associated_constContext _localctx = new Associated_constContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_associated_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1798);
			match(ASSOCIATED_CONST_);
			setState(1799);
			match(IDENTIFIER);
			setState(1800);
			match(COLON);
			setState(1801);
			type_();
			setState(1802);
			match(ASSIGN);
			setState(1803);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_constraintsContext extends ParserRuleContext {
		public TerminalNode CONSTRAINT_() { return getToken(T4Parser.CONSTRAINT_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Trait_boundsContext trait_bounds() {
			return getRuleContext(Trait_boundsContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public Generic_constraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_constraints; }
	}

	public final Generic_constraintsContext generic_constraints() throws RecognitionException {
		Generic_constraintsContext _localctx = new Generic_constraintsContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_generic_constraints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1805);
			match(CONSTRAINT_);
			setState(1806);
			match(LT);
			setState(1807);
			type_();
			setState(1808);
			match(COLON);
			setState(1809);
			trait_bounds();
			setState(1810);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_familyContext extends ParserRuleContext {
		public TerminalNode TYPE_FAMILY_() { return getToken(T4Parser.TYPE_FAMILY_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Type_familyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_family; }
	}

	public final Type_familyContext type_family() throws RecognitionException {
		Type_familyContext _localctx = new Type_familyContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_type_family);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1812);
			match(TYPE_FAMILY_);
			setState(1813);
			match(IDENTIFIER);
			setState(1814);
			match(ASSIGN);
			setState(1815);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KindContext extends ParserRuleContext {
		public TerminalNode KIND_() { return getToken(T4Parser.KIND_, 0); }
		public TerminalNode KIND_STAR_() { return getToken(T4Parser.KIND_STAR_, 0); }
		public List<TerminalNode> KIND_ARROW_() { return getTokens(T4Parser.KIND_ARROW_); }
		public TerminalNode KIND_ARROW_(int i) {
			return getToken(T4Parser.KIND_ARROW_, i);
		}
		public List<KindContext> kind() {
			return getRuleContexts(KindContext.class);
		}
		public KindContext kind(int i) {
			return getRuleContext(KindContext.class,i);
		}
		public KindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kind; }
	}

	public final KindContext kind() throws RecognitionException {
		KindContext _localctx = new KindContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_kind);
		try {
			int _alt;
			setState(1827);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1817);
				match(KIND_);
				setState(1818);
				match(KIND_STAR_);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1819);
				match(KIND_);
				setState(1824);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1820);
						match(KIND_ARROW_);
						setState(1821);
						kind();
						}
						} 
					}
					setState(1826);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Phantom_typeContext extends ParserRuleContext {
		public TerminalNode PHANTOM_() { return getToken(T4Parser.PHANTOM_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public Phantom_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phantom_type; }
	}

	public final Phantom_typeContext phantom_type() throws RecognitionException {
		Phantom_typeContext _localctx = new Phantom_typeContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_phantom_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1829);
			match(PHANTOM_);
			setState(1830);
			match(LT);
			setState(1831);
			type_();
			setState(1832);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Existential_typeContext extends ParserRuleContext {
		public TerminalNode EXISTS_() { return getToken(T4Parser.EXISTS_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Existential_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existential_type; }
	}

	public final Existential_typeContext existential_type() throws RecognitionException {
		Existential_typeContext _localctx = new Existential_typeContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_existential_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1834);
			match(EXISTS_);
			setState(1835);
			match(IDENTIFIER);
			setState(1836);
			match(COLON);
			setState(1837);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Universal_typeContext extends ParserRuleContext {
		public TerminalNode FORALL_() { return getToken(T4Parser.FORALL_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public TerminalNode DOT() { return getToken(T4Parser.DOT, 0); }
		public Universal_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_universal_type; }
	}

	public final Universal_typeContext universal_type() throws RecognitionException {
		Universal_typeContext _localctx = new Universal_typeContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_universal_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1839);
			match(FORALL_);
			setState(1840);
			match(IDENTIFIER);
			setState(1841);
			match(COLON);
			setState(1842);
			type_();
			setState(1843);
			match(DOT);
			setState(1844);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Security_annotationsContext extends ParserRuleContext {
		public TerminalNode HASH_LBRACKET() { return getToken(T4Parser.HASH_LBRACKET, 0); }
		public List<Security_attributeContext> security_attribute() {
			return getRuleContexts(Security_attributeContext.class);
		}
		public Security_attributeContext security_attribute(int i) {
			return getRuleContext(Security_attributeContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Security_annotationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_security_annotations; }
	}

	public final Security_annotationsContext security_annotations() throws RecognitionException {
		Security_annotationsContext _localctx = new Security_annotationsContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_security_annotations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1846);
			match(HASH_LBRACKET);
			setState(1847);
			security_attribute();
			setState(1852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1848);
				match(COMMA);
				setState(1849);
				security_attribute();
				}
				}
				setState(1854);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1855);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Advanced_security_attributeContext extends ParserRuleContext {
		public TerminalNode TIMING_RESISTANT_() { return getToken(T4Parser.TIMING_RESISTANT_, 0); }
		public TerminalNode FAULT_RESISTANT_() { return getToken(T4Parser.FAULT_RESISTANT_, 0); }
		public TerminalNode LEAKAGE_RESISTANT_() { return getToken(T4Parser.LEAKAGE_RESISTANT_, 0); }
		public TerminalNode SECURE_EXECUTION_() { return getToken(T4Parser.SECURE_EXECUTION_, 0); }
		public TerminalNode TRUSTED_EXECUTION_() { return getToken(T4Parser.TRUSTED_EXECUTION_, 0); }
		public TerminalNode ENCLAVE_() { return getToken(T4Parser.ENCLAVE_, 0); }
		public TerminalNode SECURE_CHANNEL_() { return getToken(T4Parser.SECURE_CHANNEL_, 0); }
		public TerminalNode AUTHENTICATED_() { return getToken(T4Parser.AUTHENTICATED_, 0); }
		public TerminalNode CONFIDENTIAL_() { return getToken(T4Parser.CONFIDENTIAL_, 0); }
		public TerminalNode INTEGRITY_CHECK_() { return getToken(T4Parser.INTEGRITY_CHECK_, 0); }
		public TerminalNode FRESHNESS_CHECK_() { return getToken(T4Parser.FRESHNESS_CHECK_, 0); }
		public TerminalNode NON_REPLAYABLE_() { return getToken(T4Parser.NON_REPLAYABLE_, 0); }
		public TerminalNode FORWARD_SECURE_() { return getToken(T4Parser.FORWARD_SECURE_, 0); }
		public TerminalNode POST_COMPROMISE_() { return getToken(T4Parser.POST_COMPROMISE_, 0); }
		public TerminalNode COMPUTATIONAL_SECURITY_() { return getToken(T4Parser.COMPUTATIONAL_SECURITY_, 0); }
		public TerminalNode INFORMATION_THEORETIC_() { return getToken(T4Parser.INFORMATION_THEORETIC_, 0); }
		public Advanced_security_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_advanced_security_attribute; }
	}

	public final Advanced_security_attributeContext advanced_security_attribute() throws RecognitionException {
		Advanced_security_attributeContext _localctx = new Advanced_security_attributeContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_advanced_security_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1857);
			_la = _input.LA(1);
			if ( !(((((_la - 229)) & ~0x3f) == 0 && ((1L << (_la - 229)) & 16383L) != 0) || _la==COMPUTATIONAL_SECURITY_ || _la==INFORMATION_THEORETIC_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Protocol_annotationContext extends ParserRuleContext {
		public TerminalNode PROTOCOL_() { return getToken(T4Parser.PROTOCOL_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Protocol_specContext protocol_spec() {
			return getRuleContext(Protocol_specContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Protocol_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocol_annotation; }
	}

	public final Protocol_annotationContext protocol_annotation() throws RecognitionException {
		Protocol_annotationContext _localctx = new Protocol_annotationContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_protocol_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1859);
			match(PROTOCOL_);
			setState(1860);
			match(LPAREN);
			setState(1861);
			protocol_spec();
			setState(1862);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Protocol_specContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Protocol_propertyContext> protocol_property() {
			return getRuleContexts(Protocol_propertyContext.class);
		}
		public Protocol_propertyContext protocol_property(int i) {
			return getRuleContext(Protocol_propertyContext.class,i);
		}
		public Protocol_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocol_spec; }
	}

	public final Protocol_specContext protocol_spec() throws RecognitionException {
		Protocol_specContext _localctx = new Protocol_specContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_protocol_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1864);
			match(IDENTIFIER);
			setState(1865);
			match(LBRACE);
			setState(1869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 315)) & ~0x3f) == 0 && ((1L << (_la - 315)) & 511L) != 0)) {
				{
				{
				setState(1866);
				protocol_property();
				}
				}
				setState(1871);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1872);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Protocol_propertyContext extends ParserRuleContext {
		public TerminalNode CONFIDENTIALITY_() { return getToken(T4Parser.CONFIDENTIALITY_, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AUTHENTICATION_() { return getToken(T4Parser.AUTHENTICATION_, 0); }
		public TerminalNode NON_REPUDIATION_() { return getToken(T4Parser.NON_REPUDIATION_, 0); }
		public TerminalNode INTEGRITY_() { return getToken(T4Parser.INTEGRITY_, 0); }
		public TerminalNode AVAILABILITY_() { return getToken(T4Parser.AVAILABILITY_, 0); }
		public TerminalNode FRESHNESS_() { return getToken(T4Parser.FRESHNESS_, 0); }
		public TerminalNode FORWARD_SECRECY_() { return getToken(T4Parser.FORWARD_SECRECY_, 0); }
		public TerminalNode BACKWARD_SECRECY_() { return getToken(T4Parser.BACKWARD_SECRECY_, 0); }
		public TerminalNode PERFECT_SECRECY_() { return getToken(T4Parser.PERFECT_SECRECY_, 0); }
		public Protocol_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocol_property; }
	}

	public final Protocol_propertyContext protocol_property() throws RecognitionException {
		Protocol_propertyContext _localctx = new Protocol_propertyContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_protocol_property);
		try {
			setState(1901);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONFIDENTIALITY_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1874);
				match(CONFIDENTIALITY_);
				setState(1875);
				match(COLON);
				setState(1876);
				expression();
				}
				break;
			case AUTHENTICATION_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1877);
				match(AUTHENTICATION_);
				setState(1878);
				match(COLON);
				setState(1879);
				expression();
				}
				break;
			case NON_REPUDIATION_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1880);
				match(NON_REPUDIATION_);
				setState(1881);
				match(COLON);
				setState(1882);
				expression();
				}
				break;
			case INTEGRITY_:
				enterOuterAlt(_localctx, 4);
				{
				setState(1883);
				match(INTEGRITY_);
				setState(1884);
				match(COLON);
				setState(1885);
				expression();
				}
				break;
			case AVAILABILITY_:
				enterOuterAlt(_localctx, 5);
				{
				setState(1886);
				match(AVAILABILITY_);
				setState(1887);
				match(COLON);
				setState(1888);
				expression();
				}
				break;
			case FRESHNESS_:
				enterOuterAlt(_localctx, 6);
				{
				setState(1889);
				match(FRESHNESS_);
				setState(1890);
				match(COLON);
				setState(1891);
				expression();
				}
				break;
			case FORWARD_SECRECY_:
				enterOuterAlt(_localctx, 7);
				{
				setState(1892);
				match(FORWARD_SECRECY_);
				setState(1893);
				match(COLON);
				setState(1894);
				expression();
				}
				break;
			case BACKWARD_SECRECY_:
				enterOuterAlt(_localctx, 8);
				{
				setState(1895);
				match(BACKWARD_SECRECY_);
				setState(1896);
				match(COLON);
				setState(1897);
				expression();
				}
				break;
			case PERFECT_SECRECY_:
				enterOuterAlt(_localctx, 9);
				{
				setState(1898);
				match(PERFECT_SECRECY_);
				setState(1899);
				match(COLON);
				setState(1900);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Zero_knowledge_annotationContext extends ParserRuleContext {
		public TerminalNode ZERO_KNOWLEDGE_() { return getToken(T4Parser.ZERO_KNOWLEDGE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Zk_paramsContext zk_params() {
			return getRuleContext(Zk_paramsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Zero_knowledge_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zero_knowledge_annotation; }
	}

	public final Zero_knowledge_annotationContext zero_knowledge_annotation() throws RecognitionException {
		Zero_knowledge_annotationContext _localctx = new Zero_knowledge_annotationContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_zero_knowledge_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1903);
			match(ZERO_KNOWLEDGE_);
			setState(1904);
			match(LPAREN);
			setState(1905);
			zk_params();
			setState(1906);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Zk_paramsContext extends ParserRuleContext {
		public TerminalNode PROOF_SYSTEM_() { return getToken(T4Parser.PROOF_SYSTEM_, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(T4Parser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(T4Parser.ASSIGN, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode SECURITY_PARAMETER_() { return getToken(T4Parser.SECURITY_PARAMETER_, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Zk_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zk_params; }
	}

	public final Zk_paramsContext zk_params() throws RecognitionException {
		Zk_paramsContext _localctx = new Zk_paramsContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_zk_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1908);
			match(PROOF_SYSTEM_);
			setState(1909);
			match(ASSIGN);
			setState(1910);
			match(IDENTIFIER);
			setState(1915);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1911);
				match(COMMA);
				setState(1912);
				match(SECURITY_PARAMETER_);
				setState(1913);
				match(ASSIGN);
				setState(1914);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Homomorphic_annotationContext extends ParserRuleContext {
		public TerminalNode HOMOMORPHIC_() { return getToken(T4Parser.HOMOMORPHIC_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode ENCRYPTION_SCHEME_() { return getToken(T4Parser.ENCRYPTION_SCHEME_, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Homomorphic_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_homomorphic_annotation; }
	}

	public final Homomorphic_annotationContext homomorphic_annotation() throws RecognitionException {
		Homomorphic_annotationContext _localctx = new Homomorphic_annotationContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_homomorphic_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1917);
			match(HOMOMORPHIC_);
			setState(1918);
			match(LPAREN);
			setState(1919);
			match(ENCRYPTION_SCHEME_);
			setState(1920);
			match(ASSIGN);
			setState(1921);
			match(IDENTIFIER);
			setState(1922);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Distributed_annotationContext extends ParserRuleContext {
		public TerminalNode DISTRIBUTED_() { return getToken(T4Parser.DISTRIBUTED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode THRESHOLD_() { return getToken(T4Parser.THRESHOLD_, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Distributed_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distributed_annotation; }
	}

	public final Distributed_annotationContext distributed_annotation() throws RecognitionException {
		Distributed_annotationContext _localctx = new Distributed_annotationContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_distributed_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1924);
			match(DISTRIBUTED_);
			setState(1925);
			match(LPAREN);
			setState(1926);
			match(THRESHOLD_);
			setState(1927);
			match(ASSIGN);
			setState(1928);
			expression();
			setState(1929);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Secure_computation_annotationContext extends ParserRuleContext {
		public TerminalNode SECURE_COMPUTATION_() { return getToken(T4Parser.SECURE_COMPUTATION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Computation_typeContext computation_type() {
			return getRuleContext(Computation_typeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Secure_computation_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secure_computation_annotation; }
	}

	public final Secure_computation_annotationContext secure_computation_annotation() throws RecognitionException {
		Secure_computation_annotationContext _localctx = new Secure_computation_annotationContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_secure_computation_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1931);
			match(SECURE_COMPUTATION_);
			setState(1932);
			match(LPAREN);
			setState(1933);
			computation_type();
			setState(1934);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Computation_typeContext extends ParserRuleContext {
		public TerminalNode MULTIPARTY_() { return getToken(T4Parser.MULTIPARTY_, 0); }
		public TerminalNode OBLIVIOUS_() { return getToken(T4Parser.OBLIVIOUS_, 0); }
		public TerminalNode PRIVATE_SET_() { return getToken(T4Parser.PRIVATE_SET_, 0); }
		public TerminalNode SECURE_SEARCH_() { return getToken(T4Parser.SECURE_SEARCH_, 0); }
		public Computation_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computation_type; }
	}

	public final Computation_typeContext computation_type() throws RecognitionException {
		Computation_typeContext _localctx = new Computation_typeContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_computation_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1936);
			_la = _input.LA(1);
			if ( !(((((_la - 305)) & ~0x3f) == 0 && ((1L << (_la - 305)) & 177L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Advanced_functionContext extends ParserRuleContext {
		public TerminalNode CLOSURE_() { return getToken(T4Parser.CLOSURE_, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode LAMBDA_() { return getToken(T4Parser.LAMBDA_, 0); }
		public TerminalNode OPERATOR_() { return getToken(T4Parser.OPERATOR_, 0); }
		public Operator_nameContext operator_name() {
			return getRuleContext(Operator_nameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode FUNCTION_PTR_() { return getToken(T4Parser.FUNCTION_PTR_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Function_typeContext function_type() {
			return getRuleContext(Function_typeContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode CALLABLE_() { return getToken(T4Parser.CALLABLE_, 0); }
		public Trait_boundsContext trait_bounds() {
			return getRuleContext(Trait_boundsContext.class,0);
		}
		public Advanced_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_advanced_function; }
	}

	public final Advanced_functionContext advanced_function() throws RecognitionException {
		Advanced_functionContext _localctx = new Advanced_functionContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_advanced_function);
		int _la;
		try {
			setState(1969);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLOSURE_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1938);
				match(CLOSURE_);
				setState(1940);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MUT || _la==IDENTIFIER || _la==REF) {
					{
					setState(1939);
					parameters();
					}
				}

				setState(1944);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARROW) {
					{
					setState(1942);
					match(ARROW);
					setState(1943);
					return_type();
					}
				}

				setState(1946);
				match(ASSIGN);
				setState(1947);
				expression();
				}
				break;
			case LAMBDA_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1948);
				match(LAMBDA_);
				setState(1950);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MUT || _la==IDENTIFIER || _la==REF) {
					{
					setState(1949);
					parameters();
					}
				}

				setState(1952);
				match(ARROW);
				setState(1953);
				expression();
				}
				break;
			case OPERATOR_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1954);
				match(OPERATOR_);
				setState(1955);
				operator_name();
				setState(1956);
				match(LPAREN);
				setState(1957);
				parameters();
				setState(1958);
				match(RPAREN);
				setState(1959);
				match(ASSIGN);
				setState(1960);
				expression();
				}
				break;
			case FUNCTION_PTR_:
				enterOuterAlt(_localctx, 4);
				{
				setState(1962);
				match(FUNCTION_PTR_);
				setState(1963);
				match(LT);
				setState(1964);
				function_type();
				setState(1965);
				match(GT);
				}
				break;
			case CALLABLE_:
				enterOuterAlt(_localctx, 5);
				{
				setState(1967);
				match(CALLABLE_);
				setState(1968);
				trait_bounds();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Operator_overloadContext extends ParserRuleContext {
		public TerminalNode OVERLOAD_() { return getToken(T4Parser.OVERLOAD_, 0); }
		public Operator_nameContext operator_name() {
			return getRuleContext(Operator_nameContext.class,0);
		}
		public TerminalNode FOR() { return getToken(T4Parser.FOR, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public Operator_overloadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_overload; }
	}

	public final Operator_overloadContext operator_overload() throws RecognitionException {
		Operator_overloadContext _localctx = new Operator_overloadContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_operator_overload);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1971);
			match(OVERLOAD_);
			setState(1972);
			operator_name();
			setState(1973);
			match(FOR);
			setState(1974);
			type_();
			setState(1975);
			match(LBRACE);
			setState(1976);
			function_body();
			setState(1977);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_bodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_function_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1982);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1979);
					statement();
					}
					} 
				}
				setState(1984);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
			}
			setState(1986);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(1985);
				return_statement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Operator_nameContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(T4Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(T4Parser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(T4Parser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(T4Parser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(T4Parser.PERCENT, 0); }
		public TerminalNode EQ() { return getToken(T4Parser.EQ, 0); }
		public TerminalNode NE() { return getToken(T4Parser.NE, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LE() { return getToken(T4Parser.LE, 0); }
		public TerminalNode GE() { return getToken(T4Parser.GE, 0); }
		public TerminalNode AND() { return getToken(T4Parser.AND, 0); }
		public TerminalNode OR() { return getToken(T4Parser.OR, 0); }
		public TerminalNode NOT() { return getToken(T4Parser.NOT, 0); }
		public TerminalNode CARET() { return getToken(T4Parser.CARET, 0); }
		public TerminalNode ANDAND() { return getToken(T4Parser.ANDAND, 0); }
		public TerminalNode OROR() { return getToken(T4Parser.OROR, 0); }
		public TerminalNode SHL() { return getToken(T4Parser.SHL, 0); }
		public TerminalNode SHR() { return getToken(T4Parser.SHR, 0); }
		public Operator_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_name; }
	}

	public final Operator_nameContext operator_name() throws RecognitionException {
		Operator_nameContext _localctx = new Operator_nameContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_operator_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1988);
			_la = _input.LA(1);
			if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & 524287L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Async_functionContext extends ParserRuleContext {
		public TerminalNode ASYNC() { return getToken(T4Parser.ASYNC, 0); }
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Generic_paramsContext generic_params() {
			return getRuleContext(Generic_paramsContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public List<Async_statementContext> async_statement() {
			return getRuleContexts(Async_statementContext.class);
		}
		public Async_statementContext async_statement(int i) {
			return getRuleContext(Async_statementContext.class,i);
		}
		public Async_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_async_function; }
	}

	public final Async_functionContext async_function() throws RecognitionException {
		Async_functionContext _localctx = new Async_functionContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_async_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1990);
			match(ASYNC);
			setState(1991);
			match(FN);
			setState(1992);
			match(IDENTIFIER);
			setState(1994);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1993);
				generic_params();
				}
			}

			setState(1996);
			match(LPAREN);
			setState(1998);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || _la==IDENTIFIER || _la==REF) {
				{
				setState(1997);
				parameters();
				}
			}

			setState(2000);
			match(RPAREN);
			setState(2003);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(2001);
				match(ARROW);
				setState(2002);
				return_type();
				}
			}

			setState(2006);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(2005);
				where_clause();
				}
			}

			setState(2017);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(2008);
				match(LBRACE);
				setState(2012);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
					{
					{
					setState(2009);
					async_statement();
					}
					}
					setState(2014);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2015);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(2016);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Async_statementContext extends ParserRuleContext {
		public TerminalNode AWAIT() { return getToken(T4Parser.AWAIT, 0); }
		public Atom_expressionContext atom_expression() {
			return getRuleContext(Atom_expressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode YIELD() { return getToken(T4Parser.YIELD, 0); }
		public Let_statementContext let_statement() {
			return getRuleContext(Let_statementContext.class,0);
		}
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Break_statementContext break_statement() {
			return getRuleContext(Break_statementContext.class,0);
		}
		public Continue_statementContext continue_statement() {
			return getRuleContext(Continue_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Match_statementContext match_statement() {
			return getRuleContext(Match_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public Early_returnContext early_return() {
			return getRuleContext(Early_returnContext.class,0);
		}
		public Yield_statementContext yield_statement() {
			return getRuleContext(Yield_statementContext.class,0);
		}
		public Async_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_async_statement; }
	}

	public final Async_statementContext async_statement() throws RecognitionException {
		Async_statementContext _localctx = new Async_statementContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_async_statement);
		try {
			setState(2040);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2019);
				match(AWAIT);
				setState(2020);
				atom_expression();
				setState(2021);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2023);
				match(YIELD);
				setState(2024);
				atom_expression();
				setState(2025);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2027);
				let_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2028);
				expression_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2029);
				assignment_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2030);
				return_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2031);
				break_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2032);
				continue_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2033);
				if_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2034);
				match_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2035);
				while_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2036);
				for_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2037);
				loop_statement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(2038);
				early_return();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(2039);
				yield_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Stream_expressionContext extends ParserRuleContext {
		public TerminalNode STREAM_() { return getToken(T4Parser.STREAM_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Stream_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stream_expression; }
	}

	public final Stream_expressionContext stream_expression() throws RecognitionException {
		Stream_expressionContext _localctx = new Stream_expressionContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_stream_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2042);
			match(STREAM_);
			setState(2043);
			match(LT);
			setState(2044);
			type_();
			setState(2045);
			match(GT);
			setState(2046);
			match(LPAREN);
			setState(2047);
			expression();
			setState(2048);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Iterator_expressionContext extends ParserRuleContext {
		public TerminalNode ITERATOR_() { return getToken(T4Parser.ITERATOR_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Iterator_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterator_expression; }
	}

	public final Iterator_expressionContext iterator_expression() throws RecognitionException {
		Iterator_expressionContext _localctx = new Iterator_expressionContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_iterator_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2050);
			match(ITERATOR_);
			setState(2051);
			match(LPAREN);
			setState(2052);
			expression();
			setState(2053);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generator_expressionContext extends ParserRuleContext {
		public TerminalNode GENERATOR_() { return getToken(T4Parser.GENERATOR_, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Yield_statementContext> yield_statement() {
			return getRuleContexts(Yield_statementContext.class);
		}
		public Yield_statementContext yield_statement(int i) {
			return getRuleContext(Yield_statementContext.class,i);
		}
		public Generator_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generator_expression; }
	}

	public final Generator_expressionContext generator_expression() throws RecognitionException {
		Generator_expressionContext _localctx = new Generator_expressionContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_generator_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2055);
			match(GENERATOR_);
			setState(2056);
			match(LBRACE);
			setState(2060);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==YIELD) {
				{
				{
				setState(2057);
				yield_statement();
				}
				}
				setState(2062);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2063);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Yield_statementContext extends ParserRuleContext {
		public TerminalNode YIELD() { return getToken(T4Parser.YIELD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public Yield_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_statement; }
	}

	public final Yield_statementContext yield_statement() throws RecognitionException {
		Yield_statementContext _localctx = new Yield_statementContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_yield_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2065);
			match(YIELD);
			setState(2066);
			expression();
			setState(2067);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Coroutine_expressionContext extends ParserRuleContext {
		public TerminalNode COROUTINE_() { return getToken(T4Parser.COROUTINE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Coroutine_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coroutine_expression; }
	}

	public final Coroutine_expressionContext coroutine_expression() throws RecognitionException {
		Coroutine_expressionContext _localctx = new Coroutine_expressionContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_coroutine_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2069);
			match(COROUTINE_);
			setState(2070);
			match(LPAREN);
			setState(2072);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || _la==IDENTIFIER || _la==REF) {
				{
				setState(2071);
				parameters();
				}
			}

			setState(2074);
			match(RPAREN);
			setState(2075);
			match(ARROW);
			setState(2076);
			return_type();
			setState(2077);
			match(ASSIGN);
			setState(2078);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Partial_applicationContext extends ParserRuleContext {
		public TerminalNode PARTIAL_() { return getToken(T4Parser.PARTIAL_, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Partial_argsContext partial_args() {
			return getRuleContext(Partial_argsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Partial_applicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partial_application; }
	}

	public final Partial_applicationContext partial_application() throws RecognitionException {
		Partial_applicationContext _localctx = new Partial_applicationContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_partial_application);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2080);
			match(PARTIAL_);
			setState(2081);
			expression();
			setState(2082);
			match(LPAREN);
			setState(2083);
			partial_args();
			setState(2084);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Partial_argsContext extends ParserRuleContext {
		public TerminalNode UNDERSCORE() { return getToken(T4Parser.UNDERSCORE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Partial_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partial_args; }
	}

	public final Partial_argsContext partial_args() throws RecognitionException {
		Partial_argsContext _localctx = new Partial_argsContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_partial_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				{
				setState(2086);
				expression();
				setState(2087);
				match(COMMA);
				}
				}
				setState(2093);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2094);
			match(UNDERSCORE);
			setState(2099);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2095);
				match(COMMA);
				setState(2096);
				expression();
				}
				}
				setState(2101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_compositionContext extends ParserRuleContext {
		public TerminalNode COMPOSE_() { return getToken(T4Parser.COMPOSE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Function_compositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_composition; }
	}

	public final Function_compositionContext function_composition() throws RecognitionException {
		Function_compositionContext _localctx = new Function_compositionContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_function_composition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2102);
			match(COMPOSE_);
			setState(2103);
			match(LPAREN);
			setState(2104);
			expression();
			setState(2105);
			match(COMMA);
			setState(2106);
			expression();
			setState(2107);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pipeline_expressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> PIPE_() { return getTokens(T4Parser.PIPE_); }
		public TerminalNode PIPE_(int i) {
			return getToken(T4Parser.PIPE_, i);
		}
		public Pipeline_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline_expression; }
	}

	public final Pipeline_expressionContext pipeline_expression() throws RecognitionException {
		Pipeline_expressionContext _localctx = new Pipeline_expressionContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_pipeline_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2109);
			expression();
			setState(2110);
			match(PIPE_);
			setState(2111);
			expression();
			setState(2116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE_) {
				{
				{
				setState(2112);
				match(PIPE_);
				setState(2113);
				expression();
				}
				}
				setState(2118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_chainContext extends ParserRuleContext {
		public TerminalNode CHAIN_() { return getToken(T4Parser.CHAIN_, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(T4Parser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(T4Parser.LPAREN, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(T4Parser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(T4Parser.RPAREN, i);
		}
		public List<TerminalNode> DOT() { return getTokens(T4Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(T4Parser.DOT, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(T4Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(T4Parser.IDENTIFIER, i);
		}
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public Method_chainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_chain; }
	}

	public final Method_chainContext method_chain() throws RecognitionException {
		Method_chainContext _localctx = new Method_chainContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_method_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2119);
			match(CHAIN_);
			setState(2120);
			match(LPAREN);
			setState(2121);
			expression();
			setState(2131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(2122);
				match(DOT);
				setState(2123);
				match(IDENTIFIER);
				setState(2124);
				match(LPAREN);
				setState(2126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
					{
					setState(2125);
					arguments();
					}
				}

				setState(2128);
				match(RPAREN);
				}
				}
				setState(2133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2134);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Module_hierarchyContext extends ParserRuleContext {
		public TerminalNode NAMESPACE_() { return getToken(T4Parser.NAMESPACE_, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(T4Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(T4Parser.IDENTIFIER, i);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<TerminalNode> COLONCOLON() { return getTokens(T4Parser.COLONCOLON); }
		public TerminalNode COLONCOLON(int i) {
			return getToken(T4Parser.COLONCOLON, i);
		}
		public List<Module_itemContext> module_item() {
			return getRuleContexts(Module_itemContext.class);
		}
		public Module_itemContext module_item(int i) {
			return getRuleContext(Module_itemContext.class,i);
		}
		public Module_hierarchyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_hierarchy; }
	}

	public final Module_hierarchyContext module_hierarchy() throws RecognitionException {
		Module_hierarchyContext _localctx = new Module_hierarchyContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_module_hierarchy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2136);
			match(NAMESPACE_);
			setState(2137);
			match(IDENTIFIER);
			setState(2142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLONCOLON) {
				{
				{
				setState(2138);
				match(COLONCOLON);
				setState(2139);
				match(IDENTIFIER);
				}
				}
				setState(2144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2145);
			match(LBRACE);
			setState(2149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_ || ((((_la - 259)) & ~0x3f) == 0 && ((1L << (_la - 259)) & 63L) != 0)) {
				{
				{
				setState(2146);
				module_item();
				}
				}
				setState(2151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2152);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Module_itemContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Visibility_modifierContext visibility_modifier() {
			return getRuleContext(Visibility_modifierContext.class,0);
		}
		public Secure_moduleContext secure_module() {
			return getRuleContext(Secure_moduleContext.class,0);
		}
		public Isolated_moduleContext isolated_module() {
			return getRuleContext(Isolated_moduleContext.class,0);
		}
		public Module_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_item; }
	}

	public final Module_itemContext module_item() throws RecognitionException {
		Module_itemContext _localctx = new Module_itemContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_module_item);
		try {
			setState(2160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2154);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2155);
				visibility_modifier();
				setState(2156);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2158);
				secure_module();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2159);
				isolated_module();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Visibility_modifierContext extends ParserRuleContext {
		public TerminalNode SECURE_() { return getToken(T4Parser.SECURE_, 0); }
		public TerminalNode ISOLATED_() { return getToken(T4Parser.ISOLATED_, 0); }
		public TerminalNode TRUSTED_() { return getToken(T4Parser.TRUSTED_, 0); }
		public TerminalNode UNTRUSTED_() { return getToken(T4Parser.UNTRUSTED_, 0); }
		public TerminalNode SENSITIVE_() { return getToken(T4Parser.SENSITIVE_, 0); }
		public TerminalNode CLASSIFIED_() { return getToken(T4Parser.CLASSIFIED_, 0); }
		public Visibility_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility_modifier; }
	}

	public final Visibility_modifierContext visibility_modifier() throws RecognitionException {
		Visibility_modifierContext _localctx = new Visibility_modifierContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_visibility_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2162);
			_la = _input.LA(1);
			if ( !(((((_la - 259)) & ~0x3f) == 0 && ((1L << (_la - 259)) & 63L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Secure_moduleContext extends ParserRuleContext {
		public TerminalNode SECURE_() { return getToken(T4Parser.SECURE_, 0); }
		public TerminalNode MODULE() { return getToken(T4Parser.MODULE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Secure_itemContext> secure_item() {
			return getRuleContexts(Secure_itemContext.class);
		}
		public Secure_itemContext secure_item(int i) {
			return getRuleContext(Secure_itemContext.class,i);
		}
		public Secure_moduleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secure_module; }
	}

	public final Secure_moduleContext secure_module() throws RecognitionException {
		Secure_moduleContext _localctx = new Secure_moduleContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_secure_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2164);
			match(SECURE_);
			setState(2165);
			match(MODULE);
			setState(2166);
			match(IDENTIFIER);
			setState(2167);
			match(LBRACE);
			setState(2171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_ || _la==COMPARTMENT_) {
				{
				{
				setState(2168);
				secure_item();
				}
				}
				setState(2173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2174);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Secure_itemContext extends ParserRuleContext {
		public TerminalNode COMPARTMENT_() { return getToken(T4Parser.COMPARTMENT_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public Secure_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secure_item; }
	}

	public final Secure_itemContext secure_item() throws RecognitionException {
		Secure_itemContext _localctx = new Secure_itemContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_secure_item);
		int _la;
		try {
			setState(2187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPARTMENT_:
				enterOuterAlt(_localctx, 1);
				{
				setState(2176);
				match(COMPARTMENT_);
				setState(2177);
				match(IDENTIFIER);
				setState(2178);
				match(LBRACE);
				setState(2182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_) {
					{
					{
					setState(2179);
					declaration();
					}
					}
					setState(2184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2185);
				match(RBRACE);
				}
				break;
			case MODULE:
			case IMPORT:
			case FN:
			case CONST:
			case STATIC:
			case STRUCT:
			case ENUM:
			case TRAIT:
			case IMPL:
			case TYPE:
			case CONFIG_:
			case EXTERN_:
				enterOuterAlt(_localctx, 2);
				{
				setState(2186);
				declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Isolated_moduleContext extends ParserRuleContext {
		public TerminalNode ISOLATED_() { return getToken(T4Parser.ISOLATED_, 0); }
		public TerminalNode MODULE() { return getToken(T4Parser.MODULE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Isolated_itemContext> isolated_item() {
			return getRuleContexts(Isolated_itemContext.class);
		}
		public Isolated_itemContext isolated_item(int i) {
			return getRuleContext(Isolated_itemContext.class,i);
		}
		public Isolated_moduleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isolated_module; }
	}

	public final Isolated_moduleContext isolated_module() throws RecognitionException {
		Isolated_moduleContext _localctx = new Isolated_moduleContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_isolated_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2189);
			match(ISOLATED_);
			setState(2190);
			match(MODULE);
			setState(2191);
			match(IDENTIFIER);
			setState(2192);
			match(LBRACE);
			setState(2196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_ || _la==TRUSTED_ || _la==UNTRUSTED_) {
				{
				{
				setState(2193);
				isolated_item();
				}
				}
				setState(2198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2199);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Isolated_itemContext extends ParserRuleContext {
		public TerminalNode TRUSTED_() { return getToken(T4Parser.TRUSTED_, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TerminalNode UNTRUSTED_() { return getToken(T4Parser.UNTRUSTED_, 0); }
		public Isolated_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isolated_item; }
	}

	public final Isolated_itemContext isolated_item() throws RecognitionException {
		Isolated_itemContext _localctx = new Isolated_itemContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_isolated_item);
		int _la;
		try {
			setState(2220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUSTED_:
				enterOuterAlt(_localctx, 1);
				{
				setState(2201);
				match(TRUSTED_);
				setState(2202);
				match(LBRACE);
				setState(2206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_) {
					{
					{
					setState(2203);
					declaration();
					}
					}
					setState(2208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2209);
				match(RBRACE);
				}
				break;
			case UNTRUSTED_:
				enterOuterAlt(_localctx, 2);
				{
				setState(2210);
				match(UNTRUSTED_);
				setState(2211);
				match(LBRACE);
				setState(2215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_) {
					{
					{
					setState(2212);
					declaration();
					}
					}
					setState(2217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2218);
				match(RBRACE);
				}
				break;
			case MODULE:
			case IMPORT:
			case FN:
			case CONST:
			case STATIC:
			case STRUCT:
			case ENUM:
			case TRAIT:
			case IMPL:
			case TYPE:
			case CONFIG_:
			case EXTERN_:
				enterOuterAlt(_localctx, 3);
				{
				setState(2219);
				declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Component_declarationContext extends ParserRuleContext {
		public TerminalNode COMPONENT_() { return getToken(T4Parser.COMPONENT_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public TerminalNode IMPLEMENTS_() { return getToken(T4Parser.IMPLEMENTS_, 0); }
		public Interface_listContext interface_list() {
			return getRuleContext(Interface_listContext.class,0);
		}
		public List<Component_itemContext> component_item() {
			return getRuleContexts(Component_itemContext.class);
		}
		public Component_itemContext component_item(int i) {
			return getRuleContext(Component_itemContext.class,i);
		}
		public Component_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_declaration; }
	}

	public final Component_declarationContext component_declaration() throws RecognitionException {
		Component_declarationContext _localctx = new Component_declarationContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_component_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2222);
			match(COMPONENT_);
			setState(2223);
			match(IDENTIFIER);
			setState(2226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS_) {
				{
				setState(2224);
				match(IMPLEMENTS_);
				setState(2225);
				interface_list();
				}
			}

			setState(2228);
			match(LBRACE);
			setState(2232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_ || _la==SERVICE_) {
				{
				{
				setState(2229);
				component_item();
				}
				}
				setState(2234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2235);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Interface_listContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(T4Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(T4Parser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Interface_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_list; }
	}

	public final Interface_listContext interface_list() throws RecognitionException {
		Interface_listContext _localctx = new Interface_listContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_interface_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2237);
			match(IDENTIFIER);
			setState(2242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2238);
				match(COMMA);
				setState(2239);
				match(IDENTIFIER);
				}
				}
				setState(2244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Component_itemContext extends ParserRuleContext {
		public TerminalNode SERVICE_() { return getToken(T4Parser.SERVICE_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Component_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_item; }
	}

	public final Component_itemContext component_item() throws RecognitionException {
		Component_itemContext _localctx = new Component_itemContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_component_item);
		int _la;
		try {
			setState(2257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SERVICE_:
				enterOuterAlt(_localctx, 1);
				{
				setState(2245);
				match(SERVICE_);
				setState(2246);
				match(IDENTIFIER);
				setState(2247);
				match(LPAREN);
				setState(2248);
				parameters();
				setState(2249);
				match(RPAREN);
				setState(2252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARROW) {
					{
					setState(2250);
					match(ARROW);
					setState(2251);
					return_type();
					}
				}

				setState(2254);
				match(SEMICOLON);
				}
				break;
			case MODULE:
			case IMPORT:
			case FN:
			case CONST:
			case STATIC:
			case STRUCT:
			case ENUM:
			case TRAIT:
			case IMPL:
			case TYPE:
			case CONFIG_:
			case EXTERN_:
				enterOuterAlt(_localctx, 2);
				{
				setState(2256);
				declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Microservice_declarationContext extends ParserRuleContext {
		public TerminalNode MICROSERVICE_() { return getToken(T4Parser.MICROSERVICE_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Microservice_configContext> microservice_config() {
			return getRuleContexts(Microservice_configContext.class);
		}
		public Microservice_configContext microservice_config(int i) {
			return getRuleContext(Microservice_configContext.class,i);
		}
		public Microservice_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_microservice_declaration; }
	}

	public final Microservice_declarationContext microservice_declaration() throws RecognitionException {
		Microservice_declarationContext _localctx = new Microservice_declarationContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_microservice_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2259);
			match(MICROSERVICE_);
			setState(2260);
			match(IDENTIFIER);
			setState(2261);
			match(LBRACE);
			setState(2265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==API_ || _la==AUTHENTICATION_ || _la==ENCRYPTION_) {
				{
				{
				setState(2262);
				microservice_config();
				}
				}
				setState(2267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2268);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Microservice_configContext extends ParserRuleContext {
		public TerminalNode API_() { return getToken(T4Parser.API_, 0); }
		public TerminalNode ENDPOINT_() { return getToken(T4Parser.ENDPOINT_, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public TerminalNode STRING() { return getToken(T4Parser.STRING, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode AUTHENTICATION_() { return getToken(T4Parser.AUTHENTICATION_, 0); }
		public TerminalNode REQUIRED_() { return getToken(T4Parser.REQUIRED_, 0); }
		public TerminalNode ENCRYPTION_() { return getToken(T4Parser.ENCRYPTION_, 0); }
		public Microservice_configContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_microservice_config; }
	}

	public final Microservice_configContext microservice_config() throws RecognitionException {
		Microservice_configContext _localctx = new Microservice_configContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_microservice_config);
		try {
			setState(2281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case API_:
				enterOuterAlt(_localctx, 1);
				{
				setState(2270);
				match(API_);
				setState(2271);
				match(ENDPOINT_);
				setState(2272);
				match(ASSIGN);
				setState(2273);
				match(STRING);
				setState(2274);
				match(SEMICOLON);
				}
				break;
			case AUTHENTICATION_:
				enterOuterAlt(_localctx, 2);
				{
				setState(2275);
				match(AUTHENTICATION_);
				setState(2276);
				match(REQUIRED_);
				setState(2277);
				match(SEMICOLON);
				}
				break;
			case ENCRYPTION_:
				enterOuterAlt(_localctx, 3);
				{
				setState(2278);
				match(ENCRYPTION_);
				setState(2279);
				match(REQUIRED_);
				setState(2280);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Api_declarationContext extends ParserRuleContext {
		public TerminalNode API_() { return getToken(T4Parser.API_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Api_methodContext> api_method() {
			return getRuleContexts(Api_methodContext.class);
		}
		public Api_methodContext api_method(int i) {
			return getRuleContext(Api_methodContext.class,i);
		}
		public Api_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_api_declaration; }
	}

	public final Api_declarationContext api_declaration() throws RecognitionException {
		Api_declarationContext _localctx = new Api_declarationContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_api_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2283);
			match(API_);
			setState(2284);
			match(IDENTIFIER);
			setState(2285);
			match(LBRACE);
			setState(2289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FN) {
				{
				{
				setState(2286);
				api_method();
				}
				}
				setState(2291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2292);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Api_methodContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Api_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_api_method; }
	}

	public final Api_methodContext api_method() throws RecognitionException {
		Api_methodContext _localctx = new Api_methodContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_api_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2294);
			match(FN);
			setState(2295);
			match(IDENTIFIER);
			setState(2296);
			match(LPAREN);
			setState(2297);
			parameters();
			setState(2298);
			match(RPAREN);
			setState(2301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(2299);
				match(ARROW);
				setState(2300);
				return_type();
				}
			}

			setState(2303);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Interface_declarationContext extends ParserRuleContext {
		public TerminalNode INTERFACE_() { return getToken(T4Parser.INTERFACE_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Interface_methodContext> interface_method() {
			return getRuleContexts(Interface_methodContext.class);
		}
		public Interface_methodContext interface_method(int i) {
			return getRuleContext(Interface_methodContext.class,i);
		}
		public Interface_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_declaration; }
	}

	public final Interface_declarationContext interface_declaration() throws RecognitionException {
		Interface_declarationContext _localctx = new Interface_declarationContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_interface_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2305);
			match(INTERFACE_);
			setState(2306);
			match(IDENTIFIER);
			setState(2307);
			match(LBRACE);
			setState(2311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FN) {
				{
				{
				setState(2308);
				interface_method();
				}
				}
				setState(2313);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2314);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Interface_methodContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Interface_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_method; }
	}

	public final Interface_methodContext interface_method() throws RecognitionException {
		Interface_methodContext _localctx = new Interface_methodContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_interface_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2316);
			match(FN);
			setState(2317);
			match(IDENTIFIER);
			setState(2318);
			match(LPAREN);
			setState(2319);
			parameters();
			setState(2320);
			match(RPAREN);
			setState(2323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(2321);
				match(ARROW);
				setState(2322);
				return_type();
				}
			}

			setState(2325);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_matchingContext extends ParserRuleContext {
		public TerminalNode PATTERN_() { return getToken(T4Parser.PATTERN_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Pattern_armContext> pattern_arm() {
			return getRuleContexts(Pattern_armContext.class);
		}
		public Pattern_armContext pattern_arm(int i) {
			return getRuleContext(Pattern_armContext.class,i);
		}
		public Pattern_matchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matching; }
	}

	public final Pattern_matchingContext pattern_matching() throws RecognitionException {
		Pattern_matchingContext _localctx = new Pattern_matchingContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_pattern_matching);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2327);
			match(PATTERN_);
			setState(2328);
			match(IDENTIFIER);
			setState(2329);
			match(LBRACE);
			setState(2333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 38280596832650239L) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & 2251799813685285L) != 0)) {
				{
				{
				setState(2330);
				pattern_arm();
				}
				}
				setState(2335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2336);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_armContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode FAT_ARROW() { return getToken(T4Parser.FAT_ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GUARD_() { return getToken(T4Parser.GUARD_, 0); }
		public Pattern_armContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_arm; }
	}

	public final Pattern_armContext pattern_arm() throws RecognitionException {
		Pattern_armContext _localctx = new Pattern_armContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_pattern_arm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2338);
			pattern();
			setState(2340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GUARD_) {
				{
				setState(2339);
				match(GUARD_);
				}
			}

			setState(2342);
			match(FAT_ARROW);
			setState(2343);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Guard_expressionContext extends ParserRuleContext {
		public TerminalNode GUARD_() { return getToken(T4Parser.GUARD_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Guard_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard_expression; }
	}

	public final Guard_expressionContext guard_expression() throws RecognitionException {
		Guard_expressionContext _localctx = new Guard_expressionContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_guard_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2345);
			match(GUARD_);
			setState(2346);
			match(LPAREN);
			setState(2347);
			expression();
			setState(2348);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DestructuringContext extends ParserRuleContext {
		public TerminalNode DESTRUCTURE_() { return getToken(T4Parser.DESTRUCTURE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<BindingContext> binding() {
			return getRuleContexts(BindingContext.class);
		}
		public BindingContext binding(int i) {
			return getRuleContext(BindingContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public DestructuringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructuring; }
	}

	public final DestructuringContext destructuring() throws RecognitionException {
		DestructuringContext _localctx = new DestructuringContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_destructuring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2350);
			match(DESTRUCTURE_);
			setState(2351);
			match(LPAREN);
			setState(2352);
			binding();
			setState(2357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2353);
				match(COMMA);
				setState(2354);
				binding();
				}
				}
				setState(2359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2360);
			match(RPAREN);
			setState(2361);
			match(ASSIGN);
			setState(2362);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingContext extends ParserRuleContext {
		public TerminalNode BINDING_() { return getToken(T4Parser.BINDING_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(T4Parser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_binding);
		try {
			setState(2369);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINDING_:
				enterOuterAlt(_localctx, 1);
				{
				setState(2364);
				match(BINDING_);
				setState(2365);
				match(IDENTIFIER);
				setState(2366);
				match(COLON);
				setState(2367);
				type_();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(2368);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComprehensionContext extends ParserRuleContext {
		public TerminalNode COMPREHENSION_() { return getToken(T4Parser.COMPREHENSION_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PIPE_() { return getToken(T4Parser.PIPE_, 0); }
		public IteratorsContext iterators() {
			return getRuleContext(IteratorsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ComprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehension; }
	}

	public final ComprehensionContext comprehension() throws RecognitionException {
		ComprehensionContext _localctx = new ComprehensionContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_comprehension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2371);
			match(COMPREHENSION_);
			setState(2372);
			match(LT);
			setState(2373);
			type_();
			setState(2374);
			match(GT);
			setState(2375);
			match(LPAREN);
			setState(2376);
			expression();
			setState(2377);
			match(PIPE_);
			setState(2378);
			iterators();
			setState(2379);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IteratorsContext extends ParserRuleContext {
		public List<Iterator_chainContext> iterator_chain() {
			return getRuleContexts(Iterator_chainContext.class);
		}
		public Iterator_chainContext iterator_chain(int i) {
			return getRuleContext(Iterator_chainContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public IteratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterators; }
	}

	public final IteratorsContext iterators() throws RecognitionException {
		IteratorsContext _localctx = new IteratorsContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_iterators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2381);
			iterator_chain();
			setState(2386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2382);
				match(COMMA);
				setState(2383);
				iterator_chain();
				}
				}
				setState(2388);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Iterator_chainContext extends ParserRuleContext {
		public TerminalNode ITERATOR_CHAIN_() { return getToken(T4Parser.ITERATOR_CHAIN_, 0); }
		public TerminalNode DOT() { return getToken(T4Parser.DOT, 0); }
		public Chain_operationContext chain_operation() {
			return getRuleContext(Chain_operationContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Iterator_chainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterator_chain; }
	}

	public final Iterator_chainContext iterator_chain() throws RecognitionException {
		Iterator_chainContext _localctx = new Iterator_chainContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_iterator_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2389);
			match(ITERATOR_CHAIN_);
			setState(2390);
			match(DOT);
			setState(2391);
			chain_operation();
			setState(2392);
			match(LPAREN);
			setState(2394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(2393);
				arguments();
				}
			}

			setState(2396);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Chain_operationContext extends ParserRuleContext {
		public TerminalNode FILTER_() { return getToken(T4Parser.FILTER_, 0); }
		public TerminalNode MAP_TRANSFORM_() { return getToken(T4Parser.MAP_TRANSFORM_, 0); }
		public TerminalNode REDUCE_() { return getToken(T4Parser.REDUCE_, 0); }
		public TerminalNode FOLD_() { return getToken(T4Parser.FOLD_, 0); }
		public TerminalNode FLATTEN_() { return getToken(T4Parser.FLATTEN_, 0); }
		public TerminalNode ZIP_() { return getToken(T4Parser.ZIP_, 0); }
		public TerminalNode ENUMERATE_() { return getToken(T4Parser.ENUMERATE_, 0); }
		public TerminalNode TAKE_() { return getToken(T4Parser.TAKE_, 0); }
		public TerminalNode SKIP_() { return getToken(T4Parser.SKIP_, 0); }
		public TerminalNode CYCLE_() { return getToken(T4Parser.CYCLE_, 0); }
		public TerminalNode REPEAT_() { return getToken(T4Parser.REPEAT_, 0); }
		public Chain_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain_operation; }
	}

	public final Chain_operationContext chain_operation() throws RecognitionException {
		Chain_operationContext _localctx = new Chain_operationContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_chain_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2398);
			_la = _input.LA(1);
			if ( !(((((_la - 289)) & ~0x3f) == 0 && ((1L << (_la - 289)) & 1023L) != 0) || _la==MAP_TRANSFORM_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_comprehensionContext extends ParserRuleContext {
		public TerminalNode LIST_() { return getToken(T4Parser.LIST_, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PIPE_() { return getToken(T4Parser.PIPE_, 0); }
		public GeneratorsContext generators() {
			return getRuleContext(GeneratorsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List_comprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_comprehension; }
	}

	public final List_comprehensionContext list_comprehension() throws RecognitionException {
		List_comprehensionContext _localctx = new List_comprehensionContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_list_comprehension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2400);
			match(LIST_);
			setState(2401);
			match(LBRACE);
			setState(2402);
			expression();
			setState(2403);
			match(PIPE_);
			setState(2404);
			generators();
			setState(2405);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GeneratorsContext extends ParserRuleContext {
		public List<GeneratorContext> generator() {
			return getRuleContexts(GeneratorContext.class);
		}
		public GeneratorContext generator(int i) {
			return getRuleContext(GeneratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public GeneratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generators; }
	}

	public final GeneratorsContext generators() throws RecognitionException {
		GeneratorsContext _localctx = new GeneratorsContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_generators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2407);
			generator();
			setState(2412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2408);
				match(COMMA);
				setState(2409);
				generator();
				}
				}
				setState(2414);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GeneratorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(T4Parser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IF() { return getToken(T4Parser.IF, 0); }
		public GeneratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generator; }
	}

	public final GeneratorContext generator() throws RecognitionException {
		GeneratorContext _localctx = new GeneratorContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_generator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2415);
			match(IDENTIFIER);
			setState(2416);
			match(IN);
			setState(2417);
			expression();
			setState(2420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(2418);
				match(IF);
				setState(2419);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Range_literalContext extends ParserRuleContext {
		public ExpressionContext start;
		public ExpressionContext end;
		public ExpressionContext step;
		public Token inclusive;
		public TerminalNode RANGE_() { return getToken(T4Parser.RANGE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode INCLUSIVE_() { return getToken(T4Parser.INCLUSIVE_, 0); }
		public Range_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_literal; }
	}

	public final Range_literalContext range_literal() throws RecognitionException {
		Range_literalContext _localctx = new Range_literalContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_range_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2422);
			match(RANGE_);
			setState(2423);
			match(LPAREN);
			setState(2424);
			((Range_literalContext)_localctx).start = expression();
			setState(2425);
			match(COMMA);
			setState(2426);
			((Range_literalContext)_localctx).end = expression();
			setState(2429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				{
				setState(2427);
				match(COMMA);
				setState(2428);
				((Range_literalContext)_localctx).step = expression();
				}
				break;
			}
			setState(2433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2431);
				match(COMMA);
				setState(2432);
				((Range_literalContext)_localctx).inclusive = match(INCLUSIVE_);
				}
			}

			setState(2435);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Early_returnContext extends ParserRuleContext {
		public TerminalNode EARLY_RETURN_() { return getToken(T4Parser.EARLY_RETURN_, 0); }
		public TerminalNode SEMICOLON() { return getToken(T4Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Early_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_early_return; }
	}

	public final Early_returnContext early_return() throws RecognitionException {
		Early_returnContext _localctx = new Early_returnContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_early_return);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2437);
			match(EARLY_RETURN_);
			setState(2439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(2438);
				expression();
				}
			}

			setState(2441);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Vector_literalContext extends ParserRuleContext {
		public TerminalNode VECTOR_() { return getToken(T4Parser.VECTOR_, 0); }
		public TerminalNode LBRACKET() { return getToken(T4Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(T4Parser.RBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Vector_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector_literal; }
	}

	public final Vector_literalContext vector_literal() throws RecognitionException {
		Vector_literalContext _localctx = new Vector_literalContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_vector_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2443);
			match(VECTOR_);
			setState(2444);
			match(LBRACKET);
			setState(2453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(2445);
				expression();
				setState(2450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2446);
					match(COMMA);
					setState(2447);
					expression();
					}
					}
					setState(2452);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(2455);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Set_literalContext extends ParserRuleContext {
		public TerminalNode SET_() { return getToken(T4Parser.SET_, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Set_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_literal; }
	}

	public final Set_literalContext set_literal() throws RecognitionException {
		Set_literalContext _localctx = new Set_literalContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_set_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2457);
			match(SET_);
			setState(2458);
			match(LBRACE);
			setState(2467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(2459);
				expression();
				setState(2464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2460);
					match(COMMA);
					setState(2461);
					expression();
					}
					}
					setState(2466);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(2469);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Crypto_literalContext extends ParserRuleContext {
		public TerminalNode KEY_LITERAL_() { return getToken(T4Parser.KEY_LITERAL_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Algorithm_typeContext algorithm_type() {
			return getRuleContext(Algorithm_typeContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Key_dataContext key_data() {
			return getRuleContext(Key_dataContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode SECRET_LITERAL_() { return getToken(T4Parser.SECRET_LITERAL_, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Secret_dataContext secret_data() {
			return getRuleContext(Secret_dataContext.class,0);
		}
		public Crypto_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crypto_literal; }
	}

	public final Crypto_literalContext crypto_literal() throws RecognitionException {
		Crypto_literalContext _localctx = new Crypto_literalContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_crypto_literal);
		try {
			setState(2487);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY_LITERAL_:
				enterOuterAlt(_localctx, 1);
				{
				setState(2471);
				match(KEY_LITERAL_);
				setState(2472);
				match(LT);
				setState(2473);
				algorithm_type();
				setState(2474);
				match(GT);
				setState(2475);
				match(LPAREN);
				setState(2476);
				key_data();
				setState(2477);
				match(RPAREN);
				}
				break;
			case SECRET_LITERAL_:
				enterOuterAlt(_localctx, 2);
				{
				setState(2479);
				match(SECRET_LITERAL_);
				setState(2480);
				match(LT);
				setState(2481);
				type_();
				setState(2482);
				match(GT);
				setState(2483);
				match(LPAREN);
				setState(2484);
				secret_data();
				setState(2485);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Key_dataContext extends ParserRuleContext {
		public TerminalNode HEX_INTEGER() { return getToken(T4Parser.HEX_INTEGER, 0); }
		public TerminalNode STRING() { return getToken(T4Parser.STRING, 0); }
		public TerminalNode BYTES() { return getToken(T4Parser.BYTES, 0); }
		public Key_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_data; }
	}

	public final Key_dataContext key_data() throws RecognitionException {
		Key_dataContext _localctx = new Key_dataContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_key_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2489);
			_la = _input.LA(1);
			if ( !(_la==HEX_INTEGER || _la==STRING || _la==BYTES) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Secret_dataContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Secret_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secret_data; }
	}

	public final Secret_dataContext secret_data() throws RecognitionException {
		Secret_dataContext _localctx = new Secret_dataContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_secret_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2491);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Crypto_operationContext extends ParserRuleContext {
		public TerminalNode CRYPTO_OP_() { return getToken(T4Parser.CRYPTO_OP_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Operation_typeContext operation_type() {
			return getRuleContext(Operation_typeContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public OperandsContext operands() {
			return getRuleContext(OperandsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Crypto_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crypto_operation; }
	}

	public final Crypto_operationContext crypto_operation() throws RecognitionException {
		Crypto_operationContext _localctx = new Crypto_operationContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_crypto_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2493);
			match(CRYPTO_OP_);
			setState(2494);
			match(LT);
			setState(2495);
			operation_type();
			setState(2496);
			match(GT);
			setState(2497);
			match(LPAREN);
			setState(2498);
			operands();
			setState(2499);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Operation_typeContext extends ParserRuleContext {
		public TerminalNode ENCRYPTION_() { return getToken(T4Parser.ENCRYPTION_, 0); }
		public TerminalNode DECRYPTION_() { return getToken(T4Parser.DECRYPTION_, 0); }
		public TerminalNode SIGNATURE_() { return getToken(T4Parser.SIGNATURE_, 0); }
		public TerminalNode VERIFICATION_() { return getToken(T4Parser.VERIFICATION_, 0); }
		public TerminalNode KEY_EXCHANGE_() { return getToken(T4Parser.KEY_EXCHANGE_, 0); }
		public TerminalNode HASH_() { return getToken(T4Parser.HASH_, 0); }
		public TerminalNode MAC_() { return getToken(T4Parser.MAC_, 0); }
		public TerminalNode PROOF_() { return getToken(T4Parser.PROOF_, 0); }
		public Operation_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation_type; }
	}

	public final Operation_typeContext operation_type() throws RecognitionException {
		Operation_typeContext _localctx = new Operation_typeContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_operation_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2501);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 18093563346681856L) != 0) || ((((_la - 397)) & ~0x3f) == 0 && ((1L << (_la - 397)) & 31L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperandsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public OperandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operands; }
	}

	public final OperandsContext operands() throws RecognitionException {
		OperandsContext _localctx = new OperandsContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_operands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2503);
			expression();
			setState(2508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2504);
				match(COMMA);
				setState(2505);
				expression();
				}
				}
				setState(2510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Protocol_definitionContext extends ParserRuleContext {
		public TerminalNode PROTOCOL_() { return getToken(T4Parser.PROTOCOL_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Protocol_stageContext> protocol_stage() {
			return getRuleContexts(Protocol_stageContext.class);
		}
		public Protocol_stageContext protocol_stage(int i) {
			return getRuleContext(Protocol_stageContext.class,i);
		}
		public Protocol_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocol_definition; }
	}

	public final Protocol_definitionContext protocol_definition() throws RecognitionException {
		Protocol_definitionContext _localctx = new Protocol_definitionContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_protocol_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2511);
			match(PROTOCOL_);
			setState(2512);
			match(IDENTIFIER);
			setState(2513);
			match(LBRACE);
			setState(2517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(2514);
				protocol_stage();
				}
				}
				setState(2519);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2520);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Protocol_stageContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Protocol_actionContext> protocol_action() {
			return getRuleContexts(Protocol_actionContext.class);
		}
		public Protocol_actionContext protocol_action(int i) {
			return getRuleContext(Protocol_actionContext.class,i);
		}
		public Protocol_stageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocol_stage; }
	}

	public final Protocol_stageContext protocol_stage() throws RecognitionException {
		Protocol_stageContext _localctx = new Protocol_stageContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_protocol_stage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2522);
			match(IDENTIFIER);
			setState(2523);
			match(ARROW);
			setState(2524);
			match(LBRACE);
			setState(2528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VERIFY_ || ((((_la - 402)) & ~0x3f) == 0 && ((1L << (_la - 402)) & 7L) != 0)) {
				{
				{
				setState(2525);
				protocol_action();
				}
				}
				setState(2530);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2531);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Protocol_actionContext extends ParserRuleContext {
		public TerminalNode SEND_() { return getToken(T4Parser.SEND_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public MessageContext message() {
			return getRuleContext(MessageContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode RECEIVE_() { return getToken(T4Parser.RECEIVE_, 0); }
		public TerminalNode COMPUTE_() { return getToken(T4Parser.COMPUTE_, 0); }
		public ComputationContext computation() {
			return getRuleContext(ComputationContext.class,0);
		}
		public TerminalNode VERIFY_() { return getToken(T4Parser.VERIFY_, 0); }
		public VerificationContext verification() {
			return getRuleContext(VerificationContext.class,0);
		}
		public Protocol_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocol_action; }
	}

	public final Protocol_actionContext protocol_action() throws RecognitionException {
		Protocol_actionContext _localctx = new Protocol_actionContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_protocol_action);
		try {
			setState(2553);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND_:
				enterOuterAlt(_localctx, 1);
				{
				setState(2533);
				match(SEND_);
				setState(2534);
				match(LPAREN);
				setState(2535);
				message();
				setState(2536);
				match(RPAREN);
				}
				break;
			case RECEIVE_:
				enterOuterAlt(_localctx, 2);
				{
				setState(2538);
				match(RECEIVE_);
				setState(2539);
				match(LPAREN);
				setState(2540);
				message();
				setState(2541);
				match(RPAREN);
				}
				break;
			case COMPUTE_:
				enterOuterAlt(_localctx, 3);
				{
				setState(2543);
				match(COMPUTE_);
				setState(2544);
				match(LPAREN);
				setState(2545);
				computation();
				setState(2546);
				match(RPAREN);
				}
				break;
			case VERIFY_:
				enterOuterAlt(_localctx, 4);
				{
				setState(2548);
				match(VERIFY_);
				setState(2549);
				match(LPAREN);
				setState(2550);
				verification();
				setState(2551);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MessageContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2555);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComputationContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ComputationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computation; }
	}

	public final ComputationContext computation() throws RecognitionException {
		ComputationContext _localctx = new ComputationContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_computation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2557);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VerificationContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VerificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verification; }
	}

	public final VerificationContext verification() throws RecognitionException {
		VerificationContext _localctx = new VerificationContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_verification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2559);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Zero_knowledge_proofContext extends ParserRuleContext {
		public TerminalNode ZERO_KNOWLEDGE_() { return getToken(T4Parser.ZERO_KNOWLEDGE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ProverContext prover() {
			return getRuleContext(ProverContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public VerifierContext verifier() {
			return getRuleContext(VerifierContext.class,0);
		}
		public Zk_statementContext zk_statement() {
			return getRuleContext(Zk_statementContext.class,0);
		}
		public WitnessContext witness() {
			return getRuleContext(WitnessContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Zero_knowledge_proofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zero_knowledge_proof; }
	}

	public final Zero_knowledge_proofContext zero_knowledge_proof() throws RecognitionException {
		Zero_knowledge_proofContext _localctx = new Zero_knowledge_proofContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_zero_knowledge_proof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2561);
			match(ZERO_KNOWLEDGE_);
			setState(2562);
			match(LPAREN);
			setState(2563);
			prover();
			setState(2564);
			match(COMMA);
			setState(2565);
			verifier();
			setState(2566);
			match(COMMA);
			setState(2567);
			zk_statement();
			setState(2568);
			match(COMMA);
			setState(2569);
			witness();
			setState(2570);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProverContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ProverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prover; }
	}

	public final ProverContext prover() throws RecognitionException {
		ProverContext _localctx = new ProverContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_prover);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2572);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VerifierContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VerifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verifier; }
	}

	public final VerifierContext verifier() throws RecognitionException {
		VerifierContext _localctx = new VerifierContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_verifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2574);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Zk_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Zk_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zk_statement; }
	}

	public final Zk_statementContext zk_statement() throws RecognitionException {
		Zk_statementContext _localctx = new Zk_statementContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_zk_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2576);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WitnessContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WitnessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_witness; }
	}

	public final WitnessContext witness() throws RecognitionException {
		WitnessContext _localctx = new WitnessContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_witness);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2578);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Homomorphic_operationContext extends ParserRuleContext {
		public TerminalNode HOMOMORPHIC_() { return getToken(T4Parser.HOMOMORPHIC_, 0); }
		public TerminalNode DOT() { return getToken(T4Parser.DOT, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Encrypted_dataContext encrypted_data() {
			return getRuleContext(Encrypted_dataContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public PlaintextContext plaintext() {
			return getRuleContext(PlaintextContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Homomorphic_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_homomorphic_operation; }
	}

	public final Homomorphic_operationContext homomorphic_operation() throws RecognitionException {
		Homomorphic_operationContext _localctx = new Homomorphic_operationContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_homomorphic_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2580);
			match(HOMOMORPHIC_);
			setState(2581);
			match(DOT);
			setState(2582);
			operation();
			setState(2583);
			match(LPAREN);
			setState(2584);
			encrypted_data();
			setState(2585);
			match(COMMA);
			setState(2586);
			plaintext();
			setState(2587);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ParserRuleContext {
		public TerminalNode ADD_() { return getToken(T4Parser.ADD_, 0); }
		public TerminalNode SUB_() { return getToken(T4Parser.SUB_, 0); }
		public TerminalNode MUL_() { return getToken(T4Parser.MUL_, 0); }
		public TerminalNode DIV_() { return getToken(T4Parser.DIV_, 0); }
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2589);
			_la = _input.LA(1);
			if ( !(((((_la - 405)) & ~0x3f) == 0 && ((1L << (_la - 405)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Encrypted_dataContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Encrypted_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_encrypted_data; }
	}

	public final Encrypted_dataContext encrypted_data() throws RecognitionException {
		Encrypted_dataContext _localctx = new Encrypted_dataContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_encrypted_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2591);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlaintextContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PlaintextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plaintext; }
	}

	public final PlaintextContext plaintext() throws RecognitionException {
		PlaintextContext _localctx = new PlaintextContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_plaintext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2593);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Distributed_cryptoContext extends ParserRuleContext {
		public ExpressionContext threshold;
		public TerminalNode DISTRIBUTED_() { return getToken(T4Parser.DISTRIBUTED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public ParticipantsContext participants() {
			return getRuleContext(ParticipantsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Distributed_cryptoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distributed_crypto; }
	}

	public final Distributed_cryptoContext distributed_crypto() throws RecognitionException {
		Distributed_cryptoContext _localctx = new Distributed_cryptoContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_distributed_crypto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2595);
			match(DISTRIBUTED_);
			setState(2596);
			match(LPAREN);
			setState(2597);
			((Distributed_cryptoContext)_localctx).threshold = expression();
			setState(2598);
			match(COMMA);
			setState(2599);
			participants();
			setState(2600);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParticipantsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public ParticipantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_participants; }
	}

	public final ParticipantsContext participants() throws RecognitionException {
		ParticipantsContext _localctx = new ParticipantsContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_participants);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2602);
			expression();
			setState(2607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2603);
				match(COMMA);
				setState(2604);
				expression();
				}
				}
				setState(2609);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Secure_computationContext extends ParserRuleContext {
		public TerminalNode SECURE_COMPUTATION_() { return getToken(T4Parser.SECURE_COMPUTATION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Computation_typeContext computation_type() {
			return getRuleContext(Computation_typeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public InputsContext inputs() {
			return getRuleContext(InputsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Secure_computationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secure_computation; }
	}

	public final Secure_computationContext secure_computation() throws RecognitionException {
		Secure_computationContext _localctx = new Secure_computationContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_secure_computation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2610);
			match(SECURE_COMPUTATION_);
			setState(2611);
			match(LPAREN);
			setState(2612);
			computation_type();
			setState(2613);
			match(COMMA);
			setState(2614);
			inputs();
			setState(2615);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public InputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputs; }
	}

	public final InputsContext inputs() throws RecognitionException {
		InputsContext _localctx = new InputsContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2617);
			expression();
			setState(2622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2618);
				match(COMMA);
				setState(2619);
				expression();
				}
				}
				setState(2624);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Anonymous_communicationContext extends ParserRuleContext {
		public TerminalNode ANONYMOUS_() { return getToken(T4Parser.ANONYMOUS_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public MessageContext message() {
			return getRuleContext(MessageContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public RoutingContext routing() {
			return getRuleContext(RoutingContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Anonymous_communicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymous_communication; }
	}

	public final Anonymous_communicationContext anonymous_communication() throws RecognitionException {
		Anonymous_communicationContext _localctx = new Anonymous_communicationContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_anonymous_communication);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2625);
			match(ANONYMOUS_);
			setState(2626);
			match(LPAREN);
			setState(2627);
			message();
			setState(2628);
			match(COMMA);
			setState(2629);
			routing();
			setState(2630);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoutingContext extends ParserRuleContext {
		public TerminalNode ONION_() { return getToken(T4Parser.ONION_, 0); }
		public TerminalNode MIXNET_() { return getToken(T4Parser.MIXNET_, 0); }
		public TerminalNode DCNET_() { return getToken(T4Parser.DCNET_, 0); }
		public RoutingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routing; }
	}

	public final RoutingContext routing() throws RecognitionException {
		RoutingContext _localctx = new RoutingContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_routing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2632);
			_la = _input.LA(1);
			if ( !(((((_la - 409)) & ~0x3f) == 0 && ((1L << (_la - 409)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Untraceable_operationContext extends ParserRuleContext {
		public TerminalNode UNTRACEABLE_() { return getToken(T4Parser.UNTRACEABLE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Untraceable_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untraceable_operation; }
	}

	public final Untraceable_operationContext untraceable_operation() throws RecognitionException {
		Untraceable_operationContext _localctx = new Untraceable_operationContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_untraceable_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2634);
			match(UNTRACEABLE_);
			setState(2635);
			match(LPAREN);
			setState(2636);
			operation();
			setState(2637);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Confidentiality_propertyContext extends ParserRuleContext {
		public TerminalNode CONFIDENTIALITY_() { return getToken(T4Parser.CONFIDENTIALITY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public PolicyContext policy() {
			return getRuleContext(PolicyContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Confidentiality_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_confidentiality_property; }
	}

	public final Confidentiality_propertyContext confidentiality_property() throws RecognitionException {
		Confidentiality_propertyContext _localctx = new Confidentiality_propertyContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_confidentiality_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2639);
			match(CONFIDENTIALITY_);
			setState(2640);
			match(LPAREN);
			setState(2641);
			data();
			setState(2642);
			match(COMMA);
			setState(2643);
			policy();
			setState(2644);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2646);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PolicyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policy; }
	}

	public final PolicyContext policy() throws RecognitionException {
		PolicyContext _localctx = new PolicyContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_policy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2648);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Authentication_propertyContext extends ParserRuleContext {
		public TerminalNode AUTHENTICATION_() { return getToken(T4Parser.AUTHENTICATION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public CredentialContext credential() {
			return getRuleContext(CredentialContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Authentication_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_authentication_property; }
	}

	public final Authentication_propertyContext authentication_property() throws RecognitionException {
		Authentication_propertyContext _localctx = new Authentication_propertyContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_authentication_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2650);
			match(AUTHENTICATION_);
			setState(2651);
			match(LPAREN);
			setState(2652);
			entity();
			setState(2653);
			match(COMMA);
			setState(2654);
			credential();
			setState(2655);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntityContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_entity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2657);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CredentialContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CredentialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_credential; }
	}

	public final CredentialContext credential() throws RecognitionException {
		CredentialContext _localctx = new CredentialContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_credential);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2659);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Non_repudiation_propertyContext extends ParserRuleContext {
		public TerminalNode NON_REPUDIATION_() { return getToken(T4Parser.NON_REPUDIATION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public EvidenceContext evidence() {
			return getRuleContext(EvidenceContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Non_repudiation_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_repudiation_property; }
	}

	public final Non_repudiation_propertyContext non_repudiation_property() throws RecognitionException {
		Non_repudiation_propertyContext _localctx = new Non_repudiation_propertyContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_non_repudiation_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2661);
			match(NON_REPUDIATION_);
			setState(2662);
			match(LPAREN);
			setState(2663);
			action();
			setState(2664);
			match(COMMA);
			setState(2665);
			evidence();
			setState(2666);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2668);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EvidenceContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EvidenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evidence; }
	}

	public final EvidenceContext evidence() throws RecognitionException {
		EvidenceContext _localctx = new EvidenceContext(_ctx, getState());
		enterRule(_localctx, 434, RULE_evidence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2670);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Integrity_propertyContext extends ParserRuleContext {
		public TerminalNode INTEGRITY_() { return getToken(T4Parser.INTEGRITY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public ChecksumContext checksum() {
			return getRuleContext(ChecksumContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Integrity_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integrity_property; }
	}

	public final Integrity_propertyContext integrity_property() throws RecognitionException {
		Integrity_propertyContext _localctx = new Integrity_propertyContext(_ctx, getState());
		enterRule(_localctx, 436, RULE_integrity_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2672);
			match(INTEGRITY_);
			setState(2673);
			match(LPAREN);
			setState(2674);
			data();
			setState(2675);
			match(COMMA);
			setState(2676);
			checksum();
			setState(2677);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChecksumContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChecksumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checksum; }
	}

	public final ChecksumContext checksum() throws RecognitionException {
		ChecksumContext _localctx = new ChecksumContext(_ctx, getState());
		enterRule(_localctx, 438, RULE_checksum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2679);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Availability_propertyContext extends ParserRuleContext {
		public TerminalNode AVAILABILITY_() { return getToken(T4Parser.AVAILABILITY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ResourceContext resource() {
			return getRuleContext(ResourceContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public RedundancyContext redundancy() {
			return getRuleContext(RedundancyContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Availability_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_availability_property; }
	}

	public final Availability_propertyContext availability_property() throws RecognitionException {
		Availability_propertyContext _localctx = new Availability_propertyContext(_ctx, getState());
		enterRule(_localctx, 440, RULE_availability_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2681);
			match(AVAILABILITY_);
			setState(2682);
			match(LPAREN);
			setState(2683);
			resource();
			setState(2684);
			match(COMMA);
			setState(2685);
			redundancy();
			setState(2686);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 442, RULE_resource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2688);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RedundancyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RedundancyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redundancy; }
	}

	public final RedundancyContext redundancy() throws RecognitionException {
		RedundancyContext _localctx = new RedundancyContext(_ctx, getState());
		enterRule(_localctx, 444, RULE_redundancy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2690);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Freshness_propertyContext extends ParserRuleContext {
		public TerminalNode FRESHNESS_() { return getToken(T4Parser.FRESHNESS_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TimestampContext timestamp() {
			return getRuleContext(TimestampContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public NonceContext nonce() {
			return getRuleContext(NonceContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Freshness_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_freshness_property; }
	}

	public final Freshness_propertyContext freshness_property() throws RecognitionException {
		Freshness_propertyContext _localctx = new Freshness_propertyContext(_ctx, getState());
		enterRule(_localctx, 446, RULE_freshness_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2692);
			match(FRESHNESS_);
			setState(2693);
			match(LPAREN);
			setState(2694);
			timestamp();
			setState(2695);
			match(COMMA);
			setState(2696);
			nonce();
			setState(2697);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimestampContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TimestampContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp; }
	}

	public final TimestampContext timestamp() throws RecognitionException {
		TimestampContext _localctx = new TimestampContext(_ctx, getState());
		enterRule(_localctx, 448, RULE_timestamp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2699);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonceContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NonceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonce; }
	}

	public final NonceContext nonce() throws RecognitionException {
		NonceContext _localctx = new NonceContext(_ctx, getState());
		enterRule(_localctx, 450, RULE_nonce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2701);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Forward_secrecy_propertyContext extends ParserRuleContext {
		public TerminalNode FORWARD_SECRECY_() { return getToken(T4Parser.FORWARD_SECRECY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Session_keyContext session_key() {
			return getRuleContext(Session_keyContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Compromise_timeContext compromise_time() {
			return getRuleContext(Compromise_timeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Forward_secrecy_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forward_secrecy_property; }
	}

	public final Forward_secrecy_propertyContext forward_secrecy_property() throws RecognitionException {
		Forward_secrecy_propertyContext _localctx = new Forward_secrecy_propertyContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_forward_secrecy_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2703);
			match(FORWARD_SECRECY_);
			setState(2704);
			match(LPAREN);
			setState(2705);
			session_key();
			setState(2706);
			match(COMMA);
			setState(2707);
			compromise_time();
			setState(2708);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Session_keyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Session_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_session_key; }
	}

	public final Session_keyContext session_key() throws RecognitionException {
		Session_keyContext _localctx = new Session_keyContext(_ctx, getState());
		enterRule(_localctx, 454, RULE_session_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2710);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compromise_timeContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Compromise_timeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compromise_time; }
	}

	public final Compromise_timeContext compromise_time() throws RecognitionException {
		Compromise_timeContext _localctx = new Compromise_timeContext(_ctx, getState());
		enterRule(_localctx, 456, RULE_compromise_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2712);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Backward_secrecy_propertyContext extends ParserRuleContext {
		public TerminalNode BACKWARD_SECRECY_() { return getToken(T4Parser.BACKWARD_SECRECY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Session_keyContext session_key() {
			return getRuleContext(Session_keyContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Compromise_timeContext compromise_time() {
			return getRuleContext(Compromise_timeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Backward_secrecy_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backward_secrecy_property; }
	}

	public final Backward_secrecy_propertyContext backward_secrecy_property() throws RecognitionException {
		Backward_secrecy_propertyContext _localctx = new Backward_secrecy_propertyContext(_ctx, getState());
		enterRule(_localctx, 458, RULE_backward_secrecy_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2714);
			match(BACKWARD_SECRECY_);
			setState(2715);
			match(LPAREN);
			setState(2716);
			session_key();
			setState(2717);
			match(COMMA);
			setState(2718);
			compromise_time();
			setState(2719);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Perfect_secrecy_propertyContext extends ParserRuleContext {
		public TerminalNode PERFECT_SECRECY_() { return getToken(T4Parser.PERFECT_SECRECY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Key_exprContext key_expr() {
			return getRuleContext(Key_exprContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public MessageContext message() {
			return getRuleContext(MessageContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Perfect_secrecy_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perfect_secrecy_property; }
	}

	public final Perfect_secrecy_propertyContext perfect_secrecy_property() throws RecognitionException {
		Perfect_secrecy_propertyContext _localctx = new Perfect_secrecy_propertyContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_perfect_secrecy_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2721);
			match(PERFECT_SECRECY_);
			setState(2722);
			match(LPAREN);
			setState(2723);
			key_expr();
			setState(2724);
			match(COMMA);
			setState(2725);
			message();
			setState(2726);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Key_exprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Key_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_expr; }
	}

	public final Key_exprContext key_expr() throws RecognitionException {
		Key_exprContext _localctx = new Key_exprContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_key_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2728);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Computational_security_propertyContext extends ParserRuleContext {
		public TerminalNode COMPUTATIONAL_SECURITY_() { return getToken(T4Parser.COMPUTATIONAL_SECURITY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public AlgorithmContext algorithm() {
			return getRuleContext(AlgorithmContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Security_parameterContext security_parameter() {
			return getRuleContext(Security_parameterContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Computational_security_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computational_security_property; }
	}

	public final Computational_security_propertyContext computational_security_property() throws RecognitionException {
		Computational_security_propertyContext _localctx = new Computational_security_propertyContext(_ctx, getState());
		enterRule(_localctx, 464, RULE_computational_security_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2730);
			match(COMPUTATIONAL_SECURITY_);
			setState(2731);
			match(LPAREN);
			setState(2732);
			algorithm();
			setState(2733);
			match(COMMA);
			setState(2734);
			security_parameter();
			setState(2735);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlgorithmContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AlgorithmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_algorithm; }
	}

	public final AlgorithmContext algorithm() throws RecognitionException {
		AlgorithmContext _localctx = new AlgorithmContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_algorithm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2737);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Security_parameterContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Security_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_security_parameter; }
	}

	public final Security_parameterContext security_parameter() throws RecognitionException {
		Security_parameterContext _localctx = new Security_parameterContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_security_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2739);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Information_theoretic_propertyContext extends ParserRuleContext {
		public TerminalNode INFORMATION_THEORETIC_() { return getToken(T4Parser.INFORMATION_THEORETIC_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public EntropyContext entropy() {
			return getRuleContext(EntropyContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Min_entropyContext min_entropy() {
			return getRuleContext(Min_entropyContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Information_theoretic_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_information_theoretic_property; }
	}

	public final Information_theoretic_propertyContext information_theoretic_property() throws RecognitionException {
		Information_theoretic_propertyContext _localctx = new Information_theoretic_propertyContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_information_theoretic_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2741);
			match(INFORMATION_THEORETIC_);
			setState(2742);
			match(LPAREN);
			setState(2743);
			entropy();
			setState(2744);
			match(COMMA);
			setState(2745);
			min_entropy();
			setState(2746);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntropyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EntropyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entropy; }
	}

	public final EntropyContext entropy() throws RecognitionException {
		EntropyContext _localctx = new EntropyContext(_ctx, getState());
		enterRule(_localctx, 472, RULE_entropy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2748);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Min_entropyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Min_entropyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min_entropy; }
	}

	public final Min_entropyContext min_entropy() throws RecognitionException {
		Min_entropyContext _localctx = new Min_entropyContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_min_entropy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2750);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compile_time_functionContext extends ParserRuleContext {
		public TerminalNode COMPILE_TIME_() { return getToken(T4Parser.COMPILE_TIME_, 0); }
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Compile_time_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compile_time_function; }
	}

	public final Compile_time_functionContext compile_time_function() throws RecognitionException {
		Compile_time_functionContext _localctx = new Compile_time_functionContext(_ctx, getState());
		enterRule(_localctx, 476, RULE_compile_time_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2752);
			match(COMPILE_TIME_);
			setState(2753);
			match(FN);
			setState(2754);
			match(IDENTIFIER);
			setState(2755);
			match(LPAREN);
			setState(2757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT || _la==IDENTIFIER || _la==REF) {
				{
				setState(2756);
				parameters();
				}
			}

			setState(2759);
			match(RPAREN);
			setState(2762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(2760);
				match(ARROW);
				setState(2761);
				return_type();
				}
			}

			setState(2764);
			match(ASSIGN);
			setState(2765);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_definitionContext extends ParserRuleContext {
		public TerminalNode MACRO_() { return getToken(T4Parser.MACRO_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public Macro_bodyContext macro_body() {
			return getRuleContext(Macro_bodyContext.class,0);
		}
		public Macro_paramsContext macro_params() {
			return getRuleContext(Macro_paramsContext.class,0);
		}
		public Macro_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_definition; }
	}

	public final Macro_definitionContext macro_definition() throws RecognitionException {
		Macro_definitionContext _localctx = new Macro_definitionContext(_ctx, getState());
		enterRule(_localctx, 478, RULE_macro_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2767);
			match(MACRO_);
			setState(2768);
			match(IDENTIFIER);
			setState(2769);
			match(LPAREN);
			setState(2771);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(2770);
				macro_params();
				}
			}

			setState(2773);
			match(RPAREN);
			setState(2774);
			match(ASSIGN);
			setState(2775);
			macro_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_paramsContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(T4Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(T4Parser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Macro_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_params; }
	}

	public final Macro_paramsContext macro_params() throws RecognitionException {
		Macro_paramsContext _localctx = new Macro_paramsContext(_ctx, getState());
		enterRule(_localctx, 480, RULE_macro_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2777);
			match(IDENTIFIER);
			setState(2782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2778);
				match(COMMA);
				setState(2779);
				match(IDENTIFIER);
				}
				}
				setState(2784);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_bodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Macro_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_body; }
	}

	public final Macro_bodyContext macro_body() throws RecognitionException {
		Macro_bodyContext _localctx = new Macro_bodyContext(_ctx, getState());
		enterRule(_localctx, 482, RULE_macro_body);
		int _la;
		try {
			setState(2794);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2785);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2786);
				match(LBRACE);
				setState(2790);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
					{
					{
					setState(2787);
					statement();
					}
					}
					setState(2792);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2793);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_invocationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode NOT() { return getToken(T4Parser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Macro_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_invocation; }
	}

	public final Macro_invocationContext macro_invocation() throws RecognitionException {
		Macro_invocationContext _localctx = new Macro_invocationContext(_ctx, getState());
		enterRule(_localctx, 484, RULE_macro_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2796);
			match(IDENTIFIER);
			setState(2797);
			match(NOT);
			setState(2798);
			match(LPAREN);
			setState(2800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(2799);
				arguments();
				}
			}

			setState(2802);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_rules_definitionContext extends ParserRuleContext {
		public TerminalNode MACRO_RULES_() { return getToken(T4Parser.MACRO_RULES_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Macro_ruleContext> macro_rule() {
			return getRuleContexts(Macro_ruleContext.class);
		}
		public Macro_ruleContext macro_rule(int i) {
			return getRuleContext(Macro_ruleContext.class,i);
		}
		public Macro_rules_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_rules_definition; }
	}

	public final Macro_rules_definitionContext macro_rules_definition() throws RecognitionException {
		Macro_rules_definitionContext _localctx = new Macro_rules_definitionContext(_ctx, getState());
		enterRule(_localctx, 486, RULE_macro_rules_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2804);
			match(MACRO_RULES_);
			setState(2805);
			match(IDENTIFIER);
			setState(2806);
			match(LBRACE);
			setState(2810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LPAREN) {
				{
				{
				setState(2807);
				macro_rule();
				}
				}
				setState(2812);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2813);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_ruleContext extends ParserRuleContext {
		public List<TerminalNode> LPAREN() { return getTokens(T4Parser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(T4Parser.LPAREN, i);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(T4Parser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(T4Parser.RPAREN, i);
		}
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public Macro_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_rule; }
	}

	public final Macro_ruleContext macro_rule() throws RecognitionException {
		Macro_ruleContext _localctx = new Macro_ruleContext(_ctx, getState());
		enterRule(_localctx, 488, RULE_macro_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2815);
			match(LPAREN);
			setState(2816);
			pattern();
			setState(2817);
			match(RPAREN);
			setState(2818);
			match(ARROW);
			setState(2819);
			match(LPAREN);
			setState(2820);
			template();
			setState(2821);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 490, RULE_template);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2823);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Syntax_extensionContext extends ParserRuleContext {
		public TerminalNode SYNTAX_() { return getToken(T4Parser.SYNTAX_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(T4Parser.ASSIGN, 0); }
		public Syntax_ruleContext syntax_rule() {
			return getRuleContext(Syntax_ruleContext.class,0);
		}
		public Syntax_extensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntax_extension; }
	}

	public final Syntax_extensionContext syntax_extension() throws RecognitionException {
		Syntax_extensionContext _localctx = new Syntax_extensionContext(_ctx, getState());
		enterRule(_localctx, 492, RULE_syntax_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2825);
			match(SYNTAX_);
			setState(2826);
			match(IDENTIFIER);
			setState(2827);
			match(ASSIGN);
			setState(2828);
			syntax_rule();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Syntax_ruleContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Syntax_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntax_rule; }
	}

	public final Syntax_ruleContext syntax_rule() throws RecognitionException {
		Syntax_ruleContext _localctx = new Syntax_ruleContext(_ctx, getState());
		enterRule(_localctx, 494, RULE_syntax_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2830);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Proc_macroContext extends ParserRuleContext {
		public TerminalNode PROC_() { return getToken(T4Parser.PROC_, 0); }
		public TerminalNode MACRO_() { return getToken(T4Parser.MACRO_, 0); }
		public TerminalNode FN() { return getToken(T4Parser.FN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode ARROW() { return getToken(T4Parser.ARROW, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Proc_macroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proc_macro; }
	}

	public final Proc_macroContext proc_macro() throws RecognitionException {
		Proc_macroContext _localctx = new Proc_macroContext(_ctx, getState());
		enterRule(_localctx, 496, RULE_proc_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2832);
			match(PROC_);
			setState(2833);
			match(MACRO_);
			setState(2834);
			match(FN);
			setState(2835);
			match(IDENTIFIER);
			setState(2836);
			match(LPAREN);
			setState(2837);
			parameters();
			setState(2838);
			match(RPAREN);
			setState(2839);
			match(ARROW);
			setState(2840);
			return_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Derive_macroContext extends ParserRuleContext {
		public TerminalNode DERIVE_() { return getToken(T4Parser.DERIVE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Trait_listContext trait_list() {
			return getRuleContext(Trait_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Derive_macroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derive_macro; }
	}

	public final Derive_macroContext derive_macro() throws RecognitionException {
		Derive_macroContext _localctx = new Derive_macroContext(_ctx, getState());
		enterRule(_localctx, 498, RULE_derive_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2842);
			match(DERIVE_);
			setState(2843);
			match(LPAREN);
			setState(2844);
			trait_list();
			setState(2845);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trait_listContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(T4Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(T4Parser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Trait_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_list; }
	}

	public final Trait_listContext trait_list() throws RecognitionException {
		Trait_listContext _localctx = new Trait_listContext(_ctx, getState());
		enterRule(_localctx, 500, RULE_trait_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2847);
			match(IDENTIFIER);
			setState(2852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2848);
				match(COMMA);
				setState(2849);
				match(IDENTIFIER);
				}
				}
				setState(2854);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attribute_macroContext extends ParserRuleContext {
		public TerminalNode ATTRIBUTE_() { return getToken(T4Parser.ATTRIBUTE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Attribute_nameContext attribute_name() {
			return getRuleContext(Attribute_nameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Attribute_macroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_macro; }
	}

	public final Attribute_macroContext attribute_macro() throws RecognitionException {
		Attribute_macroContext _localctx = new Attribute_macroContext(_ctx, getState());
		enterRule(_localctx, 502, RULE_attribute_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2855);
			match(ATTRIBUTE_);
			setState(2856);
			match(LPAREN);
			setState(2857);
			attribute_name();
			setState(2858);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attribute_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Attribute_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_name; }
	}

	public final Attribute_nameContext attribute_name() throws RecognitionException {
		Attribute_nameContext _localctx = new Attribute_nameContext(_ctx, getState());
		enterRule(_localctx, 504, RULE_attribute_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2860);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode ANNOTATION_() { return getToken(T4Parser.ANNOTATION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Annotation_nameContext annotation_name() {
			return getRuleContext(Annotation_nameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 506, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2862);
			match(ANNOTATION_);
			setState(2863);
			match(LPAREN);
			setState(2864);
			annotation_name();
			setState(2865);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Annotation_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Annotation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_name; }
	}

	public final Annotation_nameContext annotation_name() throws RecognitionException {
		Annotation_nameContext _localctx = new Annotation_nameContext(_ctx, getState());
		enterRule(_localctx, 508, RULE_annotation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2867);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecoratorContext extends ParserRuleContext {
		public TerminalNode DECORATOR_() { return getToken(T4Parser.DECORATOR_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Decorator_nameContext decorator_name() {
			return getRuleContext(Decorator_nameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public DecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorator; }
	}

	public final DecoratorContext decorator() throws RecognitionException {
		DecoratorContext _localctx = new DecoratorContext(_ctx, getState());
		enterRule(_localctx, 510, RULE_decorator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2869);
			match(DECORATOR_);
			setState(2870);
			match(LPAREN);
			setState(2871);
			decorator_name();
			setState(2872);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Decorator_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Decorator_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorator_name; }
	}

	public final Decorator_nameContext decorator_name() throws RecognitionException {
		Decorator_nameContext _localctx = new Decorator_nameContext(_ctx, getState());
		enterRule(_localctx, 512, RULE_decorator_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2874);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Meta_programmingContext extends ParserRuleContext {
		public TerminalNode META_() { return getToken(T4Parser.META_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Meta_operationContext meta_operation() {
			return getRuleContext(Meta_operationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Meta_programmingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meta_programming; }
	}

	public final Meta_programmingContext meta_programming() throws RecognitionException {
		Meta_programmingContext _localctx = new Meta_programmingContext(_ctx, getState());
		enterRule(_localctx, 514, RULE_meta_programming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2876);
			match(META_);
			setState(2877);
			match(LPAREN);
			setState(2878);
			meta_operation();
			setState(2879);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Meta_operationContext extends ParserRuleContext {
		public TerminalNode REFLECTION_() { return getToken(T4Parser.REFLECTION_, 0); }
		public TerminalNode INTROSPECTION_() { return getToken(T4Parser.INTROSPECTION_, 0); }
		public TerminalNode CODEGEN_() { return getToken(T4Parser.CODEGEN_, 0); }
		public Meta_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meta_operation; }
	}

	public final Meta_operationContext meta_operation() throws RecognitionException {
		Meta_operationContext _localctx = new Meta_operationContext(_ctx, getState());
		enterRule(_localctx, 516, RULE_meta_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2881);
			_la = _input.LA(1);
			if ( !(((((_la - 337)) & ~0x3f) == 0 && ((1L << (_la - 337)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Template_metaprogrammingContext extends ParserRuleContext {
		public TerminalNode TEMPLATE_() { return getToken(T4Parser.TEMPLATE_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Template_argsContext template_args() {
			return getRuleContext(Template_argsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Template_metaprogrammingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_metaprogramming; }
	}

	public final Template_metaprogrammingContext template_metaprogramming() throws RecognitionException {
		Template_metaprogrammingContext _localctx = new Template_metaprogrammingContext(_ctx, getState());
		enterRule(_localctx, 518, RULE_template_metaprogramming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2883);
			match(TEMPLATE_);
			setState(2884);
			match(LT);
			setState(2885);
			type_();
			setState(2886);
			match(GT);
			setState(2887);
			match(LPAREN);
			setState(2888);
			template_args();
			setState(2889);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Template_argsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Template_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_args; }
	}

	public final Template_argsContext template_args() throws RecognitionException {
		Template_argsContext _localctx = new Template_argsContext(_ctx, getState());
		enterRule(_localctx, 520, RULE_template_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2891);
			expression();
			setState(2896);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2892);
				match(COMMA);
				setState(2893);
				expression();
				}
				}
				setState(2898);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_specializationContext extends ParserRuleContext {
		public TerminalNode SPECIALIZATION_() { return getToken(T4Parser.SPECIALIZATION_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_argsContext type_args() {
			return getRuleContext(Type_argsContext.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public TerminalNode FOR() { return getToken(T4Parser.FOR, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Generic_specializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_specialization; }
	}

	public final Generic_specializationContext generic_specialization() throws RecognitionException {
		Generic_specializationContext _localctx = new Generic_specializationContext(_ctx, getState());
		enterRule(_localctx, 522, RULE_generic_specialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2899);
			match(SPECIALIZATION_);
			setState(2900);
			match(LT);
			setState(2901);
			type_args();
			setState(2902);
			match(GT);
			setState(2903);
			match(FOR);
			setState(2904);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MonomorphizationContext extends ParserRuleContext {
		public TerminalNode MONOMORPHIZATION_() { return getToken(T4Parser.MONOMORPHIZATION_, 0); }
		public TerminalNode LT() { return getToken(T4Parser.LT, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(T4Parser.GT, 0); }
		public MonomorphizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monomorphization; }
	}

	public final MonomorphizationContext monomorphization() throws RecognitionException {
		MonomorphizationContext _localctx = new MonomorphizationContext(_ctx, getState());
		enterRule(_localctx, 524, RULE_monomorphization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2906);
			match(MONOMORPHIZATION_);
			setState(2907);
			match(LT);
			setState(2908);
			type_();
			setState(2909);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Const_evaluationContext extends ParserRuleContext {
		public TerminalNode CONST_EVAL_() { return getToken(T4Parser.CONST_EVAL_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Const_evaluationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_evaluation; }
	}

	public final Const_evaluationContext const_evaluation() throws RecognitionException {
		Const_evaluationContext _localctx = new Const_evaluationContext(_ctx, getState());
		enterRule(_localctx, 526, RULE_const_evaluation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2911);
			match(CONST_EVAL_);
			setState(2912);
			match(LPAREN);
			setState(2913);
			expression();
			setState(2914);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Static_analysisContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(T4Parser.STATIC, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<Analysis_directiveContext> analysis_directive() {
			return getRuleContexts(Analysis_directiveContext.class);
		}
		public Analysis_directiveContext analysis_directive(int i) {
			return getRuleContext(Analysis_directiveContext.class,i);
		}
		public Static_analysisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_analysis; }
	}

	public final Static_analysisContext static_analysis() throws RecognitionException {
		Static_analysisContext _localctx = new Static_analysisContext(_ctx, getState());
		enterRule(_localctx, 528, RULE_static_analysis);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2916);
			match(STATIC);
			setState(2917);
			match(LBRACE);
			setState(2921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 350)) & ~0x3f) == 0 && ((1L << (_la - 350)) & 63L) != 0)) {
				{
				{
				setState(2918);
				analysis_directive();
				}
				}
				setState(2923);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2924);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Analysis_directiveContext extends ParserRuleContext {
		public TerminalNode DEBUG_() { return getToken(T4Parser.DEBUG_, 0); }
		public TerminalNode RELEASE_() { return getToken(T4Parser.RELEASE_, 0); }
		public TerminalNode TEST_() { return getToken(T4Parser.TEST_, 0); }
		public TerminalNode BENCH_() { return getToken(T4Parser.BENCH_, 0); }
		public TerminalNode DOC_() { return getToken(T4Parser.DOC_, 0); }
		public TerminalNode EXAMPLE_() { return getToken(T4Parser.EXAMPLE_, 0); }
		public Analysis_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_analysis_directive; }
	}

	public final Analysis_directiveContext analysis_directive() throws RecognitionException {
		Analysis_directiveContext _localctx = new Analysis_directiveContext(_ctx, getState());
		enterRule(_localctx, 530, RULE_analysis_directive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2926);
			_la = _input.LA(1);
			if ( !(((((_la - 350)) & ~0x3f) == 0 && ((1L << (_la - 350)) & 63L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Conditional_compilationContext extends ParserRuleContext {
		public TerminalNode CFG_() { return getToken(T4Parser.CFG_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public Conditional_compilationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_compilation; }
	}

	public final Conditional_compilationContext conditional_compilation() throws RecognitionException {
		Conditional_compilationContext _localctx = new Conditional_compilationContext(_ctx, getState());
		enterRule(_localctx, 532, RULE_conditional_compilation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2928);
			match(CFG_);
			setState(2929);
			match(LPAREN);
			setState(2930);
			condition();
			setState(2931);
			match(RPAREN);
			setState(2932);
			match(LBRACE);
			setState(2936);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536935600L) != 0) || _la==CONFIG_ || _la==EXTERN_) {
				{
				{
				setState(2933);
				declaration();
				}
				}
				setState(2938);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2939);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 534, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2941);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Feature_gateContext extends ParserRuleContext {
		public TerminalNode FEATURE_() { return getToken(T4Parser.FEATURE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Feature_nameContext feature_name() {
			return getRuleContext(Feature_nameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Feature_gateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_gate; }
	}

	public final Feature_gateContext feature_gate() throws RecognitionException {
		Feature_gateContext _localctx = new Feature_gateContext(_ctx, getState());
		enterRule(_localctx, 536, RULE_feature_gate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2943);
			match(FEATURE_);
			setState(2944);
			match(LPAREN);
			setState(2945);
			feature_name();
			setState(2946);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Feature_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Feature_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_name; }
	}

	public final Feature_nameContext feature_name() throws RecognitionException {
		Feature_nameContext _localctx = new Feature_nameContext(_ctx, getState());
		enterRule(_localctx, 538, RULE_feature_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2948);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Property_accessContext extends ParserRuleContext {
		public TerminalNode PROPERTY_() { return getToken(T4Parser.PROPERTY_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Property_nameContext property_name() {
			return getRuleContext(Property_nameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Property_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property_access; }
	}

	public final Property_accessContext property_access() throws RecognitionException {
		Property_accessContext _localctx = new Property_accessContext(_ctx, getState());
		enterRule(_localctx, 540, RULE_property_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2950);
			match(PROPERTY_);
			setState(2951);
			match(LPAREN);
			setState(2952);
			expression();
			setState(2953);
			match(COMMA);
			setState(2954);
			property_name();
			setState(2955);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Property_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public Property_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property_name; }
	}

	public final Property_nameContext property_name() throws RecognitionException {
		Property_nameContext _localctx = new Property_nameContext(_ctx, getState());
		enterRule(_localctx, 542, RULE_property_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2957);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Computed_propertyContext extends ParserRuleContext {
		public TerminalNode COMPUTED_() { return getToken(T4Parser.COMPUTED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Computed_index_exprContext computed_index_expr() {
			return getRuleContext(Computed_index_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Computed_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computed_property; }
	}

	public final Computed_propertyContext computed_property() throws RecognitionException {
		Computed_propertyContext _localctx = new Computed_propertyContext(_ctx, getState());
		enterRule(_localctx, 544, RULE_computed_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2959);
			match(COMPUTED_);
			setState(2960);
			match(LPAREN);
			setState(2961);
			expression();
			setState(2962);
			match(COMMA);
			setState(2963);
			computed_index_expr();
			setState(2964);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Computed_index_exprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Computed_index_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computed_index_expr; }
	}

	public final Computed_index_exprContext computed_index_expr() throws RecognitionException {
		Computed_index_exprContext _localctx = new Computed_index_exprContext(_ctx, getState());
		enterRule(_localctx, 546, RULE_computed_index_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2966);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Chained_expressionContext extends ParserRuleContext {
		public TerminalNode CHAINED_() { return getToken(T4Parser.CHAINED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<TerminalNode> DOT() { return getTokens(T4Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(T4Parser.DOT, i);
		}
		public List<Method_callContext> method_call() {
			return getRuleContexts(Method_callContext.class);
		}
		public Method_callContext method_call(int i) {
			return getRuleContext(Method_callContext.class,i);
		}
		public Chained_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chained_expression; }
	}

	public final Chained_expressionContext chained_expression() throws RecognitionException {
		Chained_expressionContext _localctx = new Chained_expressionContext(_ctx, getState());
		enterRule(_localctx, 548, RULE_chained_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2968);
			match(CHAINED_);
			setState(2969);
			match(LPAREN);
			setState(2970);
			expression();
			setState(2975);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(2971);
				match(DOT);
				setState(2972);
				method_call();
				}
				}
				setState(2977);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2978);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(T4Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 550, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2980);
			match(IDENTIFIER);
			setState(2981);
			match(LPAREN);
			setState(2983);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447003465728L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287796624262143L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==MOVE) {
				{
				setState(2982);
				arguments();
				}
			}

			setState(2985);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pipeline_exprContext extends ParserRuleContext {
		public TerminalNode PIPELINE_() { return getToken(T4Parser.PIPELINE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public List<TerminalNode> PIPE_() { return getTokens(T4Parser.PIPE_); }
		public TerminalNode PIPE_(int i) {
			return getToken(T4Parser.PIPE_, i);
		}
		public List<Pipeline_opContext> pipeline_op() {
			return getRuleContexts(Pipeline_opContext.class);
		}
		public Pipeline_opContext pipeline_op(int i) {
			return getRuleContext(Pipeline_opContext.class,i);
		}
		public Pipeline_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline_expr; }
	}

	public final Pipeline_exprContext pipeline_expr() throws RecognitionException {
		Pipeline_exprContext _localctx = new Pipeline_exprContext(_ctx, getState());
		enterRule(_localctx, 552, RULE_pipeline_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2987);
			match(PIPELINE_);
			setState(2988);
			match(LPAREN);
			setState(2989);
			expression();
			setState(2994);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE_) {
				{
				{
				setState(2990);
				match(PIPE_);
				setState(2991);
				pipeline_op();
				}
				}
				setState(2996);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2997);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pipeline_opContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Pipeline_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline_op; }
	}

	public final Pipeline_opContext pipeline_op() throws RecognitionException {
		Pipeline_opContext _localctx = new Pipeline_opContext(_ctx, getState());
		enterRule(_localctx, 554, RULE_pipeline_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2999);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Composition_expressionContext extends ParserRuleContext {
		public TerminalNode COMPOSITION_() { return getToken(T4Parser.COMPOSITION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Composition_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composition_expression; }
	}

	public final Composition_expressionContext composition_expression() throws RecognitionException {
		Composition_expressionContext _localctx = new Composition_expressionContext(_ctx, getState());
		enterRule(_localctx, 556, RULE_composition_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3001);
			match(COMPOSITION_);
			setState(3002);
			match(LPAREN);
			setState(3003);
			expression();
			setState(3004);
			match(COMMA);
			setState(3005);
			expression();
			setState(3006);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Partial_app_exprContext extends ParserRuleContext {
		public TerminalNode PARTIAL_APP_() { return getToken(T4Parser.PARTIAL_APP_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(T4Parser.COMMA, 0); }
		public Partial_app_argsContext partial_app_args() {
			return getRuleContext(Partial_app_argsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Partial_app_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partial_app_expr; }
	}

	public final Partial_app_exprContext partial_app_expr() throws RecognitionException {
		Partial_app_exprContext _localctx = new Partial_app_exprContext(_ctx, getState());
		enterRule(_localctx, 558, RULE_partial_app_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3008);
			match(PARTIAL_APP_);
			setState(3009);
			match(LPAREN);
			setState(3010);
			expression();
			setState(3011);
			match(COMMA);
			setState(3012);
			partial_app_args();
			setState(3013);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Partial_app_argsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(T4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(T4Parser.COMMA, i);
		}
		public Partial_app_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partial_app_args; }
	}

	public final Partial_app_argsContext partial_app_args() throws RecognitionException {
		Partial_app_argsContext _localctx = new Partial_app_argsContext(_ctx, getState());
		enterRule(_localctx, 560, RULE_partial_app_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3015);
			expression();
			setState(3020);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3016);
				match(COMMA);
				setState(3017);
				expression();
				}
				}
				setState(3022);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Currying_expressionContext extends ParserRuleContext {
		public TerminalNode CURRYING_() { return getToken(T4Parser.CURRYING_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Multi_arg_functionContext multi_arg_function() {
			return getRuleContext(Multi_arg_functionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Currying_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_currying_expression; }
	}

	public final Currying_expressionContext currying_expression() throws RecognitionException {
		Currying_expressionContext _localctx = new Currying_expressionContext(_ctx, getState());
		enterRule(_localctx, 562, RULE_currying_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3023);
			match(CURRYING_);
			setState(3024);
			match(LPAREN);
			setState(3025);
			multi_arg_function();
			setState(3026);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multi_arg_functionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Multi_arg_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_arg_function; }
	}

	public final Multi_arg_functionContext multi_arg_function() throws RecognitionException {
		Multi_arg_functionContext _localctx = new Multi_arg_functionContext(_ctx, getState());
		enterRule(_localctx, 564, RULE_multi_arg_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3028);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lazy_evaluationContext extends ParserRuleContext {
		public TerminalNode LAZY_EVAL_() { return getToken(T4Parser.LAZY_EVAL_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Lazy_evaluationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lazy_evaluation; }
	}

	public final Lazy_evaluationContext lazy_evaluation() throws RecognitionException {
		Lazy_evaluationContext _localctx = new Lazy_evaluationContext(_ctx, getState());
		enterRule(_localctx, 566, RULE_lazy_evaluation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3030);
			match(LAZY_EVAL_);
			setState(3031);
			match(LPAREN);
			setState(3032);
			expression();
			setState(3033);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Strict_evaluationContext extends ParserRuleContext {
		public TerminalNode STRICT_EVAL_() { return getToken(T4Parser.STRICT_EVAL_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Strict_evaluationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strict_evaluation; }
	}

	public final Strict_evaluationContext strict_evaluation() throws RecognitionException {
		Strict_evaluationContext _localctx = new Strict_evaluationContext(_ctx, getState());
		enterRule(_localctx, 568, RULE_strict_evaluation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3035);
			match(STRICT_EVAL_);
			setState(3036);
			match(LPAREN);
			setState(3037);
			expression();
			setState(3038);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemoizationContext extends ParserRuleContext {
		public TerminalNode MEMOIZATION_() { return getToken(T4Parser.MEMOIZATION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public MemoizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memoization; }
	}

	public final MemoizationContext memoization() throws RecognitionException {
		MemoizationContext _localctx = new MemoizationContext(_ctx, getState());
		enterRule(_localctx, 570, RULE_memoization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3040);
			match(MEMOIZATION_);
			setState(3041);
			match(LPAREN);
			setState(3042);
			expression();
			setState(3043);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Caching_expressionContext extends ParserRuleContext {
		public TerminalNode CACHING_() { return getToken(T4Parser.CACHING_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Caching_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caching_expression; }
	}

	public final Caching_expressionContext caching_expression() throws RecognitionException {
		Caching_expressionContext _localctx = new Caching_expressionContext(_ctx, getState());
		enterRule(_localctx, 572, RULE_caching_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3045);
			match(CACHING_);
			setState(3046);
			match(LPAREN);
			setState(3047);
			expression();
			setState(3048);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parallel_computationContext extends ParserRuleContext {
		public TerminalNode PARALLEL_() { return getToken(T4Parser.PARALLEL_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Parallel_computationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parallel_computation; }
	}

	public final Parallel_computationContext parallel_computation() throws RecognitionException {
		Parallel_computationContext _localctx = new Parallel_computationContext(_ctx, getState());
		enterRule(_localctx, 574, RULE_parallel_computation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3050);
			match(PARALLEL_);
			setState(3051);
			match(LPAREN);
			setState(3052);
			expression();
			setState(3053);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Concurrent_expressionContext extends ParserRuleContext {
		public TerminalNode CONCURRENT_() { return getToken(T4Parser.CONCURRENT_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Concurrent_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concurrent_expression; }
	}

	public final Concurrent_expressionContext concurrent_expression() throws RecognitionException {
		Concurrent_expressionContext _localctx = new Concurrent_expressionContext(_ctx, getState());
		enterRule(_localctx, 576, RULE_concurrent_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3055);
			match(CONCURRENT_);
			setState(3056);
			match(LPAREN);
			setState(3057);
			expression();
			setState(3058);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Atomic_operationContext extends ParserRuleContext {
		public TerminalNode ATOMIC_() { return getToken(T4Parser.ATOMIC_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Atomic_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic_operation; }
	}

	public final Atomic_operationContext atomic_operation() throws RecognitionException {
		Atomic_operationContext _localctx = new Atomic_operationContext(_ctx, getState());
		enterRule(_localctx, 578, RULE_atomic_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3060);
			match(ATOMIC_);
			setState(3061);
			match(LPAREN);
			setState(3062);
			expression();
			setState(3063);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Synchronized_blockContext extends ParserRuleContext {
		public TerminalNode SYNCHRONIZED_() { return getToken(T4Parser.SYNCHRONIZED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public LockContext lock() {
			return getRuleContext(LockContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(T4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(T4Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Synchronized_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronized_block; }
	}

	public final Synchronized_blockContext synchronized_block() throws RecognitionException {
		Synchronized_blockContext _localctx = new Synchronized_blockContext(_ctx, getState());
		enterRule(_localctx, 580, RULE_synchronized_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3065);
			match(SYNCHRONIZED_);
			setState(3066);
			match(LPAREN);
			setState(3067);
			lock();
			setState(3068);
			match(RPAREN);
			setState(3069);
			match(LBRACE);
			setState(3073);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903447404087552L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 47287797039498239L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 6755399441055763L) != 0) || _la==EARLY_RETURN_ || _la==MOVE) {
				{
				{
				setState(3070);
				statement();
				}
				}
				setState(3075);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3076);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LockContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lock; }
	}

	public final LockContext lock() throws RecognitionException {
		LockContext _localctx = new LockContext(_ctx, getState());
		enterRule(_localctx, 582, RULE_lock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3078);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Volatile_accessContext extends ParserRuleContext {
		public TerminalNode VOLATILE_() { return getToken(T4Parser.VOLATILE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Volatile_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_volatile_access; }
	}

	public final Volatile_accessContext volatile_access() throws RecognitionException {
		Volatile_accessContext _localctx = new Volatile_accessContext(_ctx, getState());
		enterRule(_localctx, 584, RULE_volatile_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3080);
			match(VOLATILE_);
			setState(3081);
			match(LPAREN);
			setState(3082);
			expression();
			setState(3083);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Immutable_valueContext extends ParserRuleContext {
		public TerminalNode IMMUTABLE_() { return getToken(T4Parser.IMMUTABLE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Immutable_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_immutable_value; }
	}

	public final Immutable_valueContext immutable_value() throws RecognitionException {
		Immutable_valueContext _localctx = new Immutable_valueContext(_ctx, getState());
		enterRule(_localctx, 586, RULE_immutable_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3085);
			match(IMMUTABLE_);
			setState(3086);
			match(LPAREN);
			setState(3087);
			expression();
			setState(3088);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mutable_referenceContext extends ParserRuleContext {
		public TerminalNode MUTABLE_() { return getToken(T4Parser.MUTABLE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Mutable_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutable_reference; }
	}

	public final Mutable_referenceContext mutable_reference() throws RecognitionException {
		Mutable_referenceContext _localctx = new Mutable_referenceContext(_ctx, getState());
		enterRule(_localctx, 588, RULE_mutable_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3090);
			match(MUTABLE_);
			setState(3091);
			match(LPAREN);
			setState(3092);
			expression();
			setState(3093);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Shared_referenceContext extends ParserRuleContext {
		public TerminalNode SHARED_() { return getToken(T4Parser.SHARED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Shared_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shared_reference; }
	}

	public final Shared_referenceContext shared_reference() throws RecognitionException {
		Shared_referenceContext _localctx = new Shared_referenceContext(_ctx, getState());
		enterRule(_localctx, 590, RULE_shared_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3095);
			match(SHARED_);
			setState(3096);
			match(LPAREN);
			setState(3097);
			expression();
			setState(3098);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Owned_valueContext extends ParserRuleContext {
		public TerminalNode OWNED_() { return getToken(T4Parser.OWNED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Owned_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_owned_value; }
	}

	public final Owned_valueContext owned_value() throws RecognitionException {
		Owned_valueContext _localctx = new Owned_valueContext(_ctx, getState());
		enterRule(_localctx, 592, RULE_owned_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3100);
			match(OWNED_);
			setState(3101);
			match(LPAREN);
			setState(3102);
			expression();
			setState(3103);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Borrowed_referenceContext extends ParserRuleContext {
		public TerminalNode BORROWED_() { return getToken(T4Parser.BORROWED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Borrowed_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_borrowed_reference; }
	}

	public final Borrowed_referenceContext borrowed_reference() throws RecognitionException {
		Borrowed_referenceContext _localctx = new Borrowed_referenceContext(_ctx, getState());
		enterRule(_localctx, 594, RULE_borrowed_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3105);
			match(BORROWED_);
			setState(3106);
			match(LPAREN);
			setState(3107);
			expression();
			setState(3108);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lifetime_annotationContext extends ParserRuleContext {
		public TerminalNode LIFETIME_() { return getToken(T4Parser.LIFETIME_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Lifetime_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lifetime_annotation; }
	}

	public final Lifetime_annotationContext lifetime_annotation() throws RecognitionException {
		Lifetime_annotationContext _localctx = new Lifetime_annotationContext(_ctx, getState());
		enterRule(_localctx, 596, RULE_lifetime_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3110);
			match(LIFETIME_);
			setState(3111);
			match(LPAREN);
			setState(3112);
			expression();
			setState(3113);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scope_expressionContext extends ParserRuleContext {
		public TerminalNode SCOPE_() { return getToken(T4Parser.SCOPE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Scope_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope_expression; }
	}

	public final Scope_expressionContext scope_expression() throws RecognitionException {
		Scope_expressionContext _localctx = new Scope_expressionContext(_ctx, getState());
		enterRule(_localctx, 598, RULE_scope_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3115);
			match(SCOPE_);
			setState(3116);
			match(LPAREN);
			setState(3117);
			expression();
			setState(3118);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Region_expressionContext extends ParserRuleContext {
		public TerminalNode REGION_() { return getToken(T4Parser.REGION_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Region_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_region_expression; }
	}

	public final Region_expressionContext region_expression() throws RecognitionException {
		Region_expressionContext _localctx = new Region_expressionContext(_ctx, getState());
		enterRule(_localctx, 600, RULE_region_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3120);
			match(REGION_);
			setState(3121);
			match(LPAREN);
			setState(3122);
			expression();
			setState(3123);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arena_allocationContext extends ParserRuleContext {
		public TerminalNode ARENA_() { return getToken(T4Parser.ARENA_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Arena_allocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arena_allocation; }
	}

	public final Arena_allocationContext arena_allocation() throws RecognitionException {
		Arena_allocationContext _localctx = new Arena_allocationContext(_ctx, getState());
		enterRule(_localctx, 602, RULE_arena_allocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3125);
			match(ARENA_);
			setState(3126);
			match(LPAREN);
			setState(3127);
			expression();
			setState(3128);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Bump_allocationContext extends ParserRuleContext {
		public TerminalNode BUMP_() { return getToken(T4Parser.BUMP_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Bump_allocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bump_allocation; }
	}

	public final Bump_allocationContext bump_allocation() throws RecognitionException {
		Bump_allocationContext _localctx = new Bump_allocationContext(_ctx, getState());
		enterRule(_localctx, 604, RULE_bump_allocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3130);
			match(BUMP_);
			setState(3131);
			match(LPAREN);
			setState(3132);
			expression();
			setState(3133);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trace_expressionContext extends ParserRuleContext {
		public TerminalNode TRACE_() { return getToken(T4Parser.TRACE_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Trace_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trace_expression; }
	}

	public final Trace_expressionContext trace_expression() throws RecognitionException {
		Trace_expressionContext _localctx = new Trace_expressionContext(_ctx, getState());
		enterRule(_localctx, 606, RULE_trace_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3135);
			match(TRACE_);
			setState(3136);
			match(LPAREN);
			setState(3137);
			expression();
			setState(3138);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Garbage_collectionContext extends ParserRuleContext {
		public TerminalNode GC_() { return getToken(T4Parser.GC_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public Collection_strategyContext collection_strategy() {
			return getRuleContext(Collection_strategyContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Garbage_collectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_garbage_collection; }
	}

	public final Garbage_collectionContext garbage_collection() throws RecognitionException {
		Garbage_collectionContext _localctx = new Garbage_collectionContext(_ctx, getState());
		enterRule(_localctx, 608, RULE_garbage_collection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3140);
			match(GC_);
			setState(3141);
			match(LPAREN);
			setState(3142);
			collection_strategy();
			setState(3143);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Collection_strategyContext extends ParserRuleContext {
		public TerminalNode RC_() { return getToken(T4Parser.RC_, 0); }
		public TerminalNode ARC_() { return getToken(T4Parser.ARC_, 0); }
		public Collection_strategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection_strategy; }
	}

	public final Collection_strategyContext collection_strategy() throws RecognitionException {
		Collection_strategyContext _localctx = new Collection_strategyContext(_ctx, getState());
		enterRule(_localctx, 610, RULE_collection_strategy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3145);
			_la = _input.LA(1);
			if ( !(_la==RC_ || _la==ARC_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pinned_memoryContext extends ParserRuleContext {
		public TerminalNode PINNED_() { return getToken(T4Parser.PINNED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Pinned_memoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pinned_memory; }
	}

	public final Pinned_memoryContext pinned_memory() throws RecognitionException {
		Pinned_memoryContext _localctx = new Pinned_memoryContext(_ctx, getState());
		enterRule(_localctx, 612, RULE_pinned_memory);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3147);
			match(PINNED_);
			setState(3148);
			match(LPAREN);
			setState(3149);
			expression();
			setState(3150);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unpinned_memoryContext extends ParserRuleContext {
		public TerminalNode UNPINNED_() { return getToken(T4Parser.UNPINNED_, 0); }
		public TerminalNode LPAREN() { return getToken(T4Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(T4Parser.RPAREN, 0); }
		public Unpinned_memoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpinned_memory; }
	}

	public final Unpinned_memoryContext unpinned_memory() throws RecognitionException {
		Unpinned_memoryContext _localctx = new Unpinned_memoryContext(_ctx, getState());
		enterRule(_localctx, 614, RULE_unpinned_memory);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3152);
			match(UNPINNED_);
			setState(3153);
			match(LPAREN);
			setState(3154);
			expression();
			setState(3155);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 59:
			return binary_expression_sempred((Binary_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean binary_expression_sempred(Binary_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	private static final String _serializedATNSegment0 =
		"\u0004\u0001\u019d\u0c56\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"+
		"\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"+
		"\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"+
		"\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007"+
		"\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007"+
		"\u008f\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091\u0002\u0092\u0007"+
		"\u0092\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094\u0002\u0095\u0007"+
		"\u0095\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097\u0002\u0098\u0007"+
		"\u0098\u0002\u0099\u0007\u0099\u0002\u009a\u0007\u009a\u0002\u009b\u0007"+
		"\u009b\u0002\u009c\u0007\u009c\u0002\u009d\u0007\u009d\u0002\u009e\u0007"+
		"\u009e\u0002\u009f\u0007\u009f\u0002\u00a0\u0007\u00a0\u0002\u00a1\u0007"+
		"\u00a1\u0002\u00a2\u0007\u00a2\u0002\u00a3\u0007\u00a3\u0002\u00a4\u0007"+
		"\u00a4\u0002\u00a5\u0007\u00a5\u0002\u00a6\u0007\u00a6\u0002\u00a7\u0007"+
		"\u00a7\u0002\u00a8\u0007\u00a8\u0002\u00a9\u0007\u00a9\u0002\u00aa\u0007"+
		"\u00aa\u0002\u00ab\u0007\u00ab\u0002\u00ac\u0007\u00ac\u0002\u00ad\u0007"+
		"\u00ad\u0002\u00ae\u0007\u00ae\u0002\u00af\u0007\u00af\u0002\u00b0\u0007"+
		"\u00b0\u0002\u00b1\u0007\u00b1\u0002\u00b2\u0007\u00b2\u0002\u00b3\u0007"+
		"\u00b3\u0002\u00b4\u0007\u00b4\u0002\u00b5\u0007\u00b5\u0002\u00b6\u0007"+
		"\u00b6\u0002\u00b7\u0007\u00b7\u0002\u00b8\u0007\u00b8\u0002\u00b9\u0007"+
		"\u00b9\u0002\u00ba\u0007\u00ba\u0002\u00bb\u0007\u00bb\u0002\u00bc\u0007"+
		"\u00bc\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be\u0002\u00bf\u0007"+
		"\u00bf\u0002\u00c0\u0007\u00c0\u0002\u00c1\u0007\u00c1\u0002\u00c2\u0007"+
		"\u00c2\u0002\u00c3\u0007\u00c3\u0002\u00c4\u0007\u00c4\u0002\u00c5\u0007"+
		"\u00c5\u0002\u00c6\u0007\u00c6\u0002\u00c7\u0007\u00c7\u0002\u00c8\u0007"+
		"\u00c8\u0002\u00c9\u0007\u00c9\u0002\u00ca\u0007\u00ca\u0002\u00cb\u0007"+
		"\u00cb\u0002\u00cc\u0007\u00cc\u0002\u00cd\u0007\u00cd\u0002\u00ce\u0007"+
		"\u00ce\u0002\u00cf\u0007\u00cf\u0002\u00d0\u0007\u00d0\u0002\u00d1\u0007"+
		"\u00d1\u0002\u00d2\u0007\u00d2\u0002\u00d3\u0007\u00d3\u0002\u00d4\u0007"+
		"\u00d4\u0002\u00d5\u0007\u00d5\u0002\u00d6\u0007\u00d6\u0002\u00d7\u0007"+
		"\u00d7\u0002\u00d8\u0007\u00d8\u0002\u00d9\u0007\u00d9\u0002\u00da\u0007"+
		"\u00da\u0002\u00db\u0007\u00db\u0002\u00dc\u0007\u00dc\u0002\u00dd\u0007"+
		"\u00dd\u0002\u00de\u0007\u00de\u0002\u00df\u0007\u00df\u0002\u00e0\u0007"+
		"\u00e0\u0002\u00e1\u0007\u00e1\u0002\u00e2\u0007\u00e2\u0002\u00e3\u0007"+
		"\u00e3\u0002\u00e4\u0007\u00e4\u0002\u00e5\u0007\u00e5\u0002\u00e6\u0007"+
		"\u00e6\u0002\u00e7\u0007\u00e7\u0002\u00e8\u0007\u00e8\u0002\u00e9\u0007"+
		"\u00e9\u0002\u00ea\u0007\u00ea\u0002\u00eb\u0007\u00eb\u0002\u00ec\u0007"+
		"\u00ec\u0002\u00ed\u0007\u00ed\u0002\u00ee\u0007\u00ee\u0002\u00ef\u0007"+
		"\u00ef\u0002\u00f0\u0007\u00f0\u0002\u00f1\u0007\u00f1\u0002\u00f2\u0007"+
		"\u00f2\u0002\u00f3\u0007\u00f3\u0002\u00f4\u0007\u00f4\u0002\u00f5\u0007"+
		"\u00f5\u0002\u00f6\u0007\u00f6\u0002\u00f7\u0007\u00f7\u0002\u00f8\u0007"+
		"\u00f8\u0002\u00f9\u0007\u00f9\u0002\u00fa\u0007\u00fa\u0002\u00fb\u0007"+
		"\u00fb\u0002\u00fc\u0007\u00fc\u0002\u00fd\u0007\u00fd\u0002\u00fe\u0007"+
		"\u00fe\u0002\u00ff\u0007\u00ff\u0002\u0100\u0007\u0100\u0002\u0101\u0007"+
		"\u0101\u0002\u0102\u0007\u0102\u0002\u0103\u0007\u0103\u0002\u0104\u0007"+
		"\u0104\u0002\u0105\u0007\u0105\u0002\u0106\u0007\u0106\u0002\u0107\u0007"+
		"\u0107\u0002\u0108\u0007\u0108\u0002\u0109\u0007\u0109\u0002\u010a\u0007"+
		"\u010a\u0002\u010b\u0007\u010b\u0002\u010c\u0007\u010c\u0002\u010d\u0007"+
		"\u010d\u0002\u010e\u0007\u010e\u0002\u010f\u0007\u010f\u0002\u0110\u0007"+
		"\u0110\u0002\u0111\u0007\u0111\u0002\u0112\u0007\u0112\u0002\u0113\u0007"+
		"\u0113\u0002\u0114\u0007\u0114\u0002\u0115\u0007\u0115\u0002\u0116\u0007"+
		"\u0116\u0002\u0117\u0007\u0117\u0002\u0118\u0007\u0118\u0002\u0119\u0007"+
		"\u0119\u0002\u011a\u0007\u011a\u0002\u011b\u0007\u011b\u0002\u011c\u0007"+
		"\u011c\u0002\u011d\u0007\u011d\u0002\u011e\u0007\u011e\u0002\u011f\u0007"+
		"\u011f\u0002\u0120\u0007\u0120\u0002\u0121\u0007\u0121\u0002\u0122\u0007"+
		"\u0122\u0002\u0123\u0007\u0123\u0002\u0124\u0007\u0124\u0002\u0125\u0007"+
		"\u0125\u0002\u0126\u0007\u0126\u0002\u0127\u0007\u0127\u0002\u0128\u0007"+
		"\u0128\u0002\u0129\u0007\u0129\u0002\u012a\u0007\u012a\u0002\u012b\u0007"+
		"\u012b\u0002\u012c\u0007\u012c\u0002\u012d\u0007\u012d\u0002\u012e\u0007"+
		"\u012e\u0002\u012f\u0007\u012f\u0002\u0130\u0007\u0130\u0002\u0131\u0007"+
		"\u0131\u0002\u0132\u0007\u0132\u0002\u0133\u0007\u0133\u0001\u0000\u0005"+
		"\u0000\u026a\b\u0000\n\u0000\f\u0000\u026d\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u027d\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u0283\b\u0002\n\u0002\f\u0002\u0286\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u028e"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u0295\b\u0004\n\u0004\f\u0004\u0298\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u02ad\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u02b3\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u02b7\b\u0006\n\u0006"+
		"\f\u0006\u02ba\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u02c2\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u02c7\b\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0003\b\u02ce\b\b\u0001\b\u0001\b\u0003\b\u02d2\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u02d7\b\b\u0001\b\u0003\b\u02da\b\b\u0001\b"+
		"\u0001\b\u0005\b\u02de\b\b\n\b\f\b\u02e1\t\b\u0001\b\u0001\b\u0003\b\u02e5"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u02f2\b\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0320"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u032e\b\f\u0001\r\u0001\r\u0003"+
		"\r\u0332\b\r\u0001\r\u0001\r\u0003\r\u0336\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u033c\b\u000e\n\u000e\f\u000e\u033f"+
		"\t\u000e\u0003\u000e\u0341\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0359\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u035e\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0368\b\u0015"+
		"\n\u0015\f\u0015\u036b\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u0371\b\u0016\n\u0016\f\u0016\u0374\t\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u037d\b\u0017\n\u0017\f\u0017\u0380\t\u0017\u0003\u0017\u0382"+
		"\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0387\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u038d\b\u0018"+
		"\n\u0018\f\u0018\u0390\t\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0394"+
		"\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u039a"+
		"\b\u0019\n\u0019\f\u0019\u039d\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u03a4\b\u001a\n\u001a\f\u001a\u03a7"+
		"\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u03ac\b\u001b"+
		"\n\u001b\f\u001b\u03af\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u03b5\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u03c0\b\u001d\n\u001d\f\u001d\u03c3\t\u001d\u0003\u001d\u03c5\b"+
		"\u001d\u0001\u001d\u0003\u001d\u03c8\b\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u03cd\b\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u03d1"+
		"\b\u001e\u0001\u001e\u0003\u001e\u03d4\b\u001e\u0001\u001e\u0003\u001e"+
		"\u03d7\b\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u03db\b\u001e\n\u001e"+
		"\f\u001e\u03de\t\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u03e2\b\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u03e7\b\u001f\n\u001f"+
		"\f\u001f\u03ea\t\u001f\u0001 \u0003 \u03ed\b \u0001 \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0003!\u03f6\b!\u0001!\u0003!\u03f9\b!\u0001!\u0001"+
		"!\u0005!\u03fd\b!\n!\f!\u0400\t!\u0001!\u0001!\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0005\"\u0409\b\"\n\"\f\"\u040c\t\"\u0003\"\u040e\b\""+
		"\u0001\"\u0003\"\u0411\b\"\u0001#\u0001#\u0001#\u0003#\u0416\b#\u0001"+
		"#\u0003#\u0419\b#\u0001#\u0001#\u0005#\u041d\b#\n#\f#\u0420\t#\u0001#"+
		"\u0001#\u0001$\u0001$\u0001$\u0003$\u0427\b$\u0001%\u0001%\u0003%\u042b"+
		"\b%\u0001%\u0001%\u0003%\u042f\b%\u0001%\u0001%\u0001%\u0001%\u0005%\u0435"+
		"\b%\n%\f%\u0438\t%\u0001%\u0001%\u0001&\u0001&\u0001&\u0003&\u043f\b&"+
		"\u0001\'\u0001\'\u0001\'\u0003\'\u0444\b\'\u0001\'\u0003\'\u0447\b\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001)\u0001)\u0003)\u0457\b)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u046e\b*\u0001+\u0001"+
		"+\u0003+\u0472\b+\u0001+\u0001+\u0001+\u0003+\u0477\b+\u0001+\u0001+\u0003"+
		"+\u047b\b+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001.\u0001.\u0003.\u0489\b.\u0001.\u0001.\u0001/\u0001/\u0003"+
		"/\u048f\b/\u0001/\u0001/\u00010\u00010\u00010\u00011\u00011\u00011\u0001"+
		"1\u00051\u049a\b1\n1\f1\u049d\t1\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00051\u04a5\b1\n1\f1\u04a8\t1\u00011\u00011\u00051\u04ac\b1\n1\f1\u04af"+
		"\t1\u00011\u00011\u00011\u00051\u04b4\b1\n1\f1\u04b7\t1\u00011\u00031"+
		"\u04ba\b1\u00012\u00012\u00012\u00012\u00052\u04c0\b2\n2\f2\u04c3\t2\u0001"+
		"2\u00012\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u0005"+
		"4\u04cf\b4\n4\f4\u04d2\t4\u00014\u00014\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00055\u04dc\b5\n5\f5\u04df\t5\u00015\u00015\u00016\u00016\u0001"+
		"6\u00056\u04e6\b6\n6\f6\u04e9\t6\u00016\u00016\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00037\u04fb\b7\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00038\u0509\b8\u00019\u00019\u0001:\u0001"+
		":\u0001:\u0001:\u0003:\u0511\b:\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0005;\u051c\b;\n;\f;\u051f\t;\u0001<\u0001<\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u0529\b=\u0001=\u0001=\u0001"+
		">\u0001>\u0001>\u0003>\u0530\b>\u0001>\u0001>\u0001?\u0001?\u0001?\u0005"+
		"?\u0537\b?\n?\f?\u053a\t?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001A\u0001"+
		"A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0001B\u0003B\u054a\bB\u0001"+
		"B\u0001B\u0001C\u0001C\u0001C\u0001C\u0005C\u0552\bC\nC\fC\u0555\tC\u0003"+
		"C\u0557\bC\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0005D\u055f\bD\n"+
		"D\fD\u0562\tD\u0003D\u0564\bD\u0001D\u0001D\u0001E\u0001E\u0001E\u0001"+
		"E\u0001E\u0005E\u056d\bE\nE\fE\u0570\tE\u0003E\u0572\bE\u0001E\u0001E"+
		"\u0001F\u0001F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001G\u0001G\u0003"+
		"G\u057f\bG\u0001G\u0003G\u0582\bG\u0001H\u0001H\u0001H\u0001H\u0003H\u0588"+
		"\bH\u0001I\u0001I\u0003I\u058c\bI\u0001I\u0001I\u0001J\u0001J\u0001J\u0001"+
		"K\u0001K\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001M\u0001M\u0005"+
		"M\u059d\bM\nM\fM\u05a0\tM\u0001M\u0003M\u05a3\bM\u0001M\u0001M\u0001N"+
		"\u0001N\u0001N\u0001N\u0005N\u05ab\bN\nN\fN\u05ae\tN\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0005N\u05b6\bN\nN\fN\u05b9\tN\u0001N\u0001N\u0005"+
		"N\u05bd\bN\nN\fN\u05c0\tN\u0001N\u0001N\u0001N\u0005N\u05c5\bN\nN\fN\u05c8"+
		"\tN\u0001N\u0003N\u05cb\bN\u0001O\u0001O\u0001O\u0001O\u0005O\u05d1\b"+
		"O\nO\fO\u05d4\tO\u0001O\u0001O\u0001P\u0003P\u05d9\bP\u0001P\u0001P\u0001"+
		"P\u0003P\u05de\bP\u0001P\u0001P\u0001P\u0001P\u0003P\u05e4\bP\u0001P\u0001"+
		"P\u0001Q\u0001Q\u0001Q\u0005Q\u05eb\bQ\nQ\fQ\u05ee\tQ\u0001Q\u0001Q\u0001"+
		"R\u0001R\u0001R\u0001R\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0003S\u05fe\bS\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001"+
		"T\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001V\u0001V\u0001"+
		"V\u0001V\u0001V\u0001V\u0001V\u0001W\u0001W\u0001W\u0001W\u0001W\u0001"+
		"W\u0001W\u0001W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001"+
		"X\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001[\u0001[\u0001"+
		"[\u0001[\u0001[\u0001[\u0001[\u0001\\\u0001\\\u0001\\\u0001\\\u0005\\"+
		"\u0641\b\\\n\\\f\\\u0644\t\\\u0001\\\u0001\\\u0001]\u0001]\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0003^\u0653\b^\u0001"+
		"_\u0001_\u0001`\u0001`\u0001`\u0001`\u0003`\u065b\b`\u0001`\u0001`\u0001"+
		"a\u0001a\u0001b\u0001b\u0001b\u0001b\u0003b\u0665\bb\u0001b\u0001b\u0001"+
		"b\u0001b\u0001b\u0001b\u0001b\u0001b\u0003b\u066f\bb\u0001c\u0001c\u0001"+
		"c\u0001c\u0001c\u0005c\u0676\bc\nc\fc\u0679\tc\u0003c\u067b\bc\u0001c"+
		"\u0001c\u0001d\u0001d\u0003d\u0681\bd\u0001d\u0001d\u0001e\u0001e\u0001"+
		"e\u0001e\u0001e\u0003e\u068a\be\u0001e\u0003e\u068d\be\u0001f\u0001f\u0001"+
		"f\u0001f\u0005f\u0693\bf\nf\ff\u0696\tf\u0003f\u0698\bf\u0001f\u0001f"+
		"\u0001g\u0001g\u0001g\u0001g\u0005g\u06a0\bg\ng\fg\u06a3\tg\u0003g\u06a5"+
		"\bg\u0001g\u0001g\u0001h\u0001h\u0001h\u0001h\u0003h\u06ad\bh\u0001i\u0001"+
		"i\u0001i\u0005i\u06b2\bi\ni\fi\u06b5\ti\u0001j\u0001j\u0001j\u0001j\u0001"+
		"k\u0001k\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001m\u0001"+
		"m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001"+
		"m\u0001m\u0001m\u0001m\u0003m\u06d3\bm\u0001n\u0001n\u0001n\u0001n\u0001"+
		"n\u0005n\u06da\bn\nn\fn\u06dd\tn\u0001n\u0001n\u0001o\u0001o\u0001o\u0001"+
		"o\u0001o\u0001o\u0003o\u06e7\bo\u0001p\u0001p\u0001p\u0003p\u06ec\bp\u0001"+
		"p\u0001p\u0005p\u06f0\bp\np\fp\u06f3\tp\u0001q\u0001q\u0001q\u0005q\u06f8"+
		"\bq\nq\fq\u06fb\tq\u0001r\u0001r\u0001r\u0001r\u0003r\u0701\br\u0001r"+
		"\u0001r\u0003r\u0705\br\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001"+
		"s\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001u\u0001u\u0001"+
		"u\u0001u\u0001u\u0001v\u0001v\u0001v\u0001v\u0001v\u0005v\u071f\bv\nv"+
		"\fv\u0722\tv\u0003v\u0724\bv\u0001w\u0001w\u0001w\u0001w\u0001w\u0001"+
		"x\u0001x\u0001x\u0001x\u0001x\u0001y\u0001y\u0001y\u0001y\u0001y\u0001"+
		"y\u0001y\u0001z\u0001z\u0001z\u0001z\u0005z\u073b\bz\nz\fz\u073e\tz\u0001"+
		"z\u0001z\u0001{\u0001{\u0001|\u0001|\u0001|\u0001|\u0001|\u0001}\u0001"+
		"}\u0001}\u0005}\u074c\b}\n}\f}\u074f\t}\u0001}\u0001}\u0001~\u0001~\u0001"+
		"~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001"+
		"~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001"+
		"~\u0001~\u0001~\u0001~\u0001~\u0003~\u076e\b~\u0001\u007f\u0001\u007f"+
		"\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u0080\u0001\u0080\u0001\u0080"+
		"\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0003\u0080\u077c\b\u0080"+
		"\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081"+
		"\u0001\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0082\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083"+
		"\u0001\u0083\u0001\u0084\u0001\u0084\u0001\u0085\u0001\u0085\u0003\u0085"+
		"\u0795\b\u0085\u0001\u0085\u0001\u0085\u0003\u0085\u0799\b\u0085\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0003\u0085\u079f\b\u0085\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0003\u0085\u07b2"+
		"\b\u0085\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001"+
		"\u0086\u0001\u0086\u0001\u0086\u0001\u0087\u0005\u0087\u07bd\b\u0087\n"+
		"\u0087\f\u0087\u07c0\t\u0087\u0001\u0087\u0003\u0087\u07c3\b\u0087\u0001"+
		"\u0088\u0001\u0088\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0003"+
		"\u0089\u07cb\b\u0089\u0001\u0089\u0001\u0089\u0003\u0089\u07cf\b\u0089"+
		"\u0001\u0089\u0001\u0089\u0001\u0089\u0003\u0089\u07d4\b\u0089\u0001\u0089"+
		"\u0003\u0089\u07d7\b\u0089\u0001\u0089\u0001\u0089\u0005\u0089\u07db\b"+
		"\u0089\n\u0089\f\u0089\u07de\t\u0089\u0001\u0089\u0001\u0089\u0003\u0089"+
		"\u07e2\b\u0089\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a"+
		"\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a"+
		"\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a"+
		"\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0003\u008a\u07f9\b\u008a"+
		"\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b"+
		"\u0001\u008b\u0001\u008b\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0001\u008d\u0001\u008d\u0001\u008d\u0005\u008d\u080b\b\u008d"+
		"\n\u008d\f\u008d\u080e\t\u008d\u0001\u008d\u0001\u008d\u0001\u008e\u0001"+
		"\u008e\u0001\u008e\u0001\u008e\u0001\u008f\u0001\u008f\u0001\u008f\u0003"+
		"\u008f\u0819\b\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001"+
		"\u008f\u0001\u008f\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0090\u0001"+
		"\u0090\u0001\u0090\u0001\u0091\u0001\u0091\u0001\u0091\u0005\u0091\u082a"+
		"\b\u0091\n\u0091\f\u0091\u082d\t\u0091\u0001\u0091\u0001\u0091\u0001\u0091"+
		"\u0005\u0091\u0832\b\u0091\n\u0091\f\u0091\u0835\t\u0091\u0001\u0092\u0001"+
		"\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001"+
		"\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0005\u0093\u0843"+
		"\b\u0093\n\u0093\f\u0093\u0846\t\u0093\u0001\u0094\u0001\u0094\u0001\u0094"+
		"\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u084f\b\u0094"+
		"\u0001\u0094\u0005\u0094\u0852\b\u0094\n\u0094\f\u0094\u0855\t\u0094\u0001"+
		"\u0094\u0001\u0094\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0005"+
		"\u0095\u085d\b\u0095\n\u0095\f\u0095\u0860\t\u0095\u0001\u0095\u0001\u0095"+
		"\u0005\u0095\u0864\b\u0095\n\u0095\f\u0095\u0867\t\u0095\u0001\u0095\u0001"+
		"\u0095\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001"+
		"\u0096\u0003\u0096\u0871\b\u0096\u0001\u0097\u0001\u0097\u0001\u0098\u0001"+
		"\u0098\u0001\u0098\u0001\u0098\u0001\u0098\u0005\u0098\u087a\b\u0098\n"+
		"\u0098\f\u0098\u087d\t\u0098\u0001\u0098\u0001\u0098\u0001\u0099\u0001"+
		"\u0099\u0001\u0099\u0001\u0099\u0005\u0099\u0885\b\u0099\n\u0099\f\u0099"+
		"\u0888\t\u0099\u0001\u0099\u0001\u0099\u0003\u0099\u088c\b\u0099\u0001"+
		"\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0005\u009a\u0893"+
		"\b\u009a\n\u009a\f\u009a\u0896\t\u009a\u0001\u009a\u0001\u009a\u0001\u009b"+
		"\u0001\u009b\u0001\u009b\u0005\u009b\u089d\b\u009b\n\u009b\f\u009b\u08a0"+
		"\t\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0005\u009b\u08a6"+
		"\b\u009b\n\u009b\f\u009b\u08a9\t\u009b\u0001\u009b\u0001\u009b\u0003\u009b"+
		"\u08ad\b\u009b\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009c\u0003\u009c"+
		"\u08b3\b\u009c\u0001\u009c\u0001\u009c\u0005\u009c\u08b7\b\u009c\n\u009c"+
		"\f\u009c\u08ba\t\u009c\u0001\u009c\u0001\u009c\u0001\u009d\u0001\u009d"+
		"\u0001\u009d\u0005\u009d\u08c1\b\u009d\n\u009d\f\u009d\u08c4\t\u009d\u0001"+
		"\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001"+
		"\u009e\u0003\u009e\u08cd\b\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0003"+
		"\u009e\u08d2\b\u009e\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0005"+
		"\u009f\u08d8\b\u009f\n\u009f\f\u009f\u08db\t\u009f\u0001\u009f\u0001\u009f"+
		"\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0"+
		"\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0003\u00a0"+
		"\u08ea\b\u00a0\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0005\u00a1"+
		"\u08f0\b\u00a1\n\u00a1\f\u00a1\u08f3\t\u00a1\u0001\u00a1\u0001\u00a1\u0001"+
		"\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001"+
		"\u00a2\u0003\u00a2\u08fe\b\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a3\u0001"+
		"\u00a3\u0001\u00a3\u0001\u00a3\u0005\u00a3\u0906\b\u00a3\n\u00a3\f\u00a3"+
		"\u0909\t\u00a3\u0001\u00a3\u0001\u00a3\u0001\u00a4\u0001\u00a4\u0001\u00a4"+
		"\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0003\u00a4\u0914\b\u00a4"+
		"\u0001\u00a4\u0001\u00a4\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a5"+
		"\u0005\u00a5\u091c\b\u00a5\n\u00a5\f\u00a5\u091f\t\u00a5\u0001\u00a5\u0001"+
		"\u00a5\u0001\u00a6\u0001\u00a6\u0003\u00a6\u0925\b\u00a6\u0001\u00a6\u0001"+
		"\u00a6\u0001\u00a6\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001"+
		"\u00a7\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0005"+
		"\u00a8\u0934\b\u00a8\n\u00a8\f\u00a8\u0937\t\u00a8\u0001\u00a8\u0001\u00a8"+
		"\u0001\u00a8\u0001\u00a8\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9"+
		"\u0001\u00a9\u0003\u00a9\u0942\b\u00a9\u0001\u00aa\u0001\u00aa\u0001\u00aa"+
		"\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa"+
		"\u0001\u00aa\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0005\u00ab\u0951\b\u00ab"+
		"\n\u00ab\f\u00ab\u0954\t\u00ab\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001"+
		"\u00ac\u0001\u00ac\u0003\u00ac\u095b\b\u00ac\u0001\u00ac\u0001\u00ac\u0001"+
		"\u00ad\u0001\u00ad\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001"+
		"\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00af\u0001\u00af\u0001\u00af\u0005"+
		"\u00af\u096b\b\u00af\n\u00af\f\u00af\u096e\t\u00af\u0001\u00b0\u0001\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0003\u00b0\u0975\b\u00b0\u0001\u00b1"+
		"\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b1"+
		"\u0003\u00b1\u097e\b\u00b1\u0001\u00b1\u0001\u00b1\u0003\u00b1\u0982\b"+
		"\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b2\u0001\u00b2\u0003\u00b2\u0988"+
		"\b\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001"+
		"\u00b3\u0001\u00b3\u0005\u00b3\u0991\b\u00b3\n\u00b3\f\u00b3\u0994\t\u00b3"+
		"\u0003\u00b3\u0996\b\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b4\u0001\u00b4"+
		"\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0005\u00b4\u099f\b\u00b4\n\u00b4"+
		"\f\u00b4\u09a2\t\u00b4\u0003\u00b4\u09a4\b\u00b4\u0001\u00b4\u0001\u00b4"+
		"\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5"+
		"\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5"+
		"\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0003\u00b5\u09b8\b\u00b5"+
		"\u0001\u00b6\u0001\u00b6\u0001\u00b7\u0001\u00b7\u0001\u00b8\u0001\u00b8"+
		"\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8"+
		"\u0001\u00b9\u0001\u00b9\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0005\u00ba"+
		"\u09cb\b\u00ba\n\u00ba\f\u00ba\u09ce\t\u00ba\u0001\u00bb\u0001\u00bb\u0001"+
		"\u00bb\u0001\u00bb\u0005\u00bb\u09d4\b\u00bb\n\u00bb\f\u00bb\u09d7\t\u00bb"+
		"\u0001\u00bb\u0001\u00bb\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc"+
		"\u0005\u00bc\u09df\b\u00bc\n\u00bc\f\u00bc\u09e2\t\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0003\u00bd\u09fa\b\u00bd\u0001\u00be\u0001"+
		"\u00be\u0001\u00bf\u0001\u00bf\u0001\u00c0\u0001\u00c0\u0001\u00c1\u0001"+
		"\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001"+
		"\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c2\u0001\u00c2\u0001"+
		"\u00c3\u0001\u00c3\u0001\u00c4\u0001\u00c4\u0001\u00c5\u0001\u00c5\u0001"+
		"\u00c6\u0001\u00c6\u0001\u00c6\u0001\u00c6\u0001\u00c6\u0001\u00c6\u0001"+
		"\u00c6\u0001\u00c6\u0001\u00c6\u0001\u00c7\u0001\u00c7\u0001\u00c8\u0001"+
		"\u00c8\u0001\u00c9\u0001\u00c9\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001"+
		"\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00cb\u0001\u00cb\u0001"+
		"\u00cb\u0005\u00cb\u0a2e\b\u00cb\n\u00cb\f\u00cb\u0a31\t\u00cb\u0001\u00cc"+
		"\u0001\u00cc\u0001\u00cc\u0001\u00cc\u0001\u00cc\u0001\u00cc\u0001\u00cc"+
		"\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0005\u00cd\u0a3d\b\u00cd\n\u00cd"+
		"\f\u00cd\u0a40\t\u00cd\u0001\u00ce\u0001\u00ce\u0001\u00ce\u0001\u00ce"+
		"\u0001\u00ce\u0001\u00ce\u0001\u00ce\u0001\u00cf\u0001\u00cf\u0001\u00d0"+
		"\u0001\u00d0\u0001\u00d0\u0001\u00d0\u0001\u00d0\u0001\u00d1\u0001\u00d1"+
		"\u0001\u00d1\u0001\u00d1\u0001\u00d1\u0001\u00d1\u0001\u00d1\u0001\u00d2"+
		"\u0001\u00d2\u0001\u00d3\u0001\u00d3\u0001\u00d4\u0001\u00d4\u0001\u00d4"+
		"\u0001\u00d4\u0001\u00d4\u0001\u00d4\u0001\u00d4\u0001\u00d5\u0001\u00d5"+
		"\u0001\u00d6\u0001\u00d6\u0001\u00d7\u0001\u00d7\u0001\u00d7\u0001\u00d7"+
		"\u0001\u00d7\u0001\u00d7\u0001\u00d7\u0001\u00d8\u0001\u00d8\u0001\u00d9"+
		"\u0001\u00d9\u0001\u00da\u0001\u00da\u0001\u00da\u0001\u00da\u0001\u00da"+
		"\u0001\u00da\u0001\u00da\u0001\u00db\u0001\u00db\u0001\u00dc\u0001\u00dc"+
		"\u0001\u00dc\u0001\u00dc\u0001\u00dc\u0001\u00dc\u0001\u00dc\u0001\u00dd"+
		"\u0001\u00dd\u0001\u00de\u0001\u00de\u0001\u00df\u0001\u00df\u0001\u00df"+
		"\u0001\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001\u00e0\u0001\u00e0"+
		"\u0001\u00e1\u0001\u00e1\u0001\u00e2\u0001\u00e2\u0001\u00e2\u0001\u00e2"+
		"\u0001\u00e2\u0001\u00e2\u0001\u00e2\u0001\u00e3\u0001\u00e3\u0001\u00e4"+
		"\u0001\u00e4\u0001\u00e5\u0001\u00e5\u0001\u00e5\u0001\u00e5\u0001\u00e5"+
		"\u0001\u00e5\u0001\u00e5\u0001\u00e6\u0001\u00e6\u0001\u00e6\u0001\u00e6"+
		"\u0001\u00e6\u0001\u00e6\u0001\u00e6\u0001\u00e7\u0001\u00e7\u0001\u00e8"+
		"\u0001\u00e8\u0001\u00e8\u0001\u00e8\u0001\u00e8\u0001\u00e8\u0001\u00e8"+
		"\u0001\u00e9\u0001\u00e9\u0001\u00ea\u0001\u00ea\u0001\u00eb\u0001\u00eb"+
		"\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00ec"+
		"\u0001\u00ec\u0001\u00ed\u0001\u00ed\u0001\u00ee\u0001\u00ee\u0001\u00ee"+
		"\u0001\u00ee\u0001\u00ee\u0003\u00ee\u0ac6\b\u00ee\u0001\u00ee\u0001\u00ee"+
		"\u0001\u00ee\u0003\u00ee\u0acb\b\u00ee\u0001\u00ee\u0001\u00ee\u0001\u00ee"+
		"\u0001\u00ef\u0001\u00ef\u0001\u00ef\u0001\u00ef\u0003\u00ef\u0ad4\b\u00ef"+
		"\u0001\u00ef\u0001\u00ef\u0001\u00ef\u0001\u00ef\u0001\u00f0\u0001\u00f0"+
		"\u0001\u00f0\u0005\u00f0\u0add\b\u00f0\n\u00f0\f\u00f0\u0ae0\t\u00f0\u0001"+
		"\u00f1\u0001\u00f1\u0001\u00f1\u0005\u00f1\u0ae5\b\u00f1\n\u00f1\f\u00f1"+
		"\u0ae8\t\u00f1\u0001\u00f1\u0003\u00f1\u0aeb\b\u00f1\u0001\u00f2\u0001"+
		"\u00f2\u0001\u00f2\u0001\u00f2\u0003\u00f2\u0af1\b\u00f2\u0001\u00f2\u0001"+
		"\u00f2\u0001\u00f3\u0001\u00f3\u0001\u00f3\u0001\u00f3\u0005\u00f3\u0af9"+
		"\b\u00f3\n\u00f3\f\u00f3\u0afc\t\u00f3\u0001\u00f3\u0001\u00f3\u0001\u00f4"+
		"\u0001\u00f4\u0001\u00f4\u0001\u00f4\u0001\u00f4\u0001\u00f4\u0001\u00f4"+
		"\u0001\u00f4\u0001\u00f5\u0001\u00f5\u0001\u00f6\u0001\u00f6\u0001\u00f6"+
		"\u0001\u00f6\u0001\u00f6\u0001\u00f7\u0001\u00f7\u0001\u00f8\u0001\u00f8"+
		"\u0001\u00f8\u0001\u00f8\u0001\u00f8\u0001\u00f8\u0001\u00f8\u0001\u00f8"+
		"\u0001\u00f8\u0001\u00f8\u0001\u00f9\u0001\u00f9\u0001\u00f9\u0001\u00f9"+
		"\u0001\u00f9\u0001\u00fa\u0001\u00fa\u0001\u00fa\u0005\u00fa\u0b23\b\u00fa"+
		"\n\u00fa\f\u00fa\u0b26\t\u00fa\u0001\u00fb\u0001\u00fb\u0001\u00fb\u0001"+
		"\u00fb\u0001\u00fb\u0001\u00fc\u0001\u00fc\u0001\u00fd\u0001\u00fd\u0001"+
		"\u00fd\u0001\u00fd\u0001\u00fd\u0001\u00fe\u0001\u00fe\u0001\u00ff\u0001"+
		"\u00ff\u0001\u00ff\u0001\u00ff\u0001\u00ff\u0001\u0100\u0001\u0100\u0001"+
		"\u0101\u0001\u0101\u0001\u0101\u0001\u0101\u0001\u0101\u0001\u0102\u0001"+
		"\u0102\u0001\u0103\u0001\u0103\u0001\u0103\u0001\u0103\u0001\u0103\u0001"+
		"\u0103\u0001\u0103\u0001\u0103\u0001\u0104\u0001\u0104\u0001\u0104\u0005"+
		"\u0104\u0b4f\b\u0104\n\u0104\f\u0104\u0b52\t\u0104\u0001\u0105\u0001\u0105"+
		"\u0001\u0105\u0001\u0105\u0001\u0105\u0001\u0105\u0001\u0105\u0001\u0106"+
		"\u0001\u0106\u0001\u0106\u0001\u0106\u0001\u0106\u0001\u0107\u0001\u0107"+
		"\u0001\u0107\u0001\u0107\u0001\u0107\u0001\u0108\u0001\u0108\u0001\u0108"+
		"\u0005\u0108\u0b68\b\u0108\n\u0108\f\u0108\u0b6b\t\u0108\u0001\u0108\u0001"+
		"\u0108\u0001\u0109\u0001\u0109\u0001\u010a\u0001\u010a\u0001\u010a\u0001"+
		"\u010a\u0001\u010a\u0001\u010a\u0005\u010a\u0b77\b\u010a\n\u010a\f\u010a"+
		"\u0b7a\t\u010a\u0001\u010a\u0001\u010a\u0001\u010b\u0001\u010b\u0001\u010c"+
		"\u0001\u010c\u0001\u010c\u0001\u010c\u0001\u010c\u0001\u010d\u0001\u010d"+
		"\u0001\u010e\u0001\u010e\u0001\u010e\u0001\u010e\u0001\u010e\u0001\u010e"+
		"\u0001\u010e\u0001\u010f\u0001\u010f\u0001\u0110\u0001\u0110\u0001\u0110"+
		"\u0001\u0110\u0001\u0110\u0001\u0110\u0001\u0110\u0001\u0111\u0001\u0111"+
		"\u0001\u0112\u0001\u0112\u0001\u0112\u0001\u0112\u0001\u0112\u0005\u0112"+
		"\u0b9e\b\u0112\n\u0112\f\u0112\u0ba1\t\u0112\u0001\u0112\u0001\u0112\u0001"+
		"\u0113\u0001\u0113\u0001\u0113\u0003\u0113\u0ba8\b\u0113\u0001\u0113\u0001"+
		"\u0113\u0001\u0114\u0001\u0114\u0001\u0114\u0001\u0114\u0001\u0114\u0005"+
		"\u0114\u0bb1\b\u0114\n\u0114\f\u0114\u0bb4\t\u0114\u0001\u0114\u0001\u0114"+
		"\u0001\u0115\u0001\u0115\u0001\u0116\u0001\u0116\u0001\u0116\u0001\u0116"+
		"\u0001\u0116\u0001\u0116\u0001\u0116\u0001\u0117\u0001\u0117\u0001\u0117"+
		"\u0001\u0117\u0001\u0117\u0001\u0117\u0001\u0117\u0001\u0118\u0001\u0118"+
		"\u0001\u0118\u0005\u0118\u0bcb\b\u0118\n\u0118\f\u0118\u0bce\t\u0118\u0001"+
		"\u0119\u0001\u0119\u0001\u0119\u0001\u0119\u0001\u0119\u0001\u011a\u0001"+
		"\u011a\u0001\u011b\u0001\u011b\u0001\u011b\u0001\u011b\u0001\u011b\u0001"+
		"\u011c\u0001\u011c\u0001\u011c\u0001\u011c\u0001\u011c\u0001\u011d\u0001"+
		"\u011d\u0001\u011d\u0001\u011d\u0001\u011d\u0001\u011e\u0001\u011e\u0001"+
		"\u011e\u0001\u011e\u0001\u011e\u0001\u011f\u0001\u011f\u0001\u011f\u0001"+
		"\u011f\u0001\u011f\u0001\u0120\u0001\u0120\u0001\u0120\u0001\u0120\u0001"+
		"\u0120\u0001\u0121\u0001\u0121\u0001\u0121\u0001\u0121\u0001\u0121\u0001"+
		"\u0122\u0001\u0122\u0001\u0122\u0001\u0122\u0001\u0122\u0001\u0122\u0005"+
		"\u0122\u0c00\b\u0122\n\u0122\f\u0122\u0c03\t\u0122\u0001\u0122\u0001\u0122"+
		"\u0001\u0123\u0001\u0123\u0001\u0124\u0001\u0124\u0001\u0124\u0001\u0124"+
		"\u0001\u0124\u0001\u0125\u0001\u0125\u0001\u0125\u0001\u0125\u0001\u0125"+
		"\u0001\u0126\u0001\u0126\u0001\u0126\u0001\u0126\u0001\u0126\u0001\u0127"+
		"\u0001\u0127\u0001\u0127\u0001\u0127\u0001\u0127\u0001\u0128\u0001\u0128"+
		"\u0001\u0128\u0001\u0128\u0001\u0128\u0001\u0129\u0001\u0129\u0001\u0129"+
		"\u0001\u0129\u0001\u0129\u0001\u012a\u0001\u012a\u0001\u012a\u0001\u012a"+
		"\u0001\u012a\u0001\u012b\u0001\u012b\u0001\u012b\u0001\u012b\u0001\u012b"+
		"\u0001\u012c\u0001\u012c\u0001\u012c\u0001\u012c\u0001\u012c\u0001\u012d"+
		"\u0001\u012d\u0001\u012d\u0001\u012d\u0001\u012d\u0001\u012e\u0001\u012e"+
		"\u0001\u012e\u0001\u012e\u0001\u012e\u0001\u012f\u0001\u012f\u0001\u012f"+
		"\u0001\u012f\u0001\u012f\u0001\u0130\u0001\u0130\u0001\u0130\u0001\u0130"+
		"\u0001\u0130\u0001\u0131\u0001\u0131\u0001\u0132\u0001\u0132\u0001\u0132"+
		"\u0001\u0132\u0001\u0132\u0001\u0133\u0001\u0133\u0001\u0133\u0001\u0133"+
		"\u0001\u0133\u0001\u0133\u0000\u0001v\u0134\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8"+
		"\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0"+
		"\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8"+
		"\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100"+
		"\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118"+
		"\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130"+
		"\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146\u0148"+
		"\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e\u0160"+
		"\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176\u0178"+
		"\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u018e\u0190"+
		"\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\u01a2\u01a4\u01a6\u01a8"+
		"\u01aa\u01ac\u01ae\u01b0\u01b2\u01b4\u01b6\u01b8\u01ba\u01bc\u01be\u01c0"+
		"\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc\u01ce\u01d0\u01d2\u01d4\u01d6\u01d8"+
		"\u01da\u01dc\u01de\u01e0\u01e2\u01e4\u01e6\u01e8\u01ea\u01ec\u01ee\u01f0"+
		"\u01f2\u01f4\u01f6\u01f8\u01fa\u01fc\u01fe\u0200\u0202\u0204\u0206\u0208"+
		"\u020a\u020c\u020e\u0210\u0212\u0214\u0216\u0218\u021a\u021c\u021e\u0220"+
		"\u0222\u0224\u0226\u0228\u022a\u022c\u022e\u0230\u0232\u0234\u0236\u0238"+
		"\u023a\u023c\u023e\u0240\u0242\u0244\u0246\u0248\u024a\u024c\u024e\u0250"+
		"\u0252\u0254\u0256\u0258\u025a\u025c\u025e\u0260\u0262\u0264\u0266\u0000"+
		"\u0014\u0002\u0000OO\u0092\u0092\u0001\u0000RS\u0003\u0000OO\u00b2\u00bc"+
		"\u00be\u00be\u0001\u0000JS\u0002\u0000_dfq\u0002\u0000\u000b\u000b\u019c"+
		"\u019c\u0001\u0000:C\u0001\u0000\u00a9\u00af\u0002\u0000\u00e5\u00f2\u0144"+
		"\u0145\u0003\u0000\u0131\u0131\u0135\u0136\u0138\u0138\u0001\u0000_q\u0001"+
		"\u0000\u0103\u0108\u0002\u0000\u0121\u012a\u019d\u019d\u0003\u0000KKO"+
		"O\u00be\u00be\u0004\u0000++..66\u018d\u0191\u0001\u0000\u0195\u0198\u0001"+
		"\u0000\u0199\u019b\u0001\u0000\u0151\u0153\u0001\u0000\u015e\u0163\u0001"+
		"\u0000\u0183\u0184\u0c86\u0000\u026b\u0001\u0000\u0000\u0000\u0002\u027c"+
		"\u0001\u0000\u0000\u0000\u0004\u027e\u0001\u0000\u0000\u0000\u0006\u0289"+
		"\u0001\u0000\u0000\u0000\b\u0291\u0001\u0000\u0000\u0000\n\u02ac\u0001"+
		"\u0000\u0000\u0000\f\u02ae\u0001\u0000\u0000\u0000\u000e\u02bd\u0001\u0000"+
		"\u0000\u0000\u0010\u02ca\u0001\u0000\u0000\u0000\u0012\u02f1\u0001\u0000"+
		"\u0000\u0000\u0014\u02f3\u0001\u0000\u0000\u0000\u0016\u031f\u0001\u0000"+
		"\u0000\u0000\u0018\u032d\u0001\u0000\u0000\u0000\u001a\u0331\u0001\u0000"+
		"\u0000\u0000\u001c\u0337\u0001\u0000\u0000\u0000\u001e\u0344\u0001\u0000"+
		"\u0000\u0000 \u034a\u0001\u0000\u0000\u0000\"\u034e\u0001\u0000\u0000"+
		"\u0000$\u0351\u0001\u0000\u0000\u0000&\u0355\u0001\u0000\u0000\u0000("+
		"\u035f\u0001\u0000\u0000\u0000*\u0364\u0001\u0000\u0000\u0000,\u036c\u0001"+
		"\u0000\u0000\u0000.\u0377\u0001\u0000\u0000\u00000\u0393\u0001\u0000\u0000"+
		"\u00002\u0395\u0001\u0000\u0000\u00004\u039e\u0001\u0000\u0000\u00006"+
		"\u03a8\u0001\u0000\u0000\u00008\u03b4\u0001\u0000\u0000\u0000:\u03c7\u0001"+
		"\u0000\u0000\u0000<\u03c9\u0001\u0000\u0000\u0000>\u03e3\u0001\u0000\u0000"+
		"\u0000@\u03ec\u0001\u0000\u0000\u0000B\u03f2\u0001\u0000\u0000\u0000D"+
		"\u0403\u0001\u0000\u0000\u0000F\u0412\u0001\u0000\u0000\u0000H\u0426\u0001"+
		"\u0000\u0000\u0000J\u0428\u0001\u0000\u0000\u0000L\u043e\u0001\u0000\u0000"+
		"\u0000N\u0440\u0001\u0000\u0000\u0000P\u044c\u0001\u0000\u0000\u0000R"+
		"\u0454\u0001\u0000\u0000\u0000T\u046d\u0001\u0000\u0000\u0000V\u046f\u0001"+
		"\u0000\u0000\u0000X\u047e\u0001\u0000\u0000\u0000Z\u0481\u0001\u0000\u0000"+
		"\u0000\\\u0486\u0001\u0000\u0000\u0000^\u048c\u0001\u0000\u0000\u0000"+
		"`\u0492\u0001\u0000\u0000\u0000b\u0495\u0001\u0000\u0000\u0000d\u04bb"+
		"\u0001\u0000\u0000\u0000f\u04c6\u0001\u0000\u0000\u0000h\u04ca\u0001\u0000"+
		"\u0000\u0000j\u04d5\u0001\u0000\u0000\u0000l\u04e2\u0001\u0000\u0000\u0000"+
		"n\u04fa\u0001\u0000\u0000\u0000p\u0508\u0001\u0000\u0000\u0000r\u050a"+
		"\u0001\u0000\u0000\u0000t\u0510\u0001\u0000\u0000\u0000v\u0512\u0001\u0000"+
		"\u0000\u0000x\u0520\u0001\u0000\u0000\u0000z\u0528\u0001\u0000\u0000\u0000"+
		"|\u052c\u0001\u0000\u0000\u0000~\u0533\u0001\u0000\u0000\u0000\u0080\u053b"+
		"\u0001\u0000\u0000\u0000\u0082\u0540\u0001\u0000\u0000\u0000\u0084\u0544"+
		"\u0001\u0000\u0000\u0000\u0086\u054d\u0001\u0000\u0000\u0000\u0088\u055a"+
		"\u0001\u0000\u0000\u0000\u008a\u0567\u0001\u0000\u0000\u0000\u008c\u0575"+
		"\u0001\u0000\u0000\u0000\u008e\u0579\u0001\u0000\u0000\u0000\u0090\u0583"+
		"\u0001\u0000\u0000\u0000\u0092\u0589\u0001\u0000\u0000\u0000\u0094\u058f"+
		"\u0001\u0000\u0000\u0000\u0096\u0592\u0001\u0000\u0000\u0000\u0098\u0596"+
		"\u0001\u0000\u0000\u0000\u009a\u059a\u0001\u0000\u0000\u0000\u009c\u05a6"+
		"\u0001\u0000\u0000\u0000\u009e\u05cc\u0001\u0000\u0000\u0000\u00a0\u05d8"+
		"\u0001\u0000\u0000\u0000\u00a2\u05e7\u0001\u0000\u0000\u0000\u00a4\u05f1"+
		"\u0001\u0000\u0000\u0000\u00a6\u05fd\u0001\u0000\u0000\u0000\u00a8\u05ff"+
		"\u0001\u0000\u0000\u0000\u00aa\u0606\u0001\u0000\u0000\u0000\u00ac\u060d"+
		"\u0001\u0000\u0000\u0000\u00ae\u0614\u0001\u0000\u0000\u0000\u00b0\u061d"+
		"\u0001\u0000\u0000\u0000\u00b2\u0626\u0001\u0000\u0000\u0000\u00b4\u062b"+
		"\u0001\u0000\u0000\u0000\u00b6\u0635\u0001\u0000\u0000\u0000\u00b8\u063c"+
		"\u0001\u0000\u0000\u0000\u00ba\u0647\u0001\u0000\u0000\u0000\u00bc\u0652"+
		"\u0001\u0000\u0000\u0000\u00be\u0654\u0001\u0000\u0000\u0000\u00c0\u065a"+
		"\u0001\u0000\u0000\u0000\u00c2\u065e\u0001\u0000\u0000\u0000\u00c4\u0664"+
		"\u0001\u0000\u0000\u0000\u00c6\u0670\u0001\u0000\u0000\u0000\u00c8\u0680"+
		"\u0001\u0000\u0000\u0000\u00ca\u0684\u0001\u0000\u0000\u0000\u00cc\u068e"+
		"\u0001\u0000\u0000\u0000\u00ce\u069b\u0001\u0000\u0000\u0000\u00d0\u06a8"+
		"\u0001\u0000\u0000\u0000\u00d2\u06ae\u0001\u0000\u0000\u0000\u00d4\u06b6"+
		"\u0001\u0000\u0000\u0000\u00d6\u06ba\u0001\u0000\u0000\u0000\u00d8\u06bc"+
		"\u0001\u0000\u0000\u0000\u00da\u06d2\u0001\u0000\u0000\u0000\u00dc\u06d4"+
		"\u0001\u0000\u0000\u0000\u00de\u06e6\u0001\u0000\u0000\u0000\u00e0\u06e8"+
		"\u0001\u0000\u0000\u0000\u00e2\u06f4\u0001\u0000\u0000\u0000\u00e4\u06fc"+
		"\u0001\u0000\u0000\u0000\u00e6\u0706\u0001\u0000\u0000\u0000\u00e8\u070d"+
		"\u0001\u0000\u0000\u0000\u00ea\u0714\u0001\u0000\u0000\u0000\u00ec\u0723"+
		"\u0001\u0000\u0000\u0000\u00ee\u0725\u0001\u0000\u0000\u0000\u00f0\u072a"+
		"\u0001\u0000\u0000\u0000\u00f2\u072f\u0001\u0000\u0000\u0000\u00f4\u0736"+
		"\u0001\u0000\u0000\u0000\u00f6\u0741\u0001\u0000\u0000\u0000\u00f8\u0743"+
		"\u0001\u0000\u0000\u0000\u00fa\u0748\u0001\u0000\u0000\u0000\u00fc\u076d"+
		"\u0001\u0000\u0000\u0000\u00fe\u076f\u0001\u0000\u0000\u0000\u0100\u0774"+
		"\u0001\u0000\u0000\u0000\u0102\u077d\u0001\u0000\u0000\u0000\u0104\u0784"+
		"\u0001\u0000\u0000\u0000\u0106\u078b\u0001\u0000\u0000\u0000\u0108\u0790"+
		"\u0001\u0000\u0000\u0000\u010a\u07b1\u0001\u0000\u0000\u0000\u010c\u07b3"+
		"\u0001\u0000\u0000\u0000\u010e\u07be\u0001\u0000\u0000\u0000\u0110\u07c4"+
		"\u0001\u0000\u0000\u0000\u0112\u07c6\u0001\u0000\u0000\u0000\u0114\u07f8"+
		"\u0001\u0000\u0000\u0000\u0116\u07fa\u0001\u0000\u0000\u0000\u0118\u0802"+
		"\u0001\u0000\u0000\u0000\u011a\u0807\u0001\u0000\u0000\u0000\u011c\u0811"+
		"\u0001\u0000\u0000\u0000\u011e\u0815\u0001\u0000\u0000\u0000\u0120\u0820"+
		"\u0001\u0000\u0000\u0000\u0122\u082b\u0001\u0000\u0000\u0000\u0124\u0836"+
		"\u0001\u0000\u0000\u0000\u0126\u083d\u0001\u0000\u0000\u0000\u0128\u0847"+
		"\u0001\u0000\u0000\u0000\u012a\u0858\u0001\u0000\u0000\u0000\u012c\u0870"+
		"\u0001\u0000\u0000\u0000\u012e\u0872\u0001\u0000\u0000\u0000\u0130\u0874"+
		"\u0001\u0000\u0000\u0000\u0132\u088b\u0001\u0000\u0000\u0000\u0134\u088d"+
		"\u0001\u0000\u0000\u0000\u0136\u08ac\u0001\u0000\u0000\u0000\u0138\u08ae"+
		"\u0001\u0000\u0000\u0000\u013a\u08bd\u0001\u0000\u0000\u0000\u013c\u08d1"+
		"\u0001\u0000\u0000\u0000\u013e\u08d3\u0001\u0000\u0000\u0000\u0140\u08e9"+
		"\u0001\u0000\u0000\u0000\u0142\u08eb\u0001\u0000\u0000\u0000\u0144\u08f6"+
		"\u0001\u0000\u0000\u0000\u0146\u0901\u0001\u0000\u0000\u0000\u0148\u090c"+
		"\u0001\u0000\u0000\u0000\u014a\u0917\u0001\u0000\u0000\u0000\u014c\u0922"+
		"\u0001\u0000\u0000\u0000\u014e\u0929\u0001\u0000\u0000\u0000\u0150\u092e"+
		"\u0001\u0000\u0000\u0000\u0152\u0941\u0001\u0000\u0000\u0000\u0154\u0943"+
		"\u0001\u0000\u0000\u0000\u0156\u094d\u0001\u0000\u0000\u0000\u0158\u0955"+
		"\u0001\u0000\u0000\u0000\u015a\u095e\u0001\u0000\u0000\u0000\u015c\u0960"+
		"\u0001\u0000\u0000\u0000\u015e\u0967\u0001\u0000\u0000\u0000\u0160\u096f"+
		"\u0001\u0000\u0000\u0000\u0162\u0976\u0001\u0000\u0000\u0000\u0164\u0985"+
		"\u0001\u0000\u0000\u0000\u0166\u098b\u0001\u0000\u0000\u0000\u0168\u0999"+
		"\u0001\u0000\u0000\u0000\u016a\u09b7\u0001\u0000\u0000\u0000\u016c\u09b9"+
		"\u0001\u0000\u0000\u0000\u016e\u09bb\u0001\u0000\u0000\u0000\u0170\u09bd"+
		"\u0001\u0000\u0000\u0000\u0172\u09c5\u0001\u0000\u0000\u0000\u0174\u09c7"+
		"\u0001\u0000\u0000\u0000\u0176\u09cf\u0001\u0000\u0000\u0000\u0178\u09da"+
		"\u0001\u0000\u0000\u0000\u017a\u09f9\u0001\u0000\u0000\u0000\u017c\u09fb"+
		"\u0001\u0000\u0000\u0000\u017e\u09fd\u0001\u0000\u0000\u0000\u0180\u09ff"+
		"\u0001\u0000\u0000\u0000\u0182\u0a01\u0001\u0000\u0000\u0000\u0184\u0a0c"+
		"\u0001\u0000\u0000\u0000\u0186\u0a0e\u0001\u0000\u0000\u0000\u0188\u0a10"+
		"\u0001\u0000\u0000\u0000\u018a\u0a12\u0001\u0000\u0000\u0000\u018c\u0a14"+
		"\u0001\u0000\u0000\u0000\u018e\u0a1d\u0001\u0000\u0000\u0000\u0190\u0a1f"+
		"\u0001\u0000\u0000\u0000\u0192\u0a21\u0001\u0000\u0000\u0000\u0194\u0a23"+
		"\u0001\u0000\u0000\u0000\u0196\u0a2a\u0001\u0000\u0000\u0000\u0198\u0a32"+
		"\u0001\u0000\u0000\u0000\u019a\u0a39\u0001\u0000\u0000\u0000\u019c\u0a41"+
		"\u0001\u0000\u0000\u0000\u019e\u0a48\u0001\u0000\u0000\u0000\u01a0\u0a4a"+
		"\u0001\u0000\u0000\u0000\u01a2\u0a4f\u0001\u0000\u0000\u0000\u01a4\u0a56"+
		"\u0001\u0000\u0000\u0000\u01a6\u0a58\u0001\u0000\u0000\u0000\u01a8\u0a5a"+
		"\u0001\u0000\u0000\u0000\u01aa\u0a61\u0001\u0000\u0000\u0000\u01ac\u0a63"+
		"\u0001\u0000\u0000\u0000\u01ae\u0a65\u0001\u0000\u0000\u0000\u01b0\u0a6c"+
		"\u0001\u0000\u0000\u0000\u01b2\u0a6e\u0001\u0000\u0000\u0000\u01b4\u0a70"+
		"\u0001\u0000\u0000\u0000\u01b6\u0a77\u0001\u0000\u0000\u0000\u01b8\u0a79"+
		"\u0001\u0000\u0000\u0000\u01ba\u0a80\u0001\u0000\u0000\u0000\u01bc\u0a82"+
		"\u0001\u0000\u0000\u0000\u01be\u0a84\u0001\u0000\u0000\u0000\u01c0\u0a8b"+
		"\u0001\u0000\u0000\u0000\u01c2\u0a8d\u0001\u0000\u0000\u0000\u01c4\u0a8f"+
		"\u0001\u0000\u0000\u0000\u01c6\u0a96\u0001\u0000\u0000\u0000\u01c8\u0a98"+
		"\u0001\u0000\u0000\u0000\u01ca\u0a9a\u0001\u0000\u0000\u0000\u01cc\u0aa1"+
		"\u0001\u0000\u0000\u0000\u01ce\u0aa8\u0001\u0000\u0000\u0000\u01d0\u0aaa"+
		"\u0001\u0000\u0000\u0000\u01d2\u0ab1\u0001\u0000\u0000\u0000\u01d4\u0ab3"+
		"\u0001\u0000\u0000\u0000\u01d6\u0ab5\u0001\u0000\u0000\u0000\u01d8\u0abc"+
		"\u0001\u0000\u0000\u0000\u01da\u0abe\u0001\u0000\u0000\u0000\u01dc\u0ac0"+
		"\u0001\u0000\u0000\u0000\u01de\u0acf\u0001\u0000\u0000\u0000\u01e0\u0ad9"+
		"\u0001\u0000\u0000\u0000\u01e2\u0aea\u0001\u0000\u0000\u0000\u01e4\u0aec"+
		"\u0001\u0000\u0000\u0000\u01e6\u0af4\u0001\u0000\u0000\u0000\u01e8\u0aff"+
		"\u0001\u0000\u0000\u0000\u01ea\u0b07\u0001\u0000\u0000\u0000\u01ec\u0b09"+
		"\u0001\u0000\u0000\u0000\u01ee\u0b0e\u0001\u0000\u0000\u0000\u01f0\u0b10"+
		"\u0001\u0000\u0000\u0000\u01f2\u0b1a\u0001\u0000\u0000\u0000\u01f4\u0b1f"+
		"\u0001\u0000\u0000\u0000\u01f6\u0b27\u0001\u0000\u0000\u0000\u01f8\u0b2c"+
		"\u0001\u0000\u0000\u0000\u01fa\u0b2e\u0001\u0000\u0000\u0000\u01fc\u0b33"+
		"\u0001\u0000\u0000\u0000\u01fe\u0b35\u0001\u0000\u0000\u0000\u0200\u0b3a"+
		"\u0001\u0000\u0000\u0000\u0202\u0b3c\u0001\u0000\u0000\u0000\u0204\u0b41"+
		"\u0001\u0000\u0000\u0000\u0206\u0b43\u0001\u0000\u0000\u0000\u0208\u0b4b"+
		"\u0001\u0000\u0000\u0000\u020a\u0b53\u0001\u0000\u0000\u0000\u020c\u0b5a"+
		"\u0001\u0000\u0000\u0000\u020e\u0b5f\u0001\u0000\u0000\u0000\u0210\u0b64"+
		"\u0001\u0000\u0000\u0000\u0212\u0b6e\u0001\u0000\u0000\u0000\u0214\u0b70"+
		"\u0001\u0000\u0000\u0000\u0216\u0b7d\u0001\u0000\u0000\u0000\u0218\u0b7f"+
		"\u0001\u0000\u0000\u0000\u021a\u0b84\u0001\u0000\u0000\u0000\u021c\u0b86"+
		"\u0001\u0000\u0000\u0000\u021e\u0b8d\u0001\u0000\u0000\u0000\u0220\u0b8f"+
		"\u0001\u0000\u0000\u0000\u0222\u0b96\u0001\u0000\u0000\u0000\u0224\u0b98"+
		"\u0001\u0000\u0000\u0000\u0226\u0ba4\u0001\u0000\u0000\u0000\u0228\u0bab"+
		"\u0001\u0000\u0000\u0000\u022a\u0bb7\u0001\u0000\u0000\u0000\u022c\u0bb9"+
		"\u0001\u0000\u0000\u0000\u022e\u0bc0\u0001\u0000\u0000\u0000\u0230\u0bc7"+
		"\u0001\u0000\u0000\u0000\u0232\u0bcf\u0001\u0000\u0000\u0000\u0234\u0bd4"+
		"\u0001\u0000\u0000\u0000\u0236\u0bd6\u0001\u0000\u0000\u0000\u0238\u0bdb"+
		"\u0001\u0000\u0000\u0000\u023a\u0be0\u0001\u0000\u0000\u0000\u023c\u0be5"+
		"\u0001\u0000\u0000\u0000\u023e\u0bea\u0001\u0000\u0000\u0000\u0240\u0bef"+
		"\u0001\u0000\u0000\u0000\u0242\u0bf4\u0001\u0000\u0000\u0000\u0244\u0bf9"+
		"\u0001\u0000\u0000\u0000\u0246\u0c06\u0001\u0000\u0000\u0000\u0248\u0c08"+
		"\u0001\u0000\u0000\u0000\u024a\u0c0d\u0001\u0000\u0000\u0000\u024c\u0c12"+
		"\u0001\u0000\u0000\u0000\u024e\u0c17\u0001\u0000\u0000\u0000\u0250\u0c1c"+
		"\u0001\u0000\u0000\u0000\u0252\u0c21\u0001\u0000\u0000\u0000\u0254\u0c26"+
		"\u0001\u0000\u0000\u0000\u0256\u0c2b\u0001\u0000\u0000\u0000\u0258\u0c30"+
		"\u0001\u0000\u0000\u0000\u025a\u0c35\u0001\u0000\u0000\u0000\u025c\u0c3a"+
		"\u0001\u0000\u0000\u0000\u025e\u0c3f\u0001\u0000\u0000\u0000\u0260\u0c44"+
		"\u0001\u0000\u0000\u0000\u0262\u0c49\u0001\u0000\u0000\u0000\u0264\u0c4b"+
		"\u0001\u0000\u0000\u0000\u0266\u0c50\u0001\u0000\u0000\u0000\u0268\u026a"+
		"\u0003\u0002\u0001\u0000\u0269\u0268\u0001\u0000\u0000\u0000\u026a\u026d"+
		"\u0001\u0000\u0000\u0000\u026b\u0269\u0001\u0000\u0000\u0000\u026b\u026c"+
		"\u0001\u0000\u0000\u0000\u026c\u026e\u0001\u0000\u0000\u0000\u026d\u026b"+
		"\u0001\u0000\u0000\u0000\u026e\u026f\u0005\u0000\u0000\u0001\u026f\u0001"+
		"\u0001\u0000\u0000\u0000\u0270\u027d\u0003\u0004\u0002\u0000\u0271\u027d"+
		"\u0003\u0006\u0003\u0000\u0272\u027d\u0003\u0010\b\u0000\u0273\u027d\u0003"+
		"<\u001e\u0000\u0274\u027d\u0003B!\u0000\u0275\u027d\u0003F#\u0000\u0276"+
		"\u027d\u0003J%\u0000\u0277\u027d\u0003N\'\u0000\u0278\u027d\u0003P(\u0000"+
		"\u0279\u027d\u0003R)\u0000\u027a\u027d\u0003\b\u0004\u0000\u027b\u027d"+
		"\u0003\f\u0006\u0000\u027c\u0270\u0001\u0000\u0000\u0000\u027c\u0271\u0001"+
		"\u0000\u0000\u0000\u027c\u0272\u0001\u0000\u0000\u0000\u027c\u0273\u0001"+
		"\u0000\u0000\u0000\u027c\u0274\u0001\u0000\u0000\u0000\u027c\u0275\u0001"+
		"\u0000\u0000\u0000\u027c\u0276\u0001\u0000\u0000\u0000\u027c\u0277\u0001"+
		"\u0000\u0000\u0000\u027c\u0278\u0001\u0000\u0000\u0000\u027c\u0279\u0001"+
		"\u0000\u0000\u0000\u027c\u027a\u0001\u0000\u0000\u0000\u027c\u027b\u0001"+
		"\u0000\u0000\u0000\u027d\u0003\u0001\u0000\u0000\u0000\u027e\u027f\u0005"+
		"\u0004\u0000\u0000\u027f\u0280\u0005\u008f\u0000\u0000\u0280\u0284\u0005"+
		"\u007f\u0000\u0000\u0281\u0283\u0003\u0002\u0001\u0000\u0282\u0281\u0001"+
		"\u0000\u0000\u0000\u0283\u0286\u0001\u0000\u0000\u0000\u0284\u0282\u0001"+
		"\u0000\u0000\u0000\u0284\u0285\u0001\u0000\u0000\u0000\u0285\u0287\u0001"+
		"\u0000\u0000\u0000\u0286\u0284\u0001\u0000\u0000\u0000\u0287\u0288\u0005"+
		"\u0080\u0000\u0000\u0288\u0005\u0001\u0000\u0000\u0000\u0289\u028a\u0005"+
		"\u0005\u0000\u0000\u028a\u028d\u0007\u0000\u0000\u0000\u028b\u028c\u0005"+
		"F\u0000\u0000\u028c\u028e\u0005\u008f\u0000\u0000\u028d\u028b\u0001\u0000"+
		"\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000\u028e\u028f\u0001\u0000"+
		"\u0000\u0000\u028f\u0290\u0005\u0086\u0000\u0000\u0290\u0007\u0001\u0000"+
		"\u0000\u0000\u0291\u0292\u0005D\u0000\u0000\u0292\u0296\u0005\u007f\u0000"+
		"\u0000\u0293\u0295\u0003\n\u0005\u0000\u0294\u0293\u0001\u0000\u0000\u0000"+
		"\u0295\u0298\u0001\u0000\u0000\u0000\u0296\u0294\u0001\u0000\u0000\u0000"+
		"\u0296\u0297\u0001\u0000\u0000\u0000\u0297\u0299\u0001\u0000\u0000\u0000"+
		"\u0298\u0296\u0001\u0000\u0000\u0000\u0299\u029a\u0005\u0080\u0000\u0000"+
		"\u029a\t\u0001\u0000\u0000\u0000\u029b\u029c\u0005\u00a6\u0000\u0000\u029c"+
		"\u029d\u0005r\u0000\u0000\u029d\u029e\u0005O\u0000\u0000\u029e\u02ad\u0005"+
		"\u0086\u0000\u0000\u029f\u02a0\u0005\u00a7\u0000\u0000\u02a0\u02a1\u0005"+
		"r\u0000\u0000\u02a1\u02a2\u0007\u0001\u0000\u0000\u02a2\u02ad\u0005\u0086"+
		"\u0000\u0000\u02a3\u02a4\u0005\u00a8\u0000\u0000\u02a4\u02a5\u0005r\u0000"+
		"\u0000\u02a5\u02a6\u0007\u0001\u0000\u0000\u02a6\u02ad\u0005\u0086\u0000"+
		"\u0000\u02a7\u02a8\u0005\u008f\u0000\u0000\u02a8\u02a9\u0005r\u0000\u0000"+
		"\u02a9\u02aa\u0003p8\u0000\u02aa\u02ab\u0005\u0086\u0000\u0000\u02ab\u02ad"+
		"\u0001\u0000\u0000\u0000\u02ac\u029b\u0001\u0000\u0000\u0000\u02ac\u029f"+
		"\u0001\u0000\u0000\u0000\u02ac\u02a3\u0001\u0000\u0000\u0000\u02ac\u02a7"+
		"\u0001\u0000\u0000\u0000\u02ad\u000b\u0001\u0000\u0000\u0000\u02ae\u02af"+
		"\u0005E\u0000\u0000\u02af\u02b2\u0005O\u0000\u0000\u02b0\u02b1\u0005F"+
		"\u0000\u0000\u02b1\u02b3\u0005\u008f\u0000\u0000\u02b2\u02b0\u0001\u0000"+
		"\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000\u02b3\u02b4\u0001\u0000"+
		"\u0000\u0000\u02b4\u02b8\u0005\u007f\u0000\u0000\u02b5\u02b7\u0003\u000e"+
		"\u0007\u0000\u02b6\u02b5\u0001\u0000\u0000\u0000\u02b7\u02ba\u0001\u0000"+
		"\u0000\u0000\u02b8\u02b6\u0001\u0000\u0000\u0000\u02b8\u02b9\u0001\u0000"+
		"\u0000\u0000\u02b9\u02bb\u0001\u0000\u0000\u0000\u02ba\u02b8\u0001\u0000"+
		"\u0000\u0000\u02bb\u02bc\u0005\u0080\u0000\u0000\u02bc\r\u0001\u0000\u0000"+
		"\u0000\u02bd\u02be\u0005\u0007\u0000\u0000\u02be\u02bf\u0005\u008f\u0000"+
		"\u0000\u02bf\u02c1\u0005}\u0000\u0000\u02c0\u02c2\u00036\u001b\u0000\u02c1"+
		"\u02c0\u0001\u0000\u0000\u0000\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2"+
		"\u02c3\u0001\u0000\u0000\u0000\u02c3\u02c6\u0005~\u0000\u0000\u02c4\u02c5"+
		"\u0005\u0088\u0000\u0000\u02c5\u02c7\u0003:\u001d\u0000\u02c6\u02c4\u0001"+
		"\u0000\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u02c8\u0001"+
		"\u0000\u0000\u0000\u02c8\u02c9\u0005\u0086\u0000\u0000\u02c9\u000f\u0001"+
		"\u0000\u0000\u0000\u02ca\u02cb\u0005\u0007\u0000\u0000\u02cb\u02cd\u0005"+
		"\u008f\u0000\u0000\u02cc\u02ce\u0003,\u0016\u0000\u02cd\u02cc\u0001\u0000"+
		"\u0000\u0000\u02cd\u02ce\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001\u0000"+
		"\u0000\u0000\u02cf\u02d1\u0005}\u0000\u0000\u02d0\u02d2\u00036\u001b\u0000"+
		"\u02d1\u02d0\u0001\u0000\u0000\u0000\u02d1\u02d2\u0001\u0000\u0000\u0000"+
		"\u02d2\u02d3\u0001\u0000\u0000\u0000\u02d3\u02d6\u0005~\u0000\u0000\u02d4"+
		"\u02d5\u0005\u0088\u0000\u0000\u02d5\u02d7\u0003:\u001d\u0000\u02d6\u02d4"+
		"\u0001\u0000\u0000\u0000\u02d6\u02d7\u0001\u0000\u0000\u0000\u02d7\u02d9"+
		"\u0001\u0000\u0000\u0000\u02d8\u02da\u00032\u0019\u0000\u02d9\u02d8\u0001"+
		"\u0000\u0000\u0000\u02d9\u02da\u0001\u0000\u0000\u0000\u02da\u02e4\u0001"+
		"\u0000\u0000\u0000\u02db\u02df\u0005\u007f\u0000\u0000\u02dc\u02de\u0003"+
		"T*\u0000\u02dd\u02dc\u0001\u0000\u0000\u0000\u02de\u02e1\u0001\u0000\u0000"+
		"\u0000\u02df\u02dd\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e2\u0001\u0000\u0000\u0000\u02e1\u02df\u0001\u0000\u0000"+
		"\u0000\u02e2\u02e5\u0005\u0080\u0000\u0000\u02e3\u02e5\u0005\u0086\u0000"+
		"\u0000\u02e4\u02db\u0001\u0000\u0000\u0000\u02e4\u02e3\u0001\u0000\u0000"+
		"\u0000\u02e5\u0011\u0001\u0000\u0000\u0000\u02e6\u02f2\u0003\u0014\n\u0000"+
		"\u02e7\u02f2\u0003\u0016\u000b\u0000\u02e8\u02f2\u0003\u001a\r\u0000\u02e9"+
		"\u02f2\u0003\u001c\u000e\u0000\u02ea\u02f2\u0003\u001e\u000f\u0000\u02eb"+
		"\u02f2\u0003 \u0010\u0000\u02ec\u02f2\u0003\"\u0011\u0000\u02ed\u02f2"+
		"\u0003$\u0012\u0000\u02ee\u02f2\u0003&\u0013\u0000\u02ef\u02f2\u0003("+
		"\u0014\u0000\u02f0\u02f2\u0003\u00dam\u0000\u02f1\u02e6\u0001\u0000\u0000"+
		"\u0000\u02f1\u02e7\u0001\u0000\u0000\u0000\u02f1\u02e8\u0001\u0000\u0000"+
		"\u0000\u02f1\u02e9\u0001\u0000\u0000\u0000\u02f1\u02ea\u0001\u0000\u0000"+
		"\u0000\u02f1\u02eb\u0001\u0000\u0000\u0000\u02f1\u02ec\u0001\u0000\u0000"+
		"\u0000\u02f1\u02ed\u0001\u0000\u0000\u0000\u02f1\u02ee\u0001\u0000\u0000"+
		"\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000\u02f1\u02f0\u0001\u0000\u0000"+
		"\u0000\u02f2\u0013\u0001\u0000\u0000\u0000\u02f3\u02f4\u0007\u0002\u0000"+
		"\u0000\u02f4\u0015\u0001\u0000\u0000\u0000\u02f5\u02f6\u0005\'\u0000\u0000"+
		"\u02f6\u02f7\u0005n\u0000\u0000\u02f7\u02f8\u0003\u0018\f\u0000\u02f8"+
		"\u02f9\u0005o\u0000\u0000\u02f9\u0320\u0001\u0000\u0000\u0000\u02fa\u02fb"+
		"\u0005(\u0000\u0000\u02fb\u02fc\u0005n\u0000\u0000\u02fc\u02fd\u0003\u0012"+
		"\t\u0000\u02fd\u02fe\u0005o\u0000\u0000\u02fe\u0320\u0001\u0000\u0000"+
		"\u0000\u02ff\u0300\u0005)\u0000\u0000\u0300\u0301\u0005n\u0000\u0000\u0301"+
		"\u0302\u0003\u0018\f\u0000\u0302\u0303\u0005o\u0000\u0000\u0303\u0320"+
		"\u0001\u0000\u0000\u0000\u0304\u0305\u0005*\u0000\u0000\u0305\u0306\u0005"+
		"n\u0000\u0000\u0306\u0307\u0003\u0018\f\u0000\u0307\u0308\u0005o\u0000"+
		"\u0000\u0308\u0320\u0001\u0000\u0000\u0000\u0309\u030a\u0005+\u0000\u0000"+
		"\u030a\u030b\u0005n\u0000\u0000\u030b\u030c\u0003\u0018\f\u0000\u030c"+
		"\u030d\u0005o\u0000\u0000\u030d\u0320\u0001\u0000\u0000\u0000\u030e\u030f"+
		"\u0005,\u0000\u0000\u030f\u0310\u0005n\u0000\u0000\u0310\u0311\u0003\u0018"+
		"\f\u0000\u0311\u0312\u0005o\u0000\u0000\u0312\u0320\u0001\u0000\u0000"+
		"\u0000\u0313\u0314\u0005-\u0000\u0000\u0314\u0315\u0005n\u0000\u0000\u0315"+
		"\u0316\u0003\u0018\f\u0000\u0316\u0317\u0005o\u0000\u0000\u0317\u0320"+
		"\u0001\u0000\u0000\u0000\u0318\u0319\u0005.\u0000\u0000\u0319\u031a\u0005"+
		"n\u0000\u0000\u031a\u031b\u0003\u0018\f\u0000\u031b\u031c\u0005o\u0000"+
		"\u0000\u031c\u0320\u0001\u0000\u0000\u0000\u031d\u0320\u0005/\u0000\u0000"+
		"\u031e\u0320\u00050\u0000\u0000\u031f\u02f5\u0001\u0000\u0000\u0000\u031f"+
		"\u02fa\u0001\u0000\u0000\u0000\u031f\u02ff\u0001\u0000\u0000\u0000\u031f"+
		"\u0304\u0001\u0000\u0000\u0000\u031f\u0309\u0001\u0000\u0000\u0000\u031f"+
		"\u030e\u0001\u0000\u0000\u0000\u031f\u0313\u0001\u0000\u0000\u0000\u031f"+
		"\u0318\u0001\u0000\u0000\u0000\u031f\u031d\u0001\u0000\u0000\u0000\u031f"+
		"\u031e\u0001\u0000\u0000\u0000\u0320\u0017\u0001\u0000\u0000\u0000\u0321"+
		"\u032e\u0005T\u0000\u0000\u0322\u032e\u0005U\u0000\u0000\u0323\u032e\u0005"+
		"V\u0000\u0000\u0324\u032e\u0005W\u0000\u0000\u0325\u032e\u0005X\u0000"+
		"\u0000\u0326\u032e\u0005Y\u0000\u0000\u0327\u032e\u0005Z\u0000\u0000\u0328"+
		"\u032e\u0005[\u0000\u0000\u0329\u032e\u0005\\\u0000\u0000\u032a\u032e"+
		"\u0005]\u0000\u0000\u032b\u032e\u0005^\u0000\u0000\u032c\u032e\u0003\u001a"+
		"\r\u0000\u032d\u0321\u0001\u0000\u0000\u0000\u032d\u0322\u0001\u0000\u0000"+
		"\u0000\u032d\u0323\u0001\u0000\u0000\u0000\u032d\u0324\u0001\u0000\u0000"+
		"\u0000\u032d\u0325\u0001\u0000\u0000\u0000\u032d\u0326\u0001\u0000\u0000"+
		"\u0000\u032d\u0327\u0001\u0000\u0000\u0000\u032d\u0328\u0001\u0000\u0000"+
		"\u0000\u032d\u0329\u0001\u0000\u0000\u0000\u032d\u032a\u0001\u0000\u0000"+
		"\u0000\u032d\u032b\u0001\u0000\u0000\u0000\u032d\u032c\u0001\u0000\u0000"+
		"\u0000\u032e\u0019\u0001\u0000\u0000\u0000\u032f\u0330\u0005\u0092\u0000"+
		"\u0000\u0330\u0332\u0005\u0085\u0000\u0000\u0331\u032f\u0001\u0000\u0000"+
		"\u0000\u0331\u0332\u0001\u0000\u0000\u0000\u0332\u0333\u0001\u0000\u0000"+
		"\u0000\u0333\u0335\u0005\u008f\u0000\u0000\u0334\u0336\u0003\u00d4j\u0000"+
		"\u0335\u0334\u0001\u0000\u0000\u0000\u0335\u0336\u0001\u0000\u0000\u0000"+
		"\u0336\u001b\u0001\u0000\u0000\u0000\u0337\u0340\u0005}\u0000\u0000\u0338"+
		"\u033d\u0003\u0012\t\u0000\u0339\u033a\u0005\u0083\u0000\u0000\u033a\u033c"+
		"\u0003\u0012\t\u0000\u033b\u0339\u0001\u0000\u0000\u0000\u033c\u033f\u0001"+
		"\u0000\u0000\u0000\u033d\u033b\u0001\u0000\u0000\u0000\u033d\u033e\u0001"+
		"\u0000\u0000\u0000\u033e\u0341\u0001\u0000\u0000\u0000\u033f\u033d\u0001"+
		"\u0000\u0000\u0000\u0340\u0338\u0001\u0000\u0000\u0000\u0340\u0341\u0001"+
		"\u0000\u0000\u0000\u0341\u0342\u0001\u0000\u0000\u0000\u0342\u0343\u0005"+
		"~\u0000\u0000\u0343\u001d\u0001\u0000\u0000\u0000\u0344\u0345\u0005\u0081"+
		"\u0000\u0000\u0345\u0346\u0003\u0012\t\u0000\u0346\u0347\u0005\u0086\u0000"+
		"\u0000\u0347\u0348\u0003p8\u0000\u0348\u0349\u0005\u0082\u0000\u0000\u0349"+
		"\u001f\u0001\u0000\u0000\u0000\u034a\u034b\u0005\u0081\u0000\u0000\u034b"+
		"\u034c\u0003\u0012\t\u0000\u034c\u034d\u0005\u0082\u0000\u0000\u034d!"+
		"\u0001\u0000\u0000\u0000\u034e\u034f\u0005f\u0000\u0000\u034f\u0350\u0003"+
		"\u0012\t\u0000\u0350#\u0001\u0000\u0000\u0000\u0351\u0352\u0005f\u0000"+
		"\u0000\u0352\u0353\u0005\t\u0000\u0000\u0353\u0354\u0003\u0012\t\u0000"+
		"\u0354%\u0001\u0000\u0000\u0000\u0355\u0356\u0005\u0007\u0000\u0000\u0356"+
		"\u0358\u0005}\u0000\u0000\u0357\u0359\u00036\u001b\u0000\u0358\u0357\u0001"+
		"\u0000\u0000\u0000\u0358\u0359\u0001\u0000\u0000\u0000\u0359\u035a\u0001"+
		"\u0000\u0000\u0000\u035a\u035d\u0005~\u0000\u0000\u035b\u035c\u0005\u0088"+
		"\u0000\u0000\u035c\u035e\u0003:\u001d\u0000\u035d\u035b\u0001\u0000\u0000"+
		"\u0000\u035d\u035e\u0001\u0000\u0000\u0000\u035e\'\u0001\u0000\u0000\u0000"+
		"\u035f\u0360\u0003\u001a\r\u0000\u0360\u0361\u0005n\u0000\u0000\u0361"+
		"\u0362\u0003*\u0015\u0000\u0362\u0363\u0005o\u0000\u0000\u0363)\u0001"+
		"\u0000\u0000\u0000\u0364\u0369\u0003\u0012\t\u0000\u0365\u0366\u0005\u0083"+
		"\u0000\u0000\u0366\u0368\u0003\u0012\t\u0000\u0367\u0365\u0001\u0000\u0000"+
		"\u0000\u0368\u036b\u0001\u0000\u0000\u0000\u0369\u0367\u0001\u0000\u0000"+
		"\u0000\u0369\u036a\u0001\u0000\u0000\u0000\u036a+\u0001\u0000\u0000\u0000"+
		"\u036b\u0369\u0001\u0000\u0000\u0000\u036c\u036d\u0005n\u0000\u0000\u036d"+
		"\u0372\u0003.\u0017\u0000\u036e\u036f\u0005\u0083\u0000\u0000\u036f\u0371"+
		"\u0003.\u0017\u0000\u0370\u036e\u0001\u0000\u0000\u0000\u0371\u0374\u0001"+
		"\u0000\u0000\u0000\u0372\u0370\u0001\u0000\u0000\u0000\u0372\u0373\u0001"+
		"\u0000\u0000\u0000\u0373\u0375\u0001\u0000\u0000\u0000\u0374\u0372\u0001"+
		"\u0000\u0000\u0000\u0375\u0376\u0005o\u0000\u0000\u0376-\u0001\u0000\u0000"+
		"\u0000\u0377\u0381\u0005\u008f\u0000\u0000\u0378\u0379\u0005\u0084\u0000"+
		"\u0000\u0379\u037e\u00030\u0018\u0000\u037a\u037b\u0005_\u0000\u0000\u037b"+
		"\u037d\u00030\u0018\u0000\u037c\u037a\u0001\u0000\u0000\u0000\u037d\u0380"+
		"\u0001\u0000\u0000\u0000\u037e\u037c\u0001\u0000\u0000\u0000\u037e\u037f"+
		"\u0001\u0000\u0000\u0000\u037f\u0382\u0001\u0000\u0000\u0000\u0380\u037e"+
		"\u0001\u0000\u0000\u0000\u0381\u0378\u0001\u0000\u0000\u0000\u0381\u0382"+
		"\u0001\u0000\u0000\u0000\u0382/\u0001\u0000\u0000\u0000\u0383\u0394\u0003"+
		"\u001a\r\u0000\u0384\u0394\u0005\u0090\u0000\u0000\u0385\u0387\u0005\u008a"+
		"\u0000\u0000\u0386\u0385\u0001\u0000\u0000\u0000\u0386\u0387\u0001\u0000"+
		"\u0000\u0000\u0387\u0388\u0001\u0000\u0000\u0000\u0388\u0389\u0005}\u0000"+
		"\u0000\u0389\u038e\u00030\u0018\u0000\u038a\u038b\u0005_\u0000\u0000\u038b"+
		"\u038d\u00030\u0018\u0000\u038c\u038a\u0001\u0000\u0000\u0000\u038d\u0390"+
		"\u0001\u0000\u0000\u0000\u038e\u038c\u0001\u0000\u0000\u0000\u038e\u038f"+
		"\u0001\u0000\u0000\u0000\u038f\u0391\u0001\u0000\u0000\u0000\u0390\u038e"+
		"\u0001\u0000\u0000\u0000\u0391\u0392\u0005~\u0000\u0000\u0392\u0394\u0001"+
		"\u0000\u0000\u0000\u0393\u0383\u0001\u0000\u0000\u0000\u0393\u0384\u0001"+
		"\u0000\u0000\u0000\u0393\u0386\u0001\u0000\u0000\u0000\u03941\u0001\u0000"+
		"\u0000\u0000\u0395\u0396\u0005\u001f\u0000\u0000\u0396\u039b\u00034\u001a"+
		"\u0000\u0397\u0398\u0005\u0083\u0000\u0000\u0398\u039a\u00034\u001a\u0000"+
		"\u0399\u0397\u0001\u0000\u0000\u0000\u039a\u039d\u0001\u0000\u0000\u0000"+
		"\u039b\u0399\u0001\u0000\u0000\u0000\u039b\u039c\u0001\u0000\u0000\u0000"+
		"\u039c3\u0001\u0000\u0000\u0000\u039d\u039b\u0001\u0000\u0000\u0000\u039e"+
		"\u039f\u0003.\u0017\u0000\u039f\u03a0\u0005\u0084\u0000\u0000\u03a0\u03a5"+
		"\u00030\u0018\u0000\u03a1\u03a2\u0005_\u0000\u0000\u03a2\u03a4\u00030"+
		"\u0018\u0000\u03a3\u03a1\u0001\u0000\u0000\u0000\u03a4\u03a7\u0001\u0000"+
		"\u0000\u0000\u03a5\u03a3\u0001\u0000\u0000\u0000\u03a5\u03a6\u0001\u0000"+
		"\u0000\u0000\u03a65\u0001\u0000\u0000\u0000\u03a7\u03a5\u0001\u0000\u0000"+
		"\u0000\u03a8\u03ad\u00038\u001c\u0000\u03a9\u03aa\u0005\u0083\u0000\u0000"+
		"\u03aa\u03ac\u00038\u001c\u0000\u03ab\u03a9\u0001\u0000\u0000\u0000\u03ac"+
		"\u03af\u0001\u0000\u0000\u0000\u03ad\u03ab\u0001\u0000\u0000\u0000\u03ad"+
		"\u03ae\u0001\u0000\u0000\u0000\u03ae7\u0001\u0000\u0000\u0000\u03af\u03ad"+
		"\u0001\u0000\u0000\u0000\u03b0\u03b5\u0005\t\u0000\u0000\u03b1\u03b5\u0005"+
		"\u00c0\u0000\u0000\u03b2\u03b3\u0005\t\u0000\u0000\u03b3\u03b5\u0005\u00c0"+
		"\u0000\u0000\u03b4\u03b0\u0001\u0000\u0000\u0000\u03b4\u03b1\u0001\u0000"+
		"\u0000\u0000\u03b4\u03b2\u0001\u0000\u0000\u0000\u03b4\u03b5\u0001\u0000"+
		"\u0000\u0000\u03b5\u03b6\u0001\u0000\u0000\u0000\u03b6\u03b7\u0005\u008f"+
		"\u0000\u0000\u03b7\u03b8\u0005\u0084\u0000\u0000\u03b8\u03b9\u0003\u0012"+
		"\t\u0000\u03b99\u0001\u0000\u0000\u0000\u03ba\u03c8\u0003\u0012\t\u0000"+
		"\u03bb\u03c4\u0005}\u0000\u0000\u03bc\u03c1\u0003\u0012\t\u0000\u03bd"+
		"\u03be\u0005\u0083\u0000\u0000\u03be\u03c0\u0003\u0012\t\u0000\u03bf\u03bd"+
		"\u0001\u0000\u0000\u0000\u03c0\u03c3\u0001\u0000\u0000\u0000\u03c1\u03bf"+
		"\u0001\u0000\u0000\u0000\u03c1\u03c2\u0001\u0000\u0000\u0000\u03c2\u03c5"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c1\u0001\u0000\u0000\u0000\u03c4\u03bc"+
		"\u0001\u0000\u0000\u0000\u03c4\u03c5\u0001\u0000\u0000\u0000\u03c5\u03c6"+
		"\u0001\u0000\u0000\u0000\u03c6\u03c8\u0005~\u0000\u0000\u03c7\u03ba\u0001"+
		"\u0000\u0000\u0000\u03c7\u03bb\u0001\u0000\u0000\u0000\u03c8;\u0001\u0000"+
		"\u0000\u0000\u03c9\u03ca\u0005\f\u0000\u0000\u03ca\u03cc\u0005\u008f\u0000"+
		"\u0000\u03cb\u03cd\u0003,\u0016\u0000\u03cc\u03cb\u0001\u0000\u0000\u0000"+
		"\u03cc\u03cd\u0001\u0000\u0000\u0000\u03cd\u03d3\u0001\u0000\u0000\u0000"+
		"\u03ce\u03d0\u0005}\u0000\u0000\u03cf\u03d1\u0003>\u001f\u0000\u03d0\u03cf"+
		"\u0001\u0000\u0000\u0000\u03d0\u03d1\u0001\u0000\u0000\u0000\u03d1\u03d2"+
		"\u0001\u0000\u0000\u0000\u03d2\u03d4\u0005~\u0000\u0000\u03d3\u03ce\u0001"+
		"\u0000\u0000\u0000\u03d3\u03d4\u0001\u0000\u0000\u0000\u03d4\u03d6\u0001"+
		"\u0000\u0000\u0000\u03d5\u03d7\u00032\u0019\u0000\u03d6\u03d5\u0001\u0000"+
		"\u0000\u0000\u03d6\u03d7\u0001\u0000\u0000\u0000\u03d7\u03e1\u0001\u0000"+
		"\u0000\u0000\u03d8\u03dc\u0005\u007f\u0000\u0000\u03d9\u03db\u0003@ \u0000"+
		"\u03da\u03d9\u0001\u0000\u0000\u0000\u03db\u03de\u0001\u0000\u0000\u0000"+
		"\u03dc\u03da\u0001\u0000\u0000\u0000\u03dc\u03dd\u0001\u0000\u0000\u0000"+
		"\u03dd\u03df\u0001\u0000\u0000\u0000\u03de\u03dc\u0001\u0000\u0000\u0000"+
		"\u03df\u03e2\u0005\u0080\u0000\u0000\u03e0\u03e2\u0005\u0086\u0000\u0000"+
		"\u03e1\u03d8\u0001\u0000\u0000\u0000\u03e1\u03e0\u0001\u0000\u0000\u0000"+
		"\u03e2=\u0001\u0000\u0000\u0000\u03e3\u03e8\u0003@ \u0000\u03e4\u03e5"+
		"\u0005\u0083\u0000\u0000\u03e5\u03e7\u0003@ \u0000\u03e6\u03e4\u0001\u0000"+
		"\u0000\u0000\u03e7\u03ea\u0001\u0000\u0000\u0000\u03e8\u03e6\u0001\u0000"+
		"\u0000\u0000\u03e8\u03e9\u0001\u0000\u0000\u0000\u03e9?\u0001\u0000\u0000"+
		"\u0000\u03ea\u03e8\u0001\u0000\u0000\u0000\u03eb\u03ed\u0005$\u0000\u0000"+
		"\u03ec\u03eb\u0001\u0000\u0000\u0000\u03ec\u03ed\u0001\u0000\u0000\u0000"+
		"\u03ed\u03ee\u0001\u0000\u0000\u0000\u03ee\u03ef\u0005\u008f\u0000\u0000"+
		"\u03ef\u03f0\u0005\u0084\u0000\u0000\u03f0\u03f1\u0003\u0012\t\u0000\u03f1"+
		"A\u0001\u0000\u0000\u0000\u03f2\u03f3\u0005\r\u0000\u0000\u03f3\u03f5"+
		"\u0005\u008f\u0000\u0000\u03f4\u03f6\u0003,\u0016\u0000\u03f5\u03f4\u0001"+
		"\u0000\u0000\u0000\u03f5\u03f6\u0001\u0000\u0000\u0000\u03f6\u03f8\u0001"+
		"\u0000\u0000\u0000\u03f7\u03f9\u00032\u0019\u0000\u03f8\u03f7\u0001\u0000"+
		"\u0000\u0000\u03f8\u03f9\u0001\u0000\u0000\u0000\u03f9\u03fa\u0001\u0000"+
		"\u0000\u0000\u03fa\u03fe\u0005\u007f\u0000\u0000\u03fb\u03fd\u0003D\""+
		"\u0000\u03fc\u03fb\u0001\u0000\u0000\u0000\u03fd\u0400\u0001\u0000\u0000"+
		"\u0000\u03fe\u03fc\u0001\u0000\u0000\u0000\u03fe\u03ff\u0001\u0000\u0000"+
		"\u0000\u03ff\u0401\u0001\u0000\u0000\u0000\u0400\u03fe\u0001\u0000\u0000"+
		"\u0000\u0401\u0402\u0005\u0080\u0000\u0000\u0402C\u0001\u0000\u0000\u0000"+
		"\u0403\u0410\u0005\u008f\u0000\u0000\u0404\u040d\u0005}\u0000\u0000\u0405"+
		"\u040a\u0003\u0012\t\u0000\u0406\u0407\u0005\u0083\u0000\u0000\u0407\u0409"+
		"\u0003\u0012\t\u0000\u0408\u0406\u0001\u0000\u0000\u0000\u0409\u040c\u0001"+
		"\u0000\u0000\u0000\u040a\u0408\u0001\u0000\u0000\u0000\u040a\u040b\u0001"+
		"\u0000\u0000\u0000\u040b\u040e\u0001\u0000\u0000\u0000\u040c\u040a\u0001"+
		"\u0000\u0000\u0000\u040d\u0405\u0001\u0000\u0000\u0000\u040d\u040e\u0001"+
		"\u0000\u0000\u0000\u040e\u040f\u0001\u0000\u0000\u0000\u040f\u0411\u0005"+
		"~\u0000\u0000\u0410\u0404\u0001\u0000\u0000\u0000\u0410\u0411\u0001\u0000"+
		"\u0000\u0000\u0411E\u0001\u0000\u0000\u0000\u0412\u0413\u0005\u000e\u0000"+
		"\u0000\u0413\u0415\u0005\u008f\u0000\u0000\u0414\u0416\u0003,\u0016\u0000"+
		"\u0415\u0414\u0001\u0000\u0000\u0000\u0415\u0416\u0001\u0000\u0000\u0000"+
		"\u0416\u0418\u0001\u0000\u0000\u0000\u0417\u0419\u00032\u0019\u0000\u0418"+
		"\u0417\u0001\u0000\u0000\u0000\u0418\u0419\u0001\u0000\u0000\u0000\u0419"+
		"\u041a\u0001\u0000\u0000\u0000\u041a\u041e\u0005\u007f\u0000\u0000\u041b"+
		"\u041d\u0003H$\u0000\u041c\u041b\u0001\u0000\u0000\u0000\u041d\u0420\u0001"+
		"\u0000\u0000\u0000\u041e\u041c\u0001\u0000\u0000\u0000\u041e\u041f\u0001"+
		"\u0000\u0000\u0000\u041f\u0421\u0001\u0000\u0000\u0000\u0420\u041e\u0001"+
		"\u0000\u0000\u0000\u0421\u0422\u0005\u0080\u0000\u0000\u0422G\u0001\u0000"+
		"\u0000\u0000\u0423\u0427\u0003\u0010\b\u0000\u0424\u0427\u0003P(\u0000"+
		"\u0425\u0427\u0003N\'\u0000\u0426\u0423\u0001\u0000\u0000\u0000\u0426"+
		"\u0424\u0001\u0000\u0000\u0000\u0426\u0425\u0001\u0000\u0000\u0000\u0427"+
		"I\u0001\u0000\u0000\u0000\u0428\u042a\u0005\u000f\u0000\u0000\u0429\u042b"+
		"\u0003,\u0016\u0000\u042a\u0429\u0001\u0000\u0000\u0000\u042a\u042b\u0001"+
		"\u0000\u0000\u0000\u042b\u042c\u0001\u0000\u0000\u0000\u042c\u042e\u0003"+
		"\u001a\r\u0000\u042d\u042f\u00032\u0019\u0000\u042e\u042d\u0001\u0000"+
		"\u0000\u0000\u042e\u042f\u0001\u0000\u0000\u0000\u042f\u0430\u0001\u0000"+
		"\u0000\u0000\u0430\u0431\u0005\u0010\u0000\u0000\u0431\u0432\u0003\u001a"+
		"\r\u0000\u0432\u0436\u0005\u007f\u0000\u0000\u0433\u0435\u0003L&\u0000"+
		"\u0434\u0433\u0001\u0000\u0000\u0000\u0435\u0438\u0001\u0000\u0000\u0000"+
		"\u0436\u0434\u0001\u0000\u0000\u0000\u0436\u0437\u0001\u0000\u0000\u0000"+
		"\u0437\u0439\u0001\u0000\u0000\u0000\u0438\u0436\u0001\u0000\u0000\u0000"+
		"\u0439\u043a\u0005\u0080\u0000\u0000\u043aK\u0001\u0000\u0000\u0000\u043b"+
		"\u043f\u0003\u0010\b\u0000\u043c\u043f\u0003P(\u0000\u043d\u043f\u0003"+
		"N\'\u0000\u043e\u043b\u0001\u0000\u0000\u0000\u043e\u043c\u0001\u0000"+
		"\u0000\u0000\u043e\u043d\u0001\u0000\u0000\u0000\u043fM\u0001\u0000\u0000"+
		"\u0000\u0440\u0441\u0005\u001d\u0000\u0000\u0441\u0443\u0005\u008f\u0000"+
		"\u0000\u0442\u0444\u0003,\u0016\u0000\u0443\u0442\u0001\u0000\u0000\u0000"+
		"\u0443\u0444\u0001\u0000\u0000\u0000\u0444\u0446\u0001\u0000\u0000\u0000"+
		"\u0445\u0447\u00032\u0019\u0000\u0446\u0445\u0001\u0000\u0000\u0000\u0446"+
		"\u0447\u0001\u0000\u0000\u0000\u0447\u0448\u0001\u0000\u0000\u0000\u0448"+
		"\u0449\u0005r\u0000\u0000\u0449\u044a\u0003\u0012\t\u0000\u044a\u044b"+
		"\u0005\u0086\u0000\u0000\u044bO\u0001\u0000\u0000\u0000\u044c\u044d\u0005"+
		"\n\u0000\u0000\u044d\u044e\u0005\u008f\u0000\u0000\u044e\u044f\u0005\u0084"+
		"\u0000\u0000\u044f\u0450\u0003\u0012\t\u0000\u0450\u0451\u0005r\u0000"+
		"\u0000\u0451\u0452\u0003p8\u0000\u0452\u0453\u0005\u0086\u0000\u0000\u0453"+
		"Q\u0001\u0000\u0000\u0000\u0454\u0456\u0005\u000b\u0000\u0000\u0455\u0457"+
		"\u0005\t\u0000\u0000\u0456\u0455\u0001\u0000\u0000\u0000\u0456\u0457\u0001"+
		"\u0000\u0000\u0000\u0457\u0458\u0001\u0000\u0000\u0000\u0458\u0459\u0005"+
		"\u008f\u0000\u0000\u0459\u045a\u0005\u0084\u0000\u0000\u045a\u045b\u0003"+
		"\u0012\t\u0000\u045b\u045c\u0005r\u0000\u0000\u045c\u045d\u0003p8\u0000"+
		"\u045d\u045e\u0005\u0086\u0000\u0000\u045eS\u0001\u0000\u0000\u0000\u045f"+
		"\u046e\u0003V+\u0000\u0460\u046e\u0003X,\u0000\u0461\u046e\u0003Z-\u0000"+
		"\u0462\u046e\u0003\\.\u0000\u0463\u046e\u0003^/\u0000\u0464\u046e\u0003"+
		"`0\u0000\u0465\u046e\u0003b1\u0000\u0466\u046e\u0003d2\u0000\u0467\u046e"+
		"\u0003h4\u0000\u0468\u046e\u0003j5\u0000\u0469\u046e\u0003l6\u0000\u046a"+
		"\u046e\u0003\u0114\u008a\u0000\u046b\u046e\u0003\u0164\u00b2\u0000\u046c"+
		"\u046e\u0003\u011c\u008e\u0000\u046d\u045f\u0001\u0000\u0000\u0000\u046d"+
		"\u0460\u0001\u0000\u0000\u0000\u046d\u0461\u0001\u0000\u0000\u0000\u046d"+
		"\u0462\u0001\u0000\u0000\u0000\u046d\u0463\u0001\u0000\u0000\u0000\u046d"+
		"\u0464\u0001\u0000\u0000\u0000\u046d\u0465\u0001\u0000\u0000\u0000\u046d"+
		"\u0466\u0001\u0000\u0000\u0000\u046d\u0467\u0001\u0000\u0000\u0000\u046d"+
		"\u0468\u0001\u0000\u0000\u0000\u046d\u0469\u0001\u0000\u0000\u0000\u046d"+
		"\u046a\u0001\u0000\u0000\u0000\u046d\u046b\u0001\u0000\u0000\u0000\u046d"+
		"\u046c\u0001\u0000\u0000\u0000\u046eU\u0001\u0000\u0000\u0000\u046f\u0471"+
		"\u0005\b\u0000\u0000\u0470\u0472\u0005\t\u0000\u0000\u0471\u0470\u0001"+
		"\u0000\u0000\u0000\u0471\u0472\u0001\u0000\u0000\u0000\u0472\u0473\u0001"+
		"\u0000\u0000\u0000\u0473\u0476\u0005\u008f\u0000\u0000\u0474\u0475\u0005"+
		"\u0084\u0000\u0000\u0475\u0477\u0003\u0012\t\u0000\u0476\u0474\u0001\u0000"+
		"\u0000\u0000\u0476\u0477\u0001\u0000\u0000\u0000\u0477\u047a\u0001\u0000"+
		"\u0000\u0000\u0478\u0479\u0005r\u0000\u0000\u0479\u047b\u0003p8\u0000"+
		"\u047a\u0478\u0001\u0000\u0000\u0000\u047a\u047b\u0001\u0000\u0000\u0000"+
		"\u047b\u047c\u0001\u0000\u0000\u0000\u047c\u047d\u0005\u0086\u0000\u0000"+
		"\u047dW\u0001\u0000\u0000\u0000\u047e\u047f\u0003p8\u0000\u047f\u0480"+
		"\u0005\u0086\u0000\u0000\u0480Y\u0001\u0000\u0000\u0000\u0481\u0482\u0003"+
		"p8\u0000\u0482\u0483\u0005r\u0000\u0000\u0483\u0484\u0003p8\u0000\u0484"+
		"\u0485\u0005\u0086\u0000\u0000\u0485[\u0001\u0000\u0000\u0000\u0486\u0488"+
		"\u0005\u0019\u0000\u0000\u0487\u0489\u0003p8\u0000\u0488\u0487\u0001\u0000"+
		"\u0000\u0000\u0488\u0489\u0001\u0000\u0000\u0000\u0489\u048a\u0001\u0000"+
		"\u0000\u0000\u048a\u048b\u0005\u0086\u0000\u0000\u048b]\u0001\u0000\u0000"+
		"\u0000\u048c\u048e\u0005\u0017\u0000\u0000\u048d\u048f\u0003p8\u0000\u048e"+
		"\u048d\u0001\u0000\u0000\u0000\u048e\u048f\u0001\u0000\u0000\u0000\u048f"+
		"\u0490\u0001\u0000\u0000\u0000\u0490\u0491\u0005\u0086\u0000\u0000\u0491"+
		"_\u0001\u0000\u0000\u0000\u0492\u0493\u0005\u0018\u0000\u0000\u0493\u0494"+
		"\u0005\u0086\u0000\u0000\u0494a\u0001\u0000\u0000\u0000\u0495\u0496\u0005"+
		"\u0012\u0000\u0000\u0496\u0497\u0003p8\u0000\u0497\u049b\u0005\u007f\u0000"+
		"\u0000\u0498\u049a\u0003T*\u0000\u0499\u0498\u0001\u0000\u0000\u0000\u049a"+
		"\u049d\u0001\u0000\u0000\u0000\u049b\u0499\u0001\u0000\u0000\u0000\u049b"+
		"\u049c\u0001\u0000\u0000\u0000\u049c\u049e\u0001\u0000\u0000\u0000\u049d"+
		"\u049b\u0001\u0000\u0000\u0000\u049e\u04ad\u0005\u0080\u0000\u0000\u049f"+
		"\u04a0\u0005\u0013\u0000\u0000\u04a0\u04a1\u0005\u0012\u0000\u0000\u04a1"+
		"\u04a2\u0003p8\u0000\u04a2\u04a6\u0005\u007f\u0000\u0000\u04a3\u04a5\u0003"+
		"T*\u0000\u04a4\u04a3\u0001\u0000\u0000\u0000\u04a5\u04a8\u0001\u0000\u0000"+
		"\u0000\u04a6\u04a4\u0001\u0000\u0000\u0000\u04a6\u04a7\u0001\u0000\u0000"+
		"\u0000\u04a7\u04a9\u0001\u0000\u0000\u0000\u04a8\u04a6\u0001\u0000\u0000"+
		"\u0000\u04a9\u04aa\u0005\u0080\u0000\u0000\u04aa\u04ac\u0001\u0000\u0000"+
		"\u0000\u04ab\u049f\u0001\u0000\u0000\u0000\u04ac\u04af\u0001\u0000\u0000"+
		"\u0000\u04ad\u04ab\u0001\u0000\u0000\u0000\u04ad\u04ae\u0001\u0000\u0000"+
		"\u0000\u04ae\u04b9\u0001\u0000\u0000\u0000\u04af\u04ad\u0001\u0000\u0000"+
		"\u0000\u04b0\u04b1\u0005\u0013\u0000\u0000\u04b1\u04b5\u0005\u007f\u0000"+
		"\u0000\u04b2\u04b4\u0003T*\u0000\u04b3\u04b2\u0001\u0000\u0000\u0000\u04b4"+
		"\u04b7\u0001\u0000\u0000\u0000\u04b5\u04b3\u0001\u0000\u0000\u0000\u04b5"+
		"\u04b6\u0001\u0000\u0000\u0000\u04b6\u04b8\u0001\u0000\u0000\u0000\u04b7"+
		"\u04b5\u0001\u0000\u0000\u0000\u04b8\u04ba\u0005\u0080\u0000\u0000\u04b9"+
		"\u04b0\u0001\u0000\u0000\u0000\u04b9\u04ba\u0001\u0000\u0000\u0000\u04ba"+
		"c\u0001\u0000\u0000\u0000\u04bb\u04bc\u0005\u0014\u0000\u0000\u04bc\u04bd"+
		"\u0003p8\u0000\u04bd\u04c1\u0005\u007f\u0000\u0000\u04be\u04c0\u0003f"+
		"3\u0000\u04bf\u04be\u0001\u0000\u0000\u0000\u04c0\u04c3\u0001\u0000\u0000"+
		"\u0000\u04c1\u04bf\u0001\u0000\u0000\u0000\u04c1\u04c2\u0001\u0000\u0000"+
		"\u0000\u04c2\u04c4\u0001\u0000\u0000\u0000\u04c3\u04c1\u0001\u0000\u0000"+
		"\u0000\u04c4\u04c5\u0005\u0080\u0000\u0000\u04c5e\u0001\u0000\u0000\u0000"+
		"\u04c6\u04c7\u0003\u00bc^\u0000\u04c7\u04c8\u0005\u0089\u0000\u0000\u04c8"+
		"\u04c9\u0003T*\u0000\u04c9g\u0001\u0000\u0000\u0000\u04ca\u04cb\u0005"+
		"\u0015\u0000\u0000\u04cb\u04cc\u0003p8\u0000\u04cc\u04d0\u0005\u007f\u0000"+
		"\u0000\u04cd\u04cf\u0003T*\u0000\u04ce\u04cd\u0001\u0000\u0000\u0000\u04cf"+
		"\u04d2\u0001\u0000\u0000\u0000\u04d0\u04ce\u0001\u0000\u0000\u0000\u04d0"+
		"\u04d1\u0001\u0000\u0000\u0000\u04d1\u04d3\u0001\u0000\u0000\u0000\u04d2"+
		"\u04d0\u0001\u0000\u0000\u0000\u04d3\u04d4\u0005\u0080\u0000\u0000\u04d4"+
		"i\u0001\u0000\u0000\u0000\u04d5\u04d6\u0005\u0010\u0000\u0000\u04d6\u04d7"+
		"\u0005\u008f\u0000\u0000\u04d7\u04d8\u0005\u0011\u0000\u0000\u04d8\u04d9"+
		"\u0003p8\u0000\u04d9\u04dd\u0005\u007f\u0000\u0000\u04da\u04dc\u0003T"+
		"*\u0000\u04db\u04da\u0001\u0000\u0000\u0000\u04dc\u04df\u0001\u0000\u0000"+
		"\u0000\u04dd\u04db\u0001\u0000\u0000\u0000\u04dd\u04de\u0001\u0000\u0000"+
		"\u0000\u04de\u04e0\u0001\u0000\u0000\u0000\u04df\u04dd\u0001\u0000\u0000"+
		"\u0000\u04e0\u04e1\u0005\u0080\u0000\u0000\u04e1k\u0001\u0000\u0000\u0000"+
		"\u04e2\u04e3\u0005\u0016\u0000\u0000\u04e3\u04e7\u0005\u007f\u0000\u0000"+
		"\u04e4\u04e6\u0003T*\u0000\u04e5\u04e4\u0001\u0000\u0000\u0000\u04e6\u04e9"+
		"\u0001\u0000\u0000\u0000\u04e7\u04e5\u0001\u0000\u0000\u0000\u04e7\u04e8"+
		"\u0001\u0000\u0000\u0000\u04e8\u04ea\u0001\u0000\u0000\u0000\u04e9\u04e7"+
		"\u0001\u0000\u0000\u0000\u04ea\u04eb\u0005\u0080\u0000\u0000\u04ebm\u0001"+
		"\u0000\u0000\u0000\u04ec\u04fb\u0003r9\u0000\u04ed\u04fb\u0003t:\u0000"+
		"\u04ee\u04fb\u0003\u0086C\u0000\u04ef\u04fb\u0003\u0088D\u0000\u04f0\u04fb"+
		"\u0003\u008aE\u0000\u04f1\u04fb\u0003\u008eG\u0000\u04f2\u04fb\u0003\u0098"+
		"L\u0000\u04f3\u04fb\u0003\u009aM\u0000\u04f4\u04fb\u0003\u009cN\u0000"+
		"\u04f5\u04fb\u0003\u009eO\u0000\u04f6\u04fb\u0003\u00a0P\u0000\u04f7\u04fb"+
		"\u0003\u00a2Q\u0000\u04f8\u04fb\u0003\u00a6S\u0000\u04f9\u04fb\u0003\u00b8"+
		"\\\u0000\u04fa\u04ec\u0001\u0000\u0000\u0000\u04fa\u04ed\u0001\u0000\u0000"+
		"\u0000\u04fa\u04ee\u0001\u0000\u0000\u0000\u04fa\u04ef\u0001\u0000\u0000"+
		"\u0000\u04fa\u04f0\u0001\u0000\u0000\u0000\u04fa\u04f1\u0001\u0000\u0000"+
		"\u0000\u04fa\u04f2\u0001\u0000\u0000\u0000\u04fa\u04f3\u0001\u0000\u0000"+
		"\u0000\u04fa\u04f4\u0001\u0000\u0000\u0000\u04fa\u04f5\u0001\u0000\u0000"+
		"\u0000\u04fa\u04f6\u0001\u0000\u0000\u0000\u04fa\u04f7\u0001\u0000\u0000"+
		"\u0000\u04fa\u04f8\u0001\u0000\u0000\u0000\u04fa\u04f9\u0001\u0000\u0000"+
		"\u0000\u04fbo\u0001\u0000\u0000\u0000\u04fc\u0509\u0003n7\u0000\u04fd"+
		"\u0509\u0003z=\u0000\u04fe\u0509\u0003v;\u0000\u04ff\u0509\u0003|>\u0000"+
		"\u0500\u0509\u0003\u0080@\u0000\u0501\u0509\u0003\u0082A\u0000\u0502\u0509"+
		"\u0003\u0084B\u0000\u0503\u0509\u0003\u0090H\u0000\u0504\u0509\u0003\u0092"+
		"I\u0000\u0505\u0509\u0003\u0094J\u0000\u0506\u0509\u0003\u0096K\u0000"+
		"\u0507\u0509\u0003\u00a4R\u0000\u0508\u04fc\u0001\u0000\u0000\u0000\u0508"+
		"\u04fd\u0001\u0000\u0000\u0000\u0508\u04fe\u0001\u0000\u0000\u0000\u0508"+
		"\u04ff\u0001\u0000\u0000\u0000\u0508\u0500\u0001\u0000\u0000\u0000\u0508"+
		"\u0501\u0001\u0000\u0000\u0000\u0508\u0502\u0001\u0000\u0000\u0000\u0508"+
		"\u0503\u0001\u0000\u0000\u0000\u0508\u0504\u0001\u0000\u0000\u0000\u0508"+
		"\u0505\u0001\u0000\u0000\u0000\u0508\u0506\u0001\u0000\u0000\u0000\u0508"+
		"\u0507\u0001\u0000\u0000\u0000\u0509q\u0001\u0000\u0000\u0000\u050a\u050b"+
		"\u0007\u0003\u0000\u0000\u050bs\u0001\u0000\u0000\u0000\u050c\u0511\u0003"+
		"\u001a\r\u0000\u050d\u050e\u0005\u0092\u0000\u0000\u050e\u050f\u0005\u0085"+
		"\u0000\u0000\u050f\u0511\u0005\u008f\u0000\u0000\u0510\u050c\u0001\u0000"+
		"\u0000\u0000\u0510\u050d\u0001\u0000\u0000\u0000\u0511u\u0001\u0000\u0000"+
		"\u0000\u0512\u0513\u0006;\uffff\uffff\u0000\u0513\u0514\u0003n7\u0000"+
		"\u0514\u0515\u0003x<\u0000\u0515\u0516\u0003n7\u0000\u0516\u051d\u0001"+
		"\u0000\u0000\u0000\u0517\u0518\n\u0001\u0000\u0000\u0518\u0519\u0003x"+
		"<\u0000\u0519\u051a\u0003n7\u0000\u051a\u051c\u0001\u0000\u0000\u0000"+
		"\u051b\u0517\u0001\u0000\u0000\u0000\u051c\u051f\u0001\u0000\u0000\u0000"+
		"\u051d\u051b\u0001\u0000\u0000\u0000\u051d\u051e\u0001\u0000\u0000\u0000"+
		"\u051ew\u0001\u0000\u0000\u0000\u051f\u051d\u0001\u0000\u0000\u0000\u0520"+
		"\u0521\u0007\u0004\u0000\u0000\u0521y\u0001\u0000\u0000\u0000\u0522\u0529"+
		"\u0005e\u0000\u0000\u0523\u0529\u0005`\u0000\u0000\u0524\u0529\u0005a"+
		"\u0000\u0000\u0525\u0529\u0005f\u0000\u0000\u0526\u0527\u0005f\u0000\u0000"+
		"\u0527\u0529\u0005\t\u0000\u0000\u0528\u0522\u0001\u0000\u0000\u0000\u0528"+
		"\u0523\u0001\u0000\u0000\u0000\u0528\u0524\u0001\u0000\u0000\u0000\u0528"+
		"\u0525\u0001\u0000\u0000\u0000\u0528\u0526\u0001\u0000\u0000\u0000\u0529"+
		"\u052a\u0001\u0000\u0000\u0000\u052a\u052b\u0003p8\u0000\u052b{\u0001"+
		"\u0000\u0000\u0000\u052c\u052d\u0003n7\u0000\u052d\u052f\u0005}\u0000"+
		"\u0000\u052e\u0530\u0003~?\u0000\u052f\u052e\u0001\u0000\u0000\u0000\u052f"+
		"\u0530\u0001\u0000\u0000\u0000\u0530\u0531\u0001\u0000\u0000\u0000\u0531"+
		"\u0532\u0005~\u0000\u0000\u0532}\u0001\u0000\u0000\u0000\u0533\u0538\u0003"+
		"n7\u0000\u0534\u0535\u0005\u0083\u0000\u0000\u0535\u0537\u0003n7\u0000"+
		"\u0536\u0534\u0001\u0000\u0000\u0000\u0537\u053a\u0001\u0000\u0000\u0000"+
		"\u0538\u0536\u0001\u0000\u0000\u0000\u0538\u0539\u0001\u0000\u0000\u0000"+
		"\u0539\u007f\u0001\u0000\u0000\u0000\u053a\u0538\u0001\u0000\u0000\u0000"+
		"\u053b\u053c\u0003n7\u0000\u053c\u053d\u0005\u0081\u0000\u0000\u053d\u053e"+
		"\u0003n7\u0000\u053e\u053f\u0005\u0082\u0000\u0000\u053f\u0081\u0001\u0000"+
		"\u0000\u0000\u0540\u0541\u0003n7\u0000\u0541\u0542\u0005\u0087\u0000\u0000"+
		"\u0542\u0543\u0005\u008f\u0000\u0000\u0543\u0083\u0001\u0000\u0000\u0000"+
		"\u0544\u0545\u0003n7\u0000\u0545\u0546\u0005\u0087\u0000\u0000\u0546\u0547"+
		"\u0005\u008f\u0000\u0000\u0547\u0549\u0005}\u0000\u0000\u0548\u054a\u0003"+
		"~?\u0000\u0549\u0548\u0001\u0000\u0000\u0000\u0549\u054a\u0001\u0000\u0000"+
		"\u0000\u054a\u054b\u0001\u0000\u0000\u0000\u054b\u054c\u0005~\u0000\u0000"+
		"\u054c\u0085\u0001\u0000\u0000\u0000\u054d\u0556\u0005}\u0000\u0000\u054e"+
		"\u0553\u0003n7\u0000\u054f\u0550\u0005\u0083\u0000\u0000\u0550\u0552\u0003"+
		"n7\u0000\u0551\u054f\u0001\u0000\u0000\u0000\u0552\u0555\u0001\u0000\u0000"+
		"\u0000\u0553\u0551\u0001\u0000\u0000\u0000\u0553\u0554\u0001\u0000\u0000"+
		"\u0000\u0554\u0557\u0001\u0000\u0000\u0000\u0555\u0553\u0001\u0000\u0000"+
		"\u0000\u0556\u054e\u0001\u0000\u0000\u0000\u0556\u0557\u0001\u0000\u0000"+
		"\u0000\u0557\u0558\u0001\u0000\u0000\u0000\u0558\u0559\u0005~\u0000\u0000"+
		"\u0559\u0087\u0001\u0000\u0000\u0000\u055a\u0563\u0005\u0081\u0000\u0000"+
		"\u055b\u0560\u0003n7\u0000\u055c\u055d\u0005\u0083\u0000\u0000\u055d\u055f"+
		"\u0003n7\u0000\u055e\u055c\u0001\u0000\u0000\u0000\u055f\u0562\u0001\u0000"+
		"\u0000\u0000\u0560\u055e\u0001\u0000\u0000\u0000\u0560\u0561\u0001\u0000"+
		"\u0000\u0000\u0561\u0564\u0001\u0000\u0000\u0000\u0562\u0560\u0001\u0000"+
		"\u0000\u0000\u0563\u055b\u0001\u0000\u0000\u0000\u0563\u0564\u0001\u0000"+
		"\u0000\u0000\u0564\u0565\u0001\u0000\u0000\u0000\u0565\u0566\u0005\u0082"+
		"\u0000\u0000\u0566\u0089\u0001\u0000\u0000\u0000\u0567\u0568\u0003\u001a"+
		"\r\u0000\u0568\u0571\u0005\u007f\u0000\u0000\u0569\u056e\u0003\u008cF"+
		"\u0000\u056a\u056b\u0005\u0083\u0000\u0000\u056b\u056d\u0003\u008cF\u0000"+
		"\u056c\u056a\u0001\u0000\u0000\u0000\u056d\u0570\u0001\u0000\u0000\u0000"+
		"\u056e\u056c\u0001\u0000\u0000\u0000\u056e\u056f\u0001\u0000\u0000\u0000"+
		"\u056f\u0572\u0001\u0000\u0000\u0000\u0570\u056e\u0001\u0000\u0000\u0000"+
		"\u0571\u0569\u0001\u0000\u0000\u0000\u0571\u0572\u0001\u0000\u0000\u0000"+
		"\u0572\u0573\u0001\u0000\u0000\u0000\u0573\u0574\u0005\u0080\u0000\u0000"+
		"\u0574\u008b\u0001\u0000\u0000\u0000\u0575\u0576\u0005\u008f\u0000\u0000"+
		"\u0576\u0577\u0005\u0084\u0000\u0000\u0577\u0578\u0003n7\u0000\u0578\u008d"+
		"\u0001\u0000\u0000\u0000\u0579\u057a\u0003\u001a\r\u0000\u057a\u057b\u0005"+
		"\u0085\u0000\u0000\u057b\u0581\u0005\u008f\u0000\u0000\u057c\u057e\u0005"+
		"}\u0000\u0000\u057d\u057f\u0003~?\u0000\u057e\u057d\u0001\u0000\u0000"+
		"\u0000\u057e\u057f\u0001\u0000\u0000\u0000\u057f\u0580\u0001\u0000\u0000"+
		"\u0000\u0580\u0582\u0005~\u0000\u0000\u0581\u057c\u0001\u0000\u0000\u0000"+
		"\u0581\u0582\u0001\u0000\u0000\u0000\u0582\u008f\u0001\u0000\u0000\u0000"+
		"\u0583\u0584\u0003n7\u0000\u0584\u0585\u0005\u0087\u0000\u0000\u0585\u0587"+
		"\u0005\u0087\u0000\u0000\u0586\u0588\u0003n7\u0000\u0587\u0586\u0001\u0000"+
		"\u0000\u0000\u0587\u0588\u0001\u0000\u0000\u0000\u0588\u0091\u0001\u0000"+
		"\u0000\u0000\u0589\u058b\u0005f\u0000\u0000\u058a\u058c\u0005\t\u0000"+
		"\u0000\u058b\u058a\u0001\u0000\u0000\u0000\u058b\u058c\u0001\u0000\u0000"+
		"\u0000\u058c\u058d\u0001\u0000\u0000\u0000\u058d\u058e\u0003n7\u0000\u058e"+
		"\u0093\u0001\u0000\u0000\u0000\u058f\u0590\u0005a\u0000\u0000\u0590\u0591"+
		"\u0003n7\u0000\u0591\u0095\u0001\u0000\u0000\u0000\u0592\u0593\u0003n"+
		"7\u0000\u0593\u0594\u0005F\u0000\u0000\u0594\u0595\u0003\u0012\t\u0000"+
		"\u0595\u0097\u0001\u0000\u0000\u0000\u0596\u0597\u0005}\u0000\u0000\u0597"+
		"\u0598\u0003n7\u0000\u0598\u0599\u0005~\u0000\u0000\u0599\u0099\u0001"+
		"\u0000\u0000\u0000\u059a\u059e\u0005\u007f\u0000\u0000\u059b\u059d\u0003"+
		"T*\u0000\u059c\u059b\u0001\u0000\u0000\u0000\u059d\u05a0\u0001\u0000\u0000"+
		"\u0000\u059e\u059c\u0001\u0000\u0000\u0000\u059e\u059f\u0001\u0000\u0000"+
		"\u0000\u059f\u05a2\u0001\u0000\u0000\u0000\u05a0\u059e\u0001\u0000\u0000"+
		"\u0000\u05a1\u05a3\u0003n7\u0000\u05a2\u05a1\u0001\u0000\u0000\u0000\u05a2"+
		"\u05a3\u0001\u0000\u0000\u0000\u05a3\u05a4\u0001\u0000\u0000\u0000\u05a4"+
		"\u05a5\u0005\u0080\u0000\u0000\u05a5\u009b\u0001\u0000\u0000\u0000\u05a6"+
		"\u05a7\u0005\u0012\u0000\u0000\u05a7\u05a8\u0003n7\u0000\u05a8\u05ac\u0005"+
		"\u007f\u0000\u0000\u05a9\u05ab\u0003T*\u0000\u05aa\u05a9\u0001\u0000\u0000"+
		"\u0000\u05ab\u05ae\u0001\u0000\u0000\u0000\u05ac\u05aa\u0001\u0000\u0000"+
		"\u0000\u05ac\u05ad\u0001\u0000\u0000\u0000\u05ad\u05af\u0001\u0000\u0000"+
		"\u0000\u05ae\u05ac\u0001\u0000\u0000\u0000\u05af\u05be\u0005\u0080\u0000"+
		"\u0000\u05b0\u05b1\u0005\u0013\u0000\u0000\u05b1\u05b2\u0005\u0012\u0000"+
		"\u0000\u05b2\u05b3\u0003n7\u0000\u05b3\u05b7\u0005\u007f\u0000\u0000\u05b4"+
		"\u05b6\u0003T*\u0000\u05b5\u05b4\u0001\u0000\u0000\u0000\u05b6\u05b9\u0001"+
		"\u0000\u0000\u0000\u05b7\u05b5\u0001\u0000\u0000\u0000\u05b7\u05b8\u0001"+
		"\u0000\u0000\u0000\u05b8\u05ba\u0001\u0000\u0000\u0000\u05b9\u05b7\u0001"+
		"\u0000\u0000\u0000\u05ba\u05bb\u0005\u0080\u0000\u0000\u05bb\u05bd\u0001"+
		"\u0000\u0000\u0000\u05bc\u05b0\u0001\u0000\u0000\u0000\u05bd\u05c0\u0001"+
		"\u0000\u0000\u0000\u05be\u05bc\u0001\u0000\u0000\u0000\u05be\u05bf\u0001"+
		"\u0000\u0000\u0000\u05bf\u05ca\u0001\u0000\u0000\u0000\u05c0\u05be\u0001"+
		"\u0000\u0000\u0000\u05c1\u05c2\u0005\u0013\u0000\u0000\u05c2\u05c6\u0005"+
		"\u007f\u0000\u0000\u05c3\u05c5\u0003T*\u0000\u05c4\u05c3\u0001\u0000\u0000"+
		"\u0000\u05c5\u05c8\u0001\u0000\u0000\u0000\u05c6\u05c4\u0001\u0000\u0000"+
		"\u0000\u05c6\u05c7\u0001\u0000\u0000\u0000\u05c7\u05c9\u0001\u0000\u0000"+
		"\u0000\u05c8\u05c6\u0001\u0000\u0000\u0000\u05c9\u05cb\u0005\u0080\u0000"+
		"\u0000\u05ca\u05c1\u0001\u0000\u0000\u0000\u05ca\u05cb\u0001\u0000\u0000"+
		"\u0000\u05cb\u009d\u0001\u0000\u0000\u0000\u05cc\u05cd\u0005\u0014\u0000"+
		"\u0000\u05cd\u05ce\u0003n7\u0000\u05ce\u05d2\u0005\u007f\u0000\u0000\u05cf"+
		"\u05d1\u0003f3\u0000\u05d0\u05cf\u0001\u0000\u0000\u0000\u05d1\u05d4\u0001"+
		"\u0000\u0000\u0000\u05d2\u05d0\u0001\u0000\u0000\u0000\u05d2\u05d3\u0001"+
		"\u0000\u0000\u0000\u05d3\u05d5\u0001\u0000\u0000\u0000\u05d4\u05d2\u0001"+
		"\u0000\u0000\u0000\u05d5\u05d6\u0005\u0080\u0000\u0000\u05d6\u009f\u0001"+
		"\u0000\u0000\u0000\u05d7\u05d9\u0007\u0005\u0000\u0000\u05d8\u05d7\u0001"+
		"\u0000\u0000\u0000\u05d8\u05d9\u0001\u0000\u0000\u0000\u05d9\u05da\u0001"+
		"\u0000\u0000\u0000\u05da\u05db\u0005g\u0000\u0000\u05db\u05dd\u0005g\u0000"+
		"\u0000\u05dc\u05de\u00036\u001b\u0000\u05dd\u05dc\u0001\u0000\u0000\u0000"+
		"\u05dd\u05de\u0001\u0000\u0000\u0000\u05de\u05df\u0001\u0000\u0000\u0000"+
		"\u05df\u05e0\u0005g\u0000\u0000\u05e0\u05e3\u0001\u0000\u0000\u0000\u05e1"+
		"\u05e2\u0005\u0088\u0000\u0000\u05e2\u05e4\u0003:\u001d\u0000\u05e3\u05e1"+
		"\u0001\u0000\u0000\u0000\u05e3\u05e4\u0001\u0000\u0000\u0000\u05e4\u05e5"+
		"\u0001\u0000\u0000\u0000\u05e5\u05e6\u0003n7\u0000\u05e6\u00a1\u0001\u0000"+
		"\u0000\u0000\u05e7\u05e8\u0005\u001b\u0000\u0000\u05e8\u05ec\u0005\u007f"+
		"\u0000\u0000\u05e9\u05eb\u0003T*\u0000\u05ea\u05e9\u0001\u0000\u0000\u0000"+
		"\u05eb\u05ee\u0001\u0000\u0000\u0000\u05ec\u05ea\u0001\u0000\u0000\u0000"+
		"\u05ec\u05ed\u0001\u0000\u0000\u0000\u05ed\u05ef\u0001\u0000\u0000\u0000"+
		"\u05ee\u05ec\u0001\u0000\u0000\u0000\u05ef\u05f0\u0005\u0080\u0000\u0000"+
		"\u05f0\u00a3\u0001\u0000\u0000\u0000\u05f1\u05f2\u0003n7\u0000\u05f2\u05f3"+
		"\u0005\u0087\u0000\u0000\u05f3\u05f4\u0005\u001c\u0000\u0000\u05f4\u00a5"+
		"\u0001\u0000\u0000\u0000\u05f5\u05fe\u0003\u00a8T\u0000\u05f6\u05fe\u0003"+
		"\u00aaU\u0000\u05f7\u05fe\u0003\u00acV\u0000\u05f8\u05fe\u0003\u00aeW"+
		"\u0000\u05f9\u05fe\u0003\u00b0X\u0000\u05fa\u05fe\u0003\u00b2Y\u0000\u05fb"+
		"\u05fe\u0003\u00b4Z\u0000\u05fc\u05fe\u0003\u00b6[\u0000\u05fd\u05f5\u0001"+
		"\u0000\u0000\u0000\u05fd\u05f6\u0001\u0000\u0000\u0000\u05fd\u05f7\u0001"+
		"\u0000\u0000\u0000\u05fd\u05f8\u0001\u0000\u0000\u0000\u05fd\u05f9\u0001"+
		"\u0000\u0000\u0000\u05fd\u05fa\u0001\u0000\u0000\u0000\u05fd\u05fb\u0001"+
		"\u0000\u0000\u0000\u05fd\u05fc\u0001\u0000\u0000\u0000\u05fe\u00a7\u0001"+
		"\u0000\u0000\u0000\u05ff\u0600\u00052\u0000\u0000\u0600\u0601\u0005}\u0000"+
		"\u0000\u0601\u0602\u0003p8\u0000\u0602\u0603\u0005\u0083\u0000\u0000\u0603"+
		"\u0604\u0003p8\u0000\u0604\u0605\u0005~\u0000\u0000\u0605\u00a9\u0001"+
		"\u0000\u0000\u0000\u0606\u0607\u00053\u0000\u0000\u0607\u0608\u0005}\u0000"+
		"\u0000\u0608\u0609\u0003p8\u0000\u0609\u060a\u0005\u0083\u0000\u0000\u060a"+
		"\u060b\u0003p8\u0000\u060b\u060c\u0005~\u0000\u0000\u060c\u00ab\u0001"+
		"\u0000\u0000\u0000\u060d\u060e\u00054\u0000\u0000\u060e\u060f\u0005}\u0000"+
		"\u0000\u060f\u0610\u0003p8\u0000\u0610\u0611\u0005\u0083\u0000\u0000\u0611"+
		"\u0612\u0003p8\u0000\u0612\u0613\u0005~\u0000\u0000\u0613\u00ad\u0001"+
		"\u0000\u0000\u0000\u0614\u0615\u00055\u0000\u0000\u0615\u0616\u0005}\u0000"+
		"\u0000\u0616\u0617\u0003p8\u0000\u0617\u0618\u0005\u0083\u0000\u0000\u0618"+
		"\u0619\u0003p8\u0000\u0619\u061a\u0005\u0083\u0000\u0000\u061a\u061b\u0003"+
		"p8\u0000\u061b\u061c\u0005~\u0000\u0000\u061c\u00af\u0001\u0000\u0000"+
		"\u0000\u061d\u061e\u0005\'\u0000\u0000\u061e\u061f\u0005n\u0000\u0000"+
		"\u061f\u0620\u0003\u0018\f\u0000\u0620\u0621\u0005o\u0000\u0000\u0621"+
		"\u0622\u0005\u0085\u0000\u0000\u0622\u0623\u0005\u00bf\u0000\u0000\u0623"+
		"\u0624\u0005}\u0000\u0000\u0624\u0625\u0005~\u0000\u0000\u0625\u00b1\u0001"+
		"\u0000\u0000\u0000\u0626\u0627\u0005\u00c1\u0000\u0000\u0627\u0628\u0005"+
		"}\u0000\u0000\u0628\u0629\u0003p8\u0000\u0629\u062a\u0005~\u0000\u0000"+
		"\u062a\u00b3\u0001\u0000\u0000\u0000\u062b\u062c\u00056\u0000\u0000\u062c"+
		"\u062d\u0005n\u0000\u0000\u062d\u062e\u0003\u0012\t\u0000\u062e\u062f"+
		"\u0005o\u0000\u0000\u062f\u0630\u0005}\u0000\u0000\u0630\u0631\u0003p"+
		"8\u0000\u0631\u0632\u0005\u0083\u0000\u0000\u0632\u0633\u0003p8\u0000"+
		"\u0633\u0634\u0005~\u0000\u0000\u0634\u00b5\u0001\u0000\u0000\u0000\u0635"+
		"\u0636\u0005\u00c2\u0000\u0000\u0636\u0637\u0005}\u0000\u0000\u0637\u0638"+
		"\u0003p8\u0000\u0638\u0639\u0005\u0083\u0000\u0000\u0639\u063a\u0003p"+
		"8\u0000\u063a\u063b\u0005~\u0000\u0000\u063b\u00b7\u0001\u0000\u0000\u0000"+
		"\u063c\u063d\u0005\u008e\u0000\u0000\u063d\u0642\u0003\u00ba]\u0000\u063e"+
		"\u063f\u0005\u0083\u0000\u0000\u063f\u0641\u0003\u00ba]\u0000\u0640\u063e"+
		"\u0001\u0000\u0000\u0000\u0641\u0644\u0001\u0000\u0000\u0000\u0642\u0640"+
		"\u0001\u0000\u0000\u0000\u0642\u0643\u0001\u0000\u0000\u0000\u0643\u0645"+
		"\u0001\u0000\u0000\u0000\u0644\u0642\u0001\u0000\u0000\u0000\u0645\u0646"+
		"\u0005\u0082\u0000\u0000\u0646\u00b9\u0001\u0000\u0000\u0000\u0647\u0648"+
		"\u0007\u0006\u0000\u0000\u0648\u00bb\u0001\u0000\u0000\u0000\u0649\u0653"+
		"\u0003\u00be_\u0000\u064a\u0653\u0003\u00c0`\u0000\u064b\u0653\u0003\u00c2"+
		"a\u0000\u064c\u0653\u0003\u00c4b\u0000\u064d\u0653\u0003\u00c6c\u0000"+
		"\u064e\u0653\u0003\u00cae\u0000\u064f\u0653\u0003\u00ccf\u0000\u0650\u0653"+
		"\u0003\u00ceg\u0000\u0651\u0653\u0003\u00d0h\u0000\u0652\u0649\u0001\u0000"+
		"\u0000\u0000\u0652\u064a\u0001\u0000\u0000\u0000\u0652\u064b\u0001\u0000"+
		"\u0000\u0000\u0652\u064c\u0001\u0000\u0000\u0000\u0652\u064d\u0001\u0000"+
		"\u0000\u0000\u0652\u064e\u0001\u0000\u0000\u0000\u0652\u064f\u0001\u0000"+
		"\u0000\u0000\u0652\u0650\u0001\u0000\u0000\u0000\u0652\u0651\u0001\u0000"+
		"\u0000\u0000\u0653\u00bd\u0001\u0000\u0000\u0000\u0654\u0655\u0003r9\u0000"+
		"\u0655\u00bf\u0001\u0000\u0000\u0000\u0656\u065b\u0005\t\u0000\u0000\u0657"+
		"\u065b\u0005\u00c0\u0000\u0000\u0658\u0659\u0005\t\u0000\u0000\u0659\u065b"+
		"\u0005\u00c0\u0000\u0000\u065a\u0656\u0001\u0000\u0000\u0000\u065a\u0657"+
		"\u0001\u0000\u0000\u0000\u065a\u0658\u0001\u0000\u0000\u0000\u065a\u065b"+
		"\u0001\u0000\u0000\u0000\u065b\u065c\u0001\u0000\u0000\u0000\u065c\u065d"+
		"\u0005\u008f\u0000\u0000\u065d\u00c1\u0001\u0000\u0000\u0000\u065e\u065f"+
		"\u0005\u008d\u0000\u0000\u065f\u00c3\u0001\u0000\u0000\u0000\u0660\u0665"+
		"\u0005\t\u0000\u0000\u0661\u0665\u0005\u00c0\u0000\u0000\u0662\u0663\u0005"+
		"\t\u0000\u0000\u0663\u0665\u0005\u00c0\u0000\u0000\u0664\u0660\u0001\u0000"+
		"\u0000\u0000\u0664\u0661\u0001\u0000\u0000\u0000\u0664\u0662\u0001\u0000"+
		"\u0000\u0000\u0664\u0665\u0001\u0000\u0000\u0000\u0665\u066e\u0001\u0000"+
		"\u0000\u0000\u0666\u066f\u0003\u00be_\u0000\u0667\u066f\u0003\u00c0`\u0000"+
		"\u0668\u066f\u0003\u00c2a\u0000\u0669\u066f\u0003\u00c6c\u0000\u066a\u066f"+
		"\u0003\u00cae\u0000\u066b\u066f\u0003\u00ccf\u0000\u066c\u066f\u0003\u00ce"+
		"g\u0000\u066d\u066f\u0003\u00d0h\u0000\u066e\u0666\u0001\u0000\u0000\u0000"+
		"\u066e\u0667\u0001\u0000\u0000\u0000\u066e\u0668\u0001\u0000\u0000\u0000"+
		"\u066e\u0669\u0001\u0000\u0000\u0000\u066e\u066a\u0001\u0000\u0000\u0000"+
		"\u066e\u066b\u0001\u0000\u0000\u0000\u066e\u066c\u0001\u0000\u0000\u0000"+
		"\u066e\u066d\u0001\u0000\u0000\u0000\u066f\u00c5\u0001\u0000\u0000\u0000"+
		"\u0670\u0671\u0003\u001a\r\u0000\u0671\u067a\u0005\u007f\u0000\u0000\u0672"+
		"\u0677\u0003\u00c8d\u0000\u0673\u0674\u0005\u0083\u0000\u0000\u0674\u0676"+
		"\u0003\u00c8d\u0000\u0675\u0673\u0001\u0000\u0000\u0000\u0676\u0679\u0001"+
		"\u0000\u0000\u0000\u0677\u0675\u0001\u0000\u0000\u0000\u0677\u0678\u0001"+
		"\u0000\u0000\u0000\u0678\u067b\u0001\u0000\u0000\u0000\u0679\u0677\u0001"+
		"\u0000\u0000\u0000\u067a\u0672\u0001\u0000\u0000\u0000\u067a\u067b\u0001"+
		"\u0000\u0000\u0000\u067b\u067c\u0001\u0000\u0000\u0000\u067c\u067d\u0005"+
		"\u0080\u0000\u0000\u067d\u00c7\u0001\u0000\u0000\u0000\u067e\u067f\u0005"+
		"\u008f\u0000\u0000\u067f\u0681\u0005\u0084\u0000\u0000\u0680\u067e\u0001"+
		"\u0000\u0000\u0000\u0680\u0681\u0001\u0000\u0000\u0000\u0681\u0682\u0001"+
		"\u0000\u0000\u0000\u0682\u0683\u0003\u00bc^\u0000\u0683\u00c9\u0001\u0000"+
		"\u0000\u0000\u0684\u0685\u0003\u001a\r\u0000\u0685\u0686\u0005\u0085\u0000"+
		"\u0000\u0686\u068c\u0005\u008f\u0000\u0000\u0687\u0689\u0005}\u0000\u0000"+
		"\u0688\u068a\u0003\u00d2i\u0000\u0689\u0688\u0001\u0000\u0000\u0000\u0689"+
		"\u068a\u0001\u0000\u0000\u0000\u068a\u068b\u0001\u0000\u0000\u0000\u068b"+
		"\u068d\u0005~\u0000\u0000\u068c\u0687\u0001\u0000\u0000\u0000\u068c\u068d"+
		"\u0001\u0000\u0000\u0000\u068d\u00cb\u0001\u0000\u0000\u0000\u068e\u0697"+
		"\u0005}\u0000\u0000\u068f\u0694\u0003\u00bc^\u0000\u0690\u0691\u0005\u0083"+
		"\u0000\u0000\u0691\u0693\u0003\u00bc^\u0000\u0692\u0690\u0001\u0000\u0000"+
		"\u0000\u0693\u0696\u0001\u0000\u0000\u0000\u0694\u0692\u0001\u0000\u0000"+
		"\u0000\u0694\u0695\u0001\u0000\u0000\u0000\u0695\u0698\u0001\u0000\u0000"+
		"\u0000\u0696\u0694\u0001\u0000\u0000\u0000\u0697\u068f\u0001\u0000\u0000"+
		"\u0000\u0697\u0698\u0001\u0000\u0000\u0000\u0698\u0699\u0001\u0000\u0000"+
		"\u0000\u0699\u069a\u0005~\u0000\u0000\u069a\u00cd\u0001\u0000\u0000\u0000"+
		"\u069b\u06a4\u0005\u0081\u0000\u0000\u069c\u06a1\u0003\u00bc^\u0000\u069d"+
		"\u069e\u0005\u0083\u0000\u0000\u069e\u06a0\u0003\u00bc^\u0000\u069f\u069d"+
		"\u0001\u0000\u0000\u0000\u06a0\u06a3\u0001\u0000\u0000\u0000\u06a1\u069f"+
		"\u0001\u0000\u0000\u0000\u06a1\u06a2\u0001\u0000\u0000\u0000\u06a2\u06a5"+
		"\u0001\u0000\u0000\u0000\u06a3\u06a1\u0001\u0000\u0000\u0000\u06a4\u069c"+
		"\u0001\u0000\u0000\u0000\u06a4\u06a5\u0001\u0000\u0000\u0000\u06a5\u06a6"+
		"\u0001\u0000\u0000\u0000\u06a6\u06a7\u0005\u0082\u0000\u0000\u06a7\u00cf"+
		"\u0001\u0000\u0000\u0000\u06a8\u06a9\u0003r9\u0000\u06a9\u06aa\u0005\u0087"+
		"\u0000\u0000\u06aa\u06ac\u0005\u0087\u0000\u0000\u06ab\u06ad\u0003r9\u0000"+
		"\u06ac\u06ab\u0001\u0000\u0000\u0000\u06ac\u06ad\u0001\u0000\u0000\u0000"+
		"\u06ad\u00d1\u0001\u0000\u0000\u0000\u06ae\u06b3\u0003\u00bc^\u0000\u06af"+
		"\u06b0\u0005\u0083\u0000\u0000\u06b0\u06b2\u0003\u00bc^\u0000\u06b1\u06af"+
		"\u0001\u0000\u0000\u0000\u06b2\u06b5\u0001\u0000\u0000\u0000\u06b3\u06b1"+
		"\u0001\u0000\u0000\u0000\u06b3\u06b4\u0001\u0000\u0000\u0000\u06b4\u00d3"+
		"\u0001\u0000\u0000\u0000\u06b5\u06b3\u0001\u0000\u0000\u0000\u06b6\u06b7"+
		"\u0005n\u0000\u0000\u06b7\u06b8\u0003*\u0015\u0000\u06b8\u06b9\u0005o"+
		"\u0000\u0000\u06b9\u00d5\u0001\u0000\u0000\u0000\u06ba\u06bb\u0007\u0007"+
		"\u0000\u0000\u06bb\u00d7\u0001\u0000\u0000\u0000\u06bc\u06bd\u0005G\u0000"+
		"\u0000\u06bd\u06be\u0005n\u0000\u0000\u06be\u06bf\u0003\u0012\t\u0000"+
		"\u06bf\u06c0\u0005\u0083\u0000\u0000\u06c0\u06c1\u0003\u00d6k\u0000\u06c1"+
		"\u06c2\u0005o\u0000\u0000\u06c2\u00d9\u0001\u0000\u0000\u0000\u06c3\u06c4"+
		"\u0005\u00c7\u0000\u0000\u06c4\u06d3\u0003\u00deo\u0000\u06c5\u06c6\u0005"+
		"\u00c8\u0000\u0000\u06c6\u06d3\u0003\u0012\t\u0000\u06c7\u06c8\u0005\u00c9"+
		"\u0000\u0000\u06c8\u06c9\u0005n\u0000\u0000\u06c9\u06ca\u0003\u00e0p\u0000"+
		"\u06ca\u06cb\u0005o\u0000\u0000\u06cb\u06d3\u0001\u0000\u0000\u0000\u06cc"+
		"\u06cd\u0005\u00c5\u0000\u0000\u06cd\u06d3\u0003\u001a\r\u0000\u06ce\u06cf"+
		"\u0005\u00cd\u0000\u0000\u06cf\u06d3\u0003\u0012\t\u0000\u06d0\u06d1\u0005"+
		"\u00ce\u0000\u0000\u06d1\u06d3\u0003\u0012\t\u0000\u06d2\u06c3\u0001\u0000"+
		"\u0000\u0000\u06d2\u06c5\u0001\u0000\u0000\u0000\u06d2\u06c7\u0001\u0000"+
		"\u0000\u0000\u06d2\u06cc\u0001\u0000\u0000\u0000\u06d2\u06ce\u0001\u0000"+
		"\u0000\u0000\u06d2\u06d0\u0001\u0000\u0000\u0000\u06d3\u00db\u0001\u0000"+
		"\u0000\u0000\u06d4\u06d5\u0005\u00d6\u0000\u0000\u06d5\u06d6\u0005n\u0000"+
		"\u0000\u06d6\u06db\u0003\u00deo\u0000\u06d7\u06d8\u0005\u00d9\u0000\u0000"+
		"\u06d8\u06da\u0003\u00deo\u0000\u06d9\u06d7\u0001\u0000\u0000\u0000\u06da"+
		"\u06dd\u0001\u0000\u0000\u0000\u06db\u06d9\u0001\u0000\u0000\u0000\u06db"+
		"\u06dc\u0001\u0000\u0000\u0000\u06dc\u06de\u0001\u0000\u0000\u0000\u06dd"+
		"\u06db\u0001\u0000\u0000\u0000\u06de\u06df\u0005o\u0000\u0000\u06df\u00dd"+
		"\u0001\u0000\u0000\u0000\u06e0\u06e1\u0005\u00d7\u0000\u0000\u06e1\u06e2"+
		"\u0005n\u0000\u0000\u06e2\u06e3\u0003*\u0015\u0000\u06e3\u06e4\u0005o"+
		"\u0000\u0000\u06e4\u06e7\u0001\u0000\u0000\u0000\u06e5\u06e7\u0005\u008f"+
		"\u0000\u0000\u06e6\u06e0\u0001\u0000\u0000\u0000\u06e6\u06e5\u0001\u0000"+
		"\u0000\u0000\u06e7\u00df\u0001\u0000\u0000\u0000\u06e8\u06eb\u0005\u00de"+
		"\u0000\u0000\u06e9\u06ea\u0005\u0083\u0000\u0000\u06ea\u06ec\u0005\u00df"+
		"\u0000\u0000\u06eb\u06e9\u0001\u0000\u0000\u0000\u06eb\u06ec\u0001\u0000"+
		"\u0000\u0000\u06ec\u06f1\u0001\u0000\u0000\u0000\u06ed\u06ee\u0005\u0083"+
		"\u0000\u0000\u06ee\u06f0\u0003\u0012\t\u0000\u06ef\u06ed\u0001\u0000\u0000"+
		"\u0000\u06f0\u06f3\u0001\u0000\u0000\u0000\u06f1\u06ef\u0001\u0000\u0000"+
		"\u0000\u06f1\u06f2\u0001\u0000\u0000\u0000\u06f2\u00e1\u0001\u0000\u0000"+
		"\u0000\u06f3\u06f1\u0001\u0000\u0000\u0000\u06f4\u06f9\u0005\u00c6\u0000"+
		"\u0000\u06f5\u06f6\u0005_\u0000\u0000\u06f6\u06f8\u0005\u00c6\u0000\u0000"+
		"\u06f7\u06f5\u0001\u0000\u0000\u0000\u06f8\u06fb\u0001\u0000\u0000\u0000"+
		"\u06f9\u06f7\u0001\u0000\u0000\u0000\u06f9\u06fa\u0001\u0000\u0000\u0000"+
		"\u06fa\u00e3\u0001\u0000\u0000\u0000\u06fb\u06f9\u0001\u0000\u0000\u0000"+
		"\u06fc\u06fd\u0005\u00d4\u0000\u0000\u06fd\u0700\u0005\u008f\u0000\u0000"+
		"\u06fe\u06ff\u0005\u0084\u0000\u0000\u06ff\u0701\u0003\u0012\t\u0000\u0700"+
		"\u06fe\u0001\u0000\u0000\u0000\u0700\u0701\u0001\u0000\u0000\u0000\u0701"+
		"\u0704\u0001\u0000\u0000\u0000\u0702\u0703\u0005r\u0000\u0000\u0703\u0705"+
		"\u0003\u0012\t\u0000\u0704\u0702\u0001\u0000\u0000\u0000\u0704\u0705\u0001"+
		"\u0000\u0000\u0000\u0705\u00e5\u0001\u0000\u0000\u0000\u0706\u0707\u0005"+
		"\u00d5\u0000\u0000\u0707\u0708\u0005\u008f\u0000\u0000\u0708\u0709\u0005"+
		"\u0084\u0000\u0000\u0709\u070a\u0003\u0012\t\u0000\u070a\u070b\u0005r"+
		"\u0000\u0000\u070b\u070c\u0003p8\u0000\u070c\u00e7\u0001\u0000\u0000\u0000"+
		"\u070d\u070e\u0005\u00c4\u0000\u0000\u070e\u070f\u0005n\u0000\u0000\u070f"+
		"\u0710\u0003\u0012\t\u0000\u0710\u0711\u0005\u0084\u0000\u0000\u0711\u0712"+
		"\u0003\u00e2q\u0000\u0712\u0713\u0005o\u0000\u0000\u0713\u00e9\u0001\u0000"+
		"\u0000\u0000\u0714\u0715\u0005\u00ca\u0000\u0000\u0715\u0716\u0005\u008f"+
		"\u0000\u0000\u0716\u0717\u0005r\u0000\u0000\u0717\u0718\u0003\u0012\t"+
		"\u0000\u0718\u00eb\u0001\u0000\u0000\u0000\u0719\u071a\u0005\u00cb\u0000"+
		"\u0000\u071a\u0724\u0005\u00da\u0000\u0000\u071b\u0720\u0005\u00cb\u0000"+
		"\u0000\u071c\u071d\u0005\u00d9\u0000\u0000\u071d\u071f\u0003\u00ecv\u0000"+
		"\u071e\u071c\u0001\u0000\u0000\u0000\u071f\u0722\u0001\u0000\u0000\u0000"+
		"\u0720\u071e\u0001\u0000\u0000\u0000\u0720\u0721\u0001\u0000\u0000\u0000"+
		"\u0721\u0724\u0001\u0000\u0000\u0000\u0722\u0720\u0001\u0000\u0000\u0000"+
		"\u0723\u0719\u0001\u0000\u0000\u0000\u0723\u071b\u0001\u0000\u0000\u0000"+
		"\u0724\u00ed\u0001\u0000\u0000\u0000\u0725\u0726\u0005\u00cd\u0000\u0000"+
		"\u0726\u0727\u0005n\u0000\u0000\u0727\u0728\u0003\u0012\t\u0000\u0728"+
		"\u0729\u0005o\u0000\u0000\u0729\u00ef\u0001\u0000\u0000\u0000\u072a\u072b"+
		"\u0005\u00d0\u0000\u0000\u072b\u072c\u0005\u008f\u0000\u0000\u072c\u072d"+
		"\u0005\u0084\u0000\u0000\u072d\u072e\u0003\u0012\t\u0000\u072e\u00f1\u0001"+
		"\u0000\u0000\u0000\u072f\u0730\u0005\u00cf\u0000\u0000\u0730\u0731\u0005"+
		"\u008f\u0000\u0000\u0731\u0732\u0005\u0084\u0000\u0000\u0732\u0733\u0003"+
		"\u0012\t\u0000\u0733\u0734\u0005\u0087\u0000\u0000\u0734\u0735\u0003\u0012"+
		"\t\u0000\u0735\u00f3\u0001\u0000\u0000\u0000\u0736\u0737\u0005\u008e\u0000"+
		"\u0000\u0737\u073c\u0003\u00ba]\u0000\u0738\u0739\u0005\u0083\u0000\u0000"+
		"\u0739\u073b\u0003\u00ba]\u0000\u073a\u0738\u0001\u0000\u0000\u0000\u073b"+
		"\u073e\u0001\u0000\u0000\u0000\u073c\u073a\u0001\u0000\u0000\u0000\u073c"+
		"\u073d\u0001\u0000\u0000\u0000\u073d\u073f\u0001\u0000\u0000\u0000\u073e"+
		"\u073c\u0001\u0000\u0000\u0000\u073f\u0740\u0005\u0082\u0000\u0000\u0740"+
		"\u00f5\u0001\u0000\u0000\u0000\u0741\u0742\u0007\b\u0000\u0000\u0742\u00f7"+
		"\u0001\u0000\u0000\u0000\u0743\u0744\u0005\u012e\u0000\u0000\u0744\u0745"+
		"\u0005}\u0000\u0000\u0745\u0746\u0003\u00fa}\u0000\u0746\u0747\u0005~"+
		"\u0000\u0000\u0747\u00f9\u0001\u0000\u0000\u0000\u0748\u0749\u0005\u008f"+
		"\u0000\u0000\u0749\u074d\u0005\u007f\u0000\u0000\u074a\u074c\u0003\u00fc"+
		"~\u0000\u074b\u074a\u0001\u0000\u0000\u0000\u074c\u074f\u0001\u0000\u0000"+
		"\u0000\u074d\u074b\u0001\u0000\u0000\u0000\u074d\u074e\u0001\u0000\u0000"+
		"\u0000\u074e\u0750\u0001\u0000\u0000\u0000\u074f\u074d\u0001\u0000\u0000"+
		"\u0000\u0750\u0751\u0005\u0080\u0000\u0000\u0751\u00fb\u0001\u0000\u0000"+
		"\u0000\u0752\u0753\u0005\u013b\u0000\u0000\u0753\u0754\u0005\u0084\u0000"+
		"\u0000\u0754\u076e\u0003p8\u0000\u0755\u0756\u0005\u013c\u0000\u0000\u0756"+
		"\u0757\u0005\u0084\u0000\u0000\u0757\u076e\u0003p8\u0000\u0758\u0759\u0005"+
		"\u013d\u0000\u0000\u0759\u075a\u0005\u0084\u0000\u0000\u075a\u076e\u0003"+
		"p8\u0000\u075b\u075c\u0005\u013e\u0000\u0000\u075c\u075d\u0005\u0084\u0000"+
		"\u0000\u075d\u076e\u0003p8\u0000\u075e\u075f\u0005\u013f\u0000\u0000\u075f"+
		"\u0760\u0005\u0084\u0000\u0000\u0760\u076e\u0003p8\u0000\u0761\u0762\u0005"+
		"\u0140\u0000\u0000\u0762\u0763\u0005\u0084\u0000\u0000\u0763\u076e\u0003"+
		"p8\u0000\u0764\u0765\u0005\u0141\u0000\u0000\u0765\u0766\u0005\u0084\u0000"+
		"\u0000\u0766\u076e\u0003p8\u0000\u0767\u0768\u0005\u0142\u0000\u0000\u0768"+
		"\u0769\u0005\u0084\u0000\u0000\u0769\u076e\u0003p8\u0000\u076a\u076b\u0005"+
		"\u0143\u0000\u0000\u076b\u076c\u0005\u0084\u0000\u0000\u076c\u076e\u0003"+
		"p8\u0000\u076d\u0752\u0001\u0000\u0000\u0000\u076d\u0755\u0001\u0000\u0000"+
		"\u0000\u076d\u0758\u0001\u0000\u0000\u0000\u076d\u075b\u0001\u0000\u0000"+
		"\u0000\u076d\u075e\u0001\u0000\u0000\u0000\u076d\u0761\u0001\u0000\u0000"+
		"\u0000\u076d\u0764\u0001\u0000\u0000\u0000\u076d\u0767\u0001\u0000\u0000"+
		"\u0000\u076d\u076a\u0001\u0000\u0000\u0000\u076e\u00fd\u0001\u0000\u0000"+
		"\u0000\u076f\u0770\u0005\u012f\u0000\u0000\u0770\u0771\u0005}\u0000\u0000"+
		"\u0771\u0772\u0003\u0100\u0080\u0000\u0772\u0773\u0005~\u0000\u0000\u0773"+
		"\u00ff\u0001\u0000\u0000\u0000\u0774\u0775\u0005\u0187\u0000\u0000\u0775"+
		"\u0776\u0005r\u0000\u0000\u0776\u077b\u0005\u008f\u0000\u0000\u0777\u0778"+
		"\u0005\u0083\u0000\u0000\u0778\u0779\u0005\u0188\u0000\u0000\u0779\u077a"+
		"\u0005r\u0000\u0000\u077a\u077c\u0003p8\u0000\u077b\u0777\u0001\u0000"+
		"\u0000\u0000\u077b\u077c\u0001\u0000\u0000\u0000\u077c\u0101\u0001\u0000"+
		"\u0000\u0000\u077d\u077e\u0005\u0130\u0000\u0000\u077e\u077f\u0005}\u0000"+
		"\u0000\u077f\u0780\u0005\u0189\u0000\u0000\u0780\u0781\u0005r\u0000\u0000"+
		"\u0781\u0782\u0005\u008f\u0000\u0000\u0782\u0783\u0005~\u0000\u0000\u0783"+
		"\u0103\u0001\u0000\u0000\u0000\u0784\u0785\u0005?\u0000\u0000\u0785\u0786"+
		"\u0005}\u0000\u0000\u0786\u0787\u0005\u0132\u0000\u0000\u0787\u0788\u0005"+
		"r\u0000\u0000\u0788\u0789\u0003p8\u0000\u0789\u078a\u0005~\u0000\u0000"+
		"\u078a\u0105\u0001\u0000\u0000\u0000\u078b\u078c\u0005\u0134\u0000\u0000"+
		"\u078c\u078d\u0005}\u0000\u0000\u078d\u078e\u0003\u0108\u0084\u0000\u078e"+
		"\u078f\u0005~\u0000\u0000\u078f\u0107\u0001\u0000\u0000\u0000\u0790\u0791"+
		"\u0007\t\u0000\u0000\u0791\u0109\u0001\u0000\u0000\u0000\u0792\u0794\u0005"+
		"\u00f3\u0000\u0000\u0793\u0795\u00036\u001b\u0000\u0794\u0793\u0001\u0000"+
		"\u0000\u0000\u0794\u0795\u0001\u0000\u0000\u0000\u0795\u0798\u0001\u0000"+
		"\u0000\u0000\u0796\u0797\u0005\u0088\u0000\u0000\u0797\u0799\u0003:\u001d"+
		"\u0000\u0798\u0796\u0001\u0000\u0000\u0000\u0798\u0799\u0001\u0000\u0000"+
		"\u0000\u0799\u079a\u0001\u0000\u0000\u0000\u079a\u079b\u0005r\u0000\u0000"+
		"\u079b\u07b2\u0003p8\u0000\u079c\u079e\u0005\u00f4\u0000\u0000\u079d\u079f"+
		"\u00036\u001b\u0000\u079e\u079d\u0001\u0000\u0000\u0000\u079e\u079f\u0001"+
		"\u0000\u0000\u0000\u079f\u07a0\u0001\u0000\u0000\u0000\u07a0\u07a1\u0005"+
		"\u0088\u0000\u0000\u07a1\u07b2\u0003p8\u0000\u07a2\u07a3\u0005\u00f5\u0000"+
		"\u0000\u07a3\u07a4\u0003\u0110\u0088\u0000\u07a4\u07a5\u0005}\u0000\u0000"+
		"\u07a5\u07a6\u00036\u001b\u0000\u07a6\u07a7\u0005~\u0000\u0000\u07a7\u07a8"+
		"\u0005r\u0000\u0000\u07a8\u07a9\u0003p8\u0000\u07a9\u07b2\u0001\u0000"+
		"\u0000\u0000\u07aa\u07ab\u0005\u00f7\u0000\u0000\u07ab\u07ac\u0005n\u0000"+
		"\u0000\u07ac\u07ad\u0003&\u0013\u0000\u07ad\u07ae\u0005o\u0000\u0000\u07ae"+
		"\u07b2\u0001\u0000\u0000\u0000\u07af\u07b0\u0005\u00f8\u0000\u0000\u07b0"+
		"\u07b2\u0003\u00e2q\u0000\u07b1\u0792\u0001\u0000\u0000\u0000\u07b1\u079c"+
		"\u0001\u0000\u0000\u0000\u07b1\u07a2\u0001\u0000\u0000\u0000\u07b1\u07aa"+
		"\u0001\u0000\u0000\u0000\u07b1\u07af\u0001\u0000\u0000\u0000\u07b2\u010b"+
		"\u0001\u0000\u0000\u0000\u07b3\u07b4\u0005\u00f6\u0000\u0000\u07b4\u07b5"+
		"\u0003\u0110\u0088\u0000\u07b5\u07b6\u0005\u0010\u0000\u0000\u07b6\u07b7"+
		"\u0003\u0012\t\u0000\u07b7\u07b8\u0005\u007f\u0000\u0000\u07b8\u07b9\u0003"+
		"\u010e\u0087\u0000\u07b9\u07ba\u0005\u0080\u0000\u0000\u07ba\u010d\u0001"+
		"\u0000\u0000\u0000\u07bb\u07bd\u0003T*\u0000\u07bc\u07bb\u0001\u0000\u0000"+
		"\u0000\u07bd\u07c0\u0001\u0000\u0000\u0000\u07be\u07bc\u0001\u0000\u0000"+
		"\u0000\u07be\u07bf\u0001\u0000\u0000\u0000\u07bf\u07c2\u0001\u0000\u0000"+
		"\u0000\u07c0\u07be\u0001\u0000\u0000\u0000\u07c1\u07c3\u0003\\.\u0000"+
		"\u07c2\u07c1\u0001\u0000\u0000\u0000\u07c2\u07c3\u0001\u0000\u0000\u0000"+
		"\u07c3\u010f\u0001\u0000\u0000\u0000\u07c4\u07c5\u0007\n\u0000\u0000\u07c5"+
		"\u0111\u0001\u0000\u0000\u0000\u07c6\u07c7\u0005\u001b\u0000\u0000\u07c7"+
		"\u07c8\u0005\u0007\u0000\u0000\u07c8\u07ca\u0005\u008f\u0000\u0000\u07c9"+
		"\u07cb\u0003,\u0016\u0000\u07ca\u07c9\u0001\u0000\u0000\u0000\u07ca\u07cb"+
		"\u0001\u0000\u0000\u0000\u07cb\u07cc\u0001\u0000\u0000\u0000\u07cc\u07ce"+
		"\u0005}\u0000\u0000\u07cd\u07cf\u00036\u001b\u0000\u07ce\u07cd\u0001\u0000"+
		"\u0000\u0000\u07ce\u07cf\u0001\u0000\u0000\u0000\u07cf\u07d0\u0001\u0000"+
		"\u0000\u0000\u07d0\u07d3\u0005~\u0000\u0000\u07d1\u07d2\u0005\u0088\u0000"+
		"\u0000\u07d2\u07d4\u0003:\u001d\u0000\u07d3\u07d1\u0001\u0000\u0000\u0000"+
		"\u07d3\u07d4\u0001\u0000\u0000\u0000\u07d4\u07d6\u0001\u0000\u0000\u0000"+
		"\u07d5\u07d7\u00032\u0019\u0000\u07d6\u07d5\u0001\u0000\u0000\u0000\u07d6"+
		"\u07d7\u0001\u0000\u0000\u0000\u07d7\u07e1\u0001\u0000\u0000\u0000\u07d8"+
		"\u07dc\u0005\u007f\u0000\u0000\u07d9\u07db\u0003\u0114\u008a\u0000\u07da"+
		"\u07d9\u0001\u0000\u0000\u0000\u07db\u07de\u0001\u0000\u0000\u0000\u07dc"+
		"\u07da\u0001\u0000\u0000\u0000\u07dc\u07dd\u0001\u0000\u0000\u0000\u07dd"+
		"\u07df\u0001\u0000\u0000\u0000\u07de\u07dc\u0001\u0000\u0000\u0000\u07df"+
		"\u07e2\u0005\u0080\u0000\u0000\u07e0\u07e2\u0005\u0086\u0000\u0000\u07e1"+
		"\u07d8\u0001\u0000\u0000\u0000\u07e1\u07e0\u0001\u0000\u0000\u0000\u07e2"+
		"\u0113\u0001\u0000\u0000\u0000\u07e3\u07e4\u0005\u001c\u0000\u0000\u07e4"+
		"\u07e5\u0003n7\u0000\u07e5\u07e6\u0005\u0086\u0000\u0000\u07e6\u07f9\u0001"+
		"\u0000\u0000\u0000\u07e7\u07e8\u0005\u001a\u0000\u0000\u07e8\u07e9\u0003"+
		"n7\u0000\u07e9\u07ea\u0005\u0086\u0000\u0000\u07ea\u07f9\u0001\u0000\u0000"+
		"\u0000\u07eb\u07f9\u0003V+\u0000\u07ec\u07f9\u0003X,\u0000\u07ed\u07f9"+
		"\u0003Z-\u0000\u07ee\u07f9\u0003\\.\u0000\u07ef\u07f9\u0003^/\u0000\u07f0"+
		"\u07f9\u0003`0\u0000\u07f1\u07f9\u0003b1\u0000\u07f2\u07f9\u0003d2\u0000"+
		"\u07f3\u07f9\u0003h4\u0000\u07f4\u07f9\u0003j5\u0000\u07f5\u07f9\u0003"+
		"l6\u0000\u07f6\u07f9\u0003\u0164\u00b2\u0000\u07f7\u07f9\u0003\u011c\u008e"+
		"\u0000\u07f8\u07e3\u0001\u0000\u0000\u0000\u07f8\u07e7\u0001\u0000\u0000"+
		"\u0000\u07f8\u07eb\u0001\u0000\u0000\u0000\u07f8\u07ec\u0001\u0000\u0000"+
		"\u0000\u07f8\u07ed\u0001\u0000\u0000\u0000\u07f8\u07ee\u0001\u0000\u0000"+
		"\u0000\u07f8\u07ef\u0001\u0000\u0000\u0000\u07f8\u07f0\u0001\u0000\u0000"+
		"\u0000\u07f8\u07f1\u0001\u0000\u0000\u0000\u07f8\u07f2\u0001\u0000\u0000"+
		"\u0000\u07f8\u07f3\u0001\u0000\u0000\u0000\u07f8\u07f4\u0001\u0000\u0000"+
		"\u0000\u07f8\u07f5\u0001\u0000\u0000\u0000\u07f8\u07f6\u0001\u0000\u0000"+
		"\u0000\u07f8\u07f7\u0001\u0000\u0000\u0000\u07f9\u0115\u0001\u0000\u0000"+
		"\u0000\u07fa\u07fb\u0005\u00f9\u0000\u0000\u07fb\u07fc\u0005n\u0000\u0000"+
		"\u07fc\u07fd\u0003\u0012\t\u0000\u07fd\u07fe\u0005o\u0000\u0000\u07fe"+
		"\u07ff\u0005}\u0000\u0000\u07ff\u0800\u0003p8\u0000\u0800\u0801\u0005"+
		"~\u0000\u0000\u0801\u0117\u0001\u0000\u0000\u0000\u0802\u0803\u0005\u00fa"+
		"\u0000\u0000\u0803\u0804\u0005}\u0000\u0000\u0804\u0805\u0003p8\u0000"+
		"\u0805\u0806\u0005~\u0000\u0000\u0806\u0119\u0001\u0000\u0000\u0000\u0807"+
		"\u0808\u0005\u00fb\u0000\u0000\u0808\u080c\u0005\u007f\u0000\u0000\u0809"+
		"\u080b\u0003\u011c\u008e\u0000\u080a\u0809\u0001\u0000\u0000\u0000\u080b"+
		"\u080e\u0001\u0000\u0000\u0000\u080c\u080a\u0001\u0000\u0000\u0000\u080c"+
		"\u080d\u0001\u0000\u0000\u0000\u080d\u080f\u0001\u0000\u0000\u0000\u080e"+
		"\u080c\u0001\u0000\u0000\u0000\u080f\u0810\u0005\u0080\u0000\u0000\u0810"+
		"\u011b\u0001\u0000\u0000\u0000\u0811\u0812\u0005\u001a\u0000\u0000\u0812"+
		"\u0813\u0003p8\u0000\u0813\u0814\u0005\u0086\u0000\u0000\u0814\u011d\u0001"+
		"\u0000\u0000\u0000\u0815\u0816\u0005\u00fc\u0000\u0000\u0816\u0818\u0005"+
		"}\u0000\u0000\u0817\u0819\u00036\u001b\u0000\u0818\u0817\u0001\u0000\u0000"+
		"\u0000\u0818\u0819\u0001\u0000\u0000\u0000\u0819\u081a\u0001\u0000\u0000"+
		"\u0000\u081a\u081b\u0005~\u0000\u0000\u081b\u081c\u0005\u0088\u0000\u0000"+
		"\u081c\u081d\u0003:\u001d\u0000\u081d\u081e\u0005r\u0000\u0000\u081e\u081f"+
		"\u0003p8\u0000\u081f\u011f\u0001\u0000\u0000\u0000\u0820\u0821\u0005\u00fe"+
		"\u0000\u0000\u0821\u0822\u0003p8\u0000\u0822\u0823\u0005}\u0000\u0000"+
		"\u0823\u0824\u0003\u0122\u0091\u0000\u0824\u0825\u0005~\u0000\u0000\u0825"+
		"\u0121\u0001\u0000\u0000\u0000\u0826\u0827\u0003p8\u0000\u0827\u0828\u0005"+
		"\u0083\u0000\u0000\u0828\u082a\u0001\u0000\u0000\u0000\u0829\u0826\u0001"+
		"\u0000\u0000\u0000\u082a\u082d\u0001\u0000\u0000\u0000\u082b\u0829\u0001"+
		"\u0000\u0000\u0000\u082b\u082c\u0001\u0000\u0000\u0000\u082c\u082e\u0001"+
		"\u0000\u0000\u0000\u082d\u082b\u0001\u0000\u0000\u0000\u082e\u0833\u0005"+
		"\u008d\u0000\u0000\u082f\u0830\u0005\u0083\u0000\u0000\u0830\u0832\u0003"+
		"p8\u0000\u0831\u082f\u0001\u0000\u0000\u0000\u0832\u0835\u0001\u0000\u0000"+
		"\u0000\u0833\u0831\u0001\u0000\u0000\u0000\u0833\u0834\u0001\u0000\u0000"+
		"\u0000\u0834\u0123\u0001\u0000\u0000\u0000\u0835\u0833\u0001\u0000\u0000"+
		"\u0000\u0836\u0837\u0005\u0100\u0000\u0000\u0837\u0838\u0005}\u0000\u0000"+
		"\u0838\u0839\u0003p8\u0000\u0839\u083a\u0005\u0083\u0000\u0000\u083a\u083b"+
		"\u0003p8\u0000\u083b\u083c\u0005~\u0000\u0000\u083c\u0125\u0001\u0000"+
		"\u0000\u0000\u083d\u083e\u0003p8\u0000\u083e\u083f\u0005\u0101\u0000\u0000"+
		"\u083f\u0844\u0003p8\u0000\u0840\u0841\u0005\u0101\u0000\u0000\u0841\u0843"+
		"\u0003p8\u0000\u0842\u0840\u0001\u0000\u0000\u0000\u0843\u0846\u0001\u0000"+
		"\u0000\u0000\u0844\u0842\u0001\u0000\u0000\u0000\u0844\u0845\u0001\u0000"+
		"\u0000\u0000\u0845\u0127\u0001\u0000\u0000\u0000\u0846\u0844\u0001\u0000"+
		"\u0000\u0000\u0847\u0848\u0005\u0102\u0000\u0000\u0848\u0849\u0005}\u0000"+
		"\u0000\u0849\u0853\u0003p8\u0000\u084a\u084b\u0005\u0087\u0000\u0000\u084b"+
		"\u084c\u0005\u008f\u0000\u0000\u084c\u084e\u0005}\u0000\u0000\u084d\u084f"+
		"\u0003~?\u0000\u084e\u084d\u0001\u0000\u0000\u0000\u084e\u084f\u0001\u0000"+
		"\u0000\u0000\u084f\u0850\u0001\u0000\u0000\u0000\u0850\u0852\u0005~\u0000"+
		"\u0000\u0851\u084a\u0001\u0000\u0000\u0000\u0852\u0855\u0001\u0000\u0000"+
		"\u0000\u0853\u0851\u0001\u0000\u0000\u0000\u0853\u0854\u0001\u0000\u0000"+
		"\u0000\u0854\u0856\u0001\u0000\u0000\u0000\u0855\u0853\u0001\u0000\u0000"+
		"\u0000\u0856\u0857\u0005~\u0000\u0000\u0857\u0129\u0001\u0000\u0000\u0000"+
		"\u0858\u0859\u0005\u010a\u0000\u0000\u0859\u085e\u0005\u008f\u0000\u0000"+
		"\u085a\u085b\u0005\u0085\u0000\u0000\u085b\u085d\u0005\u008f\u0000\u0000"+
		"\u085c\u085a\u0001\u0000\u0000\u0000\u085d\u0860\u0001\u0000\u0000\u0000"+
		"\u085e\u085c\u0001\u0000\u0000\u0000\u085e\u085f\u0001\u0000\u0000\u0000"+
		"\u085f\u0861\u0001\u0000\u0000\u0000\u0860\u085e\u0001\u0000\u0000\u0000"+
		"\u0861\u0865\u0005\u007f\u0000\u0000\u0862\u0864\u0003\u012c\u0096\u0000"+
		"\u0863\u0862\u0001\u0000\u0000\u0000\u0864\u0867\u0001\u0000\u0000\u0000"+
		"\u0865\u0863\u0001\u0000\u0000\u0000\u0865\u0866\u0001\u0000\u0000\u0000"+
		"\u0866\u0868\u0001\u0000\u0000\u0000\u0867\u0865\u0001\u0000\u0000\u0000"+
		"\u0868\u0869\u0005\u0080\u0000\u0000\u0869\u012b\u0001\u0000\u0000\u0000"+
		"\u086a\u0871\u0003\u0002\u0001\u0000\u086b\u086c\u0003\u012e\u0097\u0000"+
		"\u086c\u086d\u0003\u0002\u0001\u0000\u086d\u0871\u0001\u0000\u0000\u0000"+
		"\u086e\u0871\u0003\u0130\u0098\u0000\u086f\u0871\u0003\u0134\u009a\u0000"+
		"\u0870\u086a\u0001\u0000\u0000\u0000\u0870\u086b\u0001\u0000\u0000\u0000"+
		"\u0870\u086e\u0001\u0000\u0000\u0000\u0870\u086f\u0001\u0000\u0000\u0000"+
		"\u0871\u012d\u0001\u0000\u0000\u0000\u0872\u0873\u0007\u000b\u0000\u0000"+
		"\u0873\u012f\u0001\u0000\u0000\u0000\u0874\u0875\u0005\u0103\u0000\u0000"+
		"\u0875\u0876\u0005\u0004\u0000\u0000\u0876\u0877\u0005\u008f\u0000\u0000"+
		"\u0877\u087b\u0005\u007f\u0000\u0000\u0878\u087a\u0003\u0132\u0099\u0000"+
		"\u0879\u0878\u0001\u0000\u0000\u0000\u087a\u087d\u0001\u0000\u0000\u0000"+
		"\u087b\u0879\u0001\u0000\u0000\u0000\u087b\u087c\u0001\u0000\u0000\u0000"+
		"\u087c\u087e\u0001\u0000\u0000\u0000\u087d\u087b\u0001\u0000\u0000\u0000"+
		"\u087e\u087f\u0005\u0080\u0000\u0000\u087f\u0131\u0001\u0000\u0000\u0000"+
		"\u0880\u0881\u0005\u0109\u0000\u0000\u0881\u0882\u0005\u008f\u0000\u0000"+
		"\u0882\u0886\u0005\u007f\u0000\u0000\u0883\u0885\u0003\u0002\u0001\u0000"+
		"\u0884\u0883\u0001\u0000\u0000\u0000\u0885\u0888\u0001\u0000\u0000\u0000"+
		"\u0886\u0884\u0001\u0000\u0000\u0000\u0886\u0887\u0001\u0000\u0000\u0000"+
		"\u0887\u0889\u0001\u0000\u0000\u0000\u0888\u0886\u0001\u0000\u0000\u0000"+
		"\u0889\u088c\u0005\u0080\u0000\u0000\u088a\u088c\u0003\u0002\u0001\u0000"+
		"\u088b\u0880\u0001\u0000\u0000\u0000\u088b\u088a\u0001\u0000\u0000\u0000"+
		"\u088c\u0133\u0001\u0000\u0000\u0000\u088d\u088e\u0005\u0104\u0000\u0000"+
		"\u088e\u088f\u0005\u0004\u0000\u0000\u088f\u0890\u0005\u008f\u0000\u0000"+
		"\u0890\u0894\u0005\u007f\u0000\u0000\u0891\u0893\u0003\u0136\u009b\u0000"+
		"\u0892\u0891\u0001\u0000\u0000\u0000\u0893\u0896\u0001\u0000\u0000\u0000"+
		"\u0894\u0892\u0001\u0000\u0000\u0000\u0894\u0895\u0001\u0000\u0000\u0000"+
		"\u0895\u0897\u0001\u0000\u0000\u0000\u0896\u0894\u0001\u0000\u0000\u0000"+
		"\u0897\u0898\u0005\u0080\u0000\u0000\u0898\u0135\u0001\u0000\u0000\u0000"+
		"\u0899\u089a\u0005\u0105\u0000\u0000\u089a\u089e\u0005\u007f\u0000\u0000"+
		"\u089b\u089d\u0003\u0002\u0001\u0000\u089c\u089b\u0001\u0000\u0000\u0000"+
		"\u089d\u08a0\u0001\u0000\u0000\u0000\u089e\u089c\u0001\u0000\u0000\u0000"+
		"\u089e\u089f\u0001\u0000\u0000\u0000\u089f\u08a1\u0001\u0000\u0000\u0000"+
		"\u08a0\u089e\u0001\u0000\u0000\u0000\u08a1\u08ad\u0005\u0080\u0000\u0000"+
		"\u08a2\u08a3\u0005\u0106\u0000\u0000\u08a3\u08a7\u0005\u007f\u0000\u0000"+
		"\u08a4\u08a6\u0003\u0002\u0001\u0000\u08a5\u08a4\u0001\u0000\u0000\u0000"+
		"\u08a6\u08a9\u0001\u0000\u0000\u0000\u08a7\u08a5\u0001\u0000\u0000\u0000"+
		"\u08a7\u08a8\u0001\u0000\u0000\u0000\u08a8\u08aa\u0001\u0000\u0000\u0000"+
		"\u08a9\u08a7\u0001\u0000\u0000\u0000\u08aa\u08ad\u0005\u0080\u0000\u0000"+
		"\u08ab\u08ad\u0003\u0002\u0001\u0000\u08ac\u0899\u0001\u0000\u0000\u0000"+
		"\u08ac\u08a2\u0001\u0000\u0000\u0000\u08ac\u08ab\u0001\u0000\u0000\u0000"+
		"\u08ad\u0137\u0001\u0000\u0000\u0000\u08ae\u08af\u0005\u010e\u0000\u0000"+
		"\u08af\u08b2\u0005\u008f\u0000\u0000\u08b0\u08b1\u0005\u018a\u0000\u0000"+
		"\u08b1\u08b3\u0003\u013a\u009d\u0000\u08b2\u08b0\u0001\u0000\u0000\u0000"+
		"\u08b2\u08b3\u0001\u0000\u0000\u0000\u08b3\u08b4\u0001\u0000\u0000\u0000"+
		"\u08b4\u08b8\u0005\u007f\u0000\u0000\u08b5\u08b7\u0003\u013c\u009e\u0000"+
		"\u08b6\u08b5\u0001\u0000\u0000\u0000\u08b7\u08ba\u0001\u0000\u0000\u0000"+
		"\u08b8\u08b6\u0001\u0000\u0000\u0000\u08b8\u08b9\u0001\u0000\u0000\u0000"+
		"\u08b9\u08bb\u0001\u0000\u0000\u0000\u08ba\u08b8\u0001\u0000\u0000\u0000"+
		"\u08bb\u08bc\u0005\u0080\u0000\u0000\u08bc\u0139\u0001\u0000\u0000\u0000"+
		"\u08bd\u08c2\u0005\u008f\u0000\u0000\u08be\u08bf\u0005\u0083\u0000\u0000"+
		"\u08bf\u08c1\u0005\u008f\u0000\u0000\u08c0\u08be\u0001\u0000\u0000\u0000"+
		"\u08c1\u08c4\u0001\u0000\u0000\u0000\u08c2\u08c0\u0001\u0000\u0000\u0000"+
		"\u08c2\u08c3\u0001\u0000\u0000\u0000\u08c3\u013b\u0001\u0000\u0000\u0000"+
		"\u08c4\u08c2\u0001\u0000\u0000\u0000\u08c5\u08c6\u0005\u010f\u0000\u0000"+
		"\u08c6\u08c7\u0005\u008f\u0000\u0000\u08c7\u08c8\u0005}\u0000\u0000\u08c8"+
		"\u08c9\u00036\u001b\u0000\u08c9\u08cc\u0005~\u0000\u0000\u08ca\u08cb\u0005"+
		"\u0088\u0000\u0000\u08cb\u08cd\u0003:\u001d\u0000\u08cc\u08ca\u0001\u0000"+
		"\u0000\u0000\u08cc\u08cd\u0001\u0000\u0000\u0000\u08cd\u08ce\u0001\u0000"+
		"\u0000\u0000\u08ce\u08cf\u0005\u0086\u0000\u0000\u08cf\u08d2\u0001\u0000"+
		"\u0000\u0000\u08d0\u08d2\u0003\u0002\u0001\u0000\u08d1\u08c5\u0001\u0000"+
		"\u0000\u0000\u08d1\u08d0\u0001\u0000\u0000\u0000\u08d2\u013d\u0001\u0000"+
		"\u0000\u0000\u08d3\u08d4\u0005\u0110\u0000\u0000\u08d4\u08d5\u0005\u008f"+
		"\u0000\u0000\u08d5\u08d9\u0005\u007f\u0000\u0000\u08d6\u08d8\u0003\u0140"+
		"\u00a0\u0000\u08d7\u08d6\u0001\u0000\u0000\u0000\u08d8\u08db\u0001\u0000"+
		"\u0000\u0000\u08d9\u08d7\u0001\u0000\u0000\u0000\u08d9\u08da\u0001\u0000"+
		"\u0000\u0000\u08da\u08dc\u0001\u0000\u0000\u0000\u08db\u08d9\u0001\u0000"+
		"\u0000\u0000\u08dc\u08dd\u0005\u0080\u0000\u0000\u08dd\u013f\u0001\u0000"+
		"\u0000\u0000\u08de\u08df\u0005\u0111\u0000\u0000\u08df\u08e0\u0005\u018b"+
		"\u0000\u0000\u08e0\u08e1\u0005r\u0000\u0000\u08e1\u08e2\u0005O\u0000\u0000"+
		"\u08e2\u08ea\u0005\u0086\u0000\u0000\u08e3\u08e4\u0005\u013c\u0000\u0000"+
		"\u08e4\u08e5\u0005\u018c\u0000\u0000\u08e5\u08ea\u0005\u0086\u0000\u0000"+
		"\u08e6\u08e7\u0005\u018d\u0000\u0000\u08e7\u08e8\u0005\u018c\u0000\u0000"+
		"\u08e8\u08ea\u0005\u0086\u0000\u0000\u08e9\u08de\u0001\u0000\u0000\u0000"+
		"\u08e9\u08e3\u0001\u0000\u0000\u0000\u08e9\u08e6\u0001\u0000\u0000\u0000"+
		"\u08ea\u0141\u0001\u0000\u0000\u0000\u08eb\u08ec\u0005\u0111\u0000\u0000"+
		"\u08ec\u08ed\u0005\u008f\u0000\u0000\u08ed\u08f1\u0005\u007f\u0000\u0000"+
		"\u08ee\u08f0\u0003\u0144\u00a2\u0000\u08ef\u08ee\u0001\u0000\u0000\u0000"+
		"\u08f0\u08f3\u0001\u0000\u0000\u0000\u08f1\u08ef\u0001\u0000\u0000\u0000"+
		"\u08f1\u08f2\u0001\u0000\u0000\u0000\u08f2\u08f4\u0001\u0000\u0000\u0000"+
		"\u08f3\u08f1\u0001\u0000\u0000\u0000\u08f4\u08f5\u0005\u0080\u0000\u0000"+
		"\u08f5\u0143\u0001\u0000\u0000\u0000\u08f6\u08f7\u0005\u0007\u0000\u0000"+
		"\u08f7\u08f8\u0005\u008f\u0000\u0000\u08f8\u08f9\u0005}\u0000\u0000\u08f9"+
		"\u08fa\u00036\u001b\u0000\u08fa\u08fd\u0005~\u0000\u0000\u08fb\u08fc\u0005"+
		"\u0088\u0000\u0000\u08fc\u08fe\u0003:\u001d\u0000\u08fd\u08fb\u0001\u0000"+
		"\u0000\u0000\u08fd\u08fe\u0001\u0000\u0000\u0000\u08fe\u08ff\u0001\u0000"+
		"\u0000\u0000\u08ff\u0900\u0005\u0086\u0000\u0000\u0900\u0145\u0001\u0000"+
		"\u0000\u0000\u0901\u0902\u0005\u0112\u0000\u0000\u0902\u0903\u0005\u008f"+
		"\u0000\u0000\u0903\u0907\u0005\u007f\u0000\u0000\u0904\u0906\u0003\u0148"+
		"\u00a4\u0000\u0905\u0904\u0001\u0000\u0000\u0000\u0906\u0909\u0001\u0000"+
		"\u0000\u0000\u0907\u0905\u0001\u0000\u0000\u0000\u0907\u0908\u0001\u0000"+
		"\u0000\u0000\u0908\u090a\u0001\u0000\u0000\u0000\u0909\u0907\u0001\u0000"+
		"\u0000\u0000\u090a\u090b\u0005\u0080\u0000\u0000\u090b\u0147\u0001\u0000"+
		"\u0000\u0000\u090c\u090d\u0005\u0007\u0000\u0000\u090d\u090e\u0005\u008f"+
		"\u0000\u0000\u090e\u090f\u0005}\u0000\u0000\u090f\u0910\u00036\u001b\u0000"+
		"\u0910\u0913\u0005~\u0000\u0000\u0911\u0912\u0005\u0088\u0000\u0000\u0912"+
		"\u0914\u0003:\u001d\u0000\u0913\u0911\u0001\u0000\u0000\u0000\u0913\u0914"+
		"\u0001\u0000\u0000\u0000\u0914\u0915\u0001\u0000\u0000\u0000\u0915\u0916"+
		"\u0005\u0086\u0000\u0000\u0916\u0149\u0001\u0000\u0000\u0000\u0917\u0918"+
		"\u0005\u0113\u0000\u0000\u0918\u0919\u0005\u008f\u0000\u0000\u0919\u091d"+
		"\u0005\u007f\u0000\u0000\u091a\u091c\u0003\u014c\u00a6\u0000\u091b\u091a"+
		"\u0001\u0000\u0000\u0000\u091c\u091f\u0001\u0000\u0000\u0000\u091d\u091b"+
		"\u0001\u0000\u0000\u0000\u091d\u091e\u0001\u0000\u0000\u0000\u091e\u0920"+
		"\u0001\u0000\u0000\u0000\u091f\u091d\u0001\u0000\u0000\u0000\u0920\u0921"+
		"\u0005\u0080\u0000\u0000\u0921\u014b\u0001\u0000\u0000\u0000\u0922\u0924"+
		"\u0003\u00bc^\u0000\u0923\u0925\u0005\u0114\u0000\u0000\u0924\u0923\u0001"+
		"\u0000\u0000\u0000\u0924\u0925\u0001\u0000\u0000\u0000\u0925\u0926\u0001"+
		"\u0000\u0000\u0000\u0926\u0927\u0005\u0089\u0000\u0000\u0927\u0928\u0003"+
		"p8\u0000\u0928\u014d\u0001\u0000\u0000\u0000\u0929\u092a\u0005\u0114\u0000"+
		"\u0000\u092a\u092b\u0005}\u0000\u0000\u092b\u092c\u0003p8\u0000\u092c"+
		"\u092d\u0005~\u0000\u0000\u092d\u014f\u0001\u0000\u0000\u0000\u092e\u092f"+
		"\u0005\u0116\u0000\u0000\u092f\u0930\u0005}\u0000\u0000\u0930\u0935\u0003"+
		"\u0152\u00a9\u0000\u0931\u0932\u0005\u0083\u0000\u0000\u0932\u0934\u0003"+
		"\u0152\u00a9\u0000\u0933\u0931\u0001\u0000\u0000\u0000\u0934\u0937\u0001"+
		"\u0000\u0000\u0000\u0935\u0933\u0001\u0000\u0000\u0000\u0935\u0936\u0001"+
		"\u0000\u0000\u0000\u0936\u0938\u0001\u0000\u0000\u0000\u0937\u0935\u0001"+
		"\u0000\u0000\u0000\u0938\u0939\u0005~\u0000\u0000\u0939\u093a\u0005r\u0000"+
		"\u0000\u093a\u093b\u0003p8\u0000\u093b\u0151\u0001\u0000\u0000\u0000\u093c"+
		"\u093d\u0005\u0115\u0000\u0000\u093d\u093e\u0005\u008f\u0000\u0000\u093e"+
		"\u093f\u0005\u0084\u0000\u0000\u093f\u0942\u0003\u0012\t\u0000\u0940\u0942"+
		"\u0005\u008f\u0000\u0000\u0941\u093c\u0001\u0000\u0000\u0000\u0941\u0940"+
		"\u0001\u0000\u0000\u0000\u0942\u0153\u0001\u0000\u0000\u0000\u0943\u0944"+
		"\u0005\u0117\u0000\u0000\u0944\u0945\u0005n\u0000\u0000\u0945\u0946\u0003"+
		"\u0012\t\u0000\u0946\u0947\u0005o\u0000\u0000\u0947\u0948\u0005}\u0000"+
		"\u0000\u0948\u0949\u0003p8\u0000\u0949\u094a\u0005\u0101\u0000\u0000\u094a"+
		"\u094b\u0003\u0156\u00ab\u0000\u094b\u094c\u0005~\u0000\u0000\u094c\u0155"+
		"\u0001\u0000\u0000\u0000\u094d\u0952\u0003\u0158\u00ac\u0000\u094e\u094f"+
		"\u0005\u0083\u0000\u0000\u094f\u0951\u0003\u0158\u00ac\u0000\u0950\u094e"+
		"\u0001\u0000\u0000\u0000\u0951\u0954\u0001\u0000\u0000\u0000\u0952\u0950"+
		"\u0001\u0000\u0000\u0000\u0952\u0953\u0001\u0000\u0000\u0000\u0953\u0157"+
		"\u0001\u0000\u0000\u0000\u0954\u0952\u0001\u0000\u0000\u0000\u0955\u0956"+
		"\u0005\u0118\u0000\u0000\u0956\u0957\u0005\u0087\u0000\u0000\u0957\u0958"+
		"\u0003\u015a\u00ad\u0000\u0958\u095a\u0005}\u0000\u0000\u0959\u095b\u0003"+
		"~?\u0000\u095a\u0959\u0001\u0000\u0000\u0000\u095a\u095b\u0001\u0000\u0000"+
		"\u0000\u095b\u095c\u0001\u0000\u0000\u0000\u095c\u095d\u0005~\u0000\u0000"+
		"\u095d\u0159\u0001\u0000\u0000\u0000\u095e\u095f\u0007\f\u0000\u0000\u095f"+
		"\u015b\u0001\u0000\u0000\u0000\u0960\u0961\u0005\u011a\u0000\u0000\u0961"+
		"\u0962\u0005\u007f\u0000\u0000\u0962\u0963\u0003p8\u0000\u0963\u0964\u0005"+
		"\u0101\u0000\u0000\u0964\u0965\u0003\u015e\u00af\u0000\u0965\u0966\u0005"+
		"\u0080\u0000\u0000\u0966\u015d\u0001\u0000\u0000\u0000\u0967\u096c\u0003"+
		"\u0160\u00b0\u0000\u0968\u0969\u0005\u0083\u0000\u0000\u0969\u096b\u0003"+
		"\u0160\u00b0\u0000\u096a\u0968\u0001\u0000\u0000\u0000\u096b\u096e\u0001"+
		"\u0000\u0000\u0000\u096c\u096a\u0001\u0000\u0000\u0000\u096c\u096d\u0001"+
		"\u0000\u0000\u0000\u096d\u015f\u0001\u0000\u0000\u0000\u096e\u096c\u0001"+
		"\u0000\u0000\u0000\u096f\u0970\u0005\u008f\u0000\u0000\u0970\u0971\u0005"+
		"\u0011\u0000\u0000\u0971\u0974\u0003p8\u0000\u0972\u0973\u0005\u0012\u0000"+
		"\u0000\u0973\u0975\u0003p8\u0000\u0974\u0972\u0001\u0000\u0000\u0000\u0974"+
		"\u0975\u0001\u0000\u0000\u0000\u0975\u0161\u0001\u0000\u0000\u0000\u0976"+
		"\u0977\u0005\u011d\u0000\u0000\u0977\u0978\u0005}\u0000\u0000\u0978\u0979"+
		"\u0003p8\u0000\u0979\u097a\u0005\u0083\u0000\u0000\u097a\u097d\u0003p"+
		"8\u0000\u097b\u097c\u0005\u0083\u0000\u0000\u097c\u097e\u0003p8\u0000"+
		"\u097d\u097b\u0001\u0000\u0000\u0000\u097d\u097e\u0001\u0000\u0000\u0000"+
		"\u097e\u0981\u0001\u0000\u0000\u0000\u097f\u0980\u0005\u0083\u0000\u0000"+
		"\u0980\u0982\u0005\u011e\u0000\u0000\u0981\u097f\u0001\u0000\u0000\u0000"+
		"\u0981\u0982\u0001\u0000\u0000\u0000\u0982\u0983\u0001\u0000\u0000\u0000"+
		"\u0983\u0984\u0005~\u0000\u0000\u0984\u0163\u0001\u0000\u0000\u0000\u0985"+
		"\u0987\u0005\u0119\u0000\u0000\u0986\u0988\u0003p8\u0000\u0987\u0986\u0001"+
		"\u0000\u0000\u0000\u0987\u0988\u0001\u0000\u0000\u0000\u0988\u0989\u0001"+
		"\u0000\u0000\u0000\u0989\u098a\u0005\u0086\u0000\u0000\u098a\u0165\u0001"+
		"\u0000\u0000\u0000\u098b\u098c\u0005\u011b\u0000\u0000\u098c\u0995\u0005"+
		"\u0081\u0000\u0000\u098d\u0992\u0003p8";
	private static final String _serializedATNSegment1 =
		"\u0000\u098e\u098f\u0005\u0083\u0000\u0000\u098f\u0991\u0003p8\u0000\u0990"+
		"\u098e\u0001\u0000\u0000\u0000\u0991\u0994\u0001\u0000\u0000\u0000\u0992"+
		"\u0990\u0001\u0000\u0000\u0000\u0992\u0993\u0001\u0000\u0000\u0000\u0993"+
		"\u0996\u0001\u0000\u0000\u0000\u0994\u0992\u0001\u0000\u0000\u0000\u0995"+
		"\u098d\u0001\u0000\u0000\u0000\u0995\u0996\u0001\u0000\u0000\u0000\u0996"+
		"\u0997\u0001\u0000\u0000\u0000\u0997\u0998\u0005\u0082\u0000\u0000\u0998"+
		"\u0167\u0001\u0000\u0000\u0000\u0999\u099a\u0005\u011c\u0000\u0000\u099a"+
		"\u09a3\u0005\u007f\u0000\u0000\u099b\u09a0\u0003p8\u0000\u099c\u099d\u0005"+
		"\u0083\u0000\u0000\u099d\u099f\u0003p8\u0000\u099e\u099c\u0001\u0000\u0000"+
		"\u0000\u099f\u09a2\u0001\u0000\u0000\u0000\u09a0\u099e\u0001\u0000\u0000"+
		"\u0000\u09a0\u09a1\u0001\u0000\u0000\u0000\u09a1\u09a4\u0001\u0000\u0000"+
		"\u0000\u09a2\u09a0\u0001\u0000\u0000\u0000\u09a3\u099b\u0001\u0000\u0000"+
		"\u0000\u09a3\u09a4\u0001\u0000\u0000\u0000\u09a4\u09a5\u0001\u0000\u0000"+
		"\u0000\u09a5\u09a6\u0005\u0080\u0000\u0000\u09a6\u0169\u0001\u0000\u0000"+
		"\u0000\u09a7\u09a8\u0005\u012b\u0000\u0000\u09a8\u09a9\u0005n\u0000\u0000"+
		"\u09a9\u09aa\u0003\u0018\f\u0000\u09aa\u09ab\u0005o\u0000\u0000\u09ab"+
		"\u09ac\u0005}\u0000\u0000\u09ac\u09ad\u0003\u016c\u00b6\u0000\u09ad\u09ae"+
		"\u0005~\u0000\u0000\u09ae\u09b8\u0001\u0000\u0000\u0000\u09af\u09b0\u0005"+
		"\u012c\u0000\u0000\u09b0\u09b1\u0005n\u0000\u0000\u09b1\u09b2\u0003\u0012"+
		"\t\u0000\u09b2\u09b3\u0005o\u0000\u0000\u09b3\u09b4\u0005}\u0000\u0000"+
		"\u09b4\u09b5\u0003\u016e\u00b7\u0000\u09b5\u09b6\u0005~\u0000\u0000\u09b6"+
		"\u09b8\u0001\u0000\u0000\u0000\u09b7\u09a7\u0001\u0000\u0000\u0000\u09b7"+
		"\u09af\u0001\u0000\u0000\u0000\u09b8\u016b\u0001\u0000\u0000\u0000\u09b9"+
		"\u09ba\u0007\r\u0000\u0000\u09ba\u016d\u0001\u0000\u0000\u0000\u09bb\u09bc"+
		"\u0003p8\u0000\u09bc\u016f\u0001\u0000\u0000\u0000\u09bd\u09be\u0005\u012d"+
		"\u0000\u0000\u09be\u09bf\u0005n\u0000\u0000\u09bf\u09c0\u0003\u0172\u00b9"+
		"\u0000\u09c0\u09c1\u0005o\u0000\u0000\u09c1\u09c2\u0005}\u0000\u0000\u09c2"+
		"\u09c3\u0003\u0174\u00ba\u0000\u09c3\u09c4\u0005~\u0000\u0000\u09c4\u0171"+
		"\u0001\u0000\u0000\u0000\u09c5\u09c6\u0007\u000e\u0000\u0000\u09c6\u0173"+
		"\u0001\u0000\u0000\u0000\u09c7\u09cc\u0003p8\u0000\u09c8\u09c9\u0005\u0083"+
		"\u0000\u0000\u09c9\u09cb\u0003p8\u0000\u09ca\u09c8\u0001\u0000\u0000\u0000"+
		"\u09cb\u09ce\u0001\u0000\u0000\u0000\u09cc\u09ca\u0001\u0000\u0000\u0000"+
		"\u09cc\u09cd\u0001\u0000\u0000\u0000\u09cd\u0175\u0001\u0000\u0000\u0000"+
		"\u09ce\u09cc\u0001\u0000\u0000\u0000\u09cf\u09d0\u0005\u012e\u0000\u0000"+
		"\u09d0\u09d1\u0005\u008f\u0000\u0000\u09d1\u09d5\u0005\u007f\u0000\u0000"+
		"\u09d2\u09d4\u0003\u0178\u00bc\u0000\u09d3\u09d2\u0001\u0000\u0000\u0000"+
		"\u09d4\u09d7\u0001\u0000\u0000\u0000\u09d5\u09d3\u0001\u0000\u0000\u0000"+
		"\u09d5\u09d6\u0001\u0000\u0000\u0000\u09d6\u09d8\u0001\u0000\u0000\u0000"+
		"\u09d7\u09d5\u0001\u0000\u0000\u0000\u09d8\u09d9\u0005\u0080\u0000\u0000"+
		"\u09d9\u0177\u0001\u0000\u0000\u0000\u09da\u09db\u0005\u008f\u0000\u0000"+
		"\u09db\u09dc\u0005\u0088\u0000\u0000\u09dc\u09e0\u0005\u007f\u0000\u0000"+
		"\u09dd\u09df\u0003\u017a\u00bd\u0000\u09de\u09dd\u0001\u0000\u0000\u0000"+
		"\u09df\u09e2\u0001\u0000\u0000\u0000\u09e0\u09de\u0001\u0000\u0000\u0000"+
		"\u09e0\u09e1\u0001\u0000\u0000\u0000\u09e1\u09e3\u0001\u0000\u0000\u0000"+
		"\u09e2\u09e0\u0001\u0000\u0000\u0000\u09e3\u09e4\u0005\u0080\u0000\u0000"+
		"\u09e4\u0179\u0001\u0000\u0000\u0000\u09e5\u09e6\u0005\u0192\u0000\u0000"+
		"\u09e6\u09e7\u0005}\u0000\u0000\u09e7\u09e8\u0003\u017c\u00be\u0000\u09e8"+
		"\u09e9\u0005~\u0000\u0000\u09e9\u09fa\u0001\u0000\u0000\u0000\u09ea\u09eb"+
		"\u0005\u0193\u0000\u0000\u09eb\u09ec\u0005}\u0000\u0000\u09ec\u09ed\u0003"+
		"\u017c\u00be\u0000\u09ed\u09ee\u0005~\u0000\u0000\u09ee\u09fa\u0001\u0000"+
		"\u0000\u0000\u09ef\u09f0\u0005\u0194\u0000\u0000\u09f0\u09f1\u0005}\u0000"+
		"\u0000\u09f1\u09f2\u0003\u017e\u00bf\u0000\u09f2\u09f3\u0005~\u0000\u0000"+
		"\u09f3\u09fa\u0001\u0000\u0000\u0000\u09f4\u09f5\u00055\u0000\u0000\u09f5"+
		"\u09f6\u0005}\u0000\u0000\u09f6\u09f7\u0003\u0180\u00c0\u0000\u09f7\u09f8"+
		"\u0005~\u0000\u0000\u09f8\u09fa\u0001\u0000\u0000\u0000\u09f9\u09e5\u0001"+
		"\u0000\u0000\u0000\u09f9\u09ea\u0001\u0000\u0000\u0000\u09f9\u09ef\u0001"+
		"\u0000\u0000\u0000\u09f9\u09f4\u0001\u0000\u0000\u0000\u09fa\u017b\u0001"+
		"\u0000\u0000\u0000\u09fb\u09fc\u0003p8\u0000\u09fc\u017d\u0001\u0000\u0000"+
		"\u0000\u09fd\u09fe\u0003p8\u0000\u09fe\u017f\u0001\u0000\u0000\u0000\u09ff"+
		"\u0a00\u0003p8\u0000\u0a00\u0181\u0001\u0000\u0000\u0000\u0a01\u0a02\u0005"+
		"\u012f\u0000\u0000\u0a02\u0a03\u0005}\u0000\u0000\u0a03\u0a04\u0003\u0184"+
		"\u00c2\u0000\u0a04\u0a05\u0005\u0083\u0000\u0000\u0a05\u0a06\u0003\u0186"+
		"\u00c3\u0000\u0a06\u0a07\u0005\u0083\u0000\u0000\u0a07\u0a08\u0003\u0188"+
		"\u00c4\u0000\u0a08\u0a09\u0005\u0083\u0000\u0000\u0a09\u0a0a\u0003\u018a"+
		"\u00c5\u0000\u0a0a\u0a0b\u0005~\u0000\u0000\u0a0b\u0183\u0001\u0000\u0000"+
		"\u0000\u0a0c\u0a0d\u0003p8\u0000\u0a0d\u0185\u0001\u0000\u0000\u0000\u0a0e"+
		"\u0a0f\u0003p8\u0000\u0a0f\u0187\u0001\u0000\u0000\u0000\u0a10\u0a11\u0003"+
		"p8\u0000\u0a11\u0189\u0001\u0000\u0000\u0000\u0a12\u0a13\u0003p8\u0000"+
		"\u0a13\u018b\u0001\u0000\u0000\u0000\u0a14\u0a15\u0005\u0130\u0000\u0000"+
		"\u0a15\u0a16\u0005\u0087\u0000\u0000\u0a16\u0a17\u0003\u018e\u00c7\u0000"+
		"\u0a17\u0a18\u0005}\u0000\u0000\u0a18\u0a19\u0003\u0190\u00c8\u0000\u0a19"+
		"\u0a1a\u0005\u0083\u0000\u0000\u0a1a\u0a1b\u0003\u0192\u00c9\u0000\u0a1b"+
		"\u0a1c\u0005~\u0000\u0000\u0a1c\u018d\u0001\u0000\u0000\u0000\u0a1d\u0a1e"+
		"\u0007\u000f\u0000\u0000\u0a1e\u018f\u0001\u0000\u0000\u0000\u0a1f\u0a20"+
		"\u0003p8\u0000\u0a20\u0191\u0001\u0000\u0000\u0000\u0a21\u0a22\u0003p"+
		"8\u0000\u0a22\u0193\u0001\u0000\u0000\u0000\u0a23\u0a24\u0005?\u0000\u0000"+
		"\u0a24\u0a25\u0005}\u0000\u0000\u0a25\u0a26\u0003p8\u0000\u0a26\u0a27"+
		"\u0005\u0083\u0000\u0000\u0a27\u0a28\u0003\u0196\u00cb\u0000\u0a28\u0a29"+
		"\u0005~\u0000\u0000\u0a29\u0195\u0001\u0000\u0000\u0000\u0a2a\u0a2f\u0003"+
		"p8\u0000\u0a2b\u0a2c\u0005\u0083\u0000\u0000\u0a2c\u0a2e\u0003p8\u0000"+
		"\u0a2d\u0a2b\u0001\u0000\u0000\u0000\u0a2e\u0a31\u0001\u0000\u0000\u0000"+
		"\u0a2f\u0a2d\u0001\u0000\u0000\u0000\u0a2f\u0a30\u0001\u0000\u0000\u0000"+
		"\u0a30\u0197\u0001\u0000\u0000\u0000\u0a31\u0a2f\u0001\u0000\u0000\u0000"+
		"\u0a32\u0a33\u0005\u0134\u0000\u0000\u0a33\u0a34\u0005}\u0000\u0000\u0a34"+
		"\u0a35\u0003\u0108\u0084\u0000\u0a35\u0a36\u0005\u0083\u0000\u0000\u0a36"+
		"\u0a37\u0003\u019a\u00cd\u0000\u0a37\u0a38\u0005~\u0000\u0000\u0a38\u0199"+
		"\u0001\u0000\u0000\u0000\u0a39\u0a3e\u0003p8\u0000\u0a3a\u0a3b\u0005\u0083"+
		"\u0000\u0000\u0a3b\u0a3d\u0003p8\u0000\u0a3c\u0a3a\u0001\u0000\u0000\u0000"+
		"\u0a3d\u0a40\u0001\u0000\u0000\u0000\u0a3e\u0a3c\u0001\u0000\u0000\u0000"+
		"\u0a3e\u0a3f\u0001\u0000\u0000\u0000\u0a3f\u019b\u0001\u0000\u0000\u0000"+
		"\u0a40\u0a3e\u0001\u0000\u0000\u0000\u0a41\u0a42\u0005\u0139\u0000\u0000"+
		"\u0a42\u0a43\u0005}\u0000\u0000\u0a43\u0a44\u0003\u017c\u00be\u0000\u0a44"+
		"\u0a45\u0005\u0083\u0000\u0000\u0a45\u0a46\u0003\u019e\u00cf\u0000\u0a46"+
		"\u0a47\u0005~\u0000\u0000\u0a47\u019d\u0001\u0000\u0000\u0000\u0a48\u0a49"+
		"\u0007\u0010\u0000\u0000\u0a49\u019f\u0001\u0000\u0000\u0000\u0a4a\u0a4b"+
		"\u0005\u013a\u0000\u0000\u0a4b\u0a4c\u0005}\u0000\u0000\u0a4c\u0a4d\u0003"+
		"\u018e\u00c7\u0000\u0a4d\u0a4e\u0005~\u0000\u0000\u0a4e\u01a1\u0001\u0000"+
		"\u0000\u0000\u0a4f\u0a50\u0005\u013b\u0000\u0000\u0a50\u0a51\u0005}\u0000"+
		"\u0000\u0a51\u0a52\u0003\u01a4\u00d2\u0000\u0a52\u0a53\u0005\u0083\u0000"+
		"\u0000\u0a53\u0a54\u0003\u01a6\u00d3\u0000\u0a54\u0a55\u0005~\u0000\u0000"+
		"\u0a55\u01a3\u0001\u0000\u0000\u0000\u0a56\u0a57\u0003p8\u0000\u0a57\u01a5"+
		"\u0001\u0000\u0000\u0000\u0a58\u0a59\u0003p8\u0000\u0a59\u01a7\u0001\u0000"+
		"\u0000\u0000\u0a5a\u0a5b\u0005\u013c\u0000\u0000\u0a5b\u0a5c\u0005}\u0000"+
		"\u0000\u0a5c\u0a5d\u0003\u01aa\u00d5\u0000\u0a5d\u0a5e\u0005\u0083\u0000"+
		"\u0000\u0a5e\u0a5f\u0003\u01ac\u00d6\u0000\u0a5f\u0a60\u0005~\u0000\u0000"+
		"\u0a60\u01a9\u0001\u0000\u0000\u0000\u0a61\u0a62\u0003p8\u0000\u0a62\u01ab"+
		"\u0001\u0000\u0000\u0000\u0a63\u0a64\u0003p8\u0000\u0a64\u01ad\u0001\u0000"+
		"\u0000\u0000\u0a65\u0a66\u0005\u013d\u0000\u0000\u0a66\u0a67\u0005}\u0000"+
		"\u0000\u0a67\u0a68\u0003\u01b0\u00d8\u0000\u0a68\u0a69\u0005\u0083\u0000"+
		"\u0000\u0a69\u0a6a\u0003\u01b2\u00d9\u0000\u0a6a\u0a6b\u0005~\u0000\u0000"+
		"\u0a6b\u01af\u0001\u0000\u0000\u0000\u0a6c\u0a6d\u0003p8\u0000\u0a6d\u01b1"+
		"\u0001\u0000\u0000\u0000\u0a6e\u0a6f\u0003p8\u0000\u0a6f\u01b3\u0001\u0000"+
		"\u0000\u0000\u0a70\u0a71\u0005\u013e\u0000\u0000\u0a71\u0a72\u0005}\u0000"+
		"\u0000\u0a72\u0a73\u0003\u01a4\u00d2\u0000\u0a73\u0a74\u0005\u0083\u0000"+
		"\u0000\u0a74\u0a75\u0003\u01b6\u00db\u0000\u0a75\u0a76\u0005~\u0000\u0000"+
		"\u0a76\u01b5\u0001\u0000\u0000\u0000\u0a77\u0a78\u0003p8\u0000\u0a78\u01b7"+
		"\u0001\u0000\u0000\u0000\u0a79\u0a7a\u0005\u013f\u0000\u0000\u0a7a\u0a7b"+
		"\u0005}\u0000\u0000\u0a7b\u0a7c\u0003\u01ba\u00dd\u0000\u0a7c\u0a7d\u0005"+
		"\u0083\u0000\u0000\u0a7d\u0a7e\u0003\u01bc\u00de\u0000\u0a7e\u0a7f\u0005"+
		"~\u0000\u0000\u0a7f\u01b9\u0001\u0000\u0000\u0000\u0a80\u0a81\u0003p8"+
		"\u0000\u0a81\u01bb\u0001\u0000\u0000\u0000\u0a82\u0a83\u0003p8\u0000\u0a83"+
		"\u01bd\u0001\u0000\u0000\u0000\u0a84\u0a85\u0005\u0140\u0000\u0000\u0a85"+
		"\u0a86\u0005}\u0000\u0000\u0a86\u0a87\u0003\u01c0\u00e0\u0000\u0a87\u0a88"+
		"\u0005\u0083\u0000\u0000\u0a88\u0a89\u0003\u01c2\u00e1\u0000\u0a89\u0a8a"+
		"\u0005~\u0000\u0000\u0a8a\u01bf\u0001\u0000\u0000\u0000\u0a8b\u0a8c\u0003"+
		"p8\u0000\u0a8c\u01c1\u0001\u0000\u0000\u0000\u0a8d\u0a8e\u0003p8\u0000"+
		"\u0a8e\u01c3\u0001\u0000\u0000\u0000\u0a8f\u0a90\u0005\u0141\u0000\u0000"+
		"\u0a90\u0a91\u0005}\u0000\u0000\u0a91\u0a92\u0003\u01c6\u00e3\u0000\u0a92"+
		"\u0a93\u0005\u0083\u0000\u0000\u0a93\u0a94\u0003\u01c8\u00e4\u0000\u0a94"+
		"\u0a95\u0005~\u0000\u0000\u0a95\u01c5\u0001\u0000\u0000\u0000\u0a96\u0a97"+
		"\u0003p8\u0000\u0a97\u01c7\u0001\u0000\u0000\u0000\u0a98\u0a99\u0003p"+
		"8\u0000\u0a99\u01c9\u0001\u0000\u0000\u0000\u0a9a\u0a9b\u0005\u0142\u0000"+
		"\u0000\u0a9b\u0a9c\u0005}\u0000\u0000\u0a9c\u0a9d\u0003\u01c6\u00e3\u0000"+
		"\u0a9d\u0a9e\u0005\u0083\u0000\u0000\u0a9e\u0a9f\u0003\u01c8\u00e4\u0000"+
		"\u0a9f\u0aa0\u0005~\u0000\u0000\u0aa0\u01cb\u0001\u0000\u0000\u0000\u0aa1"+
		"\u0aa2\u0005\u0143\u0000\u0000\u0aa2\u0aa3\u0005}\u0000\u0000\u0aa3\u0aa4"+
		"\u0003\u01ce\u00e7\u0000\u0aa4\u0aa5\u0005\u0083\u0000\u0000\u0aa5\u0aa6"+
		"\u0003\u017c\u00be\u0000\u0aa6\u0aa7\u0005~\u0000\u0000\u0aa7\u01cd\u0001"+
		"\u0000\u0000\u0000\u0aa8\u0aa9\u0003p8\u0000\u0aa9\u01cf\u0001\u0000\u0000"+
		"\u0000\u0aaa\u0aab\u0005\u0144\u0000\u0000\u0aab\u0aac\u0005}\u0000\u0000"+
		"\u0aac\u0aad\u0003\u01d2\u00e9\u0000\u0aad\u0aae\u0005\u0083\u0000\u0000"+
		"\u0aae\u0aaf\u0003\u01d4\u00ea\u0000\u0aaf\u0ab0\u0005~\u0000\u0000\u0ab0"+
		"\u01d1\u0001\u0000\u0000\u0000\u0ab1\u0ab2\u0003p8\u0000\u0ab2\u01d3\u0001"+
		"\u0000\u0000\u0000\u0ab3\u0ab4\u0003p8\u0000\u0ab4\u01d5\u0001\u0000\u0000"+
		"\u0000\u0ab5\u0ab6\u0005\u0145\u0000\u0000\u0ab6\u0ab7\u0005}\u0000\u0000"+
		"\u0ab7\u0ab8\u0003\u01d8\u00ec\u0000\u0ab8\u0ab9\u0005\u0083\u0000\u0000"+
		"\u0ab9\u0aba\u0003\u01da\u00ed\u0000\u0aba\u0abb\u0005~\u0000\u0000\u0abb"+
		"\u01d7\u0001\u0000\u0000\u0000\u0abc\u0abd\u0003p8\u0000\u0abd\u01d9\u0001"+
		"\u0000\u0000\u0000\u0abe\u0abf\u0003p8\u0000\u0abf\u01db\u0001\u0000\u0000"+
		"\u0000\u0ac0\u0ac1\u0005\u0146\u0000\u0000\u0ac1\u0ac2\u0005\u0007\u0000"+
		"\u0000\u0ac2\u0ac3\u0005\u008f\u0000\u0000\u0ac3\u0ac5\u0005}\u0000\u0000"+
		"\u0ac4\u0ac6\u00036\u001b\u0000\u0ac5\u0ac4\u0001\u0000\u0000\u0000\u0ac5"+
		"\u0ac6\u0001\u0000\u0000\u0000\u0ac6\u0ac7\u0001\u0000\u0000\u0000\u0ac7"+
		"\u0aca\u0005~\u0000\u0000\u0ac8\u0ac9\u0005\u0088\u0000\u0000\u0ac9\u0acb"+
		"\u0003:\u001d\u0000\u0aca\u0ac8\u0001\u0000\u0000\u0000\u0aca\u0acb\u0001"+
		"\u0000\u0000\u0000\u0acb\u0acc\u0001\u0000\u0000\u0000\u0acc\u0acd\u0005"+
		"r\u0000\u0000\u0acd\u0ace\u0003p8\u0000\u0ace\u01dd\u0001\u0000\u0000"+
		"\u0000\u0acf\u0ad0\u0005\u0148\u0000\u0000\u0ad0\u0ad1\u0005\u008f\u0000"+
		"\u0000\u0ad1\u0ad3\u0005}\u0000\u0000\u0ad2\u0ad4\u0003\u01e0\u00f0\u0000"+
		"\u0ad3\u0ad2\u0001\u0000\u0000\u0000\u0ad3\u0ad4\u0001\u0000\u0000\u0000"+
		"\u0ad4\u0ad5\u0001\u0000\u0000\u0000\u0ad5\u0ad6\u0005~\u0000\u0000\u0ad6"+
		"\u0ad7\u0005r\u0000\u0000\u0ad7\u0ad8\u0003\u01e2\u00f1\u0000\u0ad8\u01df"+
		"\u0001\u0000\u0000\u0000\u0ad9\u0ade\u0005\u008f\u0000\u0000\u0ada\u0adb"+
		"\u0005\u0083\u0000\u0000\u0adb\u0add\u0005\u008f\u0000\u0000\u0adc\u0ada"+
		"\u0001\u0000\u0000\u0000\u0add\u0ae0\u0001\u0000\u0000\u0000\u0ade\u0adc"+
		"\u0001\u0000\u0000\u0000\u0ade\u0adf\u0001\u0000\u0000\u0000\u0adf\u01e1"+
		"\u0001\u0000\u0000\u0000\u0ae0\u0ade\u0001\u0000\u0000\u0000\u0ae1\u0aeb"+
		"\u0003p8\u0000\u0ae2\u0ae6\u0005\u007f\u0000\u0000\u0ae3\u0ae5\u0003T"+
		"*\u0000\u0ae4\u0ae3\u0001\u0000\u0000\u0000\u0ae5\u0ae8\u0001\u0000\u0000"+
		"\u0000\u0ae6\u0ae4\u0001\u0000\u0000\u0000\u0ae6\u0ae7\u0001\u0000\u0000"+
		"\u0000\u0ae7\u0ae9\u0001\u0000\u0000\u0000\u0ae8\u0ae6\u0001\u0000\u0000"+
		"\u0000\u0ae9\u0aeb\u0005\u0080\u0000\u0000\u0aea\u0ae1\u0001\u0000\u0000"+
		"\u0000\u0aea\u0ae2\u0001\u0000\u0000\u0000\u0aeb\u01e3\u0001\u0000\u0000"+
		"\u0000\u0aec\u0aed\u0005\u008f\u0000\u0000\u0aed\u0aee\u0005e\u0000\u0000"+
		"\u0aee\u0af0\u0005}\u0000\u0000\u0aef\u0af1\u0003~?\u0000\u0af0\u0aef"+
		"\u0001\u0000\u0000\u0000\u0af0\u0af1\u0001\u0000\u0000\u0000\u0af1\u0af2"+
		"\u0001\u0000\u0000\u0000\u0af2\u0af3\u0005~\u0000\u0000\u0af3\u01e5\u0001"+
		"\u0000\u0000\u0000\u0af4\u0af5\u0005\u0149\u0000\u0000\u0af5\u0af6\u0005"+
		"\u008f\u0000\u0000\u0af6\u0afa\u0005\u007f\u0000\u0000\u0af7\u0af9\u0003"+
		"\u01e8\u00f4\u0000\u0af8\u0af7\u0001\u0000\u0000\u0000\u0af9\u0afc\u0001"+
		"\u0000\u0000\u0000\u0afa\u0af8\u0001\u0000\u0000\u0000\u0afa\u0afb\u0001"+
		"\u0000\u0000\u0000\u0afb\u0afd\u0001\u0000\u0000\u0000\u0afc\u0afa\u0001"+
		"\u0000\u0000\u0000\u0afd\u0afe\u0005\u0080\u0000\u0000\u0afe\u01e7\u0001"+
		"\u0000\u0000\u0000\u0aff\u0b00\u0005}\u0000\u0000\u0b00\u0b01\u0003\u00bc"+
		"^\u0000\u0b01\u0b02\u0005~\u0000\u0000\u0b02\u0b03\u0005\u0088\u0000\u0000"+
		"\u0b03\u0b04\u0005}\u0000\u0000\u0b04\u0b05\u0003\u01ea\u00f5\u0000\u0b05"+
		"\u0b06\u0005~\u0000\u0000\u0b06\u01e9\u0001\u0000\u0000\u0000\u0b07\u0b08"+
		"\u0003p8\u0000\u0b08\u01eb\u0001\u0000\u0000\u0000\u0b09\u0b0a\u0005\u014a"+
		"\u0000\u0000\u0b0a\u0b0b\u0005\u008f\u0000\u0000\u0b0b\u0b0c\u0005r\u0000"+
		"\u0000\u0b0c\u0b0d\u0003\u01ee\u00f7\u0000\u0b0d\u01ed\u0001\u0000\u0000"+
		"\u0000\u0b0e\u0b0f\u0003p8\u0000\u0b0f\u01ef\u0001\u0000\u0000\u0000\u0b10"+
		"\u0b11\u0005\u014b\u0000\u0000\u0b11\u0b12\u0005\u0148\u0000\u0000\u0b12"+
		"\u0b13\u0005\u0007\u0000\u0000\u0b13\u0b14\u0005\u008f\u0000\u0000\u0b14"+
		"\u0b15\u0005}\u0000\u0000\u0b15\u0b16\u00036\u001b\u0000\u0b16\u0b17\u0005"+
		"~\u0000\u0000\u0b17\u0b18\u0005\u0088\u0000\u0000\u0b18\u0b19\u0003:\u001d"+
		"\u0000\u0b19\u01f1\u0001\u0000\u0000\u0000\u0b1a\u0b1b\u0005\u014c\u0000"+
		"\u0000\u0b1b\u0b1c\u0005}\u0000\u0000\u0b1c\u0b1d\u0003\u01f4\u00fa\u0000"+
		"\u0b1d\u0b1e\u0005~\u0000\u0000\u0b1e\u01f3\u0001\u0000\u0000\u0000\u0b1f"+
		"\u0b24\u0005\u008f\u0000\u0000\u0b20\u0b21\u0005\u0083\u0000\u0000\u0b21"+
		"\u0b23\u0005\u008f\u0000\u0000\u0b22\u0b20\u0001\u0000\u0000\u0000\u0b23"+
		"\u0b26\u0001\u0000\u0000\u0000\u0b24\u0b22\u0001\u0000\u0000\u0000\u0b24"+
		"\u0b25\u0001\u0000\u0000\u0000\u0b25\u01f5\u0001\u0000\u0000\u0000\u0b26"+
		"\u0b24\u0001\u0000\u0000\u0000\u0b27\u0b28\u0005\u014d\u0000\u0000\u0b28"+
		"\u0b29\u0005}\u0000\u0000\u0b29\u0b2a\u0003\u01f8\u00fc\u0000\u0b2a\u0b2b"+
		"\u0005~\u0000\u0000\u0b2b\u01f7\u0001\u0000\u0000\u0000\u0b2c\u0b2d\u0005"+
		"\u008f\u0000\u0000\u0b2d\u01f9\u0001\u0000\u0000\u0000\u0b2e\u0b2f\u0005"+
		"\u014e\u0000\u0000\u0b2f\u0b30\u0005}\u0000\u0000\u0b30\u0b31\u0003\u01fc"+
		"\u00fe\u0000\u0b31\u0b32\u0005~\u0000\u0000\u0b32\u01fb\u0001\u0000\u0000"+
		"\u0000\u0b33\u0b34\u0005\u008f\u0000\u0000\u0b34\u01fd\u0001\u0000\u0000"+
		"\u0000\u0b35\u0b36\u0005\u014f\u0000\u0000\u0b36\u0b37\u0005}\u0000\u0000"+
		"\u0b37\u0b38\u0003\u0200\u0100\u0000\u0b38\u0b39\u0005~\u0000\u0000\u0b39"+
		"\u01ff\u0001\u0000\u0000\u0000\u0b3a\u0b3b\u0005\u008f\u0000\u0000\u0b3b"+
		"\u0201\u0001\u0000\u0000\u0000\u0b3c\u0b3d\u0005\u0150\u0000\u0000\u0b3d"+
		"\u0b3e\u0005}\u0000\u0000\u0b3e\u0b3f\u0003\u0204\u0102\u0000\u0b3f\u0b40"+
		"\u0005~\u0000\u0000\u0b40\u0203\u0001\u0000\u0000\u0000\u0b41\u0b42\u0007"+
		"\u0011\u0000\u0000\u0b42\u0205\u0001\u0000\u0000\u0000\u0b43\u0b44\u0005"+
		"\u0154\u0000\u0000\u0b44\u0b45\u0005n\u0000\u0000\u0b45\u0b46\u0003\u0012"+
		"\t\u0000\u0b46\u0b47\u0005o\u0000\u0000\u0b47\u0b48\u0005}\u0000\u0000"+
		"\u0b48\u0b49\u0003\u0208\u0104\u0000\u0b49\u0b4a\u0005~\u0000\u0000\u0b4a"+
		"\u0207\u0001\u0000\u0000\u0000\u0b4b\u0b50\u0003p8\u0000\u0b4c\u0b4d\u0005"+
		"\u0083\u0000\u0000\u0b4d\u0b4f\u0003p8\u0000\u0b4e\u0b4c\u0001\u0000\u0000"+
		"\u0000\u0b4f\u0b52\u0001\u0000\u0000\u0000\u0b50\u0b4e\u0001\u0000\u0000"+
		"\u0000\u0b50\u0b51\u0001\u0000\u0000\u0000\u0b51\u0209\u0001\u0000\u0000"+
		"\u0000\u0b52\u0b50\u0001\u0000\u0000\u0000\u0b53\u0b54\u0005\u0156\u0000"+
		"\u0000\u0b54\u0b55\u0005n\u0000\u0000\u0b55\u0b56\u0003*\u0015\u0000\u0b56"+
		"\u0b57\u0005o\u0000\u0000\u0b57\u0b58\u0005\u0010\u0000\u0000\u0b58\u0b59"+
		"\u0003\u0012\t\u0000\u0b59\u020b\u0001\u0000\u0000\u0000\u0b5a\u0b5b\u0005"+
		"\u0157\u0000\u0000\u0b5b\u0b5c\u0005n\u0000\u0000\u0b5c\u0b5d\u0003\u0012"+
		"\t\u0000\u0b5d\u0b5e\u0005o\u0000\u0000\u0b5e\u020d\u0001\u0000\u0000"+
		"\u0000\u0b5f\u0b60\u0005\u0158\u0000\u0000\u0b60\u0b61\u0005}\u0000\u0000"+
		"\u0b61\u0b62\u0003p8\u0000\u0b62\u0b63\u0005~\u0000\u0000\u0b63\u020f"+
		"\u0001\u0000\u0000\u0000\u0b64\u0b65\u0005\u000b\u0000\u0000\u0b65\u0b69"+
		"\u0005\u007f\u0000\u0000\u0b66\u0b68\u0003\u0212\u0109\u0000\u0b67\u0b66"+
		"\u0001\u0000\u0000\u0000\u0b68\u0b6b\u0001\u0000\u0000\u0000\u0b69\u0b67"+
		"\u0001\u0000\u0000\u0000\u0b69\u0b6a\u0001\u0000\u0000\u0000\u0b6a\u0b6c"+
		"\u0001\u0000\u0000\u0000\u0b6b\u0b69\u0001\u0000\u0000\u0000\u0b6c\u0b6d"+
		"\u0005\u0080\u0000\u0000\u0b6d\u0211\u0001\u0000\u0000\u0000\u0b6e\u0b6f"+
		"\u0007\u0012\u0000\u0000\u0b6f\u0213\u0001\u0000\u0000\u0000\u0b70\u0b71"+
		"\u0005\u0164\u0000\u0000\u0b71\u0b72\u0005}\u0000\u0000\u0b72\u0b73\u0003"+
		"\u0216\u010b\u0000\u0b73\u0b74\u0005~\u0000\u0000\u0b74\u0b78\u0005\u007f"+
		"\u0000\u0000\u0b75\u0b77\u0003\u0002\u0001\u0000\u0b76\u0b75\u0001\u0000"+
		"\u0000\u0000\u0b77\u0b7a\u0001\u0000\u0000\u0000\u0b78\u0b76\u0001\u0000"+
		"\u0000\u0000\u0b78\u0b79\u0001\u0000\u0000\u0000\u0b79\u0b7b\u0001\u0000"+
		"\u0000\u0000\u0b7a\u0b78\u0001\u0000\u0000\u0000\u0b7b\u0b7c\u0005\u0080"+
		"\u0000\u0000\u0b7c\u0215\u0001\u0000\u0000\u0000\u0b7d\u0b7e\u0003p8\u0000"+
		"\u0b7e\u0217\u0001\u0000\u0000\u0000\u0b7f\u0b80\u0005\u0165\u0000\u0000"+
		"\u0b80\u0b81\u0005}\u0000\u0000\u0b81\u0b82\u0003\u021a\u010d\u0000\u0b82"+
		"\u0b83\u0005~\u0000\u0000\u0b83\u0219\u0001\u0000\u0000\u0000\u0b84\u0b85"+
		"\u0005\u008f\u0000\u0000\u0b85\u021b\u0001\u0000\u0000\u0000\u0b86\u0b87"+
		"\u0005\u0166\u0000\u0000\u0b87\u0b88\u0005}\u0000\u0000\u0b88\u0b89\u0003"+
		"p8\u0000\u0b89\u0b8a\u0005\u0083\u0000\u0000\u0b8a\u0b8b\u0003\u021e\u010f"+
		"\u0000\u0b8b\u0b8c\u0005~\u0000\u0000\u0b8c\u021d\u0001\u0000\u0000\u0000"+
		"\u0b8d\u0b8e\u0005\u008f\u0000\u0000\u0b8e\u021f\u0001\u0000\u0000\u0000"+
		"\u0b8f\u0b90\u0005\u0167\u0000\u0000\u0b90\u0b91\u0005}\u0000\u0000\u0b91"+
		"\u0b92\u0003p8\u0000\u0b92\u0b93\u0005\u0083\u0000\u0000\u0b93\u0b94\u0003"+
		"\u0222\u0111\u0000\u0b94\u0b95\u0005~\u0000\u0000\u0b95\u0221\u0001\u0000"+
		"\u0000\u0000\u0b96\u0b97\u0003p8\u0000\u0b97\u0223\u0001\u0000\u0000\u0000"+
		"\u0b98\u0b99\u0005\u0169\u0000\u0000\u0b99\u0b9a\u0005}\u0000\u0000\u0b9a"+
		"\u0b9f\u0003p8\u0000\u0b9b\u0b9c\u0005\u0087\u0000\u0000\u0b9c\u0b9e\u0003"+
		"\u0226\u0113\u0000\u0b9d\u0b9b\u0001\u0000\u0000\u0000\u0b9e\u0ba1\u0001"+
		"\u0000\u0000\u0000\u0b9f\u0b9d\u0001\u0000\u0000\u0000\u0b9f\u0ba0\u0001"+
		"\u0000\u0000\u0000\u0ba0\u0ba2\u0001\u0000\u0000\u0000\u0ba1\u0b9f\u0001"+
		"\u0000\u0000\u0000\u0ba2\u0ba3\u0005~\u0000\u0000\u0ba3\u0225\u0001\u0000"+
		"\u0000\u0000\u0ba4\u0ba5\u0005\u008f\u0000\u0000\u0ba5\u0ba7\u0005}\u0000"+
		"\u0000\u0ba6\u0ba8\u0003~?\u0000\u0ba7\u0ba6\u0001\u0000\u0000\u0000\u0ba7"+
		"\u0ba8\u0001\u0000\u0000\u0000\u0ba8\u0ba9\u0001\u0000\u0000\u0000\u0ba9"+
		"\u0baa\u0005~\u0000\u0000\u0baa\u0227\u0001\u0000\u0000\u0000\u0bab\u0bac"+
		"\u0005\u016a\u0000\u0000\u0bac\u0bad\u0005}\u0000\u0000\u0bad\u0bb2\u0003"+
		"p8\u0000\u0bae\u0baf\u0005\u0101\u0000\u0000\u0baf\u0bb1\u0003\u022a\u0115"+
		"\u0000\u0bb0\u0bae\u0001\u0000\u0000\u0000\u0bb1\u0bb4\u0001\u0000\u0000"+
		"\u0000\u0bb2\u0bb0\u0001\u0000\u0000\u0000\u0bb2\u0bb3\u0001\u0000\u0000"+
		"\u0000\u0bb3\u0bb5\u0001\u0000\u0000\u0000\u0bb4\u0bb2\u0001\u0000\u0000"+
		"\u0000\u0bb5\u0bb6\u0005~\u0000\u0000\u0bb6\u0229\u0001\u0000\u0000\u0000"+
		"\u0bb7\u0bb8\u0003p8\u0000\u0bb8\u022b\u0001\u0000\u0000\u0000\u0bb9\u0bba"+
		"\u0005\u016b\u0000\u0000\u0bba\u0bbb\u0005}\u0000\u0000\u0bbb\u0bbc\u0003"+
		"p8\u0000\u0bbc\u0bbd\u0005\u0083\u0000\u0000\u0bbd\u0bbe\u0003p8\u0000"+
		"\u0bbe\u0bbf\u0005~\u0000\u0000\u0bbf\u022d\u0001\u0000\u0000\u0000\u0bc0"+
		"\u0bc1\u0005\u016c\u0000\u0000\u0bc1\u0bc2\u0005}\u0000\u0000\u0bc2\u0bc3"+
		"\u0003p8\u0000\u0bc3\u0bc4\u0005\u0083\u0000\u0000\u0bc4\u0bc5\u0003\u0230"+
		"\u0118\u0000\u0bc5\u0bc6\u0005~\u0000\u0000\u0bc6\u022f\u0001\u0000\u0000"+
		"\u0000\u0bc7\u0bcc\u0003p8\u0000\u0bc8\u0bc9\u0005\u0083\u0000\u0000\u0bc9"+
		"\u0bcb\u0003p8\u0000\u0bca\u0bc8\u0001\u0000\u0000\u0000\u0bcb\u0bce\u0001"+
		"\u0000\u0000\u0000\u0bcc\u0bca\u0001\u0000\u0000\u0000\u0bcc\u0bcd\u0001"+
		"\u0000\u0000\u0000\u0bcd\u0231\u0001\u0000\u0000\u0000\u0bce\u0bcc\u0001"+
		"\u0000\u0000\u0000\u0bcf\u0bd0\u0005\u016d\u0000\u0000\u0bd0\u0bd1\u0005"+
		"}\u0000\u0000\u0bd1\u0bd2\u0003\u0234\u011a\u0000\u0bd2\u0bd3\u0005~\u0000"+
		"\u0000\u0bd3\u0233\u0001\u0000\u0000\u0000\u0bd4\u0bd5\u0003p8\u0000\u0bd5"+
		"\u0235\u0001\u0000\u0000\u0000\u0bd6\u0bd7\u0005\u016e\u0000\u0000\u0bd7"+
		"\u0bd8\u0005}\u0000\u0000\u0bd8\u0bd9\u0003p8\u0000\u0bd9\u0bda\u0005"+
		"~\u0000\u0000\u0bda\u0237\u0001\u0000\u0000\u0000\u0bdb\u0bdc\u0005\u016f"+
		"\u0000\u0000\u0bdc\u0bdd\u0005}\u0000\u0000\u0bdd\u0bde\u0003p8\u0000"+
		"\u0bde\u0bdf\u0005~\u0000\u0000\u0bdf\u0239\u0001\u0000\u0000\u0000\u0be0"+
		"\u0be1\u0005\u0170\u0000\u0000\u0be1\u0be2\u0005}\u0000\u0000\u0be2\u0be3"+
		"\u0003p8\u0000\u0be3\u0be4\u0005~\u0000\u0000\u0be4\u023b\u0001\u0000"+
		"\u0000\u0000\u0be5\u0be6\u0005\u0171\u0000\u0000\u0be6\u0be7\u0005}\u0000"+
		"\u0000\u0be7\u0be8\u0003p8\u0000\u0be8\u0be9\u0005~\u0000\u0000\u0be9"+
		"\u023d\u0001\u0000\u0000\u0000\u0bea\u0beb\u0005\u0172\u0000\u0000\u0beb"+
		"\u0bec\u0005}\u0000\u0000\u0bec\u0bed\u0003p8\u0000\u0bed\u0bee\u0005"+
		"~\u0000\u0000\u0bee\u023f\u0001\u0000\u0000\u0000\u0bef\u0bf0\u0005\u0173"+
		"\u0000\u0000\u0bf0\u0bf1\u0005}\u0000\u0000\u0bf1\u0bf2\u0003p8\u0000"+
		"\u0bf2\u0bf3\u0005~\u0000\u0000\u0bf3\u0241\u0001\u0000\u0000\u0000\u0bf4"+
		"\u0bf5\u0005\u0174\u0000\u0000\u0bf5\u0bf6\u0005}\u0000\u0000\u0bf6\u0bf7"+
		"\u0003p8\u0000\u0bf7\u0bf8\u0005~\u0000\u0000\u0bf8\u0243\u0001\u0000"+
		"\u0000\u0000\u0bf9\u0bfa\u0005\u0175\u0000\u0000\u0bfa\u0bfb\u0005}\u0000"+
		"\u0000\u0bfb\u0bfc\u0003\u0246\u0123\u0000\u0bfc\u0bfd\u0005~\u0000\u0000"+
		"\u0bfd\u0c01\u0005\u007f\u0000\u0000\u0bfe\u0c00\u0003T*\u0000\u0bff\u0bfe"+
		"\u0001\u0000\u0000\u0000\u0c00\u0c03\u0001\u0000\u0000\u0000\u0c01\u0bff"+
		"\u0001\u0000\u0000\u0000\u0c01\u0c02\u0001\u0000\u0000\u0000\u0c02\u0c04"+
		"\u0001\u0000\u0000\u0000\u0c03\u0c01\u0001\u0000\u0000\u0000\u0c04\u0c05"+
		"\u0005\u0080\u0000\u0000\u0c05\u0245\u0001\u0000\u0000\u0000\u0c06\u0c07"+
		"\u0003p8\u0000\u0c07\u0247\u0001\u0000\u0000\u0000\u0c08\u0c09\u0005\u0176"+
		"\u0000\u0000\u0c09\u0c0a\u0005}\u0000\u0000\u0c0a\u0c0b\u0003p8\u0000"+
		"\u0c0b\u0c0c\u0005~\u0000\u0000\u0c0c\u0249\u0001\u0000\u0000\u0000\u0c0d"+
		"\u0c0e\u0005\u0177\u0000\u0000\u0c0e\u0c0f\u0005}\u0000\u0000\u0c0f\u0c10"+
		"\u0003p8\u0000\u0c10\u0c11\u0005~\u0000\u0000\u0c11\u024b\u0001\u0000"+
		"\u0000\u0000\u0c12\u0c13\u0005\u0178\u0000\u0000\u0c13\u0c14\u0005}\u0000"+
		"\u0000\u0c14\u0c15\u0003p8\u0000\u0c15\u0c16\u0005~\u0000\u0000\u0c16"+
		"\u024d\u0001\u0000\u0000\u0000\u0c17\u0c18\u0005\u0179\u0000\u0000\u0c18"+
		"\u0c19\u0005}\u0000\u0000\u0c19\u0c1a\u0003p8\u0000\u0c1a\u0c1b\u0005"+
		"~\u0000\u0000\u0c1b\u024f\u0001\u0000\u0000\u0000\u0c1c\u0c1d\u0005\u017a"+
		"\u0000\u0000\u0c1d\u0c1e\u0005}\u0000\u0000\u0c1e\u0c1f\u0003p8\u0000"+
		"\u0c1f\u0c20\u0005~\u0000\u0000\u0c20\u0251\u0001\u0000\u0000\u0000\u0c21"+
		"\u0c22\u0005\u017b\u0000\u0000\u0c22\u0c23\u0005}\u0000\u0000\u0c23\u0c24"+
		"\u0003p8\u0000\u0c24\u0c25\u0005~\u0000\u0000\u0c25\u0253\u0001\u0000"+
		"\u0000\u0000\u0c26\u0c27\u0005\u017c\u0000\u0000\u0c27\u0c28\u0005}\u0000"+
		"\u0000\u0c28\u0c29\u0003p8\u0000\u0c29\u0c2a\u0005~\u0000\u0000\u0c2a"+
		"\u0255\u0001\u0000\u0000\u0000\u0c2b\u0c2c\u0005\u017d\u0000\u0000\u0c2c"+
		"\u0c2d\u0005}\u0000\u0000\u0c2d\u0c2e\u0003p8\u0000\u0c2e\u0c2f\u0005"+
		"~\u0000\u0000\u0c2f\u0257\u0001\u0000\u0000\u0000\u0c30\u0c31\u0005\u017e"+
		"\u0000\u0000\u0c31\u0c32\u0005}\u0000\u0000\u0c32\u0c33\u0003p8\u0000"+
		"\u0c33\u0c34\u0005~\u0000\u0000\u0c34\u0259\u0001\u0000\u0000\u0000\u0c35"+
		"\u0c36\u0005\u017f\u0000\u0000\u0c36\u0c37\u0005}\u0000\u0000\u0c37\u0c38"+
		"\u0003p8\u0000\u0c38\u0c39\u0005~\u0000\u0000\u0c39\u025b\u0001\u0000"+
		"\u0000\u0000\u0c3a\u0c3b\u0005\u0180\u0000\u0000\u0c3b\u0c3c\u0005}\u0000"+
		"\u0000\u0c3c\u0c3d\u0003p8\u0000\u0c3d\u0c3e\u0005~\u0000\u0000\u0c3e"+
		"\u025d\u0001\u0000\u0000\u0000\u0c3f\u0c40\u0005\u0181\u0000\u0000\u0c40"+
		"\u0c41\u0005}\u0000\u0000\u0c41\u0c42\u0003p8\u0000\u0c42\u0c43\u0005"+
		"~\u0000\u0000\u0c43\u025f\u0001\u0000\u0000\u0000\u0c44\u0c45\u0005\u0182"+
		"\u0000\u0000\u0c45\u0c46\u0005}\u0000\u0000\u0c46\u0c47\u0003\u0262\u0131"+
		"\u0000\u0c47\u0c48\u0005~\u0000\u0000\u0c48\u0261\u0001\u0000\u0000\u0000"+
		"\u0c49\u0c4a\u0007\u0013\u0000\u0000\u0c4a\u0263\u0001\u0000\u0000\u0000"+
		"\u0c4b\u0c4c\u0005\u0185\u0000\u0000\u0c4c\u0c4d\u0005}\u0000\u0000\u0c4d"+
		"\u0c4e\u0003p8\u0000\u0c4e\u0c4f\u0005~\u0000\u0000\u0c4f\u0265\u0001"+
		"\u0000\u0000\u0000\u0c50\u0c51\u0005\u0186\u0000\u0000\u0c51\u0c52\u0005"+
		"}\u0000\u0000\u0c52\u0c53\u0003p8\u0000\u0c53\u0c54\u0005~\u0000\u0000"+
		"\u0c54\u0267\u0001\u0000\u0000\u0000\u00dc\u026b\u027c\u0284\u028d\u0296"+
		"\u02ac\u02b2\u02b8\u02c1\u02c6\u02cd\u02d1\u02d6\u02d9\u02df\u02e4\u02f1"+
		"\u031f\u032d\u0331\u0335\u033d\u0340\u0358\u035d\u0369\u0372\u037e\u0381"+
		"\u0386\u038e\u0393\u039b\u03a5\u03ad\u03b4\u03c1\u03c4\u03c7\u03cc\u03d0"+
		"\u03d3\u03d6\u03dc\u03e1\u03e8\u03ec\u03f5\u03f8\u03fe\u040a\u040d\u0410"+
		"\u0415\u0418\u041e\u0426\u042a\u042e\u0436\u043e\u0443\u0446\u0456\u046d"+
		"\u0471\u0476\u047a\u0488\u048e\u049b\u04a6\u04ad\u04b5\u04b9\u04c1\u04d0"+
		"\u04dd\u04e7\u04fa\u0508\u0510\u051d\u0528\u052f\u0538\u0549\u0553\u0556"+
		"\u0560\u0563\u056e\u0571\u057e\u0581\u0587\u058b\u059e\u05a2\u05ac\u05b7"+
		"\u05be\u05c6\u05ca\u05d2\u05d8\u05dd\u05e3\u05ec\u05fd\u0642\u0652\u065a"+
		"\u0664\u066e\u0677\u067a\u0680\u0689\u068c\u0694\u0697\u06a1\u06a4\u06ac"+
		"\u06b3\u06d2\u06db\u06e6\u06eb\u06f1\u06f9\u0700\u0704\u0720\u0723\u073c"+
		"\u074d\u076d\u077b\u0794\u0798\u079e\u07b1\u07be\u07c2\u07ca\u07ce\u07d3"+
		"\u07d6\u07dc\u07e1\u07f8\u080c\u0818\u082b\u0833\u0844\u084e\u0853\u085e"+
		"\u0865\u0870\u087b\u0886\u088b\u0894\u089e\u08a7\u08ac\u08b2\u08b8\u08c2"+
		"\u08cc\u08d1\u08d9\u08e9\u08f1\u08fd\u0907\u0913\u091d\u0924\u0935\u0941"+
		"\u0952\u095a\u096c\u0974\u097d\u0981\u0987\u0992\u0995\u09a0\u09a3\u09b7"+
		"\u09cc\u09d5\u09e0\u09f9\u0a2f\u0a3e\u0ac5\u0aca\u0ad3\u0ade\u0ae6\u0aea"+
		"\u0af0\u0afa\u0b24\u0b50\u0b69\u0b78\u0b9f\u0ba7\u0bb2\u0bcc\u0c01";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}