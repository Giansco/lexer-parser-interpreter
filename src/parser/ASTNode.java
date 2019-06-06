package parser;

import java.util.List;

public interface ASTNode {

    List<ASTNode> getChildren();
    ParserType getType();
    String getValue();
}
