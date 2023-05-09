package com.datvutech.answer.bai29.v2.employee.luong.sanxuat;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.util.NumberUtils;

import lombok.Getter;

@Getter
public class LuongSanXuat extends Luong {
    private float luongCoBan;

    public LuongSanXuat(float luongCoBan) {
        this.luongCoBan = luongCoBan;
        setProp("Lương cơ bản", String.valueOf(NumberUtils.formatSeparateNum(luongCoBan)));
    }

    @Override
    public float tinhLuong() {
        return luongCoBan;
    }

}
