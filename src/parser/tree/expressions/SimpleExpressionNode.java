package parser.tree.expressions;

import parser.tree.Node;
import parser.tree.expressions.ExpressionNode;

public class SimpleExpressionNode implements ExpressionNode {

    private Node child;

    public SimpleExpressionNode(Node child) {
        this.child = child;
    }
}
