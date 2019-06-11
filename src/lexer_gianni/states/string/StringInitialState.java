package lexer_gianni.states.string;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class StringInitialState extends AbstractNormalLexerState {

    public StringInitialState() {
        super("StringInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 's') return new StringFirstState();
        else return new NoValidTransitionState();
    }
}
