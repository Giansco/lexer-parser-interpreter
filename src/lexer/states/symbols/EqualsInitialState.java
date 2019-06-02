package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class EqualsInitialState extends AbstractAcceptingLexerState {


    public EqualsInitialState() {
        super("EqualsInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '=') return new EqualsInitialState();
        else return new NoValidTransitionState();
    }
}
