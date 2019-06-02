package lexer;

import lexer.exceptions.NoMatchFoundExc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteLexer implements Lexer {

    private List<LexerAutomata> automatas;

    public ConcreteLexer(List<LexerAutomata> automatas) {
        this.automatas = automatas;
    }

    @Override
    public List<Token> lex(CharSupplier charSupplier) {
        List<Token> res = new ArrayList<>();

        while(charSupplier.hasNext()){
            res.add(nextToken(charSupplier));
            automatas.forEach(LexerAutomata::clear);
        }

        return res;
    }

    private Token nextToken(CharSupplier charSupplier){

        List<LexerAutomata> validAutomatas = new ArrayList<>(automatas);

        while(validAutomatas.size() > 0 && charSupplier.hasNext()){
            char input = charSupplier.nextChar();
            validAutomatas = validAutomatas.stream().filter(a -> a.run(input)).collect(Collectors.toList());
            if(!validAutomatas.isEmpty()) charSupplier.advance();
        }

        for (LexerAutomata a : automatas) {
            Token tkn = a.getGeneratedToken();
            if (tkn != null) return tkn;
        }

        throw new NoMatchFoundExc();
    }
}

