package lexer_gianni.states.number;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class NumberFourthState extends AbstractNormalLexerState {

    public NumberFourthState() {
        super("NumberFourthState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'e') return new NumberFifthState();
        else return new NoValidTransitionState();
    }
}
