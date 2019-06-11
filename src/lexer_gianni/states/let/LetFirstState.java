package lexer_gianni.states.let;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class LetFirstState extends AbstractNormalLexerState {


    public LetFirstState() {
        super("LetFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'e') return new LetSecondState();
        else return new NoValidTransitionState();
    }
}
