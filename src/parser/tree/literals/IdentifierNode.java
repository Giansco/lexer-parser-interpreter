package parser.tree.literals;

import main.parser_interpreter.NodeVisitor;

public class IdentifierNode implements LiteralNode {

    private String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitIdentifierNode(this);
    }
}
