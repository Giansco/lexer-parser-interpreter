package lexer;

public class ConcreteCharSupplier implements CharSupplier {

    private String sourceCode;
    private int position;

    public ConcreteCharSupplier(String sourceCode) {
        this.sourceCode = sourceCode;
        this.position = 0;
    }

    @Override
    public char nextChar() {
        return sourceCode.charAt(position++);
    }

    @Override
    public boolean hasNext() {
        return position < sourceCode.length();
    }
}
