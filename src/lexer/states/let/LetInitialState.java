package lexer.states.let;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class LetInitialState extends AbstractNormalLexerState {

    public LetInitialState() {
        super("LetInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'l') return new LetFirstState();
        else return new NoValidTransitionState();
    }
}
