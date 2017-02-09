package se.matstoms.axel.runner;

import se.matstoms.axel.operators.Operator;
import se.matstoms.axel.parsing.ASTGenerator;
import se.matstoms.axel.types.Value;
import se.matstoms.axel.operators.Division;
import se.matstoms.axel.operators.Minus;
import se.matstoms.axel.operators.Multiply;
import se.matstoms.axel.operators.Plus;
import se.matstoms.axel.util.Pair;
import se.matstoms.axel.parsing.Tokenizer;
import se.matstoms.axel.types.AString;
import se.matstoms.axel.types.Number;
import se.matstoms.axel.types.Types;

import java.util.ArrayList;

/**
 * Created by Axel on 2017-02-06.
 */
public class Runner {

    private ArrayList<Pair<Types, Class<? extends Value>>> types;
    private ArrayList<Pair<String, Operator.DualArg<? extends Value, ? extends Value, ? extends Value>>> dualArgOps;
    private ArrayList<Pair<String, Operator.SingleArg<? extends Value, ? extends Value>>> singleArgOps;
    private ArrayList<Pair<String, Keyword>> keywords;
    private Tokenizer tokenizer;
    private ASTGenerator parser;

    public Runner(String program) {
        this.types = new ArrayList<>();
        this.dualArgOps = new ArrayList<>();
        this.singleArgOps = new ArrayList<>();
        this.keywords = new ArrayList<>();
        this.tokenizer = new Tokenizer();
        this.parser = new ASTGenerator();

        this.registerType(Types.NUM, Number.class);
        this.registerType(Types.STR, AString.class);
        this.registerDualArgOperator("+", new Plus(), 10);
        this.registerDualArgOperator("-", new Minus(), 10);
        this.registerDualArgOperator("*", new Multiply(), 20);
        this.registerDualArgOperator("/", new Division(), 15);
    }

    public void run() {

    }

    private void registerSingleArgOperator(String token, Operator.SingleArg<? extends Value, ? extends Value> o) {
        this.singleArgOps.add(new Pair<>(token, o));

    }
    private void registerDualArgOperator(String token, Operator.DualArg<? extends Value, ? extends Value, ? extends Value> o, int precedence) {
        this.dualArgOps.add(new Pair<>(token, o));
        tokenizer.registerDualArgOperator(token);
    }
    private void registerType(Types t, Class<? extends Value> c) {
        this.types.add(new Pair<>(t, c));
    }


}
