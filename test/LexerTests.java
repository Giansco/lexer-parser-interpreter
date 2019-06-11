
import lexer.*;
import lexer.token.TokenStream;
import lexer.token.TokenType;
import org.junit.Assert;
import org.junit.Test;

public class LexerTests {

    @Test
    public void doesNotEndInDelimiter() {
        // We would need to have an end of file, right?
        // That should be the only problem honestly.
        Lexer lexer = new TokenLexer();
        InputStream stream = new TextStream("let nice: string = 4");
        TokenStream tokens = lexer.lex(stream);

        TokenType[] types = {
                TokenType.LET,
                TokenType.IDENTIFIER,
                TokenType.COLON,
                TokenType.STRING_TYPE,
                TokenType.EQUALS,
                TokenType.NUMBER};
        int i = 0;
        while (tokens.hasNext()) {
            Assert.assertEquals(types[i], tokens.peek().getType());
            tokens.consume();
            i++;
        }
        Assert.assertFalse(tokens.hasNext());
    }

    @Test(expected = InvalidInputException.class)
    public void variableStartsWithNumber() {
        Lexer lexer = new TokenLexer();
        InputStream stream = new TextStream("let 5nice: string = 4");
         lexer.lex(stream);
    }

    @Test
    public void normalStatement() {
        Lexer lexer = new TokenLexer();
        InputStream stream = new TextStream("nice = 3;");
        TokenStream tokens = lexer.lex(stream);

        TokenType[] types = {
                TokenType.IDENTIFIER,
                TokenType.EQUALS,
                TokenType.NUMBER,
                TokenType.SEMI_COLON};
        int i = 0;
        while (tokens.hasNext()) {
            Assert.assertEquals(types[i], tokens.peek().getType());
            tokens.consume();
            i++;
        }
        Assert.assertFalse(tokens.hasNext());
    }
}