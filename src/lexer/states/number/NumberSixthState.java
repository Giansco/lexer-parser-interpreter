package lexer.states.number;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class NumberSixthState extends AbstractAcceptingLexerState {

    public NumberSixthState() {
        super("NumberSixthState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
