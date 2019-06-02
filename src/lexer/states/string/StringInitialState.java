package lexer.states.string;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;
import lexer.states.let.LetFirstState;

public class StringInitialState extends AbstractNormalLexerState {

    public StringInitialState() {
        super("StringInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 's') return new StringFirstState();
        else return new NoValidTransitionState();
    }
}
