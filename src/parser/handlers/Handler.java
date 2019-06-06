package parser.handlers;

import parser.InputSupplier;
import parser.tree.Node;
import parser.tree.StatementNode;

public interface Handler {

    Node handle(InputSupplier supplier);
}
