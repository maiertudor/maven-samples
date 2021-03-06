package com.tm.utils;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tudor.maier on 14/11/2017.
 */
public class TestDecimalUtils {

    static List<BigDecimal> input = new ArrayList<>();
    static List<BigDecimal> serializableList = new ArrayList<>();

    @BeforeClass
    public static void setUpClass(){
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

        serializableList.clear();
        Random random = new Random();
        for ( int i = 0; i < 9999; i++) {
            serializableList.add(BigDecimal.valueOf(random.nextDouble()));
        }
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

    @Test
    public void testSerialize() throws Exception {
        DecimalUtils.serializeItems(serializableList, "test_bigdecimals.ser");
        File f = new File("/tmp/test_bigdecimals.ser");
        assertTrue("File wasn't created after serialization", f.exists());
        assertTrue("File is actually a directory", !f.isDirectory());
    }

    @Test
    public void testDeserialize() throws Exception {
        List<BigDecimal> tmpList = new ArrayList<>();
        DecimalUtils.deserializeItems(tmpList, "test_bigdecimals.ser");
        assertEquals("Lists sizes do not match", serializableList.size(), tmpList.size());
        for (BigDecimal tmpItem : tmpList) {
            assertTrue("Element: " + tmpItem + " is not in the initial list\n" + serializableList.toString(), serializableList.contains(tmpItem));
        }
    }
}
