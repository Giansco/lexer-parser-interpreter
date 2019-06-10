package parser.tree;

import main.parser_interpreter.NodeVisitor;

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

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitAssignmentNode(this);
    }
}
