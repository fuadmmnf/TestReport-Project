package jas.test;

import jas.core.Node;
import jas.core.components.Fraction;
import jas.core.components.RawValue;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void reduceTest1() {
        BigInteger[] expected = {BigInteger.valueOf(1), BigInteger.valueOf(2)};
        Fraction tempFraction = new Fraction(2, 4);
        tempFraction.reduce();
        BigInteger[] actual = {tempFraction.getNumerator(), tempFraction.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void reduceTest2() {
        BigInteger[] expected = {BigInteger.valueOf(3), BigInteger.valueOf(7)};
        Fraction tempFraction = new Fraction(3, 7);
        tempFraction.reduce();
        BigInteger[] actual = {tempFraction.getNumerator(), tempFraction.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void reduceTest3() {
        BigInteger[] expected = {BigInteger.valueOf(-1), BigInteger.valueOf(10)};
        Fraction tempFraction = new Fraction(-10, 100);
        tempFraction.reduce();
        BigInteger[] actual = {tempFraction.getNumerator(), tempFraction.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void reduceTest4() {
        BigInteger[] expected = {BigInteger.valueOf(3), BigInteger.valueOf(8)};
        Fraction tempFraction = new Fraction(-3, -8);
        tempFraction.reduce();
        BigInteger[] actual = {tempFraction.getNumerator(), tempFraction.getDenominator()};
        assertEquals(expected, actual);
    }


    @Test
    public void gcdTest1() {
        Fraction tempFraction = new Fraction(2, 8); //calling reduce in constructor
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = tempFraction.gcd();
        assertEquals(expected, actual);
    }

    @Test
    public void gcdTest2() {
        Fraction tempFraction = new Fraction(3, 8); //calling reduce in constructor
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = tempFraction.gcd();
        assertEquals(expected, actual);
    }

    @Test
    public void gcdTest3() {
        Fraction tempFraction = new Fraction(-3, 8); //calling reduce in constructor
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = tempFraction.gcd();
        assertEquals(expected, actual);
    }

    @Test
    public void gcdTest4() {
        Fraction tempFraction = new Fraction(-3, -9); //calling reduce in constructor
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = tempFraction.gcd();
        assertEquals(expected, actual);
    }

    @Test
    public void gcdTest5() {
        Fraction tempFraction = new Fraction(-3, -10); //calling reduce in constructor
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = tempFraction.gcd();
        assertEquals(expected, actual);
    }

    @Test
    public void gcdTest6() {
        Fraction tempFraction = new Fraction(-1012312322, 8); //calling reduce in constructor
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = tempFraction.gcd();
        assertEquals(expected, actual);
    }


    @Test
    public void convertToFractionTest1() {
        BigInteger[] expected = {BigInteger.valueOf(21), BigInteger.valueOf(1)};
        Fraction temp = Fraction.convertToFraction(21.0);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionTest2() {
        BigInteger[] expected = {BigInteger.valueOf(23), BigInteger.valueOf(100)};
        Fraction temp = Fraction.convertToFraction(.23);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionTest3() {
        BigInteger[] expected = {BigInteger.valueOf(4412323), BigInteger.valueOf(100000)};
        Fraction temp = Fraction.convertToFraction(44.12323);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionTest4() {
        BigInteger[] expected = {BigInteger.valueOf(-4412323), BigInteger.valueOf(100000)};
        Fraction temp = Fraction.convertToFraction(-44.12323);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionTest5() {
        BigInteger[] expected = {BigInteger.valueOf(-12323), BigInteger.valueOf(100000)};
        Fraction temp = Fraction.convertToFraction(-0.12323);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionTest6() {
        BigInteger[] expected = {BigInteger.valueOf(0), BigInteger.valueOf(1)};
        Fraction temp = Fraction.convertToFraction(0.0);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void extractRootTest1() {
        double expected = 2.0;
        double actual = Fraction.extractRoot(BigInteger.valueOf(4), BigInteger.valueOf(2)).val();
        assertEquals(expected, actual, 0);

    }

    @Test
    public void extractRootTest2() {
        double expected = Double.NaN;
        double actual = Fraction.extractRoot(BigInteger.valueOf(-4), BigInteger.valueOf(2)).val();
        assertEquals(expected, actual, 0);

    }
    @Test
    public void extractRootTest3() {
        double expected = 0.5;
        double actual = Fraction.extractRoot(BigInteger.valueOf(4), BigInteger.valueOf(-2)).val();
        assertEquals(expected, actual, 10);

    }
    @Test
    public void extractRootTest4() {
        double expected = 0.5;
        double actual = Fraction.extractRoot(BigInteger.valueOf(4), BigInteger.valueOf(-2)).val();
        assertEquals(expected, actual, 0);

    }

    @Test
    public void extractRootTest5() {
        double expected = 1.4142135623730951;
        double actual = Fraction.extractRoot(BigInteger.valueOf(4), BigInteger.valueOf(4)).val();
        System.out.println(actual);
        assertEquals(expected, actual, 0);

    }

    @Test
    public void extractRootTest6() {
        double expected = 1.0003466336538454;
        double actual = Fraction.extractRoot(BigInteger.valueOf(4), BigInteger.valueOf(4000)).val();
        System.out.println(actual);
        assertEquals(expected, actual, 0);

    }
    @Test
    public void extractRootTest7() {
        double expected = 0.0;
        double actual = Fraction.extractRoot(BigInteger.valueOf(0), BigInteger.valueOf(4000)).val();
        System.out.println(actual);
        assertEquals(expected, actual, 0);

    }



    @Test
    public void convertToFractionWithToleranceTest1() {
        BigInteger[] expected = {BigInteger.valueOf(21), BigInteger.valueOf(1)};
        Fraction temp = Fraction.convertToFraction(21.0, 0.001);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionWithToleranceTest2() {
        BigInteger[] expected = {BigInteger.valueOf(1), BigInteger.valueOf(4)};
        Fraction temp = Fraction.convertToFraction(.23, .10);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionWithToleranceTest3() {
        BigInteger[] expected = {BigInteger.valueOf(44), BigInteger.valueOf(1)};
        Fraction temp = Fraction.convertToFraction(44.12323, 1000);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionWithToleranceTest4() {
        BigInteger[] expected = {BigInteger.valueOf(-4412323), BigInteger.valueOf(100000)};
        Fraction temp = Fraction.convertToFraction(-44.12323, .0000000000001);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionWithToleranceTest5() {
        BigInteger[] expected = {BigInteger.valueOf(-12323), BigInteger.valueOf(100000)};
        Fraction temp = Fraction.convertToFraction(-0.12323, 0.023000);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void convertToFractionWithToleranceTest6() {
        BigInteger[] expected = {BigInteger.valueOf(0), BigInteger.valueOf(1)};
        Fraction temp = Fraction.convertToFraction(0.0, 0.0000000);
        BigInteger[] actual = {temp.getNumerator(), temp.getDenominator()};
        assertEquals(expected, actual);
    }









    @Test
    public void addTest1() {

        Fraction firstFrac = new Fraction(3, 6);
        Fraction secondFrac = new Fraction(7, 13);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(27), BigInteger.valueOf(26)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void addTest2() {

        Fraction firstFrac = new Fraction(0, 6);
        Fraction secondFrac = new Fraction(7, 13);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(7), BigInteger.valueOf(13)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void addTest3() {

        Fraction firstFrac = new Fraction(3, 4);
        Fraction secondFrac = new Fraction(0, 13);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(3), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void addTest4() {

        Fraction firstFrac = new Fraction(-3, 4);
        Fraction secondFrac = new Fraction(3, 4);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(0), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void addTest5() {

        Fraction firstFrac = new Fraction(3, 4);
        Fraction secondFrac = new Fraction(-3, 4);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(0), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void addTest6() {

        Fraction firstFrac = new Fraction(-3, 4);
        Fraction secondFrac = new Fraction(-3, 4);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(-6), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void addTest7() {

        Fraction firstFrac = new Fraction(-10, 4);
        Fraction secondFrac = new Fraction(-4, 4);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(-7), BigInteger.valueOf(2)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void addTest8() {

        Fraction firstFrac = new Fraction(-10, 4);
        Fraction secondFrac = new Fraction(123123, 13);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(18937), BigInteger.valueOf(2)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void addTest9() {

        Fraction firstFrac = new Fraction(-7, 13);
        Fraction secondFrac = new Fraction(71, 51);
        firstFrac = firstFrac.add(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(566), BigInteger.valueOf(663)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void expTest1() {
        Fraction firstFrac = new Fraction(2, 13);
        firstFrac = firstFrac.exp(2);
        BigInteger[] expected = {BigInteger.valueOf(4), BigInteger.valueOf(169)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest2() {
        Fraction firstFrac = new Fraction(7, 2);
        firstFrac = firstFrac.exp(2);
        BigInteger[] expected = {BigInteger.valueOf(49), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest3() {
        Fraction firstFrac = new Fraction(-3, 2);
        firstFrac = firstFrac.exp(2);
        BigInteger[] expected = {BigInteger.valueOf(9), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest5() {
        Fraction firstFrac = new Fraction(4, -5);
        firstFrac = firstFrac.exp(2);
        BigInteger[] expected = {BigInteger.valueOf(16), BigInteger.valueOf(25)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest6() {
        Fraction firstFrac = new Fraction(-10, -11);
        firstFrac = firstFrac.exp(0);
        BigInteger[] expected = {BigInteger.valueOf(1), BigInteger.valueOf(1)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void expTest7() {
        Fraction firstFrac = new Fraction(2, 13);
        firstFrac = firstFrac.exp(-5);
        BigInteger[] expected = {BigInteger.valueOf(371293), BigInteger.valueOf(32)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest8() {
        Fraction firstFrac = new Fraction(7, 2);
        firstFrac = firstFrac.exp(-4);
        BigInteger[] expected = {BigInteger.valueOf(16), BigInteger.valueOf(2401)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest9() {
        Fraction firstFrac = new Fraction(-3, 2);
        firstFrac = firstFrac.exp(-2);
        BigInteger[] expected = {BigInteger.valueOf(4), BigInteger.valueOf(9)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest10() {
        Fraction firstFrac = new Fraction(4, -5);
        firstFrac = firstFrac.exp(-1);
        BigInteger[] expected = {BigInteger.valueOf(-5), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void expTest11() {
        Fraction firstFrac = new Fraction(-10, -11);
        firstFrac = firstFrac.exp(2);
        BigInteger[] expected = {BigInteger.valueOf(100), BigInteger.valueOf(121)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }



    @Test
    public void subTest1() {

        Fraction firstFrac = new Fraction(3, 6);
        Fraction secondFrac = new Fraction(7, 13);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(-1), BigInteger.valueOf(26)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void subTest2() {

        Fraction firstFrac = new Fraction(0, 6);
        Fraction secondFrac = new Fraction(7, 13);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(-7), BigInteger.valueOf(13)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void subTest3() {

        Fraction firstFrac = new Fraction(3, 4);
        Fraction secondFrac = new Fraction(0, 13);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(3), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void subTest4() {

        Fraction firstFrac = new Fraction(-3, 4);
        Fraction secondFrac = new Fraction(3, 4);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(-6), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void subTest5() {

        Fraction firstFrac = new Fraction(3, 4);
        Fraction secondFrac = new Fraction(-3, 4);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(6), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void subTest6() {

        Fraction firstFrac = new Fraction(-3, 4);
        Fraction secondFrac = new Fraction(-3, 4);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(0), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void subTest7() {

        Fraction firstFrac = new Fraction(-10, 4);
        Fraction secondFrac = new Fraction(-4, 4);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(-3), BigInteger.valueOf(2)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void subTest8() {

        Fraction firstFrac = new Fraction(-10, 4);
        Fraction secondFrac = new Fraction(123123, 13);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(18947), BigInteger.valueOf(2)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void subTest9() {

        Fraction firstFrac = new Fraction(-7, 13);
        Fraction secondFrac = new Fraction(71, 51);
        firstFrac = firstFrac.sub(secondFrac);


        BigInteger[] expected = {BigInteger.valueOf(-1280), BigInteger.valueOf(663)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }


    @Test
    public void inverseTest1(){
        Fraction firstFrac = new Fraction(4, 15);
        firstFrac = firstFrac.inverse();
        BigInteger[] expected = {BigInteger.valueOf(15), BigInteger.valueOf(4)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void inverseTest2(){
        Fraction firstFrac = new Fraction(-1, 15);
        firstFrac = firstFrac.inverse();
        BigInteger[] expected = {BigInteger.valueOf(15), BigInteger.valueOf(-1)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }


    @Test
    public void inverseTest3(){
        Fraction firstFrac = new Fraction(71, -15);
        firstFrac = firstFrac.inverse();
        BigInteger[] expected = {BigInteger.valueOf(-15), BigInteger.valueOf(71)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void inverseTest4(){
        Fraction firstFrac = new Fraction(-71, -15);
        firstFrac = firstFrac.inverse();
        BigInteger[] expected = {BigInteger.valueOf(15), BigInteger.valueOf(71)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void inverseTest5(){
        Fraction firstFrac = new Fraction(0, 5);
        firstFrac = firstFrac.inverse();
        BigInteger[] expected = {BigInteger.valueOf(1), BigInteger.valueOf(0)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void inverseTest6(){
        Fraction firstFrac = new Fraction(-152, 0);
        firstFrac = firstFrac.inverse();
        BigInteger[] expected = {BigInteger.valueOf(0), BigInteger.valueOf(0)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void negateTest1(){
        Fraction firstFrac = new Fraction(4, 15);
        firstFrac = firstFrac.negate();
        BigInteger[] expected = {BigInteger.valueOf(-4), BigInteger.valueOf(15)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }

    @Test
    public void negateTest2(){
        Fraction firstFrac = new Fraction(-1, 15);
        firstFrac = firstFrac.negate();
        BigInteger[] expected = {BigInteger.valueOf(1), BigInteger.valueOf(15)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }


    @Test
    public void negateTest3(){
        Fraction firstFrac = new Fraction(71, -15);
        firstFrac = firstFrac.negate();
        BigInteger[] expected = {BigInteger.valueOf(71), BigInteger.valueOf(15)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void negateTest4(){
        Fraction firstFrac = new Fraction(-71, -15);
        firstFrac = firstFrac.negate();
        BigInteger[] expected = {BigInteger.valueOf(-71), BigInteger.valueOf(15)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void negateTest5(){
        Fraction firstFrac = new Fraction(0, 5);
        firstFrac = firstFrac.negate();
        BigInteger[] expected = {BigInteger.valueOf(0), BigInteger.valueOf(1)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }
    @Test
    public void negateTest6(){
        Fraction firstFrac = new Fraction(-152, 0);
        firstFrac = firstFrac.negate();
        BigInteger[] expected = {BigInteger.valueOf(152), BigInteger.valueOf(0)};
        BigInteger[] actual = {firstFrac.getNumerator(), firstFrac.getDenominator()};
        assertEquals(expected, actual);
    }



}