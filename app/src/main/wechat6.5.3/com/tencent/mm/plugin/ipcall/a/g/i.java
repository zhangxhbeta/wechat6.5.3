package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.br;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class i extends br {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "countryCode";
        aVar.nmd.put("countryCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "countryCode";
        aVar.bXK[1] = "callTimeCount";
        aVar.nmd.put("callTimeCount", "LONG");
        stringBuilder.append(" callTimeCount LONG");
        stringBuilder.append(", ");
        aVar.bXK[2] = "lastCallTime";
        aVar.nmd.put("lastCallTime", "LONG");
        stringBuilder.append(" lastCallTime LONG");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
