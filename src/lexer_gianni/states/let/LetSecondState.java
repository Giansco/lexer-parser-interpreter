package lexer_gianni.states.let;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class LetSecondState extends AbstractNormalLexerState {

    public LetSecondState() {
        super("LetSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 't') return new LetThirdState();
        else return new NoValidTransitionState();
    }
}
