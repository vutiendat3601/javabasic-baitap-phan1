package com.datvutech.answer.bai29.v2.employee.luong.common.extra;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.util.NumberUtils;

public class TroCapExtra extends LuongExtra {
    private float troCap;

    public TroCapExtra(Luong luong, float troCap) {
        super(luong.getProps());
        this.luong = luong;
        this.troCap = troCap;
        setProp("Trợ cấp", String.valueOf(NumberUtils.formatSeparateNum(troCap)));
    }

    @Override
    public float tinhLuong() {
        return luong.tinhLuong() + troCap;
    }
}
