package lexer.states.string;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
