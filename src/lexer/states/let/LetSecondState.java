package lexer.states.let;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class LetSecondState extends AbstractNormalLexerState {

    public LetSecondState() {
        super("LetSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 't') return new LetThirdState();
        else return new NoValidTransitionState();
    }
}
