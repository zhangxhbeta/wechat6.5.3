package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.v;

public final class i extends w {
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    public final boolean eH(int i) {
        return i != 0 && i < 620758015;
    }

    public final void transfer(int i) {
        v.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", Integer.valueOf(i));
        ak.yW();
        g wE = c.wE();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username from rconversation");
        stringBuilder.append(" where flag & 4611686018427387904").append(" != 0");
        v.d("MicroMsg.App.SyncTopConversation", "sql:%s", stringBuilder);
        Cursor rawQuery = wE.rawQuery(stringBuilder.toString(), null);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            while (rawQuery.moveToNext()) {
                v.v("MicroMsg.App.SyncTopConversation", "userName %s", rawQuery.getString(0));
                m.l(r1, false);
            }
            rawQuery.close();
        }
    }
}
