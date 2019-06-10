package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
