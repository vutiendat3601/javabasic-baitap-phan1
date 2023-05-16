package com.datvutech.answer.bai30.v1;

import lombok.Getter;

@Getter
public class MonLyThuyet extends MonHoc {
    private float diemTL; // Diem Tieu luan

    private float diemGK; // Diem Giua ky

    private float diemCK; // Diem Cuoi ky

    public MonLyThuyet(float diemTL, float diemGK, float diemCK) {
        this.diemTL = diemTL;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }

    @Override
    public float tinhDiemTB() {
        return diemTL * 0.2F + diemGK * 0.3F + diemCK * 0.5F;
    }

}
