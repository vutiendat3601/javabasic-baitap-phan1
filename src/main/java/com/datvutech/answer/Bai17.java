package com.datvutech.answer;

import java.util.Scanner;

import com.datvutech.common.SystemInput;

/**
 *
 * @author Admin
 */
public class Bai17 {
    public static void main(String[] args) {
        Scanner scan = SystemInput.getScanner();
        System.out.println("n = ");
        int n = scan.nextInt();
        int sum = 0;

        while (n != 0) {
            int value = n % 10;
            if (value % 2 == 0) {
                sum += value;
            }
            n /= 10;
        }

        System.out.println("Tong so luong cac chu so chan: " + sum);
    }
}
