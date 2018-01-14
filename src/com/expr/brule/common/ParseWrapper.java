/**
 * 
 */
package com.expr.brule.common;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.expr.brule.core.BusinessRuleBaseListener;
import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.core.BusinessRuleParser;
import com.expr.brule.core.BusinessRuleParser.ParseContext;

/**
 * Base class which provides parse and AST Walk feature for 
 * a business rule
 * @author ssdImmanuel
 *
 */
public class ParseWrapper extends BusinessRuleBaseListener{

	/**
	 * 
	 */
	protected TokenStreamRewriter rw;
	protected BusinessRuleParser parser;
	
	private String rule;
	public ParseWrapper(String rule) {
		this.rule = rule;
	}
	
	public void parseRule() throws IOException{
		CharStream stream = new ANTLRInputStream(new StringReader(rule));
		BusinessRuleLexer lexer = new BusinessRuleLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new BusinessRuleParser(tokens);
		
		rw = new TokenStreamRewriter(tokens);
		ParseContext ctx = parser.parse();
		ParseTreeWalker.DEFAULT.walk(this, ctx);
	}
	
	public String getLatestRule() {
		return rw.getText();
	}

}
