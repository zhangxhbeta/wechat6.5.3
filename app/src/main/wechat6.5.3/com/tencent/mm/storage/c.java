package com.tencent.mm.storage;

import com.tencent.mm.e.b.d;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c extends d {
    protected static a chq;
    private Map<String, String> nnQ = null;

    static {
        a aVar = new a();
        aVar.ddU = new Field[9];
        aVar.bXK = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "layerId";
        aVar.nmd.put("layerId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" layerId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "layerId";
        aVar.bXK[1] = "business";
        aVar.nmd.put("business", "TEXT");
        stringBuilder.append(" business TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "expId";
        aVar.nmd.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "sequence";
        aVar.nmd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = "prioritylevel";
        aVar.nmd.put("prioritylevel", "INTEGER default '0' ");
        stringBuilder.append(" prioritylevel INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "startTime";
        aVar.nmd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[6] = "endTime";
        aVar.nmd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[7] = "needReport";
        aVar.nmd.put("needReport", "INTEGER");
        stringBuilder.append(" needReport INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "rawXML";
        aVar.nmd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        aVar.bXK[9] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean isValid() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > this.field_startTime && currentTimeMillis < this.field_endTime;
    }

    public final Map<String, String> buX() {
        if (this.nnQ == null) {
            this.nnQ = com.tencent.mm.model.c.a.gj(this.field_rawXML);
        }
        return this.nnQ;
    }
}
