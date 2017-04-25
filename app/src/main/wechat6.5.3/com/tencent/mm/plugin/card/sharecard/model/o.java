package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class o extends f<n> {
    public static final String[] cic = new String[]{f.a(n.chq, "ShareCardSyncItemInfo")};
    private d cie;

    public o(d dVar) {
        super(dVar, n.chq, "ShareCardSyncItemInfo", null);
        this.cie = dVar;
    }

    public final List<n> aah() {
        List<n> arrayList = new ArrayList();
        Cursor rawQuery = this.cie.rawQuery("select * from ShareCardSyncItemInfo where retryCount < 10", null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                n nVar = new n();
                nVar.b(rawQuery);
                rawQuery.moveToNext();
                arrayList.add(nVar);
            }
        }
        rawQuery.close();
        v.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}
