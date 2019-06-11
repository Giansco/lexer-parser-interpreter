package lexer_gianni.states.string;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class StringFifthState extends AbstractNormalLexerState {

    public StringFifthState() {
        super("StringFifthState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'g') return new StringSixthState();
        else return new NoValidTransitionState();
    }
}
