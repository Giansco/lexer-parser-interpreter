package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class PlusFirstState extends AbstractAcceptingLexerState{


    public PlusFirstState() {
        super("PlusFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
