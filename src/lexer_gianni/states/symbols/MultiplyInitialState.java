package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class MultiplyInitialState extends AbstractNormalLexerState {


    public MultiplyInitialState() {
        super("MultiplyInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '*') return new MultiplyFirstState();
        else return new NoValidTransitionState();
    }
}
