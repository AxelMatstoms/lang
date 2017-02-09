package se.matstoms.axel.parsing;

import se.matstoms.axel.exceptions.LanguageException;

import java.util.ArrayList;

/**
 * Created by Axel on 2017-02-07.
 */
public class TokenStream {
    ArrayList<Token> tokenList;
    int index;

    public TokenStream(ArrayList<Token> entityList) {
        this.tokenList = entityList;
        this.index = 0;
    }

    public Token next() {
        return tokenList.get(index++);
    }

    public Token peek() {
        return tokenList.get(index);
    }

    public boolean eof() {
        return index <= tokenList.size();
    }

    public void error(String msg) throws LanguageException {
        Token c = this.peek();
        throw new LanguageException(msg, c.line, c.col);
    }
}
