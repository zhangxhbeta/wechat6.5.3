package com.tencent.mm.e.b;

import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public abstract class bt extends c {
    private static final int bMg = "logId".hashCode();
    private static final int bMh = "liftTime".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    public long field_liftTime;
    public int field_logId;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "logId";
        aVar.nmd.put("logId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" logId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "logId";
        aVar.bXK[1] = "liftTime";
        aVar.nmd.put("liftTime", "LONG");
        stringBuilder.append(" liftTime LONG");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        return aVar;
    }
}
