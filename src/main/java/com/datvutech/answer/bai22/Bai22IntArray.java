package com.datvutech.answer.bai22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.stream.IntStream;

import com.datvutech.answer.PrimeNumberEratosthenes;
import com.datvutech.common.AppScanner;

public class Bai22IntArray {
    private int[] arr = new int[0];
    private int n;

    // 1. Nhập giá trị cho n phần tử mảng từ bàn phím
    public int[] fillInArray(int n) {
        final Scanner sysScanner = AppScanner.getSystemScanner();
        this.n = n;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.format("a[%d] = ", i);
            arr[i] = sysScanner.nextInt();
        }
        return arr;
    }

    // 2. Phát sinh giá trị ngẫu nhiên từ -199 đến 199 cho n phần tử mảng;
    public int[] generateRandomNums(int n, int minValue, int maxValue) {
        this.n = n;
        arr = new int[n];
        int d = maxValue - minValue;
        for (int i = 0; i < n; i++) {
            int randomValue = (int) (minValue + Math.round(Math.random() * d));
            arr[i] = randomValue;
        }
        return arr;
    }

    // 3. Xuất mảng ra màn hình;
    public int[] getOriginArray() {
        return arr;
    }

    // 4. Liệt kê các giá trị âm có trong mảng;
    public int[] getNegativeNums() {
        int[] negativeNums = IntStream.of(arr).filter(x -> x < 0).toArray();
        return negativeNums;
    }

    // 5. Liệt kê các số nguyên tố có trong mảng;
    public int[] getPrimeNums() {
        final int MAX_VALUE = getTheBiggestNum();
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        int[] primeNums = IntStream.of(arr).filter((x) -> primeNumber.isPrime(x)).toArray();
        return primeNums;
    }

    // 6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước;
    public int[] getAToBArray(int a, int b) {
        int[] aToBArray = IntStream.of(arr)
                .filter((x) -> x >= a && x <= b).toArray();

        return aToBArray;
    }

    // 7. Tính tổng giá trị các phần tử là số nguyên tố;
    public int getSumOfPrimeNums() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNum = new PrimeNumberEratosthenes(MAX_VALUE);

        int sum = IntStream.of(arr).filter((x) -> primeNum.isPrime(x)).sum();
        return sum;
    }

    // 8. Tính trung bình cộng của các phần tử dương có trong mảng;
    public double getAvgOfPositiveNums() {
        double avgOfPositiveNums = IntStream.of(arr).filter((x) -> x > 0).average().getAsDouble();
        return avgOfPositiveNums;
    }

    // 9. Tính trung bình cộng của các phần tử dương có trong mảng;
    public long countBiggerThanX(int x) {

        long biggerXCount = IntStream.of(arr).filter((v) -> v > x).count();
        return biggerXCount;
    }

    // 10. Đếm số phần tử có giá trị là số nguyên tố trong mảng;
    public long countPrimeNum() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        final long primeNumCount = IntStream.of(arr).filter((x) -> primeNumber.isPrime(x)).count();
        return primeNumCount;
    }

    // 11. Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố;
    public boolean isPrimeNumbers() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        final long primeNumCount = IntStream.of(arr).filter((x) -> primeNumber.isPrime(x)).count();
        return primeNumCount == n;
    }

    // 12. Kiểm tra mảng có phải là mảng tăng dần;
    public boolean isAscending() {
        boolean isAscending = IntStream.of(arr).spliterator().hasCharacteristics(Spliterator.SORTED);
        return isAscending;
    }

    // 13. Tìm giá trị lớn nhất trong mảng;
    public int getTheBiggestNum() {
        final int theBiggestNum = IntStream.of(arr).max().getAsInt();
        return theBiggestNum;
    }

    // 17. Nhập giá trị cho mảng từ file
    public String fillArrayByFile() {
        try {
            Path filePath = Paths.get("arr.txt");
            System.out.println(Files.exists(filePath));
            final Scanner fileReader = new Scanner(Files.newInputStream(filePath));
            n = fileReader.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fileReader.nextInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }
}
