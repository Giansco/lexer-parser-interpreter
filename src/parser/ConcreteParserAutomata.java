package parser;

import parser.states.ParserState;

import java.util.List;
import java.util.Stack;

public class ConcreteParserAutomata implements ParserAutomata {

    ParserState currentState;
    Stack<ASTNode> stack;

    public ConcreteParserAutomata(ParserState initialState) {
        this.currentState = initialState;
    }

    @Override
    public void setState(ParserState state) {
        this.currentState = state;
        this.stack = new Stack<>();
    }

    @Override
    public ASTNode run(List<ASTNode> input) {
        stack.push(new TerminalNode(ParserType.$));

        stack.push(input.get(0));

        stack = this.currentState.handle(stack, currentState);
    }
}
