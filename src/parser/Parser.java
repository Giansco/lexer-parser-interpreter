package parser;

import parser.tree.Node;

public interface Parser {

    Node parse(InputSupplier supplier);
}
