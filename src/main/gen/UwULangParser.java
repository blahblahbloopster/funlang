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
		IMPORT=22, RETURN=23, PACKAGE=24, IDENTIFIER=25, KEYWORD=26, PLUS=27, 
		MINUS=28, TIMES=29, DIVIDE=30;
	public static final int
		RULE_nameTypePair = 0, RULE_struct = 1, RULE_fieldAccess = 2, RULE_functionInvocation = 3, 
		RULE_methodInvocation = 4, RULE_addOp = 5, RULE_mulOp = 6, RULE_expression = 7, 
		RULE_statement = 8, RULE_fieldAssign = 9, RULE_ifStatement = 10, RULE_whileLoop = 11, 
		RULE_variableAssign = 12, RULE_multiStatement = 13, RULE_fun = 14, RULE_impt = 15, 
		RULE_new = 16, RULE_qualifiedName = 17, RULE_packageStatement = 18, RULE_file = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"nameTypePair", "struct", "fieldAccess", "functionInvocation", "methodInvocation", 
			"addOp", "mulOp", "expression", "statement", "fieldAssign", "ifStatement", 
			"whileLoop", "variableAssign", "multiStatement", "fun", "impt", "new", 
			"qualifiedName", "packageStatement", "file"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'='", null, null, null, "'('", "')'", "'{'", "'}'", 
			"';'", "':'", null, "'stwuct'", "'fuwn'", "'static'", "'new'", "'if'", 
			"'whiwe'", "'wet'", "'mewt'", "'impowt'", "'wetuwn'", "'package'", null, 
			null, "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "INTEGER", "FLOAT", "WS", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", "COLON", "STRING_LITERAL", 
			"STRUCT", "FUN", "STATIC", "NEW", "IF", "WHILE", "LET", "MUT", "IMPORT", 
			"RETURN", "PACKAGE", "IDENTIFIER", "KEYWORD", "PLUS", "MINUS", "TIMES", 
			"DIVIDE"
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
			setState(40);
			((NameTypePairContext)_localctx).name = match(IDENTIFIER);
			setState(41);
			match(COLON);
			setState(42);
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
			setState(44);
			match(STRUCT);
			setState(45);
			match(IDENTIFIER);
			setState(46);
			match(OPEN_BRACE);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					nameTypePair();
					setState(48);
					match(T__0);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(55);
				nameTypePair();
				setState(56);
				match(SEMICOLON);
				}
			}

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN || _la==STATIC) {
				{
				{
				setState(60);
				fun();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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
			setState(68);
			match(T__1);
			setState(69);
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
			setState(71);
			match(IDENTIFIER);
			setState(72);
			match(OPEN_PAREN);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(73);
					expression(0);
					setState(74);
					match(T__0);
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(81);
				expression(0);
				}
			}

			setState(84);
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
			setState(86);
			match(T__1);
			setState(87);
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
			setState(89);
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
			setState(91);
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
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(94);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(95);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(96);
				match(OPEN_PAREN);
				setState(97);
				expression(0);
				setState(98);
				match(CLOSE_PAREN);
				}
				break;
			case 4:
				{
				setState(100);
				match(INTEGER);
				}
				break;
			case 5:
				{
				setState(101);
				match(FLOAT);
				}
				break;
			case 6:
				{
				setState(102);
				match(STRING_LITERAL);
				}
				break;
			case 7:
				{
				setState(103);
				new_();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(107);
						mulOp();
						setState(108);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(111);
						addOp();
						setState(112);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(115);
						fieldAccess();
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(117);
						methodInvocation();
						}
						break;
					}
					} 
				}
				setState(122);
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
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				whileLoop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(125);
				variableAssign();
				setState(126);
				match(SEMICOLON);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(128);
				expression(0);
				setState(129);
				match(SEMICOLON);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(131);
				match(RETURN);
				setState(132);
				expression(0);
				setState(133);
				match(SEMICOLON);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(135);
				fieldAssign();
				setState(136);
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
			setState(140);
			expression(0);
			setState(141);
			match(T__1);
			setState(142);
			match(IDENTIFIER);
			setState(143);
			match(T__2);
			setState(144);
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
			setState(146);
			match(IF);
			setState(147);
			match(OPEN_PAREN);
			setState(148);
			expression(0);
			setState(149);
			match(CLOSE_PAREN);
			setState(150);
			match(OPEN_BRACE);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(151);
				statement();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
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
			setState(159);
			match(WHILE);
			setState(160);
			match(OPEN_PAREN);
			setState(161);
			expression(0);
			setState(162);
			match(CLOSE_PAREN);
			setState(163);
			match(OPEN_BRACE);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(164);
				statement();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
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
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET || _la==MUT) {
				{
				setState(172);
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

			setState(175);
			match(IDENTIFIER);
			setState(176);
			match(T__2);
			setState(177);
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
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(179);
				statement();
				}
				}
				setState(184);
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
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(185);
				match(STATIC);
				}
			}

			setState(188);
			match(FUN);
			setState(189);
			((FunContext)_localctx).name = match(IDENTIFIER);
			setState(190);
			match(OPEN_PAREN);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191);
					nameTypePair();
					setState(192);
					match(T__0);
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(199);
				nameTypePair();
				}
			}

			setState(202);
			match(CLOSE_PAREN);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(203);
				match(COLON);
				setState(204);
				((FunContext)_localctx).returnType = match(IDENTIFIER);
				}
			}

			setState(207);
			match(OPEN_BRACE);
			setState(208);
			multiStatement();
			setState(209);
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
			setState(211);
			match(IMPORT);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(212);
					match(IDENTIFIER);
					setState(213);
					match(T__1);
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(219);
			match(IDENTIFIER);
			setState(220);
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
			setState(222);
			match(NEW);
			setState(223);
			match(IDENTIFIER);
			setState(224);
			match(OPEN_PAREN);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(225);
				expression(0);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					match(IDENTIFIER);
					setState(234);
					match(T__1);
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(240);
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

	public static class PackageStatementContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(UwULangParser.PACKAGE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public PackageStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterPackageStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitPackageStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitPackageStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageStatementContext packageStatement() throws RecognitionException {
		PackageStatementContext _localctx = new PackageStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_packageStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(PACKAGE);
			setState(243);
			qualifiedName();
			setState(244);
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

	public static class FileContext extends ParserRuleContext {
		public PackageStatementContext packageStatement() {
			return getRuleContext(PackageStatementContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			packageStatement();
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(247);
				impt();
				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCT) {
				{
				{
				setState(252);
				struct();
				}
				}
				setState(257);
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
		"\u0004\u0001\u001e\u0103\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0001\u0005\u0001>\b\u0001"+
		"\n\u0001\f\u0001A\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001\u0003\u0003\u0003"+
		"S\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007i\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"w\b\u0007\n\u0007\f\u0007z\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u008b\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0099\b\n\n"+
		"\n\f\n\u009c\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a6\b\u000b\n\u000b\f\u000b"+
		"\u00a9\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0003\f\u00ae\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0005\r\u00b5\b\r\n\r\f\r\u00b8\t\r"+
		"\u0001\u000e\u0003\u000e\u00bb\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c3\b\u000e\n\u000e"+
		"\f\u000e\u00c6\t\u000e\u0001\u000e\u0003\u000e\u00c9\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u00ce\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00d7\b\u000f\n\u000f\f\u000f\u00da\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00e3"+
		"\b\u0010\n\u0010\f\u0010\u00e6\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00ec\b\u0011\n\u0011\f\u0011\u00ef\t\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0004\u0013\u00f9\b\u0013\u000b\u0013\f\u0013\u00fa"+
		"\u0001\u0013\u0005\u0013\u00fe\b\u0013\n\u0013\f\u0013\u0101\t\u0013\u0001"+
		"\u0013\u0000\u0001\u000e\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0003\u0001\u0000"+
		"\u001b\u001c\u0001\u0000\u001d\u001e\u0001\u0000\u0014\u0015\u010f\u0000"+
		"(\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000\u0000\u0004D\u0001"+
		"\u0000\u0000\u0000\u0006G\u0001\u0000\u0000\u0000\bV\u0001\u0000\u0000"+
		"\u0000\nY\u0001\u0000\u0000\u0000\f[\u0001\u0000\u0000\u0000\u000eh\u0001"+
		"\u0000\u0000\u0000\u0010\u008a\u0001\u0000\u0000\u0000\u0012\u008c\u0001"+
		"\u0000\u0000\u0000\u0014\u0092\u0001\u0000\u0000\u0000\u0016\u009f\u0001"+
		"\u0000\u0000\u0000\u0018\u00ad\u0001\u0000\u0000\u0000\u001a\u00b6\u0001"+
		"\u0000\u0000\u0000\u001c\u00ba\u0001\u0000\u0000\u0000\u001e\u00d3\u0001"+
		"\u0000\u0000\u0000 \u00de\u0001\u0000\u0000\u0000\"\u00ed\u0001\u0000"+
		"\u0000\u0000$\u00f2\u0001\u0000\u0000\u0000&\u00f6\u0001\u0000\u0000\u0000"+
		"()\u0005\u0019\u0000\u0000)*\u0005\f\u0000\u0000*+\u0005\u0019\u0000\u0000"+
		"+\u0001\u0001\u0000\u0000\u0000,-\u0005\u000e\u0000\u0000-.\u0005\u0019"+
		"\u0000\u0000.4\u0005\t\u0000\u0000/0\u0003\u0000\u0000\u000001\u0005\u0001"+
		"\u0000\u000013\u0001\u0000\u0000\u00002/\u0001\u0000\u0000\u000036\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"5:\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0003\u0000\u0000"+
		"\u000089\u0005\u000b\u0000\u00009;\u0001\u0000\u0000\u0000:7\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;?\u0001\u0000\u0000\u0000<>\u0003"+
		"\u001c\u000e\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000"+
		"?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000BC\u0005\n\u0000\u0000C\u0003\u0001\u0000"+
		"\u0000\u0000DE\u0005\u0002\u0000\u0000EF\u0005\u0019\u0000\u0000F\u0005"+
		"\u0001\u0000\u0000\u0000GH\u0005\u0019\u0000\u0000HN\u0005\u0007\u0000"+
		"\u0000IJ\u0003\u000e\u0007\u0000JK\u0005\u0001\u0000\u0000KM\u0001\u0000"+
		"\u0000\u0000LI\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000QS\u0003\u000e\u0007\u0000RQ\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0005\b\u0000"+
		"\u0000U\u0007\u0001\u0000\u0000\u0000VW\u0005\u0002\u0000\u0000WX\u0003"+
		"\u0006\u0003\u0000X\t\u0001\u0000\u0000\u0000YZ\u0007\u0000\u0000\u0000"+
		"Z\u000b\u0001\u0000\u0000\u0000[\\\u0007\u0001\u0000\u0000\\\r\u0001\u0000"+
		"\u0000\u0000]^\u0006\u0007\uffff\uffff\u0000^i\u0005\u0019\u0000\u0000"+
		"_i\u0003\u0006\u0003\u0000`a\u0005\u0007\u0000\u0000ab\u0003\u000e\u0007"+
		"\u0000bc\u0005\b\u0000\u0000ci\u0001\u0000\u0000\u0000di\u0005\u0004\u0000"+
		"\u0000ei\u0005\u0005\u0000\u0000fi\u0005\r\u0000\u0000gi\u0003 \u0010"+
		"\u0000h]\u0001\u0000\u0000\u0000h_\u0001\u0000\u0000\u0000h`\u0001\u0000"+
		"\u0000\u0000hd\u0001\u0000\u0000\u0000he\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000ix\u0001\u0000\u0000\u0000"+
		"jk\n\u0003\u0000\u0000kl\u0003\f\u0006\u0000lm\u0003\u000e\u0007\u0004"+
		"mw\u0001\u0000\u0000\u0000no\n\u0002\u0000\u0000op\u0003\n\u0005\u0000"+
		"pq\u0003\u000e\u0007\u0003qw\u0001\u0000\u0000\u0000rs\n\n\u0000\u0000"+
		"sw\u0003\u0004\u0002\u0000tu\n\t\u0000\u0000uw\u0003\b\u0004\u0000vj\u0001"+
		"\u0000\u0000\u0000vn\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y\u000f\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000{\u008b\u0003\u0014\n\u0000|\u008b\u0003\u0016\u000b"+
		"\u0000}~\u0003\u0018\f\u0000~\u007f\u0005\u000b\u0000\u0000\u007f\u008b"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u000e\u0007\u0000\u0081\u0082"+
		"\u0005\u000b\u0000\u0000\u0082\u008b\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005\u0017\u0000\u0000\u0084\u0085\u0003\u000e\u0007\u0000\u0085\u0086"+
		"\u0005\u000b\u0000\u0000\u0086\u008b\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0003\u0012\t\u0000\u0088\u0089\u0005\u000b\u0000\u0000\u0089\u008b\u0001"+
		"\u0000\u0000\u0000\u008a{\u0001\u0000\u0000\u0000\u008a|\u0001\u0000\u0000"+
		"\u0000\u008a}\u0001\u0000\u0000\u0000\u008a\u0080\u0001\u0000\u0000\u0000"+
		"\u008a\u0083\u0001\u0000\u0000\u0000\u008a\u0087\u0001\u0000\u0000\u0000"+
		"\u008b\u0011\u0001\u0000\u0000\u0000\u008c\u008d\u0003\u000e\u0007\u0000"+
		"\u008d\u008e\u0005\u0002\u0000\u0000\u008e\u008f\u0005\u0019\u0000\u0000"+
		"\u008f\u0090\u0005\u0003\u0000\u0000\u0090\u0091\u0003\u000e\u0007\u0000"+
		"\u0091\u0013\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0012\u0000\u0000"+
		"\u0093\u0094\u0005\u0007\u0000\u0000\u0094\u0095\u0003\u000e\u0007\u0000"+
		"\u0095\u0096\u0005\b\u0000\u0000\u0096\u009a\u0005\t\u0000\u0000\u0097"+
		"\u0099\u0003\u0010\b\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009c"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0005\n\u0000\u0000\u009e\u0015\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005\u0013\u0000\u0000\u00a0\u00a1\u0005"+
		"\u0007\u0000\u0000\u00a1\u00a2\u0003\u000e\u0007\u0000\u00a2\u00a3\u0005"+
		"\b\u0000\u0000\u00a3\u00a7\u0005\t\u0000\u0000\u00a4\u00a6\u0003\u0010"+
		"\b\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0005\n\u0000\u0000\u00ab\u0017\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ae\u0007\u0002\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0005\u0019\u0000\u0000\u00b0\u00b1\u0005\u0003\u0000\u0000"+
		"\u00b1\u00b2\u0003\u000e\u0007\u0000\u00b2\u0019\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b5\u0003\u0010\b\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u001b\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bb\u0005\u0010\u0000\u0000\u00ba"+
		"\u00b9\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u000f\u0000\u0000\u00bd"+
		"\u00be\u0005\u0019\u0000\u0000\u00be\u00c4\u0005\u0007\u0000\u0000\u00bf"+
		"\u00c0\u0003\u0000\u0000\u0000\u00c0\u00c1\u0005\u0001\u0000\u0000\u00c1"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c2\u00bf\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c9\u0003\u0000\u0000\u0000\u00c8"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cd\u0005\b\u0000\u0000\u00cb\u00cc"+
		"\u0005\f\u0000\u0000\u00cc\u00ce\u0005\u0019\u0000\u0000\u00cd\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0005\t\u0000\u0000\u00d0\u00d1\u0003\u001a"+
		"\r\u0000\u00d1\u00d2\u0005\n\u0000\u0000\u00d2\u001d\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d8\u0005\u0016\u0000\u0000\u00d4\u00d5\u0005\u0019\u0000"+
		"\u0000\u00d5\u00d7\u0005\u0002\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00db\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0019\u0000"+
		"\u0000\u00dc\u00dd\u0005\u000b\u0000\u0000\u00dd\u001f\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005\u0011\u0000\u0000\u00df\u00e0\u0005\u0019\u0000"+
		"\u0000\u00e0\u00e4\u0005\u0007\u0000\u0000\u00e1\u00e3\u0003\u000e\u0007"+
		"\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0005\b\u0000\u0000\u00e8!\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0005\u0019\u0000\u0000\u00ea\u00ec\u0005\u0002\u0000\u0000"+
		"\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f0\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0005\u0019\u0000\u0000\u00f1#\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0005\u0018\u0000\u0000\u00f3\u00f4\u0003\"\u0011\u0000\u00f4\u00f5"+
		"\u0005\u000b\u0000\u0000\u00f5%\u0001\u0000\u0000\u0000\u00f6\u00f8\u0003"+
		"$\u0012\u0000\u00f7\u00f9\u0003\u001e\u000f\u0000\u00f8\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00ff\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fe\u0003\u0002\u0001\u0000\u00fd\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\'\u0001\u0000\u0000"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u00164:?NRhvx\u008a\u009a\u00a7"+
		"\u00ad\u00b6\u00ba\u00c4\u00c8\u00cd\u00d8\u00e4\u00ed\u00fa\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}