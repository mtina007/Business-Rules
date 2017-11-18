/**
 * 
 */
package com.expr.brule.common;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.core.BusinessRuleParser;
import com.expr.brule.core.BusinessRuleParser.ParseContext;

/**
 * @author ssdImmanuel
 *
 */
public class ParseWrapper {

	/**
	 * 
	 */
	private String rule;
	public ParseWrapper(String rule) {
		this.rule = rule;
	}
	
	public void parseRule() throws IOException{
		CharStream stream = new ANTLRInputStream(new StringReader(rule));
		BusinessRuleLexer lexer = new BusinessRuleLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BusinessRuleParser parser = new BusinessRuleParser(tokens);
		
		ParseContext ctx = parser.parse();
	}

}
