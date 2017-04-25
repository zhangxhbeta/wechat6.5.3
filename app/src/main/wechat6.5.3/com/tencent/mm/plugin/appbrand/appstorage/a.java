package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.e.b.j;
import java.lang.reflect.Field;

public final class a extends j {
    protected static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "key";
        aVar.nmd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "key";
        aVar.bXK[1] = "data";
        aVar.nmd.put("data", "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "dataType";
        aVar.nmd.put("dataType", "TEXT");
        stringBuilder.append(" dataType TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "size";
        aVar.nmd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
