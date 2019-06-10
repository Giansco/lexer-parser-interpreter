package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class MultiplyFirstState extends AbstractAcceptingLexerState{


    public MultiplyFirstState() {
        super("MultiplyFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
