package parser;

import parser.handlers.Handler;
import parser.tree.Node;

public class ConcreteParser implements Parser {

    private Handler resultHandler;

    public ConcreteParser(Handler resultHandler) {
        this.resultHandler = resultHandler;
    }

    @Override
    public Node parse(InputSupplier supplier) {
        return resultHandler.handle(supplier);
    }
}
