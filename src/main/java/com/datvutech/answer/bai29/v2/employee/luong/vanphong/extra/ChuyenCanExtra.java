package com.datvutech.answer.bai29.v2.employee.luong.vanphong.extra;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.LuongExtra;

public class ChuyenCanExtra extends LuongExtra {

    private int soNgayLamViec;
    private float donGia;

    public ChuyenCanExtra(Luong luong, int soNgayLamViec, float donGia) {
        super(luong.getProps());
        this.luong = luong;
        this.soNgayLamViec = soNgayLamViec;
        this.donGia = donGia;
        setProp("Số ngày làm việc * Đơn giá", String.valueOf(soNgayLamViec + " * " + donGia));
    }

    @Override
    public float tinhLuong() {
        return luong.tinhLuong() + soNgayLamViec * donGia;
    }

}
