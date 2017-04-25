package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import junit.framework.Assert;

public final class e extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private com.tencent.mm.bg.g cuX;

    public e(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(d dVar) {
        dVar.bkU = -1;
        return ((int) this.cuX.insert("qcontact", "username", dVar.py())) != -1;
    }

    public final boolean a(String str, d dVar) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (dVar == null) {
            return false;
        }
        if (this.cuX.update("qcontact", dVar.py(), "username=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final d xU(String str) {
        d dVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + be.lZ(str) + "\"", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                dVar = new d();
                dVar.username = rawQuery.getString(0);
                dVar.cIA = rawQuery.getLong(1);
                dVar.extInfo = rawQuery.getString(2);
                dVar.hZH = rawQuery.getInt(3);
                dVar.hZI = rawQuery.getLong(4);
                dVar.hZJ = rawQuery.getLong(5);
                dVar.cuT = rawQuery.getInt(6);
                dVar.cHX = rawQuery.getInt(7);
                dVar.cyz = rawQuery.getInt(8);
                dVar.cyA = rawQuery.getInt(9);
                dVar.hZK = rawQuery.getString(10);
                dVar.hZL = rawQuery.getString(11);
                dVar.hZM = rawQuery.getString(12);
                dVar.hZN = rawQuery.getString(13);
            }
            rawQuery.close();
        }
        return dVar;
    }
}
