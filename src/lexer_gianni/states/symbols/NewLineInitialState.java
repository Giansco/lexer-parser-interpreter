package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
