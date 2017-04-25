package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.e.b.cy;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class g extends cy {
    protected static a chq;
    int bkU = -1;

    static {
        a aVar = new a();
        aVar.ddU = new Field[17];
        aVar.bXK = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "filename";
        aVar.nmd.put("filename", "TEXT");
        stringBuilder.append(" filename TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "user";
        aVar.nmd.put("user", "TEXT");
        stringBuilder.append(" user TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "msgid";
        aVar.nmd.put("msgid", "LONG");
        stringBuilder.append(" msgid LONG");
        stringBuilder.append(", ");
        aVar.bXK[3] = "offset";
        aVar.nmd.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "filenowsize";
        aVar.nmd.put("filenowsize", "INTEGER");
        stringBuilder.append(" filenowsize INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "totallen";
        aVar.nmd.put("totallen", "INTEGER");
        stringBuilder.append(" totallen INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "status";
        aVar.nmd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "createtime";
        aVar.nmd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.bXK[8] = "lastmodifytime";
        aVar.nmd.put("lastmodifytime", "LONG");
        stringBuilder.append(" lastmodifytime LONG");
        stringBuilder.append(", ");
        aVar.bXK[9] = "clientid";
        aVar.nmd.put("clientid", "TEXT");
        stringBuilder.append(" clientid TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "voicelenght";
        aVar.nmd.put("voicelenght", "INTEGER");
        stringBuilder.append(" voicelenght INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[11] = "msglocalid";
        aVar.nmd.put("msglocalid", "INTEGER");
        stringBuilder.append(" msglocalid INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[12] = "human";
        aVar.nmd.put("human", "TEXT");
        stringBuilder.append(" human TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "voiceformat";
        aVar.nmd.put("voiceformat", "INTEGER");
        stringBuilder.append(" voiceformat INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[14] = "nettimes";
        aVar.nmd.put("nettimes", "INTEGER");
        stringBuilder.append(" nettimes INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[15] = "reserved1";
        aVar.nmd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[16] = "reserved2";
        aVar.nmd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        aVar.bXK[17] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean LD() {
        if ((this.field_status <= 1 || this.field_status > 3) && this.field_status != 8) {
            return false;
        }
        return true;
    }
}
