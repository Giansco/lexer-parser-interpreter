package lexer.states.print;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
