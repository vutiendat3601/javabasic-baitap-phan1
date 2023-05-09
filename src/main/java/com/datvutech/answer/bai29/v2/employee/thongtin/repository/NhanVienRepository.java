package com.datvutech.answer.bai29.v2.employee.thongtin.repository;

import java.util.List;
import java.util.Optional;

import com.datvutech.answer.bai29.v2.employee.thongtin.LoaiNhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.NhanVien;

public interface NhanVienRepository {
    int themNhanVien(List<NhanVien> nhanViens);

    boolean themNhanVien(NhanVien nhanVien);

    Optional<NhanVien> timNhanVien(String id);

    List<NhanVien> timNhanVien(LoaiNhanVien loaiNhanVien);

    List<NhanVien> timToanBoNhanVien();
}
