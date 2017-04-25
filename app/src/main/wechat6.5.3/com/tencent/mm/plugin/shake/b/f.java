package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.plugin.shake.a.a.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class f extends a {
    protected static c.a chq;

    static {
        c.a aVar = new c.a();
        aVar.ddU = new Field[13];
        aVar.bXK = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "svrid";
        aVar.nmd.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "svrid";
        aVar.bXK[1] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "subtype";
        aVar.nmd.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "createtime";
        aVar.nmd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = "tag";
        aVar.nmd.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = DownloadInfo.STATUS;
        aVar.nmd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "title";
        aVar.nmd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "desc";
        aVar.nmd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "thumburl";
        aVar.nmd.put("thumburl", "TEXT");
        stringBuilder.append(" thumburl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "reserved1";
        aVar.nmd.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "reserved2";
        aVar.nmd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "reserved3";
        aVar.nmd.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[12] = "reservedBuf";
        aVar.nmd.put("reservedBuf", "BLOB");
        stringBuilder.append(" reservedBuf BLOB");
        aVar.bXK[13] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final c.a tl() {
        return chq;
    }
}
