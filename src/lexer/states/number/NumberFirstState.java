package lexer.states.number;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class NumberFirstState extends AbstractNormalLexerState {

    public NumberFirstState() {
        super("NumberFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'u') return new NumberSecondState();
        else return new NoValidTransitionState();
    }
}
