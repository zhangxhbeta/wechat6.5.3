package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.ap;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class o extends ap {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[7];
        aVar.bXK = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "prodcutID";
        aVar.nmd.put("prodcutID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "prodcutID";
        aVar.bXK[1] = "totalCount";
        aVar.nmd.put("totalCount", "INTEGER");
        stringBuilder.append(" totalCount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "continuCount";
        aVar.nmd.put("continuCount", "INTEGER");
        stringBuilder.append(" continuCount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "flag";
        aVar.nmd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "modifyTime";
        aVar.nmd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = "showTipsTime";
        aVar.nmd.put("showTipsTime", "LONG");
        stringBuilder.append(" showTipsTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[6] = "setFlagTime";
        aVar.nmd.put("setFlagTime", "LONG");
        stringBuilder.append(" setFlagTime LONG");
        aVar.bXK[7] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return null;
    }
}
