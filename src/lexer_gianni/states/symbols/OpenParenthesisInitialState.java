package lexer_gianni.states.symbols;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
