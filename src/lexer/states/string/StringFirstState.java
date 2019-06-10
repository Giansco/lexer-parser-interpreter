package lexer.states.string;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class StringFirstState extends AbstractNormalLexerState {

    public StringFirstState() {
        super("StringFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 't') return new StringSecondState();
        else return new NoValidTransitionState();
    }
}
