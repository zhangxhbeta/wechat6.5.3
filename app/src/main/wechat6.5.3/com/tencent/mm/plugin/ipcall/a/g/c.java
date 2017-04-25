package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.bp;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class c extends bp {
    public static a chq;
    public ArrayList<String> gIB;

    static {
        a aVar = new a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "wechatUsername";
        aVar.nmd.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "systemAddressBookUsername";
        aVar.nmd.put("systemAddressBookUsername", "TEXT");
        stringBuilder.append(" systemAddressBookUsername TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "contactId";
        aVar.nmd.put("contactId", "TEXT");
        stringBuilder.append(" contactId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "sortKey";
        aVar.nmd.put("sortKey", "TEXT");
        stringBuilder.append(" sortKey TEXT");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
