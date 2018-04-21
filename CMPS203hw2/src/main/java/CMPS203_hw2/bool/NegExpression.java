package CMPS203_hw2.bool;

import java.util.HashMap;

public class NegExpression extends BoolExpression {
    private BoolExpression b;

    public void setB(BoolExpression b) {
        this.b = b;
    }

    public BoolExpression getB() {
        return b;
    }

    @Override
    public Boolean execute(HashMap<String, Integer> hashMap) {
        if (this.getB().execute(hashMap)) {
            return false;
        }
        else {
            return true;
        }
    }
}
