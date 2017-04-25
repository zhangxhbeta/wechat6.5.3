package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.e.b.h;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class d extends h {
    public static final a cxi;

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "key";
        aVar.nmd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "key";
        aVar.bXK[1] = Columns.VALUE;
        aVar.nmd.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        cxi = aVar;
    }

    protected final a tl() {
        return cxi;
    }
}
