package parser.tree.expressions;

import parser.tree.Node;
import parser.tree.OperationNode;

public class SubtractionNode extends OperationNode {

    public SubtractionNode(Node expression, Node term) {
        super(expression, term);
    }
}
