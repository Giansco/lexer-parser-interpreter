package interpreter.environment;

public interface Environment {

    void addVariableWithValue(EnvironmentVariable var, EnvironmentValue value);
    void addVariable(EnvironmentVariable var);
    void setValueToVariable(String identifier, EnvironmentValue value);
    EnvironmentValue getVariableValue(String identifier);
}
