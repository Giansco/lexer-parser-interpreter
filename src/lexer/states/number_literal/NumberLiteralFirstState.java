package lexer.states.number_literal;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;

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
