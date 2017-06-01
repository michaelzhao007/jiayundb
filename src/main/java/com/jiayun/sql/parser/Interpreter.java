package com.jiayun.sql.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.antlr.v4.runtime.UnbufferedTokenStream;

import com.jiayun.internal.JiayunDB;
import com.jiayun.internal.Table;
import com.jiayun.internal.Value;
import com.sun.rowset.internal.Row;

public class Interpreter {
    public QBaseListener listener = // default response to messages
            new QBaseListener() {
                public void info(String msg) { System.out.println(msg); }
                public void error(String msg) { System.err.println(msg); }
                public void error(String msg, Exception e) {
                    error(msg); e.printStackTrace(System.err);
                }
                public void error(String msg, Token t) {
                    error("line "+t.getLine()+": "+msg);
                }
            };
            
	 JiayunDB db;
    public Object tables;
	 
	 public Interpreter() {
		 this.db = new JiayunDB();
	 }
	 
	 
	 
	 public void interp(InputStream input) throws RecognitionException, IOException {
	        QLexer lex = new QLexer(new UnbufferedCharStream(input));
	        CommonTokenFactory tokenFactory = new CommonTokenFactory(true);
	        lex.setTokenFactory(tokenFactory);
	        QParser parser = new QParser(new InterpreterTokenStream(lex), new Interpreter());
	        parser.program();
	        // System.out.println(tables);
	    }

	    public void createTable(String name)
	    {
	    	db.createTable(name);
	    }
	    
	    public Table getTable(String name) {
	    	return db.getTable(name);
	    }



        public void insertInto(String name,  String val) {
            Table table = db.getTable(name);
            table.insertIntoTable(val);           
        }

}
