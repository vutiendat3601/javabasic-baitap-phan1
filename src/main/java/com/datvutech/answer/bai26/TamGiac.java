package com.datvutech.answer.bai26;

import java.util.Scanner;

import com.datvutech.answer.bai24.Diem2D;
import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * This class represents a triangle in Oxy coordinate plane
 * 
 * @author Dat Vu
 * @date 2023-05-04
 * 
 */

@NoArgsConstructor
@Getter
@Setter
public class TamGiac {
    /* #: Properties */
    private Diem2D a;
    private Diem2D b;
    private Diem2D c;
    /* # Properties */

    /* #: Constructors */
    public TamGiac(Diem2D a, Diem2D b, Diem2D c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /* # Constructors */

    /* #: Input, output */
    public void nhapDiem() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        int x, y;

        System.out.print("A.x = ");
        x = sysScanner.nextInt();
        a.setX(x);
        System.out.print("A.y = ");
        y = sysScanner.nextInt();
        a.setY(y);

        System.out.print("B.x = ");
        x = sysScanner.nextInt();
        b.setX(x);
        System.out.print("B.y = ");
        y = sysScanner.nextInt();
        b.setY(y);

        System.out.print("C.x = ");
        x = sysScanner.nextInt();
        c.setX(x);
        System.out.print("C.y = ");
        y = sysScanner.nextInt();
        c.setY(y);
    }

    public void xuat() {
        System.out.format("A = (%d,%d)\n", a.getX(), a.getY());
        System.out.format("B = (%d,%d)\n", b.getX(), b.getY());
        System.out.format("C = (%d,%d)\n", c.getX(), c.getY());
    }
    /* # Input, output */

    /* #: Bussiness */
    // Triangle Area Formula: S = (1/2) | AB.AC.sinBAC |
    // Triangle Area Formula: S = (1/2) | (xB-xA)(yC-yA) - (xC-xA)(uB-yA) |
    public float calculateArea() {
        float temp = 1.0F * (b.getX() - a.getX()) * (c.getY() - a.getY())
                - (c.getX() - a.getX()) * (b.getY() - a.getY());
        temp = temp > 0 ? temp : -temp;
        float area = temp / 2;
        return area;
    }

    public float calculatePerimeter() {
        float ab = a.khoangCach(b);
        float ac = a.khoangCach(c);
        float bc = b.khoangCach(c);
        return ab + ac + bc;
    }
    /* # Bussiness */

    public static void main(String[] args) {
        TamGiac tamGiac1 = new TamGiac(new Diem2D(12, 2), new Diem2D(-1, 9), new Diem2D(3, -2));
        System.out.println("Dien tich tam giac: " + tamGiac1.calculateArea());
        System.out.println("Chu vi tam giac: " + tamGiac1.calculatePerimeter());
    }
}
