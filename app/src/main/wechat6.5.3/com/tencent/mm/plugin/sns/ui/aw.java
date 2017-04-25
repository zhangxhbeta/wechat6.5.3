package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class aw {
    private static Map<String, List<String>> gzC = new HashMap();
    private static Map<String, List<String>> gzD = new HashMap();
    private static HashMap<Long, Long> gzE = new HashMap();
    private static HashMap<Long, String> gzF = new HashMap();

    private static CharSequence g(Context context, long j) {
        return DateFormat.format(context.getString(2131232889), j);
    }

    public static String j(Context context, long j) {
        int i;
        int i2;
        String str;
        int i3 = 0;
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        int i4 = instance.get(1) == instance2.get(1) ? 1 : 0;
        if (i4 == 0 || instance.get(2) != instance2.get(2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i4 == 0 || r2 == 0 || instance.get(5) != instance2.get(5)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i4 == 0 || r2 == 0 || instance.get(5) - 1 != instance2.get(5)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            int i5;
            if (i4 != 0 && instance.get(2) - 1 == instance2.get(2)) {
                i5 = 1;
            } else if (instance.get(1) - instance2.get(1) == 1) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                instance.add(5, -1);
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
                    i3 = 1;
                }
                if (i2 != 0) {
                    return (String) g(context, j);
                }
                if (i3 != 0) {
                    return context.getString(2131232911) + " " + ((String) g(context, j));
                }
                if (i4 == 0) {
                    str = (String) DateFormat.format(context.getString(2131232866), j);
                } else {
                    str = (String) DateFormat.format(context.getString(2131232879), j);
                }
                if (str.indexOf("-") > 0) {
                    i3 = instance2.get(2) + 1;
                    str = instance2.get(5) + " " + C(context, i3);
                    if (i4 == 0) {
                        str = str + " " + instance2.get(1);
                    }
                }
                return str + " " + ((String) g(context, j));
            }
        }
        i3 = i;
        if (i2 != 0) {
            return (String) g(context, j);
        }
        if (i3 != 0) {
            return context.getString(2131232911) + " " + ((String) g(context, j));
        }
        if (i4 == 0) {
            str = (String) DateFormat.format(context.getString(2131232879), j);
        } else {
            str = (String) DateFormat.format(context.getString(2131232866), j);
        }
        if (str.indexOf("-") > 0) {
            i3 = instance2.get(2) + 1;
            str = instance2.get(5) + " " + C(context, i3);
            if (i4 == 0) {
                str = str + " " + instance2.get(1);
            }
        }
        return str + " " + ((String) g(context, j));
    }

    public static String k(Context context, long j) {
        int i;
        int i2;
        String str;
        int i3 = 0;
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        int i4 = instance.get(1) == instance2.get(1) ? 1 : 0;
        if (i4 == 0 || instance.get(2) != instance2.get(2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i4 == 0 || r2 == 0 || instance.get(5) != instance2.get(5)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i4 == 0 || r2 == 0 || instance.get(5) - 1 != instance2.get(5)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            int i5;
            if (i4 != 0 && instance.get(2) - 1 == instance2.get(2)) {
                i5 = 1;
            } else if (instance.get(1) - instance2.get(1) == 1) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                instance.add(5, -1);
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
                    i3 = 1;
                }
                if (i2 != 0) {
                    return (String) g(context, j);
                }
                if (i3 != 0) {
                    return context.getString(2131232911) + " " + ((String) g(context, j));
                }
                str = (String) DateFormat.format(context.getString(2131232879), j);
                if (str.indexOf("-") > 0) {
                    i3 = instance2.get(2) + 1;
                    str = instance2.get(5) + " " + C(context, i3);
                    if (i4 == 0) {
                        str = str + " " + instance2.get(1);
                    }
                }
                return str + " " + ((String) g(context, j));
            }
        }
        i3 = i;
        if (i2 != 0) {
            return (String) g(context, j);
        }
        if (i3 != 0) {
            return context.getString(2131232911) + " " + ((String) g(context, j));
        }
        str = (String) DateFormat.format(context.getString(2131232879), j);
        if (str.indexOf("-") > 0) {
            i3 = instance2.get(2) + 1;
            str = instance2.get(5) + " " + C(context, i3);
            if (i4 == 0) {
                str = str + " " + instance2.get(1);
            }
        }
        return str + " " + ((String) g(context, j));
    }

    public static synchronized void clean() {
        synchronized (aw.class) {
            gzE.clear();
            gzF.clear();
        }
    }

    public static synchronized String f(Context context, long j) {
        String str;
        synchronized (aw.class) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                str = "";
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (gzE.containsKey(Long.valueOf(j))) {
                    if (timeInMillis - ((Long) gzE.get(Long.valueOf(j))).longValue() >= 60000) {
                        gzE.remove(Long.valueOf(j));
                    } else if (gzF.containsKey(Long.valueOf(j))) {
                        str = (String) gzF.get(Long.valueOf(j));
                    }
                }
                int i;
                if ((timeInMillis - j) / 3600000 == 0) {
                    i = (int) ((timeInMillis - j) / 60000);
                    if (i <= 0) {
                        i = 1;
                    }
                    str = context.getResources().getQuantityString(2131361802, i, new Object[]{Integer.valueOf(i)});
                    gzF.put(Long.valueOf(j), str);
                    gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                } else {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                    long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                            i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                            if (i <= 0) {
                                i = 1;
                            }
                            str = context.getResources().getQuantityString(2131361803, i, new Object[]{Integer.valueOf(i)});
                            gzF.put(Long.valueOf(j), str);
                            gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        } else {
                            str = context.getString(2131232911);
                            gzF.put(Long.valueOf(j), str);
                            gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        }
                    } else {
                        i = (int) ((timeInMillis - j) / 3600000);
                        if (i <= 0) {
                            i = 1;
                        }
                        str = context.getResources().getQuantityString(2131361801, i, new Object[]{Integer.valueOf(i)});
                        gzF.put(Long.valueOf(j), str);
                        gzE.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                    }
                }
            }
        }
        return str;
    }

    private static void as(Context context, String str) {
        String[] stringArray = context.getResources().getStringArray(2131296297);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        gzD.put(str, arrayList);
    }

    private static String C(Context context, int i) {
        String[] stringArray = context.getResources().getStringArray(2131296297);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        if (i >= arrayList.size()) {
            return "";
        }
        return (String) arrayList.get(i);
    }

    public static String q(Context context, String str, String str2) {
        if (gzD.get(str2) == null) {
            as(context, str2);
        }
        int i = be.getInt(str, 0);
        List list = (List) gzD.get(str2);
        if (i >= list.size() || list.get(i) == null || ((String) list.get(i)).equals("")) {
            as(context, str2);
        }
        list = (List) gzD.get(str2);
        if (i < list.size()) {
            return (String) list.get(i);
        }
        return "";
    }

    public static CharSequence a(Context context, long j, boolean z) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000 && z) {
            return context.getString(2131232902);
        }
        long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
        if (timeInMillis2 > 0 && timeInMillis2 <= 86400000 && z) {
            return context.getString(2131232911);
        }
        new GregorianCalendar().setTimeInMillis(j);
        return DateFormat.format(context.getString(2131232867), j);
    }
}
