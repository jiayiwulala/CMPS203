package CMPS203_hw2.bool;

import java.util.HashMap;

public class AndExpression extends BoolExpression {
    private BoolExpression b1;
    private BoolExpression b2;

    public void setB1(BoolExpression b1) {
        this.b1 = b1;
    }

    public BoolExpression getB1() {
        return b1;
    }

    public void setB2(BoolExpression b2) {
        this.b2 = b2;
    }

    public BoolExpression getB2() {
        return b2;
    }

    @Override
    public Boolean execute(HashMap<String, Integer> hashMap) {
        if (this.getB1().execute(hashMap) && this.getB2().execute(hashMap)) {
            return true;
        }
        else {
            return false;
        }
    }
}


