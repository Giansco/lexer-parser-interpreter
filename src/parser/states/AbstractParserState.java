package parser.states;

import parser.ASTNode;
import parser.ParserAutomata;

import java.util.Map;
import java.util.Stack;

public abstract class AbstractParserState implements ParserState {

    protected ParserAutomata automata;
    protected Map<ASTNode, ParserState> transitions;

    public AbstractParserState(ParserAutomata automata, Map<ASTNode, ParserState> transitions) {
        this.automata = automata;
        this.transitions = transitions;
    }

    @Override
    public Stack<ASTNode> handle(Stack<ASTNode> stack, ParserState previous) {

        ParserState parserState = transitions.get(stack.peek());

        automata.setState(parserState);

        return stack;
    }
}
