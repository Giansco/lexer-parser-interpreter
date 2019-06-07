package parser.tree;

import parser.tree.literals.IdentifierNode;

public class AssignmentNode implements Node{

    private Node identifierNode;
    private Node expressionNode;
    //should have equals node???

    public AssignmentNode(Node identifierNode, Node expressionNode) {
        this.identifierNode = identifierNode;
        this.expressionNode = expressionNode;
    }

    public Node getIdentifierNode() {
        return identifierNode;
    }

    public Node getExpressionNode() {
        return expressionNode;
    }
}
