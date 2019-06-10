package parser.tree.types;

import main.parser_interpreter.NodeVisitor;

public class StringTypeNode implements TypeNode {

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitStringTypeNode(this);
    }
}
