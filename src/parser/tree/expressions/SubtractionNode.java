package parser.tree.expressions;

import main.parser_interpreter.NodeVisitor;
import parser.tree.Node;
import parser.tree.OperationNode;

public class SubtractionNode extends OperationNode {

    public SubtractionNode(Node expression, Node term) {
        super(expression, term);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitSubtractionExpressionNode(this);
    }
}
