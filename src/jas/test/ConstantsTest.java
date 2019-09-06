package jas.test;

import jas.core.components.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantsTest {

    @Test
    public void valueOfTest1(){

        Constants.define("newConst", ()-> 920.000920);

        double expected = 920.000920;
        double actual = Constants.valueOf("newConst");
        assertEquals(expected, actual, 0);
    }

    @Test
    public void valueOfTest2(){

        Constants.define("newConst", ()-> -123129831298312312312312312313123123123123123123123123.0);

        double expected = -1.231298312983123E53;
        double actual = Constants.valueOf("newConst");
        assertEquals(expected, actual, 0);
    }


    @Test
    public void getConstantTest1(){

        Constants.define("getConst", ()-> -0.00001);

        Constants.Constant expected = new Constants.Constant("getConst", ()-> -0.00001);
        Constants.Constant actual = Constants.get("getConst");
        assertEquals(expected.val(), actual.val(), 0);
    }

}