package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.e.b.m;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class i extends m {
    static final a cxi;
    public static final String[] dAV = new String[]{"appId", "version", "debugType"};

    static {
        int i = 0;
        a aVar = new a();
        aVar.ddU = new Field[11];
        aVar.bXK = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "version";
        aVar.nmd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "versionMd5";
        aVar.nmd.put("versionMd5", "TEXT");
        stringBuilder.append(" versionMd5 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "versionState";
        aVar.nmd.put("versionState", "INTEGER");
        stringBuilder.append(" versionState INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "pkgPath";
        aVar.nmd.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "createTime";
        aVar.nmd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[6] = "resourceCount";
        aVar.nmd.put("resourceCount", "INTEGER");
        stringBuilder.append(" resourceCount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "debugType";
        aVar.nmd.put("debugType", "INTEGER default '0' ");
        stringBuilder.append(" debugType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "downloadURL";
        aVar.nmd.put("downloadURL", "TEXT");
        stringBuilder.append(" downloadURL TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "startTime";
        aVar.nmd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[10] = "endTime";
        aVar.nmd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        aVar.bXK[11] = "rowid";
        aVar.nme = stringBuilder.toString();
        cxi = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = dAV;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = cxi;
        aVar2.nme = stringBuilder2.append(aVar2.nme).append(",").append(str2).toString();
    }

    protected final a tl() {
        return cxi;
    }
}
