package parser;

import java.util.List;

public class TerminalNode implements ASTNode {

    private ParserType type;
    private String value;

    public TerminalNode(ParserType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TerminalNode(ParserType type) {
        this.type = type;
        this.value = null;
    }

    @Override
    public List<ASTNode> getChildren() {
        return null;
    }

    @Override
    public ParserType getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }
}
