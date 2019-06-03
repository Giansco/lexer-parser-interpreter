package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class MinusInitialState extends AbstractAcceptingLexerState{


    public MinusInitialState() {
        super("MinusInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '-') return new MinusInitialState();
        else return new NoValidTransitionState();
    }
}
