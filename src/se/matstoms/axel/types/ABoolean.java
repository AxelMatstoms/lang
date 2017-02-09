package se.matstoms.axel.types;

/**
 * Created by Axel on 2017-02-07.
 */
public class ABoolean extends Value {
    private boolean value;

    public ABoolean(String value) {
        this.value = value.equals("true") ? true : false;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public AString toAString() {
        return new AString(value ? "true" : "false");
    }

    @Override
    public Types getType() {
        return Types.BOL;
    }
}
