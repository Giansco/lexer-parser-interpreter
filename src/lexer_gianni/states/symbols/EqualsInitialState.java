package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class EqualsInitialState extends AbstractNormalLexerState {


    public EqualsInitialState() {
        super("EqualsInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '=') return new EqualsFirstState();
        else return new NoValidTransitionState();
    }
}
