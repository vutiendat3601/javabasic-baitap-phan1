package com.datvutech.answer.bai30.v1;

import lombok.Getter;

@Getter
public class MonThucHanh extends MonHoc {
    private float diemKT1; // Diem Kiem tra 1

    private float diemKT2; // Diem Kiem tra 2

    private float diemKT3; // Diem Kiem tra 3

    private float diemKT4; // Diem Kiem tra 4

    public MonThucHanh(float diemKT1, float diemKT2, float diemKT3, float diemKT4) {
        this.diemKT1 = diemKT1;
        this.diemKT2 = diemKT2;
        this.diemKT3 = diemKT3;
        this.diemKT4 = diemKT4;
    }

    @Override
    public float tinhDiemTB() {
        return (diemKT1 + diemKT2 + diemKT3 + diemKT4) / 4;
    }

}
