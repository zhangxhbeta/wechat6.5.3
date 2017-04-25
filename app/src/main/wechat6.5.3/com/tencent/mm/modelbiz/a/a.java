package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.s;
import java.lang.reflect.Field;

public final class a extends s {
    protected static com.tencent.mm.sdk.h.c.a chq;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[17];
        aVar.bXK = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "bizChatId";
        aVar.nmd.put("bizChatId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "bizChatId";
        aVar.bXK[1] = "brandUserName";
        aVar.nmd.put("brandUserName", "TEXT");
        stringBuilder.append(" brandUserName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "unReadCount";
        aVar.nmd.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "newUnReadCount";
        aVar.nmd.put("newUnReadCount", "INTEGER");
        stringBuilder.append(" newUnReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "lastMsgID";
        aVar.nmd.put("lastMsgID", "LONG");
        stringBuilder.append(" lastMsgID LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = "lastMsgTime";
        aVar.nmd.put("lastMsgTime", "LONG");
        stringBuilder.append(" lastMsgTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[6] = "content";
        aVar.nmd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "digest";
        aVar.nmd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "digestUser";
        aVar.nmd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "atCount";
        aVar.nmd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "editingMsg";
        aVar.nmd.put("editingMsg", "TEXT");
        stringBuilder.append(" editingMsg TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "chatType";
        aVar.nmd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[12] = "status";
        aVar.nmd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[13] = "isSend";
        aVar.nmd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[14] = "msgType";
        aVar.nmd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "msgCount";
        aVar.nmd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[16] = "flag";
        aVar.nmd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        aVar.bXK[17] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
