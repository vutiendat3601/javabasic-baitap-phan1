package com.datvutech.answer.bai29.v2.employee.thongtin;

public enum LoaiNhanVien {
    QUAN_LY("Quản lý"), SAN_XUAT("Sản xuất"), VAN_PHONG("Văn phòng");

    private String value;

    LoaiNhanVien(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
