package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.de;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class u extends de {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "pref_key";
        aVar.nmd.put("pref_key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pref_key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "pref_key";
        aVar.bXK[1] = "pref_title";
        aVar.nmd.put("pref_title", "TEXT");
        stringBuilder.append(" pref_title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "pref_url";
        aVar.nmd.put("pref_url", "TEXT");
        stringBuilder.append(" pref_url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "is_show";
        aVar.nmd.put("is_show", "INTEGER default '1' ");
        stringBuilder.append(" is_show INTEGER default '1' ");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
