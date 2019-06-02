package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class SemiColonInitialState extends AbstractAcceptingLexerState {


    public SemiColonInitialState() {
        super("SemiColonInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ';') return new SemiColonInitialState();
        else return new NoValidTransitionState();
    }
}
