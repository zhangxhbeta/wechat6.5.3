package com.tencent.mm.modelfriend;

import com.tencent.mm.ak.n;
import com.tencent.mm.e.a.z;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

final class d extends c<z> {
    d() {
        this.nhz = z.class.getName().hashCode();
    }

    private static boolean a(z zVar) {
        if (zVar.aXk.aXm == 0) {
            try {
                int xQ = k.xQ() | 4096;
                ak.yW();
                com.tencent.mm.model.c.vf().set(34, Integer.valueOf(xQ));
                ak.yW();
                com.tencent.mm.model.c.wG().b(new n(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, xQ, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                v.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Throwable e) {
                v.a("MicroMsg.FriendBindQQ.EventListener", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return false;
    }
}
