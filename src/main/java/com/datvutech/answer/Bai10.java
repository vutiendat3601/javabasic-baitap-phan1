package com.datvutech.answer;

import java.time.LocalDate;
import java.util.Scanner;

import com.datvutech.common.AppScanner;

/***
 * Kiểm tra xem ngày (gồm 3 thành phần là ngày, tháng, năm) cho trước có phải là
 * một ngày hợp
 * lệ. Trong đó, một ngày được gọi là hợp lệ khi:
 * - Năm: số nguyên lớn hơn 0;
 * - Tháng: từ 1 đến 12;
 * - Ngày từ 1 đến số ngày tối đa của tháng – năm tương ứng.
 */
public class Bai10 {
    public static boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidDateSC(int year, int month, int day) {
        boolean isValid = true;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                isValid = (day >= 1 && day <= 31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                isValid = (day >= 1 && day <= 30);
                break;
            case 2:
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    isValid = (day >= 1 && day <= 29); // Nam nhuan
                } else {
                    isValid = (day >= 1 && day <= 28); // Nam khong nhuan
                }
                break;
            default:
                isValid = false; // Sai thang
                break;
        }

        return isValid;
    }

    public static void main(String[] args) {
        int day = -1;
        int month = -1;
        int year = -1;
        Scanner scanner = AppScanner.getSystemScanner();
        System.out.print("day = ");
        day = scanner.nextInt();
        System.out.print("month = ");
        month = scanner.nextInt();
        System.out.print("year = ");
        year = scanner.nextInt();
        boolean valid = isValidDate(year, month, day);
        if (valid) {
            System.out.println("The day is valid");
        } else {
            System.out.println("The day is invalid");
        }
    }
}
