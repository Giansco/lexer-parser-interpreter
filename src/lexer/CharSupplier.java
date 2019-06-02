package lexer;

public interface CharSupplier {

    char nextChar();
    boolean hasNext();
}
