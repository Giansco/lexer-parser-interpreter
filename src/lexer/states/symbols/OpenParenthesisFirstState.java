package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class OpenParenthesisFirstState extends AbstractAcceptingLexerState{


    public OpenParenthesisFirstState() {
        super("OpenParenthesisFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
