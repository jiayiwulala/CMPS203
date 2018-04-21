import static org.junit.Assert.assertTrue;

import CMPS203_hw2.arith.*;
import CMPS203_hw2.bool.*;
import CMPS203_hw2.command.*;
import org.junit.Test;
import java.util.HashMap;


public class MyTest {


    @Test
    public void simpleaddTest() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        IntExpression intExpression1 = new IntExpression();
        IntExpression intExpression2 = new IntExpression();
        intExpression1.setNumber(3);
        intExpression2.setNumber(-5);
        SumExpression sumExpression = new SumExpression();
        sumExpression.setE1(intExpression1);
        sumExpression.setE2(intExpression2);

        System.out.println(sumExpression.execute(hashMap));
    }

    @Test
    public void simpleminusTest() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        MinusExpression minusExpression = new MinusExpression();
        IntExpression intExpression1 = new IntExpression();
        IntExpression intExpression2 = new IntExpression();
        intExpression1.setNumber(3);
        intExpression2.setNumber(-5);
        minusExpression.setE1(intExpression1);
        minusExpression.setE2(intExpression2);

        System.out.println(minusExpression.execute(hashMap));
    }

    @Test
    public void complextest1(){    // (4/4)*5 = 5
        HashMap<String, Integer> hashMap1 = new HashMap<String, Integer>();

        IntExpression intExpression1 = new IntExpression();
        intExpression1.setNumber(5);

        IntExpression intExpression2 = new IntExpression();
        intExpression2.setNumber(4);

        DivExpression divExpression = new DivExpression();
        divExpression.setE1(intExpression2);
        divExpression.setE2(intExpression2);

        MulExpression mulExpression = new MulExpression();
        mulExpression.setE1(intExpression1);
        mulExpression.setE2(divExpression);

        IntExpression intExpression3 = new IntExpression();
        intExpression3.setNumber(6);

        IntExpression intExpression4 = new IntExpression();
        intExpression4.setNumber(9);

        LessExpression lessExpression = new LessExpression(); //  5 < 6
        lessExpression.setE1(mulExpression);
        lessExpression.setE2(intExpression3);

        GreatExpression greatExpression = new GreatExpression(); // 5 > 9
        greatExpression.setE1(mulExpression);
        greatExpression.setE2(intExpression4);


        AndExpression andExpression = new AndExpression(); // (5 < 6) && (5 > 9)
        andExpression.setB1(lessExpression);
        andExpression.setB2(greatExpression);

        NegExpression negExpression1 = new NegExpression(); //not ((5 < 6) && (5 > 9))
        negExpression1.setB(andExpression);

        OrExpression orExpression = new OrExpression(); //(5 < 6) || (5 > 9)
        orExpression.setB1(lessExpression);
        orExpression.setB2(greatExpression);

        NegExpression negExpression2 = new NegExpression(); //not ((5 < 6) || (5 > 9))
        negExpression2.setB(orExpression);

        Assign assignExpression1 = new Assign();
        String str = "x";
        assignExpression1.setStr(str);
        assignExpression1.setE1(intExpression1); // x = 5

        Assign assignExpression2 = new Assign();
        assignExpression2.setStr(str);
        assignExpression2.setE1(intExpression2); // x = 4

        If ifExpression1 = new If();
        ifExpression1.setC1(assignExpression1);
        ifExpression1.setC2(assignExpression2);
        ifExpression1.setB(negExpression1); // true c1

        System.out.println(ifExpression1.execute(hashMap1)); // {x:5}

        HashMap<String, Integer> hashMap2 = new HashMap<String, Integer>();

        If ifExpression2 = new If();
        ifExpression2.setC1(assignExpression1);
        ifExpression2.setC2(assignExpression2);
        ifExpression2.setB(negExpression2); // false c2

        System.out.println(ifExpression2.execute(hashMap2)); // {x :4}
    }

    @Test
    public void complextest2(){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        IntExpression intExpression = new IntExpression();
        intExpression.setNumber(0);

        Assign assignExpression = new Assign();
        String str = "i";
        assignExpression.setStr(str);
        assignExpression.setE1(intExpression); //i = 0

        System.out.println(assignExpression.execute(hashMap));

        VarExpression varExpression = new VarExpression();
        varExpression.setStr(str); // 0
        System.out.println("var:" + varExpression.execute(hashMap));
    }

    @Test
    public void complextest3() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        Skip skipExpression = new Skip();

        IntExpression intExpression1 = new IntExpression();
        intExpression1.setNumber(0);

        Assign assignExpression = new Assign();
        String str = "i";
        assignExpression.setStr(str);
        assignExpression.setE1(intExpression1);
        assignExpression.execute(hashMap);

        VarExpression varExpression = new VarExpression();
        varExpression.setStr(str);

        IntExpression intExpression2 = new IntExpression();
        intExpression2.setNumber(5);

        LessExpression lessExpression = new LessExpression(); // i = 0; i < 5
        lessExpression.setE1(varExpression);
        lessExpression.setE2(intExpression2);

        IntExpression intExpression3 = new IntExpression();
        intExpression3.setNumber(2);

        SumExpression sumExpression = new SumExpression();
        sumExpression.setE1(varExpression);
        sumExpression.setE2(intExpression3);

        Assign assignExpression1 = new Assign();
        assignExpression1.setStr(str);
        assignExpression1.setE1(sumExpression);   // i = i + 1

        Next nextExpression = new Next();
        nextExpression.setC1(assignExpression1);
        nextExpression.setC2(skipExpression);

        While whileExpression = new While(); // i = 0; while (i < 5): i = i + 1
        whileExpression.setB(lessExpression);
        whileExpression.setC(nextExpression);

        System.out.println(whileExpression.execute(hashMap)); //{i = 6}
    }


}
