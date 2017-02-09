package se.matstoms.axel.expressions;

import se.matstoms.axel.runner.Variable;
import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-07.
 */
public abstract class AssignmentExpression extends Expression {
    protected Variable left;

    public abstract void assign();

    @Override
    public ExpType getType() {
        return ExpType.ASGN;
    }
}
