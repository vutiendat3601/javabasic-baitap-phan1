package com.datvutech.answer.bai29.v2.io;

import static com.datvutech.util.NumberUtils.isNumeric;
import static java.util.Objects.isNull;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.answer.bai29.v2.employee.luong.common.ZeroLuong;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.BaoHiemXaHoiExtra;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.TroCapExtra;
import com.datvutech.answer.bai29.v2.employee.luong.vanphong.LuongVanPhong;
import com.datvutech.answer.bai29.v2.employee.luong.vanphong.extra.ChuyenCanExtra;

public class LuongVanPhongCSVBuilder {
    private Luong luong;

    private LuongVanPhongCSVBuilder() {
        luong = new ZeroLuong();
    }

    public static LuongVanPhongCSVBuilder builder() {
        return new LuongVanPhongCSVBuilder();
    }

    public LuongVanPhongCSVBuilder themLuongCoBan(String rLuongCoBan) {
        if (!isNull(rLuongCoBan)) {

            if (isNumeric(rLuongCoBan)) {
                luong = new LuongVanPhong(Float.parseFloat(rLuongCoBan));
            }

        }
        return this;
    }

    public LuongVanPhongCSVBuilder themChuyenCanExtra(String rSoNgayLamViec, String rDonGia) {
        if (!isNull(rSoNgayLamViec) && !isNull(rDonGia)) {

            if (isNumeric(rDonGia) && isNumeric(rSoNgayLamViec)) {
                luong = new ChuyenCanExtra(luong, Integer.parseInt(rSoNgayLamViec),
                        Float.parseFloat(rDonGia));
            }
        }
        return this;
    }

    public LuongVanPhongCSVBuilder themTroCapExtra(String rTroCap) {
        if (!isNull(rTroCap)) {

            if (isNumeric(rTroCap)) {
                luong = new TroCapExtra(luong, Float.parseFloat(rTroCap));
            }
        }
        return this;
    }

    public LuongVanPhongCSVBuilder themBaoHiemXaHoi(String rBaoHiemXaHoi) {
        if (!isNull(rBaoHiemXaHoi)) {

            if (isNumeric(rBaoHiemXaHoi)) {
                luong = new BaoHiemXaHoiExtra(luong, Float.parseFloat(rBaoHiemXaHoi));
            }
        }
        return this;
    }

    public Luong build() {
        return luong;
    }
}
