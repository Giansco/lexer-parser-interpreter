package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class ColonInitialState extends AbstractAcceptingLexerState{


    public ColonInitialState() {
        super("ColonInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ':') return new ColonInitialState();
        else return new NoValidTransitionState();
    }
}
