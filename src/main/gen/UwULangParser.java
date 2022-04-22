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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INTEGER=8, FLOAT=9, 
		WS=10, OPEN_PAREN=11, CLOSE_PAREN=12, OPEN_BRACE=13, CLOSE_BRACE=14, SEMICOLON=15, 
		COLON=16, STRING_LITERAL=17, STRUCT=18, FUN=19, STATIC=20, NEW=21, IF=22, 
		WHILE=23, LET=24, MUT=25, IMPORT=26, RETURN=27, IDENTIFIER=28, KEYWORD=29;
	public static final int
		RULE_nameTypePair = 0, RULE_struct = 1, RULE_fieldAccess = 2, RULE_functionInvocation = 3, 
		RULE_methodInvocation = 4, RULE_addOp = 5, RULE_mulOp = 6, RULE_expression = 7, 
		RULE_statement = 8, RULE_ifStatement = 9, RULE_whileLoop = 10, RULE_variableAssign = 11, 
		RULE_multiStatement = 12, RULE_fun = 13, RULE_impt = 14, RULE_new = 15, 
		RULE_file = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"nameTypePair", "struct", "fieldAccess", "functionInvocation", "methodInvocation", 
			"addOp", "mulOp", "expression", "statement", "ifStatement", "whileLoop", 
			"variableAssign", "multiStatement", "fun", "impt", "new", "file"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'+'", "'-'", "'*'", "'/'", "'='", null, null, null, 
			"'('", "')'", "'{'", "'}'", "';'", "':'", null, "'stwuct'", "'fuwn'", 
			"'static'", "'new'", "'if'", "'whiwe'", "'wet'", "'mewt'", "'impowt'", 
			"'wetuwn'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "INTEGER", "FLOAT", "WS", 
			"OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", 
			"COLON", "STRING_LITERAL", "STRUCT", "FUN", "STATIC", "NEW", "IF", "WHILE", 
			"LET", "MUT", "IMPORT", "RETURN", "IDENTIFIER", "KEYWORD"
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
			setState(34);
			((NameTypePairContext)_localctx).name = match(IDENTIFIER);
			setState(35);
			match(COLON);
			setState(36);
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
			setState(38);
			match(STRUCT);
			setState(39);
			match(IDENTIFIER);
			setState(40);
			match(OPEN_BRACE);
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(41);
					nameTypePair();
					setState(42);
					match(T__0);
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(49);
				nameTypePair();
				setState(50);
				match(SEMICOLON);
				}
			}

			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN || _la==STATIC) {
				{
				{
				setState(54);
				fun();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
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
			setState(62);
			match(T__1);
			setState(63);
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
			setState(65);
			match(IDENTIFIER);
			setState(66);
			match(OPEN_PAREN);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					expression(0);
					setState(68);
					match(T__0);
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(75);
				expression(0);
				}
			}

			setState(78);
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
			setState(80);
			match(T__1);
			setState(81);
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
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
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
			setState(85);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
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
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(88);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(89);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(90);
				match(OPEN_PAREN);
				setState(91);
				expression(0);
				setState(92);
				match(CLOSE_PAREN);
				}
				break;
			case 4:
				{
				setState(94);
				match(INTEGER);
				}
				break;
			case 5:
				{
				setState(95);
				match(FLOAT);
				}
				break;
			case 6:
				{
				setState(96);
				match(STRING_LITERAL);
				}
				break;
			case 7:
				{
				setState(97);
				new_();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(101);
						mulOp();
						setState(102);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(105);
						addOp();
						setState(106);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(109);
						fieldAccess();
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(111);
						methodInvocation();
						}
						break;
					}
					} 
				}
				setState(116);
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
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				whileLoop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(119);
				variableAssign();
				setState(120);
				match(SEMICOLON);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(122);
				expression(0);
				setState(123);
				match(SEMICOLON);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(125);
				match(RETURN);
				setState(126);
				expression(0);
				setState(127);
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
		enterRule(_localctx, 18, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(IF);
			setState(132);
			match(OPEN_PAREN);
			setState(133);
			expression(0);
			setState(134);
			match(CLOSE_PAREN);
			setState(135);
			match(OPEN_BRACE);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(136);
				statement();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
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
		enterRule(_localctx, 20, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(WHILE);
			setState(145);
			match(OPEN_PAREN);
			setState(146);
			expression(0);
			setState(147);
			match(CLOSE_PAREN);
			setState(148);
			match(OPEN_BRACE);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(149);
				statement();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
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
		enterRule(_localctx, 22, RULE_variableAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET || _la==MUT) {
				{
				setState(157);
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

			setState(160);
			match(IDENTIFIER);
			setState(161);
			match(T__6);
			setState(162);
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
		enterRule(_localctx, 24, RULE_multiStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 26, RULE_fun);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(170);
				match(STATIC);
				}
			}

			setState(173);
			match(FUN);
			setState(174);
			((FunContext)_localctx).name = match(IDENTIFIER);
			setState(175);
			match(OPEN_PAREN);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(176);
					nameTypePair();
					setState(177);
					match(T__0);
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(184);
				nameTypePair();
				}
			}

			setState(187);
			match(CLOSE_PAREN);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(188);
				match(COLON);
				setState(189);
				((FunContext)_localctx).returnType = match(IDENTIFIER);
				}
			}

			setState(192);
			match(OPEN_BRACE);
			setState(193);
			multiStatement();
			setState(194);
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
		enterRule(_localctx, 28, RULE_impt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(IMPORT);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(197);
					match(IDENTIFIER);
					setState(198);
					match(T__1);
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(204);
			match(IDENTIFIER);
			setState(205);
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
		enterRule(_localctx, 30, RULE_new);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(NEW);
			setState(208);
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
		enterRule(_localctx, 32, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(210);
				impt();
				}
				}
				setState(213); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCT) {
				{
				{
				setState(215);
				struct();
				}
				}
				setState(220);
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
		"\u0004\u0001\u001d\u00de\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001\u0005\u00018\b\u0001"+
		"\n\u0001\f\u0001;\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003G\b\u0003\n\u0003\f\u0003J\t\u0003\u0001\u0003\u0003\u0003"+
		"M\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007c\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"q\b\u0007\n\u0007\f\u0007t\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0082"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u008a\b\t"+
		"\n\t\f\t\u008d\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u0097\b\n\n\n\f\n\u009a\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0003\u000b\u009f\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0005\f\u00a6\b\f\n\f\f\f\u00a9\t\f\u0001\r\u0003\r\u00ac\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00b4\b\r\n\r"+
		"\f\r\u00b7\t\r\u0001\r\u0003\r\u00ba\b\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00bf\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00c8\b\u000e\n\u000e\f\u000e\u00cb\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0004\u0010\u00d4\b\u0010\u000b\u0010\f\u0010\u00d5\u0001\u0010\u0005"+
		"\u0010\u00d9\b\u0010\n\u0010\f\u0010\u00dc\t\u0010\u0001\u0010\u0000\u0001"+
		"\u000e\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \u0000\u0003\u0001\u0000\u0003\u0004\u0001\u0000"+
		"\u0005\u0006\u0001\u0000\u0018\u0019\u00ea\u0000\"\u0001\u0000\u0000\u0000"+
		"\u0002&\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006A"+
		"\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\nS\u0001\u0000\u0000"+
		"\u0000\fU\u0001\u0000\u0000\u0000\u000eb\u0001\u0000\u0000\u0000\u0010"+
		"\u0081\u0001\u0000\u0000\u0000\u0012\u0083\u0001\u0000\u0000\u0000\u0014"+
		"\u0090\u0001\u0000\u0000\u0000\u0016\u009e\u0001\u0000\u0000\u0000\u0018"+
		"\u00a7\u0001\u0000\u0000\u0000\u001a\u00ab\u0001\u0000\u0000\u0000\u001c"+
		"\u00c4\u0001\u0000\u0000\u0000\u001e\u00cf\u0001\u0000\u0000\u0000 \u00d3"+
		"\u0001\u0000\u0000\u0000\"#\u0005\u001c\u0000\u0000#$\u0005\u0010\u0000"+
		"\u0000$%\u0005\u001c\u0000\u0000%\u0001\u0001\u0000\u0000\u0000&\'\u0005"+
		"\u0012\u0000\u0000\'(\u0005\u001c\u0000\u0000(.\u0005\r\u0000\u0000)*"+
		"\u0003\u0000\u0000\u0000*+\u0005\u0001\u0000\u0000+-\u0001\u0000\u0000"+
		"\u0000,)\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/4\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000012\u0003\u0000\u0000\u000023\u0005\u000f\u0000\u0000"+
		"35\u0001\u0000\u0000\u000041\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000059\u0001\u0000\u0000\u000068\u0003\u001a\r\u000076\u0001\u0000\u0000"+
		"\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005"+
		"\u000e\u0000\u0000=\u0003\u0001\u0000\u0000\u0000>?\u0005\u0002\u0000"+
		"\u0000?@\u0005\u001c\u0000\u0000@\u0005\u0001\u0000\u0000\u0000AB\u0005"+
		"\u001c\u0000\u0000BH\u0005\u000b\u0000\u0000CD\u0003\u000e\u0007\u0000"+
		"DE\u0005\u0001\u0000\u0000EG\u0001\u0000\u0000\u0000FC\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KM\u0003"+
		"\u000e\u0007\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NO\u0005\f\u0000\u0000O\u0007\u0001\u0000\u0000"+
		"\u0000PQ\u0005\u0002\u0000\u0000QR\u0003\u0006\u0003\u0000R\t\u0001\u0000"+
		"\u0000\u0000ST\u0007\u0000\u0000\u0000T\u000b\u0001\u0000\u0000\u0000"+
		"UV\u0007\u0001\u0000\u0000V\r\u0001\u0000\u0000\u0000WX\u0006\u0007\uffff"+
		"\uffff\u0000Xc\u0005\u001c\u0000\u0000Yc\u0003\u0006\u0003\u0000Z[\u0005"+
		"\u000b\u0000\u0000[\\\u0003\u000e\u0007\u0000\\]\u0005\f\u0000\u0000]"+
		"c\u0001\u0000\u0000\u0000^c\u0005\b\u0000\u0000_c\u0005\t\u0000\u0000"+
		"`c\u0005\u0011\u0000\u0000ac\u0003\u001e\u000f\u0000bW\u0001\u0000\u0000"+
		"\u0000bY\u0001\u0000\u0000\u0000bZ\u0001\u0000\u0000\u0000b^\u0001\u0000"+
		"\u0000\u0000b_\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000ba\u0001"+
		"\u0000\u0000\u0000cr\u0001\u0000\u0000\u0000de\n\u0003\u0000\u0000ef\u0003"+
		"\f\u0006\u0000fg\u0003\u000e\u0007\u0004gq\u0001\u0000\u0000\u0000hi\n"+
		"\u0002\u0000\u0000ij\u0003\n\u0005\u0000jk\u0003\u000e\u0007\u0003kq\u0001"+
		"\u0000\u0000\u0000lm\n\n\u0000\u0000mq\u0003\u0004\u0002\u0000no\n\t\u0000"+
		"\u0000oq\u0003\b\u0004\u0000pd\u0001\u0000\u0000\u0000ph\u0001\u0000\u0000"+
		"\u0000pl\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qt\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u000f"+
		"\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000u\u0082\u0003\u0012"+
		"\t\u0000v\u0082\u0003\u0014\n\u0000wx\u0003\u0016\u000b\u0000xy\u0005"+
		"\u000f\u0000\u0000y\u0082\u0001\u0000\u0000\u0000z{\u0003\u000e\u0007"+
		"\u0000{|\u0005\u000f\u0000\u0000|\u0082\u0001\u0000\u0000\u0000}~\u0005"+
		"\u001b\u0000\u0000~\u007f\u0003\u000e\u0007\u0000\u007f\u0080\u0005\u000f"+
		"\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081u\u0001\u0000\u0000"+
		"\u0000\u0081v\u0001\u0000\u0000\u0000\u0081w\u0001\u0000\u0000\u0000\u0081"+
		"z\u0001\u0000\u0000\u0000\u0081}\u0001\u0000\u0000\u0000\u0082\u0011\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0005\u0016\u0000\u0000\u0084\u0085\u0005"+
		"\u000b\u0000\u0000\u0085\u0086\u0003\u000e\u0007\u0000\u0086\u0087\u0005"+
		"\f\u0000\u0000\u0087\u008b\u0005\r\u0000\u0000\u0088\u008a\u0003\u0010"+
		"\b\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0005\u000e\u0000\u0000\u008f\u0013\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005\u0017\u0000\u0000\u0091\u0092\u0005\u000b\u0000"+
		"\u0000\u0092\u0093\u0003\u000e\u0007\u0000\u0093\u0094\u0005\f\u0000\u0000"+
		"\u0094\u0098\u0005\r\u0000\u0000\u0095\u0097\u0003\u0010\b\u0000\u0096"+
		"\u0095\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u009b\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0005\u000e\u0000\u0000\u009c\u0015\u0001\u0000\u0000\u0000\u009d"+
		"\u009f\u0007\u0002\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0005\u001c\u0000\u0000\u00a1\u00a2\u0005\u0007\u0000\u0000\u00a2"+
		"\u00a3\u0003\u000e\u0007\u0000\u00a3\u0017\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a6\u0003\u0010\b\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u0019\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ac\u0005\u0014\u0000\u0000\u00ab\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0013\u0000\u0000\u00ae\u00af"+
		"\u0005\u001c\u0000\u0000\u00af\u00b5\u0005\u000b\u0000\u0000\u00b0\u00b1"+
		"\u0003\u0000\u0000\u0000\u00b1\u00b2\u0005\u0001\u0000\u0000\u00b2\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00ba\u0003\u0000\u0000\u0000\u00b9\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bb\u00be\u0005\f\u0000\u0000\u00bc\u00bd\u0005"+
		"\u0010\u0000\u0000\u00bd\u00bf\u0005\u001c\u0000\u0000\u00be\u00bc\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0005\r\u0000\u0000\u00c1\u00c2\u0003\u0018"+
		"\f\u0000\u00c2\u00c3\u0005\u000e\u0000\u0000\u00c3\u001b\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c9\u0005\u001a\u0000\u0000\u00c5\u00c6\u0005\u001c\u0000"+
		"\u0000\u00c6\u00c8\u0005\u0002\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u001c\u0000"+
		"\u0000\u00cd\u00ce\u0005\u000f\u0000\u0000\u00ce\u001d\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0005\u0015\u0000\u0000\u00d0\u00d1\u0005\u001c\u0000"+
		"\u0000\u00d1\u001f\u0001\u0000\u0000\u0000\u00d2\u00d4\u0003\u001c\u000e"+
		"\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u00da\u0001\u0000\u0000\u0000\u00d7\u00d9\u0003\u0002\u0001"+
		"\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db!\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000"+
		"\u0014.49HLbpr\u0081\u008b\u0098\u009e\u00a7\u00ab\u00b5\u00b9\u00be\u00c9"+
		"\u00d5\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}