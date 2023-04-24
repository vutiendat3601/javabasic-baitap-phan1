package com.datvutech.answer;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.datvutech.common.SystemInput;

/* 
 * Viết chương trình tạo mảng một chiều và cho phép người dùng chọn thực hiện các chức năng
bên dưới, đến khi nào người dùng chọn 0 thì thoát chương trình:
- 1. Nhập giá trị cho n phần tử mảng từ bàn phím;
- 2. Phát sinh giá trị ngẫu nhiên từ -199 đến 199 cho n phần tử mảng;
- 3. Xuất mảng ra màn hình;
- 4. Liệt kê các giá trị âm có trong mảng;
- 5. Liệt kê các số nguyên tố có trong mảng;
- 6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước;
- 7. Tính tổng giá trị các phần tử là số nguyên tố;
- 8. Tính trung bình cộng của các phần tử dương có trong mảng;
- 9. Đếm số phần tử có giá trị lớn hơn x cho trước;
- 10. Đếm số phần tử có giá trị là số nguyên tố trong mảng;
- 11. Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố;
- 12. Kiểm tra mảng có phải là mảng tăng dần;
- 13. Tìm giá trị lớn nhất trong mảng;
- 14. Tìm giá trị nhỏ nhất trong mảng;
- 15. Tìm số âm lớn nhất trong mảng;
- 16. Đảo ngược mảng.
 */
public class Bai22 {
    Scanner scan = SystemInput.getScanner();
    private int[] arr = new int[0];
    private int n = 0;

    // 1. Nhập giá trị cho n phần tử mảng từ bàn phím
    public String initLengthOfArray() {
        System.out.print("So luong phan tu = ");
        n = scan.nextInt();
        arr = new int[n];
        return "Da tao mang rong voi " + n + "phan tu";
    }

    // 2. Phát sinh giá trị ngẫu nhiên từ -199 đến 199 cho n phần tử mảng;
    public String createRandomArray() {
        Random random = new Random();
        final int MIN_VALUE = -199;
        for (int i = 0; i < n; i++) {
            arr[i] = MIN_VALUE + random.nextInt(399);
        }
        return "OK";
    }

    // 3. Xuất mảng ra màn hình;
    public String getArrayString() {
        return Arrays.toString(arr);
    }

    // 4. Liệt kê các giá trị âm có trong mảng;
    public String getNegativeNumsString() {
        int[] negativeNums = Arrays.stream(arr).filter(x -> x < 0).toArray();
        return Arrays.toString(negativeNums);
    }

    // 5. Liệt kê các số nguyên tố có trong mảng;
    public String getPrimesArrayString() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        int[] primeNums = Arrays.stream(arr).filter((x) -> primeNumber.isPrime(x)).toArray();
        return Arrays.toString(primeNums);
    }

    // 6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước;
    public String getABArrayString() {
        System.out.print("a = ");
        final int a = scan.nextInt();
        System.out.print("b = ");
        final int b = scan.nextInt();

        int[] filteredABArray = Arrays.stream(arr)
                .filter((x) -> x >= a && x <= b).toArray();

        return filteredABArray.toString();
    }

    // 7. Tính tổng giá trị các phần tử là số nguyên tố;
    public String getSumOfPrimesInArray() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);

        int sum = Arrays.stream(arr).filter((x) -> primeNumber.isPrime(x)).sum();
        return String.valueOf(sum);
    }

    // 8. Tính trung bình cộng của các phần tử dương có trong mảng;
    public String getAverageOfPossitiveNumInArray() {

        int[] possitiveNumArr = Arrays.stream(arr).filter((x) -> x > 0).toArray();
        final int sum = Arrays.stream(arr).sum();
        final float avgNum = sum / possitiveNumArr.length;
        return String.valueOf(avgNum);
    }

    // 9. Tính trung bình cộng của các phần tử dương có trong mảng;
    public String getBiggerXCount() {
        System.out.println("x = ");
        Scanner scan = SystemInput.getScanner();
        final int x = scan.nextInt();

        long biggerXCount = Arrays.stream(arr).filter((v) -> v > x).count();
        return String.valueOf(biggerXCount);
    }

    // 10. Đếm số phần tử có giá trị là số nguyên tố trong mảng;
    public String getPrimeNumsCount() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        final long primeNumsCount = Arrays.stream(arr).filter((x) -> primeNumber.isPrime(x)).count();
        return String.valueOf(primeNumsCount);
    }

    // 11. Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố;
    public String getArrayIsPrimeNumber() {
        final int MAX_VALUE = 199;
        PrimeNumberEratosthenes primeNumber = new PrimeNumberEratosthenes(MAX_VALUE);
        final long primeNumsCount = Arrays.stream(arr).filter((x) -> primeNumber.isPrime(x)).count();
        return String.valueOf(primeNumsCount == n);
    }

    // 12. Kiểm tra mảng có phải là mảng tăng dần;
    public String getArrayIsAscending() {
        boolean isIncrement = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isIncrement = false;
                break;
            }
        }

        return isIncrement ? "Mảng là mảng tăng dần" : "Không là mảng tăng dần";
    }

    // 13. Tìm giá trị lớn nhất trong mảng;
    public String getTheBiggestNum() {
        final int theBiggestNum = Arrays.stream(arr).max().getAsInt();
        return String.valueOf(theBiggestNum);
    }

    // UI
    public void showMenu() {
        System.out.print("""
                Chuong trinh mang:
                - 1. Nhập giá trị cho n phần tử mảng từ bàn phím;
                - 2. Phát sinh giá trị ngẫu nhiên từ -199 đến 199 cho n phần tử mảng;
                - 3. Xuất mảng ra màn hình;
                - 4. Liệt kê các giá trị âm có trong mảng;
                - 5. Liệt kê các số nguyên tố có trong mảng;
                - 6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước;
                - 7. Tính tổng giá trị các phần tử là số nguyên tố;
                - 8. Tính trung bình cộng của các phần tử dương có trong mảng;
                - 9. Đếm số phần tử có giá trị lớn hơn x cho trước;
                - 10. Đếm số phần tử có giá trị là số nguyên tố trong mảng;
                - 11. Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố;
                - 12. Kiểm tra mảng có phải là mảng tăng dần;
                - 13. Tìm giá trị lớn nhất trong mảng;
                - 14. Tìm giá trị nhỏ nhất trong mảng;
                - 15. Tìm số âm lớn nhất trong mảng;
                - 16. Đảo ngược mảng.
                """);
    }

    /***
     * 
     * @return true indicates that the program continues
     */
    public boolean processMenu() {
        int c = 0;
        Scanner scan = SystemInput.getScanner();
        System.out.print("Lua chon = ");
        c = scan.nextInt();
        System.out.println(
                "\n------------------------------------RESULT-------------------------------------------------------------\n");
        switch (c) {
            case 1:
                System.out.println(initLengthOfArray());
                break;
            case 2:
                System.out.println(createRandomArray());
                break;
            case 3:
                System.out.println(getArrayString());
                break;
            case 4:
                System.out.println(getNegativeNumsString());
                break;
            case 5:
                System.out.println(getPrimeNumsCount());
                break;
            case 6:
                System.out.println(getABArrayString());
                break;
            case 7:
                System.out.println(getSumOfPrimesInArray());
                break;
            case 8:
                System.out.println(getAverageOfPossitiveNumInArray());
                break;
            case 9:
                System.out.println(getBiggerXCount());
                break;
            case 10:
                System.out.println(getPrimeNumsCount());
                break;
            case 11:
                System.out.println(getArrayIsPrimeNumber());
                break;
            case 12:
                System.out.println(getArrayIsAscending());
                break;
            case 13:
                System.out.println(getTheBiggestNum());
                break;
            case 14:

                break;
            case 15:

                break;
            case 16:

                break;
        }
        System.out.println(
                "\n------------------------------------END OF RESULT-------------------------------------------------------------\n");
        return c != 0;
    }

    public static void main(String[] args) {
        Bai22 bai22 = new Bai22();
        bai22.showMenu();
        while (bai22.processMenu()) {
            bai22.showMenu();
        }
    }
}
