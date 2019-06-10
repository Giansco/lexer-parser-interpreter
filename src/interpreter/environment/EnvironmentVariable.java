package interpreter.environment;

public interface EnvironmentVariable {

    String getIdentifier();

    IdentifierType getType();
}
