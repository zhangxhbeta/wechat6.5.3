package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.al;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class g extends al {
    protected static a chq;

    public g(String str, String str2) {
        this.field_groupID = str;
        this.field_desc = str2;
    }

    protected final a tl() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "groupID";
        aVar.nmd.put("groupID", "TEXT");
        stringBuilder.append(" groupID TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "desc";
        aVar.nmd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }
}
