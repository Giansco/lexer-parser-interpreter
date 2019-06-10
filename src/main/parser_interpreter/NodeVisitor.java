package main.parser_interpreter;

import parser.tree.*;
import parser.tree.declarations.AssignedDeclarationNode;
import parser.tree.declarations.UnassignedDeclarationNode;
import parser.tree.expressions.AdditionNode;
import parser.tree.expressions.SimpleExpressionNode;
import parser.tree.expressions.SubtractionNode;
import parser.tree.literals.IdentifierNode;
import parser.tree.literals.NumberLiteralNode;
import parser.tree.literals.StringLiteralNode;
import parser.tree.terms.DivisionNode;
import parser.tree.terms.MultiplicityNode;
import parser.tree.terms.SimpleTermNode;
import parser.tree.types.NumberTypeNode;
import parser.tree.types.StringTypeNode;

public interface NodeVisitor {

    void visitNode(Node node);
    void visitResultNode(ResultNode node);
    void visitStatementNode(StatementNode node);
    void visitAssignedDeclarationNode(AssignedDeclarationNode node);
    void visitUnassignedDeclarationNode(UnassignedDeclarationNode node);
    void visitAssignmentNode(AssignmentNode node);
    void visitPrintNode(PrintNode node);
    void visitIdentifierNode(IdentifierNode node);
    void visitStringTypeNode(StringTypeNode node);
    void visitNumberTypeNode(NumberTypeNode node);
    void visitSimpleExpressionNode(SimpleExpressionNode node);
    void visitAdditionExpressionNode(AdditionNode node);
    void visitSubtractionExpressionNode(SubtractionNode node);
    void visitSimpleTermNode(SimpleTermNode node);
    void visitDivisionTermNode(DivisionNode node);
    void visitMultiplicityTermNode(MultiplicityNode node);
    void visitStringLiteralNode(StringLiteralNode node);
    void visitNumberLiteralNode(NumberLiteralNode node);

}
