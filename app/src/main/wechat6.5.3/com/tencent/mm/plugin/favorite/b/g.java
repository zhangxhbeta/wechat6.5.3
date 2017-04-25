package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class g extends f<f> {
    public static final String[] cic = new String[]{f.a(f.chq, "FavEditInfo")};
    public d cie;

    public g(d dVar) {
        super(dVar, f.chq, "FavEditInfo", null);
        this.cie = dVar;
        this.cie.dF("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
    }
}
