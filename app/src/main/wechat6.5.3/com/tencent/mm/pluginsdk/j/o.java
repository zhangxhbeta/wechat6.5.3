package com.tencent.mm.pluginsdk.j;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class o {
    private static final Locale lCL = u.Ke(u.bsY());
    private static final boolean lCM = u.bsV();

    public static String F(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(1000 * j));
    }

    public static String H(Context context, int i) {
        long j = 1000 * ((long) i);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return SQLiteDatabase.KeyEmpty;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return o(context, timeInMillis) + ";" + G(context.getString(2131232888), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(2131232911) + " " + o(context, timeInMillis) + ";" + G(context.getString(2131232888), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(2131232894) + " " + o(context, timeInMillis) + ";" + G(context.getString(2131232888), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(2131232903) + " " + o(context, timeInMillis) + ";" + G(context.getString(2131232888), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(2131232893) + " " + o(context, timeInMillis) + ";" + G(context.getString(2131232888), j);
        }
        gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        int i2 = gregorianCalendar2.get(11);
        int i3;
        StringBuilder stringBuilder;
        String string;
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) == gregorianCalendar2.get(3)) {
            i3 = gregorianCalendar2.get(7);
            stringBuilder = new StringBuilder();
            switch (i3) {
                case 1:
                    string = context.getString(2131232907);
                    break;
                case 2:
                    string = context.getString(2131232905);
                    break;
                case 3:
                    string = context.getString(2131232909);
                    break;
                case 4:
                    string = context.getString(2131232910);
                    break;
                case 5:
                    string = context.getString(2131232908);
                    break;
                case 6:
                    string = context.getString(2131232904);
                    break;
                case 7:
                    string = context.getString(2131232906);
                    break;
                default:
                    string = SQLiteDatabase.KeyEmpty;
                    break;
            }
            return stringBuilder.append(string).append(" ").append(I(context, i2)).append(";").append(G(context.getString(2131232888), j)).toString();
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar2.get(3)) {
            i3 = gregorianCalendar2.get(7);
            stringBuilder = new StringBuilder();
            switch (i3) {
                case 1:
                    string = context.getString(2131232898);
                    break;
                case 2:
                    string = context.getString(2131232896);
                    break;
                case 3:
                    string = context.getString(2131232900);
                    break;
                case 4:
                    string = context.getString(2131232901);
                    break;
                case 5:
                    string = context.getString(2131232899);
                    break;
                case 6:
                    string = context.getString(2131232895);
                    break;
                case 7:
                    string = context.getString(2131232897);
                    break;
                default:
                    string = SQLiteDatabase.KeyEmpty;
                    break;
            }
            return stringBuilder.append(string).append(" ").append(I(context, i2)).append(";").append(G(context.getString(2131232888), j)).toString();
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return DateFormat.format(context.getString(2131232866), j) + " " + I(context, i2) + ";" + G(context.getString(2131232888), j);
        } else {
            return DateFormat.format(context.getString(2131232879), j) + " " + I(context, i2) + ";" + G(context.getString(2131232888), j);
        }
    }

    public static String G(String str, long j) {
        String charSequence = DateFormat.format(str, j).toString();
        if (be.kS(charSequence)) {
            return SQLiteDatabase.KeyEmpty;
        }
        charSequence = charSequence.trim();
        if (charSequence.startsWith("0")) {
            return charSequence.substring(1);
        }
        return charSequence;
    }

    public static CharSequence m(Context context, long j) {
        return context.getString(2131232936) + DateFormat.format(context.getString(2131232935), j);
    }

    public static CharSequence n(Context context, long j) {
        return context.getString(2131232937) + DateFormat.format(context.getString(2131232935), j);
    }

    private static CharSequence I(Context context, int i) {
        if (i < 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (((long) i) < 6) {
            return context.getString(2131232870);
        }
        if (((long) i) < 12) {
            return context.getString(2131232882);
        }
        if (((long) i) < 13) {
            return context.getString(2131232887);
        }
        if (((long) i) < 18) {
            return context.getString(2131232856);
        }
        return context.getString(2131232873);
    }

    public static CharSequence o(Context context, long j) {
        if (j < 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (j < 21600000) {
            return context.getString(2131232870);
        }
        if (j < 43200000) {
            return context.getString(2131232882);
        }
        if (j < 46800000) {
            return context.getString(2131232887);
        }
        if (j < 64800000) {
            return context.getString(2131232856);
        }
        return context.getString(2131232873);
    }

    public static CharSequence c(Context context, long j, boolean z) {
        CharSequence charSequence;
        if (!lCM) {
            Locale locale = lCL;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                return SQLiteDatabase.KeyEmpty;
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
                    return z ? context.getString(2131232911) : context.getString(2131232911) + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                } else {
                    gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(j);
                    if (gregorianCalendar.get(1) != gregorianCalendar2.get(1) || gregorianCalendar.get(3) != gregorianCalendar2.get(3)) {
                        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) ? z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j)) : z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j));
                    } else {
                        charSequence = new SimpleDateFormat("E", locale).format(Long.valueOf(j));
                        if (z) {
                            return charSequence;
                        }
                        return charSequence + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                    }
                }
            }
            return java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
        } else if (j < 3600000) {
            return SQLiteDatabase.KeyEmpty;
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                return DateFormat.is24HourFormat(aa.getContext()) ? n.a(context.getString(2131232889), time) : I(context, time.hour) + n.a(context.getString(2131232888), time);
            } else {
                if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                    boolean is24HourFormat = DateFormat.is24HourFormat(aa.getContext());
                    if (z) {
                        return context.getString(2131232911);
                    }
                    return context.getString(2131232911) + " " + (is24HourFormat ? n.a(context.getString(2131232889), time) : I(context, time.hour) + n.a(context.getString(2131232888), time));
                } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                    charSequence = n.a("E ", time);
                    if (z) {
                        return charSequence;
                    }
                    return charSequence + n.a(context.getString(2131232890), time);
                } else if (time.year == time2.year) {
                    if (z) {
                        return n.a(context.getString(2131232866), time);
                    }
                    return n.a(context.getString(2131232868, new Object[]{o(context, ((long) time.hour) * 3600000)}).toString(), time);
                } else if (z) {
                    return n.a(context.getString(2131232879), time);
                } else {
                    return n.a(context.getString(2131232880, new Object[]{o(context, ((long) time.hour) * 3600000)}).toString(), time);
                }
            }
        }
    }
}
