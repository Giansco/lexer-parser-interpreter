package interpreter.environment;

public interface EnvironmentValue {

    boolean matches(IdentifierType identifierType);

    EnvironmentValue sum(EnvironmentValue rightVal);
    EnvironmentValue subtract(EnvironmentValue rightVal);
    EnvironmentValue multiply(EnvironmentValue rightVal);
    EnvironmentValue divide(EnvironmentValue rightVal);

    EnvironmentValue sumWithNumber(NumberValue leftVal);
    EnvironmentValue sumWithString(StringValue leftVal);
    EnvironmentValue subtractWithNumber(NumberValue leftVal);
    EnvironmentValue subtractWithString(StringValue leftVal);
    EnvironmentValue multiplyWithNumber(NumberValue leftVal);
    EnvironmentValue multiplyWithString(StringValue leftVal);
    EnvironmentValue divideWithNumber(NumberValue leftVal);
    EnvironmentValue divideWithString(StringValue leftVal);

    String toValueString();
}
