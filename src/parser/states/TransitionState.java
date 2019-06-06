package parser.states;

import parser.ASTNode;
import parser.ParserAutomata;

import java.util.Map;
import java.util.Stack;

public class TransitionState extends AbstractParserState {

    private Map<ASTNode, ParserState> transitions;

    public TransitionState(ParserAutomata automata, Map<ASTNode, ParserState> transitions) {
        super(automata, transitions);
    }

    @Override
    public Stack<ASTNode> handle(Stack<ASTNode> stack, ParserState previous) {

        return super.handle(stack,previous);
    }

    @Override
    public boolean isAcceptingState() {
        return false;
    }
}
