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
import parser.*;
import parser.handlers.*;
import parser.tree.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

        List<Token> tkn = lexerRun(sourceCode);

        tkn.forEach(Printer::printToken);

        List<Input> inputs = parserInputSetUp(tkn);

        Node result = parserRun(inputs);

        System.out.println(result);
    }

    private static String readFile(String[] args) throws IOException {
        String filePath = "./src/examples/class-example.txt";
        if(args.length > 0) filePath = args[0];
        return new String(Files.readAllBytes(Paths.get(filePath)));

    }

    private static List<Token> lexerRun(String sourceCode){

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

        return lexer.lex(charSupplier);
    }

    private static List<Input> parserInputSetUp(List<Token> tokens){
        return tokens.stream()
                .map(tkn -> new ConcreteInput(fromLexerToParserType(tkn), tkn.getContent()))
                .filter(inp -> inp.getType() != null)
                .collect(Collectors.toList());
    }

    private static InputType fromLexerToParserType(Token token){
        switch (token.getTokenType()){
            case LET: return InputType.LET;
            case NUMERIC_LITERAL: return InputType.NUMERIC_LITERAL;
            case STRING_LITERAL: return InputType.STRING_LITERAL;
            case PRINT: return InputType.PRINT;
            case NUMBER: return InputType.NUMBER;
            case STRING: return InputType.STRING;
            case OPEN_PARENTHESIS: return InputType.OPEN_PARENTHESIS;
            case CLOSE_PARENTHESIS: return InputType.CLOSE_PARENTHESIS;
            case COLON: return InputType.COLON;
            case SEMI_COLON: return InputType.SEMI_COLON;
            case PLUS: return InputType.PLUS;
            case MINUS: return InputType.MINUS;
            case MULTIPLY: return InputType.MULTIPLY;
            case DIVIDE: return InputType.DIVIDE;
            case EQUALS: return InputType.EQUALS;
            case IDENTIFIER: return InputType.IDENTIFIER;
            default: return null;
        }
    }

    private static Node parserRun(List<Input> inputs){

        InputSupplier supplier = new ConcreteInputSupplier(inputs);

        Handler literalHandler = new LiteralHandler();

        Handler termHandler = new TermHandler(literalHandler);

        Handler expressionHandler = new ExpressionHandler(termHandler);

        Handler typeHandler = new TypeHandler();

        Handler assignmentHandler = new AssignmentHandler(expressionHandler, literalHandler);

        Handler declarationHandler = new DeclarationHandler(expressionHandler, typeHandler, literalHandler);

        Handler printHandler = new PrintHandler(expressionHandler);

        Map<InputType, Handler> transitions = new HashMap<>();
        transitions.put(InputType.IDENTIFIER, assignmentHandler);
        transitions.put(InputType.LET, declarationHandler);
        transitions.put(InputType.PRINT, printHandler);

        Handler statementHandler = new StatementHandler(transitions);

        Handler resultHandler = new ResultHandler(statementHandler);

        Parser parser = new ConcreteParser(resultHandler);

        return parser.parse(supplier);
    }
}
