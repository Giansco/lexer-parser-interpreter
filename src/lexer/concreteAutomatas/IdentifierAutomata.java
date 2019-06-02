package lexer.concreteAutomatas;

import lexer.ConcreteToken;
import lexer.LexerState;
import lexer.TokenType;

public class IdentifierAutomata extends AbstractLexerAutomata {


    public IdentifierAutomata(LexerState initialState) {
        super(initialState);
    }

    @Override
    public boolean run(char input) {
        currentState = currentState.nextState(input);
        if (currentState.getDescription().equals("NoValidTransition")) return  false;
        tokenContent += input;
        if(currentState.isAcceptanceState()) generatedToken = new ConcreteToken(TokenType.IDENTIFIER, tokenContent);
        return true;
    }
}
