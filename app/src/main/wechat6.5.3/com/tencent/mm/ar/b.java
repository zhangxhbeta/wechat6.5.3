package com.tencent.mm.ar;

import com.tencent.mm.e.b.aq;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class b extends aq {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[17];
        aVar.bXK = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "talker";
        aVar.nmd.put("talker", "TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "talker";
        aVar.bXK[1] = "encryptTalker";
        aVar.nmd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "displayName";
        aVar.nmd.put("displayName", "TEXT default '' ");
        stringBuilder.append(" displayName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "state";
        aVar.nmd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "lastModifiedTime";
        aVar.nmd.put("lastModifiedTime", "LONG default '0' ");
        stringBuilder.append(" lastModifiedTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "isNew";
        aVar.nmd.put("isNew", "INTEGER default '0' ");
        stringBuilder.append(" isNew INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "addScene";
        aVar.nmd.put("addScene", "INTEGER default '0' ");
        stringBuilder.append(" addScene INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "fmsgSysRowId";
        aVar.nmd.put("fmsgSysRowId", "LONG default '0' ");
        stringBuilder.append(" fmsgSysRowId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "fmsgIsSend";
        aVar.nmd.put("fmsgIsSend", "INTEGER default '0' ");
        stringBuilder.append(" fmsgIsSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "fmsgType";
        aVar.nmd.put("fmsgType", "INTEGER default '0' ");
        stringBuilder.append(" fmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "fmsgContent";
        aVar.nmd.put("fmsgContent", "TEXT default '' ");
        stringBuilder.append(" fmsgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "recvFmsgType";
        aVar.nmd.put("recvFmsgType", "INTEGER default '0' ");
        stringBuilder.append(" recvFmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "contentFromUsername";
        aVar.nmd.put("contentFromUsername", "TEXT default '' ");
        stringBuilder.append(" contentFromUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[13] = "contentNickname";
        aVar.nmd.put("contentNickname", "TEXT default '' ");
        stringBuilder.append(" contentNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[14] = "contentPhoneNumMD5";
        aVar.nmd.put("contentPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "contentFullPhoneNumMD5";
        aVar.nmd.put("contentFullPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[16] = "contentVerifyContent";
        aVar.nmd.put("contentVerifyContent", "TEXT default '' ");
        stringBuilder.append(" contentVerifyContent TEXT default '' ");
        aVar.bXK[17] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
