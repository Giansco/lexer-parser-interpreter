package lexer_gianni.states.identifier;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class IdentifierFirstState extends AbstractAcceptingLexerState {

    public IdentifierFirstState() {
        super("IdentifierFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (String.valueOf(input).matches("[0-9a-zA-Z_$]")) return new IdentifierFirstState();
        else return new NoValidTransitionState();
    }
}
