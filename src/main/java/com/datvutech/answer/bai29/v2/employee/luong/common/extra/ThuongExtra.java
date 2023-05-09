package com.datvutech.answer.bai29.v2.employee.luong.common.extra;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.util.NumberUtils;

public class ThuongExtra extends LuongExtra {
    private float thuong;

    public ThuongExtra(Luong luong, float thuong) {
        super(luong.getProps());
        this.luong = luong;
        this.thuong = thuong;
        setProp("Thưởng", String.valueOf(NumberUtils.formatSeparateNum(thuong)));
    }

    @Override
    public float tinhLuong() {
        return luong.tinhLuong() + thuong;
    }
}
