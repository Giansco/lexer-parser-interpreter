package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.exc.InvalidPrintExc;
import parser.exc.SyntaxErrorExc;
import parser.tree.Node;
import parser.tree.PrintNode;

public class PrintHandler implements Handler {

    private Handler expressionHandler;

    public PrintHandler(Handler expressionHandler) {
        this.expressionHandler = expressionHandler;
    }

    @Override
    public Node handle(InputSupplier supplier) {
        if (supplier.hasNext()){
            Input print = supplier.nextInput();
            supplier.advance();
            Input openParenthesis = supplier.nextInput();//should check hasNext again
            supplier.advance();

            if (print.getType() == InputType.PRINT && openParenthesis.getType() == InputType.OPEN_PARENTHESIS){
                Node expressionNode = expressionHandler.handle(supplier);

                Input closeParenthesis = supplier.nextInput();//should check hasNext again
                supplier.advance();
                if (closeParenthesis.getType() == InputType.CLOSE_PARENTHESIS){
                    return new PrintNode(expressionNode);
                }else throw new InvalidPrintExc();
            }else throw new InvalidPrintExc();
        }

        throw new SyntaxErrorExc();
    }
}
