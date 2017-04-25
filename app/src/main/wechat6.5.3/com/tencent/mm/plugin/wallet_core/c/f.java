package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.h.d;
import java.util.ArrayList;

public final class f extends com.tencent.mm.sdk.h.f<s> {
    public static final String[] cic = new String[]{com.tencent.mm.sdk.h.f.a(s.chq, "WalletKindInfo")};
    public d cie;

    public f(d dVar) {
        super(dVar, s.chq, "WalletKindInfo", null);
        this.cie = dVar;
    }

    public final ArrayList<s> bgS() {
        ArrayList<s> arrayList = null;
        Cursor rawQuery = this.cie.rawQuery("select * from WalletKindInfo", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
            } else {
                arrayList = new ArrayList();
                rawQuery.moveToFirst();
                while (!rawQuery.isAfterLast()) {
                    s sVar = new s();
                    sVar.b(rawQuery);
                    arrayList.add(sVar);
                    rawQuery.moveToNext();
                }
                rawQuery.close();
            }
        }
        return arrayList;
    }
}
