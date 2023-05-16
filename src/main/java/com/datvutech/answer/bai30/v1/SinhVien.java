package com.datvutech.answer.bai30.v1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SinhVien {
    private List<MonHoc> monHocs;

    public SinhVien() {
        monHocs = new LinkedList<>();
    }

    public List<Float> tinhDiemTrungBinh() {
        List<Float> diemTBs = new ArrayList<>();
        for (MonHoc mh : monHocs) {
            diemTBs.add(mh.tinhDiemTB());
        }
        return diemTBs;
    }
}
