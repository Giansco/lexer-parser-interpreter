package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
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
            Input input = supplier.nextInput();
            if (input.getType() == InputType.PLUS){
                supplier.advance();
                Node termNode2 = termHandler.handle(supplier);
                return new AdditionNode(expressionNode, termNode2);
            }else if (input.getType() == InputType.MINUS){
                supplier.advance();
                Node termNode2 = termHandler.handle(supplier);
                return new SubtractionNode(expressionNode, termNode2);
            }else{
                //not an operator
                return expressionNode;
            }
        }else {
            return expressionNode;
        }

//        throw new SyntaxErrorExc();
    }
}
