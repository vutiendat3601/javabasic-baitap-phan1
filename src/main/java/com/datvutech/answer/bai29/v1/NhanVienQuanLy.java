package com.datvutech.answer.bai29.v1;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NhanVienQuanLy extends NhanVien {

    private int heSoChucVu;

    private float thuong;
    /* #: Input, output */

    public void nhapHeSoChucVu() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("Hệ số chức vụ = ");
        heSoChucVu = sysScanner.nextInt();
    }

    public void nhapThuong() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("Thưởng = ");
        thuong = sysScanner.nextFloat();
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        nhapHeSoChucVu();
        nhapThuong();
    }
    /* # Input, output */

    @Override
    public float tinhLuong() {
        return luongCoBan * heSoChucVu + thuong;
    }

    @Override
    public String toString() {
        return super.toString() +
                """
                        He so chuc vuc: %d
                        Thuong: %.0f
                        """.formatted(heSoChucVu, thuong);
    }

}
