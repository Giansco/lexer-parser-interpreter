package lexer_gianni.states.print;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class PrintSecondState extends AbstractNormalLexerState {

    public PrintSecondState() {
        super("PrintSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'i') return new PrintThirdState();
        else return new NoValidTransitionState();
    }
}
