package parser;

public interface InputSupplier {

    Input nextInput();
    void advance();
    boolean hasNext();
}
