package parser.tree;

import java.util.List;

public class ResultNode implements Node {

    private List<Node> children;

    public ResultNode(List<Node> children) {
        this.children = children;
    }
}
