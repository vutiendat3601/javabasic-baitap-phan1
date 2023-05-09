package com.datvutech.answer.bai29.v1;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVienSanXuat extends NhanVien {

    private int soSanPham;

    @Override
    public float tinhLuong() {
        return luongCoBan + soSanPham * 2_000;
    }

    /* #: Input, output */
    public void nhapSoSanPham() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("Số sản phẩm = ");
        soSanPham = sysScanner.nextInt();
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        nhapSoSanPham();
    }
    /* # Input, output */

    @Override
    public String toString() {
        return super.toString() +
                """
                        Số sản phẩm: %d
                                    """.formatted(soSanPham);
    }
}
