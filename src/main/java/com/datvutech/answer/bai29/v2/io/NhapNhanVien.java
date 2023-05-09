package com.datvutech.answer.bai29.v2.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.datvutech.answer.bai29.v2.employee.thongtin.LoaiNhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.NhanVien;
import com.datvutech.answer.bai29.v2.employee.thongtin.repository.NhanVienRepository;
import com.datvutech.answer.bai29.v2.employee.thongtin.repository.impl.NhanVienRepositoryCSV;

public class NhapNhanVien {
    private NhanVienRepository nhanVienRepo;

    public NhapNhanVien(NhanVienRepository nhanVienRepo) {
        this.nhanVienRepo = nhanVienRepo;
    }

    public void nhapNhanVienFromFile(File file) {
        try {
            Reader fileReader = new FileReader(file);
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader("id", "hoVaTenDem", "ten", "ngaySinh", "namVaoLam", "loaiNhanVien")
                    .setSkipHeaderRecord(true).build();

            Iterable<CSVRecord> records = csvFormat.parse(fileReader);
            List<NhanVien> nhanViens = new LinkedList<>();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (CSVRecord r : records) {
                String rId = r.get("id");
                String rHoVaTenDem = r.get("hoVaTenDem");
                String rTen = r.get("ten");
                String rNgaySinh = r.get("ngaySinh");
                String rNamVaoLam = r.get("namVaoLam");
                String rLoaiNhanVien = r.get("loaiNhanVien");
                LoaiNhanVien loaiNhanVien = identifyLoaiNhanVien(rLoaiNhanVien);
                if (loaiNhanVien != null) {
                    nhanViens.add(
                            new NhanVien(rId, rHoVaTenDem, rTen, dateFormat.parse(rNgaySinh),
                                    Integer.parseInt(rNamVaoLam), loaiNhanVien));
                }
            }
            nhanVienRepo.themNhanVien(nhanViens);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!, please try again");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private LoaiNhanVien identifyLoaiNhanVien(String loaiNhanVien) {
        switch (loaiNhanVien) {
            case "QL":
                return LoaiNhanVien.QUAN_LY;
            case "VP":
                return LoaiNhanVien.VAN_PHONG;
            case "SX":
                return LoaiNhanVien.SAN_XUAT;
        }
        return null;
    }

    public static void main(String[] args) throws URISyntaxException {
        NhanVienRepository nhanVienRepo = new NhanVienRepositoryCSV();
        NhapNhanVien nhapNhanVien = new NhapNhanVien(nhanVienRepo);
        NhapLuongStrategy nhapLuongStrategy = new NhapLuongStrategy(nhanVienRepo);

        URL nhapNhanVienURL = NhapNhanVien.class.getResource("/Bai29NhapNhanVien.csv");
        nhapNhanVien.nhapNhanVienFromFile(new File(nhapNhanVienURL.toURI()));

        URL qlStrategyURL = NhapLuongStrategy.class.getResource("/Bai29QLStrategy.csv");
        nhapLuongStrategy.nhapQuanLyStrategy(new File(qlStrategyURL.toURI()));

        List<NhanVien> nhanViens = nhanVienRepo.timToanBoNhanVien();
        nhanViens.forEach(nv -> {
            System.out.println(nv.getLuongStrategy().tinhLuong());
        });
        System.out.println("TEMP");
    }
}
