package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class EqualsInitialState extends AbstractNormalLexerState {


    public EqualsInitialState() {
        super("EqualsInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '=') return new EqualsFirstState();
        else return new NoValidTransitionState();
    }
}
