package lexer.states.identifier;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

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
