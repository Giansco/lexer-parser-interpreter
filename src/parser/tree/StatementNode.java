package parser.tree;

public class StatementNode implements Node {

    private Node child;

    public StatementNode(Node child) {
        this.child = child;
    }
}
