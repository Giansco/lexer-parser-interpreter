package lexer.states.number;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class NumberSecondState extends AbstractNormalLexerState {

    public NumberSecondState() {
        super("NumberSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'm') return new NumberThirdState();
        else return new NoValidTransitionState();
    }
}
