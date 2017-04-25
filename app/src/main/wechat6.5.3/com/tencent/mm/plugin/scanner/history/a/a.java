package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.mm.e.b.ci;
import java.lang.reflect.Field;

public final class a extends ci {
    protected static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[6];
        aVar.bXK = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "productId";
        aVar.nmd.put("productId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "productId";
        aVar.bXK[1] = "xmlContent";
        aVar.nmd.put("xmlContent", "TEXT");
        stringBuilder.append(" xmlContent TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "ScanTime";
        aVar.nmd.put("ScanTime", "LONG");
        stringBuilder.append(" ScanTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[3] = "funcType";
        aVar.nmd.put("funcType", "INTEGER");
        stringBuilder.append(" funcType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "qrcodeUrl";
        aVar.nmd.put("qrcodeUrl", "TEXT");
        stringBuilder.append(" qrcodeUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "scene";
        aVar.nmd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        aVar.bXK[6] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
