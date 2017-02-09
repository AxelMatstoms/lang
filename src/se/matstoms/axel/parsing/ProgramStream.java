package se.matstoms.axel.parsing;

import se.matstoms.axel.exceptions.LanguageException;
import se.matstoms.axel.util.Pair;

/**
 * Created by Axel on 2017-02-06.
 */
public class ProgramStream {
    String program;
    int pos,
        line,
        col;

    public ProgramStream(String program) {
        this.program = program;
        this.pos = 0;
        this.line = 1;
        this.col = 0;
    }

    public char next() {
        char c = program.charAt(pos++);
        if(c == '\n') {
            line++;
            col = 0;
        } else {
            col++;
        }
        return c;
    }

    public char peek() {
        return program.charAt(pos);
    }

    public char peek(int i) {
        return program.charAt(pos + i);
    }

    public Pair<Integer, Integer> getPos() {
        return new Pair<>(line, col);
    }

    public boolean eof() {
        return pos >= program.length();
    }

    public void error(String message) throws LanguageException{
        throw new LanguageException(message, line, col);
    }
}
