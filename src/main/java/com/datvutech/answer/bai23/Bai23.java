package com.datvutech.answer.bai23;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.datvutech.util.AppScanner;

public class Bai23 {
    private Bai23IntArray bai23IntArray;

    public Bai23() {
        bai23IntArray = new Bai23IntArray();
    }

    // UI
    public void showMenu() {
        System.out.print("""
                #####################################################################\n
                Chương trình mảng số nguyên:
                - 1. Nhập giá trị cho mxn phần tử của mảng từ bàn phím;
                - 2. Phát sinh giá trị ngẫu nhiên từ -99 đến 99 cho mxn phần tử của mảng;
                - 3. Xuất giá trị các phần tử ra màn hình;
                - 4. Tính tổng giá trị các số lẻ;
                - 5. Tính tổng các giá trị dương trên dòng k cho trước;
                - 6. Đếm số lượng số dương;
                - 7. Đếm số lượng số nguyên tố trên một dòng của ma trận;
                - 8. Kiểm tra ma trận có tồn tại số âm hay không;
                - 9. Kiểm tra các phần tử trên dòng k cho trước có tăng dần từ trái qua phải hay không;
                - 10. Liệt kê dòng có chứa số nguyên tố;
                - 11. Liệt kê dòng chứa toàn giá trị chẵn.
                \n####################################################################\n
                """);
    }

    public boolean processMenu() {
        int c = 0;
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("Lua chon = ");
        c = sysScanner.nextInt();
        System.out.println(
                "\n------------------------------------RESULT------------------------------------\n");

        int[][] nums = new int[0][0];
        int m = 0;
        int n = 0;
        int k = 0;

        switch (c) {
            case 1:
                System.out.print("m = ");
                m = sysScanner.nextInt();
                System.out.print("n = ");
                n = sysScanner.nextInt();
                nums = bai23IntArray.fillInArray(m, n);
                for (int[] a : nums) {
                    System.out.println(Arrays.toString(a));
                }
                break;
            case 2:
                System.out.print("m = ");
                m = sysScanner.nextInt();
                System.out.print("n = ");
                n = sysScanner.nextInt();
                System.out.print("minValue = ");
                int minValue = sysScanner.nextInt();
                System.out.print("maxValue = ");
                int maxValue = sysScanner.nextInt();
                nums = bai23IntArray.generateRandomNums(m, n, minValue, maxValue);
                for (int[] a : nums) {
                    System.out.println(Arrays.toString(a));
                }
                break;
            case 3:
                nums = bai23IntArray.getOriginArray();
                System.out.println("Origin array: " + Arrays.toString(nums));
                break;
            case 4:
                int sumOfOddNums = bai23IntArray.calculateSumOfOddNums();
                System.out.println("sumOfOddNums: " + sumOfOddNums);
                break;
            case 5:
                System.out.print("k = ");
                k = sysScanner.nextInt();
                int sumOfLineK = bai23IntArray.calculateSumOfLineK(k);
                System.out.println("sumOfLineK: " + sumOfLineK);
                break;
            case 6:
                long positiveNumCount = bai23IntArray.countPositiveNum();
                System.out.println("positiveNumCount: " + positiveNumCount);
                break;

            case 7:
                long[] primeNumCountByLines = bai23IntArray.countPrimeNumByLine();

                System.out.println("Số lượng số nguyên tố trên mỗi dòng: ");
                for (int i = 0; i < primeNumCountByLines.length; i++) {
                    System.out.format("Dòng %d: %d\n", i, primeNumCountByLines[i]);
                }
                break;
            case 8:
                boolean hasAnyNegativeNum = bai23IntArray.hasAnyNegativeNum();
                System.out.println("hasAnyNegativeNum: " + hasAnyNegativeNum);
                break;

            case 9:
                System.out.print("k = ");
                k = sysScanner.nextInt();
                boolean ascending = bai23IntArray.isAscendingLineK(k);
                System.out.println("ascending: " + ascending);
                break;

            case 10:
                nums = bai23IntArray.getLinesHasAnyPrimeNum();
                for (int[] a : nums) {
                    System.out.println(Arrays.toString(a));
                }
                break;
            case 11:
                nums = bai23IntArray.getLinesHasOnlyEvenNums();
                for (int[] a : nums) {
                    System.out.println(Arrays.toString(a));
                }
                break;
        }
        System.out.println(
                "\n------------------------------------END OF RESULT-------------------------------------------------------------\n");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c != 0;
    }

    public static void main(String[] args) {
        Bai23 bai23 = new Bai23();
        bai23.showMenu();
        while (bai23.processMenu()) {
            bai23.showMenu();
        }
    }
}
