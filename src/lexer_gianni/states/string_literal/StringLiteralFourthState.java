package lexer_gianni.states.string_literal;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class StringLiteralFourthState extends AbstractAcceptingLexerState {

    public StringLiteralFourthState() {
        super("StringLiteralFourthState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
