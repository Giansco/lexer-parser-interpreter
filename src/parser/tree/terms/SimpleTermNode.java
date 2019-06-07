package parser.tree.terms;

import parser.tree.Node;

public class SimpleTermNode implements TermNode {

    private Node child;

    public SimpleTermNode(Node child) {
        this.child = child;
    }
}
