package jas.test;

import jas.core.Assets;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssetsTest {

    @Test
    public void isSymbolTest1(){
        boolean expected = true;
        boolean actual = Assets.isSymbol('+');

        assertEquals(expected, actual);
    }
 @Test
    public void isSymbolTest2(){
        boolean expected = false;
        boolean actual = Assets.isSymbol('_');

        assertEquals(expected, actual);
    }

    @Test
    public void isValidVarNameTest1() {
        boolean expected = true;
        boolean actual = Assets.isValidVarName("_asd123");
        assertEquals(expected, actual);
    }
    @Test
    public void isValidVarNameTest2() {
        boolean expected = false;
        boolean actual = Assets.isValidVarName("1asd123");
        assertEquals(expected, actual);
    }
    @Test
    public void isValidVarNameTest3() {
        boolean expected = false;
        boolean actual = Assets.isValidVarName("");
        assertEquals(expected, actual);
    }
    @Test
    public void isValidVarNameTest4() {
        boolean expected = false;
        boolean actual = Assets.isValidVarName("123.0");
        assertEquals(expected, actual);
    }
    @Test
    public void isValidVarNameTest5() {
        boolean expected = false;
        boolean actual = Assets.isValidVarName("*23af");
        assertEquals(expected, actual);
    }
}