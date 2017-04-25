package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.pluginsdk.j.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;

public final class h implements d {
    public final boolean ZV() {
        return j.acH();
    }

    public final boolean ZW() {
        return j.acJ();
    }

    public final String ZX() {
        ak.yW();
        return (String) c.vf().get(a.npD, null);
    }

    public final int ZY() {
        int i = 0;
        com.tencent.mm.plugin.card.model.c aak = af.aak();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
        Cursor rawQuery = aak.cie.rawQuery("select count(*) from UserCardInfo" + stringBuilder.toString(), null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        v.i("MicroMsg.CardMgrImpl", "getGiftCardCount:" + i);
        return i;
    }

    public final boolean iT(int i) {
        return j.iT(i);
    }
}
