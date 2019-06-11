package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class SemiColonFirstState extends AbstractAcceptingLexerState {


    public SemiColonFirstState() {
        super("SemiColonFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
