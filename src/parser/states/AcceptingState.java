package parser.states;

import parser.ASTNode;
import parser.ParserAutomata;

import java.util.Stack;

public class AcceptingState extends AbstractParserState{

    public AcceptingState(ParserAutomata automata) {
        super(automata);
    }

    @Override
    public Stack<ASTNode> handle(Stack<ASTNode> stack, ParserState previous) {
        return null;
    }

    @Override
    public boolean isAcceptingState() {
        return true;
    }
}
