// Generated from T4Parser.g4 by ANTLR 4.13.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link T4Parser}.
 */
public interface T4ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link T4Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(T4Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(T4Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(T4Parser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(T4Parser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#module_declaration}.
	 * @param ctx the parse tree
	 */
	void enterModule_declaration(T4Parser.Module_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#module_declaration}.
	 * @param ctx the parse tree
	 */
	void exitModule_declaration(T4Parser.Module_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#import_declaration}.
	 * @param ctx the parse tree
	 */
	void enterImport_declaration(T4Parser.Import_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#import_declaration}.
	 * @param ctx the parse tree
	 */
	void exitImport_declaration(T4Parser.Import_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#config_block}.
	 * @param ctx the parse tree
	 */
	void enterConfig_block(T4Parser.Config_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#config_block}.
	 * @param ctx the parse tree
	 */
	void exitConfig_block(T4Parser.Config_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#config_item}.
	 * @param ctx the parse tree
	 */
	void enterConfig_item(T4Parser.Config_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#config_item}.
	 * @param ctx the parse tree
	 */
	void exitConfig_item(T4Parser.Config_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#extern_block}.
	 * @param ctx the parse tree
	 */
	void enterExtern_block(T4Parser.Extern_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#extern_block}.
	 * @param ctx the parse tree
	 */
	void exitExtern_block(T4Parser.Extern_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#extern_function}.
	 * @param ctx the parse tree
	 */
	void enterExtern_function(T4Parser.Extern_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#extern_function}.
	 * @param ctx the parse tree
	 */
	void exitExtern_function(T4Parser.Extern_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declaration(T4Parser.Function_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declaration(T4Parser.Function_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#type_}.
	 * @param ctx the parse tree
	 */
	void enterType_(T4Parser.Type_Context ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#type_}.
	 * @param ctx the parse tree
	 */
	void exitType_(T4Parser.Type_Context ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#basic_type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(T4Parser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#basic_type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(T4Parser.Basic_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#cryptographic_type}.
	 * @param ctx the parse tree
	 */
	void enterCryptographic_type(T4Parser.Cryptographic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#cryptographic_type}.
	 * @param ctx the parse tree
	 */
	void exitCryptographic_type(T4Parser.Cryptographic_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#algorithm_type}.
	 * @param ctx the parse tree
	 */
	void enterAlgorithm_type(T4Parser.Algorithm_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#algorithm_type}.
	 * @param ctx the parse tree
	 */
	void exitAlgorithm_type(T4Parser.Algorithm_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#type_path}.
	 * @param ctx the parse tree
	 */
	void enterType_path(T4Parser.Type_pathContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#type_path}.
	 * @param ctx the parse tree
	 */
	void exitType_path(T4Parser.Type_pathContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#tuple_type}.
	 * @param ctx the parse tree
	 */
	void enterTuple_type(T4Parser.Tuple_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#tuple_type}.
	 * @param ctx the parse tree
	 */
	void exitTuple_type(T4Parser.Tuple_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#array_type}.
	 * @param ctx the parse tree
	 */
	void enterArray_type(T4Parser.Array_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#array_type}.
	 * @param ctx the parse tree
	 */
	void exitArray_type(T4Parser.Array_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#slice_type}.
	 * @param ctx the parse tree
	 */
	void enterSlice_type(T4Parser.Slice_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#slice_type}.
	 * @param ctx the parse tree
	 */
	void exitSlice_type(T4Parser.Slice_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#reference_type}.
	 * @param ctx the parse tree
	 */
	void enterReference_type(T4Parser.Reference_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#reference_type}.
	 * @param ctx the parse tree
	 */
	void exitReference_type(T4Parser.Reference_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#mutable_reference_type}.
	 * @param ctx the parse tree
	 */
	void enterMutable_reference_type(T4Parser.Mutable_reference_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#mutable_reference_type}.
	 * @param ctx the parse tree
	 */
	void exitMutable_reference_type(T4Parser.Mutable_reference_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#function_type}.
	 * @param ctx the parse tree
	 */
	void enterFunction_type(T4Parser.Function_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#function_type}.
	 * @param ctx the parse tree
	 */
	void exitFunction_type(T4Parser.Function_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generic_type}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_type(T4Parser.Generic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generic_type}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_type(T4Parser.Generic_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#type_args}.
	 * @param ctx the parse tree
	 */
	void enterType_args(T4Parser.Type_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#type_args}.
	 * @param ctx the parse tree
	 */
	void exitType_args(T4Parser.Type_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generic_params}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_params(T4Parser.Generic_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generic_params}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_params(T4Parser.Generic_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generic_param}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_param(T4Parser.Generic_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generic_param}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_param(T4Parser.Generic_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#bound}.
	 * @param ctx the parse tree
	 */
	void enterBound(T4Parser.BoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#bound}.
	 * @param ctx the parse tree
	 */
	void exitBound(T4Parser.BoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(T4Parser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(T4Parser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#where_item}.
	 * @param ctx the parse tree
	 */
	void enterWhere_item(T4Parser.Where_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#where_item}.
	 * @param ctx the parse tree
	 */
	void exitWhere_item(T4Parser.Where_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(T4Parser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(T4Parser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(T4Parser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(T4Parser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(T4Parser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(T4Parser.Return_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void enterStruct_declaration(T4Parser.Struct_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void exitStruct_declaration(T4Parser.Struct_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#struct_fields}.
	 * @param ctx the parse tree
	 */
	void enterStruct_fields(T4Parser.Struct_fieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#struct_fields}.
	 * @param ctx the parse tree
	 */
	void exitStruct_fields(T4Parser.Struct_fieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#struct_field}.
	 * @param ctx the parse tree
	 */
	void enterStruct_field(T4Parser.Struct_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#struct_field}.
	 * @param ctx the parse tree
	 */
	void exitStruct_field(T4Parser.Struct_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#enum_declaration}.
	 * @param ctx the parse tree
	 */
	void enterEnum_declaration(T4Parser.Enum_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#enum_declaration}.
	 * @param ctx the parse tree
	 */
	void exitEnum_declaration(T4Parser.Enum_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#enum_variant}.
	 * @param ctx the parse tree
	 */
	void enterEnum_variant(T4Parser.Enum_variantContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#enum_variant}.
	 * @param ctx the parse tree
	 */
	void exitEnum_variant(T4Parser.Enum_variantContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#trait_declaration}.
	 * @param ctx the parse tree
	 */
	void enterTrait_declaration(T4Parser.Trait_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#trait_declaration}.
	 * @param ctx the parse tree
	 */
	void exitTrait_declaration(T4Parser.Trait_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#trait_item}.
	 * @param ctx the parse tree
	 */
	void enterTrait_item(T4Parser.Trait_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#trait_item}.
	 * @param ctx the parse tree
	 */
	void exitTrait_item(T4Parser.Trait_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#impl_block}.
	 * @param ctx the parse tree
	 */
	void enterImpl_block(T4Parser.Impl_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#impl_block}.
	 * @param ctx the parse tree
	 */
	void exitImpl_block(T4Parser.Impl_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#impl_item}.
	 * @param ctx the parse tree
	 */
	void enterImpl_item(T4Parser.Impl_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#impl_item}.
	 * @param ctx the parse tree
	 */
	void exitImpl_item(T4Parser.Impl_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#type_alias}.
	 * @param ctx the parse tree
	 */
	void enterType_alias(T4Parser.Type_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#type_alias}.
	 * @param ctx the parse tree
	 */
	void exitType_alias(T4Parser.Type_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#const_declaration}.
	 * @param ctx the parse tree
	 */
	void enterConst_declaration(T4Parser.Const_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#const_declaration}.
	 * @param ctx the parse tree
	 */
	void exitConst_declaration(T4Parser.Const_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#static_declaration}.
	 * @param ctx the parse tree
	 */
	void enterStatic_declaration(T4Parser.Static_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#static_declaration}.
	 * @param ctx the parse tree
	 */
	void exitStatic_declaration(T4Parser.Static_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(T4Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(T4Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#let_statement}.
	 * @param ctx the parse tree
	 */
	void enterLet_statement(T4Parser.Let_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#let_statement}.
	 * @param ctx the parse tree
	 */
	void exitLet_statement(T4Parser.Let_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(T4Parser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(T4Parser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(T4Parser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(T4Parser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(T4Parser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(T4Parser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#break_statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak_statement(T4Parser.Break_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#break_statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak_statement(T4Parser.Break_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#continue_statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue_statement(T4Parser.Continue_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#continue_statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue_statement(T4Parser.Continue_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(T4Parser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(T4Parser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#match_statement}.
	 * @param ctx the parse tree
	 */
	void enterMatch_statement(T4Parser.Match_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#match_statement}.
	 * @param ctx the parse tree
	 */
	void exitMatch_statement(T4Parser.Match_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#match_arm}.
	 * @param ctx the parse tree
	 */
	void enterMatch_arm(T4Parser.Match_armContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#match_arm}.
	 * @param ctx the parse tree
	 */
	void exitMatch_arm(T4Parser.Match_armContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(T4Parser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(T4Parser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(T4Parser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(T4Parser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(T4Parser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(T4Parser.Loop_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#atom_expression}.
	 * @param ctx the parse tree
	 */
	void enterAtom_expression(T4Parser.Atom_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#atom_expression}.
	 * @param ctx the parse tree
	 */
	void exitAtom_expression(T4Parser.Atom_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(T4Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(T4Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#literal_expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_expression(T4Parser.Literal_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#literal_expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_expression(T4Parser.Literal_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#path_expression}.
	 * @param ctx the parse tree
	 */
	void enterPath_expression(T4Parser.Path_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#path_expression}.
	 * @param ctx the parse tree
	 */
	void exitPath_expression(T4Parser.Path_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#binary_expression}.
	 * @param ctx the parse tree
	 */
	void enterBinary_expression(T4Parser.Binary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#binary_expression}.
	 * @param ctx the parse tree
	 */
	void exitBinary_expression(T4Parser.Binary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(T4Parser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(T4Parser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(T4Parser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(T4Parser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#call_expression}.
	 * @param ctx the parse tree
	 */
	void enterCall_expression(T4Parser.Call_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#call_expression}.
	 * @param ctx the parse tree
	 */
	void exitCall_expression(T4Parser.Call_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(T4Parser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(T4Parser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#index_expression}.
	 * @param ctx the parse tree
	 */
	void enterIndex_expression(T4Parser.Index_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#index_expression}.
	 * @param ctx the parse tree
	 */
	void exitIndex_expression(T4Parser.Index_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#field_expression}.
	 * @param ctx the parse tree
	 */
	void enterField_expression(T4Parser.Field_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#field_expression}.
	 * @param ctx the parse tree
	 */
	void exitField_expression(T4Parser.Field_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#method_expression}.
	 * @param ctx the parse tree
	 */
	void enterMethod_expression(T4Parser.Method_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#method_expression}.
	 * @param ctx the parse tree
	 */
	void exitMethod_expression(T4Parser.Method_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#tuple_expression}.
	 * @param ctx the parse tree
	 */
	void enterTuple_expression(T4Parser.Tuple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#tuple_expression}.
	 * @param ctx the parse tree
	 */
	void exitTuple_expression(T4Parser.Tuple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#array_expression}.
	 * @param ctx the parse tree
	 */
	void enterArray_expression(T4Parser.Array_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#array_expression}.
	 * @param ctx the parse tree
	 */
	void exitArray_expression(T4Parser.Array_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#struct_expression}.
	 * @param ctx the parse tree
	 */
	void enterStruct_expression(T4Parser.Struct_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#struct_expression}.
	 * @param ctx the parse tree
	 */
	void exitStruct_expression(T4Parser.Struct_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#field_init}.
	 * @param ctx the parse tree
	 */
	void enterField_init(T4Parser.Field_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#field_init}.
	 * @param ctx the parse tree
	 */
	void exitField_init(T4Parser.Field_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#enum_expression}.
	 * @param ctx the parse tree
	 */
	void enterEnum_expression(T4Parser.Enum_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#enum_expression}.
	 * @param ctx the parse tree
	 */
	void exitEnum_expression(T4Parser.Enum_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#range_expression}.
	 * @param ctx the parse tree
	 */
	void enterRange_expression(T4Parser.Range_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#range_expression}.
	 * @param ctx the parse tree
	 */
	void exitRange_expression(T4Parser.Range_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#reference_expression}.
	 * @param ctx the parse tree
	 */
	void enterReference_expression(T4Parser.Reference_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#reference_expression}.
	 * @param ctx the parse tree
	 */
	void exitReference_expression(T4Parser.Reference_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#dereference_expression}.
	 * @param ctx the parse tree
	 */
	void enterDereference_expression(T4Parser.Dereference_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#dereference_expression}.
	 * @param ctx the parse tree
	 */
	void exitDereference_expression(T4Parser.Dereference_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#type_cast_expression}.
	 * @param ctx the parse tree
	 */
	void enterType_cast_expression(T4Parser.Type_cast_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#type_cast_expression}.
	 * @param ctx the parse tree
	 */
	void exitType_cast_expression(T4Parser.Type_cast_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#grouped_expression}.
	 * @param ctx the parse tree
	 */
	void enterGrouped_expression(T4Parser.Grouped_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#grouped_expression}.
	 * @param ctx the parse tree
	 */
	void exitGrouped_expression(T4Parser.Grouped_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#block_expression}.
	 * @param ctx the parse tree
	 */
	void enterBlock_expression(T4Parser.Block_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#block_expression}.
	 * @param ctx the parse tree
	 */
	void exitBlock_expression(T4Parser.Block_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#if_expression}.
	 * @param ctx the parse tree
	 */
	void enterIf_expression(T4Parser.If_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#if_expression}.
	 * @param ctx the parse tree
	 */
	void exitIf_expression(T4Parser.If_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#match_expression}.
	 * @param ctx the parse tree
	 */
	void enterMatch_expression(T4Parser.Match_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#match_expression}.
	 * @param ctx the parse tree
	 */
	void exitMatch_expression(T4Parser.Match_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#closure_expression}.
	 * @param ctx the parse tree
	 */
	void enterClosure_expression(T4Parser.Closure_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#closure_expression}.
	 * @param ctx the parse tree
	 */
	void exitClosure_expression(T4Parser.Closure_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#async_expression}.
	 * @param ctx the parse tree
	 */
	void enterAsync_expression(T4Parser.Async_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#async_expression}.
	 * @param ctx the parse tree
	 */
	void exitAsync_expression(T4Parser.Async_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#await_expression}.
	 * @param ctx the parse tree
	 */
	void enterAwait_expression(T4Parser.Await_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#await_expression}.
	 * @param ctx the parse tree
	 */
	void exitAwait_expression(T4Parser.Await_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#cryptographic_expression}.
	 * @param ctx the parse tree
	 */
	void enterCryptographic_expression(T4Parser.Cryptographic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#cryptographic_expression}.
	 * @param ctx the parse tree
	 */
	void exitCryptographic_expression(T4Parser.Cryptographic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#encrypt_expression}.
	 * @param ctx the parse tree
	 */
	void enterEncrypt_expression(T4Parser.Encrypt_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#encrypt_expression}.
	 * @param ctx the parse tree
	 */
	void exitEncrypt_expression(T4Parser.Encrypt_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#decrypt_expression}.
	 * @param ctx the parse tree
	 */
	void enterDecrypt_expression(T4Parser.Decrypt_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#decrypt_expression}.
	 * @param ctx the parse tree
	 */
	void exitDecrypt_expression(T4Parser.Decrypt_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#sign_expression}.
	 * @param ctx the parse tree
	 */
	void enterSign_expression(T4Parser.Sign_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#sign_expression}.
	 * @param ctx the parse tree
	 */
	void exitSign_expression(T4Parser.Sign_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#verify_expression}.
	 * @param ctx the parse tree
	 */
	void enterVerify_expression(T4Parser.Verify_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#verify_expression}.
	 * @param ctx the parse tree
	 */
	void exitVerify_expression(T4Parser.Verify_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#keygen_expression}.
	 * @param ctx the parse tree
	 */
	void enterKeygen_expression(T4Parser.Keygen_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#keygen_expression}.
	 * @param ctx the parse tree
	 */
	void exitKeygen_expression(T4Parser.Keygen_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#kem_expression}.
	 * @param ctx the parse tree
	 */
	void enterKem_expression(T4Parser.Kem_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#kem_expression}.
	 * @param ctx the parse tree
	 */
	void exitKem_expression(T4Parser.Kem_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#proof_expression}.
	 * @param ctx the parse tree
	 */
	void enterProof_expression(T4Parser.Proof_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#proof_expression}.
	 * @param ctx the parse tree
	 */
	void exitProof_expression(T4Parser.Proof_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#verify_proof_expression}.
	 * @param ctx the parse tree
	 */
	void enterVerify_proof_expression(T4Parser.Verify_proof_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#verify_proof_expression}.
	 * @param ctx the parse tree
	 */
	void exitVerify_proof_expression(T4Parser.Verify_proof_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#security_annotation}.
	 * @param ctx the parse tree
	 */
	void enterSecurity_annotation(T4Parser.Security_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#security_annotation}.
	 * @param ctx the parse tree
	 */
	void exitSecurity_annotation(T4Parser.Security_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#security_attribute}.
	 * @param ctx the parse tree
	 */
	void enterSecurity_attribute(T4Parser.Security_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#security_attribute}.
	 * @param ctx the parse tree
	 */
	void exitSecurity_attribute(T4Parser.Security_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(T4Parser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(T4Parser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#literal_pattern}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_pattern(T4Parser.Literal_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#literal_pattern}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_pattern(T4Parser.Literal_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#identifier_pattern}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_pattern(T4Parser.Identifier_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#identifier_pattern}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_pattern(T4Parser.Identifier_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#wildcard_pattern}.
	 * @param ctx the parse tree
	 */
	void enterWildcard_pattern(T4Parser.Wildcard_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#wildcard_pattern}.
	 * @param ctx the parse tree
	 */
	void exitWildcard_pattern(T4Parser.Wildcard_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#reference_pattern}.
	 * @param ctx the parse tree
	 */
	void enterReference_pattern(T4Parser.Reference_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#reference_pattern}.
	 * @param ctx the parse tree
	 */
	void exitReference_pattern(T4Parser.Reference_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#struct_pattern}.
	 * @param ctx the parse tree
	 */
	void enterStruct_pattern(T4Parser.Struct_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#struct_pattern}.
	 * @param ctx the parse tree
	 */
	void exitStruct_pattern(T4Parser.Struct_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#field_pattern}.
	 * @param ctx the parse tree
	 */
	void enterField_pattern(T4Parser.Field_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#field_pattern}.
	 * @param ctx the parse tree
	 */
	void exitField_pattern(T4Parser.Field_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#enum_pattern}.
	 * @param ctx the parse tree
	 */
	void enterEnum_pattern(T4Parser.Enum_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#enum_pattern}.
	 * @param ctx the parse tree
	 */
	void exitEnum_pattern(T4Parser.Enum_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#tuple_pattern}.
	 * @param ctx the parse tree
	 */
	void enterTuple_pattern(T4Parser.Tuple_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#tuple_pattern}.
	 * @param ctx the parse tree
	 */
	void exitTuple_pattern(T4Parser.Tuple_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#array_pattern}.
	 * @param ctx the parse tree
	 */
	void enterArray_pattern(T4Parser.Array_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#array_pattern}.
	 * @param ctx the parse tree
	 */
	void exitArray_pattern(T4Parser.Array_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#range_pattern}.
	 * @param ctx the parse tree
	 */
	void enterRange_pattern(T4Parser.Range_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#range_pattern}.
	 * @param ctx the parse tree
	 */
	void exitRange_pattern(T4Parser.Range_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#patterns}.
	 * @param ctx the parse tree
	 */
	void enterPatterns(T4Parser.PatternsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#patterns}.
	 * @param ctx the parse tree
	 */
	void exitPatterns(T4Parser.PatternsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generic_args}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_args(T4Parser.Generic_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generic_args}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_args(T4Parser.Generic_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#error_type}.
	 * @param ctx the parse tree
	 */
	void enterError_type(T4Parser.Error_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#error_type}.
	 * @param ctx the parse tree
	 */
	void exitError_type(T4Parser.Error_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#result_type}.
	 * @param ctx the parse tree
	 */
	void enterResult_type(T4Parser.Result_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#result_type}.
	 * @param ctx the parse tree
	 */
	void exitResult_type(T4Parser.Result_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#advanced_type}.
	 * @param ctx the parse tree
	 */
	void enterAdvanced_type(T4Parser.Advanced_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#advanced_type}.
	 * @param ctx the parse tree
	 */
	void exitAdvanced_type(T4Parser.Advanced_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#higher_kinded_type}.
	 * @param ctx the parse tree
	 */
	void enterHigher_kinded_type(T4Parser.Higher_kinded_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#higher_kinded_type}.
	 * @param ctx the parse tree
	 */
	void exitHigher_kinded_type(T4Parser.Higher_kinded_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#type_constructor}.
	 * @param ctx the parse tree
	 */
	void enterType_constructor(T4Parser.Type_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#type_constructor}.
	 * @param ctx the parse tree
	 */
	void exitType_constructor(T4Parser.Type_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#crypto_type_params}.
	 * @param ctx the parse tree
	 */
	void enterCrypto_type_params(T4Parser.Crypto_type_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#crypto_type_params}.
	 * @param ctx the parse tree
	 */
	void exitCrypto_type_params(T4Parser.Crypto_type_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#trait_bounds}.
	 * @param ctx the parse tree
	 */
	void enterTrait_bounds(T4Parser.Trait_boundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#trait_bounds}.
	 * @param ctx the parse tree
	 */
	void exitTrait_bounds(T4Parser.Trait_boundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#associated_type}.
	 * @param ctx the parse tree
	 */
	void enterAssociated_type(T4Parser.Associated_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#associated_type}.
	 * @param ctx the parse tree
	 */
	void exitAssociated_type(T4Parser.Associated_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#associated_const}.
	 * @param ctx the parse tree
	 */
	void enterAssociated_const(T4Parser.Associated_constContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#associated_const}.
	 * @param ctx the parse tree
	 */
	void exitAssociated_const(T4Parser.Associated_constContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generic_constraints}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_constraints(T4Parser.Generic_constraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generic_constraints}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_constraints(T4Parser.Generic_constraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#type_family}.
	 * @param ctx the parse tree
	 */
	void enterType_family(T4Parser.Type_familyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#type_family}.
	 * @param ctx the parse tree
	 */
	void exitType_family(T4Parser.Type_familyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#kind}.
	 * @param ctx the parse tree
	 */
	void enterKind(T4Parser.KindContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#kind}.
	 * @param ctx the parse tree
	 */
	void exitKind(T4Parser.KindContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#phantom_type}.
	 * @param ctx the parse tree
	 */
	void enterPhantom_type(T4Parser.Phantom_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#phantom_type}.
	 * @param ctx the parse tree
	 */
	void exitPhantom_type(T4Parser.Phantom_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#existential_type}.
	 * @param ctx the parse tree
	 */
	void enterExistential_type(T4Parser.Existential_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#existential_type}.
	 * @param ctx the parse tree
	 */
	void exitExistential_type(T4Parser.Existential_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#universal_type}.
	 * @param ctx the parse tree
	 */
	void enterUniversal_type(T4Parser.Universal_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#universal_type}.
	 * @param ctx the parse tree
	 */
	void exitUniversal_type(T4Parser.Universal_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#security_annotations}.
	 * @param ctx the parse tree
	 */
	void enterSecurity_annotations(T4Parser.Security_annotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#security_annotations}.
	 * @param ctx the parse tree
	 */
	void exitSecurity_annotations(T4Parser.Security_annotationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#advanced_security_attribute}.
	 * @param ctx the parse tree
	 */
	void enterAdvanced_security_attribute(T4Parser.Advanced_security_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#advanced_security_attribute}.
	 * @param ctx the parse tree
	 */
	void exitAdvanced_security_attribute(T4Parser.Advanced_security_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#protocol_annotation}.
	 * @param ctx the parse tree
	 */
	void enterProtocol_annotation(T4Parser.Protocol_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#protocol_annotation}.
	 * @param ctx the parse tree
	 */
	void exitProtocol_annotation(T4Parser.Protocol_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#protocol_spec}.
	 * @param ctx the parse tree
	 */
	void enterProtocol_spec(T4Parser.Protocol_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#protocol_spec}.
	 * @param ctx the parse tree
	 */
	void exitProtocol_spec(T4Parser.Protocol_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#protocol_property}.
	 * @param ctx the parse tree
	 */
	void enterProtocol_property(T4Parser.Protocol_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#protocol_property}.
	 * @param ctx the parse tree
	 */
	void exitProtocol_property(T4Parser.Protocol_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#zero_knowledge_annotation}.
	 * @param ctx the parse tree
	 */
	void enterZero_knowledge_annotation(T4Parser.Zero_knowledge_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#zero_knowledge_annotation}.
	 * @param ctx the parse tree
	 */
	void exitZero_knowledge_annotation(T4Parser.Zero_knowledge_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#zk_params}.
	 * @param ctx the parse tree
	 */
	void enterZk_params(T4Parser.Zk_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#zk_params}.
	 * @param ctx the parse tree
	 */
	void exitZk_params(T4Parser.Zk_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#homomorphic_annotation}.
	 * @param ctx the parse tree
	 */
	void enterHomomorphic_annotation(T4Parser.Homomorphic_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#homomorphic_annotation}.
	 * @param ctx the parse tree
	 */
	void exitHomomorphic_annotation(T4Parser.Homomorphic_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#distributed_annotation}.
	 * @param ctx the parse tree
	 */
	void enterDistributed_annotation(T4Parser.Distributed_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#distributed_annotation}.
	 * @param ctx the parse tree
	 */
	void exitDistributed_annotation(T4Parser.Distributed_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#secure_computation_annotation}.
	 * @param ctx the parse tree
	 */
	void enterSecure_computation_annotation(T4Parser.Secure_computation_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#secure_computation_annotation}.
	 * @param ctx the parse tree
	 */
	void exitSecure_computation_annotation(T4Parser.Secure_computation_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#computation_type}.
	 * @param ctx the parse tree
	 */
	void enterComputation_type(T4Parser.Computation_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#computation_type}.
	 * @param ctx the parse tree
	 */
	void exitComputation_type(T4Parser.Computation_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#advanced_function}.
	 * @param ctx the parse tree
	 */
	void enterAdvanced_function(T4Parser.Advanced_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#advanced_function}.
	 * @param ctx the parse tree
	 */
	void exitAdvanced_function(T4Parser.Advanced_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#operator_overload}.
	 * @param ctx the parse tree
	 */
	void enterOperator_overload(T4Parser.Operator_overloadContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#operator_overload}.
	 * @param ctx the parse tree
	 */
	void exitOperator_overload(T4Parser.Operator_overloadContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunction_body(T4Parser.Function_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunction_body(T4Parser.Function_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#operator_name}.
	 * @param ctx the parse tree
	 */
	void enterOperator_name(T4Parser.Operator_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#operator_name}.
	 * @param ctx the parse tree
	 */
	void exitOperator_name(T4Parser.Operator_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#async_function}.
	 * @param ctx the parse tree
	 */
	void enterAsync_function(T4Parser.Async_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#async_function}.
	 * @param ctx the parse tree
	 */
	void exitAsync_function(T4Parser.Async_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#async_statement}.
	 * @param ctx the parse tree
	 */
	void enterAsync_statement(T4Parser.Async_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#async_statement}.
	 * @param ctx the parse tree
	 */
	void exitAsync_statement(T4Parser.Async_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#stream_expression}.
	 * @param ctx the parse tree
	 */
	void enterStream_expression(T4Parser.Stream_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#stream_expression}.
	 * @param ctx the parse tree
	 */
	void exitStream_expression(T4Parser.Stream_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#iterator_expression}.
	 * @param ctx the parse tree
	 */
	void enterIterator_expression(T4Parser.Iterator_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#iterator_expression}.
	 * @param ctx the parse tree
	 */
	void exitIterator_expression(T4Parser.Iterator_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generator_expression}.
	 * @param ctx the parse tree
	 */
	void enterGenerator_expression(T4Parser.Generator_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generator_expression}.
	 * @param ctx the parse tree
	 */
	void exitGenerator_expression(T4Parser.Generator_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#yield_statement}.
	 * @param ctx the parse tree
	 */
	void enterYield_statement(T4Parser.Yield_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#yield_statement}.
	 * @param ctx the parse tree
	 */
	void exitYield_statement(T4Parser.Yield_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#coroutine_expression}.
	 * @param ctx the parse tree
	 */
	void enterCoroutine_expression(T4Parser.Coroutine_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#coroutine_expression}.
	 * @param ctx the parse tree
	 */
	void exitCoroutine_expression(T4Parser.Coroutine_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#partial_application}.
	 * @param ctx the parse tree
	 */
	void enterPartial_application(T4Parser.Partial_applicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#partial_application}.
	 * @param ctx the parse tree
	 */
	void exitPartial_application(T4Parser.Partial_applicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#partial_args}.
	 * @param ctx the parse tree
	 */
	void enterPartial_args(T4Parser.Partial_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#partial_args}.
	 * @param ctx the parse tree
	 */
	void exitPartial_args(T4Parser.Partial_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#function_composition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_composition(T4Parser.Function_compositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#function_composition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_composition(T4Parser.Function_compositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#pipeline_expression}.
	 * @param ctx the parse tree
	 */
	void enterPipeline_expression(T4Parser.Pipeline_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#pipeline_expression}.
	 * @param ctx the parse tree
	 */
	void exitPipeline_expression(T4Parser.Pipeline_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#method_chain}.
	 * @param ctx the parse tree
	 */
	void enterMethod_chain(T4Parser.Method_chainContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#method_chain}.
	 * @param ctx the parse tree
	 */
	void exitMethod_chain(T4Parser.Method_chainContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#module_hierarchy}.
	 * @param ctx the parse tree
	 */
	void enterModule_hierarchy(T4Parser.Module_hierarchyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#module_hierarchy}.
	 * @param ctx the parse tree
	 */
	void exitModule_hierarchy(T4Parser.Module_hierarchyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#module_item}.
	 * @param ctx the parse tree
	 */
	void enterModule_item(T4Parser.Module_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#module_item}.
	 * @param ctx the parse tree
	 */
	void exitModule_item(T4Parser.Module_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#visibility_modifier}.
	 * @param ctx the parse tree
	 */
	void enterVisibility_modifier(T4Parser.Visibility_modifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#visibility_modifier}.
	 * @param ctx the parse tree
	 */
	void exitVisibility_modifier(T4Parser.Visibility_modifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#secure_module}.
	 * @param ctx the parse tree
	 */
	void enterSecure_module(T4Parser.Secure_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#secure_module}.
	 * @param ctx the parse tree
	 */
	void exitSecure_module(T4Parser.Secure_moduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#secure_item}.
	 * @param ctx the parse tree
	 */
	void enterSecure_item(T4Parser.Secure_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#secure_item}.
	 * @param ctx the parse tree
	 */
	void exitSecure_item(T4Parser.Secure_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#isolated_module}.
	 * @param ctx the parse tree
	 */
	void enterIsolated_module(T4Parser.Isolated_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#isolated_module}.
	 * @param ctx the parse tree
	 */
	void exitIsolated_module(T4Parser.Isolated_moduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#isolated_item}.
	 * @param ctx the parse tree
	 */
	void enterIsolated_item(T4Parser.Isolated_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#isolated_item}.
	 * @param ctx the parse tree
	 */
	void exitIsolated_item(T4Parser.Isolated_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#component_declaration}.
	 * @param ctx the parse tree
	 */
	void enterComponent_declaration(T4Parser.Component_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#component_declaration}.
	 * @param ctx the parse tree
	 */
	void exitComponent_declaration(T4Parser.Component_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#interface_list}.
	 * @param ctx the parse tree
	 */
	void enterInterface_list(T4Parser.Interface_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#interface_list}.
	 * @param ctx the parse tree
	 */
	void exitInterface_list(T4Parser.Interface_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#component_item}.
	 * @param ctx the parse tree
	 */
	void enterComponent_item(T4Parser.Component_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#component_item}.
	 * @param ctx the parse tree
	 */
	void exitComponent_item(T4Parser.Component_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#microservice_declaration}.
	 * @param ctx the parse tree
	 */
	void enterMicroservice_declaration(T4Parser.Microservice_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#microservice_declaration}.
	 * @param ctx the parse tree
	 */
	void exitMicroservice_declaration(T4Parser.Microservice_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#microservice_config}.
	 * @param ctx the parse tree
	 */
	void enterMicroservice_config(T4Parser.Microservice_configContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#microservice_config}.
	 * @param ctx the parse tree
	 */
	void exitMicroservice_config(T4Parser.Microservice_configContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#api_declaration}.
	 * @param ctx the parse tree
	 */
	void enterApi_declaration(T4Parser.Api_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#api_declaration}.
	 * @param ctx the parse tree
	 */
	void exitApi_declaration(T4Parser.Api_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#api_method}.
	 * @param ctx the parse tree
	 */
	void enterApi_method(T4Parser.Api_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#api_method}.
	 * @param ctx the parse tree
	 */
	void exitApi_method(T4Parser.Api_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#interface_declaration}.
	 * @param ctx the parse tree
	 */
	void enterInterface_declaration(T4Parser.Interface_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#interface_declaration}.
	 * @param ctx the parse tree
	 */
	void exitInterface_declaration(T4Parser.Interface_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#interface_method}.
	 * @param ctx the parse tree
	 */
	void enterInterface_method(T4Parser.Interface_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#interface_method}.
	 * @param ctx the parse tree
	 */
	void exitInterface_method(T4Parser.Interface_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#pattern_matching}.
	 * @param ctx the parse tree
	 */
	void enterPattern_matching(T4Parser.Pattern_matchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#pattern_matching}.
	 * @param ctx the parse tree
	 */
	void exitPattern_matching(T4Parser.Pattern_matchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#pattern_arm}.
	 * @param ctx the parse tree
	 */
	void enterPattern_arm(T4Parser.Pattern_armContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#pattern_arm}.
	 * @param ctx the parse tree
	 */
	void exitPattern_arm(T4Parser.Pattern_armContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#guard_expression}.
	 * @param ctx the parse tree
	 */
	void enterGuard_expression(T4Parser.Guard_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#guard_expression}.
	 * @param ctx the parse tree
	 */
	void exitGuard_expression(T4Parser.Guard_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#destructuring}.
	 * @param ctx the parse tree
	 */
	void enterDestructuring(T4Parser.DestructuringContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#destructuring}.
	 * @param ctx the parse tree
	 */
	void exitDestructuring(T4Parser.DestructuringContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(T4Parser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(T4Parser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#comprehension}.
	 * @param ctx the parse tree
	 */
	void enterComprehension(T4Parser.ComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#comprehension}.
	 * @param ctx the parse tree
	 */
	void exitComprehension(T4Parser.ComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#iterators}.
	 * @param ctx the parse tree
	 */
	void enterIterators(T4Parser.IteratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#iterators}.
	 * @param ctx the parse tree
	 */
	void exitIterators(T4Parser.IteratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#iterator_chain}.
	 * @param ctx the parse tree
	 */
	void enterIterator_chain(T4Parser.Iterator_chainContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#iterator_chain}.
	 * @param ctx the parse tree
	 */
	void exitIterator_chain(T4Parser.Iterator_chainContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#chain_operation}.
	 * @param ctx the parse tree
	 */
	void enterChain_operation(T4Parser.Chain_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#chain_operation}.
	 * @param ctx the parse tree
	 */
	void exitChain_operation(T4Parser.Chain_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#list_comprehension}.
	 * @param ctx the parse tree
	 */
	void enterList_comprehension(T4Parser.List_comprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#list_comprehension}.
	 * @param ctx the parse tree
	 */
	void exitList_comprehension(T4Parser.List_comprehensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generators}.
	 * @param ctx the parse tree
	 */
	void enterGenerators(T4Parser.GeneratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generators}.
	 * @param ctx the parse tree
	 */
	void exitGenerators(T4Parser.GeneratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generator}.
	 * @param ctx the parse tree
	 */
	void enterGenerator(T4Parser.GeneratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generator}.
	 * @param ctx the parse tree
	 */
	void exitGenerator(T4Parser.GeneratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#range_literal}.
	 * @param ctx the parse tree
	 */
	void enterRange_literal(T4Parser.Range_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#range_literal}.
	 * @param ctx the parse tree
	 */
	void exitRange_literal(T4Parser.Range_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#early_return}.
	 * @param ctx the parse tree
	 */
	void enterEarly_return(T4Parser.Early_returnContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#early_return}.
	 * @param ctx the parse tree
	 */
	void exitEarly_return(T4Parser.Early_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#vector_literal}.
	 * @param ctx the parse tree
	 */
	void enterVector_literal(T4Parser.Vector_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#vector_literal}.
	 * @param ctx the parse tree
	 */
	void exitVector_literal(T4Parser.Vector_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#set_literal}.
	 * @param ctx the parse tree
	 */
	void enterSet_literal(T4Parser.Set_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#set_literal}.
	 * @param ctx the parse tree
	 */
	void exitSet_literal(T4Parser.Set_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#crypto_literal}.
	 * @param ctx the parse tree
	 */
	void enterCrypto_literal(T4Parser.Crypto_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#crypto_literal}.
	 * @param ctx the parse tree
	 */
	void exitCrypto_literal(T4Parser.Crypto_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#key_data}.
	 * @param ctx the parse tree
	 */
	void enterKey_data(T4Parser.Key_dataContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#key_data}.
	 * @param ctx the parse tree
	 */
	void exitKey_data(T4Parser.Key_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#secret_data}.
	 * @param ctx the parse tree
	 */
	void enterSecret_data(T4Parser.Secret_dataContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#secret_data}.
	 * @param ctx the parse tree
	 */
	void exitSecret_data(T4Parser.Secret_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#crypto_operation}.
	 * @param ctx the parse tree
	 */
	void enterCrypto_operation(T4Parser.Crypto_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#crypto_operation}.
	 * @param ctx the parse tree
	 */
	void exitCrypto_operation(T4Parser.Crypto_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#operation_type}.
	 * @param ctx the parse tree
	 */
	void enterOperation_type(T4Parser.Operation_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#operation_type}.
	 * @param ctx the parse tree
	 */
	void exitOperation_type(T4Parser.Operation_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#operands}.
	 * @param ctx the parse tree
	 */
	void enterOperands(T4Parser.OperandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#operands}.
	 * @param ctx the parse tree
	 */
	void exitOperands(T4Parser.OperandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#protocol_definition}.
	 * @param ctx the parse tree
	 */
	void enterProtocol_definition(T4Parser.Protocol_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#protocol_definition}.
	 * @param ctx the parse tree
	 */
	void exitProtocol_definition(T4Parser.Protocol_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#protocol_stage}.
	 * @param ctx the parse tree
	 */
	void enterProtocol_stage(T4Parser.Protocol_stageContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#protocol_stage}.
	 * @param ctx the parse tree
	 */
	void exitProtocol_stage(T4Parser.Protocol_stageContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#protocol_action}.
	 * @param ctx the parse tree
	 */
	void enterProtocol_action(T4Parser.Protocol_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#protocol_action}.
	 * @param ctx the parse tree
	 */
	void exitProtocol_action(T4Parser.Protocol_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(T4Parser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(T4Parser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#computation}.
	 * @param ctx the parse tree
	 */
	void enterComputation(T4Parser.ComputationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#computation}.
	 * @param ctx the parse tree
	 */
	void exitComputation(T4Parser.ComputationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#verification}.
	 * @param ctx the parse tree
	 */
	void enterVerification(T4Parser.VerificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#verification}.
	 * @param ctx the parse tree
	 */
	void exitVerification(T4Parser.VerificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#zero_knowledge_proof}.
	 * @param ctx the parse tree
	 */
	void enterZero_knowledge_proof(T4Parser.Zero_knowledge_proofContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#zero_knowledge_proof}.
	 * @param ctx the parse tree
	 */
	void exitZero_knowledge_proof(T4Parser.Zero_knowledge_proofContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#prover}.
	 * @param ctx the parse tree
	 */
	void enterProver(T4Parser.ProverContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#prover}.
	 * @param ctx the parse tree
	 */
	void exitProver(T4Parser.ProverContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#verifier}.
	 * @param ctx the parse tree
	 */
	void enterVerifier(T4Parser.VerifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#verifier}.
	 * @param ctx the parse tree
	 */
	void exitVerifier(T4Parser.VerifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#zk_statement}.
	 * @param ctx the parse tree
	 */
	void enterZk_statement(T4Parser.Zk_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#zk_statement}.
	 * @param ctx the parse tree
	 */
	void exitZk_statement(T4Parser.Zk_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#witness}.
	 * @param ctx the parse tree
	 */
	void enterWitness(T4Parser.WitnessContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#witness}.
	 * @param ctx the parse tree
	 */
	void exitWitness(T4Parser.WitnessContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#homomorphic_operation}.
	 * @param ctx the parse tree
	 */
	void enterHomomorphic_operation(T4Parser.Homomorphic_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#homomorphic_operation}.
	 * @param ctx the parse tree
	 */
	void exitHomomorphic_operation(T4Parser.Homomorphic_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(T4Parser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(T4Parser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#encrypted_data}.
	 * @param ctx the parse tree
	 */
	void enterEncrypted_data(T4Parser.Encrypted_dataContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#encrypted_data}.
	 * @param ctx the parse tree
	 */
	void exitEncrypted_data(T4Parser.Encrypted_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#plaintext}.
	 * @param ctx the parse tree
	 */
	void enterPlaintext(T4Parser.PlaintextContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#plaintext}.
	 * @param ctx the parse tree
	 */
	void exitPlaintext(T4Parser.PlaintextContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#distributed_crypto}.
	 * @param ctx the parse tree
	 */
	void enterDistributed_crypto(T4Parser.Distributed_cryptoContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#distributed_crypto}.
	 * @param ctx the parse tree
	 */
	void exitDistributed_crypto(T4Parser.Distributed_cryptoContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#participants}.
	 * @param ctx the parse tree
	 */
	void enterParticipants(T4Parser.ParticipantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#participants}.
	 * @param ctx the parse tree
	 */
	void exitParticipants(T4Parser.ParticipantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#secure_computation}.
	 * @param ctx the parse tree
	 */
	void enterSecure_computation(T4Parser.Secure_computationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#secure_computation}.
	 * @param ctx the parse tree
	 */
	void exitSecure_computation(T4Parser.Secure_computationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(T4Parser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(T4Parser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#anonymous_communication}.
	 * @param ctx the parse tree
	 */
	void enterAnonymous_communication(T4Parser.Anonymous_communicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#anonymous_communication}.
	 * @param ctx the parse tree
	 */
	void exitAnonymous_communication(T4Parser.Anonymous_communicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#routing}.
	 * @param ctx the parse tree
	 */
	void enterRouting(T4Parser.RoutingContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#routing}.
	 * @param ctx the parse tree
	 */
	void exitRouting(T4Parser.RoutingContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#untraceable_operation}.
	 * @param ctx the parse tree
	 */
	void enterUntraceable_operation(T4Parser.Untraceable_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#untraceable_operation}.
	 * @param ctx the parse tree
	 */
	void exitUntraceable_operation(T4Parser.Untraceable_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#confidentiality_property}.
	 * @param ctx the parse tree
	 */
	void enterConfidentiality_property(T4Parser.Confidentiality_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#confidentiality_property}.
	 * @param ctx the parse tree
	 */
	void exitConfidentiality_property(T4Parser.Confidentiality_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(T4Parser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(T4Parser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#policy}.
	 * @param ctx the parse tree
	 */
	void enterPolicy(T4Parser.PolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#policy}.
	 * @param ctx the parse tree
	 */
	void exitPolicy(T4Parser.PolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#authentication_property}.
	 * @param ctx the parse tree
	 */
	void enterAuthentication_property(T4Parser.Authentication_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#authentication_property}.
	 * @param ctx the parse tree
	 */
	void exitAuthentication_property(T4Parser.Authentication_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(T4Parser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(T4Parser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#credential}.
	 * @param ctx the parse tree
	 */
	void enterCredential(T4Parser.CredentialContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#credential}.
	 * @param ctx the parse tree
	 */
	void exitCredential(T4Parser.CredentialContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#non_repudiation_property}.
	 * @param ctx the parse tree
	 */
	void enterNon_repudiation_property(T4Parser.Non_repudiation_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#non_repudiation_property}.
	 * @param ctx the parse tree
	 */
	void exitNon_repudiation_property(T4Parser.Non_repudiation_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(T4Parser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(T4Parser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#evidence}.
	 * @param ctx the parse tree
	 */
	void enterEvidence(T4Parser.EvidenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#evidence}.
	 * @param ctx the parse tree
	 */
	void exitEvidence(T4Parser.EvidenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#integrity_property}.
	 * @param ctx the parse tree
	 */
	void enterIntegrity_property(T4Parser.Integrity_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#integrity_property}.
	 * @param ctx the parse tree
	 */
	void exitIntegrity_property(T4Parser.Integrity_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#checksum}.
	 * @param ctx the parse tree
	 */
	void enterChecksum(T4Parser.ChecksumContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#checksum}.
	 * @param ctx the parse tree
	 */
	void exitChecksum(T4Parser.ChecksumContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#availability_property}.
	 * @param ctx the parse tree
	 */
	void enterAvailability_property(T4Parser.Availability_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#availability_property}.
	 * @param ctx the parse tree
	 */
	void exitAvailability_property(T4Parser.Availability_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(T4Parser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(T4Parser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#redundancy}.
	 * @param ctx the parse tree
	 */
	void enterRedundancy(T4Parser.RedundancyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#redundancy}.
	 * @param ctx the parse tree
	 */
	void exitRedundancy(T4Parser.RedundancyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#freshness_property}.
	 * @param ctx the parse tree
	 */
	void enterFreshness_property(T4Parser.Freshness_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#freshness_property}.
	 * @param ctx the parse tree
	 */
	void exitFreshness_property(T4Parser.Freshness_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#timestamp}.
	 * @param ctx the parse tree
	 */
	void enterTimestamp(T4Parser.TimestampContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#timestamp}.
	 * @param ctx the parse tree
	 */
	void exitTimestamp(T4Parser.TimestampContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#nonce}.
	 * @param ctx the parse tree
	 */
	void enterNonce(T4Parser.NonceContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#nonce}.
	 * @param ctx the parse tree
	 */
	void exitNonce(T4Parser.NonceContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#forward_secrecy_property}.
	 * @param ctx the parse tree
	 */
	void enterForward_secrecy_property(T4Parser.Forward_secrecy_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#forward_secrecy_property}.
	 * @param ctx the parse tree
	 */
	void exitForward_secrecy_property(T4Parser.Forward_secrecy_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#session_key}.
	 * @param ctx the parse tree
	 */
	void enterSession_key(T4Parser.Session_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#session_key}.
	 * @param ctx the parse tree
	 */
	void exitSession_key(T4Parser.Session_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#compromise_time}.
	 * @param ctx the parse tree
	 */
	void enterCompromise_time(T4Parser.Compromise_timeContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#compromise_time}.
	 * @param ctx the parse tree
	 */
	void exitCompromise_time(T4Parser.Compromise_timeContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#backward_secrecy_property}.
	 * @param ctx the parse tree
	 */
	void enterBackward_secrecy_property(T4Parser.Backward_secrecy_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#backward_secrecy_property}.
	 * @param ctx the parse tree
	 */
	void exitBackward_secrecy_property(T4Parser.Backward_secrecy_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#perfect_secrecy_property}.
	 * @param ctx the parse tree
	 */
	void enterPerfect_secrecy_property(T4Parser.Perfect_secrecy_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#perfect_secrecy_property}.
	 * @param ctx the parse tree
	 */
	void exitPerfect_secrecy_property(T4Parser.Perfect_secrecy_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#key_expr}.
	 * @param ctx the parse tree
	 */
	void enterKey_expr(T4Parser.Key_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#key_expr}.
	 * @param ctx the parse tree
	 */
	void exitKey_expr(T4Parser.Key_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#computational_security_property}.
	 * @param ctx the parse tree
	 */
	void enterComputational_security_property(T4Parser.Computational_security_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#computational_security_property}.
	 * @param ctx the parse tree
	 */
	void exitComputational_security_property(T4Parser.Computational_security_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#algorithm}.
	 * @param ctx the parse tree
	 */
	void enterAlgorithm(T4Parser.AlgorithmContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#algorithm}.
	 * @param ctx the parse tree
	 */
	void exitAlgorithm(T4Parser.AlgorithmContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#security_parameter}.
	 * @param ctx the parse tree
	 */
	void enterSecurity_parameter(T4Parser.Security_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#security_parameter}.
	 * @param ctx the parse tree
	 */
	void exitSecurity_parameter(T4Parser.Security_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#information_theoretic_property}.
	 * @param ctx the parse tree
	 */
	void enterInformation_theoretic_property(T4Parser.Information_theoretic_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#information_theoretic_property}.
	 * @param ctx the parse tree
	 */
	void exitInformation_theoretic_property(T4Parser.Information_theoretic_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#entropy}.
	 * @param ctx the parse tree
	 */
	void enterEntropy(T4Parser.EntropyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#entropy}.
	 * @param ctx the parse tree
	 */
	void exitEntropy(T4Parser.EntropyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#min_entropy}.
	 * @param ctx the parse tree
	 */
	void enterMin_entropy(T4Parser.Min_entropyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#min_entropy}.
	 * @param ctx the parse tree
	 */
	void exitMin_entropy(T4Parser.Min_entropyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#compile_time_function}.
	 * @param ctx the parse tree
	 */
	void enterCompile_time_function(T4Parser.Compile_time_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#compile_time_function}.
	 * @param ctx the parse tree
	 */
	void exitCompile_time_function(T4Parser.Compile_time_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#macro_definition}.
	 * @param ctx the parse tree
	 */
	void enterMacro_definition(T4Parser.Macro_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#macro_definition}.
	 * @param ctx the parse tree
	 */
	void exitMacro_definition(T4Parser.Macro_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#macro_params}.
	 * @param ctx the parse tree
	 */
	void enterMacro_params(T4Parser.Macro_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#macro_params}.
	 * @param ctx the parse tree
	 */
	void exitMacro_params(T4Parser.Macro_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#macro_body}.
	 * @param ctx the parse tree
	 */
	void enterMacro_body(T4Parser.Macro_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#macro_body}.
	 * @param ctx the parse tree
	 */
	void exitMacro_body(T4Parser.Macro_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#macro_invocation}.
	 * @param ctx the parse tree
	 */
	void enterMacro_invocation(T4Parser.Macro_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#macro_invocation}.
	 * @param ctx the parse tree
	 */
	void exitMacro_invocation(T4Parser.Macro_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#macro_rules_definition}.
	 * @param ctx the parse tree
	 */
	void enterMacro_rules_definition(T4Parser.Macro_rules_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#macro_rules_definition}.
	 * @param ctx the parse tree
	 */
	void exitMacro_rules_definition(T4Parser.Macro_rules_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#macro_rule}.
	 * @param ctx the parse tree
	 */
	void enterMacro_rule(T4Parser.Macro_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#macro_rule}.
	 * @param ctx the parse tree
	 */
	void exitMacro_rule(T4Parser.Macro_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(T4Parser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(T4Parser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#syntax_extension}.
	 * @param ctx the parse tree
	 */
	void enterSyntax_extension(T4Parser.Syntax_extensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#syntax_extension}.
	 * @param ctx the parse tree
	 */
	void exitSyntax_extension(T4Parser.Syntax_extensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#syntax_rule}.
	 * @param ctx the parse tree
	 */
	void enterSyntax_rule(T4Parser.Syntax_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#syntax_rule}.
	 * @param ctx the parse tree
	 */
	void exitSyntax_rule(T4Parser.Syntax_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#proc_macro}.
	 * @param ctx the parse tree
	 */
	void enterProc_macro(T4Parser.Proc_macroContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#proc_macro}.
	 * @param ctx the parse tree
	 */
	void exitProc_macro(T4Parser.Proc_macroContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#derive_macro}.
	 * @param ctx the parse tree
	 */
	void enterDerive_macro(T4Parser.Derive_macroContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#derive_macro}.
	 * @param ctx the parse tree
	 */
	void exitDerive_macro(T4Parser.Derive_macroContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#trait_list}.
	 * @param ctx the parse tree
	 */
	void enterTrait_list(T4Parser.Trait_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#trait_list}.
	 * @param ctx the parse tree
	 */
	void exitTrait_list(T4Parser.Trait_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#attribute_macro}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_macro(T4Parser.Attribute_macroContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#attribute_macro}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_macro(T4Parser.Attribute_macroContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_name(T4Parser.Attribute_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_name(T4Parser.Attribute_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(T4Parser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(T4Parser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#annotation_name}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation_name(T4Parser.Annotation_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#annotation_name}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation_name(T4Parser.Annotation_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(T4Parser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(T4Parser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#decorator_name}.
	 * @param ctx the parse tree
	 */
	void enterDecorator_name(T4Parser.Decorator_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#decorator_name}.
	 * @param ctx the parse tree
	 */
	void exitDecorator_name(T4Parser.Decorator_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#meta_programming}.
	 * @param ctx the parse tree
	 */
	void enterMeta_programming(T4Parser.Meta_programmingContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#meta_programming}.
	 * @param ctx the parse tree
	 */
	void exitMeta_programming(T4Parser.Meta_programmingContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#meta_operation}.
	 * @param ctx the parse tree
	 */
	void enterMeta_operation(T4Parser.Meta_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#meta_operation}.
	 * @param ctx the parse tree
	 */
	void exitMeta_operation(T4Parser.Meta_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#template_metaprogramming}.
	 * @param ctx the parse tree
	 */
	void enterTemplate_metaprogramming(T4Parser.Template_metaprogrammingContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#template_metaprogramming}.
	 * @param ctx the parse tree
	 */
	void exitTemplate_metaprogramming(T4Parser.Template_metaprogrammingContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#template_args}.
	 * @param ctx the parse tree
	 */
	void enterTemplate_args(T4Parser.Template_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#template_args}.
	 * @param ctx the parse tree
	 */
	void exitTemplate_args(T4Parser.Template_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#generic_specialization}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_specialization(T4Parser.Generic_specializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#generic_specialization}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_specialization(T4Parser.Generic_specializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#monomorphization}.
	 * @param ctx the parse tree
	 */
	void enterMonomorphization(T4Parser.MonomorphizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#monomorphization}.
	 * @param ctx the parse tree
	 */
	void exitMonomorphization(T4Parser.MonomorphizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#const_evaluation}.
	 * @param ctx the parse tree
	 */
	void enterConst_evaluation(T4Parser.Const_evaluationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#const_evaluation}.
	 * @param ctx the parse tree
	 */
	void exitConst_evaluation(T4Parser.Const_evaluationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#static_analysis}.
	 * @param ctx the parse tree
	 */
	void enterStatic_analysis(T4Parser.Static_analysisContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#static_analysis}.
	 * @param ctx the parse tree
	 */
	void exitStatic_analysis(T4Parser.Static_analysisContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#analysis_directive}.
	 * @param ctx the parse tree
	 */
	void enterAnalysis_directive(T4Parser.Analysis_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#analysis_directive}.
	 * @param ctx the parse tree
	 */
	void exitAnalysis_directive(T4Parser.Analysis_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#conditional_compilation}.
	 * @param ctx the parse tree
	 */
	void enterConditional_compilation(T4Parser.Conditional_compilationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#conditional_compilation}.
	 * @param ctx the parse tree
	 */
	void exitConditional_compilation(T4Parser.Conditional_compilationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(T4Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(T4Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#feature_gate}.
	 * @param ctx the parse tree
	 */
	void enterFeature_gate(T4Parser.Feature_gateContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#feature_gate}.
	 * @param ctx the parse tree
	 */
	void exitFeature_gate(T4Parser.Feature_gateContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#feature_name}.
	 * @param ctx the parse tree
	 */
	void enterFeature_name(T4Parser.Feature_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#feature_name}.
	 * @param ctx the parse tree
	 */
	void exitFeature_name(T4Parser.Feature_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#property_access}.
	 * @param ctx the parse tree
	 */
	void enterProperty_access(T4Parser.Property_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#property_access}.
	 * @param ctx the parse tree
	 */
	void exitProperty_access(T4Parser.Property_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#property_name}.
	 * @param ctx the parse tree
	 */
	void enterProperty_name(T4Parser.Property_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#property_name}.
	 * @param ctx the parse tree
	 */
	void exitProperty_name(T4Parser.Property_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#computed_property}.
	 * @param ctx the parse tree
	 */
	void enterComputed_property(T4Parser.Computed_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#computed_property}.
	 * @param ctx the parse tree
	 */
	void exitComputed_property(T4Parser.Computed_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#computed_index_expr}.
	 * @param ctx the parse tree
	 */
	void enterComputed_index_expr(T4Parser.Computed_index_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#computed_index_expr}.
	 * @param ctx the parse tree
	 */
	void exitComputed_index_expr(T4Parser.Computed_index_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#chained_expression}.
	 * @param ctx the parse tree
	 */
	void enterChained_expression(T4Parser.Chained_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#chained_expression}.
	 * @param ctx the parse tree
	 */
	void exitChained_expression(T4Parser.Chained_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call(T4Parser.Method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call(T4Parser.Method_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#pipeline_expr}.
	 * @param ctx the parse tree
	 */
	void enterPipeline_expr(T4Parser.Pipeline_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#pipeline_expr}.
	 * @param ctx the parse tree
	 */
	void exitPipeline_expr(T4Parser.Pipeline_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#pipeline_op}.
	 * @param ctx the parse tree
	 */
	void enterPipeline_op(T4Parser.Pipeline_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#pipeline_op}.
	 * @param ctx the parse tree
	 */
	void exitPipeline_op(T4Parser.Pipeline_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#composition_expression}.
	 * @param ctx the parse tree
	 */
	void enterComposition_expression(T4Parser.Composition_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#composition_expression}.
	 * @param ctx the parse tree
	 */
	void exitComposition_expression(T4Parser.Composition_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#partial_app_expr}.
	 * @param ctx the parse tree
	 */
	void enterPartial_app_expr(T4Parser.Partial_app_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#partial_app_expr}.
	 * @param ctx the parse tree
	 */
	void exitPartial_app_expr(T4Parser.Partial_app_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#partial_app_args}.
	 * @param ctx the parse tree
	 */
	void enterPartial_app_args(T4Parser.Partial_app_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#partial_app_args}.
	 * @param ctx the parse tree
	 */
	void exitPartial_app_args(T4Parser.Partial_app_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#currying_expression}.
	 * @param ctx the parse tree
	 */
	void enterCurrying_expression(T4Parser.Currying_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#currying_expression}.
	 * @param ctx the parse tree
	 */
	void exitCurrying_expression(T4Parser.Currying_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#multi_arg_function}.
	 * @param ctx the parse tree
	 */
	void enterMulti_arg_function(T4Parser.Multi_arg_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#multi_arg_function}.
	 * @param ctx the parse tree
	 */
	void exitMulti_arg_function(T4Parser.Multi_arg_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#lazy_evaluation}.
	 * @param ctx the parse tree
	 */
	void enterLazy_evaluation(T4Parser.Lazy_evaluationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#lazy_evaluation}.
	 * @param ctx the parse tree
	 */
	void exitLazy_evaluation(T4Parser.Lazy_evaluationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#strict_evaluation}.
	 * @param ctx the parse tree
	 */
	void enterStrict_evaluation(T4Parser.Strict_evaluationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#strict_evaluation}.
	 * @param ctx the parse tree
	 */
	void exitStrict_evaluation(T4Parser.Strict_evaluationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#memoization}.
	 * @param ctx the parse tree
	 */
	void enterMemoization(T4Parser.MemoizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#memoization}.
	 * @param ctx the parse tree
	 */
	void exitMemoization(T4Parser.MemoizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#caching_expression}.
	 * @param ctx the parse tree
	 */
	void enterCaching_expression(T4Parser.Caching_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#caching_expression}.
	 * @param ctx the parse tree
	 */
	void exitCaching_expression(T4Parser.Caching_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#parallel_computation}.
	 * @param ctx the parse tree
	 */
	void enterParallel_computation(T4Parser.Parallel_computationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#parallel_computation}.
	 * @param ctx the parse tree
	 */
	void exitParallel_computation(T4Parser.Parallel_computationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#concurrent_expression}.
	 * @param ctx the parse tree
	 */
	void enterConcurrent_expression(T4Parser.Concurrent_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#concurrent_expression}.
	 * @param ctx the parse tree
	 */
	void exitConcurrent_expression(T4Parser.Concurrent_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#atomic_operation}.
	 * @param ctx the parse tree
	 */
	void enterAtomic_operation(T4Parser.Atomic_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#atomic_operation}.
	 * @param ctx the parse tree
	 */
	void exitAtomic_operation(T4Parser.Atomic_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#synchronized_block}.
	 * @param ctx the parse tree
	 */
	void enterSynchronized_block(T4Parser.Synchronized_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#synchronized_block}.
	 * @param ctx the parse tree
	 */
	void exitSynchronized_block(T4Parser.Synchronized_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#lock}.
	 * @param ctx the parse tree
	 */
	void enterLock(T4Parser.LockContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#lock}.
	 * @param ctx the parse tree
	 */
	void exitLock(T4Parser.LockContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#volatile_access}.
	 * @param ctx the parse tree
	 */
	void enterVolatile_access(T4Parser.Volatile_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#volatile_access}.
	 * @param ctx the parse tree
	 */
	void exitVolatile_access(T4Parser.Volatile_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#immutable_value}.
	 * @param ctx the parse tree
	 */
	void enterImmutable_value(T4Parser.Immutable_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#immutable_value}.
	 * @param ctx the parse tree
	 */
	void exitImmutable_value(T4Parser.Immutable_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#mutable_reference}.
	 * @param ctx the parse tree
	 */
	void enterMutable_reference(T4Parser.Mutable_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#mutable_reference}.
	 * @param ctx the parse tree
	 */
	void exitMutable_reference(T4Parser.Mutable_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#shared_reference}.
	 * @param ctx the parse tree
	 */
	void enterShared_reference(T4Parser.Shared_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#shared_reference}.
	 * @param ctx the parse tree
	 */
	void exitShared_reference(T4Parser.Shared_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#owned_value}.
	 * @param ctx the parse tree
	 */
	void enterOwned_value(T4Parser.Owned_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#owned_value}.
	 * @param ctx the parse tree
	 */
	void exitOwned_value(T4Parser.Owned_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#borrowed_reference}.
	 * @param ctx the parse tree
	 */
	void enterBorrowed_reference(T4Parser.Borrowed_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#borrowed_reference}.
	 * @param ctx the parse tree
	 */
	void exitBorrowed_reference(T4Parser.Borrowed_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#lifetime_annotation}.
	 * @param ctx the parse tree
	 */
	void enterLifetime_annotation(T4Parser.Lifetime_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#lifetime_annotation}.
	 * @param ctx the parse tree
	 */
	void exitLifetime_annotation(T4Parser.Lifetime_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#scope_expression}.
	 * @param ctx the parse tree
	 */
	void enterScope_expression(T4Parser.Scope_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#scope_expression}.
	 * @param ctx the parse tree
	 */
	void exitScope_expression(T4Parser.Scope_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#region_expression}.
	 * @param ctx the parse tree
	 */
	void enterRegion_expression(T4Parser.Region_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#region_expression}.
	 * @param ctx the parse tree
	 */
	void exitRegion_expression(T4Parser.Region_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#arena_allocation}.
	 * @param ctx the parse tree
	 */
	void enterArena_allocation(T4Parser.Arena_allocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#arena_allocation}.
	 * @param ctx the parse tree
	 */
	void exitArena_allocation(T4Parser.Arena_allocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#bump_allocation}.
	 * @param ctx the parse tree
	 */
	void enterBump_allocation(T4Parser.Bump_allocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#bump_allocation}.
	 * @param ctx the parse tree
	 */
	void exitBump_allocation(T4Parser.Bump_allocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#trace_expression}.
	 * @param ctx the parse tree
	 */
	void enterTrace_expression(T4Parser.Trace_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#trace_expression}.
	 * @param ctx the parse tree
	 */
	void exitTrace_expression(T4Parser.Trace_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#garbage_collection}.
	 * @param ctx the parse tree
	 */
	void enterGarbage_collection(T4Parser.Garbage_collectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#garbage_collection}.
	 * @param ctx the parse tree
	 */
	void exitGarbage_collection(T4Parser.Garbage_collectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#collection_strategy}.
	 * @param ctx the parse tree
	 */
	void enterCollection_strategy(T4Parser.Collection_strategyContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#collection_strategy}.
	 * @param ctx the parse tree
	 */
	void exitCollection_strategy(T4Parser.Collection_strategyContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#pinned_memory}.
	 * @param ctx the parse tree
	 */
	void enterPinned_memory(T4Parser.Pinned_memoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#pinned_memory}.
	 * @param ctx the parse tree
	 */
	void exitPinned_memory(T4Parser.Pinned_memoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link T4Parser#unpinned_memory}.
	 * @param ctx the parse tree
	 */
	void enterUnpinned_memory(T4Parser.Unpinned_memoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link T4Parser#unpinned_memory}.
	 * @param ctx the parse tree
	 */
	void exitUnpinned_memory(T4Parser.Unpinned_memoryContext ctx);
}