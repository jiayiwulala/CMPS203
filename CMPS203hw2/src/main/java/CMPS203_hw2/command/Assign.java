package CMPS203_hw2.command;

import CMPS203_hw2.arith.ArithExpression;

import java.util.HashMap;

public class Assign extends CommandExpression {
    private String str;
    private ArithExpression e1;

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setE1(ArithExpression e1) {
        this.e1 = e1;
    }

    public ArithExpression getE1() {
        return e1;
    }

    @Override
    public HashMap<String, Integer> execute(HashMap<String, Integer> hashMap) {
        hashMap.put(this.getStr(), this.getE1().execute(hashMap));
        return hashMap;
    }
}

