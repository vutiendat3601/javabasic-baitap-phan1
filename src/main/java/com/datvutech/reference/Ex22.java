/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datvutech.reference;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chidi
 */
public class Ex22 {

    public static int soNT(int n) {
        int dem = 0;
        int kq;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && n > 0) {
                dem++;
            }
        }
        if (dem > 0) {
            kq = 1;
        } else {
            kq = 0;
        }
        return kq;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        int luachon = 0;
        int[] a = new int[n];
        do {
            System.out.println("\n=======MENU======");
            System.out.println(
                    "0.Thoat\n"
                            + "1.Nhap gia tri cho n phan tu vao mang\n"
                            + "2.Phat sinh gia tri ngau nhien tu -199 den 199\n"
                            + "3.Xuat mang ra man hinh\n"
                            + "4.Liet ke cac gia tri am trong mang\n"
                            + "5.Liet ke cac so nguyen to trong mang\n"
                            + "6.Liet ke cac phan tu nam trong mang [a,b] cho truoc\n"
                            + "7.Tinh tong cac gia tri so nguyen to trong mang\n"
                            + "8.Trung binh cong cac phan tu duong trong mang\n"
                            + "9.Dem so phan tu co gia tri lon hon x cho truoc\n"
                            + "10.Dem so luong so nguyen to trong mang\n"
                            + "11.Kiem tra mang co phai chua toan so nguyen to\n"
                            + "12. Kiem tra mang co phai la mang tang dan khong\n"
                            + "13. Tim gia tri lon nhat trong mang\n"
                            + "14.Tim gia tri nho nhat trong mang\n"
                            + "15.Tim so am lon nhat\n"
                            + "16.Dao nguoc mang\n"
                            + "======================================");
            luachon = sc.nextInt();
            if (luachon == 1) {
                for (int i = 0; i < n; i++) {
                    System.out.print("a[" + i + "]=");
                    a[i] = sc.nextInt();
                }
            }
            if (luachon == 2) {
                Random rd_value = new Random();
                for (int i = 0; i < n; i++) {
                    a[i] = rd_value.nextInt((199 - (-199)) + 1) + (-199);
                }
            }
            if (luachon == 3) {
                System.out.println("====Mang vua nhap la: ====");
                for (int i = 0; i < n; i++) {
                    System.out.println("a[" + i + "]=" + a[i]);
                }
            }
            if (luachon == 4) {
                System.out.println("Cac phan tu am trong mang la: ");
                for (int i = 0; i < n; i++) {
                    if (a[i] < 0) {
                        System.out.println(a[i] + " ");
                    }
                }
            }
            if (luachon == 5) {
                System.out.println("So nguyen to trong mang la:");
                for (int i = 0; i < n; i++) {
                    if (soNT(a[i]) == 0 && a[i] > 0) {
                        System.out.println(a[i] + " ");
                    }
                }
            }
            if (luachon == 6) {
                System.out.println("Nhap vao khoang [a,b]: ");
                int a1 = sc.nextInt();
                int b1 = sc.nextInt();
                System.out.println("Cac phan tu nam trong khoang [" + a1 + "," + b1 + "] la: ");
                for (int i = 0; i < n; i++) {
                    if (a[i] >= a1 && a[i] <= b1) {
                        System.out.print(a[i] + " ");
                    }
                }
                System.out.println();

            }
            if (luachon == 7) {
                System.out.print("Tong cac so nguyen to trong mang la: ");
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (soNT(a[i]) == 0) {
                        sum += a[i];
                    }
                }
                System.out.println(sum);
            }
            if (luachon == 8) {
                int sum = 0;
                int dem = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i] > 0) {
                        dem++;
                        sum += a[i];
                    }
                }
                System.out.print(sum / dem);
            }
            if (luachon == 9) {
                System.out.println("Nhap vao so x cho truoc: ");
                int x = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    if (a[i] > x) {
                        System.out.print(a[i] + ", ");
                    }
                }
            }
            if (luachon == 10) {
                System.out.println("So luong so nguyen to trong mang la");
                int dem = 0;
                for (int i = 0; i < n; i++) {
                    if (soNT(a[i]) == 0) {
                        dem++;
                    }
                }
                System.out.print(dem);
            }

            if (luachon == 11) {
                int dem = 0;
                for (int i = 0; i < n; i++) {
                    if (soNT(a[i]) == 0) {
                        dem++;
                    }
                }
                if (dem == n - 1) {
                    System.out.println("Mang chi co so nguyen to");
                } else {
                    System.out.println("mang chi co" + dem + "so nguyen to trong" + n + " phan tu\n");
                }
            }
            if (luachon == 12) {
                int check = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n - 1; j++) {
                        if (a[j] < a[i]) {
                            check++;
                        }
                    }
                }
                if (check == 0) {
                    System.out.println("mang tang dan");
                } else {
                    System.out.println("mang khong tang dan");
                }
            }
            if (luachon == 13) {
                System.out.println("Gia tri lon nhat trong mang la: ");
                int max = a[0];
                for (int i = 1; i < n; i++) {
                    if (a[i] >= max) {
                        max = a[i];
                    }
                }
                System.out.println(max);
            }
            if (luachon == 14) {
                System.out.println("Gia tri be nhat trong mang la: ");
                int min = a[0];
                for (int i = 1; i < n; i++) {
                    if (a[i] <= min) {
                        min = a[i];
                    }
                }
                System.out.println(min);
            }
            if (luachon == 15) {
                int m = 0;
                int b[] = new int[10];
                for (int i = 0; i < n; i++) {
                    if (a[i] < 0) {
                        b[m] = a[i];
                        m++;
                    }
                }
                System.out.print("So am lon nhat trong ");
                for (int j = 0; j < m; j++) {
                    System.out.print(b[j] + " ");
                }
                int max = b[0];
                for (int i = 1; i < m; i++) {
                    if (b[i] >= max) {
                        max = b[i];
                    }
                }
                System.out.println("la:" + max);
                if (m == 0) {
                    System.out.println("Khong co so am trong mang");
                }

            }
            if (luachon == 16) {
                System.out.println("*****Dao nguoc mang***** ");
                for (int i = n - 1; i >= 0; i--) {
                    System.out.print(a[i] + " ");
                }
            }
        } while (luachon > 0);
    }
}
