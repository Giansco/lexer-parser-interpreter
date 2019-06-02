package lexer.states.number;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class NumberFourthState extends AbstractNormalLexerState {

    public NumberFourthState() {
        super("NumberFourthState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'e') return new NumberFifthState();
        else return new NoValidTransitionState();
    }
}
