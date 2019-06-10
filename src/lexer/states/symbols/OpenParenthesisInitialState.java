package lexer.states.symbols;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class OpenParenthesisInitialState extends AbstractNormalLexerState {


    public OpenParenthesisInitialState() {
        super("OpenParenthesisInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '(') return new OpenParenthesisFirstState();
        else return new NoValidTransitionState();
    }
}
