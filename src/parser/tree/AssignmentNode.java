package parser.tree;

import com.sun.org.apache.xpath.internal.ExpressionNode;

public class AssignmentNode implements Node{

    private IdentifierNode identifierNode;
    private EqualsNode equalsNode;
    private Node expressionNode;

    public AssignmentNode(IdentifierNode identifierNode, EqualsNode equalsNode, Node expressionNode) {
        this.identifierNode = identifierNode;
        this.equalsNode = equalsNode;
        this.expressionNode = expressionNode;
    }
}
