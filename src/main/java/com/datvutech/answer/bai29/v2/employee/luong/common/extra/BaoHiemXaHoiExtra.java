package com.datvutech.answer.bai29.v2.employee.luong.common.extra;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.util.NumberUtils;

public class BaoHiemXaHoiExtra extends LuongExtra {
    private float baoHiemXaHoi;

    public BaoHiemXaHoiExtra(Luong luong, float baoHiemXaHoi) {
        super(luong.getProps());
        this.luong = luong;
        this.baoHiemXaHoi = baoHiemXaHoi;
        setProp("Bảo hiểm xã hội", String.valueOf(NumberUtils.formatSeparateNum(baoHiemXaHoi)));
    }

    @Override
    public float tinhLuong() {
        return luong.tinhLuong() - baoHiemXaHoi;
    }

}
