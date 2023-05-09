package com.datvutech.answer.bai29.v2.employee.luong.vanphong;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;

public class LuongVanPhong extends Luong {

    private float luongCoBan;

    public LuongVanPhong(float luongCoBan) {
        this.luongCoBan = luongCoBan;
        setProp("Lương cơ bản", String.valueOf(luongCoBan));
    }

    @Override
    public float tinhLuong() {
        return luongCoBan;
    }

}
