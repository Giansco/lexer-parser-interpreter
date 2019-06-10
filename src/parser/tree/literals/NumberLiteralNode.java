package parser.tree.literals;

import main.parser_interpreter.NodeVisitor;

public class NumberLiteralNode implements LiteralNode {

    private Double value;

    public NumberLiteralNode(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitNumberLiteralNode(this);
    }
}
