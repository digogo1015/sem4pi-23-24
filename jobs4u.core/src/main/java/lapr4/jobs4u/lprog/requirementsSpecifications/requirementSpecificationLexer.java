// Generated from C:/Users/tiago/IdeaProjects/sem4pi-23-24-2dl1/jobs4u.core/src/main/java/lapr4/jobs4u/lprog/requirementsSpecifications/requirementSpecification.g4 by ANTLR 4.13.1
package lapr4.jobs4u.lprog.requirementsSpecifications;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class requirementSpecificationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, TK_TEXT=8, TK_LETTER=9, 
		TK_DIGIT=10, NEWLINE=11, WS=12, TEXT=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "TK_TEXT", "TK_LETTER", 
			"TK_DIGIT", "NEWLINE", "WS", "TEXT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'(integer)'", "'('", "')'", "', '", "'; '", "'# '", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "TK_TEXT", "TK_LETTER", 
			"TK_DIGIT", "NEWLINE", "WS", "TEXT"
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


	public requirementSpecificationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "requirementSpecification.g4"; }

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
		"\u0004\u0000\rS\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u00076\b"+
		"\u0007\u000b\u0007\f\u00077\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0003"+
		"\n?\b\n\u0001\n\u0001\n\u0001\u000b\u0004\u000bD\b\u000b\u000b\u000b\f"+
		"\u000bE\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0000\u0000\r\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0003\u0002\u0000A"+
		"Zaz\u0001\u000009\u0002\u0000\t\t  U\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b"+
		"\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0005\'\u0001"+
		"\u0000\u0000\u0000\u0007)\u0001\u0000\u0000\u0000\t,\u0001\u0000\u0000"+
		"\u0000\u000b/\u0001\u0000\u0000\u0000\r2\u0001\u0000\u0000\u0000\u000f"+
		"5\u0001\u0000\u0000\u0000\u00119\u0001\u0000\u0000\u0000\u0013;\u0001"+
		"\u0000\u0000\u0000\u0015>\u0001\u0000\u0000\u0000\u0017C\u0001\u0000\u0000"+
		"\u0000\u0019I\u0001\u0000\u0000\u0000\u001b\u001c\u0005(\u0000\u0000\u001c"+
		"\u001d\u0005i\u0000\u0000\u001d\u001e\u0005n\u0000\u0000\u001e\u001f\u0005"+
		"t\u0000\u0000\u001f \u0005e\u0000\u0000 !\u0005g\u0000\u0000!\"\u0005"+
		"e\u0000\u0000\"#\u0005r\u0000\u0000#$\u0005)\u0000\u0000$\u0002\u0001"+
		"\u0000\u0000\u0000%&\u0005(\u0000\u0000&\u0004\u0001\u0000\u0000\u0000"+
		"\'(\u0005)\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005,\u0000\u0000"+
		"*+\u0005 \u0000\u0000+\b\u0001\u0000\u0000\u0000,-\u0005;\u0000\u0000"+
		"-.\u0005 \u0000\u0000.\n\u0001\u0000\u0000\u0000/0\u0005#\u0000\u0000"+
		"01\u0005 \u0000\u00001\f\u0001\u0000\u0000\u000023\u0005:\u0000\u0000"+
		"3\u000e\u0001\u0000\u0000\u000046\u0003\u0011\b\u000054\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u00008\u0010\u0001\u0000\u0000\u00009:\u0007\u0000\u0000\u0000"+
		":\u0012\u0001\u0000\u0000\u0000;<\u0007\u0001\u0000\u0000<\u0014\u0001"+
		"\u0000\u0000\u0000=?\u0005\r\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0005\n\u0000\u0000A\u0016"+
		"\u0001\u0000\u0000\u0000BD\u0007\u0002\u0000\u0000CB\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0006\u000b\u0000\u0000H\u0018"+
		"\u0001\u0000\u0000\u0000IJ\u0005,\u0000\u0000JK\u0005-\u0000\u0000KL\u0005"+
		"(\u0000\u0000LM\u0005)\u0000\u0000MN\u0005:\u0000\u0000NO\u0005;\u0000"+
		"\u0000OP\u0005+\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0006\f\u0000"+
		"\u0000R\u001a\u0001\u0000\u0000\u0000\u0004\u00007>E\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}