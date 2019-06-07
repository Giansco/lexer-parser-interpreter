package parser.tree;

import parser.tree.Node;

public abstract class OperationNode implements Node {

    private Node left;
    private Node right;

    public OperationNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
