package parser.tree.literals;

import main.parser_interpreter.NodeVisitor;

public class StringLiteralNode implements LiteralNode {

    private String value;

    public StringLiteralNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitStringLiteralNode(this);
    }
}
