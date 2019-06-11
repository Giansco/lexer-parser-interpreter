package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
