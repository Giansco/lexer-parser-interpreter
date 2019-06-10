package parser.tree.declarations;

import main.parser_interpreter.NodeVisitor;
import parser.tree.Node;

public class AssignedDeclarationNode implements DeclarationNode {

    private Node identifier;
    private Node type;
    private Node expression;

    public AssignedDeclarationNode(Node identifier, Node type, Node expression) {
        this.identifier = identifier;
        this.type = type;
        this.expression = expression;
    }

    public Node getIdentifier() {
        return identifier;
    }

    public Node getType() {
        return type;
    }

    public Node getExpression() {
        return expression;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitAssignedDeclarationNode(this);
    }
}
