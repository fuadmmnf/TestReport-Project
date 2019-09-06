package jas.test;

import jas.Function;
import jas.core.components.Literal;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTest {
    @Test
    public void functionTest1(){
        boolean expected = true;
        Function funcOne = new Function("var",new Literal("a*a^b"));
        boolean actual = funcOne.equals(new Function("var",new Literal("a^(1+b)")));
        assertEquals(expected, actual);
    }

    @Test
    public void functionTest2(){
        boolean expected = false;
        Function funcOne = new Function("x",new Literal("a*a^b"));
        boolean actual = funcOne.equals(new Function("y",new Literal("a+b")));
        assertEquals(expected, actual);
    }
}