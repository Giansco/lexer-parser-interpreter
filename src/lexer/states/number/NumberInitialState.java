package lexer.states.number;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class NumberInitialState extends AbstractNormalLexerState {

    public NumberInitialState() {
        super("NumberInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'n') return new NumberFirstState();
        else return new NoValidTransitionState();
    }
}
