package lexer_gianni.states.string;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class StringFirstState extends AbstractNormalLexerState {

    public StringFirstState() {
        super("StringFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 't') return new StringSecondState();
        else return new NoValidTransitionState();
    }
}
