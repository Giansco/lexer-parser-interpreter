package main.parser_interpreter;

public interface Element {

    void accept(NodeVisitor visitor);
}
