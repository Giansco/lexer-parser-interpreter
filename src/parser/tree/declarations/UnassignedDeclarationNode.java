package parser.tree.declarations;

import main.parser_interpreter.NodeVisitor;
import parser.tree.Node;

public class UnassignedDeclarationNode implements DeclarationNode {

    private Node identifier;
    private Node type;

    public UnassignedDeclarationNode(Node identifier, Node type) {
        this.identifier = identifier;
        this.type = type;
    }

    public Node getIdentifier() {
        return identifier;
    }

    public Node getType() {
        return type;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitUnassignedDeclarationNode(this);
    }
}
