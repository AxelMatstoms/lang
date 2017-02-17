package se.matstoms.axel.types;

/**
 * Created by Axel on 2017-02-06.
 */
public class Number extends Value {
    private long intValue;
    private double doubleValue;
    boolean preferInt;


    public Number(String input) {
        this.doubleValue = Float.parseFloat(input);
        this.intValue = (int) this.doubleValue;
        this.preferInt = this.intValue == this.doubleValue;
    }

    public Number(long i) {
        this.intValue = i;
        this.doubleValue = (float) this.intValue;
        this.preferInt = this.intValue == this.doubleValue;
    }

    public Number(double d) {
        this.doubleValue = d;
        this.intValue = (int) this.doubleValue;
        this.preferInt = this.intValue == this.doubleValue;
    }

    public long getIntValue() {
        return this.intValue;
    }

    public double getFloatValue() {
        return this.doubleValue;
    }

    @Override
    public AString toAString() {
        return new AString(preferInt ? Long.toString(intValue) : Double.toString(doubleValue));
    }

    @Override
    public Types getType() {
        return Types.NUM;
    }

    @Override
    public String toString() {
        return preferInt ? Long.toString(intValue) : Double.toString(doubleValue);
    }
}
