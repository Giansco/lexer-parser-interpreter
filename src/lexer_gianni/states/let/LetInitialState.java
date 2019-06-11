package lexer_gianni.states.let;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class LetInitialState extends AbstractNormalLexerState {

    public LetInitialState() {
        super("LetInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'l') return new LetFirstState();
        else return new NoValidTransitionState();
    }
}
