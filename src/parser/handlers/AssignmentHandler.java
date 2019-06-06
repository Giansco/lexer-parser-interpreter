package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.tree.*;

public class AssignmentHandler implements Handler{

    private ExpressionHandler handler;

    public AssignmentHandler(ExpressionHandler handler) {
        this.handler = handler;
    }

    @Override
    public Node handle(InputSupplier supplier){
        if (supplier.hasNext()){
            Input identifier = supplier.nextInput();
            supplier.advance();
            Input equals = supplier.nextInput();
            supplier.advance();

            if (identifier.getType() == InputType.IDENTIFIER && equals.getType() == InputType.EQUALS){
                Node expressionNode = handler.handle(supplier);
                return new AssignmentNode(new IdentifierNode(identifier.getValue()), new EqualsNode(), expressionNode);
            }
        }
    }
}
