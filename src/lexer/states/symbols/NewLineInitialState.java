package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class NewLineInitialState extends AbstractNormalLexerState {


    public NewLineInitialState() {
        super("NewLineInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '\n') return new NewLineFirstState();
        else return new NoValidTransitionState();
    }
}
