package parser.tree;

import main.parser_interpreter.NodeVisitor;

public class PrintNode implements Node {

    private Node expressionNode;

    public PrintNode(Node expressionNode) {
        this.expressionNode = expressionNode;
    }

    public Node getExpressionNode() {
        return expressionNode;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitPrintNode(this);
    }
}
