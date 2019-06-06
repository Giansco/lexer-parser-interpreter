package parser.rules;

import parser.ASTNode;

import java.util.Stack;

public interface Rule {

    Stack<ASTNode> transform(Stack<ASTNode> stack);
}
