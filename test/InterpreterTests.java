import interpreter.ConcreteInterpreter;
import interpreter.Interpreter;
import interpreter.exc.IdentifierNotFoundExc;
import interpreter.exc.InvalidOperationExc;
import interpreter.exc.InvalidTypeAssignmentExc;
import lexer.*;
import lexer.states.identifier.IdentifierInitialState;
import lexer.states.let.LetInitialState;
import lexer.states.number.NumberInitialState;
import lexer.states.number_literal.NumberLiteralInitialState;
import lexer.states.print.PrintInitialState;
import lexer.states.string.StringInitialState;
import lexer.states.string_literal.StringLiteralInitialState;
import lexer.states.symbols.*;
import main.Main;
import main.parser_interpreter.ConcreteNodeVisitor;
import main.parser_interpreter.NodeVisitor;
import org.junit.Test;
import parser.*;
import parser.handlers.*;
import parser.tree.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterpreterTests {

    @Test
    public void testValidSourceCode(){
        List<Token> tkn = Main.lexerRun("let pepe: string = \"hola\";\n" +
                "let pepito: number;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(pepito + pepe + \"mundo\");");

        List<Input> inputs = Main.parserInputSetUp(tkn);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }

    @Test(expected = IdentifierNotFoundExc.class)
    public void testNonExistingIdentifier(){
        List<Token> tkn = Main.lexerRun("let pepe: string = \"hola\";\n" +
                "let pepito: number;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(juan + pepe + \"mundo\");");

        List<Input> inputs = Main.parserInputSetUp(tkn);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }

    @Test(expected = InvalidOperationExc.class)
    public void testInvalidOperation(){
        List<Token> tkn = Main.lexerRun("let pepe: string = \"hola\";\n" +
                "let pepito: number;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(pepito - pepe + \"mundo\");");

        List<Input> inputs = Main.parserInputSetUp(tkn);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }

    @Test(expected = InvalidTypeAssignmentExc.class)
    public void testInvalidTypeAssignment(){
        List<Token> tkn = Main.lexerRun("let pepe: string = \"hola\";\n" +
                "let pepito: string;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(pepito + pepe + \"mundo\");");

        List<Input> inputs = Main.parserInputSetUp(tkn);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }
}
