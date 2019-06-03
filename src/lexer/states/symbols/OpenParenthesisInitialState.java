package lexer.states.symbols;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class OpenParenthesisInitialState extends AbstractAcceptingLexerState{


    public OpenParenthesisInitialState() {
        super("OpenParenthesisInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if(input == '(') return new OpenParenthesisInitialState();
        else return new NoValidTransitionState();
    }
}
