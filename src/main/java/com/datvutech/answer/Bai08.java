package com.datvutech.answer;

import java.util.Scanner;

import com.datvutech.common.SystemInput;

// Nhập vào một số thực là điểm ở thang điểm 10, cho biết giá trị ở thang điểm chữ ABCDF. Biết
// rằng: 8.5 - 10: A, 7.0 - 8.4: B, 5.5 - 6.9: C, 4.0 - 5.4: D, dưới 4: F. 
public class Bai08 {
    public static void main(String[] args) {
        Scanner scanner = SystemInput.getScanner();
        System.out.print("mark (0-10) = ");
        float mark = scanner.nextFloat(); // Read the input for mark

        if (mark >= 8.5 && mark <= 10) {
            System.out.println("Diem " + mark + " tuong ung voi diem A.");
        } else if (mark >= 7.0 && mark < 8.5) {
            System.out.println("Diem " + mark + " tuong ung voi diem B.");
        } else if (mark >= 5.5 && mark < 7.0) {
            System.out.println("Diem " + mark + " tuong ung voi diem C.");
        } else if (mark >= 4.0 && mark < 5.5) {
            System.out.println("Diem " + mark + " tuong ung voi diem D.");
        } else if (mark < 4.0 && mark >= 0) {
            System.out.println("Diem " + mark + " tuong ung voi diem F.");
        } else {
            System.out.println("Nhap sai mark, mark trong gia tri tu 0 den 10.");
        }
    }
}
