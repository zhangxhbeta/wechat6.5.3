package com.tencent.mm.plugin.webview.e;

import com.tencent.mm.e.b.dj;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class g extends dj {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "host";
        aVar.nmd.put("host", "TEXT");
        stringBuilder.append(" host TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "expireTime";
        aVar.nmd.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
