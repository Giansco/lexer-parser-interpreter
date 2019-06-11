package parser.handlers;

import parser.Input;
import parser.InputSupplier;
import parser.InputType;
import parser.exc.DeclarationWithoutColonExc;
import parser.exc.DeclarationWithoutLetExc;
import parser.exc.SyntaxErrorExc;
import parser.tree.Node;
import parser.tree.declarations.AssignedDeclarationNode;
import parser.tree.declarations.UnassignedDeclarationNode;

public class DeclarationHandler implements Handler {

    private Handler expressionHandler;
    private Handler typeHandler;
    private Handler literalHandler;

    public DeclarationHandler(Handler expressionHandler, Handler typeHandler, Handler literalHandler) {
        this.expressionHandler = expressionHandler;
        this.typeHandler = typeHandler;
        this.literalHandler = literalHandler;
    }

    @Override
    public Node handle(InputSupplier supplier) {
        if (supplier.hasNext()){
            Input let = supplier.nextInput();
            supplier.advance();

            if (let.getType() == InputType.LET){
                Node identifierNode = literalHandler.handle(supplier);
                Input colon = supplier.nextInput();//should check hasNext again
                supplier.advance();

                if (colon.getType() == InputType.COLON){
                    Node typeNode = typeHandler.handle(supplier);

                    //check for equals
                    if(supplier.hasNext()){
                        Input equals = supplier.nextInput(); //should check hasNext again
                        if (equals.getType() == InputType.EQUALS){
                            supplier.advance();
                            Node expressionNode = expressionHandler.handle(supplier);
                            return new AssignedDeclarationNode(identifierNode,typeNode,expressionNode);
                        }else {
                            return new UnassignedDeclarationNode(identifierNode, typeNode);
                        }
                    }else {
                        return new UnassignedDeclarationNode(identifierNode, typeNode);
                    }
                }else throw new DeclarationWithoutColonExc();
            }else throw new DeclarationWithoutLetExc();
        }

        throw new SyntaxErrorExc();
    }
}
