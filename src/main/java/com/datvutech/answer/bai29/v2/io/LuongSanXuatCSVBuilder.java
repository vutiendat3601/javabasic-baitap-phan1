package com.datvutech.answer.bai29.v2.io;

import static com.datvutech.util.NumberUtils.isNumeric;
import static java.util.Objects.isNull;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.answer.bai29.v2.employee.luong.common.ZeroLuong;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.BaoHiemXaHoiExtra;
import com.datvutech.answer.bai29.v2.employee.luong.common.extra.TroCapExtra;
import com.datvutech.answer.bai29.v2.employee.luong.sanxuat.LuongSanXuat;
import com.datvutech.answer.bai29.v2.employee.luong.sanxuat.extra.SoSanPhamExtra;

public class LuongSanXuatCSVBuilder {
    private Luong luong;

    private LuongSanXuatCSVBuilder() {
        luong = new ZeroLuong();
    }

    public static LuongSanXuatCSVBuilder builder() {
        return new LuongSanXuatCSVBuilder();
    }

    public LuongSanXuatCSVBuilder themLuongCoBan(String rLuongCoBan) {
        if (!isNull(rLuongCoBan)) {

            if (isNumeric(rLuongCoBan)) {
                luong = new LuongSanXuat(Float.parseFloat(rLuongCoBan));
            }

        }
        return this;
    }

    public LuongSanXuatCSVBuilder themSoSanPhamExtra(String rSoSanPham, String rDonGia) {
        if (!isNull(rDonGia) && !isNull(rSoSanPham)) {

            if (isNumeric(rDonGia) && isNumeric(rSoSanPham)) {
                luong = new SoSanPhamExtra(luong, Integer.parseInt(rSoSanPham),
                        Float.parseFloat(rDonGia));
            }
        }
        return this;
    }

    public LuongSanXuatCSVBuilder themTroCapExtra(String rTroCap) {
        if (!isNull(rTroCap)) {

            if (isNumeric(rTroCap)) {
                luong = new TroCapExtra(luong, Float.parseFloat(rTroCap));
            }
        }
        return this;
    }

    public LuongSanXuatCSVBuilder themBaoHiemXaHoi(String rBaoHiemXaHoi) {
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
