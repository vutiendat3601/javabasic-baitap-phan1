package com.datvutech.answer.bai25;

import java.util.Optional;
import java.util.Scanner;

import com.datvutech.util.AppScanner;
import com.datvutech.util.NumberUtils;

/***
 * This class represents a fraction in mathematics
 * 
 * @author Dat Vu
 * @date 2023-05-04
 */

public class PhanSo {
    /* #: Properties */
    private int tuSo;
    private int mauSo;
    /* # Properties */

    /* #: Constructors */
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    /* #: Constructors */

    /* #: Input, output */
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
        System.out.println(this);
    }
    /* # Input, output */

    /* #: Bussiness */
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
        if (a == null) {
            return this;
        }
        int ucln = NumberUtils.gcd(mauSo, a.mauSo);
        PhanSo res = new PhanSo(
                tuSo * (ucln / mauSo) + a.tuSo * (ucln / a.mauSo), // cong tu so
                ucln);
        ucln = NumberUtils.gcd(res.tuSo, res.mauSo);
        res.toiGian();
        return res;
    }

    public PhanSo tru(PhanSo a) {
        if (a == null) {
            return this;
        }
        int ucln = NumberUtils.gcd(mauSo, a.mauSo);
        PhanSo res = new PhanSo(
                tuSo * (ucln / mauSo) - a.tuSo * (ucln / a.mauSo), // tru tu so
                ucln);
        res.toiGian();
        return res;
    }

    public PhanSo nhan(PhanSo a) {
        if (a == null) {
            return this;
        }
        PhanSo res = new PhanSo(
                tuSo * a.tuSo,
                mauSo * a.mauSo);
        res.toiGian();
        return res;

    }

    public PhanSo chia(PhanSo a) {
        if (a == null) {
            return this;
        }
        PhanSo res = new PhanSo(
                tuSo * a.mauSo,
                mauSo * a.tuSo);
        res.toiGian();
        return res;
    }

    public PhanSo cong(int a) {

        PhanSo res = new PhanSo(
                tuSo + a * mauSo, // cong tu so
                mauSo);
        res.toiGian();
        return res;
    }

    public PhanSo tru(int a) {
        PhanSo res = new PhanSo(
                tuSo - a * mauSo, // tru tu so
                mauSo);
        res.toiGian();
        return res;
    }

    public PhanSo nhan(int a) {
        PhanSo res = new PhanSo(
                tuSo * a,
                mauSo);
        res.toiGian();
        return res;
    }

    public PhanSo chia(int a) {
        PhanSo res = new PhanSo(
                tuSo,
                mauSo * a);
        res.toiGian();
        return res;
    }

    public void toiGian() {
        int ucln = NumberUtils.gcd(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
    }
    /* # Bussiness */

    @Override
    public String toString() {
        return tuSo == 0 ? 0 + "" : mauSo == 1 ? tuSo + "" : tuSo + "/" + mauSo;
    }

    public static void main(String[] args) {
        PhanSo p = new PhanSo(1, 3);
        System.out.println(p.giaTriThuc());
        System.out.println(p.lonHon(new PhanSo(1, 2)));
        System.out.println(p.cong(new PhanSo(1, 2)));
        System.out.println(p.tru(new PhanSo(1, 2)));
        System.out.println(p.nhan(new PhanSo(1, 2)));
        System.out.println(p.chia(new PhanSo(1, 2)));
    }
}
