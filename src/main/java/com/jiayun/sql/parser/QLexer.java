// Generated from Q.g4 by ANTLR 4.5.3
package com.jiayun.sql.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ID=8, INT=9, STRING=10, 
		WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "ID", "INT", "STRING", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'create'", "'table'", "'insert'", "'into'", "'set'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "ID", "INT", "STRING", 
		"WS"
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


	    Interpreter interp;
	    public QParser(TokenStream input, Interpreter interp) {
	        this(input);
	        this.interp = interp;
	    }


	public QLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Q.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 9:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			setText(getText().substring(1, getText().length()-1));
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rT\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\7\t=\n\t\f\t\16\t@\13\t\3\n\6\nC\n\n\r\n\16\nD\3\13\3\13"+
		"\7\13I\n\13\f\13\16\13L\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\2\2\r\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\6\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2))\5\2\13\f\17\17\"\"V\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5 \3\2\2\2\7&\3\2\2\2\t"+
		"-\3\2\2\2\13\62\3\2\2\2\r\66\3\2\2\2\178\3\2\2\2\21:\3\2\2\2\23B\3\2\2"+
		"\2\25F\3\2\2\2\27P\3\2\2\2\31\32\7e\2\2\32\33\7t\2\2\33\34\7g\2\2\34\35"+
		"\7c\2\2\35\36\7v\2\2\36\37\7g\2\2\37\4\3\2\2\2 !\7v\2\2!\"\7c\2\2\"#\7"+
		"d\2\2#$\7n\2\2$%\7g\2\2%\6\3\2\2\2&\'\7k\2\2\'(\7p\2\2()\7u\2\2)*\7g\2"+
		"\2*+\7t\2\2+,\7v\2\2,\b\3\2\2\2-.\7k\2\2./\7p\2\2/\60\7v\2\2\60\61\7q"+
		"\2\2\61\n\3\2\2\2\62\63\7u\2\2\63\64\7g\2\2\64\65\7v\2\2\65\f\3\2\2\2"+
		"\66\67\7.\2\2\67\16\3\2\2\289\7=\2\29\20\3\2\2\2:>\t\2\2\2;=\t\3\2\2<"+
		";\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\22\3\2\2\2@>\3\2\2\2AC\4\62;"+
		"\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\24\3\2\2\2FJ\7)\2\2GI\n\4"+
		"\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7)"+
		"\2\2NO\b\13\2\2O\26\3\2\2\2PQ\t\5\2\2QR\3\2\2\2RS\b\f\3\2S\30\3\2\2\2"+
		"\6\2>DJ\4\3\13\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}