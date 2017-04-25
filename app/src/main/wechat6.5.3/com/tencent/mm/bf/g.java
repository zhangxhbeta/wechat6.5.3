package com.tencent.mm.bf;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.a.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g {
    private static g nnP;
    private int nnO = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;

    private g() {
    }

    public static g buU() {
        if (nnP == null) {
            nnP = new g();
        }
        return nnP;
    }

    public final SpannableString e(Context context, CharSequence charSequence, int i) {
        if (charSequence == null || be.kS(charSequence.toString())) {
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        if (charSequence == null || be.kS(charSequence.toString())) {
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        charSequence = charSequence instanceof SpannableString ? (SpannableString) charSequence : new SpannableString(charSequence);
        PInt pInt = new PInt();
        pInt.value = this.nnO;
        return f.buR().b(b.buL().a(charSequence, i, pInt), i, pInt.value);
    }

    public final SpannableString c(Context context, CharSequence charSequence, float f) {
        if (charSequence == null || be.kS(charSequence.toString())) {
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        return e(context, charSequence, (int) f);
    }

    public static void d(Spannable spannable) {
        int i = 0;
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        while (i < clickableSpanArr.length) {
            spannable.removeSpan(clickableSpanArr[i]);
            i++;
        }
    }

    public static int bK(String str, int i) {
        f buR = f.buR();
        if (be.kS(str)) {
            return i;
        }
        int length = str.length();
        if (i == 0 || i == length) {
            return i;
        }
        int i2;
        if (f.nnL == null) {
            StringBuilder stringBuilder = new StringBuilder();
            int length2 = buR.nnB.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(buR.nnB[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = buR.nnC.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(buR.nnC[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = buR.nnD.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(buR.nnD[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = buR.nnE.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(buR.nnE[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = buR.nnF.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(buR.nnF[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = buR.nnG.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(buR.nnG[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            if (!(buR.nnH == null || buR.nnH.isEmpty())) {
                Iterator it = buR.nnH.iterator();
                while (it.hasNext()) {
                    s sVar = (s) it.next();
                    stringBuilder.append(Pattern.quote(sVar.field_key)).append("|");
                    if (!be.kS(sVar.field_cnValue)) {
                        stringBuilder.append(Pattern.quote(sVar.field_cnValue)).append("|");
                    }
                    if (!be.kS(sVar.field_enValue)) {
                        stringBuilder.append(Pattern.quote(sVar.field_enValue)).append("|");
                    }
                    if (!be.kS(sVar.field_qqValue)) {
                        stringBuilder.append(Pattern.quote(sVar.field_qqValue)).append("|");
                    }
                    if (!be.kS(sVar.field_twValue)) {
                        stringBuilder.append(Pattern.quote(sVar.field_twValue)).append("|");
                    }
                    if (!be.kS(sVar.field_thValue)) {
                        stringBuilder.append(Pattern.quote(sVar.field_thValue)).append("|");
                    }
                }
            }
            f.nnL = Pattern.compile(stringBuilder.toString());
        }
        Matcher matcher = f.nnL.matcher(str.substring(i < 6 ? 0 : i - 6, i + 6 >= length ? length - 1 : i + 6));
        while (matcher.find()) {
            if (6 > matcher.start() && 6 < matcher.end()) {
                i2 = matcher.start();
                break;
            }
        }
        i2 = 6;
        return i + (i2 + -6 > 0 ? i2 - 6 : 0);
    }

    public static String dH(String str, String str2) {
        f buR = f.buR();
        int i = 0;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '[') {
                a Ll = buR.Ll(str.substring(i));
                if (Ll != null) {
                    stringBuilder.append(str2);
                    i += Ll.text.length();
                }
            }
            stringBuilder.append(charAt);
            i++;
        }
        String stringBuilder2 = stringBuilder.toString();
        b.buL();
        return b.dG(stringBuilder2, str2);
    }
}
