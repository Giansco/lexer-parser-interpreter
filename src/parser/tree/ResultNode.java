package parser.tree;

import main.parser_interpreter.NodeVisitor;

import java.util.List;

public class ResultNode implements Node {

    private List<Node> children;

    public ResultNode(List<Node> children) {
        this.children = children;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitResultNode(this);
    }
}
