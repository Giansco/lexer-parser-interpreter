package parser.tree.literals;

import parser.tree.literals.LiteralNode;

public class IdentifierNode implements LiteralNode {

    private String value;

    public IdentifierNode(String value) {
        this.value = value;
    }
}
