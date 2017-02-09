package se.matstoms.axel.expressions;

import se.matstoms.axel.types.AVoid;
import se.matstoms.axel.types.Value;

import java.util.ArrayList;

/**
 * Created by Axel on 2017-02-08.
 */
public class CodeExpression extends Expression {
    ArrayList<Expression> code;

    public CodeExpression() {
        this.code = new ArrayList<>();
    }

    public CodeExpression(ArrayList<Expression> code) {
        this.code = code;
    }

    public void putExpression(Expression e) {
        code.add(e);
    }

    @Override
    public Value getValue() {
        return AVoid.getInstance();
    }

    @Override
    public ExpType getType() {
        return ExpType.CODE;
    }
}
