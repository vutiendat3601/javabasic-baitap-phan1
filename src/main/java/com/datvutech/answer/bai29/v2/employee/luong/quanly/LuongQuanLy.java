package com.datvutech.answer.bai29.v2.employee.luong.quanly;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.util.NumberUtils;

public class LuongQuanLy extends Luong {
    private float luongCoBan;
    private float heSoChucVu;

    public LuongQuanLy(float luongCoBan, float heSoChucVu) {
        this.luongCoBan = luongCoBan;
        this.heSoChucVu = heSoChucVu;
        setProp("Lương cơ bản * Hệ số chức vụ", String.valueOf(
                NumberUtils.formatSeparateNum(luongCoBan) +
                        " * " +
                        NumberUtils.formatSeparateNum(heSoChucVu)));

    }

    @Override
    public float tinhLuong() {
        return luongCoBan * heSoChucVu;
    }
}
