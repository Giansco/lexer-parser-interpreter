package lexer_gianni.states.number_literal;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractNormalLexerState;
import lexer_gianni.states.LexerState;

public class NumberLiteralFirstState extends AbstractNormalLexerState {

    public NumberLiteralFirstState() {
        super("NumberLiteralFirstState");
    }

    @Override
    public LexerState nextState(char input) {
        if (String.valueOf(input).matches("[0-9]")) return new NumberLiteralSecondState();
        else return new NoValidTransitionState();
    }
}
