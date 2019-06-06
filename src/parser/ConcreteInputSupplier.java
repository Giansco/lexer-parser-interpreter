package parser;

import java.util.List;

public class ConcreteInputSupplier implements InputSupplier {

    private List<Input> inputs;
    private int position;

    public ConcreteInputSupplier(List<Input> inputs) {
        this.inputs = inputs;
        this.position = 0;
    }

    @Override
    public Input nextInput() {
        return inputs.get(position);
    }

    @Override
    public void advance() {
        position++;
    }

    @Override
    public boolean hasNext() {
        return position < inputs.size();
    }
}
