package lexer_gianni.states.number;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class NumberInitialState extends AbstractNormalLexerState {

    public NumberInitialState() {
        super("NumberInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'n') return new NumberFirstState();
        else return new NoValidTransitionState();
    }
}
