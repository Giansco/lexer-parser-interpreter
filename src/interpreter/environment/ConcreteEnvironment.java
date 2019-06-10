package interpreter.environment;

import interpreter.exc.IdentifierNotFoundExc;
import interpreter.exc.InvalidTypeAssignmentExc;

import java.util.HashMap;
import java.util.Map;

public class ConcreteEnvironment implements Environment {

    private Map<EnvironmentVariable, EnvironmentValue> variables;

    public ConcreteEnvironment() {
        variables = new HashMap<>();
    }

    @Override
    public void addVariableWithValue(EnvironmentVariable var, EnvironmentValue value) {
        if(value.matches(var.getType())){
            variables.put(var, value);
        } else throw new InvalidTypeAssignmentExc();
    }

    @Override
    public void addVariable(EnvironmentVariable var) {
        variables.put(var, null);
    }

    @Override
    public void setValueToVariable(String identifier, EnvironmentValue value) {
        EnvironmentVariable var = variables.keySet()
                .stream()
                .filter(ev -> ev.getIdentifier().equals(identifier))
                .findFirst()
                .orElseThrow(IdentifierNotFoundExc::new);
        if(value.matches(var.getType())){
            variables.put(var, value);
        } else throw new InvalidTypeAssignmentExc();
    }

    @Override
    public EnvironmentValue getVariableValue(String identifier) {
        EnvironmentVariable var = variables.keySet()
                .stream()
                .filter(ev -> ev.getIdentifier().equals(identifier))
                .findFirst()
                .orElseThrow(IdentifierNotFoundExc::new);
        return variables.get(var);
    }

}
