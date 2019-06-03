package lexer.states.print;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class PrintInitialState extends AbstractNormalLexerState {

    public PrintInitialState() {
        super("PrintInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'p') return new PrintFirstState();
        else return new NoValidTransitionState();
    }
}
