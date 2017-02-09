package se.matstoms.axel.expressions;

import se.matstoms.axel.operators.Operator;
import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-07.
 */
public class BinaryExpression extends Expression{
    private Operator.DualArg operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(Operator.DualArg operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public Value getValue() {
        return operator.operate(left.getValue(), right.getValue());
    }

    @Override
    public ExpType getType() {
        return ExpType.BIN;
    }
}
