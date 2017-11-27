package com.tm.utils;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tudor.maier on 14/11/2017.
 */
public class TestDecimalUtils {

    List<BigDecimal> input = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        input.clear();
        input.add(BigDecimal.valueOf(1.7));
        input.add(BigDecimal.valueOf(2.3));
        input.add(BigDecimal.valueOf(3.2));
        input.add(BigDecimal.valueOf(0.8));
        input.add(BigDecimal.valueOf(1.7));
        input.add(BigDecimal.valueOf(2.3));
        input.add(BigDecimal.valueOf(3.2));
        input.add(BigDecimal.valueOf(0.8));
        input.add(BigDecimal.valueOf(3.2));
        input.add(BigDecimal.valueOf(12.8));
    }

    @Test
    public void testSum_001() throws Exception {
        assertEquals(DecimalUtils.computeSum(input), BigDecimal.valueOf(32.0));
    }

    @Test
    public void testAverage_001() throws Exception {
        assertEquals(DecimalUtils.computeAverage(input), BigDecimal.valueOf(3.2));
    }

    @Test
    public void testTopPercent() throws Exception {
        assertEquals(1, DecimalUtils.topTen(input).size());
        assertEquals(BigDecimal.valueOf(12.8), DecimalUtils.topTen(input).get(0));
    }
}
