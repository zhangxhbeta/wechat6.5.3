package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.cp;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class u extends cp {
    protected static a chq;

    protected final a tl() {
        return null;
    }

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
        aVar.bXK[1] = "position";
        aVar.nmd.put("position", "INTEGER");
        stringBuilder.append(" position INTEGER");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    public u(int i, String str) {
        this.field_position = i;
        this.field_key = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index:").append(this.field_position);
        stringBuilder.append("key  :").append(this.field_key);
        return stringBuilder.toString();
    }
}
