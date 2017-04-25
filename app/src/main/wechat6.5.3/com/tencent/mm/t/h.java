package com.tencent.mm.t;

import com.tencent.mm.e.b.l;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class h extends l {
    public static final a cxi;

    static {
        a aVar = new a();
        aVar.ddU = new Field[16];
        aVar.bXK = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appIdHashCode";
        aVar.nmd.put("appIdHashCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHashCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "appIdHashCode";
        aVar.bXK[1] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "appIcon";
        aVar.nmd.put("appIcon", "TEXT");
        stringBuilder.append(" appIcon TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "appName";
        aVar.nmd.put("appName", "TEXT");
        stringBuilder.append(" appName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "BigHeadImgUrl";
        aVar.nmd.put("BigHeadImgUrl", "TEXT");
        stringBuilder.append(" BigHeadImgUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "appInfo";
        aVar.nmd.put("appInfo", "BLOB");
        stringBuilder.append(" appInfo BLOB");
        stringBuilder.append(", ");
        aVar.bXK[6] = "versionInfo";
        aVar.nmd.put("versionInfo", "BLOB");
        stringBuilder.append(" versionInfo BLOB");
        stringBuilder.append(", ");
        aVar.bXK[7] = "bindInfo";
        aVar.nmd.put("bindInfo", "BLOB");
        stringBuilder.append(" bindInfo BLOB");
        stringBuilder.append(", ");
        aVar.bXK[8] = "brandId";
        aVar.nmd.put("brandId", "TEXT");
        stringBuilder.append(" brandId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "brandFlag";
        aVar.nmd.put("brandFlag", "INTEGER default '0' ");
        stringBuilder.append(" brandFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "signature";
        aVar.nmd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "AppOpt";
        aVar.nmd.put("AppOpt", "INTEGER default '0' ");
        stringBuilder.append(" AppOpt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "syncAttrVersion";
        aVar.nmd.put("syncAttrVersion", "TEXT");
        stringBuilder.append(" syncAttrVersion TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "lastSyncAttrTimeInSecond";
        aVar.nmd.put("lastSyncAttrTimeInSecond", "LONG default '0' ");
        stringBuilder.append(" lastSyncAttrTimeInSecond LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[14] = "debugEnabled";
        aVar.nmd.put("debugEnabled", "INTEGER default 'false' ");
        stringBuilder.append(" debugEnabled INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "roundedSquareIcon";
        aVar.nmd.put("roundedSquareIcon", "TEXT");
        stringBuilder.append(" roundedSquareIcon TEXT");
        aVar.bXK[16] = "rowid";
        aVar.nme = stringBuilder.toString();
        cxi = aVar;
    }

    protected final a tl() {
        return cxi;
    }
}
