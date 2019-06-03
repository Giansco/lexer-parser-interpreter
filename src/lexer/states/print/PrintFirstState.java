package lexer.states.print;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
