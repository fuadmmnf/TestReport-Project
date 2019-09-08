package jas.test;

import jas.core.Compiler;
import jas.core.Node;
import jas.core.components.Variable;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompilerTest {

    @Test
    public void innermostIndicesTest1() {
        int[] expectedIndices = {9, 19};
        int[] obtainedIndices = Compiler.innermostIndices("asbdasd[[[asdasdasd]asdasd]]]asadas", '[', ']');

        assertArrayEquals(expectedIndices, obtainedIndices);
    }

    @Test
    public void innermostIndicesTest2() {
        int[] expectedIndices = {-1, -1};
        int[] obtainedIndices = Compiler.innermostIndices("", '[', ']');

        assertArrayEquals(expectedIndices, obtainedIndices);
    }

    @Test
    public void innermostIndicesTest3() {
        int[] expectedIndices = {-1, -1};
        int[] obtainedIndices = Compiler.innermostIndices("asbdasd[[[asdasdasd]asdasd]]]asadas", '_', '_');

        assertArrayEquals(expectedIndices, obtainedIndices);
    }


    @Test
    public void replaceTest1() {
        String expectedText = "aisud baslist(id,bas)ui dbasu asdas";
        String obtainedText = Compiler.replace("aisud bas{id,bas}ui dbasu asdas", '{', '}', "list(", ")");

        assertEquals(expectedText, obtainedText);
    }


    @Test
    public void replaceTest2() {
        String expectedText = "asjkdbaskbdas  aajbsasda sd asjd asd as";

        String obtainedText = Compiler.replace("asjkdbaskbdas  aajbsasda sd asjd asd as", '{', '}', "list(", ")");

        assertEquals(expectedText, obtainedText);
    }


    @Test
    public void formatList1() {
        String expectedText = "asjkdblist(alist()skb)list(list(das  aa)jbsasda sd asjd asd)list( as)";

        String obtainedText = Compiler.formatList("asjkdb{a{}skb}{{das  aa}jbsasda sd asjd asd}{ as}");

        assertEquals(expectedText, obtainedText);
    }

    @Test
    public void formatList2() {
        String expectedText = "asjkdb(alist()skb)list(list(das  aa)jbsasda sd asjd asd)list( as)";

        String obtainedText = Compiler.formatList("asjkdb(a{}skb){{das  aa}jbsasda sd asjd asd}{ as}");

        assertEquals(expectedText, obtainedText);
    }


    @Test
    public void isUnformattedTest1() {
        boolean expectedValue = false;
        boolean obtainedValue = Compiler.isUnformatted("asdaiudahsuid ashudi ahud ashud as");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void isUnformattedTest2() {
        boolean expectedValue = true;
        boolean obtainedValue = Compiler.isUnformatted("list(asdasdsad)asdatan(sec(cot())acot())asin(d)adsin()asdacos(ascos())tan()");

        assertEquals(expectedValue, obtainedValue);
    }


    @Test
    public void formatOperationsTest1() {
        String expectedValue = "list<(asdasdsad)>asdatan<(sec<(cot<()>)>acot<()>)>asin<(d)>" +
                "adsin<()>asdacos<(ascos<()>)>tan<()>ln<(factorial<()>e())>";
        String obtainedValue = Compiler.formatOperations("list(asdasdsad)asdatan(sec(cot())acot())" +
                "asin(d)adsin()asdacos(ascos())tan()ln(factorial()e())");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatOperationsTest2() {
        String expectedValue = "listasdas(dsad)asdata(nse)c(c)ot(a)cotasindadsin<(a)>" +
                "sdacos<(as)>costan<(l)>n(fa)ctorial(e())";
        String obtainedValue = Compiler.formatOperations("listasdas(dsad)asdata(nse)c(c)ot(a)" +
                "cotasindadsin(a)sdacos(as)costan(l)n(fa)ctorial(e())");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatOperationsTest3() {
        String expectedValue = "listasdas(dsadasdata(nsec(cot(acotasindadsin(asdacos(ascostan(ln(factorial(e(";
        String obtainedValue = Compiler.formatOperations("listasdas(dsa" +
                "dasdata(nsec(cot(acotasindadsin(asdacos(ascostan(ln(factorial(e(");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatOperationsTest4() {
        String expectedValue = "";
        String obtainedValue = Compiler.formatOperations("");

        assertEquals(expectedValue, obtainedValue);
    }


    @Test
    public void operationIndicesTest1() {
        int[] expectedValue = {5, 8};// - after */^< replaced to */^< (0 -xxx)
        int[] obtainedValue = Compiler.operationIndices("-24x/-12y*-0z", 5);

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    public void operationIndicesTest2() {
        int[] expectedValue = {1, 4};// - after */^< replaced to */^< (0 -xxx)
        int[] obtainedValue = Compiler.operationIndices("-24x/-12y*-0z", 4);

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    public void operationIndicesTest3() {
        int[] expectedValue = {-1, -3};// - after */^< replaced to */^< (0 -xxx)
        int[] obtainedValue = Compiler.operationIndices("-24x/-12y*-0z", 3);

        assertArrayEquals(expectedValue, obtainedValue);
    }


    @Test
    public void formatCoefficientsTest1() {
        String expectedValue = "2*x+3*y*24*z";
        String obtainedValue = Compiler.formatCoefficients("2x+3y*24z");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatCoefficientsTest2() {
        String expectedValue = "0*x+y*z";
        String obtainedValue = Compiler.formatCoefficients("0x+y*z");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatCoefficientsTest3() {
        String expectedValue = "043";
        String obtainedValue = Compiler.formatCoefficients("043");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatCoefficientsTest4() {
        String expectedValue = "0-24*x/(0-12)*y*(0-0)*z";
        String obtainedValue = Compiler.formatCoefficients("-24x/-12y*-0z");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatCoefficientsTest5() {
        String expectedValue = "0-0*X";
        String obtainedValue = Compiler.formatCoefficients("-0X");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatCoefficientsTest6() {
        String expectedValue = "0-24*X/(0-12)*Y*(0-0)*Z";
        String obtainedValue = Compiler.formatCoefficients("-24X/-12Y*-0Z");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatCoefficientsTest7() {
        String expectedValue = "0-24*XA/(0-12)*YB*(0-0)*cZ";
        String obtainedValue = Compiler.formatCoefficients("-24XA/-12YB*-0cZ");

        assertEquals(expectedValue, obtainedValue);
    }


    @Test
    public void formatParenthesisTest1() {
        String expectedValue = "cos<(asd)>*(4+2)*(asdas)";
        String obtainedValue = Compiler.formatParenthesis("cos<(asd)>(4+2)(asdas)");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatParenthesisTest2() {
        String expectedValue = "";
        String obtainedValue = Compiler.formatParenthesis("");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatParenthesisTest3() {
        String expectedValue = "(<>)<()>*()*()<(())>";
        String obtainedValue = Compiler.formatParenthesis("(<>)<()>()()<(())>");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatParenthesisTest4() {
        String expectedValue = "(1231ahdbas)<(asdasd)>*asda*(asdas )*(asd)<((sad)*asd)>";
        String obtainedValue = Compiler.formatParenthesis("(1231ahdbas)<(asdasd)>asda(asdas )(asd)<((sad)asd)>");

        assertEquals(expectedValue, obtainedValue);
    }


    @Test
    public void formatLiteralTest1() {
        String expectedValue = "aaasda s( Asd)Sadas}{}das[]asd('123dwq>";
        String obtainedValue = Compiler.formatLiteral("aaasda s( Asd)Sadas}{}das[]asd'123dwq");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatLiteralTest2() {
        String expectedValue = "(')'";
        String obtainedValue = Compiler.formatLiteral("''");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatLiteralTest3() {
        String expectedValue = "('asdas')('asdsa')1+2('(123)')+('ad')";
        String obtainedValue = Compiler.formatLiteral("'asdas''asdsa'1+2'(123)'+'ad'");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatLiteralTest4() {
        String expectedValue = "('";
        String obtainedValue = Compiler.formatLiteral("'");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void formatLiteralTest5() {
        String expectedValue = "";
        String obtainedValue = Compiler.formatLiteral("");

        assertEquals(expectedValue, obtainedValue);
    }


    @Test
    public void removeUnnecessaryDecimalTest1() {
        String expectedValue = "-31";
        String obtainedValue = Compiler.removeUnnecessaryDecimal("-31.0");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void removeUnnecessaryDecimalTest2() {
        String expectedValue = "31";
        String obtainedValue = Compiler.removeUnnecessaryDecimal("31.0000");

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void removeUnnecessaryDecimalTest3() {
        String expectedValue = "0";
        String obtainedValue = Compiler.removeUnnecessaryDecimal("0.0");

        assertEquals(expectedValue, obtainedValue);
    }










}