package lexer;

public interface LexerAutomata {

    boolean run(char input);
    Token getGeneratedToken();
    void clear();
}
