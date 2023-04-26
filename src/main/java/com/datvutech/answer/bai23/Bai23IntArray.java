package com.datvutech.answer.bai23;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.datvutech.util.AppScanner;
import com.datvutech.util.NumberUtils;
import com.datvutech.util.PrimeNumberEratosthenes;

/***
 * 1. Nhập giá trị cho mxn phần tử của mảng từ bàn phím;
 * 2. Phát sinh giá trị ngẫu nhiên từ -99 đến 99 cho mxn phần tử của mảng;
 * 3. Xuất giá trị các phần tử ra màn hình;
 * 4. Tính tổng giá trị các số lẻ;
 * 5. Tính tổng các giá trị dương trên dòng k cho trước;
 * 6. Đếm số lượng số dương;
 * 7. Đếm số lượng số nguyên tố trên một dòng của ma trận;
 * 8. Kiểm tra ma trận có tồn tại số âm hay không;
 * 9. Kiểm tra các phần tử trên dòng k cho trước có tăng dần từ trái qua phải
 * hay không;
 * 10. Liệt kê dòng có chứa số nguyên tố;
 * 11. Liệt kê dòng chứa toàn giá trị chẵn.
 */
public class Bai23IntArray {
    private int[][] nums = new int[0][0];
    private int m;
    private int n;

    // 1. Nhập giá trị cho mxn phần tử của mảng từ bàn phím;
    public int[][] fillInArray(int m, int n) {
        this.m = m;
        this.n = n;
        final Scanner sysScanner = AppScanner.getSystemScanner();
        this.n = n;
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("a[%d][%d] = ", i, j);
                nums[i][j] = sysScanner.nextInt();
            }
        }
        return nums;
    }

    // 2. Phát sinh giá trị ngẫu nhiên từ -99 đến 99 cho mxn phần tử của mảng;
    public int[][] generateRandomNums(int m, int n, int minValue, int maxValue) {
        this.m = m;
        this.n = n;
        nums = new int[m][n];
        int d = maxValue - minValue;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int randomValue = (int) (minValue + Math.round(Math.random() * d));
                nums[i][j] = randomValue;
            }
        }
        return nums;
    }

    // 3. Xuất giá trị các phần tử ra màn hình;
    public int[][] getOriginArray() {
        return nums;
    }

    // 4. Tính tổng giá trị các số lẻ;
    public int calculateSumOfOddNums() {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += IntStream.of(nums[i]).filter(num -> NumberUtils.isOddNumber(num)).sum();
        }
        return sum;
    }

    // 5. Tính tổng các giá trị dương trên dòng k cho trước;
    public int calculateSumOfLineK(int k) {
        int sum = IntStream.of(nums[k]).sum();
        return sum;
    }

    // 6. Đếm số lượng số dương;
    public long countPositiveNum() {
        long positiveNumCount = 0;
        for (int i = 0; i < m; i++) {
            positiveNumCount += IntStream.of(nums[i]).filter(num -> num > 0).count();
        }
        return positiveNumCount;
    }

    // 7. Đếm số lượng số nguyên tố trên một dòng của ma trận;
    public long[] countPrimeNumByLine() {
        long[] primeNumCountByLines = new long[m];
        int theBiggestNum = getTheBiggestNum();
        PrimeNumberEratosthenes primeNums = new PrimeNumberEratosthenes(theBiggestNum);
        for (int i = 0; i < m; i++) {
            primeNumCountByLines[i] = IntStream.of(nums[i]).filter(num -> primeNums.isPrime(num)).count();
        }
        return primeNumCountByLines;
    }

    // 8. Kiểm tra ma trận có tồn tại số âm hay không;
    public boolean hasAnyNegativeNum() {
        boolean result = false;
        for (int i = 0; i < m; i++) {
            OptionalInt intOpt = IntStream.of(nums[i]).filter(num -> num < 0).findFirst();
            if (intOpt.isPresent()) {
                result = true;
                break;
            }
        }
        return result;
    }

    // 9. Kiểm tra các phần tử trên dòng k cho trước có tăng dần từ trái qua phải;
    public boolean isAscendingLineK(int k) {
        boolean ascending = true;

        int[] a = nums[m];
        for (int j = 0; j < n - 1; j++) {
            if (a[j] >= a[j + 1]) {
                ascending = false;
                break;
            }
        }
        return ascending;
    }

    // 10. Liệt kê dòng có chứa số nguyên tố;
    public int[][] getLinesHasAnyPrimeNum() {
        final int theBiggestNum = getTheBiggestNum();
        PrimeNumberEratosthenes primeNums = new PrimeNumberEratosthenes(theBiggestNum);
        int numOfLines = 0;
        boolean[] lineHasPrimeNums = new boolean[m];
        for (int i = 0; i < m; i++) {
            OptionalInt intOpt = IntStream.of(nums[i]).filter(num -> primeNums.isPrime(num)).findFirst();
            if (intOpt.isPresent()) {
                lineHasPrimeNums[i] = true;
                numOfLines++;
            }
        }
        int[][] a = new int[numOfLines][n];
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (lineHasPrimeNums[i]) {
                a[j++] = Arrays.copyOf(nums[i], n);
            }
        }
        return a;
    }

    // 11. Liệt kê dòng chứa toàn giá trị chẵn;
    public int[][] getLinesHasOnlyEvenNums() {
        int numOfLines = 0;
        boolean[] lineHasOnlyEvenNums = new boolean[m];
        for (int i = 0; i < m; i++) {
            OptionalInt intOpt = IntStream.of(nums[i])
                    .filter(num -> NumberUtils.isOddNumber(num)).findFirst();
            if (!intOpt.isPresent()) {
                lineHasOnlyEvenNums[i] = true;
                numOfLines++;
            }
        }
        int[][] a = new int[numOfLines][n];
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (lineHasOnlyEvenNums[i]) {
                a[j++] = Arrays.copyOf(nums[i], n);
            }
        }
        return a;
    }

    public int getTheBiggestNum() {
        int theBiggestNum = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            final int max = IntStream.of(nums[i]).max().getAsInt();
            theBiggestNum = theBiggestNum >= max ? theBiggestNum : max;
        }
        return theBiggestNum;
    }

}
