package lexer.states.number;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class NumberThirdState extends AbstractNormalLexerState {

    public NumberThirdState() {
        super("NumberThirdState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'b') return new NumberFourthState();
        else return new NoValidTransitionState();
    }
}
