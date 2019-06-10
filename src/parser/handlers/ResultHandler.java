package parser.handlers;

import parser.InputSupplier;
import parser.tree.Node;
import parser.tree.ResultNode;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler implements Handler {

    private Handler statementHandler;

    public ResultHandler(Handler statementHandler) {
        this.statementHandler = statementHandler;
    }

    @Override
    public Node handle(InputSupplier supplier) {

        List<Node> results = new ArrayList<>();

        while (supplier.hasNext()){
            Node statementNode = statementHandler.handle(supplier);
            results.add(statementNode);
        }

        return new ResultNode(results);
    }
}
