package com.tencent.mm.plugin.game.e;

import android.content.Context;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static Map<String, List<String>> gzC = new HashMap();
    private static Map<String, List<String>> gzD = new HashMap();
    public static HashMap<Long, Long> gzE = new HashMap();
    public static HashMap<Long, String> gzF = new HashMap();

    public static String f(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (gzE.containsKey(Long.valueOf(j))) {
            if (timeInMillis - ((Long) gzE.get(Long.valueOf(j))).longValue() >= 60000) {
                gzE.remove(Long.valueOf(j));
            } else if (gzF.containsKey(Long.valueOf(j))) {
                return (String) gzF.get(Long.valueOf(j));
            }
        }
        int i;
        if ((timeInMillis - j) / 3600000 == 0) {
            i = (int) ((timeInMillis - j) / 60000);
            if (i <= 0) {
                i = 1;
            }
            String quantityString = context.getResources().getQuantityString(2131361802, i, new Object[]{Integer.valueOf(i)});
            gzF.put(Long.valueOf(j), quantityString);
            gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
            timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
            if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                if (i <= 0) {
                    i = 1;
                }
                quantityString = context.getResources().getQuantityString(2131361803, i, new Object[]{Integer.valueOf(i)});
                gzF.put(Long.valueOf(j), quantityString);
                gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                return quantityString;
            }
            quantityString = context.getString(2131232911);
            gzF.put(Long.valueOf(j), quantityString);
            gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        i = (int) ((timeInMillis - j) / 3600000);
        if (i <= 0) {
            i = 1;
        }
        quantityString = context.getResources().getQuantityString(2131361801, i, new Object[]{Integer.valueOf(i)});
        gzF.put(Long.valueOf(j), quantityString);
        gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
        return quantityString;
    }
}
