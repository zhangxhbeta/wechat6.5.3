package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.q.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class k extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "AppMessage")};

    public k(d dVar) {
        super(dVar, a.chq, "AppMessage", null);
    }

    public final a dz(long j) {
        c aVar = new a();
        aVar.field_msgId = j;
        return super.b(aVar, new String[0]) ? aVar : null;
    }
}
