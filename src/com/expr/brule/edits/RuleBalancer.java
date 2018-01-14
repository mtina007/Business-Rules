/**
 * 
 */
package com.expr.brule.edits;

import com.expr.brule.common.ParseWrapper;
import com.expr.brule.core.BusinessRuleParser.ExprContext;

/**
 * @author ssdImmanuel
 *
 */
public class RuleBalancer extends ParseWrapper {

	/**
	 * @param rule
	 */
	public RuleBalancer(String rule) {
		super(rule);
	}
	
	private int openInsertCount=0;
	private int closeInsertCount=0;
	
	@Override
	public void enterExpr(ExprContext ctx) {
		if(ctx.compop()!=null) {
			//System.out.println(""+ctx.getParent().getClass());
			
			ExprContext par = (ExprContext) ctx.getParent();
			
			if(par.LEFTPAREN()==null) {
				rw.insertBefore(ctx.start, " ( ");
				openInsertCount++;
			}else {
				rw.replace(par.start, " ( ");
			}
			
			if(par.RIGHTPAREN()==null) {
				rw.insertAfter(ctx.stop, " ) ");
				closeInsertCount++;
			}else {
				rw.replace(par.stop, " ) ");
			}
		}
		
		if(ctx.binop()!=null) {
			//System.out.println(""+ctx.getParent().getClass());
			
			ExprContext par = (ExprContext) ctx.getParent();
			
			if(par.LEFTPAREN()==null) {
				rw.insertBefore(ctx.start, " ( ");
				openInsertCount++;
			}else {
				rw.replace(par.start, " ( ");
			}
			
			if(par.RIGHTPAREN()==null) {
				rw.insertAfter(ctx.stop, " ) ");
				closeInsertCount++;
			}else {
				rw.replace(par.stop, " ) ");
			}
		}
		
	}

	public int getOpenInsertCount() {
		return openInsertCount;
	}

	public void setOpenInsertCount(int openInsertCount) {
		this.openInsertCount = openInsertCount;
	}

	public int getCloseInsertCount() {
		return closeInsertCount;
	}

	public void setCloseInsertCount(int closeInsertCount) {
		this.closeInsertCount = closeInsertCount;
	}

}
