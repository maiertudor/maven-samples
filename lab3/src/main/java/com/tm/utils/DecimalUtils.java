package com.tm.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by tudor.maier on 14/11/2017.
 */
public class DecimalUtils {

    public static BigDecimal computeSum(List<BigDecimal> input) {
        return input.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal computeAverage(List<BigDecimal> input) {
        return computeSum(input).divide(BigDecimal.valueOf(input.size()));
    }

    public static List<BigDecimal> topTen(List<BigDecimal> input) {
        List<BigDecimal> temp =
                input.stream().sorted((o1, o2) -> o1.compareTo(o2) * -1).
                        collect(Collectors.toList());
        return temp.stream()
                .limit((long) (temp.size() * 0.1)).collect(toList());
    }
}
