package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.bs;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class k extends bs {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[6];
        aVar.bXK = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "phonenumber";
        aVar.nmd.put("phonenumber", "TEXT");
        stringBuilder.append(" phonenumber TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "calltime";
        aVar.nmd.put("calltime", "LONG");
        stringBuilder.append(" calltime LONG");
        stringBuilder.append(", ");
        aVar.bXK[2] = "duration";
        aVar.nmd.put("duration", "LONG");
        stringBuilder.append(" duration LONG");
        stringBuilder.append(", ");
        aVar.bXK[3] = DownloadInfo.STATUS;
        aVar.nmd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "addressId";
        aVar.nmd.put("addressId", "LONG default '-1' ");
        stringBuilder.append(" addressId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "phoneType";
        aVar.nmd.put("phoneType", "INTEGER default '-1' ");
        stringBuilder.append(" phoneType INTEGER default '-1' ");
        aVar.bXK[6] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
