package CMPS203_hw2.arith;

import java.util.HashMap;

public class VarExpression extends ArithExpression {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public int execute(HashMap<String, Integer> hashMap) {
        return hashMap.get(this.getStr());
    }
}
