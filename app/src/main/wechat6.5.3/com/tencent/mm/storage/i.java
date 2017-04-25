package com.tencent.mm.storage;

import com.tencent.mm.e.b.q;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class i extends q {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "sessionName";
        aVar.nmd.put("sessionName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" sessionName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "sessionName";
        aVar.bXK[1] = "startTime";
        aVar.nmd.put("startTime", "LONG default '0' ");
        stringBuilder.append(" startTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "endTime";
        aVar.nmd.put("endTime", "LONG default '0' ");
        stringBuilder.append(" endTime LONG default '0' ");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
