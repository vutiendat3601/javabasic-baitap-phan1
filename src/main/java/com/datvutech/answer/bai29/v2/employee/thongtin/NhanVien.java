package com.datvutech.answer.bai29.v2.employee.thongtin;

import java.util.Date;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.answer.bai29.v2.employee.luong.common.ZeroLuong;

import lombok.Getter;
import lombok.Setter;

@Getter
public class NhanVien {
    private String id;
    private String hoTenDem;
    private String ten;
    private Date birthday;
    private int namVaoLam;
    private LoaiNhanVien loaiNhanVien;

    @Setter
    private Luong luongStrategy;

    public NhanVien() {
        luongStrategy = new ZeroLuong();
    }

    public NhanVien(String id, String hoVaTenDem, String ten, Date birthday, int namVaoLam, LoaiNhanVien loaiNhanVien) {
        this();
        this.id = id;
        this.hoTenDem = hoVaTenDem;
        this.ten = ten;
        this.birthday = birthday;
        this.namVaoLam = namVaoLam;
        this.loaiNhanVien = loaiNhanVien;
    }

}
