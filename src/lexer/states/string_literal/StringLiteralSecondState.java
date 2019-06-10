package lexer.states.string_literal;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

public class StringLiteralSecondState extends AbstractAcceptingLexerState {

    public StringLiteralSecondState() {
        super("StringLiteralSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
