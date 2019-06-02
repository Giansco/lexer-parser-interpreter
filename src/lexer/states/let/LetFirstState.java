package lexer.states.let;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class LetFirstState extends AbstractNormalLexerState {


    public LetFirstState() {
        super("LetFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'e') return new LetSecondState();
        else return new NoValidTransitionState();
    }
}
