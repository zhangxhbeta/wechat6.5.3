package com.tencent.mm.plugin.aa.a.b;

import java.lang.reflect.Field;

public final class a extends com.tencent.mm.e.b.a {
    public static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "payMsgId";
        aVar.nmd.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "payMsgId";
        aVar.bXK[1] = "insertmsg";
        aVar.nmd.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "chatroom";
        aVar.nmd.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "msgId";
        aVar.nmd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
