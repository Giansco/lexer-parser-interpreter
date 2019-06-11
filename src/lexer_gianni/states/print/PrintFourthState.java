package lexer_gianni.states.print;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class PrintFourthState extends AbstractNormalLexerState {

    public PrintFourthState() {
        super("PrintFourthState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == 't') return new PrintFifthState();
        else return new NoValidTransitionState();
    }
}