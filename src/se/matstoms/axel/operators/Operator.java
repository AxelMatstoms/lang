package se.matstoms.axel.operators;

import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-06.
 */
public abstract class Operator {

    public static abstract class SingleArg<R extends Value, A extends Value> {
        public abstract R operate(A arg);
    }

    public static abstract class DualArg<R extends Value, A1 extends Value, A2 extends Value> {
        public abstract R operate(A1 arg1, A2 arg2);
    }
}
