package com.datvutech;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL in = Test.class.getResource("/bai29.csv");

        Reader fileReader = new FileReader(new File(in.toURI()));

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader("id", "hoVaTenDem", "ten", "ngaySinh", "namVaoLam", "loaiNhanVien")
                .setSkipHeaderRecord(true).build();
        System.out.format("|%-8s|%-20s|%-16s|%-16s|%-16s|%-16s|\n", "Id", "Họ và tên đệm", "Tên", "Ngày sinh",
                "Năm vào làm", "Loại nhân viên");
        System.out.println(String.format("+%-8s+%-20s+%-16s+%-16s+%-16s+%-16s+", "-",
                "-", "-", "-", "-", "-").replace(' ', '-'));
        Iterable<CSVRecord> records = csvFormat.parse(fileReader);
        for (CSVRecord r : records) {
            System.out.format("|%-8s|%-20s|%-16s|%-16s|%-16s|%-16s|\n", r.get("id"), r.get("hoVaTenDem"), r.get("ten"),
                    r.get("ngaySinh"), r.get("namVaoLam"), r.get("loaiNhanVien"));
        }
    }
}
