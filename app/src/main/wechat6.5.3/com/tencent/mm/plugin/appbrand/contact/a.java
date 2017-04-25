package com.tencent.mm.plugin.appbrand.contact;

import com.tencent.mm.e.b.dm;
import java.lang.reflect.Field;

public final class a extends dm {
    static final com.tencent.mm.sdk.h.c.a cxi;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[9];
        aVar.bXK = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "UserNameHash";
        aVar.nmd.put("UserNameHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" UserNameHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "UserNameHash";
        aVar.bXK[1] = "UserName";
        aVar.nmd.put("UserName", "TEXT");
        stringBuilder.append(" UserName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "NickName";
        aVar.nmd.put("NickName", "TEXT");
        stringBuilder.append(" NickName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "QuanPin";
        aVar.nmd.put("QuanPin", "TEXT");
        stringBuilder.append(" QuanPin TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "BitMask";
        aVar.nmd.put("BitMask", "INTEGER");
        stringBuilder.append(" BitMask INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "BitVal";
        aVar.nmd.put("BitVal", "INTEGER");
        stringBuilder.append(" BitVal INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "Alias";
        aVar.nmd.put("Alias", "TEXT");
        stringBuilder.append(" Alias TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "ExternalInfo";
        aVar.nmd.put("ExternalInfo", "TEXT");
        stringBuilder.append(" ExternalInfo TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "BrandIconURL";
        aVar.nmd.put("BrandIconURL", "TEXT");
        stringBuilder.append(" BrandIconURL TEXT");
        aVar.bXK[9] = "rowid";
        aVar.nme = stringBuilder.toString();
        cxi = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return cxi;
    }
}
