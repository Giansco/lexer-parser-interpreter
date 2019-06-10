package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class CloseParenthesisInitialState extends AbstractNormalLexerState {


    public CloseParenthesisInitialState() {
        super("CloseParenthesisInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ')') return new CloseParenthesisFirstState();
        else return new NoValidTransitionState();
    }
}
