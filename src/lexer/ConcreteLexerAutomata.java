package lexer;

import lexer.states.LexerState;

public class ConcreteLexerAutomata implements LexerAutomata {

    private LexerState initialState;
    private LexerState currentState;
    private Token generatedToken;
    private String tokenContent;
    private TokenType tokenType;
    private int amountProcessed;

    public ConcreteLexerAutomata(LexerState initialState, TokenType tokenType) {
        this.initialState = initialState;
        this.currentState = initialState;
        generatedToken = null;
        tokenContent = "";
        this.tokenType = tokenType;
        this.amountProcessed = 0;
    }

    @Override
    public boolean run(char input) {
        currentState = currentState.nextState(input);
        if (currentState.getDescription().equals("NoValidTransition")) return false;
        if(input != '\'' && input != '\"') tokenContent += input;
        amountProcessed++;
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
        amountProcessed = 0;
    }

    @Override
    public int getAmountProcessed() {
        return amountProcessed;
    }


}
