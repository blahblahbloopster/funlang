// Generated from /home/foo/synced/uwu-lang/src/main/kotlin/UwULang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UwULangParser}.
 */
public interface UwULangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UwULangParser#nameTypePair}.
	 * @param ctx the parse tree
	 */
	void enterNameTypePair(UwULangParser.NameTypePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#nameTypePair}.
	 * @param ctx the parse tree
	 */
	void exitNameTypePair(UwULangParser.NameTypePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#struct}.
	 * @param ctx the parse tree
	 */
	void enterStruct(UwULangParser.StructContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#struct}.
	 * @param ctx the parse tree
	 */
	void exitStruct(UwULangParser.StructContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(UwULangParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(UwULangParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(UwULangParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(UwULangParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(UwULangParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(UwULangParser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(UwULangParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(UwULangParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(UwULangParser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(UwULangParser.MulOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(UwULangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(UwULangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(UwULangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(UwULangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(UwULangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(UwULangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(UwULangParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(UwULangParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#variableAssign}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssign(UwULangParser.VariableAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#variableAssign}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssign(UwULangParser.VariableAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#multiStatement}.
	 * @param ctx the parse tree
	 */
	void enterMultiStatement(UwULangParser.MultiStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#multiStatement}.
	 * @param ctx the parse tree
	 */
	void exitMultiStatement(UwULangParser.MultiStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(UwULangParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(UwULangParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#impt}.
	 * @param ctx the parse tree
	 */
	void enterImpt(UwULangParser.ImptContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#impt}.
	 * @param ctx the parse tree
	 */
	void exitImpt(UwULangParser.ImptContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#new}.
	 * @param ctx the parse tree
	 */
	void enterNew(UwULangParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#new}.
	 * @param ctx the parse tree
	 */
	void exitNew(UwULangParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by {@link UwULangParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(UwULangParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link UwULangParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(UwULangParser.FileContext ctx);
}