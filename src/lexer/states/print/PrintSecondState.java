package lexer.states.print;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
