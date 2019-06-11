package lexer_gianni.states.let;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class LetThirdState extends AbstractAcceptingLexerState {

    public LetThirdState() {
        super("LetThirdState");
    }

    @Override
    public LexerState nextState(char input) {
//        if (input == 't') return new LetThirdState();
        return new NoValidTransitionState();
    }
}
