package CMPS203_hw2.command;

import java.util.HashMap;

public abstract class CommandExpression {
    public abstract HashMap<String, Integer> execute(HashMap<String, Integer> hashMap);
}

