package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class WhiteSpaceFirstState extends AbstractAcceptingLexerState {


    public WhiteSpaceFirstState() {
        super("WhiteSpaceFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
