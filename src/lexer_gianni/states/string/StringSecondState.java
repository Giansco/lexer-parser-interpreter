package lexer_gianni.states.string;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class StringSecondState extends AbstractNormalLexerState {

    public StringSecondState() {
        super("StringSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'r') return new StringThirdState();
        else return new NoValidTransitionState();
    }
}
