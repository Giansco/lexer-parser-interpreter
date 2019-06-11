package lexer_gianni.states.string_literal;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

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
