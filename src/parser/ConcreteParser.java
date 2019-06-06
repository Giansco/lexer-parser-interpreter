package parser;

import java.util.Stack;

public class ConcreteParser implements Parser {

    private ParserAutomata automata;

    public ConcreteParser(ParserAutomata automata) {
        this.automata = automata;
    }

    @Override
    public ASTNode parse(ASTNodeSupplier supplier) {
        return automata.run(supplier.getASTNodes());
    }
}
