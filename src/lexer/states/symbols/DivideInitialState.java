package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class DivideInitialState extends AbstractAcceptingLexerState{


    public DivideInitialState() {
        super("DivideInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '/') return new DivideInitialState();
        else return new NoValidTransitionState();
    }
}
