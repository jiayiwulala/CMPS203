package CMPS203_hw2.command;

import java.util.HashMap;

public class Skip extends CommandExpression {
    @Override
    public HashMap<String, Integer> execute(HashMap<String, Integer> hashMap) {
        return hashMap;
    }
}
