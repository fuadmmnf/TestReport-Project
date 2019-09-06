package jas.test;

import jas.MathContext;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MathContextTest {

    @Test
    public void factorialTest1(){
        BigInteger expected = BigInteger.valueOf(0);
        BigInteger actual = MathContext.factorial(BigInteger.valueOf(0));
        assertEquals(expected, actual);
    }
    @Test
    public void factorialTest2(){
        BigInteger expected = BigInteger.valueOf(-1);
        BigInteger actual = MathContext.factorial(BigInteger.valueOf(-10));
        assertEquals(expected, actual);
    }
    @Test
    public void factorialTest3(){
        BigInteger expected = BigInteger.valueOf(-1);
        BigInteger actual = MathContext.factorial(BigInteger.valueOf(20));
        assertEquals(expected, actual);
    }

    @Test
    public void factorialTest4(){
        BigInteger expected = BigInteger.valueOf(362880);
        BigInteger actual = MathContext.factorial(BigInteger.valueOf(9));
        assertEquals(expected, actual);
    }
    @Test
    public void lcmTest1(){
        BigInteger expected = BigInteger.valueOf(70);
        BigInteger actual = MathContext.lcm(BigInteger.valueOf(10), BigInteger.valueOf(14));
        assertEquals(expected, actual);
    }
    @Test
    public void lcmTest2(){
        BigInteger expected = BigInteger.valueOf(-1);
        BigInteger actual = MathContext.lcm(BigInteger.valueOf(-10), BigInteger.valueOf(10));
        assertEquals(expected, actual);
    }
    @Test
    public void lcmTest3(){
        BigInteger expected = BigInteger.valueOf(325012744);
        BigInteger actual = MathContext.lcm(BigInteger.valueOf(200131), BigInteger.valueOf(1624));
        assertEquals(expected, actual);
    }

    @Test
    public void lcmTest4(){
        BigInteger expected = BigInteger.valueOf(9);
        BigInteger actual = MathContext.lcm(BigInteger.valueOf(9), BigInteger.valueOf(9));
        assertEquals(expected, actual);
    }
    
    
    @Test
    public void factorTest1(){
        List<BigInteger> expected = new ArrayList<>(Arrays.asList(BigInteger.valueOf(2), BigInteger.valueOf(2)));
        List<BigInteger> actual = MathContext.factor(BigInteger.valueOf(4));
        assertEquals(expected, actual);
    }
    @Test
    public void factorTest2(){
        List<BigInteger> expected = new ArrayList<>(Arrays.asList(BigInteger.valueOf(-1)));
        List<BigInteger> actual = MathContext.factor(BigInteger.valueOf(0));
        assertEquals(expected, actual);
    }
    @Test
    public void factorTest3(){
        List<BigInteger> expected = new ArrayList<>(Arrays.asList(BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(5), BigInteger.valueOf(5), BigInteger.valueOf(5)));
        List<BigInteger> actual = MathContext.factor(BigInteger.valueOf(1000));
        assertEquals(expected, actual);
    }

    @Test
    public void factorTest4(){
        List<BigInteger> expected = new ArrayList<>(Arrays.asList(BigInteger.valueOf(2), BigInteger.valueOf(13)));
        List<BigInteger> actual = MathContext.factor(BigInteger.valueOf(26));
        assertEquals(expected, actual);
    }
    @Test
    public void factorTest5(){
        List<BigInteger> expected = new ArrayList<>(Arrays.asList(BigInteger.valueOf(3), BigInteger.valueOf(3), BigInteger.valueOf(3), BigInteger.valueOf(3), BigInteger.valueOf(37), BigInteger.valueOf(333667)));
        List<BigInteger> actual = MathContext.factor(BigInteger.valueOf(999999999));
        assertEquals(expected, actual);
    }
    @Test
    public void factorTest6(){
        List<BigInteger> expected = new ArrayList<>(Arrays.asList(BigInteger.valueOf(2), BigInteger.valueOf(691), BigInteger.valueOf(723589)));
        List<BigInteger> actual = MathContext.factor(BigInteger.valueOf(999999998));
        assertEquals(expected, actual);
    }





    @Test
    public void numOccurrencesTest1(){

        int[] expected = {6,1,1};
        int[] actual = MathContext.numOccurrences(new ArrayList<BigInteger>(Arrays.asList(BigInteger.valueOf(3), BigInteger.valueOf(5),
                BigInteger.valueOf(7))),
                new ArrayList<BigInteger>(Arrays.asList(BigInteger.valueOf(4),
                        BigInteger.valueOf(3),BigInteger.valueOf(3),BigInteger.valueOf(7),
                        BigInteger.valueOf(5),BigInteger.valueOf(3),BigInteger.valueOf(3),BigInteger.valueOf(3))));
        assertArrayEquals(expected, actual);
    }
    @Test
    public void numOccurrencesTest2(){

        int[] expected = {0,0,0};
        int[] actual = MathContext.numOccurrences(new ArrayList<BigInteger>(Arrays.asList(BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(7))), new ArrayList<BigInteger>(Arrays.asList()));
        assertArrayEquals(expected, actual);
    }


}