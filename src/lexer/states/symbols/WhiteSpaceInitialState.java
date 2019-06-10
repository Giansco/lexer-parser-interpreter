package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
