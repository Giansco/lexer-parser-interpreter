package lexer_gianni;

import java.util.List;

public interface Lexer {

    List<Token> lex(CharSupplier charSupplier);
}
