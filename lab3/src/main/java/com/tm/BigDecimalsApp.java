package com.tm;

import com.tm.utils.DecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tudor.maier on 14/11/2017.
 */
public class BigDecimalsApp {
    public static void main (String[] args) {

        List<BigDecimal> input = new ArrayList<>();
        Random random = new Random();
        for ( int i = 0; i < 9999; i++) {
            input.add(BigDecimal.valueOf(random.nextDouble()));
        }

        System.out.println("--------Before serialization--------");
        Long s = System.currentTimeMillis();
        System.out.println("Sum: " + DecimalUtils.computeSum(input));
        System.out.println("Average: " + DecimalUtils.computeAverage(input));
        System.out.println("Top 10: " + DecimalUtils.topTen(input));
        Long resultOne = System.currentTimeMillis() - s;
        System.out.println("Took: " + resultOne + "ms");

        DecimalUtils.serializeItems(input, "bigdecimals.ser");

        List<BigDecimal> readDecimals = new ArrayList<>();

        DecimalUtils.deserializeItems(readDecimals, "bigdecimals.ser");

        System.out.println("--------After deserialization--------");
        s = System.currentTimeMillis();
        System.out.println("Sum: " + DecimalUtils.computeSum(readDecimals));
        System.out.println("Average: " + DecimalUtils.computeAverage(readDecimals));
        System.out.println("Top 10: " + DecimalUtils.topTen(readDecimals));
        Long resultTwo = System.currentTimeMillis() - s;
        System.out.println("Took: " + resultOne + "ms");

    }

}
