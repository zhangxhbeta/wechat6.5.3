package com.tencent.mm.plugin.bbom;

import com.tencent.mm.booter.notification.e;
import com.tencent.mm.h.a;
import com.tencent.mm.h.i;
import com.tencent.mm.plugin.zero.a.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class k implements g {
    public final void a(long j, String str, String str2, String str3, String str4, int i) {
        String string;
        if (be.kS(str2)) {
            string = aa.getContext().getString(i.dE(str) ? 2131231879 : 2131233300);
        } else {
            string = str2;
        }
        e eVar = a.bZF.bZE;
        if (!a.su()) {
            e.cancel();
        }
        try {
            eVar.bZw.a(j, str, string, str3, str4, false, i);
        } catch (Throwable e) {
            v.e("MicroMsg.Notification.Handle", "push:notify, error");
            v.a("MicroMsg.Notification.Handle", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
