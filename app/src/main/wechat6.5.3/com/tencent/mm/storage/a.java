package com.tencent.mm.storage;

import com.tencent.mm.e.b.c;
import java.lang.reflect.Field;

public final class a extends c {
    protected static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[8];
        aVar.bXK = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "abtestkey";
        aVar.nmd.put("abtestkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "abtestkey";
        aVar.bXK[1] = "value";
        aVar.nmd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "expId";
        aVar.nmd.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "sequence";
        aVar.nmd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = "prioritylevel";
        aVar.nmd.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "startTime";
        aVar.nmd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[6] = "endTime";
        aVar.nmd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[7] = "noReport";
        aVar.nmd.put("noReport", "INTEGER");
        stringBuilder.append(" noReport INTEGER");
        aVar.bXK[8] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public final boolean isValid() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > this.field_startTime && currentTimeMillis < this.field_endTime;
    }
}
