package lexer;

import lexer.states.ConcreteToken;
import lexer.states.LexerState;

public class ConcreteLexerAutomata implements LexerAutomata {

    private LexerState initialState;
    private LexerState currentState;
    private Token generatedToken;
    private String tokenContent;
    private TokenType tokenType;

    public ConcreteLexerAutomata(LexerState initialState, TokenType tokenType) {
        this.initialState = initialState;
        this.currentState = initialState;
        generatedToken = null;
        tokenContent = "";
        this.tokenType = tokenType;
    }

    @Override
    public boolean run(char input) {
        currentState = currentState.nextState(input);
        if (currentState.getDescription().equals("NoValidTransition")) return false;
        tokenContent += input;
        if(currentState.isAcceptanceState()) generatedToken = new ConcreteToken(tokenType, tokenContent);
        return true;
    }

    @Override
    public Token getGeneratedToken() {
        return generatedToken;
    }

    @Override
    public void clear() {
        currentState = initialState;
        generatedToken = null;
        tokenContent = "";
    }
}
