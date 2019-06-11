package lexer_gianni.states.number;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class NumberFifthState extends AbstractNormalLexerState {

    public NumberFifthState() {
        super("NumberFifthState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'r') return new NumberSixthState();
        else return new NoValidTransitionState();
    }
}
