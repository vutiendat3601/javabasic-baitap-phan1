package com.datvutech.answer.bai29.v2.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;
import com.datvutech.answer.bai29.v2.employee.thongtin.LoaiNhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.NhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.repository.NhanVienRepository;

public class NhapLuongStrategy {
    private NhanVienRepository nhanVienRepo;

    public NhapLuongStrategy(NhanVienRepository nhanVienRepo) {
        this.nhanVienRepo = nhanVienRepo;
    }

    public void nhapQuanLyStrategy(File file) {
        try {
            CSVFormat csvFormat = createCSVFormat("nhanVienId", "luongCoBan", "heSoChucVu", "thuong", "troCap");

            Reader fileReader = new FileReader(file);
            Iterable<CSVRecord> records = csvFormat.parse(fileReader);
            for (CSVRecord r : records) {
                String rNhanVienId = r.get("nhanVienId");
                NhanVien nhanVien = nhanVienRepo.timNhanVien(rNhanVienId).orElse(null);
                if (nhanVien != null && nhanVien.getLoaiNhanVien() == LoaiNhanVien.QUAN_LY) {
                    String rLuongCoBan = r.get("luongCoBan");
                    String rHeSoChucVu = r.get("heSoChucVu");
                    String rThuong = r.get("thuong");
                    String rTroCap = r.get("troCap");

                    Luong luong = LuongQuanLyCSVBuilder.builder()
                            .themLuongCoBan(rLuongCoBan, rHeSoChucVu)
                            .themThuongExtra(rThuong)
                            .themTroCapExtra(rTroCap)
                            .build();
                    nhanVien.setLuongStrategy(luong);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!, please try again");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void nhapVanPhongStrategy(File file) {
        try {
            CSVFormat csvFormat = createCSVFormat("nhanVienId", "luongCoBan",
                    "donGia", "soNgayLamViec", "troCap", "baoHiemXaHoi");

            Reader fileReader = new FileReader(file);
            Iterable<CSVRecord> records = csvFormat.parse(fileReader);
            for (CSVRecord r : records) {
                String rNhanVienId = r.get("nhanVienId");
                NhanVien nhanVien = nhanVienRepo.timNhanVien(rNhanVienId).orElse(null);
                if (nhanVien != null && nhanVien.getLoaiNhanVien() == LoaiNhanVien.VAN_PHONG) {
                    String rLuongCoBan = r.get("luongCoBan");
                    String rDonGia = r.get("donGia");
                    String rSoNgayLamViec = r.get("soNgayLamViec");
                    String rTroCap = r.get("troCap");
                    String rBaoHiemXaHoi = r.get("baoHiemXaHoi");

                    Luong luong = LuongVanPhongCSVBuilder.builder()
                            .themLuongCoBan(rLuongCoBan)
                            .themChuyenCanExtra(rSoNgayLamViec, rDonGia)
                            .themTroCapExtra(rTroCap)
                            .themBaoHiemXaHoi(rBaoHiemXaHoi)
                            .build();
                    nhanVien.setLuongStrategy(luong);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!, please try again");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void nhapSanXuatStrategy(File file) {
        try {
            CSVFormat csvFormat = createCSVFormat("nhanVienId", "luongCoBan",
                    "donGia", "soSanPham", "troCap", "baoHiemXaHoi");

            Reader fileReader = new FileReader(file);
            Iterable<CSVRecord> records = csvFormat.parse(fileReader);
            for (CSVRecord r : records) {
                String rNhanVienId = r.get("nhanVienId");
                NhanVien nhanVien = nhanVienRepo.timNhanVien(rNhanVienId).orElse(null);
                if (nhanVien != null && nhanVien.getLoaiNhanVien() == LoaiNhanVien.SAN_XUAT) {
                    String rLuongCoBan = r.get("luongCoBan");
                    String rDonGia = r.get("donGia");
                    String rSoSanPham = r.get("soSanPham");
                    String rTroCap = r.get("troCap");
                    String rBaoHiemXaHoi = r.get("baoHiemXaHoi");

                    Luong luong = LuongSanXuatCSVBuilder.builder()
                            .themLuongCoBan(rLuongCoBan)
                            .themSoSanPhamExtra(rSoSanPham, rDonGia)
                            .themTroCapExtra(rTroCap)
                            .themBaoHiemXaHoi(rBaoHiemXaHoi)
                            .build();
                    nhanVien.setLuongStrategy(luong);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!, please try again");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private CSVFormat createCSVFormat(String... headers) {
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setSkipHeaderRecord(true).build();
        return csvFormat;
    }
}
