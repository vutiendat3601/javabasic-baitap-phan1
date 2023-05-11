package com.datvutech.answer.bai04;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

//4. Nhập vào 3 số nguyên, in ra màn hình số nhỏ nhất và số lớn nhất.
public class Bai04 {

    public static int getMin(int a, int b, int c) {
        int res = a;
        res = res < b ? res : b;
        res = res < c ? res : c;
        return res;
    }
    public static int getMax(int a, int b, int c) {
        int res = a;
        res = res > b ? res : b;
        res = res > c ? res : c;
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = AppScanner.getSystemScanner();

        System.out.print("a = ");
        int a = scanner.nextInt();
        System.out.print("b = ");
        int b = scanner.nextInt();
        System.out.print("c = ");
        int c = scanner.nextInt();
        System.out.println("So nho nhat: "+ getMin(a, b, c));
        System.out.println("So lon nhat: "+ getMax(a, b, c));
    }
}
