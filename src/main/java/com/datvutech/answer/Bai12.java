package com.datvutech.answer;

import java.util.Scanner;

import com.datvutech.common.AppScanner;

public class Bai12 {
    public static int countDivisorsFermat(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = -1;
        Scanner scanner = AppScanner.getSystemScanner();
        System.out.print("n = ");
        n = scanner.nextInt();
        int numOfDivisors = countDivisorsFermat(n);
        System.out.println("Number of divisor of " + n + ": " + numOfDivisors);
    }
}
