package interpreter.environment;

import interpreter.exc.InvalidOperationExc;

public class StringValue implements EnvironmentValue {

    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean matches(IdentifierType identifierType) {
        return identifierType == IdentifierType.STRING;
    }

    @Override
    public EnvironmentValue sum(EnvironmentValue rightVal) {
        return rightVal.sumWithString(this);
    }

    @Override
    public EnvironmentValue subtract(EnvironmentValue rightVal) {
        return rightVal.subtractWithString(this);
    }

    @Override
    public EnvironmentValue multiply(EnvironmentValue rightVal) {
        return rightVal.multiplyWithString(this);
    }

    @Override
    public EnvironmentValue divide(EnvironmentValue rightVal) {
        return rightVal.divideWithString(this);
    }

    @Override
    public EnvironmentValue sumWithNumber(NumberValue leftVal) {
        return new StringValue(leftVal.getValue() + value);//check
    }

    @Override
    public EnvironmentValue sumWithString(StringValue leftVal) {
        return new StringValue(leftVal.getValue() + value);
    }

    @Override
    public EnvironmentValue subtractWithNumber(NumberValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public EnvironmentValue subtractWithString(StringValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public EnvironmentValue multiplyWithNumber(NumberValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public EnvironmentValue multiplyWithString(StringValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public EnvironmentValue divideWithNumber(NumberValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public EnvironmentValue divideWithString(StringValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public String toValueString() {
        return value;
    }
}
