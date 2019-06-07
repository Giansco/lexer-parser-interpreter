package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.exc.InvalidTypeExc;
import parser.exc.SyntaxErrorExc;
import parser.tree.Node;
import parser.tree.types.NumberTypeNode;
import parser.tree.types.StringTypeNode;

public class TypeHandler implements Handler {


    @Override
    public Node handle(InputSupplier supplier) {
        if (supplier.hasNext()){
            Input type = supplier.nextInput();
            supplier.advance();
            if (type.getType() == InputType.STRING) return new StringTypeNode();
            else if (type.getType() == InputType.NUMBER) return new NumberTypeNode();
            else throw new InvalidTypeExc();
        }

        throw new SyntaxErrorExc();
    }
}
