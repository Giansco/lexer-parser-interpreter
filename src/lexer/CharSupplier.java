package lexer;

public interface CharSupplier {

    char nextChar();
    void advance();
    boolean hasNext();
}
