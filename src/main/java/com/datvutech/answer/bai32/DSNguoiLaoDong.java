package com.datvutech.answer.bai32;

import java.util.ArrayList;
import java.util.List;

public class DSNguoiLaoDong {
    private List<NguoiLaoDong> dsNLD;

    public DSNguoiLaoDong() {
        dsNLD = new ArrayList<>();
    }

    public void nhap() {
    }

    public void xuat() {
    }

    public double tinhTongLuong() {
        double sumSalary = 0;
        for (NguoiLaoDong nld : dsNLD) {
            sumSalary += nld.tinhLuong();
        }
        return sumSalary;
    }
}
