package se.matstoms.axel.parsing;

import se.matstoms.axel.exceptions.LanguageException;
import se.matstoms.axel.expressions.BinaryExpression;
import se.matstoms.axel.expressions.CodeExpression;
import se.matstoms.axel.expressions.Expression;
import se.matstoms.axel.expressions.ValueExpression;
import se.matstoms.axel.operators.Operator;
import se.matstoms.axel.runner.Keyword;
import se.matstoms.axel.types.Number;
import se.matstoms.axel.types.Types;
import se.matstoms.axel.types.Value;
import se.matstoms.axel.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Axel on 2017-02-07.
 */
public class ASTGenerator {
    private TokenStream tStream;
    private HashMap<String, Integer> precedence;
    private HashMap<String, Class<? extends Value>> types;
    private HashMap<String, Operator.DualArg<? extends Value, ? extends Value, ? extends Value>> dualArgOps;
    private HashMap<String, Operator.SingleArg<? extends Value, ? extends Value>> singleArgOps;
    private ArrayList<Pair<String, Keyword>> keywords;

    public ASTGenerator() {
        this.precedence = new HashMap<>();
    }

    public ASTGenerator(TokenStream tStream) {
        this.tStream = tStream;
        this.precedence = new HashMap<>();
    }

    public void setTokenStream(TokenStream tStream) {
        this.tStream = tStream;
    }

    public void registerDualArgOperator(String token, Operator.DualArg<? extends Value, ? extends Value, ? extends Value> o, int pre) {
        precedence.put(token, pre);
        dualArgOps.put(token, o);
    }

    public void registerSingleArgOperator(String token, Operator.SingleArg<? extends Value, ? extends Value> o) {
        singleArgOps.put(token, o);
    }

    public Expression parseTopLevel() {
        CodeExpression ce = new CodeExpression();

        while(!tStream.eof()) {
            ce.putExpression(parseExpression());
            if(!tStream.eof()) skipPunc(';');
        }

        return ce;
    }

    private Expression parseExpression() {

        return new ValueExpression(new Number(2));
    }

    private Expression parseBinary(Token left, int myPrec) {

    }

    private void skipPunc(char punc) {
        if(isPunc(punc)) {
            tStream.next();
        } else {
            try {
                tStream.error("Excpected token " + punc);
            } catch (LanguageException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPunc(char c) {
        Token tok = tStream.peek();
        return tok.tokenType == TokenType.PNC && tok.value.equals(c);
    }
}
