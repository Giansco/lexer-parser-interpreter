package parser.tree.types;

import main.parser_interpreter.NodeVisitor;

public class NumberTypeNode implements TypeNode {

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitNumberTypeNode(this);
    }
}
