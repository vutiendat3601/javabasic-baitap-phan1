package com.datvutech.answer.bai29.v1;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NhanVienVanPhong extends NhanVien {

    private int soNgayLamViec;

    private float troCap;

    /* #: Input, output */
    public void nhapSoNgayLamViec() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("Số ngày làm việc = ");
        soNgayLamViec = sysScanner.nextInt();
    }

    public void nhapTroCap() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("Trợ cấp = ");
        troCap = sysScanner.nextFloat();
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        nhapTroCap();
        nhapSoNgayLamViec();
    }
    /* # Input, output */

    @Override
    public float tinhLuong() {
        return luongCoBan + soNgayLamViec * 100_000 + troCap;
    }

    @Override
    public String toString() {
        return super.toString() +
                """
                        Số ngày làm việc: %d
                        Trợ cấp: %.0f"""
                        .formatted(soNgayLamViec, troCap);
    }

}
