package com.datvutech.answer.bai29.v1;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NhanVien {
    protected String ten;
    protected String ho;
    protected int namVaoLam;
    protected float luongCoBan;

    public abstract float tinhLuong();

    public void nhapThongTin() {
        Scanner sysScanner = AppScanner.getSystemScanner();

        System.out.print("Họ = ");
        ho = sysScanner.nextLine();

        System.out.print("Tên = ");
        ten = sysScanner.nextLine();

        System.out.print("Năm vào làm = ");
        namVaoLam = sysScanner.nextInt();

        System.out.print("Lương cơ bản = ");
        luongCoBan = sysScanner.nextFloat();
    }

    public void xuatThongTin() {
        System.out.println("Thông tin nhân viên: ");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return """
                Họ: %s
                Tên: %s
                Năm vào làm: %d
                Lương cơ bản: %.0f
                 """.formatted(ho, ten, namVaoLam, luongCoBan);
    }
}
