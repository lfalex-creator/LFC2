// Generated from c:/Users/lupuf/Git-projects/LFC2/LFC2/OurCompiler.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OurCompilerParser}.
 */
public interface OurCompilerListener extends ParseTreeListener {
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
}