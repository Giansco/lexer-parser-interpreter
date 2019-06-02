package lexer;

public interface LexerState {

    LexerState nextState(char input);
    boolean isAcceptanceState();
    String getDescription();
}
