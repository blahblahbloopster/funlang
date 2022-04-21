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
		WHILE=23, LET=24, MUT=25, IMPORT=26, IDENTIFIER=27, KEYWORD=28;
	public static final int
		RULE_struct = 0, RULE_fieldAccess = 1, RULE_functionInvocation = 2, RULE_methodInvocation = 3, 
		RULE_addOp = 4, RULE_mulOp = 5, RULE_expression = 6, RULE_statement = 7, 
		RULE_ifStatement = 8, RULE_whileLoop = 9, RULE_variableAssign = 10, RULE_fun = 11, 
		RULE_impt = 12, RULE_file = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"struct", "fieldAccess", "functionInvocation", "methodInvocation", "addOp", 
			"mulOp", "expression", "statement", "ifStatement", "whileLoop", "variableAssign", 
			"fun", "impt", "file"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'+'", "'-'", "'*'", "'/'", "'='", null, null, null, 
			"'('", "')'", "'{'", "'}'", "';'", "':'", null, "'stwuct'", "'fuwn'", 
			"'static'", "'new'", "'if'", "'whiwe'", "'wet'", "'mewt'", "'impowt'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "INTEGER", "FLOAT", "WS", 
			"OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", 
			"COLON", "STRING_LITERAL", "STRUCT", "FUN", "STATIC", "NEW", "IF", "WHILE", 
			"LET", "MUT", "IMPORT", "IDENTIFIER", "KEYWORD"
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

	public static class StructContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(UwULangParser.STRUCT, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> COLON() { return getTokens(UwULangParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(UwULangParser.COLON, i);
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
		enterRule(_localctx, 0, RULE_struct);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(STRUCT);
			setState(29);
			match(IDENTIFIER);
			setState(30);
			match(OPEN_BRACE);
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					match(IDENTIFIER);
					setState(32);
					match(COLON);
					setState(33);
					match(IDENTIFIER);
					setState(34);
					match(T__0);
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(40);
				match(IDENTIFIER);
				setState(41);
				match(COLON);
				setState(42);
				match(IDENTIFIER);
				setState(43);
				match(SEMICOLON);
				}
			}

			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN || _la==STATIC) {
				{
				{
				setState(46);
				fun();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
		enterRule(_localctx, 2, RULE_fieldAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__1);
			setState(55);
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
		enterRule(_localctx, 4, RULE_functionInvocation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(IDENTIFIER);
			setState(58);
			match(OPEN_PAREN);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(59);
					expression(0);
					setState(60);
					match(T__0);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(67);
				expression(0);
				}
			}

			setState(70);
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
		enterRule(_localctx, 6, RULE_methodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__1);
			setState(73);
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
		enterRule(_localctx, 8, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
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
		enterRule(_localctx, 10, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(80);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(81);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(82);
				match(OPEN_PAREN);
				setState(83);
				expression(0);
				setState(84);
				match(CLOSE_PAREN);
				}
				break;
			case 4:
				{
				setState(86);
				match(INTEGER);
				}
				break;
			case 5:
				{
				setState(87);
				match(FLOAT);
				}
				break;
			case 6:
				{
				setState(88);
				match(STRING_LITERAL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(103);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(92);
						mulOp();
						setState(93);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(95);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(96);
						addOp();
						setState(97);
						expression(2);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(100);
						fieldAccess();
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(102);
						methodInvocation();
						}
						break;
					}
					} 
				}
				setState(107);
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
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				whileLoop();
				}
				break;
			case LET:
			case MUT:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(110);
				variableAssign();
				setState(111);
				match(SEMICOLON);
				}
				}
				break;
			case INTEGER:
			case FLOAT:
			case OPEN_PAREN:
			case STRING_LITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(113);
				expression(0);
				setState(114);
				match(SEMICOLON);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 16, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IF);
			setState(119);
			match(OPEN_PAREN);
			setState(120);
			expression(0);
			setState(121);
			match(CLOSE_PAREN);
			setState(122);
			match(OPEN_BRACE);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(123);
				statement();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
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
		enterRule(_localctx, 18, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(WHILE);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << IDENTIFIER))) != 0)) {
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
		enterRule(_localctx, 20, RULE_variableAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==LET || _la==MUT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(145);
			match(IDENTIFIER);
			setState(146);
			match(T__6);
			setState(147);
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

	public static class FunContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(UwULangParser.FUN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public TerminalNode STATIC() { return getToken(UwULangParser.STATIC, 0); }
		public List<TerminalNode> COLON() { return getTokens(UwULangParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(UwULangParser.COLON, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
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
		enterRule(_localctx, 22, RULE_fun);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(149);
				match(STATIC);
				}
			}

			setState(152);
			match(FUN);
			setState(153);
			match(IDENTIFIER);
			setState(154);
			match(OPEN_PAREN);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					match(IDENTIFIER);
					setState(156);
					match(COLON);
					setState(157);
					match(IDENTIFIER);
					setState(158);
					match(T__0);
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(164);
				match(IDENTIFIER);
				setState(165);
				match(COLON);
				setState(166);
				match(IDENTIFIER);
				}
			}

			setState(169);
			match(CLOSE_PAREN);
			setState(170);
			match(OPEN_BRACE);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << IF) | (1L << WHILE) | (1L << LET) | (1L << MUT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(171);
				statement();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
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
		enterRule(_localctx, 24, RULE_impt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(IMPORT);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(180);
					match(IDENTIFIER);
					setState(181);
					match(T__1);
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(187);
			match(IDENTIFIER);
			setState(188);
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
		enterRule(_localctx, 26, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(190);
				impt();
				}
				}
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCT) {
				{
				{
				setState(195);
				struct();
				}
				}
				setState(200);
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
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u00ca\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000$\b\u0000\n\u0000"+
		"\f\u0000\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000-\b\u0000\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u00003\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002?\b\u0002"+
		"\n\u0002\f\u0002B\t\u0002\u0001\u0002\u0003\u0002E\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006Z\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006h\b\u0006\n\u0006\f\u0006k\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007u\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0005\b}\b\b\n\b\f\b\u0080\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u008a\b\t\n"+
		"\t\f\t\u008d\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0003\u000b\u0097\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a0"+
		"\b\u000b\n\u000b\f\u000b\u00a3\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00a8\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00ad\b\u000b\n\u000b\f\u000b\u00b0\t\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00b7\b\f\n\f\f\f\u00ba\t\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0004\r\u00c0\b\r\u000b\r\f\r\u00c1\u0001\r\u0005\r\u00c5"+
		"\b\r\n\r\f\r\u00c8\t\r\u0001\r\u0000\u0001\f\u000e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0003\u0001\u0000"+
		"\u0003\u0004\u0001\u0000\u0005\u0006\u0001\u0000\u0018\u0019\u00d5\u0000"+
		"\u001c\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000\u00049\u0001"+
		"\u0000\u0000\u0000\u0006H\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000"+
		"\u0000\nM\u0001\u0000\u0000\u0000\fY\u0001\u0000\u0000\u0000\u000et\u0001"+
		"\u0000\u0000\u0000\u0010v\u0001\u0000\u0000\u0000\u0012\u0083\u0001\u0000"+
		"\u0000\u0000\u0014\u0090\u0001\u0000\u0000\u0000\u0016\u0096\u0001\u0000"+
		"\u0000\u0000\u0018\u00b3\u0001\u0000\u0000\u0000\u001a\u00bf\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0005\u0012\u0000\u0000\u001d\u001e\u0005\u001b"+
		"\u0000\u0000\u001e%\u0005\r\u0000\u0000\u001f \u0005\u001b\u0000\u0000"+
		" !\u0005\u0010\u0000\u0000!\"\u0005\u001b\u0000\u0000\"$\u0005\u0001\u0000"+
		"\u0000#\u001f\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&,\u0001\u0000\u0000\u0000"+
		"\'%\u0001\u0000\u0000\u0000()\u0005\u001b\u0000\u0000)*\u0005\u0010\u0000"+
		"\u0000*+\u0005\u001b\u0000\u0000+-\u0005\u000f\u0000\u0000,(\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-1\u0001\u0000\u0000\u0000.0\u0003"+
		"\u0016\u000b\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000045\u0005\u000e\u0000\u00005\u0001\u0001"+
		"\u0000\u0000\u000067\u0005\u0002\u0000\u000078\u0005\u001b\u0000\u0000"+
		"8\u0003\u0001\u0000\u0000\u00009:\u0005\u001b\u0000\u0000:@\u0005\u000b"+
		"\u0000\u0000;<\u0003\f\u0006\u0000<=\u0005\u0001\u0000\u0000=?\u0001\u0000"+
		"\u0000\u0000>;\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000CE\u0003\f\u0006\u0000DC\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0005\f\u0000\u0000"+
		"G\u0005\u0001\u0000\u0000\u0000HI\u0005\u0002\u0000\u0000IJ\u0003\u0004"+
		"\u0002\u0000J\u0007\u0001\u0000\u0000\u0000KL\u0007\u0000\u0000\u0000"+
		"L\t\u0001\u0000\u0000\u0000MN\u0007\u0001\u0000\u0000N\u000b\u0001\u0000"+
		"\u0000\u0000OP\u0006\u0006\uffff\uffff\u0000PZ\u0005\u001b\u0000\u0000"+
		"QZ\u0003\u0004\u0002\u0000RS\u0005\u000b\u0000\u0000ST\u0003\f\u0006\u0000"+
		"TU\u0005\f\u0000\u0000UZ\u0001\u0000\u0000\u0000VZ\u0005\b\u0000\u0000"+
		"WZ\u0005\t\u0000\u0000XZ\u0005\u0011\u0000\u0000YO\u0001\u0000\u0000\u0000"+
		"YQ\u0001\u0000\u0000\u0000YR\u0001\u0000\u0000\u0000YV\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000Zi\u0001\u0000"+
		"\u0000\u0000[\\\n\u0002\u0000\u0000\\]\u0003\n\u0005\u0000]^\u0003\f\u0006"+
		"\u0003^h\u0001\u0000\u0000\u0000_`\n\u0001\u0000\u0000`a\u0003\b\u0004"+
		"\u0000ab\u0003\f\u0006\u0002bh\u0001\u0000\u0000\u0000cd\n\t\u0000\u0000"+
		"dh\u0003\u0002\u0001\u0000ef\n\b\u0000\u0000fh\u0003\u0006\u0003\u0000"+
		"g[\u0001\u0000\u0000\u0000g_\u0001\u0000\u0000\u0000gc\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000j\r\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000lu\u0003\u0010\b\u0000mu\u0003\u0012\t\u0000no\u0003"+
		"\u0014\n\u0000op\u0005\u000f\u0000\u0000pu\u0001\u0000\u0000\u0000qr\u0003"+
		"\f\u0006\u0000rs\u0005\u000f\u0000\u0000su\u0001\u0000\u0000\u0000tl\u0001"+
		"\u0000\u0000\u0000tm\u0001\u0000\u0000\u0000tn\u0001\u0000\u0000\u0000"+
		"tq\u0001\u0000\u0000\u0000u\u000f\u0001\u0000\u0000\u0000vw\u0005\u0016"+
		"\u0000\u0000wx\u0005\u000b\u0000\u0000xy\u0003\f\u0006\u0000yz\u0005\f"+
		"\u0000\u0000z~\u0005\r\u0000\u0000{}\u0003\u000e\u0007\u0000|{\u0001\u0000"+
		"\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u000e\u0000\u0000\u0082\u0011"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0017\u0000\u0000\u0084\u0085"+
		"\u0005\u000b\u0000\u0000\u0085\u0086\u0003\f\u0006\u0000\u0086\u0087\u0005"+
		"\f\u0000\u0000\u0087\u008b\u0005\r\u0000\u0000\u0088\u008a\u0003\u000e"+
		"\u0007\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000"+
		"\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0005\u000e\u0000\u0000\u008f\u0013\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0007\u0002\u0000\u0000\u0091\u0092\u0005\u001b"+
		"\u0000\u0000\u0092\u0093\u0005\u0007\u0000\u0000\u0093\u0094\u0003\f\u0006"+
		"\u0000\u0094\u0015\u0001\u0000\u0000\u0000\u0095\u0097\u0005\u0014\u0000"+
		"\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u0013\u0000"+
		"\u0000\u0099\u009a\u0005\u001b\u0000\u0000\u009a\u00a1\u0005\u000b\u0000"+
		"\u0000\u009b\u009c\u0005\u001b\u0000\u0000\u009c\u009d\u0005\u0010\u0000"+
		"\u0000\u009d\u009e\u0005\u001b\u0000\u0000\u009e\u00a0\u0005\u0001\u0000"+
		"\u0000\u009f\u009b\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a7\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005\u001b\u0000\u0000\u00a5\u00a6\u0005\u0010\u0000"+
		"\u0000\u00a6\u00a8\u0005\u001b\u0000\u0000\u00a7\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005\f\u0000\u0000\u00aa\u00ae\u0005\r\u0000\u0000"+
		"\u00ab\u00ad\u0003\u000e\u0007\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u000e\u0000\u0000"+
		"\u00b2\u0017\u0001\u0000\u0000\u0000\u00b3\u00b8\u0005\u001a\u0000\u0000"+
		"\u00b4\u00b5\u0005\u001b\u0000\u0000\u00b5\u00b7\u0005\u0002\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0005\u001b\u0000\u0000\u00bc\u00bd\u0005\u000f\u0000\u0000"+
		"\u00bd\u0019\u0001\u0000\u0000\u0000\u00be\u00c0\u0003\u0018\f\u0000\u00bf"+
		"\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c3\u00c5\u0003\u0000\u0000\u0000\u00c4"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u001b\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u0012"+
		"%,1@DYgit~\u008b\u0096\u00a1\u00a7\u00ae\u00b8\u00c1\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}