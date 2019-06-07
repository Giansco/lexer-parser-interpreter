package parser.tree.terms;

import parser.tree.Node;
import parser.tree.OperationNode;

public class MultiplicityNode extends OperationNode {

    public MultiplicityNode(Node term, Node literal) {
        super(term, literal);
    }
}
