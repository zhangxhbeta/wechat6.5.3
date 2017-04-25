package com.tencent.mm.storage;

import com.tencent.mm.e.b.cz;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class be extends cz {
    protected static a chq;

    protected final a tl() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgId";
        aVar.nmd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "msgId";
        aVar.bXK[1] = "cmsgId";
        aVar.nmd.put("cmsgId", "TEXT");
        stringBuilder.append(" cmsgId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "content";
        aVar.nmd.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }
}
