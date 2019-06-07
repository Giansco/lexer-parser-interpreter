package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.exc.InvalidStatementExc;
import parser.exc.StatementWithoutSemiColonExc;
import parser.exc.SyntaxErrorExc;
import parser.tree.Node;
import parser.tree.StatementNode;

import java.util.Map;

public class StatementHandler implements Handler {

    private Map<InputType, Handler> transitions;

    public StatementHandler(Map<InputType, Handler> transitions) {
        this.transitions = transitions;
    }

    @Override
    public Node handle(InputSupplier supplier){
        if (supplier.hasNext()){
            Input input = supplier.nextInput();
            if (!transitions.containsKey(input.getType())) throw new InvalidStatementExc();
            Node assignmentNode = transitions.get(input.getType()).handle(supplier);

            //Check statement finishes with semi-colon
            if (supplier.hasNext()){
                Input lookAhead = supplier.nextInput();
                if (lookAhead.getType() == InputType.SEMI_COLON) supplier.advance();
                else throw new StatementWithoutSemiColonExc();
            }else {
                throw new StatementWithoutSemiColonExc();
            }

            return new StatementNode(assignmentNode);
        }

        throw new SyntaxErrorExc();
    }
}
