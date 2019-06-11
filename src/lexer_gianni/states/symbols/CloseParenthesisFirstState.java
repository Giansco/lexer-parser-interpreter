package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class CloseParenthesisFirstState extends AbstractAcceptingLexerState{


    public CloseParenthesisFirstState() {
        super("CloseParenthesisFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
