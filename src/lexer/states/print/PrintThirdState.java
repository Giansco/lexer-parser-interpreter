package lexer.states.print;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
