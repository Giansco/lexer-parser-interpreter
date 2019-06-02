package lexer.concreteAutomatas;

import lexer.ConcreteToken;
import lexer.LexerAutomata;
import lexer.LexerState;
import lexer.Token;

abstract class AbstractLexerAutomata implements LexerAutomata {

    protected LexerState initialState;
    protected LexerState currentState;
    protected Token generatedToken;
    protected String tokenContent;

    protected AbstractLexerAutomata(LexerState initialState) {
        this.initialState = initialState;
        this.currentState = initialState;
        generatedToken = null;
        tokenContent = "";
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
