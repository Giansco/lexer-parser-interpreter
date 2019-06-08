package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class SemiColonInitialState extends AbstractNormalLexerState {


    public SemiColonInitialState() {
        super("SemiColonInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ';') return new SemiColonFirstState();
        else return new NoValidTransitionState();
    }
}
