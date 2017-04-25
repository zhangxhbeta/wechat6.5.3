package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.ct;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class m extends ct {
    protected static a chq;
    public int jBI;

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "logtime";
        aVar.nmd.put("logtime", "LONG");
        stringBuilder.append(" logtime LONG");
        stringBuilder.append(", ");
        aVar.bXK[1] = "offset";
        aVar.nmd.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "logsize";
        aVar.nmd.put("logsize", "INTEGER");
        stringBuilder.append(" logsize INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "errorcount";
        aVar.nmd.put("errorcount", "INTEGER");
        stringBuilder.append(" errorcount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = Columns.VALUE;
        aVar.nmd.put(Columns.VALUE, "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.jBI = (int) this.nmb;
        } catch (Exception e) {
            String message = e.getMessage();
            v.e("MicroMsg.SnsKvReport", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ad.aSH().aUw();
            }
            throw e;
        } catch (Throwable e2) {
            v.a("MicroMsg.SnsKvReport", e2, "", new Object[0]);
        }
    }
}
