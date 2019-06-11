package lexer_gianni.states;

public interface LexerState {

    LexerState nextState(char input);
    boolean isAcceptanceState();
    String getDescription();
}
