package com.tencent.mm.modelbiz;

import com.tencent.mm.e.b.y;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class f extends y {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[6];
        aVar.bXK = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "openId";
        aVar.nmd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "openId";
        aVar.bXK[1] = "brandUsername";
        aVar.nmd.put("brandUsername", "TEXT default '' ");
        stringBuilder.append(" brandUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "headImgUrl";
        aVar.nmd.put("headImgUrl", "TEXT");
        stringBuilder.append(" headImgUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "nickname";
        aVar.nmd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "kfType";
        aVar.nmd.put("kfType", "INTEGER");
        stringBuilder.append(" kfType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "updateTime";
        aVar.nmd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.bXK[6] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public f(String str, String str2, String str3, String str4, int i, long j) {
        this.field_openId = str;
        this.field_brandUsername = str2;
        this.field_headImgUrl = str3;
        this.field_nickname = str4;
        this.field_kfType = i;
        this.field_updateTime = j;
    }
}
