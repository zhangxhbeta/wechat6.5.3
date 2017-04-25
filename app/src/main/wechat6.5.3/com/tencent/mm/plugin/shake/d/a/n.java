package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.shake.a.a.b;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class n extends b {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "username";
        aVar.nmd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "username";
        aVar.bXK[1] = "deeplink";
        aVar.nmd.put("deeplink", "TEXT default '' ");
        stringBuilder.append(" deeplink TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "title";
        aVar.nmd.put("title", "TEXT default '' ");
        stringBuilder.append(" title TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "iconurl";
        aVar.nmd.put("iconurl", "TEXT default '' ");
        stringBuilder.append(" iconurl TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "createtime";
        aVar.nmd.put("createtime", "LONG default '' ");
        stringBuilder.append(" createtime LONG default '' ");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
