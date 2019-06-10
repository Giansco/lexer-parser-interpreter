package interpreter;

import parser.tree.Node;

import java.util.Iterator;

public class ConcreteInputSupplier implements InputSupplier {

    private Iterator<Node> inputs;

    public ConcreteInputSupplier(Iterator<Node> inputs) {
        this.inputs = inputs;
    }

    @Override
    public Node nextInput() {
        return inputs.next();
    }

    @Override
    public boolean hasNext() {
        return inputs.hasNext();
    }
}
