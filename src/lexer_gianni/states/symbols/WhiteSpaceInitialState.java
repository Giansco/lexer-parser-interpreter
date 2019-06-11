package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class WhiteSpaceInitialState extends AbstractNormalLexerState {


    public WhiteSpaceInitialState() {
        super("WhiteSpaceInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ' ' || input == '\t') return new WhiteSpaceFirstState();
        else return new NoValidTransitionState();
    }
}
