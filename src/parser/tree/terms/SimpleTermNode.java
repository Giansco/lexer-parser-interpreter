package parser.tree.terms;

import main.parser_interpreter.NodeVisitor;
import parser.tree.Node;

public class SimpleTermNode implements TermNode {

    private Node child;

    public SimpleTermNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitSimpleTermNode(this);
    }
}
