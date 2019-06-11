package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class MinusFirstState extends AbstractAcceptingLexerState{


    public MinusFirstState() {
        super("MinusFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
