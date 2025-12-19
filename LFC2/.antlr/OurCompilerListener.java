// Generated from c:/Users/gheor/Desktop/Facultate/Anul II/LFC/LFC2/LFC2/OurCompiler.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OurCompilerParser}.
 */
public interface OurCompilerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#pure_data}.
	 * @param ctx the parse tree
	 */
	void enterPure_data(OurCompilerParser.Pure_dataContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#pure_data}.
	 * @param ctx the parse tree
	 */
	void exitPure_data(OurCompilerParser.Pure_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterData_type(OurCompilerParser.Data_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitData_type(OurCompilerParser.Data_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#any_math_operator}.
	 * @param ctx the parse tree
	 */
	void enterAny_math_operator(OurCompilerParser.Any_math_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#any_math_operator}.
	 * @param ctx the parse tree
	 */
	void exitAny_math_operator(OurCompilerParser.Any_math_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#math_expr}.
	 * @param ctx the parse tree
	 */
	void enterMath_expr(OurCompilerParser.Math_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#math_expr}.
	 * @param ctx the parse tree
	 */
	void exitMath_expr(OurCompilerParser.Math_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#comp_val}.
	 * @param ctx the parse tree
	 */
	void enterComp_val(OurCompilerParser.Comp_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#comp_val}.
	 * @param ctx the parse tree
	 */
	void exitComp_val(OurCompilerParser.Comp_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#comparer}.
	 * @param ctx the parse tree
	 */
	void enterComparer(OurCompilerParser.ComparerContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#comparer}.
	 * @param ctx the parse tree
	 */
	void exitComparer(OurCompilerParser.ComparerContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#logic_link}.
	 * @param ctx the parse tree
	 */
	void enterLogic_link(OurCompilerParser.Logic_linkContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#logic_link}.
	 * @param ctx the parse tree
	 */
	void exitLogic_link(OurCompilerParser.Logic_linkContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogic_expr(OurCompilerParser.Logic_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogic_expr(OurCompilerParser.Logic_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#crement_expr}.
	 * @param ctx the parse tree
	 */
	void enterCrement_expr(OurCompilerParser.Crement_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#crement_expr}.
	 * @param ctx the parse tree
	 */
	void exitCrement_expr(OurCompilerParser.Crement_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(OurCompilerParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(OurCompilerParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(OurCompilerParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(OurCompilerParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#expression_generator}.
	 * @param ctx the parse tree
	 */
	void enterExpression_generator(OurCompilerParser.Expression_generatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#expression_generator}.
	 * @param ctx the parse tree
	 */
	void exitExpression_generator(OurCompilerParser.Expression_generatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(OurCompilerParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(OurCompilerParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#var_declar_expr}.
	 * @param ctx the parse tree
	 */
	void enterVar_declar_expr(OurCompilerParser.Var_declar_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#var_declar_expr}.
	 * @param ctx the parse tree
	 */
	void exitVar_declar_expr(OurCompilerParser.Var_declar_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#var_assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterVar_assign_expr(OurCompilerParser.Var_assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#var_assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitVar_assign_expr(OurCompilerParser.Var_assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#var_decl_assg_expr}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_assg_expr(OurCompilerParser.Var_decl_assg_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#var_decl_assg_expr}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_assg_expr(OurCompilerParser.Var_decl_assg_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void enterIf_expr(OurCompilerParser.If_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void exitIf_expr(OurCompilerParser.If_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#for_expr}.
	 * @param ctx the parse tree
	 */
	void enterFor_expr(OurCompilerParser.For_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#for_expr}.
	 * @param ctx the parse tree
	 */
	void exitFor_expr(OurCompilerParser.For_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#while_expr}.
	 * @param ctx the parse tree
	 */
	void enterWhile_expr(OurCompilerParser.While_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#while_expr}.
	 * @param ctx the parse tree
	 */
	void exitWhile_expr(OurCompilerParser.While_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#return_expr}.
	 * @param ctx the parse tree
	 */
	void enterReturn_expr(OurCompilerParser.Return_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#return_expr}.
	 * @param ctx the parse tree
	 */
	void exitReturn_expr(OurCompilerParser.Return_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurCompilerParser#function_call_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call_expr(OurCompilerParser.Function_call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurCompilerParser#function_call_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call_expr(OurCompilerParser.Function_call_exprContext ctx);
}