package com.datvutech.answer.bai30.v1;

public class MonDoAn extends MonHoc {
    private float diemGVHD; // Diem giang vien huong dan
    private float diemGVPB; // Diem giang vien phan bien

    public MonDoAn(float diemGVHD, float diemGVPB) {
        this.diemGVHD = diemGVHD;
        this.diemGVPB = diemGVPB;
    }

    @Override
    public float tinhDiemTB() {
        return (diemGVHD + diemGVPB) / 2;
    }
}
