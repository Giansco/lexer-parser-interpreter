package lexer_gianni.states.print;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class PrintFirstState extends AbstractNormalLexerState {

    public PrintFirstState() {
        super("PrintFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'r') return new PrintSecondState();
        else return new NoValidTransitionState();
    }
}
