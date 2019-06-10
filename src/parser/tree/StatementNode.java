package parser.tree;

import main.parser_interpreter.NodeVisitor;

public class StatementNode implements Node {

    private Node child;

    public StatementNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitStatementNode(this);
    }
}
