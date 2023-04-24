package com.datvutech.answer;

import java.time.LocalDate;
import java.util.Scanner;

import com.datvutech.common.SystemInput;

/***
 * Kiểm tra xem ngày (gồm 3 thành phần là ngày, tháng, năm) cho trước có phải là
 * một ngày hợp
 * lệ. Trong đó, một ngày được gọi là hợp lệ khi:
 * - Năm: số nguyên lớn hơn 0;
 * - Tháng: từ 1 đến 12;
 * - Ngày từ 1 đến số ngày tối đa của tháng – năm tương ứng
 */
public class Bai11 {

    public static LocalDate getNextDay(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.plusDays(1);
    }

    public static LocalDate getPreviousDay(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.minusDays(1);
    }

   

    public static void main(String[] args) {
        int day = -1;
        int month = -1;
        int year = -1;
        Scanner scanner = SystemInput.getScanner();
        System.out.print("day = ");
        day = scanner.nextInt();
        System.out.print("month = ");
        month = scanner.nextInt();
        System.out.print("year = ");
        year = scanner.nextInt();
        System.out.println("The next day is " + getNextDay(year, month, day));
        System.out.println("The previous day is " + getPreviousDay(year, month, day));
    }
}