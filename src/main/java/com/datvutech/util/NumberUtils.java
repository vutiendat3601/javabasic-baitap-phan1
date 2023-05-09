package com.datvutech.util;

import java.text.DecimalFormat;

public class NumberUtils {
    public static boolean isOddNumber(int x) {
        return x % 2 != 0;
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static boolean isNumeric(String x) {
        if (x == null) {
            return false;
        }
        try {
            Double.parseDouble(x);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static <T extends Number> String formatSeparateNum(T num) {
        DecimalFormat format = new DecimalFormat();
        return format.format(num);
    }

}
