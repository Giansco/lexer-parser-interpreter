package lexer_gianni.states.number_literal;

import lexer_gianni.states.NoValidTransitionState;
import lexer_gianni.states.AbstractAcceptingLexerState;
import lexer_gianni.states.LexerState;

public class NumberLiteralSecondState extends AbstractAcceptingLexerState {

    public NumberLiteralSecondState() {
        super("NumberLiteralSecondState");
    }

    @Override
    public LexerState nextState(char input) {
        if (String.valueOf(input).matches("[0-9]")) return new NumberLiteralSecondState();
        else return new NoValidTransitionState();
    }
}
