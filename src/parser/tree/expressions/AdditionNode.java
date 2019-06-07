package parser.tree.expressions;

import parser.tree.Node;
import parser.tree.OperationNode;

public class AdditionNode extends OperationNode {

    public AdditionNode(Node expression, Node term) {
        super(expression, term);
    }
}
