package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.e.b.b;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class c extends b {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "billNo";
        aVar.nmd.put("billNo", "TEXT PRIMARY KEY ");
        stringBuilder.append(" billNo TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "billNo";
        aVar.bXK[1] = "insertmsg";
        aVar.nmd.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "localMsgId";
        aVar.nmd.put("localMsgId", "LONG");
        stringBuilder.append(" localMsgId LONG");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
