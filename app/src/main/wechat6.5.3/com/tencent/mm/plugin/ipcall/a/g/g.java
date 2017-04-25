package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.bq;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class g extends bq {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[7];
        aVar.bXK = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "svrId";
        aVar.nmd.put("svrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" svrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "svrId";
        aVar.bXK[1] = "isRead";
        aVar.nmd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "title";
        aVar.nmd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "content";
        aVar.nmd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "pushTime";
        aVar.nmd.put("pushTime", "LONG");
        stringBuilder.append(" pushTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = "msgType";
        aVar.nmd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "descUrl";
        aVar.nmd.put("descUrl", "TEXT");
        stringBuilder.append(" descUrl TEXT");
        aVar.bXK[7] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
