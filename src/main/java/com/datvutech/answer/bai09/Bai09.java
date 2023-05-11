package com.datvutech.answer.bai09;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

// Nhập vào chỉ số điện cũ và chỉ số điện mới. Tính tiền điện phải trả trong tháng, dữ liệu nhập
// phải đảm bảo chỉ số điện cũ <= chỉ số điện mới. Cách thức tính tiền điện theo quy định sau:
// - Bậc 1: cho các kWh từ 0 đến 50: 1480 VNĐ/kw;
// - Bậc 2: cho các kWh từ 51 đến 100: 1533 VNĐ/kw;
// - Bậc 3: cho các kWh từ 101 đến 200: 1786 VNĐ/kw;
// - Bậc 4: cho các kWh từ 201 đến 300: 2242 VNĐ/kw;
// - Bậc 5: cho các kWh từ 301 trở lên: 2503 VNĐ/kw;
public class Bai09 {
    public static final double LEVEL_1_INDEX = 50;
    public static final double LEVEL_2_INDEX = 100;
    public static final double LEVEL_3_INDEX = 200;
    public static final double LEVEL_4_INDEX = 300;

    public static final double LEVEL_1_PRICE = 1480;
    public static final double LEVEL_2_PRICE = 1533;
    public static final double LEVEL_3_PRICE = 1786;
    public static final double LEVEL_4_PRICE = 2242;
    public static final double LEVEL_5_PRICE = 2503;

    public static double calElectricExpense(int oldIndex, int newIndex) {
        int numOfConsumed = newIndex - oldIndex;
        double expense = 0;
        if (numOfConsumed <= LEVEL_1_INDEX) {
            expense = numOfConsumed * LEVEL_1_PRICE;
        } else if (numOfConsumed <= LEVEL_2_INDEX) {
            expense = LEVEL_1_INDEX * LEVEL_1_PRICE + (numOfConsumed - LEVEL_1_INDEX) * LEVEL_2_PRICE;
        } else if (numOfConsumed <= LEVEL_3_INDEX) {
            expense = LEVEL_1_INDEX * LEVEL_1_PRICE + LEVEL_1_INDEX * LEVEL_2_PRICE + (numOfConsumed - LEVEL_2_INDEX) * LEVEL_3_PRICE;
        } else if (numOfConsumed <= LEVEL_4_INDEX) {
            expense = LEVEL_1_INDEX * LEVEL_1_PRICE + LEVEL_1_INDEX * LEVEL_2_PRICE + LEVEL_2_INDEX * LEVEL_3_PRICE + (numOfConsumed - LEVEL_3_INDEX) * LEVEL_4_PRICE;
        } else {
            expense = LEVEL_1_INDEX * LEVEL_1_PRICE + LEVEL_1_INDEX * LEVEL_2_PRICE + LEVEL_2_INDEX * LEVEL_3_PRICE + LEVEL_2_INDEX * LEVEL_4_PRICE + (numOfConsumed - LEVEL_4_INDEX) * LEVEL_5_PRICE;
        }
        return expense;
    }

    public static void main(String[] args) {
        Scanner scanner = AppScanner.getSystemScanner();
        System.out.print("oldIndex = ");
        int oldIndex = scanner.nextInt();
        System.out.print("newIndex = ");
        int newIndex = scanner.nextInt();

        System.out.println("Chi phi tien dien: " + calElectricExpense(oldIndex, newIndex) + " VND");
    }
}
