// Generated from BusinessRule.g4 by ANTLR 4.5.3
package com.expr.brule.core;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BusinessRuleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, STRING=3, LEFTPAREN=4, RIGHTPAREN=5, EQUAL=6, LT=7, GT=8, 
		LTE=9, GTE=10, NE=11, AND=12, OR=13, VARIABLE=14, SPACE=15;
	public static final int
		RULE_parse = 0, RULE_expr = 1, RULE_binop = 2, RULE_compop = 3, RULE_startofexpr = 4, 
		RULE_endofexpr = 5;
	public static final String[] ruleNames = {
		"parse", "expr", "binop", "compop", "startofexpr", "endofexpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'('", "')'", null, null, null, "'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "STRING", "LEFTPAREN", "RIGHTPAREN", "EQUAL", "LT", 
		"GT", "LTE", "GTE", "NE", "AND", "OR", "VARIABLE", "SPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BusinessRule.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BusinessRuleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BusinessRuleParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			expr(0);
			setState(13);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Token lhs;
		public Token rhs;
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(BusinessRuleParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(BusinessRuleParser.VARIABLE, i);
		}
		public TerminalNode STRING() { return getToken(BusinessRuleParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(BusinessRuleParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BusinessRuleParser.FALSE, 0); }
		public StartofexprContext startofexpr() {
			return getRuleContext(StartofexprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EndofexprContext endofexpr() {
			return getRuleContext(EndofexprContext.class,0);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(16);
				((ExprContext)_localctx).lhs = match(VARIABLE);
				setState(17);
				compop();
				setState(18);
				((ExprContext)_localctx).rhs = match(VARIABLE);
				}
				break;
			case 2:
				{
				setState(20);
				((ExprContext)_localctx).lhs = match(VARIABLE);
				setState(21);
				compop();
				setState(22);
				((ExprContext)_localctx).rhs = match(STRING);
				}
				break;
			case 3:
				{
				setState(24);
				match(TRUE);
				}
				break;
			case 4:
				{
				setState(25);
				match(FALSE);
				}
				break;
			case 5:
				{
				setState(26);
				match(VARIABLE);
				}
				break;
			case 6:
				{
				setState(27);
				startofexpr();
				setState(28);
				expr(0);
				setState(29);
				endofexpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(33);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(34);
					binop();
					setState(35);
					expr(8);
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(BusinessRuleParser.AND, 0); }
		public TerminalNode OR() { return getToken(BusinessRuleParser.OR, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_binop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompopContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(BusinessRuleParser.EQUAL, 0); }
		public TerminalNode LT() { return getToken(BusinessRuleParser.LT, 0); }
		public TerminalNode GT() { return getToken(BusinessRuleParser.GT, 0); }
		public TerminalNode LTE() { return getToken(BusinessRuleParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(BusinessRuleParser.GTE, 0); }
		public TerminalNode NE() { return getToken(BusinessRuleParser.NE, 0); }
		public CompopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterCompop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitCompop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitCompop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompopContext compop() throws RecognitionException {
		CompopContext _localctx = new CompopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << LT) | (1L << GT) | (1L << LTE) | (1L << GTE) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartofexprContext extends ParserRuleContext {
		public TerminalNode LEFTPAREN() { return getToken(BusinessRuleParser.LEFTPAREN, 0); }
		public StartofexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startofexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterStartofexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitStartofexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitStartofexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartofexprContext startofexpr() throws RecognitionException {
		StartofexprContext _localctx = new StartofexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_startofexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(LEFTPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndofexprContext extends ParserRuleContext {
		public TerminalNode RIGHTPAREN() { return getToken(BusinessRuleParser.RIGHTPAREN, 0); }
		public EndofexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endofexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterEndofexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitEndofexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitEndofexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndofexprContext endofexpr() throws RecognitionException {
		EndofexprContext _localctx = new EndofexprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_endofexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(RIGHTPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\3\3\3\3\3\3\3\7"+
		"\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\2\3\4\b\2\4"+
		"\6\b\n\f\2\4\3\2\16\17\3\2\b\r\64\2\16\3\2\2\2\4!\3\2\2\2\6,\3\2\2\2\b"+
		".\3\2\2\2\n\60\3\2\2\2\f\62\3\2\2\2\16\17\5\4\3\2\17\20\7\2\2\3\20\3\3"+
		"\2\2\2\21\22\b\3\1\2\22\23\7\20\2\2\23\24\5\b\5\2\24\25\7\20\2\2\25\""+
		"\3\2\2\2\26\27\7\20\2\2\27\30\5\b\5\2\30\31\7\5\2\2\31\"\3\2\2\2\32\""+
		"\7\3\2\2\33\"\7\4\2\2\34\"\7\20\2\2\35\36\5\n\6\2\36\37\5\4\3\2\37 \5"+
		"\f\7\2 \"\3\2\2\2!\21\3\2\2\2!\26\3\2\2\2!\32\3\2\2\2!\33\3\2\2\2!\34"+
		"\3\2\2\2!\35\3\2\2\2\")\3\2\2\2#$\f\t\2\2$%\5\6\4\2%&\5\4\3\n&(\3\2\2"+
		"\2\'#\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2\2,-\t"+
		"\2\2\2-\7\3\2\2\2./\t\3\2\2/\t\3\2\2\2\60\61\7\6\2\2\61\13\3\2\2\2\62"+
		"\63\7\7\2\2\63\r\3\2\2\2\4!)";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}