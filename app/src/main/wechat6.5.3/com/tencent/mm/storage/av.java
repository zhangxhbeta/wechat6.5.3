package com.tencent.mm.storage;

import com.tencent.mm.e.b.cb;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class av extends cb {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[6];
        aVar.bXK = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appId";
        aVar.nmd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "appId";
        aVar.bXK[1] = "packageName";
        aVar.nmd.put("packageName", "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "status";
        aVar.nmd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "sceneFlag";
        aVar.nmd.put("sceneFlag", "INTEGER default '0' ");
        stringBuilder.append(" sceneFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "msgTypeFlag";
        aVar.nmd.put("msgTypeFlag", "INTEGER default '0' ");
        stringBuilder.append(" msgTypeFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "msgState";
        aVar.nmd.put("msgState", "INTEGER default '0' ");
        stringBuilder.append(" msgState INTEGER default '0' ");
        aVar.bXK[6] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
