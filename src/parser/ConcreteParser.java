package parser;

import parser.handlers.Handler;
import parser.tree.Node;

public class ConcreteParser implements Parser {

    private Handler statementHandler;

    public ConcreteParser(Handler statementHandler) {
        this.statementHandler = statementHandler;
    }

    @Override
    public Node parse(InputSupplier supplier) {
        return statementHandler.handle(supplier);
    }
}
