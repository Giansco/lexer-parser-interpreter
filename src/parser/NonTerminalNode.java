package parser;

import java.util.List;

public class NonTerminalNode implements ASTNode {

    private List<ASTNode> children;
    private ParserType type;

    public NonTerminalNode(List<ASTNode> children, ParserType type) {
        this.children = children;
        this.type = type;
    }

    @Override
    public List<ASTNode> getChildren() {
        return children;
    }

    @Override
    public ParserType getType() {
        return type;
    }

    @Override
    public String getValue() {
        return null;
    }
}
