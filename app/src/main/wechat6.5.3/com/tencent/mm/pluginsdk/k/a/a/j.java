package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class j {
    private static final int lDJ = b.DoCache.bkU;
    private static final int lDK = b.DoDelete.bkU;
    private static final int lDL = b.DoDecrypt.bkU;

    public enum a {
        ;

        static {
            lDM = 1;
            lDN = 2;
            lDO = 3;
            lDP = 4;
            lDQ = 5;
            lDR = 6;
            lDS = new int[]{lDM, lDN, lDO, lDP, lDQ, lDR};
        }
    }

    public static void q(long j, long j2) {
        if (j > 0 && 197 != j) {
            g.iuh.a(j, j2, 1, false);
        }
        g.iuh.a(197, j2, 1, false);
    }

    public static void dP(long j) {
        q(j, 2);
    }

    public static void a(int i, int i2, String str, int i3, int i4, boolean z, boolean z2, boolean z3, String str2) {
        a(i, i2, str, i3, lDJ, z2 ? 0 : 1, i4 - 1, z3 ? 0 : 1, 1, z ? 0 : 1, str2);
    }

    public static void a(int i, int i2, int i3, boolean z, String str) {
        a(i, i2, SQLiteDatabase.KeyEmpty, i3, lDK, z ? 0 : 1, a.lDN - 1, 1, 1, 1, str);
    }

    public static void a(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        a(i, i2, SQLiteDatabase.KeyEmpty, i3, lDL, z ? 0 : 1, a.lDN - 1, z3 ? 0 : 1, z2 ? 0 : 1, z4 ? 0 : 1, str);
    }

    private static void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2) {
        g.iuh.h(11906, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        if (!be.kS(str2) && !str2.equals("0")) {
            g.iuh.h(11907, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str2);
        }
    }
}
