package lexer.states.string_literal;

import lexer.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
