package lexer_gianni.states.number;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class NumberSecondState extends AbstractNormalLexerState {

    public NumberSecondState() {
        super("NumberSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'm') return new NumberThirdState();
        else return new NoValidTransitionState();
    }
}
