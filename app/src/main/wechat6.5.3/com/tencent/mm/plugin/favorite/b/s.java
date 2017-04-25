package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.text.format.DateFormat;
import java.util.GregorianCalendar;

public final class s {
    public static CharSequence v(Context context, int i) {
        if (i <= 0) {
            return context.getString(2131232753, new Object[]{Integer.valueOf(0)});
        }
        return context.getString(2131232753, new Object[]{Integer.valueOf(i)});
    }

    public static CharSequence s(Context context, int i) {
        if (i <= 0) {
            return context.getString(2131232727, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
        }
        int i2 = i % 60;
        return context.getString(2131232727, new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i2)});
    }

    public static CharSequence e(Context context, long j) {
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return context.getString(2131232902);
        }
        long timeInMillis2 = gregorianCalendar2.getTimeInMillis() - j;
        if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
            return context.getString(2131232911);
        }
        new GregorianCalendar().setTimeInMillis(j);
        int timeInMillis3 = (int) ((gregorianCalendar.getTimeInMillis() - j) / 86400000);
        if (timeInMillis3 <= 0) {
            timeInMillis3 = 1;
        }
        if (timeInMillis3 > 30) {
            return DateFormat.format(context.getString(2131232685), j);
        }
        return context.getResources().getQuantityString(2131361803, timeInMillis3, new Object[]{Integer.valueOf(timeInMillis3)});
    }
}
