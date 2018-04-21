package CMPS203_hw2.command;

import java.util.HashMap;

public class Next extends CommandExpression {
    private CommandExpression c1;
    private CommandExpression c2;

    public void setC1(CommandExpression c1) {
        this.c1 = c1;
    }

    public CommandExpression getC1() {
        return c1;
    }

    public void setC2(CommandExpression c2) {
        this.c2 = c2;
    }

    public CommandExpression getC2() {
        return c2;
    }

    @Override
    public HashMap<String, Integer> execute(HashMap<String, Integer> hashMap) {
        HashMap<String, Integer> hashMap1 = this.getC1().execute(hashMap);
        HashMap<String, Integer> hashMap2 = this.getC2().execute(hashMap1);
        return hashMap2;
    }
}
