// Generated from /home/foo/synced/uwu-lang/src/main/kotlin/UwULang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UwULangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UwULangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UwULangParser#nameTypePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameTypePair(UwULangParser.NameTypePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct(UwULangParser.StructContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(UwULangParser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(UwULangParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(UwULangParser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(UwULangParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(UwULangParser.MulOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(UwULangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(UwULangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(UwULangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(UwULangParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#variableAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssign(UwULangParser.VariableAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#multiStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiStatement(UwULangParser.MultiStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(UwULangParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#impt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpt(UwULangParser.ImptContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#new}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(UwULangParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by {@link UwULangParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(UwULangParser.FileContext ctx);
}