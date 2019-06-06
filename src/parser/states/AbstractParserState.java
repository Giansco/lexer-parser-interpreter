package parser.states;

import parser.ParserAutomata;

public abstract class AbstractParserState implements ParserState {

    protected ParserAutomata automata;

    public AbstractParserState(ParserAutomata automata) {
        this.automata = automata;
    }
}
