package com.datvutech.answer;

import java.util.Scanner;

import com.datvutech.common.SystemInput;

// 7. Nhập vào một số nguyên là tháng, cho biết tháng đó có bao nhiêu ngày (nếu là tháng 2 thì yêu
// cầu nhập thêm năm).
public class Bai07 {
    public static void main(String[] args) {
        Scanner scanner = SystemInput.getScanner();

        System.out.print("month (1-12) = ");
        int month = scanner.nextInt();

        if (month == 2) {
            System.out.print("year = ");
            int year = scanner.nextInt();

            int days = kiemTraSoLuongNgay(year, month);

            if (days == -1) {
                System.out.println("Nhap year khong hop le, vui long thu lai");
            } else {
                System.out.println("So luong ngay trong thang " + month + " cua nam " + year + ": " + days);
            }
        } else {
            int days = kiemTraSoLuongNgay(month);

            if (days == -1) {
                System.out.println("Nhap month khong hop le, vui long thu lai");
            } else {
                System.out.println("So luong ngay trong thang " + month + ": " + days);
            }
        }

    }

    public static int kiemTraSoLuongNgay(int year, int month) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (Bai06.kiemTraNamNhuan(year)) {
            daysInMonth[1] = 29;
        }

        if (month < 1 || month > 12) {
            return -1;
        }

        return daysInMonth[month - 1];
    }

    public static int kiemTraSoLuongNgay(int month) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month < 1 || month > 12) {
            return -1;
        }

        return daysInMonth[month - 1];
    }
}
