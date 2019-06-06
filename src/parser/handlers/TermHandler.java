package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.tree.Node;

public class TermHandler implements Handler {

    @Override
    public Node handle(InputSupplier supplier) {
        if (supplier.hasNext()){
            Input input = supplier.nextInput();
        }
    }
}
