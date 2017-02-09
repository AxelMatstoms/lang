package se.matstoms.axel.parsing;

import se.matstoms.axel.exceptions.LanguageException;
import se.matstoms.axel.types.Value;
import se.matstoms.axel.types.AString;
import se.matstoms.axel.types.Number;
import se.matstoms.axel.types.Types;
import se.matstoms.axel.util.Pair;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Axel on 2017-02-06.
 */
public class Tokenizer {
    private int index;
    private ProgramStream program;
    private ArrayList<Token> tokenList;
    private ArrayList<String> singleArgOps;
    private ArrayList<String> dualArgOps;
    private ArrayList<Character> opChars;
    private ArrayList<String> keywords;
    private Pattern idStart;


    public Tokenizer(ProgramStream ps) {
        this();
        this.program = ps;
    }

    public Tokenizer() {
        index = 0;
        tokenList = new ArrayList<>();
        singleArgOps = new ArrayList<>();
        dualArgOps = new ArrayList<>();
        opChars = new ArrayList<>();
        keywords = new ArrayList<>();
        idStart = Pattern.compile("a-z_$", Pattern.CASE_INSENSITIVE);
    }

    public void setProgram(ProgramStream ps) {
        this.program = ps;
    }

    public void registerSingleArgOperator(String op) {
        singleArgOps.add(op);
        char[] chars = op.toCharArray();
        for(char c : chars) {
            if(!opChars.contains(c)) {
                opChars.add(c);
            }
        }
    }

    public void registerDualArgOperator(String op) {
        dualArgOps.add(op);
        char[] chars = op.toCharArray();
        for(char c : chars) {
            if(!opChars.contains(c)) {
                opChars.add(c);
            }
        }
    }

    public void registerKeyword(String kw) {
        keywords.add(kw);
    }

    public TokenStream parse() {

        while(!program.eof()) {
            readWhile(Character::isWhitespace);
            char c = program.peek();
            if(c == '#') {
                skipComment();
            } else if(c == '"') {
                parseString();
            } else if(Character.isDigit(c) || (c == '.' && Character.isDigit(program.peek(1)))) {
                parseNumber();
            } else if(isIdStart(c)) {
                parseIdentifier();
            } else if(isPunctuation(c)) {
                tokenList.add(new Token(TokenType.PNC, c, program.getPos()));
            } else if(isOpChar(c)) {
                parseOp();
            } else {
                try {
                    program.error("Can't deal with character");
                } catch (LanguageException e) {
                    e.printStackTrace();
                }
            }
        }

        return new TokenStream(tokenList);
    }

    private void skipComment() {
        readWhile(c -> c != '\n');
    }

    private String readWhile(Predicate predicate) {
        String str = "";
        while(!program.eof() && predicate.test(program.peek())) {
            str += program.next();
        }
        return str;
    }

    private interface Predicate {
        boolean test(char c);
    }

    private void parseString() {
        String string = "";
        boolean cont = true;
        boolean started = false;
        char c;
        while(!program.eof() && cont) {
            c = program.next();
            if(c == '"') {
                if (!started) {
                    started = true;
                } else if(started  && program.peek(-1) == '\\') {
                    string += c;
                } else {
                    cont = false;
                }
            } else {
                string += c;
            }
        }
        tokenList.add(new Token(TokenType.VAL, new Pair<Types, Value>(Types.STR, new AString(string)), program.getPos()));
    }

    private void parseNumber() {
        boolean hasDot = false;
        String number = "";
        char c;
        boolean cont = true;
        while(!program.eof() && cont) {
            c = program.next();

            if(c == '.') {
                if(hasDot) {
                    cont = false;
                }
                hasDot = true;
            } else if(!Character.isDigit(c)) {
                cont = false;
            }

            if(cont) {
                number += c;
            }

        }
        tokenList.add(new Token(TokenType.VAL, new Pair<Types, Value>(Types.NUM, new Number(number)), program.getPos()));
    }

    private void parseIdentifier() {
        final Pattern p = Pattern.compile("[a-z0-9_$]", Pattern.CASE_INSENSITIVE);
        String str = readWhile(c -> {
            Matcher m = p.matcher(Character.toString(c));
            return m.matches();
        });
        TokenType type = keywords.contains(str) ? TokenType.KWR : TokenType.VAR;
        tokenList.add(new Token(type, str, program.getPos()));
    }

    private void parseOp() {
        tokenList.add(new Token(TokenType.OPR, readWhile(this::isOpChar), program.getPos()));
    }

    private void parsePunctuation() {
        tokenList.add(new Token(TokenType.PNC, program.next(), program.getPos()));
    }

    private boolean isPunctuation(char c) {
        return "(){}[],;.".contains(Character.toString(c));
    }

    private boolean isOpChar(char c) {
        return opChars.contains(c);
    }

    private boolean isIdStart(char c) {
        return idStart.matcher(Character.toString(c)).matches();
    }


}
