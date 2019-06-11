package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
