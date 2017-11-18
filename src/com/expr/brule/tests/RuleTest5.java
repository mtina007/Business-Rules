package com.expr.brule.tests;


import java.util.HashMap;

import com.expr.brule.evaluate.ExecutionEngine;

public class RuleTest5 {

	public static void main(String[] args) throws Exception {

		String rule = "( ( IND1 = Y)  OR ( IND2 = Y ) )";
		
		//rule = "( IND1 = Y OR (IND2 = N)";
		
		System.out.println("Input rule: "+rule);
		
		HashMap values = new HashMap();
		values.put("IND1", "Y");
		values.put("IND2", "Y");
		
		ExecutionEngine eng = new ExecutionEngine(rule, values);
		eng.evaluate();
		
	}

}
