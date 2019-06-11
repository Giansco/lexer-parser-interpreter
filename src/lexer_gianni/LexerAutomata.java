package lexer_gianni;

public interface LexerAutomata {

    boolean run(char input);
    Token getGeneratedToken();
    void clear();
    int getAmountProcessed();
}
