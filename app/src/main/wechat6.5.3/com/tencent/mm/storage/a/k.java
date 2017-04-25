package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.an;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class k extends an {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "productID";
        aVar.nmd.put("productID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "productID";
        aVar.bXK[1] = "content";
        aVar.nmd.put("content", "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "lan";
        aVar.nmd.put("lan", "TEXT default '' ");
        stringBuilder.append(" lan TEXT default '' ");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
