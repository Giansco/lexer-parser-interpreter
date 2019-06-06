package parser.states;

import parser.ASTNode;
import parser.ParserAutomata;
import parser.rules.Rule;

import java.util.Stack;

public class RuleState extends AbstractParserState {

    private Rule rule;

    public RuleState(ParserAutomata automata, Rule rule) {
        super(automata);
        this.rule = rule;
    }

    @Override
    public Stack<ASTNode> handle(Stack<ASTNode> stack, ParserState previous) {
        automata.setState(previous);
        return rule.transform(stack);
    }

    @Override
    public boolean isAcceptingState() {
        return false;
    }
}
