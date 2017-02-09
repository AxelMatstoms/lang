package se.matstoms.axel.exceptions;

/**
 * Created by Axel on 2017-02-07.
 */
public class LanguageException extends Exception {
    public LanguageException(String message, int line, int col) {
        super(String.format("%$1s at row %$2d, column %3$d", message, line, col));
    }
}
