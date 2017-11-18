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
import com.expr.brule.editing.ExpressionReplaceEditor;
import com.expr.brule.editing.RuleExpression;

public class RuleTest4 {

	public static void main(String[] args) throws Exception {

		String rule = "( ( ( AMOUNT > 200000.00) AND ( IND1 = Y) ) or ( ind1 = Y ) )";
		CharStream stream = new ANTLRInputStream(new StringReader(rule));
		BusinessRuleLexer lexer = new BusinessRuleLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BusinessRuleParser parser = new BusinessRuleParser(tokens);
		
		ParseContext ctx = parser.parse();
		
		System.out.println("Input rule: "+rule);

		RuleExpression orig = new RuleExpression("AMOUNT","200000.00",">");
		RuleExpression repl = new RuleExpression("AMOUNT-1","400000.00","<");
		
		RuleExpression o1 = new RuleExpression("IND1","Y","=");
		RuleExpression r1 = new RuleExpression("IND22","Z","=");
		
		HashMap rmap = new HashMap();
		rmap.put(orig, repl);
		rmap.put(o1, r1);
		ExpressionReplaceEditor edit = new ExpressionReplaceEditor(tokens,rmap);
		ParseTreeWalker.DEFAULT.walk(edit, ctx);
		
		System.out.println("Edited rule: "+edit.getEditedRule());
	}

}
