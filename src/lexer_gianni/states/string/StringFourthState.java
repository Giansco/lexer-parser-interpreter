package lexer_gianni.states.string;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class StringFourthState extends AbstractNormalLexerState {

    public StringFourthState() {
        super("StringFourthState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'n') return new StringFifthState();
        else return new NoValidTransitionState();
    }
}
