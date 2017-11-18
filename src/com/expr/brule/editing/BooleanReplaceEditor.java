package com.expr.brule.editing;

import org.antlr.v4.runtime.CommonTokenStream;

import com.expr.brule.core.BusinessRuleParser.BinopContext;

public class BooleanReplaceEditor extends BaseRuleEditor {

	private String oldop;
	private String newop;
	public BooleanReplaceEditor(CommonTokenStream tokens, String oldop, String newop) {
		super(tokens);
		this.oldop=oldop;
		this.newop = newop;
	}


	@Override
	public void enterBinop(BinopContext ctx) {
		String currop = ctx.getText();
		if(currop.equals(this.oldop)){
			rw.replace(ctx.start, ctx.stop, newop);
		}
	}

	
	
}
