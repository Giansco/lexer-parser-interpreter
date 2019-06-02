package lexer.states.identifier;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class IdentifierInitialState extends AbstractNormalLexerState {

    public IdentifierInitialState() {
        super("IdentifierInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (String.valueOf(input).matches("[a-zA-Z_$]")) return new IdentifierFirstState();
        else return new NoValidTransitionState();
    }
}
