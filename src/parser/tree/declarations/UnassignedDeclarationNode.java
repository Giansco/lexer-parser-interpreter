package parser.tree.declarations;

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
}