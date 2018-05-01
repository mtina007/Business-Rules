/**
 * 
 */
package com.expr.brule.edits;

import java.util.ArrayList;

import com.expr.brule.common.ParseWrapper;
import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.ExprContext;
import com.expr.brule.core.BusinessRuleParser.StringExpressionContext;
import com.expr.brule.editing.RangeData;

/**
 * @author ssdImmanuel
 *
 */
public class RuleColoringData extends ParseWrapper {

	/**
	 * 
	 */
	private ArrayList<RangeData> tokenranges= new ArrayList<RangeData>();
	public RuleColoringData(String rule) {
		super(rule);
	}

	@Override
	public void enterBinop(BinopContext ctx) {
		
		RangeData data = new RangeData();
		data.tokenStart = ctx.start.getStartIndex();
		data.tokenLength= ctx.start.getText().length();
		
		data.tokenType = ctx.start.getType();
		this.tokenranges.add(data);
	}
	
	@Override
	public void enterStringExpression(StringExpressionContext ctx) {
		if(ctx.compop()!=null){
			RangeData data = new RangeData();
			data.tokenStart = ctx.compop().start.getStartIndex();
			data.tokenLength= ctx.compop().getText().length();
			
			data.tokenType = ctx.compop().start.getType();
			this.tokenranges.add(data);
			if(ctx.STRING()==null){
				return;
			}
			data = new RangeData();
			data.tokenStart = ctx.rhs.getStartIndex();
			data.tokenLength= ctx.rhs.getText().length();
			
			data.tokenType = ctx.rhs.getType();
			this.tokenranges.add(data);
		}
	}


	public ArrayList<RangeData> getTokenranges() {
		return tokenranges;
	}

	public void setTokenranges(ArrayList<RangeData> tokenranges) {
		this.tokenranges = tokenranges;
	}
	
}
