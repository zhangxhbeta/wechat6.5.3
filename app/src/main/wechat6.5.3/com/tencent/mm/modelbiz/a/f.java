package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.u;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class f extends u {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "brandUserName";
        aVar.nmd.put("brandUserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "brandUserName";
        aVar.bXK[1] = "userId";
        aVar.nmd.put("userId", "TEXT");
        stringBuilder.append(" userId TEXT");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
