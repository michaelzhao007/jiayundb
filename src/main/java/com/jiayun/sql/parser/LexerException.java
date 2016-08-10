package com.jiayun.sql.parser;

public class LexerException extends Exception{

    private static final long serialVersionUID = -7651451345797000442L;

    public LexerException(char c) {
        super("unexpected '" + c + "'");
    }

    public LexerException(String msg) {
        super("unexpected \"" + msg + "\"");
    }
}
