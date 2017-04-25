package com.tencent.mm.model;

import com.tencent.mm.a.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class j {
    public static String f(String str, long j) {
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(j));
        if (str == null || str.length() <= 1) {
            format = format + "fffffff";
        } else {
            format = format + g.m(str.getBytes()).substring(0, 7);
        }
        return (format + String.format("%04x", new Object[]{Long.valueOf(j % 65535)})) + ((j % 7) + 100);
    }
}
