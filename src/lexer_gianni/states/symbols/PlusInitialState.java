package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class PlusInitialState extends AbstractNormalLexerState {


    public PlusInitialState() {
        super("PlusInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '+') return new PlusFirstState();
        else return new NoValidTransitionState();
    }
}
