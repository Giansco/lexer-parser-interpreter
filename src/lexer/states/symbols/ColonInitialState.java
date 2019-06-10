package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class ColonInitialState extends AbstractNormalLexerState {


    public ColonInitialState() {
        super("ColonInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ':') return new ColonFirstState();
        else return new NoValidTransitionState();
    }
}
