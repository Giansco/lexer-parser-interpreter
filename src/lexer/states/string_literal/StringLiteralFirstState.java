package lexer.states.string_literal;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class StringLiteralFirstState extends AbstractNormalLexerState {

    public StringLiteralFirstState() {
        super("StringLiteralFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == '\"') return new StringLiteralSecondState();
        else if (String.valueOf(input).matches("(?s).")) return new StringLiteralFirstState();
        else return new NoValidTransitionState();
    }
}
