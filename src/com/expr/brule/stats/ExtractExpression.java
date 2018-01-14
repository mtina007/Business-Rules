package com.expr.brule.stats;

import java.util.ArrayList;

import com.expr.brule.common.ParseWrapper;
import com.expr.brule.core.BusinessRuleParser.ExprContext;

public class ExtractExpression extends ParseWrapper {

	
	private ArrayList<RuleExpression> expressions;
	
	public ExtractExpression(String rule) {
		super(rule);
		setExpressions(new ArrayList<RuleExpression>());
	}

	public ArrayList<RuleExpression> getExpressions() {
		return expressions;
	}

	public void setExpressions(ArrayList<RuleExpression> expressions) {
		this.expressions = expressions;
	}

	@Override
	public void enterExpr(ExprContext ctx) {
		if(ctx.compop()!=null) {
			RuleExpression exp = new RuleExpression();
			exp.lhs = ctx.lhs.getText();
			exp.operator = ctx.compop().getText();
			exp.rhs = ctx.rhs.getText();
			expressions.add(exp);
		}
	}
	
	
}
