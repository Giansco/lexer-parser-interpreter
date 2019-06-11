package lexer_gianni.states;

public abstract class AbstractAcceptingLexerState implements LexerState {

    private String desc;

    public AbstractAcceptingLexerState(){this.desc = "";}

    public AbstractAcceptingLexerState(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean isAcceptanceState() {
        return true;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
