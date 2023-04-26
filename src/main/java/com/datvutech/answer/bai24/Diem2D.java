package com.datvutech.answer.bai24;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Diem2D {
    private int x;
    private int y;
    private String name;

    // Constructor
    public Diem2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Diem2D(int x, int y, String name) {
        this(x, y);
        this.name = name;
    }

    // Bussiness
    public void nhapDiem() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("x = ");
        x = sysScanner.nextInt();
        System.out.print("y = ");
        y = sysScanner.nextInt();

    }

    public void hienThi() {
        System.out.format("Toa do hien tai cua diem %s: (%d, %d)\n", name, x, y);
    }

    public void doiDiem(int dX, int dY) {
        x -= dX;
        y -= dY;
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
        int delta = dX * dX + dY * dY;
        return (float) Math.sqrt(delta);
    }

    public float khoangCach(Diem2D diem) {
        int dX = x - diem.x;
        dX = dX > 0 ? dX : -dX;

        int dY = y - diem.y;
        dY = dY > 0 ? dY : -dY;

        int delta = dX * dX + dY * dY;
        return (float) Math.sqrt(delta);
    }

    public static void main(String[] args) {
        Diem2D A = new Diem2D(3, 4, "A");
        A.hienThi();

        Diem2D B = new Diem2D(0, 0, "B");
        B.nhapDiem();
        B.hienThi();

        Diem2D C = new Diem2D(-B.giaTriX(), -B.giaTriY(), "C");
        C.hienThi();

        System.out.println("Khoang cach diem B den tam O: " + B.khoangCach());
        System.out.println("Khoang cach diem A den diem B: " + B.khoangCach(A));
    }
}
