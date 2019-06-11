import interpreter.exc.IdentifierNotFoundExc;
import interpreter.exc.InvalidOperationExc;
import interpreter.exc.InvalidTypeAssignmentExc;
import lexer.InputStream;
import lexer.Lexer;
import lexer.TextStream;
import lexer.TokenLexer;
import lexer.token.TokenStream;
import lexer_gianni.*;
import main.Main;
import org.junit.Test;
import parser.*;
import parser.tree.Node;

import java.util.List;

public class InterpreterTests {

    @Test
    public void testValidSourceCode(){

        Lexer lexer = new TokenLexer();

        InputStream stream = new TextStream("let pepe: string = \"hola\";\n" +
                "let pepito: number;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(pepito + pepe + \"mundo\");");

        TokenStream tokenStream = lexer.lex(stream);

        //Change tokens from lexer_gianni to parser inputs
        List<Input> inputs = Main.parserInputSetUp(tokenStream);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }

    @Test(expected = IdentifierNotFoundExc.class)
    public void testNonExistingIdentifier(){
        Lexer lexer = new TokenLexer();

        InputStream stream = new TextStream("let pepe: string = \"hola\";\n" +
                "let pepito: number;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(pepitooo + pepe + \"mundo\");");

        TokenStream tokenStream = lexer.lex(stream);

        //Change tokens from lexer_gianni to parser inputs
        List<Input> inputs = Main.parserInputSetUp(tokenStream);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }

    @Test(expected = InvalidOperationExc.class)
    public void testInvalidOperation(){
        Lexer lexer = new TokenLexer();

        InputStream stream = new TextStream("let pepe: string = \"hola\";\n" +
                "let pepito: number;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(pepito - pepe + \"mundo\");");

        TokenStream tokenStream = lexer.lex(stream);

        //Change tokens from lexer_gianni to parser inputs
        List<Input> inputs = Main.parserInputSetUp(tokenStream);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }

    @Test(expected = InvalidTypeAssignmentExc.class)
    public void testInvalidTypeAssignment(){
        Lexer lexer = new TokenLexer();

        InputStream stream = new TextStream("let pepe: string = \"hola\";\n" +
                "let pepito: string;\n" +
                "pepito = 5.5 - 8;\n" +
                "\n" +
                "print(pepito + pepe + \"mundo\");");

        TokenStream tokenStream = lexer.lex(stream);

        //Change tokens from lexer_gianni to parser inputs
        List<Input> inputs = Main.parserInputSetUp(tokenStream);

        Node result = Main.parserRun(inputs);

        Main.interpreterRun(result);
    }
}
