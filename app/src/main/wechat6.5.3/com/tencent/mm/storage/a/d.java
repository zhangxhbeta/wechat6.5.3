package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.ak;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class d extends ak {
    protected static a chq;

    protected final a tl() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.ddU = new Field[7];
        aVar.bXK = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "md5_lang";
        aVar.nmd.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.nmc = "md5_lang";
        aVar.bXK[1] = "md5";
        aVar.nmd.put("md5", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "lang";
        aVar.nmd.put("lang", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" lang TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "desc";
        aVar.nmd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "groupId";
        aVar.nmd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "click_flag";
        aVar.nmd.put("click_flag", "INTEGER");
        stringBuilder.append(" click_flag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "download_flag";
        aVar.nmd.put("download_flag", "INTEGER");
        stringBuilder.append(" download_flag INTEGER");
        aVar.bXK[7] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    public final String EB() {
        return this.field_md5 == null ? "" : this.field_md5;
    }
}
