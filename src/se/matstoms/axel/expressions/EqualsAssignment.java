package se.matstoms.axel.expressions;

import se.matstoms.axel.runner.Variable;
import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-07.
 */
public class EqualsAssignment extends AssignmentExpression{
    private Expression right;

    public EqualsAssignment(Variable left, Expression right) {
        this.left = left;
        this.right = right;
        assign();
    }

    @Override
    public Value getValue() {
        return right.getValue();
    }

    @Override
    public void assign() {
        left.setValue(right.getValue());
    }
}
