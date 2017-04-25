package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class h extends f<g> {
    public static final String[] cic = new String[]{f.a(g.chq, "CardMsgInfo")};
    public d cie;

    public h(d dVar) {
        super(dVar, g.chq, "CardMsgInfo", null);
        this.cie = dVar;
    }

    public final Cursor Kp() {
        return this.cie.rawQuery("select * from CardMsgInfo order by time desc", null);
    }

    public final int Kw() {
        int i = 0;
        Cursor rawQuery = this.cie.rawQuery(" select count(*) from CardMsgInfo where read_state = ? ", new String[]{"1"});
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final boolean aaf() {
        return this.cie.dF("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
    }
}
