package com.tencent.mm.storage;

import com.tencent.mm.e.b.r;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class k extends r {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgDataId";
        aVar.nmd.put("msgDataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgDataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "msgDataId";
        aVar.bXK[1] = "bakchatName";
        aVar.nmd.put("bakchatName", "TEXT default '' ");
        stringBuilder.append(" bakchatName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "startTime";
        aVar.nmd.put("startTime", "LONG default '0' ");
        stringBuilder.append(" startTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "endTime";
        aVar.nmd.put("endTime", "LONG default '0' ");
        stringBuilder.append(" endTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "nickName";
        aVar.nmd.put("nickName", "TEXT default '' ");
        stringBuilder.append(" nickName TEXT default '' ");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
