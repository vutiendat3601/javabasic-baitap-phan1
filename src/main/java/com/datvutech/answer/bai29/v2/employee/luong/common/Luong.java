package com.datvutech.answer.bai29.v2.employee.luong.common;

import java.util.Properties;

import com.datvutech.util.NumberUtils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class Luong {
    private Properties props;

    public Luong() {
        props = new Properties();
    }

    /* #: Bussiness */
    public String getProp(String propName) {
        return props.getProperty(propName, "");
    }

    public void setProp(String propName, String value) {
        props.setProperty(propName, value);
    }

    public abstract float tinhLuong();
    /* # Bussiness */

    @Override
    public String toString() {
        final StringBuilder strBuilder = new StringBuilder("");
        if (!props.isEmpty()) {
            props.forEach((k, v) -> strBuilder.append(" + " + k));
            strBuilder.replace(0, 3, "");
            strBuilder.append(" = " + NumberUtils.formatSeparateNum(tinhLuong()));
        }
        return strBuilder.toString();
    }

}
