package com.tencent.mm.plugin.freewifi.g;

import com.tencent.mm.e.b.bb;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class e extends bb {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "id";
        aVar.nmd.put("id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "id";
        aVar.bXK[1] = "protocolNumber";
        aVar.nmd.put("protocolNumber", "INTEGER");
        stringBuilder.append(" protocolNumber INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "logContent";
        aVar.nmd.put("logContent", "TEXT");
        stringBuilder.append(" logContent TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "createTime";
        aVar.nmd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
