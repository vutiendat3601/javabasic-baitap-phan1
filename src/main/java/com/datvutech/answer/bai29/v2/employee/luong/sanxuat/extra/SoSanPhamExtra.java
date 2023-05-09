package com.datvutech.answer.bai29.v2.employee.luong.sanxuat.extra;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.LuongExtra;
import com.datvutech.util.NumberUtils;

public class SoSanPhamExtra extends LuongExtra {
    private int soSanPham;
    private float donGia;

    public SoSanPhamExtra(Luong luong, int soSanPham, float donGia) {
        super(luong.getProps());
        this.luong = luong;
        this.soSanPham = soSanPham;
        this.donGia = donGia;
        setProp("Số sản phẩm * Đơn giá", String.valueOf(soSanPham + " * " + NumberUtils.formatSeparateNum(donGia)));
    }

    @Override
    public float tinhLuong() {
        return luong.tinhLuong() + soSanPham * donGia;
    }

}
