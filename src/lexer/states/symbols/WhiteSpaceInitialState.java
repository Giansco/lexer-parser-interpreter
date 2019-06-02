package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class WhiteSpaceInitialState extends AbstractAcceptingLexerState {


    public WhiteSpaceInitialState() {
        super("WhiteSpaceInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ' ' || input == '\t') return new WhiteSpaceInitialState();
        else return new NoValidTransitionState();
    }
}
