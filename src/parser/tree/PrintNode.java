package parser.tree;

public class PrintNode implements Node {

    Node expressionNode;

    public PrintNode(Node expressionNode) {
        this.expressionNode = expressionNode;
    }

    public Node getExpressionNode() {
        return expressionNode;
    }
}
