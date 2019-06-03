package main;

import lexer.*;
import lexer.states.number.NumberInitialState;
import lexer.states.number_literal.NumberLiteralInitialState;
import lexer.states.print.PrintInitialState;
import lexer.states.string_literal.StringLiteralInitialState;
import lexer.states.symbols.*;
import lexer.states.identifier.IdentifierInitialState;
import lexer.states.let.LetInitialState;
import lexer.states.string.StringInitialState;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String sourceCode;
        try {
            sourceCode = readFile(args);
        } catch (IOException error) {
            System.out.println(error.getMessage());
            return;
        }

//        System.out.println(" ".matches("(?s)."));

        lexerSetUp(sourceCode);
    }

    private static String readFile(String[] args) throws IOException {
        String filePath = "./src/examples/class-example.txt";
        if(args.length > 0) filePath = args[0];
        return new String(Files.readAllBytes(Paths.get(filePath)));

    }

    private static void lexerSetUp(String sourceCode){

        CharSupplier charSupplier = new ConcreteCharSupplier(sourceCode);

        List<LexerAutomata> automatas = Stream.of(
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

        Lexer lexer = new ConcreteLexer(automatas);

        List<Token> lex = lexer.lex(charSupplier);

        lex.forEach(Printer::printToken);
    }

    private void generateLetStates(){

    }
}
