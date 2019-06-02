package lexer;

import java.util.List;

public interface Lexer {

    List<Token> lex(CharSupplier charSupplier);
}
