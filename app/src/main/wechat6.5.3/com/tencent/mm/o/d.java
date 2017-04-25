package com.tencent.mm.o;

import com.tencent.mm.e.b.bc;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class d extends bc {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[14];
        aVar.bXK = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "cgi";
        aVar.nmd.put("cgi", "TEXT");
        stringBuilder.append(" cgi TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "cmdid";
        aVar.nmd.put("cmdid", "INTEGER");
        stringBuilder.append(" cmdid INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "functionmsgid";
        aVar.nmd.put("functionmsgid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "functionmsgid";
        aVar.bXK[3] = "version";
        aVar.nmd.put("version", "LONG");
        stringBuilder.append(" version LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = "preVersion";
        aVar.nmd.put("preVersion", "LONG");
        stringBuilder.append(" preVersion LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = "retryinterval";
        aVar.nmd.put("retryinterval", "INTEGER");
        stringBuilder.append(" retryinterval INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "reportid";
        aVar.nmd.put("reportid", "INTEGER");
        stringBuilder.append(" reportid INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "successkey";
        aVar.nmd.put("successkey", "INTEGER");
        stringBuilder.append(" successkey INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "failkey";
        aVar.nmd.put("failkey", "INTEGER");
        stringBuilder.append(" failkey INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "finalfailkey";
        aVar.nmd.put("finalfailkey", "INTEGER");
        stringBuilder.append(" finalfailkey INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "custombuff";
        aVar.nmd.put("custombuff", "TEXT");
        stringBuilder.append(" custombuff TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "addMsg";
        aVar.nmd.put("addMsg", "BLOB");
        stringBuilder.append(" addMsg BLOB");
        stringBuilder.append(", ");
        aVar.bXK[12] = "status";
        aVar.nmd.put("status", "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[13] = "needShow";
        aVar.nmd.put("needShow", "INTEGER default 'false' ");
        stringBuilder.append(" needShow INTEGER default 'false' ");
        aVar.bXK[14] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final void b(bm bmVar) {
        if (bmVar != null) {
            this.field_addMsg = bmVar;
        }
    }
}
