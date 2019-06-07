package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.exc.SyntaxErrorExc;
import parser.tree.Node;
import parser.tree.terms.DivisionNode;
import parser.tree.terms.MultiplicityNode;
import parser.tree.terms.SimpleTermNode;
import parser.tree.literals.StringLiteralNode;

public class TermHandler implements Handler {

    private Handler literalHandler;

    public TermHandler(Handler literalHandler) {
        this.literalHandler = literalHandler;
    }

    @Override
    public Node handle(InputSupplier supplier) {

        Node literalNode = literalHandler.handle(supplier);
        Node termNode = new SimpleTermNode(literalNode); //Add expression node
        if (supplier.hasNext()){
            Input input = supplier.nextInput();
            if (input.getType() == InputType.DIVIDE){
                supplier.advance();
                Node literalNode2 = literalHandler.handle(supplier);
                return new DivisionNode(termNode, literalNode2);
            }else if (input.getType() == InputType.MULTIPLY){
                supplier.advance();
                Node literalNode2 = literalHandler.handle(supplier);
                return new MultiplicityNode(termNode, literalNode2);
            }else{
                //not an operator
                return termNode;
            }
        }else {
            return termNode;
        }
    }
}
