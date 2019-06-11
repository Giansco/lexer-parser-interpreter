package main;

import interpreter.ConcreteInterpreter;
import interpreter.Interpreter;
import lexer.InputStream;
import lexer.Lexer;
import lexer.TextStream;
import lexer.TokenLexer;
import lexer.token.Token;
import lexer.token.TokenStream;
import lexer.token.TokenType;
import main.parser_interpreter.ConcreteNodeVisitor;
import main.parser_interpreter.NodeVisitor;
import parser.*;
import parser.handlers.*;
import parser.tree.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
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

        Lexer lexer = new TokenLexer();

        InputStream stream = new TextStream(sourceCode);

        TokenStream tokenStream = lexer.lex(stream);

        //Change tokens from lexer_gianni to parser inputs
        List<Input> inputs = parserInputSetUp(tokenStream);

        Node result = parserRun(inputs);

        interpreterRun(result);
    }

    private static String readFile(String[] args) throws IOException {
        String filePath = "./src/examples/simple.txt";
        if(args.length > 0) filePath = args[0];
        return new String(Files.readAllBytes(Paths.get(filePath)));

    }

    public static List<Input> parserInputSetUp(TokenStream tokens){
        List<Input> res = new ArrayList<>();
        while (tokens.hasNext()){
            Token peek = tokens.peek();
            tokens.consume();
            res.add(new ConcreteInput(fromLexerToParserType(peek.getType()), peek.getContent()));
        }

        return res;
    }

    public static InputType fromLexerToParserType(TokenType type){
        switch (type){
            case LET: return InputType.LET;
            case NUMBER: return InputType.NUMERIC_LITERAL;
            case STRING: return InputType.STRING_LITERAL;
            case PRINT: return InputType.PRINT;
            case NUMBER_TYPE: return InputType.NUMBER;
            case STRING_TYPE: return InputType.STRING;
            case LEFT_PARENTHESIS: return InputType.OPEN_PARENTHESIS;
            case RIGHT_PARENTHESIS: return InputType.CLOSE_PARENTHESIS;
            case COLON: return InputType.COLON;
            case SEMI_COLON: return InputType.SEMI_COLON;
            case PLUS: return InputType.PLUS;
            case MINUS: return InputType.MINUS;
            case MULTIPLICATION: return InputType.MULTIPLY;
            case DIVISION: return InputType.DIVIDE;
            case EQUALS: return InputType.EQUALS;
            case IDENTIFIER: return InputType.IDENTIFIER;
            default: return null;
        }
    }

    public static Node parserRun(List<Input> inputs){

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

    public static void interpreterRun(Node node){

        Iterator<Node> collect = Stream.of(node).iterator();

        interpreter.InputSupplier supplier = new interpreter.ConcreteInputSupplier(collect);

        NodeVisitor visitor = new ConcreteNodeVisitor();

        Interpreter interpreter = new ConcreteInterpreter(visitor);

        interpreter.interpret(supplier);
    }
}
