package lexer_gianni;

public class ConcreteCharSupplier implements CharSupplier {

    private String sourceCode;
    private int position;

    public ConcreteCharSupplier(String sourceCode) {
        this.sourceCode = sourceCode;
        this.position = 0;
    }

    @Override
    public char nextChar() {
        return sourceCode.charAt(position);
    }

    @Override
    public void advance() {
        position++;
    }

    @Override
    public boolean hasNext() {
        return position < sourceCode.length();
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int pos) {
        position = pos;
    }
}
