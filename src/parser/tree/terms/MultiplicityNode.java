package parser.tree.terms;

import main.parser_interpreter.NodeVisitor;
import parser.tree.Node;
import parser.tree.OperationNode;

public class MultiplicityNode extends OperationNode {

    public MultiplicityNode(Node term, Node literal) {
        super(term, literal);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitMultiplicityTermNode(this);
    }
}
