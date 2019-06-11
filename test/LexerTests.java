import lexer.*;
import lexer.exceptions.NoMatchFoundExc;
import lexer.states.identifier.IdentifierInitialState;
import lexer.states.let.LetInitialState;
import lexer.states.number.NumberInitialState;
import lexer.states.number_literal.NumberLiteralInitialState;
import lexer.states.print.PrintInitialState;
import lexer.states.string.StringInitialState;
import lexer.states.string_literal.StringLiteralInitialState;
import lexer.states.symbols.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LexerTests {

    private List<LexerAutomata> setUp(){
        return Stream.of(
                new ConcreteLexerAutomata(new WhiteSpaceInitialState(), TokenType.WHITESPACE),
                new ConcreteLexerAutomata(new ColonInitialState(), TokenType.COLON),
                new ConcreteLexerAutomata(new SemiColonInitialState(), TokenType.SEMI_COLON),
                new ConcreteLexerAutomata(new EqualsInitialState(), TokenType.EQUALS),
                new ConcreteLexerAutomata(new MinusInitialState(), TokenType.MINUS),
                new ConcreteLexerAutomata(new NewLineInitialState(), TokenType.NEW_LINE),
                new ConcreteLexerAutomata(new PlusInitialState(), TokenType.PLUS),
                new ConcreteLexerAutomata(new MultiplyInitialState(), TokenType.MULTIPLY),
                new ConcreteLexerAutomata(new DivideInitialState(), TokenType.DIVIDE),
                new ConcreteLexerAutomata(new OpenParenthesisInitialState(), TokenType.OPEN_PARENTHESIS),
                new ConcreteLexerAutomata(new CloseParenthesisInitialState(), TokenType.CLOSE_PARENTHESIS),
                new ConcreteLexerAutomata(new LetInitialState(), TokenType.LET),
                new ConcreteLexerAutomata(new StringLiteralInitialState(), TokenType.STRING_LITERAL),
                new ConcreteLexerAutomata(new NumberLiteralInitialState(), TokenType.NUMERIC_LITERAL),
                new ConcreteLexerAutomata(new StringInitialState(), TokenType.STRING),
                new ConcreteLexerAutomata(new NumberInitialState(), TokenType.NUMBER),
                new ConcreteLexerAutomata(new PrintInitialState(), TokenType.PRINT),
                new ConcreteLexerAutomata(new IdentifierInitialState(), TokenType.IDENTIFIER)
        ).collect(Collectors.toList());
    }

    @Test(expected = lexer.exceptions.NoMatchFoundExc.class)
    public void testUnsupportedCharacter(){
        CharSupplier charSupplier = new ConcreteCharSupplier("pepe = 5 ^ 5");

        List<LexerAutomata> automatas = setUp();

        Lexer lexer = new ConcreteLexer(automatas);

        lexer.lex(charSupplier);
    }

    @Test(expected = lexer.exceptions.NoMatchFoundExc.class)
    public void testInvalidIdentifierName(){
        CharSupplier charSupplier = new ConcreteCharSupplier("aendas123! = 5 + 5");

        List<LexerAutomata> automatas = setUp();

        Lexer lexer = new ConcreteLexer(automatas);

        lexer.lex(charSupplier);
    }

    @Test
    public void testValidAssignation(){

        CharSupplier charSupplier = new ConcreteCharSupplier("let pepe: string = 5");

        List<LexerAutomata> automatas = setUp();

        Lexer lexer = new ConcreteLexer(automatas);

        List<Token> tkns = lexer.lex(charSupplier);

        List<TokenType> types = Stream.of(
                TokenType.LET,
                TokenType.WHITESPACE,
                TokenType.IDENTIFIER,
                TokenType.COLON,
                TokenType.WHITESPACE,
                TokenType.STRING,
                TokenType.WHITESPACE,
                TokenType.EQUALS,
                TokenType.WHITESPACE,
                TokenType.NUMERIC_LITERAL).collect(Collectors.toList());

        for (int i = 0; i < types.size(); i++) {
            Assert.assertEquals(tkns.get(i).getTokenType(), types.get(i));
        }
    }
}
