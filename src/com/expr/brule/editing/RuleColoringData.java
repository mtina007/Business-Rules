/**
 * 
 */
package com.expr.brule.editing;

import java.util.ArrayList;

import com.expr.brule.core.BusinessRuleBaseListener;
import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.EndofexprContext;
import com.expr.brule.core.BusinessRuleParser.ExprContext;
import com.expr.brule.core.BusinessRuleParser.StartofexprContext;

/**
 * @author ssdImmanuel
 *
 */
public class RuleColoringData extends BusinessRuleBaseListener {

	/**
	 * 
	 */
	private ArrayList<RangeData> tokenranges= new ArrayList<RangeData>();
	public RuleColoringData() {
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
	public void enterStartofexpr(StartofexprContext ctx) {
		RangeData data = new RangeData();
		data.tokenStart = ctx.start.getStartIndex();
		data.tokenLength= ctx.start.getText().length();
		
		data.tokenType = ctx.start.getType();
		this.tokenranges.add(data);
	}

	@Override
	public void enterEndofexpr(EndofexprContext ctx) {
		RangeData data = new RangeData();
		data.tokenStart = ctx.start.getStartIndex();
		data.tokenLength= ctx.start.getText().length();
		
		data.tokenType = ctx.start.getType();
		this.tokenranges.add(data);
	}

	
	@Override
	public void enterExpr(ExprContext ctx) {
		if(ctx.compop()!=null){
			if(ctx.STRING()==null){
				return;
			}
			RangeData data = new RangeData();
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
