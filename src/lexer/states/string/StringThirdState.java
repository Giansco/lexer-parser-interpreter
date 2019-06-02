package lexer.states.string;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class StringThirdState extends AbstractNormalLexerState {

    public StringThirdState() {
        super("StringThirdState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'i') return new StringFourthState();
        else return new NoValidTransitionState();
    }
}
