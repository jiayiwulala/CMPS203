package CMPS203_hw2.arith;

import java.util.HashMap;

public class IntExpression extends ArithExpression {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int execute(HashMap<String, Integer> hashMap) {
        return this.getNumber();
    }
}
