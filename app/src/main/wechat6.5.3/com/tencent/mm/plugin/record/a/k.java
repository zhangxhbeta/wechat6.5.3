package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.b.cf;
import com.tencent.mm.plugin.record.a.f.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class k extends cf implements a {
    protected static c.a chq;

    static {
        c.a aVar = new c.a();
        aVar.ddU = new Field[10];
        aVar.bXK = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "localId";
        aVar.nmd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "localId";
        aVar.bXK[1] = "msgId";
        aVar.nmd.put("msgId", "LONG default '-1' ");
        stringBuilder.append(" msgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "oriMsgId";
        aVar.nmd.put("oriMsgId", "LONG default '-1' ");
        stringBuilder.append(" oriMsgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "toUser";
        aVar.nmd.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "title";
        aVar.nmd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "desc";
        aVar.nmd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "dataProto";
        aVar.nmd.put("dataProto", "BLOB");
        stringBuilder.append(" dataProto BLOB");
        stringBuilder.append(", ");
        aVar.bXK[7] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = DownloadInfo.STATUS;
        aVar.nmd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "favFrom";
        aVar.nmd.put("favFrom", "TEXT");
        stringBuilder.append(" favFrom TEXT");
        aVar.bXK[10] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final c.a tl() {
        return chq;
    }

    public final int aJB() {
        return this.field_localId;
    }
}
