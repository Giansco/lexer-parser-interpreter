package lexer.concreteAutomatas;

import lexer.ConcreteToken;
import lexer.LexerState;
import lexer.TokenType;

public class WhiteSpaceAutomata extends AbstractLexerAutomata {


    public WhiteSpaceAutomata(LexerState initialState) {
        super(initialState);
    }

    @Override
    public boolean run(char input) {
        currentState = currentState.nextState(input);
        if (currentState.getDescription().equals("NoValidTransition")) return  false;
        tokenContent += input;
        if(currentState.isAcceptanceState()) generatedToken = new ConcreteToken(TokenType.WHITESPACE, tokenContent);
        return true;
    }
}
