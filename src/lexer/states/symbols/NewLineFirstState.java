package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class NewLineFirstState extends AbstractAcceptingLexerState{


    public NewLineFirstState() {
        super("NewLineFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
