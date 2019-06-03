package main;

import lexer.Token;

public class Printer {

    public static void printToken(Token token){
        System.out.print("<"+token.getTokenType()+", "+token.getContent()+">");
    }
}
