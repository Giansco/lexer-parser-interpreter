package interpreter;

import parser.tree.Node;

public interface InputSupplier {

    Node nextInput();
    boolean hasNext();
}
