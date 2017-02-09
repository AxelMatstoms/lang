package se.matstoms.axel.types;

import se.matstoms.axel.types.AString;

/**
 * Created by Axel on 2017-02-06.
 */
public abstract class Value {
    public abstract AString toAString();
    public abstract Types getType();
}
