package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "FavConfigInfo")};
    private com.tencent.mm.sdk.h.d cie;

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "FavConfigInfo", null);
        this.cie = dVar;
    }

    public final void ao(byte[] bArr) {
        c alw = alw();
        if (8216 == alw.field_configId) {
            alw.field_value = be.bn(bArr);
            boolean a = a(alw, new String[0]);
            v.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[]{alw.field_value, Boolean.valueOf(a)});
            return;
        }
        alw.field_configId = 8216;
        alw.field_value = be.bn(bArr);
        a = b(alw);
        v.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[]{alw.field_value, Boolean.valueOf(a)});
    }

    final c alw() {
        c cVar = new c();
        v.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[]{new StringBuilder("select * from FavConfigInfo where configId = 8216").toString()});
        Cursor rawQuery = this.cie.rawQuery(r1, null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return cVar;
    }
}
