package com.datvutech.answer.bai29.v2.employee.thongtin.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.datvutech.answer.bai29.v2.employee.thongtin.LoaiNhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.NhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.repository.NhanVienRepository;

public class NhanVienRepositoryCSV implements NhanVienRepository {

    private List<NhanVien> nhanViens;

    public NhanVienRepositoryCSV() {
        nhanViens = new ArrayList<>();
    }

    @Override
    public int themNhanVien(List<NhanVien> nhanViens) {
        if (this.nhanViens.isEmpty()) {
            this.nhanViens.addAll(nhanViens);
        }
        int success = 0;
        for (NhanVien nv : nhanViens) {
            if (timNhanVien(nv.getId()).isEmpty()) {
                this.nhanViens.add(nv);
                success++;
            }
        }
        return success;
    }

    @Override
    public boolean themNhanVien(NhanVien nhanVien) {
        nhanViens.add(nhanVien);
        return true;
    }

    @Override
    public Optional<NhanVien> timNhanVien(String id) {
        return nhanViens.stream().filter((nv) -> nv.getId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public List<NhanVien> timNhanVien(LoaiNhanVien loaiNhanVien) {
        return nhanViens.stream().filter((nv) -> nv.getLoaiNhanVien() == loaiNhanVien).toList();
    }

    @Override
    public List<NhanVien> timToanBoNhanVien() {
        return List.copyOf(nhanViens);
    }

}
