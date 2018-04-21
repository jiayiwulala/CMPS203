package CMPS203_hw2.arith;

import java.util.HashMap;

public class DivExpression extends ArithExpression {
    private ArithExpression e1;
    private ArithExpression e2;

    public ArithExpression getE1() {
        return e1;
    }

    public void setE1(ArithExpression e1) {
        this.e1 = e1;
    }

    public ArithExpression getE2() {
        return e2;
    }

    public void setE2(ArithExpression e2) {
        this.e2 = e2;
    }

    @Override
    public int execute(HashMap<String, Integer> hashMap) {
        try{
            return this.getE1().execute(hashMap) / this.getE2().execute(hashMap);
        } catch (Exception e) {
            System.out.print("division by zero exception");
            return -1;
        }
    }

}
