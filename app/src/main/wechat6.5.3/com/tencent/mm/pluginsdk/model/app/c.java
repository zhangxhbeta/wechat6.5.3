package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class c extends f<b> {
    public static final String[] cic = new String[]{f.a(b.chq, "appattach")};
    d cie;

    public c(d dVar) {
        super(dVar, b.chq, "appattach", null);
        this.cie = dVar;
    }

    public final b Gu(String str) {
        b bVar = new b();
        bVar.field_mediaSvrId = str;
        if (b((com.tencent.mm.sdk.h.c) bVar, "mediaSvrId")) {
            return bVar;
        }
        return !b((com.tencent.mm.sdk.h.c) bVar, "mediaId") ? null : bVar;
    }

    public final b dy(long j) {
        com.tencent.mm.sdk.h.c bVar = new b();
        bVar.field_msgInfoId = j;
        return b(bVar, "msgInfoId") ? bVar : null;
    }
}
