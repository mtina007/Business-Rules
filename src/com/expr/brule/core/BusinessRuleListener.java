// Generated from BusinessRule.g4 by ANTLR 4.5.3
package com.expr.brule.core;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BusinessRuleParser}.
 */
public interface BusinessRuleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(BusinessRuleParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(BusinessRuleParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BusinessRuleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BusinessRuleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(BusinessRuleParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(BusinessRuleParser.BinopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(BusinessRuleParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(BusinessRuleParser.CompopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#startofexpr}.
	 * @param ctx the parse tree
	 */
	void enterStartofexpr(BusinessRuleParser.StartofexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#startofexpr}.
	 * @param ctx the parse tree
	 */
	void exitStartofexpr(BusinessRuleParser.StartofexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#endofexpr}.
	 * @param ctx the parse tree
	 */
	void enterEndofexpr(BusinessRuleParser.EndofexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#endofexpr}.
	 * @param ctx the parse tree
	 */
	void exitEndofexpr(BusinessRuleParser.EndofexprContext ctx);
}