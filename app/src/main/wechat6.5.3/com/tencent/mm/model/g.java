package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac;

public final class g {
    public static int xD() {
        if (com.tencent.mm.kernel.g.uz()) {
            int i;
            ac wK = ((d) com.tencent.mm.kernel.g.f(d.class)).wK();
            v.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", "select count(*) from rbottleconversation where unReadCount > 0");
            Cursor rawQuery = wK.cie.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                i = 0;
            } else {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            if (rawQuery == null) {
                return i;
            }
            rawQuery.close();
            return i;
        }
        v.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
        return 0;
    }
}
