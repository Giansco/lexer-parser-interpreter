package parser;

import parser.states.ParserState;

import java.util.List;

public interface ParserAutomata {

    void setState(ParserState state);
    ASTNode run(List<ASTNode> input);
}
