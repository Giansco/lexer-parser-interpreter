package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class SemiColonInitialState extends AbstractNormalLexerState {


    public SemiColonInitialState() {
        super("SemiColonInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ';') return new SemiColonFirstState();
        else return new NoValidTransitionState();
    }
}
