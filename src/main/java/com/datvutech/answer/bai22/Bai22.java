package com.datvutech.answer.bai22;

import java.util.Arrays;
import java.util.Scanner;

import com.datvutech.common.AppScanner;

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
    Scanner sysScanner = AppScanner.getSystemScanner();
    private Bai22IntArray bai22IntArray;

    public Bai22() {
        bai22IntArray = new Bai22IntArray();
    }

    // UI
    public void showMenu() {
        System.out.print("""
                #####################################################################\n
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
                - 17. Nhap mang tu file.
                \n####################################################################\n
                """);
    }

    /***
     * 
     * @return true indicates that the program continues
     */
    public boolean processMenu() {
        int c = 0;
        Scanner scanner = AppScanner.getSystemScanner();
        System.out.print("Lua chon = ");
        c = scanner.nextInt();
        System.out.println(
                "\n------------------------------------RESULT------------------------------------\n");

        int[] nums = new int[0];
        int n;
        switch (c) {
            case 1:
                System.out.print("n = ");
                n = scanner.nextInt();
                nums = bai22IntArray.fillInArray(n);
                System.out.println(Arrays.toString(nums));
                break;
            case 2:
                System.out.print("n = ");
                n = scanner.nextInt();
                System.out.print("minValue = ");
                int minValue = scanner.nextInt();
                System.out.print("maxValue = ");
                int maxValue = scanner.nextInt();
                nums = bai22IntArray.generateRandomNums(n, minValue, maxValue);
                System.out.println(Arrays.toString(nums));
                break;
            case 3:
                nums = bai22IntArray.getOriginArray();
                System.out.println("Origin array: " + Arrays.toString(nums));
                break;
            case 4:
                nums = bai22IntArray.getNegativeNums();
                break;
            case 5:
                long primeNumsCount = bai22IntArray.countPrimeNum();
                System.out.println("primeNumsCount: " + primeNumsCount);
                break;
            case 6:
                System.out.println("a = ");
                int a = scanner.nextInt();
                System.out.println("b = ");
                int b = scanner.nextInt();
                nums = bai22IntArray.getAToBArray(a, b);
                System.out.println(Arrays.toString(nums));
                break;
            case 7:
                long sumOfPrimeNums = bai22IntArray.getSumOfPrimeNums();
                System.out.println("sumOfPrimeNums: " + sumOfPrimeNums);
                break;
            case 8:
                double avgOfPositiveNums = bai22IntArray.getAvgOfPositiveNums();
                System.out.println("avgOfPositiveNums: " + avgOfPositiveNums);
                break;
            case 9:
                System.out.println("x = ");
                final int x = scanner.nextInt();
                long biggerThanXCount = bai22IntArray.countBiggerThanX(x);
                System.out.println(biggerThanXCount);
                break;
            case 10:
                System.out.println(bai22IntArray.countPrimeNum());
                break;
            case 11:
                System.out.println(bai22IntArray.isPrimeNumbers());
                break;
            case 12:
                boolean ascending = bai22IntArray.isAscending();
                System.out.println("ascending: " + ascending);
                break;
            case 13:
                long theBiggestNum = bai22IntArray.getTheBiggestNum();
                System.out.println("theBiggestNum: " + theBiggestNum);
                break;
            case 14:

                break;
            case 15:

                break;
            case 16:

                break;
            case 17:
                bai22IntArray.fillArrayByFile();
                break;
        }
        System.out.println(
                "\n------------------------------------END OF RESULT-------------------------------------------------------------\n");
        sysScanner.nextInt();
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
