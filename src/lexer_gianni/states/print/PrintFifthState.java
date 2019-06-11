package lexer_gianni.states.print;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class PrintFifthState extends AbstractAcceptingLexerState {

    public PrintFifthState() {
        super("PrintFifthState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
