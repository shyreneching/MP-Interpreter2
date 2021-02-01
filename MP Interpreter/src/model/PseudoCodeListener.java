// Generated from C:/Users/Erika Y Chan/Kae/School Stuff/CMPILER S11/MP - Interpreter/MP v2/MP-Interpreter2/MP Interpreter/src\PseudoCode.g4 by ANTLR 4.9.1
package model;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PseudoCodeParser}.
 */
public interface PseudoCodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(PseudoCodeParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(PseudoCodeParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(PseudoCodeParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(PseudoCodeParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#mainDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMainDeclaration(PseudoCodeParser.MainDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#mainDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMainDeclaration(PseudoCodeParser.MainDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(PseudoCodeParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(PseudoCodeParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(PseudoCodeParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(PseudoCodeParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(PseudoCodeParser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(PseudoCodeParser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(PseudoCodeParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(PseudoCodeParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(PseudoCodeParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(PseudoCodeParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(PseudoCodeParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(PseudoCodeParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(PseudoCodeParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(PseudoCodeParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(PseudoCodeParser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(PseudoCodeParser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(PseudoCodeParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(PseudoCodeParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(PseudoCodeParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(PseudoCodeParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PseudoCodeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PseudoCodeParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PseudoCodeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PseudoCodeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(PseudoCodeParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(PseudoCodeParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(PseudoCodeParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(PseudoCodeParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(PseudoCodeParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(PseudoCodeParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PseudoCodeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PseudoCodeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(PseudoCodeParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(PseudoCodeParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#forheader}.
	 * @param ctx the parse tree
	 */
	void enterForheader(PseudoCodeParser.ForheaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#forheader}.
	 * @param ctx the parse tree
	 */
	void exitForheader(PseudoCodeParser.ForheaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#forinitializer}.
	 * @param ctx the parse tree
	 */
	void enterForinitializer(PseudoCodeParser.ForinitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#forinitializer}.
	 * @param ctx the parse tree
	 */
	void exitForinitializer(PseudoCodeParser.ForinitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#customAssignError}.
	 * @param ctx the parse tree
	 */
	void enterCustomAssignError(PseudoCodeParser.CustomAssignErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#customAssignError}.
	 * @param ctx the parse tree
	 */
	void exitCustomAssignError(PseudoCodeParser.CustomAssignErrorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(PseudoCodeParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(PseudoCodeParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(PseudoCodeParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(PseudoCodeParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(PseudoCodeParser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(PseudoCodeParser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#printInvocation}.
	 * @param ctx the parse tree
	 */
	void enterPrintInvocation(PseudoCodeParser.PrintInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#printInvocation}.
	 * @param ctx the parse tree
	 */
	void exitPrintInvocation(PseudoCodeParser.PrintInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#scanInvocation}.
	 * @param ctx the parse tree
	 */
	void enterScanInvocation(PseudoCodeParser.ScanInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#scanInvocation}.
	 * @param ctx the parse tree
	 */
	void exitScanInvocation(PseudoCodeParser.ScanInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(PseudoCodeParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(PseudoCodeParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(PseudoCodeParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(PseudoCodeParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(PseudoCodeParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(PseudoCodeParser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(PseudoCodeParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(PseudoCodeParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PseudoCodeParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PseudoCodeParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PseudoCodeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PseudoCodeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(PseudoCodeParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(PseudoCodeParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseudoCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(PseudoCodeParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseudoCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(PseudoCodeParser.PrimaryContext ctx);
}