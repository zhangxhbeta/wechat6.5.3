package com.tencent.mm.booter;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class h {
    public static boolean qh() {
        try {
            ak.yW();
            t.e((Long) c.vf().get(66817, null));
        } catch (Throwable e) {
            v.a("MicroMsg.PostTaskMediaNoteStat", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        if (t.ax(0) * 1000 > 1800000) {
            return true;
        }
        return false;
    }
}
