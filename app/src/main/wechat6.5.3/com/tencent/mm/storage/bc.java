package com.tencent.mm.storage;

import com.tencent.mm.e.b.cx;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class bc extends cx {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "openId";
        aVar.nmd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "openId";
        aVar.bXK[1] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "username";
        aVar.nmd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public bc(String str, String str2, String str3) {
        this.field_appId = str;
        this.field_username = str2;
        this.field_openId = str3;
    }
}
