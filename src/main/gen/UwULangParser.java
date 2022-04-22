// Generated from /home/foo/synced/uwu-lang/src/main/kotlin/UwULang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UwULangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, INTEGER=4, FLOAT=5, WS=6, OPEN_PAREN=7, CLOSE_PAREN=8, 
		OPEN_BRACE=9, CLOSE_BRACE=10, SEMICOLON=11, COLON=12, STRING_LITERAL=13, 
		STRUCT=14, FUN=15, STATIC=16, NEW=17, IF=18, WHILE=19, LET=20, MUT=21, 
		IMPORT=22, RETURN=23, IDENTIFIER=24, KEYWORD=25, PLUS=26, MINUS=27, TIMES=28, 
		DIVIDE=29;
	public static final int
		RULE_nameTypePair = 0, RULE_struct = 1, RULE_fieldAccess = 2, RULE_functionInvocation = 3, 
		RULE_methodInvocation = 4, RULE_addOp = 5, RULE_mulOp = 6, RULE_expression = 7, 
		RULE_statement = 8, RULE_fieldAssign = 9, RULE_ifStatement = 10, RULE_whileLoop = 11, 
		RULE_variableAssign = 12, RULE_multiStatement = 13, RULE_fun = 14, RULE_impt = 15, 
		RULE_new = 16, RULE_file = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"nameTypePair", "struct", "fieldAccess", "functionInvocation", "methodInvocation", 
			"addOp", "mulOp", "expression", "statement", "fieldAssign", "ifStatement", 
			"whileLoop", "variableAssign", "multiStatement", "fun", "impt", "new", 
			"file"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'='", null, null, null, "'('", "')'", "'{'", "'}'", 
			"';'", "':'", null, "'stwuct'", "'fuwn'", "'static'", "'new'", "'if'", 
			"'whiwe'", "'wet'", "'mewt'", "'impowt'", "'wetuwn'", null, null, "'+'", 
			"'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "INTEGER", "FLOAT", "WS", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", "COLON", "STRING_LITERAL", 
			"STRUCT", "FUN", "STATIC", "NEW", "IF", "WHILE", "LET", "MUT", "IMPORT", 
			"RETURN", "IDENTIFIER", "KEYWORD", "PLUS", "MINUS", "TIMES", "DIVIDE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "UwULang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UwULangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class NameTypePairContext extends ParserRuleContext {
		public Token name;
		public Token type;
		public TerminalNode COLON() { return getToken(UwULangParser.COLON, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public NameTypePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameTypePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterNameTypePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitNameTypePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitNameTypePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameTypePairContext nameTypePair() throws RecognitionException {
		NameTypePairContext _localctx = new NameTypePairContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_nameTypePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((NameTypePairContext)_localctx).name = match(IDENTIFIER);
			setState(37);
			match(COLON);
			setState(38);
			((NameTypePairContext)_localctx).type = match(IDENTIFIER);
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

	public static class StructContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(UwULangParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<NameTypePairContext> nameTypePair() {
			return getRuleContexts(NameTypePairContext.class);
		}
		public NameTypePairContext nameTypePair(int i) {
			return getRuleContext(NameTypePairContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_struct);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(STRUCT);
			setState(41);
			match(IDENTIFIER);
			setState(42);
			match(OPEN_BRACE);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					nameTypePair();
					setState(44);
					match(T__0);
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(51);
				nameTypePair();
				setState(52);
				match(SEMICOLON);
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN || _la==STATIC) {
				{
				{
				setState(56);
				fun();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(CLOSE_BRACE);
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

	public static class FieldAccessContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFieldAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fieldAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__1);
			setState(65);
			match(IDENTIFIER);
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

	public static class FunctionInvocationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionInvocation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(IDENTIFIER);
			setState(68);
			match(OPEN_PAREN);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(69);
					expression(0);
					setState(70);
					match(T__0);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(77);
				expression(0);
				}
			}

			setState(80);
			match(CLOSE_PAREN);
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

	public static class MethodInvocationContext extends ParserRuleContext {
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__1);
			setState(83);
			functionInvocation();
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

	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(UwULangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(UwULangParser.MINUS, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitAddOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(UwULangParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(UwULangParser.DIVIDE, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterMulOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitMulOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitMulOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !(_la==TIMES || _la==DIVIDE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode INTEGER() { return getToken(UwULangParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(UwULangParser.FLOAT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(UwULangParser.STRING_LITERAL, 0); }
		public NewContext new_() {
			return getRuleContext(NewContext.class,0);
		}
		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class,0);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(90);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(91);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(92);
				match(OPEN_PAREN);
				setState(93);
				expression(0);
				setState(94);
				match(CLOSE_PAREN);
				}
				break;
			case 4:
				{
				setState(96);
				match(INTEGER);
				}
				break;
			case 5:
				{
				setState(97);
				match(FLOAT);
				}
				break;
			case 6:
				{
				setState(98);
				match(STRING_LITERAL);
				}
				break;
			case 7:
				{
				setState(99);
				new_();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(103);
						mulOp();
						setState(104);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(107);
						addOp();
						setState(108);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(111);
						fieldAccess();
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(112);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(113);
						methodInvocation();
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public VariableAssignContext variableAssign() {
			return getRuleContext(VariableAssignContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(UwULangParser.RETURN, 0); }
		public FieldAssignContext fieldAssign() {
			return getRuleContext(FieldAssignContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				whileLoop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(121);
				variableAssign();
				setState(122);
				match(SEMICOLON);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(124);
				expression(0);
				setState(125);
				match(SEMICOLON);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(127);
				match(RETURN);
				setState(128);
				expression(0);
				setState(129);
				match(SEMICOLON);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(131);
				fieldAssign();
				setState(132);
				match(SEMICOLON);
				}
				}
				break;
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

	public static class FieldAssignContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public FieldAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFieldAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFieldAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFieldAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAssignContext fieldAssign() throws RecognitionException {
		FieldAssignContext _localctx = new FieldAssignContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fieldAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			expression(0);
			setState(137);
			match(T__1);
			setState(138);
			match(IDENTIFIER);
			setState(139);
			match(T__2);
			setState(140);
			expression(0);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(UwULangParser.IF, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(IF);
			setState(143);
			match(OPEN_PAREN);
			setState(144);
			expression(0);
			setState(145);
			match(CLOSE_PAREN);
			setState(146);
			match(OPEN_BRACE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(147);
				statement();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(CLOSE_BRACE);
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

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(UwULangParser.WHILE, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(WHILE);
			setState(156);
			match(OPEN_PAREN);
			setState(157);
			expression(0);
			setState(158);
			match(CLOSE_PAREN);
			setState(159);
			match(OPEN_BRACE);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(160);
				statement();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
			match(CLOSE_BRACE);
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

	public static class VariableAssignContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LET() { return getToken(UwULangParser.LET, 0); }
		public TerminalNode MUT() { return getToken(UwULangParser.MUT, 0); }
		public VariableAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterVariableAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitVariableAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitVariableAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignContext variableAssign() throws RecognitionException {
		VariableAssignContext _localctx = new VariableAssignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET || _la==MUT) {
				{
				setState(168);
				_la = _input.LA(1);
				if ( !(_la==LET || _la==MUT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(171);
			match(IDENTIFIER);
			setState(172);
			match(T__2);
			setState(173);
			expression(0);
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

	public static class MultiStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MultiStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterMultiStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitMultiStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitMultiStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiStatementContext multiStatement() throws RecognitionException {
		MultiStatementContext _localctx = new MultiStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(175);
				statement();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FunContext extends ParserRuleContext {
		public Token name;
		public Token returnType;
		public TerminalNode FUN() { return getToken(UwULangParser.FUN, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public MultiStatementContext multiStatement() {
			return getRuleContext(MultiStatementContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public TerminalNode STATIC() { return getToken(UwULangParser.STATIC, 0); }
		public List<NameTypePairContext> nameTypePair() {
			return getRuleContexts(NameTypePairContext.class);
		}
		public NameTypePairContext nameTypePair(int i) {
			return getRuleContext(NameTypePairContext.class,i);
		}
		public TerminalNode COLON() { return getToken(UwULangParser.COLON, 0); }
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fun);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(181);
				match(STATIC);
				}
			}

			setState(184);
			match(FUN);
			setState(185);
			((FunContext)_localctx).name = match(IDENTIFIER);
			setState(186);
			match(OPEN_PAREN);
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(187);
					nameTypePair();
					setState(188);
					match(T__0);
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(195);
				nameTypePair();
				}
			}

			setState(198);
			match(CLOSE_PAREN);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(199);
				match(COLON);
				setState(200);
				((FunContext)_localctx).returnType = match(IDENTIFIER);
				}
			}

			setState(203);
			match(OPEN_BRACE);
			setState(204);
			multiStatement();
			setState(205);
			match(CLOSE_BRACE);
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

	public static class ImptContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(UwULangParser.IMPORT, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public ImptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterImpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitImpt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitImpt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImptContext impt() throws RecognitionException {
		ImptContext _localctx = new ImptContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_impt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(IMPORT);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					match(IDENTIFIER);
					setState(209);
					match(T__1);
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(215);
			match(IDENTIFIER);
			setState(216);
			match(SEMICOLON);
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

	public static class NewContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(UwULangParser.NEW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewContext new_() throws RecognitionException {
		NewContext _localctx = new NewContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_new);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(NEW);
			setState(219);
			match(IDENTIFIER);
			setState(220);
			match(OPEN_PAREN);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(221);
				expression(0);
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(CLOSE_PAREN);
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

	public static class FileContext extends ParserRuleContext {
		public List<ImptContext> impt() {
			return getRuleContexts(ImptContext.class);
		}
		public ImptContext impt(int i) {
			return getRuleContext(ImptContext.class,i);
		}
		public List<StructContext> struct() {
			return getRuleContexts(StructContext.class);
		}
		public StructContext struct(int i) {
			return getRuleContext(StructContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(229);
				impt();
				}
				}
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCT) {
				{
				{
				setState(234);
				struct();
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00f1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001/\b\u0001\n\u0001\f\u00012\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00017\b\u0001\u0001"+
		"\u0001\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003I\b\u0003\n\u0003\f\u0003L\t"+
		"\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007e\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007s\b\u0007\n\u0007\f\u0007v\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0087\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u0095\b\n\n\n\f\n\u0098\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00a2\b\u000b\n\u000b\f\u000b\u00a5\t\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0003\f\u00aa\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0005\r\u00b1"+
		"\b\r\n\r\f\r\u00b4\t\r\u0001\u000e\u0003\u000e\u00b7\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00bf\b\u000e\n\u000e\f\u000e\u00c2\t\u000e\u0001\u000e\u0003\u000e\u00c5"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ca\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u00d3\b\u000f\n\u000f\f\u000f\u00d6\t\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00df\b\u0010\n\u0010\f\u0010\u00e2\t\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0004\u0011\u00e7\b\u0011\u000b\u0011\f\u0011"+
		"\u00e8\u0001\u0011\u0005\u0011\u00ec\b\u0011\n\u0011\f\u0011\u00ef\t\u0011"+
		"\u0001\u0011\u0000\u0001\u000e\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0003\u0001"+
		"\u0000\u001a\u001b\u0001\u0000\u001c\u001d\u0001\u0000\u0014\u0015\u00fe"+
		"\u0000$\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004@"+
		"\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bR\u0001\u0000"+
		"\u0000\u0000\nU\u0001\u0000\u0000\u0000\fW\u0001\u0000\u0000\u0000\u000e"+
		"d\u0001\u0000\u0000\u0000\u0010\u0086\u0001\u0000\u0000\u0000\u0012\u0088"+
		"\u0001\u0000\u0000\u0000\u0014\u008e\u0001\u0000\u0000\u0000\u0016\u009b"+
		"\u0001\u0000\u0000\u0000\u0018\u00a9\u0001\u0000\u0000\u0000\u001a\u00b2"+
		"\u0001\u0000\u0000\u0000\u001c\u00b6\u0001\u0000\u0000\u0000\u001e\u00cf"+
		"\u0001\u0000\u0000\u0000 \u00da\u0001\u0000\u0000\u0000\"\u00e6\u0001"+
		"\u0000\u0000\u0000$%\u0005\u0018\u0000\u0000%&\u0005\f\u0000\u0000&\'"+
		"\u0005\u0018\u0000\u0000\'\u0001\u0001\u0000\u0000\u0000()\u0005\u000e"+
		"\u0000\u0000)*\u0005\u0018\u0000\u0000*0\u0005\t\u0000\u0000+,\u0003\u0000"+
		"\u0000\u0000,-\u0005\u0001\u0000\u0000-/\u0001\u0000\u0000\u0000.+\u0001"+
		"\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000016\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000034\u0003\u0000\u0000\u000045\u0005\u000b\u0000\u000057\u0001\u0000"+
		"\u0000\u000063\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u00007;\u0001"+
		"\u0000\u0000\u00008:\u0003\u001c\u000e\u000098\u0001\u0000\u0000\u0000"+
		":=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005\n\u0000"+
		"\u0000?\u0003\u0001\u0000\u0000\u0000@A\u0005\u0002\u0000\u0000AB\u0005"+
		"\u0018\u0000\u0000B\u0005\u0001\u0000\u0000\u0000CD\u0005\u0018\u0000"+
		"\u0000DJ\u0005\u0007\u0000\u0000EF\u0003\u000e\u0007\u0000FG\u0005\u0001"+
		"\u0000\u0000GI\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000IL\u0001"+
		"\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MO\u0003\u000e\u0007"+
		"\u0000NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PQ\u0005\b\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000RS\u0005"+
		"\u0002\u0000\u0000ST\u0003\u0006\u0003\u0000T\t\u0001\u0000\u0000\u0000"+
		"UV\u0007\u0000\u0000\u0000V\u000b\u0001\u0000\u0000\u0000WX\u0007\u0001"+
		"\u0000\u0000X\r\u0001\u0000\u0000\u0000YZ\u0006\u0007\uffff\uffff\u0000"+
		"Ze\u0005\u0018\u0000\u0000[e\u0003\u0006\u0003\u0000\\]\u0005\u0007\u0000"+
		"\u0000]^\u0003\u000e\u0007\u0000^_\u0005\b\u0000\u0000_e\u0001\u0000\u0000"+
		"\u0000`e\u0005\u0004\u0000\u0000ae\u0005\u0005\u0000\u0000be\u0005\r\u0000"+
		"\u0000ce\u0003 \u0010\u0000dY\u0001\u0000\u0000\u0000d[\u0001\u0000\u0000"+
		"\u0000d\\\u0001\u0000\u0000\u0000d`\u0001\u0000\u0000\u0000da\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000et\u0001"+
		"\u0000\u0000\u0000fg\n\u0003\u0000\u0000gh\u0003\f\u0006\u0000hi\u0003"+
		"\u000e\u0007\u0004is\u0001\u0000\u0000\u0000jk\n\u0002\u0000\u0000kl\u0003"+
		"\n\u0005\u0000lm\u0003\u000e\u0007\u0003ms\u0001\u0000\u0000\u0000no\n"+
		"\n\u0000\u0000os\u0003\u0004\u0002\u0000pq\n\t\u0000\u0000qs\u0003\b\u0004"+
		"\u0000rf\u0001\u0000\u0000\u0000rj\u0001\u0000\u0000\u0000rn\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u000f\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000w\u0087\u0003\u0014\n\u0000x\u0087\u0003"+
		"\u0016\u000b\u0000yz\u0003\u0018\f\u0000z{\u0005\u000b\u0000\u0000{\u0087"+
		"\u0001\u0000\u0000\u0000|}\u0003\u000e\u0007\u0000}~\u0005\u000b\u0000"+
		"\u0000~\u0087\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0017\u0000\u0000"+
		"\u0080\u0081\u0003\u000e\u0007\u0000\u0081\u0082\u0005\u000b\u0000\u0000"+
		"\u0082\u0087\u0001\u0000\u0000\u0000\u0083\u0084\u0003\u0012\t\u0000\u0084"+
		"\u0085\u0005\u000b\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086"+
		"w\u0001\u0000\u0000\u0000\u0086x\u0001\u0000\u0000\u0000\u0086y\u0001"+
		"\u0000\u0000\u0000\u0086|\u0001\u0000\u0000\u0000\u0086\u007f\u0001\u0000"+
		"\u0000\u0000\u0086\u0083\u0001\u0000\u0000\u0000\u0087\u0011\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0003\u000e\u0007\u0000\u0089\u008a\u0005\u0002"+
		"\u0000\u0000\u008a\u008b\u0005\u0018\u0000\u0000\u008b\u008c\u0005\u0003"+
		"\u0000\u0000\u008c\u008d\u0003\u000e\u0007\u0000\u008d\u0013\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0005\u0012\u0000\u0000\u008f\u0090\u0005\u0007"+
		"\u0000\u0000\u0090\u0091\u0003\u000e\u0007\u0000\u0091\u0092\u0005\b\u0000"+
		"\u0000\u0092\u0096\u0005\t\u0000\u0000\u0093\u0095\u0003\u0010\b\u0000"+
		"\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000"+
		"\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005\n\u0000\u0000\u009a\u0015\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0005\u0013\u0000\u0000\u009c\u009d\u0005\u0007\u0000\u0000\u009d"+
		"\u009e\u0003\u000e\u0007\u0000\u009e\u009f\u0005\b\u0000\u0000\u009f\u00a3"+
		"\u0005\t\u0000\u0000\u00a0\u00a2\u0003\u0010\b\u0000\u00a1\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005"+
		"\n\u0000\u0000\u00a7\u0017\u0001\u0000\u0000\u0000\u00a8\u00aa\u0007\u0002"+
		"\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0018"+
		"\u0000\u0000\u00ac\u00ad\u0005\u0003\u0000\u0000\u00ad\u00ae\u0003\u000e"+
		"\u0007\u0000\u00ae\u0019\u0001\u0000\u0000\u0000\u00af\u00b1\u0003\u0010"+
		"\b\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b3\u001b\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b7\u0005\u0010\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0005\u000f\u0000\u0000\u00b9\u00ba\u0005\u0018\u0000"+
		"\u0000\u00ba\u00c0\u0005\u0007\u0000\u0000\u00bb\u00bc\u0003\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0001\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000"+
		"\u0000\u00be\u00bb\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c5\u0003\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c9\u0005\b\u0000\u0000\u00c7\u00c8\u0005\f\u0000\u0000"+
		"\u00c8\u00ca\u0005\u0018\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005\t\u0000\u0000\u00cc\u00cd\u0003\u001a\r\u0000\u00cd"+
		"\u00ce\u0005\n\u0000\u0000\u00ce\u001d\u0001\u0000\u0000\u0000\u00cf\u00d4"+
		"\u0005\u0016\u0000\u0000\u00d0\u00d1\u0005\u0018\u0000\u0000\u00d1\u00d3"+
		"\u0005\u0002\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u0018\u0000\u0000\u00d8\u00d9"+
		"\u0005\u000b\u0000\u0000\u00d9\u001f\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0005\u0011\u0000\u0000\u00db\u00dc\u0005\u0018\u0000\u0000\u00dc\u00e0"+
		"\u0005\u0007\u0000\u0000\u00dd\u00df\u0003\u000e\u0007\u0000\u00de\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0005\b\u0000\u0000\u00e4!\u0001\u0000\u0000\u0000\u00e5\u00e7\u0003"+
		"\u001e\u000f\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ed\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003"+
		"\u0002\u0001\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001"+
		"\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ee#\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000"+
		"\u0000\u0000\u001506;JNdrt\u0086\u0096\u00a3\u00a9\u00b2\u00b6\u00c0\u00c4"+
		"\u00c9\u00d4\u00e0\u00e8\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}