package lexer.states.string;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class StringSixthState extends AbstractAcceptingLexerState {

    public StringSixthState() {
        super("StringSixthState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
