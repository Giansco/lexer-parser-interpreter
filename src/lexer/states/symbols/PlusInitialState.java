package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class PlusInitialState extends AbstractNormalLexerState {


    public PlusInitialState() {
        super("PlusInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '+') return new PlusFirstState();
        else return new NoValidTransitionState();
    }
}
