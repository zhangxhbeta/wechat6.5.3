package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.e.b.dl;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class ad extends dl {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "recordId";
        aVar.nmd.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "recordId";
        aVar.bXK[1] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "domin";
        aVar.nmd.put("domin", "TEXT");
        stringBuilder.append(" domin TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "key";
        aVar.nmd.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = Columns.VALUE;
        aVar.nmd.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
