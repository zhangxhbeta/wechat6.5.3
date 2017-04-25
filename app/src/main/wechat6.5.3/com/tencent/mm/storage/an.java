package com.tencent.mm.storage;

import com.tencent.mm.e.b.bh;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class an extends bh {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[13];
        aVar.bXK = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "originSvrId";
        aVar.nmd.put("originSvrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" originSvrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "originSvrId";
        aVar.bXK[1] = "newMsgId";
        aVar.nmd.put("newMsgId", "LONG");
        stringBuilder.append(" newMsgId LONG");
        stringBuilder.append(", ");
        aVar.bXK[2] = "fromUserName";
        aVar.nmd.put("fromUserName", "TEXT default '' ");
        stringBuilder.append(" fromUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "toUserName";
        aVar.nmd.put("toUserName", "TEXT default '' ");
        stringBuilder.append(" toUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "createTime";
        aVar.nmd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "content";
        aVar.nmd.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "msgSource";
        aVar.nmd.put("msgSource", "TEXT default '' ");
        stringBuilder.append(" msgSource TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "msgSeq";
        aVar.nmd.put("msgSeq", "INTEGER");
        stringBuilder.append(" msgSeq INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "flag";
        aVar.nmd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "reserved1";
        aVar.nmd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "reserved2";
        aVar.nmd.put("reserved2", "LONG");
        stringBuilder.append(" reserved2 LONG");
        stringBuilder.append(", ");
        aVar.bXK[11] = "reserved3";
        aVar.nmd.put("reserved3", "TEXT default '' ");
        stringBuilder.append(" reserved3 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "reserved4";
        aVar.nmd.put("reserved4", "TEXT default '' ");
        stringBuilder.append(" reserved4 TEXT default '' ");
        aVar.bXK[13] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
