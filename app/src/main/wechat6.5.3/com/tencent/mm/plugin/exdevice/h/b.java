package com.tencent.mm.plugin.exdevice.h;

import com.tencent.mm.e.b.bk;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class b extends bk {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[14];
        aVar.bXK = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "deviceID";
        aVar.nmd.put("deviceID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" deviceID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "deviceID";
        aVar.bXK[1] = "brandName";
        aVar.nmd.put("brandName", "TEXT");
        stringBuilder.append(" brandName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "mac";
        aVar.nmd.put("mac", "LONG");
        stringBuilder.append(" mac LONG");
        stringBuilder.append(", ");
        aVar.bXK[3] = "deviceType";
        aVar.nmd.put("deviceType", "TEXT");
        stringBuilder.append(" deviceType TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "connProto";
        aVar.nmd.put("connProto", "TEXT");
        stringBuilder.append(" connProto TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "connStrategy";
        aVar.nmd.put("connStrategy", "INTEGER");
        stringBuilder.append(" connStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "closeStrategy";
        aVar.nmd.put("closeStrategy", "INTEGER");
        stringBuilder.append(" closeStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "md5Str";
        aVar.nmd.put("md5Str", "TEXT");
        stringBuilder.append(" md5Str TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "authKey";
        aVar.nmd.put("authKey", "TEXT");
        stringBuilder.append(" authKey TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "url";
        aVar.nmd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "sessionKey";
        aVar.nmd.put("sessionKey", "BLOB");
        stringBuilder.append(" sessionKey BLOB");
        stringBuilder.append(", ");
        aVar.bXK[11] = "sessionBuf";
        aVar.nmd.put("sessionBuf", "BLOB");
        stringBuilder.append(" sessionBuf BLOB");
        stringBuilder.append(", ");
        aVar.bXK[12] = "authBuf";
        aVar.nmd.put("authBuf", "BLOB");
        stringBuilder.append(" authBuf BLOB");
        stringBuilder.append(", ");
        aVar.bXK[13] = "lvbuffer";
        aVar.nmd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        aVar.bXK[14] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
