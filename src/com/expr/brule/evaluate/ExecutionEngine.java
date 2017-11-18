/**
 * 
 */
package com.expr.brule.evaluate;

import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.expr.brule.core.BusinessRuleBaseVisitor;
import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.core.BusinessRuleParser;
import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.CompopContext;
import com.expr.brule.core.BusinessRuleParser.EndofexprContext;
import com.expr.brule.core.BusinessRuleParser.ExprContext;
import com.expr.brule.core.BusinessRuleParser.ParseContext;
import com.expr.brule.core.BusinessRuleParser.StartofexprContext;

/**
 * @author ssdImmanuel
 *
 */
public class ExecutionEngine extends BusinessRuleBaseVisitor<Object> {

	public ExecutionEngine(String rule, HashMap<String, Object> values) {
		this.rule = rule;
		this.values = values;
	}

	private String rule;
	private HashMap values;
	
	private Boolean result;

	public void evaluate() {
		BusinessRuleLexer lexer = new BusinessRuleLexer(new ANTLRInputStream(this.rule));
		BusinessRuleParser parser = new BusinessRuleParser(new CommonTokenStream(lexer));
		this.result = (Boolean) this.visit(parser.parse());
		
		System.out.println("Final outcome : "+result);
	}

	@Override
	public Object visitParse(ParseContext ctx) {
		System.out.println("visit parse: "+ctx.getText());
		boolean res = false;
		
		if(ctx.expr().startofexpr()==null){
			res = (boolean) super.visit(ctx);
		}else{
			res = (boolean) super.visit(ctx.expr());
		}
		
		System.out.println("after parse");
		return res;
	}

	
	
	@Override
	public Boolean visitExpr(ExprContext ctx) {

		if (ctx.compop() != null) {
			System.out.println("about to execute "+ctx.getText());
			boolean result = this.evaluateComparisonExpression(ctx);
			System.out.println("*** "+result);
			return result;
		}

		if (ctx.binop() != null) {

			System.out.println("Binary exp: " + ctx.binop().getText());
			System.out.println("*** " + ctx.expr(0).getText());
			System.out.println("*** " + ctx.expr(1).getText());
			boolean res = this.evaluateBoolean(ctx);
			System.out.println("before returning");
			return res;
		}
		
		System.out.println("outside..."+ctx.getText());
		//return (Boolean) super.visitExpr(ctx);
		return (Boolean) super.visit(ctx.expr(0));
	}

	@Override
	public Object visitBinop(BinopContext ctx) {
		return super.visitBinop(ctx);
	}

	@Override
	public Object visitCompop(CompopContext ctx) {
		return super.visitCompop(ctx);
	}
	
	@Override
	public Object visitStartofexpr(StartofexprContext ctx) {
		System.out.println("start of expr");
		return super.visitStartofexpr(ctx);
	}

	@Override
	public Object visitEndofexpr(EndofexprContext ctx) {
		System.out.println("end of expr");
		return super.visitEndofexpr(ctx);
	}

	private boolean evaluateBoolean(ExprContext ctx) {
		
		System.out.println("Before Evaluation of LHS "+ctx.expr(0).getText()+" ");
		//System.out.println("Test : "+this.visit(ctx.expr(0)));
		boolean leftoutcome =  (boolean) this.visit(ctx.expr(0));
		//boolean leftoutcome =  (boolean) this.visitExpr(ctx.expr(0));
		
		System.out.println("Before Evaluation of RHS "+ctx.expr(1).getText()+" ");
		boolean rightoutcome =  (boolean) this.visitExpr(ctx.expr(1));
		
		System.out.println("Evaluation of "+ctx.expr(0).getText()+" "+leftoutcome);
		System.out.println("Evaluation of "+ctx.expr(1).getText()+" "+rightoutcome);

		if (ctx.binop().AND() != null) {
			return (leftoutcome && rightoutcome);
		}

		if (ctx.binop().OR() != null) {
			System.out.println("Evaluating OR "+rightoutcome);
			return (leftoutcome || rightoutcome);
		}

		return false;
	}

	private boolean asBoolean(ExprContext ctx){
		return (boolean) this.visit(ctx);
	}
	
	private boolean evaluateComparisonExpression(ExprContext ctx) {
		String lhsvalue = ctx.lhs.getText();
		String rhsvalue = ctx.rhs.getText();
		Object lhsRuntimeValue;
		Object newrhsValue = rhsvalue.replaceAll("\"", "");

		lhsRuntimeValue = this.values.get(lhsvalue);
		if (lhsRuntimeValue == null) {
			lhsRuntimeValue = lhsvalue;
		}

		System.out.println("lhs: " + lhsvalue);
		System.out.println("sbs: "+values.get(lhsvalue));
		System.out.println("rhs: " + ctx.rhs.getText());

		if (ctx.compop().EQUAL() != null) {
			System.out.println("Outcome of expr "+ctx.getText()+" : "+lhsRuntimeValue.equals(rhsvalue));
			
			if(lhsRuntimeValue instanceof String) {
				
			}else if(lhsRuntimeValue instanceof Integer) {
				
			}
			return lhsRuntimeValue.equals(newrhsValue);
		}
		
		if(ctx.compop().GT()!=null) {
			
			
		}

		return lhsRuntimeValue.equals(rhsvalue);
	}

}
