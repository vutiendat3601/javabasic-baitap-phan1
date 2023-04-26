package com.datvutech.util;

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
}
