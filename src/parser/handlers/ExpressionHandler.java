package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.tree.Node;

public class ExpressionHandler implements Handler {

    private TermHandler termHandler;

    public ExpressionHandler(TermHandler termHandler) {
        this.termHandler = termHandler;
    }

    @Override
    public Node handle(InputSupplier supplier) {

        Node termNode = termHandler.handle(supplier);
        if (supplier.hasNext()){
            Input input = supplier.nextInput();
            if (input.getType() == InputType.PLUS){

            }else if (input.getType() == InputType.MINUS){

            }else{

            }
        }
    }
}
