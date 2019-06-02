package lexer.states;

import lexer.Token;
import lexer.TokenType;

public class ConcreteToken implements Token {

    private TokenType tokenType;
    private String content;

    public ConcreteToken(TokenType tokenType, String content) {
        this.tokenType = tokenType;
        this.content = content;
    }

    @Override
    public TokenType getTokenType() {
        return tokenType;
    }

    @Override
    public String getContent() {
        return content;
    }
}
