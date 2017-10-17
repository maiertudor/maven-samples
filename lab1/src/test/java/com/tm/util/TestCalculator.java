package com.tm.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by tudor.maier on 17/10/2017.
 */
public class TestCalculator {

    @Test
    public void testadd() throws Exception {
        int a = 10;
        int b = 20;
        assertEquals(30, Calculator.add(a, b));
    }

    @Test
    public void testsubstract() throws Exception {
        int a = 100;
        int b = 20;
        assertEquals(80, Calculator.substract(a, b));
    }

    @Test
    public void testdivide() throws Exception {
        assertEquals(Double.valueOf(5), Double.valueOf(Calculator.divide(100.0, 20.0)));
        assertEquals(Double.valueOf(3.5), Double.valueOf(Calculator.divide(7.0, 2.0)));
        assertEquals(Double.valueOf(0.0), Double.valueOf(Calculator.divide(0.0, 2.0)));

        try{
            Calculator.divide(2.0, 0.0);
            fail("Should not get to this line");
        } catch (Exception ex) {
            assertNotNull(ex);
            assertEquals("Division by zero", ex.getMessage());
        }
    }

    @Test
    public void testmultiply() throws Exception {
        assertEquals(Double.valueOf(10.0), Double.valueOf(Calculator.multiply(2.5, 4.0)));
        assertEquals(Double.valueOf(16.4), Double.valueOf(Calculator.multiply(4.1, 4.0)));
        assertEquals(Double.valueOf(0.0), Double.valueOf(Calculator.multiply(0.0, 2.4)));
    }

    @Test
    public void testmin() throws Exception {
        assertEquals(10, Calculator.min(10,20));
        assertEquals(-2, Calculator.min(-2, -1));
        assertEquals(0, Calculator.min(0, 0));
        assertEquals(-2, Calculator.min(-2, 1));
    }

    @Test
    public void testmax() throws Exception {
        assertEquals(20, Calculator.max(10,20));
        assertEquals(-1, Calculator.max(-2, -1));
        assertEquals(0, Calculator.max(0, 0));
        assertEquals(1, Calculator.max(-2, 1));
    }

    @Test
    public void textsqrt() throws Exception {
        assertEquals(Double.valueOf(4.0), Double.valueOf(Calculator.sqrt(16)));
        assertEquals(Double.valueOf(3.1622776601683795), Double.valueOf(Calculator.sqrt(10)));
        assertEquals(Double.valueOf(0.0), Double.valueOf(Calculator.sqrt(0)));

        try{
            Calculator.sqrt(-10);
            fail("Should not get here");
        } catch (Exception ex) {
            assertNotNull(ex);
            assertEquals("Negative argument", ex.getMessage());
        }
    }
}
