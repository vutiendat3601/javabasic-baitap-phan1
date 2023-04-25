package com.datvutech.answer;

import java.util.Scanner;

import com.datvutech.common.AppScanner;

// 5. Giải và biện luận phương trình bậc 2 (ax2 + bx + c =0).
public class Bai05 {
    public static void main(String[] args) {
        Scanner scanner = AppScanner.getSystemScanner();
        // Nhap vao a, b, c
        System.out.print("a = ");
        double a = scanner.nextInt();
        System.out.print("b = ");
        double b = scanner.nextInt();
        System.out.print("c = ");
        double c = scanner.nextInt();

        double x1 = 0;
        double x2 = 0;
        String res = "";
        // Trường hợp 1: a = 0, ta giải và biện luận ax + b = 0.
        if (a == 0) {
            if (b == 0) {
                res = "Phuong trinh vo nghiem";
            } else {
                res = "Phuong trinh co nghiem duy nhat: " + c / b;
            }
        } else {
            double delta = b * b - 4 * a * c;
            // + Nếu delta > 0 thì phương trình có 2 nghiệm phân biệt
            if (delta > 0) {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                res = "Phuong trinh co nghiem x1: " + x1 + ", x2: " + x2;
            } else if (delta == 0) {
                x1 = -b / (2 * a);
                res = "Phuong trinh co nghiem kep: " + x1;
            } else {
                res = "Phuong trinh vo nghiem";
            }
        }
        System.out.println(res);
    }
}
