package se.matstoms.axel.expressions;

import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-07.
 */
public class ValueExpression extends Expression {
    private Value value;

    public ValueExpression(Value value) {
        this.value = value;
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public ExpType getType() {
        return ExpType.VAL;
    }
}
