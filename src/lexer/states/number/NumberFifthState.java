package lexer.states.number;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class NumberFifthState extends AbstractNormalLexerState {

    public NumberFifthState() {
        super("NumberFifthState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'r') return new NumberSixthState();
        else return new NoValidTransitionState();
    }
}
