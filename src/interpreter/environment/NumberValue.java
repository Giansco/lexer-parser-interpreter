package interpreter.environment;

import interpreter.exc.InvalidOperationExc;

public class NumberValue implements EnvironmentValue {

    private Double value;

    public NumberValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean matches(IdentifierType identifierType) {
        return identifierType == IdentifierType.NUMBER;
    }

    @Override
    public EnvironmentValue sum(EnvironmentValue rightVal) {
        return rightVal.sumWithNumber(this);
    }

    @Override
    public EnvironmentValue subtract(EnvironmentValue rightVal) {
        return rightVal.subtractWithNumber(this);
    }

    @Override
    public EnvironmentValue multiply(EnvironmentValue rightVal) {
        return rightVal.multiplyWithNumber(this);
    }

    @Override
    public EnvironmentValue divide(EnvironmentValue rightVal) {
        return rightVal.divideWithNumber(this);
    }

    @Override
    public EnvironmentValue sumWithNumber(NumberValue leftVal) {
        return new NumberValue(leftVal.getValue() + value);
    }

    @Override
    public EnvironmentValue sumWithString(StringValue leftVal) {
        return new StringValue(leftVal.getValue() + value);//check
    }

    @Override
    public EnvironmentValue subtractWithNumber(NumberValue leftVal) {
        return new NumberValue(leftVal.getValue() - value);
    }

    @Override
    public EnvironmentValue subtractWithString(StringValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public EnvironmentValue multiplyWithNumber(NumberValue leftVal) {
        return new NumberValue(leftVal.getValue() * value);
    }

    @Override
    public EnvironmentValue multiplyWithString(StringValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public EnvironmentValue divideWithNumber(NumberValue leftVal) {
        return new NumberValue(leftVal.getValue() / value);
    }

    @Override
    public EnvironmentValue divideWithString(StringValue leftVal) {
        throw new InvalidOperationExc();
    }

    @Override
    public String toValueString() {
        return String.valueOf(value);
    }
}
