package lexer_gianni.states.number;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class NumberSixthState extends AbstractAcceptingLexerState {

    public NumberSixthState() {
        super("NumberSixthState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
