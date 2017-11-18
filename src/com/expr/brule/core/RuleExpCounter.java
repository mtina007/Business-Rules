/**
 * 
 */
package com.expr.brule.core;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.ExprContext;
import com.expr.brule.core.BusinessRuleParser.ParseContext;

/**
 * @author ssdImmanuel
 *
 */
public class RuleExpCounter extends BusinessRuleBaseListener {

	/**
	 * 
	 */
	private int expressionCounter=0;
	private int booleanOpCount=0;
	
	public RuleExpCounter() {
	}

	@Override
	public void enterParse(ParseContext ctx) {
		
	}

	@Override
	public void enterExpr(ExprContext ctx) {
		if(ctx.compop()!=null){
			this.expressionCounter++;
		}
	}
	
	@Override
	public void enterBinop(BinopContext ctx) {
		this.setBooleanOpCount(this.getBooleanOpCount() + 1);
	}

	public int getExpressionCounter() {
		return expressionCounter;
	}

	public void setExpressionCounter(int expressionCounter) {
		this.expressionCounter = expressionCounter;
	}

	public int getBooleanOpCount() {
		return booleanOpCount;
	}

	public void setBooleanOpCount(int booleanOpCount) {
		this.booleanOpCount = booleanOpCount;
	}
	
	

}
