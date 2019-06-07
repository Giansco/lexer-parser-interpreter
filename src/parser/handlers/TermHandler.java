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
        Node termNode = new SimpleTermNode(literalNode); //Add term node
        if (supplier.hasNext()){
            return recursiveHandle(termNode, supplier);
        }else {
            return termNode;
        }
    }

    private Node recursiveHandle(Node term, InputSupplier supplier){

        Input input = supplier.nextInput();
        if (input.getType() == InputType.DIVIDE){
            supplier.advance();
            Node literalNode = literalHandler.handle(supplier);
            return recursiveHandle(new DivisionNode(term, literalNode), supplier);
        }else if (input.getType() == InputType.MULTIPLY){
            supplier.advance();
            Node literalNode = literalHandler.handle(supplier);
            return recursiveHandle(new MultiplicityNode(term, literalNode), supplier);
        }else{
            //not an operator
            return term;
        }
    }
}
