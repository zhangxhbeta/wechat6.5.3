package com.tencent.mm.pluginsdk.j;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class n {
    public static CharSequence a(CharSequence charSequence, Time time) {
        Object spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a;
            int length2;
            int i2 = 1;
            char charAt = spannableStringBuilder.charAt(i);
            if (charAt == '\'') {
                a = a(spannableStringBuilder, i, length);
                length2 = spannableStringBuilder.length();
            } else {
                Object aMPMString;
                while (i + i2 < length && spannableStringBuilder.charAt(i + i2) == charAt) {
                    i2++;
                }
                switch (charAt) {
                    case 'A':
                        aMPMString = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'E':
                        aMPMString = DateUtils.getDayOfWeekString(time.weekDay + 1, i2 < 4 ? 20 : 10);
                        break;
                    case 'L':
                    case 'M':
                        a = time.month;
                        if (i2 < 4) {
                            if (i2 != 3) {
                                aMPMString = cS(a + 1, i2);
                                break;
                            }
                            aMPMString = DateUtils.getMonthString(a, 20);
                            break;
                        }
                        aMPMString = DateUtils.getMonthString(a, 10);
                        break;
                    case 'a':
                        aMPMString = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'd':
                        aMPMString = cS(time.monthDay, i2);
                        break;
                    case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                        a = time.hour;
                        if (a == 0) {
                            a = 12;
                        }
                        if (a > 12) {
                            a -= 12;
                        }
                        aMPMString = String.valueOf(a);
                        break;
                    case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                        aMPMString = cS(time.hour, i2);
                        break;
                    case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                        aMPMString = cS(time.minute, i2);
                        break;
                    case 's':
                        aMPMString = cS(time.second, i2);
                        break;
                    case 'y':
                        a = time.year;
                        if (i2 > 2) {
                            aMPMString = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(a)});
                            break;
                        }
                        aMPMString = cS(a % 100, 2);
                        break;
                    case 'z':
                        TimeZone timeZone = TimeZone.getDefault();
                        timeZone.inDaylightTime(new Date(time.toMillis(false)));
                        if (i2 >= 2) {
                            aMPMString = timeZone.getDisplayName(time.isDst != 0, 0);
                            break;
                        }
                        long rawOffset = (((long) timeZone.getRawOffset()) + time.gmtoff) / 1000;
                        StringBuilder stringBuilder = new StringBuilder();
                        if (rawOffset < 0) {
                            stringBuilder.insert(0, "-");
                            rawOffset = -rawOffset;
                        } else {
                            stringBuilder.insert(0, "+");
                        }
                        a = (int) ((rawOffset % 3600) / 60);
                        stringBuilder.append(cS((int) (rawOffset / 3600), 2));
                        stringBuilder.append(cS(a, 2));
                        aMPMString = stringBuilder.toString();
                        break;
                    default:
                        aMPMString = null;
                        break;
                }
                if (aMPMString != null) {
                    spannableStringBuilder.replace(i, i + i2, aMPMString);
                    a = aMPMString.length();
                    length2 = spannableStringBuilder.length();
                } else {
                    a = i2;
                    length2 = length;
                }
            }
            i = a + i;
            length = length2;
        }
        if (charSequence instanceof Spanned) {
            return new SpannedString(spannableStringBuilder);
        }
        return spannableStringBuilder.toString();
    }

    private static int a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i + 1 >= i2 || spannableStringBuilder.charAt(i + 1) != '\'') {
            int i3 = 0;
            spannableStringBuilder.delete(i, i + 1);
            int i4 = i2 - 1;
            while (i < i4) {
                if (spannableStringBuilder.charAt(i) != '\'') {
                    i++;
                    i3++;
                } else if (i + 1 >= i4 || spannableStringBuilder.charAt(i + 1) != '\'') {
                    spannableStringBuilder.delete(i, i + 1);
                    return i3;
                } else {
                    spannableStringBuilder.delete(i, i + 1);
                    i4--;
                    i3++;
                    i++;
                }
            }
            return i3;
        }
        spannableStringBuilder.delete(i, i + 1);
        return 1;
    }

    private static String cS(int i, int i2) {
        return String.format(Locale.getDefault(), "%0" + i2 + "d", new Object[]{Integer.valueOf(i)});
    }
}
