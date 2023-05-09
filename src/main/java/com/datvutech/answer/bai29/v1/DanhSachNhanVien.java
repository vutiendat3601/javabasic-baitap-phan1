package com.datvutech.answer.bai29.v1;

import java.util.LinkedList;
import java.util.List;

public class DanhSachNhanVien {
    private List<NhanVien> dsNhanVien;

    public DanhSachNhanVien() {
        dsNhanVien = new LinkedList<>();
    }

    public boolean themNhanVien(NhanVien nhanVien) {
        dsNhanVien.add(nhanVien);
        return true;
    }

    public float tinhTongLuong() {
        float total = 0F;
        for (NhanVien nv : dsNhanVien) {
            total += nv.tinhLuong();
        }
        return total;
    }

    public void xuatDanhSachNhanVien() {
        System.out.println(String.format("+%-8s+%-8s+%-16s+%-16s+%-16s+", "-",
                "-", "-", "-", "-").replace(' ', '-'));
        System.out.format("|%-8s|%-8s|%-16s|%-16s|%-16s|\n", "Họ",
                "Tên", "Năm vào làm", "Lương cơ bản", "Loại nhân viên");
        System.out.println(String.format("+%-8s+%-8s+%-16s+%-16s+%-16s+", "-",
                "-", "-", "-", "-").replace(' ', '-'));
        dsNhanVien.forEach(nv -> {
            System.out.format("|%-8s|%-8s|%-16d|%-16.2f|%-16s|\n", nv.getHo(),
                    nv.getTen(), nv.getNamVaoLam(), nv.getLuongCoBan(),
                    nv.getClass().getSimpleName());
        });
        System.out.println(String.format("+%-8s+%-8s+%-16s+%-16s+%-16s+", "-",
                "-", "-", "-", "-").replace(' ', '-'));

    }

    public float tinhTongLuongTheoLoaiNhanVien(String loai) {
        float total = 0F;
        Class<?> classType = null;
        switch (loai) {
            case "VanPhong":
                classType = NhanVienVanPhong.class;
                break;
            case "QuanLy":
                classType = NhanVienQuanLy.class;
                break;
            case "SanXuat":
                classType = NhanVienSanXuat.class;
                break;
        }
        for (NhanVien nv : dsNhanVien) {
            if (nv.getClass() == classType) {
                total += nv.tinhLuong();
            }
        }
        return total;
    }

}
