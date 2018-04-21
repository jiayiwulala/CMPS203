package CMPS203_hw2.command;

import CMPS203_hw2.bool.BoolExpression;

import java.util.HashMap;

public class If extends CommandExpression {
    private CommandExpression c1;
    private CommandExpression c2;
    private BoolExpression b;

    public void setC1(CommandExpression c1) {
        this.c1 = c1;
    }

    public void setC2(CommandExpression c2) {
        this.c2 = c2;
    }

    public CommandExpression getC1() {
        return c1;
    }

    public CommandExpression getC2() {
        return c2;
    }

    public BoolExpression getB() {
        return b;
    }

    public void setB(BoolExpression b) {
        this.b = b;
    }

    @Override
    public HashMap<String, Integer> execute(HashMap<String, Integer> hashMap) {
        if (this.getB().execute(hashMap)) {
            return this.getC1().execute(hashMap);
        }
        else {
            return this.getC2().execute(hashMap);
        }
    }

}
