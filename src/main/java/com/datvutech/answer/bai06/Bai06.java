package com.datvutech.answer.bai06;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

// 6. Nhập vào một số nguyên là năm, cho biết năm đó có là năm nhuần hay không. Biết rằng: năm
// nhuần là năm chia hết cho 400 hoặc chia hết cho 4 nhưng không chia hết cho 100.
public class Bai06 {

    public static boolean kiemTraNamNhuan(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = AppScanner.getSystemScanner();
        System.out.print("year = ");
        int year = scanner.nextInt();
        boolean res = kiemTraNamNhuan(year);
        if (res) {
            System.out.println("Nam " + year + " la nam nhuan");
        } else {
            System.out.println("Nam " + year + " khong phai la nam nhuan");
        }
    }
}
