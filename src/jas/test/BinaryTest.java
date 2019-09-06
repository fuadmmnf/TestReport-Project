package jas.test;

import jas.Function;
import jas.core.Node;
import jas.core.components.Literal;
import jas.core.components.RawValue;
import jas.core.components.Variable;
import jas.core.operations.Binary;
import jogamp.opengl.glu.nurbs.Bin;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTest {

    @Test
    public void getPriorityTest1() {
        int expected = 3;
        int actual = Binary.getPriority("^");
        assertEquals(expected, actual);
    }

    @Test
    public void getPriorityTest2() {
        int expected = -1;
        int actual = Binary.getPriority(",");
        assertEquals(expected, actual);
    }

    @Test
    public void getPriorityTest3() {
        int expected = 0;
        int actual = Binary.getPriority("14");
        assertEquals(expected, actual);
    }

    @Test
    public void getPriorityTest4() {
        RawValue rawValue = new RawValue(1.4);
        int expected = 0;
        int actual = Binary.getPriority("asdsad");
        assertEquals(expected, actual);
    }


    @Test
    public void operatorsTest1() {
        String expected = "*/";
        String actual = Binary.operators(2);
        assertEquals(expected, actual);
    }

    @Test
    public void operatorsTest2() {
        String expected = ",";
        String actual = Binary.operators(-1);
        assertEquals(expected, actual);
    }

    @Test
    public void operatorsTest3() {
        String expected = "";
        String actual = Binary.operators(1231);
        assertEquals(expected, actual);
    }


    @Test
    public void needsParenthesisTest1() {
        boolean expected = false;
        boolean actual = Binary.needsParenthesis(new RawValue(4124.012));
        assertEquals(expected, actual);
    }

    @Test
    public void needsParenthesisTest2() {
        boolean expected = false;
        boolean actual = Binary.needsParenthesis(new RawValue(0.0));
        assertEquals(expected, actual);
    }

    @Test
    public void needsParenthesisTest3() {
        boolean expected = true;
        boolean actual = Binary.needsParenthesis(new RawValue(-12310.67));
        assertEquals(expected, actual);
    }


    @Test
    public void evalTest1() {
        double expected = 1.0833333333333333;
        Node binary = new Binary(new RawValue(13), "/", new RawValue(12.0));
        double actual = binary.eval(123.0);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void evalTest2() {
        double expected = Double.POSITIVE_INFINITY;
        Binary binary = new Binary(new RawValue(13), "/", new RawValue(0));
        double actual = binary.eval(123.0);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void evalTest3() {
        double expected = Double.NEGATIVE_INFINITY;
        Binary binary = new Binary(new RawValue(-13), "/", new RawValue(0));
        double actual = binary.eval(123.0);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void evalTest4() {
        double expected = Double.NEGATIVE_INFINITY;
        Binary binary = new Binary(new RawValue(35), "^", new RawValue(0.5));
        double actual = binary.eval(123.0);
        assertEquals(expected, actual, 0);
    }


    @Test
    public void simplifyTest1() {
        String expected = "'(4+42)'+(-1)*'32/2'";
        String actual = new Binary(new Literal("(4+42)"), "-", new Literal("32/2")).simplify().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyTest2() {
        String expected = "'-34^1'*'-0/124'^(-1)";
        String actual = new Binary(new Literal("-34^1"), "/", new Literal("-0/124")).simplify().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyTest3() {
        String expected = "'ln(42)'*'-0/124'^(-1)";
        String actual = new Binary(new Literal("ln(42)"), "/", new Literal("-0/124")).simplify().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyZeroOneTest1() {
        String expected = "0";
        String actual = new Binary(new RawValue(0), "*", new Variable("x")).simplifyZeroOne().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyZeroOneTest2() {
        String expected = "0";
        String actual = new Binary(new Variable("x"), "*", new RawValue(0)).simplifyZeroOne().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyZeroOneTest3() {
        String expected = "x";
        String actual = new Binary(new RawValue(1), "*", new Variable("x")).simplifyZeroOne().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyZeroOneTest4() {
        String expected = "x";
        String actual = new Binary(new Variable("x"), "*", new RawValue(1)).simplifyZeroOne().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyZeroOneTest5() {
        String expected = "1";
        String actual = new Binary(new Variable("x"), "^", new RawValue(0)).simplifyZeroOne().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void simplifyZeroOneTest6() {
        String expected = "0";
        String actual = new Binary(new RawValue(0), "^", new Variable("sup")).simplifyZeroOne().toString();
        assertEquals(expected, actual);
    }


    

//    @Test
//    public void simplifyZeroOneTest2(){
//        String expected = "'-34^1'*'-0/124'^(-1)";
//        String actual = new Binary(new Literal("-34^1"), "/", new Literal("-0/124")).simplifyZeroOne().toString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void simplifyZeroOneTest3(){
//        String expected = "'ln(42)'*'-0/124'^(-1)";
//        String actual = new Binary(new Literal("ln(42)"), "/", new Literal("-0/124")).simplifyZeroOne().toString();
//        assertEquals(expected, actual);
//    }

}