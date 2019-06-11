package lexer_gianni.states;

public abstract class AbstractNormalLexerState implements LexerState {

    private String desc;

    public AbstractNormalLexerState(){this.desc = "";}

    public AbstractNormalLexerState(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean isAcceptanceState() {
        return false;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
