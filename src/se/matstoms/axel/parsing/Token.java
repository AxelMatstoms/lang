package se.matstoms.axel.parsing;

import se.matstoms.axel.util.Pair;

/**
 * Created by Axel on 2017-02-06.
 */
public class Token {
    TokenType tokenType;
    Object value;
    int line, col;

    public Token(TokenType en, Object value) {
        this.tokenType = en;
        this.value = value;
    }

    public Token(TokenType tt, Object value, Pair<Integer, Integer> pos) {
        this(tt, value);
        this.line = pos.getFirst();
        this.col = pos.getSecond();
    }
}
