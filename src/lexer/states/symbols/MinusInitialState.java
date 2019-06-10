package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class MinusInitialState extends AbstractNormalLexerState {


    public MinusInitialState() {
        super("MinusInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '-') return new MinusFirstState();
        else return new NoValidTransitionState();
    }
}
