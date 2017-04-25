package com.tencent.mm.ui.account;

import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f extends b {
    private static f nJN = null;
    public String cYN = null;
    public String nJH = null;
    public String nJI = null;
    public String nJJ = null;
    public String nJK = null;
    public byte[] nJL = null;
    public int nJM = 0;

    public final void bAL() {
        if (be.kS(this.nJI)) {
            ak.vy().a(new s(this.cYN, this.nJH, this.nQc.nJM, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty, false, false), 0);
            return;
        }
        ak.vy().a(new s(this.cYN, this.nJI, this.nQc.nJM, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty, false, true), 0);
    }

    public static void a(f fVar) {
        nJN = fVar;
    }

    public static String bAR() {
        if (nJN != null) {
            return nJN.cYN;
        }
        return null;
    }

    public static String bAS() {
        if (nJN != null) {
            return nJN.nJH;
        }
        return null;
    }
}
