package com.tencent.mm.storage;

import com.tencent.mm.e.b.ae;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class x extends ae {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "labelId";
        aVar.nmd.put("labelId", "TEXT");
        stringBuilder.append(" labelId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "contactName";
        aVar.nmd.put("contactName", "TEXT");
        stringBuilder.append(" contactName TEXT");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
