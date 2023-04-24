package com.datvutech.answer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Bai03Test {
    @Test
    public void testAbiggerThanB() {
        int a = 10;
        int b = 2;
        assertTrue(Bai03.max(a, b) == a);
    }

    @Test
    public void testAsmallerThanB() {
        int a = -10;
        int b = 2;
        assertTrue(Bai03.max(a, b) == b);
    }
}
