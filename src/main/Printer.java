package main;

import interpreter.environment.EnvironmentValue;
import lexer_gianni.Token;

public class Printer {

    public static void printToken(Token token){
        System.out.print("<"+token.getTokenType()+", "+token.getContent()+">");
    }

    public static void printValue(EnvironmentValue value){
        System.out.println(value.toValueString());
    }
}
