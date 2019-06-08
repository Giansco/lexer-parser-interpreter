package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class MinusFirstState extends AbstractAcceptingLexerState{


    public MinusFirstState() {
        super("MinusFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
