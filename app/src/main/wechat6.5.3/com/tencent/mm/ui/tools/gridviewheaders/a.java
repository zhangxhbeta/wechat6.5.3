package com.tencent.mm.ui.tools.gridviewheaders;

import android.content.Context;
import java.util.Calendar;
import java.util.Date;

public class a {
    private static a oVG;
    private long oVD = Calendar.getInstance().getTimeInMillis();
    public long oVE;
    public long oVF;

    public static a bJA() {
        if (oVG == null) {
            synchronized (a.class) {
                oVG = new a();
            }
        }
        return oVG;
    }

    private a() {
        Calendar instance = Calendar.getInstance();
        instance.set(7, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.oVE = instance.getTimeInMillis();
        instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.oVF = instance.getTimeInMillis();
    }

    public static long b(Date date) {
        return (long) ((date.getYear() * 100) + date.getMonth());
    }

    public final String a(Date date, Context context) {
        if (date.getTime() >= this.oVE) {
            return context.getString(2131235658);
        }
        if (date.getTime() >= this.oVF) {
            return context.getString(2131235657);
        }
        return String.format("%d/%d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1)});
    }
}
