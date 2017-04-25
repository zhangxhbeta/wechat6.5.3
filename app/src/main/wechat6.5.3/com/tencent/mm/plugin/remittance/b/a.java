package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.e.b.ag;
import java.lang.reflect.Field;

public final class a extends ag {
    public static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgId";
        aVar.nmd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "msgId";
        aVar.bXK[1] = "transferId";
        aVar.nmd.put("transferId", "TEXT");
        stringBuilder.append(" transferId TEXT");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
