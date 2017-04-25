package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h implements InputFilter {
    private int oSR;
    private int oSS;

    public enum a {
        ;

        static {
            oST = 1;
            oSU = 2;
            oSV = new int[]{oST, oSU};
        }
    }

    public h(int i, int i2) {
        this.oSR = i;
        this.oSS = i2;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (cn(spanned.toString(), this.oSS) + cn(charSequence.toString(), this.oSS) > this.oSR) {
            return SQLiteDatabase.KeyEmpty;
        }
        return charSequence;
    }

    public static int cn(String str, int i) {
        if (i == a.oST) {
            if (be.kS(str)) {
                return 0;
            }
            return str.length();
        } else if (i == a.oSU) {
            return PC(str);
        } else {
            return 0;
        }
    }

    public static int PC(String str) {
        int i = 0;
        if (be.kS(str)) {
            return 0;
        }
        int PD = PD(str) + str.length();
        if (!be.kS(str)) {
            int i2 = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt >= '\u0000' && charAt <= '') {
                    i2++;
                }
                i++;
            }
            i = str.length() - (i2 + PD(str));
        }
        return i + PD;
    }

    public static int PD(String str) {
        if (be.kS(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            int i2 = 0;
            while (i2 <= matcher.groupCount()) {
                i2++;
                i++;
            }
        }
        return i;
    }

    public static int aw(int i, String str) {
        if (u.bsU()) {
            return Math.round(((float) (i - Math.round((float) PC(str)))) / 2.0f);
        }
        return i - PC(str);
    }

    public static int ax(int i, String str) {
        if (u.bsU()) {
            return Math.round(((float) (Math.round((float) PC(str)) - i)) / 2.0f);
        }
        return PC(str) - i;
    }
}
