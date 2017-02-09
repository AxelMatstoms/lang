package se.matstoms.axel.expressions;

import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-07.
 */
public abstract class Expression {
    public abstract Value getValue();
    public abstract ExpType getType();
}
