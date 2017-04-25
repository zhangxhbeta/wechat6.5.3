package com.tencent.mm.plugin.game.c;

import com.tencent.mm.e.b.bd;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class k extends bd {
    protected static a chq;

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
        aVar.nmd.put(Columns.VALUE, "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
