package parser.tree.literals;

import parser.tree.literals.LiteralNode;

public class NumberLiteralNode implements LiteralNode {

    private Double value;

    public NumberLiteralNode(Double value) {
        this.value = value;
    }
}
