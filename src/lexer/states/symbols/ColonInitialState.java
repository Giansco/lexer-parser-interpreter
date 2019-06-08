package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
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
