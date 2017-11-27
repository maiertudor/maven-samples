package com.tm;

import com.tm.utils.DecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tudor.maier on 14/11/2017.
 */
public class BigDecimalsApp {
    public static void main (String[] args) {

        List<BigDecimal> input = new ArrayList<>();
        input.add(BigDecimal.valueOf(1.7));
        input.add(BigDecimal.valueOf(2.3));
        input.add(BigDecimal.valueOf(3.2));
        input.add(BigDecimal.valueOf(0.8));

        System.out.println("Result sum: " + DecimalUtils.computeSum(input));
        System.out.println("Result average: " + DecimalUtils.computeAverage(input));
    }
}
