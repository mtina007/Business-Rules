/**
 * 
 */
package com.expr.brule.edits;

import java.util.HashMap;

import com.expr.brule.core.BusinessRuleParser.ExprContext;

/**
 * @author ssdImmanuel
 *
 */
public class RuleVariableEditor extends RuleEditSupport {

	public RuleVariableEditor(String rule, String lhs, String replacelhs) {
		this(rule,new HashMap());
		this.replaceMap.put(lhs, replacelhs);
	}
	
	public RuleVariableEditor(String rule, HashMap map) {
		super(rule, map);
	}

	@Override
	public void enterExpr(ExprContext ctx) {
		
		if(ctx.compop()!=null){
			String lhs = ctx.lhs.getText();
			if(this.replaceMap.containsKey(lhs)){
				this.rw.replace(ctx.lhs, " "+this.replaceMap.get(lhs)+" ");
			}
		}
		
	}

}
