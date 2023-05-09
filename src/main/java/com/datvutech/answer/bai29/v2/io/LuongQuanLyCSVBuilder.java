package com.datvutech.answer.bai29.v2.io;

import static com.datvutech.util.NumberUtils.isNumeric;
import static java.util.Objects.isNull;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.answer.bai29.v2.employee.luong.common.ZeroLuong;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.ThuongExtra;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.TroCapExtra;
import com.datvutech.answer.bai29.v2.employee.luong.quanly.LuongQuanLy;

public class LuongQuanLyCSVBuilder {
    private Luong luong;

    private LuongQuanLyCSVBuilder() {
        luong = new ZeroLuong();
    }

    public static LuongQuanLyCSVBuilder builder() {
        return new LuongQuanLyCSVBuilder();
    }

    public LuongQuanLyCSVBuilder themLuongCoBan(String rLuongCoBan, String rHeSoChucVu) {
        if (!isNull(rHeSoChucVu) &&
                !isNull(rHeSoChucVu)) {

            if (isNumeric(rLuongCoBan) &&
                    isNumeric(rHeSoChucVu)) {
                luong = new LuongQuanLy(Float.parseFloat(rLuongCoBan),
                        Float.parseFloat(rHeSoChucVu));
            }

        }
        return this;
    }

    public LuongQuanLyCSVBuilder themThuongExtra(String rThuong) {
        if (!isNull(rThuong)) {

            if (isNumeric(rThuong)) {
                luong = new ThuongExtra(luong, Float.parseFloat(rThuong));
            }
        }
        return this;
    }

    public LuongQuanLyCSVBuilder themTroCapExtra(String rTroCap) {
        if (!isNull(rTroCap)) {

            if (isNumeric(rTroCap)) {
                luong = new TroCapExtra(luong, Float.parseFloat(rTroCap));
            }
        }
        return this;
    }

    public Luong build() {
        return luong;
    }
}
