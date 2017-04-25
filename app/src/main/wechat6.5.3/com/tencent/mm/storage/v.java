package com.tencent.mm.storage;

import com.tencent.mm.e.b.ac;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class v extends ac {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "username";
        aVar.nmd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "username";
        aVar.bXK[1] = "cmdbuf";
        aVar.nmd.put("cmdbuf", "BLOB default '' ");
        stringBuilder.append(" cmdbuf BLOB default '' ");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
