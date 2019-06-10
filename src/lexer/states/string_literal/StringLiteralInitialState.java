package lexer.states.string_literal;

import lexer.states.NoValidTransitionState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

public class StringLiteralInitialState extends AbstractNormalLexerState {

    public StringLiteralInitialState() {
        super("StringLiteralInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (input == '\"') return new StringLiteralFirstState();
        else if (input == '\'') return new StringLiteralThirdState();
        else return new NoValidTransitionState();
    }
}
