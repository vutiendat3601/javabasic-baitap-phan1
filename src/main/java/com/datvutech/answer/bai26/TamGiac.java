package com.datvutech.answer.bai26;

import java.util.Scanner;

import com.datvutech.answer.bai24.Diem2D;
import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TamGiac {
    private Diem2D a;
    private Diem2D b;
    private Diem2D c;

    public TamGiac(Diem2D a, Diem2D b, Diem2D c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

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
}
