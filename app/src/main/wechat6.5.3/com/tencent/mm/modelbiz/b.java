package com.tencent.mm.modelbiz;

import com.tencent.mm.e.b.w;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class b extends w {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "userName";
        aVar.nmd.put("userName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "userName";
        aVar.bXK[1] = "qyUin";
        aVar.nmd.put("qyUin", "INTEGER");
        stringBuilder.append(" qyUin INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "userUin";
        aVar.nmd.put("userUin", "INTEGER");
        stringBuilder.append(" userUin INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "userFlag";
        aVar.nmd.put("userFlag", "INTEGER");
        stringBuilder.append(" userFlag INTEGER");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
