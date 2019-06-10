package lexer.states.let;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class LetThirdState extends AbstractAcceptingLexerState {

    public LetThirdState() {
        super("LetThirdState");
    }

    @Override
    public LexerState nextState(char input) {
//        if (input == 't') return new LetThirdState();
        return new NoValidTransitionState();
    }
}
