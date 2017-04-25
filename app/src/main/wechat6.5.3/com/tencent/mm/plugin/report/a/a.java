package com.tencent.mm.plugin.report.a;

import com.tencent.mm.e.b.ah;
import java.lang.reflect.Field;

public final class a extends ah {
    protected static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "bakLogId";
        aVar.nmd.put("bakLogId", "INTEGER");
        stringBuilder.append(" bakLogId INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[1] = "valueStr";
        aVar.nmd.put("valueStr", "TEXT");
        stringBuilder.append(" valueStr TEXT");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
