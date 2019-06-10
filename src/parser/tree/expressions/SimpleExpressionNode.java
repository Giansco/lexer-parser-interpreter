package parser.tree.expressions;

import main.parser_interpreter.NodeVisitor;
import parser.tree.Node;

public class SimpleExpressionNode implements ExpressionNode {

    private Node child;

    public SimpleExpressionNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitSimpleExpressionNode(this);
    }
}
