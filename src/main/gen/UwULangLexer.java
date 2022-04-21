// Generated from /home/foo/synced/uwu-lang/src/main/kotlin/UwULang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UwULangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INTEGER=8, FLOAT=9, 
		WS=10, OPEN_PAREN=11, CLOSE_PAREN=12, OPEN_BRACE=13, CLOSE_BRACE=14, SEMICOLON=15, 
		COLON=16, STRING_LITERAL=17, STRUCT=18, FUN=19, STATIC=20, NEW=21, IF=22, 
		WHILE=23, LET=24, MUT=25, IMPORT=26, IDENTIFIER=27, KEYWORD=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "INTEGER", "FLOAT", 
			"WS", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", 
			"COLON", "STRING_LITERAL", "STRUCT", "FUN", "STATIC", "NEW", "IF", "WHILE", 
			"LET", "MUT", "IMPORT", "IDENTIFIER", "KEYWORD"
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


	public UwULangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UwULang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001c\u00d2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007"+
		"I\b\u0007\u000b\u0007\f\u0007J\u0001\u0007\u0001\u0007\u0004\u0007O\b"+
		"\u0007\u000b\u0007\f\u0007P\u0003\u0007S\b\u0007\u0001\b\u0003\bV\b\b"+
		"\u0001\b\u0004\bY\b\b\u000b\b\f\bZ\u0001\b\u0001\b\u0004\b_\b\b\u000b"+
		"\b\f\b`\u0001\b\u0001\b\u0003\be\b\b\u0001\b\u0004\bh\b\b\u000b\b\f\b"+
		"i\u0001\b\u0001\b\u0004\bn\b\b\u000b\b\f\bo\u0003\br\b\b\u0001\t\u0004"+
		"\tu\b\t\u000b\t\f\tv\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u008b\b\u0010\n\u0010\f\u0010\u008e\t\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u00c4\b\u001a\n\u001a\f\u001a\u00c7\t\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u00d1\b\u001b\u0000\u0000\u001c\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000\u0004\u0003\u0000\t\n\r"+
		"\r  \u0001\u0000\"\"\u0003\u0000AZ__az\u0004\u000009AZ__az\u00e6\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00019\u0001\u0000\u0000\u0000\u0003;\u0001\u0000\u0000\u0000\u0005="+
		"\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\tA\u0001\u0000"+
		"\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rE\u0001\u0000\u0000\u0000"+
		"\u000fH\u0001\u0000\u0000\u0000\u0011U\u0001\u0000\u0000\u0000\u0013t"+
		"\u0001\u0000\u0000\u0000\u0015z\u0001\u0000\u0000\u0000\u0017|\u0001\u0000"+
		"\u0000\u0000\u0019~\u0001\u0000\u0000\u0000\u001b\u0080\u0001\u0000\u0000"+
		"\u0000\u001d\u0082\u0001\u0000\u0000\u0000\u001f\u0084\u0001\u0000\u0000"+
		"\u0000!\u0086\u0001\u0000\u0000\u0000#\u0091\u0001\u0000\u0000\u0000%"+
		"\u0098\u0001\u0000\u0000\u0000\'\u009d\u0001\u0000\u0000\u0000)\u00a4"+
		"\u0001\u0000\u0000\u0000+\u00a8\u0001\u0000\u0000\u0000-\u00ab\u0001\u0000"+
		"\u0000\u0000/\u00b1\u0001\u0000\u0000\u00001\u00b5\u0001\u0000\u0000\u0000"+
		"3\u00ba\u0001\u0000\u0000\u00005\u00c1\u0001\u0000\u0000\u00007\u00d0"+
		"\u0001\u0000\u0000\u00009:\u0005,\u0000\u0000:\u0002\u0001\u0000\u0000"+
		"\u0000;<\u0005.\u0000\u0000<\u0004\u0001\u0000\u0000\u0000=>\u0005+\u0000"+
		"\u0000>\u0006\u0001\u0000\u0000\u0000?@\u0005-\u0000\u0000@\b\u0001\u0000"+
		"\u0000\u0000AB\u0005*\u0000\u0000B\n\u0001\u0000\u0000\u0000CD\u0005/"+
		"\u0000\u0000D\f\u0001\u0000\u0000\u0000EF\u0005=\u0000\u0000F\u000e\u0001"+
		"\u0000\u0000\u0000GI\u000209\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KR\u0001"+
		"\u0000\u0000\u0000LN\u0005.\u0000\u0000MO\u000209\u0000NM\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000RL\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000S\u0010\u0001\u0000\u0000\u0000TV\u0005-\u0000"+
		"\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000"+
		"\u0000\u0000WY\u000209\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\^\u0005.\u0000\u0000]_\u000209\u0000^]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0005e\u0000\u0000ce\u0005-\u0000"+
		"\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000"+
		"\u0000\u0000fh\u000209\u0000gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jq\u0001\u0000"+
		"\u0000\u0000km\u0005.\u0000\u0000ln\u000209\u0000ml\u0001\u0000\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000pr\u0001\u0000\u0000\u0000qk\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000r\u0012\u0001\u0000\u0000\u0000su\u0007\u0000\u0000"+
		"\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0006"+
		"\t\u0000\u0000y\u0014\u0001\u0000\u0000\u0000z{\u0005(\u0000\u0000{\u0016"+
		"\u0001\u0000\u0000\u0000|}\u0005)\u0000\u0000}\u0018\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005{\u0000\u0000\u007f\u001a\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005}\u0000\u0000\u0081\u001c\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005;\u0000\u0000\u0083\u001e\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		":\u0000\u0000\u0085 \u0001\u0000\u0000\u0000\u0086\u008c\u0005\"\u0000"+
		"\u0000\u0087\u008b\b\u0001\u0000\u0000\u0088\u0089\u0005\\\u0000\u0000"+
		"\u0089\u008b\u0005\"\u0000\u0000\u008a\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c"+
		"\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d"+
		"\u008f\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005\"\u0000\u0000\u0090\"\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005s\u0000\u0000\u0092\u0093\u0005t\u0000\u0000\u0093\u0094\u0005w"+
		"\u0000\u0000\u0094\u0095\u0005u\u0000\u0000\u0095\u0096\u0005c\u0000\u0000"+
		"\u0096\u0097\u0005t\u0000\u0000\u0097$\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005f\u0000\u0000\u0099\u009a\u0005u\u0000\u0000\u009a\u009b\u0005w"+
		"\u0000\u0000\u009b\u009c\u0005n\u0000\u0000\u009c&\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0005s\u0000\u0000\u009e\u009f\u0005t\u0000\u0000\u009f\u00a0"+
		"\u0005a\u0000\u0000\u00a0\u00a1\u0005t\u0000\u0000\u00a1\u00a2\u0005i"+
		"\u0000\u0000\u00a2\u00a3\u0005c\u0000\u0000\u00a3(\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0005n\u0000\u0000\u00a5\u00a6\u0005e\u0000\u0000\u00a6\u00a7"+
		"\u0005w\u0000\u0000\u00a7*\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005i"+
		"\u0000\u0000\u00a9\u00aa\u0005f\u0000\u0000\u00aa,\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005w\u0000\u0000\u00ac\u00ad\u0005h\u0000\u0000\u00ad\u00ae"+
		"\u0005i\u0000\u0000\u00ae\u00af\u0005w\u0000\u0000\u00af\u00b0\u0005e"+
		"\u0000\u0000\u00b0.\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005w\u0000\u0000"+
		"\u00b2\u00b3\u0005e\u0000\u0000\u00b3\u00b4\u0005t\u0000\u0000\u00b40"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005m\u0000\u0000\u00b6\u00b7\u0005"+
		"e\u0000\u0000\u00b7\u00b8\u0005w\u0000\u0000\u00b8\u00b9\u0005t\u0000"+
		"\u0000\u00b92\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005i\u0000\u0000\u00bb"+
		"\u00bc\u0005m\u0000\u0000\u00bc\u00bd\u0005p\u0000\u0000\u00bd\u00be\u0005"+
		"o\u0000\u0000\u00be\u00bf\u0005w\u0000\u0000\u00bf\u00c0\u0005t\u0000"+
		"\u0000\u00c04\u0001\u0000\u0000\u0000\u00c1\u00c5\u0007\u0002\u0000\u0000"+
		"\u00c2\u00c4\u0007\u0003\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c66\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c8\u00d1\u0003#\u0011\u0000\u00c9\u00d1"+
		"\u0003%\u0012\u0000\u00ca\u00d1\u0003)\u0014\u0000\u00cb\u00d1\u0003+"+
		"\u0015\u0000\u00cc\u00d1\u0003-\u0016\u0000\u00cd\u00d1\u0003/\u0017\u0000"+
		"\u00ce\u00d1\u00031\u0018\u0000\u00cf\u00d1\u00033\u0019\u0000\u00d0\u00c8"+
		"\u0001\u0000\u0000\u0000\u00d0\u00c9\u0001\u0000\u0000\u0000\u00d0\u00ca"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cb\u0001\u0000\u0000\u0000\u00d0\u00cc"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000\u00d0\u00ce"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d18\u0001"+
		"\u0000\u0000\u0000\u0010\u0000JPRUZ`dioqv\u008a\u008c\u00c5\u00d0\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}