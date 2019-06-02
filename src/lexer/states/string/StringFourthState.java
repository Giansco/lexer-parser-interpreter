package lexer.states.string;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
