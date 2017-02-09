package se.matstoms.axel.types;

/**
 * Created by Axel on 2017-02-06.
 */
public class AString extends Value {
    private String value;

    public AString(String str) {
        this.value = str;
    }

    public String getValue() {
        return value;
    }


    @Override
    public AString toAString() {
        return this;
    }

    @Override
    public Types getType() {
        return Types.STR;
    }
}
