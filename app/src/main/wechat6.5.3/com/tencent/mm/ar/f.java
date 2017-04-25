package com.tencent.mm.ar;

import com.tencent.mm.e.b.ar;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class f extends ar {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[8];
        aVar.bXK = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgContent";
        aVar.nmd.put("msgContent", "TEXT default '' ");
        stringBuilder.append(" msgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[1] = "isSend";
        aVar.nmd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "talker";
        aVar.nmd.put("talker", "TEXT default '' ");
        stringBuilder.append(" talker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "encryptTalker";
        aVar.nmd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "svrId";
        aVar.nmd.put("svrId", "LONG default '0' ");
        stringBuilder.append(" svrId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "type";
        aVar.nmd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "createTime";
        aVar.nmd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "chatroomName";
        aVar.nmd.put("chatroomName", "TEXT default '' ");
        stringBuilder.append(" chatroomName TEXT default '' ");
        aVar.bXK[8] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean Ku() {
        return this.field_isSend % 2 == 0;
    }
}
