package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.tree.AssignmentNode;
import parser.tree.expressions.AdditionNode;
import parser.tree.Node;
import parser.tree.expressions.SimpleExpressionNode;
import parser.tree.expressions.SubtractionNode;


public class ExpressionHandler implements Handler {

    private Handler termHandler;

    public ExpressionHandler(Handler termHandler) {
        this.termHandler = termHandler;
    }

    @Override
    public Node handle(InputSupplier supplier) {

        Node termNode = termHandler.handle(supplier);
        Node expressionNode = new SimpleExpressionNode(termNode); //Add expression node

        if (supplier.hasNext()){
            return recursiveHandle(expressionNode, supplier);
        }else {
            return expressionNode;
        }
    }

    private Node recursiveHandle(Node exp, InputSupplier supplier){

        Input input = supplier.nextInput();
        if (input.getType() == InputType.PLUS){
            supplier.advance();
            Node termNode = termHandler.handle(supplier);
            return recursiveHandle(new AdditionNode(exp, termNode), supplier);
        }else if (input.getType() == InputType.MINUS){
            supplier.advance();
            Node termNode = termHandler.handle(supplier);
            return recursiveHandle(new SubtractionNode(exp, termNode), supplier);
        }else{
            //not an operator
            return exp;
        }
    }
}
