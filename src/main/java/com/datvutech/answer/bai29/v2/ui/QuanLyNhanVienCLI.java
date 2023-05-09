package com.datvutech.answer.bai29.v2.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JFileChooser;

import com.datvutech.answer.bai29.v2.employee.thongtin.LoaiNhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.NhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.repository.NhanVienRepository;
import com.datvutech.answer.bai29.v2.employee.thongtin.repository.impl.NhanVienRepositoryCSV;
import com.datvutech.answer.bai29.v2.io.NhapLuongStrategy;
import com.datvutech.answer.bai29.v2.io.NhapNhanVien;
import com.datvutech.util.AppScanner;
import com.datvutech.util.FileUtils;
import com.datvutech.util.NumberUtils;

/***
 * 1. Nhập thông tin của các nhân viên để phục vụ cho việc tính lương.
 * 2. Xuất thông tin của các nhân viên.
 * 3. Tính tổng lương của công ty và tổng lương của từng loại nhân viên
 */

public class QuanLyNhanVienCLI {
    NhanVienRepository nhanVienRepo;

    /* #: CLI */
    public QuanLyNhanVienCLI() {
        nhanVienRepo = new NhanVienRepositoryCSV();
    }

    public int showMenu() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.println("""
                1. Nhập thông tin của nhân viên từ file CSV.
                2. Nhập thông tin tính lương nhân viên từ file CSV.
                3. Xuất thông tin danh sách nhân viên.
                4. Tính tổng lương của công ty
                5. Tính tổng lương của từng loại nhân viên
                6. Xuất thông tin tính lương nhân viên
                0. Thoát
                    """);
        System.out.print("Lựa chọn = ");
        int c = sysScanner.nextInt();
        return c;
    }

    public boolean processMenu(final int c) {
        System.out.println("\n#############################################\n");
        switch (c) {
            case 1:
                xuLyNhapThongTinNhanVienTuFileCSV();
                break;
            case 2:
                xuLyNhapThongTinTinhLuong();
                break;
            case 3:
                xuLyXuatDanhSachNhanVien();
                break;
            case 4:
                xuLyTinhTongLuongCongTy();
                break;
            case 5:
                xuLyTinhTongLuongCongTyTheoLoaiNhanVien();
                break;
            case 6:
                xuLyXuatThongTinTinhLuongNhanVien();
                break;
        }
        System.out.println("\n#############################################\n");
        return c != 0;
    }
    /* # CLI */

    /* #: Bussiness */
    public void run() {
        boolean running = true;
        while (running) {
            int c = showMenu();
            running = processMenu(c);
        }
    }

    /* 1. Xử lý nhập thông tin nhân viên từ file CSV */
    private void xuLyNhapThongTinNhanVienTuFileCSV() {
        NhapNhanVien nhapNhanVien = new NhapNhanVien(nhanVienRepo);

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            nhapNhanVien.nhapNhanVienFromFile(new File(filePath));
        }
    }

    // 2. Xử lý nhập thông tin tin để tính lương
    private void xuLyNhapThongTinTinhLuong() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.println("""
                1. Nhập lương quản lý
                2. Nhập lương văn phòng
                3. Nhập lương sản xuất
                0. Quay lại
                """);
        int c = -1;
        do {
            System.out.print("Lựa chọn = ");
            c = sysScanner.nextInt();
        } while (c < 0 && c > 3);
        if (c == 0) {
            return;
        }
        Optional<File> inpFile = FileUtils.showFileOpenDialog();
        if (inpFile.isPresent()) {
            NhapLuongStrategy luongStrategy = new NhapLuongStrategy(nhanVienRepo);
            switch (c) {
                case 1:
                    luongStrategy.nhapQuanLyStrategy(inpFile.get());
                    break;
                case 2:
                    luongStrategy.nhapVanPhongStrategy(inpFile.get());
                    break;
                case 3:
                    luongStrategy.nhapSanXuatStrategy(inpFile.get());
                    break;
            }
        }
    }

    // 3. Xuất thông tin danh sách nhân viên
    public void xuLyXuatDanhSachNhanVien() {
        List<NhanVien> nhanViens = nhanVienRepo.timToanBoNhanVien();
        // Header
        System.out.println(String.format("+ %-10s + %-32s + %-8s + %-12s + %-16s +", "-", "-",
                "-", "-", "-", "-").replace(' ', '-'));
        System.out.format("| %-10s | %-32s | %-8s | %-12s | %-16s |\n", "Id", "Họ và tên đệm",
                "Tên", "Năm vào làm", "Loại nhân viên");
        System.out.println(String.format("+ %-10s + %-32s + %-8s + %-12s + %-16s +", "-", "-",
                "-", "-", "-", "-").replace(' ', '-'));

        // Body
        nhanViens.forEach(nv -> {
            System.out.format("| %-10s | %-32s | %-8s | %-12d | %-16s |\n", nv.getId(), nv.getHoTenDem(),
                    nv.getTen(), nv.getNamVaoLam(), nv.getLoaiNhanVien());
        });

        // Footer
        System.out.println(String.format("+ %-10s + %-32s + %-8s + %-12s + %-16s +", "-", "-",
                "-", "-", "-", "-").replace(' ', '-'));

    }

    // 3. Tính tổng lương công ty
    public void xuLyTinhTongLuongCongTy() {
        List<NhanVien> nhanViens = nhanVienRepo.timToanBoNhanVien();
        List<Float> luongValues = nhanViens.stream().map((nv) -> nv.getLuongStrategy().tinhLuong()).toList();

        float minLuong = luongValues.stream().min(Float::compare).get();
        float maxLuong = luongValues.stream().max(Float::compare).get();
        float tongLuong = luongValues.stream().reduce(0F, Float::sum);

        // Header
        System.out.println(String.format("+ %-37s +", "-").replace(' ', '-'));

        // Body
        final String FORMAT = "| %-18s | %16s |\n";
        System.out.format(FORMAT, "Lương thấp nhất ", NumberUtils.formatSeparateNum(minLuong));
        System.out.format(FORMAT, "Lương cao nhất ", NumberUtils.formatSeparateNum(maxLuong));
        System.out.format(FORMAT, "Tổng lương ", NumberUtils.formatSeparateNum(tongLuong));

        // Footer
        System.out.println(String.format("+ %-37s +", "-").replace(' ', '-'));
    }

    // 4. Tính tổng lương công ty theo loại nhân viên
    public void xuLyTinhTongLuongCongTyTheoLoaiNhanVien() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.println("""
                1. Tổng lương quản lý
                2. Tổng lương văn phòng
                3. Tổng lương sản xuất
                0. Quay lại
                    """);
        int c = -1;
        do {
            System.out.print("Lựa chọn = ");
            c = sysScanner.nextInt();
        } while (c < 0 && c > 3);
        if (c == 0) {
            return;
        }
        List<NhanVien> nhanViens = new ArrayList<>();
        String headerTitle = "";
        switch (c) {
            case 1:
                nhanViens = nhanVienRepo.timNhanVien(LoaiNhanVien.QUAN_LY);
                headerTitle = LoaiNhanVien.QUAN_LY.toString();
                break;
            case 2:
                nhanViens = nhanVienRepo.timNhanVien(LoaiNhanVien.VAN_PHONG);
                headerTitle = LoaiNhanVien.VAN_PHONG.toString();
                break;
            case 3:
                nhanViens = nhanVienRepo.timNhanVien(LoaiNhanVien.SAN_XUAT);
                headerTitle = LoaiNhanVien.SAN_XUAT.toString();
                break;
        }
        List<Float> luongValues = nhanViens.stream().map((nv) -> nv.getLuongStrategy().tinhLuong()).toList();

        float minLuong = luongValues.stream().min(Float::compare).get();
        float maxLuong = luongValues.stream().max(Float::compare).get();
        float tongLuong = luongValues.stream().reduce(0F, Float::sum);

        // Header
        System.out.println(String.format("+ %-37s +", "-").replace(' ', '-'));
        System.out.println(String.format("| %-37s |", "LƯƠNG " + headerTitle.toUpperCase()));
        System.out.println(String.format("+ %-37s +", "-").replace(' ', '-'));

        // Body
        final String FORMAT = "| %-18s | %16s |\n";
        System.out.format(FORMAT, "Lương thấp nhất ", NumberUtils.formatSeparateNum(minLuong));
        System.out.format(FORMAT, "Lương cao nhất ", NumberUtils.formatSeparateNum(maxLuong));
        System.out.format(FORMAT, "Tổng lương ", NumberUtils.formatSeparateNum(tongLuong));

        // Footer
        System.out.println(String.format("+ %-37s +", "-").replace(' ', '-'));
    }

    public void xuLyXuatThongTinTinhLuongNhanVien() {
        List<NhanVien> nhanViens = nhanVienRepo.timToanBoNhanVien();
        System.out.println(String.format("+ %-10s + %-28s + %-16s + %-90s +", "-", "-", "-", "-")
                .replace(' ', '-'));
        System.out.format("| %-10s | %-28s | %-16s | %-90s |\n", "Id", "Họ và tên", "Loại nhân viên",
                "Thuộc tính liên quan đến lương");
        System.out.println(String.format("+ %-10s + %-28s + %-16s + %-90s +", "-", "-", "-", "-")
                .replace(' ', '-'));

        nhanViens.forEach(nv -> {
            // Luong luongStrategy = nv.getLuongStrategy();
            System.out.format("| %-10s | %-28s | %-16s | %-90s |\n",
                    nv.getId(),
                    nv.getHoTenDem() + " " + nv.getTen(),
                    nv.getLoaiNhanVien(),
                    nv.getLuongStrategy());
        });
        System.out.println(String.format("+ %-10s + %-28s + %-16s + %-90s +", "-", "-", "-", "-")
                .replace(' ', '-'));
    }
    /* # Bussiness */

    public static void main(String[] args) {
        QuanLyNhanVienCLI cli = new QuanLyNhanVienCLI();
        cli.run();
    }
}
