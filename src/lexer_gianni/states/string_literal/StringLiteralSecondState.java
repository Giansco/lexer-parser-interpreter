package lexer_gianni.states.string_literal;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class StringLiteralSecondState extends AbstractAcceptingLexerState {

    public StringLiteralSecondState() {
        super("StringLiteralSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
