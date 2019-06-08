package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
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
