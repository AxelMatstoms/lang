package se.matstoms.axel.runner;

import se.matstoms.axel.types.Value;

/**
 * Created by Axel on 2017-02-07.
 */
public class Variable {
    private String identifier;
    private Value value;

    public Value getValue() {
        return value;
    }

    public void setValue(Value v) {
        this.value = v;
    }
}
