package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.bj;
import java.lang.reflect.Field;

public final class a extends bj {
    public static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "username";
        aVar.nmd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "championUrl";
        aVar.nmd.put("championUrl", "TEXT");
        stringBuilder.append(" championUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "championMotto";
        aVar.nmd.put("championMotto", "TEXT");
        stringBuilder.append(" championMotto TEXT");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
