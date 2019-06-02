package main;

import lexer.Token;

public class Printer {

    public static void printToken(Token token){
        System.out.println("<"+token.getTokenType()+", "+token.getContent()+">");
    }
}
