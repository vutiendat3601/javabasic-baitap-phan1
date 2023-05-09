package com.datvutech.answer.bai27;

import java.util.ArrayList;
import java.util.List;

import com.datvutech.answer.bai24.Diem2D;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DaGiac {
    /* #: Properties */
    private List<Diem2D> diems;

    /* # Properties */
    /* #: Constructors */

    public DaGiac(Diem2D diem1, Diem2D diem2, Diem2D diem3) {
        diems = new ArrayList<>();
        diems.add(diem1);
        diems.add(diem2);
        diems.add(diem3);
    }
    /* # Constructor */

    /* #: Input, output */
    public void nhap() {
        Diem2D diem2d = new Diem2D(0, 0);
        diem2d.nhapDiem();
        diems.add(diem2d);
    }

    /* # Input, output */
}
