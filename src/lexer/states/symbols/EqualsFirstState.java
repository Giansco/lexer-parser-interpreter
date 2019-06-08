package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class EqualsFirstState extends AbstractAcceptingLexerState {


    public EqualsFirstState() {
        super("EqualsFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
