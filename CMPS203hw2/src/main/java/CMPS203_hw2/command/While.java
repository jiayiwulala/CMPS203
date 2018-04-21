package CMPS203_hw2.command;

import CMPS203_hw2.bool.BoolExpression;

import java.util.HashMap;

public class While extends CommandExpression {
    private BoolExpression b;
    private CommandExpression c;

    public BoolExpression getB() {
        return b;
    }

    public void setB(BoolExpression b) {
        this.b = b;
    }

    public CommandExpression getC() {
        return c;
    }

    public void setC(CommandExpression c) {
        this.c = c;
    }

    @Override
    public HashMap<String, Integer> execute(HashMap<String, Integer> hashMap) {
        if (this.getB().execute(hashMap)) {
            HashMap<String, Integer> hashMap1 = this.getC().execute(hashMap);
            return this.execute(hashMap1);
        }
        else {
            return hashMap;
        }
    }
}

