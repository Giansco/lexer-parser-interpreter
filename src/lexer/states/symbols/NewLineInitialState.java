package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class NewLineInitialState extends AbstractAcceptingLexerState{


    public NewLineInitialState() {
        super("NewLineInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '\n') return new NewLineInitialState();
        else return new NoValidTransitionState();
    }
}
