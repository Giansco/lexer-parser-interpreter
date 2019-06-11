package lexer_gianni.states.print;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class PrintThirdState extends AbstractNormalLexerState {

    public PrintThirdState() {
        super("PrintThirdState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 'n') return new PrintFourthState();
        else return new NoValidTransitionState();
    }
}
