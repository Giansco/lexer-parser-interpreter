package lexer_gianni.states.identifier;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
