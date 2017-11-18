/**
 * 
 */
package com.expr.brule.editing;

import java.util.ArrayList;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import com.expr.brule.core.BusinessRuleBaseListener;
import com.expr.brule.core.BusinessRuleParser.ExprContext;

/**
 * @author ssdImmanuel
 *
 */
public class BaseRuleEditorTest extends BusinessRuleBaseListener {

	/**
	 * This the base rule editor
	 * The idea is to provide various editing features
	 * 1. replace lhs
	 * 2. replace rhs
	 * 3. replace comparator expression with unary
	 * 4. replace all AND to OR and vice versa
	 * 5. replace one comparator operator with another
	 * 
	 */
	protected TokenStreamRewriter rw;
	protected int ecnt=0;
	private ArrayList<String> al;
	protected int tcnt;
	protected String editedRule;
	
	public BaseRuleEditorTest(CommonTokenStream tokens) {
		rw = new TokenStreamRewriter(tokens);
	}
	
	
	@Override
	public void enterExpr(ExprContext ctx) {
		//System.out.println("Expr: "+ctx.getText());
		
		if(ctx.compop()!=null){
			this.ecnt++;
			rw.replace(ctx.start, ctx.stop, "true");
			System.out.println("Edited rule: "+rw.getText());
		}
		
	}
	
	
	public String getEditedRule(){
		return this.rw.getText();
	}
	
}
