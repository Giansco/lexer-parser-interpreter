package lexer_gianni.states.number;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class NumberThirdState extends AbstractNormalLexerState {

    public NumberThirdState() {
        super("NumberThirdState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'b') return new NumberFourthState();
        else return new NoValidTransitionState();
    }
}
