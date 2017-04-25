package com.tencent.mm.j;

import com.tencent.mm.e.b.af;
import java.lang.reflect.Field;

public class a extends af {
    public static com.tencent.mm.sdk.h.c.a chq;
    public static final String cht = null;

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[25];
        aVar.bXK = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgCount";
        aVar.nmd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[1] = "username";
        aVar.nmd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "username";
        aVar.bXK[2] = "unReadCount";
        aVar.nmd.put("unReadCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "chatmode";
        aVar.nmd.put("chatmode", "INTEGER default '0' ");
        stringBuilder.append(" chatmode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "status";
        aVar.nmd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "isSend";
        aVar.nmd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "conversationTime";
        aVar.nmd.put("conversationTime", "LONG default '0' ");
        stringBuilder.append(" conversationTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "content";
        aVar.nmd.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "msgType";
        aVar.nmd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "customNotify";
        aVar.nmd.put("customNotify", "TEXT default '' ");
        stringBuilder.append(" customNotify TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "showTips";
        aVar.nmd.put("showTips", "INTEGER default '0' ");
        stringBuilder.append(" showTips INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "flag";
        aVar.nmd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "digest";
        aVar.nmd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[13] = "digestUser";
        aVar.nmd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[14] = "hasTrunc";
        aVar.nmd.put("hasTrunc", "INTEGER default '0' ");
        stringBuilder.append(" hasTrunc INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "parentRef";
        aVar.nmd.put("parentRef", "TEXT");
        stringBuilder.append(" parentRef TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "attrflag";
        aVar.nmd.put("attrflag", "INTEGER default '0' ");
        stringBuilder.append(" attrflag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[17] = "editingMsg";
        aVar.nmd.put("editingMsg", "TEXT default '' ");
        stringBuilder.append(" editingMsg TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[18] = "atCount";
        aVar.nmd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[19] = "sightTime";
        aVar.nmd.put("sightTime", "LONG default '0' ");
        stringBuilder.append(" sightTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[20] = "unReadMuteCount";
        aVar.nmd.put("unReadMuteCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadMuteCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[21] = "lastSeq";
        aVar.nmd.put("lastSeq", "LONG");
        stringBuilder.append(" lastSeq LONG");
        stringBuilder.append(", ");
        aVar.bXK[22] = "UnDeliverCount";
        aVar.nmd.put("UnDeliverCount", "INTEGER");
        stringBuilder.append(" UnDeliverCount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[23] = "UnReadInvite";
        aVar.nmd.put("UnReadInvite", "INTEGER");
        stringBuilder.append(" UnReadInvite INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[24] = "firstUnDeliverSeq";
        aVar.nmd.put("firstUnDeliverSeq", "LONG");
        stringBuilder.append(" firstUnDeliverSeq LONG");
        aVar.bXK[25] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public a(String str) {
        setUsername(str);
    }

    public final void ek(int i) {
        dk(this.field_attrflag | i);
    }

    public final boolean el(int i) {
        return (this.field_attrflag & i) != 0;
    }
}
