package com.expr.brule.editing;

import java.util.HashMap;

import org.antlr.v4.runtime.CommonTokenStream;

import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.CompopContext;

public class BaseReplaceEditor extends BaseRuleEditor {

	protected HashMap<Object, Object> replaceMap = new HashMap();
	public BaseReplaceEditor(CommonTokenStream tokens,HashMap rmap) {
		super(tokens);
		this.replaceMap = rmap;
	}
	@Override
	public void enterBinop(BinopContext ctx) {
		// TODO Auto-generated method stub
		super.enterBinop(ctx);
	}
	@Override
	public void enterCompop(CompopContext ctx) {
		// TODO Auto-generated method stub
		super.enterCompop(ctx);
	}
	
	
}
