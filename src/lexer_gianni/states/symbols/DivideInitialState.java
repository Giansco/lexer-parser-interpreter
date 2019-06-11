package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
