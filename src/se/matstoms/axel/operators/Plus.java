package se.matstoms.axel.operators;

import se.matstoms.axel.types.Number;

/**
 * Created by Axel on 2017-02-06.
 */
public class Plus extends Operator.DualArg<Number, Number, Number> {
    @Override
    public Number operate(Number arg1, Number arg2) {
        return new Number(arg1.getFloatValue()+ arg2.getFloatValue());
    }
}
