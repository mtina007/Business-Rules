package com.expr.brule.editing;

import java.util.HashMap;

import org.antlr.v4.runtime.CommonTokenStream;

import com.expr.brule.core.BusinessRuleParser.CompopContext;
import com.expr.brule.core.BusinessRuleParser.ExprContext;

public class ExpressionReplaceEditor extends BaseReplaceEditor {

	public ExpressionReplaceEditor(CommonTokenStream tokens, HashMap rmap) {
		super(tokens, rmap);
	}

	private boolean replace=false;
	private RuleExpression save;
	@Override
	public void enterExpr(ExprContext ctx) {

		if (ctx.compop() != null) {
			RuleExpression exp = new RuleExpression(ctx.lhs.getText(), ctx.rhs.getText(), ctx.compop().getText());

			System.out.println(exp + "" + this.replaceMap.get(exp));
			if (this.replaceMap.get(exp) instanceof RuleExpression) {
				save = (RuleExpression) this.replaceMap.get(exp);
				rw.replace(ctx.lhs, save.getBusinessVariable());
				//rw.replace(ctx.compop().start, ctx.compop().stop, save.getOperator());
				rw.replace(ctx.rhs, save.getComparedValue());
				replace=true;
			}

		}

	}

	@Override
	public void enterCompop(CompopContext ctx) {
		//super.enterCompop(ctx);
		if(replace){
			rw.replace(ctx.start, " "+save.getOperator()+" ");
			replace=false;
		}else{
			super.enterCompop(ctx);
		}
	}
	
	
	

}
