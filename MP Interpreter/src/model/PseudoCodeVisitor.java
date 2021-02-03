// Generated from C:/Users/erwin/Desktop/CMPILER/MP-Interpreter2/MP Interpreter/src\PseudoCode.g4 by ANTLR 4.9
package model;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PseudoCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PseudoCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(PseudoCodeParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(PseudoCodeParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#mainDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDeclaration(PseudoCodeParser.MainDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(PseudoCodeParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(PseudoCodeParser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(PseudoCodeParser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(PseudoCodeParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(PseudoCodeParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(PseudoCodeParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(PseudoCodeParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(PseudoCodeParser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(PseudoCodeParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(PseudoCodeParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PseudoCodeParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PseudoCodeParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(PseudoCodeParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(PseudoCodeParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(PseudoCodeParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PseudoCodeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(PseudoCodeParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#forheader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForheader(PseudoCodeParser.ForheaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#forinitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForinitializer(PseudoCodeParser.ForinitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#customAssignError}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomAssignError(PseudoCodeParser.CustomAssignErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(PseudoCodeParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(PseudoCodeParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(PseudoCodeParser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#printInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintInvocation(PseudoCodeParser.PrintInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#scanInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScanInvocation(PseudoCodeParser.ScanInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(PseudoCodeParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(PseudoCodeParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(PseudoCodeParser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(PseudoCodeParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PseudoCodeParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PseudoCodeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(PseudoCodeParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(PseudoCodeParser.PrimaryContext ctx);
}