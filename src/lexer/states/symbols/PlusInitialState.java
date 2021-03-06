package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class PlusInitialState extends AbstractAcceptingLexerState{


    public PlusInitialState() {
        super("PlusInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '+') return new PlusInitialState();
        else return new NoValidTransitionState();
    }
}
