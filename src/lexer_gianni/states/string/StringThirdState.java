package lexer_gianni.states.string;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class StringThirdState extends AbstractNormalLexerState {

    public StringThirdState() {
        super("StringThirdState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'i') return new StringFourthState();
        else return new NoValidTransitionState();
    }
}
