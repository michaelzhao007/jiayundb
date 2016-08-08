// Generated from Q.g4 by ANTLR 4.5.3
package com.jiayun.sql.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QParser}.
 */
public interface QListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(QParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link QParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(QParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link QParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(QParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(QParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QParser#create}.
	 * @param ctx the parse tree
	 */
	void enterCreate(QParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QParser#create}.
	 * @param ctx the parse tree
	 */
	void exitCreate(QParser.CreateContext ctx);
}