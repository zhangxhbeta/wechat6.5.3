package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.cq;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class g extends cq {
    protected static a chq;
    public int jBM;

    static {
        a aVar = new a();
        aVar.ddU = new Field[12];
        aVar.bXK = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "snsID";
        aVar.nmd.put("snsID", "LONG");
        stringBuilder.append(" snsID LONG");
        stringBuilder.append(", ");
        aVar.bXK[1] = "parentID";
        aVar.nmd.put("parentID", "LONG");
        stringBuilder.append(" parentID LONG");
        stringBuilder.append(", ");
        aVar.bXK[2] = "isRead";
        aVar.nmd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "createTime";
        aVar.nmd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "talker";
        aVar.nmd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "isSend";
        aVar.nmd.put("isSend", "INTEGER default 'false' ");
        stringBuilder.append(" isSend INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "curActionBuf";
        aVar.nmd.put("curActionBuf", "BLOB");
        stringBuilder.append(" curActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.bXK[8] = "refActionBuf";
        aVar.nmd.put("refActionBuf", "BLOB");
        stringBuilder.append(" refActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.bXK[9] = "commentSvrID";
        aVar.nmd.put("commentSvrID", "LONG");
        stringBuilder.append(" commentSvrID LONG");
        stringBuilder.append(", ");
        aVar.bXK[10] = ClientInfoTable.Columns.CLIENTID;
        aVar.nmd.put(ClientInfoTable.Columns.CLIENTID, "TEXT");
        stringBuilder.append(" clientId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "commentflag";
        aVar.nmd.put("commentflag", "INTEGER");
        stringBuilder.append(" commentflag INTEGER");
        aVar.bXK[12] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.jBM = (int) this.nmb;
        } catch (Exception e) {
            String message = e.getMessage();
            v.e("MicroMsg.SnsComment", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ad.aSH().aUw();
            }
            throw e;
        } catch (Throwable e2) {
            v.a("MicroMsg.SnsComment", e2, "", new Object[0]);
        }
    }

    public final void aUs() {
        this.field_commentflag |= 1;
    }
}
