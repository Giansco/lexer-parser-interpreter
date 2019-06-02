package lexer.states;

public interface LexerState {

    LexerState nextState(char input);
    boolean isAcceptanceState();
    String getDescription();
}
