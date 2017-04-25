package com.tencent.mm.plugin.order.b;

import com.tencent.mm.e.b.cc;
import java.lang.reflect.Field;

public final class a extends cc {
    protected static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgId";
        aVar.nmd.put("msgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "msgId";
        aVar.bXK[1] = "msgContentXml";
        aVar.nmd.put("msgContentXml", "TEXT");
        stringBuilder.append(" msgContentXml TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "isRead";
        aVar.nmd.put("isRead", "TEXT");
        stringBuilder.append(" isRead TEXT");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
