/**
 * 
 */
package com.expr.brule.common;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
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
		CharStream stream = CharStreams.fromString(rule);
		BusinessRuleLexer lexer = new BusinessRuleLexer(stream);
		//lexer.removeErrorListeners();
		//lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new BusinessRuleParser(tokens);
		//parser.removeErrorListeners();
		//parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		
		rw = new TokenStreamRewriter(tokens);
		ParseContext ctx = parser.parse();
		ParseTreeWalker.DEFAULT.walk(this, ctx);
	}
	
	public String getLatestRule() {
		return rw.getText();
	}

}
