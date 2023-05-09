package com.datvutech.answer.bai29.v2.employee.luong.common.extra;

import java.util.Properties;

import com.datvutech.answer.bai29.v2.employee.luong.common.Luong;

public abstract class LuongExtra extends Luong {
    protected Luong luong;

    public LuongExtra(Properties props) {
        setProps(props);
    }
}
