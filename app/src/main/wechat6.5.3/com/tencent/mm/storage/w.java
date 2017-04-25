package com.tencent.mm.storage;

import com.tencent.mm.e.b.ad;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class w extends ad {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[6];
        aVar.bXK = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "labelID";
        aVar.nmd.put("labelID", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" labelID INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "labelID";
        aVar.bXK[1] = "labelName";
        aVar.nmd.put("labelName", "TEXT");
        stringBuilder.append(" labelName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "labelPYFull";
        aVar.nmd.put("labelPYFull", "TEXT");
        stringBuilder.append(" labelPYFull TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "labelPYShort";
        aVar.nmd.put("labelPYShort", "TEXT");
        stringBuilder.append(" labelPYShort TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "createTime";
        aVar.nmd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = "isTemporary";
        aVar.nmd.put("isTemporary", "INTEGER");
        stringBuilder.append(" isTemporary INTEGER");
        aVar.bXK[6] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
