package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.be;

public final class b {
    public static String h(int i, int i2, String str) {
        if (i == i2) {
            return c((double) i, str);
        }
        return String.format("%s~%s", new Object[]{c((double) i2, str), c((double) i, str)});
    }

    public static String c(double d, String str) {
        if ("CNY".equals(str) || "1".equals(str) || be.kS(str)) {
            return String.format("¥%.2f", new Object[]{Double.valueOf(d / 100.0d)});
        }
        return String.format("%s%.2f", new Object[]{str, Double.valueOf(d / 100.0d)});
    }

    public static String a(Context context, pc pcVar) {
        if (pcVar.mjf > 0) {
            return pcVar.gkB + " " + c((double) pcVar.mjf, pcVar.mqp);
        }
        return context.getString(2131233789);
    }
}
