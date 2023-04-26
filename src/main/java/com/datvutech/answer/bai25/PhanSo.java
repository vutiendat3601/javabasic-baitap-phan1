package com.datvutech.answer.bai25;

import java.util.Optional;
import java.util.Scanner;

import com.datvutech.util.AppScanner;
import com.datvutech.util.NumberUtils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    // Hàm nhập giá trị cho 1 phân số.
    // Nếu phân số vừa nhập có mẫu số = 0 thì yêu cầu nhập lại.
    public void nhapPhanSo() {
        Scanner sysScanner = AppScanner.getSystemScanner();
        System.out.print("tuSo = ");
        tuSo = sysScanner.nextInt();
        int temp = 0;
        do {
            System.out.print("mauSo = ");
            temp = sysScanner.nextInt();
        } while (temp == 0);
        mauSo = temp;
    }

    // Hàm hiển thị phân số theo dạng tu/mau hoặc -tu/mau.
    // Yêu cầu: nếu tử số =0 thì chỉ in ra số 0, nếu mẫu số =1 thì chỉ in ra tử số.
    public void hienThi() {
        System.out.print("Gia tri: ");
        if (tuSo == 0) {
            System.out.println(0);
        } else if (mauSo == 1) {
            System.out.println(tuSo);
        } else {
            System.out.println(tuSo + "/" + mauSo);
        }
    }

    // Hàm nghịch đảo phân số (làm thay đổi giá trị phân số) void nghichDao();
    public void nghichDao() {
        if (tuSo == 0) {
            System.out.println("So 0 khong co so nghich dao!");
        }
        int temp = tuSo;
        tuSo = mauSo;
        mauSo = temp;
    }

    // Hàm tính ra phân số nghịch đảo của 1 phân số (phân số sẽ giữ nguyên nhưng hàm
    // trả về giá trị là phân số nghịch đảo của nó).
    public PhanSo giaTriNghichDao() {
        if (tuSo == 0) {
            System.out.println("So 0 khong co so nghich dao!");
            return null; // Bad design
        }
        return new PhanSo(mauSo, tuSo);
    }

    public Optional<PhanSo> giaTriNghichDao2() {
        if (tuSo == 0) {
            System.out.println("So 0 khong co so nghich dao!");
            return Optional.empty();
        }
        return Optional.of(new PhanSo(mauSo, tuSo));
    }

    public double giaTriThuc() {
        return ((float) tuSo) / mauSo;
    }

    public boolean lonHon(PhanSo a) {
        return tuSo * a.mauSo > a.tuSo * mauSo;
    }

    public PhanSo cong(PhanSo a) {
        int ucln = NumberUtils.gcd(mauSo, a.mauSo);
        PhanSo res = new PhanSo(
                tuSo * (ucln / mauSo) + a.tuSo * (ucln / a.mauSo), // cong tu so
                ucln);
        ucln = NumberUtils.gcd(res.tuSo, res.mauSo);
        res.tuSo /= ucln;
        res.mauSo /= ucln;
        return res;
    }

    public PhanSo tru(PhanSo a) {
        int ucln = NumberUtils.gcd(mauSo, a.mauSo);
        PhanSo res = new PhanSo(
                tuSo * (ucln / mauSo) - a.tuSo * (ucln / a.mauSo), // tru tu so
                ucln);
        ucln = NumberUtils.gcd(res.tuSo, res.mauSo);
        res.tuSo /= ucln;
        res.mauSo /= ucln;
        return res;
    }

    public PhanSo nhan(PhanSo a) {
        PhanSo res = new PhanSo(
                tuSo * a.tuSo,
                mauSo * a.mauSo);
        int ucln = NumberUtils.gcd(res.tuSo, res.mauSo);
        res.tuSo /= ucln;
        res.mauSo /= ucln;
        return res;
    }

    public PhanSo chia(PhanSo a) {

        PhanSo res = new PhanSo(
                tuSo * a.mauSo,
                mauSo * a.tuSo);
        int ucln = NumberUtils.gcd(res.tuSo, res.mauSo);
        res.tuSo /= ucln;
        res.mauSo /= ucln;
        return res;
    }

    @Override
    public String toString() {
        return tuSo == 0 ? 0 + "" : mauSo == 1 ? tuSo + "" : tuSo + "/" + mauSo;
    }

    public static void main(String[] args) {
        PhanSo p = new PhanSo(1, 2);
        System.out.println(p.giaTriThuc());
        System.out.println(p.lonHon(new PhanSo(1, 2)));
        System.out.println(p.cong(new PhanSo(1, 2)));
        System.out.println(p.tru(new PhanSo(1, 2)));
        System.out.println(p.nhan(new PhanSo(1, 2)));
        System.out.println(p.chia(new PhanSo(1, 2)));
    }
}
