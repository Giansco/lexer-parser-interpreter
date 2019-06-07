package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.exc.InvalidAssignmentExc;
import parser.exc.SyntaxErrorExc;
import parser.tree.*;
import parser.tree.literals.IdentifierNode;

public class AssignmentHandler implements Handler{

    private Handler expressionHandler;
    private Handler literalHandler;

    public AssignmentHandler(Handler expressionHandler, Handler literalHandler) {
        this.expressionHandler = expressionHandler;
        this.literalHandler = literalHandler;
    }

    @Override
    public Node handle(InputSupplier supplier){
        if (supplier.hasNext()){

            Node identifierNode = literalHandler.handle(supplier);
            Input equals = supplier.nextInput();//should check hasNext again
            supplier.advance();

            if (equals.getType() == InputType.EQUALS){
                Node expressionNode = expressionHandler.handle(supplier);
                return new AssignmentNode(identifierNode, expressionNode);
            }else {
                throw new InvalidAssignmentExc();
            }
        }

        throw new SyntaxErrorExc();
    }
}
