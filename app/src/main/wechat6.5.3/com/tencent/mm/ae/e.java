package com.tencent.mm.ae;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class e {
    public static d a(d dVar) {
        if (dVar == null) {
            return null;
        }
        if (!dVar.Gp()) {
            return dVar;
        }
        d fC = n.GH().fC(dVar.cLE);
        if (fC != null) {
            return fC;
        }
        return dVar;
    }

    public static boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        int i = dVar.offset;
        int i2 = dVar.cyu;
        long j = dVar.bmL;
        if (dVar.Gp()) {
            d fC = n.GH().fC(dVar.cLE);
            i = fC.offset;
            i2 = fC.cyu;
            j = fC.bmL;
        }
        if (i2 == 0) {
            return true;
        }
        if ((i != i2 || i2 == 0) && r2 == 0) {
            return false;
        }
        return true;
    }

    public static String c(d dVar) {
        if (dVar == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (!dVar.Gp()) {
            return dVar.cLv;
        }
        d fC = n.GH().fC(dVar.cLE);
        if (fC == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return fC.cLv;
    }
}
