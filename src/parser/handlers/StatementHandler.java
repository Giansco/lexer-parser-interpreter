package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
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
            supplier.advance();
            Node assignmentNode = transitions.get(input.getType()).handle(supplier);
            return new StatementNode(assignmentNode);
        }

    }
}
