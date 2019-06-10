package interpreter;

import main.parser_interpreter.NodeVisitor;

public class ConcreteInterpreter implements Interpreter {

    private NodeVisitor visitor;

    public ConcreteInterpreter(NodeVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public void interpret(InputSupplier supplier) {
        while (supplier.hasNext()){
            visitor.visitNode(supplier.nextInput());
        }
    }
}
