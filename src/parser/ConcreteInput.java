package parser;

public class ConcreteInput implements Input {

    private InputType type;
    private String value;

    public ConcreteInput(InputType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public InputType getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }
}
