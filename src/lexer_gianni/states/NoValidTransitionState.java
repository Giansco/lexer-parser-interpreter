package lexer_gianni.states;

public class NoValidTransitionState extends AbstractNormalLexerState {

    public NoValidTransitionState() {
        super("NoValidTransition");
    }

    @Override
    public LexerState nextState(char input) {
        return new NoValidTransitionState();
    }
}
