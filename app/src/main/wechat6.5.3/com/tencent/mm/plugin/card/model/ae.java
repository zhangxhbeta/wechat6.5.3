package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class ae extends f<ad> {
    public static final String[] cic = new String[]{f.a(ad.chq, "PendingCardId")};
    d cie;

    public ae(d dVar) {
        super(dVar, ad.chq, "PendingCardId", null);
        this.cie = dVar;
    }

    public final List<ad> aah() {
        List<ad> arrayList = new ArrayList();
        Cursor rawQuery = this.cie.rawQuery("select * from PendingCardId where retryCount < 10", null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                ad adVar = new ad();
                adVar.b(rawQuery);
                rawQuery.moveToNext();
                arrayList.add(adVar);
            }
        }
        rawQuery.close();
        v.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}
