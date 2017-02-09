package se.matstoms.axel.types;

/**
 * Created by Axel on 2017-02-08.
 */
public class AVoid extends Value{

    private static AVoid instance = new AVoid();

    private AVoid() {

    }

    public static AVoid getInstance() {
        return instance;
    }

    @Override
    public AString toAString() {
        return new AString("");
    }

    @Override
    public Types getType() {
        return Types.VOD;
    }
}
