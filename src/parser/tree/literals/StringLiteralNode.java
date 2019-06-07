package parser.tree.literals;

import parser.tree.literals.LiteralNode;

public class StringLiteralNode implements LiteralNode {

    private String value;

    public StringLiteralNode(String value) {
        this.value = value;
    }
}
