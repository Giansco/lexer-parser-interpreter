package lexer_gianni.states.number;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class NumberFirstState extends AbstractNormalLexerState {

    public NumberFirstState() {
        super("NumberFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'u') return new NumberSecondState();
        else return new NoValidTransitionState();
    }
}
