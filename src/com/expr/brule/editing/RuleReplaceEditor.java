/**
 * 
 */
package com.expr.brule.editing;

import java.util.HashMap;

import org.antlr.v4.runtime.CommonTokenStream;

import com.expr.brule.core.BusinessRuleParser.ExprContext;

/**
 * @author ssdImmanuel
 *
 */
public class RuleReplaceEditor extends BaseRuleEditor {

	private HashMap<String,String> replaceMap= new HashMap<String, String>();
	
	public RuleReplaceEditor(CommonTokenStream tokens, String lhs, String replacelhs) {
		super(tokens);
		this.replaceMap.put(lhs, replacelhs);
	}
	
	public RuleReplaceEditor(CommonTokenStream tokens, int tcnt, HashMap map) {
		super(tokens);
		this.replaceMap.putAll(map);
	}

	@Override
	public void enterExpr(ExprContext ctx) {
		
		if(ctx.compop()!=null){
			String lhs = ctx.lhs.getText();
			//System.out.println("lhs: "+lhs);
			if(this.replaceMap.containsKey(lhs)){
				this.rw.replace(ctx.lhs, " "+this.replaceMap.get(lhs)+" ");
			}
		}
		
	}

}
