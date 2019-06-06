package parser;

public interface Parser {

    ASTNode parse(ASTNodeSupplier supplier);
}
