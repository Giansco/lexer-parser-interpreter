package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class DivideInitialState extends AbstractNormalLexerState {


    public DivideInitialState() {
        super("DivideInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '/') return new DivideFirstState();
        else return new NoValidTransitionState();
    }
}
