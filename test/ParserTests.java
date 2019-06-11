import org.junit.Test;
import parser.*;
import parser.exc.DeclarationWithoutColonExc;
import parser.exc.StatementWithoutSemiColonExc;
import parser.handlers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserTests {

    private Parser setUp(){

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

        return new ConcreteParser(resultHandler);
    }

    @Test(expected = DeclarationWithoutColonExc.class)
    public void testDeclarationWithoutColonExc(){

        List<Input> inputs = Stream.of(
                new ConcreteInput(InputType.LET, "let"),
                new ConcreteInput(InputType.IDENTIFIER, "pepe"),
                new ConcreteInput(InputType.STRING, "string")
        ).collect(Collectors.toList());

        InputSupplier supplier = new ConcreteInputSupplier(inputs);

        Parser parser = setUp();

        parser.parse(supplier);
    }

    @Test(expected = StatementWithoutSemiColonExc.class)
    public void testStatementWithoutSemiColon(){

        List<Input> inputs = Stream.of(
                new ConcreteInput(InputType.LET, "let"),
                new ConcreteInput(InputType.IDENTIFIER, "pepe"),
                new ConcreteInput(InputType.COLON, ":"),
                new ConcreteInput(InputType.STRING, "string")
        ).collect(Collectors.toList());

        InputSupplier supplier = new ConcreteInputSupplier(inputs);

        Parser parser = setUp();

        parser.parse(supplier);
    }

    @Test()
    public void testValidStatement(){

        List<Input> inputs = Stream.of(
                new ConcreteInput(InputType.LET, "let"),
                new ConcreteInput(InputType.IDENTIFIER, "pepe"),
                new ConcreteInput(InputType.COLON, ":"),
                new ConcreteInput(InputType.STRING, "string"),
                new ConcreteInput(InputType.SEMI_COLON, ";")
        ).collect(Collectors.toList());

        InputSupplier supplier = new ConcreteInputSupplier(inputs);

        Parser parser = setUp();

        parser.parse(supplier);
    }
}
