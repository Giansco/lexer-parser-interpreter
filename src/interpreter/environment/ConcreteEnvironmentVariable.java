package interpreter.environment;

import interpreter.exc.InvalidTypeAssignmentExc;

public class ConcreteEnvironmentVariable implements EnvironmentVariable {

    private String identifier;
    private IdentifierType type;


    public ConcreteEnvironmentVariable(String identifier, IdentifierType type) {
        this.identifier = identifier;
        this.type = type;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public IdentifierType getType() {
        return type;
    }
}
