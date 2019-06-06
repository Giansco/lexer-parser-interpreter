package parser.states;

import parser.ASTNode;
import parser.ParserAutomata;

import java.util.Map;
import java.util.Stack;

public class TransitionState extends AbstractParserState {

    private Map<ASTNode, ParserState> transitions;

    public TransitionState(ParserAutomata automata, Map<ASTNode, ParserState> transitions) {
        super(automata);
        this.transitions = transitions;
    }

    @Override
    public Stack<ASTNode> handle(Stack<ASTNode> stack, ParserState previous) {

        ParserState parserState = transitions.get(stack.peek());

        automata.setState(parserState);

        return parserState.handle(stack, this);
    }

    @Override
    public boolean isAcceptingState() {
        return false;
    }
}
