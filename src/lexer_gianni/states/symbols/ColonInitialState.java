package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class ColonInitialState extends AbstractNormalLexerState {


    public ColonInitialState() {
        super("ColonInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ':') return new ColonFirstState();
        else return new NoValidTransitionState();
    }
}
