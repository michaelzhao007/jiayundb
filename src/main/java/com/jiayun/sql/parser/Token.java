package com.jiayun.sql.parser;

import java.util.HashSet;

public class Token {
    private static final HashSet<String> keywordSet = new HashSet<String>();
    
    static {
        keywordSet.add("select");
        keywordSet.add("from");
        keywordSet.add("table");
        keywordSet.add("create");
        keywordSet.add("values");
        keywordSet.add("where");
        keywordSet.add("valequal");
        keywordSet.add("insert");
        keywordSet.add("into");
    }
    
    public static enum Type {
        Keyword, Number, Identifier, Sign, String, Space, NewLine,  EndSymbol;
    }
    
    final Type type;
    final String value;
    
    Token(Type type, String value) {
        if(type == Type.Identifier) {
            char firstchar = value.charAt(0);
            if(firstchar >= '0' & firstchar <= '9') {
                type = Type.Number;
            }
            else if(keywordSet.contains(value)) {
                type = Type.Keyword;
            }
        }
        else if(type == Type.String) {
            value = value.substring(1, value.length()-1);
        }
        else if(type == Type.EndSymbol) {
            value = null;
        }
        this.type = type;
        this.value = value;
    }
    
    @Override 
    public String toString() {
        return String.format("%s(%s) ", type, value);
    }

}
