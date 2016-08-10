package com.jiayun.sql.parser;

import java.io.Reader;
import java.util.LinkedList;

import com.jiayun.sql.parser.Token.Type;

public class Lexer {
    
    private static enum State {
        Normal, Identifier, Sign, String, Space;
    }
    
    public Lexer(Reader reader) {
        
    }
    
    Token read() {
        return null;
    }
    
    private State state;
    private final LinkedList<Token> tokenBuffer = new LinkedList<Token>();
    private StringBuilder readBuffer = null;
    private boolean transferredMeaningSign = false;
    
    private void refreshBuffer(char c) {
        readBuffer = new StringBuilder();
        readBuffer.append(c);
    }
    
    private void createToken(Type type) {
        Token token = new Token(type, readBuffer.toString());
        tokenBuffer.addFirst(token);
        readBuffer = null;
    }
    
    private static final char[] Space = new char[] {' ', '\t'};

    private boolean inIdentifierSetButNotRear(char c) {
        return (c >= 'a' & c <= 'z' ) | (c >='A' & c <= 'Z') | (c >= '0' & c <= '9')|| (c == '_');
    }

    private boolean include(char[] range, char c) {
        boolean include = false;
        for(int i=0; i<range.length; ++i) {
            if(range[i] == c) {
                include = true;
                break;
            }
        }
        return include;
    }
    
    private boolean readChar(char c)  {
        boolean moveCur = true;
        Type createType = null;
        if(state == State.Normal) {
                   if(inIdentifierSetButNotRear(c)) {
                        state = State.Identifier;
                    }
                    else if(SignParser.inCharSet(c)) {
                        state = State.Sign;
                    }
                    else if(c == '\"' | c == '\'') {
                        state = State.String;
                        transferredMeaningSign = false;

                    }
                    else if(include(Space, c)) {
                        state = State.Space;
                    }
                    else if(c == '\n') {
                        createType = Type.NewLine;
                    }
                    else if(c == '\0') {
                        createType = Type.EndSymbol;
                    }
                    else {
                        throw new LexerException(c);
                    }
                    refreshBuffer(c);
        }
        else if(state == State.Identifier) {
            
        } 
        else if(state == State.Sign) {
            
        }
        else if(state == State.String) {

                if(c == '\n') {
                    throw new LexicalAnalysisException(c);
                    
                } else if(c == '\0') {
                    throw new LexicalAnalysisException(c);
                
                } else if(transferredMeaningSign) {
                    
                    Character tms = StringTMMap.get(c);
                    if(tms == null) {
                        throw new LexicalAnalysisException(c);
                    }
                    readBuffer.append(tms);
                    transferredMeaningSign = false;
                    
                } else if(c == '\\') {
                    transferredMeaningSign = true;
                    
                } else {
                    readBuffer.append(c);
                    char firstChar = readBuffer.charAt(0);
                    if(firstChar == c) {
                        createType = Type.String;
                        state = State.Normal;
                    }
                }
        }
        else if(state == State.Space) {
            
        }
        
        if(createType != null) {
            createToken(createType);
        }
        return moveCur;
    }


}
