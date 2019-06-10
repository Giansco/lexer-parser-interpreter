package main.parser_interpreter;

import interpreter.environment.*;
import javafx.util.Pair;
import main.Printer;
import parser.tree.*;
import parser.tree.declarations.AssignedDeclarationNode;
import parser.tree.declarations.UnassignedDeclarationNode;
import parser.tree.expressions.AdditionNode;
import parser.tree.expressions.SimpleExpressionNode;
import parser.tree.expressions.SubtractionNode;
import parser.tree.literals.IdentifierNode;
import parser.tree.literals.NumberLiteralNode;
import parser.tree.literals.StringLiteralNode;
import parser.tree.terms.DivisionNode;
import parser.tree.terms.MultiplicityNode;
import parser.tree.terms.SimpleTermNode;
import parser.tree.types.NumberTypeNode;
import parser.tree.types.StringTypeNode;

import java.util.Stack;

public class ConcreteNodeVisitor implements NodeVisitor {

    private Environment environment;
    private Stack<Pair<String, Integer>> identifiers;
    private Stack<Pair<IdentifierType, Integer>> types;
    private Stack<Pair<EnvironmentValue, Integer>> values;

    private int order;


    public ConcreteNodeVisitor() {
        environment = new ConcreteEnvironment();
        identifiers = new Stack<>();
        types = new Stack<>();
        values = new Stack<>();
        order = 0;
    }

    @Override
    public void visitNode(Node node) {
        node.accept(this);
    }

    @Override
    public void visitResultNode(ResultNode node) {
        node.getChildren().forEach(n -> n.accept(this));
    }

    @Override
    public void visitStatementNode(StatementNode node) {
        node.getChild().accept(this);
    }

    @Override
    public void visitAssignedDeclarationNode(AssignedDeclarationNode node) {
        node.getIdentifier().accept(this);
        node.getType().accept(this);
        node.getExpression().accept(this);

        environment.addVariableWithValue(new ConcreteEnvironmentVariable(identifiers.pop().getKey(), types.pop().getKey()), values.pop().getKey());
    }

    @Override
    public void visitUnassignedDeclarationNode(UnassignedDeclarationNode node) {
        node.getIdentifier().accept(this);
        node.getType().accept(this);

        environment.addVariable(new ConcreteEnvironmentVariable(identifiers.pop().getKey(), types.pop().getKey()));
    }

    @Override
    public void visitAssignmentNode(AssignmentNode node) {
        node.getIdentifierNode().accept(this);
        node.getExpressionNode().accept(this);

        environment.setValueToVariable(identifiers.pop().getKey(),values.pop().getKey());
    }

    @Override
    public void visitPrintNode(PrintNode node) {
        node.getExpressionNode().accept(this);

        EnvironmentValue result = values.pop().getKey();

        Printer.printValue(result);
    }

    @Override
    public void visitIdentifierNode(IdentifierNode node) {
        identifiers.push(new Pair<>(node.getValue(), order++));
    }

    @Override
    public void visitStringTypeNode(StringTypeNode node) {
        types.push(new Pair<>(IdentifierType.STRING, order++));
    }

    @Override
    public void visitNumberTypeNode(NumberTypeNode node) {
        types.push(new Pair<>(IdentifierType.NUMBER, order++));
    }

    @Override
    public void visitSimpleExpressionNode(SimpleExpressionNode node) {
        node.getChild().accept(this);
    }

    @Override
    public void visitAdditionExpressionNode(AdditionNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);

        switch (values.size()){
            case 1:
                Pair<EnvironmentValue, Integer> val = getEnvironmentValueFromId();
                Pair<EnvironmentValue, Integer> val2 = values.pop();
                if (val.getValue() < val2.getValue())
                    values.push(new Pair<>(val.getKey().sum(val2.getKey()), order++));
                else
                    values.push(new Pair<>(val2.getKey().sum(val.getKey()), order++));
                break;
            case 0:
                EnvironmentValue right = getEnvironmentValueFromId().getKey();
                EnvironmentValue left = getEnvironmentValueFromId().getKey();
                values.push(new Pair<>(left.sum(right), order++));
                break;
            default:
                EnvironmentValue right2 = values.pop().getKey();
                EnvironmentValue left2 = values.pop().getKey();
                values.push(new Pair<>(left2.sum(right2), order++));
                break;
        }
    }

    private Pair<EnvironmentValue, Integer> getEnvironmentValueFromId(){
        Pair<String, Integer> id = identifiers.pop();
        return new Pair<>(environment.getVariableValue(id.getKey()), id.getValue());
    }

    @Override
    public void visitSubtractionExpressionNode(SubtractionNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);

        switch (values.size()){
            case 1:
                Pair<EnvironmentValue, Integer> val = getEnvironmentValueFromId();
                Pair<EnvironmentValue, Integer> val2 = values.pop();
                if (val.getValue() < val2.getValue())
                    values.push(new Pair<>(val.getKey().subtract(val2.getKey()), order++));
                else
                    values.push(new Pair<>(val2.getKey().subtract(val.getKey()), order++));
                break;
            case 0:
                EnvironmentValue right = getEnvironmentValueFromId().getKey();
                EnvironmentValue left = getEnvironmentValueFromId().getKey();
                values.push(new Pair<>(left.subtract(right), order++));
                break;
            default:
                EnvironmentValue right2 = values.pop().getKey();
                EnvironmentValue left2 = values.pop().getKey();
                values.push(new Pair<>(left2.subtract(right2), order++));
                break;
        }
    }

    @Override
    public void visitSimpleTermNode(SimpleTermNode node) {
        node.getChild().accept(this);
    }

    @Override
    public void visitDivisionTermNode(DivisionNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);

        switch (values.size()){
            case 1:
                Pair<EnvironmentValue, Integer> val = getEnvironmentValueFromId();
                Pair<EnvironmentValue, Integer> val2 = values.pop();
                if (val.getValue() < val2.getValue())
                    values.push(new Pair<>(val.getKey().divide(val2.getKey()), order++));
                else
                    values.push(new Pair<>(val2.getKey().divide(val.getKey()), order++));
                break;
            case 0:
                EnvironmentValue right = getEnvironmentValueFromId().getKey();
                EnvironmentValue left = getEnvironmentValueFromId().getKey();
                values.push(new Pair<>(left.divide(right), order++));
                break;
            default:
                EnvironmentValue right2 = values.pop().getKey();
                EnvironmentValue left2 = values.pop().getKey();
                values.push(new Pair<>(left2.divide(right2), order++));
                break;
        }
    }

    @Override
    public void visitMultiplicityTermNode(MultiplicityNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);

        switch (values.size()){
            case 1:
                Pair<EnvironmentValue, Integer> val = getEnvironmentValueFromId();
                Pair<EnvironmentValue, Integer> val2 = values.pop();
                if (val.getValue() < val2.getValue())
                    values.push(new Pair<>(val.getKey().multiply(val2.getKey()), order++));
                else
                    values.push(new Pair<>(val2.getKey().multiply(val.getKey()), order++));
                break;
            case 0:
                EnvironmentValue right = getEnvironmentValueFromId().getKey();
                EnvironmentValue left = getEnvironmentValueFromId().getKey();
                values.push(new Pair<>(left.multiply(right), order++));
                break;
            default:
                EnvironmentValue right2 = values.pop().getKey();
                EnvironmentValue left2 = values.pop().getKey();
                values.push(new Pair<>(left2.multiply(right2), order++));
                break;
        }
    }

    @Override
    public void visitStringLiteralNode(StringLiteralNode node) {
        values.push(new Pair<>(new StringValue(node.getValue()), order++));
    }

    @Override
    public void visitNumberLiteralNode(NumberLiteralNode node) {
        values.push(new Pair<>(new NumberValue(node.getValue()), order++));
    }
}
