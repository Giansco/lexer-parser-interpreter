package lexer;

public interface CharSupplier {

    char nextChar();
    void advance();
    boolean hasNext();
    int getPosition();
    void setPosition(int pos);

}
