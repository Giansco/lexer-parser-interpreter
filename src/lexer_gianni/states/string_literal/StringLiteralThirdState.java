package lexer_gianni.states.string_literal;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class StringLiteralThirdState extends AbstractNormalLexerState {

    public StringLiteralThirdState() {
        super("StringLiteralThirdState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == '\'') return new StringLiteralFourthState();
        else if (String.valueOf(input).matches("(?s).")) return new StringLiteralThirdState();
        else return new NoValidTransitionState();
    }
}
