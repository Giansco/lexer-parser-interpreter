package lexer_gianni;

public interface CharSupplier {

    char nextChar();
    void advance();
    boolean hasNext();
    int getPosition();
    void setPosition(int pos);

}
