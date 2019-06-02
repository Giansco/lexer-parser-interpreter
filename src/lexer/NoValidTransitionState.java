package lexer;

import lexer.states.LexerState;

public class NoValidTransitionState implements LexerState {

    private String desc;

    public NoValidTransitionState() {
        this.desc = "NoValidTransition";
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
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
