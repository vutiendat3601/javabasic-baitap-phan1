package com.datvutech.answer.bai24;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.Setter;

/***
 * This class represents a point in Oxy coordinate plane
 * 
 * @author Dat Vu
 * @date 2023-05-04
 */

@Setter
@Getter
public class Diem2D {
    /* #: Properties */
    private int x;
    private int y;
    private String name;
    /* # Properties */

    /* #: Constructors */
    public Diem2D(int x, int y) {
        this.x = x;
        this.y = y;
        name = "DiemKhongTen";
    }

    public Diem2D(int x, int y, String name) {
        this(x, y);
        this.name = name;
    }
    /* # Constructors */

    /* #: Input, output */
    public void nhapDiem() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("x = ");
        x = sysScanner.nextInt();
        System.out.print("y = ");
        y = sysScanner.nextInt();
    }

    public void hienThi() {
        System.out.format("Toạ độ điểm %s: (%d, %d)\n", name, x, y);
    }
    /* # Input, output */

    /* #: Bussiness */
    public void doiDiem(int dX, int dY) {
        x += dX;
        y += dY;
    }

    public int giaTriX() {
        return x;
    }

    public int giaTriY() {
        return y;
    }

    public float khoangCach() {
        int dX = x > 0 ? x : -x;
        int dY = y > 0 ? y : -y;
        int sqrKc = dX * dX + dY * dY;
        return (float) Math.sqrt(sqrKc);
    }

    public float khoangCach(Diem2D diem) {
        int dX = x - diem.x;
        dX = dX > 0 ? dX : -dX;

        int dY = y - diem.y;
        dY = dY > 0 ? dY : -dY;

        int sqrKc = dX * dX + dY * dY;
        return (float) Math.sqrt(sqrKc);
    }
    /* # Bussiness */

    public static void main(String[] args) {
        Diem2D A = new Diem2D(3, 4, "A");
        A.hienThi();

        Diem2D B = new Diem2D(0, 0, "B");
        B.nhapDiem();
        B.hienThi();

        Diem2D C = new Diem2D(-B.giaTriX(), -B.giaTriY(), "C");
        C.hienThi();

        System.out.format("Khoảng cách điểm %s đến tâm O: %.2f\n", B.getName(), B.khoangCach());
        System.out.format("Khoảng cách điểm %s đến điểm %s: %.2f\n", A.getName(), B.getName(), A.khoangCach(B));
    }
}
