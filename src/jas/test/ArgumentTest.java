package jas.test;

import jas.core.Mode;
import jas.core.Node;
import jas.core.components.List;
import jas.core.components.Literal;
import jas.core.components.Variable;
import jas.core.operations.Argument;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentTest {

    @Test
    public void resolveTest1(){
        Variable variable = new Variable("newVariable");
        Argument expected = Argument.VARIABLE;
        Argument actual = Argument.resolve(variable);
        assertEquals(expected, actual);
    }
    @Test
    public void resolveTest2(){
        Argument expected = Argument.NUMBER;
        Argument actual = Argument.resolve(new Node() {
            @Override
            public boolean equals(Node other) {
                return false;
            }

            @Override
            public Node copy() {
                return null;
            }

            @Override
            public void order() {

            }

            @Override
            public int levelOf(Node o) {
                return 0;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public int numNodes() {
                return 0;
            }

            @Override
            public double val() {
                return 0;
            }

            @Override
            public int complexity() {
                return 0;
            }

            @Override
            public Node simplify() {
                return null;
            }

            @Override
            public Node beautify() {
                return null;
            }

            @Override
            public Node explicitNegativeForm() {
                return null;
            }

            @Override
            public Node toAdditionOnly() {
                return null;
            }

            @Override
            public Node toExponentialForm() {
                return null;
            }

            @Override
            public Node firstDerivative(Variable v) {
                return null;
            }

            @Override
            public Node expand() {
                return null;
            }

            @Override
            public String coloredString() {
                return null;
            }

            @Override
            public Node replace(Node o, Node r) {
                return null;
            }

            @Override
            public boolean isUndefined() {
                return false;
            }

            @Override
            public double eval(double x) {
                return 0;
            }
        });
        assertEquals(expected, actual);
    }

}