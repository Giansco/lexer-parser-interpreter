package lexer.states.print;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class PrintFifthState extends AbstractAcceptingLexerState {

    public PrintFifthState() {
        super("PrintFifthState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
