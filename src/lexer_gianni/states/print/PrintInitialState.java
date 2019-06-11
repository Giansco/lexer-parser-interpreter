package lexer_gianni.states.print;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
