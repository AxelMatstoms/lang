package se.matstoms.axel;

import se.matstoms.axel.parsing.Tokenizer;
import se.matstoms.axel.parsing.ProgramStream;

/**
 * Created by Axel on 2017-02-06.
 */
public class Main {

    public static void main(String[] args) {
        /*if(args[0] != null && args[0] != "") {
            File file = new File(args[0]);

        }*/

        Tokenizer p = new Tokenizer(new ProgramStream("1337.420"));
        System.out.println(p.parseNumber().toString());
    }
}
