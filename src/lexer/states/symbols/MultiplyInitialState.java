package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class MultiplyInitialState extends AbstractAcceptingLexerState{


    public MultiplyInitialState() {
        super("MultiplyInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '*') return new MultiplyInitialState();
        else return new NoValidTransitionState();
    }
}
