// Generated from BusinessRule.g4 by ANTLR 4.5.3
package com.expr.brule.core;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BusinessRuleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BusinessRuleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(BusinessRuleParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(BusinessRuleParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop(BusinessRuleParser.BinopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#compop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompop(BusinessRuleParser.CompopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#startofexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartofexpr(BusinessRuleParser.StartofexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#endofexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndofexpr(BusinessRuleParser.EndofexprContext ctx);
}