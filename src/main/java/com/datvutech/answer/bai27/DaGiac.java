package com.datvutech.answer.bai27;

import java.util.Scanner;

import com.datvutech.answer.bai24.Diem2D;
import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DaGiac {

    // fields
    private int soCanh;
    private Diem2D[] diems;

    // constructors
    public DaGiac() {
    }

    public DaGiac(int soCanh, Diem2D[] diems) {
        this.soCanh = soCanh;
        this.diems = diems;
    }

    public DaGiac(DaGiac dg) {
        soCanh = dg.getSoCanh();
        diems = dg.getDiems();
    }

    // getters, setters
    public int getSoCanh() {
        return soCanh;
    }

    public void setSoCanh(int soCanh) {
        this.soCanh = soCanh;
    }

    public Diem2D[] getDiems() {
        return diems;
    }

    public void setDiems(Diem2D[] arr) {
        this.diems = arr;
    }

    // business code
    public void nhap() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        do {
            System.out.print("soCanh = ");
            soCanh = sysScanner.nextInt();
        } while (soCanh <= 2);

        diems = new Diem2D[soCanh];
        for (int i = 0; i < soCanh; i++) {
            System.out.println("Nhap canh thu " + (i + 1) + " = ");
            Diem2D diem = new Diem2D(0, 0);
            diem.nhapDiem();
            diems[i] = diem;
        }
    }

    public void xuat() {
        for (int i = 0; i < soCanh; i++) {
            System.out.print(diems[i]);
        }
    }

    public int tinhChuVi() {
        int cv = 0;
        for (int i = 0; i < soCanh - 1; i++) {
            cv += diems[i].khoangCach(diems[i + 1]);
        }
        return cv;
    }

    public Diem2D dinhXaNhat() {
        Diem2D dinh = diems[0];
        float xaNhat = diems[0].khoangCach();

        for (int i = 1; i < soCanh; i++) {
            float temp = diems[i].khoangCach();
            if (temp > xaNhat) {
                xaNhat = temp;
                dinh = diems[i];
            }
        }
        return dinh;
    }
}
