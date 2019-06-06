package parser.states;

import parser.ASTNode;

import java.util.Stack;

public interface ParserState {

    Stack<ASTNode> handle(Stack<ASTNode> stack, ParserState previous);
    boolean isAcceptingState();
}
