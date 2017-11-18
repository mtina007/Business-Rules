package com.expr.brule.tests;

import java.io.StringReader;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.core.BusinessRuleParser;
import com.expr.brule.core.BusinessRuleParser.ParseContext;
import com.expr.brule.editing.RuleReplaceEditor;

public class RuleTest2 {

	public static void main(String[] args) throws Exception {

		String rule = "( ( ( AMOUNT > 200000.00) AND ( IND1 = Y) ) or ( ind1 = N ) )";
		CharStream stream = new ANTLRInputStream(new StringReader(rule));
		BusinessRuleLexer lexer = new BusinessRuleLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BusinessRuleParser parser = new BusinessRuleParser(tokens);
		
		ParseContext ctx = parser.parse();
		
		System.out.println("Input rule:"+ctx.getText());

		/*
		 * Replace with single input
		 */
		RuleReplaceEditor rep = new RuleReplaceEditor(tokens, "AMOUNT", "CASH");
		ParseTreeWalker.DEFAULT.walk(rep, ctx);
		
		System.out.println("Single input : "+rep.getEditedRule());
		
		HashMap input = new HashMap();
		input.put("AMOUNT", "CASHVALUE");
		input.put("IND1", "IND2");
		RuleReplaceEditor repmult = new RuleReplaceEditor(tokens, 0,input);
		ParseTreeWalker.DEFAULT.walk(repmult, ctx);
		System.out.println("Map input: "+repmult.getEditedRule());
	}

}
