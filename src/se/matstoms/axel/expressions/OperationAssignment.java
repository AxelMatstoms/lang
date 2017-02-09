package se.matstoms.axel.expressions;

import se.matstoms.axel.operators.Operator;
import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-07.
 */
public class OperationAssignment extends AssignmentExpression {
    private Expression right;
    private Operator.DualArg operator;

    @Override
    public Value getValue() {
        return null;
    }

    @Override
    public void assign() {
        left.setValue(operator.operate(left.getValue(), right.getValue()));
    }
}
