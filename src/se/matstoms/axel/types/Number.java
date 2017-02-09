package se.matstoms.axel.types;

/**
 * Created by Axel on 2017-02-06.
 */
public class Number extends Value {
    private long intValue;
    private double floatValue;
    boolean preferInt;


    public Number(String input) {
        this.floatValue = Float.parseFloat(input);
        this.intValue = (int) this.floatValue;
        this.preferInt = this.intValue == this.floatValue;
    }

    public Number(int i) {
        this.intValue = i;
        this.floatValue = (float) this.intValue;
        this.preferInt = this.intValue == this.floatValue;
    }

    public Number(float f) {
        this.floatValue = f;
        this.intValue = (int) this.floatValue;
        this.preferInt = this.intValue == this.floatValue;
    }

    public long getIntValue() {
        return this.intValue;
    }

    public double getFloatValue() {
        return this.floatValue;
    }

    @Override
    public AString toAString() {
        return new AString(preferInt ? Long.toString(intValue) : Double.toString(floatValue));
    }

    @Override
    public Types getType() {
        return Types.NUM;
    }

    @Override
    public String toString() {
        return preferInt ? Long.toString(intValue) : Double.toString(floatValue);
    }
}
