package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class CloseParenthesisInitialState extends AbstractAcceptingLexerState{


    public CloseParenthesisInitialState() {
        super("CloseParenthesisInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == ')') return new CloseParenthesisInitialState();
        else return new NoValidTransitionState();
    }
}
