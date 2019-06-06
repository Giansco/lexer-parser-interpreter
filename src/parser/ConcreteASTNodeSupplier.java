package parser;

import lexer.Token;

import java.util.List;

public class ConcreteASTNodeSupplier implements ASTNodeSupplier {

    private List<Token> tokens;

    public ConcreteASTNodeSupplier(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<ASTNode> getASTNodes() {
        return null;
    }
}
