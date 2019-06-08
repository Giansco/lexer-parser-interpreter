package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class CloseParenthesisFirstState extends AbstractAcceptingLexerState{


    public CloseParenthesisFirstState() {
        super("CloseParenthesisFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
