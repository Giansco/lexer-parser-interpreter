package lexer.states.string;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class StringSecondState extends AbstractNormalLexerState {

    public StringSecondState() {
        super("StringSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'r') return new StringThirdState();
        else return new NoValidTransitionState();
    }
}
