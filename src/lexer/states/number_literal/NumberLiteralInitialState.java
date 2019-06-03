package lexer.states.number_literal;

import lexer.NoValidTransitionState;
import lexer.states.AbstractAcceptingLexerState;
import lexer.states.AbstractNormalLexerState;
import lexer.states.LexerState;
import lexer.states.number.NumberFirstState;

public class NumberLiteralInitialState extends AbstractAcceptingLexerState {

    public NumberLiteralInitialState() {
        super("NumberLiteralInitialState");
    }

    @Override
    public LexerState nextState(char input) {
        if (String.valueOf(input).matches("[0-9]")) return new NumberLiteralInitialState();
        else if (input == '.') return new NumberLiteralFirstState();
        else return new NoValidTransitionState();
    }
}
