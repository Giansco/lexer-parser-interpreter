package lexer.states.number_literal;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.LexerState;

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
