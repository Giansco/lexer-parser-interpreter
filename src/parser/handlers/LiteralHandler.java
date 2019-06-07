package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.exc.InvalidLiteralExc;
import parser.exc.SyntaxErrorExc;
import parser.tree.Node;
import parser.tree.literals.IdentifierNode;
import parser.tree.literals.NumberLiteralNode;
import parser.tree.literals.StringLiteralNode;

public class LiteralHandler implements Handler {

    public LiteralHandler() {
    }

    @Override
    public Node handle(InputSupplier supplier) {
        if (supplier.hasNext()){
            Input input = supplier.nextInput();
            supplier.advance();
            switch (input.getType()){
                case NUMERIC_LITERAL: return new NumberLiteralNode(Double.valueOf(input.getValue()));
                case STRING_LITERAL: return new StringLiteralNode(input.getValue());
                case IDENTIFIER: return new IdentifierNode(input.getValue());
                default: throw new InvalidLiteralExc();
            }
        }

        throw new SyntaxErrorExc();
    }
}
