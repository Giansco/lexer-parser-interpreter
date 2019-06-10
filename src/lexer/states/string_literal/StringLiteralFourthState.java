package lexer.states.string_literal;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class StringLiteralFourthState extends AbstractAcceptingLexerState {

    public StringLiteralFourthState() {
        super("StringLiteralFourthState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
