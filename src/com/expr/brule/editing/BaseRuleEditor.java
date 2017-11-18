/**
 * 
 */
package com.expr.brule.editing;

import java.util.ArrayList;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import com.expr.brule.core.BusinessRuleBaseListener;
import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.CompopContext;
import com.expr.brule.core.BusinessRuleParser.EndofexprContext;
import com.expr.brule.core.BusinessRuleParser.ExprContext;
import com.expr.brule.core.BusinessRuleParser.StartofexprContext;

/**
 * @author ssdImmanuel
 *
 */
public class BaseRuleEditor extends BusinessRuleBaseListener {

	/**
	 * This the base rule editor The idea is to provide various editing features
	 * 1. replace lhs 
	 * 2. replace rhs 
	 * 3. replace comparator expression with unary
	 * 4. replace all AND to OR and vice versa 
	 * 5. replace one comparator
	 * operator with another
	 * 
	 */
	protected TokenStreamRewriter rw;
	protected int ecnt = 0;
	private ArrayList<String> al;
	protected int tcnt;
	protected String editedRule;

	public BaseRuleEditor(CommonTokenStream tokens) {
		rw = new TokenStreamRewriter(tokens);
	}

	@Override
	public void enterExpr(ExprContext ctx) {

		if (ctx.lhs != null) {
			rw.replace(ctx.lhs, " " + ctx.lhs.getText() + " ");
			rw.replace(ctx.rhs, " " + ctx.rhs.getText() + " ");
		}

	}

	@Override
	public void enterBinop(BinopContext ctx) {
		rw.replace(ctx.start, " " + ctx.getText() + " ");
	}

	@Override
	public void enterCompop(CompopContext ctx) {
		rw.replace(ctx.start, " " + ctx.getText() + " ");
	}

	
	@Override
	public void enterEndofexpr(EndofexprContext ctx) {
		rw.replace(ctx.start, " " + ctx.getText() + " ");
	}

	@Override
	public void enterStartofexpr(StartofexprContext ctx) {
		rw.replace(ctx.start, " " + ctx.getText() + " ");
	}

	public String getEditedRule() {
		return this.rw.getText();
	}

}
