package com.datvutech.answer.bai32;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class NguoiLaoDong {
    protected String maSo;

    protected String hoTen;

    protected int namSinh;

    public abstract double tinhLuong();

    public abstract void nhap();

    public abstract void xuat();
}
