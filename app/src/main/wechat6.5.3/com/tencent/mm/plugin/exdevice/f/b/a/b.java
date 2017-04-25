package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.bm;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class b extends bm {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appusername";
        aVar.nmd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "title";
        aVar.nmd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "score";
        aVar.nmd.put("score", "INTEGER");
        stringBuilder.append(" score INTEGER");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
