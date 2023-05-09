package com.datvutech.answer.bai29.v1;

import java.util.Scanner;

import com.datvutech.util.AppScanner;

public class QuanLyNhanVien {
    private DanhSachNhanVien dsNhanVien;

    public QuanLyNhanVien() {
        dsNhanVien = new DanhSachNhanVien();
    }

    public int hienThiMenu() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("""
                1. Danh sách nhân viên
                2. Thêm nhân viên
                3. Tính lương
                0. Thoát
                """);
        System.out.print("Lựa chọn = ");
        int c = sysScanner.nextInt();
        return c;
    }

    public boolean xuLyMenu(final int c) {
        System.out.println("\n#############################################\n");
        switch (c) {
            case 1:
                xuLyDanhSachNhanVien();
                break;
            case 2:
                xuLyThemNhanVien();
                break;
            case 3:
                xuLyTinhLuong();
                break;
        }
        System.out.println("\n#############################################\n");
        return c != 0;
    }

    // 1. Danh sách nhân viên
    private void xuLyDanhSachNhanVien() {
        System.out.println("--- Danh sách nhân viên ---------------------------------");
        dsNhanVien.xuatDanhSachNhanVien();
    }

    // 2. Thêm nhân viên
    private void xuLyThemNhanVien() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("""
                Chọn loại nhân viên muốn thêm
                1. Nhân viên sản xuất
                2. Nhân viên văn phòng
                3. Nhân viên quản lý
                    """);
        System.out.print("Lựa chọn = ");
        int c = sysScanner.nextInt();
        sysScanner.nextLine();
        NhanVien nhanVien = null;
        switch (c) {
            case 1:
                nhanVien = new NhanVienSanXuat();
                break;
            case 2:
                nhanVien = new NhanVienVanPhong();
                break;
            case 3:
                nhanVien = new NhanVienQuanLy();
                break;
        }
        nhanVien.nhapThongTin();
        boolean success = dsNhanVien.themNhanVien(nhanVien);
        if (success) {
            System.out.println("Thêm nhân viên thành công!!!");
        }
    }

    // 3. Tính lương
    public void xuLyTinhLuong() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("""
                Chọn loại nhân viên muốn thêm
                1. Tính tổng lương
                2. Tính lương theo loại nhân viên
                    """);
        System.out.print("Lựa chọn = ");
        int c = sysScanner.nextInt();
        sysScanner.nextLine();
        System.out.println("--- Tổng lương ---------------------------------");
        switch (c) {
            case 1:
                System.out.format("Tổng lương: %.2f\n", dsNhanVien.tinhTongLuong());
                break;
            case 2:
                System.out.print("""
                        Chọn loại nhân viên muốn tính tổng lương
                        1. Nhân viên sản xuất
                        2. Nhân viên văn phòng
                        3. Nhân viên quản lý
                            """);
                c = sysScanner.nextInt();
                switch (c) {
                    case 1:
                        System.out.format(
                                "Tổng lương nhân viên sản xuất $.2f\n",
                                dsNhanVien.tinhTongLuongTheoLoaiNhanVien("SanXuat"));
                        break;
                    case 2:
                        System.out.format("Tổng lương nhân viên văn phòng $.2f\n",
                                dsNhanVien.tinhTongLuongTheoLoaiNhanVien("VanPhong"));
                        break;
                    case 3:
                        System.out.format(
                                "Tổng lương nhân viên quản lý $.2f\n",
                                dsNhanVien.tinhTongLuongTheoLoaiNhanVien("QuanLy"));
                        break;
                }
                break;
        }

    }

    public void run() {
        boolean running = true;
        while (running) {
            int c = hienThiMenu();
            running = xuLyMenu(c);
        }
    }

    public static void main(String[] args) {
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        qlnv.run();
    }
}
