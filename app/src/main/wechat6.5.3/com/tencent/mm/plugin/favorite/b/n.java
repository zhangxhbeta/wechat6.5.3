package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class n extends f<m> {
    public static final String[] cic = new String[]{f.a(m.chq, "FavSearchInfo")};
    d cie;

    public n(d dVar) {
        super(dVar, m.chq, "FavSearchInfo", null);
        this.cie = dVar;
    }

    public final void bD(long j) {
        this.cie.dF("FavSearchInfo", "delete from FavSearchInfo where localId = " + j);
    }

    public final m bE(long j) {
        Cursor rawQuery = this.cie.rawQuery("select * from FavSearchInfo where localId = " + j, null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        m mVar = new m();
        mVar.b(rawQuery);
        rawQuery.close();
        return mVar;
    }
}
