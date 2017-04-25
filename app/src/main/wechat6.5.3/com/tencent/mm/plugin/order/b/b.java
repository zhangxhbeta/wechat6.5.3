package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class b extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "OrderCommonMsgXml")};
    private d cie;

    public final /* bridge */ /* synthetic */ boolean a(c cVar, String[] strArr) {
        return super.a((a) cVar, strArr);
    }

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((a) cVar);
    }

    public b(d dVar) {
        super(dVar, a.chq, "OrderCommonMsgXml", null);
        this.cie = dVar;
    }

    public final Cursor Kp() {
        return this.cie.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
    }

    public final boolean a(a aVar) {
        return super.b(aVar);
    }
}
