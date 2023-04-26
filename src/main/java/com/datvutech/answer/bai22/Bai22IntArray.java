package com.datvutech.answer.bai22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.datvutech.util.AppScanner;
import com.datvutech.util.PrimeNumberEratosthenes;

public class Bai22IntArray {
    private int[] nums = new int[0];
    private int n;

    // 1. Nhập giá trị cho n phần tử mảng từ bàn phím
    public int[] fillInArray(int n) {
        final Scanner sysScanner = AppScanner.getSystemScanner();
        this.n = n;
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.format("a[%d] = ", i);
            nums[i] = sysScanner.nextInt();
        }
        return nums;
    }

    // 2. Phát sinh giá trị ngẫu nhiên từ -199 đến 199 cho n phần tử mảng;
    public int[] generateRandomNums(int n, int minValue, int maxValue) {
        this.n = n;
        nums = new int[n];
        int d = maxValue - minValue;
        for (int i = 0; i < n; i++) {
            int randomValue = (int) (minValue + Math.round(Math.random() * d));
            nums[i] = randomValue;
        }
        return nums;
    }

    // 3. Xuất mảng ra màn hình;
    public int[] getOriginArray() {
        return nums;
    }

    // 4. Liệt kê các giá trị âm có trong mảng;
    public int[] getNegativeNums() {
        int[] negativeNums = IntStream.of(nums).filter(x -> x < 0).toArray();
        return negativeNums;
    }

    // 5. Liệt kê các số nguyên tố có trong mảng;
    public int[] getPrimeNums() {
        final int MAX_VALUE = getTheBiggestNum();
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        int[] primeNums = IntStream.of(nums).filter((x) -> primeNumber.isPrime(x)).toArray();
        return primeNums;
    }

    // 6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước;
    public int[] getAToBNums(int a, int b) {
        int[] aToBArray = IntStream.of(nums)
                .filter((x) -> x >= a && x <= b).toArray();

        return aToBArray;
    }

    // 7. Tính tổng giá trị các phần tử là số nguyên tố;
    public int calculateSumOfPrimeNums() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNum = new PrimeNumberEratosthenes(MAX_VALUE);

        int sum = IntStream.of(nums).filter((x) -> primeNum.isPrime(x)).sum();
        return sum;
    }

    // 8. Tính trung bình cộng của các phần tử dương có trong mảng;
    public double calculateAvgOfPositiveNums() {
        double avgOfPositiveNums = IntStream.of(nums).filter((x) -> x > 0).average().getAsDouble();
        return avgOfPositiveNums;
    }

    // 9. Tính trung bình cộng của các phần tử dương có trong mảng;
    public long countBiggerThanX(int x) {
        long biggerXCount = IntStream.of(nums).filter((v) -> v > x).count();
        return biggerXCount;
    }

    // 10. Đếm số phần tử có giá trị là số nguyên tố trong mảng;
    public long countPrimeNum() {
        final int MAX_VALUE = getTheBiggestNum();
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        final long primeNumCount = IntStream.of(nums).filter((x) -> primeNumber.isPrime(x)).count();
        return primeNumCount;
    }

    // 11. Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố;
    public boolean isPrimeNumbers() {
        final int MAX_VALUE = getTheBiggestNum();
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        final long primeNumCount = IntStream.of(nums).filter((x) -> primeNumber.isPrime(x)).count();
        return primeNumCount == n;
    }

    // 12. Kiểm tra mảng có phải là mảng tăng dần;
    public boolean isAscending() {
        boolean ascending = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                ascending = false;
                break;
            }
        }
        return ascending;
    }

    // 13. Tìm giá trị lớn nhất trong mảng;
    public int getTheBiggestNum() {
        final int theBiggestNum = IntStream.of(nums).max().getAsInt();
        return theBiggestNum;
    }

    // 14. Tìm giá trị lớn nhất trong mảng;
    public int getTheSmallestNum() {
        final int theSmallestNum = IntStream.of(nums).min().getAsInt();
        return theSmallestNum;
    }

    // 15. Tìm số âm lớn nhất trong mảng;
    public int getTheBiggestNegativeNum() {
        final int theSmallestNum = IntStream.of(nums).filter((num) -> num < 0).max().getAsInt();
        return theSmallestNum;
    }

    // 16. Đảo ngược mảng;
    public int[] reverseNums() {
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - i - 1] = temp;
        }
        return nums;
    }

    // 17. Nhập giá trị cho mảng từ file
    public int[] fillArrayByFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            final Scanner fileReader = new Scanner(Files.newInputStream(path));
            n = fileReader.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = fileReader.nextInt();
            }
        } catch (IOException e) {
            System.out.println("Error when loading file, please try again!");
        }
        return nums;
    }
}
