package com.datvutech.common;

import java.util.Scanner;

public class SystemInput {
    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return SCANNER;
    }
}
